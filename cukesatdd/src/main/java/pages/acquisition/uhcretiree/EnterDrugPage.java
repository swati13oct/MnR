package pages.acquisition.uhcretiree;

/*@author eb*/

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
	

	private PageData formularyList;
	public JSONObject formularyListJson;
	
	public EnterDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ENTER_DRUG_PAGE_DATA;
		formularyList = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
		openAndValidate();
		//enterDrugName();
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
		//System.out.println(getDrugNameJson());
		//return getDrugNameJson();
		if (driver.getTitle().equalsIgnoreCase(
				"Drug Search - G16 MAPD")) {
			return new EnterDrugPage(driver);
		}
		//return getOurPlanDropDownJson();
		return null;

	}


	public SelectDosagePage clickDrugName(String drugName) {
		driver.findElement(By.className(drugName)).click();
		//System.out.println(getTitle());
		return new SelectDosagePage(driver);
	}

}