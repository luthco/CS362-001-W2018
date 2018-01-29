package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void testIsValidHour()  throws Throwable  {
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
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
		 
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
	 }
	 
	 @Test
	  public void testIsValidMinute()  throws Throwable  {
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
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

		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
	 }
	  
//	 @Test
//	  public void testIsValidDay()  throws Throwable  {
//		 int startHour=23;
//		 int startMinute=30;
//		 int startDay=15;
//		 int startMonth=01;
//		 int startYear=2018;
//		 String title="Birthday Party";
//		 String description="This is my birthday party.";
//		 //Construct a new Appointment object with the initial data	 
//		 Appt appt = new Appt(startHour,
//		          startMinute ,
//		          startDay ,
//		          startMonth ,
//		          startYear ,
//		          title,
//		         description);
//		 
//		 appt.setStartDay(50);
//		 assertFalse(appt.getValid());
//	 }
	  
//	 @Test
//	  public void testIsValidMonth()  throws Throwable  {
//		 int startHour=23;
//		 int startMinute=30;
//		 int startDay=15;
//		 int startMonth=01;
//		 int startYear=2018;
//		 String title="Birthday Party";
//		 String description="This is my birthday party.";
//		 //Construct a new Appointment object with the initial data	 
//		 Appt appt = new Appt(startHour,
//		          startMinute ,
//		          startDay ,
//		          startMonth ,
//		          startYear ,
//		          title,
//		         description);
//		 
//		 appt.setStartMonth(13);
//		 assertFalse(appt.getValid());
//	 }
	  
	 @Test
	  public void testIsValidYear()  throws Throwable  {
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
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
		 
		 appt.setStartYear(2020);
		 assertTrue(appt.getValid());
	 }
	  
	 @Test
	  public void testIsValidDesc()  throws Throwable  {
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
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
		 
		 appt.setDescription(null);
		 assertEquals("", appt.getDescription());
	 }
	 
	 @Test
	  public void testCompareTo()  throws Throwable  {
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt1 = new Appt(startHour,
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
		 
		 assertTrue(appt1.compareTo(appt2) == appt2.compareTo(appt1));
	 }
	 
	 @Test
	  public void testToString()  throws Throwable  {
		 int startHour=23;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
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

		 assertTrue(appt.toString() != null);
		 
		 appt.setStartMinute(60);
		 assertTrue(appt.toString() == null);
	 }

	
}
