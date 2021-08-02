package pages.mobile.acquisition.dceredesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugSummaryPage;


public class SwitchToGenericMobile extends UhcDriver {

	@FindBy(xpath = "//*[@id='drugPopHeading']")
	public WebElement TellUsABoutHeader;

	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement TellUsABoutCloseBtn;

	/*
	 * @FindBy(xpath =
	 * "//*[contains(@for,'radio-1-input')]//div[contains(@class,'label')]") public
	 * WebElement BrandDrugRadio;
	 * 
	 * @FindBy(xpath =
	 * "//*[contains(@for,'radio-2-input')]//div[contains(@class,'label')]") public
	 * WebElement GenericDrugRadio;
	 */

//	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	@FindBy(css = "#modal-label")
	public WebElement SwitchPageHeader;

//	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	@FindBy(css = "#cancelicon")
	public WebElement SwitchPageCloseBtn;
	
	@FindBy(xpath = "//input[@id= 'drugquantity']")
	public WebElement DrugQuantityTxtBx;

	@FindBy(xpath = "//button[@type= 'submit' and contains(@dtmname, 'confirm')]")
	public WebElement AddDrugBtn;

	@FindBy(xpath = "//*[@id='quantitycontainer']//*[contains(@class, ' errtext')]")
	public WebElement BlankQuantityError;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;
	
	@FindBy(xpath = "//select[contains(@id, 'selectdosage')]")
	public WebElement SelectDosageDrpDwn;
	
	@FindBy(xpath = "//select[contains(@id, 'new-drug-packaging')]")
	public WebElement SelectPackageDrpDwn;
	
	@FindBy(xpath = "//input[contains(@id, 'drugquantity')]")
	public WebElement QuantityTxt;
	
	@FindBy(xpath = "//select[contains(@id, 'new-drug-frequency')]")
	public WebElement FrequentyDrpDwn;
	
	@FindBy(xpath = "//select[contains(@id, 'new-drug-refill')]")
	public WebElement supplyLengthDrpDwn;

	public SwitchToGenericMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(SwitchPageHeader);
		validateNew(SwitchPageCloseBtn);
		validateNew(AddDrugBtn);
		validateNew(supplyLengthDrpDwn);
		validateNew(QuantityTxt);
	}

	public void validateBrandDrugPage(String BrandDrugName, String genericDrugName) {
		BrandDrugName = BrandDrugName.toLowerCase();
		genericDrugName = genericDrugName.toLowerCase();

		WebElement BrandDrugRadio = driver
				.findElement(By.xpath("//uhc-radio[contains(@dtmname, '" + BrandDrugName + "')]"));
		WebElement GenericDrugRadio = driver
				.findElement(By.xpath("//uhc-radio[contains(@dtmname, '" + genericDrugName + "')]"));
		// input
		validateNew(BrandDrugRadio);
		validateNew(GenericDrugRadio);
		/*
		 * if(BrandDrugRadio.isEnabled() && !GenericDrugRadio.isEnabled()) { System.out.
		 * println("Brand Name and Generic Drug Options are displayed and Brand Name Option is Selected by default"
		 * );
		 * 
		 * } else { Assertion.fail("Brand Name and Generic Drug options NOT Validated"); }
		 */

	}

	public void ValidateBlankQuantityError() {
		validateNew(DrugQuantityTxtBx);
		String Quantity = DrugQuantityTxtBx.getText();
		DrugQuantityTxtBx.clear();
		System.out.println("Quantity cleared : " + DrugQuantityTxtBx.getText());
		jsClickNew(DrugQuantityTxtBx);
		if (DrugQuantityTxtBx.getText().isEmpty()) {
			validateNew(AddDrugBtn);
			jsClickNew(AddDrugBtn);
			if (validateNew(BlankQuantityError)
					&& BlankQuantityError.getText().contains("enter a valid quantity between 1 and 999")) {
				System.out
						.println("Error Message displayed for Blank Quantity search : " + BlankQuantityError.getText());
				DrugQuantityTxtBx.sendKeys(Quantity);
			} else
				Assertion.fail("Error Message displayed for Blank Quantity search : " + BlankQuantityError.getText());

		} else {
			Assertion.fail("Drug Quantity Text Box NOT Cleared : " + DrugQuantityTxtBx.getText());

		}

	}

	public BuildYourDrugList ClickAddDrug() {
		validateNew(AddDrugBtn);
		jsClickNew(AddDrugBtn);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
		return null;
	}

	public void selectDosage(String Dosage) {
		validateNew(SelectDosageDrpDwn);
		jsClickNew(SelectDosageDrpDwn);
		WebElement Drug = driver
				.findElement(By.xpath("//select[@id='selectdosage']//option[contains(text(), '" + Dosage + "')]"));
		jsClickNew(Drug);
	}
	
	
//	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	@FindBy(xpath = "//h2[contains(text(),'Review Drug Costs')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPageMobile ClickSwitch_ReturnSummaryPage() {
		validateNew(AddDrugBtn);
		jsClickNew(AddDrugBtn);
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if(validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPageMobile(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}

	public void selectPackage(String Package) {
		validateNew(SelectPackageDrpDwn);
		jsClickNew(SelectPackageDrpDwn);
		WebElement element = driver.findElement(
				By.xpath("//select[@id='new-drug-packaging']//option[contains(text(), '" + Package + "')]"));
		jsClickNew(element);

	}

	public void selectQuantity(String Quantity) {
		validateNew(QuantityTxt);
		QuantityTxt.sendKeys(Quantity);
	}

	public void selectFrequency(String Frequency) {
		validateNew(FrequentyDrpDwn);
		jsClickNew(FrequentyDrpDwn);
		WebElement element = driver.findElement(
				By.xpath("//select[@id='new-drug-frequency']//option[contains(text(), '" + Frequency + "')]"));
		jsClickNew(element);
	}

	public void selectSupplyLength(String SupplyLength) {
		validateNew(supplyLengthDrpDwn);
		jsClickNew(supplyLengthDrpDwn);
		WebElement element = driver.findElement(
				By.xpath("//select[@id='new-drug-refill']//option[contains(text(), '" + SupplyLength + "')]"));
		jsClickNew(element);

	}

	public void validateSwitchPage(String genericDrug, String brandDrug) {
		WebElement GenericDrugText = driver.findElement(By.xpath("//h3//*[contains(text(), '"+genericDrug+"')]"));
		WebElement BrandDrugText = driver.findElement(By.xpath("//h3//*[contains(text(), '"+brandDrug+"')]"));
		WebElement SavingsText = driver.findElement(By.xpath("//*[contains(text(), 'save up to') and contains(text(), 'annually by switching to the generic')]"));
		openAndValidate();
		if(!validateNew(GenericDrugText) || !validateNew(BrandDrugText) || !validateNew(SavingsText)) {
			Assertion.fail("Switch To Generic Page Validation Failed");
		}
		Assertion.assertTrue("Switch To Generic Page Validation Passed", true);
	}

	@FindBy(css = "div[class*='d-block'] #changePharmacyLink")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(css = "a[dtmname$='plans in your area']")
	public WebElement LinkToDrugSummary;
	
	@FindBy(css = "#drugdetails div>div>a:only-child[class^='uhc-link']")
	public WebElement LinktoExitScenario;

	public DrugDetailsPageMobile ClickSwitch_ReturnDetailsPage() {
		validateNew(AddDrugBtn);
		jsClickNew(AddDrugBtn);
		CommonUtility.waitForPageLoad(driver, DrugDetails_ChangePharmacyLnk, 30);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(LinktoExitScenario)) {
			Assertion.assertTrue("Naviagted to DCE Drug Details Page", true);
			return new DrugDetailsPageMobile(driver);
		}
		Assertion.fail("Did not Navigate to DCE Drug Details Page");
		return null;
	}

}
