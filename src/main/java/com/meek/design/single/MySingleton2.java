package com.meek.design.single;

public class MySingleton2 {

    private static MySingleton2 instance = null;
    private MySingleton2(){}

    //静态工厂方法
    public synchronized static MySingleton2 getInstance(){
        if(instance == null){
            instance = new MySingleton2();
        }
        return instance;
    }
}
