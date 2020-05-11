package pages.acquisition.shopperprofile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class NonMemberCreateProfile extends UhcDriver {
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//input[@id='email']")
	private WebElement visitorEmail;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//app-tab[@tabtitle='Non Member']//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//input[@id='dob']")
	private WebElement dob;
	
	@FindBy(xpath = "//label[@for='male']")
	private WebElement male;
	
	@FindBy(xpath = "//label[@for='female']")
	private WebElement female;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//input[@id='zipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//button[contains(text(),'Profile')]")
	private WebElement btnCreateProfile;
	
	@FindBy(xpath="//div[contains(@class,'progress-bar')]")
	private WebElement progressBar;
	
	@FindBy(xpath = "//h5")
	private WebElement shopperProfileCreationHeader;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement termsCheck;
	
	@FindBy(css="p.success.text-success")
	private WebElement successMessage;
	
	
	public NonMemberCreateProfile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 15);
		CommonUtility.waitForPageLoadNew(driver, btnCreateProfile, 15);
	}
	
	/**
	 * Create a Profile with the details
	 * @param details
	 * @return
	 */
	public VPPPlanSummaryPage createProfile(DataTable details) {
		
		List<DataTableRow> givenAttributesRow = details.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String emailID = givenAttributesMap.get("Email");
		
		String DOB = givenAttributesMap.get("DOB");
		
		String gender = givenAttributesMap.get("Gender");
		
		String zipcode = givenAttributesMap.get("Zipcode");
		
		String fname = givenAttributesMap.get("First Name");
		
		String lname = givenAttributesMap.get("Last Name");
		
		try {
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
			sendkeys(visitorEmail, emailID);
			sendkeys(firstName, fname);
			sendkeys(lastName, lname);
			sendkeys(dob, DOB);
			sendkeys(zipCode, zipcode);
			if(gender.equalsIgnoreCase("f"))
				female.click();
			else
				male.click();
			termsCheck.click();
			btnCreateProfile.click();
			waitforElementNew(progressBar);
			waitforElementNew(successMessage);
			switchToNewTab();
			Thread.sleep(15000);
			if(driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
				return new VPPPlanSummaryPage(driver);
			}else {
				System.out.println("Plan Summary page is not loaded");
				return null;
			}
		} catch (Exception e) {
			Assert.fail("###############Create A Profile Failed For NON MEMBER###############");
			return null;
		}
	}
}
