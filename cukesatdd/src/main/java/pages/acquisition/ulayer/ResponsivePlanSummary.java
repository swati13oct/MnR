package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ResponsivePlanSummary extends UhcDriver{

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;
	
	public ResponsivePlanSummary(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		// ADD JSON Validation Path if required
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		// ADD elements that needed to validate
	}
	private JSONObject formJsonObject(PageData vppPlanSummary) {
		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(vppPlanSummary.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText().trim());
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
							jsonObjectForArray.put(vppPlanSummary.getExpectedData().get(key).getElementName(),
									element.getText().trim());
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
		return jsonObject;

}
	/*public JSONObject getPlanSummaryActualData(String planName) {
	String fileName = null;
	if (planName.contains("HMO")) {
		fileName = "maplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanElement);
		return jsonObject;

	}
	if (planName.contains("PDP")) {
		fileName = "pdpplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName, pdpPlanElement);
		return jsonObject;
	}
	if (planName.contains("Regional PPO")) {
		fileName = "mamultistateplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanElement);
		return jsonObject;

	}

	return null;
}*/

private JSONObject getActualJsonObject(String fileName, String planName, List<WebElement> planElement) {
	vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
	for (WebElement plan : planElement) {
		if (plan.getText().contains(planName)) {

			JSONObject jsonObject = new JSONObject();
			for (String key : vppPlanSummary.getExpectedData().keySet()) {
				WebElement element = findChildElement(vppPlanSummary.getExpectedData().get(key), plan);
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			return jsonObject;

		}
	}
	return null;
}
}