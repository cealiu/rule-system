package com.rule.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.rule.common.constant.CommonConstants;
import com.rule.common.constant.UserConstant;
import com.rule.common.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.util.Objects;


@Slf4j
public class OkHttpTokenInterceptor implements Interceptor {
	@Override
	public Response intercept(Chain chain) throws IOException {



		Request newRequest = null;
		if (chain.request().url().toString().contains("client/token")) {
			newRequest = chain.request()
					.newBuilder()
					.header(UserConstant.SECURITY_INFORMATION, JSONObject.toJSONString(BaseContextHandler.getSecurityInformation()) )
					.header(UserConstant.JWT_INFO,JSONObject.toJSONString(BaseContextHandler.getJwtInfo()))
					.header(UserConstant.LANG, Objects.isNull(BaseContextHandler.getLang())?"":BaseContextHandler.getLang())
					.build();
		} else {
			newRequest = chain.request()
					.newBuilder()
					.header(UserConstant.SECURITY_INFORMATION, JSONObject.toJSONString(BaseContextHandler.getSecurityInformation()) )
					.header(UserConstant.JWT_INFO,JSONObject.toJSONString(BaseContextHandler.getJwtInfo()))
					.header(UserConstant.LANG, Objects.isNull(BaseContextHandler.getLang())?"":BaseContextHandler.getLang())
					.build();
		}

		Response response = chain.proceed(newRequest);
		if (HttpStatus.FORBIDDEN.value() == response.code()) {
			if (response.body().string().contains(String.valueOf(CommonConstants.EX_CLIENT_INVALID_CODE))) {
				log.info("Client Token Expire,Retry to request...");
				newRequest = chain.request()
						.newBuilder()
						.header(UserConstant.SECURITY_INFORMATION, JSONObject.toJSONString(BaseContextHandler.getSecurityInformation()) )
						.header(UserConstant.JWT_INFO,JSONObject.toJSONString(BaseContextHandler.getJwtInfo()))
						.header(UserConstant.LANG, Objects.isNull(BaseContextHandler.getLang())?"":BaseContextHandler.getLang())
						.build();
				response = chain.proceed(newRequest);
			}
		}
		return response;
	}

}
