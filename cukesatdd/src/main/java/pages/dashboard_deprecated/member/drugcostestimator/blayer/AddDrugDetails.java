package pages.dashboard_deprecated.member.drugcostestimator.blayer;
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

/**
 * Functionality: Covers all elements and methods for Add Drugs Detail Modal
 */
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
	public AddDrugDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		String fileName = CommonConstants.ADD_DRUG_DETAILS_PAGE_DATA;
		adddrugdetails = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_DCE_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : adddrugdetails.getExpectedData().keySet()) {
			WebElement element = findElement(adddrugdetails.getExpectedData().get(key));
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
		adddrugdetailsJson = jsonObject;

		System.out.println("addnewdrugJson----->" + adddrugdetailsJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject addDrugDetailsPageExpectedJson = expectedDataMap.get(CommonConstants.ADD_DRUG_DETAILS);

		return addDrugDetailsPageExpectedJson;
	}

	/** select dosage of the drug
	 * 
	 */
	public void selectDosage(String dosage){

		WebElement element = driver.findElement(By.xpath("//input[@value='"+dosage+"']"));
		if(!element.isSelected()){
			element.click();
		}
	}

	/** select qnty quantity of the drug
	 * 
	 */
	public void selectQnty(String qnty){
		waitforElement(quantityField);
		sendkeys(quantityField, qnty);
	}

	/** select frequency of the drug
	 * 
	 */
	public void selectFrequency(String frquency){
		Select options = new Select(selectYourFrequencyDropdown);
		if(frquency.equalsIgnoreCase("Every 1 month")){
			options.selectByValue("30");
		}
		if(frquency.equalsIgnoreCase("Every 3 months")){
			options.selectByValue("90");
		}
	}

	/** Click on continue button 
	 * For branded drug 
	 * returns new SavingsOppurtunity
	 */
	public SavingsOppurtunity continueAddDrugDetailsModal() throws InterruptedException{
		waitforElement(continueButton);
		continueButton.click();
		//continueButton.click();
		Thread.sleep(12000);
		return new SavingsOppurtunity(driver);
	}

	/** Click on continue button 
	 * For generic drug
	 * returns new DrugCostEstimatorPage
	 */
	public DrugCostEstimatorPage continueAddDrugDetailsMod() throws InterruptedException{
		waitforElement(continueButton);
		continueButton.click();
		Thread.sleep(12000);
		return new DrugCostEstimatorPage(driver);
	}

	/** ToDo - Need to remove this method 
	 * 
	 */
	public SavingsOppurtunity continueAddDrugDetails(){

		waitforElement(continueButton);
		continueButton.click();
		if (driver.getTitle().equalsIgnoreCase("SAVINGS OPPORTUNITY")) {
			return new SavingsOppurtunity(driver);
		}
		return null;
	}

	/** Click on backToSeach button 
	 * 
	 * returns new AddNewDrugModal
	 */
	public AddNewDrugModal backToSeach(){
		backToSearchBtn.click();
		return new AddNewDrugModal(driver);
	}

	/** Validation of addDrugDetailsPage
	 *
	 */
	public void validateThePage(){
		Assert.assertTrue(addDrugDetailsPage.isDisplayed());
	}

}
