/**
 * 
 */
package acceptancetests.atdd.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

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

import acceptancetests.atdd.data.PageData;

/**
 * @author pjaising
 *
 */
public class CommonUtility {

	public static boolean checkPageIsReady(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (js.executeScript("return document.readyState").toString()
				.equals("complete")) {
			System.out.println("Page Is loaded.");
			return true;
		} else {
			checkPageIsReady(driver);
		}
		return false;
	}

	public static WebElement getWebElementByXpathNoTimeout(String xpath,
			WebDriver driver) {
		return driver.findElement(By.xpath(xpath));
	}

	public static PageData readPageData(String fileName,
			String pageObjectDirectoryMember) {
		File headerFile = null;
		try {
			headerFile = ExpectedDataUtility.getExpectedResponse(fileName,
					pageObjectDirectoryMember);
		} catch (IOException e) {
			System.out.println("Error reading  " + pageObjectDirectoryMember
					+ fileName + "  Exception: " + e);
		}
		PageData pageData = new PageData();
		ObjectMapper mapper = new ObjectMapper();
		try {
			pageData = mapper.readValue(new File(headerFile.getPath()),
					PageData.class);
		} catch (JsonParseException e) {
			System.out.println("Error parsing the json  "
					+ pageObjectDirectoryMember + fileName + "  Exception: "
					+ e);
		} catch (JsonMappingException e) {
			System.out.println("Error mapping the json  "
					+ pageObjectDirectoryMember + fileName + "  Exception: "
					+ e);
		} catch (IOException e) {
			System.out.println("Exception occurred for  "
					+ pageObjectDirectoryMember + fileName + "  Exception: "
					+ e);
		}
		return pageData;
	}

	public static JSONObject mergeJson(JSONObject toJson, JSONObject fromJson) {

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

	public static void waitForPageLoad(WebDriver driver, WebElement element,
			long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			WebElement elementExpected = wait.until(ExpectedConditions
					.visibilityOf(element));
			if ((elementExpected.getText().isEmpty() || elementExpected
					.getText() == null)) {
				timeout = timeout - 5;
				if (timeout > 0) {
					waitForPageLoad(driver, element, timeout);
				}
			}
		} catch (Exception e) {
			System.out.println("Not able to locate this " + element
					+ " on page");
			return;
		}
	}

	public static void waitForElementToDisappear(WebDriver driver,
			WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		Boolean elementExpected = wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		if(!elementExpected){
			timeout = timeout - 5;
		if (timeout > 0) {
			waitForElementToDisappear(driver, element, timeout);
		}
		}
	}



}
