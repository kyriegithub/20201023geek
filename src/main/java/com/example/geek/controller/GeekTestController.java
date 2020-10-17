package com.example.geek.controller;

import com.example.geek.entity.GeekUser;
import com.example.geek.exception.CustomizedException;
import com.example.geek.model.query.geekUser.GeekUserQuery;
import com.example.geek.model.response.Result;
import com.example.geek.service.GeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-10-08 00:22
 * @Description
 */
@RestController
@RequestMapping("geek")
public class GeekTestController {

    @Autowired
    private GeekService  geekService;


    /**
     * 新增数据
     * @param geekUser
     * @return
     */
    @PostMapping("user")
    public Result addUser(@RequestBody GeekUser geekUser) {
        geekService.addUser(geekUser);
        return Result.success();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("user/{id}")
    public Result delUser(@PathVariable("id") int id) {
        geekService.delUser(id);
        return Result.success();
    }


    /**
     * 查询单个信息
     * @param id
     * @return
     */
    @GetMapping("user/{id}")
    public Result getUser(@PathVariable("id") int id) {
        GeekUser geekUser=geekService.getUserInfo(id);
        /**
         * 异常抛出处理方式
         */
        if(id==0){
            throw  new CustomizedException("error.undefine","未定义错误异常");
        }
        return Result.success(geekUser);
    }


    /**
     * 查询列表
     * @param geekUserQuery
     * @return
     */
    @GetMapping("user/list")
    public Result getUserList(GeekUserQuery geekUserQuery) {
        return geekService.getUserList(geekUserQuery);
    }






    /**
     * 更新数据
     * @param geekUser
     * @return
     */
    @PutMapping("user")
    public Result updatUser(@RequestBody GeekUser geekUser) {
        geekService.updatUser(geekUser);
        return Result.success();

    }





}
