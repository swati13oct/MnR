package pages.acquisition.dce;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import atdd.framework.UhcDriver;
public class AddNewDrugModal extends UhcDriver {

	private PageData addnewdrug;

	public JSONObject addnewdrugJson;

	@FindBy(id = "drug-search-button")
	public WebElement searchButton;


	@FindBy(xpath = "//header[@class='add-drug-slide-header']/span[contains(text(),'Add a new drug')]")
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
	
	
	public AddNewDrugModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addNewDrugHeading, 10);
		//String fileName = CommonConstants.ADD_NEW_DRUG_PAGE_DATA;
		//addnewdrug = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_DCE_MEMBER);
		//openAndValidate();
	}
	@Override
	public void openAndValidate() {

		
		JSONObject jsonObject = new JSONObject();
		for (String key : addnewdrug.getExpectedData().keySet()) {
			WebElement element = findElement(addnewdrug.getExpectedData()
					.get(key));
			if (null != element) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		addnewdrugJson = jsonObject;
		System.out.println("addDrugJson----->"+addnewdrugJson);
	
		
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject addnewdrugExpectedJson = expectedDataMap.get(CommonConstants.ADD_NEW_DRUG_MODAL);

		return addnewdrugExpectedJson;
	}
	public AddDrugDetails clickonSearchButton(String DrugName) throws InterruptedException {
		//drugsearchinput.click();
		drugsearchinput.sendKeys(DrugName);
		Thread.sleep(3000);
		searchButton.click();
		waitforElement(continueButton);
		continueButton.click();
		//if (driver.getTitle().equalsIgnoreCase("ADD A NEW DRUG")) {
			return new AddDrugDetails(driver);
		//}
		//return null;
	}
	
	public void typeDrugName(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
		searchButton.click();
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
	public void selectAdrugFromAutoCompleteSuggestions(String drug){
		List<WebElement> elements = driver.findElements(By.className("autocomplete-suggestions"));
		for(WebElement element : elements){
			
			if(drug.equalsIgnoreCase(element.getText())){
				element.click();
				break;
			}
		}
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

