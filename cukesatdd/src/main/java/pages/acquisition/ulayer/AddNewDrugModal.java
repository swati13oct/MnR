package pages.acquisition.ulayer;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
public class AddNewDrugModal extends UhcDriver {

	private PageData addnewdrug;

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

	@FindBy(xpath = "//span[@class='color-red']")
	public WebElement atleast_4_mesg;
	
	@FindBy(id = "dialogHeading1")
	public WebElement modalHeading;
	
	@FindBy(xpath = "//div[contains(@class,'autocomplete-suggestions')]/div[@class='autocomplete-suggestion']")
	public List<WebElement> autoCompleteSuggestionList;
	
	@FindBy(xpath = "//div[@class='loading-dialog'][not (contains(@style,'display: none;'))]")
	public List<WebElement> loadingDialog;
	
	@FindBy(xpath = "//input[starts-with(@id,'drugs-')]/parent::div[contains(@class,'radio-block')]/label")
	public WebElement drugList;

	@FindBy(id = "closeDrugPopup")
	public WebElement cancel;
	
	
	public AddNewDrugModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	@Override
	public void openAndValidate() {
		validateNew(modalHeading);
		validateNew(searchButton);
	}

	public AddDrugDetails searchDrugWithoutAutoComplete(String DrugName) throws InterruptedException {

		sendkeys(drugsearchinput, DrugName.toLowerCase());
		searchButton.click();
		CommonUtility.waitForPageLoadNew(driver, drugList, 30);
		continueButton.click();
		return new AddDrugDetails(driver);

	}
	
	public void closeModalWindow() {
		cancel.click();
		waitforElementDisapper(By.id("closeDrugPopup"), 30);
	}
	
	public void typeDrugName(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
	}
	public AddDrugDetails selectDrug(String drugname){
		String xpath = "//label[contains(text(),'"+drugname+"')]/parent::div/input[contains(@id,'drugs-')]";
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

	public AddDrugDetails searchDrugWithAutoComplete(String drug) {
		sendkeys(drugsearchinput, drug.toLowerCase());
		for (WebElement currentSuggestion : autoCompleteSuggestionList) {

			if (drug.equalsIgnoreCase(currentSuggestion.getText().trim())) {
				currentSuggestion.click();
				break;
			}
		}
		return new AddDrugDetails(driver);

	}
	public AddDrugDetails submit() throws InterruptedException{
//		if(searchButton.isDisplayed()){
//			searchButton.click();
//		}
		//searchButton.click();
		//waitforElement(continueButton);
		Thread.sleep(10000);
		if(continueButton.isDisplayed()){
			continueButton.click();
		}
		
		Thread.sleep(5000);
		return new AddDrugDetails(driver);
	}
	
	public void verifyExceededError(){
		exceededError.isDisplayed();
	}
	public DrugCostEstimatorPage cancel(){
		waitforElement(cancelButton);
		cancelButton.click();
		return new DrugCostEstimatorPage(driver);
	}
	
	public AddDrugDetails continueAddNewDrugModal(){
		waitforElement(continueButton);
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		continueButton.click();
		return new AddDrugDetails(driver);
	}
	
	public void validate_atleast_4_mesg()
	{
		waitforElement(atleast_4_mesg);
		
	}
}

