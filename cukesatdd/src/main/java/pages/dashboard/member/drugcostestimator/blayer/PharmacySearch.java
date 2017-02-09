package pages.dashboard.member.drugcostestimator.blayer;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PharmacySearch extends UhcDriver{

	public PharmacySearch(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		String filename = CommonConstants.SELECT_PHARMACY_BLUE_LAYER_PAGE_DATA; //not sure about this
	}
	
	private PageData selectPharmacy; //tentative name
	
	private JSONObject selectPharmacyJson;
	
	@FindBy (xpath = "//div[@id='dce.member']/div[2]/div/div/div/div/div/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a/p[2]")
	public WebElement Step2PharmacyTab;
	
	@FindBy(className = "milesSelection")
	public WebElement MilesSelection;
	
	@FindBy (xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div/div[2]/div[3]/span[1]")
	public WebElement Zipcode;
	
	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div/div[2]/div[3]/a[1]")
	public WebElement SearchLink; //is it the same thing?
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[1]/p")
	public WebElement StandardNetworkPharmaciesRadioButton;
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[2]/div/p")
	public WebElement PharmacyNetworkPharmacyRadioButton;
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[4]/p")
	public WebElement PreferredMailServicePharmacyRadioButton;
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[2]/div/span[3]/div")
	public WebElement PreferredRetailSavingMsg;
	
	@FindBy(className = "tablePharmacy")
	public WebElement PharmacyList;
	
	@FindBy(xpath = "//span[contains(./text(),'Men')]")
	public WebElement PharmacyName;
	
	

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		JSONObject jsonObject = new JSONObject();
		for (String key : selectPharmacy.getExpectedData().keySet()) {
			WebElement element = findElement(selectPharmacy.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		selectPharmacyJson = jsonObject;

		System.out.println("selectPharmacyJson----->" + selectPharmacyJson);
	}
	
	public void selectStep2Pharmacy(){
		Step2PharmacyTab.click();
	}
	public void editZipcode(String zip){
		sendkeys(Zipcode,zip); //not sure what webelement to use
	}
	
	public void selectMiles(String mile){
		Select options = new Select(MilesSelection);
		options.selectByVisibleText(mile);
	}

	public void editZipcodeLink(){
		SearchLink.click();
	}
	
	public void selectPharmacyType(){
		
	}
}
