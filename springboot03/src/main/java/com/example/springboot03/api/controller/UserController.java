package com.example.springboot03.api.controller;

import com.example.springboot03.api.vo.req.LoginReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqin
 * @date 2020/9/24 15:28
 */
@RestController
@Api("用户模块")
public class UserController {

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public String login(@RequestBody LoginReqVo reqVo){

        return "";
    }
}
