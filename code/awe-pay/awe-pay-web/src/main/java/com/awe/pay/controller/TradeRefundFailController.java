package com.awe.pay.controller;
   

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awe.pay.controller.base.BaseController;
import com.awe.pay.domain.TradeRefundFail;
import com.awe.pay.domain.query.TradeRefundFailQuery;
import com.awe.pay.service.TradeRefundFailService;
import com.awe.pay.utils.exceptions.ExistedException;
import com.hbird.common.utils.page.PageUtil;
import com.hbird.common.utils.wrap.WrapMapper;
import com.hbird.common.utils.wrap.Wrapper;

/**
 * TradeRefundFailController ：正向交易及逆向退款失败表控制器
 * 
 * @author ljz
 * @version 2014-12-23 10:06:27
*/
@Controller
@RequestMapping("tradeRefundFail")
public class TradeRefundFailController extends BaseController {

    @Autowired
    private TradeRefundFailService tradeRefundFailService;

    /** 视图前缀 */
    private static final String viewPrefix ="tradeRefundFail";
    
    private static final Log LOG = LogFactory.getLog(TradeRefundFailController.class);

    /**
     * 分页 查询数据
     * 
     * @param model
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "")
    public String index(Model model, PageUtil page, TradeRefundFailQuery query) {
        try {
            List<TradeRefundFail> dataList = tradeRefundFailService.queryTradeRefundFailListWithPage(query, page);
            model.addAttribute("dataList", dataList);// 数据集合
            model.addAttribute("query", query);// 查询参数
            model.addAttribute("page", page);// 分页
        } catch (Exception e) {
            LOG.error("tradeRefundFail index has error.", e);
        }
        return viewPrefix + "/index";
    }

    /**
     * 正向交易及逆向退款失败表----添加跳转
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "addForward")
    public String addForward() {
        return viewPrefix + "/add";
    }

    /**
     * 正向交易及逆向退款失败表----添加
     * 
     * @param tradeRefundFail
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Wrapper<?> add(TradeRefundFail tradeRefundFail) {
        try {
            tradeRefundFail.setCreateUser(getLoginUserCnName());
            if (tradeRefundFailService.insert(tradeRefundFail)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "添加成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
            }
        } catch (ExistedException e) {
            LOG.warn("tradeRefundFail add fail, exist tradeRefundFail.");
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败，已经存在");
        } catch (Exception e) {
            LOG.error("tradeRefundFail add has error.", e);
            return WrapMapper.wrap(Wrapper.ERROR_CODE, "添加失败！");
        }
    }

    /**
     * 正向交易及逆向退款失败表----更新跳转
     * 
     * @param model
     * @param tradeRefundFail
     * @return
     */
    @RequestMapping(value = "updateForward")
    public String updateForward(Model model, TradeRefundFail tradeRefundFail) {
        try {
            TradeRefundFail tradeRefundFailResult = tradeRefundFailService.getTradeRefundFailById(tradeRefundFail.getId());
            model.addAttribute("tradeRefundFail", tradeRefundFailResult);
        } catch (Exception e) {
            LOG.error("tradeRefundFail updateForward has error.", e);
        }
        return viewPrefix + "/update";
    }

    /**
     * 正向交易及逆向退款失败表----更新
     * 
     * @param model
     * @param tradeRefundFail
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Wrapper<?> update(Model model, TradeRefundFail tradeRefundFail) {
        try {
            tradeRefundFail.setUpdateUser(getLoginUserCnName());
            if (tradeRefundFailService.update(tradeRefundFail)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "更新成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "更新失败！");
            }
        } catch (Exception e) {
            LOG.error("tradeRefundFail update has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 正向交易及逆向退款失败表----删除
     * 
     * @param tradeRefundFail
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Wrapper<?> delete(TradeRefundFail tradeRefundFail) {
        try {
            tradeRefundFail.setUpdateUser(getLoginUserCnName());
            if (tradeRefundFailService.delete(tradeRefundFail)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "删除成功！");
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "删除失败！");
            }
        } catch (Exception e) {
            LOG.error("tradeRefundFail delete has error.", e);
            return WrapMapper.error();
        }
    }

    /**
     * 正向交易及逆向退款失败表----查询-无分页
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Wrapper<?> query(TradeRefundFailQuery query) {
        try {
            List<TradeRefundFail> list = tradeRefundFailService.queryTradeRefundFailList(query);
            if (!CollectionUtils.isEmpty(list)) {
                return WrapMapper.wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, list);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询配置信息失败！");
            }
        } catch (Exception e) {
            LOG.error("tradeRefundFail query has error.", e);
            return WrapMapper.error();
        }
    }
    
    /**
     * 查询正向交易及逆向退款失败表详情
     * 
     * @param query
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Wrapper<?> detail(TradeRefundFailQuery query) {
        if (null == query || null == query.getId()) {
            return illegalArgument();
        }

        try {
            TradeRefundFail tradeRefundFail = tradeRefundFailService.getTradeRefundFailById(query.getId());
            if (tradeRefundFail != null) {
                return new Wrapper<TradeRefundFail>().result(tradeRefundFail);
            } else {
                return WrapMapper.wrap(Wrapper.ERROR_CODE, "查询正向交易及逆向退款失败表详情失败！");
            }
        } catch (Exception e) {
            LOG.warn("detail tradeRefundFail has error.", e);
            return error();
        }
    }
}
