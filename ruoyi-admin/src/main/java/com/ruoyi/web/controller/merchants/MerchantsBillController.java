package com.ruoyi.web.controller.merchants;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
public class MerchantsBillController extends BaseController
{
    @Autowired
    private IMerchantsBillService merchantsBillService;

    /**
     * 查询【账单】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MerchantsBill merchantsBill)
    {
        startPage();
        List<MerchantsBill> list = merchantsBillService.selectMerchantsBillList(merchantsBill);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantsBill merchantsBill)
    {
        List<MerchantsBill> list = merchantsBillService.selectMerchantsBillList(merchantsBill);
        ExcelUtil<MerchantsBill> util = new ExcelUtil<MerchantsBill>(MerchantsBill.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(merchantsBillService.selectMerchantsBillById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add(@RequestBody MerchantsBill merchantsBill)
    {
        return toAjax(merchantsBillService.insertMerchantsBill(merchantsBill));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantsBill merchantsBill)
    {
        return toAjax(merchantsBillService.updateMerchantsBill(merchantsBill));
    }

    /**
     * 删除【请填写功能名称】
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(merchantsBillService.deleteMerchantsBillByIds(ids));
    }
}
