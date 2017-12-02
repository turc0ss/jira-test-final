package com.tmattila.service;

import com.tmattila.model.Dates;

/***
 * DateService interface
 * @author Tapio Mattila
 *
 */
public interface DateService {
	/***
	 * saveDateToRepository method that uses Dates model as a parameter
	 * @param dateDAO
	 */
	void saveDateToRepository(Dates dateDAO);
}




