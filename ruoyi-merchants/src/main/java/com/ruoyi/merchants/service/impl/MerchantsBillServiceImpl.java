package com.ruoyi.merchants.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.merchants.mapper.MerchantsBillMapper;
import com.ruoyi.merchants.domain.MerchantsBill;
import com.ruoyi.merchants.service.IMerchantsBillService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author lihong
 * @date 2022-10-27
 */
@Service
public class MerchantsBillServiceImpl implements IMerchantsBillService 
{
    @Autowired
    private MerchantsBillMapper merchantsBillMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MerchantsBill selectMerchantsBillById(Long id)
    {
        return merchantsBillMapper.selectMerchantsBillById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MerchantsBill> selectMerchantsBillList(MerchantsBill merchantsBill)
    {
        return merchantsBillMapper.selectMerchantsBillList(merchantsBill);
    }

    @Override
    public int payBill(Long merchantsId, Long billId) {

        return merchantsBillMapper.updateMerchantsBillStateById(merchantsId,billId);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMerchantsBill(MerchantsBill merchantsBill)
    {
        return merchantsBillMapper.insertMerchantsBill(merchantsBill);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMerchantsBill(MerchantsBill merchantsBill)
    {
        return merchantsBillMapper.updateMerchantsBill(merchantsBill);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsBillByIds(Long[] ids)
    {
        return merchantsBillMapper.deleteMerchantsBillByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsBillById(Long id)
    {
        return merchantsBillMapper.deleteMerchantsBillById(id);
    }


}
