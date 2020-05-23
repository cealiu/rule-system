package com.rule.common.util.jwt;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author LiuCe
 * @date 2020/5/23 9:05 下午
 * @email liucemail@gmail.com
 */
@Setter
@Getter
public class JWTInfo implements Serializable{

	private String userName;
	private String userId;
	private String ip;
	private String fingerPrint;

}
