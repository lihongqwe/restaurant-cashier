package com.ruoyi.web.controller.merchants;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.SecurityUtils;
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
public class MerchantsFoodController extends BaseController {
    @Autowired
    private IMerchantsFoodService merchantsFoodService;

    /**
     * 查询【菜单】列表
     */
    @GetMapping("/list")
    public AjaxResult list(MerchantsFood merchantsFood) {
        //添加商家id
        merchantsFood.setMerchantsId(SecurityUtils.getUserId());
//        merchantsFood.setMerchantsId(106L);
        List<MerchantsFood> list = merchantsFoodService.selectMerchantsFoodList(merchantsFood);
        List<FoodVo> collect = list.stream().map(food -> {
                    FoodVo foodVo = new FoodVo();
                    BeanUtils.copyProperties(food, foodVo);
                    foodVo.setFoodPrice(food.getFoodPrice());
                    return foodVo;
                }
        ).collect(Collectors.toList());
        return AjaxResult.success(collect);
    }
    /**
     * 新增【菜单】
     */
    @PostMapping
    public AjaxResult add(@RequestParam(value = "avatar") MultipartFile fileUpload, @RequestParam("foodName") String foodName,
                          @RequestParam("foodPrice") float foodPrice,@RequestParam("foodType") String foodType ) {
        MerchantsFood merchantsFood = new MerchantsFood();
        merchantsFood.setMerchantsId(SecurityUtils.getUserId());
//        merchantsFood.setMerchantsId();
        merchantsFood.setFoodName(foodName);
        merchantsFood.setFoodPrice(foodPrice);
        merchantsFood.setFoodType(foodType);
        return toAjax(merchantsFoodService.insertMerchantsFood(fileUpload, merchantsFood));
    }

    /**
     * 修改【菜单】
     */
    @PutMapping
    public AjaxResult edit(@RequestParam(value="avatar",required=false) MultipartFile fileUpload, @RequestParam("foodName") String foodName,
                           @RequestParam("foodPrice") float foodPrice,@RequestParam("foodId") Long foodId,@RequestParam("foodType") String foodType) {
        MerchantsFood merchantsFood = new MerchantsFood();
        merchantsFood.setMerchantsId(SecurityUtils.getUserId());
//        merchantsFood.setMerchantsId();107
        merchantsFood.setFoodName(foodName);
        merchantsFood.setFoodPrice(foodPrice);
        merchantsFood.setFoodId(foodId);
        merchantsFood.setFoodType(foodType);
        return toAjax(merchantsFoodService.updateMerchantsFood(fileUpload,merchantsFood));
    }

    /**
     * 删除【菜单】
     */
    @GetMapping("/{foodIds}")
    public AjaxResult remove(@PathVariable Long[] foodIds) {
        return toAjax(merchantsFoodService.deleteMerchantsFoodByIds(SecurityUtils.getUserId(), foodIds));
    }
}
