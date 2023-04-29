import java.util.*;
/*
 * Get a date (mon/day/year) from user. Print exact the week of dates 
 * (Sun to Sat). ex) input: 2/20/2001 if the day isWednesday 
 * output: Sunday 2/17/2001 
 * Monday 2/18/2001
 * Tuesday 2/19/2001 
 * Wednesday 2/20/2001
 * Thursday 2/21/2001 
 * Friday 2/22/2001 
 * Saturday 2/23/2001
 */

public class calendar{
	public static void main(String[] args){
		calendar("2/20/2002",3);
	}

	public static void calendar(String date, int calendar){
		int[] days_month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		String[] list = date.split("/");
		String[] res = new String[7];
		res[calendar] = printCalendar(calendar) + date;
		int year = Integer.parseInt(list[2]);
		int month = Integer.parseInt(list[0]);
		int day = Integer.parseInt(list[1]);
		int left = calendar;
		int right = 7-calendar-1;
		for(int i=1;i<=left;i++){
			day -= 1;
			if(day != 0){
				res[calendar-i] = printCalendar(calendar-i) + ""+month+"/"+day+"/"+year;
			}else{
				month -= 1;
				if(month != 0){
					day = (isLeapYear(year)&&month==2)?29:days_month[month];
					res[calendar-i] = printCalendar(calendar-i) + ""+month+"/"+day+"/"+year;
				}else{
					year -= 1;
					month = 12;
					day = 31;
					res[calendar-i] = printCalendar(calendar-i) + ""+month+"/"+day+"/"+year;
				}
			}
		}
		year = Integer.parseInt(list[2]);
		month = Integer.parseInt(list[0]);
		day = Integer.parseInt(list[1]);
		for(int i=1;i<=right;i++){
			day += 1;
			if(day == ((isLeapYear(year)&&month==2)?29:days_month[month])){
				day = 1;
				month += 1;
				if(month == 13){
					year += 1;
					month = 1;
					res[calendar+i] = printCalendar(calendar+i)+""+month+"/"+day+"/"+year;
				}else{
					res[calendar+i] = printCalendar(calendar+i)+""+month+"/"+day+"/"+year;
				}
			}else{
				res[calendar+i] = printCalendar(calendar+i)+""+month+"/"+day+"/"+year;
			}
		}
		System.out.println(Arrays.toString(res));
	}

	public static String printCalendar(int days){
		int select = days%7;
		switch(select){
			case 0:
			       return "Sunday";
			case 1:
			       return "Monday";
			case 2:
			       return "Tuesday";
			case 3:
			       return "Wednesday";
			case 4:
			       return "Thursday";
			case 5:
			       return "Friday";
			case 6:
			       return "Saturday";
		}
		return "";
	}

	public static boolean isLeapYear(int year){
		if(year%400==0 || (year%4==0 && year%100!=0)){
			return true;
		}else{
			return false;
		}
	}
}