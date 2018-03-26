package com.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ribbon.model.User;

@RestController
public class RibController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping(value="/users", produces="application/json")
	public List<User> findAll(){
		String uri="http://USER-SERVICE/all-users";
		System.out.println(".........URI PORT......"+loadBalancerClient.choose("user-service").getPort());
		List<User> userList = restTemplate.getForObject(uri,List.class);
		return userList;
	}
	@RequestMapping(value="/users-city/{city}", produces="application/json")
	public List<User> findByCity(@PathVariable("city") String city){
		String uri="http://USER-SERVICE/users-by-city/"+city;
		List<User> userList = restTemplate.getForObject(uri,List.class);
		return userList;
	}
	@RequestMapping(value="/users/{userid}", produces="application/json")
	public User findById(@PathVariable("userid") int id){
		String uri="http://USER-SERVICE/one-user/"+id;
		User user = restTemplate.getForObject(uri,User.class);
		return user;
	}
	@RequestMapping(value="/say-hello/{username}")
	public String greet(@PathVariable("username")String name){
		String uri="http://USER-SERVICE/greet/"+name;
		String msg = restTemplate.getForObject(uri,String.class);
		return msg;
	}
}
