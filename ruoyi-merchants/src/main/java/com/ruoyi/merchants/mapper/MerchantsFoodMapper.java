package com.ruoyi.merchants.mapper;

import java.util.List;
import com.ruoyi.merchants.domain.MerchantsFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author lihong
 * @date 2022-10-27
 */
@Mapper
public interface MerchantsFoodMapper 
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
    public int insertMerchantsFood(MerchantsFood merchantsFood);

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    public int updateMerchantsFood(MerchantsFood merchantsFood);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteMerchantsFoodById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param foodIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerchantsFoodByIds(@Param("MerchantsId") Long MerchantsId,@Param("foodIds")  Long[] foodIds);


    MerchantsFood getFoodIds(Long foodId);

}
