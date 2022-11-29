package com.ruoyi.web.controller.merchants;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.merchants.domain.vo.BillFareVo;
import com.ruoyi.merchants.domain.vo.BillVo;
import com.ruoyi.merchants.domain.vo.food;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.merchants.domain.MerchantsBill;
import com.ruoyi.merchants.service.IMerchantsBillService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 账单Controller
 *
 * @author lihong
 * @date 2022-10-27
 */
@RestController
@RequestMapping("/merchants/bill")
public class MerchantsBillController extends BaseController {

    @Autowired
    private IMerchantsBillService merchantsBillService;

    /**
     * 查询【账单】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MerchantsBill merchantsBill) {
        startPage();
//        merchantsBill.setMerchantsId();
        merchantsBill.setMerchantsId( SecurityUtils.getUserId());
        List<BillVo> BillList = merchantsBillService.selectMerchantsBillList(merchantsBill);
       float TotalPrice = 0;
        for (BillVo billVo: BillList) {
            float billPrice = billVo.getBillPrice();
            TotalPrice +=billPrice;
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("TotalPrice",TotalPrice);
        TableDataInfo dataTable = getDataTable(BillList,TotalPrice);
        dataTable.setTotal(BillList.size());
        return dataTable;
    }

//    /**
//     * 账单汇总
//     */
//    @GetMapping("/summary")
//    public AjaxResult summary(){
//        return  AjaxResult.success();
//    }


    /**
     * 结账
     */
    @PostMapping(value ="/pay")
    public AjaxResult pay(@RequestBody MerchantsBill merchantsBill ){
        merchantsBill.setMerchantsId(SecurityUtils.getUserId());
        return toAjax(merchantsBillService.payBill(merchantsBill));
    }

    /**
     * 下单
     */
    @PostMapping("/placeorder")
    public AjaxResult PlaceOrder(@RequestBody BillFareVo billFareVo){
        return toAjax(merchantsBillService.PlaceTheOrder(billFareVo));
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(merchantsBillService.selectMerchantsBillById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody MerchantsBill merchantsBill) {
        return toAjax(merchantsBillService.insertMerchantsBill(merchantsBill));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantsBill merchantsBill) {
        return toAjax(merchantsBillService.updateMerchantsBill(merchantsBill));
    }

    /**
     * 删除【请填写功能名称】
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(merchantsBillService.deleteMerchantsBillByIds(ids));
    }
}
