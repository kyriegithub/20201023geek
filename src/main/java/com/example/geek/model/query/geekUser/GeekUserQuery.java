package com.example.geek.model.query.geekUser;

import com.example.geek.model.query.BaseQuery;
import lombok.Data;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-10-18 04:52
 * @Description
 */
@Data
public class GeekUserQuery extends BaseQuery {

    /**
     *
     */
    private String name;


    /**
     *
     */
    private String phone;

}
