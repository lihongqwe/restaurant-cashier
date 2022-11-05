package com.ruoyi.merchants.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.merchants.mapper.MerchantsFoodMapper;
import com.ruoyi.merchants.domain.MerchantsFood;
import com.ruoyi.merchants.service.IMerchantsFoodService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-10-27
 */
@Service
public class MerchantsFoodServiceImpl implements IMerchantsFoodService {
    @Autowired
    private MerchantsFoodMapper merchantsFoodMapper;

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath; //图标图片存储路径

    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath; //图标映射路径


    @Override
    public MerchantsFood selectMerchantsFoodById(Long id) {
        return null;
    }

    /**
     * 查询【菜单】列表
     *
     * @param merchantsFood 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MerchantsFood> selectMerchantsFoodList(MerchantsFood merchantsFood) {
        Long[] foodIds = merchantsFood.getFoodIds();
        List<MerchantsFood> foodList = new ArrayList<>();
        if (foodIds != null) {
            for (Long foodId : foodIds) {
                MerchantsFood food = merchantsFoodMapper.getFoodIds(foodId);
                foodList.add(food);
            }
            return foodList;
        }
        return merchantsFoodMapper.selectMerchantsFoodList(merchantsFood);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMerchantsFood(MultipartFile fileUpload, MerchantsFood merchantsFood) {
        String url = uploadPictures(fileUpload);
        long size = merchantsFoodMapper.selectMerchantsFoodById(SecurityUtils.getUserId()).size()+1;
        merchantsFood.setFoodId(size);
        merchantsFood.setFoodPicture(url);
        return merchantsFoodMapper.insertMerchantsFood(merchantsFood);
    }


    /**
     * 修改【请填写功能名称】
     *
     * @param fileUpload
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMerchantsFood(MultipartFile fileUpload, MerchantsFood merchantsFood) {
        String url = uploadPictures(fileUpload);
        merchantsFood.setFoodPicture(url);
        return merchantsFoodMapper.updateMerchantsFood(merchantsFood);
    }

    public String uploadPictures(MultipartFile fileUpload) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名。
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID() + suffixName;
        fileUpload.getOriginalFilename();
        String url = ProfilePhotoMapperPath + fileName;
        //创建文件夹
        File newPath = new File(ProfilePhotoSavePath, fileName);
        if (!newPath.exists()) {
            newPath.mkdirs();
        }
        try {
            //将图片保存到文件夹里
            fileUpload.transferTo(newPath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return url;
    }


    /**
     * 批量删除【请填写功能名称】
     *
     * @param foodIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsFoodByIds(Long MerchantsId, Long[] foodIds) {
        return merchantsFoodMapper.deleteMerchantsFoodByIds(MerchantsId, foodIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsFoodById(Long id) {
        return merchantsFoodMapper.deleteMerchantsFoodById(id);
    }
}
