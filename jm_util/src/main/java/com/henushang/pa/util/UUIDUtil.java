package com.henushang.pa.util;

import java.util.UUID;

public class UUIDUtil {
	
	public static String getId() {
		UUID id = UUID.randomUUID();
		return id.toString().replaceAll("-", "");
	}
	
	
	public static void main(String[] args) {
		System.out.println(getId());
		System.out.println(getId().length());
	}
}
