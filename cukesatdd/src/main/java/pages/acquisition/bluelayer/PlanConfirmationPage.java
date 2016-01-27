package pages.acquisition.bluelayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.AdditionalPlanPage;
import pages.acquisition.bluelayer.CreateAccountPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PlanConfirmationPage extends UhcDriver {

	@FindBy(name = "continue")
	private WebElement continueButton;

	private PageData planConfirmation;

	public JSONObject planConfirmationJson;

	public PlanConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_CONFIRMATION_PAGE_DATA;
		planConfirmation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public Object confirmPlan() {

		continueButton.click();
		
		if (currentUrl().contains("/confirmPlans")) {
			return new CreateAccountPage(driver);
		}
		if (driver.findElement(By.tagName("h2")).getText()
				.equalsIgnoreCase("Confirm information for additional plans")) {
			return new AdditionalPlanPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {

		validate(continueButton);

		JSONObject jsonObject = new JSONObject();
		for (String key : planConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(planConfirmation.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		planConfirmationJson = jsonObject;
	}
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject registrationCommonExpectedJson = expectedDataMap
				.get(CommonConstants.REGISTRATION_COMMON);
		JSONObject planConfirmationExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_CONFIRMATION);
		planConfirmationExpectedJson = CommonUtility.mergeJson(
				planConfirmationExpectedJson, registrationCommonExpectedJson);
		return planConfirmationExpectedJson;
	}

}
