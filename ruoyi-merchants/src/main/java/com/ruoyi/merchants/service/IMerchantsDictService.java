package com.ruoyi.merchants.service;

import com.ruoyi.merchants.domain.MerchantsDict;

import java.util.List;

public interface IMerchantsDictService {


    List<MerchantsDict> selectDictDataByLabel(Long userId , String dictLabel);

    int insertDictData(MerchantsDict merchantsDict);

    void deleteDictDataByIds(int dictCode);
}
