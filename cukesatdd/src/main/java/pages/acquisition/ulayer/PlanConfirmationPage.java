package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
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
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
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
			List<WebElement> elements = findElements(planConfirmation
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
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

					if (validate(element)) {
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
	}

}
