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


	@FindBy(xpath = "//*[@id='drugPopHeading']")
	public WebElement TellUsABoutHeader;
	
	@FindBy(xpath = "//img[@class='uhc-modal__close']")
	public WebElement TellUsABoutCloseBtn;

	@FindBy(xpath = "//*[contains(@for,'radio-1-input')]//div[contains(@class,'label')]")
	public WebElement BrandDrugRadio;
	
	@FindBy(xpath = "//*[contains(@for,'radio-2-input')]//div[contains(@class,'label')]")
	public WebElement GenericDrugRadio;
	
	
	public TellUsAboutDrug(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(TellUsABoutHeader);
		validateNew(TellUsABoutCloseBtn);
	}

	public void validateBrandDrugPage(String BrandDrugName, String genericDrugName) {
		validateNew(BrandDrugRadio);
		validateNew(GenericDrugRadio);
		if(BrandDrugRadio.getText().contains(BrandDrugName) && BrandDrugRadio.isEnabled() && GenericDrugRadio.getText().contains(genericDrugName)) {
			System.out.println("Brand Name and Generic Drug Options are displayed and Brand Name Option is Selected by default");
			
		}
		else {
			Assert.fail("Brand Name and Generic Drug options NOT Validated");
		}
		
		
	}


}
