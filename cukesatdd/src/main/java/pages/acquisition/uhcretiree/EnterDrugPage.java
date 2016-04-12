package pages.acquisition.uhcretiree;

/*@author eb*/

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EnterDrugPage extends UhcDriver {

	@FindBy(id = "drugNameFilter")
	private WebElement drugInputField;

	@FindBy(xpath="/html/body/div/div/div/div/div[3]/div/div[6]/div/div/div/div[2]/div/div/div")
	public static WebElement findDrugBtn;

	public EnterDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	@Override
	public void openAndValidate() {
		//		validate(specificDrugLink);

	}

//	public JSONObject getDrugNameJson(){
//		String fileName = CommonConstants.OUR_PLANS_NAV_PAGE_DATA;
//		ourPlansNav = CommonUtility.readPageData(fileName,
//				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
//
//		JSONObject jsonObject = new JSONObject();
//		for (String key : ourPlansNav.getExpectedData().keySet()) {
//			WebElement element = findElement(ourPlansNav.getExpectedData()
//					.get(key));
//			if (element != null) {
//				if(validate(element)){
//					try {
//						jsonObject.put(key, element.getText());
//					} catch (JSONException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		ourPlansNavJson = jsonObject;
//		return ourPlansNavJson;
//	}
//
//	public JSONObject enterDrugName(String drugName) {
//		validate(drugInputField);
//		drugInputField.sendKeys(drugInputField);
//		findDrugBtn.click();		
//		return getOurPlanDropDownJson();
//
//	}

}