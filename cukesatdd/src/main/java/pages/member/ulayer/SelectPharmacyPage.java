package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */

public class SelectPharmacyPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='inputRadioButtons']")
	private WebElement pharmacyOptions;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/div/div/div[3]")
	WebElement viewDrugCostTab1;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[6]/div/div/form/div/div/div[1]/div[2]/p")
	private WebElement pharmacyHeading;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[6]/div/div/form/div/div/div/div/div[3]")
	WebElement viewDrugCostTab2;

	@FindBys(value = { @FindBy(xpath = "//div[@class='dcePharmacyTable']/table/tbody/tr") })
	private List<WebElement> pharmacyRows;

	@FindBy(className = "viewDrugCost")
	private WebElement drugCostTable;

	@FindBy(className = "tablePharmacy")
	WebElement pharmacyTable;

	@FindBy(className = "milesSelection")
	private WebElement distances;

	@FindBy(linkText = "add a drug")
	private WebElement addDrugLink;

	@FindBy(linkText = "select")
	private WebElement selectPharmacyButton;
	
	@FindBy(xpath = "/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[4]/div/div[6]/div[1]/div[3]/div/div/div/div[7]/div/div/div/div/div[1]/div[3]/div[2]/span[6]/span[2]/strong/span[2]")
	private WebElement planYear2017;
	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[2]/div[3]/div[1]/p")
	private WebElement pharmacySaverPharmacieslb;
	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[2]/div[10]/div[5]/div/div[1]/div/p")
	private WebElement pharmacySaverDisclaimer;

	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[2]/div[3]/div[1]/span[3]/div")
	private WebElement pharmacySaver_SaverMessage;
	
	
	private PageData selectPharmacy;

	public JSONObject selectPharmacyJson;

	public SelectPharmacyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SELECT_PHARMACY_ULAYER_PAGE_DATA;
		selectPharmacy = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public SelectPharmacyPage selectTypeDistance(String pharmacyType,
			String distance) {

		List<WebElement> pharmacies = pharmacyOptions.findElements(By
				.tagName("input"));
		for (WebElement pharmacy : pharmacies) {
			String pharmacyType1 = pharmacy.getAttribute("value");
			if (null != pharmacyType1
					&& pharmacyType1.equalsIgnoreCase(pharmacyType)) {
				pharmacy.click();
				break;
			}
		}

		select(distances, distance);
		if (pharmacyHeading.getText().contains("select a pharmacy")) {
			return new SelectPharmacyPage(driver);
		}
		return null;
	}

	public ViewDrugCostPage selectPharmacy(String pharmacyName, String planType) {

		CommonUtility.waitForPageLoad(driver, pharmacyTable, CommonConstants.TIMEOUT_30);

		for (WebElement pharmacyRow : pharmacyRows) {
			List<WebElement> pharmacyColumns = pharmacyRow.findElements(By
					.tagName("td"));
			WebElement pharmacyNameElement = pharmacyColumns.get(2); // Pharamcy
																		// name
																		// is
																		// available
																		// at
																		// third
																		// column

			if (pharmacyNameElement.getText().equalsIgnoreCase(pharmacyName)) {
				if (pharmacyColumns.get(4).getText().equalsIgnoreCase("select")) {
					pharmacyColumns.get(4).findElement(By.linkText("select"))
							.click();
					viewDrugCostTab1.click();
					if(validate(planYear2017)){
						planYear2017.click();
					}
					return new ViewDrugCostPage(driver,planType);

				} else {
					viewDrugCostTab2.click();
					if(validate(planYear2017)){
						planYear2017.click();
					}
					return new ViewDrugCostPage(driver,planType);
				}

			}
		}
		return null;

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		String key = "Default";
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject selectPharmacyPageExpectedJson = null;
		try {
			selectPharmacyPageExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.SELECT_PHARMACY).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectPharmacyPageExpectedJson = CommonUtility.mergeJson(
				selectPharmacyPageExpectedJson, globalExpectedJson);
		return selectPharmacyPageExpectedJson;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String pharmacyType, String distance) {

		String key = pharmacyType + "_" + distance;
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject updatedPharmacyPageExpectedJson = null;
		try {
			updatedPharmacyPageExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.SELECT_PHARMACY).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updatedPharmacyPageExpectedJson = CommonUtility.mergeJson(
				updatedPharmacyPageExpectedJson, globalExpectedJson);
		return updatedPharmacyPageExpectedJson;
	}

	@Override
	public void openAndValidate() {

		validate(distances);

		JSONObject jsonObject = new JSONObject();
		for (String key : selectPharmacy.getExpectedData().keySet()) {

			WebElement element = findElement(selectPharmacy.getExpectedData()
					.get(key));
			// TODO: NEED TO REVIEW
			if (key.equalsIgnoreCase("pharmacyList")) {
				List<WebElement> pharmacyListElememnts = element
						.findElements(By.tagName("tr"));
				JSONArray jsonArray = new JSONArray();
				for (WebElement pharmacyElement : pharmacyListElememnts) {
					if (validate(pharmacyElement)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put("pharmacy",
									pharmacyElement.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (null != element
					&& !element.getText().equalsIgnoreCase("")) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		selectPharmacyJson = jsonObject;
		
		System.out.println("selectPharmacyJson----->"+selectPharmacyJson);

	}
	
	public boolean isPharmacySaveRadioButtonPresent(){
		
		if(pharmacySaverPharmacieslb.isDisplayed()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public void refreshDrugLookupPage() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	public boolean isPharmacySaverDisclaimerDisplayed() {

		if (pharmacySaverDisclaimer.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean isPharmacySaver_SaverMessagePresent() {

		if (pharmacySaver_SaverMessage.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

}
