package com.jesper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.jesper.util.StringUtility;

public class App {

	public static void generateFileWithUniqueLines(int lines, String filePath) {
		try {
			Path path = Paths.get(filePath);
		} catch (InvalidPathException e) {
			throw new IllegalArgumentException("Invalid Path");
		}
		
		File file = new File(filePath);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for (int i = 0; i < lines; i++) {
				bw.write(StringUtility.getRandomString(100));
				bw.newLine();
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
