package com.springer.challenge.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
	/**
	 * This function will split the string based on white spaces in this case normal space and tab.
	 * @param data string command like c w h
	 * @return list of string of the data command
     */
	public static List<String> parse(String data) {
		List<String> list = new ArrayList<String>();
		if(null == data || data.isEmpty()) {
			return list;
		}
		int i=0;
		for(;i<data.length();i++) {
			char ch = data.charAt(i);
			if(ch == ' ' || ch == '\t') {
				continue;
			}
			break;
		}
		if(i!=0) {
			data = data.substring(i);
		}
		String[] tokensVal = data.split("[\\s\\t]+");//( "\\s+|\t");
		list = new ArrayList<String>(Arrays.asList(tokensVal));

		return list;
	}
}
