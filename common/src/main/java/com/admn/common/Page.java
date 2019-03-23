package com.admn.common;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

public class Page implements Serializable {

    //总记录数
    private int totalCount;
    //每页记录数
    @Min(value = 1, message = "每页大小不能0")
    private int pageSize;
    //总页数
    private int totalPage;
    //当前页数
    @Min(value = 1, message = "当前页数不能为0")
    //当前页数
    private int currPage;
    //列表数据
    private List<?> list;

    public Page() {};

    /**
     * 分页
     * @param currPage 当前页数
     * @param pageSize 每页条数
     */
    public Page(int currPage, int pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    /**
     * 分页
     * @param list        列表数据
     * @param totalCount  总记录数
     * @param pageSize    每页记录数
     * @param currPage    当前页数
     */
    public Page(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
