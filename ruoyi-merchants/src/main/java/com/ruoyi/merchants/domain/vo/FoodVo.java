package com.ruoyi.merchants.domain.vo;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;

public class FoodVo {
    /** 菜品名字 */
    @Excel(name = "菜品id")
    private Long foodId;

    /** 菜品价格 */
    @Excel(name = "菜品价格")
    private String foodPrice;


    /** 菜品名字 */
    @Excel(name = "菜品名字")
    private String foodName;

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public FoodVo(){

    }

    public FoodVo(Long foodId, String foodPrice, String foodName) {
        this.foodId = foodId;
        this.foodPrice = foodPrice;
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "FoodVo{" +
                "foodId=" + foodId +
                ", foodPrice=" + foodPrice +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
