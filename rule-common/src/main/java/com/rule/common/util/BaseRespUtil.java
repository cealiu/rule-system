package com.rule.common.util;

import com.rule.common.enums.BaseRespCodeEnum;
import com.rule.common.enums.BaseRespStatusEnum;
import com.rule.common.msg.BaseResponse;


public class BaseRespUtil {

	public static <E extends BaseResponse> E setSuccess(E response, BaseRespCodeEnum respCode) {
		return setSuccess(response, respCode.getCode(), respCode.getMessage());
	}

	public static <E extends BaseResponse> E setSuccess(E response) {
		return setSuccess(response, BaseRespCodeEnum.SUCCESS.getCode(), BaseRespCodeEnum.SUCCESS.getMessage());
	}

	public static <E extends BaseResponse> E setSuccess(E response, String successMsg) {
		return setSuccess(response, BaseRespCodeEnum.SUCCESS.getCode(), successMsg);
	}

	public static <E extends BaseResponse> E setSuccess(E response, String successCode, String successMsg) {
		response.setStatus(BaseRespStatusEnum.SUCCESS.getCode());
		response.setCode(successCode);
		response.setMessage(successMsg);
		return response;
	}

	public static <E extends BaseResponse> E setFail(E response, String failCode, String failMsg) {
		response.setStatus(BaseRespStatusEnum.FAIL.getCode());
		response.setCode(failCode);
		response.setMessage(failMsg);
		return response;
	}

	public static <E extends BaseResponse> E setFail(E response, BaseRespCodeEnum failRespCode) {
		return setFail(response, failRespCode.getCode(), failRespCode.getMessage());
	}

	public static <E extends BaseResponse> E setFail(E response, BaseRespCodeEnum failRespCode, String failMsg) {
		return setFail(response, failRespCode.getCode(), failMsg);
	}


	public static <E extends BaseResponse> E setSystemError(E response) {
		return setFail(response, BaseRespCodeEnum.SYSTEM_ERROR.getCode(), BaseRespCodeEnum.SYSTEM_ERROR.getMessage());
	}

	public static <E extends BaseResponse> E setSystemError(E response, String errorMsg) {
		return setFail(response, BaseRespCodeEnum.SYSTEM_ERROR.getCode(), errorMsg);
	}

	public static <E extends BaseResponse> E setDBException(E response) {
		return setFail(response, BaseRespCodeEnum.DATABASE_EXCEPTION.getCode(),
				BaseRespCodeEnum.DATABASE_EXCEPTION.getMessage());
	}

	public static <E extends BaseResponse> E setDBException(E response, String errorMsg) {
		return setFail(response, BaseRespCodeEnum.DATABASE_EXCEPTION.getCode(), errorMsg);
	}

	public static <E extends BaseResponse> E setInvalidParamError(E response) {
		return setFail(response, BaseRespCodeEnum.INVALID_PARAMETER.getCode(),
				BaseRespCodeEnum.INVALID_PARAMETER.getMessage());
	}

	public static <E extends BaseResponse> E setInvalidParamError(E response, String extMessage) {
		return setFail(response, BaseRespCodeEnum.INVALID_PARAMETER.getCode(), BaseRespCodeEnum.INVALID_PARAMETER.getMessage() +"["+ extMessage +"]");
	}

	public static <E extends BaseResponse> String getDesc(E response) {
		StringBuilder sb = new StringBuilder();
		if (response == null) {
			sb.append("response==null");
		} else {
			sb.append("{status=").append(response.getStatus());
			sb.append(",code=").append(response.getCode());
			sb.append(", message=").append(response.getMessage()).append("}");
		}
		return sb.toString();
	}
	public static <E extends BaseResponse> boolean isSuccess(E response){
		if( null == response || null == response.getStatus() || "".equals(response.getStatus().trim()) ){
			return false;
		}
		return BaseRespStatusEnum.SUCCESS.getCode().equals(response.getStatus());
	}

	public static <E extends BaseResponse> boolean isFail(E response){
		return !isSuccess(response);
	}
}
