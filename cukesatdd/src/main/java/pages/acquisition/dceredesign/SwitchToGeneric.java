package pages.acquisition.dceredesign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;

public class SwitchToGeneric extends UhcDriver {


	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;
	
	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement SwitchPageCloseBtn;

	/*
	 * @FindBy(xpath =
	 * "//*[contains(@for,'radio-1-input')]//div[contains(@class,'label')]") public
	 * WebElement BrandDrugRadio;
	 * 
	 * @FindBy(xpath =
	 * "//*[contains(@for,'radio-2-input')]//div[contains(@class,'label')]") public
	 * WebElement GenericDrugRadio;
	 */	
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

	public SwitchToGeneric(WebDriver driver) {
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


	@FindBy(xpath = "//*[contains(@class, 'd-lg-block')]//button[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'plans in your area')]")
	public WebElement LinkToDrugSummary;
	
	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button') and contains(text(), 'Return to')]")
	public WebElement LinktoExitScenario;
	
	public DrugDetailsPage ClickSwitch_ReturnDetailsPage() {
		validateNew(AddDrugBtn);
		jsClickNew(AddDrugBtn);
		pageloadcomplete();
		CommonUtility.waitForPageLoad(driver, DrugDetails_ChangePharmacyLnk, 30);
		if (validateNew(DrugDetails_ChangePharmacyLnk) && validateNew(LinktoExitScenario)) {
			Assertion.assertTrue("Naviagted to DCE Drug Details Page", true);
			return new DrugDetailsPage(driver);
		}
		Assertion.fail("Did not Navigate to DCE Drug Details Page");
		return null;
	}

	@FindBy(xpath = "//h2[contains(text(), 'Review Drug Costs')]")
	public WebElement reviewDrugCostPageHeading;

	public DrugSummaryPage ClickSwitch_ReturnSummaryPage() {
		validateNew(AddDrugBtn);
		jsClickNew(AddDrugBtn);
		pageloadcomplete();
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);

		if(validateNew(reviewDrugCostPageHeading)) {
			return new DrugSummaryPage(driver);
		}
		Assertion.fail("DCE - Drug Summary Page is not displayed");
		return null;
	}
	
	public void selectDosage(String Dosage) {
		validateNew(SelectDosageDrpDwn);
		jsClickNew(SelectDosageDrpDwn);
		WebElement Drug = driver.findElement(By.xpath("//select[@id='selectdosage']//option[contains(text(), '"+Dosage+"')]"));
		jsClickNew(Drug);
	}

	public void selectPackage(String Package) {
		validateNew(SelectPackageDrpDwn);
		jsClickNew(SelectPackageDrpDwn);
		WebElement element = driver.findElement(By.xpath("//select[@id='new-drug-packaging']//option[contains(text(), '"+Package+"')]"));
		jsClickNew(element);
	
	}
	
	public void selectQuantity(String Quantity) {
		validateNew(QuantityTxt);
		QuantityTxt.sendKeys(Quantity);
	}

	public void selectFrequency(String Frequency) {
		validateNew(FrequentyDrpDwn);
		jsClickNew(FrequentyDrpDwn);
		WebElement element = driver.findElement(By.xpath("//select[@id='new-drug-frequency']//option[contains(text(), '"+Frequency+"')]"));
		jsClickNew(element);
	}

	public void selectSupplyLength(String SupplyLength) {
		validateNew(supplyLengthDrpDwn);
		jsClickNew(supplyLengthDrpDwn);
		WebElement element = driver.findElement(By.xpath("//select[@id='new-drug-refill']//option[contains(text(), '"+SupplyLength+"')]"));
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
}
