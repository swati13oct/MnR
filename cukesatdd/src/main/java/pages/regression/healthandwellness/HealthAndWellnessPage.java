package pages.regression.healthandwellness;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class HealthAndWellnessPage extends HealthAndWellnessBase {

	boolean testThirdPartyPage=true; //note: consent is to not test 3rd party page, but capable if needs to

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
		hwCheckModelPopup(driver);
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

	public void validateGetReward() {
		Assert.assertTrue("PROBLEM - expect to see Get Reward link for user", hwValidate(getRewardLink));
		String expectedUrl="uhc.com/rewards";
		String actUrlLink=getRewardLink.getAttribute("href");
		Assert.assertTrue("PROBLEM - unable to locate expected href link from element.  Expect to contain '"+expectedUrl+"' | Actual='"+actUrlLink+"'",actUrlLink.contains(expectedUrl));
		if (testThirdPartyPage && MRScenario.environment.equalsIgnoreCase("prod")) {
			getRewardLink.click();
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(15);
			String actualUrl=driver.getCurrentUrl();
			expectedUrl="rewards/program-overview";
			if (!actualUrl.contains(expectedUrl)) { //note: in case sometimes page takes longer to run
				sleepBySec(15);
				actualUrl=driver.getCurrentUrl();
			}
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking Get Reward link.  Expect to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", actualUrl.contains(expectedUrl));

			if (hwValidate(notNowLnk,0)) {
				checkModelPopup(driver,1);
				notNowLnk.click();
				sleepBySec(15);
			}

			/* this can be done on stage only, don't accept for prod user
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
			 */
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
				if (hwValidate(notNowLnk))
					notNowLnk.click();
				if (hwValidate(backArrow))
					backArrow.click();
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
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(renewActiveIconImg_ship) || hwValidate(renewActiveIconImg_ship2));
			WebElement renewActiveIconImgElement=null;
			if (hwValidate(renewActiveIconImg_ship))
				renewActiveIconImgElement=renewActiveIconImg_ship;
			else
				renewActiveIconImgElement=renewActiveIconImg_ship2;
			String expectedHref="/active/overview";
			String expectedDomain=getExpectedDomain();
			String expectedEnv=getExpectedEnv();
			if (testThirdPartyPage && MRScenario.environment.equalsIgnoreCase("prod")) {
				renewActiveIconImgElement.click();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForPageLoad(driver, generalHeader, 15);
				sleepBySec(10);
				String actualUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
				Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL domain is not as expected. Expected='"+expectedDomain+"' for env='"+expectedEnv+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
				Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
				goBackToPriorPgViaBack(originalUrl);
			}

			//note: card title ------------------
			targetElement="Card Title";
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(cardTitle_ship) || hwValidate(cardTitle_ship2));
			WebElement cardTitleElement=null;
			if (hwValidate(cardTitle_ship)) {
				cardTitleElement=cardTitle_ship;
			} else {
				cardTitleElement=cardTitle_ship2;
			}
			
			String expectedText="Renew Active";
			String actualText=cardTitleElement.getText();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' element text is not as expected. Expected='"+expectedText+"' | Actual='"+actualText+"'", actualText.contains(expectedText));


			//note: Learn More button ------------------
			targetElement="Learn More buttone";
			Assert.assertTrue("PROBLEM - unable to locate '"+targetElement+"'", hwValidate(learnMoreBtn_ship)|| hwValidate(learnMoreBtn_ship2));
			WebElement learnMoreBtnElement=null;
			if (hwValidate(learnMoreBtn_ship)) 
				learnMoreBtnElement=learnMoreBtn_ship;
			else
				learnMoreBtnElement=learnMoreBtn_ship2;
			//expectedHref="https://member.int.uhc.com/active/overview";
			expectedHref="/active/overview";
			String actualEleLnkHref=learnMoreBtnElement.getAttribute("href");
			expectedDomain=getExpectedDomain();
			expectedEnv=getExpectedEnv();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' element href attribute value is not as expected. Expected='"+expectedHref+"' | Actual='"+actualEleLnkHref+"'", actualEleLnkHref.contains(expectedHref));
			if (testThirdPartyPage && MRScenario.environment.equalsIgnoreCase("prod")) {
				renewActiveIconImgElement.click();
				CommonUtility.checkPageIsReady(driver);
				CommonUtility.waitForPageLoad(driver, generalHeader, 15);
				sleepBySec(10);
				String actualUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
				Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL domain is not as expected. Expected='"+expectedDomain+"' for env='"+expectedEnv+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
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
		if (testThirdPartyPage && MRScenario.environment.equalsIgnoreCase("prod")) {
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
		if (testThirdPartyPage && MRScenario.environment.equalsIgnoreCase("prod")) {
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
		String expectedDomain=getExpectedDomain();
		String expectedEnv=getExpectedEnv();
		//note: on offline-line env, this link will land on error b/c of the env config
		//note: on online-stage env, this link sometimes will run in loop/redirecting non stop, already notified Talix contact but it worked fine on their side
		if (testThirdPartyPage && MRScenario.environment.equalsIgnoreCase("prod")) {
			termsAndConditionsElement.click();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, generalHeader, 15);
			sleepBySec(10);
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL is not as expected. Expected='"+expectedHref+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
			Assert.assertTrue("PROBLEM - '"+targetElement+"' landing page URL domain is not as expected. Expected='"+expectedDomain+"' for env='"+expectedEnv+"' | Actual='"+actualUrl+"'", actualUrl.contains(expectedHref));
			Assert.assertTrue("PROBLEM - unable to locate general header on landing page URL for link from "+targetElement, hwValidate(generalHeader));
			goBackToPriorPgViaBack(originalUrl);
		}
	}
}
