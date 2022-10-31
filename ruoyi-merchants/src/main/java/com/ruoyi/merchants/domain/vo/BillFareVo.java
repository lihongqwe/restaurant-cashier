package com.ruoyi.merchants.domain.vo;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

public class BillFareVo {

    /** 账单id */
    @Excel(name = "账单id")
    private Long billId;

    /** 台座id */
    @Excel(name = "台座id")
    private Long pedestalId;

    /** 菜品列表 */
    @Excel(name = "菜品列表")
    private List<food> foodName;


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

    public List<food> getFoodName() {
        return foodName;
    }

    public void setFoodName(List<food> foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "BillFareVo{" +
                "billId=" + billId +
                ", pedestalId=" + pedestalId +
                ", foodName=" + foodName +
                '}';
    }
}
