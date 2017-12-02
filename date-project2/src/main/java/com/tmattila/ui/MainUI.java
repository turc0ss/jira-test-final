package com.tmattila.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmattila.model.Dates;
import com.tmattila.service.DateService;
import com.tmattila.utils.DateStringUtils;
import com.tmattila.utils.LoggingMessages;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/***
 * MainUI class that holds all the ui related components. Extends vaadin UI class.
 * @author Tapio Mattila
 *
 */
@SuppressWarnings("serial")
@Theme("valo")
@Title("Date Project")
@SpringUI(path = "/ui")
public class MainUI extends UI {

	/***
	 * Logger class initialization for MainUI class. 
	 * This class is used to print log messages.
	 */
	private static final Logger logger = LogManager.getLogger(MainUI.class);

	/***
	 * MainLayout component rootLayout.
	 */
	private VerticalLayout rootLayout;

	/***
	 * HorizontalLayout that holds the headerLayout.
	 */
	private HorizontalLayout headerLayout;

	/***
	 * Own horizontalLayout to hold buttonLayout.
	 */
	private HorizontalLayout buttonLayout;

	/***
	 * HorizontalLayout that holds dateMarkings. 
	 * Is used to show the dates in the browser.
	 */
	private HorizontalLayout dateMarkings;

	/***
	 * Label that holds header text.
	 */
	private Label headerLabel;

	/***
	 * Button that is used to print dates to browser and save to database.
	 */
	private Button dateButton;

	/***
	 * Date class that is recording the currect time and date.
	 */
	private Date date;

	/***
	 * DateFormat class that uses SimpleDateFormat to format the date in custom form.
	 */
	private DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	/***
	 * Dates entity that holds the information that is saved in to database.
	 */
	private Dates dates;

	@Override
	protected final void init(final VaadinRequest request) {
		
		logger.debug(LoggingMessages.START_PROGRAM.getString());
		
		dates = new Dates();

		rootLayout = new VerticalLayout();
		headerLayout = new HorizontalLayout();

		headerLabel = new Label("<h2><b>" + DateStringUtils.HEADER_TEXT.getString() + "</b></h2>", ContentMode.HTML);
		headerLayout.addComponent(headerLabel);

		buttonLayout = new HorizontalLayout();
		buttonLayout.setMargin(false);
		buttonLayout.setSpacing(false);
		
		dateButton = new Button(DateStringUtils.BUTTON_TEXT.getString());
		dateMarkings = new HorizontalLayout();

		dateButton.addClickListener(e -> {
			
			try {
				buildLayout();
			} catch (Exception error) {
				logger.error(LoggingMessages.DATE_PRINT_ERROR.getString());
				error.printStackTrace();
			}
			
		});

		buttonLayout.addComponent(dateButton);

		rootLayout.addComponent(headerLabel);
		rootLayout.addComponent(buttonLayout);
		setContent(rootLayout);
	}
	
	/***
	 * Autowired DateService interfac to be able to save dates in to database through service class.
	 */
	@Autowired
	private DateService dateService;
	
	/***
	 * BuildLayout method to seperate layout creation to its own method.
	 */
	private void buildLayout() {

		logger.debug(LoggingMessages.DATE_PRINT_ENTER.getString());

		date = new Date();
		String formattedDate = dateF.format(date);

		Label timeLabel = new Label("<b>" + DateStringUtils.DATE_TEXT.getString() + " </b>", ContentMode.HTML);
		Label dateLabel = new Label(timeLabel.getValue() + formattedDate, ContentMode.HTML);
		
		saveDate();
		
		dateMarkings.addComponent(dateLabel);
		rootLayout.addComponent(dateLabel);
		
		logger.info(LoggingMessages.DATE_PRINT.getString() + ": " + formattedDate);
		logger.debug(LoggingMessages.DATE_PRINT_EXIT.getString());
	}
	
	/***
	 * SaveDate method to seperate saving data to database on its own method and to include try catch block to check errors.
	 */
	private void saveDate() {
		try {
			dateService.saveDateToRepository(dates);
			logger.debug(LoggingMessages.DATE_SAVED_TO_DB.getString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(LoggingMessages.DATE_SAVE_ERROR.getString());
		}
	}
}




