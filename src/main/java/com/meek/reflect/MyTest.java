package com.meek.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class MyTest {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Point point = new Point();
        BeanInfo beanInfo = Introspector.getBeanInfo(point.getClass(), Object.class);
        PropertyDescriptor[] p = beanInfo.getPropertyDescriptors();
        for(int i=0;i<p.length;i++){
            System.out.println(p[i].getName()+"="+
                    p[i].getReadMethod().invoke(point,(Object[])null));

        }
        PropertyDescriptor pd = new PropertyDescriptor("lon",Point.class);
        Method writeMethod = pd.getWriteMethod();
        writeMethod.invoke(point,135.6819);
        Method readMethod = pd.getReadMethod();
        Object invoke = readMethod.invoke(point, null);
        System.out.println(invoke);
    }

    static class Point{
        private double lon;
        private double lat;
        private String loctime;
        Point(){}
        Point(double lon,double lat){
            this.lat = lat;
            this.lon = lon;
        }
        Point(double lon,double lat,String loctime){
            this.lat = lat;
            this.lon = lon;
            this.loctime = loctime;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getLoctime() {
            return loctime;
        }

        public void setLoctime(String loctime) {
            this.loctime = loctime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.lon, lon) == 0 &&
                    Double.compare(point.lat, lat) == 0 &&
                    Objects.equals(loctime, point.loctime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lon, lat, loctime);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "lon=" + lon +
                    ", lat=" + lat +
                    ", loctime='" + loctime + '\'' +
                    '}';
        }
    }
}
