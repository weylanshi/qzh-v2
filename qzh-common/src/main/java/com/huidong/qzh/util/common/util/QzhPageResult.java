package com.huidong.qzh.util.common.util;

import java.util.List;

public class QzhPageResult {

    /*每页大小*/
    private long pageSize;
    /*第几页*/
    private long pageNo;
    /*总页数*/
    private  long totalPage;
    /*每页数据*/
    private List<?> list;




    public static QzhPageResult build(long pageNo, long pageSize, long totalPage, List<?> list) {
        return new QzhPageResult(pageSize, pageNo, totalPage,list);
    }

    public QzhPageResult(long pageSize, long pageNo, long totalPage, List<?> list) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.totalPage = totalPage;
        this.list = list;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}
