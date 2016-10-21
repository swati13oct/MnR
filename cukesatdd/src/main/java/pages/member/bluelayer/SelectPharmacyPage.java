package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
 * @author pperugu
 *
 */

public class SelectPharmacyPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='inputRadioButtons']")
	private WebElement pharmacyOptions;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[4]/div/div/div[1]/div[1]/div[2]")
	WebElement  selectPharmacyTab;
	
	@FindBy(xpath = "//div[@id='dce.member']/div/div[4]/div/div/div[1]/div[1]/div[3]")
	WebElement viewDrugCostTab1;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div[1]/div[1]/div[3]")
	WebElement viewDrugCostTab2;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div[1]/div[2]/p")
	private WebElement pharmacyHeading;

	@FindBys(value = { @FindBy(xpath = "//div[@class='dcePharmacyTable']/table/tbody/tr") })
	private List<WebElement> pharmacyRows;

	@FindBy(className = "viewDrugCost")
	private WebElement drugCostTable;

	@FindBy(className = "tablePharmacy")
	private WebElement pharmacyTable;

	@FindBy(className = "milesSelection")
	private WebElement distances;

	@FindBy(linkText = "add a drug")
	private WebElement addDrugLink;

	@FindBy(linkText = "select")
	private WebElement selectPharmacyButton;
	
	@FindBy(xpath = "//*[@id='dceMemberUlayer']/div/div[1]/div[3]/div[2]/table/tbody/tr[2]/td[3]/div")
	private WebElement drugCostsValue;
	
	private PageData selectPharmacy;

	public JSONObject selectPharmacyJson;

	public SelectPharmacyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SELECT_PHARMACY_INDIVIDUAL_BLUE_LAYER_PAGE_DATA;
		selectPharmacy = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public SelectPharmacyPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SELECT_PHARMACY_BLUE_LAYER_PAGE_DATA;
		selectPharmacy = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public SelectPharmacyPage selectTypeDistance(String pharmacyType,
			String distance, String category) {

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

		if (pharmacyHeading.getText().contains("select a pharmacy") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new SelectPharmacyPage(driver,category);
		}
		else if(pharmacyHeading.getText().contains("select a pharmacy")){
			return new SelectPharmacyPage(driver);
		}
		return null;
	}

	public ViewDrugCostPage selectPharmacy(String pharmacyName, String category) {

		CommonUtility.waitForPageLoad(driver, pharmacyTable,CommonConstants.TIMEOUT_30);
		List<WebElement> pharmacyRows = pharmacyTable.findElements(By
				.tagName("tr"));

		for (WebElement pharmacyRow : pharmacyRows) {
			List<WebElement> pharmacyColumns = pharmacyRow.findElements(By
					.tagName("td"));

			// Pharmacy name is available at third column
			WebElement pharmacyNameElement = pharmacyColumns.get(2);

			if (pharmacyNameElement.getText().equalsIgnoreCase(pharmacyName)) {
				if (pharmacyColumns.get(4).getText().equalsIgnoreCase("select")) {
					pharmacyColumns.get(4).findElement(By.linkText("select"))
					.click();
					viewDrugCostTab1.click();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					viewDrugCostTab2.click();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if(category.equalsIgnoreCase(CommonConstants.GROUP)){
					return new ViewDrugCostPage(driver,category);
				}
				else{
					return new ViewDrugCostPage(driver);
				}

			}
		}
		return null;
	}

	public ViewDrugCostPage selectPharmacyandvalidate(String pharmacyName,
			String category, String pharmacyType) {
		CommonUtility.waitForPageLoad(driver, pharmacyTable,CommonConstants.TIMEOUT_30);
		List<WebElement> pharmacyRows = pharmacyTable.findElements(By
				.tagName("tr"));

		for (WebElement pharmacyRow : pharmacyRows) {
			List<WebElement> pharmacyColumns = pharmacyRow.findElements(By
					.tagName("td"));

			// Pharmacy name is available at third column
			WebElement pharmacyNameElement = pharmacyColumns.get(2);

			if (pharmacyNameElement.getText().equalsIgnoreCase(pharmacyName)) {
				if (pharmacyColumns.get(4).getText().equalsIgnoreCase("select")) {
					pharmacyColumns.get(4).findElement(By.linkText("select")).click();
				}
			}
		}
		validateWidgets();
		selectPharmacyTab.click();
		validateWidgets();
		viewDrugCostTab2.click();
		boolean present;
		try {
			driver.findElement(By.id("ATDD_CurrentPharmacy"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Current Pharmacy widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Current Pharmacy widget @@@@@@@@@");
		if(drugCostsValue.getText().contains("$"))
			System.out.println("Drug Costs table has a value");
		else
			System.out.println("Drug Costs table shows null value ");
		

		if(category.equalsIgnoreCase(CommonConstants.GROUP)){
			return new ViewDrugCostPage(driver,category);
		}
		else{
			return new ViewDrugCostPage(driver);
		}
	}

	public void validateWidgets() {
		boolean present;
		try {
			driver.findElement(By.id("ATDD_CurrentPharmacy"));
			driver.findElement(By.id("ATDD_DrugCostSavings"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Current Pharmacy and Drug Cost Savings widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Current Pharmacy and Drug Cost Savings widget @@@@@@@@@");


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
			} else if (null != element) {
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

		// Need a review for below commented code
		/*
		 * JSONObject jsonObject = new JSONObject(); for (String key :
		 * selectPharmacy.getExpectedData().keySet()) { List<WebElement>
		 * elements = findElements(selectPharmacy .getExpectedData().get(key));
		 * if (elements.size() == 1) { if (validate(elements.get(0))) { try {
		 * jsonObject.put(key, elements.get(0).getText()); } catch
		 * (JSONException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } } else if (elements.size() > 1) { JSONArray
		 * jsonArray = new JSONArray(); for (WebElement element : elements) { if
		 * (validate(element)) { try { JSONObject jsonObjectForArray = new
		 * JSONObject(); jsonObjectForArray.put("pharmacy", element.getText());
		 * jsonArray.put(jsonObjectForArray); } catch (JSONException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } } } try {
		 * jsonObject.put(key, jsonArray); } catch (JSONException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * } selectPharmacyJson = jsonObject;
		 */

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





}
