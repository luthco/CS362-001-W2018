package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void testCalDay1()  throws Throwable  {
	  CalDay cal = new CalDay();
	  assertTrue(cal.isValid() == false);
	  
	 }
	 
	 @Test
	  public void testCalDay2()  throws Throwable  {
	  
	  Calendar rightnow = Calendar.getInstance();
	  int thisMonth = rightnow.get(Calendar.MONTH)+1;
	  int thisYear = rightnow.get(Calendar.YEAR);
	  int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	  GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
	  CalDay cal = new CalDay(today);
	  
	  assertTrue(cal.isValid() == true);
	 }

	 @Test
	  public void testaddApptAndToString()  throws Throwable  {
	  
	  Calendar rightnow = Calendar.getInstance();
	  int thisMonth = rightnow.get(Calendar.MONTH)+1;
	  int thisYear = rightnow.get(Calendar.YEAR);
	  int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	  GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
	  CalDay cal = new CalDay(today);
		  
	  int startHour=13;
	  int startMinute=30;
	  int startDay=20;
	  int startMonth=03;
	  int startYear=2018;
   	  String title="Birthday Party";
	  String description="This is my birthday party.";
	  //Construct a new Appointment object with the initial data	 
  	  Appt appt = new Appt(startHour,
	           startMinute ,
	           startDay ,
	           startMonth ,
	           startYear ,
	           title,
	           description);
		   
  	  Appt appt2 = new Appt(startHour,
	           startMinute ,
	           startDay ,
	           startMonth ,
	           startYear ,
	           title,
	           description);
  	  appt2.setStartHour(12);
  	  
  	  Appt appt3 = new Appt(startHour,
	           startMinute ,
	           startDay ,
	           startMonth ,
	           startYear ,
	           title,
	           description);
 	  appt3.setStartHour(14);
 	  
	  cal.addAppt(appt);
	  cal.addAppt(appt2);
	  cal.addAppt(appt3);
	  
	  cal.toString();
	  
	  assertTrue(cal.isValid() == true);
	 }

	 
}
