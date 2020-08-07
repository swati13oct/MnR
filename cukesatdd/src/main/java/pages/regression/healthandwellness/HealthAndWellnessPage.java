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


	@FindBy(xpath="//div[contains(@class,'aside')]//a[contains(text(),'GET REWARDED')]")
	protected WebElement getRewardLink;

	@FindBy(xpath="//h1")
	protected WebElement generalHeader;

	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][1]//a[contains(@data-linkdesc,'Renew Active')]//img")
	protected WebElement renewActiveIconImg_ship;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][2]//h4")
	protected WebElement cardTitle_ship;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][4]//a[text()='LEARN MORE']")
	protected WebElement learnMoreBtn_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][5]//a[text()='Find a gym']")
	protected WebElement findGymLnk_ship;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][6]//a[text()='Brain health tools']")
	protected WebElement brainHealthToolsLnk_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][7]//div[contains(text(),'Your code')]//strong")
	protected WebElement yourCode_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][7]//div[contains(text(),'Your code')]//a")
	protected WebElement tooltipIcon_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][7]//div[contains(@class,'tooltip') and contains(@style,'display')]")
	protected WebElement tooltipText_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][7]//div[contains(@class,'tooltip') and contains(@style,'display')]//a[@class='close-tooltip']")
	protected WebElement closeTooltipX_ship;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][8]//a[contains(@href,'term')]")
	protected WebElement termsAndConditions_ship;

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
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')]//a[contains(@href,'term')]")
	protected WebElement termsAndConditions;

	boolean testThirdPartyPage=false; //note: consent is to not test 3rd party page, but capable if needs to


	
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
		//note: if none is provided, assume the page has all top menu options and the last one is HW
		//String defaultCssPath="#main-nav > div > div > div > a[href*='health-and-wellness.html']";
		int defaultIndex=7;
		clickHealthnWellnessTab(defaultIndex);
	}
	
	public void clickHealthnWellnessTab(int index){
		   if (MRScenario.environment.contains("team-a")) {
	            Assert.assertTrue("KNOWN BEHAVIOR - The H&W page does not load on Team-A env due to non-availability of lower environment support from Talix (The third party vendor which actually hosts the page). Please validate on stage env", false);
	        }     
	        if (hwValidate(healthAndWellness)) {
	            healthAndWellness.click();
	            waitforElementNew(titleText,60);//note: sometimes it takes a long time to load H&W page

	 

	        } else if  (hwValidate(healthAndWellness_harness)) {
	            System.out.println("Unable to locate Rally HW button but able to locate testharness HW button");
	            System.out.println("Unable to locate the xpath for healthAndWellness for stage and non-harness, try the one for stage and harness");
	            Assert.assertTrue("PROBLEM - unable to locate H&W tab", hwValidate(healthAndWellness_harness));
	            //tbd healthAndWellness_harness.isDisplayed();
	            healthAndWellness_harness.click();
	            waitforElement(titleText);
	        } else {
	            //String defaultCssPath="#main-nav > div > div > div > a[href*='health-and-wellness.html']";
	            System.out.println("Unable to locate Rally or testharness HW button, last attemp for shadow-root");
	            String targetCssPath="notFound";
	            for(int i=index; i>=1; i--) {
	                String cssPath="#sticky-main-nav > div > div > div > a:nth-child("+i+")";
	                System.out.println("TEST - check cssPath="+cssPath);
	                targetCssPath=locateElementWithinShadowRoot(shadowRootHeader,cssPath);
	                if (!targetCssPath.equals("notFound")) {
	                    break;
	                }
	            }
	            System.out.println("Will use cssPath='"+targetCssPath+"'");
	            //String cssPath="#sticky-main-nav > div > div > div > a:nth-child("+index+")";
	            locateAndClickElementWithinShadowRoot(shadowRootHeader,targetCssPath);
	        }

	 

	        hwCheckModelPopup(driver);
	}

	/**
	 * Validates Health and Wellness page
	 */
	public void validateHnWDashboardnL2Tabs(){
		Assert.assertTrue("PROBLEM - Lifestyle icon is not displayed", hwValidate(lifestyleIcon));
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
			if (hwValidate(rewardsLink) || hwValidate(learnmorelink)) {
				Assert.assertTrue("PROBLEM - unable to locate either one of the expected elements on page. rewardCheck="+hwValidate(rewardsLink)+" | learnmoreCheck="+validate(learnmorelink), true);
				break;
			} else {
				sleepBySec(5);
				x=x+1;
				System.out.println("waited "+(5000*x)+" seconds for expected links to show");
			}
		}
		//one last attempt
		Assert.assertTrue("PROBLEM - unable to locate either one of the expected elements on page. rewardCheck="+hwValidate(rewardsLink)+" | learnmoreCheck="+hwValidate(learnmorelink), true);
	}


	/**
	 * validate Header on the  dashborad page
	 */
	public int validateHeaderOnDashborad(){
		int result=-1;
		if (hwValidate(dashboardHeader)) {
			System.out.println("Located the expected dashboard header for stage and non-testharness");
			result=1;
		} else if (hwValidate(dashboardHeader_harness)) {
			System.out.println("Located the header for testharness");
			result=2;
		} else {
			System.out.println("Not the usual dashboard header, not testharness header, last attempt to see if it's in shadow-root");
			//last try to see if it's shadowroot element
			//cssPath="#sticky-main-nav > div > div > div > a[href*='health-and-wellness.html']";
			for (int i=1; i<=7; i++) {
				String cssPath="#sticky-main-nav > div > div > div > a:nth-child("+i+")";
				if (!locateElementWithinShadowRoot(shadowRootHeader, cssPath).equals("notFound")) {
					return i;
				}
			}
		}
		return result;
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
	
	public String locateElementWithinShadowRoot(WebElement shadowRootElement, String inputCssSelector) {
		String result="notFound";
		if (hwValidate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1=expandRootElement(shadowRootElement);
			try {
				WebElement element=root1.findElement(By.cssSelector(inputCssSelector));
				Assert.assertTrue("Dashboard header is not displayed", hwValidate(element));
				if (hwValidate(element)) 
					return inputCssSelector;
				else
					return result;
			} catch (Exception e) {
				System.out.println("can't locate element. Exception e="+e);
				//Assert.assertTrue("Dashboard header not functioning as expected", false);
				return result;
			}
		} else {
			System.out.println("no shadow-root element either, not sure what's going on w/ the header on rally");
			//Assert.assertTrue("Dashboard header is not displayed", false);
			return result;
		}
	}
	
	public void locateAndClickElementWithinShadowRoot(WebElement shadowRootElement, String inputCssSelector) {
		CommonUtility.waitForPageLoad(driver, shadowRootElement, 5);;
		hwCheckModelPopup(driver);
		if (hwValidate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1=expandRootElement(shadowRootElement);
			try {
				WebElement element=root1.findElement(By.cssSelector(inputCssSelector));
				Assert.assertTrue("Dashboard header is not displayed", hwValidate(element));
				System.out.println("element is located, click it...");
				element.click();
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
	
	public void validateNoGetReward() {
		Assert.assertTrue("PROBLEM - expect NOT to see Get Reward link for user", !hwValidate(getRewardLink));
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
		Assert.assertTrue("PROBLEM - expect to see Get Reward link for user", hwValidate(getRewardLink));
		String expectedUrl="uhc.com/rewards";
		String actUrlLink=getRewardLink.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate expected href link from element.  Expect to contain '"+expectedUrl+"' | Actual='"+actUrlLink+"'",actUrlLink.contains(expectedUrl));
		if (testThirdPartyPage) {
			getRewardLink.click();
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(15);
			String actualUrl=driver.getCurrentUrl();
			if (!actualUrl.contains(expectedUrl)) { //note: in case sometimes page takes longer to run
				sleepBySec(15);
				actualUrl=driver.getCurrentUrl();
			}
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking Get Reward link.  Expect to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", actualUrl.contains(expectedUrl));

			//note: click the "Yes! I accept..." button if it shows up in order to move on
			if (hwValidate(iAcceptButton, 0)) {
				iAcceptButton.click();
				sleepBySec(15);
			}

			//else check this instead
			CommonUtility.waitForPageLoad(driver, giftCardBalanceText, 30);
			Assert.assertTrue("PROBLEM - expect to see 'Gift Card Balance Available' element for user", hwValidate(giftCardBalanceText));
			sleepBySec(15);

			Assert.assertTrue("PROBLEM - expect to see the back arrow element for user", hwValidate(rewardLogo));
			Assert.assertTrue("PROBLEM - expect to see the back arrow element for user", hwValidate(backArrow));
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
	}
	
	public void validateNoRenewActive(String planType) {
		String targetElement="Find Your Gym";
		WebElement gymElement=findGymLnk;
		if (planType.equalsIgnoreCase("SHIP")) {
			targetElement="Find a Gym";
			gymElement=findGymLnk_ship;
		}
		Assert.assertTrue("PROBLEM - should not be able to locate '"+targetElement+"'", !hwValidate(gymElement));

		targetElement="Brain Health Tools";
		WebElement brainElement=brainHealthToolsLnk;
		if (planType.equalsIgnoreCase("SHIP")) 
			brainElement=brainHealthToolsLnk_ship;
		Assert.assertTrue("PROBLEM - should not be able to locate '"+targetElement+"'", !hwValidate(brainElement));
	}
	
	public void validateRenewActive(String planType) {
		checkModelPopup(driver,3);
		String originalUrl=driver.getCurrentUrl();
		if (planType.toUpperCase().contains("SHIP") && !planType.toUpperCase().contains("COMBO")) { 
			//note: that shoe icon ------------------
			String targetElement="Renew Active icon image";
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(renewActiveIconImg_ship));
			String expectedHref="/active/overview";
			//String expectedHref="https://member.int.uhc.com/active/overview";
			if (testThirdPartyPage) {
				renewActiveIconImg_ship.click();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForPageLoad(driver, generalHeader, 15);
				sleepBySec(10);
				String actualUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
				Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
				goBackToPriorPgViaBack(originalUrl);
			}

			//note: card title ------------------
			targetElement="Card Title";
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(cardTitle_ship));
			String expectedText="Renew Active";
			String actualText=cardTitle_ship.getText();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", actualText.contains(expectedText));


			//note: Learn More button ------------------
			targetElement="Learn More buttone";
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(learnMoreBtn_ship));
			//expectedHref="https://member.int.uhc.com/active/overview";
			expectedHref="/active/overview";
			String actualEleLnkHref=learnMoreBtn_ship.getAttribute("href");
			Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.contains(expectedHref));
			if (testThirdPartyPage) {
				renewActiveIconImg_ship.click();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForPageLoad(driver, generalHeader, 15);
				sleepBySec(10);
				String actualUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
				Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
				goBackToPriorPgViaBack(originalUrl);
			}
		}
		//note: temperary disable this validation due to COVID related update
		/*
		//note: Find A Gym ------------------
		String targetElement="Find Your Gym";
		WebElement gymElement=findGymLnk;
		if (planType.toUpperCase().contains("SHIP")) {
			targetElement="Find a Gym";
			gymElement=findGymLnk_ship;
		}
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(gymElement));
		String expectedHref="/active/fitness-location-search";
		//String expectedHref="https://member.int.uhc.com/active/fitness-location-search";
		String actualEleLnkHref=gymElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.contains(expectedHref));
		if (testThirdPartyPage) {
			gymElement.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, generalHeader, 15);
			sleepBySec(10);
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
			Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
			goBackToPriorPgViaBack(originalUrl);
		}

		//note: Brain Health Tools ------------------
		targetElement="Brain Health Tools";
		WebElement brainElement=brainHealthToolsLnk;
		if (planType.toUpperCase().contains("SHIP")) 
			brainElement=brainHealthToolsLnk_ship;
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(brainElement));
		//expectedHref="https://member.int.uhc.com/active/train-your-brain";
		expectedHref="/active/train-your-brain";
		actualEleLnkHref=brainElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.contains(expectedHref));
		if (testThirdPartyPage) {
			brainElement.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, generalHeader, 15);
			sleepBySec(10);
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
			Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
			goBackToPriorPgViaBack(originalUrl);
		} 
		*/

		//note: Confirmation Code ------------------
		String targetElement="Your Code";
		WebElement codeElement=yourCode;
		//note: temperary disable the following if condition until gym and brain test is displaying again
		//keep if (planType.toUpperCase().contains("SHIP")) 
		//keep 	codeElement=yourCode_ship;
		CommonUtility.waitForPageLoad(driver, codeElement, 10);
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(codeElement));
		String actualText=codeElement.getText();
		System.out.println("TEST - yourCode="+actualText);
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected code not empty string | Actual='"+actualText+"'", !actualText.equals(""));

		//note: tooltip ------------------
		targetElement="tooltip icon";
		WebElement tooltipIconElement=tooltipIcon;
		WebElement tooltipTextElement=tooltipText;
		WebElement closeTooltipXElement=closeTooltipX;
		//note: temperary disable the following if condition until gym and brain test is displaying again
		//keep if (planType.toUpperCase().contains("SHIP")) {
		//keep 	tooltipIconElement=tooltipIcon_ship;
		//keep 	tooltipTextElement=tooltipText_ship;
		//keep 	closeTooltipXElement=closeTooltipX_ship;
		//keep }
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(tooltipIconElement));
		scrollElementToCenterScreen(tooltipIconElement);
		moveMouseToElement(tooltipIconElement);
		CommonUtility.waitForPageLoad(driver, tooltipTextElement, 15);
		targetElement="tooltip text";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(tooltipTextElement));
		actualText=tooltipTextElement.getText();
		String expectedText="Use your unique Renew Active confirmation code to access your gym membership, ";
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected text to contain '"+expectedText+"' | Actual='"+actualText+"'", actualText.contains(expectedText));
		targetElement="close tooltip X";
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(closeTooltipXElement));
		closeTooltipXElement.click();
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - should not be able to locate tooltip text anymore after closing", !hwValidate(tooltipTextElement));

		//note: Terms and Conditions ------------------
		targetElement="Terms and Conditions";
		WebElement termsAndConditionsElement=termsAndConditions;
		//note: temperary disable the following if condition until gym and brain test is displaying again
		//keep if (planType.toUpperCase().contains("SHIP")) {	
		//keep 	termsAndConditionsElement=termsAndConditions_ship;
		//keep }
		Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(termsAndConditionsElement));
		String expectedHref="active/terms";
		String actualEleLnkHref=termsAndConditionsElement.getAttribute("href");
		Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.contains(expectedHref));
		if (testThirdPartyPage) {
			termsAndConditionsElement.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, generalHeader, 15);
			sleepBySec(10);
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
			Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
			goBackToPriorPgViaBack(originalUrl);
		}
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

	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean hwValidate(WebElement element) {
		long timeoutInSec=0;
		return hwValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean hwValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	}
	

}
