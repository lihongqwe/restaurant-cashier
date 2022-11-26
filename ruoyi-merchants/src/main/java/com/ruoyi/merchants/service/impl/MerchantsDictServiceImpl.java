package com.ruoyi.merchants.service.impl;

import com.ruoyi.merchants.domain.MerchantsDict;
import com.ruoyi.merchants.mapper.MerchantsDictMapper;
import com.ruoyi.merchants.service.IMerchantsDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantsDictServiceImpl implements IMerchantsDictService {
    @Autowired
    private MerchantsDictMapper merchantsDictMapper;


    /**
     * 根据字典类型查询字典数据信息
     */

    @Override
    public List<MerchantsDict> selectDictDataByLabel(Long userId ,String dictLabel) {
        return merchantsDictMapper.selectDictDataBydictLabel(userId,dictLabel);
    }


    /**
     * 新增保存字典数据信息
     */
    @Override
    public int insertDictData(MerchantsDict merchantsDict) {
        List<MerchantsDict> merchantsDicts = merchantsDictMapper.selectDictDataBydictLabel(merchantsDict.getMerchantsId(), merchantsDict.getDictLabel());
        int size = merchantsDicts.size();
        merchantsDict.setDictSort((long) (size+1));
        return merchantsDictMapper.insertDictData(merchantsDict);
    }

    /**
     * 除字典数据信息
     */
    @Override
    public void deleteDictDataByIds( int dictCode) {
        merchantsDictMapper.deleteDictDataById(dictCode);
    }
}
