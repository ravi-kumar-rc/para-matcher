package com.technology.test.matcher;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.technology.test.matcher.util.MatcherStackPrototype;

/**
 * Matcher implementation for the parantheses type
 * 
 * @author ravi
 *
 */
public class ParanthesesMatcher implements Matcher {

	// Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(ParanthesesMatcher.class);
	
	// Flag to indicate the relevance of the input string with respect to the matcher type
	private boolean inputStringRelevant;
	
	// For iterating through each character in the input string
	private char c;
	
	/**
	 * Overridden implementation of the matching
	 * 
	 * @param inputString
	 * 			- string provided by the user
	 * @return boolean
	 * 			- true: if the string is valid and has matching parantheses
	 * 			- false: if either is invalid and doesn't have matching parantheses or its not relevant to this matcher at all.
	 */
	@Override
	public boolean match(String inputString) {
		
		LOGGER.info("Matching initiated...");
		
		Stack<Character> matcherStack = MatcherStackPrototype.getMatcherStack(); 
		
		LOGGER.info("Matcher prototype constructuted...");
		
		LOGGER.info("Checking for input string relevance w.r.t this matcher");
		
		if(!inputString.contains("(") && !inputString.contains(")")) {
			inputStringRelevant = false;
			return false;
		}
		
		LOGGER.info("Successfully tested string relevance...");
		
		LOGGER.info("Starting to iterate through each character in the string...");
		
		for(int i = 0;i < inputString.length();i++) {
			c = inputString.charAt(i);
			if(c == '(') {
				matcherStack.push(c);
			} else if(c == ')'){
				if(matcherStack.empty()) {
					return false;
				} else {
					char temp = matcherStack.peek();
					if(temp == '(') {
						matcherStack.pop();
					} else {
						return false;
					}
				}
			}
		}
		
		return matcherStack.empty();
	}

	// --------------- GETTERS & SETTERS ------------------
	@Override
	public String getType() {
		return "Parantheses";
	}
	
	@Override
	public boolean isInputStringRelevant() {
		return inputStringRelevant;
	}
	
	
}
