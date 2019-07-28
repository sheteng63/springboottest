package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * @Description
 * @author ips
 * @version 1.0 2018-12-30 9:34:22
 */
public class UserEntity implements Serializable {

	/**  */   
    private static final long serialVersionUID = 1L;
    /**
	 * 用户ID
	 */
	private BigInteger platUserId;
	/**
	 * 商户编号
	 */
	private String merCode;
	/**
	 * 平台商户账户号
	 */
	private String platMerAccCode;
	/**
	 * 平台交易流水号
	 */
	private String trxId;
	/**
	 * 交易日期时间
	 */
	private String trxDtTm;
	/**
	 * 用户类型: 01、个人
	 */
	private String userType;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 证件类型:01、身份证 02、护照 03、港澳台居民通行证 04、外国人永久居留证
	 */
	private String identType;
	/**
	 * 用户证件号码_密文
	 */
	private String identNo;
	/**
	 * 用户真实姓名_密文
	 */
	private String userRealName;
	/**
	 * 用户手机号_密文
	 */
	private String userMobileNo;
	/**
	 * 交易状态 SUCCESS、成功 FAIL、失败 PROCESSING、处理中 EXCEPTION、异常
	 */
	private String trxStatus;
	/**
	 * 交易状态描述(失败信息)
	 */
	private String trxStatusMsg;
	/**
	 * 完成时间
	 */
	private Date platTrxDtTm;
	/**
	 * 服务器回调URL
	 */
	private String notifyUrl;
	/**
	 * 附加数据
	 */
	private String attach;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改人
	 */
	private String modifyBy;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 备用字段
	 */
	private String attribute1;

	/**
	 * 合作平台编号
	 */
	private String coptCode;

	/**
	 * 设置用户ID
	 */
	public void setPlatUserId(BigInteger platUserId) {
		this.platUserId = platUserId;

	}

	/**
	 * 获取用户ID
	 */
	public BigInteger getPlatUserId() {
		return this.platUserId;

	}

	/**
	 * 设置商户编号
	 */
	public void setMerCode(String merCode) {
		this.merCode = merCode;

	}

	/**
	 * 获取商户编号
	 */
	public String getMerCode() {
		return this.merCode;

	}

	/**
	 * 设置平台商户账户号
	 */
	public void setPlatMerAccCode(String platMerAccCode) {
		this.platMerAccCode = platMerAccCode;

	}

	/**
	 * 获取平台商户账户号
	 */
	public String getPlatMerAccCode() {
		return this.platMerAccCode;

	}

	/**
	 * 设置平台交易流水号
	 */
	public void setTrxId(String trxId) {
		this.trxId = trxId;

	}

	/**
	 * 获取平台交易流水号
	 */
	public String getTrxId() {
		return this.trxId;

	}

	/**
	 * 设置交易日期时间
	 */
	public void setTrxDtTm(String trxDtTm) {
		this.trxDtTm = trxDtTm;

	}

	/**
	 * 获取交易日期时间
	 */
	public String getTrxDtTm() {
		return this.trxDtTm;

	}

	/**
	 * 设置用户类型: 01、个人
	 */
	public void setUserType(String userType) {
		this.userType = userType;

	}

	/**
	 * 获取用户类型: 01、个人
	 */
	public String getUserType() {
		return this.userType;

	}

	/**
	 * 设置用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;

	}

	/**
	 * 获取用户名
	 */
	public String getUserName() {
		return this.userName;

	}

	/**
	 * 设置证件类型:01、身份证 02、护照 03、港澳台居民通行证 04、外国人永久居留证
	 */
	public void setIdentType(String identType) {
		this.identType = identType;

	}

	/**
	 * 获取证件类型:01、身份证 02、护照 03、港澳台居民通行证 04、外国人永久居留证
	 */
	public String getIdentType() {
		return this.identType;

	}

	/**
	 * 设置用户证件号码_密文
	 */
	public void setIdentNo(String identNo) {
		this.identNo = identNo;

	}

	/**
	 * 获取用户证件号码_密文
	 */
	public String getIdentNo() {
		return this.identNo;

	}

	/**
	 * 设置用户真实姓名_密文
	 */
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;

	}

	/**
	 * 获取用户真实姓名_密文
	 */
	public String getUserRealName() {
		return this.userRealName;

	}

	/**
	 * 设置用户手机号_密文
	 */
	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;

	}

	/**
	 * 获取用户手机号_密文
	 */
	public String getUserMobileNo() {
		return this.userMobileNo;

	}

	/**
	 * 设置交易状态 SUCCESS、成功 FAIL、失败 PROCESSING、处理中 EXCEPTION、异常
	 */
	public void setTrxStatus(String trxStatus) {
		this.trxStatus = trxStatus;

	}

	/**
	 * 获取交易状态 SUCCESS、成功 FAIL、失败 PROCESSING、处理中 EXCEPTION、异常
	 */
	public String getTrxStatus() {
		return this.trxStatus;

	}

	/**
	 * 设置交易状态描述(失败信息)
	 */
	public void setTrxStatusMsg(String trxStatusMsg) {
		this.trxStatusMsg = trxStatusMsg;

	}

	/**
	 * 获取交易状态描述(失败信息)
	 */
	public String getTrxStatusMsg() {
		return this.trxStatusMsg;

	}

	/**
	 * 设置完成时间
	 */
	public void setPlatTrxDtTm(Date platTrxDtTm) {
		if (platTrxDtTm == null) {
			this.platTrxDtTm = null;
		} else {
			this.platTrxDtTm = (Date) platTrxDtTm.clone();
		}

	}

	/**
	 * 获取完成时间
	 */
	public Date getPlatTrxDtTm() {
		if (this.platTrxDtTm == null) {
			return null;
		}
		return (Date) this.platTrxDtTm.clone();

	}

	/**
	 * 设置服务器回调URL
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;

	}

	/**
	 * 获取服务器回调URL
	 */
	public String getNotifyUrl() {
		return this.notifyUrl;

	}

	/**
	 * 设置附加数据
	 */
	public void setAttach(String attach) {
		this.attach = attach;

	}

	/**
	 * 获取附加数据
	 */
	public String getAttach() {
		return this.attach;

	}

	/**
	 * 设置创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;

	}

	/**
	 * 获取创建人
	 */
	public String getCreateBy() {
		return this.createBy;

	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Date createTime) {
		if (createTime == null) {
			this.createTime = null;
		} else {
			this.createTime = (Date) createTime.clone();
		}

	}

	/**
	 * 获取创建时间
	 */
	public Date getCreateTime() {
		if (this.createTime == null) {
			return null;
		}
		return (Date) this.createTime.clone();

	}

	/**
	 * 设置修改人
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;

	}

	/**
	 * 获取修改人
	 */
	public String getModifyBy() {
		return this.modifyBy;

	}

	/**
	 * 设置修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		if (modifyTime == null) {
			this.modifyTime = null;
		} else {
			this.modifyTime = (Date) modifyTime.clone();
		}

	}

	/**
	 * 获取修改时间
	 */
	public Date getModifyTime() {
		if (this.modifyTime == null) {
			return null;
		}
		return (Date) this.modifyTime.clone();

	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getCoptCode() {
		return coptCode;
	}

	public void setCoptCode(String coptCode) {
		this.coptCode = coptCode;
	}

}
