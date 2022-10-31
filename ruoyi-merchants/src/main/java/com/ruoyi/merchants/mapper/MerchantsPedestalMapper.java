package com.ruoyi.merchants.mapper;

import java.util.List;
import com.ruoyi.merchants.domain.MerchantsPedestal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author lihong
 * @date 2022-10-27
 */

@Mapper
public interface MerchantsPedestalMapper 
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
     * 修改台座状态
     */
    public int updatePedestalState(Long pedestalId);
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
     * 删除【请填写功能名称】
     * 
     * @param pedestalId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMerchantsPedestalByPedestalId(Long pedestalId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pedestalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerchantsPedestalByPedestalIds(@Param("MerchantsId") Long MerchantsId ,@Param("pedestalIds") Long[] pedestalIds);

    void updateState(Long pedestalId);
}
