package com.ruoyi.merchants.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BillVo {



    /** 账单id */
    @Excel(name = "账单id")
    private Long billId;

    /** 台座id */
    @Excel(name = "台座id")
    private Long pedestalId;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private List<String> foodName;

    /** 账单状态（0:未结算，1:已结算） */
    @Excel(name = "账单状态", readConverterExp = "0=:未结算，1:已结算")
    private Integer billState;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String paymentMethod;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 账单总价格 */
    @Excel(name = "账单总价格")
    private BigDecimal billPrice;


    /** 结算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结算时间")
    private Date checkOutTime;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getPedestalId() {
        return pedestalId;
    }

    public void setPedestalId(Long pedestalId) {
        this.pedestalId = pedestalId;
    }

    public List<String> getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = Collections.singletonList(foodName);
    }

    public Integer getBillState() {
        return billState;
    }

    public void setBillState(Integer billState) {
        this.billState = billState;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setFoodName(List<String> foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(BigDecimal billPrice) {
        this.billPrice = billPrice;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
    public BillVo(){}

    @Override
    public String toString() {
        return "BillVo{" +
                "billId=" + billId +
                ", pedestalId=" + pedestalId +
                ", foodName=" + foodName +
                ", billState=" + billState +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", createTime=" + createTime +
                ", billPrice=" + billPrice +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
