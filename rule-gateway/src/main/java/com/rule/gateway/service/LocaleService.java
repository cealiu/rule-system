package com.rule.gateway.service;

import org.springframework.web.server.ServerWebExchange;

public interface LocaleService {

	String getMessage(String code, ServerWebExchange exchange);
}
