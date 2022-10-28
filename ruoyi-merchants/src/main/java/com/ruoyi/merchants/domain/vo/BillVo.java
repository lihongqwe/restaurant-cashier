package com.ruoyi.merchants.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;

import java.util.Date;

public class BillVo {


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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getMerchantsId() {
        return merchantsId;
    }

    public void setMerchantsId(Long merchantsId) {
        this.merchantsId = merchantsId;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
    public BillVo(){}

    @Override
    public String toString() {
        return "BillVo{" +
                "merchantsId=" + merchantsId +
                ", billId=" + billId +
                ", pedestalId=" + pedestalId +
                ", foodName='" + foodName + '\'' +
                ", billState=" + billState +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public BillVo(Long merchantsId, Long billId, Long pedestalId, String foodName, Integer billState, String paymentMethod, Date createTime) {

        this.merchantsId = merchantsId;
        this.billId = billId;
        this.pedestalId = pedestalId;
        this.foodName = foodName;
        this.billState = billState;
        this.paymentMethod = paymentMethod;
        this.createTime = createTime;
    }
}
