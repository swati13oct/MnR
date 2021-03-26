package pages.mobile.acquisition.ulayer;

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
public class AdditionalPlanPageMobile extends UhcDriver{

	@FindBy(id = "popupClose")
	private WebElement noOtherPlanToAddLink;

	@FindBy(id = "popupSubmit")
	private WebElement popupSubmitButton;

	@FindBy(id = "memberId1")
	private WebElement memberId1;

	@FindBy(id = "memberId2")
	private WebElement memberId2;

	public AdditionalPlanPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PlanConfirmationPageMobile addAnotherPlan(String addditionaPlanId) {

		String[] planIdArray = addditionaPlanId.split("-");
		sendkeys(memberId1, planIdArray[0]);
		if (planIdArray.length > 1) {
			sendkeys(memberId2, planIdArray[1]);
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
				PageTitleConstantsMobile.ULAYER_AARP_MEDICARE_PLANS)) {
			return new PlanConfirmationPageMobile(driver);
		}
		return null;

	}

	public CreateAccountPageMobile addNoOtherPlan() {
		noOtherPlanToAddLink.click();
		ElementData elementData = new ElementData("tagName","h1");
		WebElement element = findElement(elementData);
		if (element.getText()
				.equalsIgnoreCase("Register for an Online Account")) {
			return new CreateAccountPageMobile(driver);
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
