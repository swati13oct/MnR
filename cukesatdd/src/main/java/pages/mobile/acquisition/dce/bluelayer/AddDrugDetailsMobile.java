package pages.mobile.acquisition.dce.bluelayer;

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
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.bluelayer.SavingsOppurtunity;
import pages.acquisition.ulayer.PageTitleConstants;

public class AddDrugDetailsMobile extends UhcDriver {

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

	@FindBy(xpath = "//*[@id=\"alt-search-radios\"]/div/div[1]//label")
	public WebElement btndrugName;

	@FindBy(id = "frequency")
	public WebElement selectYourFrequencyDropdown;

	public AddDrugDetailsMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
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

	public void selectDosage(String dosage) {

		WebElement element = driver.findElement(By.xpath("//input[@value='" + dosage + "']/following-sibling::label"));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void selectQnty(String qnty) {
		waitforElement(quantityField);
		sendkeys(quantityField, qnty);
	}

	public void selectFrequency(String frquency) {
		Select options = new Select(selectYourFrequencyDropdown);
		if (frquency.equalsIgnoreCase("Every 1 month")) {
			options.selectByValue("30");
		}
		if (frquency.equalsIgnoreCase("Every 3 months")) {
			options.selectByValue("90");
		}
	}

	public SavingsOppurtunityMobile continueAddDrugDetailsModal() throws InterruptedException {
		waitforElement(continueButton);
		continueButton.click();
		// continueButton.click();
		Thread.sleep(12000);
		return new SavingsOppurtunityMobile(driver);
	}

	public DrugCostEstimatorPageMobile continueAddDrugDetailsMod() throws InterruptedException {
		waitforElement(continueButton);
		continueButton.click();
		Thread.sleep(12000);
		return new DrugCostEstimatorPageMobile(driver);
	}

	public SavingsOppurtunityMobile continueAddDrugDetails() {

		waitforElement(continueButton);
		continueButton.click();
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_SAVINGS_OPPORTUNITY)) {
			return new SavingsOppurtunityMobile(driver);
		}
		return null;
	}

	public AddNewDrugModalMobile backToSeach() {
		backToSearchBtn.click();
		return new AddNewDrugModalMobile(driver);
	}

	public void validateThePage() {
		Assert.assertTrue(addDrugDetailsPage.isDisplayed());
	}

	public SavingsOppurtunityMobile continueAddDrugDetailsModWithSaving() throws InterruptedException {
		scrollToView(continueButton);
		continueButton.click();

		return new SavingsOppurtunityMobile(driver);
	}

	public DrugCostEstimatorPage continueAddDrugDetailsModNoSaving() throws InterruptedException {
		validateNew(continueButton);
		continueButton.click();
		return new DrugCostEstimatorPage(driver);
	}

	public void selectDosageAttribute(String dosage) throws InterruptedException {
		if (btndrugName.getText().equalsIgnoreCase(dosage))
			btndrugName.click();
	}

}
