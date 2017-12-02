package com.tmattila.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/***
 * Dates model with a mongodb @Document annotation to declare collection name to dates.
 * @author Tapio Mattila
 *
 */
@Document(collection = "dates")
public class Dates {
	
	/***
	 * String id, db field value "id".
	 */
	@Id
	private String id;
	
	/***
	 * String title, db field value "Title:".
	 */
	@Field(value="Title:")
	private String title;
	
	/***
	 * Variable Date for setting new date.
	 */
	private Date date;
	
	/***
	 * String formattedDate, db field value "Date:".
	 */
	@Field(value = "Date:")
	private String formattedDate;
	
	/***
	 * Dates constructor.
	 */
	public Dates() {
		
	}
	/***
	 * Getter for the title.
	 * @return title
	 */
	public final String getTitle() {
		return title;
	}

	/***
	 * Setter for the title.
	 * @param title
	 */
	public final void setTitle(final String title) {
		this.title = title;
	}

	/***
	 * Getter for the date.
	 * @return date
	 */
	public final Date getDate() {
		return this.date;
	}

	/***
	 * Setter for the date.
	 * @param date
	 */
	public final void setDate(final Date date) {
		this.date = new Date();
	}
	
	/***
	 * Getter for the formatted date.
	 * @return formattedDate
	 */
	public final String getFormattedDate() {
		return this.formattedDate;
	}

	/***
	 * Setter for the formatted date.
	 * @param formattedDate
	 */
	public final void setFormattedDate(final String formattedDate) {
		Date date = new Date();
		DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.formattedDate = dateF.format(date);
	}

	@Override
	public final String toString() {
		return "Dates [title=" + title + ", date=" + formattedDate + "]";
	}
}




