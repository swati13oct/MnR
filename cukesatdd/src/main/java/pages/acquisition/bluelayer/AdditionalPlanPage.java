package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class AdditionalPlanPage extends UhcDriver {

	@FindBy(linkText = "No other plans to add")
	private WebElement noOtherPlanToAddLink;

	@FindBy(id = "popupSubmit")
	private WebElement popupSubmitButton;
	
	@FindBy(xpath = "//tr[@id='contentRow']/td/div[2]/div[2]/div/div/div/div/form/div/div[2]/div[2]/div/div/h3")
	private WebElement planConformationHeader;
	
	@FindBy(id = "memberId1")
	private WebElement memberId1;

	@FindBy(id = "memberId2")
	private WebElement memberId2;

	public AdditionalPlanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PlanConfirmationPage addAnotherPlan(String addditionaPlanId) {

		String[] planIdArray = addditionaPlanId.split("-");
		sendkeys(memberId1, planIdArray[0]);
		if (planIdArray.length > 1) {
			sendkeys(memberId2, planIdArray[1]);
		}
		popupSubmitButton.click();
		/*CommonUtility.waitForPageLoad(driver, planConformationHeader);*/
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration"))
			return new PlanConfirmationPage(driver);
		return null;

	}

	public CreateAccountPage addNoOtherPlan() {
		noOtherPlanToAddLink.click();

		return new CreateAccountPage(driver);

	}

	@Override
	public void openAndValidate() {
		validate(noOtherPlanToAddLink);
		validate(memberId1);
		validate(memberId2);
		validate(popupSubmitButton);
	}
}
