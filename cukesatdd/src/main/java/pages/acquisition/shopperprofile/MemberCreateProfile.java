package pages.acquisition.shopperprofile;

import java.util.HashMap;
import java.util.Set;

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
	
	@FindBy(id = "member-email")
	private WebElement visitorEmail;
	
	@FindBy(id = "member-firstName")
	private WebElement firstName;
	
	@FindBy(id = "member-lastName")
	private WebElement lastName;
	
	@FindBy(id = "member-mbi")
	private WebElement mbi;
	
	@FindBy(id = "member-zipCode")
	private WebElement zipCode;
	
	@FindBy(id = "member-dob")
	private WebElement dob;
	
	@FindBy(xpath = "//input[@id='member-zipCode']/following::button[contains(text(),'Profile')][1]")
	private WebElement btnCreateProfile;
	
	@FindBy(xpath = "//h5")
	private WebElement shopperProfileCreationHeader;
	
	@FindBy(css="p.success.text-success")
	private WebElement successMessage;
	
	
	public MemberCreateProfile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 15);
		CommonUtility.waitForPageLoadNew(driver, mbi, 15);
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
		
		try {
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
			sendkeys(visitorEmail, emailID);
			sendkeys(firstName, fname);
			sendkeys(lastName, lname);
			sendkeys(dob, DOB);
			if(Strings.isNullOrEmpty(MBI))
				sendkeys(zipCode, zipcode);
			else {
				sendkeys(mbi, MBI);
				sendkeys(zipCode, zipcode);
			}
			String winHandleBefore = driver.getWindowHandle();
			btnCreateProfile.click();
			waitforElementNew(successMessage);
			Thread.sleep(2000);
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
