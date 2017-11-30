package com.lin.workitem.controller;

import com.lin.workitem.model.User;
import com.lin.workitem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json"})
    public int addUser(User user){
        return userService.add(user);
    }
    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object selectAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        return userService.selectAllUser(pageNum,pageSize);
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "login";
    }
}
