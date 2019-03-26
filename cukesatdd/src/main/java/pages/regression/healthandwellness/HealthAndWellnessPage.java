/**
 * 
 */
package pages.regression.healthandwellness;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath  = "//header[@class='hide-mobile']//a[contains(text(),'Health & Wellness')]")
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
	

	public HealthAndWellnessPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		validate(rallyHealthAndWellness);
	}

	/**
	 * clicks on Health n Wellness Tab
	 */
	public void clickHealthnWellnessTab(){
		try {
			if (MRScenario.environment.equalsIgnoreCase("team-a")) {
				Assert.assertTrue("KNOWN BEHAVIOR - The H&W page does not load on Team-A env due to non-availability of lower environment support from Talix (The third party vendor which actually hosts the page). Please validate on stage env", false);
			} 		
			healthAndWellness.isDisplayed();
			healthAndWellness.click();
			waitforElement(titleText);
		} catch (Exception e) {
				System.out.println("Unable to locate the xpath for healthAndWellness for stage and non-harness, try the one for stage and harness");
				healthAndWellness_harness.isDisplayed();
				healthAndWellness_harness.click();
				waitforElement(titleText);
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
		try {
			Thread.sleep(15000);
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
	}

	/**
	 * Clicks on Lifestyle tab
	 */
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
	}

	/**
	 * Validate Life style banner
	 */
	public void validateLifestylePage(){
		Assert.assertTrue("Lifestyle dashboard is not displayed", hnwLifestyleBanner.isDisplayed());
	}

	/**
	 * Clicks on health and wellness Learning tab
	 */
	public void clickLearningTab(){
		if(learningTab.isDisplayed()){
			learningTab.click();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * validate health and wellness Learning Page
	 */
	public void validateLearningPage(){
		Assert.assertTrue("Learning dashboard is not displayed", hnwLearningBanner.isDisplayed());
	}

	/**
	 * validate Header on the  dashborad page
	 */
	public void validateHeaderOnDashborad(){
		try {
			dashboardHeader.isDisplayed();
			System.out.println("Located the expected dashboard header for stage and non-harness");
		} catch (Exception e) {
			System.out.println("Unable to located the expected dashboard header for stage and non-harness, try the xpath for stage and hardness. "+e);
			Assert.assertTrue("Dashboard header is not displayed", dashboardHeader_harness.isDisplayed());
		}
		//Assert.assertTrue("Learning dashboard is not displayed", dashboardHeader.isDisplayed() || dashboardHeader_harness.isDisplayed());
		System.out.println("=========================>Header is Diaplyed on Dashboard page");
	}

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
		
	}

}
