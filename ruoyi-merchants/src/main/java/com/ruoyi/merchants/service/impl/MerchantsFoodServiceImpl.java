package com.ruoyi.merchants.service.impl;

import java.io.File;
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
//    public AjaxResult insertMerchantsFood(MultipartFile fileUpload)
    {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;
        fileUpload.getOriginalFilename();
        try {
            String url=ProfilePhotoMapperPath+fileName;
            if(insertMerchantsFood(url,merchantsFood)==1){
                //将图片保存到文件夹里
                fileUpload.transferTo(new File(ProfilePhotoSavePath+fileName));
                return AjaxResult.success("上传成功");
            }
            return AjaxResult.error("上传失败!!!");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("上传失败!!!");
        }
    }

    public  int insertMerchantsFood(String url,MerchantsFood merchantsFood)
    {
        merchantsFood.setFoodPicture(url);
        long size = merchantsFoodMapper.selectMerchantsFoodList(merchantsFood).size();
        merchantsFood.setFoodId(size+1);
        return merchantsFoodMapper.insertMerchantsFood(merchantsFood);
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
