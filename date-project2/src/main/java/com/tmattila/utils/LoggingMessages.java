package com.tmattila.utils;

/***
 * Enum class LoggingMessages that holds the string representations that are used in the application.
 * @author Tapio Mattila
 *
 */
public enum LoggingMessages {
	
	START_PROGRAM("Start program"),
	DATE_PRINT("Date created and printed on the browser"),
	DATE_PRINT_ERROR("Something went wrong, error printing date to browser"),
	DATE_PRINT_ENTER("Enter the button press, buildLayout() method."),
	DATE_PRINT_EXIT("Exit buildLayout()"),
	DATE_SAVED_TO_DB("Date saved to database"),
	DATE_SAVE_ERROR("Error saving date to database"),
	DATES_OBJECT_CREATED("New Dates object created"),
	SAVEDATETOREPOSITORY_ENTER("Enter saveDateToRepository()"),
	SAVEDATETOREPOSITORY_EXIT("Exit saveDateToRepository()");
	
	/***
	 * Set the string variable to use.
	 */
	private final String string;
	
	/***
	 * DateStringUtils constructor.
	 * @param string
	 */
	private LoggingMessages(final String string) {
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

