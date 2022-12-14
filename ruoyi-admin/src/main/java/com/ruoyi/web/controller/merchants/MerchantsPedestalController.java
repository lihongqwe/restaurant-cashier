package com.ruoyi.web.controller.merchants;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.merchants.domain.vo.PedestalVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.merchants.domain.MerchantsPedestal;
import com.ruoyi.merchants.service.IMerchantsPedestalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【台座】Controller
 * 
 * @author lihong
 * @date 2022-10-27
 */
@RestController
@RequestMapping("/merchants/pedestal")
public class MerchantsPedestalController extends BaseController
{
    @Autowired
    private IMerchantsPedestalService merchantsPedestalService;

    /**
     * 查询【台座】列表
     */
    @GetMapping("/list")
    public AjaxResult list(MerchantsPedestal merchantsPedestal)
    {
        merchantsPedestal.setMerchantsId(SecurityUtils.getUserId());
        List<MerchantsPedestal> list = merchantsPedestalService.selectMerchantsPedestalList(merchantsPedestal);
        List<PedestalVo> collect = list.stream().map(pedestal -> {
            PedestalVo pedestalVo = new PedestalVo();
            BeanUtils.copyProperties(pedestal, pedestalVo);
            return pedestalVo;
        }).collect(Collectors.toList());
        return AjaxResult.success(collect);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, MerchantsPedestal merchantsPedestal)
    {
        List<MerchantsPedestal> list = merchantsPedestalService.selectMerchantsPedestalList(merchantsPedestal);
        ExcelUtil<MerchantsPedestal> util = new ExcelUtil<MerchantsPedestal>(MerchantsPedestal.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【台座】详细信息
     */
    @GetMapping(value = "/{pedestalId}")
    public AjaxResult getInfo(@PathVariable("pedestalId") Long pedestalId)
    {
        return AjaxResult.success(merchantsPedestalService.selectMerchantsPedestalByPedestalId(pedestalId));
    }

    /**
     * 新增【台座】
     */
    @PostMapping
    public AjaxResult add(@RequestBody MerchantsPedestal merchantsPedestal)
    {

        merchantsPedestal.setMerchantsId(SecurityUtils.getUserId());
//        merchantsPedestal.setMerchantsId(2L);
        int i = merchantsPedestalService.insertMerchantsPedestal(merchantsPedestal);
        if(i>0){
            return  AjaxResult.success();
        }
        return AjaxResult.error("台座信息已存在！！！");
    }

    /**
     * 修改【台座】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantsPedestal merchantsPedestal)
    {
        return toAjax(merchantsPedestalService.updateMerchantsPedestal(merchantsPedestal));
    }

    /**
     * 删除【台座】
     */
	@DeleteMapping("/{pedestalIds}")
    public AjaxResult remove(@PathVariable Long[] pedestalIds)
    {
        return toAjax(merchantsPedestalService.deleteMerchantsPedestalByPedestalIds(SecurityUtils.getUserId(),pedestalIds));
    }


}
