package com.technology.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	
	private Main matcherMain;
	
	@Before 
	public void setup() {
		matcherMain = new Main();
	}
	
	@Test
	public void testValidReqestMatching() {
		String inputStringValid = "(a(b(c)def))";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(1);
		Assert.assertTrue(matcherMain.requestMatching());
		
		inputStringValid = "(a(bcd(,))987[)";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(1);
		Assert.assertTrue(matcherMain.requestMatching());
	}

	@Test
	public void testInvalidReqestMatching() {
		String inputStringInvalid = "((a(b(c)def))";
		matcherMain.setInputString(inputStringInvalid);
		matcherMain.setMatcherChoice(1);
		Assert.assertFalse(matcherMain.requestMatching());
	}
	
	@Test
	public void testValidBracketMatcherRequestMatching() {
		String inputStringValid = "[a[b[c]def]]";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(2);
		Assert.assertTrue(matcherMain.requestMatching());
	}

	@Test
	public void testInvalidBracketMatcherRequestMatching() {
		String inputStringValid = "[[a[b[c]def]]";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(2);
		Assert.assertFalse(matcherMain.requestMatching());
	}
	
	@Test
	public void testValidCurlMatcherRequestMatching() {
		String inputStringValid = "{a{b{c}def}}";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(3);
		Assert.assertTrue(matcherMain.requestMatching());
	}

	@Test
	public void testInvalidCurlMatcherRequestMatching() {
		String inputStringValid = "{{a{b{c}def}}";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(3);
		Assert.assertFalse(matcherMain.requestMatching());
	}

	@Test(expected=AssertionError.class)
	public void testInvalidMatcherRequestMatching1() {
		String inputStringValid = "{{a{b{c}def}}";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(1);
		Assert.assertTrue(matcherMain.requestMatching());
	}

	@Test
	public void testInvalidMatcherRequestMatching2() {
		String inputStringValid = "{{a{b{c}def}}";
		matcherMain.setInputString(inputStringValid);
		matcherMain.setMatcherChoice(1);
		Assert.assertFalse(matcherMain.requestMatching());
	}
}
