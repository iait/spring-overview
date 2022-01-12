package com.example.com.example.util;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class CalendarFactory implements FactoryBean<Calendar> {

	private final Calendar instance = Calendar.getInstance();

	@Override
	public Calendar getObject() throws Exception {
		return instance;
	}

	@Override
	public Class<?> getObjectType() {
		return Calendar.class;
	}

	public void addDays(int days) {
		instance.add(Calendar.DAY_OF_YEAR, days);
	}
}
