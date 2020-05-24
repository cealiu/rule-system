package com.rule.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="基础响应对象",description="基础接口响应对象")
public class BaseResponse {

    @ApiModelProperty(value = "响应描述", name = "message", example = "OK")
    private String message;
    @ApiModelProperty(value = "响应码", name = "code", example = "00000000")
    private String code;
    @ApiModelProperty(value = "响应状态", name = "status", example = "1")
    private String status;

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public BaseResponse(String status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code= code;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseResponse{");
        sb.append("message='").append(message).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
