package com.awe.pms.domain;

import java.util.Date;

/**
 * BusinessInfo：商家信息实体类
 * 
 * @author ljz
 * @version 2014-12-30 16:41:48
 * 
 */
public class BusinessInfo implements java.io.Serializable {

    /** 序列化标识 */
	private static final long serialVersionUID = 1L;
	
    /** 主键 */
    private Long id; 
    /** 商家编号 */
    private String businessNo; 
    /** 商家名称 */
    private String businessName; 
    /** 商家英文名称 */
    private String enName; 
    /** 名称缩写 */
    private String businessAbbr; 
    /** 类型（国内、进口） */
    private Integer type; 
    /** 类型名称 */
    private String typeName; 
    /** 一级分类 */
    private Long categoryOneId; 
    /** 一级分类名称 */
    private String categoryOne; 
    /** 二级分类 */
    private Long categoryTwoId; 
    /** 二级分类名称 */
    private String categoryTwo; 
    /** 三级分类 */
    private Long categoryThreeId; 
    /** 三级分类名称 */
    private String categoryThree; 
    /** 地区-省份-名称 */
    private String provinceName; 
    /** 地区-省份-编号 */
    private String provinceNo; 
    /** 地区-市-名称 */
    private String cityName; 
    /** 地区-市-编号 */
    private String cityNo; 
    /** 地区-县-名称 */
    private String countyName; 
    /** 地区-县-编号 */
    private String countyNo; 
    /** 联系人 */
    private String contactor; 
    /** 手机 */
    private String mobilePhone; 
    /** 联系人电话 */
    private String telePhone; 
    /** 地址 */
    private String address; 
    /** 邮编 */
    private String postCode; 
    /** 描述 */
    private String features; 
    /** 备注 */
    private String remark; 
    /** 审核状态 */
    private Integer checkStatus; 
    /** 入驻时间 */
    private Date enterTime; 
    /** 有效合同开始时间 */
    private Date contractTimeStart; 
    /** 有效合同结束时间 */
    private Date contractTimeEnd; 
    /** 商家级别 */
    private Integer level; 
    /** 是否有证件 */
    private Integer hasCard; 
    /** 法定人身份证（图片地址） */
    private String legalPerson; 
    /** 公司注册信息（扫描件） */
    private String companyRegister; 
    /** 保证金 */
    private Double earnestMoney; 
    /** 信用等级 */
    private Integer creditLevel; 
    /** 信用额度 */
    private Double creditLimit; 
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
     * get 商家编号
     * 
     * @return the businessNo
     */
    public String getBusinessNo(){
        return businessNo;
    }
        
    /**
     * set 商家编号
     * 
     * @param businessNo the businessNo to set
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }
    
    /**
     * get 商家名称
     * 
     * @return the businessName
     */
    public String getBusinessName(){
        return businessName;
    }
        
    /**
     * set 商家名称
     * 
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    
    /**
     * get 商家英文名称
     * 
     * @return the enName
     */
    public String getEnName(){
        return enName;
    }
        
    /**
     * set 商家英文名称
     * 
     * @param enName the enName to set
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }
    
    /**
     * get 名称缩写
     * 
     * @return the businessAbbr
     */
    public String getBusinessAbbr(){
        return businessAbbr;
    }
        
    /**
     * set 名称缩写
     * 
     * @param businessAbbr the businessAbbr to set
     */
    public void setBusinessAbbr(String businessAbbr) {
        this.businessAbbr = businessAbbr;
    }
    
    /**
     * get 类型（国内、进口）
     * 
     * @return the type
     */
    public Integer getType(){
        return type;
    }
        
    /**
     * set 类型（国内、进口）
     * 
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }
    
    /**
     * get 类型名称
     * 
     * @return the typeName
     */
    public String getTypeName(){
        return typeName;
    }
        
    /**
     * set 类型名称
     * 
     * @param typeName the typeName to set
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    /**
     * get 一级分类
     * 
     * @return the categoryOneId
     */
    public Long getCategoryOneId(){
        return categoryOneId;
    }
        
    /**
     * set 一级分类
     * 
     * @param categoryOneId the categoryOneId to set
     */
    public void setCategoryOneId(Long categoryOneId) {
        this.categoryOneId = categoryOneId;
    }
    
    /**
     * get 一级分类名称
     * 
     * @return the categoryOne
     */
    public String getCategoryOne(){
        return categoryOne;
    }
        
    /**
     * set 一级分类名称
     * 
     * @param categoryOne the categoryOne to set
     */
    public void setCategoryOne(String categoryOne) {
        this.categoryOne = categoryOne;
    }
    
    /**
     * get 二级分类
     * 
     * @return the categoryTwoId
     */
    public Long getCategoryTwoId(){
        return categoryTwoId;
    }
        
    /**
     * set 二级分类
     * 
     * @param categoryTwoId the categoryTwoId to set
     */
    public void setCategoryTwoId(Long categoryTwoId) {
        this.categoryTwoId = categoryTwoId;
    }
    
    /**
     * get 二级分类名称
     * 
     * @return the categoryTwo
     */
    public String getCategoryTwo(){
        return categoryTwo;
    }
        
    /**
     * set 二级分类名称
     * 
     * @param categoryTwo the categoryTwo to set
     */
    public void setCategoryTwo(String categoryTwo) {
        this.categoryTwo = categoryTwo;
    }
    
    /**
     * get 三级分类
     * 
     * @return the categoryThreeId
     */
    public Long getCategoryThreeId(){
        return categoryThreeId;
    }
        
    /**
     * set 三级分类
     * 
     * @param categoryThreeId the categoryThreeId to set
     */
    public void setCategoryThreeId(Long categoryThreeId) {
        this.categoryThreeId = categoryThreeId;
    }
    
    /**
     * get 三级分类名称
     * 
     * @return the categoryThree
     */
    public String getCategoryThree(){
        return categoryThree;
    }
        
    /**
     * set 三级分类名称
     * 
     * @param categoryThree the categoryThree to set
     */
    public void setCategoryThree(String categoryThree) {
        this.categoryThree = categoryThree;
    }
    
    /**
     * get 地区-省份-名称
     * 
     * @return the provinceName
     */
    public String getProvinceName(){
        return provinceName;
    }
        
    /**
     * set 地区-省份-名称
     * 
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    
    /**
     * get 地区-省份-编号
     * 
     * @return the provinceNo
     */
    public String getProvinceNo(){
        return provinceNo;
    }
        
    /**
     * set 地区-省份-编号
     * 
     * @param provinceNo the provinceNo to set
     */
    public void setProvinceNo(String provinceNo) {
        this.provinceNo = provinceNo;
    }
    
    /**
     * get 地区-市-名称
     * 
     * @return the cityName
     */
    public String getCityName(){
        return cityName;
    }
        
    /**
     * set 地区-市-名称
     * 
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    /**
     * get 地区-市-编号
     * 
     * @return the cityNo
     */
    public String getCityNo(){
        return cityNo;
    }
        
    /**
     * set 地区-市-编号
     * 
     * @param cityNo the cityNo to set
     */
    public void setCityNo(String cityNo) {
        this.cityNo = cityNo;
    }
    
    /**
     * get 地区-县-名称
     * 
     * @return the countyName
     */
    public String getCountyName(){
        return countyName;
    }
        
    /**
     * set 地区-县-名称
     * 
     * @param countyName the countyName to set
     */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    
    /**
     * get 地区-县-编号
     * 
     * @return the countyNo
     */
    public String getCountyNo(){
        return countyNo;
    }
        
    /**
     * set 地区-县-编号
     * 
     * @param countyNo the countyNo to set
     */
    public void setCountyNo(String countyNo) {
        this.countyNo = countyNo;
    }
    
    /**
     * get 联系人
     * 
     * @return the contactor
     */
    public String getContactor(){
        return contactor;
    }
        
    /**
     * set 联系人
     * 
     * @param contactor the contactor to set
     */
    public void setContactor(String contactor) {
        this.contactor = contactor;
    }
    
    /**
     * get 手机
     * 
     * @return the mobilePhone
     */
    public String getMobilePhone(){
        return mobilePhone;
    }
        
    /**
     * set 手机
     * 
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    /**
     * get 联系人电话
     * 
     * @return the telePhone
     */
    public String getTelePhone(){
        return telePhone;
    }
        
    /**
     * set 联系人电话
     * 
     * @param telePhone the telePhone to set
     */
    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }
    
    /**
     * get 地址
     * 
     * @return the address
     */
    public String getAddress(){
        return address;
    }
        
    /**
     * set 地址
     * 
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * get 邮编
     * 
     * @return the postCode
     */
    public String getPostCode(){
        return postCode;
    }
        
    /**
     * set 邮编
     * 
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
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
     * get 备注
     * 
     * @return the remark
     */
    public String getRemark(){
        return remark;
    }
        
    /**
     * set 备注
     * 
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * get 审核状态
     * 
     * @return the checkStatus
     */
    public Integer getCheckStatus(){
        return checkStatus;
    }
        
    /**
     * set 审核状态
     * 
     * @param checkStatus the checkStatus to set
     */
    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
    
    /**
     * get 入驻时间
     * 
     * @return the enterTime
     */
    public Date getEnterTime(){
        return enterTime;
    }
        
    /**
     * set 入驻时间
     * 
     * @param enterTime the enterTime to set
     */
    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }
    
    /**
     * get 有效合同开始时间
     * 
     * @return the contractTimeStart
     */
    public Date getContractTimeStart(){
        return contractTimeStart;
    }
        
    /**
     * set 有效合同开始时间
     * 
     * @param contractTimeStart the contractTimeStart to set
     */
    public void setContractTimeStart(Date contractTimeStart) {
        this.contractTimeStart = contractTimeStart;
    }
    
    /**
     * get 有效合同结束时间
     * 
     * @return the contractTimeEnd
     */
    public Date getContractTimeEnd(){
        return contractTimeEnd;
    }
        
    /**
     * set 有效合同结束时间
     * 
     * @param contractTimeEnd the contractTimeEnd to set
     */
    public void setContractTimeEnd(Date contractTimeEnd) {
        this.contractTimeEnd = contractTimeEnd;
    }
    
    /**
     * get 商家级别
     * 
     * @return the level
     */
    public Integer getLevel(){
        return level;
    }
        
    /**
     * set 商家级别
     * 
     * @param level the level to set
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    /**
     * get 是否有证件
     * 
     * @return the hasCard
     */
    public Integer getHasCard(){
        return hasCard;
    }
        
    /**
     * set 是否有证件
     * 
     * @param hasCard the hasCard to set
     */
    public void setHasCard(Integer hasCard) {
        this.hasCard = hasCard;
    }
    
    /**
     * get 法定人身份证（图片地址）
     * 
     * @return the legalPerson
     */
    public String getLegalPerson(){
        return legalPerson;
    }
        
    /**
     * set 法定人身份证（图片地址）
     * 
     * @param legalPerson the legalPerson to set
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
    
    /**
     * get 公司注册信息（扫描件）
     * 
     * @return the companyRegister
     */
    public String getCompanyRegister(){
        return companyRegister;
    }
        
    /**
     * set 公司注册信息（扫描件）
     * 
     * @param companyRegister the companyRegister to set
     */
    public void setCompanyRegister(String companyRegister) {
        this.companyRegister = companyRegister;
    }
    
    /**
     * get 保证金
     * 
     * @return the earnestMoney
     */
    public Double getEarnestMoney(){
        return earnestMoney;
    }
        
    /**
     * set 保证金
     * 
     * @param earnestMoney the earnestMoney to set
     */
    public void setEarnestMoney(Double earnestMoney) {
        this.earnestMoney = earnestMoney;
    }
    
    /**
     * get 信用等级
     * 
     * @return the creditLevel
     */
    public Integer getCreditLevel(){
        return creditLevel;
    }
        
    /**
     * set 信用等级
     * 
     * @param creditLevel the creditLevel to set
     */
    public void setCreditLevel(Integer creditLevel) {
        this.creditLevel = creditLevel;
    }
    
    /**
     * get 信用额度
     * 
     * @return the creditLimit
     */
    public Double getCreditLimit(){
        return creditLimit;
    }
        
    /**
     * set 信用额度
     * 
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
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
