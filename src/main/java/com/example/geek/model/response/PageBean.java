package com.example.geek.model.response;

import com.github.pagehelper.Page;

/**
 * Created by wangzuoxu on 2018/4/28.
 */
public class PageBean {

    private int pageNo = 1;

    private int pageSize = 10;

    private long totalCount = 0;

    public PageBean() {
    }

    public PageBean(int pageNo, int pageSize, long totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public static PageBean fromPage(Page page) {
        if (page==null) {
            return null;
        }
        return new PageBean(page.getPageNum(), page.getPageSize(), page.getTotal());
    }

}
