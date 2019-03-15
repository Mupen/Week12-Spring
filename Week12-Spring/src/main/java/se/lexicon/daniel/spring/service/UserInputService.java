package se.lexicon.daniel.spring.service;

public interface UserInputService {
	
	/**
	 * Get String which is not just empty space
	 * 
	 * @return correct String
	 */
	
	 String getString(String inputString);
	
	/**
	 * Check the string is number with in range of Integer or not, until you get a
	 * correct number
	 * 
	 * @return correct number
	 */
	
	Integer getInteger(Integer number);

}
