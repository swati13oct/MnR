package pages.mobile.acquisition.commonpages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;


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
	
	@FindBy(id = "aarpSVGLogo")
	public WebElement AARPlogo;
	
	@FindBy(css="input#visitorsEmail+div.invalid-field")
	private WebElement emailError;
	
	@FindBy(css="input#authFirstName+div.invalid-field")
	private WebElement fnameError;
	
	@FindBy(css="input#authLastName+div.invalid-field")
	private WebElement lnameError;
	
	@FindBy(css="p.failure.text-danger")
	private WebElement errorMessage;
	
	@FindBy(css="a.back-button")
	private WebElement backToProfileSearch;
	
	@FindBy(xpath="//a[text()='Non Member']")
	private WebElement nonMemberTab;

	public static final String DELETE_PROFILE_URL = "http://digital-checkout-team-e.ocp-elr-core-nonprod.optum.com/digital-checkout/guest/profile";
	
	
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
	 * Search Profile and Delete for a member
	 * @param email
	 * @param dob
	 * @param mbi
	 */
	public void searchProfileAndDelete(String email,String dob,String mbi) {
		
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
		sendkeys(visitorEmail, email);
		btnSearchShopper.click();
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
		if(searchResults.size()>0) {
			DeleteProfileMobile deleteProfile = new DeleteProfileMobile(driver);
			deleteProfile.deleteAProfile(email);
			backToProfileSearch.click();
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
			sendkeys(visitorEmail, email);
			btnSearchShopper.click();
		}else {
			CommonUtility.waitForPageLoadNew(driver, btnCreateProfile, 20);
			System.out.println("########No user found########");
		}
	}
	
	/**
	 * Click on create profile button
	 * @return
	 */
	public MemberCreateProfile clickOnCreateProfile() {
			try {
				btnCreateProfile.click();
				Thread.sleep(5000);
				if(driver.getCurrentUrl().contains("create-profile")) {
					return new MemberCreateProfile(driver);
				}else {
					System.out.println("Create Profile failed");
					return null;
			}
			} catch (Exception e) {
				Assert.fail("Create Profile failed");
				return null;
			}
	}
	/**
	 * Validate error messages	
	 * @param emptyFields
	 * @param email
	 */
	public void validateErrorMessages(boolean emptyFields,String email,String fname,String lname) {
		if (emptyFields) {
			btnSearchShopper.click();
			Assert.assertEquals(emailError.getText().trim(), "Enter a valid email address");
			Assert.assertEquals(fnameError.getText().trim(), "First name is required");
			Assert.assertEquals(lnameError.getText().trim(), "Last name is required");
			Assert.assertEquals(errorMessage.getText().trim(), "Please provide either Email or First & Last name to search Shopper.");
		}else if(Strings.isNullOrEmpty(email)){
			sendkeys(firstName, fname);
			sendkeys(lastName, lname);
			btnSearchShopper.click();
			waitforElement(errorMessage);
			Assert.assertEquals(errorMessage.getText().trim().replaceAll("\\.\\s+", "\\.\n"), "There are no results found for this user."+"\n"+"Please re-enter"
					+ " Email or First & Last name then click the search button."+"\n"+"or, Create a Shopper Profile for Consumer.");
		}else {
			sendkeys(visitorEmail, email);
			btnSearchShopper.click();
			Assert.assertEquals(emailError.getText().trim(), "Enter a valid email address");
		}
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
	public ComparePlansPageMobile doCloakIn() {
	//public VPPPlanSummaryPage doCloakIn() {
		try {
			CommonUtility.waitForPageLoadNew(driver, searchResults.get(0), 45);
			String winBeforeClick = driver.getWindowHandle();
			btnCloakIn.click();
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String>(
                    driver.getWindowHandles());
			/*driver.switchTo().window(tabs.get(1));
			driver.switchTo().window(tabs.get(0)).close();
			driver.switchTo().window(tabs.get(1));*/
			
			for(String tab: tabs) {
				if(!tab.equals(winBeforeClick)) {
					driver.switchTo().window(tab);
					break;
				} else {
					driver.switchTo().window(tab).close();
				}
			}
			
			
			CommonUtility.checkPageIsReadyNew(driver);
			validateNew(AARPlogo);
			if(driver.getCurrentUrl().contains("health-plans.html")) {
				return new ComparePlansPageMobile(driver);
			}else {
				System.out.println("Plan Compare page is not loaded");
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Click on create profile for non member
	 * @return
	 */
	public NonMemberCreateProfile clickOnCreateProfileForNonMember() {
		try {
			btnCreateProfile.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='Non Member']")).click();
			if(driver.getCurrentUrl().contains("create-profile")) {
				return new NonMemberCreateProfile(driver);
			}else {
				System.out.println("Create Profile failed");
				return null;
		}
		} catch (Exception e) {
			Assert.fail("Create Profile failed");
			return null;
		}
	}
	
	/**
	 * Search Profile and Delete for a Non member
	 * @param email
	 * @param dob
	 * @param mbi
	 */
	public void searchProfileAndDeleteNonMember(HashMap<String,String> givenAttributesMap) {
		
		/*Map<String, String> givenAttributesMap = new HashMap<String, String>();
		List<DataTableRow> givenAttributesRow = nonMemberDetails.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String emailID = givenAttributesMap.get("Email");
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
		sendkeys(visitorEmail, emailID);
		btnSearchShopper.click();
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
		if(searchResults.size()>0) {
			DeleteProfileMobile deleteProfile = new DeleteProfileMobile(driver);
			deleteProfile.deleteAProfile(emailID);
			backToProfileSearch.click();
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
			sendkeys(visitorEmail, emailID);
			btnSearchShopper.click();
		}else {
			CommonUtility.waitForPageLoadNew(driver, btnCreateProfile, 20);
			System.out.println("########No user found########");
		}
	}
}
