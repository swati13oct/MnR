/**
 * 
 */
package atdd.framework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;

import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.util.regex.Pattern;

/**
 * @author pjaising
 *
 */
public abstract class UhcDriver {

	public WebDriver driver;
	private long defaultTimeoutInSec=30;
	
	@FindBy(xpath = ".//iframe[contains(@id,'IPerceptionsEmbed')]")
	public static WebElement IPerceptionsFrame;
	
	@FindBy(xpath="//*[contains(@class,'btn-no')]")
	public static WebElement IPerceptionNoBtn;
	
	public void start(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	public UhcDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<String>(
                        driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
	}

	public WebDriver switchToNewIframe(String iframeName) {
		return driver.switchTo().frame(iframeName);

	}

	public WebDriver switchToNewIframe(WebElement iframeElement) {
		return driver.switchTo().frame(iframeElement);

	}

	public boolean elementFound(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
				return false;
			}


                } catch (Exception e) {
                        // driver.quit(); Commented to fix parallel test cases issue
                        System.out.println("Element not found/not visible");
                }
                return false;
        }


	public void sendkeys(WebElement element, String message) {
		element.click();
		element.clear();
		element.sendKeys(message);

	}

	public void select(WebElement element, String message) {
		element.click();
		element.sendKeys(message);
	}

	public void selectFromDropDown(List<WebElement> elementList, String value) {
		for (WebElement element : elementList) {
			if (element.getText().contains(value)) {
				element.click();
				break;
			}
		}
	}
	
	public boolean validate(WebElement element) {  
		return validate(element, defaultTimeoutInSec);
	}

	public boolean validateNew(WebElement element) { 
		return validateNew(element, defaultTimeoutInSec);
	}

	public void waitforElementNew(WebElement element) {
		waitforElementNew(element, defaultTimeoutInSec);
	}


	public boolean validate(WebElement element, long timeoutInSec) {
    	try {
	    	waitforElementNew(element, timeoutInSec);
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible. Exception message - "+e.getMessage());

		}
		return false;

		/*//CM
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-50)", "");
	        try {
	         waitforElement(element);
	            if (element.isDisplayed()) {
	                   Actions actions = new Actions(driver);
	                   actions.moveToElement(element);
	                   actions.perform();
	                   Assert.assertTrue("@@@The element " + element.getText() + "is found@@@", element.isDisplayed());
	                   System.out.println("@@@The element " + element.getText() + "is found@@@");
	            }
	     } catch (Exception e) {
	            Assert.fail("The element " + element.getText() + "is not  found");
	         return false;
	     }
	     
	        return true;*/
    }

	public WebElement findElement(ElementData elementData) {
        WebElement element = null;
        try {
                if (elementData.getIdentifier().equalsIgnoreCase("id")) {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        element = driver
                                        .findElement(By.id(elementData.getElementName()));
                } else if (elementData.getIdentifier()
                                .equalsIgnoreCase("className")) {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        element = driver.findElement(By.className(elementData
                                        .getElementName()));
                } else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        element = driver.findElement(By.xpath(elementData
                                        .getElementName()));
                } else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        element = driver.findElement(By.linkText(elementData
                                        .getElementName()));
                } else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        element = driver.findElement(By.name(elementData
                                        .getElementName()));
                } else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
                        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                        element = driver.findElement(By.tagName(elementData
                                        .getElementName()));
                }

                return element;
        } catch (Exception e) {
                return null;
        }

}

	public WebElement findChildElement(ElementData elementData,
            WebElement parentElement) {
    WebElement element = null;
    try {
            if (elementData.getIdentifier().equalsIgnoreCase("id")) {

                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    element = parentElement.findElement(By.id(elementData
                                    .getElementName()));
            } else if (elementData.getIdentifier()
                            .equalsIgnoreCase("className")) {
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    element = parentElement.findElement(By.className(elementData
                                    .getElementName()));
            } else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    element = parentElement.findElement(By.xpath(elementData
                                    .getElementName()));
            } else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    element = parentElement.findElement(By.linkText(elementData
                                    .getElementName()));

            } else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    element = parentElement.findElement(By.name(elementData
                                    .getElementName()));

            } else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    element = parentElement.findElement(By.tagName(elementData
                                    .getElementName()));

        }
        return element;
} catch (Exception e) {
        return element;
}
}

public List<WebElement> findChildElements(ElementData elementData,
        WebElement parentElement) {
List<WebElement> element = null;
try {
        if (elementData.getIdentifier().equalsIgnoreCase("id")) {

                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                element = parentElement.findElements(By.id(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier()
                        .equalsIgnoreCase("className")) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                element = parentElement.findElements(By.className(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                element = parentElement.findElements(By.xpath(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                element = parentElement.findElements(By.linkText(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                element = parentElement.findElements(By.name(elementData
                                .getElementName()));

        } else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                element = parentElement.findElements(By.tagName(elementData
                                .getElementName()));
        }
        return element;
} catch (Exception e) {
        return element;
}
}

public List<WebElement> findElements(ElementData elementData) {
List<WebElement> element = null;
try {
        if (elementData.getIdentifier().equalsIgnoreCase("id")) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                element = driver.findElements(By.id(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier()
                        .equalsIgnoreCase("className")) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                element = driver.findElements(By.className(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                element = driver.findElements(By.xpath(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                element = driver.findElements(By.linkText(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                element = driver.findElements(By.name(elementData
                                .getElementName()));
        } else if (elementData.getIdentifier().contains("select:")) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                String[] identifierArr = elementData.getIdentifier().split(":");
                if (identifierArr[1].equalsIgnoreCase("className")) {
                        WebElement selectElement = driver.findElement(By
                                        .className(elementData.getElementName()));
                        Select select = new Select(selectElement);
                        element = select.getOptions();
                } else if (identifierArr[1].equalsIgnoreCase("id")) {
                        WebElement selectElement = driver.findElement(By
                                        .id(elementData.getElementName()));
                        Select select = new Select(selectElement);
                        element = select.getOptions();
                }
        }
	        return element;
	} catch (Exception e) {
	        return element;
	}
	}
	
	public WebElement findDynamicElement(By locator) {
	WebElement element = null;
	FluentWait<WebDriver> wait = new WebDriverWait(driver,
	                Long.parseLong(System.getProperty("base.timeout", "1")))
	                .withTimeout(
	                                Long.parseLong(System.getProperty("base.timeout", "1")),
	                                TimeUnit.SECONDS);
	try {
	        element = wait.until(ExpectedConditions
	                        .visibilityOfElementLocated(locator));
	} catch (Exception e) {
	        return element;
	}
	
	return element;
	}

	public String currentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Cookie getCookieName(String cookieName) {
		return driver.manage().getCookieNamed(cookieName);
	}

    public abstract void openAndValidate() throws InterruptedException;
    
    /*
     * Generic method to capture the dtm data both static and dynamic. The variable dtm files are kept under page-objects/dtm-common-data/
     * Currently only member and aquisition files are there. More foles can be added if required.
     * Input params are
     * fileName: Json file name containing the web elements names and id, so that they can be read from current page.
     * filePath: Path to the folder containing fileName
     * dtmFilePath: Json file name containing the dynamic dtm tags variable and their path 
     * dtmDir: Path to the dtmFilePath
     */
    public  JSONObject getDTMPageJson(String fileName, String filePath, String dtmFilePath, String dtmDir){
            PageData pageData = CommonUtility.readPageData(fileName,filePath);
            JSONObject jsonObject = new JSONObject();
            for (String key : pageData.getExpectedData().keySet()) {
                    WebElement element = findElement(pageData.getExpectedData()
                                    .get(key));
                    if (element != null) {
                            if (validate(element)) {

                                    JSONObject dtmObject = new JSONObject();
                                    if (element.getAttribute("dtmname") != null
                                                    && element.getAttribute("dtmid") != null) {
                                            try {
                                                    dtmObject.put("dtmid", element.getAttribute("dtmid"));
                                                    dtmObject.put("dtmname",
                                                                    element.getAttribute("dtmname"));
                                            } catch (JSONException e) {
                                                    // TODO Auto-generated catch block
                                                    e.printStackTrace();
                                            }

                                    
                                    try {
                                            jsonObject.put(key, dtmObject);
                                    } catch (JSONException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                    }
                                    }
                                    else{
                                            System.out.println("DTM id or DTM name was not found for Element:"+key);
                                    }
                            
                            }
                            else{
                                    System.out.println("Validation failed for element::"+key);
                            }
                    }
            }
            
            try {
                    jsonObject.put("dtmPageData", CommonUtility.checkForVariable(driver,dtmFilePath,dtmDir));
            } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            

            return jsonObject;
    }

	/***
	 * the method clicks on an element using javaScriptExecutor
	 * 
	 * @param element
	 */
	public void jsClickNew(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		System.out.println("Element Clicked");
	}

	/***
	 * the method scrolls page upto element's location
	 * 
	 * @param element
	 * @return
	 */
	public boolean scrollToView(WebElement element) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {

			Assert.fail("The element " + element.getText() + "is not  found");
			return false;
		}

		return true;
	}

	/***
	 * the method imposes an implicit wait of 10 sec and navigates to provided
	 * URL
	 * 
	 * @param url
	 */
	public void startNew(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	/***
	 * the method waits for upto 30 sec till element gets visible before
	 * throwing an exception
	 * 
	 * @param element
	 */
	public void waitforElementNew(WebElement element,long timeoutInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/***
	 * the method clicks on an element and the wait till another tab gets open
	 * and switches to it
	 * 
	 * @param Element
	 */
	public void switchToNewTabNew(WebElement Element) {
		String parentHandle = driver.getWindowHandle();
		int initialCount = driver.getWindowHandles().size();
		Element.click();
		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(parentHandle))
				break;
		}
	}

	/***
	 * the method waits for 60 sec till current windows count increments by 1
	 * 
	 * @param initialCount
	 */
	public void waitForCountIncrement(int initialCount) {
		System.out.println("Waiting for new window to get open");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.numberOfWindowsToBe(initialCount + 1));
	}
	
	/***
	 * the method waits for 60 sec till current windows count decrement by 1
	 * 
	 * @param initialCount
	 */
	public void waitForCountDecrement(int initialCount) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.numberOfWindowsToBe(initialCount - 1));
	}

	/***
	 * the method first scroll to particular field 9after waiting) and the
	 * writes in that field
	 * 
	 * @param element
	 * @param message
	 */
	public void sendkeysNew(WebElement element, String message) {
		validateNew(element);
		element.click();
		element.clear();
		element.sendKeys(message);

	}

	/***
	 * the method first scroll to the element and then waits till it is visible
	 * 
	 * @param element
	 * @return : boolean
	 */
	public boolean validateNew(WebElement element, long timeoutInSec) {
		scrollToView(element);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-50)", "");
		try {
			waitforElementNew(element,timeoutInSec);
			if (element.isDisplayed()) {
				Assert.assertTrue("@@@The element " + element.getText() + "is found@@@", element.isDisplayed());
				System.out.println("@@@The element " + element.getText() + "is found@@@");
			}
		} catch (Exception e) {

			Assert.fail("The element " + element.getText() + "is not  found");
			return false;
		}

		return true;
	}

	public void validateTextUsingRegex(WebElement element, String patternText) {
		String input = element.getText();
		System.out.println("Actual Text for comparision:" + input);
		String Effectivepattern = "^" + patternText + "$";
		System.out.println("Effectivepattern---" + Effectivepattern);
		try {
			Pattern pattern = Pattern.compile(Effectivepattern);
			if (pattern.matcher(input).matches())
				Assert.assertTrue("Pattern matches for the text:" + input, true);
			else
				Assert.fail("Pattern does not matches");
		} catch (IllegalArgumentException ex) {
			System.out.println("Exception - " + ex.toString());
			System.out.println("Exception message: " + ex.getMessage());
			Assert.fail("Error!!!" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Exception - " + ex.toString());
			System.out.println("Exception message: " + ex.getMessage());
		}
	}
	
	public void selectFromDropDownByText(WebDriver driver, WebElement dropdownElement, String value) {
		Select dropdown = new Select(dropdownElement);
		waitUntilSelectOptionsPopulated(dropdown);
		dropdown.selectByVisibleText(value);
		CommonUtility.checkPageIsReadyNew(driver);
		waitUntilSelectOptionsPopulated(dropdown);
		if (!dropdown.getFirstSelectedOption().getText().trim().equalsIgnoreCase(value))
			Assert.fail("Expected value is not present in dropdown");
	}
	
	public void selectFromDropDownByValue(WebElement dropdownElement, String value) {
		Select dropdown = new Select(dropdownElement);
		waitUntilSelectOptionsPopulated(dropdown);
		dropdown.selectByValue(value);
		CommonUtility.checkPageIsReadyNew(driver);
		waitUntilSelectOptionsPopulated(dropdown);
	if(!dropdown.getFirstSelectedOption().getAttribute("value").trim().equalsIgnoreCase(value))
		Assert.fail("Expected value is not present in dropdown");
	}

	public void waitUntilSelectOptionsPopulated(final Select select) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver d) {
				return (select.getOptions().get(0));
			}
		});
	}
	
	/***
	 * the method waits for maximum 30 sec till element gets disapper
	 * throwing an exception
	 * 
	 * @param element
	 */
	public void waitforElementDisapper(By by, long timeout) {
		System.out.println("Waiting for element to disappear!!!");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

	}
	/***
	 * Created by - agarg119
	 * The method waits for 2 seconds (increasing timeout may affect execution performance) to validate element is not present on screen.
	 * @param element
	 * @return boolean 
	 */
	public boolean validateNonPresenceOfElement(WebElement element) {
		try {
			waitforElementVisibilityInTime(element, 2);

		} catch (Exception e) {
			System.out.println("Validation Passed !!! Element not visible on screen");
			return true;
		}
		System.out.println("Validation failed!!! Element is visible on screen");
		return false;
	}
	
	/***
	 * Created By - agarg119
	 * the method waits for mentioned seconds till element gets visible before
	 * throwing an exception
	 * 
	 * @param element
	 */
	public void waitforElementVisibilityInTime(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	/***
	 * Created By - agarg119
	 * the method waits for mentioned seconds till element gets clickable
	 * throwing an exception
	 * 
	 * @param element
	 */
	public void waitTillElementClickableInTime(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	/***
	 * Created By - agarg119 the method waits for mentioned seconds till
	 * dropdown options gets visible throwing an exception
	 * 
	 * @param element
	 * @param timeout
	 */
	public void waitTllOptionsAvailableInDropdown(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, By.tagName("option")));

	}
	
	
	
	/***
	 * Created By - agarg119
	 * the method waits for the iframe to be available and switch to it
	 * throwing an exception
	 * 
	 * @param element
	 */
	public void waitTillFrameAvailabeAndSwitch(WebElement element, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}
	
	/* logic to simulate hover over functionality*/
	public void navigateToMenuLinks(WebElement hdrMenuElement, WebElement menuDropListItem) {

		Actions actions = new Actions(driver);
		actions.moveToElement(hdrMenuElement);
		actions.moveToElement(menuDropListItem);
		actions.click().build().perform();
		CommonUtility.checkPageIsReadyNew(driver);

	}
	
	public static void clickIfElementPresentInTime(WebDriver driver, WebElement element, int timeInSec) {
		System.out.println("Waiting for element to load...");
		CommonUtility.waitForPageLoad(driver, element, timeInSec);
		try {
			if (element.isDisplayed()) {
				System.out.println("Element is displayed. Clicking on element...");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
			}
		} catch (Exception e) {
			System.out.println("Element is not displayed");
		}
	}
	
	public void checkModelPopup(WebDriver driver) {
		 checkModelPopup(driver,defaultTimeoutInSec);
	}
	
	public void checkModelPopup(WebDriver driver,long timeoutInSec) {

			CommonUtility.waitForPageLoad(driver, IPerceptionsFrame,timeoutInSec);
			
			try{
				if(IPerceptionsFrame.isDisplayed())	{
					driver.switchTo().frame(IPerceptionsFrame);
					IPerceptionNoBtn.click();
					driver.switchTo().defaultContent();
				}
			}catch(Exception e){
				System.out.println("Iperceptions popup not found");
			}

	}
	
	/**
	 * determine system time 
	 * note: for prod no one would be changing the date, 
	 * note: so just get the current time (the build system) 
	 * note: and format it the same like the one using getSystemTime from MRRestWAR
	 * note: keep the format: Mon Oct 14 17:14:06 UTC 2019
	 * @return
	 */
	@FindBy(xpath="//body")
	protected WebElement timeJson;
	public String getMemTestEnvSysTime() {
		String timeStr = "";
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to check the system time");
		String urlGetSysTime="https://www." + MRScenario.environment + "-medicare." + MRScenario.domain+ "/MRRestWAR/rest/time/getSystemTime";
		System.out.println("test env URL for getting time: "+urlGetSysTime);
		if (MRScenario.environment.contains("team-ci"))
			urlGetSysTime="https://www." + MRScenario.environment + "-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/MRRestWAR/rest/time/getSystemTime";
		//open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('"+urlGetSysTime+"','_blank');");
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		WebElement currentSysTimeElement=timeJson;
		String currentSysTimeStr=currentSysTimeElement.getText();
		System.out.println("currentSysTimeStr="+currentSysTimeStr);

		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonObj;
		try {
			jsonObj = (org.json.simple.JSONObject) parser.parse(currentSysTimeStr);
			org.json.simple.JSONObject sysTimeJsonObj = (org.json.simple.JSONObject) jsonObj; 

			timeStr = (String) sysTimeJsonObj.get("systemtime"); 
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to find out the system time", false);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return timeStr;
	}

	public String getAcqTestEnvSysTime(String testSiteUrl) {
		String timeStr = "";
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to check the system time");
		String urlGetSysTime=testSiteUrl+ "/DCERestWAR/dcerest/profiledetail/bConnected";
		System.out.println("test env URL for getting time: "+urlGetSysTime);
		//open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('"+urlGetSysTime+"','_blank');");
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		WebElement currentSysTimeElement=timeJson;
		String currentSysTimeStr=currentSysTimeElement.getText();
		System.out.println("currentSysTimeStr="+currentSysTimeStr);
		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonObj;
		try {
			jsonObj = (org.json.simple.JSONObject) parser.parse(currentSysTimeStr);
			org.json.simple.JSONObject sysTimeJsonObj = (org.json.simple.JSONObject) jsonObj; 

			org.json.simple.JSONObject dataObj = (org.json.simple.JSONObject) sysTimeJsonObj.get("data"); 
			timeStr=(String) dataObj.get("systemDate"); 
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to find out the system time", false);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return timeStr;
	}

	public void startNewMobile(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void mobileswipe(String percentage,boolean swipeup) {
		AppiumDriver mobiledriver = (AppiumDriver) driver;
		TouchAction mact = new TouchAction(mobiledriver);
		Dimension size = mobiledriver.manage().window().getSize();
	    //Starting y location set to 90% of the height (near bottom)
	    int starty = (int) (size.height * 0.90);
	    //Ending y location set to % of the height (near top)
	    percentage = "0.".concat(percentage.replace("%", ""));
	    int endy = (int) (size.height * Float.valueOf(1-Float.valueOf(percentage)));
	    if(!swipeup)
	    	endy = endy+(int) (size.height * 0.2); //To avoid address bar position
	    //x position set to mid-screen horizontally
	    int startx = (int) size.width / 2;
	    //System.out.println(size+" "+startx+" "+starty+" "+endy);
		threadsleep(500);
		if(swipeup)
			mact.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();
		else
			mact.longPress(PointOption.point(startx, endy)).moveTo(PointOption.point(startx, starty)).release().perform();
	}

	public void mobileswipe(String percentage, int count,boolean swipeup) {
		for (int i = 1; i <= count; i++) {
			mobileswipe(percentage,swipeup);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void hidekeypad() {
		try {
		threadsleep(2000);
		if(driver.getClass().toString().toUpperCase().contains("ANDROID")) //wd.getClass().toString().toUpperCase().contains("IOS")) {
			((AndroidDriver)driver).hideKeyboard();
		else {
			clickTextIOSNative("Done");
		}
		threadsleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(driver.getCurrentUrl());
		}
	}
	
	public void getkeypad() {
		threadsleep(1000);
		if(driver.getClass().toString().toUpperCase().contains("ANDROID"))
			((AndroidDriver)driver).getKeyboard();
		else
			((IOSDriver)driver).getKeyboard();
		threadsleep(1000);
	}

	public void mobileactiontab(WebElement element) {
		if(driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			Actions act = new Actions(driver); // Works only for Android driver
			act.click(element).perform();
		}
		else
			jsClickNew(element);
	}
	
	public void mobileactionsendkeys(WebElement element,String keys) {
		if(driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			Actions act = new Actions(driver); // Works only for Android driver
			act.click(element).sendKeys(keys).perform();
		}
		else {
			//element.setValue("10001");
			//((JavascriptExecutor)webDriver).executeScript("arguments[0].value='100011';", m); 
			//((AppiumDriver)webDriver).getKeyboard().pressKey(Keys.BACK_SPACE);
			element.click();
			threadsleep(500);
			element.click();
			((AppiumDriver)driver).getKeyboard().sendKeys(keys);
		}
	}
	
	public void jsSendkeys(MobileElement element,String keys) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+ keys +"';", element);
	}
	
	public void pageloadcomplete() {
		new WebDriverWait(driver, 30).until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		System.out.println("Page load completed");
	}

	public void mobileFindElement(WebElement element,int swipeCount,boolean swipeUp) {
		try {
			waitTillElementClickableInTime(element,3);
			//new Actions(driver).moveToElement(element).perform();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("not visible");
			if(swipeCount<1)
				return;
			mobileswipe("80%",swipeUp);
			swipeCount--;
			mobileFindElement(element,swipeCount,swipeUp);
		}
	}
	
	public void mobileSelectOption(Select element,String option) {
		if(driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			element.selectByVisibleText(option);
		}
		else {
			String curHandle = ((IOSDriver) driver).getContext();
			System.out.println("curHandle - "+curHandle);
			System.out.println(((IOSDriver) driver).getContextHandles());
			((IOSDriver) driver).context("NATIVE_APP");
			driver.findElement(MobileBy.className("XCUIElementTypePickerWheel")).sendKeys(option);
			threadsleep(500);
			((IOSDriver) driver).findElement(MobileBy.AccessibilityId("Done")).click();
			((IOSDriver) driver).context(curHandle);
			System.out.println("curHandle - "+((IOSDriver) driver).getContext());
		}
	}

	public void clickTextIOSNative(String text) {
		String curHandle = ((IOSDriver) driver).getContext();
		System.out.println("curHandle - "+curHandle);
		System.out.println(((IOSDriver) driver).getContextHandles());
		((IOSDriver) driver).context("NATIVE_APP");
		((IOSDriver) driver).findElement(MobileBy.AccessibilityId(text)).click();
		threadsleep(500);
		((IOSDriver) driver).context(curHandle);
		System.out.println("curHandle - "+((IOSDriver) driver).getContext());
	}
	
	public void fixFormResubmissionAndroid(boolean positive) {
		String curHandle = ((AndroidDriver) driver).getContext();
		System.out.println("curHandle - "+curHandle);
		System.out.println(((AndroidDriver) driver).getContextHandles());
		((AndroidDriver) driver).context("NATIVE_APP");
		try {
		if(positive)
			((AndroidDriver) driver).findElement(MobileBy.id("com.android.chrome:id/positive_button")).click();
		else
			((AndroidDriver) driver).findElement(MobileBy.id("com.android.chrome:id/negative_button")).click();
		}catch(Exception e) {
			System.out.println("Unable/No form resubmission");
		}
		threadsleep(500);
		((AndroidDriver) driver).context(curHandle);
		System.out.println("curHandle - "+((AndroidDriver) driver).getContext());
	}
	
	public void fixFormResubmission(boolean positive) {
		if(driver.getClass().toString().toUpperCase().contains("ANDROID"))
			fixFormResubmissionAndroid(positive);
	}
	
	public void threadsleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}