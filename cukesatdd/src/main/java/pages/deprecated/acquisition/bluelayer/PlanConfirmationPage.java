package pages.deprecated.acquisition.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
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
		ElementData elementData = new ElementData("tagName","h2");
		WebElement element = findElement(elementData);
		if (element.getText()
				.equalsIgnoreCase("Confirm information for additional plans")) {
			return new AdditionalPlanPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : planConfirmation.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planConfirmation
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validateNew(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validateNew(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(planConfirmation
									.getExpectedData().get(key)
									.getElementName(), element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		planConfirmationJson = jsonObject;
		
		System.out.println("planConfirmationJson----->"+planConfirmationJson);
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
