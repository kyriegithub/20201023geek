package com.example.geek.model.response;

public class Query {

    /**
     * 升序asc,降序desc
     */
    private String order;
    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 当前页
     */
    private int pageNo = 1;
    /**
     * 每页记录数
     */
    private int pageSize = 10;
    /**
     * 总记录数
     */
    private long totalCount;

    public Query() {
    }

    public Query(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Query(String order, String orderBy, int pageNo, int pageSize, long totalCount) {
        this.order = order;
        this.orderBy = orderBy;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getPageNo() {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = 10;
        }
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
}
