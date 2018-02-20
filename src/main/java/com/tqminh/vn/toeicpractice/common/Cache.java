package com.tqminh.vn.toeicpractice.common;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.model.Account;

@Component
public class Cache {
	
	private Map<String, Account> map;

	public Cache() {
		super();
		map= new Hashtable<>();
	}

	public Map<String, Account> getMap() {
		return map;
	}

	public void setMap(Map<String, Account> map) {
		this.map = map;
	}	
}
