package pages.member.bluelayer;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.JSONArray;
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
public class ClaimSummaryPage extends UhcDriver {

	@FindBy(id = "fromMonth")
	private WebElement fromMonth;
	
	@FindBy(linkText = "add plan")
	private WebElement addaplanlink;

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

	@FindBy(id = "searchbutton")
	private WebElement showClaimHistoryButton;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[6]/form/input[12]")
	private WebElement claimDetail;

	@FindBy(xpath = "//div[@id='providercontainer']/select")
	private WebElement providerSearch;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[2]/td[7]/form/input[4]")
	private WebElement drugclaimDetail;

	@FindBy(className = "claimssection")
	private WebElement claimssection;

	@FindBy(id = "radioDrug")
	private WebElement radioDrug;
	
	@FindBy(xpath = "//p[@id='linktodrugcostbenefit']/p/a")
	private WebElement linkexistense;
	
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


	private PageData claimsSummary;

	public JSONObject claimSummaryJson;

	public ClaimSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		//CommonUtility.waitForPageLoad(driver, showClaimHistoryButton,30);

		String fileName = CommonConstants.CLAIM_SUMMARY_PAGE_DATA;
		claimsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public ClaimSummaryPage(WebDriver driver, String planCategory) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, showClaimHistoryButton, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.CLAIM_SUMMARY_INDIVIDUAL_PAGE_DATA;
		claimsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public ClaimSummaryPage searchClaimsByPeriod(
			Map<String, String> timeAttributesMap) {

		String claimPeriod = timeAttributesMap.get("Claim Period");
		select(searchRange, claimPeriod);
		CommonUtility.waitForPageLoad(driver, showClaimHistoryButton, 30);
		showClaimHistoryButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	public ClaimSummaryPage searchDrugClaimsByPeriod(
			Map<String, String> timeAttributesMap) {

		String claimPeriod = timeAttributesMap.get("Claim Period");
		searchRange.click();
		searchRange.sendKeys(claimPeriod);

		CommonUtility.checkPageIsReady(driver);
		showClaimHistoryButton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	public ClaimDetailsPage getClaimDetail() {

		claimDetail.click();

		CommonUtility.checkPageIsReady(driver);
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Medical Claim Detail")) {

			return new ClaimDetailsPage(driver);

		}
		return null;

	}

	public String getClaimSummaryContent() {
		return claimssection.getText();
	}

	public ClaimSummaryPage searchClaimsByTimeInterval(
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

		sendkeys(fromMonth, fromMonthInput);
		sendkeys(fromDay, fromDayInput);
		sendkeys(fromYear, fromYearInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toYear, toYearInput);

		CommonUtility.checkPageIsReady(driver);
		showClaimHistoryButton.click();

		CommonUtility.checkPageIsReady(driver);
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
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

		sendkeys(fromMonth, fromMonthInput);
		sendkeys(fromDay, fromDayInput);
		sendkeys(fromYear, fromYearInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toYear, toYearInput);
		CommonUtility.checkPageIsReady(driver);
		showClaimHistoryButton.click();

		CommonUtility.checkPageIsReady(driver);
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}

	public ClaimSummaryPage searchDrugClaimsByPeriod(
			Map<String, String> timeAttributesMap, String planCategory) {
		/*
		 * if (planType.equalsIgnoreCase("MAPD")) { radioDrug.click(); }
		 */
		String claimPeriod = timeAttributesMap.get("Claim Period");
		select(searchRange, claimPeriod);

		CommonUtility.checkPageIsReady(driver);
		showClaimHistoryButton.click();

		CommonUtility.checkPageIsReady(driver);
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			if (planCategory.equalsIgnoreCase("Individual")) {
				return new ClaimSummaryPage(driver, planCategory);
			} else {
				return new ClaimSummaryPage(driver);
			}
		}
		return null;

	}

	public ClaimSummaryPage searchDrugClaimsByTimeInterval(
			Map<String, String> timeAttributesMap, String planType) {
		if (planType.equalsIgnoreCase("MAPD")) {
			radioDrug.click();
		}
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

		sendkeys(fromMonth, fromMonthInput);
		sendkeys(fromDay, fromDayInput);
		sendkeys(fromYear, fromYearInput);
		sendkeys(toMonth, toMonthInput);
		sendkeys(toDay, toDayInput);
		sendkeys(toYear, toYearInput);
		CommonUtility.checkPageIsReady(driver);
		showClaimHistoryButton.click();

		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String timePeriod) {

		// get expected data for claim summary
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject claimSummaryExpectedJson = null;
		try {
			claimSummaryExpectedJson = expectedDataMap.get(
					CommonConstants.CLAIM_SUMMARY).getJSONObject(timePeriod);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		claimSummaryExpectedJson = CommonUtility.mergeJson(
				claimSummaryExpectedJson, globalExpectedJson);
		return claimSummaryExpectedJson;
	}

	@Override
	public void openAndValidate() {

		validate(showClaimHistoryButton);

		JSONObject jsonObject = new JSONObject();
		for (String key : claimsSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(claimsSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (elementFound(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		claimSummaryJson = jsonObject;
		
		System.out.println("claimSummaryJson----->"+claimSummaryJson);

	}
	
	public String searchlinkexistense() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(linkexistense.isDisplayed())
		{
			return linkexistense.getText();
		}
			return null;
	}


	public boolean validateaddaplanlink() {
		
boolean presentLink =false;
		
		try {
			if(addaplanlink.isDisplayed()){
				
				presentLink = true;
				return presentLink;
			}			  
			 
		} catch (NoSuchElementException e) {
			presentLink = false;
		}
		return presentLink;
		// TODO Auto-generated method stub
		
	}


	public boolean validateClaims(){
		boolean flag = false;
		if(validate(serviceDate)&&validate(providerName)&&validate(claimType)&&validate(charged)&&validate(claimStatus)
				&&validate(claimDetails)&&validate(moreInfoLink1)&&validate(searchResultMsg)){
			flag = true;
		}else
			System.out.println("Could not verify the Med Claims elements");
		return flag;
	}
	
	public boolean validateRxClaims() {
		boolean flag = false;
		if(validate(dateFilled)&&validate(rxNumber)&&validate(medication)&&validate(pharmacy)&&validate(memberHasPaid)
				&&validate(planHasPaid)&&validate(otherPayments)&&validate(searchResultMsg)){
			flag = true;
		}else
			System.out.println("Could not verify the Med Claims elements");
		return flag;
	}


	
	
	
}
