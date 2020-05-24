package com.rule.auth.dao;

import com.rule.auth.dao.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LiuCe
 * @date 2020/5/24 12:33 下午
 * @email liucemail@gmail.com
 */

@Mapper
public interface UserDao {

	User selectByUser(User user);
}
