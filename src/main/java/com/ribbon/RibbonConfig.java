package com.ribbon;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

public class RibbonConfig {
	
	@Bean
	public IRule rule(){
		return new WeightedResponseTimeRule();
	}
	

}
