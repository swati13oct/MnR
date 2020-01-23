package pages.acquisition.bluelayer;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.bluelayer.SavingsOppurtunity;

public class AddDrugDetails extends UhcDriver {

	private PageData adddrugdetails;

	public JSONObject adddrugdetailsJson;

	@FindBy(xpath = "//span[contains(text(),'Add Drug Details')]")
	public WebElement addDrugDetailsPage;

	@FindBy(id = "drug-dosage-button")
	public WebElement continueButton;

	@FindBy(xpath = "//input[@value='Lipitor TAB 10MG']")
	public WebElement Dosageone;

	@FindBy(id = "quantity")
	public WebElement quantityField;
	
	@FindBy(id = "drug-alt-back-button")
	public WebElement backToSearchBtn;
	
	@FindBy(id = "frequency")
	public WebElement selectYourFrequencyDropdown;
	
	@FindBy(id = "addheadDetails_id")
	public WebElement addDrugDetailsPageHeading;
	
	@FindBy(xpath = "//*[contains(@id,'dosage')]//select")
	public WebElement dosageDropdown;
	
	@FindBy(xpath = "//*[@id=\"alt-search-radios\"]/div/div[1]//label")
	public WebElement btndrugName;
	
	public AddDrugDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);	
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, addDrugDetailsPageHeading, 45);
		validateNew(selectYourFrequencyDropdown);
		validateNew(quantityField);
		//validateNew(dosageDropdown);
	}

	/*public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject addDrugDetailsPageExpectedJson = expectedDataMap.get(CommonConstants.ADD_DRUG_DETAILS);

		return addDrugDetailsPageExpectedJson;
	}*/
	public void selectDosage(String dosage){
	
		/*WebElement drugDosage = driver.findElement(By.xpath(".//*[@id='dosage-radios']//label[contains(text(),'"+dosage+"')]"));
		drugDosage.click();*/
		selectFromDropDownByText(driver, dosageDropdown, dosage);  //this can be used if select dropdown is brought back

	}
	
	public void selectDosageAttribute(String dosage) throws InterruptedException{
		if(btndrugName.getText().equalsIgnoreCase(dosage))
			btndrugName.click();
	}

	public void selectQnty(String qnty){
		sendkeysNew(quantityField, qnty);
	}

	public void selectFrequency(String frquency){
		selectFromDropDownByText(driver, selectYourFrequencyDropdown, frquency);
	}

	public SavingsOppurtunity continueAddDrugDetailsModal() throws InterruptedException{
		waitforElement(continueButton);
		continueButton.click();
		//continueButton.click();
		Thread.sleep(12000);
		return new SavingsOppurtunity(driver);
		}
	
	public DrugCostEstimatorPage continueAddDrugDetailsMod() throws InterruptedException{
		waitforElement(continueButton);
		continueButton.click();
		Thread.sleep(12000);
		return new DrugCostEstimatorPage(driver);
		}
	public SavingsOppurtunity continueAddDrugDetails(){
		
		waitforElement(continueButton);
		continueButton.click();
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_SAVINGS_OPPORTUNITY)) {
			return new SavingsOppurtunity(driver);
		}
		return null;
	}
	public AddNewDrugModal backToSeach(){
		backToSearchBtn.click();
		return new AddNewDrugModal(driver);
	}
	public void validateThePage(){
		Assert.assertTrue(addDrugDetailsPage.isDisplayed());
	}
	public SavingsOppurtunity continueAddDrugDetailsModWithSaving() throws InterruptedException{
		scrollToView(continueButton);
		continueButton.click();
		
		return new SavingsOppurtunity(driver);
		}
	
	public DrugCostEstimatorPage continueAddDrugDetailsModNoSaving() throws InterruptedException{
		validateNew(continueButton);
		continueButton.click();
		return new DrugCostEstimatorPage(driver);
		}
}
