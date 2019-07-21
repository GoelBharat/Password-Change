package org.agoda.hiring;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Password change App.
 * 
 * @author Bharat Goel
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Test having all the valid password requirement
	 */
	public void testValidPassword() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@TqDB2q2*31!@QQ2Aa");
		assertTrue("Password is not a valid", flag);
	}

	/**
	 * Test missing length of password
	 */
	public void testShortLength() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "!Qw1@#$");
		assertFalse("Password entered is of correct length", flag);
	}

	/**
	 * Test having 0 uppercase
	 */
	public void testZeroUppercase() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@tqdb2q2#31!@qq2aa");
		assertFalse("Password entered is having a upper case", flag);
	}

	/**
	 * Test having 0 lowercase
	 */
	public void testZeroLowercase() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@QWER2Q2#31!@QQ2AA");
		assertFalse("Password entered is having a lower case", flag);
	}

	/**
	 * Test having 0 numeric
	 */
	public void testZeroNumeric() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@QWERaQb#qw!@QQvAA");
		assertFalse("Password entered is having a numeric", flag);
	}

	/**
	 * Test having 0 special character
	 */
	public void testZeroSplChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "1QWERaQb2qw34QQvAA");
		assertFalse("Password entered is having a special character", flag);
	}

	/**
	 * Test having duplicate character more than 4
	 */
	public void testDupChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@TTTT2q2#31!@TQ2Aa");
		assertFalse("Password entered is having duplicate less than 5", flag);
	}

	/**
	 * Test having special character more than 4
	 */
	public void testSplChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@TTTt2q2#31!@@Q2Aa");
		assertFalse("Password entered is having special less than 5", flag);
	}

	/**
	 * Test having numeric more than 50%
	 */
	public void testNumeric() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@912t2q2831!@@42A9");
		assertFalse("Password entered is having numeric character less than 50%", flag);
	}

	/**
	 * Test for not matching with old password
	 */
	public void testOldPasswordNotMatching() {
		boolean flag = App.ChangePassword("@wqqq22#31!@QQ2QQ", "@TqDB2q2#31!@QQ2Aa");
		assertFalse("Old password is matching", flag);
	}

	/**
	 * Test for password is not similar to old password < 80% match
	 */
	public void testSimilarityMatch() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@wqqq2q2#31!@QQ2QA");
		assertFalse("New password is > 80% similar to old password", flag);
	}

	/**
	 * Test for old password is null
	 */
	public void testOldPasswordNull() {
		boolean flag = App.ChangePassword(null, "@wqqq2q2#31!@QQ2QQ");
		assertFalse("Old password is not null", flag);
	}

	/**
	 * Test for new password is null
	 */
	public void testNewPasswordNull() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", null);
		assertFalse("New password is not null", flag);
	}

	/**
	 * Test for old password is empty
	 */
	public void testOldPasswordEmpty() {
		boolean flag = App.ChangePassword(" ", "@wqqq2q2#31!@QQ2QQ");
		assertFalse("Old password is not empty", flag);
	}

	/**
	 * Test for new password is empty
	 */
	public void testNewPasswordEmpty() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", " ");
		assertFalse("New password is not empty", flag);
	}

	/**
	 * Test for old and new password are empty
	 */
	public void testOldNEwPasswordEmpty() {
		boolean flag = App.ChangePassword(" ", " ");
		assertFalse("New and old password are not empty", flag);
	}

	/**
	 * Test for old and new password are null
	 */
	public void testOldNewPasswordNull() {
		boolean flag = App.ChangePassword(null, null);
		assertFalse("New and old password are not null", flag);
	}

	/**
	 * Test having new password of more than 18 length
	 */
	public void testNewPasswordMoreLength() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@TqDB2q2#31!@QQ2AaaFGh");
		assertTrue("Password is not having more than 18 length", flag);
	}

	/**
	 * Test having blank space in between
	 */
	public void testInBetweenblankSpace() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@TqDB2q2#31  !@QQ2AaaFGh");
		assertFalse("Password is not having blank space", flag);
	}
	/**
	 * Test having blank space in start
	 */
	public void testInStartblankSpace() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "  @TqDB2q2#31!@QQ2Aa");
		assertFalse("Password is not having blank space in start", flag);
	}
	/**
	 * Test having blank space in end
	 */
	public void testInEndblankSpace() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@TqDB2q2#31!@QQ2Aa  ");
		assertFalse("Password is not having blank space in end", flag);
	}
	/**
	 * Test having blank space in start, end and in between
	 */
	public void testblankSpace() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "  @TqDB2q2  #31!@QQ2Aa  ");
		assertFalse("Password is not having blank space in between, end and in start", flag);
	}
	/**
	 * Test having non listed special character
	 */
	public void testNonListedSplChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "^TqDB2q2#31!@QQ2Aa");
		assertFalse("Password is having non listed spl chars", flag);
	}
	/**
	 * Test having non listed special character at end
	 */
	public void testNonListedSplCharAtEnd() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "@wqqq2q2#31!@QQ2Q*");
		assertFalse("Password is having non listed spl chars at end", flag);
	}
	/**
	 * Test having only special char
	 */
	public void testHavingOnlySpclChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "!@#!@#!@#!@#!@#!@#!@#!@#");
		assertFalse("Password is having all spcl char", flag);
	}
	/**
	 * Test having only lower char
	 */
	public void testHavingOnlyLowerChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "qweqweqweqweqweqwe");
		assertFalse("Password is having all lower char", flag);
	}
	/**
	 * Test having only upper char
	 */
	public void testHavingOnlyUpperChar() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "QWEQWEQWEQWEQWEQWEQWE");
		assertFalse("Password is having all upper char", flag);
	}
	/**
	 * Test having only number 
	 */
	public void testHavingOnlyNumber() {
		boolean flag = App.ChangePassword("@wqqq2q2#31!@QQ2QQ", "1231231231231231231");
		assertFalse("Password is having all number", flag);
	}
	
}
