package com.ruoyi.merchants.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import cn.hutool.json.JSONUtil;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.merchants.domain.MerchantsPedestal;
import com.ruoyi.merchants.domain.vo.BillFareVo;
import com.ruoyi.merchants.domain.vo.BillVo;
import com.ruoyi.merchants.domain.vo.food;
import com.ruoyi.merchants.mapper.MerchantsPedestalMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.merchants.mapper.MerchantsBillMapper;
import com.ruoyi.merchants.domain.MerchantsBill;
import com.ruoyi.merchants.service.IMerchantsBillService;

import static com.ruoyi.common.utils.SecurityUtils.getUserId;

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

    @Autowired
    private MerchantsPedestalMapper merchantsPedestalMapper;


    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MerchantsBill selectMerchantsBillById(Long id)
    {
        return null;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param merchantsBill 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BillVo> selectMerchantsBillList(MerchantsBill merchantsBill)
    {
        List<MerchantsBill> merchantsBills =merchantsBillMapper.selectMerchantsBillList(merchantsBill);
        List<BillVo> collect = merchantsBills.stream().map(bill -> {
                    BillVo billVo = new BillVo();
                    BeanUtils.copyProperties(bill, billVo);
                    String foodName = bill.getFoodName().replace("food","")
                            .replace("=",":");
                    List<food> food=  JSONUtil.toList(foodName,food.class);
                    billVo.setFoodName(food);
                    billVo.setBillPrice(bill.getBillPrice());
                    return billVo;
                }
        ).collect(Collectors.toList());
        return collect;
    }

    @Override
    public int payBill( MerchantsBill merchantsBill) {
        //修改台座状态

        merchantsPedestalMapper.updateState(merchantsBill.getPedestalId());
        return merchantsBillMapper.updateMerchantsBillStateById(merchantsBill);
    }

    /**
     * 下单
     */
    @Override
    public int PlaceTheOrder(BillFareVo billFareVo) {
        MerchantsBill merchantsBill = new MerchantsBill();
        merchantsBill.setPedestalId(billFareVo.getPedestalId());
        Long billId= (long) (merchantsBillMapper.selectMerchantsBillById(SecurityUtils.getUserId()).size() + 1);
//        Long billId= (long) (merchantsBillMapper.selectMerchantsBillById(107L).size() + 1);
        merchantsBill.setBillId(billId);
        List<food> foodName = billFareVo.getFoodName();
//        merchantsBill.setMerchantsId(107L);
        merchantsBill.setMerchantsId(SecurityUtils.getUserId());
        merchantsBill.setFoodName(foodName.toString());
        //计算账单总价钱
        float  price = 0;
        for (food food : billFareVo.getFoodName()){
            int number = food.getNumber();
            price += food.getPrice()*number;
        }
        merchantsBill.setBillPrice(price);
        //修改台座状态
        merchantsPedestalMapper.updatePedestalState(merchantsBill.getPedestalId());
        return merchantsBillMapper.insertMerchantsBill(merchantsBill);
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
