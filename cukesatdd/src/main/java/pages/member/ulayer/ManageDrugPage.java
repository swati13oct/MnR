/**
 * 
 */
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

import pages.member.ulayer.AddDrugPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class ManageDrugPage extends UhcDriver {

	@FindBy(linkText = "add a drug")
	private WebElement addDrugLink;

	@FindBy(linkText = "Delete")
	private WebElement deleteLink;

	@FindBy(name = "drugname")
	private WebElement drugName;

	@FindBy(xpath = "//div[@class='drugDropDownList']")
	private WebElement drugDropDownList;

	@FindBys(value = { @FindBy(xpath = "//div[@class='drugDropDownList']/div") })
	private List<WebElement> drugListElements;

	@FindBy(linkText = "view drug costs")
	private WebElement viewDrugCostButton;
	
	@FindBy(xpath = "//div[@id='dce.member']/div/div[3]/div/div/div/div[5]/p")
	private WebElement dosagePageText;
	

	@FindBy(xpath = "//div[@id='dce.member']/div/div[6]/div/div/form/div/div/div/div[2]/p")
	private WebElement pharmacyPageHeading;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/div/div/div[2]")
	WebElement pharmacyTab;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[5]/div/div/div[1]/div[1]/div[3]")
	private WebElement viewDrugCostTab;
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[5]/div/div/div[1]/div[1]/div[1]")
	private WebElement drugListTab;
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[5]/div/div/div[1]/div[2]/div[4]/div/div")
	private WebElement drugListBox; //box where all the added drugs will show 
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[5]/div/div/div[1]/div[2]/div[4]/div/div/div[5]/a")
	private WebElement editDrugLink;
	
	@FindBy(xpath = ".//*[@id='dce.member']div/div[5]/div/div/div[1]/div[2]/div[4]/div/div/div[6]/a")
	private WebElement deleteDrugLink;
	
	@FindBys(value = { @FindBy(name = "typeofdrug") })
	private List<WebElement> genericDrugs;
	

	@FindBy(linkText = "select a pharmacy")
	private WebElement continueButton;
	
	private PageData manageDrug;

	public JSONObject manageDrugJson;

	public ManageDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MANAGE_DRUG_ULAYER_PAGE_DATA;
		manageDrug = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		openAndValidate();
	}

	public AddDrugPage searchDrug(String drugInitials) {
		addDrugLink.click();
		sendkeys(drugName, drugInitials);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (drugDropDownList.isDisplayed()) {
			return new AddDrugPage(driver);
		} else
			return null;

	}

	public DrugDosagePage selectDrug(String drugName) {

		for (WebElement element : drugListElements) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(drugName)) {
				String drugXpath = "//*[contains(text(), '" + drugName + "')]";
				element.findElement(By.xpath(drugXpath)).click();
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dosagePageText.getText().equalsIgnoreCase("Select dosage:*")) {
			return new DrugDosagePage(driver);
		}
		return null;

	}

	public String validateDrugList() {

		return drugDropDownList.getText();
	}

	public ViewDrugCostPage navigateToViewDrugCostPage() {
		viewDrugCostButton.click();
		if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
			return new ViewDrugCostPage(driver,null);
		} else {
			return null;
		}

	}

	public void deleteDrugs() {
		if (deleteLink.isEnabled()) {
			deleteLink.click();
		} else {
			System.out.println("link is disabled");
		}
	}

	public void logout() {
		logOut.click();

	}

	public SelectPharmacyPage navigateToPharmacyPage() {
		if(!pharmacyPageHeading.getText().contains("select a pharmacy")){
			pharmacyTab.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pharmacyPageHeading.getText().contains("select a pharmacy")) {
			return new SelectPharmacyPage(driver);
		}
		return null;

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

	public JSONObject getExpectedData(JSONObject expectedDataMap) {
	
		String key = "NoDrug";
		/*JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);*/
		JSONObject manageDrugExpectedJson = null;
		try {
			manageDrugExpectedJson = (JSONObject) ((JSONObject) expectedDataMap
					.get(CommonConstants.MANAGE_DRUG)).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*manageDrugExpectedJson = CommonUtility.mergeJson(
				manageDrugExpectedJson, globalExpectedJson);*/
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

	public ManageDrugPage selectDrugType(String drugType) {

		if (!drugType.equalsIgnoreCase("Brand")) {
			for (WebElement dosage : genericDrugs) {
				dosage.click();
				break;
			}
		}
		continueButton.click();
		if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
			return new ManageDrugPage(driver);
		}
		return null;
	}
	
	public boolean validateDrugListSection(){
		boolean flag = false;
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(addDrugLink)&&validate(viewDrugCostTab)&&validate(pharmacyTab)&&validate(drugListTab))
			flag = true;
		return flag;
	}
	
	public boolean validateDrugAdded(){
		if(validate(drugListBox)&&validate(editDrugLink)&&validate(deleteLink))
			return true;
		else
			return false;
	}


}
