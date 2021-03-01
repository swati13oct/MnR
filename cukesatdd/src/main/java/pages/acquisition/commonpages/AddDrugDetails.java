package pages.acquisition.commonpages;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class AddDrugDetails extends UhcDriver {

	public JSONObject adddrugdetailsJson;

	@FindBy(id = "addheadDetails_id")
	public WebElement addDrugDetailsPageHeading;

	@FindBy(id = "drug-dosage-button")
	public WebElement continueButton;
	
	@FindBy(xpath = "//*[contains(@id,'dosage')]//select")  
	public WebElement dosageDropdown;

	@FindBy(id = "quantity")
	public WebElement quantityField;
	
	@FindBy(id = "drug-alt-back-button")
	public WebElement backToSearchBtn;

	@FindBy(xpath = "//div[@class='loading-dialog'][not (contains(@style,'display: none;'))]")
	public WebElement loadingDialog;
	
	@FindBy(id = "frequency")
	public WebElement selectYourFrequencyDropdown;
	
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

	public void selectDosage(String dosage) throws InterruptedException{

		/*WebElement drugDosage = driver.findElement(By.xpath(".//*[@id='dosage-radios']//label[contains(text(),'"+dosage+"')]"));
		drugDosage.click();*/
		selectFromDropDownByText(driver, dosageDropdown, dosage);
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
		Assert.assertTrue(addDrugDetailsPageHeading.isDisplayed());
	}

}
