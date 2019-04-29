/**
 * 
 */
package pages.member_deprecated.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class ManageDrugPage extends UhcDriver {

	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[5]/a[1]/span")
	private WebElement addDrugLink;
	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[5]/a[2]/span")
	private WebElement selectPharmacyBtn;

	@FindBy(linkText = "Delete")
	private WebElement deleteLink;

	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[1]/h3[2]")
	private WebElement searchPharmacyTab;

	@FindBy(name = "drugname")
	private WebElement drugName;

	@FindBy(xpath = "//div[@class='drugDropDownList']")
	private WebElement drugDropDownList;

	@FindBy(linkText = "view drug costs")
	private WebElement viewDrugCostButton;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	

	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[4]/div")
	private WebElement drugListBox; //box where all the added drugs will show 
	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[4]/div/div[1]/div[5]/a")
	private WebElement editDrugLink;
	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[4]/div/div[1]/div[6]/a")
	private WebElement deleteDrugLink;
	
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
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[2]/div[2]/div[1]/input")
	private WebElement standardradiobtn;
	
	public SelectPharmacyPage navigateToPharmacyPage() {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", searchPharmacyTab);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(validate(standardradiobtn))
			return new SelectPharmacyPage(driver);
		
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
	
		if(validate(addDrugLink)&&validate(selectPharmacyBtn))
			flag = true;
		return flag;
	}
	
	public boolean validateDrugAdded(){
		if(validate(drugListBox)&&validate(editDrugLink)&&validate(deleteDrugLink))
			return true;
		else
			return false;
	}

	public ViewDrugCostPage navigateToViewDrugCostPage() {
		viewDrugCostButton.click();
		if (driver.getTitle().equalsIgnoreCase("Drug Cost Estimator")) {
			return new ViewDrugCostPage(driver);
		}
		return null;

	}

}