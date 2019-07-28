package com.example.demo.service;

public interface MerchantService {

    /**
     * 请求RHJF商户入网
     * @param identNo
     */
    void merchantIn(String identNo);

    /**
     * 请求RHJF商户产品开通
     */
    void merchantOpen();
}
