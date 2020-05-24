package com.rule.common.msg;


public class ListRestResponse<T>  extends BaseResponse {
    T result;
    int count;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ListRestResponse count(int count) {
        this.setCount(count);
        return this;
    }

    public ListRestResponse count(Long count) {
        this.setCount(count.intValue());
        return this;
    }


    public ListRestResponse result(T result) {
        this.setResult(result);
        return this;
    }

}
