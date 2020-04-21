package com.rule.gateway.service.impl;

import com.rule.gateway.service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String code, ServerWebExchange exchange) {
		String language = exchange.getRequest().getHeaders().getFirst("Accept-Language");

		Locale targetLocale = Locale.getDefault();
		if (language != null && !language.isEmpty()) {
			targetLocale = Locale.forLanguageTag(language);
		}
		LocaleContext localeContext = new SimpleLocaleContext(targetLocale);

		return messageSource.getMessage(code, null, localeContext.getLocale());
	}
}
