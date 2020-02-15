package pages.regression.healthandwellness;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class HealthAndWellnessPage extends UhcDriver{

	@FindBy(xpath = "//div[@class='hw-header']//span[contains(text(),'Health & Wellness')]")
	private WebElement titleText;
	
	@FindBy(linkText = "Health & Wellness")
	private WebElement rallyHealthAndWellness;

	//tbd @FindBy(xpath  = "//header[@class='hide-mobile']//a[contains(text(),'Health & Wellness')]")
	@FindBy(xpath  = "//a[contains(text(),'Health & Wellness')]")
	private WebElement healthAndWellness;

	@FindBy(id  = "healthwellness_4")
	private WebElement healthAndWellness_harness;
	
	@FindBy(id = "lifestyle_desk1")
	private WebElement lifestyleTab;

	@FindBy(id = "learning_desk1")
	private WebElement learningTab;

	@FindBy(xpath = "//*[@id='root']/div/main/div[1]/div/header/div/div[1]/h1/span")
	private WebElement lifestyleIcon;

	@FindBy(xpath = "//*[@id='quick-links']/div/div[4]/article/div/a")
	private WebElement learningIcon;

	@FindBy(id = "hl-hw-banner-lifestyle")
	private WebElement hnwLifestyleBanner;

	@FindBy(id = "hl-hw-banner-learning")
	private WebElement hnwLearningBanner;

	//@FindBy (xpath = "//header[@class='hide-mobile']//*[@id='main-nav']/div")
	//@FindBy (xpath = "//header[@class='hide-mobile']//div[@ng-switch-when='M&R']")
	@FindBy (xpath = "//header[@class='hide-mobile']//*[@id='sticky-nav']")
	private WebElement dashboardHeader;
	@FindBy (className = "menuL1")
	private WebElement dashboardHeader_harness;
	
	@FindBy (id = "rewards_desk")
	private WebElement rewadsTab;
	
	@FindBy (id = "renew-rewards-widget-target")
	private WebElement rewardsPage;
	
	@FindBy (partialLinkText = "REWARDED")
	private WebElement rewardsLink;
	
	@FindBy (linkText = "LEARN MORE")
	private WebElement learnmorelink;
	
	@FindBy(tagName="arcade-header")
	private WebElement shadowRootHeader;

	public HealthAndWellnessPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//note: comment out for now, step creating this object may not be landing on the actual page yet
		//validate(rallyHealthAndWellness,120);
	}

	/**
	 * clicks on Health n Wellness Tab
	 */
	public void clickHealthnWellnessTab(){
		String defaultCssPath="#main-nav > div > div > div > a[href*='health-and-wellness.html']";
		clickHealthnWellnessTab(defaultCssPath);
	}
	
	public void clickHealthnWellnessTab(String cssPath){
		try {
			if (MRScenario.environment.contains("team-a")) {
				Assert.assertTrue("KNOWN BEHAVIOR - The H&W page does not load on Team-A env due to non-availability of lower environment support from Talix (The third party vendor which actually hosts the page). Please validate on stage env", false);
			} 		
			healthAndWellness.isDisplayed();
			healthAndWellness.click();
			waitforElementNew(titleText,60);//note: sometimes it takes a long time to load H&W page
		} catch (Exception e) {
			if (validate(healthAndWellness_harness)) {
				System.out.println("Unable to locate Rally HW button but able to locate testharness HW button");
				System.out.println("Unable to locate the xpath for healthAndWellness for stage and non-harness, try the one for stage and harness");
				healthAndWellness_harness.isDisplayed();
				healthAndWellness_harness.click();
				waitforElement(titleText);
			} else {
				String defaultCssPath="#main-nav > div > div > div > a[href*='health-and-wellness.html']";
				System.out.println("Unable to Able to locate Rally or testharness HW button, last attemp for shadow-root");
				if (cssPath.equals("none")) 
					locateAndClickElementWithinShadowRoot(shadowRootHeader, defaultCssPath);
				else 
					locateAndClickElementWithinShadowRoot(shadowRootHeader,cssPath);
			}
		}
		hwCheckModelPopup(driver);
	}

	/**
	 * Validates Health and Wellness page
	 */
	public void validateHnWDashboardnL2Tabs(){
		Assert.assertTrue("Lifestyle icon is not displayed", lifestyleIcon.isDisplayed());
		//Assert.assertTrue("Learning icon is not displayed", learningIcon.isDisplayed());
		driver.getCurrentUrl();
		if (driver.getCurrentUrl().contains("health-and-wellness"))
		{
			System.out.println("Health and Wellness page Successfully loaded ");
			Assert.assertTrue(true);
		}
		else {
			System.err.println("Health and Wellness page not Successfully loaded ");
		}
		int x=0;
		while (x < 5) {
			if (validate(rewardsLink) || validate(learnmorelink)) {
				Assert.assertTrue("PROBLEM - unable to locate either one of the expected elements on page. rewardCheck="+validate(rewardsLink)+" | learnmoreCheck="+validate(learnmorelink), true);
				break;
			} else {
				sleepBySec(5);
				x=x+1;
				System.out.println("waited "+(5000*x)+" seconds for expected links to show");
			}
		}
		//one last attempt
		Assert.assertTrue("PROBLEM - unable to locate either one of the expected elements on page. rewardCheck="+validate(rewardsLink)+" | learnmoreCheck="+validate(learnmorelink), true);
	}


	/**
	 * validate Header on the  dashborad page
	 */
	public String validateHeaderOnDashborad(){
		String cssPath="none";
		if (validate(dashboardHeader)) {
			System.out.println("Located the expected dashboard header for stage and non-testharness");
		} else if (validate(dashboardHeader_harness)) {
			System.out.println("Located the header for testharness");
		} else {
			System.out.println("Not the usual dashboard header, not testharness header, last attempt to see if it's in shadow-root");
			//last try to see if it's shadowroot element
			cssPath="#sticky-main-nav > div > div > div > a[href*='health-and-wellness.html']";
			//tbd locateElementWithinShadowRoot(shadowRootHeader, "#main-nav > div > div > div > a[href*='health-and-wellness.html']");
			locateElementWithinShadowRoot(shadowRootHeader, cssPath);
		}
		return cssPath;
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
	
	public void locateElementWithinShadowRoot(WebElement shadowRootElement, String inputCssSelector) {
		if (validate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1=expandRootElement(shadowRootElement);
			try {
				WebElement element=root1.findElement(By.cssSelector(inputCssSelector));
				Assert.assertTrue("Dashboard header is not displayed", validate(element));
			} catch (Exception e) {
				System.out.println("can't locate element. Exception e="+e);
				Assert.assertTrue("Dashboard header not functioning as expected", false);
			}
		} else {
			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
			Assert.assertTrue("Dashboard header is not displayed", false);
		}
	}

	public void locateAndClickElementWithinShadowRoot(WebElement shadowRootElement, String inputCssSelector) {
		hwCheckModelPopup(driver);
		if (validate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1=expandRootElement(shadowRootElement);
			try {
				WebElement element=root1.findElement(By.cssSelector(inputCssSelector));
				Assert.assertTrue("Dashboard header is not displayed", validate(element));
				System.out.println("element is located, click it...");
				element.click();
				//tbd waitforElement(titleText);
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOf(titleText));
				hwCheckModelPopup(driver);
			} catch (Exception e) {
				System.out.println("can't locate element. Exception e="+e);
				Assert.assertTrue("Dashboard header not functioning as expected", false);
			}
		} else {
			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
			Assert.assertTrue("Dashboard header is not displayed", false);
		}
	}
	
	/**
	 * For iPerception Model
	 * @param driver
	 */
	/* tbd
	public static void XcheckForIPerceptionModel(WebDriver driver) {
		int counter = 0;
		do {
			System.out.println("current value of counter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	} */

	@FindBy(xpath="//div[contains(@class,'aside')]//a[contains(text(),'GET REWARDED')]")
	protected WebElement getRewardLink;
	
	public void validateNoGetReward() {
		Assert.assertTrue("PROBLEM - expect NOT to see Get Reward link for user", !validate(getRewardLink,0));
	}
	
	@FindBy(xpath="//span[contains(text(),'Gift Card Balance Available')]")
	protected WebElement giftCardBalanceText;
	
	@FindBy(xpath="//a[@class='backArrow']")
	protected WebElement backArrow;
	
	@FindBy(xpath="//a/img[contains(@class,'logo')]")
	protected WebElement rewardLogo;
	
	@FindBy(xpath="//button[contains(text(),'Yes! I accept')]")
	protected WebElement iAcceptButton;
	
	public void validateGetReward() {
			Assert.assertTrue("PROBLEM - expect to see Get Reward link for user", validate(getRewardLink,0));
			getRewardLink.click();
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(15);
			String expectedUrl="rewards/program-overview";
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking Get Reward link.  Expect to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", actualUrl.contains(expectedUrl));

			//note: click the "Yes! I accept..." button if it shows up in order to move on
			if (validate(iAcceptButton, 0)) {
				iAcceptButton.click();
				sleepBySec(15);
			}
			
			//else check this instead
			CommonUtility.waitForPageLoad(driver, giftCardBalanceText, 30);
			Assert.assertTrue("PROBLEM - expect to see 'Gift Card Balance Available' element for user", validate(giftCardBalanceText,0));
			sleepBySec(15);

			Assert.assertTrue("PROBLEM - expect to see the back arrow element for user", validate(rewardLogo,0));
			Assert.assertTrue("PROBLEM - expect to see the back arrow element for user", validate(backArrow,0));
			System.out.println("Tried #1");
			backArrow.click(); //TODO - this has problem, clicking it won't go back to prior page
			sleepBySec(15);
			CommonUtility.checkPageIsReady(driver);
			actualUrl=driver.getCurrentUrl();

			expectedUrl="member/health-and-wellness";
			int max=3;
			int count=1;
			while (count<=max) {
				actualUrl=driver.getCurrentUrl();
				System.out.println("TEST - actualUrl="+actualUrl);
				System.out.println("TEST - expectedUrl="+expectedUrl);
				if (actualUrl.contains(expectedUrl)) {
					break;
				}
				count=count+1;
				System.out.println("Tried #"+count);
				rewardLogo.click();
				CommonUtility.checkPageIsReady(driver);
				sleepBySec(15);
			}
			
			actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking back arrow from reward-overview page.  Expect to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", actualUrl.contains(expectedUrl));

	}
	
	@FindBy(xpath="//h1")
	protected WebElement generalHeader;

	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][1]//a[@data-linkdesc='Renew Active']//img")
	protected WebElement renewActiveIconImg;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][2]//h4")
	protected WebElement cardTitle;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][4]//a[text()='LEARN MORE']")
	protected WebElement learnMoreBtn;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//a[text()='FIND YOUR GYM']")
	protected WebElement findGymLnk;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//a[text()='TRAIN YOUR BRAIN']")
	protected WebElement brainHealthToolsLnk;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//div[contains(text(),'Your code')]//strong")
	protected WebElement yourCode;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//div[contains(text(),'Your code')]//a")
	protected WebElement tooltipIcon;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//div[contains(@class,'tooltip') and contains(@style,'display')]")
	protected WebElement tooltipText;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//div[contains(@class,'tooltip') and contains(@style,'display')]//a[@class='close-tooltip']")
	protected WebElement closeTooltipX;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//a[text()='Terms and Conditions']")
	protected WebElement termsAndConditions;

	public void validateNoRenewActive() {
		String targetElement="Renew Active icon image";
		Assert.assertTrue("PROBLEM - should not be able to locate '"+targetElement+"'", !validate(renewActiveIconImg,0));
		targetElement="Card Title";
		Assert.assertTrue("PROBLEM - should not be able to locate '"+targetElement+"'", !validate(cardTitle,0));
	}
	
	public void validateRenewActive() {
		String originalUrl=driver.getCurrentUrl();
		/* tbd 
			//note: that shoe icon ------------------
			String targetElement="Renew Active icon image";
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(renewActiveIconImg,0));
			String expectedHref="https://member.int.uhc.com/active/overview";
			renewActiveIconImg.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, generalHeader, 15);
			sleepBySec(10);
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.equals(expectedHref));
			Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, validate(generalHeader,0));
			goBackToPriorPgViaBack(originalUrl);

		//note: card title ------------------
		String targetElement="Card Title";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(cardTitle,0));
		String expectedText="Renew Active";
		String actualText=cardTitle.getText();
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", actualText.equals(expectedText));

 
		//note: Learn More button ------------------
		targetElement="Learn More buttone";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(learnMoreBtn,0));
		String expectedHref="https://member.int.uhc.com/active/overview";
		String actualEleLnkHref=learnMoreBtn.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.equals(expectedHref));
		renewActiveIconImg.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, generalHeader, 15);
		sleepBySec(10);
		String actualUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.equals(expectedHref));
		Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, validate(generalHeader,0));
		goBackToPriorPgViaBack(originalUrl);
		*/
		//note: Find A Gym ------------------
		String targetElement="Find Your Gym";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(findGymLnk,0));
		String expectedHref="https://member.int.uhc.com/active/fitness-location-search";
		String actualEleLnkHref=findGymLnk.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.equals(expectedHref));
		findGymLnk.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, generalHeader, 15);
		sleepBySec(10);
		String actualUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.equals(expectedHref));
		Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, validate(generalHeader,0));
		goBackToPriorPgViaBack(originalUrl);

		//note: Brain Health Tools ------------------
		targetElement="Brain Health Tools";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(brainHealthToolsLnk,0));
		expectedHref="https://member.int.uhc.com/active/train-your-brain";
		actualEleLnkHref=brainHealthToolsLnk.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.equals(expectedHref));
		brainHealthToolsLnk.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, generalHeader, 15);
		sleepBySec(10);
		actualUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.equals(expectedHref));
		Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, validate(generalHeader,0));
		goBackToPriorPgViaBack(originalUrl);

		//note: Confirmation Code ------------------
		targetElement="Your Code";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(yourCode,0));
		String actualText=yourCode.getText();
		System.out.println("TEST - yourCode="+actualText);
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected code not empty string | Actual='"+actualText+"'", !actualText.equals(""));
		
		
		//note: tooltip ------------------
		targetElement="tooltip icon";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(tooltipIcon,0));
		scrollElementToCenterScreen(tooltipIcon);
		moveMouseToElement(tooltipIcon);
		CommonUtility.waitForPageLoad(driver, tooltipText, 15);
		targetElement="tooltip text";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(tooltipText,0));
		actualText=tooltipText.getText();
		String expectedText="Use your unique Renew Active confirmation code to access your gym membership, ";
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected text to contain '"+expectedText+"' | Actual='"+actualText+"'", actualText.contains(expectedText));
		targetElement="close tooltip X";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(closeTooltipX,0));
		closeTooltipX.click();
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - should not be able to locate tooltip text anymore after closing", !validate(tooltipText,0));
		
		//note: Terms and Conditions ------------------
		targetElement="Terms and Conditions";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", validate(termsAndConditions,0));
		expectedHref="https://member.int.uhc.com/active/terms";
		actualEleLnkHref=termsAndConditions.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.equals(expectedHref));
		termsAndConditions.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, generalHeader, 15);
		sleepBySec(10);
		actualUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.equals(expectedHref));
		Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, validate(generalHeader,0));
		goBackToPriorPgViaBack(originalUrl);
	}

	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */
	}
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}
	
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println("slept for '"+sec+"' sec");
	}
	
	public void hwCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
	
	public void goBackToPriorPgViaBack(String origUrlBeforeClick) {
		driver.navigate().back();
		sleepBySec(15);
		CommonUtility.checkPageIsReady(driver);
		String expUrl=origUrlBeforeClick;
		String actUrl=driver.getCurrentUrl();
		if (!actUrl.contains(expUrl)) { //note: give it one more try before giving up
			driver.get(origUrlBeforeClick);
			sleepBySec(5);
			actUrl=driver.getCurrentUrl();
		}
		Assert.assertTrue("PROBLEM - unable to go back to Health and Wellness page. "
				+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		hwCheckModelPopup(driver);
		
		
	}
	

}
