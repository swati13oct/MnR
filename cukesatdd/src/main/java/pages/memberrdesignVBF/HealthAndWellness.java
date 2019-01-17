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

	@FindBy(id = "single-search-input")
	private WebElement hnwSearch;
	
	@FindBy(className = "hw-title__image")
	private WebElement hnwImage;
	
	@FindBy(className = "hw-hero__img")
	private WebElement hnwHeroImage;
	
	@FindBy(id = "quick-links")
	private WebElement quickLinksRenew;
	
	@FindBy(id = "featured-positivity-swiper")
	private WebElement featuredPositivityBlock;
	
	@FindBy(id = "online-courses-swiper")
	private WebElement onlineCoursesBlock;
	
	@FindBy(id = "health-content-swiper")
	private WebElement healthContentBlock;
	
	@FindBy(id = "health-videos-swiper")
	private WebElement healthVideoBlock;
	
	@FindBy(xpath = "//div[@id='health-videos-swiper']//div[@class='c-card__img']")
	private WebElement firstHealthVideo;
	
	
	public HealthAndWellness(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}
	
	

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, hnwSearch, 60);
		validateNew(hnwImage);
		validateNew(hnwHeroImage);
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
		if (lifestyleIcon.isDisplayed()) {
			lifestyleIcon.click();
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
		scrollToView(learningIcon);
		if (learningIcon.isDisplayed()) {
			learningIcon.click();
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
	
	public void validateHnWNewDashboard() {
		scrollToView(quickLinksRenew);
		Assert.assertTrue("quickLinksRenew is not displayed", quickLinksRenew.isDisplayed());
		scrollToView(featuredPositivityBlock);
		Assert.assertTrue("featuredPositivityBlock is not displayed", featuredPositivityBlock.isDisplayed());
		scrollToView(onlineCoursesBlock);
		Assert.assertTrue("onlineCoursesBlock is not displayed", onlineCoursesBlock.isDisplayed());
		scrollToView(healthContentBlock);
		Assert.assertTrue("healthContentBlock is not displayed", healthContentBlock.isDisplayed());
		scrollToView(healthVideoBlock);
		Assert.assertTrue("healthVideoBlock is not displayed", healthVideoBlock.isDisplayed());
		scrollToView(firstHealthVideo);
		Assert.assertTrue("firstHealthVideo is not displayed", firstHealthVideo.isDisplayed());
	}
}
