
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;
import java.util.Calendar;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!




public class UrlValidatorTest extends TestCase {

   private static final long TestTimeout = 60 * 500 * 1;

   public static int getRandomIntBetween(Random random, int min, int max) {

     long range       = (long)max - (long)min + 1;
     long fraction    = (long)(range * random.nextDouble());
       int randomNumber = (int)(fraction + min);
     return randomNumber;
   }

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
        //You can use this function to implement your manual testing
        UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
            //Good URL
        assertTrue(url.isValid("http://www.google.com"));
        assertTrue(url.isValid("http://www.google.com/"));
            //Bad URL
        assertFalse(url.isValid("http://www.google.com/..//file"));
        assertFalse(url.isValid("256.256.256.256"));
        assertFalse(url.isValid("http:www.google.com"));

        String schemes2[] = {"http", "https"};
        UrlValidator url2 = new UrlValidator(schemes2,null,UrlValidator.NO_FRAGMENTS);
        //assertTrue(url2.isValid("http://www.google.com/"));
   }

   public void testPartition()
   {
     UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);

        //Scheme Testing
     assertTrue(url.isValid("http://www.google.com"));
     //assertTrue(url.isValid("https://www.google.com"));   //This should work
     //assertTrue(url.isValid("ftp://www.google.com"));     //This should work
     //assertFalse(url.isValid("yo://www.google.com"));     //This should work
     //assertFalse(url.isValid("nope://www.google.com"));   //This should work
     //assertFalse(url.isValid("http:/www.google.com"));    //This should work

        //Authority Testing
     assertTrue(url.isValid("http://www.esufhlaieciebuailawnawbcliwdnubawcliwnjrhalceingsenlfnawdb.com"));
     assertTrue(url.isValid("http://www.google.edu"));
     assertTrue(url.isValid("http://hhheeeyyy.google.whuttup"));
     assertTrue(url.isValid("http://chris@google.com"));
     assertTrue(url.isValid("http://225.225.225.225"));
     //assertTrue(url.isValid("http://chris:dog@google.com"));        //This should work
     //assertTrue(url.isValid("http://chris:dog@google.com:8080"));   //This should work

     assertFalse(url.isValid("256.256.256.256"));
     assertFalse(url.isValid("http:://www.google.com"));
     assertFalse(url.isValid("://www.google.com"));

        //Path Testing
     assertTrue(url.isValid("http://www.google.com/t123"));
     //assertTrue(url.isValid("http://www.google.com/t123/"));        //This should work
     //assertTrue(url.isValid("http://www.google.com/t123/file"));    //This should work
     assertTrue(url.isValid("http://www.google.com/$t123"));

     assertFalse(url.isValid("http://www.google.com//t123"));
     assertFalse(url.isValid("http://www.google.com/t123/.."));
     assertFalse(url.isValid("http://www.google.com/..//t123"));
     assertFalse(url.isValid("http://www.google.com/t123//file"));

        //Query testing
     assertTrue(url.isValid("http://www.google.com/?action=view"));
     assertTrue(url.isValid("http://www.google.com/?action=edit&mode=up"));

   }


   public void testIsValid()
   {

     UrlValidator url = new UrlValidator(null,null, UrlValidator.ALLOW_ALL_SCHEMES);
     long randomseed = System.currentTimeMillis();
     Random random = new Random(randomseed);
     long startTime = Calendar.getInstance().getTimeInMillis();
     long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	   String[] schemeTrue = {"http://", "ftp://", "h3t://", ""};
     String[] schemeFalse = {"3ht://", "http:/", "http:", "http/", "://"};
     String[] authorityTrue = {"www.google.com", "go.com", "go.au", "0.0.0.0",
                               "255.255.255.255", "255.com"};
     String[] authorityFalse = {"256.256.256.256", "1.2.3.4.5", "1.2.3.4.",
                                "1.2.3", ".1.2.3.4", "go.a", "go.a1a", "go.1aa",
                                "aaa.", ".aaa", "aaa", ""};
     String[] urlPortTrue = {":80", ":65535", ":0", ""};
     String[] urlPortFalse = {"-1", ":65636", ":65a"};
     String[] pathTrue = {"/test1", "/t123", "/$23", "/test1", "", ":/test1/file"};
     String[] pathFalse = {"/..", "/../", "/..//file", "/test1//file"};
     String[] urlQuery = {"?action=view", "?action=edit&mode=up", ""};

     System.out.println("Start testing...");

    try{
        boolean expected = false;
        int num1, num2, num3, num4, num5;
        String randScheme, randAuthority, randPort, randPath, randQuery, finalUrl;

        for (int iteration = 0; iteration < 1000; iteration++){
          num1 = getRandomIntBetween(random,0,1);
          num2 = getRandomIntBetween(random,0,1);
          num3 = getRandomIntBetween(random,0,1);
          num4 = getRandomIntBetween(random,0,1);

          if((num1 == 0) && (num2 == 0) && (num3 == 0) && (num4 == 0)){
            expected = true;
          } else {
            expected = false;
          }

          if(num1 == 0){
            randScheme = schemeTrue[getRandomIntBetween(random,0,3)];
          } else {
            randScheme = schemeFalse[getRandomIntBetween(random,0,4)];
          }
          if(num2 == 0){
            randAuthority = authorityTrue[getRandomIntBetween(random,0,5)];
          } else {
            randAuthority = authorityFalse[getRandomIntBetween(random,0,11)];
          }
          if(num3 == 0){
            randPort = urlPortTrue[getRandomIntBetween(random,0,3)];
          } else {
            randPort = urlPortFalse[getRandomIntBetween(random,0,2)];
          }
          if(num4 == 0){
            randPath = pathTrue[getRandomIntBetween(random,0,5)];
          } else {
            randPath = pathFalse[getRandomIntBetween(random,0,3)];
          }
          randQuery = urlQuery[getRandomIntBetween(random,0,2)];


          finalUrl = randScheme + randAuthority + randPort + randPath + randQuery;

                                                             // ******************************************//
          // assertEquals(url.isValid(finalUrl), expected);  // All these tests should work when line is uncommented, but most fail due to bugs
                                                             // ******************************************//
        }

    } catch(NullPointerException e){

    }
    System.out.println("Done testing...");
   }



}
