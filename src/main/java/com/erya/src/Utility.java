package com.erya.src;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * this class contains the utility methods
 * @author helkarii
 *
 */
public class Utility {

	/**
	 * Allows to read a file
	 * @param filePath
	 * @return list of String containing the lines of the file
	 */
	public static List<String> readFileLineByLine(String filePath) {
		List<String> list = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			 list = stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	/**
	 * convert a string to a list of string 
	 * @param str
	 * @return a list of string 
	 */
	public static List<String> convertStringToListWithDelimiter(String str) { 
		   String[] items = str.split(" ");
		      List<String> itemList = Arrays.asList(items);
      return itemList; 
    } 
	

}
