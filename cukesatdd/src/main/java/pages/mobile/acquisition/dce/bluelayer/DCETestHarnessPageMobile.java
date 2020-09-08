package pages.mobile.acquisition.dce.bluelayer;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
public class DCETestHarnessPageMobile extends UhcDriver{
	private PageData switchgeneric;

	public JSONObject switchgenericJson;
	

	@FindBy(id="drug-alt-search-button")
	public WebElement continueButton;
	
	@FindBy(xpath="//input[contains(@ng-model, 'Zip')]")
	public WebElement ZipCode;
	
	@FindBy(xpath="//button[contains(@type ,'submit') and contains(text(), 'Search')]")
	public WebElement ZipSearch;
	
	@FindBy(xpath="//select[contains(@id ,'dce-county-select')]")
	public WebElement CountyDropDown;
	
	@FindBy(xpath="//select[contains(@id ,'plan-select')]")
	public WebElement PlanDropDown;

	@FindBy(xpath="//button[contains(@type ,'submit') and contains(text(), 'DCE')]")
	public WebElement DCEbutton_StartDCE;

	public DCETestHarnessPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, ZipCode, 10);
		try {
			openAndValidate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void openAndValidate() throws InterruptedException {
		validateNew(ZipCode);
		validateNew(ZipSearch);
	}

	

	public void enterZipandSearch(String ZIP) {
		ZipCode.sendKeys(ZIP);
		jsClickNew(ZipSearch);
	}


	public void SelectCounty(String countyName) {
		validateNew(CountyDropDown);		
		jsClickNew(CountyDropDown);
		WebElement CountySelection = driver.findElement(By.xpath("//option[contains(text(), '"+countyName+"')]"));
		CountySelection.click();
		
	}


	public void selectPlan(String planName) {
		validateNew(PlanDropDown);		
		jsClickNew(PlanDropDown);
		WebElement CountySelection = driver.findElement(By.xpath("//option[contains(text(), '"+planName+"')]"));
		CountySelection.click();	
	}


	public DrugCostEstimatorPageMobile StartDCE() {
	
		validateNew(DCEbutton_StartDCE);
		jsClickNew(DCEbutton_StartDCE);

		return new DrugCostEstimatorPageMobile(driver);
	}
	

}
