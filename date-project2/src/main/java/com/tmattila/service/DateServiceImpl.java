package com.tmattila.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmattila.model.Dates;
import com.tmattila.repository.DateRepository;
import com.tmattila.utils.DateStringUtils;
import com.tmattila.utils.LoggingMessages;

/***
 * DateServiceImpl service class that handles the connection to database.
 * @author Tapio Mattila
 *
 */
@Service
public class DateServiceImpl implements DateService {

	/***
	 * Logger class initialization for DateServiceImpl class.
	 * This class is used to print log messages.
	 */
	private static final Logger logger = LogManager.getLogger(DateServiceImpl.class);
	
	/***
	 * Autowired DateRepository interface to use repository methods inside DateServiceImpl classs
	 */
	@Autowired
	private DateRepository dateRepository;
	
	@Override
	public final void saveDateToRepository(final Dates dateDAO) {
		
		logger.debug(LoggingMessages.SAVEDATETOREPOSITORY_ENTER.getString());
		
		Dates dates = new Dates();
		logger.info(LoggingMessages.DATES_OBJECT_CREATED.getString());
		dates.setTitle(DateStringUtils.DATE_TITLE.getString());
		dates.setFormattedDate(dateDAO.getFormattedDate());
		logger.info(dates.toString());
		dateRepository.save(dates);
		
		logger.debug(LoggingMessages.SAVEDATETOREPOSITORY_EXIT.getString());
	}
}




