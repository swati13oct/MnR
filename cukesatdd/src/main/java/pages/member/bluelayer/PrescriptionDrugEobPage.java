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
 * @author pperugu
 *
 */
public class PrescriptionDrugEobPage extends UhcDriver {

	@FindBy(id = "fromMonth")
	private WebElement fromMonth;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	@FindBy(id = "fromDay")
	private WebElement fromDay;

	@FindBy(id = "fromYear")
	private WebElement fromYear;

	@FindBy(id = "toMonth")
	private WebElement toMonth;

	@FindBy(id = "toDay")
	private WebElement toDay;

	@FindBy(id = "toYear")
	private WebElement toYear;

	@FindBy(className = "shipbtnEobHistory")
	private WebElement shipbtnEobHistory;

	@FindBy(id = "eobtable")
	private WebElement eobtable;

	private PageData prescriptionDrugEob;

	public JSONObject prescriptionDrugEobJson;

	public PrescriptionDrugEobPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PRESCRIPTION_DRUG_EOB_PAGE_DATA;
		prescriptionDrugEob = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public PrescriptionDrugEobPage searchesPresDrugEob(
			Map<String, String> dateAttributesMap) {

		String toDate = dateAttributesMap.get("To Date");
		String fromDate = dateAttributesMap.get("From Date");

		String[] fromDateArray = fromDate.split("-");
		String[] toDateArray = toDate.split("-");

		String fromMonthInput = fromDateArray[0];
		String fromDayInput = fromDateArray[1];
		String fromYearInput = fromDateArray[2];

		String toMonthInput = toDateArray[0];
		String toDayInput = toDateArray[1];
		String toYearInput = toDateArray[2];

		sendkeys(fromMonth, fromMonthInput);
		sendkeys(fromDay, fromDayInput);
		sendkeys(fromYear, fromYearInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toYear, toYearInput);

		shipbtnEobHistory.click();
		if (currentUrl().contains("part-d-eob-search.html")) {
			return new PrescriptionDrugEobPage(driver);
		}
		return null;

	}

	public String getPrescriptionDrugEobContent() {
		return eobtable.getText();
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : prescriptionDrugEob.getExpectedData().keySet()) {
			WebElement element = findElement(prescriptionDrugEob
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
		prescriptionDrugEobJson = jsonObject;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject prescriptionDrugEobExpectedJson = expectedDataMap
				.get(CommonConstants.PRESCRIPTION_DRUG_EOB);
		prescriptionDrugEobExpectedJson = CommonUtility.mergeJson(
				prescriptionDrugEobExpectedJson, globalExpectedJson);
		return prescriptionDrugEobExpectedJson;
	}

	public void logOut() {
		logOut.click();

	}

}
