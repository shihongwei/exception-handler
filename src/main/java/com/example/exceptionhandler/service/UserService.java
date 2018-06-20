package com.example.exceptionhandler.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.exceptionhandler.exception.ServiceException;
import com.example.exceptionhandler.model.User;

@Service
public class UserService {

    public void updateUser(User user) {

        if (user == null) {
            throw new ServiceException("入参不能为null");
        }
        if (StringUtils.isEmpty(user.getName())) {
            throw new ServiceException("用户名不能为空");
        }
        User existUser = findUserByName(user.getName());
        if (existUser == null) {
            throw new ServiceException("用户不存在");
        }
        if ("system".equals(user.getName())) {
            throw new RuntimeException("系统异常信息");
        }
    }

    public User findUserByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("argument is null");
        }
        if ("simon".equals(name)) {
            return new User().setName("simon");
        }

        return null;
    }

}
