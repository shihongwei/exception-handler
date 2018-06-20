package com.example.exceptionhandler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptionhandler.common.Result;
import com.example.exceptionhandler.common.ResultUtil;
import com.example.exceptionhandler.model.User;
import com.example.exceptionhandler.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/update")
    public Result update(@RequestParam(name = "name") String name) {
        //throw new ServiceException("测试异常抛出");
        User user = new User();
        user.setName(name);
        userService.updateUser(user);
        return ResultUtil.success();
    }

    @GetMapping("/find")
    public Result find() {

        User user = new User();
        user.setName("simon");

        return ResultUtil.success(user);
    }

}
