package com.he.implementations.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import com.he.implementation.AlienLanguageTranslator;
import org.junit.Test;

public class TestImplementation {
	
	private <T> ArrayList<String> getImplementations(Class<T> cls){
		Class<?>[] clss =  cls.getInterfaces();
		ArrayList<String> l = new ArrayList<String>();
		for (Class<?> c: clss){
			l.add(c.getName());
		}
		return l;
	}
	
	@Test
	public void testInterface(){
		List<String> implementations = getImplementations(AlienLanguageTranslator.class);
		boolean contains = false;
		
		for (String implementation: implementations){
			if (implementation.equals("com.he.implementation.LanguageTranslator"))
			{
				contains = true;
				break;
			}
		}
		
		if (!contains) throw new AssertionError();
	}
	
	@Test
	public void testTranslateToEnglish(){
		String langTokens = "kl";
		String expectedLangTokens = "hi";
		
		AlienLanguageTranslator translator = new AlienLanguageTranslator();
		String translated = translator.toDefaultLanguage(langTokens);
		
		Assert.assertEquals(expectedLangTokens, translated);
	}
	
	@Test
	public void testTranslateFromEnglish(){
		String langTokens = "Hi";
		String expectedLangTokens = "Kl";
		
		AlienLanguageTranslator translator = new AlienLanguageTranslator();
		String translated = translator.fromDefaultLanguage(langTokens);
		
		Assert.assertEquals(expectedLangTokens, translated);
	}
}
