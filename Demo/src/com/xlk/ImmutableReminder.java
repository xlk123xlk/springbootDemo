package com.xlk;

import java.util.Date;

public final class ImmutableReminder {
	 
	private final Date date;
	
	public ImmutableReminder(Date date) {
		if (date.getTime() < System.currentTimeMillis()) {
			throw new IllegalArgumentException("Can not set reminder for past time: " + date);
		}
		this.date = new Date(date.getTime());
	}
 
	public Date getRemindingDate() {
		return (Date) date.clone();
	}
}

