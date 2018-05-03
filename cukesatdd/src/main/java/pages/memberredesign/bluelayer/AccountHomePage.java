package pages.memberredesign.bluelayer;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
//import gherkin.lexer.i18n.EO;

public class AccountHomePage extends UhcDriver {
	
	@FindBy(id = "home_2")
	private WebElement home;
	
	@FindBy(linkText = "FIND CARE & COSTS")
	private WebElement findCareCost;
	
	@FindBy(id = "claims_1")
	private WebElement claims;
	
	@FindBy(id = "claimsummaryC1")
	private WebElement claimSummary;
	
	@FindBy(id = "eobC1")
	private WebElement explainationOfBenefits;
	
	@FindBy(id = "coveragebenefits_2")
	private WebElement coverageBenefits;
	
	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;
	
	@FindBy(id = "formsandresourcesC1")
	private WebElement formsAndResources;
	
	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;
	
	@FindBy(id = "premiumpayment_3")
	private WebElement premiumPayment;
	
	@FindBy(id = "healthwellness_3")
	private WebElement healthWellness;
	
	@FindBy(id = "Help")
	private WebElement help;
	
	@FindBy(id = "Account/Profile")
	private WebElement accountProfile;

	@FindBy(className = "menuL1")
	private WebElement header;
	
	@FindBy(className = "footerContainer")
	private WebElement footerSection;
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;
	
	@FindBy(linkText = "Help & Contact Us")
	private WebElement helpnContactUs;
	
	@FindBy(linkText = "Legal Notices & Disclosures")
	private WebElement legalNotices;
	
	@FindBy(linkText = "Account Settings")
	private WebElement accountnSettings;
	
	@FindBy(linkText = "Saved")
	private WebElement saved;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	@FindBy(linkText = "About UnitedHealthcare")
	private WebElement aboutUHC;
	
	@FindBy(linkText = "Legal Entity Disclosure")
	private WebElement legalDisclosures;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicy;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUse;


	
	public AccountHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
		validate(home);
		validate(findCareCost);
		validate(claims);
		validate(claimSummary);
		validate(explainationOfBenefits);
		validate(coverageBenefits);
		validate(benefitsSummary);
		validate(formsAndResources);
		validate(orderMaterials);
		validate(premiumPayment);
		validate(healthWellness);
		validate(accountProfile);
		validate(help);
		
	}
	
	/**
	 * Validate the Header of the page
	 */
	public void validateHeader(){
		Assert.assertTrue("Header is not displayed", header.isDisplayed());
	}
	
	/**
	 * Validate Home Tab of the page
	 */
	public void validateHomeTab(){
		Assert.assertTrue("Home tab is not displayed", home.isDisplayed());
	}
	
	/**
	 * validate Find Care Cost Tab
	 */
	public void validateFindCareCostTab(){
		Assert.assertTrue("Find Care and Cost tab is not displayed", findCareCost.isDisplayed());
	}
	
	/**
	 * Validate claims Tab
	 */
	public void validateClaims(){
		Assert.assertTrue("Claims tab is not displayed", claims.isDisplayed());
	}
	
	/**
	 * Validate claims level 2 tabs
	 */
	public void validateClaimsL2Tabs(){
		if(claims.isDisplayed()){
			claims.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue("claimSummary is not displayed", claimSummary.isDisplayed());
			Assert.assertTrue("explainationOfBenefits is not displayed", explainationOfBenefits.isDisplayed());
		}
	}
	
	/**
	 * Validate Coverage and Benefits Level 2 Tabs
	 */
	public void validateCoverageBenefitsL2Tabs(){
		waitforElement(coverageBenefits);
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue("benefitsSummary is not displayed", benefitsSummary.isDisplayed());
			Assert.assertTrue("formsAndResources is not displayed", formsAndResources.isDisplayed());
			Assert.assertTrue("orderMaterials is not displayed", orderMaterials.isDisplayed());
		}
	}
	
	/**
	 * Click on claims summary
	 */
	public void clickClaimsSummary(){
		if(claims.isDisplayed()){
			claims.click();
			if(claimSummary.isDisplayed()){
				claimSummary.click();
			}
		}
	}
	
	/**
	 * Click on premium payment
	 */
	public void clickPremiumPayment(){
		if(premiumPayment.isDisplayed()){
			premiumPayment.click();
		}
	}
	
	/**
	 * Click on claims followed by EOB
	 */
	public void clickeob(){
		if(claims.isDisplayed()){
			claims.click();
			if(explainationOfBenefits.isDisplayed()){
				explainationOfBenefits.click();
			}
		}
	}
	
	/**
	 * Validate coverage and Benefits tab
	 */
	public void validateCoverageBenefits(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitforElement(coverageBenefits);
		Assert.assertTrue("coverageBenefits tab is not displayed", coverageBenefits.isDisplayed());
	}
	
	/**
	 * Click coverage and Benefits tab, and verifies benefits Summary, forms And Resources and order Materials tab
	 */
	public void clickCoverageBenefits(){
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			Assert.assertTrue("benefitsSummary tab is not displayed", benefitsSummary.isDisplayed());
			Assert.assertTrue("formsAndResources tab is not displayed", formsAndResources.isDisplayed());
			Assert.assertTrue("orderMaterials tab is not displayed", orderMaterials.isDisplayed());
		}
	}
	
	/**
	 * click on Benefits Summary
	 */
	public void clickBenefitsSummary(){
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			if(benefitsSummary.isDisplayed()){
				benefitsSummary.click();
			}
		}
	}
	
	/**
	 * click on forms And Resources
	 */
	public void clickFormsResources(){
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			if(formsAndResources.isDisplayed()){
				formsAndResources.click();
			}
		}
	}
	
	/**
	 * click on Order Materials
	 */
	public void clickOrderMaterials() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (coverageBenefits.isDisplayed()) {
			coverageBenefits.click();
			if (orderMaterials.isDisplayed()) {
				orderMaterials.click();
			}
		}
	}
	
	public void validateHelp(){
		//Assert.assertTrue("Help tab is not displayed", help.isDisplayed());
	}
	
	public void validateAccountProfile(){
		//Assert.assertTrue("Account/Profile tab is not displayed", accountProfile.isDisplayed());
	}
	/**
	 * Validate Footer section of the page
	 */
	public void validateFooterSection(){
		JavascriptExecutor jse = (JavascriptExecutor) driver; 
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
		Assert.assertTrue("Footer section is not displayed", footerSection.isDisplayed());
	}
	
	/**
	 * Validate Member support content section
	 */
	public void validateMemberSupport(){
//		List<WebElement> footerColumn = driver.findElements(By.id("memberSupportID"));
//		System.out.println(footerColumn.size());
//		String memberSupportText = footerColumn.get(0).getText();
//		Assert.assertTrue("Member Support is not displayed", memberSupportText.contains("Member Support"));
//		Assert.assertTrue("Help & Contact Us link is not displayed", memberSupportText.contains("Help & Contact Us"));
//		Assert.assertTrue("Legal Notices & Disclosures link is not displayed", memberSupportText.contains("Legal Notices & Disclosures"));
		Assert.assertTrue("Help & Contact Us link is not clickable", helpnContactUs.isDisplayed());
		Assert.assertTrue("legal notices and disclaimer link is not clickable", legalNotices.isDisplayed());
		validateMemberSupportFooterLinks();
	}
	
	/**
	 * Validate member support Footer links
	 */
	public void validateMemberSupportFooterLinks(){
//		List<WebElement> footerlinksColumn = driver.findElements(By.id("footerLinksID"));
//		System.out.println(footerlinksColumn.size());
//		String memberSupportFooterLinkText = footerlinksColumn.get(0).getText();
		//System.out.println(memberSupportFooterLinkText);
		Assert.assertTrue("About link is not displayed", aboutUHC.isDisplayed());
		Assert.assertTrue("Legal Disclosures link is not displayed", legalDisclosures.isDisplayed());
		Assert.assertTrue("Privacy Policy link is not displayed", privacyPolicy.isDisplayed());
		Assert.assertTrue("Terms of Use link is not displayed", termsOfUse.isDisplayed());
	}
	
	/**
	 * Validate quick links in footer section
	 */
	public void validateQuickLinksFooterLinks(){
//		List<WebElement> footerlinksColumn = driver.findElements(By.id("footerLinksID"));
//		System.out.println(footerlinksColumn.size());
//		String quickLinksFooterLinkText = footerlinksColumn.get(1).getText();
		//System.out.println(quickLinksFooterLinkText);
		//Assert.assertTrue("Language Assistance english link is not displayed", languageAssistanceEnglish.isDisplayed());
		//Assert.assertTrue("Language Assistance Spanish is not displayed", languageAssistanceSpanish.isDisplayed());
		
	}
	
	/**
	 * Validate quick links
	 */
	public void validateQuickLinks(){
//		List<WebElement> footerColumn = driver.findElements(By.id("memberSupportID"));
//		System.out.println(footerColumn.size());
//		String quickLinksText = footerColumn.get(1).getText();
//		System.out.println(quickLinksText);
//		Assert.assertTrue("Quick Links is not displayed", quickLinksText.contains("Quick Links"));
//		Assert.assertTrue("Account and settings link is not displayed", quickLinksText.contains("ACCOUNT SETTINGS"));
//		Assert.assertTrue("Saved is not displayed", quickLinksText.contains("SAVED"));
//		Assert.assertTrue("Logout link is not displayed", quickLinksText.contains("LOG OUT"));
		Assert.assertTrue("Account and Settings link is not clickable", accountnSettings.isDisplayed());
		Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
		Assert.assertTrue("Logout link is not clickable", logout.isDisplayed());
		validateQuickLinksFooterLinks();
	}
	
	/**
	 * Validate Feedback Model
	 */
	public void checkModelPopup() {
		try {
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)) {
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
		} catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}
	}
	
	/**
	 * Validate saved links
	 */
	public void validateSavedLink(){
		Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
	}
	
	
	

}
