/**
 * 
 */
package pages.member.bluelayer;

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
 * @author pperugu
 *
 */
public class ManageDrugPage extends UhcDriver {

	@FindBy(linkText = "add a drug")
	private WebElement addDrugLink;

	@FindBy(linkText = "Delete")
	private WebElement deleteLink;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div[1]/div[2]/p")
	private WebElement pharmacyHeading;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[4]/div/div/div/div/div[2]")
	private WebElement searchPharmacyTab;

	@FindBy(name = "drugname")
	private WebElement drugName;

	@FindBy(xpath = "//div[@class='drugDropDownList']")
	private WebElement drugDropDownList;

	@FindBys(value = { @FindBy(xpath = "//div[@class='drugDropDownList']/div") })
	private List<WebElement> drugListElements;

	@FindBy(linkText = "view drug costs")
	private WebElement viewDrugCostButton;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	private PageData manageDrug;

	public JSONObject manageDrugJson;

	public ManageDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MANAGE_DRUG_INDIVIDUAL_BLUE_LAYER_PAGE_DATA;
		manageDrug = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

		openAndValidate();
	}

	public ManageDrugPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MANAGE_DRUG_BLUE_LAYER_PAGE_DATA;
		manageDrug = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

		openAndValidate();
	}

	public AddDrugPage searchDrug(String drugInitials, String category) {
		addDrugLink.click();
		sendkeys(drugName, drugInitials);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (drugDropDownList.isDisplayed() && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new AddDrugPage(driver,category);
		} else if (drugDropDownList.isDisplayed()) {
			return new AddDrugPage(driver);
		}
			return null;

	}

	public DrugDosagePage selectDrug(String drugName) {
		// TODO Auto-generated method stub
		/*
		 * List<WebElement> list = drugDropDownList.findElements(By
		 * .xpath("//div[@class='tHi autoCompleteDrugs ng-scope']"));
		 */

		for (WebElement element : drugListElements) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(drugName)) {
				String drugXpath = "//*[contains(text(), '" + drugName + "')]";
				element.findElement(By.xpath(drugXpath)).click();

			}

		}
		if (driver.getTitle().equalsIgnoreCase("Drug Cost Estimator")) {
			return new DrugDosagePage(driver);
		}
		return null;

	}

	public ViewDrugCostPage navigateToViewDrugCostPage() {
		viewDrugCostButton.click();
		if (driver.getTitle().equalsIgnoreCase("Drug Cost Estimator")) {
			return new ViewDrugCostPage(driver);
		}
		return null;

	}

	public void deleteDrugs() {
		if (deleteLink.isEnabled()) {
			deleteLink.click();
		} else {
			System.out.println("link is disabled");
		}
	}
	public void checkForDrugPresentAndDelete(){
		List<WebElement> lst = driver.findElements(By.xpath("//div[@class='delete']"));
		for(int i=0;i<lst.size();i++){
			System.out.println("number of drugs present = "+lst.size());
			lst.get(i).click();
		}
	}
	public void logOut() {
		logOut.click();

	}
	@Override
	public void openAndValidate() {
	
		validate(logOut);
		
		
		JSONObject jsonObject = new JSONObject();
		for (String key : manageDrug.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(manageDrug
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
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
					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put("addedDrug",
									element.getText());
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

			}

		}
		manageDrugJson = jsonObject;
		
		System.out.println("manageDrugJson----->"+manageDrugJson);

	}


	public SelectPharmacyPage navigateToPharmacyPage(String category) {

		searchPharmacyTab.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pharmacyHeading.getText().contains("select a pharmacy") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new SelectPharmacyPage(driver,category);
		}
		else if(pharmacyHeading.getText().contains("select a pharmacy"))
		{
			return new SelectPharmacyPage(driver);
		}
		return null;

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		
		String key = "NoDrug";
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject manageDrugExpectedJson = null;
		try {
			manageDrugExpectedJson = (JSONObject) expectedDataMap
					.get(CommonConstants.MANAGE_DRUG).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manageDrugExpectedJson = CommonUtility.mergeJson(
				manageDrugExpectedJson, globalExpectedJson);
		return manageDrugExpectedJson;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			Map<String, String> dosageAttributesMap) {
		
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		
		String key = null;
		if((packages !=null) && (!(packages.equalsIgnoreCase("null"))))
		{
			key= drugDosage+"_"+drugQuantity+"_"+drugFrequency+"_"+packages;
		}
		else
		{
			key= drugDosage+"_"+drugQuantity+"_"+drugFrequency; //Lipitor TAB 10MG_30_Every 1 month
		}
		
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject manageDrugExpectedJson = null;
		try {
			manageDrugExpectedJson = (JSONObject) expectedDataMap
					.get(CommonConstants.MANAGE_DRUG).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manageDrugExpectedJson = CommonUtility.mergeJson(
				manageDrugExpectedJson, globalExpectedJson);
		return manageDrugExpectedJson;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			Map<String, String> dosageAttributesMap, String drugType) {
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		
		String key = null;
		if((packages !=null) && (!(packages.equalsIgnoreCase("null"))))
		{
			key= drugDosage+"_"+drugQuantity+"_"+drugFrequency+"_"+packages+"_"+drugType;
		}
		else
		{
			key= drugDosage+"_"+drugQuantity+"_"+drugFrequency+"_"+drugType; //Lipitor TAB 10MG_30_Every 1 month_Brand
		}
		
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject manageDrugExpectedJson = null;
		try {
			manageDrugExpectedJson = (JSONObject) expectedDataMap
					.get(CommonConstants.MANAGE_DRUG).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		manageDrugExpectedJson = CommonUtility.mergeJson(
				manageDrugExpectedJson, globalExpectedJson);
		return manageDrugExpectedJson;
	}

}
