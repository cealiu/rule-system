package com.rule.common.msg;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Getter
@Setter
public class PageQueryRequest<T>{
    /**
     * 查询实体对象
     */
    private T t;

    private PageBean pageBean;


    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).toString();
    }
}
