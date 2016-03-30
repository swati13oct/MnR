package pages.drx;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;

/**
 * @author pagarwa5
 *
 */
public class GenericPortletHomePage extends GlobalWebElements {

	@FindBy(id = "inputZipCode")
	private WebElement zipCodeField;

	@FindBy(className = "panel-title-dce")
	private WebElement drugSearchTitle;

	@FindBys(value = { @FindBy(xpath = "//select[@id='inputCounty']/option") })
	private List<WebElement> countyList;

	@FindBy(xpath = "//select[@id='inputCounty']/option")
	private WebElement countyField;

	@FindBy(id = "inputStartDate")
	private WebElement effectiveDateFiled;

	@FindBys(value = { @FindBy(xpath = "//select[@id='inputPlanCategory']/option") })
	private List<WebElement> planCategoryList;

	@FindBy(id = "inputPlanCategory")
	private WebElement planCategoryField;

	@FindBys(value = { @FindBy(xpath = "//select[@id='inputPlan']/option") })
	private List<WebElement> planNameList;

	@FindBy(id = "inputPlan")
	private WebElement planNameField;

	@FindBy(id = "inputTransferredDrugCost")
	private WebElement tansferredDrugCostField;

	@FindBy(id = "inputTransferredTrOOp")
	private WebElement transferredTroopField;

	@FindBy(id = "body-container")
	private WebElement bodyContainer;

	@FindBy(id = "submitBtn")
	private WebElement submitButton;

	private static String GENERIC_PORTLET_URL = MRConstants.GENERIC_PORTLET_URL;

	public GenericPortletHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void openAndValidate() {

		start(GENERIC_PORTLET_URL);
		validate(zipCodeField);
		validate(countyField);
		validate(effectiveDateFiled);
		validate(planCategoryField);
		validate(planNameField);
		validate(tansferredDrugCostField);
		validate(transferredTroopField);
		validate(submitButton);
		validate(enterPlanInfoLink);
		validate(enterDrugsLink);
		validate(selectPharmacyLink);
		validate(planSummaryLink);

	}

	public DrugSearchPage enterPlanInfo(Map<String, String> memberAttributesMap) {

		if (memberAttributesMap != null && !memberAttributesMap.isEmpty()) {

			sendkeys(zipCodeField, memberAttributesMap.get("Zip Code"));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bodyContainer.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selectFromDropDown(countyList, memberAttributesMap.get("County"));
			bodyContainer.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			effectiveDateFiled.click();
			effectiveDateFiled.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			effectiveDateFiled.sendKeys(Keys.BACK_SPACE);
			effectiveDateFiled.sendKeys(memberAttributesMap
					.get("Effective  Date"));

			bodyContainer.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			selectFromDropDown(planCategoryList,
					memberAttributesMap.get("Plan Category"));
			bodyContainer.click();
			selectFromDropDown(planNameList,
					memberAttributesMap.get("Plan Name"));
			bodyContainer.click();
			sendkeys(tansferredDrugCostField,
					memberAttributesMap.get("Transferred Drug Cost"));
			sendkeys(transferredTroopField,
					memberAttributesMap.get("Transferred Troop"));
			submitButton.click();

			if (drugSearchTitle.getText().contains(
					"Add Drugs to Estimate Annual Prescription Drug Costs")) {
				return new DrugSearchPage(driver);
			}

		}
		return null;

	}
}
