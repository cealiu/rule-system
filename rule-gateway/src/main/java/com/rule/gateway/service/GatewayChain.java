package com.rule.gateway.service;

import com.rule.gateway.service.filter.IgnoreStartWithFilter;
import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GatewayChain extends ChainBase {

	@Autowired
	private IgnoreStartWithFilter ignoreStartWithFilter;
//	@Autowired()
//	private JwtUserFilter jwtUserFilter;

	@PostConstruct
	public void updateGatewayChain(){

		//忽略路径判断
		this.addCommand(ignoreStartWithFilter);

	}
}
