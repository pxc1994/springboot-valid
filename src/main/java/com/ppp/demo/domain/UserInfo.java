package com.ppp.demo.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/2/25 11:16
 */
@Data
public class UserInfo {

    @NotBlank(message = "年龄不能为空")
    @Min(value = 18,message = "18禁")
    private String age;

    @NotBlank(message = "性别不能为空")
    private String gender;


}
