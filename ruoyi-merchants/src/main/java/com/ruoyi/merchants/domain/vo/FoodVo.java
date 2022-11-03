package com.ruoyi.merchants.domain.vo;

import com.ruoyi.common.annotation.Excel;

import java.math.BigDecimal;
import java.util.List;

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

    /** 菜品图片地址 */
    @Excel(name = "菜品图片地址")
    private String foodPicture;



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

    public String getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(String foodPicture) {
        this.foodPicture = foodPicture;
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
                ", foodPrice='" + foodPrice + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodPicture='" + foodPicture + '\'' +
                '}';
    }
}
