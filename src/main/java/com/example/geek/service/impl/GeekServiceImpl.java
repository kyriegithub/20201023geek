package com.example.geek.service.impl;

import com.example.geek.entity.GeekUser;
import com.example.geek.entity.GeekUserExample;
import com.example.geek.mapper.GeekUserMapper;
import com.example.geek.model.query.geekUser.GeekUserQuery;
import com.example.geek.model.response.Result;
import com.example.geek.service.GeekService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-10-08 23:36
 * @Description
 */
@Service
@Slf4j
public class GeekServiceImpl implements GeekService {

    @Autowired
    private GeekUserMapper geekUserMapper;

    @Override
    public GeekUser getUserInfo(int id) {
        GeekUser geekUser=geekUserMapper.selectByPrimaryKey(id);
        return geekUser;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public void addUser(GeekUser geekUser) {
        geekUserMapper.insertSelective(geekUser);
    }

    @Override
    public void delUser(int id) {
        geekUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Result getUserList(GeekUserQuery geekUserQuery) {
        Page<Object> page= PageHelper.startPage(geekUserQuery.getPageNo(),geekUserQuery.getPageSize());
        GeekUserExample example=new GeekUserExample();
        if(StringUtils.isNotEmpty(geekUserQuery.getName())){
            example.or().andNameLike("%"+geekUserQuery.getName()+"%");
        }
        if(StringUtils.isNotEmpty(geekUserQuery.getPhone())){
            example.or().andPhoneLike("%"+geekUserQuery.getPhone()+"%");
        }
        List<GeekUser> list=  geekUserMapper.selectByExample(example);
        return Result.successPage(list,page);
    }

    @Override
    public void updatUser(GeekUser geekUser) {
        geekUserMapper.updateByPrimaryKeySelective(geekUser);
    }
}
