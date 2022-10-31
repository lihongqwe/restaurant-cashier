package com.ruoyi.merchants.service;

import java.util.List;
import com.ruoyi.merchants.domain.MerchantsPedestal;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
public interface IMerchantsPedestalService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param pedestalId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MerchantsPedestal selectMerchantsPedestalByPedestalId(Long pedestalId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param merchantsPedestal 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MerchantsPedestal> selectMerchantsPedestalList(MerchantsPedestal merchantsPedestal);

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsPedestal 【请填写功能名称】
     * @return 结果
     */
    public int insertMerchantsPedestal(MerchantsPedestal merchantsPedestal);

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsPedestal 【请填写功能名称】
     * @return 结果
     */
    public int updateMerchantsPedestal(MerchantsPedestal merchantsPedestal);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pedestalIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteMerchantsPedestalByPedestalIds(Long MerchantsId , Long[] pedestalIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param pedestalId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMerchantsPedestalByPedestalId(Long pedestalId);
}
