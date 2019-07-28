package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.utils.Base64;
import com.example.demo.common.utils.HttpRequest;
import com.example.demo.common.utils.Md5Util;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserExtraDao;
import com.example.demo.dto.MerchantInResp;
import com.example.demo.dto.MerchantOpenResp;
import com.example.demo.dto.UserEntityDto;
import com.example.demo.entity.UserExtraEntity;
import com.example.demo.service.MerchantService;
import com.ips.commons.security.IpsVerify;
import com.ips.commons.security.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MerchantServiceImpl implements MerchantService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantServiceImpl.class);

    /** 编码字符集 **/
    private static String CHAR_ENCODING = "UTF-8";

    /** 商户入网接口url*/
    private static String url = "http://portal.ronghuijinfubj.com/middlepayportal/merchant/in";

    /** 商户产品开通url*/
    private static String urlOpen = "http://portal.ronghuijinfubj.com/middlepayportal/merchant/openProduct";

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserExtraDao userExtraDao;


    public void merchantIn(String identNo){

        UserExtraEntity userExtraEntity = new UserExtraEntity();

        List<UserEntityDto> userEntitylist = userDao.selectUserByIdentNo(identNo);
        UserEntityDto userEntity = userEntitylist.get(0);
        String userName = decryptString(userEntity.getUserRealName());

        String deskey = "tCZfuo6NyEtd2YMDANVZivoi";
        String signkey = "XCHFiJe78TE3CE4UXAawmpxjhDzyKAfm";

        //测试渠道信息
        String channelName = "channelName";
        String channelNo = "channelNo";

        //测试商户信息,需填写真实有效信息
        String merchantName = "个体户"+ userName;
        String merchantBillName = "个体户" + userName;
        String installProvince = "上海";
        String installCity = "上海市";
        String installCounty = "上海区";
        String operateAddress = "上海";
        String merchantType = "PERSON";
        //String businessLicense = "营业执照号码";
        String legalPersonName = userName;//法人信息与结算人信息一致
        String legalPersonID = decryptString(identNo);//参与鉴权
        String merchantPersonName = userName;
        String merchantPersonPhone = decryptString(userEntity.getUserMobileNo());//银行预留手机号，参与鉴权
        //String merchantPersonEmail = "商户联系人邮箱";
        String bankType = "TOPRIVATE";//对公对私
        String accountName = userName;//参与鉴权
        String accountNo = decryptString(userEntity.getCardNo());//参与鉴权
        String bankCode = userEntity.getBankBraNo();
        String remarks = "备注";

        Map<String, String> map = new HashMap<String, String>();
        map.put("channelName", channelName);
        map.put("channelNo", channelNo);
        map.put("merchantName", merchantName);
        map.put("merchantBillName", merchantBillName);
        map.put("installProvince", installProvince);
        map.put("installCity", installCity);
        map.put("installCounty", installCounty);
        map.put("operateAddress", operateAddress);
        map.put("merchantType", merchantType);
        map.put("legalPersonName", legalPersonName);
        map.put("legalPersonID", legalPersonID);
        map.put("merchantPersonName", merchantPersonName);
        map.put("merchantPersonPhone", merchantPersonPhone);
        map.put("bankType", bankType);
        map.put("accountName", accountName);
        String accno = encode(deskey, accountNo);
        map.put("accountNo", accno);
        map.put("bankCode", bankCode);
        map.put("remarks", remarks);

        String sign = Md5Util.MD5(JSON.toJSONString(map)+signkey);
        map.put("sign", sign);
        try{
            LOGGER.info("-----》请求RHJF商户入网请求信息",JSON.toJSONString(map));
            String merIn = HttpRequest.sendPost(url, JSON.toJSONString(map));
            LOGGER.info("-----》请求RHJF商户入网返回信息",JSON.toJSONString(merIn));
            MerchantInResp resp = JSONObject.parseObject(merIn,MerchantInResp.class);

        }catch (Exception e){
            LOGGER.error("-----》请求RHJF商户入网失败",e);
        }




    }

    @Override
    public void merchantOpen() {

        String signkey = "XCHFiJe78TE3CE4UXAawmpxjhDzyKAfm";

        String productType = "UNIONPAY_DHA";
        String merchantNo = "";
        String t0Fee = "0.50";
        String t1Fee = "0.50";



        Map<String, String> map = new HashMap<String, String>();
        map.put("productType", productType);
        map.put("merchantNo", merchantNo);
        map.put("t0Fee", t0Fee);
        map.put("t1Fee", t1Fee);

        String sign = Md5Util.MD5(JSON.toJSONString(map)+signkey);
        map.put("sign", sign);
        try{
            String merOpen = HttpRequest.sendPost(urlOpen, JSON.toJSONString(map));
            MerchantOpenResp resp = JSONObject.parseObject(merOpen,MerchantOpenResp.class);


        }catch (Exception e){
            LOGGER.error("-----》请求RHJF商户产品开通失败",e);
        }



    }

    //解密
    public String decryptString(String string) {
        if (StringUtils.isBlank(string)) {
            return string;
        }
        try {
            String decryptString = IpsVerify.infoDecryptForAES("", string)[0];
            return decryptString;
        } catch (Exception e) {
            return string;
        }
    }
    //加密
    public String encryptString(String string) {
        if (StringUtils.isBlank(string)) {
            return string;
        }
        try {
            String encryptString = IpsVerify.infoEncryptForAES("", string)[0];
            return encryptString;
        } catch (Exception e) {
            return string;
        }
    }
    /**
     * Base64编码
     * @param key
     * @param data
     * @return
     */
    public static String encode(String key, String data) {
        try {
            byte[] keyByte = key.getBytes(CHAR_ENCODING);
            byte[] dataByte = data.getBytes(CHAR_ENCODING);
            byte[] valueByte = MerchantServiceImpl.des3Encryption(keyByte, dataByte);
            String value = new String(Base64.encode(valueByte), CHAR_ENCODING);
            return value;
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * des3Encryption加密
     * @param key
     * @param data
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IllegalStateException
     */
    public static byte[] des3Encryption(byte[] key, byte[] data) throws
            NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, IllegalStateException {
        final String Algorithm = "DESede";

        SecretKey deskey = new SecretKeySpec(key, Algorithm);

        Cipher c1 = Cipher.getInstance(Algorithm);
        c1.init(Cipher.ENCRYPT_MODE, deskey);
        return c1.doFinal(data);
    }
}
