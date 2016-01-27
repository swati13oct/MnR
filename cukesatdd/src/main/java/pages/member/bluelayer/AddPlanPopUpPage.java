package pages.member.bluelayer;

/**
 * @author pagarwa5
 * 
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class AddPlanPopUpPage extends UhcDriver {

	@FindBy(id = "addPlanMemberId.id")
	private WebElement memberIdfield;

	@FindBy(id = "addPlanMemberId.extension")
	private WebElement memberIdExtensionfield;

	@FindBy(linkText = "continue")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@id='add_anotherplan']/div[2]/div/div[2]/div[2]/h3[2]")
	private WebElement addNewPlansHeading;
	
	@FindBy(xpath = "//div[@id='add_anotherplan']/div[2]/div/div[2]/div[2]/p[2]")
	private WebElement addNewPlansHeadingMessage;

	public AddPlanPopUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ConfirmPlanDetailsPage addNewPlan(String newPlanMemberId) {

		String[] memberIdArray = newPlanMemberId.split("-");
		sendkeys(memberIdfield, memberIdArray[0]);
		if (memberIdArray.length > 1) {
			sendkeys(memberIdExtensionfield, memberIdArray[1]);
		}

		continueButton.click();
		CommonUtility.waitForPageLoad(driver, addNewPlansHeading, CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, addNewPlansHeadingMessage, CommonConstants.TIMEOUT_30);
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Plan Summary")) {
			return new ConfirmPlanDetailsPage(driver);
		}

		return null;

	}

	@Override
	public void openAndValidate() {
		validate(memberIdfield);
		validate(memberIdExtensionfield);
		validate(continueButton);

	}

}
