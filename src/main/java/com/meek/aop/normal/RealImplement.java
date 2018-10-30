package com.meek.aop.normal;

/**
 * 功能描述: 实现类
 */
public class RealImplement implements InterfaceA{

    @Override
    public void exec() {
        System.out.println("real impl");
    }
}
