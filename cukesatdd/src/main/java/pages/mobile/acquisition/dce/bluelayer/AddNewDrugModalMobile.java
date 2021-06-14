package pages.mobile.acquisition.dce.bluelayer;
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
public class AddNewDrugModalMobile extends UhcDriver {

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
	
	
	public AddNewDrugModalMobile(WebDriver driver) {
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
	public AddDrugDetailsMobile clickonSearchButton(String DrugName) {
		//drugsearchinput.click();
		drugsearchinput.sendKeys(DrugName);
		searchButton.click();     
		waitforElement(continueButton);
		continueButton.click();
		//if (driver.getTitle().equalsIgnoreCase("ADD A NEW DRUG")) {
			return new AddDrugDetailsMobile(driver);
		//}
		//return null;
	}
	
	public void typeDrugName(String DrugName) {
		drugsearchinput.sendKeys(DrugName);
	}
	public AddDrugDetailsMobile selectDrug(String drugname){
		String xpath = "//label[contains(text(),'"+drugname+"')]/parent::div/input[contains(@id,'drugs-')]";
		WebElement rdrug = driver.findElement(By.xpath(xpath));
		if(!rdrug.isSelected()){
			rdrug.click();
		}
		waitforElement(continueButton);
		continueButton.click();
		return new AddDrugDetailsMobile(driver);
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
	public AddDrugDetailsMobile submit() throws InterruptedException{
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
		return new AddDrugDetailsMobile(driver);
	}
	
	public void verifyExceededError(){
		exceededError.isDisplayed();
	}
	public DrugCostEstimatorPageMobile cancel(){
		waitforElement(cancelButton);
		cancelButton.click();
		return new DrugCostEstimatorPageMobile(driver);
	}
	
	public AddDrugDetailsMobile continueAddNewDrugModal(){
		waitforElement(continueButton);
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		continueButton.click();
		return new AddDrugDetailsMobile(driver);
	}
	
	public void validate_atleast_4_mesg()
	{
		waitforElement(atleast_4_mesg);
		
	}
}

