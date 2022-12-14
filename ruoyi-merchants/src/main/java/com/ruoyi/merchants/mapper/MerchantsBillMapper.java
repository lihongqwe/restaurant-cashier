package com.ruoyi.merchants.mapper;

import java.util.List;
import com.ruoyi.merchants.domain.MerchantsBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author lihong
 * @date 2022-10-27
 */

@Mapper
public interface MerchantsBillMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public List<MerchantsBill> selectMerchantsBillById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MerchantsBill> selectMerchantsBillList(MerchantsBill merchantsBill);

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 结果
     */
    public int insertMerchantsBill(MerchantsBill merchantsBill);

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 结果
     */
    public int updateMerchantsBill(MerchantsBill merchantsBill);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMerchantsBillById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerchantsBillByIds(Long[] ids);


    int updateMerchantsBillStateById(MerchantsBill merchantsBill);
}

