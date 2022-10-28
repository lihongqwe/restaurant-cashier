package com.ruoyi.merchants.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 【账单】对象 merchants_bill
 * 
 * @author lihong
 * @date 2022-10-27
 */
public class MerchantsBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 店家id */
    @Excel(name = "店家id")
    private Long merchantsId;

    /** 账单id */
    @Excel(name = "账单id")
    private Long billId;

    /** 台座id */
    @Excel(name = "台座id")
    private Long pedestalId;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String foodName;

    /** 账单状态（0:未结算，1:已结算） */
    @Excel(name = "账单状态", readConverterExp = "0=:未结算，1:已结算")
    private Integer billState;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String paymentMethod;

    /** 创建时间 */
    @Excel(name = "创建时间",dateFormat = "yyyy-MM-dd")
    private Date createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMerchantsId(Long merchantsId) 
    {
        this.merchantsId = merchantsId;
    }

    public Long getMerchantsId() 
    {
        return merchantsId;
    }
    public void setBillId(Long billId) 
    {
        this.billId = billId;
    }

    public Long getBillId() 
    {
        return billId;
    }
    public void setPedestalId(Long pedestalId) 
    {
        this.pedestalId = pedestalId;
    }

    public Long getPedestalId() 
    {
        return pedestalId;
    }
    public void setFoodName(String foodName) 
    {
        this.foodName = foodName;
    }

    public String getFoodName() 
    {
        return foodName;
    }
    public void setBillState(Integer billState) 
    {
        this.billState = billState;
    }

    public Integer getBillState() 
    {
        return billState;
    }
    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("merchantsId", getMerchantsId())
            .append("billId", getBillId())
            .append("pedestalId", getPedestalId())
            .append("foodName", getFoodName())
            .append("billState", getBillState())
            .append("paymentMethod", getPaymentMethod())
            .append("createTime", getCreateTime())
            .toString();
    }
}
