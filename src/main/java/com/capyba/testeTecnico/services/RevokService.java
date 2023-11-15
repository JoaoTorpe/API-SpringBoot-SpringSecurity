package com.capyba.testeTecnico.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class RevokService {

	private Set<String> blackList = new HashSet<String>();
	
	
	public void addToBlackList(String token) {
		blackList.add(token);
	}
	
	public boolean isInBlackList (String token) {
		return blackList.contains(token);
	}
	
}
