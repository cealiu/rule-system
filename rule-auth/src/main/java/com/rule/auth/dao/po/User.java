package com.rule.auth.dao.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author LiuCe
 * @date 2020/5/24 12:34 下午
 * @email liucemail@gmail.com
 */
@Setter
@Getter
public class User {

	private Long id;

	private String userId;

	private String userName;

	private String nickname;

	private String password;

	private Date createTime;

	private Date updateTime;
}
