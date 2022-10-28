package com.ruoyi.web.controller.merchants;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.merchants.domain.vo.FoodVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.merchants.domain.MerchantsFood;
import com.ruoyi.merchants.service.IMerchantsFoodService;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 菜单 Controller
 * 
 * @author lihong
 * @date 2022-10-27
 */
@RestController
@RequestMapping("/merchants/food")
public class MerchantsFoodController extends BaseController
{
    @Autowired
    private IMerchantsFoodService merchantsFoodService;

    //登录用户的id
//    private final Long userId = getUserId();


    /**
     * 查询【菜单】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(@RequestBody MerchantsFood merchantsFood)
    {
        startPage();
        //添加商家id
//        merchantsFood.setMerchantsId(userId);
        List<MerchantsFood> list = merchantsFoodService.selectMerchantsFoodList(merchantsFood);
        System.out.println(merchantsFood);
        List<FoodVo> collect = list.stream().map(food -> {
                    FoodVo foodVo = new FoodVo();
                    BeanUtils.copyProperties(food, foodVo);
                    foodVo.setFoodPrice(food.getFoodPrice().toString()+"元");
                    return foodVo;
                }
        ).collect(Collectors.toList());
        return getDataTable(collect);
    }

//    /**
//     * 导出【菜单】列表
//     */
//    @PostMapping("/export")
//    public void export(HttpServletResponse response, MerchantsFood merchantsFood)
//    {
//        List<MerchantsFood> list = merchantsFoodService.selectMerchantsFoodList(merchantsFood);
//        ExcelUtil<MerchantsFood> util = new ExcelUtil<MerchantsFood>(MerchantsFood.class);
//        util.exportExcel(response, list, "【菜单】数据");
//    }
//
//    /**
//     * 获取【菜单】详细信息
//     */
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Long id)
//    {
//        return AjaxResult.success(merchantsFoodService.selectMerchantsFoodById(id));
//    }

    /**
     * 新增【菜单】
     */
    @PostMapping
    public AjaxResult add(@RequestParam("avatar") MultipartFile fileUpload,@RequestParam("foodName") String  foodName,
                          @RequestParam("foodPrice") BigDecimal foodPrice)
    {
        Long MerchantsId=2L;
        MerchantsFood merchantsFood = new MerchantsFood();
        merchantsFood.setMerchantsId(MerchantsId);
        merchantsFood.setFoodName(foodName);
        merchantsFood.setFoodPrice(foodPrice);

        return merchantsFoodService.insertMerchantsFood(fileUpload,merchantsFood);
    }

    /**
     * 修改【菜单】
     */
    @PutMapping
    public AjaxResult edit(@RequestBody MerchantsFood merchantsFood)
    {
//        merchantsFood.setMerchantsId(userId);
        return toAjax(merchantsFoodService.updateMerchantsFood(merchantsFood));
    }

    /**
     * 删除【菜单】
     */
	@GetMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        //        merchantsFood.setMerchantsId(userId);
        Long MerchantsId=2L;
        return toAjax(merchantsFoodService.deleteMerchantsFoodByIds(MerchantsId,ids));
    }
}
