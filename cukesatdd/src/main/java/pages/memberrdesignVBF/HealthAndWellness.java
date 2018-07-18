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

	@FindBy(xpath = "//div[@class='hw-bucket-container']/div/a/img[contains(@alt,'Lifestyle')]")
	private WebElement lifestyleIcon;

	@FindBy(xpath = "//div[@class='hw-bucket-container']/div/a/img[contains(@alt,'Learning')]")
	private WebElement learningIcon;

	@FindBy(id = "hl-hw-banner-lifestyle")
	private WebElement hnwLifestyleBanner;

	@FindBy(id = "hl-hw-banner-learning")
	private WebElement hnwLearningBanner;
	
	@FindBy(id = "hl-hw-banner")
	private WebElement hnwBanner;
	
	@FindBy(className = "hl-hw-listContent")
	private WebElement hnwlistContent;
	
	@FindBy(id = "hw-featuredContent")
	private WebElement hnwFeaturedContent;
	
	@FindBy(id = "hw-learningCenter")
	private WebElement hnwLearningCenter;
	

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
	public void validateHnWDashboard() {
		scrollToView(hnwBanner);
		Assert.assertTrue("Health and Wellness main banner is not displayed", hnwBanner.isDisplayed());
		scrollToView(learningIcon);
		Assert.assertTrue("Learning icon is not displayed", learningIcon.isDisplayed());
		scrollToView(lifestyleIcon);
		Assert.assertTrue("lifestyleIcon icon is not displayed", lifestyleIcon.isDisplayed());
		scrollToView(hnwlistContent);
		Assert.assertTrue("hnwlistContent is not displayed", hnwlistContent.isDisplayed());
		scrollToView(hnwFeaturedContent);
		Assert.assertTrue("hnwFeaturedContent is not displayed", hnwFeaturedContent.isDisplayed());
		scrollToView(hnwLearningCenter);
		Assert.assertTrue("hnwLearningCenter is not displayed", hnwLearningCenter.isDisplayed());
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
