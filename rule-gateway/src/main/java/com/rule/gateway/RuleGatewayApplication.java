package com.rule.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RuleGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(RuleGatewayApplication.class, args);
	}
}
