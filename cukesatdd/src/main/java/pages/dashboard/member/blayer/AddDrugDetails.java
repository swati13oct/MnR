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

public class AddDrugDetails extends UhcDriver {

	private PageData adddrugdetails;

	public JSONObject adddrugdetailsJson;

	@FindBy(xpath = "//span[contains(text(),'Add Drug Details')]")
	public WebElement AddDrugDetailsPage;

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
	public AddDrugDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, AddDrugDetailsPage, 10);
		String fileName = CommonConstants.ADD_DRUG_DETAILS_PAGE_DATA;
		//	adddrugdetails = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		//openAndValidate();
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : adddrugdetails.getExpectedData().keySet()) {
			WebElement element = findElement(adddrugdetails.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		adddrugdetailsJson = jsonObject;

		System.out.println("addnewdrugJson----->" + adddrugdetailsJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject newPaymentHistoryExpectedJson = expectedDataMap.get(CommonConstants.ADD_DRUG_DETAILS);

		return newPaymentHistoryExpectedJson;
	}
	public void selectDosage(String dosage){
		WebElement element = driver.findElement(By.xpath("//input[@value='"+dosage+"']"));
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
		options.selectByVisibleText(frquency);
	}

	public void continueAddDrugDetails(){
		waitforElement(continueButton);
		continueButton.click();
	}
	public AddNewDrugModal backToSeach(){
		backToSearchBtn.click();
		return new AddNewDrugModal(driver);
	}
	public void validateThePage(){
		Assert.assertTrue(AddDrugDetailsPage.isDisplayed());
	}

}
