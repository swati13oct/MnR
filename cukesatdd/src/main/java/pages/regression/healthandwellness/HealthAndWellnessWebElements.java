package pages.regression.healthandwellness;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class HealthAndWellnessWebElements extends UhcDriver{

	@FindBy(xpath = "//div[@class='hw-header']//span[contains(text(),'Health & Wellness')]")
	protected WebElement titleText;

	@FindBy(linkText = "Health & Wellness")
	protected WebElement rallyHealthAndWellness;

	@FindBy(xpath  = "//a[contains(text(),'Health & Wellness')]")
	protected WebElement healthAndWellness;

	@FindBy(id  = "healthwellness_4")
	protected WebElement healthAndWellness_harness;

	@FindBy(id = "lifestyle_desk1")
	protected WebElement lifestyleTab;

	@FindBy(id = "learning_desk1")
	protected WebElement learningTab;

	@FindBy(xpath = "//*[@id='root']/div/main/div[1]/div/header/div/div[1]/h1/span")
	protected WebElement lifestyleIcon;

	@FindBy(xpath = "//*[@id='quick-links']/div/div[4]/article/div/a")
	protected WebElement learningIcon;

	@FindBy(id = "hl-hw-banner-lifestyle")
	protected WebElement hnwLifestyleBanner;

	@FindBy(id = "hl-hw-banner-learning")
	protected WebElement hnwLearningBanner;

	@FindBy (xpath = "//header[@class='hide-mobile']//*[@id='sticky-nav']")
	protected WebElement dashboardHeader;
	@FindBy (className = "menuL1")
	protected WebElement dashboardHeader_harness;

	@FindBy (id = "rewards_desk")
	protected WebElement rewadsTab;

	@FindBy (id = "renew-rewards-widget-target")
	protected WebElement rewardsPage;

	@FindBy (partialLinkText = "REWARDED")
	protected WebElement rewardsLink;

	@FindBy (linkText = "LEARN MORE")
	protected WebElement learnmorelink;

	@FindBy(tagName="arcade-header")
	protected WebElement shadowRootHeader;


	@FindBy(xpath="//div[contains(@class,'aside')]//a[contains(text(),'GET REWARDED')]")
	protected WebElement getRewardLink;

	@FindBy(xpath="//h1")
	protected WebElement generalHeader;

	@FindBy(xpath="//div[contains(@class,'aside')]//a[contains(@data-linkdesc,'Renew Active')]//img")
	protected WebElement renewActiveIconImg_ship2;
	
	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][1]//a[contains(@data-linkdesc,'Renew Active')]//img")
	protected WebElement renewActiveIconImg_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][2]//h4")
	protected WebElement cardTitle_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//h4")
	protected WebElement cardTitle_ship2;

	@FindBy(xpath="//div[contains(@class,'aside')]//div[contains(@class,'o-box')][4]//a[text()='LEARN MORE']")
	protected WebElement learnMoreBtn_ship;

	@FindBy(xpath="//div[contains(@class,'aside')]//a[text()='LEARN MORE']")
	protected WebElement learnMoreBtn_ship2;

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
	
	@FindBy(xpath="//span[contains(text(),'Gift Card Balance Available')]")
	protected WebElement giftCardBalanceText;

	@FindBy(xpath="//a[@class='backArrow']")
	protected WebElement backArrow;

	@FindBy(xpath="//a/img[contains(@class,'logo')]")
	protected WebElement rewardLogo;

	@FindBy(xpath="//button[contains(text(),'Yes! I accept')]")
	protected WebElement iAcceptButton;

	@FindBy(xpath="//a[contains(text(),'Not Now')]")
	protected WebElement notNowLnk;

	public HealthAndWellnessWebElements(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//note: comment out for now, step creating this object may not be landing on the actual page yet
		//validate(rallyHealthAndWellness,120);
	}

}
