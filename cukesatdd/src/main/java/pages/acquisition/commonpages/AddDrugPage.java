package pages.acquisition.commonpages;

/*@author pagarwa5*/


import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class AddDrugPage extends UhcDriver {

	@FindBy(className = "drugDropDownList")
	private WebElement drugDropDown;

	@FindBy(id = "dcemodal")
	WebElement drugsAdded;

	@FindBy(className = "drugSearchBox")
	WebElement drugSearchBox;
	
	@FindBy(xpath="//div[@class='tabsHead']/div[2]")
	WebElement selectPharmacyTab;
	
	@FindBy(xpath="//div[@class='tabsHead']/div")
	WebElement manageDrugTab;


	public JSONObject drugListJson;

	public AddDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	public void enterDrugInitials(String drugInitials) {
		sendkeys(drugSearchBox, drugInitials);
		CommonUtility.waitForPageLoad(driver, drugDropDown,
				CommonConstants.TIMEOUT_40);
/*
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
*/	
	}
	
	public boolean validateDrugInitialsSearch(String drugInitials) {
		String[] dropDownValues = getDrugList().split("\n");
		boolean flag = true;
		for(int i=0;i<dropDownValues.length;i++){
			if (!dropDownValues[i].toLowerCase().contains(drugInitials)){
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	public String getDrugList() {
		return drugDropDown.getText();

	}

	/*public SelectDosagePage selectDrug(String drugName) {
		ElementData drugElement = new ElementData("xpath",
				"//div[contains(text(), '" + drugName + "')]");
		WebElement element = findElement(drugElement);
		element.click();

		return new SelectDosagePage(driver);

	}*/

	
	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject drugsAddedExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		return drugsAddedExpectedJson;

	}

	@Override
	public void openAndValidate() {
		validate(drugSearchBox);

	}
	
	/*
	 * TODO: CodeMonkeys Team: Please check if this is required. 
	 * 
	 * In this framework we perform validations by comparing JSONObjects 
	 * 
	 * 
	 * */
	public void validateAddDrugFlow(){
		validate(drugSearchBox);
		selectPharmacyTab.click();
		manageDrugTab.click();
		validate(drugSearchBox);
	}
	public SelectDosagePage selectDrug(String drugName) {
        ElementData drugElement = new ElementData("xpath",
                        "//div[contains(text(), '" + drugName + "')]");
        WebElement element = findElement(drugElement);
        element.click();

        return new SelectDosagePage(driver);

}


}
