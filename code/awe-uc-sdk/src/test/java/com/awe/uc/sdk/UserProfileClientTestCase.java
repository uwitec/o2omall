package com.awe.uc.sdk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.awe.uc.sdk.request.UserProfileRequest;
import com.awe.uc.sdk.request.dto.UserProfileRequestDto;
import com.awe.uc.sdk.response.dto.UserProfileResponseDto;

/**
 * UserProfileClient测试用例
 * 
 * @author lijianzhong
 * 
 */
public class UserProfileClientTestCase {
    String WS_DOMAIN = "http://dev.ucws.shop.hbird.com/";
    // String WS_DOMAIN = "http://local.ucws.shop.hbird.com:8090/";
    private UserProfileClient client;

    @Before
    public void init() {
        client = new UserProfileClient();
        client.setServiceUrlDomain(WS_DOMAIN);
        client.setConnectTimeout(3000);
        client.setReadTimeout(3000);
    }

    @Test
    public void testGetUserProfile() {
        UserProfileRequestDto requestDto = new UserProfileRequestDto();
        requestDto.setId(1l);
        UserProfileRequest request = new UserProfileRequest("key",requestDto);
        
        UserProfileResponseDto userProfileResponseDto = client.getUserProfile(request);
        Assert.notNull(userProfileResponseDto);
    } 

}
