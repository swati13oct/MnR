package pages.memberrdesignVBF;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class HealthAndWellness extends UhcDriver {

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

	public HealthAndWellness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, lifestyleIcon, 50);
		validateNew(lifestyleIcon);
		validateNew(learningIcon);
	}

	/***
	 * 
	 */
	public void validateHnWDashboardnL2Tabs() {
		scrollToView(lifestyleIcon);
		Assert.assertTrue("Lifestyle icon is not displayed", lifestyleIcon.isDisplayed());
		scrollToView(learningIcon);
		Assert.assertTrue("Learning icon is not displayed", learningIcon.isDisplayed());
		scrollToView(lifestyleTab);
		Assert.assertTrue("Lifestyle tab is not displayed", lifestyleTab.isDisplayed());
		scrollToView(learningTab);
		Assert.assertTrue("Learning tab is not displayed", learningTab.isDisplayed());
	}

	/***
	 * 
	 */
	public void clickLifestyleTab() {
		if (lifestyleTab.isDisplayed()) {
			lifestyleTab.click();
			CommonUtility.checkPageIsReadyNew(driver);
		}
	}

	/***
	 * 	
	 */
	public void validateLifestylePage() {
		CommonUtility.waitForPageLoadNew(driver, hnwLifestyleBanner, 60);
		Assert.assertTrue("Lifestyle dashboard is not displayed", hnwLifestyleBanner.isDisplayed());
	}

	/***
	 * 
	 */
	public void clickLearningTab() {
		scrollToView(learningTab);
		if (learningTab.isDisplayed()) {
			learningTab.click();
			CommonUtility.checkPageIsReadyNew(driver);
		}
	}

	/***
	 * 
	 */
	public void validateLearningPage() {
		CommonUtility.waitForPageLoadNew(driver, hnwLearningBanner, 60);
		Assert.assertTrue("Learning dashboard is not displayed", hnwLearningBanner.isDisplayed());
	}

}
