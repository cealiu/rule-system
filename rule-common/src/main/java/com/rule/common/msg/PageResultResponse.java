package com.rule.common.msg;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class PageResultResponse<T> extends BaseResponse {

    private List<T> dataList;
    private long pageNumber;
    private long pageSize;
    private long total;
    private long pages;

}
