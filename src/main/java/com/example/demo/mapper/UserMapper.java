package com.example.demo.mapper;

import com.example.demo.entity.UserInfo;

import java.util.List;

public interface UserMapper {
    /**
     * 获取所有用户
     * @return
     */
    List<UserInfo> getAllUser();

    void addUser(UserInfo user);

    void insertUser(UserInfo user);
}
