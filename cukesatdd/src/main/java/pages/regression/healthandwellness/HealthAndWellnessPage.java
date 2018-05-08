/**
 * 
 */
package pages.regression.healthandwellness;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class HealthAndWellnessPage extends UhcDriver{


	@FindBy(linkText = "Health & Wellness")
	private WebElement rallyHealthAndWellness;

	@FindBy(xpath  = "//header[@class='hide-mobile']//a[contains(text(),'Health & Wellness')]")
	private WebElement healthAndWellness;

	@FindBy(id = "lifestyle_desk1")
	private WebElement lifestyleTab;

	@FindBy(id = "learning_desk1")
	private WebElement learningTab;

	@FindBy(xpath = ".//*[@id='hl-hw-buckets']/div/div[1]/a/img")
	private WebElement lifestyleIcon;

	@FindBy(xpath = ".//*[@id='hl-hw-buckets']/div/div[2]/a/img")
	private WebElement learningIcon;

	@FindBy(id = "hl-hw-banner-lifestyle")
	private WebElement hnwLifestyleBanner;

	@FindBy(id = "hl-hw-banner-learning")
	private WebElement hnwLearningBanner;

	@FindBy (xpath = "//header[@class='hide-mobile']//*[@id='main-nav']/div")
	private WebElement dashboardHeader;
	
	@FindBy (id = "rewards_desk")
	private WebElement rewadsTab;
	
	@FindBy (id = "renew-rewards-widget-target")
	private WebElement rewardsPage;
	

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
		if(healthAndWellness.isDisplayed()){
			healthAndWellness.click();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Validates Health and Wellness dashboard level 2 tabs
	 */
	public void validateHnWDashboardnL2Tabs(){
		Assert.assertTrue("Lifestyle icon is not displayed", lifestyleIcon.isDisplayed());
		Assert.assertTrue("Learning icon is not displayed", learningIcon.isDisplayed());
		Assert.assertTrue("Lifestyle tab is not displayed", lifestyleTab.isDisplayed());
		Assert.assertTrue("Learning tab is not displayed", learningTab.isDisplayed());
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
		Assert.assertTrue("Learning dashboard is not displayed", dashboardHeader.isDisplayed());
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