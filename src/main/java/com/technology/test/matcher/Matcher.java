package com.technology.test.matcher;

/**
 * Matcher interface
 * @author ravi
 *
 */
public interface Matcher {
	
	boolean match(String inputString);
	
	String getType();
	
	boolean isInputStringRelevant();
}
