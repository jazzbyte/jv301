package com.varxyz.jv301.service;

import java.util.HashMap;
import java.util.Map;


/**
 * 서블릿 scope을 대체하는 사용자 정의 비즈니스 네이밍 서비스
 * 
 * @author Sage R Lee
 *
 */
public class NamingService {
	private static NamingService theObject = new NamingService();
	private Map<String, Object> nameValuePairs;

	private NamingService() {
		nameValuePairs = new HashMap<String, Object>();
	}

	public static NamingService getInstance() {
		return theObject;
	}

	public Object getAttribute(String name) {
		return nameValuePairs.get(name);
	}

	public void setAttribute(String name, Object object) {
		if (!nameValuePairs.containsKey(name)) {
			nameValuePairs.put(name, object);
		} else {
			throw new IllegalArgumentException("This name, " + name
					+ ", is already in use.");
		}
	}

	public void removeAttribute(String name) {
		nameValuePairs.remove(name);
	}

}
