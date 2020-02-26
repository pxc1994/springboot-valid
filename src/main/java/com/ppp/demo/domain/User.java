package com.ppp.demo.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 11:13
 */
@Data
public class User {

    @NotBlank(message = "姓名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Valid //嵌套必须@Valid 否则嵌套中的验证不生效
    @NotNull(message = "userInfo不能为空")
    private UserInfo userInfo;
}
