/**
 * 
 */
package acceptancetests.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
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

import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import atdd.framework.MRScenario;
import junit.framework.Assert;

/**
 * @author pjaising
 *
 */
@SuppressWarnings("deprecation")
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
		System.out.println("toJson" + toJson);
		System.out.println("fromJson" + fromJson);

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
			System.out.println("The element: " + elementExpected + " is visible");
			

		} catch (Exception e) {
			//Assert.fail("Not able to locate this element -- " + element + " on page");
			System.out.println("error in waiting for page load "+e.getMessage());
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

		WebDriver wd = mrScenario.getWebDriverNew();
		wd.get(completeDateUrl);
		//wd.quit();
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

		WebDriver wd = mrScenario.getWebDriverNew();
		wd.get(completeDateUrl);
		//wd.quit();
	}

	public static void resetMRRestTime(MRScenario mrScenario) {
		String dateURL = "jvm?server=1";
		String completeDateUrl = MRREST_TIME_ADMIN_URL + dateURL;
		WebDriver wd = mrScenario.getWebDriverNew();
		wd.get(completeDateUrl);
		//wd.quit();
	}

	public static void resetPartDTime(MRScenario mrScenario) {
		String dateURL = "jvm?server=1";
		String completeDateUrl = PARTD_TIME_ADMIN_URL + dateURL;
		WebDriver wd = mrScenario.getWebDriverNew();
		wd.get(completeDateUrl);
		//wd.quit();

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
		// Read the file containing dtm script variables
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
				System.out.println("Something wrong with the JSON key " + key);
				e.printStackTrace();
			}
		}

		return dtmObject;
	}

	public static void deRegister(MRScenario mrScenario, String username) {

		if (System.getProperty("environment").equalsIgnoreCase("ci")) {
			WebDriver driver = mrScenario.getWebDriverNew();
			driver.get("http://partdtemp-ci.ose.optum.com/PartDPortalWeb/deregister.jsp");
			driver.findElement(By.id("tobederegisteruser")).click();
			driver.findElement(By.id("tobederegisteruser")).sendKeys(username);
			driver.findElement(By.id("tobederegisteruser")).submit();
			//driver.quit();
		}
		if (System.getProperty("environment").equalsIgnoreCase("stage")) {
			WebDriver driver = mrScenario.getWebDriverNew();
			driver.get("http://apsrs0261.uhc.com:9080/PartDPortalWeb/deregister.jsp");
			driver.findElement(By.id("tobederegisteruser")).click();
			driver.findElement(By.id("tobederegisteruser")).sendKeys(username);
			driver.findElement(By.id("tobederegisteruser")).submit();
			//driver.quit();
		}
		if (System.getProperty("environment").equalsIgnoreCase("test-a")) {
			WebDriver driver = mrScenario.getWebDriverNew();
			driver.get("http://apsrt0245.uhc.com:9080/PartDPortalWeb/deregister.jsp");
			driver.findElement(By.id("tobederegisteruser")).click();
			driver.findElement(By.id("tobederegisteruser")).sendKeys(username);
			driver.findElement(By.id("tobederegisteruser")).submit();
			//driver.quit();
		}
		if (System.getProperty("environment").equalsIgnoreCase("test-b")) {
			WebDriver driver = mrScenario.getWebDriverNew();
			driver.get("http://apsrt0247.uhc.com:9080/PartDPortalWeb/deregister.jsp");
			driver.findElement(By.id("tobederegisteruser")).click();
			driver.findElement(By.id("tobederegisteruser")).sendKeys(username);
			driver.findElement(By.id("tobederegisteruser")).submit();
			//driver.quit();
		}

	}

	public static void createVersionFile(MRScenario mrScenario) {
		if (System.getProperty("environment").equalsIgnoreCase("ci")) {
			WebDriver wd = mrScenario.getWebDriverNew();
			try {
				int widthMaxLimit = 45;
				PrintWriter writer = new PrintWriter("target/version.txt", "UTF-8");
				String headerCol1 = "Artifact Name";
				String headerLine = headerCol1 + String.format("%" + (widthMaxLimit - headerCol1.length()) + "s", "")
						+ "Build Number";
				writer.println(headerLine);

				try {
					wd.get("https://ci-generic.uhc.com/content/cqartifactsversion.html");
					List<WebElement> rows = wd.findElements(By.xpath("//table[@id='package_info_table']/tbody/tr"));

					for (WebElement row : rows) {
						String artifactName = row.findElements(By.tagName("td")).get(0).getText();
						String buildNumber = row.findElements(By.tagName("td")).get(1).getText();
						row.findElements(By.tagName("td")).get(2).getText();
						String line = artifactName
								+ String.format("%" + (widthMaxLimit - artifactName.length()) + "s", "") + buildNumber;
						writer.println(line);
					}
				} catch (Exception e1) {
					// e1.printStackTrace();
					String cqAritifacts = "CQ Artifacts";
					String mrrLine = cqAritifacts
							+ String.format("%" + (widthMaxLimit - cqAritifacts.length()) + "s", "")
							+ "Failed to load CQ Artifacts Info(Deployment Failed)";
					writer.println(mrrLine);
					System.out.println("ERROR getting CQ Artifacts version");
				}
				String mrrestAppName = "MRRestWAR";
				try {
					wd.get("http://mrrest-ci.ose.optum.com/MRRestWAR/version.jsp");

					String mrrLine = mrrestAppName
							+ String.format("%" + (widthMaxLimit - mrrestAppName.length()) + "s", "")
							+ wd.findElement(By.xpath("//table[@class='outer']/tbody/tr[3]/td[2]")).getText();
					writer.println(mrrLine);
				} catch (Exception e2) {
					// e.printStackTrace();
					String mrrLine = mrrestAppName
							+ String.format("%" + (widthMaxLimit - mrrestAppName.length()) + "s", "")
							+ "Failed to load Build Number(Deployment Failed)";
					writer.println(mrrLine);
					System.out.println("ERROR getting MRREST application version");
				}
				String partdAppName = "PartDPortalWeb";
				try {
					wd.get("http://partdtemp-ci.ose.optum.com/PartDPortalWeb/version.jsp");
					String partDLine = partdAppName
							+ String.format("%" + (widthMaxLimit - partdAppName.length()) + "s", "")
							+ wd.findElement(By.xpath("//table[@class='outer']/tbody/tr[7]/td[2]")).getText();
					writer.println(partDLine);
				} catch (Exception e3) {
					// e.printStackTrace();
					String partDLine = partdAppName
							+ String.format("%" + (widthMaxLimit - partdAppName.length()) + "s", "")
							+ "Failed to load Build Number(Deployment Failed)";
					writer.println(partDLine);
					System.out.println("ERROR getting PartD application version");
				}
				writer.close();
			} catch (Exception e) {
				System.out.println("ERROR creating version text file");
			}
			//wd.quit();
		}
	}

	/***
	 * the method waits for a given time till element gets visible
	 * 
	 * @param driver
	 * @param element
	 * @param timeout
	 */
	public static void waitForPageLoadNew(WebDriver driver, WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			WebElement elementExpected = wait.until(ExpectedConditions.visibilityOf(element));
			if (elementExpected.isDisplayed()) {
				System.out.println("The element: " + elementExpected + " is visible");
			} else {
				System.out.println("The element: " + elementExpected + " is not visible");
				Assert.fail("The element: " + elementExpected + " is not visible");
			}

		} catch (Exception e) {
			Assert.fail("Not able to locate this element -- " + element + " on page");
			System.out.println(e.getMessage());
		}

	}
	
	public static void waitForPageLoadNewForClick(WebDriver driver, WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			WebElement elementExpected = wait.until(ExpectedConditions.elementToBeClickable(element));
			if (elementExpected.isDisplayed()) {
				System.out.println("The element: " + elementExpected + " is visible");
			} else {
				System.out.println("The element: " + elementExpected + " is not visible");
				Assert.fail("The element: " + elementExpected + " is not visible");
			}

		} catch (Exception e) {
			Assert.fail("Not able to locate this element -- " + element + " on page");
			System.out.println(e.getMessage());
		}

	}


	/***
	 * the waits till page state becomes complete
	 * 
	 * @param driver
	 * @return
	 */
	public static boolean checkPageIsReadyNew(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int counter = 0; counter <= 23; counter++) {
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				System.out.println("Browser Page -- " + driver.getTitle() + " -- Is loaded.");
				return true;
			}
			try {
				System.out.println(counter+" of 23 tries - wait 5 sec for document.readyState=complete... ");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		Assert.fail("TimeOut!!! Page not loaded");
		return false;
	}
}
