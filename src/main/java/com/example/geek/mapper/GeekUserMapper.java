package com.example.geek.mapper;

import com.example.geek.entity.GeekUser;
import com.example.geek.entity.GeekUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GeekUserMapper {
    long countByExample(GeekUserExample example);

    int deleteByExample(GeekUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GeekUser record);

    int insertSelective(GeekUser record);

    List<GeekUser> selectByExample(GeekUserExample example);

    GeekUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GeekUser record, @Param("example") GeekUserExample example);

    int updateByExample(@Param("record") GeekUser record, @Param("example") GeekUserExample example);

    int updateByPrimaryKeySelective(GeekUser record);

    int updateByPrimaryKey(GeekUser record);
}