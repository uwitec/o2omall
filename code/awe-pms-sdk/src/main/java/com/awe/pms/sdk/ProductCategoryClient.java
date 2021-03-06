package com.awe.pms.sdk;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import com.awe.pms.sdk.request.ProductCategoryRequest;
import com.awe.pms.sdk.request.dto.ProductCategoryRequestDto;
import com.awe.pms.sdk.response.ProductCategoryResponse;
import com.awe.pms.sdk.response.dto.ProductCategoryResponseDto;
import com.hbird.common.client.AbstractSecureClient;
import com.hbird.common.sdk.api.response.HbirdResponse;
import com.hbird.common.utils.serialize.JsonHelper;

/**
 * 商品类别服务的客户端
 * 
 * @author ljz
 * @version 2014-12-25 17:50:15
 * 
 */
public class ProductCategoryClient extends AbstractSecureClient {
    
    private final static Log LOG = LogFactory.getLog(ProductCategoryClient.class);

    /**
     * 商品类别查询服务
     * 
     * @param request
     *            查询请求对象
     * @return ProductCategoryResponseDto 接口返回的数据对象
     */
    public ProductCategoryResponseDto getProductCategory(ProductCategoryRequestDto requestDto) {
        Assert.notNull(requestDto);

        ProductCategoryRequest request = new ProductCategoryRequest(super.getKey(), requestDto);
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductCategory request: " + JsonHelper.toJson(request));
        }

        String url = super.getServiceUrlDomain() + "services/productCategory/getProductCategory";
        ProductCategoryResponse response = super.getRestTemplate().postForObject(url, request, ProductCategoryResponse.class);

        if (LOG.isDebugEnabled()) {
            LOG.debug("getProductCategory url: " + url);
            LOG.debug("getProductCategory response: " + JsonHelper.toJson(response));
        }
        return super.getResult(response);
    }
    
    /**
     * 根据条件查询商品类别服务
     * 
     * @param request
     *            查询请求对象
     * @return List<ProductCategoryResponseDto> 接口返回的数据对象集合
     */
    @SuppressWarnings("unchecked")
	public List<ProductCategoryResponseDto> getProductCategorys(ProductCategoryRequestDto requestDto) {
//    	Assert.notNull(requestDto);
    	
    	ProductCategoryRequest request = new ProductCategoryRequest(super.getKey(), requestDto);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProductCategorys request: " + JsonHelper.toJson(request));
    	}
    	
    	String url = super.getServiceUrlDomain() + "services/productCategory/getProductCategorys";
    	
    	HbirdResponse<List> response = super.getRestTemplate().postForObject(url, request, HbirdResponse.class);
    	
    	List<ProductCategoryResponseDto> responseResult = JsonHelper.toList(JsonHelper.toJson(response.getResult()), ProductCategoryResponseDto.class);
    	response.setResult(responseResult);
    	
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("getProductCategorys url: " + url);
    		LOG.debug("getProductCategorys response: " + JsonHelper.toJson(response));
    	}
    	return super.getResult(response);
    }
}
