/**
 * 
 */
package pages.member.bluelayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.AddPlanPopUpPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PlanSummaryPage extends UhcDriver {

	@FindBy(id = "addAnotherPlanLink")
	private WebElement addAnotherPlanLink;
	
	@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div/div[2]/div/div[2]/div/h3")
	private WebElement planInformationHeading;
	
	@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div/div[3]/div/div[2]/div/h3")
	private WebElement claimSectionHeading;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div[160]/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div/p/a")
	private WebElement viewdetailbutton;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData planSummary;

	public JSONObject planSummaryJson;

	public PlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_SUMMARY_PAGE_DATA;
		CommonUtility.waitForPageLoad(driver, planInformationHeading,CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
		planSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public PlanSummaryPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_SUMMARY_PAGE_DATA;
		CommonUtility.waitForPageLoad(driver, planInformationHeading,CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
		planSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public AddPlanPopUpPage clickAddPlan() {
		addAnotherPlanLink.click();
		CommonUtility.checkPageIsReady(driver);
		return new AddPlanPopUpPage(driver);
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : planSummary.getExpectedData().keySet()) {

			WebElement element = findElement(planSummary.getExpectedData().get(
					key));
			if (element != null) {
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}

		}
		planSummaryJson = jsonObject;

		System.out.println("planSummaryJson----->"+planSummaryJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		/* get PLAN_SUMMARY expected data */
		JSONObject planSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_SUMMARY);
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		planSummaryExpectedJson = CommonUtility.mergeJson(
				planSummaryExpectedJson, globalExpectedJson);

		return planSummaryExpectedJson;
	}

	public DrugCostandBenefitSummaryPage navigateToViewDetails() {
		viewdetailbutton.click();
		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Medicare Solutions | Drug Cost and Benefits Summary")) {
			return new DrugCostandBenefitSummaryPage(driver);
		}
		return null;
		}

}
