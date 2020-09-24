package com.example.springboot03.api.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liqin
 * @date 2020/9/24 15:31
 */
@ApiModel("用户登录参数")
@Data
public class LoginReqVo {

    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty("用户密码(base64加密后的密码)")
    @NotBlank(message = "用户密码不能为空")
    private String userPwd;

    @ApiModelProperty("验证码")
    @NotBlank(message = "验证码不能为空")
    private String verifyCode;

}
