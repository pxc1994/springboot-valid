package com.ppp.demo.response;

import lombok.Data;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 11:09
 */
@Data
public class ResponseResult {

    private Integer code;

    private String msg;

    public ResponseResult(){

    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(ResultEnum result) {
        this.code = result.getCode();
        this.msg = result.getMessage();
    }

}
