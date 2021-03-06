package com.awe.pms.sdk.api.response.dto;

import com.hbird.common.sdk.api.dto.HbirdDto;
import java.util.Date;

/**
 * SkuImagesResponseDto：sku图片返回对象Dto<br/>
 * 提供rest接口时方法的返回对象
 * 
 * @author ljz
 * @version 2014-12-25 14:47:30
 * 
 */
public class SkuImagesResponseDto extends HbirdDto {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;
    
    /** 主键 */
    private Long id; 
    /** sku编号 */
    private String skuNo; 
    /** 图片类型 */
    private Integer imgType; 
    /** 图片路径 */
    private String imgPath; 
    /**
     * 小图路径
     */
    private String imgPathLetter;
    /** 是否主图 */
    private Integer isPrimaryPath; 
    /** 描述 */
    private String features; 
    /** 优先级 */
    private Integer priority; 
    /** 创建时间 */
    private Date createTime; 
    /** 修改时间 */
    private Date updateTime; 
    /** 创建人 */
    private String createUser; 
    /** 修改人 */
    private String updateUser; 
    /** 是否有效 */
    private Integer yn; 
    
    /**
     * get 主键
     * 
     * @return the id
     */
    public Long getId(){
        return id;
    }
        
    /**
     * set 主键
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * get sku编号
     * 
     * @return the skuNo
     */
    public String getSkuNo(){
        return skuNo;
    }
        
    /**
     * set sku编号
     * 
     * @param skuNo the skuNo to set
     */
    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }
    
    /**
     * get 图片类型
     * 
     * @return the imgType
     */
    public Integer getImgType(){
        return imgType;
    }
        
    /**
     * set 图片类型
     * 
     * @param imgType the imgType to set
     */
    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
    
    /**
     * get 图片路径
     * 
     * @return the imgPath
     */
    public String getImgPath(){
        return imgPath;
    }
        
    /**
     * set 图片路径
     * 
     * @param imgPath the imgPath to set
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    /**
	 * @return the imgPathLetter
	 */
	public String getImgPathLetter() {
		return imgPathLetter;
	}

	/**
	 * @param imgPathLetter the imgPathLetter to set
	 */
	public void setImgPathLetter(String imgPathLetter) {
		this.imgPathLetter = imgPathLetter;
	}

	/**
     * get 是否主图
     * 
     * @return the isPrimaryPath
     */
    public Integer getIsPrimaryPath(){
        return isPrimaryPath;
    }
        
    /**
     * set 是否主图
     * 
     * @param isPrimaryPath the isPrimaryPath to set
     */
    public void setIsPrimaryPath(Integer isPrimaryPath) {
        this.isPrimaryPath = isPrimaryPath;
    }
    
    /**
     * get 描述
     * 
     * @return the features
     */
    public String getFeatures(){
        return features;
    }
        
    /**
     * set 描述
     * 
     * @param features the features to set
     */
    public void setFeatures(String features) {
        this.features = features;
    }
    
    /**
     * get 优先级
     * 
     * @return the priority
     */
    public Integer getPriority(){
        return priority;
    }
        
    /**
     * set 优先级
     * 
     * @param priority the priority to set
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    
    /**
     * get 创建时间
     * 
     * @return the createTime
     */
    public Date getCreateTime(){
        return createTime;
    }
        
    /**
     * set 创建时间
     * 
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * get 修改时间
     * 
     * @return the updateTime
     */
    public Date getUpdateTime(){
        return updateTime;
    }
        
    /**
     * set 修改时间
     * 
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    /**
     * get 创建人
     * 
     * @return the createUser
     */
    public String getCreateUser(){
        return createUser;
    }
        
    /**
     * set 创建人
     * 
     * @param createUser the createUser to set
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
    /**
     * get 修改人
     * 
     * @return the updateUser
     */
    public String getUpdateUser(){
        return updateUser;
    }
        
    /**
     * set 修改人
     * 
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
    
    /**
     * get 是否有效
     * 
     * @return the yn
     */
    public Integer getYn(){
        return yn;
    }
        
    /**
     * set 是否有效
     * 
     * @param yn the yn to set
     */
    public void setYn(Integer yn) {
        this.yn = yn;
    }
}
