package com.awe.order.manager;

import java.util.List;

import com.awe.order.domain.OrderLog;
import com.awe.order.domain.query.OrderLogQuery;
import com.hbird.common.utils.page.PageUtil;
/**
 * OrderLogManager接口
 * 
 * @author ljz
 * @version 2014-12-23 10:06:36
 * 
 */
public interface OrderLogManager {

    /**
     * 批量增加对象信息
     * 
     * @param orderLogList
     * @return
     */
    public boolean insert(List<OrderLog> orderLogList);

    /**
     * 单个增加对象信息
     * 
     * @param orderLog
     * @return
     */
    public boolean insert(OrderLog orderLog);

    /**
     * 更新 对象信息
     * 
     * @param orderLog
     *            对象信息对象
     * @return false：失败 true：成功
     */
    public boolean update(OrderLog orderLog);

    /**
     * 根据查询Bean获取对象集合，无翻页
     * 
     * @param queryBean
     * @return
     */
    public List<OrderLog> queryOrderLogList(OrderLogQuery queryBean);

    /**
     * 根据查询Bean获取对象集合，带翻页
     * 
     * @param queryBean
     * @param pageUtil
     * @return
     */
    public List<OrderLog> queryOrderLogListWithPage(OrderLogQuery queryBean,
            PageUtil pageUtil);

    /**
     * 根据查询Bean获取对象信息总数
     * 
     * @param queryBean
     *            对象信息查询对象
     * @return 对象信息总数
     */
    public int queryOrderLogCount(OrderLogQuery queryBean);

    /**
     * 根据主键删除对象信息，该处做的是逻辑删除
     * 
     * @param orderLog
     *            　
     * @return
     */
    public boolean delete(OrderLog orderLog);

    /**
     * 根据主键获取对象信息
     * 
     * @param id
     *            主键字段
     * @return 对象信息
     */
    public OrderLog getOrderLogById(Long id);

    /**
     * 根据主键集合批量删除对象信息，该处做的是逻辑删除
     * 
     * @param orderLogs
     *            OrderLog集合
     * @return
     */
    public boolean delete(OrderLog[] orderLogs);

    /**
     * 判断是否存在
     * 
     * @param orderLog
     * @return
     */
    public boolean exist(OrderLog orderLog);
}