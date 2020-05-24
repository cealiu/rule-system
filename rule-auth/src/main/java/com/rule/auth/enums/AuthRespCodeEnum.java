package com.rule.auth.enums;

import com.rule.common.enums.BaseRespCodeEnum;
import com.rule.common.enums.BaseRespStatusEnum;

/**
 * @author LiuCe
 * @date 2020/5/24 6:08 下午
 * @email liucemail@gmail.com
 */
public enum AuthRespCodeEnum {

	/** 用户不存在 **/
	USER_NOT_EXIST("99988801", "用户不存在", BaseRespStatusEnum.FAIL.getCode()),

	/** 密码不正确 **/
	PASSWORD_WRONG("99988802", "密码不正确", BaseRespStatusEnum.FAIL.getCode());

	private String status;
	private String code;
	private String message;

	private AuthRespCodeEnum(String code, String message, String status) {
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
