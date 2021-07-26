package atdd.framework;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import oracle.net.aso.e;

/**
 * @author pjaising
 *
 */
public abstract class UhcDriver {

	public WebDriver driver;

	private long defaultTimeoutInSec = 20;

	@FindBy(xpath = ".//iframe[contains(@id,'IPerceptionsEmbed')]")
	public WebElement IPerceptionsFrame;

	@FindBy(xpath = "//*[contains(@class,'btn-no')]")
	public WebElement IPerceptionNoBtn;

	@FindBy(xpath = "//img[@alt='menu icon']")
	public WebElement MenuMobile;

	@FindBy(css = "#mobile-nav > div.scroll-pane > div > div.mob-menu-header > div.icn-sctn > button.icon-mob-btn.dropdown-btn")
	public WebElement siteSearchTextBox;

	@FindBy(xpath = "//*[@id='ghn_lnk_3']/span")
	public WebElement LearnAboutMedicare;

	@FindBy(xpath = "//p[contains(text(),'Introduction to Medicare')]")
	public WebElement IntroductionToMedicare;

	@FindBy(xpath = "//div[contains(@class,'dropdown-container sub-level-3')]//a[normalize-space()='Prescriptions, Providers & Benefits']")
	public WebElement PrescriptionsProvidersBenefitsLink;

	@FindBy(xpath = "//span[contains(text(),'Shop For a Plan')]")
	public WebElement MenuShopForPlanMobile;

	@FindBy(css = "#shop-scroll > div.nav-row > div.mob-sctn.section-2.column.column-lg-4 > p")
	public WebElement PlanTypes;

	@FindBy(xpath = "//a[@dtmname='NavLinks:Shop for a Plan:Plan Types:Drug Cost Estimator']")
	public WebElement DCERedesignLink;

	@FindBy(xpath = "//a[@dtmname='NavLinks:Shop for a Plan:Plan Types:Pharmacy Search']")
	public WebElement PharmacyTool;

	@FindBy(xpath = "//h3//a[@dtmname='NavLinks:Shop for a Plan:Plan Types:Get a Plan Recommendation' and text()='Get a Plan Recommendation']")
	public WebElement GetPlanRecoMobile;

	@FindBy(css = "#shop-scroll > div.nav-row > div.column.section-1.column-lg-4 > h3:nth-child(1) > a")
	public WebElement ShopTool;

	@FindBy(xpath = "//p[@class='dropdown-btn'][normalize-space()='Tools to help you choose a plan']")
	public WebElement toolsToChoosePlan;

	@FindBy(xpath = "//a[@dtmname='NavLinks:Shop for a Plan:Plan Types:Provider Search']")
	public WebElement ProviderSearch;

	@FindBy(css = "div[class*='get-started-banner'] button")
	private WebElement getStartedBtn;

	@FindBy(xpath = "//body/div/header[@role='banner']/div/div/div/div/div[@role='navigation']/div/div/div/div/ul[@data-role='navigation']/li[2]/div[2]/div[1]/div[1]/span[1]")
	private WebElement MobileMenuBackBtn;

	@FindBy(xpath = "//a[.='Back to Top']")
	private WebElement backToTop;

	public void MobileMenu() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(toolsToChoosePlan);
		scrollToView(GetPlanRecoMobile);
		jsClickNew(GetPlanRecoMobile);
	}

	public void MobileMenuProviderSearch() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(toolsToChoosePlan);
		jsClickNew(ProviderSearch);
	}

	public void MobileMenuMain() {
		scrollToView(MenuMobile);
		jsClickNew(MenuMobile);

	}

	public void MobileLearnAboutMedicare() {
		scrollToView(MenuMobile);
		jsClickNew(MenuMobile);
		jsClickNew(LearnAboutMedicare);
		jsClickNew(IntroductionToMedicare);

	}

	public void MobileLearnAboutMedicarePrescProvBenefit() {
		scrollToView(MenuMobile);
		jsClickNew(MenuMobile);
		jsClickNew(LearnAboutMedicare);
		jsClickNew(IntroductionToMedicare);
		jsClickNew(PrescriptionsProvidersBenefitsLink);

	}

	public void MobileMenuAndGetStarted() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(toolsToChoosePlan);
		jsClickNew(GetPlanRecoMobile);
		jsClickNew(getStartedBtn);

	}

	public void MobileMenuAndGetPlanRecom() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(toolsToChoosePlan);
		jsClickNew(GetPlanRecoMobile);

	}

	public void MobileMenuShopTool() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		// jsClickNew(ShopTool);
	}

	public void MobileMenuToShopToolToShop() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(ShopTool);
	}

	public void MobileMenuToPlanTypes() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(PlanTypes);
	}

	public void MobileMenuToolsToHelp() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		scrollToView(toolsToChoosePlan);
		jsClickNew(toolsToChoosePlan);

	}

	public void MobileMenuAccessDCE() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(toolsToChoosePlan);
		jsClickNew(DCERedesignLink);
	}

	public void MobileMenuSiteSearch() {
		jsClickNew(MenuMobile);
		jsClickNew(siteSearchTextBox);
	}

	public void MobileMenuAccessPharmacy() {
		jsClickNew(MenuMobile);
		jsClickNew(MenuShopForPlanMobile);
		jsClickNew(toolsToChoosePlan);
		scrollToView(PharmacyTool);
		jsClickNew(PharmacyTool);
	}

	public void start(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void startNewMobile(String url) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	public UhcDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void switchToNewTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
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

	public static void sendkeys(WebElement element, String message) {
		if (MRScenario.mobileDeviceOSName.equalsIgnoreCase("IOS")) {
			element.click();
			element.clear();
			element.sendKeys(message);
		} else {
			element.click();
			element.clear();
			element.sendKeys(message);
		}

	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * To handle iOS specific sendkeys problem By: Harshal Ahire
	 */
	public void sendkeysMobile(WebElement element, String message) {
		if (MRScenario.mobileDeviceOSName.equalsIgnoreCase("IOS")) {

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendKeys_IOS(element, message);
			element.getText().replaceAll("\u00A00", " ").trim();
			element.sendKeys(Keys.ENTER);

			// element.sendKeys(Keys.BACK_SPACE);

		} else {
			// scrollToView(element);
			jsClickNew(element);
			threadsleep(5); // Adding 5ms wait
			element.clear();
			element.sendKeys(message);
		}

	}

	public void sendKeysByCharacter(WebElement element, String message) {
		scrollToView(element);
		element.click();
		element.clear();
		jsClickNew(element);
		for (int i = 0; i < message.length(); i++) {
			threadsleep(5); // Adding some milliseconds wait
			char c = message.charAt(i);
			StringBuilder s = new StringBuilder().append(c);
			element.sendKeys(s);
		}
	}

	/*
	 * To handle iOS specific sendkeys problem By: Harshal Ahire
	 */
	public void sendKeys_IOS(WebElement webElement, String valueToSend) {

		((JavascriptExecutor) driver).executeScript(
				"let input = arguments[0];var setValue = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;setValue.call(input, '"
						+ valueToSend + "');var e = new Event('input', { bubbles: true });input.dispatchEvent(e);",
				webElement);
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
			System.out.println("Exception: Element not found/not visible. Exception message - " + e.getMessage());

		}
		return false;

		/*
		 * //CM
		 * 
		 * JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollBy(0,-50)", ""); try {
		 * waitforElement(element); if (element.isDisplayed()) { Actions actions = new
		 * Actions(driver); actions.moveToElement(element); actions.perform();
		 * Assertion.assertTrue("@@@The element " + element.getText() + "is found@@@",
		 * element.isDisplayed()); System.out.println("@@@The element " +
		 * element.getText() + "is found@@@"); } } catch (Exception e) {
		 * Assertion.fail("The element " + element.getText() + "is not  found"); return
		 * false; }
		 * 
		 * return true;
		 */
	}

	public WebElement findElement(ElementData elementData) {

		WebElement element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.linkText(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.name(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElement(By.tagName(elementData.getElementName()));
			}

			return element;
		} catch (Exception e) {
			return null;
		}

	}

	public WebElement findChildElement(ElementData elementData, WebElement parentElement) {

		WebElement element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElement(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElement(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElement(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElement(By.linkText(elementData.getElementName()));

			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElement(By.name(elementData.getElementName()));

			} else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElement(By.tagName(elementData.getElementName()));

			}
			return element;
		} catch (Exception e) {
			return element;
		}
	}

	public List<WebElement> findChildElements(ElementData elementData, WebElement parentElement) {

		List<WebElement> element = null;
		try {
			if (elementData.getIdentifier().equalsIgnoreCase("id")) {

				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElements(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElements(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = parentElement.findElements(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElements(By.linkText(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElements(By.name(elementData.getElementName()));

			} else if (elementData.getIdentifier().equalsIgnoreCase("tagName")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = parentElement.findElements(By.tagName(elementData.getElementName()));
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
				element = driver.findElements(By.id(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("className")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElements(By.className(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("xpath")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				element = driver.findElements(By.xpath(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("linkText")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = driver.findElements(By.linkText(elementData.getElementName()));
			} else if (elementData.getIdentifier().equalsIgnoreCase("name")) {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				element = driver.findElements(By.name(elementData.getElementName()));
			} else if (elementData.getIdentifier().contains("select:")) {
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				String[] identifierArr = elementData.getIdentifier().split(":");
				if (identifierArr[1].equalsIgnoreCase("className")) {
					WebElement selectElement = driver.findElement(By.className(elementData.getElementName()));
					Select select = new Select(selectElement);
					element = select.getOptions();
				} else if (identifierArr[1].equalsIgnoreCase("id")) {
					WebElement selectElement = driver.findElement(By.id(elementData.getElementName()));
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

		FluentWait<WebDriver> wait = new WebDriverWait(driver, Long.parseLong(System.getProperty("base.timeout", "1")))
				.withTimeout(Long.parseLong(System.getProperty("base.timeout", "1")), TimeUnit.SECONDS);
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
	 * Generic method to capture the dtm data both static and dynamic. The variable
	 * dtm files are kept under page-objects/dtm-common-data/ Currently only member
	 * and aquisition files are there. More foles can be added if required. Input
	 * params are fileName: Json file name containing the web elements names and id,
	 * so that they can be read from current page. filePath: Path to the folder
	 * containing fileName dtmFilePath: Json file name containing the dynamic dtm
	 * tags variable and their path dtmDir: Path to the dtmFilePath
	 */
	public JSONObject getDTMPageJson(String fileName, String filePath, String dtmFilePath, String dtmDir) {

		PageData pageData = CommonUtility.readPageData(fileName, filePath);
		JSONObject jsonObject = new JSONObject();
		for (String key : pageData.getExpectedData().keySet()) {
			WebElement element = findElement(pageData.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {

					JSONObject dtmObject = new JSONObject();
					if (element.getAttribute("dtmname") != null && element.getAttribute("dtmid") != null) {
						try {
							dtmObject.put("dtmid", element.getAttribute("dtmid"));
							dtmObject.put("dtmname", element.getAttribute("dtmname"));
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
					} else {
						System.out.println("DTM id or DTM name was not found for Element:" + key);
					}

				} else {
					System.out.println("Validation failed for element::" + key);
				}
			}
		}

		try {
			jsonObject.put("dtmPageData", CommonUtility.checkForVariable(driver, dtmFilePath, dtmDir));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}

	/*
	 * To handle iOS specific click problem By: Harshal Ahire
	 */
	public void iOSClick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"var ele = arguments[0];ele.addEventListener('click', function() {ele.setAttribute('automationTrack','true');});",
					element);
			// checkElementisEnabled(element);
			scrollToView(element);
			element.click();
			sleepBySec(2);
			String seleniumClick = element.getAttribute("automationTrack");
			System.out.println("Selenium Click executed........" + seleniumClick);

			// If automationTrack is null and element is displayed,
			// then selenium click was not successful
			seleniumClick = (seleniumClick == null && element.isDisplayed()) ? "false" : "true";

			if (!seleniumClick.equalsIgnoreCase("true")) {
				System.out.println("Trying JSClick on IOS ..........");
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].click();", element);
			}
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			System.out.println("Selenium click got executed but, " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Click and JsClick failed");
		}
	}

	public void jsClickNew(WebElement element) {

		if (driver.getClass().toString().toUpperCase().contains("IOS")) {

			/* To handle iOS specific click problem By: Harshal Ahire */

			iOSClick(element);
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
				scrollToView(element);
			}
			js.executeScript("arguments[0].click();", element);
		}

	}

	public String getidentifier(WebElement element) {
		String elementStr = element.toString();
		return "[" + elementStr.substring(elementStr.indexOf("->") + 3);

	}

	public boolean checkElementisEnabled(WebElement element) {
		System.out.println("Looking for Element to enable .......");
		try {
			if (element.getAttribute("@disbaled") == "true") {
				System.out.println("Element is enabled to perform action .......");

			}
		} catch (Exception e) {
			System.out.println("Element not enabled hence action failed on screen....");
		}

		return true;

	}

	public boolean checkElementisDisabled(WebElement element) {
		System.out.println("Looking for Element to disable .......");
		try {
			if (element.getAttribute("@disbaled") != "true") {
				System.out.println("Element is disabled.......");

			}
		} catch (Exception e) {
			System.out.println("Element is enabled hence action failed....");
		}

		return true;

	}

	public boolean scrollToView(WebElement element) {
		if (driver.getClass().toString().toUpperCase().contains("IOS")
				|| driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			scrollElementInMobileView(element);
			// iosScroll(element);

		} else {
			try {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", element);
			} catch (Exception e) {

				Assertion.fail("The element " + element + "is not  found");
				return false;
			}
		}
		return true;
	}

	private boolean scrollElementInMobileView(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].scrollIntoView({behavior: \"auto\", block: \"center\", inline: \"center\"});",
					element);
		} catch (Exception e) {
			Assertion.fail("The element " + element + " is not found for scrolling into view");
			return false;
		}
		return true;
	}

	/***
	 * the method imposes an implicit wait of 10 sec and navigates to provided URL
	 * 
	 * @param url
	 */
	public void startNewPRE(String url, String browser) {

		System.out.println("Browser Name: " + browser);
		if (browser.equals("safari"))
			driver.get(url);
		else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
		}
	}

	public void startNew(String url) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	/***
	 * the method waits for upto 30 sec till element gets visible before throwing an
	 * exception
	 * 
	 * @param element
	 */
	public void waitforElementNew(WebElement element, long timeoutInSec) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/***
	 * the method clicks on an element and the wait till another tab gets open and
	 * switches to it
	 * 
	 * @param Element
	 */
	public void switchToNewTabNew(WebElement Element) {

		CommonConstants.setMainWindowHandle(driver.getWindowHandle());
		int initialCount = driver.getWindowHandles().size();
		scrollToView(Element);
		jsClickNew(Element);
		waitForPageLoadSafari();
		waitForCountIncrement(initialCount);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		String currentHandle = null;
		for (int i = 0; i < initialCount + 1; i++) {
			driver.switchTo().window(tabs.get(i));
			currentHandle = driver.getWindowHandle();
			if (!currentHandle.contentEquals(CommonConstants.getMainWindowHandle()))
				break;
		}

	}
	/*
	 * Author: Harshal Ahire
	 * 
	 * To interact with Shadow element for IOS
	 * 
	 * @Params driver, shadowHost, cssOfShadowElement
	 */

	/*
	 * // get the shadowHost in the original dom using findElement WebElement
	 * shadowHost = driver.findElement(By.cssSelector("#county")); // get the shadow
	 * root WebElement shadowRoot = getShadowRoot((AppiumDriver)driver,shadowHost);
	 * // access shadow tree element WebElement shadowTreeElement =
	 * shadowRoot.findElement(By.cssSelector("#county > option:nth-child(2)"));
	 */

	public static WebElement getShadowElement(WebDriver driver, WebElement shadowHost, String cssOfShadowElement) {
		WebElement shardowRoot = getShadowRoot(driver, shadowHost);
		return shardowRoot.findElement(By.cssSelector(cssOfShadowElement));
	}

	private static WebElement getShadowRoot(WebDriver driver, WebElement shadowHost) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
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
	 * the method first scroll to particular field 9after waiting) and the writes in
	 * that field
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
		if (driver.getClass().toString().toUpperCase().contains("IOS")
				|| driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			scrollToView(element);
		} else {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-50)", "");
		}
		try {
			waitforElementNew(element, timeoutInSec);
			if (element.isDisplayed()) {
				Assertion.assertTrue("@@@The element " + element.getText() + "is found@@@", element.isDisplayed());
				// System.out.println("@@@The element " + element.getText() + "is found@@@");
			}
		} catch (Exception e) {

			Assertion.fail("The element " + element + "is not  found");
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
				Assertion.assertTrue("Pattern matches for the text:" + input, true);
			else
				Assertion.fail("Pattern does not matches");
		} catch (IllegalArgumentException ex) {
			System.out.println("Exception - " + ex.toString());
			System.out.println("Exception message: " + ex.getMessage());
			Assertion.fail("Error!!!" + ex.getMessage());
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
			Assertion.fail("Expected value is not present in dropdown");
	}

	public void selectFromDropDownByValue(WebElement dropdownElement, String value) {

		scrollToView(dropdownElement);
		Select dropdown = new Select(dropdownElement);
		waitUntilSelectOptionsPopulated(dropdown);
		if (driver.getClass().toString().toUpperCase().contains("IOS")) {
			String dropDownOptionText = dropdownElement.findElement(By.xpath("//option[@value='" + value + "']"))
					.getText().trim();
			mobileSelectOption(dropdownElement, dropDownOptionText, true);
		} else {
			dropdown.selectByValue(value);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		waitUntilSelectOptionsPopulated(dropdown);
		if (!dropdown.getFirstSelectedOption().getAttribute("value").trim().equalsIgnoreCase(value))
			Assertion.fail("Expected value is not present in dropdown");
	}

	public void waitUntilSelectOptionsPopulated(final Select select) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2,
				TimeUnit.MILLISECONDS);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver d) {
				return (select.getOptions().get(0));
			}
		});
	}

	/***
	 * the method waits for maximum 30 sec till element gets disapper throwing an
	 * exception
	 * 
	 * @param element
	 */
	public void waitforElementDisapper(By by, long timeout) {

		System.out.println("Waiting for element to disappear!!!");
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

	}

	/***
	 * Created by - agarg119 The method waits for 2 seconds (increasing timeout may
	 * affect execution performance) to validate element is not present on screen.
	 * 
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
	 * Created By - agarg119 the method waits for mentioned seconds till element
	 * gets visible before throwing an exception
	 * 
	 * @param element
	 */
	public void waitforElementVisibilityInTime(WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/***
	 * Created By - agarg119 the method waits for mentioned seconds till element
	 * gets clickable throwing an exception
	 * 
	 * @param element
	 */
	public void waitTillElementClickableInTime(WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/***
	 * Created By - agarg119 the method waits for mentioned seconds till dropdown
	 * options gets visible throwing an exception
	 * 
	 * @param element
	 * @param timeout
	 */
	public void waitTllOptionsAvailableInDropdown(WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, By.tagName("option")));

	}

	/*
	 * Created By - hahire It will move to the element and clicks (without
	 * releasing) in the middle of the given element (Use for IOS)
	 * 
	 * @param element
	 */

	public void clickAndHold(WebElement element) {
		Actions actionProvider = new Actions(driver);
		// Perform click-and-hold action on the element
		actionProvider.clickAndHold(element).build().perform();
	}

	/***
	 * Created By - agarg119 the method waits for the iframe to be available and
	 * switch to it throwing an exception
	 * 
	 * @param element
	 */
	public void waitTillFrameAvailabeAndSwitch(WebElement element, long timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}

	/* logic to simulate hover over functionality */
	public void navigateToMenuLinks(WebElement hdrMenuElement, WebElement menuDropListItem) {

		/*
		 * Actions actions = new Actions(driver); actions.moveToElement(hdrMenuElement);
		 * actions.moveToElement(menuDropListItem); actions.click().build().perform();
		 */
		jsMouseOver(hdrMenuElement);
		jsMouseOver(menuDropListItem);
		menuDropListItem.click();
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void clickIfElementPresentInTime(WebDriver driver, WebElement element, int timeInSec) {
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
		checkModelPopup(driver, defaultTimeoutInSec);
	}

	@FindBy(xpath = ".//*[contains(@id,'singleLargeLayoutContainer')]")
	public WebElement IPerceptionsPopup;

	@FindBy(xpath = "//*[contains(@id,'ip-no')]")
	public WebElement IPerceptionPopuNoBtn;

	public void checkModelPopup(WebDriver driver, long timeoutInSec) {

		CommonUtility.waitForPageLoad(driver, IPerceptionsFrame, timeoutInSec);
		CommonUtility.waitForPageLoad(driver, IPerceptionsPopup, timeoutInSec);

		try {
			if (IPerceptionsPopup.isDisplayed()) {
				// driver.switchTo().frame(IPerceptionsFrame);
				IPerceptionPopuNoBtn.click();
				// driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			System.out.println("IPerceptionsPopup not found");
			try {
				if (IPerceptionsFrame.isDisplayed()) {
					System.out.println("IPerceptionsFrame found");
					driver.switchTo().frame(IPerceptionsFrame);
					IPerceptionNoBtn.click();
					driver.switchTo().defaultContent();
				}
			} catch (Exception e1) {
				System.out.println("Iperceptions not found");
			}
		}
	}

	/**
	 * determine system time note: for prod no one would be changing the date, note:
	 * so just get the current time (the build system) note: and format it the same
	 * like the one using getSystemTime from MRRestWAR note: keep the format: Mon
	 * Oct 14 17:14:06 UTC 2019
	 * 
	 * @return
	 */
	@FindBy(xpath = "//body")
	protected WebElement timeJson;

	public String getMemTestEnvSysTime() {

		String timeStr = "";
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to check the system time");
		// tbd String urlGetSysTime="https://www." + MRScenario.environment +
		// "-medicare." + MRScenario.domain+ "/MRRestWAR/rest/time/getSystemTime";
		String urlGetSysTime = "https://www." + MRScenario.environment + "-medicare." + MRScenario.domain
				+ "/UCPUserManagement/time/getSystemTime";
		System.out.println("test env URL for getting time: " + urlGetSysTime);
		if (MRScenario.environment.contains("team-ci"))
			// urlGetSysTime="https://www." + MRScenario.environment +
			// "-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/MRRestWAR/rest/time/getSystemTime";
			urlGetSysTime = "https://www." + MRScenario.environment
					+ "-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/UCPUserManagement/time/getSystemTime";
		if (MRScenario.environment.contains("team-voc"))
			urlGetSysTime = urlGetSysTime.replace("www.", "");
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + urlGetSysTime + "','_blank');");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement currentSysTimeElement = timeJson;
		String currentSysTimeStr = currentSysTimeElement.getText();
		System.out.println("currentSysTimeStr=" + currentSysTimeStr);

		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonObj;
		try {
			jsonObj = (org.json.simple.JSONObject) parser.parse(currentSysTimeStr);
			org.json.simple.JSONObject sysTimeJsonObj = (org.json.simple.JSONObject) jsonObj;

			timeStr = (String) sysTimeJsonObj.get("systemtime");
		} catch (ParseException e) {
			e.printStackTrace();
			Assertion.assertTrue("PROBLEM - unable to find out the system time", false);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return timeStr;
	}

	public String getAcqTestEnvSysTime(String testSiteUrl) {

		String timeStr = "";
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to check the system time");
		// tbd String urlGetSysTime=testSiteUrl+
		// "/DCERestWAR/dcerest/profiledetail/bConnected";
		String urlGetSysTime = testSiteUrl + "/PlanBenefitsWAR/profiledetail/aarp";
		System.out.println("test env URL for getting time: " + urlGetSysTime);
		// open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('" + urlGetSysTime + "','_blank');");

		if (driver.getClass().toString().toUpperCase().contains("IOS")) {
			System.out.println("Waiting for accepting the open new window alert on iOS device");
			threadsleep(5000);
			waitForCountIncrement(1);
		}

		for (String winHandle : driver.getWindowHandles()) {
			if (!winHandle.equals(winHandleBefore)) {
				driver.switchTo().window(winHandle);
				break;
			}
		}
		waitForPageLoadSafari();
		threadsleep(2000);
		WebElement currentSysTimeElement = timeJson;
		String currentSysTimeStr = currentSysTimeElement.getText();
		System.out.println("currentSysTimeStr=" + currentSysTimeStr);
		JSONParser parser = new JSONParser();
		org.json.simple.JSONObject jsonObj;
		try {
			jsonObj = (org.json.simple.JSONObject) parser.parse(currentSysTimeStr);
			org.json.simple.JSONObject sysTimeJsonObj = (org.json.simple.JSONObject) jsonObj;

			org.json.simple.JSONObject dataObj = (org.json.simple.JSONObject) sysTimeJsonObj.get("data");
			timeStr = (String) dataObj.get("systemDate");
		} catch (ParseException e) {
			e.printStackTrace();
			Assertion.assertTrue("PROBLEM - unable to find out the system time", false);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return timeStr;
	}

	/**
	 * @author Murali - mmurugas This method will perform vertical swipe on mobile
	 *         screen for given %
	 */
	public boolean mobileswipe(String percentage, boolean swipeup) {
		boolean swipeSuccess = true;

		AppiumDriver mobiledriver = (AppiumDriver) driver;
		TouchAction mact = new TouchAction(mobiledriver);
		Dimension size = mobiledriver.manage().window().getSize();
		// Starting y location set to 85% - 90% of the height (near bottom)
		Random rand = new Random();
		double start = 0.85d, end = 0.90d;
		double val = start + (end - start) * rand.nextDouble();
		// System.out.println(val);
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		String randomPercentage = numberFormat.format(val);
		// System.out.println("randomPercentage Swipe - "+randomPercentage);
		int starty = (int) (size.height * Double.parseDouble(randomPercentage));
		// Ending y location set to % of the height (near top)
		percentage = "0.".concat(percentage.replace("%", ""));
		int endy = (int) (size.height * Float.valueOf(1 - Float.valueOf(percentage)));
		if (!swipeup)
			endy = endy + (int) (size.height * 0.2);
		// Above line is to avoid address bar position while swiping top to bottom.
		// x position set to mid-screen horizontally
		int startx = (int) size.width / 2;
		// System.out.println(size+" "+startx+" "+starty+" "+endy);
		threadsleep(500);
		try {
			if (swipeup)
				mact.press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(startx, endy)).release().perform();
			else
				mact.press(PointOption.point(startx, endy)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(startx, starty)).release().perform();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("-------------- Exception occurred while Swiping --------------------");
			swipeSuccess = false;
		}
		threadsleep(500);
		return swipeSuccess;
	}

	public void mobileswipe(String percentage, int count, boolean swipeup) {
		for (int i = 1; i <= count; i++) {
			mobileswipe(percentage, swipeup);
		}
	}

	/**
	 * @author Murali - mmurugas This method will hide mobile keypad
	 */
	@SuppressWarnings("rawtypes")
	public void hidekeypad() {

		try {
			threadsleep(2000);
			if (driver.getClass().toString().toUpperCase().contains("ANDROID")) // wd.getClass().toString().toUpperCase().contains("IOS"))
				// {
				((AndroidDriver) driver).hideKeyboard();
			else {
				clickTextIOSNative("Done");
			}
			threadsleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(driver.getCurrentUrl());
		}
	}

	public void getkeypad() {

		threadsleep(1000);
		if (driver.getClass().toString().toUpperCase().contains("ANDROID"))
			((AndroidDriver) driver).getKeyboard();
		else
			((IOSDriver) driver).getKeyboard();
		threadsleep(1000);
	}

	public void mobileactiontap(WebElement element) {

		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			Actions act = new Actions(driver); // Works only for Android driver
			act.click(element).perform();
		} else
			jsClickNew(element);
		// jsClickMobile(element);
	}

	public void mobileactionsendkeys(WebElement element, String keys) {

		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			Actions act = new Actions(driver); // Works only for Android driver
			act.click(element).sendKeys(keys).perform();

		} else {
			// element.setValue("10001");
			// ((JavascriptExecutor)webDriver).executeScript("arguments[0].value='100011';",
			// m);
			// ((AppiumDriver)webDriver).getKeyboard().pressKey(Keys.BACK_SPACE);
			element.clear();
			element.click();
			threadsleep(500);
			element.click();
			((AppiumDriver) driver).getKeyboard().sendKeys(keys);
		}
	}

	public void jsSendkeys(WebElement searchBox, String keys) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='" + keys + "';", searchBox);
	}

	public void pageloadcomplete() {
		new WebDriverWait(driver, 30).until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		System.out.println("Page load completed");
	}

	public void mobileFindElement(WebElement element, int swipeCount, boolean swipeUp) {
		try {
			waitTillElementClickableInTime(element, 3);
			// new Actions(driver).moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not visible");
			if (swipeCount < 1)
				return;
			mobileswipe("80%", swipeUp);
			swipeCount--;
			mobileFindElement(element, swipeCount, swipeUp);
		}
	}

	/**
	 * @author Murali - mmurugas This method will select option from dropdown based
	 *         on visible text mobile Updated By - Harshal Ahire
	 */
	public void mobileSelectOption(WebElement selectElement, String option, boolean clickElement) {

		if (driver.getClass().toString().toUpperCase().contains("ANDROID")
				|| MRScenario.mobileDeviceOSName.equalsIgnoreCase("ANDROID")) {
			Select element = new Select(selectElement);
			element.selectByVisibleText(option);
		} else {
			String curHandle = ((IOSDriver) driver).getContext();
			System.out.println("curHandle - " + curHandle);
			System.out.println(((IOSDriver) driver).getContextHandles());
			if (clickElement)
				jsClickNew(selectElement);
			threadsleep(2000);
			((IOSDriver) driver).context("NATIVE_APP");
			driver.findElement(MobileBy.className("XCUIElementTypePickerWheel")).sendKeys(option);
			threadsleep(500);
			((IOSDriver) driver).findElement(MobileBy.AccessibilityId("Done")).click();
			((IOSDriver) driver).context(curHandle);
			System.out.println("curHandle - " + ((IOSDriver) driver).getContext());
		}
	}

	/*
	 * @author : Harshal Ahire
	 * 
	 * @Params: dropdwon option
	 *
	 * To select value in dropdpwn via JsScript in IOS device
	 *****/
	public void iosDropDownSelection(String option) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.getElementsByClassName('uhc-select uhc-select--block county-dropdown ng-pristine ng-valid ng-touched').value =='"
						+ option + "';");
	}

	public void iosScroll(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickTextIOSNative(String text) {

		String curHandle = ((IOSDriver) driver).getContext();
		System.out.println("curHandle - " + curHandle);
		try {
			System.out.println(((IOSDriver) driver).getContextHandles());
			((IOSDriver) driver).context("NATIVE_APP");
			((IOSDriver) driver).findElement(MobileBy.AccessibilityId(text)).click();
			threadsleep(500);
		} catch (Exception e) {
			System.out.println("IOS Screen Unable to Click text : " + text);
		}
		((IOSDriver) driver).context(curHandle);
		System.out.println("curHandle - " + ((IOSDriver) driver).getContext());
	}

	public void fixFormResubmissionAndroid(boolean positive) {

		String curHandle = ((AndroidDriver) driver).getContext();
		System.out.println("curHandle - " + curHandle);
		System.out.println(((AndroidDriver) driver).getContextHandles());
		((AndroidDriver) driver).context("NATIVE_APP");
		try {
			if (positive)
				((AndroidDriver) driver).findElement(MobileBy.id("com.android.chrome:id/positive_button")).click();
			else
				((AndroidDriver) driver).findElement(MobileBy.id("com.android.chrome:id/negative_button")).click();
		} catch (Exception e) {
			System.out.println("Unable/No form resubmission");
		}
		threadsleep(500);
		((AndroidDriver) driver).context(curHandle);
		System.out.println("curHandle - " + ((AndroidDriver) driver).getContext());
	}

	/**
	 * @author Murali - mmurugas This method will re-submit if form submission popup
	 *         arises mobile
	 */
	public void fixFormResubmission(boolean positive) {

		if (driver.getClass().toString().toUpperCase().contains("ANDROID"))
			fixFormResubmissionAndroid(positive);
	}

	public String ReturnDriverStorage(WebDriver driver, String StorageType, String StorageKey) {
		String ReturnValue = "";
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
		if (StorageType.equalsIgnoreCase("local storage") || StorageType.equalsIgnoreCase("localstorage")) {
			LocalStorage localStorage = webStorage.getLocalStorage();
			ReturnValue = localStorage.getItem(StorageKey);
			System.out.println("Local Storage - Key: " + StorageKey + "; Value: " + ReturnValue);
		} else if (StorageType.equalsIgnoreCase("session storage") || StorageType.equalsIgnoreCase("sessionstorage")) {
			SessionStorage sessionStorage = webStorage.getSessionStorage();
			ReturnValue = sessionStorage.getItem(StorageKey);
			System.out.println("Session Storage - Key: " + StorageKey + "; Value: " + ReturnValue);
		}
		return ReturnValue;
	}

	public void threadsleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Murali - mmurugas This method will perform horizontal swipe on mobile
	 *         screen
	 */
	public boolean mobileswipeHorizantal(String percentage, boolean swiperight) {

		boolean swipeSuccess = true;
		AppiumDriver mobiledriver = (AppiumDriver) driver;
		TouchAction mact = new TouchAction(mobiledriver);
		Dimension size = mobiledriver.manage().window().getSize();
		// Starting x location set to % of the width (near left end)
		percentage = "0.".concat(percentage.replace("%", ""));
		// System.out.println("percentage : "+percentage);
		int startx = (int) (size.width * Float.valueOf(1 - Float.valueOf(percentage)));
		// Ending x location set to 90% - 95% of the width (near right end)
		Random rand = new Random();
		double start = 0.90d, end = 0.95d;
		double val = start + (end - start) * rand.nextDouble();
		// System.out.println(val);
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		String randomPercentage = numberFormat.format(val);
		// System.out.println("randomPercentage Swipe - "+randomPercentage);
		int endx = (int) (size.width * Double.parseDouble(randomPercentage));
		// Y position set to 50% of height Vertically
		int starty = (int) (size.height / 2);
		// System.out.println(size + " " + startx + " " + endx + " " + starty);
		threadsleep(500);
		try {
			if (swiperight) {
				// mact.longPress(PointOption.point(startx,
				// starty)).moveTo(PointOption.point(endx, starty)).release().perform();
				mact.press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(endx, starty)).waitAction().release().perform();
			} else {
				// mact.longPress(PointOption.point(endx,
				// starty)).moveTo(PointOption.point(startx, starty)).release().perform();
				mact.press(PointOption.point(endx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(startx, starty)).release();
				mobiledriver.performTouchAction(mact);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("------------- Exception occurred while Horizantal Swiping -----------------------");
			swipeSuccess = false;
		}
		threadsleep(500);
		return swipeSuccess;
	}

	public void mobileswipeHorizantal(String percentage, int count, boolean swiperight) {
		for (int i = 1; i <= count; i++) {
			mobileswipeHorizantal(percentage, swiperight);
		}
	}

	public void waitforElementInvisibilityInTime(WebElement element, long timeout) {
		System.out.println("Checking Element Invisibility");

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void mobileactiondragdrop(WebElement dragelement, WebElement dropelement, boolean swipeVertical) {
		System.out.println("Drag Drop");

		AppiumDriver mobiledriver = (AppiumDriver) driver;
		TouchAction mact = new TouchAction(mobiledriver);
		int dragx = dragelement.getLocation().getX();
		int dragy = dragelement.getLocation().getY();
		int dropx = dropelement.getLocation().getX();
		int dropy = dropelement.getLocation().getY();
		System.out.println(dragx + "," + dragy + "," + dropx + "," + dropy);
		mact.longPress(PointOption.point(dragx, dragy)).moveTo(PointOption.point(dropx, dropy)).release().perform();
		System.out.println("All");
	}

	/*
	 * public void jsClickMobile(WebElement element) {
	 * 
	 * if (driver.getClass().toString().toUpperCase().contains("ANDROID") ||
	 * driver.getClass().toString().toUpperCase().contains("WEBDRIVER")) {
	 * JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].click();", element); } else if
	 * (driver.getClass().toString().toUpperCase().contains("IOS")) {
	 * 
	 * iOSClick(element);
	 * 
	 * }
	 * 
	 * }
	 */

	public String returnDriverStorageJS(String StorageType, String StorageKey) {
		String ReturnValue = "";

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		if (StorageType.equalsIgnoreCase("local storage") || StorageType.equalsIgnoreCase("localstorage")) {
			ReturnValue = (String) js
					.executeScript(String.format("return window.localStorage.getItem('%s');", StorageKey));
			System.out.println("Local Storage - Key: " + StorageKey + "; Value: " + ReturnValue);
		} else if (StorageType.equalsIgnoreCase("session storage") || StorageType.equalsIgnoreCase("sessionstorage")) {
			ReturnValue = (String) js
					.executeScript(String.format("return window.sessionStorage.getItem('%s');", StorageKey));
			System.out.println("Session Storage - Key: " + StorageKey + "; Value: " + ReturnValue);
		}
		return ReturnValue;
	}

	public void addDrugs() {
		// TODO Auto-generated method stub

	}

	/**
	 * Wait for page load in Safari browser, by checking the invisibility of loading
	 * spinners which show in different flows
	 *
	 * @return true, if successful
	 * @author amahale
	 */
	public boolean waitForPageLoadSafari() {
		boolean ready = false;

		if (MRScenario.browserName.equalsIgnoreCase("Safari")) {
			// Sets FluentWait Setup
			List<WebElement> loadingScreen = null;
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class);

			// First checking to see if the loading indicator is found
			// we catch and throw no exception here in case they aren't ignored
			try {
				threadsleep(5000); // Adding sleep since the loading spinner sometimes takes long to come up
				System.out.println("Waiting to check if Loading screen is present");
				loadingScreen = fwait.until(new Function<WebDriver, List<WebElement>>() {
					public List<WebElement> apply(WebDriver driver) {
						return driver.findElements(By.xpath(

								"//div[(((@id='overlay' and not(./ancestor::footer)) or @id='loading_fader' or @class='spinner' or @id='loader' or @class='uhc-spinner') and not(contains(@style,'none')))]"));
						// @class='loading-block' ==> Old spinner locator on pharmacy search page.

					}
				});
			} catch (Exception e) {
			}

			// checking if loading indicators were found and if so we wait for it to
			// disappear
			if (!CollectionUtils.isEmpty(loadingScreen)) {
				System.out.println("Loading screen visible!!! Waiting till it disappears");
				WebDriverWait wait = new WebDriverWait(driver, 10);
				try {
					ready = wait.until(ExpectedConditions.invisibilityOfAllElements(loadingScreen));
				} catch (NoSuchElementException e) {
					// If no loading screen element found, page is ready
					ready = true;
				} catch (TimeoutException t) {
					// If script timed out finding loading screen element, page is ready
					ready = true;
				}
				System.out.println("Loading screen disappeared, page is ready.");
			} else {
				System.out.println("No loading screen element(s) found");
			}
		}
		return ready;
	}

	/**
	 * move mouse out from the element using jQuery event, mouseout.
	 *
	 * @param element
	 *            the element
	 * @return true, if successful
	 * 
	 *         Note: Use in combination with jsMouseOver
	 */
	public boolean jsMouseOut(WebElement element) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$(arguments[0]).mouseout();", element);
		} catch (Exception e) {
			Assertion.fail("The element " + element.getText() + "is not  found");
			return false;
		}

		return true;
	}

	/**
	 * mouse over using jQuery event, mouseover.
	 *
	 * @param element
	 *            the element
	 * @return true, if successful
	 * 
	 *         Note: use the jsMouseOut if using jsMouseOver for tooltip
	 */
	public boolean jsMouseOver(WebElement element) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$(arguments[0]).mouseover();", element);
		} catch (Exception e) {
			Assertion.fail("The element " + element.getText() + "is not  found");
			return false;
		}

		return true;
	}

	public int countOfNewWindowTab() {

		return driver.getWindowHandles().size();
	}

	/**
	 * Grant memory access on android chrome.
	 *
	 * @author amahale
	 * @param pdfLink
	 *            the pdf link
	 */
	public void grantPermissionOnAndroidChrome(WebElement pdfLink) {
		AppiumDriver mobileDriver = (AppiumDriver) driver;
		String webContext = mobileDriver.getContext();

		jsClickNew(pdfLink);

		WebDriverWait wait = new WebDriverWait(mobileDriver, defaultTimeoutInSec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("android:id/button1")));

		Set<String> contexts = mobileDriver.getContextHandles();

		for (String context : contexts) {
			if (context.contains("NATIVE_APP")) {
				mobileDriver.context(context);
				try {
					mobileDriver.findElement(By.id("android:id/button1")).click();
					mobileDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
					break;
				} catch (NoSuchElementException e) {
					System.out.println("Permission was already granted.");
				}
			}
		}

		sleepBySec(3); // Added sleep for letting a file to get downloaded.
		mobileDriver.context(webContext);
	}

	/**
	 * Gets the downloaded pdf file content on android device.
	 *
	 * @author amahale
	 * @param fileName
	 *            the file name without .pdf extension
	 * @return the downloaded pdf file content android
	 */

	public byte[] getDownloadedPdfFileContentAndroid(String fileName) {
		byte[] content = null;
		try {
			if (!fileName.isEmpty()) {
				AppiumDriver mobileDriver = (AppiumDriver) driver;
				content = mobileDriver.pullFile("/sdcard/Download/" + fileName + ".pdf");
			}
		} catch (Exception e) {
			Assertion.fail("Unable to read file " + fileName + " from sdcard/Download/");
		}

		return content;
	}

	/**
	 * Delete downloaded file from Android device.
	 * 
	 * @author amahale This is not working as of now. Since Appium server needs a
	 *         flag to be set while starting. this isn't possible on saucelabs as of
	 *         now
	 */
	public void deleteDownloadedFile() {
		AppiumDriver mobileDriver = (AppiumDriver) driver;
		List<String> removePDFArgs = Arrays.asList("-rf", "/sdcard/Download/PreEnrollment_Checklist_EN.pdf");
		Map<String, Object> removePDFCmd = ImmutableMap.of("command", "rm", "args", removePDFArgs);
		mobileDriver.executeScript("mobile: shell", removePDFCmd);
	}

}
