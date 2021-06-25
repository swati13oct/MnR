package pages.acquisition.shopperprofile;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;

public class CloakProfile extends UhcDriver {

	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;

	@FindBy(id = "shopperZipCode")
	private WebElement zipcode;
	
	@FindBy(xpath = "//select[@id='residenceCounty']")
	private WebElement selectedResidenceCounty;

	@FindBy(id = "recordType")
	private WebElement consumerType;

	@FindBy(xpath = "//input[@id='no']/parent::label")
	private WebElement disableDataImportNo;

	@FindBy(id = "shopperFirstName")
	private WebElement firstName;

	@FindBy(id = "shopperlastName")
	private WebElement lastName;

	@FindBy(id = "shopperEmail")
	private WebElement email;

	@FindBy(id = "shopperDob")
	private WebElement dateOfBirth;

	@FindBy(id = "shopperProfileId")
	private WebElement uuid;

	@FindBy(id = "shopperMbi")
	private WebElement shopperMbi;

	@FindBy(xpath = "//button[contains(text(),'Cloak')]")
	private WebElement btnCloakIn;
	
	@FindBy(id = "aarpSVGLogo")
	public WebElement AARPlogo;

	public static final String DELETE_PROFILE_URL = "http://digital-checkout-team-e.ocp-elr-core-nonprod.optum.com/digital-checkout/guest/profile";

	public CloakProfile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, firstName, 45);
		CommonUtility.waitForPageLoadNew(driver, btnCloakIn, 45);
	}
	
	public String getText(WebElement element) {
		String text = String.valueOf(((JavascriptExecutor) driver).executeScript("return arguments[0].value;",element));
		return text;
	}

	public void validateCloakInForm(HashMap<String, String> userData) {
		String zipCode = userData.get("ZipCode");
		String county = userData.get("County");
		String consumerType = userData.get("Consumer Type");
		//String providers = givenAttributesMap.get("Providers");
		String fname = userData.get("First Name");
		String lname = userData.get("Last Name");
		String dob = userData.get("DOB");
		String mbi = userData.get("MBI");
		String emailID = userData.get("Email");
		String profileUUID = userData.get("Profile UUID");
		
		Assertion.assertEquals(zipCode, getText(zipcode));
		//Assertion.assertEquals(county, (new Select(selectedResidenceCounty).getFirstSelectedOption()));
		Assertion.assertEquals(fname.toLowerCase(), getText(firstName).toLowerCase());
		Assertion.assertEquals(lname.toLowerCase(), getText(lastName).toLowerCase());
		Assertion.assertEquals(dob, getText(dateOfBirth));
		Assertion.assertEquals(mbi, getText(shopperMbi));
		Assertion.assertEquals(emailID.toLowerCase(), getText(email).toLowerCase());
		Assertion.assertEquals(profileUUID, getText(uuid));
		
	}
	
	
	/**
	 * Cloak In the Searched Profile
	 * 
	 * @return
	 */
	public ComparePlansPage doCloakIn(HashMap<String, String> userData) {
		try {
			validateCloakInForm(userData);
			String winBeforeClick = driver.getWindowHandle();
			Thread.sleep(5000);
			btnCloakIn.click();
			Thread.sleep(15000);
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			for (String tab : tabs) {
				if (!tab.equals(winBeforeClick)) {
					driver.switchTo().window(tab);
					break;
				} else {
					driver.switchTo().window(tab).close();
				}
			}

			CommonUtility.checkPageIsReadyNew(driver);
			validateNew(AARPlogo);
			if (driver.getCurrentUrl().contains("health-plans.html")) {
				return new ComparePlansPage(driver);
			} else {
				System.out.println("Plan Compare page is not loaded");
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
