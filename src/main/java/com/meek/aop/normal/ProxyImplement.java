package com.meek.aop.normal;

/**
 * 功能描述:具体代理类
 */
public class ProxyImplement implements InterfaceA{

    private InterfaceA interfaceA;

    public ProxyImplement(){
        interfaceA = new RealImplement() ;
    }

    @Override
    public void exec() {
        System.out.println("dosomethings before");
                //实际调用
        interfaceA.exec();

        System.out.println("dosomethings after");
    }
    public static void main(String[] args){  
        new ProxyImplement().exec();      
    } 
}
