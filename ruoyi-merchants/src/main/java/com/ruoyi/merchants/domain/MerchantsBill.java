package com.ruoyi.merchants.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.merchants.domain.vo.food;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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

//    private List<food> foodName;

    /** 账单状态（0:未结算，1:已结算） */
    @Excel(name = "账单状态", readConverterExp = "0=:未结算，1:已结算")
    private Integer billState;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String paymentMethod;

    /** 创建时间 */
    @Excel(name = "创建时间",dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 账单总价格 */
    @Excel(name = "账单总价格")
    private float billPrice;

    /** 口味 */
    @Excel(name = "口味")
    private String taste;


    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间")
    private Date checkOutTime;

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

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
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

    public float getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(float billPrice) {
        this.billPrice = billPrice;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
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
        return "MerchantsBill{" +
                "id=" + id +
                ", merchantsId=" + merchantsId +
                ", billId=" + billId +
                ", pedestalId=" + pedestalId +
                ", foodName='" + foodName + '\'' +
                ", billState=" + billState +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", createTime=" + createTime +
                ", billPrice=" + billPrice +
                ", taste=" + taste +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
