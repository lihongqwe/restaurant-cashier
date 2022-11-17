package com.ruoyi.merchants.domain.vo;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

public class BillFareVo {


    /** 台座id */
    @Excel(name = "台座id")
    private Long pedestalId;

    /** 菜品列表 */
    @Excel(name = "菜品列表")
    private List<food> foodName;

    /** 口味 */
    @Excel(name = "口味")
    private String taste;


    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
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
                "pedestalId=" + pedestalId +
                ", foodName=" + foodName +
                ", taste=" + taste +
                '}';
    }
}
