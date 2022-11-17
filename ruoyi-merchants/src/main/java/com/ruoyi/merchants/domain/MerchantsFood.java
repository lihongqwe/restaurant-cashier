package com.ruoyi.merchants.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【菜单】对象 merchants_food
 * 
 * @author lihong
 * @date 2022-10-27
 */
public class MerchantsFood extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 商家id */
    @Excel(name = "商家id")
    private Long merchantsId;

    /** 菜品id */
    @Excel(name = "菜品id")
    private Long foodId;

    /** 菜品价格 */
    @Excel(name = "菜品价格")
    private float foodPrice;

    /** 菜品名字 */
    @Excel(name = "菜品名字")
    private String foodName;

    /** 菜品图片地址 */
    @Excel(name = "菜品图片地址")
    private String foodPicture;

    /** 菜品类型 */
    @Excel(name = "菜品类型")
    private String foodType;

    private Long[]  foodIds;


    public Long[]  getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(Long[]  foodIds) {
        this.foodIds = foodIds;
    }

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
    public void setFoodId(Long foodId) 
    {
        this.foodId = foodId;
    }

    public Long getFoodId() 
    {
        return foodId;
    }
    public void setFoodPrice(float foodPrice)
    {
        this.foodPrice = foodPrice;
    }

    public float getFoodPrice()
    {
        return foodPrice;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "MerchantsFood{" +
                "id=" + id +
                ", merchantsId=" + merchantsId +
                ", foodId=" + foodId +
                ", foodPrice=" + foodPrice +
                ", foodName='" + foodName + '\'' +
                ", foodPicture='" + foodPicture + '\'' +
                ", foodType='" + foodType + '\'' +
                ", foodIds=" + Arrays.toString(foodIds) +
                '}';
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

}
