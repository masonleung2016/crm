package com.ufostudio.crm.common.entity;

import com.google.common.collect.Maps;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页数据DTO
 *
 * @Author: LCF
 * @Date: 2020/7/5 17:39
 * @Package: com.ufostudio.crm.common.entity
 */

public class PageInfoDTO implements Serializable {
    /**
     * 页码，默认是第一页
     */
    private int pageNum = 1;
    /**
     * 每页显示的记录数，默认是15
     */
    private int pageSize = 15;
    /**
     * 总记录数
     */
    private int totalRecord;
    /**
     * sql中limit起始值
     */
    private int offset;
    /**
     * sql中limit结束值
     */
    private int limit;
    /*
    总页数
     */
    private int totalPage;

    /**
     * 对应的当前页记录
     */
    private List results;

    /**
     * 其他的参数我们把它分装成一个Map对象
     */
    private Map<String, Object> params;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        this.limit = this.pageSize;
        this.offset = this.pageSize * (this.pageNum - 1);
        this.totalPage = totalPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = Maps.newHashMap();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pageNum", pageNum)
                .append("pageSize", pageSize)
                .append("totalRecord", totalRecord)
                .append("offset", offset)
                .append("limit", limit)
                .append("totalPage", totalPage)
                .append("results", results)
                .append("params", params)
                .toString();
    }
}
