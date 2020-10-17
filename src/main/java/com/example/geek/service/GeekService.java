package com.example.geek.service;

import com.example.geek.entity.GeekUser;
import com.example.geek.model.query.geekUser.GeekUserQuery;
import com.example.geek.model.response.Result;

import java.util.List;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-10-08 23:35
 * @Description
 */
public interface GeekService {


    /**
     * 增
     * @param geekUser
     */
    void addUser(GeekUser geekUser);


    /**
     * 删
     * @param id
     */
    void delUser(int id);


    /**
     * 改
     * @param geekUser
     */
    void updatUser(GeekUser geekUser);


    /**
     * 查单个
     * @param id
     * @return
     */
    GeekUser getUserInfo(int id);

    /**
     * 查列表
     * @param geekUserQuery
     * @return
     */
    Result getUserList(GeekUserQuery geekUserQuery);
}
