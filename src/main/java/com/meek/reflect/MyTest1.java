package com.meek.reflect;


import java.util.Objects;


public class MyTest1 {

    public static String version = "1";

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //包装类型
        Class c1 = Point.class;
        System.out.println("package: " + c1.getPackage());
        System.out.println("name: " + c1.getName());
        System.out.println("outer class: " + c1.getDeclaringClass());
        for (int i = 0; i < c1.getDeclaredConstructors().length; i++) {
            System.out.println("constructor"+i+": " + c1.getDeclaredConstructors()[i].getName());
        }
        for (int i = 0; i < c1.getDeclaredMethods().length; i++) {
            System.out.println("method"+i+": " + c1.getDeclaredMethods()[i].getName());
        }

        for (int i = 0; i < c1.getDeclaredFields().length; i++) {
            System.out.println("field"+i+": " + c1.getDeclaredFields()[i]);
        }


    }
    class Point{
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
