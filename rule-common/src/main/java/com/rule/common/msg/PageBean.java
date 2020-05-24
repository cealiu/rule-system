package com.rule.common.msg;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Setter
@Getter
public class PageBean {

    private Integer pageNumber;
    private Integer pageSize;
    private String orderBy;

    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).toString();
    }
}
