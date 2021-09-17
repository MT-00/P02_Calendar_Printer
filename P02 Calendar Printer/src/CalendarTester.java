//////////////// FILE HEADER  //////////////////////////
//
// Title:   P02 Calendar Printer
// Files:   CalendarPrinter.java, CalendarTester.java
// Course:  CS 300, Spring 2020
//
// Author:  Meng Tian
// Email:   mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
public class CalendarTester {
	/**
	 * Checks whether CalendarPrinter.fullCenturiesContained() method works as
	 * expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testFullCenturiesContained() {
		// use different number to test the fullCenuriesContained
		if (CalendarPrinter.fullCenturiesContained(new Year(204)) != 2)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20)
			return false;
		if (CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.yearOffsetWithinCentury() method works as
	 * expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testYearOffsetWithinCentury() {
		// use different year number to test the yearOffsetWithinCentury
		if (CalendarPrinter.yearOffsetWithinCentury(new Year(999934)) != 34)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.yearOffsetWithinCentury(new Year(2020)) != 20)
			return false;
		if (CalendarPrinter.yearOffsetWithinCentury(new Year(44444)) != 44)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.isLeapYear() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testIsLeapYear() {
		// use different year number to test the isLeapYear
		if (CalendarPrinter.isLeapYear(new Year(2000)) != true)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.isLeapYear(new Year(2020)) != true)
			return false;
		if (CalendarPrinter.isLeapYear(new Year(1234)) != false)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.numberOfDaysInMonth() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testNumberOfDaysInMonth() {
        // use different month and year number to test the numberOfDaysInMonth
		if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.June,new Year(1973))) != 30)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February,new Year(2000))) != 29)
			return false;
		if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February,new Year(1973))) != 28)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.calcFirstDayOfWeekInMonth() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testCalcFirstDayOfWeekInMonth() {
		// use different month and year number to test the calcFirstDayOfWeekInMonth
		if (CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.January,new Year(2019)) ) != DayOfWeek.Tuesday)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.December,new Year(2017))) != DayOfWeek.Friday)
			return false;
		if (CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.January,new Year(2004))) != DayOfWeek.Thursday)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.dayOfWeekAfter() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testDayOfWeekAfter() {
		// use different day(DayOfWeek) to test the dayOfWeekAfter
		if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Thursday) != DayOfWeek.Friday)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday) != DayOfWeek.Monday)
			return false;
		if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Tuesday) != DayOfWeek.Wednesday)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.monthOfYearAfter() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testMonthOfYearAfter() {
		// use different month(MonthOfYear) to test the monthOfYearAfter
		if (CalendarPrinter.monthOfYearAfter(MonthOfYear.April) != MonthOfYear.May)// check if the result matches the correct answer
			return false;
		if (CalendarPrinter.monthOfYearAfter(MonthOfYear.June) != MonthOfYear.July)
			return false;
		if (CalendarPrinter.monthOfYearAfter(MonthOfYear.December) != MonthOfYear.January)
			return false;
		return true;
	}

	/**
	 * Checks whether CalendarPrinter.createNewMonth() method works as expected.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testCreateNewMonth() {
		// use different month and year number to test the createNewMonth
		Month monthTest1 = new Month(MonthOfYear.April,new Year(2000));// set the answer by creating a new month object
		if (!CalendarPrinter.createNewMonth(MonthOfYear.April,new Year(2000)).getMonthOfYear().equals(monthTest1.getMonthOfYear())) // check if the MonthOfYear result matches the correct answer
	       return false;  
		if (CalendarPrinter.createNewMonth(MonthOfYear.April,new Year(2000)).getYear().intValue() != (monthTest1.getYear().intValue())) // check if the year number matches the correct answer
		       return false;  
		Month monthTest2 = new Month(MonthOfYear.June,new Year(2020));
        if (!CalendarPrinter.createNewMonth(MonthOfYear.June,new Year(2020)).getMonthOfYear().equals(monthTest2.getMonthOfYear()))
           return false;
        if (CalendarPrinter.createNewMonth(MonthOfYear.June,new Year(2020)).getYear().intValue() != (monthTest2.getYear().intValue())) 
		       return false;  
        Month monthTest3 = new Month(MonthOfYear.December,new Year(1997));
        if (!CalendarPrinter.createNewMonth(MonthOfYear.December,new Year(1997)).getMonthOfYear().equals(monthTest3.getMonthOfYear()))
	       return false;
        if (CalendarPrinter.createNewMonth(MonthOfYear.December,new Year(1997)).getYear().intValue() != (monthTest3.getYear().intValue())) 
		       return false;  
        return true;
        }
	
	/**
	 * Calls the test methods implemented in this class and displays their output
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		// apply all tests and print out the answer
		System.out.println("testFullCenturiesContained: " + testFullCenturiesContained());
		System.out.println("testYearOffsetWithinCentury: " + testYearOffsetWithinCentury());
		System.out.println("testIsLeapYear: " + testIsLeapYear());
		System.out.println("testDayOfWeekAfter: " + testDayOfWeekAfter());
		System.out.println("testMonthOfYearAfter: " + testMonthOfYearAfter());
        System.out.println("testNumberOfDaysInMonth: " + testNumberOfDaysInMonth());
		System.out.println("testCalcFirstDayOfWeekInMonth: " + testCalcFirstDayOfWeekInMonth());
		System.out.println("testCreateNewMonth: " + testCreateNewMonth());

	}
}
