package com.meek.ioc.impl;

import com.meek.ioc.MessageService;

public class MessageServiceImpl implements MessageService {


    @Override
    public String getMessage() {
        return "hello ioc";
    }
}
