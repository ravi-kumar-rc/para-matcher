package com.technology.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.technology.test.matcher.BracketMatcher;
import com.technology.test.matcher.CurlyBraceMatcher;
import com.technology.test.matcher.Matcher;
import com.technology.test.matcher.ParanthesesMatcher;

/**
 * Main class for the application
 * @author ravi
 *
 */
public class Main {

	// Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class); 
	
	// User's choice of the matcher: 1 - Parantheses; 2 - Bracket; 3 - Curly Brace
	private int matcherChoice;
	
	// Input string provided by the user
	private String inputString;
	
	// Input stream reader
	private InputStreamReader isr;
	
	// Buffered reader to read from the console
	private BufferedReader br;
	
	// Flag to indicate the matcher hoice validity
	private boolean matcherChoiceValid;
	
	// Matcher implementation
	private Matcher matcher;
	
	// Flag to indicate input string validity
	private boolean inputStringValid;
	
	/**
	 * Constructor
	 * 	- Initialises the input stream and buffered readers
	 */
	public Main() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}
	
	/**
	 * Requests the user to choose a matcher type
	 */
	public void requestMatcherChoice() {
		System.out.println("----------MATCHER UTIL----------");
		
		// Loop iterates till the user chooses a valid matcher
		while(!matcherChoiceValid) {
		
			System.out.println("\nWhat do you want to match: ");
			System.out.println("1. Parantheses \"()\"");
			System.out.println("2. Bracket \"[]\"");
			System.out.println("3. Curly Brace \"{}\"");
			System.out.println("\nPlease enter your choice: ");
			
			try {
				matcherChoice = Integer.parseInt(br.readLine());
				if(matcherChoice < 1 || matcherChoice > 3) {
					System.out.println("\nSorry, matcher of your choice is not available. Please choose between 1 & 3.");
					matcherChoiceValid = false;
				} else {
					matcherChoiceValid = true;
				}
			} catch (NumberFormatException e) {
				LOGGER.info("Only integer values are accepted..." + e.getMessage());
				continue;
			} catch (IOException e) {
				LOGGER.info("Unable to read input..." + e.getMessage());
			}
		}
	}
	
	/**
	 * Requests input string from the user
	 */
	public void requestInputString() {
		
		while(!inputStringValid) {
			System.out.println("\nEnter an input string : ");
			try {
				inputString = br.readLine();
				if(inputString == null || inputString.trim().isEmpty()) {
					System.out.println("Enter a valid input string");
					inputStringValid = false;
				} else {
					inputStringValid = true; 
				}
			} catch (IOException e) {
				LOGGER.info("Unable to read input..." + e.getMessage());
			}
		}
	}
	
	/**
	 * Initiates the matching
	 * @return boolean
	 * 		- true: if the string contains valid matching type
	 * 		- false: if the string is irrelevant or doesn't have the matching type
	 */
	public boolean requestMatching() {
		switch(matcherChoice) {
			case 1:
				matcher = new ParanthesesMatcher();
				return matcher.match(inputString);
			
			case 2:
				matcher = new BracketMatcher();
				return matcher.match(inputString);
				
			case 3:
				matcher = new CurlyBraceMatcher();
				return matcher.match(inputString);
		}
		return false;
	}
	
	/**
	 * Entry point for the class
	 * @param args
	 */
	static public void main(String[] args) {
		Main m = new Main();
		m.requestMatcherChoice();
		m.requestInputString();
		LOGGER.info("Starting to match...");
		boolean matched = m.requestMatching();
		String matcherType = m.getMatcher().getType();
		if(matched) {
			System.out.println("\nInput string has matching " + matcherType);
		} else {
			if(!m.getMatcher().isInputStringRelevant()) {
				System.out.println("\nInput string does not contain " + matcherType + " at all"); 
				System.out.println("\nTry with another matcher type.");
			} else {
				System.out.println("Input string does not have matching " + matcherType);
			}
		}
	}
	
	// ----------- GETTERS & SETTERS --------------------
	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public Matcher getMatcher() {
		return matcher;
	}

	public int getMatcherChoice() {
		return matcherChoice;
	}

	public void setMatcherChoice(int matcherChoice) {
		this.matcherChoice = matcherChoice;
	}

}
