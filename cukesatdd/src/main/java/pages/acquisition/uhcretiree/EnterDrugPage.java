package pages.acquisition.uhcretiree;

/*@author eb*/

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EnterDrugPage extends UhcDriver {

	@FindBy(id = "drugNameFilter")
	private WebElement drugInputField;

	@FindBy(xpath="/html/body/div[1]/div/div[1]/div/div[3]/div/div[8]/div/div/div/div[2]/div/div/div")
	public static WebElement findDrugBtn;
	
	@FindBy(name = "drugInitials")
	CharSequence[] drugInitials;
	
	@FindBy(id = "detailsPage")
	private WebElement detailsPage;
	
	private PageData formularyList;
	public JSONObject formularyListJson;
	
	public EnterDrugPage(WebDriver driver, boolean skipClick, String drugName) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ENTER_DRUG_PAGE_DATA;
		formularyList = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
		if (skipClick != true){
			openAndValidate();
		} else {
			//If it is already on the drug details page (skipClick == true) then send page a json object that contains "key":"skip"
			validate(drugInputField);
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("DrugName", drugName);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formularyListJson = jsonObject;
		}
		//enterDrugName();
	}


	public EnterDrugPage(WebDriver driver) {
		super(driver);
	}


	@Override
	public void openAndValidate() {
		validate(drugInputField);

		JSONObject jsonObject = new JSONObject();
		for (String key : formularyList.getExpectedData().keySet()) {
			WebElement element = findElement(formularyList.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		formularyListJson = jsonObject;
	}


	/*public JSONObject getDrugNameJson(){
		/*String fileName = CommonConstants.ENTER_DRUG_PAGE_DATA;
		PageData ourPlansNav = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);*/

	/*	JSONObject jsonObject = new JSONObject();
		for (String key : ourPlansNav.getExpectedData().keySet()) {
			WebElement element = findElement(ourPlansNav.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		JSONObject ourPlansNavJson = jsonObject;
		return ourPlansNavJson;
	}*/

	public EnterDrugPage enterDrugName(String drugName) {
		validate(drugInputField);
		drugInputField.sendKeys(drugName);
		findDrugBtn.click();	
		System.out.println(getTitle());
		String xpath = "/html/body/div[1]/div/div[1]/div/div[3]/div/div[11]/div/div/div/div[1]/h1";
		String text = driver.findElement(By.xpath(xpath)).getText().toUpperCase();
		
		/*Wait for the page to load. For some drugs, it finds it right away and goes directly to the drug details page. 
		* If this happens and the page is already on the Drug Details page. If it is, send true*/
		CommonUtility.waitForPageLoad(driver, detailsPage, 5);
		if (driver.getTitle().contains(
				"Drug Search")){
			return new EnterDrugPage(driver, driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase("DRUG DETAILS"), drugName);
		}
		//return getOurPlanDropDownJson();
		return null;

	}


	public SelectDosagePage clickDrugName(String drugName, boolean skipClick) {
		if (skipClick != true){
			driver.findElement(By.className(drugName.toLowerCase())).click();
		}
		//System.out.println(getTitle());
		return new SelectDosagePage(driver);
	}

}