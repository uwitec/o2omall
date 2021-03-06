package com.awe.mall.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awe.mall.controller.base.BaseController;
import com.awe.mall.service.OrdersService;
import com.awe.order.enums.EnumOrderStauts;
import com.awe.order.enums.EnumPayType;
import com.awe.order.sdk.request.dto.OrdersRequestDto;
import com.awe.order.sdk.response.dto.OrdersResponseDto;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.web.context.UserContext;
/**
 * @description 我的订单
 * @author zyq
 * @date 2014-12-30
 * @version 1.0.0
 */
@Controller
@RequestMapping("myorder")
public class MyOrderController extends BaseController {

	private static final Log LOG = LogFactory.getLog(MyOrderController.class);
	
	private static final String VIEW_WORKSPACE = "myorder/";
	private static final String VIEW_PRODUCT_ORDER_LIST_PAGE = "productOrderList";
	private static final String VIEW_SERVICE_ORDER_LIST_PAGE = "serviceOrderList";
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("productorderlist")
	public String productOrderList(Model model, PageUtil page, OrdersRequestDto requestDto){
		LOG.info("-- welcome to productOrderList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
		model.addAttribute("leftFlag", "productorderlist");//我的订单-左边菜单标志
		List<OrdersResponseDto> dataList = null;
		try {
			requestDto.setOrderType(100);
			requestDto.setUserId(UserContext.get().getUserId());
			dataList = ordersService.queryFrontOrdersListWithPage(requestDto, page);
			if(null == dataList){
				dataList = new ArrayList<OrdersResponseDto>();
			}
			model.addAttribute("PayTypeMap",EnumPayType.getMap());
			LOG.info("#####" + EnumPayType.getMap().get("1"));
			model.addAttribute("OrderStautsMap", EnumOrderStauts.getMap());
			LOG.info("@@@@" + EnumOrderStauts.getMap().get("60"));
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			LOG.error("#MyOrderController.productOrderList#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_PRODUCT_ORDER_LIST_PAGE;
	}
	
	@RequestMapping("serviceorderlist")
	public String serviceOrderList(Model model,PageUtil page,OrdersRequestDto requestDto){
		LOG.info("-- welcome to serviceOrderList index --");
        model.addAttribute("navFlag", "member"); // 页面主要导航标识，‘我的‘
        model.addAttribute("leftFlag", "serviceorderlist");//我的订单-左边菜单标志
        List<OrdersResponseDto> dataList = null;
		try {
			requestDto.setOrderType(200);
			requestDto.setUserId(UserContext.get().getUserId());
			dataList = ordersService.queryFrontOrdersListWithPage(requestDto, page);
			if(null == dataList){
				dataList = new ArrayList<OrdersResponseDto>();
			}
			model.addAttribute("PayTypeMap",EnumPayType.getMap());
			LOG.info("#####" + EnumPayType.getMap().get("1"));
			model.addAttribute("OrderStautsMap", EnumOrderStauts.getMap());
			LOG.info("@@@@" + EnumOrderStauts.getMap().get("60"));
			model.addAttribute("dataList", dataList);
		} catch (Exception e) {
			LOG.error("#MyOrderController.serviceOrderList#Fail:::" + e);
		}
		return VIEW_WORKSPACE + VIEW_SERVICE_ORDER_LIST_PAGE;
	}
}
