package pages.member.bluelayer;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.RallyDashboardPage;

public class HealthAndWellness  extends UhcDriver {
	
	@FindBy(partialLinkText = "Health & Wellness")
	private WebElement rallyHealthAndWellness;
	
	@FindBy(id = "healthwellness")
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
	
	public HealthAndWellness(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		CommonUtility.waitForPageLoad(driver, lifestyleIcon, 50);
		validate(lifestyleIcon);
		validate(learningIcon);
	}
	
/*	public void clickHealthnWellnessTab(){
		if(healthAndWellness.isDisplayed()){
			healthAndWellness.click();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	public void validateHnWDashboardnL2Tabs(){
		/*JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");*/
		scrollToView(lifestyleIcon);
		Assert.assertTrue("Lifestyle icon is not displayed", lifestyleIcon.isDisplayed());
		scrollToView(learningIcon);
		Assert.assertTrue("Learning icon is not displayed", learningIcon.isDisplayed());
		scrollToView(lifestyleTab);
		Assert.assertTrue("Lifestyle tab is not displayed", lifestyleTab.isDisplayed());
		scrollToView(learningTab);
		Assert.assertTrue("Learning tab is not displayed", learningTab.isDisplayed());
	}
	
	public void clickLifestyleTab(){
		if(lifestyleTab.isDisplayed()){
			lifestyleTab.click();
			CommonUtility.checkPageIsReady(driver);
			/*try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	public void validateLifestylePage(){
		CommonUtility.waitForPageLoad(driver, hnwLifestyleBanner, 60);
		Assert.assertTrue("Lifestyle dashboard is not displayed", hnwLifestyleBanner.isDisplayed());
	}
	
	public void clickLearningTab(){
		scrollToView(learningTab);
		if(learningTab.isDisplayed()){
			learningTab.click();
			CommonUtility.checkPageIsReady(driver);
			/*try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
	}
	
	public void validateLearningPage(){
		CommonUtility.waitForPageLoad(driver, hnwLearningBanner, 60);
		Assert.assertTrue("Learning dashboard is not displayed", hnwLearningBanner.isDisplayed());
	}

}
