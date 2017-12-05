package com.tmattila.utils;

/***
 * Enum class DateStringUtils that holds the string representations that are used in the application.
 * @author Tapio Mattila
 *
 */
public enum DateStringUtils {

	HEADER_TEXT("Welcome to date storage application ---- jira test smart 6666 ----"),
	BUTTON_TEXT("Click to save the time of button press to database"),
	DATE_TEXT("Date and time of button press: "),
	DATE_TITLE("DATE"),
	DATE_TEST_TITLE("TEST");
	
	/***
	 * Set the string variable to use.
	 */
	private final String string;
	
	/***
	 * DateStringUtils constructor.
	 * @param string
	 */
	private DateStringUtils(final String string) {
		this.string = string;
	}
	
	/***
	 * GetString method to show the string representation.
	 * @return string
	 */
	public String getString() {
		return string;
	}
}



