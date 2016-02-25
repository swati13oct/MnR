package pages.acquisition.bluelayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
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

	@FindBy(name = "continue")
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
		sendkeys(memberid1, memberIdArray[0]);
		if (memberIdArray.length > 1) {
			sendkeys(memberIdNumber2, memberIdArray[1]);
		}
		sendkeys(monthToEnter, month);
		sendkeys(dayToEnter, day);
		sendkeys(yearToEnter, year);
		continueButton.click();

		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration")) {
			return new PlanConfirmationPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(memberid1);
		validate(memberIdNumber2);
		validate(monthToEnter);
		validate(dayToEnter);
		validate(yearToEnter); {

	}


	
	
		
	}

	public AcquisitionHomePage switchBack() {
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			validate(registerHereLink);
			if(driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®"))
			{
				return new AcquisitionHomePage(driver);
			}
			return null;
		
	}
}
