package com.powernode.controller;

import com.powernode.domain.User;
import com.powernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/selectList")
    public List<User> selectList(){
       return userService.selectList();
    }
}
