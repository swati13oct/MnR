package pages.acquisition.ulayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class AdditionalPlanPage extends UhcDriver{

	@FindBy(xpath = "//*[contains(text(), 'no other plans to add')]")
	private WebElement noOtherPlanToAddLink;

	@FindBy(id = "popupSubmit")
	private WebElement popupSubmitButton;

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

		memberId1.click();
		memberId1.clear();
		memberId1.sendKeys(planIdArray[0]);
		if (planIdArray.length > 1) {
			memberId2.click();
			memberId2.clear();
			memberId2.sendKeys(planIdArray[1]);
		}
		popupSubmitButton.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Registration")) {
			return new PlanConfirmationPage(driver);
		}
		return null;

	}

	public CreateAccountPage addNoOtherPlan() {
		noOtherPlanToAddLink.click();
		if (driver.findElement(By.tagName("h1")).getText()
				.equalsIgnoreCase("Register for an Online Account")) {
			return new CreateAccountPage(driver);
		}
		return null;

	}
	
	@Override
	public void openAndValidate() {
		validate(noOtherPlanToAddLink);
		validate(memberId1);
		validate(memberId2);
		validate(popupSubmitButton);		
	}
}
