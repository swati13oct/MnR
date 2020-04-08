package pages.acquisition.shopperprofile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class ProfileSearch extends UhcDriver {
	
	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;
	
	@FindBy(id = "authFirstName")
	private WebElement firstName;
	
	@FindBy(id = "authLastName")
	private WebElement lastName;
	
	@FindBy(xpath = "//button[text()='Search Shopper']")
	private WebElement btnSearchShopper;
	
	@FindBy(xpath = "//button[contains(text(),'Profile')]")
	private WebElement btnCreateProfile;
	
	@FindAll({@FindBy(xpath = "//table/tbody/tr")})
	private List<WebElement> searchResults;
	
	@FindBy(xpath="//table//button")
	private WebElement btnCloakIn;

	
	
	public ProfileSearch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, firstName, 45);
		CommonUtility.waitForPageLoadNew(driver, btnSearchShopper, 45);
	}
	
	/**
	 * Validate the search results 
	 */
	public void validateSearchProfileResults() {
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		waitforElement(searchResults.get(0));
		Assert.assertTrue(searchResults.size()>0);
	}

	/**
	 * Search profile by email
	 * @param email
	 */
	public void searchProfileByEmail(String email) {
		
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		sendkeys(visitorEmail, email);
		btnSearchShopper.click();
		validateSearchProfileResults();
	}
	
	/**
	 * Search Profile by First Name and Last Name
	 * @param fname
	 * @param lname
	 */
	public void searchProfileByName(String fname,String lname) {
		
		CommonUtility.waitForPageLoadNew(driver, firstName, 45);
		sendkeys(firstName, fname);
		sendkeys(lastName, lname);
		btnSearchShopper.click();
		validateSearchProfileResults();
	}
	
	/**
	 * Cloak In the Searched Profile
	 * @return
	 */
	public VPPPlanSummaryPage doCloakIn() {
		try {
			CommonUtility.waitForPageLoadNew(driver, searchResults.get(0), 45);
			btnCloakIn.click();
			Thread.sleep(5000);
			switchToNewTab();
			Thread.sleep(10000);
			if(driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
				return new VPPPlanSummaryPage(driver);
			}else {
				System.out.println("Plan Summary page is not loaded");
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
