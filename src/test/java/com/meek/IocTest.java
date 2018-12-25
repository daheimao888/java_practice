package com.meek;

import com.meek.ioc.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-xxx.xml");
        System.out.println("context 启动成功");
        MessageService bean = context.getBean(MessageService.class);
        System.out.println(bean.getMessage());
    }  
}
