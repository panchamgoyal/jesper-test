package com.jesper;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void testFileCreate() {
		String path = "output.txt";
		App.generateFileWithUniqueLines(50, path);
		
		try {
			FileInputStream fis = new FileInputStream(path);
			fis.close();
		} catch (FileNotFoundException e) {
			fail("Output file not created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFileLineLengthCheck() {
		String path = "output.txt";
		App.generateFileWithUniqueLines(50, path);
		try {
			FileInputStream fis = new FileInputStream(path);
			Scanner sc = new Scanner(fis);
			int lineNo = 0;
			while(sc.hasNextLine()) {
				lineNo ++;
				String line = sc.nextLine();
				if(line.length() != 100)
					fail("Line length not equal to 100 on line:" +lineNo);
			}
			fis.close();
			sc.close();
			if(lineNo != 50)
				fail("No of lines is not 50");
		} catch (FileNotFoundException e) {
			fail("Output file not created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCharacterCheck() {
		String path = "output.txt";
		App.generateFileWithUniqueLines(50, path);
		try {
			FileInputStream fis = new FileInputStream(path);
			Scanner sc = new Scanner(fis);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(!line.matches("[A-Za-z0-9]+"))
					fail("Non alphanumeric characters found");
			}
			sc.close();
			fis.close();
		} catch (FileNotFoundException e) {
			fail("Output file not created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMemory() {
		String path = "output.txt";
		long preUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024;
		App.generateFileWithUniqueLines(50, path);
		long postUsage = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024;
		if(postUsage - preUsage > 10240)
			fail("Using more than 10MB");
	}
	
}
