package pages.memberredesign.bluelayer;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ClassToInstanceMap;

import atdd.framework.UhcDriver;
import gherkin.lexer.i18n.EO;

public class AccountHomePage extends UhcDriver {
	
	@FindBy(id = "home")
	private WebElement home;
	
	@FindBy(id = "findcarecost")
	private WebElement findCareCost;
	
	@FindBy(id = "claims")
	private WebElement claims;
	
	@FindBy(id = "claimsummary")
	private WebElement claimSummary;
	
	@FindBy(id = "eob")
	private WebElement explainationOfBenefits;
	
	@FindBy(id = "coveragebenefits")
	private WebElement coverageBenefits;
	
	@FindBy(id = "benefitssummary")
	private WebElement benefitsSummary;
	
	@FindBy(id = "formsandresources")
	private WebElement formsAndResources;
	
	@FindBy(id = "ordermaterials")
	private WebElement orderMaterials;
	
	@FindBy(id = "premiumpayment")
	private WebElement premiumPayment;
	
	@FindBy(id = "healthwellness")
	private WebElement healthWellness;
	
	@FindBy(id = "Help")
	private WebElement help;
	
	@FindBy(id = "Account/Profile")
	private WebElement accountProfile;
	
	//menuL1
	@FindBy(className = "menuL1")
	private WebElement header;
	

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
			Assert.assertTrue("claimSummary is not displayed", claimSummary.isDisplayed());
			Assert.assertTrue("explainationOfBenefits is not displayed", explainationOfBenefits.isDisplayed());
		}
	}
	
	public void validateCoverageBenefitsL2Tabs(){
		waitforElement(coverageBenefits);
		if(coverageBenefits.isDisplayed()){
			coverageBenefits.click();
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
	
	
	

}
