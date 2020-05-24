package com.rule.auth.controller.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LiuCe
 * @date 2020/5/24 12:26 下午
 * @email liucemail@gmail.com
 */
@Getter
@Setter
public class UserLoginDto {

	private String userName;

	private String userId;

	private String password;
}
