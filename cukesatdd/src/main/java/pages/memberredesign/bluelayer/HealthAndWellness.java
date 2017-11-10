package pages.memberredesign.bluelayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class HealthAndWellness  extends UhcDriver {
	
	@FindBy(linkText = "Health & Wellness")
	private WebElement rallyHealthAndWellness;
	
	@FindBy(id = "healthwellness")
	private WebElement healthAndWellness;
	
	@FindBy(id = "lifestyle")
	private WebElement lifestyleTab;
	
	@FindBy(id = "learning")
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
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		validate(rallyHealthAndWellness);
	}
	
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
	
	public void validateHnWDashboardnL2Tabs(){
		Assert.assertTrue("Lifestyle icon is not displayed", lifestyleIcon.isDisplayed());
		Assert.assertTrue("Learning icon is not displayed", learningIcon.isDisplayed());
		Assert.assertTrue("Lifestyle tab is not displayed", lifestyleTab.isDisplayed());
		Assert.assertTrue("Learning tab is not displayed", learningTab.isDisplayed());
	}
	
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
	
	public void validateLifestylePage(){
		Assert.assertTrue("Lifestyle dashboard is not displayed", hnwLifestyleBanner.isDisplayed());
	}
	
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
	
	public void validateLearningPage(){
		Assert.assertTrue("Learning dashboard is not displayed", hnwLearningBanner.isDisplayed());
	}

}
