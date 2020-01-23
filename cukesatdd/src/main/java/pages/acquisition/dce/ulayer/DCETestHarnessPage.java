package pages.acquisition.dce.ulayer;
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
public class DCETestHarnessPage extends UhcDriver{
	
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

	public DCETestHarnessPage(WebDriver driver) {
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


	public void enterZipandSearch(String zipCode2) {
		// TODO Auto-generated method stub
		
	}


	public void SelectCounty(String countyName) {
		// TODO Auto-generated method stub
		
	}


	public void selectPlan(String planName) {
		// TODO Auto-generated method stub
		
	}
	

}
