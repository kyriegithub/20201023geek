package com.example.geek.model.query;

import java.io.Serializable;

/**
 * @author xiaowc
 */
public class QueryPageBean implements Serializable {
    private static final int PAGE_SIZE_DEFAULT = 12;
    private static final int PAGE_NO_DEFAULT = 1;

    private static final long serialVersionUID = 4146055498237132023L;
    /**
     * 第几页
     **/
    private Integer pageNo;
    /**
     * 每页记录数
     **/
    private Integer pageSize;

    public QueryPageBean() {

    }

    public QueryPageBean(Integer page, Integer pageSize) {
        super();
        this.pageNo = page;
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize==null?PAGE_SIZE_DEFAULT:pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo == null ? PAGE_NO_DEFAULT : pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}