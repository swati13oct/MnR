package pages.acquisition.shopperprofile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class DeleteProfile extends UhcDriver {
	
	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;
	
	@FindBy(id = "mbi")
	private WebElement mbi;
	
	@FindBy(id = "dob")
	private WebElement dob;
	
	@FindBy(xpath="//button[text()='Delete']")
	private WebElement btnDelete;

	@FindBy(xpath="//button/preceding-sibling::p")
	private WebElement deletedMessage;
	
	@FindBy(xpath="//a[text()='Non Member']")
	private WebElement nonMemberTab;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//app-tab[@tabtitle='Non Member']//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//app-tab[@tabtitle='Non Member']//input[@id='dob']")
	private WebElement dobNonMember;
	
	@FindBy(xpath="//app-tab[@tabtitle='Non Member']//button")
	private WebElement btnDeleteNonMember;
	
	@FindBy(xpath = "//button")
	private WebElement btnSearchShopper;
	
	@FindAll({@FindBy(xpath = "//table/tbody/tr")})
	private List<WebElement> searchResults;
	
	@FindBy(css="p.failure.text-danger")
	private WebElement messageNoUserFound;
	
	public static final String DELETE_PROFILE_URL = "https://www.team-e-aarpmedicareplans.ocp-elr-core-nonprod.optum.com/admin/shopper-profile.html/delete-profile";
	
	public static final String DELETE_PROFILE_URL_STAGE = "https://stage-generic.uhc.com/admin/shopper-profile.html/delete-profile";
	
	public DeleteProfile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline")) {
		}
		else if (MRScenario.environment.equals("stage")) {
			start(DELETE_PROFILE_URL_STAGE);
		}else {
			start(DELETE_PROFILE_URL);
		}

		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 15);
	}
	
	/**
	 * Delete a profile using email,dob and MBI
	 * @param emailID
	 * @param dateOfBirth
	 * @param MBI
	 */
	public void deleteAProfile(String emailID) {
		try {
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 20);
			sendkeys(visitorEmail, emailID);
			btnSearchShopper.click();
			if(searchResults.size()>0) {
				btnDelete.click();
				CommonUtility.waitForPageLoadNew(driver, messageNoUserFound, 15);
				System.out.println("##################"+"Deleted user "+emailID+" ##################");
			}
			else
				System.out.println("##################"+messageNoUserFound.getText().trim()+"##################");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete a non member profile using email,dob,fname and lname
	 * @param emailID
	 * @param dateOfBirth
	 * @param fname
	 * @param lname
	 */
	public void deleteANonMemberProfile(String emailID, String dateOfBirth, String fname,String lname) {
		try {
			nonMemberTab.click();
			sendkeys(visitorEmail, emailID);
			sendkeys(dobNonMember, dateOfBirth);
			sendkeys(firstName, fname);
			sendkeys(lastName, lname);
			btnDeleteNonMember.click();
			CommonUtility.waitForPageLoadNew(driver, deletedMessage, 15);
			System.out.println("##################"+deletedMessage.getText().trim()+"##################");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
