package com.lin.workitem.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.workitem.mapper.UserMapper;
import com.lin.workitem.model.User;
import com.lin.workitem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> selectAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
