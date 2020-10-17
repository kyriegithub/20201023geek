package com.example.geek.model.query;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by chenzq
 * Date: 2019/5/17 下午2:29
 **/
@Data
public class BaseSelectQuery implements Serializable {
    private Integer clinicId;
    private Integer orgId;
}
