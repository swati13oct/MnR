package pages.dashboard_deprecated.member.blayer;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import atdd.framework.UhcDriver;
import pages.dashboard_deprecated.member.drugcostestimator.blayer.AddDrugDetails;
public class AddNewDrugModal extends UhcDriver {


	public JSONObject addnewdrugJson;

	@FindBy(id = "drug-search-button")
	public WebElement searchButton;


	@FindBy(xpath = "//header[@class='add-drug-slide-header']/span[contains(text(),'ADD A NEW DRUG')]")
	public WebElement addNewDrugHeading;

	@FindBy(xpath = "//a[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(id = "drug-search-input")
	public WebElement drugsearchinput;
	
	@FindBy(id="radio-0")
	public WebElement firstdrug; //its liptor
	
	@FindBy(xpath = "//span[contains(text(),'Please enter at least 4 characters to continue search')]")
	public WebElement errorMessage;

	@FindBy(id = "drug-alt-search-button")
	public WebElement continueButton;

	@FindBy(xpath = "//span[contains(text(),'Your Drug List can contain a maximum of 25 drugs.')]")
	public WebElement exceededError;
	
	public AddNewDrugModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addNewDrugHeading, 10);
		//String fileName = CommonConstants.ADD_NEW_DRUG_PAGE_DATA;
		//addnewdrug = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		//openAndValidate();
	}
	@Override
	public void openAndValidate() {
		addNewDrugHeading.isDisplayed();
		
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
	public void typeDrugName(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
	}
	public AddDrugDetails selectDrug(String drugname){
		String xpath = "//label[contains(text(),'"+drugname+"')]/parent::div/input";
		WebElement rdrug = driver.findElement(By.xpath(xpath));
		if(!rdrug.isSelected()){
			rdrug.click();
		}
		waitforElement(continueButton);
		continueButton.click();
		return new AddDrugDetails(driver);
	}
	public void verifyerror(){
		errorMessage.isDisplayed();
	}
	public void selectAdrugFromAutoCompleteSuggestions(String drug){
		List<WebElement> elements = driver.findElements(By.className("autocomplete-suggestions"));
		for(WebElement element : elements){
			
			if(drug.equalsIgnoreCase(element.getText())){
				element.click();
				break;
			}
		}
	}
	
	public void submit(){
		searchButton.click();
	}
	
	public void verifyExceededError(){
		exceededError.isDisplayed();
	}
	public AddDrugDetails continueAddNewDrugModal() {
		waitforElement(continueButton);
		continueButton.click();
		return new AddDrugDetails(driver);
	}
}

