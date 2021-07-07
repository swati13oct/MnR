package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class GlobalWebElements extends UhcDriver {
	public GlobalWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {

	}

	@FindBy(id = "gf_lnk_1")
	public WebElement footerHomeLink;
	
	@FindBy(xpath = "//a[text()='Home']")
	public WebElement breadCrumbHomeLink;

	// @FindBy(id = "gf_lnk_2")
	@FindBy(xpath = "//*[@id='more-list-heading']//..//a[contains(@href,'about-us')]")
	public WebElement footerAboutUsLink;

	@FindBy(xpath = "//*[@id='more-list-heading']//..//a[contains(@href,'contact-us')]")
	public WebElement footerContactUsLink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'sitemap')]")
	public WebElement footerSiteMapLink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'privacy-policy')]")
	public WebElement footerPrivacyPolicyLink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'terms-of-use')]")
	public WebElement footerTermsnConditionsLink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'disclaimer')]")
	public WebElement footerDisclaimersLink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'insurance-brokers')]")
	public WebElement footerAgentsnBrokersLink;

	/** Request for assistance link **/
	@FindBy(id = "gf_lnk_10")
	public WebElement footerRequestforAssistancelink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'accessibility')]")
	public WebElement footerAccessibilitylink;

	@FindBys(value = { @FindBy(xpath = "//*[@id='more-list-heading']//..//a[contains(@href,'aarp.org')]") })
	public WebElement aarpOrgLink;

	@FindBys(value = { @FindBy(id = "footnotes1") })
	public WebElement footnotesContent;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']//..//a[contains(@href,'medicare-advantage-plans')]")
	public WebElement medicareAdvantagePlansLink;

	@FindBy(xpath = "//div[contains(text(),'Shop Plans')]")
	public WebElement shopPlansExpander;

	@FindBy(xpath = "//div[contains(text(),'Tools & Resources')]")
	public WebElement toolsAndResources;

	@FindBy(css = "#accordion-3-button")
	public WebElement learnAboutMedicareFooterButton;

	@FindBy(xpath = "//div[contains(text(),'More')]")
	public WebElement more;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']//..//a[contains(@href,'dual-special-needs-plans')]")
	public WebElement medicareSpecialNeedsPlansLink;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']//..//a[contains(@href,'medicare-supplement-plans')]")
	public WebElement medicareSupplementInsurancePlansLink;

	@FindBy(xpath = "//span[@class='meded-article-header__title' and contains(text(),'Medicare Supplement')]")
	public WebElement medicareSupplementInsurancePlansHeader;

	@FindBy(xpath = "//*[@id='shop-plans-list-heading']//..//a[contains(@href,'prescription-drug-plans')]")
	public WebElement medicarePrescriptionDrug_PlansLink;

	@FindBy(id = "gfn_lnk_row3_1")
	public WebElement learnAboutMedicareLink;

	@FindBy(id = "gfn_lnk_row3_2")
	public WebElement prepareForInitialEnrollment;

	@FindBy(id = "gfn_lnk_row3_3")
	public WebElement exploreChangingPlansLink;

	@FindBy(id = "gfn_lnk_row3_4")
	public WebElement discoverMoreResourcesLink;

	@FindBy(linkText = "Back to Top")
	public WebElement footerNavigationBackToTopLink;

	@FindBy(xpath = ".//*[contains(@class, 'viewdisclaimerstext')]")
	public WebElement viewAllDisclaimerInformationLink;

	// @FindBy(linkText = "Hide disclaimer information")
	@FindBy(xpath = ".//*[contains(@class, 'hidedisclaimerstext')]")
	public WebElement hideDiscliamerInformation;

	@FindBy(css = "a.backtotop1.hideLink")
	public WebElement disclaimerBackToTopLink;

	@FindBy(id = "proceed")
	public WebElement siteLeavingPopupProceddButton;

	@FindBy(id = "gf_lnk_6")
	public WebElement footerTermsAndConditionsLink;

	@FindBy(id = "gf_lnk_8")
	public WebElement footerAgentsAndBrokersLink;

	@FindBy(id = "gfn_lnk_row3_3")
	public WebElement prepareForInitialEnrollmentLink;

	@FindBy(id = "gfn_lnk_row2_5")
	public WebElement medicareSpecialNeedPlansLink;

	// @FindBy(xpath = "//h1[@class='logo']/a")
	@FindBy(id = "logo")
	public WebElement logoLink;

	@FindBy(xpath = "//ul[@class='menu-links']/li[2]/a")
	public WebElement importantDisclosuresLink;

	@FindBy(xpath = "//ul[@class='menu-links']/li[1]/a")
	public WebElement visitAARPLink;

	@FindBy(id = "proceed")
	public WebElement proceedLink;

	@FindBy(className = "menu-dropdown")
	public WebElement alreadyPlanMemberButtonInactive;

	@FindBy(xpath = "//div[@class='menu-dropdown active']")
	public WebElement alreadyPlanMemberButtonActive;

	@FindBy(id = "already-a-member-dropdown")
	public WebElement alreadyPlanMemberButton;

	@FindBy(className = "sign-in-text")
	public WebElement signInText;

	@FindBy(id = "top-user")
	public WebElement usernameField;

	@FindBy(id = "top-pass")
	public WebElement passwordField;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/a")
	public WebElement forgotUsernameLink;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	public WebElement registerHereLink;

	@FindBy(className = "not-registered-text")
	public WebElement notRegisteredText;

	@FindBy(id = "nav")
	public WebElement navigationSectionEnterSearch;

	@FindBy(id = "ghn_lnk_2")
	public WebElement navigationSectionOurPlansLink;

	@FindBy(id = "ghn_lnk_3")
	public WebElement navigationSectionMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3/a/span")
	public WebElement learnAboutMedicareMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div/div/h3[3]/a/span")
	public WebElement exploreChangingPlansMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3/a/span")
	public WebElement prepareForInitialEnrollmentMedicareEducationLink;

	@FindBy(xpath = "//div[@id='subnav_3']/div/div/div/div[2]/div/h3[2]/a/span")
	public WebElement discoverMoreResourcesMedicareEducationLink;

	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/span/p")
	public WebElement alreadyMemberInvalidCredsErrorMessage;

	@FindBy(xpath = "//div[@class='top-menu']/div/div[2]/div/form/button")
	public WebElement signInButton;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/p[2]/a")
	public WebElement prescriptiondrugPlansRequestMoreHelpLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[2]/div/p[2]/a[3]")
	public WebElement resumeYourSavedApplicationLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[2]/div/h3/a/span")
	public WebElement headerMedicareSupplementPlansLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[1]/div[1]/div[1]/p[2]/a")
	public WebElement medicareAdvantagePlansRequestMoreHelpLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div/div[2]/div/p[2]/a[2]/span")
	public WebElement medicareSelectHosipitalDirectoryLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/a")
	public WebElement takeQuizButton;

	@FindBy(id = "nav-zipcode")
	public WebElement zipcodeField;

	@FindBy(className = "zip-button")
	public WebElement findPlansButton;

	@FindBy(id = "ghn_lnk_2")
	public WebElement ourPlansHoverLink;

	@FindBy(id = "subnav_2")
	public WebElement ourPlansDropdownText;

	/** Request for assistance model window **/
	@FindBy(id = "cover")
	public WebElement RequestforAssistancepopup;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public WebElement proactiveChatExitBtn;

	@FindBy(xpath = "//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__button_type_chat')]")
	public WebElement proactiveChatChatBtn;

	@FindBy(xpath = "//*[@id='subnav_2']//*[contains(@href,'estimate')]")
	public WebElement headerDrugCostEstimatorLink;

	@FindBy(xpath = "(//a[contains(@dtmid, 'acq_top_nav') and contains(text(), 'Sign in')])[1]")
	public WebElement headerSignInLink;

	@FindBy(xpath = "(//a[contains(@href, 'healthsafe-id')])[1]")
	public WebElement headerRegisterLink;

	@FindBy(id = "aarpSVGLogo")
	public WebElement AARPlogo;

	@FindBy(xpath = "//*[contains(@id,'uhcSVGLogo')]")
	public WebElement UHCLogo;

	@FindBy(xpath = "//img[contains(@dtmid,'acq_visitor_profile')]")
	public WebElement visitorprofileicon;

	// @FindBy(xpath = "//*[contains(@onclick,'jumpToHSIDSignIn()')]")
	@FindBy(xpath = "//*[contains(@onclick,\"jumpToHSIDSignIn('body')\")]")
	public WebElement signIn;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[3]/a")
	public WebElement menuShop;

	@FindBy(xpath = "//*[@id='tools-resources-list-heading']//..//a[contains(@href,'plan-recommendation')]")
	public WebElement planRecommendationLink;

	@FindBy(xpath = "//*[@id='tools-resources-list-heading']//..//a[contains(@href,'estimate-drug-costs')]")
	public WebElement drugCostEstimatorLink;

	@FindBy(xpath = "//*[@id='tools-resources-list-heading']//..//a[contains(@href,'Pharmacy-Search-English')]")
	public WebElement pharmacySearchLink;

	@FindBy(xpath = "//*[@id='tools-resources-list-heading']//..//a[contains(@onclick,'loadCachedProviderSearch();')]")
	public WebElement providerSearchLink;

	// @FindBy(xpath =
	// "(//*[@id='learn-about-medicare-list-heading']//..//a[contains(@href,'medicare-education')])[1]")
	@FindBy(xpath = "//*[@id='accordion-3-content']//a[@href='/medicare-education.html']")
	public WebElement introductionToMedicareLink;

	// @FindBy(xpath =
	// "//*[@id='learn-about-medicare-list-heading']//..//a[contains(@href,'medicare-eligibility')]")
	@FindBy(xpath = "//*[@id='accordion-3-content']//a[contains(@href,'medicare-eligibility')]")
	public WebElement eligibilityLink;

	// @FindBy(xpath =
	// "//*[@id='learn-about-medicare-list-heading']//..//a[contains(@href,'medicare-parts-and-medigap-plans')]")
	@FindBy(xpath = "//*[@id='accordion-3-content']//a[contains(@href,'medicare-parts-and-medigap-plans')]")
	public WebElement coverageChoiceLink;

	// @FindBy(xpath =
	// "//*[@id='learn-about-medicare-list-heading']//..//a[contains(@href,'medicare-faq')]")
	@FindBy(xpath = "//*[@id='accordion-3-content']//a[contains(@href,'medicare-faq')]")
	public WebElement medicareFaqLink;

	// @FindBy(xpath =
	// "//*[@id='more-list-heading']//..//a[contains(@href,'about-us')]")
	@FindBy(xpath = "//*[@id='accordion-4-content']//a[contains(@href,'about-us')]")
	public WebElement aboutLink;

	// @FindBy(xpath =
	// "//*[@id='more-list-heading']//..//a[contains(@href,'contact-us')]")
	@FindBy(xpath = "//*[@id='accordion-4-content']//a[contains(@href,'contact-us')]")
	public WebElement contactLink;

	// @FindBy(xpath =
	// "//*[@id='more-list-heading']//..//a[contains(@href,'language-assistance')]")
	@FindBy(xpath = "//*[@id='accordion-4-content']//a[contains(@href,'language-assistance')]")
	public WebElement languageAssistanceLink;

	@FindBy(xpath = "//*[@id='accordion-4-content']//a[contains(@href,'aarp.org')]")
	public WebElement footerAARPLink;
	
	
//	@FindBy(xpath = "//b[contains(text(),'MENU')]")
	@FindBy(css = "div[aria-label='menu navigation']")
	public WebElement MenuMobile;
	
	@FindBy(css = "#mobile-nav")
	public WebElement mobileNav;
	
	@FindBy(css = "#ghn_lnk_2")
	public WebElement shopForAPlan;
	
	@FindBy(css = "#subnav_2 .nav-back")
	public WebElement shopForPlanBackButton;
	
	@FindBy(css = "#ghn_lnk_1")
	public WebElement home;
	
	@FindBy(css = "form[class*='zipCompForm-0'] button[class*='zip-button']")
	private WebElement getStartedButton;
	
	@FindBy(css = "#ghn_lnk_3")
	public WebElement learnAboutMedicareNavButton;
	
	@FindBy(css = "#subnav_3 .nav-back")
	private WebElement learnAboutMedicareBackButton;
	

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}

	public void accessFooterLinkFromShopPlans(String planType) {
		WebElement shopPlansTab = driver.findElement(By.cssSelector("#accordion-1-button"));
		boolean expanded = Boolean.parseBoolean(shopPlansTab.getAttribute("aria-expanded"));
		if (!expanded) {
			jsClickNew(shopPlansExpander);
		}

		planType = planType.toLowerCase();

		switch (planType) {
		case "ma":
		case "mapd":
			jsClickNew(medicareAdvantagePlansLink);
			break;
		case "snp":
		case "dsnp":
			jsClickNew(medicareSpecialNeedsPlansLink);
			break;
		case "medsupp":
			jsClickNew(medicareSupplementInsurancePlansLink);
			break;
		case "pdp":
			jsClickNew(medicarePrescriptionDrug_PlansLink);
			break;
		default:
			throw new IllegalArgumentException("Invalid link for plan type " + planType);
		}
		pageloadcomplete();
	}

	public void accessFooterLinkFromToolsResources(String tool) {
		WebElement shopPlansTab = driver.findElement(By.cssSelector("#accordion-2-button"));
		boolean expanded = Boolean.parseBoolean(shopPlansTab.getAttribute("aria-expanded"));
		if (!expanded) {
			jsClickNew(toolsAndResources);
		}

		tool = tool.toLowerCase();

		switch (tool) {
		case "pre":
			jsClickNew(planRecommendationLink);
			break;
		case "dce":
			jsClickNew(drugCostEstimatorLink);
			break;
		case "pharmacy search":
			jsClickNew(pharmacySearchLink);
			break;
		case "provider search":
			jsClickNew(providerSearchLink);
			break;
		default:
			throw new IllegalArgumentException("Invalid tool " + tool);
		}
		pageloadcomplete();
	}

	public void accessFooterLinkFromLearnAboutMedicare(String option) {
		WebElement shopPlansTab = driver.findElement(By.cssSelector("#accordion-3-button"));
		boolean expanded = Boolean.parseBoolean(shopPlansTab.getAttribute("aria-expanded"));
		if (!expanded) {
			jsClickNew(learnAboutMedicareFooterButton);
		}

		option = option.toLowerCase();

		switch (option) {
		case "introduction to medicare":
			jsClickNew(introductionToMedicareLink);
			break;
		case "eligibility":
			jsClickNew(eligibilityLink);
			break;
		case "coverage choices":
			jsClickNew(coverageChoiceLink);
			break;
		case "medicare faq":
			jsClickNew(medicareFaqLink);
			break;
		default:
			throw new IllegalArgumentException("Invalid Learn about Medicare option" + option);
		}
		pageloadcomplete();
	}

	public void accessFooterLinkFromMore(String option) {
		WebElement shopPlansTab = driver.findElement(By.cssSelector("#accordion-4-button"));
		boolean expanded = Boolean.parseBoolean(shopPlansTab.getAttribute("aria-expanded"));
		if (!expanded) {
			jsClickNew(more);
		}

		option = option.toLowerCase();

		switch (option) {
		case "about":
			jsClickNew(aboutLink);
			break;
		case "contact":
			jsClickNew(contactLink);
			break;
		case "language assistance":
			jsClickNew(languageAssistanceLink);
			break;
		case "aarp":
			jsClickNew(footerAARPLink);
			break;
		default:
			throw new IllegalArgumentException(option + " is not avaliable under More tab");
		}
		
		pageloadcomplete();
	}

	public AcquisitionHomePageMobile openHomeFromMenu() {
		jsClickNew(MenuMobile);
		
		validateNew(mobileNav, 5);
		
		jsClickNew(home);
		if(validate(getStartedButton)) {
			return new AcquisitionHomePageMobile(driver);
		} 
		return null;
	}
	
	public ShopForPlanNavigationPageMobile openShopForPlanFromMenu() {
		jsClickNew(MenuMobile);
		
		validateNew(mobileNav, 5);
		
		jsClickNew(shopForAPlan);
		if(validate(shopForPlanBackButton)) {
			return new ShopForPlanNavigationPageMobile(driver);
		} 
		return null;
	}
	
	public LearnAboutMedicareHomePageMobile openLearnAboutMedicareFromMenu() {
		jsClickNew(MenuMobile);
		
		validateNew(mobileNav, 5);
		
		jsClickNew(learnAboutMedicareNavButton);
		if(validate(learnAboutMedicareBackButton)) {
			return new LearnAboutMedicareHomePageMobile(driver);
		} 
		return null;
	}
	
}
