package com.ruoyi.merchants.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.merchants.mapper.MerchantsPedestalMapper;
import com.ruoyi.merchants.domain.MerchantsPedestal;
import com.ruoyi.merchants.service.IMerchantsPedestalService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
@Service
public class MerchantsPedestalServiceImpl implements IMerchantsPedestalService 
{
    @Autowired
    private MerchantsPedestalMapper merchantsPedestalMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param pedestalId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MerchantsPedestal selectMerchantsPedestalByPedestalId(Long pedestalId)
    {
        return merchantsPedestalMapper.selectMerchantsPedestalByPedestalId(pedestalId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param merchantsPedestal 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MerchantsPedestal> selectMerchantsPedestalList(MerchantsPedestal merchantsPedestal)
    {
        return merchantsPedestalMapper.selectMerchantsPedestalList(merchantsPedestal);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsPedestal 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMerchantsPedestal(MerchantsPedestal merchantsPedestal)
    {
        if(merchantsPedestalMapper.selectMerchantsPedestalList(merchantsPedestal).size()==0){
            return merchantsPedestalMapper.insertMerchantsPedestal(merchantsPedestal);
        }
        return 0;
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsPedestal 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMerchantsPedestal(MerchantsPedestal merchantsPedestal)
    {
        return merchantsPedestalMapper.updateMerchantsPedestal(merchantsPedestal);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pedestalIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsPedestalByPedestalIds(Long MerchantsId ,Long[] pedestalIds)
    {
        return merchantsPedestalMapper.deleteMerchantsPedestalByPedestalIds(MerchantsId,pedestalIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param pedestalId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsPedestalByPedestalId(Long pedestalId)
    {
        return merchantsPedestalMapper.deleteMerchantsPedestalByPedestalId(pedestalId);
    }
}
