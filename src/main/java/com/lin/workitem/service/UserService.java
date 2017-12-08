package com.lin.workitem.service;

import com.lin.workitem.model.User;

import java.util.List;

public interface UserService {

    int add(User user);

    List<User> selectAllUser(int pageNum, int pageSize);

    User selectByName(User user);
}
