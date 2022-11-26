package com.ruoyi.merchants.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.io.Serializable;


public class MerchantsDict implements Serializable {

    private Long merchantsId;
    private Long dictCode;
    private Long dictSort;
    private String dictLabel;
    private String dictValue;

    public MerchantsDict() {

    }

    public MerchantsDict(Long merchantsId, Long dictCode, Long dictSort, String dictLabel, String dictValue) {
        this.merchantsId = merchantsId;
        this.dictCode = dictCode;
        this.dictSort = dictSort;
        this.dictLabel = dictLabel;
        this.dictValue = dictValue;
    }


    @Override
    public String toString() {
        return "MerchantsDict{" +
                "merchantsId=" + merchantsId +
                ", dictCode=" + dictCode +
                ", dictSort=" + dictSort +
                ", dictLabel='" + dictLabel + '\'' +
                ", dictValue='" + dictValue + '\'' +
                '}';
    }

    public Long getMerchantsId() {
        return merchantsId;
    }

    public void setMerchantsId(Long merchantsId) {
        this.merchantsId = merchantsId;
    }

    public Long getDictCode() {
        return dictCode;
    }

    public void setDictCode(Long dictCode) {
        this.dictCode = dictCode;
    }

    public Long getDictSort() {
        return dictSort;
    }

    public void setDictSort(Long dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
