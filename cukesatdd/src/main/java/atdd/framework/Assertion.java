package atdd.framework;


import org.testng.Assert;
/**
 * The Class Assertion.
 * This class acts as a wrapper to TestNG assert class
 * to avoid rework while migrating from JUnit to TestNG
 * since method signature are different.
 */
public class Assertion {
	
	public static void assertTrue(String message, boolean condition) {
		Assert.assertTrue(condition, message);
	}
	
	public static void assertFalse(String message, boolean condition) {
		Assert.assertFalse(condition, message);
	}
	
	public static void assertTrue(boolean condition) {
		Assert.assertTrue(condition);
	}
	
	public static void assertFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	public static void fail(String message) {
		Assert.fail(message);
	}
	
	public static void fail() {
		Assert.fail();
	}
	
	public static void assertEquals(String expected, String actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public static void assertEquals(String message, String actual, String expected) {
		Assert.assertEquals(actual, expected, message);
	}
	
	public static void assertEquals(String message, boolean actual, boolean expected) {
		Assert.assertEquals(actual, expected, message);
	}
	
	public static void assertEquals(String message, Object actual, Object expected) {
		Assert.assertEquals(actual, expected, message);
	}
	
	public static void assertEquals(Object expected, Object actual) {
		Assert.assertEquals(actual, expected);
	}

}
