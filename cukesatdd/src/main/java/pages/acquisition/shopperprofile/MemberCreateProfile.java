package pages.acquisition.shopperprofile;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;


public class MemberCreateProfile extends UhcDriver {
	
	@FindBy(id = "shopperZipCode")
	private WebElement shopperZipcode;
	
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
	
	@FindBy(xpath = "//input[@id='shopperZipCode']/following::button[contains(text(),'Profile')][1]")
	private WebElement btnCreateProfile;
	
	@FindBy(xpath = "//h5")
	private WebElement shopperProfileCreationHeader;
	
	@FindBy(xpath="//div[@role='alertdialog']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//span[text()='Male']/parent::label")
	private WebElement genderMale;
	
	@FindBy(xpath = "//span[text()='Female']/parent::label")
	private WebElement genderFeMale;
	
	public MemberCreateProfile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, email, 15);
		CommonUtility.waitForPageLoadNew(driver, shopperMbi, 15);
		//CommonUtility.waitForPageLoadNew(driver, btnCreateProfile, 15);
	}
	
	public ComparePlansPage createProfile(HashMap<String, String> givenAttributesMap) {
		
		//Handled data table in step definition
		/*List<DataTableRow> givenAttributesRow = details.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String emailID = givenAttributesMap.get("Email");
		
		String DOB = givenAttributesMap.get("DOB");
		
		String MBI = givenAttributesMap.get("MBI");
		
		String fname = givenAttributesMap.get("First Name");
		
		String lname = givenAttributesMap.get("Last Name");
		
		String zipcode = givenAttributesMap.get("Zipcode");
		
		String gender = givenAttributesMap.get("Gender");
		
		try {
			CommonUtility.waitForPageLoadNew(driver, email, 20);
			sendkeys(email, emailID);
			sendkeys(firstName, fname);
			sendkeys(lastName, lname);
			sendkeys(dateOfBirth, DOB);
			sendkeys(shopperZipcode, zipcode);
			if(Strings.isNullOrEmpty(MBI)) {
				System.out.println("Creating a Non member");
				if(gender.equalsIgnoreCase("male"))
					genderMale.click();
				else
					genderFeMale.click();
			}else {
				sendkeys(shopperMbi, MBI);
				selectFromDropDownByText(driver, consumerType, "Member");
				genderMale.click();
			}
			
			String winHandleBefore = driver.getWindowHandle();
			/* btnCreateProfile.click(); */
			scrollToView(btnCreateProfile);
			jsClickNew(driver.findElement(By.xpath("//input[@id='shopperZipCode']/following::button[contains(text(),'Profile')][1]")));
			waitforElementNew(successMessage);
			sleepBySec(10);
			Set<String> tabs = driver.getWindowHandles();
			for(String tab : tabs) {
				if(!tab.equals(winHandleBefore)) {
					driver.switchTo().window(tab);
					break;
				}
			}
			CommonUtility.checkPageIsReadyNew(driver);
			if(driver.getCurrentUrl().contains("health-plans.html")) {
				return new ComparePlansPage(driver);
			}else {
				System.out.println("Plan Compare page is not loaded");
				return null;
			}
		} catch (Exception e) {
			Assert.fail("###############Create A Profile Failed###############");
			return null;
		}
	}
}
