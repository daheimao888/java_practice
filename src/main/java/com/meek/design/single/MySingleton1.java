package com.meek.design.single;

public class MySingleton1 {
    private static MySingleton1 instance = new MySingleton1();
    private MySingleton1(){}

    //静态工厂方法
    public static MySingleton1 getInstance(){
        return instance;
    }

}
