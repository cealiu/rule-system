package com.rule.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="响应对象",description="接口响应对象")
public class ObjectRestResponse<T> extends BaseResponse {

    @ApiModelProperty(value = "响应对象", name = "data", example = "data")
    T data;

    boolean rel;

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }


    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
