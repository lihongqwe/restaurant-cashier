package com.ruoyi.merchants.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

public class PedestalVo {

    /** 台座id */
    private Long pedestalId;

    /** 台座状态（0:空闲，1:有人） */
    @Excel(name = "台座状态", readConverterExp = "0=:空闲，1:有人")
    private Integer pedestalState;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Long getPedestalId() {
        return pedestalId;
    }

    public void setPedestalId(Long pedestalId) {
        this.pedestalId = pedestalId;
    }

    public Integer getPedestalState() {
        return pedestalState;
    }

    public void setPedestalState(Integer pedestalState) {
        this.pedestalState = pedestalState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PedestalVo{" +
                "pedestalId=" + pedestalId +
                ", pedestalState=" + pedestalState +
                ", createTime=" + createTime +
                '}';
    }

    public PedestalVo() {

    }
}
