package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants.PLANTYPE;
import acceptancetests.data.CommonConstants.TOOLS;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class GlobalWebElements extends UhcDriver {
	public GlobalWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {

	}

	@FindBy(css = "#gf_lnk_1")
	public WebElement footerHomeLink;

	@FindBy(xpath = "//a[text()='Home']")
	public WebElement breadCrumbHomeLink;

	// @FindBy(css = "#gf_lnk_2")
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
	@FindBy(css = "#gf_lnk_10")
	public WebElement footerRequestforAssistancelink;

	@FindBy(xpath = "//*[@class='footer-bottom']//a[contains(@href,'accessibility')]")
	public WebElement footerAccessibilitylink;

	@FindBy(xpath = "//*[@id='accordion-4-button']//..//a[contains(@href,'aarp.org')]")
	public WebElement aarpOrgLink;

	@FindBys(value = { @FindBy(css = "#footnotes1") })
	public WebElement footnotesContent;

	@FindBy(css = "#accordion-1-button")
	public WebElement shopPlansExpander;

	@FindBy(css = "#accordion-2-button")
	public WebElement toolsAndResources;

	@FindBy(css = "#accordion-3-button")
	public WebElement learnAboutMedicareFooterButton;

	@FindBy(css = "#accordion-4-button > div")
	public WebElement more;

	@FindBy(css = "#accordion-1-content [href*='medicare-advantage-plans']")
	public WebElement medicareAdvantagePlansLink;

	@FindBy(css = "#accordion-1-content [href*='special-needs-plans']")
	public WebElement medicareSpecialNeedsPlansLink;

	@FindBy(css = "#accordion-1-content [href*='medicare-supplement-plans']")
	public WebElement medicareSupplementInsurancePlansLink;

	@FindBy(css = "#accordion-1-content [href*='prescription-drug-plans']")
	public WebElement medicarePrescriptionDrug_PlansLink;

	@FindBy(xpath = "//span[@class='meded-article-header__title' and contains(text(),'Medicare Supplement')]")
	public WebElement medicareSupplementInsurancePlansHeader;

	@FindBy(css = "#gfn_lnk_row3_1")
	public WebElement learnAboutMedicareLink;

	@FindBy(css = "#gfn_lnk_row3_2")
	public WebElement prepareForInitialEnrollment;

	@FindBy(css = "#gfn_lnk_row3_3")
	public WebElement exploreChangingPlansLink;

	@FindBy(css = "#gfn_lnk_row3_4")
	public WebElement discoverMoreResourcesLink;

	@FindBy(linkText = "Back to Top")
	public WebElement footerNavigationBackToTopLink;

	@FindBy(css = "#accordion-disclaimer-button")
	public WebElement viewAllDisclaimerInformationLink;

	// @FindBy(linkText = "Hide disclaimer information")
	@FindBy(xpath = ".//*[contains(@class, 'hidedisclaimerstext')]")
	public WebElement hideDiscliamerInformation;

	@FindBy(css = "a.backtotop1.hideLink")
	public WebElement disclaimerBackToTopLink;

	@FindBy(css = "#proceed")
	public WebElement siteLeavingPopupProceddButton;

	@FindBy(css = "#gf_lnk_6")
	public WebElement footerTermsAndConditionsLink;

	@FindBy(css = "#gf_lnk_8")
	public WebElement footerAgentsAndBrokersLink;

	@FindBy(css = "#gfn_lnk_row3_3")
	public WebElement prepareForInitialEnrollmentLink;

	@FindBy(css = "#gfn_lnk_row2_5")
	public WebElement medicareSpecialNeedPlansLink;

	// @FindBy(xpath = "//h1[@class='logo']/a")
	@FindBy(css = "#logo")
	public WebElement logoLink;

	@FindBy(xpath = "//ul[@class='menu-links']/li[2]/a")
	public WebElement importantDisclosuresLink;

	// @FindBy(xpath = "//ul[@class='menu-links']/li[1]/a")
	@FindBy(css = "#mobile-nav a[dtmname$='Visit AARP.org']")
	public WebElement visitAARPLink;

	@FindBy(css = "#search-field")
	public WebElement searchTxtbox;

	@FindBy(css = "#header-tfn-link")
	public WebElement headerTfn;

	@FindBy(css = "#guest-profile")
	public WebElement visitorProfileFlyoutTitle;

	@FindBy(css = "#guest-saved-items-button")
	public WebElement visitorProfileFlyoutViewSavedItemBtn;

	@FindBy(css = "#flyout-drug-button")
	public WebElement visitorProfileFlyoutAddDrugBtn;

	@FindBy(css = "#flyout-plan-button")
	public WebElement visitorProfileFlyoutAddPlansBtn;

	@FindBy(xpath = "//*[contains(@class,'log-in')]//a[contains(text(),'Sign In')]")
	public WebElement visitorProfileFlyoutSignInLink;

	@FindBy(css = "#proceed")
	public WebElement proceedLink;

	@FindBy(className = "menu-dropdown")
	public WebElement alreadyPlanMemberButtonInactive;

	@FindBy(xpath = "//div[@class='menu-dropdown active']")
	public WebElement alreadyPlanMemberButtonActive;

	@FindBy(css = "#already-a-member-dropdown")
	public WebElement alreadyPlanMemberButton;

	@FindBy(className = "sign-in-text")
	public WebElement signInText;

	@FindBy(css = "#top-user")
	public WebElement usernameField;

	@FindBy(css = "#top-pass")
	public WebElement passwordField;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/a")
	public WebElement forgotUsernameLink;

	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	public WebElement registerHereLink;

	@FindBy(className = "not-registered-text")
	public WebElement notRegisteredText;

	@FindBy(css = "#nav")
	public WebElement navigationSectionEnterSearch;

	@FindBy(css = "#ghn_lnk_2")
	public WebElement navigationSectionOurPlansLink;

	@FindBy(css = "#ghn_lnk_3")
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

	@FindBy(css = "#nav-zipcode")
	public WebElement zipcodeField;

	@FindBy(xpath = "//*[@id='zipcodemeded-0']")
	public WebElement zipcodeFieldShopPage;

	@FindBy(className = "zip-button")
	public WebElement findPlansButton;

	@FindBy(css = "#ghn_lnk_2")
	public WebElement ourPlansHoverLink;

	@FindBy(css = "#subnav_2")
	public WebElement ourPlansDropdownText;

	/** Request for assistance model window **/
	@FindBy(css = "#cover")
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

	@FindBy(css = "#aarpSVGLogo")
	public WebElement AARPlogo;

	@FindBy(xpath = "//*[contains(@id,'uhcSVGLogo')]")
	public WebElement UHCLogo;

	// @FindBy(xpath = "//img[contains(@dtmid,'acq_visitor_profile')]")
	@FindBy(css = ".saved_items_container > button[dtmname^='Visitor Profile:Global Header']")
	public WebElement visitorprofileicon;

	// @FindBy(xpath = "//*[contains(@onclick,'jumpToHSIDSignIn()')]")
	@FindBy(xpath = "//*[contains(@onclick,\"jumpToHSIDSignIn('body')\")]")
	public WebElement signIn;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[3]/a")
	public WebElement menuShop;

	@FindBy(css = "#accordion-2-content [href*='plan-recommendation-engine']")
	public WebElement planRecommendationLink;

	@FindBy(css = "#accordion-2-content [href*='drug-cost-estimator']")
	public WebElement drugCostEstimatorLink;

	@FindBy(css = "#accordion-2-content [href*='Pharmacy-Search']")
	public WebElement pharmacySearchLink;

	@FindBy(css = "#accordion-2-content [onclick*='ProviderSearch']")
	public WebElement searchDoctorsLink;

	@FindBy(css = "#accordion-2-content [title='Search Dentists']")
	public WebElement searchDentistsLink;

	@FindBy(css = "#accordion-3-content [href*='medicare-education']")
	public WebElement introductionToMedicareLink;

	@FindBy(css = "#accordion-3-content [href*='medicare-eligibility']")
	public WebElement eligibilityLink;

	@FindBy(css = "#accordion-3-content [href*='medicare-parts-and-medigap-plans']")
	public WebElement coverageChoiceLink;

	@FindBy(css = "#accordion-3-content [href*='medicare-faq']")
	public WebElement medicareFaqLink;

	@FindBy(css = "#accordion-4-content [href*='about-us']")
	public WebElement aboutLink;

	@FindBy(css = "#accordion-4-content [href*='contact-us']")
	public WebElement contactLink;

	@FindBy(css = "#accordion-4-content [href*='language-assistance']")
	public WebElement languageAssistanceLink;

	@FindBy(css = "#accordion-4-content [href*='aarp.org']")
	public WebElement footerAARPLink;

	// @FindBy(xpath = "//b[contains(text(),'MENU')]")
	@FindBy(css = "div[aria-label='menu navigation']")
	public WebElement MenuMobile;

	@FindBy(css = ".mob-menu-header > div > button[class*='nav-close']")
	public WebElement mainMenuNavCloseButton;

	@FindBy(css = "[class$='mob-menu-search'] button[class$='nav-close']")
	public WebElement siteSearchCloseButton;

	@FindBy(css = "#mobile-nav")
	public WebElement mobileNav;

	@FindBy(css = "#ghn_lnk_2")
	public WebElement shopForAPlan;

	@FindBy(css = "#subnav_2 .nav-back")
	public WebElement shopForPlanBackButton;

	@FindBy(css = "#ghn_lnk_1")
	public WebElement home;

	
	@FindBy(css = "a[class*='GoToMember']")
	public WebElement goToMemberSiteLink;
	

	@FindBy(css = ".mob-menu-header button[class^='icon-mob-btn'][onclick*='Search']")
	private WebElement siteSearchButton;

	@FindBy(css = "form[class*='zipCompForm-0'] button[class*='zip-button']")
	private WebElement getStartedButton;

	@FindBy(css = "#ghn_lnk_3")
	public WebElement learnAboutMedicareNavButton;

	@FindBy(css = "#subnav_3 .nav-back")
	private WebElement learnAboutMedicareBackButton;

	@FindBy(css = "#accordion-1-button > svg")
	public WebElement shopPlans;

	@FindBy(xpath = "//*[@id='accordion-2-button']/div")
	public WebElement tools;

	@FindBy(xpath = "//*[@id='accordion-3-button']/div")
	public WebElement learnMedicare;
	

	@FindBy(css = "#redirect_content")
	private WebElement leaveAARPMedicarePlansDialog;

	@FindBy(css = "#proceed")
	private WebElement proceedLeaveAARPMedicare;
	
	@FindBy(css = "#upgradeVersionBarNew")
	private WebElement upgradeBrowserVersionBanner;
	
	@FindBy(css = "#upgradeVersionBarNew div[class$='buttons'] > .updateLater")
	private WebElement updateLaterButton;
	
	@FindBy(css = "#upgradeVersionBarNew div[class$='buttons'] > .updateNow")
	private WebElement updateNowButton;

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}
	
	public void proceedToLeaveAARP() {
		if (validate(leaveAARPMedicarePlansDialog)) {
			jsClickNew(proceedLeaveAARPMedicare);
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
		}
	}

	/**
	 * Access footer link from shop plans tab.
	 *
	 * @param planType the plan type
	 */
	public void accessFooterLinkFromShopPlans(PLANTYPE planType) {
		boolean expanded = Boolean.parseBoolean(CommonUtility.getElementAttribute(shopPlansExpander, "aria-expanded"));
		if (!expanded) {
			jsClickNew(shopPlansExpander);
		}

		switch (planType) {
		case MA:
		case MAPD:
			jsClickNew(medicareAdvantagePlansLink);
			break;
		case DSNP:
		case SNP:
			jsClickNew(medicareSpecialNeedsPlansLink);
			break;
		case MEDSUPP:
			jsClickNew(medicareSupplementInsurancePlansLink);
			break;
		case PDP:
			jsClickNew(medicarePrescriptionDrug_PlansLink);
			break;
		default:
			throw new IllegalArgumentException("Invalid link for plan type - " + planType.name());
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}

	/**
	 * Access footer link from Tools Resources tab.
	 *
	 * @param tool the tool
	 */
	public void accessFooterLinkFromToolsResources(TOOLS tool) {
		boolean expanded = Boolean.parseBoolean(CommonUtility.getElementAttribute(toolsAndResources, "aria-expanded"));
		if (!expanded) {
			jsClickNew(toolsAndResources);
		}

		switch (tool) {
		case PRE:
			jsClickNew(planRecommendationLink);
			break;
		case DCE:
			jsClickNew(drugCostEstimatorLink);
			break;
		case PHARMACYSEARCH:
			jsClickNew(pharmacySearchLink);
			break;
		case SEARCHDOCTORS:
			switchToNewTabNew(searchDoctorsLink);
			break;
		case SEARCHDENTISTS:
			switchToNewTabNew(searchDentistsLink);
			break;
		default:
			throw new IllegalArgumentException("Invalid tool - " + tool.name());
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}

	/**
	 * Access footer link from Learn About Medicare tab.
	 *
	 * @param option the option
	 */
	public void accessFooterLinkFromLearnAboutMedicare(String option) {
		boolean expanded = Boolean
				.parseBoolean(CommonUtility.getElementAttribute(learnAboutMedicareFooterButton, "aria-expanded"));
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
			throw new IllegalArgumentException("Invalid Learn about Medicare option - " + option);
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}

	/**
	 * Access footer link from More tab.
	 *
	 * @param option the option
	 */
	public void accessFooterLinkFromMore(String option) {
		boolean expanded = Boolean.parseBoolean(CommonUtility.getElementAttribute(more, "aria-expanded"));

		scrollToView(more);

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

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CommonUtility.checkPageIsReadyNew(driver);
	}

	/**
	 * Open home from menu.
	 * 
	 * Clicks on the Home option from right nav menu
	 *
	 * @return the acquisition home page mobile
	 */
	public AcquisitionHomePageMobile openHomeFromMenu() {
		// Scroll to the top of page for header to be visible
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		jsClickNew(MenuMobile);
		sleepBySec(2);
		validateNew(mobileNav, 5);
		jsClickNew(home);
		sleepBySec(2);
		if (validate(getStartedButton)) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

	
	public void openMemberSignInFromMenu() {
		//Scroll to the top of page for header to be visible
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		jsClickNew(MenuMobile);
		
		validateNew(mobileNav, 5);
		
		jsClickNew(goToMemberSiteLink);
	}
	
	

	/**
	 * Open site search from menu.
	 * 
	 */
	public void openSiteSearchFromMenu() {
		// Scroll to the top of page for header to be visible
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		jsClickNew(MenuMobile);

		// validateNew(mobileNav, 5);

		jsClickNew(siteSearchButton);
	}

	/**
	 * Open Shop for Plan from menu.
	 *
	 * @return the object of ShopForPlanNavigationPageMobile
	 * 
	 *         To access the options under Shop for Plan menu, refer the methods in
	 *         ShopForPlanNavigationPageMobile
	 */
	public ShopForPlanNavigationPageMobile openShopForPlanFromMenu() {

		// Scroll to the top of page for header to be visible
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		jsClickNew(MenuMobile);

		waitforElement(shopForAPlan);
		// validateNew(mobileNav, 5);

		jsClickNew(shopForAPlan);
		if (validate(shopForPlanBackButton)) {
			return new ShopForPlanNavigationPageMobile(driver);
		}
		return null;
	}

	/**
	 * Open Learn about Medicare from menu.
	 *
	 * @return the object of LearnAboutMedicareHomePageMobile
	 * 
	 *         To access the options under Shop for Plan menu, refer the methods in
	 *         LearnAboutMedicareHomePageMobile
	 */
	public LearnAboutMedicareHomePageMobile openLearnAboutMedicareFromMenu() {
		// Scroll to the top of page for header to be visible
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		jsClickNew(MenuMobile);
		sleepBySec(5);
		// validateNew(mobileNav, 5);

		jsClickNew(learnAboutMedicareNavButton);
		if (validate(learnAboutMedicareBackButton)) {
			return new LearnAboutMedicareHomePageMobile(driver);
		}
		return null;
	}

	
	/**
	 * Click update later browser button.
	 * 
	 * This method is for lower version of Chrome browser on Android
	 */
	public void clickUpdateLaterBrowserButton() {
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			if (validate(upgradeBrowserVersionBanner)) {
				System.out.println("Update browser banner shown !");
				jsClickNew(updateLaterButton);
				System.out.println("Clicked 'Update later' button");
				sleepBySec(2);
				if (!upgradeBrowserVersionBanner.isDisplayed()) {
					System.out.println("Update browser banner disappeared.");
				}
			}
		}
	}
	

}
