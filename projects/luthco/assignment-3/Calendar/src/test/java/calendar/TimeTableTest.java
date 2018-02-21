package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void testGetApptRange()  throws Throwable  {

	  TimeTable timeTable = new TimeTable();

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
 	  Appt appt = new Appt(13,30,20,03,2018,"B","D");
 	  Appt appt2 = new Appt(12,30,20,03,2018,"B","D");
 	  Appt appt3 = new Appt(14,30,20,03,2018,"B","D");
		Appt appt4 = new Appt(13,30,21,03,2018,"B","D");

		int[] arrayz = new int[0];
	  appt3.setRecurrence(arrayz, 3, 0, 2);

	  int[] arrayw = new int[0];
	  appt4.setRecurrence(arrayw, 1, 0, 2);

	  Appt appt5 = new Appt(12,30,21,03,2018,"Hello","Test Function");

	  LinkedList<Appt> arrays = new LinkedList<Appt>();
	  arrays.add(appt);
	  arrays.add(appt2);
	  arrays.add(appt3);
	  arrays.add(appt4);
	  arrays.add(appt5);

	  int[] arrayy = new int[3];
	  arrayy[0] = 1;
    arrayy[1] = 2;
	  arrayy[2] = 3;

	  appt5.setRecurrence(arrayy, 2, 0, 0);

	  GregorianCalendar firstDay = new GregorianCalendar(2018,03,20);
	  GregorianCalendar lastDay = new GregorianCalendar(2018,04,22);

	  timeTable.getApptRange(arrays, firstDay, lastDay);
	 }

	 @Test
	  public void testDeleteApp()  throws Throwable  {

			TimeTable timeTable = new TimeTable();

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
	 	  Appt appt = new Appt(13,30,20,03,2018,"B","D");
	 	  Appt appt2 = new Appt(12,30,20,03,2018,"B","D");
	 	  Appt appt3 = new Appt(14,30,20,03,2018,"B","D");
			Appt appt4 = new Appt(13,30,21,03,2018,"B","D");

			int[] arrayz = new int[0];
		  appt3.setRecurrence(arrayz, 3, 0, 2);

		  int[] arrayw = new int[0];
		  appt4.setRecurrence(arrayw, 1, 0, 2);

		  Appt appt5 = new Appt(12,30,21,03,2018,"Hello","Test Function");

	  LinkedList<Appt> arrays = new LinkedList<Appt>();

	  timeTable.deleteAppt(arrays, null);

	  arrays.add(appt);
	  arrays.add(appt2);
	  arrays.add(appt3);
	  arrays.add(appt4);
	  arrays.add(appt5);

	  timeTable.deleteAppt(arrays, appt3);

	  assertTrue(arrays.size() == 4);

	  Appt appt6 = new Appt(25,30,20,03,2018,"B","D");
	  arrays.add(appt6);

	  assertTrue(timeTable.deleteAppt(arrays, appt6) == null);
	 }

	 @Test
	  public void testPermutes()  throws Throwable  {

			TimeTable timeTable = new TimeTable();

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
	 	  Appt appt = new Appt(13,30,20,03,2018,"B","D");
	 	  Appt appt2 = new Appt(12,30,20,03,2018,"B","D");
	 	  Appt appt3 = new Appt(14,30,20,03,2018,"B","D");
			Appt appt4 = new Appt(13,30,21,03,2018,"B","D");

			int[] arrayz = new int[0];
		  appt3.setRecurrence(arrayz, 3, 0, 2);

		  int[] arrayw = new int[0];
		  appt4.setRecurrence(arrayw, 1, 0, 2);

		  Appt appt5 = new Appt(12,30,21,03,2018,"Hello","Test Function");

	  LinkedList<Appt> arrays = new LinkedList<Appt>();

	  arrays.add(appt);
	  arrays.add(appt2);
	  arrays.add(appt3);
	  arrays.add(appt4);
	  arrays.add(appt5);

	  int[] intts = new int[5];
	  intts[0] = 2;
	  intts[1] = 4;
	  intts[2] = 0;
	  intts[3] = 3;
    intts[4] = 1;

      LinkedList<Appt> newArrays = new LinkedList<Appt>();
	  newArrays = timeTable.permute(arrays, intts);

//	  assertTrue(newArrays.get(0) == appt3);
//	  assertTrue(newArrays.get(1) == appt5);
//	  assertTrue(newArrays.get(2) == appt);
//	  assertTrue(newArrays.get(3) == appt4);
//	  assertTrue(newArrays.get(4) == appt2);
	 }

}
