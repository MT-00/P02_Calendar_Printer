//////////////// FILE HEADER  //////////////////////////
//
// Title:   P02 Calendar Printer
// Files:   CalendarPrinter.java, CalendarTester.java
// Course:  CS 300, Spring 2020
//
// Author:  Meng Tian
// Email:   mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
import java.util.ArrayList;
import java.util.Scanner;

public class CalendarPrinter {
	/**
	 * Calculates the number of centuries (rounded down) between year 0 and the
	 * specified year. For example, the year 2034 has the century index of 20 (as do
	 * the other years 2000-2099).
	 * 
	 * @param year to compute the century offset for
	 * @return number of centuries between year 0 and the specified year
	 */
	public static int fullCenturiesContained(Year year) {

		int numCenturies = year.intValue() / 100;// retrieve the number of year in the Year type variable
		// calculates the number of centuries by divide 100
		// the int type automatically rounds it down
		return numCenturies;
	}

	/**
	 * Calculates the number of years between the specified year and the first year
	 * of its century. For example, the year 2034 has the offset within its century
	 * of 34 (as do 1234 and 9999934).
	 * 
	 * @param year to compute the offset within century for
	 * @return number of years between the specified year and the first year of
	 *         century
	 */
	public static int yearOffsetWithinCentury(Year year) {

		int yearOffset = year.intValue();// retrieve the number of year in the Year type variable
		int initialYear = (yearOffset / 100) * 100;// get the numbers without the unit digit and tens digit
		return yearOffset - initialYear;// calculate to get the numbers on unit digit and tens digit
	}

	/**
	 * This method computes whether the specified year is a leap year or not.
	 * 
	 * @param year is the year is being checked for leap-year-ness
	 * @return true when the specified year is a leap year, and false otherwise
	 */
	public static boolean isLeapYear(Year year) {
		int checkedYear = year.intValue();// retrieve the number of year in the Year type variable
		// check if the given year is leap year
		if (checkedYear % 4 == 0 && checkedYear % 100 != 0) {
			return true;
		} else if (checkedYear % 400 == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Calculates the number of days in the specified month, while taking into
	 * consideration whether or not the specified month is in a leap year. Note:
	 * that this is calculated based on the month's monthOfYear and year, and is NOT
	 * retrieved from the month's getDayCount() method. This is because this method
	 * is used to generate the day objects that are stored within each month.
	 * 
	 * @param month to determine the number of days within (within its year)
	 * @return the number of days in the specified month (between 28-31)
	 */
	public static int numberOfDaysInMonth(Month month) {
		Year yearNum1 = month.getYear();// retrieve the year number in the Month type variable
		MonthOfYear monthOfYear1 = month.getMonthOfYear();// retrieve the name of month in the Month type variable
		if (monthOfYear1 == MonthOfYear.February) {// check if it is February
			if (isLeapYear(yearNum1) == true) {// check if the year is leap year
				return 29;// if it is, return 29
			} else
				return 28;// if it is not, return 28
			//if it is not February, check if it is the month listed below
		} else if ((monthOfYear1 == MonthOfYear.January) || (monthOfYear1 == MonthOfYear.March)
				|| (monthOfYear1 == MonthOfYear.May) || (monthOfYear1 == MonthOfYear.July)
				|| (monthOfYear1 == MonthOfYear.August) || (monthOfYear1 == MonthOfYear.October)
				|| (monthOfYear1 == MonthOfYear.December)) {
			return 31;// if it is, return 31

		} else {
			return 30;// if it is not, return 30
		}

	}

	/**
	 * Calculates which day of the week the first day of the specified month falls
	 * on. Note: that this is calculated based on the month's monthOfYear and year,
	 * and is NOT retrieved from the month's getDayByDate(1) day. This is because
	 * this method is used to generate the day objects that are stored within each
	 * month.
	 * 
	 * @param month within which we are calculate the day of week for the first day
	 * @return DayOfWeek corresponding to the first day within the specified month
	 */
	public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
		Year yearNum2 = month.getYear();//retrieve the year number in the Month type variable
		MonthOfYear month2 = month.getMonthOfYear();// retrieve the name of month in the Month type variable
		int m = 0;// initialize the month number
		// match the name of month and the month number
		if (month2 == MonthOfYear.January) {
			m = 13;
		} else if (month2 == MonthOfYear.February) {
			m = 14;
		} else if (month2 == MonthOfYear.March) {
			m = 3;
		} else if (month2 == MonthOfYear.April) {
			m = 4;
		} else if (month2 == MonthOfYear.May) {
			m = 5;
		} else if (month2 == MonthOfYear.June) {
			m = 6;
		} else if (month2 == MonthOfYear.July) {
			m = 7;
		} else if (month2 == MonthOfYear.August) {
			m = 8;
		} else if (month2 == MonthOfYear.September) {
			m = 9;
		} else if (month2 == MonthOfYear.October) {
			m = 10;
		} else if (month2 == MonthOfYear.November) {
			m = 11;
		} else
			m = 12;
        // according to the formula, if the month is January or February, it belongs to the previous month
		int yearNum3 = yearNum2.intValue();
		if ((m == 13) || (m == 14)) {
			yearNum3 = yearNum3 - 1;
		}
		// apply the given formula
		int K = yearNum3 % 100;// set the year of the century
		int q = 1;// set the day of month equals 1
		int J = yearNum3 / 100;// set the zero based century
		int firstFloor = 13 * (m + 1) / 5;
		int secondFloor = K / 4;
		int thirdFloor = J / 4;
		int h = (q + firstFloor + K + secondFloor + thirdFloor + 5 * J) % 7;
        // according to the result, return the date of the first day of the week of given month
		if (h == 0) {
			return DayOfWeek.Saturday;
		} else if (h == 1) {
			return DayOfWeek.Sunday;
		} else if (h == 2) {
			return DayOfWeek.Monday;
		} else if (h == 3) {
			return DayOfWeek.Tuesday;
		} else if (h == 4) {
			return DayOfWeek.Wednesday;
		} else if (h == 5) {
			return DayOfWeek.Thursday;
		} else
			return DayOfWeek.Friday;

	}

	/**
	 * Calculates the day of the week that follows the specified day of week. For
	 * example, Thursday comes after Wednesday, and Monday comes after Sunday.
	 * 
	 * @param dayBefore is the day of week that comes before the day of week
	 *                  returned
	 * @return day of week that comes after dayBefore
	 */
	public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
		// according to the given date, return the day after in DayOfWeek type
		if (dayBefore == DayOfWeek.Sunday) {
			return DayOfWeek.Monday;
		} else if (dayBefore == DayOfWeek.Monday) {
			return DayOfWeek.Tuesday;
		} else if (dayBefore == DayOfWeek.Tuesday) {
			return DayOfWeek.Wednesday;
		} else if (dayBefore == DayOfWeek.Wednesday) {
			return DayOfWeek.Thursday;
		} else if (dayBefore == DayOfWeek.Thursday) {
			return DayOfWeek.Friday;
		} else if (dayBefore == DayOfWeek.Friday) {
			return DayOfWeek.Thursday;
		} else
			return DayOfWeek.Sunday;

	}

	/**
	 * Calculates the month of the year that follows the specified month. For
	 * example, July comes after June, and January comes after December.
	 * 
	 * @param monthBefore is the month that comes before the month that is returned
	 * @return month of year that comes after monthBefore
	 */
	public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
		// according to the given month, return the month after in MonthOfYear type
		if (monthBefore == MonthOfYear.January) {
			return MonthOfYear.February;
		} else if (monthBefore == MonthOfYear.February) {
			return MonthOfYear.March;
		} else if (monthBefore == MonthOfYear.March) {
			return MonthOfYear.April;
		} else if (monthBefore == MonthOfYear.April) {
			return MonthOfYear.May;
		} else if (monthBefore == MonthOfYear.May) {
			return MonthOfYear.June;
		} else if (monthBefore == MonthOfYear.June) {
			return MonthOfYear.July;
		} else if (monthBefore == MonthOfYear.July) {
			return MonthOfYear.August;
		} else if (monthBefore == MonthOfYear.August) {
			return MonthOfYear.September;
		} else if (monthBefore == MonthOfYear.September) {
			return MonthOfYear.October;
		} else if (monthBefore == MonthOfYear.October) {
			return MonthOfYear.November;
		} else if (monthBefore == MonthOfYear.November) {
			return MonthOfYear.December;
		} else
			return MonthOfYear.January;

	}

	/**
	 * Creates a new month object and fully initializes with its corresponding days.
	 * 
	 * @param monthOfYear which month of the year this new month represents
	 * @param year        in which this month is a part
	 * @return reference to the newly created month object
	 */
	public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
		// create a new month with given MonthOfYear and Year
		Month month4 = new Month(monthOfYear, year);
		for (int b = 1; b <= CalendarPrinter.numberOfDaysInMonth(month4);b++) {
      Day newday2 = new Day(CalendarPrinter.calcFirstDayOfWeekInMonth(month4),b, month4);
      month4.addDay(newday2);
    }
		return month4;
	}

	/**
	 * Prints the contents of the specified month object in calendar form. This
	 * printout should begin with the Month an year of the month. The next line
	 * should contain the three letter abbreviations for the seven days of the week.
	 * And then the dates of each day of that month should follow: one week per
	 * line, with periods in positions of days that are a part of the month before
	 * or after. For example, January 2020 should be printed as follows:
	 *
	 * January 2020 MON TUE WED THU FRI SAT SUN . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14
	 * 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 . .
	 *
	 * @param month which is to be printed by this method
	 */
	public static void printMonth(Month month) {
		// get the MonthOfYear and Year within the Month variable
		MonthOfYear monthOfYr = month.getMonthOfYear();
		Year yearNum6 = month.getYear();
		System.out.println(monthOfYr + " " + yearNum6);// print out the required month and year number
		System.out.println("MON TUE WED THU FRI SAT SUN");// print out the headline
		DayOfWeek startDate = CalendarPrinter.calcFirstDayOfWeekInMonth(month);// compute the first day of week in given month
		// set a number to the first day of week for later calculation
		int j = 0;
		if (startDate == DayOfWeek.Monday) {
			j = 0;
		} else if (startDate == DayOfWeek.Tuesday) {
			j = 1;
		} else if (startDate == DayOfWeek.Wednesday) {
			j = 2;
		} else if (startDate == DayOfWeek.Thursday) {
			j = 3;
		} else if (startDate == DayOfWeek.Friday) {
			j = 4;
		} else if (startDate == DayOfWeek.Saturday) {
			j = 5;
		} else
			j = 6;
		// print out the dots for the day before the first day of the week of given month
		for (int k = 0; k < j; k++) {
			System.out.print(" "+"." + "  ");
		}
        
		int days = CalendarPrinter.numberOfDaysInMonth(month);// get the total number of days in given month
		for (int i = 0; i < days; i++) {
			// categorize the day number with tens digit and its without tens digit with different number of spaces
			if(i + 1 < 10) {
			System.out.print(" "+ (i + 1) + "  ");}
			else
				System.out.print(" "+(i + 1) + " ");
			// one week per line
			if ((i + j + 1) % 7 == 0) {
				System.out.print("\n");
			}
		}
		// print out the dots for the day after the last day of the last week of given month
		int residue = 7 - (days + j) % 7;
		for (int m = 0; m < residue; m++) {
				System.out.print(" "+ "." + "  ");
			}
		// change to another line
		System.out.print("\n");

	}

	/**
	 * Creates an array list of months that are initialized with their full
	 * complement of days. Prints out each of these months in calendar form, and
	 * then returns the resulting ArrayList.
	 * 
	 * @param month of the year for the first month that is created and printed
	 * @param year  that the first month created and printed is a part of
	 * @param count is the total number of sequential months created and printed
	 */
	public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {
		Month monthBefore = CalendarPrinter.createNewMonth(month, year);// initialize a Month for the starting month
		// store the number of days included in that month
		for (int a = 1; a <= CalendarPrinter.numberOfDaysInMonth(monthBefore);a++) {
			Day newday = new Day(CalendarPrinter.calcFirstDayOfWeekInMonth(monthBefore),a, monthBefore);
			monthBefore.addDay(newday);
		}
		MonthOfYear monthIndex = month;// get the name of the starting month
		ArrayList<Month> monthList = new ArrayList<Month>();// create a list for all months need to be printed
		monthList.add(monthBefore);// add the starting month in it first
		for (int i = 0; i < count-1; i++) {// the number of loop is the number of total months needed minus one (as the starting month is the number 0)
			MonthOfYear monthAfterOfYr = CalendarPrinter.monthOfYearAfter(monthIndex);// get the name of the following month
			// the month after December will be the month in a new year
			if (monthIndex == MonthOfYear.December) {
				int yearValue = year.intValue();
				yearValue = yearValue +1;
				year = new Year(yearValue);
			}
			Month monthAfter = new Month(monthAfterOfYr, year);// create a Month for the following month
			// store the number of days included in that month
			for (int b = 1; b <= CalendarPrinter.numberOfDaysInMonth(monthAfter);b++) {
				Day newday2 = new Day(CalendarPrinter.calcFirstDayOfWeekInMonth(monthAfter),b, monthAfter);
				monthAfter.addDay(newday2);
			}
			monthList.add(monthAfter);// add the following month in the arraylist
			monthIndex = monthAfterOfYr;// change the monthBefore to the following month in order to do calculation after
		}
		// print months by applying the printMonth method
		for (int m = 0; m < count; m++) {
			CalendarPrinter.printMonth(monthList.get(m));
		}

        return monthList;
		
	}
	
	/**
	* Driver for the CalendarPrinter Application. This program asks the user to enter
	* an initial month, an initial year, and the total number of months to create and
	* display in calendar form.
	* @param args is not used by this program
	*/
	public static void main(String[] args) {
		 //print welcome message
		 Scanner in = new Scanner(System.in);
		 System.out.println("Welcome to the Calendar Printer.");
		 System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
		 // read input from the user
		 System.out.print("Enter the month to begin calendar: ");
		 String monthString = in.nextLine().trim();
		 System.out.print("Enter the year to begin calendar: ");
		 String yearString = in.nextLine().trim();
		 System.out.print("Enter the number of months to include in this calendar: ");
		 String countString = in.nextLine().trim();
		 // convert user input into usable form
		 monthString = monthString.substring(0,3).toUpperCase();
		 MonthOfYear month = null;
		 for(int i=0;i<MonthOfYear.values().length;i++)
		if(monthString.equals(MonthOfYear.values()[i].name().substring(0,3).toUpperCase()))
		 month = MonthOfYear.values()[i];
		 Year year = new Year(Integer.parseInt(yearString.trim()));
		 int count = Integer.parseInt(countString.trim());
		 // create months and display them in calendar form
		 System.out.println();
		 createAndPrintMonths(month,year,count);
		 // display thank you message
		 System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
		 System.out.println("Thanks, and have a nice day.");
		 in.close();
		}

	}

