package com.rule.gateway.filter;

import com.rule.gateway.service.GatewayChain;
import com.rule.gateway.service.LocaleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GatewayFilter implements GlobalFilter {

	@Autowired
	LocaleService localeService;

	@Autowired
	GatewayChain gatewayChain;
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ContextBase context = new ContextBase();
//		String test = localeService.getMessage("error.notfound",exchange);
//		System.out.println(test);
		try {
			gatewayChain.execute(context);

		}catch (Exception e){
			log.error("request filter error {}",e.getMessage());
		}
		Mono<Void> mono = (Mono<Void>)context.get("rs");

		return mono;
	}

}
