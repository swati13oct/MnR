package pages.deprecated.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.memberrdesignVBF.claims.ClaimsCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class MedicalClaimSummaryPage extends UhcDriver {

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

	@FindBy(id = "searchRange")
	private WebElement searchRange;

	@FindBys(value = { @FindBy(xpath = "//select[@id='searchRange']/option") })
	private List<WebElement> dropDownValue;

	@FindBy(id = "shipfromMonth")
	private WebElement shipfromMonth;

	@FindBy(id = "shipfromDay")
	private WebElement shipfromDay;

	@FindBy(id = "shipfromYear")
	private WebElement shipfromYear;

	@FindBy(id = "shiptoMonth")
	private WebElement shiptoMonth;

	@FindBy(id = "shiptoDay")
	private WebElement shiptoDay;

	@FindBy(id = "shiptoYear")
	private WebElement shiptoYear;

	@FindBy(id = "shipRange")
	private WebElement shipRange;

	@FindBy(id = "searchbutton")
	private WebElement searchbutton;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[8]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div")
	private WebElement shipsearchbutton;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[8]/form/input[4]")
	private WebElement shipclaimDetail;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[6]/form/input[12]")
	private WebElement claimDetail;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[7]/form/input[4]")
	private WebElement drugclaimDetail;

	@FindBy(xpath = "//div[@id='providercontainer']/select")
	private WebElement providerSearch;

	@FindBy(className = "claimssection")
	private WebElement claimsSection;

	@FindBy(id = "searchResultMsg")
	private WebElement searchResultMessage;

	@FindBy(id = "customResultMsg")
	private WebElement customResultMessage;

	@FindBy(id = "noClaimsFoundMsg")
	private WebElement noClaimsFoundMessage;

	@FindBy(id = "radioDrug")
	private WebElement radioDrug;
	
	@FindBy(xpath = ".//*[@id='columnsort0']/table/tbody/tr/td[1]/p/b")
	private WebElement serviceDate;
	
	@FindBy(xpath = ".//*[@id='columnsort1']/table/tbody/tr/td[1]/p/b")
	private WebElement providerName;
	
	@FindBy(xpath = ".//*[@id='columnsort2']/table/tbody/tr/td[1]/p/b")
	private WebElement claimType;
	
	@FindBy(xpath = ".//*[@id='columnsort3']/table/tbody/tr/td[1]/p/b")
	private WebElement charged;
	
	@FindBy(xpath = ".//*[@id='columnsort4']/table/tbody/tr/td[1]/p/b")
	private WebElement claimStatus;
	
	@FindBy(xpath = ".//*[@id='columnsort5']/table/tbody/tr/td[1]/p/b")
	private WebElement claimDetails;
	
	@FindBy(xpath = ".//*[@id='claim']/tbody/tr[2]/td[6]/form/input[12]")
	private WebElement moreInfoLink1;
	
	@FindBy(xpath = ".//*[@id='searchResultMsg']/p")
	private WebElement searchResultMsg;

	private PageData medicalClaimsSummary;

	public JSONObject medicalClaimsSummaryJson;

	public MedicalClaimSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	/*	CommonUtility.waitForPageLoad(driver, searchResultMessage, CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, customResultMessage, CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, noClaimsFoundMessage, CommonConstants.TIMEOUT_30);*/
		String fileName = CommonConstants.MEDICAL_CLAIMS_SUMMARY_PAGE_DATA;
		medicalClaimsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public MedicalClaimSummaryPage searchClaimsByPeriod(
			Map<String, String> timeAttributesMap, String businessType) {

		if (businessType.equalsIgnoreCase("GOVT")) {
			String claimPeriod = timeAttributesMap.get("Claim Period");
			searchRange.click();
			searchRange.sendKeys(claimPeriod);
			CommonUtility.checkPageIsReadyNew(driver);
			searchbutton.click();
		}

		if (businessType.equalsIgnoreCase("SHIP")) {
			String claimPeriod = timeAttributesMap.get("Claim Period");
			shipRange.click();
			shipRange.sendKeys(claimPeriod);
			CommonUtility.checkPageIsReadyNew(driver); // need to wait for claims
			// to load up

			String providerName = timeAttributesMap.get("Provider Name");
			if (providerSearch.isDisplayed()) {
				providerSearch.click();
				providerSearch.sendKeys(providerName);
				CommonUtility.checkPageIsReadyNew(driver);
			} else {
				System.out.println("No claims Displayed");
				return null;
			}
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	public MedicalClaimDetailsPage getClaimDetail(String businessType) {
		if (businessType.equalsIgnoreCase("GOVT")) {
			claimDetail.click();
		}
		if (businessType.equalsIgnoreCase("SHIP")) {
			shipclaimDetail.click();
		}

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Medical Details")) {
			return new MedicalClaimDetailsPage(driver);
		}
		return null;

	}

	public DrugClaimDetailsPage getDrugClaimDetail() {

		drugclaimDetail.click();

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Prescription Drug Details")) {
			return new DrugClaimDetailsPage(driver);
		}
		return null;

	}

	public String getClaimSummaryContent() {
		return claimsSection.getText();
	}

	public MedicalClaimSummaryPage searchClaimsByTimeInterval(
			Map<String, String> timeAttributesMap, String businessType) {

		String toDate = timeAttributesMap.get("Claims To Date");
		String fromDate = timeAttributesMap.get("Claims From Date");

		String[] fromDateArray = fromDate.split("-");
		String[] toDateArray = toDate.split("-");

		String fromMonthInput = fromDateArray[0];
		String fromDayInput = fromDateArray[1];
		String fromYearInput = fromDateArray[2];

		String toMonthInput = toDateArray[0];
		String toDayInput = toDateArray[1];
		String toYearInput = toDateArray[2];

		if (businessType.equalsIgnoreCase("GOVT")) {
			searchRange.click();
			searchRange.sendKeys("Custom Search");

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
			CommonUtility.checkPageIsReadyNew(driver);
			searchbutton.click();

		}

		if (businessType.equalsIgnoreCase("SHIP")) {
			searchRange.click();
			searchRange.sendKeys("Custom Search");

			shipfromMonth.click();
			shipfromMonth.clear();
			shipfromMonth.sendKeys(fromMonthInput);

			shipfromDay.click();
			shipfromDay.clear();
			shipfromDay.sendKeys(fromDayInput);

			shipfromYear.click();
			shipfromYear.clear();
			shipfromYear.sendKeys(fromYearInput);

			shiptoMonth.click();
			shiptoMonth.clear();
			shiptoMonth.sendKeys(toMonthInput);

			shiptoDay.click();
			shiptoDay.clear();
			shiptoDay.sendKeys(toDayInput);

			shiptoYear.click();
			shiptoYear.clear();
			shiptoYear.sendKeys(toYearInput);
			CommonUtility.checkPageIsReadyNew(driver);

			String providerName = timeAttributesMap.get("Provider Name");
			if (providerSearch.isDisplayed()) {
				providerSearch.click();
				providerSearch.sendKeys(providerName);
				CommonUtility.checkPageIsReadyNew(driver);
				shipsearchbutton.click();
				CommonUtility.checkPageIsReadyNew(driver);
			} else {
				System.out.println("No claims Displayed");
				return null;
			}
		}

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	public MedicalClaimSummaryPage searchDrugClaimsByPeriod(String claimPeriod) {

		searchRange.click();
		searchRange.sendKeys(claimPeriod);

		CommonUtility.checkPageIsReadyNew(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;

	}

	public MedicalClaimSummaryPage searchDrugClaimsByTimeInterval(
			Map<String, String> timeAttributesMap) {

		String toDate = timeAttributesMap.get("Claims To Date");
		String fromDate = timeAttributesMap.get("Claims From Date");

		String[] fromDateArray = fromDate.split("-");
		String[] toDateArray = toDate.split("-");

		String fromMonthInput = fromDateArray[0];
		String fromDayInput = fromDateArray[1];
		String fromYearInput = fromDateArray[2];

		String toMonthInput = toDateArray[0];
		String toDayInput = toDateArray[1];
		String toYearInput = toDateArray[2];

		searchRange.click();
		searchRange.sendKeys("Custom Search");

		sendkeysNew(fromMonth, fromMonthInput);
		sendkeysNew(fromDay, fromDayInput);
		sendkeysNew(fromYear, fromYearInput);
		sendkeysNew(toMonth, toMonthInput);
		sendkeysNew(toDay, toDayInput);
		sendkeysNew(toYear, toYearInput);

		searchbutton.click();

		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	public MedicalClaimSummaryPage searchDrugClaimsByTimeInterval(
			Map<String, String> timeAttributesMap, String planType) {

		String toDate = timeAttributesMap.get("Claims To Date");
		String fromDate = timeAttributesMap.get("Claims From Date");

		String[] fromDateArray = fromDate.split("-");
		String[] toDateArray = toDate.split("-");

		String fromMonthInput = fromDateArray[0];
		String fromDayInput = fromDateArray[1];
		String fromYearInput = fromDateArray[2];

		String toMonthInput = toDateArray[0];
		String toDayInput = toDateArray[1];
		String toYearInput = toDateArray[2];

		if (planType.equalsIgnoreCase("MAPD")) {
			radioDrug.click(); // To select the drug claims radio button
		}

		searchRange.click();
		searchRange.sendKeys("Custom Search");

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
		CommonUtility.checkPageIsReadyNew(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;

	}

	public MedicalClaimSummaryPage searchDrugClaimsByPeriod(
			Map<String, String> timeAttributesMap, String planType) {

		if (planType.equalsIgnoreCase("MAPD")) {
			radioDrug.click(); // To select the drug claims radio button
		}

		String claimPeriod = timeAttributesMap.get("Claim Period");
		searchRange.click();
		searchRange.sendKeys(claimPeriod);

		CommonUtility.checkPageIsReadyNew(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	/* Below methods used for GOVT only members */
	public MedicalClaimSummaryPage searchClaimsByPeriod(String claimPeriod) {

		searchRange.click();
		searchRange.sendKeys(claimPeriod);
		CommonUtility.waitForPageLoadNew(driver, searchbutton, CommonConstants.TIMEOUT_30);
		searchbutton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	public MedicalClaimSummaryPage searchClaimsByTimeInterval(String toDate,
			String fromDate) {

		String[] fromDateArray = fromDate.split("-");
		String[] toDateArray = toDate.split("-");

		String fromMonthInput = fromDateArray[0];
		String fromDayInput = fromDateArray[1];
		String fromYearInput = fromDateArray[2];

		String toMonthInput = toDateArray[0];
		String toDayInput = toDateArray[1];
		String toYearInput = toDateArray[2];

		searchRange.click();
		for (WebElement value : dropDownValue) {
			if (value.getText().equalsIgnoreCase(
					ClaimsCommonConstants.CUSTOM_SEARCH)) {
				value.click();
			}
		}
		sendkeysNew(fromMonth, fromMonthInput);
		sendkeysNew(fromDay, fromDayInput);
		sendkeysNew(fromYear, fromYearInput);
		sendkeysNew(toMonth, toMonthInput);
		sendkeysNew(toDay, toDayInput);
		sendkeysNew(toYear, toYearInput);
		CommonUtility.waitForPageLoadNew(driver, searchbutton, CommonConstants.TIMEOUT_30);
		searchbutton.click();

		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : medicalClaimsSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(medicalClaimsSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validateNew(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validateNew(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(medicalClaimsSummary
								.getExpectedData().get(key).getElementName(),
								element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}

		}
		medicalClaimsSummaryJson = jsonObject;
		System.out.println("medicalClaimsSummaryJson----->"+medicalClaimsSummaryJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String claimPeriod) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject medicalClaimSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.MEDICAL_CLAIMS_SUMMARY);
		try {
			medicalClaimSummaryExpectedJson = (JSONObject) medicalClaimSummaryExpectedJson
					.get(claimPeriod);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		medicalClaimSummaryExpectedJson = CommonUtility.mergeJson(
				medicalClaimSummaryExpectedJson, globalExpectedJson);
		return medicalClaimSummaryExpectedJson;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String toDate, String fromDate) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject medicalClaimSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.MEDICAL_CLAIMS_SUMMARY);
		String key = toDate + "_" + fromDate;
		try {
			medicalClaimSummaryExpectedJson = (JSONObject) medicalClaimSummaryExpectedJson
					.get(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		medicalClaimSummaryExpectedJson = CommonUtility.mergeJson(
				medicalClaimSummaryExpectedJson, globalExpectedJson);
		return medicalClaimSummaryExpectedJson;

	}

	public MedicalClaimDetailsPage getClaimDetail() {

		claimDetail.click();
		if (driver.getTitle().equalsIgnoreCase("Medical Details")) {
			return new MedicalClaimDetailsPage(driver);
		}
		return null;
	}

	public String getRxNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean validateClaims(){
		boolean flag = false;
		CommonUtility.waitForPageLoadNew(driver, searchResultMsg, CommonConstants.TIMEOUT_30);
		if(validateNew(serviceDate)&&validateNew(providerName)&&validateNew(claimType)&&validateNew(charged)&&validateNew(claimStatus)
				&&validateNew(claimDetails)&&validateNew(moreInfoLink1)&&validateNew(searchResultMsg)){
			flag = true;
			
		}else
			System.out.println("Could not verify the Med Claims elements");
		return flag;
	}
}
