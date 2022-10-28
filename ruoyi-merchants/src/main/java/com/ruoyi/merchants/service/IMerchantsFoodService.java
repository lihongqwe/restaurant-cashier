package com.ruoyi.merchants.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.merchants.domain.MerchantsFood;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
public interface IMerchantsFoodService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public MerchantsFood selectMerchantsFoodById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MerchantsFood> selectMerchantsFoodList(MerchantsFood merchantsFood);

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    public AjaxResult insertMerchantsFood(MultipartFile fileUpload, MerchantsFood merchantsFood);

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    public int updateMerchantsFood(MerchantsFood merchantsFood);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteMerchantsFoodByIds(Long MerchantsId,Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMerchantsFoodById(Long id);
}
