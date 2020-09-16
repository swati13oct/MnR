package pages.acquisition.dceredesign;
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

import pages.acquisition.dceredesign.BuildYourDrugList;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

public class TellUsAboutDrug extends UhcDriver {


//	@FindBy(xpath = "//*[@id='drugPopHeading']")
	@FindBy(id="modal-label")
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
	@FindBy(xpath = "//input[@id= 'drugquantity']")
	public WebElement DrugQuantityTxtBx;

	@FindBy(xpath = "//button//*[contains(text(),'Add to drug List')]")
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
	
//	@FindBy(xpath = "//select[contains(@id, 'new-drug-frequency')]")
	@FindBy(id="selectdosage")
	public WebElement FrequentyDrpDwn;
	
	@FindBy(xpath = "//select[contains(@id, 'new-drug-refill')]")
	public WebElement supplyLengthDrpDwn;

	public TellUsAboutDrug(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(TellUsABoutHeader);
		validateNew(TellUsABoutCloseBtn);
		validateNew(AddDrugBtn);
		validateNew(supplyLengthDrpDwn);
//		validateNew(FrequentyDrpDwn);
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
		 * } else { Assert.fail("Brand Name and Generic Drug options NOT Validated"); }
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
				Assert.fail("Error Message displayed for Blank Quantity search : "+BlankQuantityError.getText());

		}
		else {
			Assert.fail("Drug Quantity Text Box NOT Cleared : "+DrugQuantityTxtBx.getText());

		}
						
	}

	public BuildYourDrugList ClickAddDrug() {
		validateNew(AddDrugBtn);
		jsClickNew(AddDrugBtn);
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugList(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
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
}
