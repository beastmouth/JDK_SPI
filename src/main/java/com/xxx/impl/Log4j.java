package com.xxx.impl;

import com.xxx.Log;

/**
 * @author hbj
 * @date 2021/1/21 3:18 下午
 */
public class Log4j implements Log {
    @Override
    public void logging(String info) {
        System.out.println("log4j:" + info);
    }
}
