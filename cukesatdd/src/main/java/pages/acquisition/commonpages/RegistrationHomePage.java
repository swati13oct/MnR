package pages.acquisition.commonpages;

import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class RegistrationHomePage extends UhcDriver{

	@FindBy(id = "memberid1")
	private WebElement memberid1;

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

	private static String PAGE_URL = MRConstants.AARPM_REGISTRATION_URL;

	public RegistrationHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PlanConfirmationPage registerWith(String memberId, String dateOfbirth) {

		String[] memberIdArray = memberId.split("-");
		String[] doBArray = dateOfbirth.split("-");
		String month = doBArray[0];
		String day = doBArray[1];
		String year = doBArray[2];

		sendkeys(memberid1, memberIdArray[0]);
		if (memberIdArray.length > 1) {
			sendkeys(memberIdNumber2, memberIdArray[1]);
		}
		sendkeys(monthToEnter, month);
		sendkeys(dayToEnter, day);
		sendkeys(yearToEnter, year);

		continueButton.click();

		try {
			if (memberid1.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, memberid1,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("memberid1 not found");
		} catch (TimeoutException ex) {
			System.out.println("memberid1 not found");
		} catch (Exception e) {
			System.out.println("memberid1 not found");
		}

		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS))
			return new PlanConfirmationPage(driver);
		else
			return null;
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(memberid1);
		validate(memberIdNumber2);
		validate(monthToEnter);
		validate(dayToEnter);
		validate(yearToEnter);
		
	}

	public void switchBack() {		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	}
	
	public RegistrationAARPErrorPage navigateToErrorPage() {		
		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstants.ULAYER_AARP_MEDICARE_PLANS)) {
			return new RegistrationAARPErrorPage(driver);
		}
		return null;
	}
	
}
