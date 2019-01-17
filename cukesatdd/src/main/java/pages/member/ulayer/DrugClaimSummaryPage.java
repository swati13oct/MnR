package pages.member.ulayer;

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
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class DrugClaimSummaryPage extends UhcDriver {

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
	private List<WebElement> searchRangeList;

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



	@FindBy(id = "searchbutton")
	private WebElement searchbutton;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[8]/div/div[2]/div[2]/div[2]/div/div[2]/div[3]/div/div[3]/div")
	private WebElement shipsearchbutton;


	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[7]/form/input[4]")
	private WebElement drugclaimDetail;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[2]")
	private WebElement firstClaimRxNumber;

	@FindBy(xpath = "//div[@id='providercontainer']/select")
	private WebElement providerSearch;

	@FindBy(className = "claimssection")
	private WebElement claimsSection;



	@FindBy(id = "radioDrug")
	private WebElement radioDrug;
	
	@FindBy(xpath = ".//*[@id='columnsort0']/table/tbody/tr/td[1]/p/b")
	private WebElement dateFilled;
	
	@FindBy(xpath = ".//*[@id='columnsort1']/table/tbody/tr/td[1]/p/b")
	private WebElement rxNumber;
	
	@FindBy(xpath = ".//*[@id='columnsort2']/table/tbody/tr/td[1]/p/b")
	private WebElement medication;
	
	@FindBy(xpath = ".//*[@id='columnsort3']/table/tbody/tr/td[1]/p/b")
	private WebElement pharmacy;
	
	@FindBy(xpath = ".//*[@id='columnsort4']/table/tbody/tr/td[1]/p/b")
	private WebElement memberHasPaid;
	
	@FindBy(xpath = ".//*[@id='columnsort5']/table/tbody/tr/td[1]/p/b")
	private WebElement planHasPaid;
	
	@FindBy(xpath = ".//*[@id='columnsort5']/table/tbody/tr/td[1]/p/b")
	private WebElement otherPayments;
	
	@FindBy(xpath = ".//*[@id='searchResultMsg']/p")
	private WebElement searchResultMsg;

	private PageData drugClaimsSummary;

	public JSONObject drugClaimsSummaryJson;

	public DrugClaimSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO: Finally we should wait only for one element
		/*String fileName = CommonConstants.DRUG_CLAIMS_SUMMARY_PAGE_DATA;
		drugClaimsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();*/
	}

	/*
	 * public DrugClaimSummaryPage searchClaimsByPeriod( Map<String, String>
	 * timeAttributesMap, String businessType) {
	 * 
	 * if (businessType.equalsIgnoreCase("GOVT")) { String claimPeriod =
	 * timeAttributesMap.get("Claim Period"); searchRange.click();
	 * searchRange.sendKeys(claimPeriod);
	 * CommonUtility.checkPageIsReady(driver); searchbutton.click(); }
	 * 
	 * if (businessType.equalsIgnoreCase("SHIP")) { String claimPeriod =
	 * timeAttributesMap.get("Claim Period"); shipRange.click();
	 * shipRange.sendKeys(claimPeriod); CommonUtility.checkPageIsReady(driver);
	 * String providerName = timeAttributesMap.get("Provider Name"); if
	 * (providerSearch.isDisplayed()) { providerSearch.click();
	 * providerSearch.sendKeys(providerName);
	 * CommonUtility.checkPageIsReady(driver); } else {
	 * System.out.println("No claims Displayed"); return null; } }
	 * CommonUtility.checkPageIsReady(driver); if
	 * (driver.getTitle().equalsIgnoreCase("Claims")) { return new
	 * DrugClaimSummaryPage(driver); } return null; }
	 * 
	 * public ClaimDetailsPage getClaimDetail(String businessType) { if
	 * (businessType.equalsIgnoreCase("GOVT")) { claimDetail.click(); } if
	 * (businessType.equalsIgnoreCase("SHIP")) { shipclaimDetail.click(); }
	 * 
	 * CommonUtility.checkPageIsReady(driver); if
	 * (driver.getTitle().equalsIgnoreCase("Medical Details")) { return new
	 * ClaimDetailsPage(driver); } return null;
	 * 
	 * }
	 */

	public DrugClaimDetailsPage getDrugClaimDetail() {

		drugclaimDetail.click();
		if (driver.getTitle().equalsIgnoreCase("Prescription Drug Details")) {
			return new DrugClaimDetailsPage(driver);
		}
		return null;

	}

	public String getClaimSummaryContent() {
		return claimsSection.getText();
	}

	public DrugClaimSummaryPage searchClaimsByTimeInterval(
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
			CommonUtility.checkPageIsReady(driver);
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
			CommonUtility.checkPageIsReady(driver);

			String providerName = timeAttributesMap.get("Provider Name");
			if (providerSearch.isDisplayed()) {
				providerSearch.click();
				providerSearch.sendKeys(providerName);
				CommonUtility.checkPageIsReady(driver);
				shipsearchbutton.click();
				CommonUtility.checkPageIsReady(driver);
			} else {
				System.out.println("No claims Displayed");
				return null;
			}
		}

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;
	}

	public DrugClaimSummaryPage searchDrugClaimsByPeriod(String claimPeriod) {
		CommonUtility.waitForPageLoad(driver, searchbutton,CommonConstants.TIMEOUT_30);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectFromDropDown(searchRangeList, claimPeriod);
		searchbutton.click();
		
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;

	}

	public DrugClaimSummaryPage searchDrugClaimsByTimeInterval(String toDate,
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
		searchRange.sendKeys("Custom Search");

		sendkeys(fromMonth, fromMonthInput);
		sendkeys(fromDay, fromDayInput);
		sendkeys(fromYear, fromYearInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toYear, toYearInput);

		CommonUtility.waitForPageLoad(driver, searchbutton,CommonConstants.TIMEOUT_30);
		searchbutton.click();

		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;
	}

	public DrugClaimSummaryPage searchDrugClaimsByTimeInterval(String toDate,
			String fromDate, String planType) {

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
		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;

	}

	public DrugClaimSummaryPage searchDrugClaimsByPeriod(String claimPeriod,
			String planType) {

		if (planType.equalsIgnoreCase("MAPD")) {
			radioDrug.click(); // To select the drug claims radio button
		}
		searchRange.click();
		searchRange.sendKeys(claimPeriod);

		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;
	}

	public String getRxNumber() {
		return firstClaimRxNumber.getText();
	}

	@Override
	public void openAndValidate() {

		validate(firstClaimRxNumber);

		JSONObject jsonObject = new JSONObject();
		for (String key : drugClaimsSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(drugClaimsSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {
					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(drugClaimsSummary
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
		drugClaimsSummaryJson = jsonObject;
		
		System.out.println("drugClaimsSummaryJson----->"+drugClaimsSummaryJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String claimPeriod) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject drugClaimSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.DRUG_CLAIMS_SUMMARY);
		try {
			drugClaimSummaryExpectedJson = (JSONObject) drugClaimSummaryExpectedJson
					.get(claimPeriod);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		drugClaimSummaryExpectedJson = CommonUtility.mergeJson(
				drugClaimSummaryExpectedJson, globalExpectedJson);
		return drugClaimSummaryExpectedJson;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String toDate, String fromDate) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject claimSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.DRUG_CLAIMS_SUMMARY);
		String key = toDate + "_" + fromDate;
		try {
			claimSummaryExpectedJson = (JSONObject) claimSummaryExpectedJson
					.get(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		claimSummaryExpectedJson = CommonUtility.mergeJson(
				claimSummaryExpectedJson, globalExpectedJson);
		return claimSummaryExpectedJson;
	}
	
	public boolean validateRxClaims() {
		boolean flag = false;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(dateFilled)&&validate(rxNumber)&&validate(medication)&&validate(pharmacy)&&validate(memberHasPaid)
				&&validate(planHasPaid)&&validate(otherPayments)&&validate(searchResultMsg)){
			flag = true;
			
		}else
			System.out.println("Could not verify the Med Claims elements");
		return flag;
	}

}
