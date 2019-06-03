package com.fwt.utils;

import java.util.List;

public class Page {
    /**
     * 当前页
     */
    public Integer currentPage = 1;
    /**
     * 每页展示的数量
     */
    public Integer pageSize = 5;
    /**
     * 数据总行数
     */
    public Integer totalCount;
    /**
     * 总页数
     */
    //从第几行开始
    public Integer start;

    public Integer pageCount;
    public List<?> list;
    public String url;

    public Page() {

    }

    public Page(Integer currentPage, Integer pageSize, Integer totalCount, Integer pageCount, List<?> list, String url) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.pageCount = pageCount;
        this.list = list;
        this.url = url;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        currentPage=currentPage>0?currentPage : 1;

        setStart((pageSize*(currentPage-1))>getTotalCount()?
                pageSize*(getPageCount()-1) : (pageSize*(currentPage-1))>= pageSize?
                (pageSize*(currentPage-1)) : 0);
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        setPageCount(totalCount%pageSize == 0? totalCount/pageSize : totalCount/pageSize+1);
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {

        return pageCount;
    }

    public void setPageCount(Integer pageCount) {

        this.pageCount = pageCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart() {
        return start;
    }

    public void setStart(Integer start1) {

     this.start=start1;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", start=" + start +
                ", pageCount=" + pageCount +
                ", list=" + list +
                ", url='" + url + '\'' +
                '}';
    }
}
