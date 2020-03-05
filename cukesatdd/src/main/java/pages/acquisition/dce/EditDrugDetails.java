package pages.acquisition.dce;
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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EditDrugDetails extends UhcDriver {

	private PageData editdrugdetails;

	public JSONObject editdrugdetailsJson;

	@FindBy(xpath = "//span[contains(text(),'Edit Drug Details')]")
	public WebElement editDrugDetailsPage;

	@FindBy(xpath = "//button[@class='cta-button popUpdate']")
	public WebElement updateButton;

	@FindBy(xpath = "//input[@value='Lipitor TAB 10MG']")
	public WebElement Dosageone;

	@FindBy(id = "quantity")
	public WebElement quantityField;
	
	@FindBy(id = "drug-alt-back-button")
	public WebElement backToSearchBtn;
	
	@FindBy(id = "frequency")
	public WebElement selectYourFrequencyDropdown;
	public EditDrugDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		String fileName = CommonConstants.ADD_DRUG_DETAILS_PAGE_DATA;
		editdrugdetails = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_DCE_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : editdrugdetails.getExpectedData().keySet()) {
			WebElement element = findElement(editdrugdetails.getExpectedData().get(key));
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
		editdrugdetailsJson = jsonObject;

		System.out.println("addnewdrugJson----->" + editdrugdetailsJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject addDrugDetailsPageExpectedJson = expectedDataMap.get(CommonConstants.ADD_DRUG_DETAILS);

		return addDrugDetailsPageExpectedJson;
	}
	public void selectDosage(String dosage){
	
		WebElement element = driver.findElement(By.xpath("//input[@value='"+dosage+"']/following-sibling::label"));
		if(!element.isSelected()){
			element.click();
		}
	}

	public void selectQnty(String qnty){
		waitforElement(quantityField);
		sendkeys(quantityField, qnty);
	}

	public void selectFrequency(String frquency){
		Select options = new Select(selectYourFrequencyDropdown);
		if(frquency.equalsIgnoreCase("Every 1 month")){
			options.selectByValue("30");
		}
		if(frquency.equalsIgnoreCase("Every 3 months")){
			options.selectByValue("90");
		}
	}

//	public SavingsOppurtunity continueAddDrugDetailsModal() throws InterruptedException{
//		waitforElement(continueButton);
//		continueButton.click();
//		continueButton.click();
//		Thread.sleep(12000);
//		return new SavingsOppurtunity(driver);
//		}
//	
	public DrugCostEstimatorPage updateEditDrugDetails() throws InterruptedException{
		waitforElement(updateButton);
		updateButton.click();
		Thread.sleep(12000);
		return new DrugCostEstimatorPage(driver);
		}
//	public SavingsOppurtunity continueAddDrugDetails(){
//		
//		waitforElement(updateButton);
//		updateButton.click();
//		if (driver.getTitle().equalsIgnoreCase("SAVINGS OPPORTUNITY")) {
//			return new SavingsOppurtunity(driver);
//		}
//		return null;
//	}
//	public AddNewDrugModal backToSeach(){
//		backToSearchBtn.click();
//		return new AddNewDrugModal(driver);
//	}
	public void validateThePage(){
		Assert.assertTrue(editDrugDetailsPage.isDisplayed());
	}

}
