package com.meek.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK 动态代理
 * 从静态代理中可以看出: 静态代理只能代理一个具体的类，如果要代理一个接口的多个实现的话需要定义不同的代理类。
 * 需要解决这个问题就可以用到 JDK 的动态代理。
 * 其中有两个非常核心的类:
 *  java.lang.reflect.Proxy类。
 *  java.lang.reflect.InvocationHandle接口。
 * Proxy 类是用于创建代理对象，而 InvocationHandler 接口主要你是来处理执行逻辑
 */
public class CustomizeHandle implements InvocationHandler {

    private Object target;

    public CustomizeHandle(Class clazz){
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        System.out.println("proxy class=" + proxy.getClass());
        return result;
    }
    private void before() {
        System.out.println("handle before");
    }

    private void after() {
        System.out.println("handle after");
    }

}
