package com.ruoyi.merchants.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.merchants.mapper.MerchantsFoodMapper;
import com.ruoyi.merchants.domain.MerchantsFood;
import com.ruoyi.merchants.service.IMerchantsFoodService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
@Service
public class MerchantsFoodServiceImpl implements IMerchantsFoodService 
{
    @Autowired
    private MerchantsFoodMapper merchantsFoodMapper;


    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MerchantsFood selectMerchantsFoodById(Long id)
    {
        return merchantsFoodMapper.selectMerchantsFoodById(id);
    }

    /**
     * 查询【菜单】列表
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MerchantsFood> selectMerchantsFoodList(MerchantsFood merchantsFood)
    {
        return merchantsFoodMapper.selectMerchantsFoodList(merchantsFood);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMerchantsFood(MerchantsFood merchantsFood)
    {
        return merchantsFoodMapper.insertMerchantsFood(merchantsFood);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMerchantsFood(MerchantsFood merchantsFood)
    {
        return merchantsFoodMapper.updateMerchantsFood(merchantsFood);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsFoodByIds(Long[] ids)
    {
        return merchantsFoodMapper.deleteMerchantsFoodByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsFoodById(Long id)
    {
        return merchantsFoodMapper.deleteMerchantsFoodById(id);
    }
}
