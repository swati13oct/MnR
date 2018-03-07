/**
 * 
 */
package pages.deprecated.member.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PrescriptionDrugEobPage extends UhcDriver{
	
	@FindBy(id = "fromMonth")
	private WebElement fromMonth;

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
	
	@FindBy(xpath = "//div[@class='eobCntMidBg']/h3")
	private WebElement drugEobHeading;
	
	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath = ".//*[@id='eobSearchForm']/div[2]/div[2]/div[2]/table")
	private WebElement eobTable;
	
	private PageData prescriptionDrugEob;

	public JSONObject prescriptionDrugEobJson;

	public PrescriptionDrugEobPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoadNew(driver, drugEobHeading, CommonConstants.TIMEOUT_30);
	}

	
	public PrescriptionDrugEobPage searchesPresDrugEob(Map<String, String> dateAttributesMap) {
		
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
		
		fromMonth.click();
		fromMonth.clear();
		fromMonth.sendKeys(fromMonthInput);

		fromDay.click();
		fromDay.clear();
		fromDay.sendKeys(fromDayInput);

		fromYear.click();
		fromYear.clear();
		fromYear.sendKeys(fromYearInput);

		toMonth.click();
		toMonth.clear();
		toMonth.sendKeys(toMonthInput);

		toDay.click();
		toDay.clear();
		toDay.sendKeys(toDayInput);

		toYear.click();
		toYear.clear();
		toYear.sendKeys(toYearInput);
		
		shipbtnEobHistory.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (currentUrl().contains("part-d-eob-search.html")) {
			return new PrescriptionDrugEobPage(driver);
		}
		return null;
		
	}

	public String getPrescriptionDrugEobContent() {
		return eobTable.getText();
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

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : prescriptionDrugEob.getExpectedData().keySet()) {
			WebElement element = findElement(prescriptionDrugEob.getExpectedData()
					.get(key));
			if (element != null) {
				validateNew(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		prescriptionDrugEobJson = jsonObject;
		
		System.out.println("prescriptionDrugEobJson----->"+prescriptionDrugEobJson);
	}

	public boolean validateRxEob(){
		CommonUtility.waitForPageLoadNew(driver, eobTable, 20);
		if(eobTable.getText().contains("EOB Date")&&eobTable.getText().contains("My EOB Statements")&&
				eobTable.getText().contains("Download EOB (PDF)"))
			return true;
		return false;
	}
	
	public void logOut() {
		logOut.click();

	}
}
