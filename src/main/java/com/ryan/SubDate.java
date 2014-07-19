package com.ryan;

public class SubDate {
	
	static int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	//Method for calculating total days from A.D 1 to the previous year of the given date 
	public static int getYearDay(int year) {
		int result = 0;
		for (int i=1; i < year; i++) {
			if(isLeapYear(i)) result += 366;
			else result += 365;
		}
		return result;
	}
	
	//Method for checking whether a specific year is a leap year
	public static boolean isLeapYear(int year) {
		if(year % 400 == 0) return true; // Year 1200 is leap years
		if(year % 100 == 0) return false;// Year 700 is not a leap year
		if(year % 4 == 0) return true;	 //	Year 400 is a leap year
		return false;
	}
	
	//Method for calculating total days from January to the previous month of the given date
	//For example, if the given year is 20140719, the range for the calculation is between January and June
	public static int getMonthDay(int month, boolean isLeap) {
		int result = 0;
		for(int i=1;i < month; i++) {
			result += months[i-1];
		}
		if(isLeap && month > 2) result += 1;
		return result;
	}

	//Method for calculating accumulated days from A.D 1 to the given date
	public static int getTotalDay(String date) {
		int result = 0;
		int year = getYearDay(Integer.parseInt(date.substring(0,4)));
		int month = getMonthDay(Integer.parseInt(date.substring(4,6)), isLeapYear(year));
		int day = Integer.parseInt(date.substring(6,8));
		result = year+month+day;
		return result;
	}
	
	//Method for calculating the day(s) between two given dates
	public static int sub(String date1, String date2) {
		return Math.abs(getTotalDay(date1)-getTotalDay(date2));
	}
}
