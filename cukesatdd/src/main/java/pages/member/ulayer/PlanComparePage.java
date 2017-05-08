/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PlanComparePage extends UhcDriver {

	private PageData planCompare;

	public JSONObject planCompareJson;

	@FindBys(value = { @FindBy(xpath = "//ul[@class='mouseOverMenu']/li") })
	private List<WebElement> planSelectionOptions;

	@FindBy(className = "selectBg")
	private WebElement plansChoiceDropDown;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div[283]/div[2]/table/tbody/tr[41]/td[3]/a")
	private WebElement nextYearButton;
	
	public PlanComparePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_COMPARE_PAGE_DATA;
		planCompare = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(plansChoiceDropDown);

		JSONObject jsonObject = new JSONObject();
		JSONObject currentYearPlan = new JSONObject();
		JSONObject nextYearPlan = new JSONObject();
		JSONObject planSelected = new JSONObject();

		for (String key : planCompare.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planCompare
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

				try { 
					if (elements.get(1).getText() != null
							&& !(elements.get(1).getText().equalsIgnoreCase(""))) {
						currentYearPlan.put(key, elements.get(1).getText());
					}
					if (elements.get(2).getText() != null
							&& !(elements.get(2).getText().equalsIgnoreCase(""))) {
						nextYearPlan.put(key, elements.get(2).getText());
					}
					if (elements.get(3).getText() != null
							&& !(elements.get(3).getText().equalsIgnoreCase(""))) {
						planSelected.put(key, elements.get(3).getText());
					}
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		try {
			if (currentYearPlan != null) {
				jsonObject.put("currentYearPlan", currentYearPlan);
			}
			if (nextYearPlan != null) {
				jsonObject.put("nextYearPlan", nextYearPlan);
			}
			if (planSelected != null && planSelected.keys().hasNext()) {
				jsonObject.put("planSelected", planSelected);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		planCompareJson = jsonObject;

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String key) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject planCompareExpectedJson = null;
		try {
			planCompareExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.PLAN_COMPARE).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planCompareExpectedJson = CommonUtility.mergeJson(
				planCompareExpectedJson, globalExpectedJson);
		return planCompareExpectedJson;
	}

	public PlanComparePage selectsPlanFromChoices(String planName) {

		Actions builder = new Actions(driver);
		builder.moveToElement(plansChoiceDropDown).perform();

		for (WebElement element : planSelectionOptions) {

			if (element.getText().contains(planName)) {
				ElementData elementData = new ElementData("tagName", "c");
				builder.click(findChildElement(elementData, element)).perform();
				break;
			}

		}

		if (getTitle().equalsIgnoreCase("Compare 2017 Plans")) {
			return new PlanComparePage(driver);
		}
		return null;

	}

	public void logOut() {
		logOut.click();

	}

	public PlanCompareDetails selectNextYearPlan() {
		nextYearButton.click();
		
		if(getTitle().equalsIgnoreCase("Compare 2017 Plans"))
		{
			return new PlanCompareDetails(driver);
			
					}
		return null;
	}

}
