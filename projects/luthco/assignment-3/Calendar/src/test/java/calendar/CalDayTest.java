package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Iterator;

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
	  	CalDay empty = new CalDay();
	  	GregorianCalendar today = new GregorianCalendar(2018, 3, 3);
	  	CalDay filled = new CalDay(today);
			assertEquals(3,filled.getMonth());
			assertEquals(3,filled.getDay());
			assertEquals(2018,filled.getYear());
	  	assertTrue(filled.isValid());
	 }

	 @Test
	  public void testaddApptAndToString()  throws Throwable  {
		CalDay empty = new CalDay();
	  Calendar rightnow = Calendar.getInstance();
	  int thisMonth = rightnow.get(Calendar.MONTH)+1;
	  int thisYear = rightnow.get(Calendar.YEAR);
	  int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
	  GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
	  CalDay cal = new CalDay(today);

	  //Construct a new Appointment object with the initial data
    Appt appt = new Appt(2,2,2,2,2018,"T","D");
		Appt appt2 = new Appt(3,3,3,3,2018,"T","D");
		Appt appt3 = new Appt(4,4,4,4,2018,"T","D");
		Appt appt4 = new Appt(4,4,100,4,2018,"T","D");

		LinkedList<Appt> appts = new LinkedList<Appt>();

	  cal.addAppt(appt);
	  cal.addAppt(appt2);
	  cal.addAppt(appt3);
		cal.addAppt(appt4);
		assertTrue(cal.isValid());

	  cal.toString();

		Iterator<?> A1 = cal.iterator();
		Iterator<?> A2 = empty.iterator();

	  assertTrue(cal.isValid());
		assertTrue(cal.toString().contains(appt.toString()));
		assertTrue(cal.toString().contains(appt2.toString()));
		assertTrue(cal.toString().contains(appt3.toString()));
		assertTrue(cal.toString().contains(appt4.toString()));
		assertEquals(4,cal.getSizeAppts());
	 }


	 @Test
		public void testIterator()  throws Throwable  {
			GregorianCalendar today = new GregorianCalendar(2018, 3, 3);
			CalDay filled = new CalDay(today);

			filled.iterator();

	 }

}
