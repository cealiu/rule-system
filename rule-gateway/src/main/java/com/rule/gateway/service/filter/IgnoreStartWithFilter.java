package com.rule.gateway.service.filter;

import com.alibaba.fastjson.JSONObject;
import com.rule.common.constant.UserConstant;
import com.rule.common.context.BaseContextHandler;
import com.rule.common.vo.security.SecurityInformation;
import com.rule.gateway.constant.GatewayConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author LiuCe
 * @date 2020/6/6 21:23
 * @email liucemail@gmail.com
 */
@Component
@Slf4j
@RefreshScope
public class IgnoreStartWithFilter implements Filter {

	@Value("#{'${webgate.ignore.startWith}'.split(',')}")
	private List<String> startWith ;

	@Override
	public boolean postprocess(Context context, Exception exception){
		ServerWebExchange serverWebExchange=(ServerWebExchange) context.get(GatewayConstant.SERVER_WEB_EXCHANGE);
		GatewayFilterChain gatewayFilterChain=(GatewayFilterChain) context.get(GatewayConstant.GATEWAY_FILTER_CHAIN);
		ServerHttpRequest request = serverWebExchange.getRequest();

		Mono<Void> mono = (Mono<Void>) context.get(GatewayConstant.MONO_VOID);
		if(mono==null)
		{
			ServerHttpRequest.Builder mutate = request.mutate();
			log.info("getToken {}", BaseContextHandler.getJwtInfo());
			mutate.header(UserConstant.JWT_INFO, JSONObject.toJSONString(BaseContextHandler.getJwtInfo()));
			ServerHttpRequest build = mutate.build();
			mono =gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
			context.put(GatewayConstant.MONO_VOID,mono);
		}
		return false;
	}

	@Override
	public boolean execute(Context context) throws Exception{

		ServerWebExchange serverWebExchange=(ServerWebExchange) context.get(GatewayConstant.SERVER_WEB_EXCHANGE);
		GatewayFilterChain gatewayFilterChain=(GatewayFilterChain) context.get(GatewayConstant.GATEWAY_FILTER_CHAIN);
		LinkedHashSet requiredAttribute = serverWebExchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
		ServerHttpRequest request = serverWebExchange.getRequest();

		String requestUri = request.getPath().pathWithinApplication().value();
		ServerHttpRequest.Builder mutate = request.mutate();


		// 不进行拦截的地址
		if (isStartWith(requestUri)) {
			ServerHttpRequest build = mutate.build();
			log.info("no interception {}",requestUri);
			Mono<Void> mono =gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
			context.put(GatewayConstant.MONO_VOID,mono);
			return true;
		}
		return false;
	}

	/**
	 * 忽略不用拦截的URL
	 * @param path
	 * @return
	 */

	private boolean isStartWith(String path) {
		return startWith.stream().map(url -> url.replace("/**", "")).anyMatch(path::contains);
	}
}
