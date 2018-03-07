package pages.deprecated.acquisition.bluelayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class RegistrationHomePage extends UhcDriver {



	@FindBy(id = "memberid1")
	private WebElement memberid1;
	
	@FindBy(xpath = "//div[@class='menu-dropdown active']/div[2]/div/span[2]/a")
	private WebElement registerHereLink;

	@FindBy(name = "memberIdNumber2")
	private WebElement memberIdNumber2;

	@FindBy(id = "month")
	private WebElement monthToEnter;

	@FindBy(id = "day")
	private WebElement dayToEnter;

	@FindBy(id = "year")
	private WebElement yearToEnter;

	@FindBy(className = "shipcontinue_btn")
	private WebElement continueButton;

	private static String PAGE_URL = MRConstants.UHCM_REGISTRATION_URL;

	public RegistrationHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PlanConfirmationPage registerWith(String memberId, String dateOfbirth) {

		String[] memberIdArray = memberId.split("-");
		String[] dobArray = dateOfbirth.split("-");
		String month = dobArray[0];
		String day = dobArray[1];
		String year = dobArray[2];
		sendkeysNew(memberid1, memberIdArray[0]);
		if (memberIdArray.length > 1) {
			sendkeysNew(memberIdNumber2, memberIdArray[1]);
		}
		sendkeysNew(monthToEnter, month);
		sendkeysNew(dayToEnter, day);
		sendkeysNew(yearToEnter, year);
		continueButton.click();

		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration")) {
			return new PlanConfirmationPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		startNew(PAGE_URL);
		validateNew(memberid1);
		validateNew(memberIdNumber2);
		validateNew(monthToEnter);
		validateNew(dayToEnter);
		validateNew(yearToEnter); {
		validateNew(continueButton);

	}


	
	
		
	}

	public RegistrationUMSErrorPage navigateToErrorPage() {		
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration")) {
			return new RegistrationUMSErrorPage(driver);
		}
		return null;
	}
	/*TODO:sseetala Please check if this method is required. Unable to find references in the codebase*/
	public AcquisitionHomePage switchBack() {
		
		/*----------Start---------
		 * TODO:sseetala Please create a method in UhcDriver class for the below selenium operation/command and consume it here
		 * 
		 * */
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			
			/*-----------end--------------*/
			validateNew(registerHereLink);
			if(getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®"))
			{
				return new AcquisitionHomePage(driver);
			}
			return null;
		
	}
}
