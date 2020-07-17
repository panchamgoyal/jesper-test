package com.jesper.util;

import static org.junit.Assert.fail;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testRandomString_CharacterCheck() {
		String randomString = StringUtility.getRandomString(50);
		if(!randomString.matches("[A-Za-z0-9]+"))
			fail("Non alphanumeric characters found");
	}
	
	@Test
	public void testRandomString_LengthCheck() {
		int inputLength = 50;
		String randomString = StringUtility.getRandomString(inputLength);
		if(randomString.length() != inputLength)
			fail("output string length is incorrect");
	}


}
