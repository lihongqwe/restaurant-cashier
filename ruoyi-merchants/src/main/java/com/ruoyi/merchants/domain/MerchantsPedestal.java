package com.ruoyi.merchants.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【台座】对象 merchants_pedestal
 * 
 * @author lihong
 * @date 2022-10-27
 */
public class MerchantsPedestal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 台座id */
    private Long pedestalId;

    /** 台座状态（0:空闲，1:有人） */
    @Excel(name = "台座状态", readConverterExp = "0=:空闲，1:有人")
    private Integer pedestalState;

    /** 店家id */
    @Excel(name = "店家id")
    private Long merchantsId;

    public void setPedestalId(Long pedestalId) 
    {
        this.pedestalId = pedestalId;
    }

    public Long getPedestalId() 
    {
        return pedestalId;
    }
    public void setPedestalState(Integer pedestalState) 
    {
        this.pedestalState = pedestalState;
    }

    public Integer getPedestalState() 
    {
        return pedestalState;
    }
    public void setMerchantsId(Long merchantsId) 
    {
        this.merchantsId = merchantsId;
    }

    public Long getMerchantsId() 
    {
        return merchantsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pedestalId", getPedestalId())
            .append("pedestalState", getPedestalState())
            .append("merchantsId", getMerchantsId())
            .toString();
    }
}
