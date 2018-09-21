package com.hashirama.demo.mapper;

import com.hashirama.demo.entity.UserInfo;

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
