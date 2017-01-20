package pages.dashboard.member.blayer;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
public class AddNewDrugModal extends UhcDriver {

	private PageData addnewdrug;

	public JSONObject addnewdrugJson;

	@FindBy(id = "drug-search-button")
	public WebElement searchButton;

	@FindBy(xpath = "//span[text()='Add a New Drug']")
	public WebElement addNewDrugHeading;

	@FindBy(xpath = "//a[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(id = "drug-search-input")
	public WebElement drugsearchinput;
	
	@FindBy(id="radio-0")
	public WebElement firstdrug; //its liptor
	
	

	@FindBy(id = "drug-alt-search-button")
	public WebElement continueButton;

	public AddNewDrugModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, addNewDrugHeading, 10);
		String fileName = CommonConstants.ADD_NEW_DRUG_PAGE_DATA;
		//addnewdrug = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		//openAndValidate();
	}
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : addnewdrug.getExpectedData().keySet()) {
			WebElement element = findElement(addnewdrug.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		addnewdrugJson = jsonObject;
		System.out.println("addnewdrugJson----->" + addnewdrugJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject addnewdrugExpectedJson = expectedDataMap.get(CommonConstants.ADD_NEW_DRUG_PAGE_DATA);

		return addnewdrugExpectedJson;
	}

	public AddDrugDetails clickonSearchButton(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
		searchButton.click();
		if (driver.getTitle().equalsIgnoreCase("Our Add Drug Details®")) {
			return new AddDrugDetails(driver);
		}
		return null;
	}
	public void selectDrug(String drugname){
		String xpath = "//label[contains(text(),'Lip-EX')]/parent::div/input";
		WebElement rdrug = driver.findElement(By.xpath(xpath));
		if(!rdrug.isSelected()){
			rdrug.click();
		}
		continueButton.click();
	}
}

