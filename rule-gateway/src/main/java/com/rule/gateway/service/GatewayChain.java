package com.rule.gateway.service;

import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GatewayChain extends ChainBase {

	@PostConstruct
	public void updateGatewayChain(){

	}
}
