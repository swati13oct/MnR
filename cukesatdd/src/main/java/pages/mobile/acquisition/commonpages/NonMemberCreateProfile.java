package pages.mobile.acquisition.commonpages;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;


public class NonMemberCreateProfile extends UhcDriver {
	
	@FindBy(css = "#non-member-email")
	private WebElement visitorEmail;
	
	@FindBy(css = "#non-member-firstName")
	private WebElement firstName;
	
	@FindBy(id="non-member-lastName")
	private WebElement lastName;
	
	@FindBy(css = "#non-member-dob")
	private WebElement dob;
	
	@FindBy(xpath = "//label[@for='male']")
	private WebElement male;
	
	@FindBy(xpath = "//label[@for='female']")
	private WebElement female;
	
	@FindBy(css = "#zipCode")
	private WebElement zipCode;
	
	@FindBy(xpath = "//input[@id='zipCode']/following::button[contains(text(),'Profile')][1]")
	private WebElement btnCreateProfile;
	
	@FindBy(xpath="//div[contains(@class,'progress-bar')]")
	private WebElement progressBar;
	
	@FindBy(xpath = "//h5")
	private WebElement shopperProfileCreationHeader;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement termsCheck;
	
	@FindBy(css="p.success.text-success")
	private WebElement successMessage;
	
	@FindBy(css="div.modal-footer>button:first-child")
	private WebElement btnAgreeToConsent;
	
	@FindBy(css="div.modal-footer>button:last-child")
	private WebElement btnNoToConsent;
	
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
	public ComparePlansPage createProfile(HashMap<String, String> givenAttributesMap) {
		//Handled dataTable from step definition
		/*List<DataTableRow> givenAttributesRow = details.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String emailID = givenAttributesMap.get("Email");
		
		String DOB = givenAttributesMap.get("DOB");
		
		String gender = givenAttributesMap.get("Gender");
		
		String zipcode = givenAttributesMap.get("Zipcode");
		
		String fname = givenAttributesMap.get("First Name");
		
		String lname = givenAttributesMap.get("Last Name");
		
		String consent = givenAttributesMap.get("Consent");
		
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
			String winHandleBefore = driver.getWindowHandle();
			btnCreateProfile.click();
			CommonUtility.waitForPageLoadNew(driver, btnAgreeToConsent, 15);
			if(consent.equalsIgnoreCase("YES")) {
				termsCheck.click();
				btnAgreeToConsent.click();
			}
			else {
				btnNoToConsent.click();
				System.out.println("###############No Consent###############");
			}
			waitforElementNew(progressBar);
			waitforElementNew(successMessage);
			Thread.sleep(2000);
//			switchToNewTab();
			Set<String> tabs = driver.getWindowHandles();
			for(String tab : tabs) {
				if(!tab.equals(winHandleBefore)) {
					driver.switchTo().window(tab);
					break;
				}
			}
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(5000);
			if(driver.getCurrentUrl().contains("health-plans.html")) {
				return new ComparePlansPage(driver);
			}else {
				System.out.println("Compare Plans page is not loaded");
				return null;
			}
		} catch (Exception e) {
			Assert.fail("###############Create A Profile Failed For NON MEMBER###############");
			return null;
		}
	}
}
