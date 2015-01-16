package com.awe.test.rems.rest.request;

import com.awe.test.rems.rest.request.dto.RefundRequestDto;
import com.hbird.common.sdk.api.request.HbirdPageSecureRequest;
import com.hbird.common.utils.page.PageUtil;

/**
 * RefundRequest：退款表请求参数
 * 
 * @author zyq
 * @version 2014-12-25 9:16:23
 * 
 */
public class RefundRequest extends HbirdPageSecureRequest<RefundRequestDto> {

    /** 序列化标识 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public RefundRequest() {
        super();
    }

    /**
     * @param key
     * @param content
     */
    public RefundRequest(String key, RefundRequestDto content) {
        super(key, content);
    }
    /**
     * 
     * @param key
     * @param content
     * @param pageUtil
     */
    public RefundRequest(String key, RefundRequestDto content, PageUtil pageUtil) {
        super(key, content);
    }
}
