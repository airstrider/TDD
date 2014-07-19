package com.ryan;

import junit.framework.TestCase;

public class SubDateTest extends TestCase {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(SubDateTest.class);
	}
	
	//Test method for calculating total days from A.D 1 to previous year 
	public void testGetYearDay() {
		//Assumption: 00000000 doesn't exist
		//(e.g.) 0001010100:00:01(YYYYMMDDhh:mm:ss) has passed 0 day
		assertEquals(0,SubDate.getYearDay(1));
		
		//(e.g.) 0002010100:00:01(YYYYMMDDhh:mm:ss) has passed 365 days
		assertEquals(365,SubDate.getYearDay(2));
		
		assertEquals(365+365+365+366,SubDate.getYearDay(5));		
	}
	
	//Test method for checking whether a given year is a leap year
	public void testLeapYear() {
		assertTrue(SubDate.isLeapYear(0));
		assertFalse(SubDate.isLeapYear(1));
		assertTrue(SubDate.isLeapYear(4));
		assertTrue(SubDate.isLeapYear(1200));
		assertFalse(SubDate.isLeapYear(700));
	}
	
	//Test method for calculating accumulated days from January to previous month of this year
	public void testGetMonthDay() {
		assertEquals(0,SubDate.getMonthDay(1, true));
		assertEquals(31,SubDate.getMonthDay(2, true));
		assertEquals(31+28,SubDate.getMonthDay(3, false));
		assertEquals(31+29,SubDate.getMonthDay(3, true));
	}
	
	//Test method for calculating accumulated days from the first day to today of this month 
	public void testGetTotalDay() {
		assertEquals(1, SubDate.getTotalDay("00010101"));
		assertEquals(366, SubDate.getTotalDay("00020101"));
		assertEquals(366+365+365, SubDate.getTotalDay("00040101"));
		assertEquals(366+365+365+366, SubDate.getTotalDay("00050101"));
	}
	
	//Test method for calculating the day(s) between two given dates
	public void testSubDate() {
		assertEquals(18, SubDate.sub("20140719","20140701"));
		assertEquals(31+28+31+30+31+30+18, SubDate.sub("20140101","20140719"));
	}
}
