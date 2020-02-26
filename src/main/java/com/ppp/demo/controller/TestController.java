package com.ppp.demo.controller;

import com.ppp.demo.domain.User;
import com.ppp.demo.exception.ParamErrorException;
import com.ppp.demo.response.ResponseResult;
import com.ppp.demo.response.ResultEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 13:45
 */
@RestController
public class TestController {


    /**
     * get请求一般参数较少 使用正常逻辑判断校验参数
     * @param username
     * @return
     */
    @Validated
    @GetMapping("/user/{username}")
    public ResponseResult findUser(@PathVariable String username){
        if(username ==null || "".equals(username)){
            throw new ParamErrorException("username不能为空");
        }
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    /**
     * post请求校验
     * @param user
     * @return
     */
    @PostMapping("/adduser")
    public ResponseResult addUser(@Valid @RequestBody User user){
        return new ResponseResult(ResultEnum.SUCCESS);
    }
}
