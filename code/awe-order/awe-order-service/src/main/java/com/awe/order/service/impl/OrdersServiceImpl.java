package com.awe.order.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.perf4j.aop.Profiled;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awe.order.domain.OrderDetails;
import com.awe.order.domain.OrderLog;
import com.awe.order.domain.Orders;
import com.awe.order.domain.OrdersItems;
import com.awe.order.domain.query.FrontOrdersQuery;
import com.awe.order.domain.query.OrdersQuery;
import com.awe.order.dto.OrdersDto;
import com.awe.order.manager.OrdersManager;
import com.awe.order.sdk.api.response.dto.OrdersResponseDto;
import com.awe.order.service.OrdersService;
import com.awe.order.service.helper.OrdersComparator;
import com.awe.order.utils.exceptions.ExistedException;
import com.awe.order.utils.exceptions.OrderCodeUtil;
import com.awe.pms.sdk.ProductClient;
import com.awe.pms.sdk.request.dto.ProductSkuRequestDto;
import com.awe.pms.sdk.response.dto.ProductResponseDto;
import com.awe.pms.sdk.response.dto.ProductSkuResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * OrdersService接口的实现类
 * 
 * @author ljz
 * @version 2014-12-23 10:58:06
 * 
 */
@Service
@SuppressWarnings("all")
public class OrdersServiceImpl implements OrdersService {

	/** LOG */
	private static final Log LOG = LogFactory.getLog(OrdersServiceImpl.class);

	@Autowired
	private OrdersManager ordersManager;
	@Autowired
	private ProductClient productClient;

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.batchInsert")
	public boolean insert(List<Orders> ordersList) {
		boolean resultFlag = false;
		try {
			if (CollectionUtils.isNotEmpty(ordersList)) {
				resultFlag = ordersManager.insert(ordersList);
			} else {
				LOG.warn("OrdersServiceImpl#batchInsert failed, param is illegal.");
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#batchInsert has error.", e);
		}
		return resultFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.insert")
	public boolean insert(Orders orders) {
		boolean resultFlag = false;
		try {
			if (null != orders) {
				// 1:查询有效的订单好是否在订单表中
				if (ordersManager.exist(orders)) {
					throw new ExistedException();
				}
				resultFlag = ordersManager.insert(orders);

			} else {
				LOG.warn("OrdersServiceImpl#insert failed, param is illegal.");
			}
		} catch (ExistedException e) {
			LOG.warn("OrdersServiceImpl#insert failed, orders has existed.");
			throw e;
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#insert has error.", e);
		}
		return resultFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.update")
	public boolean update(Orders orders) {
		boolean resultFlag = false;
		try {
			if (null != orders && null != orders.getOrderNo()) {
				resultFlag = ordersManager.update(orders);
			} else {
				LOG.warn("OrdersServiceImpl#update failed, param is illegal.");
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#update has error.", e);
		}
		return resultFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.queryOrdersList")
	public List<Orders> queryOrdersList(OrdersQuery queryBean) {
		List<Orders> ordersList = null;
		try {
			ordersList = ordersManager.queryOrdersList(queryBean);
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#queryOrdersList has error.", e);
		}
		return ordersList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.queryOrdersListWithPage")
	public List<Orders> queryOrdersListWithPage(OrdersQuery queryBean, PageUtil pageUtil) {
		List<Orders> ordersList = null;
		try {
			ordersList = ordersManager.queryOrdersListWithPage(queryBean, pageUtil);
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#queryOrdersListWithPage has error.", e);
		}
		return ordersList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.delete")
	public boolean delete(Orders orders) {
		boolean resultFlag = false;
		try {
			if (null != orders && null != orders.getId()) {
				resultFlag = ordersManager.delete(orders);
			} else {
				LOG.warn("OrdersServiceImpl#delete param is illegal.");
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#delete has error.", e);
		}
		return resultFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.batchDelete")
	public boolean delete(Orders[] orderss) {
		boolean resultFlag = false;
		try {
			if (null != orderss && orderss.length > 0) {
				resultFlag = ordersManager.delete(orderss);
			} else {
				LOG.warn("OrdersServiceImpl#batchDelete failed, param is illegal.");
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#batchDelete has error.", e);
		}
		return resultFlag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.getOrdersById")
	public Orders getOrdersById(Long id) {
		Orders orders = null;
		try {
			if (null != id) {
				orders = ordersManager.getOrdersById(id);
			} else {
				LOG.warn("OrdersServiceImpl#getOrdersById failed, param is illegal.");
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#getOrdersById has error.", e);
		}
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.getOrdersByOrderNO")
	public Orders getOrdersByOrderNO(String orderNo) {
		Orders orders = null;
		try {
			if (null != orderNo) {
				orders = ordersManager.getOrdersByOrderNO(orderNo);
			} else {
				LOG.warn("OrdersServiceImpl#getOrdersByOrderNO failed, param is illegal.");
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#getOrdersByOrderNO has error.", e);
		}
		return orders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.queryFrontOrdersListWithPage")
	public List<Orders> queryFrontOrdersListWithPage(FrontOrdersQuery queryBean, PageUtil pageUtil) {
		List<OrdersDto> ordersDtoList = null;
		List<Orders> dataList = new ArrayList<Orders>();
		Orders orders = null;
		OrdersItems ordersItems = null;
		List<OrdersItems> ordersItemsList = null;
		List<OrdersItems> tempList = null;
		boolean isOtherOrder = false;
		try {
			ordersDtoList = ordersManager.queryFrontOrdersListWithPage(queryBean, pageUtil);
			Collections.sort(ordersDtoList, new OrdersComparator());// 按订单号排序
			for (OrdersDto ordersDto : ordersDtoList) {
				if (null == orders || !ordersDto.getOrderNo().equals(orders.getOrderNo())) {
					orders = new Orders();
					BeanUtils.copyProperties(ordersDto, orders);
					ordersItemsList = new ArrayList<OrdersItems>();
					isOtherOrder = true;
				}
				ordersItems = new OrdersItems();
				BeanUtils.copyProperties(ordersDto, ordersItems);
				ordersItemsList.add(ordersItems);
				if (!isOtherOrder) {
					tempList = ordersItemsList;
					orders.setOrdersItemsList(tempList);
					dataList.add(orders);
				}
				isOtherOrder = false;
			}

		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#queryFrontOrdersListWithPage has error.", e);
		}
		return dataList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.insertDetails")
	public Wrapper<?> insertDetails(Orders orders, Map<String, String> mapSC, String ip) {
		boolean resultFlag = false;
		// 调用恒冲商品接口对象
		ProductSkuRequestDto skuRequestDto = new ProductSkuRequestDto();
		// 把skuno封装到list中
		List<String> skunos = new ArrayList<String>();
		for (String key : mapSC.keySet()) {
			skunos.add(key);
		}
		skuRequestDto.setSkuNos(skunos);
		try {
			// zhc商品信息
			List<ProductResponseDto> responseDtos = productClient.getProductBySkuNos(skuRequestDto);
			List<OrdersResponseDto> ordersResponseDtos = new ArrayList<OrdersResponseDto>();
			Map<String, OrdersResponseDto> mapList = new HashMap<String, OrdersResponseDto>();
			for (ProductResponseDto productResponseDto : responseDtos) {
				String key = productResponseDto.getBusinessNo() + "_" + productResponseDto.getCategoryOneId();
				if (mapList.containsKey(key)) {
					// 虚拟商品
					mapList.get(key).getOrdersItemsList().add(toOrdersItems(productResponseDto, mapSC));
				} else {
					// 订单基本信息
					OrdersResponseDto dto = new OrdersResponseDto();
					BeanUtils.copyProperties(orders, dto);
					// 订单基本信息
					int orderType = productResponseDto.getCategoryOneId() == 10 ? 100 : 200;
					dto.setOrderType(orderType);// type=100虚拟商品 //type=200实物
					dto.setOrderNo(OrderCodeUtil.CodeUtil(ip));// 创建订单号
					dto.setSeller(productResponseDto.getProductSkuResponseDtos().get(0).getBusinessName());// 商家名称
					dto.setSellerNo(productResponseDto.getProductSkuResponseDtos().get(0).getBusinessNo());// 商家编号
					List<OrdersItems> dtos = new ArrayList<OrdersItems>();
					dtos.add(toOrdersItems(productResponseDto, mapSC));
					dto.setOrdersItemsList(dtos);
					mapList.put(key, dto);
				}
			}
			// 计算每个订单的价格
			double totalPrice = 0.0;
			for (String key : mapList.keySet()) {
				// 订单总价格
				double countPrice = 0.0;
				OrdersResponseDto orderDto = mapList.get(key);
				List<OrdersItems> listItem = orderDto.getOrdersItemsList();
				for (OrdersItems ordersItems : listItem) {
					ordersItems.setOrderNo(orderDto.getOrderNo());
					countPrice += ordersItems.getCount() * ordersItems.getSkuPrice();
				}
				totalPrice += countPrice;
				orderDto.setCommAmount(countPrice);
			}
			// 开始插入订单
			List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
			List<OrdersItems> listItems = new ArrayList<OrdersItems>();// 订单商品
			Map<String, Double> orderMessageMap = new HashMap<String, Double>();// 存放訂單和訂單的價格
			for (String key : mapList.keySet()) {
				Orders o = new Orders();// 订单基本信息
				OrderLog log = new OrderLog();// 订单日志
				OrderDetails details = null;
				if (mapList.get(key) != null) {
					OrdersResponseDto orderDto = mapList.get(key);
					List<OrdersItems> listItem = orderDto.getOrdersItemsList();// 订单商品
					BeanUtils.copyProperties(orderDto, o);// 订单基本信息
					// 订单日志
					log.setOrderNo(o.getOrderNo());// 订单号
					log.setStatus(o.getOrderStatus());// 状态
					log.setStatusName("待付款");// 状态
					log.setCreateUser(o.getCreateUser());// 创建姓名
					for (OrdersItems ordersItems : listItem) {
						OrdersItems items = new OrdersItems();
						BeanUtils.copyProperties(ordersItems, items);
						listItems.add(items);
					}
					details = new OrderDetails(o, listItems, log);
				}
				orderMessageMap.put(o.getOrderNo(), o.getCommAmount());
				orderDetails.add(details);
			}
			resultFlag = ordersManager.insertDetails(orderDetails);
			if (resultFlag) {
				return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, orderMessageMap);
			} else {
				return WrapMapper.wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#insert has error.", e);
		}
		return WrapMapper.error();
	}

	private OrdersItems toOrdersItems(ProductResponseDto productResponseDto, Map<String, String> mapSC) {
		OrdersItems items = new OrdersItems();
		List<ProductSkuResponseDto> listPsku = productResponseDto.getProductSkuResponseDtos();
		BeanUtils.copyProperties(listPsku.get(0), items);
		items.setImgUrl(listPsku.get(0).getImgPath());
		items.setSkuPrice(listPsku.get(0).getSalePrice());
		items.setFinalPrice(listPsku.get(0).getSalePrice());
		if (mapSC.containsKey(items.getSkuNo())) {
			items.setCount(Integer.valueOf(mapSC.get(items.getSkuNo())));
		}
		return items;
	}

	/**
	 * {@inheritDoc}
	 */
	@Profiled(tag = "OrdersService.cancelOrders")
	public boolean cancelOrders(Orders orders) {
		boolean resultFlag = false;
		try {
			resultFlag = ordersManager.cancelOrders(orders);
		} catch (Exception e) {
			LOG.error("OrdersServiceImpl#cancelOrders has error.", e);
		}
		return resultFlag;

	}
}
