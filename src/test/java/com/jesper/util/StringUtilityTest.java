package com.jesper.util;

import static org.junit.Assert.fail;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testGenerateFileWithUniqueLines_CharacterCheck() {
		String randomString = StringUtility.getRandomString(50);
		if(!randomString.matches("[A-Za-z0-9]+"))
			fail("Non alphanumeric characters found");
	}
	
	@Test
	public void testGenerateFileWithUniqueLines_RandomCheck() {
		String randomString = StringUtility.getRandomString(50);
		String randomString2 = StringUtility.getRandomString(50);
		if(randomString.contentEquals(randomString2))
			fail("two strings with same characters found");
	}


}
