package com.ruoyi.web.controller.merchants;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.merchants.domain.MerchantsDict;
import com.ruoyi.merchants.service.IMerchantsDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchants/dict")
public class MerchantsDictController extends BaseController {

    @Autowired
    private IMerchantsDictService iMerchantsDictService;


    @GetMapping("type/{dictLabel}")
    public AjaxResult dictType(@PathVariable String dictLabel){
        Long userId = SecurityUtils.getUserId();
//        Long userId=;
        List<MerchantsDict> merchantsDicts=iMerchantsDictService.selectDictDataByLabel(userId,dictLabel);
        return AjaxResult.success(merchantsDicts);
    }

    @PostMapping()
    public  AjaxResult add(@Validated @RequestBody MerchantsDict merchantsDict){

        Long userId = SecurityUtils.getUserId();
//        Long userId=;
        merchantsDict.setMerchantsId(userId);
        return toAjax(iMerchantsDictService.insertDictData(merchantsDict));
    }

    @GetMapping("/delete/{dictCode}")
    public  AjaxResult  delete(@PathVariable int dictCode){
        iMerchantsDictService.deleteDictDataByIds(dictCode);
        return success();
    }
}
