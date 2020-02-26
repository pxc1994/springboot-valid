package com.ppp.demo.exception;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 11:00
 */
public class ParamErrorException extends RuntimeException{


    public ParamErrorException() {
    }

    public ParamErrorException(String message) {
        super(message);
    }
}
