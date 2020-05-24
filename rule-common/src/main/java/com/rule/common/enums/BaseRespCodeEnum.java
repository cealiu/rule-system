package com.rule.common.enums;


public enum BaseRespCodeEnum {
	/** 成功 **/
	SUCCESS("00000000", "处理成功", BaseRespStatusEnum.SUCCESS.getCode()),

	/** 未查询到结果 **/
	SUCCESS_NO_VALUE("00000001", "处理成功", BaseRespStatusEnum.SUCCESS.getCode()),

	/** 系统错误 **/
	SYSTEM_ERROR("99999999", "系统错误", BaseRespStatusEnum.FAIL.getCode()),

	/** 数据库错误 **/
	DATABASE_EXCEPTION("99999998", "数据库异常", BaseRespStatusEnum.FAIL.getCode()),

	/** 多个查询结果 **/
	MULTI_QUERY_RESULT("99999997", "多个查询结果", BaseRespStatusEnum.FAIL.getCode()),

	/** 接口调用异常 **/
	INVOKE_EXCEPTION("99999996", "调用接口异常", BaseRespStatusEnum.FAIL.getCode()),

	/** 未查询到结果 **/
	FAIL_NO_VALUE("99999995", "未查询到结果", BaseRespStatusEnum.FAIL.getCode()),

	/** 记录已存在 **/
	RECORD_EXIST("99999994", "记录已存在", BaseRespStatusEnum.FAIL.getCode()),

	/** oss服务异常 **/
	OSS_EXCEPTION("99999993", "oss服务异常", BaseRespStatusEnum.FAIL.getCode()),

	/** 无效参数 **/
	INVALID_PARAMETER("99999992", "无效参数", BaseRespStatusEnum.FAIL.getCode()),

	/** 重复的请求 **/
	DUPLICATE_TRADE("99999991", "重复的请求", BaseRespStatusEnum.FAIL.getCode()),

	/** 参数填充不完整 **/
	PARAMETER_EMPTY("99999989", "参数填充不完整", BaseRespStatusEnum.FAIL.getCode());


	private String status;
	private String code;
	private String message;

	private BaseRespCodeEnum(String code, String message, String status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
