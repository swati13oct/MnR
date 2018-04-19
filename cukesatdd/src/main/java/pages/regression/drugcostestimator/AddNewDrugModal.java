package pages.regression.drugcostestimator;
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
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * Functionality: Covers all elements and methods for Add New Drug Modal in DCE
 */
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


	public AddNewDrugModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, addNewDrugHeading, 10);
		String fileName = CommonConstants.ADD_NEW_DRUG_PAGE_DATA;
		addnewdrug = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_DCE_MEMBER);
		openAndValidate();
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

	/** Click Search button 
	 * 
	 * returns new AddDrugDetails
	 */
	public AddDrugDetails clickonSearchButton(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
		searchButton.click();     
		if (driver.getTitle().equalsIgnoreCase("Our Add Drug Details®")) {
			return new AddDrugDetails(driver);
		}
		return null;
	}

	/** Enter DrugName in drug search input textbox
	 * 
	 * returns new AddDrugDetails
	 */
	public void typeDrugName(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
	}

	/** Select Drug with drugname radio button
	 * 
	 * returns new AddDrugDetails
	 */
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

	/** Verifies errorMessage on the page
	 * 
	 */
	public void verifyerror(){
		errorMessage.isDisplayed();
	}

	/** selects drug on the modal from auto suggestions
	 * 
	 */
	public void selectAdrugFromAutoCompleteSuggestions(String drug){
		List<WebElement> elements = driver.findElements(By.className("autocomplete-suggestions"));
		for(WebElement element : elements){

			if(drug.equalsIgnoreCase(element.getText())){
				element.click();
				break;
			}
		}
	}

	/** Click on search button followed by continue button in next modal
	 * 
	 * return new AddDrugDetails
	 */
	public AddDrugDetails submit() throws InterruptedException{
		searchButton.click();
		waitforElement(continueButton);
		continueButton.click();
		Thread.sleep(5000);
		return new AddDrugDetails(driver);
	}

	/** Verifies exceed error of the drug list
	 * 
	 */
	public void verifyExceededError(){
		exceededError.isDisplayed();
	}

	/** Clicks on cancel button 
	 * 
	 * return new DrugCostEstimatorPage
	 */
	public DrugCostEstimatorPage cancel(){
		waitforElement(cancelButton);
		cancelButton.click();
		return new DrugCostEstimatorPage(driver);
	}


	/** Clicks on continue button 
	 * 
	 * return new AddDrugDetails
	 */
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

	/** Validates at least 4 character error message 
	 * 
	 */
	public void validate_atleast_4_mesg()
	{
		waitforElement(atleast_4_mesg);

	}
}

