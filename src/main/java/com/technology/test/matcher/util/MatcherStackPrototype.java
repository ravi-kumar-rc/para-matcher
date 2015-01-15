package com.technology.test.matcher.util;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a prototype of the matcher stack
 * @author ravi
 *
 */
public class MatcherStackPrototype {

	// Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(MatcherStackPrototype.class);
	
	private MatcherStackPrototype() {
		// Just here to avoid instantiaion
	}
	
	public static Stack<Character> getMatcherStack() {
		MatcherStack matcherStack = MatcherStack.getInstance();
		LOGGER.info("Creating and returning a prototype of the MatcherStack...");
		return (Stack<Character>) matcherStack.clone();
	}
}
