package com.ruoyi.merchants.mapper;

import com.ruoyi.merchants.domain.MerchantsDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MerchantsDictMapper {


    List<MerchantsDict> selectDictDataBydictLabel(@Param("userId") Long userId,@Param("dictLabel") String dictLabel);

    int insertDictData(MerchantsDict merchantsDict);

    void deleteDictDataById(int dictCode);
}
