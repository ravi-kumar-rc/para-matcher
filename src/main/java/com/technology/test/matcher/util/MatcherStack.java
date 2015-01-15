package com.technology.test.matcher.util;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of a Stack for the matcher which is derived from the Java's Stack structure
 * The object is cloned (prototyped) everytime a user requests a string to be matched/validated
 * 
 * It is a singleton and will be instantiated once but can be cloned multiple times
 * 
 * @author ravi
 *
 */
public class MatcherStack extends Stack<Character> implements Cloneable {

	// Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(MatcherStack.class); 

	private static MatcherStack instance;
	
	/**
	 * Just here to avoid instantiation
	 */
	private MatcherStack() {}
	
	public static MatcherStack getInstance() {
		LOGGER.info("Creating a singleton instance of the MatcherStack...");
		if(instance == null) {
			instance = new MatcherStack();
		}
		return instance;
	}
	
	public Object clone() {
		LOGGER.info("Cloning singleton instance of the MatcherStack...");
		Object clone = super.clone();
		return clone;
	}
}
