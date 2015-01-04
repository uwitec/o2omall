package com.awe.mall.service;

import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * 我的订单列表服务
 * @author zyq
 * @version 1.0.0.0
 * @since 2015-1-4
 */
public interface OrdersService {

	/**
	 * 订单查询服务
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> getOrders(OrdersRequestDto requestDto);
	/**
	 * 获取已下单订单列表
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> queryFrontOrdersListWithPage(OrdersRequestDto requestDto);
	/**
	 * 订单取消
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> cancelOrders(OrdersRequestDto requestDto);
	/**
	 * 删除订单数据
	 * @param requestDto
	 * @return
	 */
	public Wrapper<?> deleteOrders(OrdersRequestDto requestDto);
}
