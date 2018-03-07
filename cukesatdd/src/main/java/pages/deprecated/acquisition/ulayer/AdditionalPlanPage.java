package pages.deprecated.acquisition.ulayer;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class AdditionalPlanPage extends UhcDriver{

	@FindBy(id = "popupClose")
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
		sendkeysNew(memberId1, planIdArray[0]);
		if (planIdArray.length > 1) {
			sendkeysNew(memberId2, planIdArray[1]);
		}
		popupSubmitButton.click();
		try {
			if (popupSubmitButton.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, popupSubmitButton,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("popupSubmitButton not found");
		} catch (TimeoutException ex) {
			System.out.println("popupSubmitButton not found");
		} catch (Exception e) {
			System.out.println("popupSubmitButton not found");
		}

		if (getTitle().equalsIgnoreCase(
				"AARP Medicare Plans | Registration")) {
			return new PlanConfirmationPage(driver);
		}
		return null;

	}

	public CreateAccountPage addNoOtherPlan() {
		noOtherPlanToAddLink.click();
		ElementData elementData = new ElementData("tagName","h1");
		WebElement element = findElement(elementData);
		if (element.getText()
				.equalsIgnoreCase("Register for an Online Account")) {
			return new CreateAccountPage(driver);
		}
		return null;

	}
	
	@Override
	public void openAndValidate() {
		validateNew(noOtherPlanToAddLink);
		validateNew(memberId1);
		validateNew(memberId2);
		validateNew(popupSubmitButton);		
	}
}
