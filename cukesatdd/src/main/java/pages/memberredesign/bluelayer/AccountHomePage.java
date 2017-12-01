package pages.memberredesign.bluelayer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ClassToInstanceMap;

import atdd.framework.UhcDriver;
import gherkin.lexer.i18n.EO;

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
	
	@FindBy(linkText = "ACCOUNT SETTINGS")
	private WebElement accountnSettings;
	
	@FindBy(linkText = "SAVED")
	private WebElement saved;
	
	@FindBy(linkText = "LOG OUT")
	private WebElement logout;
	
	@FindBy(linkText = "About UnitedHealthcare")
	private WebElement aboutUHC;
	
	@FindBy(linkText = "Legal Entity Disclosure")
	private WebElement legalDisclosures;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicy;
	
	@FindBy(linkText = "Terms of Use")
	private WebElement termsOfUse;

	@FindBy(linkText = "Language Assistance | Non-Discrimination Notice")
	private WebElement languageAssistanceEnglish;
	
	@FindBy(linkText = "Asistencia de Idiomas | Aviso de no Discriminación (PDF)")
	private WebElement languageAssistanceSpanish;
	
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
	
	public void validateHeader(){
		Assert.assertTrue("Header is not displayed", header.isDisplayed());
	}
	
	public void validateHomeTab(){
		Assert.assertTrue("Home tab is not displayed", home.isDisplayed());
	}
	
	public void validateFindCareCostTab(){
		Assert.assertTrue("Find Care and Cost tab is not displayed", findCareCost.isDisplayed());
	}
	
	public void validateClaims(){
		Assert.assertTrue("Claims tab is not displayed", claims.isDisplayed());
	}
	
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
	
	public void clickClaimsSummary(){
		if(claims.isDisplayed()){
			claims.click();
			if(claimSummary.isDisplayed()){
				claimSummary.click();
			}
		}
	}
	
	public void clickPremiumPayment(){
		if(premiumPayment.isDisplayed()){
			premiumPayment.click();
		}
	}
	
	public void clickeob(){
		if(claims.isDisplayed()){
			claims.click();
			if(explainationOfBenefits.isDisplayed()){
				explainationOfBenefits.click();
			}
		}
	}
	
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
	
	public void clickCoverageBenefits(){
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			Assert.assertTrue("benefitsSummary tab is not displayed", benefitsSummary.isDisplayed());
			Assert.assertTrue("formsAndResources tab is not displayed", formsAndResources.isDisplayed());
			Assert.assertTrue("orderMaterials tab is not displayed", orderMaterials.isDisplayed());
		}
	}
	
	public void clickBenefitsSummary(){
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			if(benefitsSummary.isDisplayed()){
				benefitsSummary.click();
			}
		}
	}
	
	public void clickFormsResources(){
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
			if(formsAndResources.isDisplayed()){
				formsAndResources.click();
			}
		}
	}
	
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
	
	public void validateFooterSection(){
		JavascriptExecutor jse = (JavascriptExecutor) driver; 
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
		Assert.assertTrue("Footer section is not displayed", footerSection.isDisplayed());
	}
	
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
	
	public void validateQuickLinksFooterLinks(){
//		List<WebElement> footerlinksColumn = driver.findElements(By.id("footerLinksID"));
//		System.out.println(footerlinksColumn.size());
//		String quickLinksFooterLinkText = footerlinksColumn.get(1).getText();
		//System.out.println(quickLinksFooterLinkText);
		Assert.assertTrue("Language Assistance english link is not displayed", languageAssistanceEnglish.isDisplayed());
		Assert.assertTrue("Language Assistance Spanish is not displayed", languageAssistanceSpanish.isDisplayed());
		
	}
	
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
	
	public void validateSavedLink(){
		Assert.assertTrue("Saved link is not clickable", saved.isDisplayed());
	}
	
	
	

}
