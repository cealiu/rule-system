package com.rule.common.vo.security;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LiuCe
 * @date 2020/5/23 9:12 下午
 * @email liucemail@gmail.com
 */
@Setter
@Getter
public class SecurityInformation {

	private String fingerPrint;

	private String publicIp;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("SecurityInformation{");
		sb.append("fingerPrint='").append(fingerPrint).append('\'');
		sb.append(", publicIp='").append(publicIp).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
