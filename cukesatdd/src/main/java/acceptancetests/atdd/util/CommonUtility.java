/**
 * 
 */
package acceptancetests.atdd.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import atdd.framework.MRScenario;

/**
 * @author pjaising
 *
 */
public class CommonUtility {

	private static String MRREST_TIME_ADMIN_URL = MRConstants.MRREST_TIME_ADMIN_URL;

	private static String PARTD_TIME_ADMIN_URL = MRConstants.PARTD_TIME_ADMIN_URL;

	public static boolean checkPageIsReady(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return true;
		} else {
			checkPageIsReady(driver);
		}
		return false;
	}

	public static WebElement getWebElementByXpathNoTimeout(String xpath, WebDriver driver) {
		return driver.findElement(By.xpath(xpath));
	}

	public static PageData readPageData(String fileName, String pageObjectDirectoryMember) {
		File headerFile = null;
		try {
			headerFile = ExpectedDataUtility.getExpectedResponse(fileName, pageObjectDirectoryMember);
		} catch (IOException e) {
			System.out.println("Error reading  " + pageObjectDirectoryMember + fileName + "  Exception: " + e);
		}
		PageData pageData = new PageData();
		ObjectMapper mapper = new ObjectMapper();
		try {
			pageData = mapper.readValue(new File(headerFile.getPath()), PageData.class);
		} catch (JsonParseException e) {
			System.out.println("Error parsing the json  " + pageObjectDirectoryMember + fileName + "  Exception: " + e);
		} catch (JsonMappingException e) {
			System.out.println("Error mapping the json  " + pageObjectDirectoryMember + fileName + "  Exception: " + e);
		} catch (IOException e) {
			System.out.println("Exception occurred for  " + pageObjectDirectoryMember + fileName + "  Exception: " + e);
		}
		return pageData;
	}

	public static JSONObject mergeJson(JSONObject toJson, JSONObject fromJson) {
		System.out.println("toJson"+toJson);
		System.out.println("fromJson"+fromJson);

		Iterator<?> itr = fromJson.keys();
		while (itr.hasNext()) {
			String key = (String) itr.next();
			try {
				toJson.put(key, fromJson.get(key));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return toJson;
	}

	public static void waitForPageLoad(WebDriver driver, WebElement element, long timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			WebElement elementExpected = wait.until(ExpectedConditions.visibilityOf(element));
			if ((elementExpected.getText().isEmpty() || elementExpected.getText() == null)) {
				timeout = timeout - 5;
				if (timeout > 0) {
					waitForPageLoad(driver, element, timeout);
				}
			}

		} catch (Exception e) {
			timeout = timeout - 5;
			if (timeout > 0) {
				waitForPageLoad(driver, element, timeout);
			} else {
				System.out.println("Not able to locate this " + element + " on page");
				return;
			}
		}

	}

	public static void waitForElementToDisappear(WebDriver driver, WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);

		Boolean elementExpected = wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		if (!elementExpected) {
			timeout = timeout - 5;
			if (timeout > 0) {
				waitForElementToDisappear(driver, element, timeout);
			}
		}
	}

	public static JSONObject concatenateJsons(JSONObject firstPlanInformationExpected,
			JSONObject secondPlanInformationExpected) {
		Iterator<?> itr = secondPlanInformationExpected.keys();
		while (itr.hasNext()) {
			String key = (String) itr.next();

			try {
				int lengthOfArray = secondPlanInformationExpected.getJSONArray(key).length();
				for (int i = 0; i < lengthOfArray; i++) {
					firstPlanInformationExpected = firstPlanInformationExpected.append(key,
							secondPlanInformationExpected.getJSONArray(key).get(i));
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return firstPlanInformationExpected;

	}

	public static void changeMRRestTime(MRScenario mrScenario, String date) {

		int calendarMonth, month, day, year;
		String[] dateComponents = date.split("-");
		month = Integer.parseInt(dateComponents[0]);
		calendarMonth = month - 1; // We take month-1 because the Calendar API
		// uses 0-11 for Jan-Dec
		day = Integer.parseInt(dateComponents[1]);
		year = Integer.parseInt(dateComponents[2]);

		// Create a calendar object for the date in order to retrieve Millis
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, calendarMonth, day, 00, 00, 00);

		// Set time zone to EST (Eastern Time) as this is the time zone used by
		// MRRestWAR
		calendar.setTimeZone(TimeZone.getTimeZone("EST"));

		// Calculate milliseconds for call to MRRestWAR
		long millis = calendar.getTimeInMillis();

		String dateURL = "joda?millis=" + millis + "&month=" + month + "&day=" + day + "&year=" + year
				+ "&hour=00&min=00&sec=00&server=1";

		String completeDateUrl = MRREST_TIME_ADMIN_URL + dateURL;

		WebDriver wd = mrScenario.getWebDriver();
		wd.get(completeDateUrl);
		wd.quit();
	}

	public static void changePartDTime(MRScenario mrScenario, String date) {

		int calendarMonth, month, day, year;
		String[] dateComponents = date.split("-");
		month = Integer.parseInt(dateComponents[0]);
		calendarMonth = month - 1; // We take month-1 because the Calendar API
		// uses 0-11 for Jan-Dec
		day = Integer.parseInt(dateComponents[1]);
		year = Integer.parseInt(dateComponents[2]);

		// Create a calendar object for the date in order to retrieve Millis
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, calendarMonth, day, 00, 00, 00);

		// Set time zone to EST (Eastern Time) as this is the time zone used by
		// PARTD
		calendar.setTimeZone(TimeZone.getTimeZone("EST"));

		// Calculate milliseconds for call to PARTD
		long millis = calendar.getTimeInMillis();

		String dateURL = "joda?millis=" + millis + "&month=" + month + "&day=" + day + "&year=" + year
				+ "&hour=00&min=00&sec=00&server=1";

		String completeDateUrl = PARTD_TIME_ADMIN_URL + dateURL;

		WebDriver wd = mrScenario.getWebDriver();
		wd.get(completeDateUrl);
		wd.quit();
	}

	public static void resetMRRestTime(MRScenario mrScenario) {
		String dateURL = "jvm?server=1";
		String completeDateUrl = MRREST_TIME_ADMIN_URL + dateURL;
		WebDriver wd = mrScenario.getWebDriver();
		wd.get(completeDateUrl);
		wd.quit();
	}

	public static void resetPartDTime(MRScenario mrScenario) {
		String dateURL = "jvm?server=1";
		String completeDateUrl = PARTD_TIME_ADMIN_URL + dateURL;
		WebDriver wd = mrScenario.getWebDriver();
		wd.get(completeDateUrl);
		wd.quit();

	}

	public static JSONObject checkForVariable(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageName = js.executeScript("return " + "DTMData.content.pageName").toString();
		String error = js.executeScript("return " + "DTMData.content.error").toString();

		JSONObject dtmObject = new JSONObject();
		try {
			dtmObject.put("pageName", pageName);
			dtmObject.put("error", error);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dtmObject;

	}

	public static JSONObject checkForVariable(WebDriver driver, String filePath, String dtmDir) {
		 //Read the file containing dtm script variables
		JSONObject getTags = MRScenario.readExpectedJson(filePath, dtmDir);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		JSONObject dtmObject = new JSONObject();

		// iterate over json
		Iterator<?> keys = getTags.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value;
			try {
				value = (String) getTags.get(key);
				String val = js.executeScript("return " + value).toString();
				dtmObject.put(key, val);
			} catch (JSONException e) {
               System.out.println("Something wrong with the JSON key "+ key);
				e.printStackTrace();
			}
		}

		return dtmObject;
	}
}
