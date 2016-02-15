package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class AddDrugPage extends UhcDriver{
	
	@FindBy(className = "drugDropDownList")
	private WebElement drugDropDown;

	@FindBy(className = "autoCompleteDrugs")
	private List<WebElement> drugs;

	@FindBy(id = "dcemodal")
	WebElement drugsAdded;

	@FindBy(className = "drugSearchBox")
	WebElement drugSearchBox;

	private PageData drugList;

	public JSONObject drugListJson;

	public AddDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ADD_DRUG_PAGE_DATA;
		drugList = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		openAndValidate();
	}

	public void enterDrugInitials(String drugInitials) {
		sendkeys(drugSearchBox, drugInitials);
		CommonUtility.waitForPageLoad(driver, drugDropDown,
				CommonConstants.TIMEOUT_40);
		JSONObject jsonObject = new JSONObject();
		for (String key : drugList.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(drugList.getExpectedData()
					.get(key));
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
						jsonObjectForArray.put(
								drugList.getExpectedData().get(key)
										.getElementName(), element.getText());
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
		drugListJson = jsonObject;
		System.out.println("drugListJson------>" + drugListJson);
	}

	public String getDrugList() {
		return drugDropDown.getText();

	}

	public SelectDosagePage selectDrug(String drugName) {
		ElementData drugElement = new ElementData("xpath",
				"//div[contains(text(), '" + drugName + "')]");
		WebElement element = findElement(drugElement);
		element.click();
		
		return new SelectDosagePage(driver);


	}

	
	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject drugsAddedExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		return drugsAddedExpectedJson;

	}

	@Override
	public void openAndValidate() {
		validate(drugSearchBox);

	}



}
	/*@FindBy(css = "div > img[alt=\"Plus Image\"]")
	WebElement plusSign;

	@FindBy(xpath = "//div[@class='drugDropDownList']")
	private WebElement drugDropDownList;
	
	@FindBy(xpath = "//div[@class='costSavingsDrawer cb']")
	private WebElement switchTogenericButton;
	
	@FindBy(xpath = "//div[@class='reduceCosts generic']")
	private WebElement reduceCostPath;
	
	@FindBy(linkText = "Close and apply changes")
	WebElement applyChangesButton;
	
	@FindBy(id = "dcemodal")
	WebElement drugsAdded;
	
	@FindBy(xpath = "//div[@class='tab selectedTab']")
	private WebElement pharmacySearchTab;

	@FindBy(name = "drugname")
	WebElement drugNameField;
	
	@FindBy(linkText = "Reduce costs")
	WebElement reduceCostLink;

	@FindBy(name = "autoCompleteDrugs_Lipitor")
	WebElement lipitorDrug;
	
	@FindBy(linkText = "View plan results")
	private WebElement viewPlansLink;
	
	private PageData drugList;

	public JSONObject drugListJson;

	public AddDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ADD_DRUG_PAGE_DATA;
		drugList = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		openAndValidate();
	}

	public void enterDrugInitials(String drugInitials) {
		sendkeys(drugSearchBox, drugInitials);
		CommonUtility.waitForPageLoad(driver, drugDropDown,
				CommonConstants.TIMEOUT_40);
		JSONObject jsonObject = new JSONObject();
		for (String key : drugList.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(drugList.getExpectedData()
					.get(key));
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
						jsonObjectForArray.put(
								drugList.getExpectedData().get(key)
										.getElementName(), element.getText());
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
		drugListJson = jsonObject;
		System.out.println("drugListJson------>" + drugListJson);
	}

	public String getDrugList() {
		return drugDropDownList.getText();

	}

	public SelectDosagePage selectDrug(String drugName) {
		List<WebElement> list = drugDropDownList.findElements(By
				.xpath("//div[@class='tHi autoCompleteDrugs ng-scope']"));

		for (WebElement element : list) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(drugName)) {
				String drugXpath = "//*[contains(text(), '" + drugName + "')]";
				element.findElement(By.xpath(drugXpath)).click();

			}

		}
		if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®"))
		{
			return new SelectDosagePage(driver);
		}
		else
		{
			return null;
		}
	

	}

	public String validateDrugsAdded() {
		
		return drugsAdded.getText();
	}

	public PharmacySelectorPage navigateToPharmacyPage() {
		pharmacySearchTab.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new PharmacySelectorPage(driver);
		} else {
			return null;
		}
		
		
	}

	public VPPPlanSummaryPage navigateToHealthPlansPage() {
		
		
		viewPlansLink.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		} else {
			return null;
		}
		
	}

	public void reduceCost() {
		reduceCostLink.click();
		System.out.println("reduce cost");
		
	}

	public void switchToGeneric() {
		switchTogenericButton.findElement(By.linkText("Switch to generic")).click();
		System.out.println();
	}

	public void applyChanges() {
		applyChangesButton.click();
		System.out.println("changes");
		
	}

	@Override
	public void openAndValidate() {
		validate(drugSearchBox);
		
	}

}
*/