
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!




public class UrlValidatorTest extends TestCase {

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
   }

   public void testYourFirstPartition()
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
     //assertTrue(url.isValid("http://www.google.com/t123/"));
     //assertTrue(url.isValid("http://www.google.com/t123/file"));
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
	   //You can use this function for programming based testing

   }



}
