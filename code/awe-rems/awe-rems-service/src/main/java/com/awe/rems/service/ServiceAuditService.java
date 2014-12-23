package com.awe.rems.service;

import java.util.List;

import com.awe.rems.domain.ServiceAudit;
import com.awe.rems.domain.query.ServiceAuditQuery;
import com.hbird.common.utils.page.PageUtil;

/**
 * ServiceAuditService接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:15
 * 
 */
public interface ServiceAuditService {

    /**
     * 批量增加对象信息
     * 
     * @param serviceAuditList
     * @return
     */
    public boolean insert(List<ServiceAudit> serviceAuditList);

    /**
     * 单个增加对象信息
     * 
     * @param serviceAudit
     * @return
     */
    public boolean insert(ServiceAudit serviceAudit);

    /**
     * 更新 对象信息
     * 
     * @param serviceAudit
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(ServiceAudit serviceAudit);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<ServiceAudit> queryServiceAuditList(ServiceAuditQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<ServiceAudit> queryServiceAuditListWithPage(ServiceAuditQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param serviceAudit
     *            　
     * @return
     */
    public boolean delete(ServiceAudit serviceAudit);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public ServiceAudit getServiceAuditById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param serviceAudits
     *            ServiceAudit集合
     * @return
     */
    public boolean delete(ServiceAudit[] serviceAudits);
}