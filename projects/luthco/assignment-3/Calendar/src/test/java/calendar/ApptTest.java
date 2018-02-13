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
	  public void appt()  throws Throwable  {

		 Appt appt = new Appt(1,2,3,4,5,"test", "dtest");
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(1, appt.getStartHour());
		 assertEquals(2, appt.getStartMinute());
		 assertEquals(3, appt.getStartDay());
		 assertEquals(4, appt.getStartMonth());
		 assertEquals(5, appt.getStartYear());
		 assertEquals("test", appt.getTitle());
		 assertEquals("dtest", appt.getDescription());

		 //appt.setStartMonth(13);
		 appt.setStartDay(0);
		 appt.setStartMinute(65);
		 appt.setStartHour(24);
		 appt.setStartYear(2000);
		 appt.setTitle("title");
		 appt.setDescription("description");

		 assertFalse(appt.getValid());
 	 	 assertEquals(24, appt.getStartHour());
     assertEquals(65, appt.getStartMinute());
     assertEquals(0, appt.getStartDay());
     assertEquals(2000, appt.getStartYear());
     assertEquals("title", appt.getTitle());
     assertEquals("description", appt.getDescription());

		 appt.setTitle(null);
		 appt.setDescription(null);
		 appt.setRecurrence(null, 2, 2, 2);

		 assertEquals("", appt.getTitle());
		 assertEquals("", appt.getDescription());
		 assertEquals(2, appt.getRecurNumber());
		 assertEquals(2, appt.getRecurIncrement());
		 assertEquals(2, appt.getRecurBy());

		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());

		 appt.setStartMinute(0);
		 assertFalse(appt.getValid());

		 appt.setStartMinute(59);
		 assertFalse(appt.getValid());

		 appt.setStartMinute(30);
		 appt.setStartDay(40);
		 assertFalse(appt.getValid());

		 appt.setStartDay(20);
		 assertFalse(appt.getValid());

		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());

		 appt.setStartHour(0);
		 assertTrue(appt.getValid());

		 appt.setStartHour(23);
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
		 Appt appt1 = new Appt(23, 30, 15, 01, 2018, "B", "D");
		 Appt appt2 = new Appt(23, 30, 15, 01, 2018, "B", "D");
		 Appt appt3 = new Appt(10, 35, 25, 10, 10, "B", "D");

		 assertTrue( 0 == appt1.compareTo(appt2));
		 assertFalse( 0 == appt1.compareTo(appt3));

		 Appt appthour1 = new Appt(0,1,1,1,1,"","");
 		 Appt appthour2 = new Appt(23,1,1,1,1,"","");
 		 Appt apptmin1 = new Appt(1,0,1,1,1,"","");
 		 Appt apptmin2 = new Appt(1,59,1,1,1,"","");
 		 Appt apptday1 = new Appt(1,1,1,1,1,"","");
 		 Appt apptday2 = new Appt(1,1,31,1,1,"","");
 		 Appt apptmonth1 = new Appt(1,1,1,1,1,"","");
 		 Appt apptmonth2 = new Appt(1,1,1,12,1,"","");
 		 assertTrue(appthour1.getValid());
 		 assertTrue(appthour2.getValid());
 		 assertTrue(apptday1.getValid());
 		 assertTrue(apptday2.getValid());
 		 assertTrue(apptmin1.getValid());
 		 assertTrue(apptmin2.getValid());
 		 assertTrue(apptmonth1.getValid());
 		 assertTrue(apptmonth2.getValid());

 		 for(int i=1; i<13; i++){
 			 Appt apptStart = new Appt(1,1,1,i,1,"","");
 			 assertTrue(apptStart.getValid());
 		  }

		 Appt apptGet1 = new Appt(1,1,1,1,1,"test","Test appt");
		 apptGet1.setStartHour(100);
		 assertFalse(apptGet1.getValid());
		 Appt apptGet2 = new Appt(1,1,1,1,1,"test","Test appt");
		 apptGet2.setStartMinute(100);
		 assertFalse(apptGet2.getValid());
		 Appt apptGet3 = new Appt(1,1,1,1,1,"test","Test appt");
		 apptGet3.setStartDay(100);
		 Appt apptGet4 = new Appt(1,1,1,1,1,"test","Test appt");
	 }


@Test
public void testString()  throws Throwable  {
	Appt appt = new Appt(15,30,1,1,1,"test","Test appt");
	Appt apptmidnight = new Appt(0,30,1,1,1,"test","Test appt");
	Appt apptnoon = new Appt(12,0,1,1,1,"test","Test appt");
	//Appt invalidAppt = new Appt(0,0,0,0,0,"","");

	for(int i=0; i<23; i++){
		Appt apptLoop = new Appt(i,30,1,1,1,"test","Test appt");
		String meridian = (apptLoop.getStartHour()<11? "pm" : "am");
		int expectedHour = (apptLoop.getStartHour()>11? apptLoop.getStartHour()-12 : apptLoop.getStartHour());
		expectedHour = expectedHour==0 ? 12 : expectedHour;

		assertEquals("\t1/1/1 at "+expectedHour+":30"+meridian+" ,test, Test appt\n", apptLoop.toString());
	}
	assertEquals("\t1/1/1 at 3:30am ,test, Test appt\n", appt.toString());
	assertEquals("\t1/1/1 at 12:0am ,test, Test appt\n", apptnoon.toString());
	assertEquals("\t1/1/1 at 12:30pm ,test, Test appt\n", apptmidnight.toString());
	//assertNull(invalidAppt.toString());
}

	 @Test
	  public void testRecuran()  throws Throwable  {
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

		 appt.setRecurrence(null, 2, 2, 2);
		 int[] arrayw = new int[1];
		 arrayw[0] = 0;

		 assertTrue(appt.getRecurNumber() == 2);
		 assertTrue(appt.getRecurIncrement() == 2);
		 assertTrue(appt.getRecurBy() == 2);
		 //assertTrue(appt.getRecurDays() == arrayw);

		 int[] arrayy = new int[3];
		 arrayy[0] = 1;
		 arrayy[1] = 2;
		 arrayy[2] = 3;

		 appt.setRecurrence(arrayy, 2, 2, 2);
		 assertTrue(appt.getRecurDays() == arrayy);

		 assertTrue(appt.isRecurring());
	 }


}
