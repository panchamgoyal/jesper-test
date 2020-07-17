package com.jesper.util;

public class StringUtility {

	private final static String APLHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"
			+ "abcdefghijklmnopqrstuvxyz";
	
	public static String getRandomString(int n) {
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (APLHANUMERIC.length() * Math.random());
			sb.append(APLHANUMERIC.charAt(index));
		}
		return sb.toString();
	}

}
