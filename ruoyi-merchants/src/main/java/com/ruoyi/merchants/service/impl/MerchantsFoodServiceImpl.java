package com.ruoyi.merchants.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.AjaxResult;
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
public class MerchantsFoodServiceImpl implements IMerchantsFoodService 
{
    @Autowired
    private MerchantsFoodMapper merchantsFoodMapper;

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath; //图标图片存储路径

    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath; //图标映射路径


    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public MerchantsFood selectMerchantsFoodById(Long id)
    {
        return merchantsFoodMapper.selectMerchantsFoodById(id);
    }

    /**
     * 查询【菜单】列表
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MerchantsFood> selectMerchantsFoodList(MerchantsFood merchantsFood)
    {
        return merchantsFoodMapper.selectMerchantsFoodList(merchantsFood);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    @Override
    public AjaxResult insertMerchantsFood(MultipartFile fileUpload, MerchantsFood merchantsFood)
    {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名。
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;
        fileUpload.getOriginalFilename();
        String url=ProfilePhotoMapperPath+fileName;
        merchantsFood.setFoodPicture(url);
        //创建文件夹
        File newPath =new File(ProfilePhotoSavePath,fileName);
        if(!newPath.exists()){
            newPath.mkdirs();
        }
        try {
            //将图片保存到文件夹里
            fileUpload.transferTo(newPath);
            //将数据存如数据库
            insertMerchantsFood(merchantsFood);
            return AjaxResult.error("上传成功!!!");
            } catch (IOException ex) {
            ex.printStackTrace();
        }
        return AjaxResult.error("上传失败!!!");
        }
    public  int insertMerchantsFood(MerchantsFood merchantsFood)
    {
        MerchantsFood food = new MerchantsFood();
        food.setMerchantsId(merchantsFood.getMerchantsId());
        long size = merchantsFoodMapper.selectMerchantsFoodList(food).size();

        merchantsFood.setFoodId(size+1);
        return merchantsFoodMapper.insertMerchantsFood(merchantsFood);
//        return 1;
    }


    /**
     * 修改【请填写功能名称】
     * 
     * @param merchantsFood 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMerchantsFood(MerchantsFood merchantsFood)
    {
        return merchantsFoodMapper.updateMerchantsFood(merchantsFood);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param foodIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsFoodByIds(Long MerchantsId,Long[] foodIds)
    {
        return merchantsFoodMapper.deleteMerchantsFoodByIds(MerchantsId,foodIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteMerchantsFoodById(Long id)
    {
        return merchantsFoodMapper.deleteMerchantsFoodById(id);
    }
}
