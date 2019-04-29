package pages.member_deprecated.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
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
public class ClaimSummaryPage extends UhcDriver {

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

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[3]/td[6]/form/input[12]")
	private WebElement claimDetail;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[7]/form/input[4]")
	private WebElement drugclaimDetail;

	@FindBy(xpath = "//div[@id='providercontainer']/select")
	private WebElement providerSearch;

	@FindBy(className = "claimssection")
	private WebElement claimsSection;

	@FindBy(id = "radioDrug")
	private WebElement radioDrug;

	private PageData claimsSummary;

	public JSONObject claimsSummaryJson;

	public ClaimSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, paymenthistorypage);
		String fileName = CommonConstants.DRUG_CLAIMS_SUMMARY_PAGE_DATA;
		claimsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public ClaimSummaryPage searchClaimsByPeriod(
			Map<String, String> timeAttributesMap, String businessType) {

		if (businessType.equalsIgnoreCase("GOVT")) {
			String claimPeriod = timeAttributesMap.get("Claim Period");
			searchRange.click();
			searchRange.sendKeys(claimPeriod);
			CommonUtility.checkPageIsReady(driver);
			searchbutton.click();
		}

		if (businessType.equalsIgnoreCase("SHIP")) {
			String claimPeriod = timeAttributesMap.get("Claim Period");
			shipRange.click();
			shipRange.sendKeys(claimPeriod);
			CommonUtility.checkPageIsReady(driver); // need to wait for claims
			// to load up

			String providerName = timeAttributesMap.get("Provider Name");
			if (providerSearch.isDisplayed()) {
				providerSearch.click();
				providerSearch.sendKeys(providerName);
				CommonUtility.checkPageIsReady(driver);
			} else {
				System.out.println("No claims Displayed");
				return null;
			}
		}
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	public ClaimDetailsPage getClaimDetail(String businessType) {
		if (businessType.equalsIgnoreCase("GOVT")) {
			claimDetail.click();
		}
		if (businessType.equalsIgnoreCase("SHIP")) {
			shipclaimDetail.click();
		}

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Medical Details")) {
			return new ClaimDetailsPage(driver);
		}
		return null;

	}

	public DrugClaimDetailsPage getDrugClaimDetail() {

		drugclaimDetail.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Prescription Drug Details")) {
			return new DrugClaimDetailsPage(driver);
		}
		return null;

	}

	public String getClaimSummaryContent() {
		return claimsSection.getText();
	}

	public ClaimSummaryPage searchClaimsByTimeInterval(
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
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	public ClaimSummaryPage searchDrugClaimsByPeriod(String claimPeriod) {

		searchRange.click();
		searchRange.sendKeys(claimPeriod);

		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;

	}

	public ClaimSummaryPage searchDrugClaimsByTimeInterval(
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

		sendkeys(fromMonth,fromMonthInput);
		sendkeys(fromDay,fromDayInput);
		sendkeys(fromYear,fromYearInput);
		sendkeys(toMonth,toMonthInput);
		sendkeys(toDay,toDayInput);
		sendkeys(toYear,toYearInput);
		
		searchbutton.click();
		
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	public ClaimSummaryPage searchDrugClaimsByTimeInterval(
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
		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;

	}

	public ClaimSummaryPage searchDrugClaimsByPeriod(
			Map<String, String> timeAttributesMap, String planType) {

		if (planType.equalsIgnoreCase("MAPD")) {
			radioDrug.click(); // To select the drug claims radio button
		}

		String claimPeriod = timeAttributesMap.get("Claim Period");
		searchRange.click();
		searchRange.sendKeys(claimPeriod);

		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : claimsSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(claimsSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(claimsSummary.getExpectedData()
								.get(key).getElementName(), element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
		claimsSummaryJson = jsonObject;
		
		System.out.println("claimsSummaryJson----->"+claimsSummaryJson);

	}
	public JSONObject getExpectedData(Map<String,JSONObject> expectedDataMap,String claimPeriod) {
		
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject claimSummaryExpectedJson = null;
		if (claimPeriod.equalsIgnoreCase("Last 90 Days") || claimPeriod == null) {
			claimSummaryExpectedJson = expectedDataMap
					.get(CommonConstants.DRUG_CLAIMS_SUMMARY);
		}

		claimSummaryExpectedJson = CommonUtility.mergeJson(
				claimSummaryExpectedJson, globalExpectedJson);
		return claimSummaryExpectedJson;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		// TODO Auto-generated method stub
		return null;
	}

}