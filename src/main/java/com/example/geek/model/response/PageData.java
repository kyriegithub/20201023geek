package com.example.geek.model.response;

import java.util.Collections;
import java.util.List;

/**
 * @author: zhanglu
 * @create: 2018/06/21 20:11
 * @description:
 */
public class PageData<T> {

    private static PageBean DEFAULT_PAGE_BEAN = new PageBean();

    List<T> items = Collections.EMPTY_LIST;

    PageBean pageBean = DEFAULT_PAGE_BEAN;

    public PageData() {
    }

    public PageData(List<T> items) {
        this.items = items;
    }

    public PageData(List<T> items, PageBean pageBean) {
        this.items = items;
        setPageBean(pageBean);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = (pageBean==null?DEFAULT_PAGE_BEAN:pageBean);
    }
}
