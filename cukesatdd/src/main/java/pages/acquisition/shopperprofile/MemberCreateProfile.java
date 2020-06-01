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

public class MemberCreateProfile extends UhcDriver {
	
	@FindBy(id = "member-email")
	private WebElement visitorEmail;
	
	@FindBy(id = "member-firstName")
	private WebElement firstName;
	
	@FindBy(id = "member-lastName")
	private WebElement lastName;
	
	@FindBy(id = "member-mbi")
	private WebElement mbi;
	
	@FindBy(id = "member-dob")
	private WebElement dob;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Member']//button[contains(text(),'Profile')]")
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
		CommonUtility.waitForPageLoadNew(driver, btnCreateProfile, 15);
	}
	
	public VPPPlanSummaryPage createProfile(DataTable details) {
		
		List<DataTableRow> givenAttributesRow = details.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String emailID = givenAttributesMap.get("Email");
		
		String DOB = givenAttributesMap.get("DOB");
		
		String MBI = givenAttributesMap.get("MBI");
		
		String fname = givenAttributesMap.get("First Name");
		
		String lname = givenAttributesMap.get("Last Name");
		
		try {
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
			sendkeys(visitorEmail, emailID);
			sendkeys(firstName, fname);
			sendkeys(lastName, lname);
			sendkeys(mbi, MBI);
			sendkeys(dob, DOB);
			btnCreateProfile.click();
			waitforElementNew(successMessage);
			switchToNewTab();
			CommonUtility.checkPageIsReadyNew(driver);
			if(driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
				return new VPPPlanSummaryPage(driver);
			}else {
				System.out.println("Plan Summary page is not loaded");
				return null;
			}
		} catch (Exception e) {
			Assert.fail("###############Create A Profile Failed###############");
			return null;
		}
	}
}
