package pages.memberrdesignVBF;

import java.util.List;
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

	@FindBy(className = "loading-dialog")
	public List<WebElement> loadingImages;

	public AddDrugDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : adddrugdetails.getExpectedData().keySet()) {
			WebElement element = findElement(adddrugdetails.getExpectedData().get(key));
			if (null != element) {
				validateNew(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					System.out.println(e.getMessage());
				}

			}
		}
		adddrugdetailsJson = jsonObject;

		System.out.println("addnewdrugJson----->" + adddrugdetailsJson);
	}

/***
 * 
 * @return
 * @throws InterruptedException
 */
	public SavingsOppurtunity continueAddDrugDetailsModal() throws InterruptedException {
		validateNew(continueButton);
		continueButton.click();
		if (!(loadingImages.isEmpty())) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
		}
		return new SavingsOppurtunity(driver);
	}


}
