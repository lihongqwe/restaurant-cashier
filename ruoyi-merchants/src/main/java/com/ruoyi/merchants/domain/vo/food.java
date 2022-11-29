package com.ruoyi.merchants.domain.vo;

public class food {

    /**
     * 菜品名字
     */
    private String name;
    /**
     * 菜品单价
     */
    private float price;

    private int number;

    private  String taste;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", taste='" + taste + '\'' +
                '}';
    }
}
