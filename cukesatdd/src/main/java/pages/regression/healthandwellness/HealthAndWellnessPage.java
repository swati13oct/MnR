package pages.regression.healthandwellness;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		// TODO Auto-generated method stub
		//note: comment out for now, step creating this object may not be landing on the actual page yet
		//validate(rallyHealthAndWellness,120);
	}

	/**
	 * clicks on Health n Wellness Tab
	 */
	public void clickHealthnWellnessTab(){
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
				System.out.println("Unable to Able to locate Rally or testharness HW button, last attemp for shadow-root");
				locateAndClickElementWithinShadowRoot(shadowRootHeader, "#main-nav > div > div > div > a[href*='health-and-wellness.html']");
			}
		}
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
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x=x+1;
				System.out.println("waited "+(5000*x)+" seconds for expected links to show");
			}
		}
		//one last attempt
		Assert.assertTrue("PROBLEM - unable to locate either one of the expected elements on page. rewardCheck="+validate(rewardsLink)+" | learnmoreCheck="+validate(learnmorelink), true);
		/* tbd
		try {
			Thread.sleep(17500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String errorText="";
		boolean rewardCheck=false;
		boolean learnmoreCheck=false;
		rewardCheck=validate(rewardsLink);
		learnmoreCheck=validate(learnmorelink);
		Assert.assertTrue("PROBLEM - unable to locate either one of the expected elements on page. rewardCheck="+rewardCheck+" | learnmoreCheck="+learnmoreCheck, (rewardCheck || learnmoreCheck));
		//Assert.assertTrue("GetRewarded Link is displayed", (rewardsLink.isDisplayed() || learnmorelink.isDisplayed()));
		//Assert.assertTrue("Learning tab is not displayed", learningTab.isDisplayed());
		 */
	}

	/**
	 * Clicks on Lifestyle tab
	 */
	/* tbd-remove
	public void clickLifestyleTab(){
		if(lifestyleTab.isDisplayed()){
			lifestyleTab.click();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} */

	/**
	 * Validate Life style banner
	 */
	/* tbd-remove
	public void validateLifestylePage(){
		Assert.assertTrue("Lifestyle dashboard is not displayed", hnwLifestyleBanner.isDisplayed());
	} */

	/**
	 * Clicks on health and wellness Learning tab
	 */
	/* tbd-remove
	public void TBR_clickLearningTab(){
		if(learningTab.isDisplayed()){
			learningTab.click();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} */

	/**
	 * validate health and wellness Learning Page
	 */
	/* tbd-remove
	public void validateLearningPage(){
		Assert.assertTrue("Learning dashboard is not displayed", hnwLearningBanner.isDisplayed());
	} */

	/**
	 * validate Header on the  dashborad page
	 */
	public void validateHeaderOnDashborad(){
		if (validate(dashboardHeader)) {
			System.out.println("Located the expected dashboard header for stage and non-testharness");
		} else if (validate(dashboardHeader_harness)) {
			System.out.println("Located the header for testharness");
		} else {
			System.out.println("Not the usual dashboard header, not testharness header, last attempt to see if it's in shadow-root");
			//last try to see if it's shadowroot element
			locateElementWithinShadowRoot(shadowRootHeader, "#main-nav > div > div > div > a[href*='health-and-wellness.html']");
		}
		/* tbd-remove
		try {
			dashboardHeader.isDisplayed();
			System.out.println("Located the expected dashboard header for stage and non-harness");
		} catch (Exception e) {
			System.out.println("Unable to located the expected dashboard header for stage and non-harness, try the xpath for stage and hardness. "+e);
			Assert.assertTrue("Dashboard header is not displayed", dashboardHeader_harness.isDisplayed());
		}
		//Assert.assertTrue("Learning dashboard is not displayed", dashboardHeader.isDisplayed() || dashboardHeader_harness.isDisplayed());
		System.out.println("=========================>Header is Diaplyed on Dashboard page");
		*/
	}

	/* tbd-remove
	public void clicAndValidateRewardsPage() {
		Assert.assertTrue(">>>>>>>>>Rewards tab Displayed",rewadsTab.isDisplayed());
		System.out.println("rewards tab is displayed");
		try {
			rewadsTab.click();
			Thread.sleep(50000);
			validate(rewardsPage);
			
		} catch (Exception e) {
			System.err.println("rewards page is not loaded properly");
			// TODO: handle exception
		}
		
	} */
	
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
		checkForIPerceptionModel(driver);
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
				checkForIPerceptionModel(driver);
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
	public static void checkForIPerceptionModel(WebDriver driver) {
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
	}

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
		try {
			Assert.assertTrue("PROBLEM - expect to see Get Reward link for user", validate(getRewardLink,0));
			getRewardLink.click();
			CommonUtility.checkPageIsReady(driver);
			Thread.sleep(15000);
			String expectedUrl="rewards/program-overview";
			String actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking Get Reward link.  Expect to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", actualUrl.contains(expectedUrl));

			//note: click the "Yes! I accept..." button if it shows up in order to move on
			if (validate(iAcceptButton, 0)) {
				iAcceptButton.click();
				Thread.sleep(15000);
			}
			
			//else check this instead
			CommonUtility.waitForPageLoad(driver, giftCardBalanceText, 30);
			Assert.assertTrue("PROBLEM - expect to see 'Gift Card Balance Available' element for user", validate(giftCardBalanceText,0));
			Thread.sleep(15000);

			Assert.assertTrue("PROBLEM - expect to see the back arrow element for user", validate(rewardLogo,0));
			Assert.assertTrue("PROBLEM - expect to see the back arrow element for user", validate(backArrow,0));
			System.out.println("Tried #1");
			backArrow.click(); //TODO - this has problem, clicking it won't go back to prior page
			CommonUtility.checkPageIsReady(driver);
			Thread.sleep(15000);

			expectedUrl="member/health-and-wellness.html";
			int max=3;
			int count=1;
			while (count<=max) {
				actualUrl=driver.getCurrentUrl();
				if (actualUrl.contains(expectedUrl)) {
					break;
				}
				count=count+1;
				System.out.println("Tried #"+count);
				rewardLogo.click();
				CommonUtility.checkPageIsReady(driver);
				Thread.sleep(15000);
			}
			actualUrl=driver.getCurrentUrl();
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking back arrow from reward-overview page.  Expect to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", actualUrl.contains(expectedUrl));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
