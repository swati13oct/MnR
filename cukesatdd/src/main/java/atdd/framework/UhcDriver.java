/**
 * 
 */
package atdd.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pjaising
 *
 */
public abstract class UhcDriver {

	public WebDriver driver;

	public void start(String url) {
		driver.get(url);
	}

	public UhcDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5000L);
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
			driver.quit();
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
		try {
			this.waitforElement(element);
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible");

		}
		return false;
	}

	public WebElement findElement(ElementData elementData) {
		WebElement element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

	public abstract void openAndValidate();
	
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
}
