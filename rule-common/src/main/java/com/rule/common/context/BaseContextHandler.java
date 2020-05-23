package com.rule.common.context;

import com.rule.common.constant.UserConstant;
import com.rule.common.util.jwt.JWTInfo;
import com.rule.common.vo.security.SecurityInformation;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuCe
 * @date 2020/5/23 9:03 下午
 * @email liucemail@gmail.com
 */

@Slf4j
public class BaseContextHandler {
	public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

	public static void set(String key, Object value) {

		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		log.debug("ThreadLocal put key {}  value {}",key,value);
		map.put(key, value);
	}

	public static Object get(String key){
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		Object value=map.get(key);
		log.debug("ThreadLocal get key {}  value {}",key,value);
		return value;
	}
	public static JWTInfo getJwtInfo(){
		JWTInfo value = (JWTInfo)get(UserConstant.JWT_INFO);
		return value;
	}
	public static void setJwtInfo(JWTInfo jwtInfo){set(UserConstant.JWT_INFO,jwtInfo);}

	public static void setLang(String  lang){set(UserConstant.LANG,lang);}
	public static String getLang(){
		String value = (String)get(UserConstant.LANG);
		return value;
	}


	public static SecurityInformation getSecurityInformation(){
		SecurityInformation value = (SecurityInformation)get(UserConstant.SECURITY_INFORMATION);
		return value;
	}
	public static void setSecurityInformation(SecurityInformation securityInformation){set(UserConstant.SECURITY_INFORMATION,securityInformation);}


	private static String returnObjectValue(Object value) {
		return value==null?null:value.toString();
	}

	public static void remove(){
		threadLocal.remove();
	}

}
