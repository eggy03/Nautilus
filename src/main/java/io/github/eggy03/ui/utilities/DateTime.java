package io.github.eggy03.ui.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import io.github.eggy03.ui.common.ExceptionUI;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateTime {
	private DateTime() {
		throw new IllegalStateException("Utility Class");
	}

	public static String getDate() {
		try {
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
			Date myDate = sdf.parse(ldt.format(dtf));
			sdf.applyPattern("EEEEE, d MMMMM yyyy");
			return sdf.format(myDate);
		} catch (ParseException e) {
			new ExceptionUI("Date Parsing Error", e.getMessage()+"\nPlease refer to the logs for more information.");
			log.error("Date Time Parsing Error: ",e);
			return "Date Unavailable";
		}
	}
}
