package com.ppp.demo.response;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 11:04
 */
public enum ResultEnum {

    SUCCESS(1000,"请求成功"),
    PARAM_ERROR(1001,"参数错误"),
    UNKNOWN_ERROR(9999,"未知错误");

    private Integer code;

    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
