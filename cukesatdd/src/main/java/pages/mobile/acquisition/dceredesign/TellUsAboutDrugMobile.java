package pages.mobile.acquisition.dceredesign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;


public class TellUsAboutDrugMobile extends UhcDriver {


//	@FindBy(id="modal-label")
	@FindBy(css = "div[class*='tellusyourdrugModal']  #modal-label")
	public WebElement TellUsAboutHeader;
	
//	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	@FindBy(css = "div[class*='tellusyourdrugModal']  #cancelicon")
	public WebElement TellUsAboutCloseBtn;

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

//	@FindBy(xpath = "//button//*[contains(text(),'Add to drug List')]")
	@FindBy(css = "button[dtmname$='add to drug list']")
	public WebElement AddDrugBtn;

	@FindBy(xpath = "//*[@id='quantitycontainer']//*[contains(@class, ' errtext')]")
	public WebElement BlankQuantityError;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;
	
	@FindBy(xpath = "//h2[normalize-space()='Build Your Drug List']")
	private WebElement buildYourDrugListHeader;
	
	@FindBy(css = "#adddrug")
	private WebElement addDrugButtonBuildDrugList;
	
	@FindBy(css = "#previousButton")
	private WebElement previousGetStartedButton;
	
	@FindBy(xpath = "//select[contains(@id, 'selectdosage')]")
	public WebElement SelectDosageDrpDwn;
	
	@FindBy(xpath = "//select[contains(@id, 'new-drug-packaging')]")
	public WebElement SelectPackageDrpDwn;
	
	@FindBy(xpath = "//input[contains(@id, 'drugquantity')]")
	public WebElement QuantityTxt;
	
//	@FindBy(xpath = "//select[contains(@id, 'new-drug-frequency')]")
	@FindBy(css = "#selectdosage")
	public WebElement FrequencyDrpDwn;
	
	@FindBy(xpath = "//select[contains(@id, 'new-drug-refill')]")
	public WebElement supplyLengthDrpDwn;

	public TellUsAboutDrugMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(TellUsAboutHeader);
		validateNew(TellUsAboutCloseBtn);
		scrollToView(AddDrugBtn);
		
		validateNew(supplyLengthDrpDwn);
		validateNew(FrequencyDrpDwn);
		validateNew(QuantityTxt);
	}

	public void validateBrandDrugPage(String BrandDrugName, String genericDrugName) {
		BrandDrugName = BrandDrugName.toLowerCase();
		genericDrugName = genericDrugName.toLowerCase();
		
		WebElement BrandDrugRadio = driver.findElement(By.xpath("//uhc-radio[contains(@dtmname, '"+BrandDrugName+"')]"));
		WebElement GenericDrugRadio = driver.findElement(By.xpath("//uhc-radio[contains(@dtmname, '"+genericDrugName+"')]"));
		//input
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
		System.out.println("Quantity cleared : "+DrugQuantityTxtBx.getText());
		jsClickNew(DrugQuantityTxtBx);
		if(DrugQuantityTxtBx.getText().isEmpty()) {
			validateNew(AddDrugBtn);
			jsClickNew(AddDrugBtn);
			if(validateNew(BlankQuantityError) && BlankQuantityError.getText().contains("enter a valid quantity between 1 and 999")) {
				System.out.println("Error Message displayed for Blank Quantity search : "+BlankQuantityError.getText());
				DrugQuantityTxtBx.sendKeys(Quantity);
			}
			else
				Assertion.fail("Error Message displayed for Blank Quantity search : "+BlankQuantityError.getText());

		}
		else {
			Assertion.fail("Drug Quantity Text Box NOT Cleared : "+DrugQuantityTxtBx.getText());

		}
						
	}

	public BuildYourDrugListMobile ClickAddDrug() {
		jsClickNew(AddDrugBtn);
		CommonUtility.waitForPageLoad(driver, buildYourDrugListHeader, 30);
		if (validateNew(addDrugButtonBuildDrugList)) {
			Assertion.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugListMobile(driver);
		}
		Assertion.fail("Did not Navigate to Build Drug List Page");
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
		sendkeysNew(QuantityTxt, Quantity);
		
	}

	public void selectFrequency(String Frequency) {
		validateNew(FrequencyDrpDwn);
		jsClickNew(FrequencyDrpDwn);
		WebElement element = driver.findElement(By.xpath("//select[@id='drugfrequency']//option[contains(text(), '"+Frequency+"')]"));
		jsClickNew(element);
	}

	public void selectSupplyLength(String SupplyLength) {
		validateNew(supplyLengthDrpDwn);
		jsClickNew(supplyLengthDrpDwn);
		WebElement element = driver.findElement(By.xpath("//select[@id='new-drug-refill']//option[contains(text(), '"+SupplyLength+"')]"));
		jsClickNew(element);
	
	}
}
