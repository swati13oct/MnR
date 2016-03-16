/**
 * 
 */
package pages.member.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
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
public class PlanSummaryPage extends UhcDriver {

	@FindBy(id = "addAnotherPlanLink")
	private WebElement addAnotherPlanLink;

	@FindBy(id = "main_content")
	private WebElement planSummarySuccess;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData planSummary;

	public JSONObject planSummaryJson;

	public PlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_SUMMARY_PAGE_DATA;
		planSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public AddPlanPopUpPage clickAddPlan() {
		addAnotherPlanLink.click();
		CommonUtility.checkPageIsReady(driver);
		return new AddPlanPopUpPage(driver);

	}

	public String getContent() {
		return planSummarySuccess.getText();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {
		validate(addAnotherPlanLink);
		validate(planSummarySuccess);
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : planSummary.getExpectedData().keySet()) {
			WebElement element = findElement(planSummary.getExpectedData().get(
					key));
			if(element !=null )
			{	
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		planSummaryJson = jsonObject;

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject planSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_SUMMARY);
		planSummaryExpectedJson = CommonUtility.mergeJson(
				planSummaryExpectedJson, globalExpectedJson);
		return planSummaryExpectedJson;

	}

}
