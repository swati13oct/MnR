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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class DrugCostandBenefitSummaryPage extends UhcDriver {

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div[2]/div/h2")
	private WebElement drugCostHeading;;
	
	private PageData drugCostBenefitSummary;

	public JSONObject drugCostBenefitSummaryJson;

	public DrugCostandBenefitSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, drugCostHeading, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.DRUG_COST_BENEFIT_SUMMARY_PAGE_DATA;
		drugCostBenefitSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validate(logOut);
		validate(drugCostHeading);
		JSONObject jsonObject = new JSONObject();
		for (String key : drugCostBenefitSummary.getExpectedData().keySet()) {
			WebElement element = findElement(drugCostBenefitSummary
					.getExpectedData().get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		drugCostBenefitSummaryJson = jsonObject;
		
		System.out.println("drugCostBenefitSummaryJson----->"+drugCostBenefitSummaryJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject drugCostBenefitSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.DRUG_COST_BENEFIT_SUMMARY);
		drugCostBenefitSummaryExpectedJson = CommonUtility.mergeJson(
				drugCostBenefitSummaryExpectedJson, globalExpectedJson);
		return drugCostBenefitSummaryExpectedJson;
	}
}
