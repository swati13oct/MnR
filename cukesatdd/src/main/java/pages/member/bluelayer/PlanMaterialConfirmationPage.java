/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PlanMaterialConfirmationPage extends UhcDriver {

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData planMaterials;

	public JSONObject planMaterialsConfirmationJson;

	public PlanMaterialConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ORDER_PLAN_MATERIALS_PAGE_DATA;
		planMaterials = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}
	public void validatePlanName(){
    	String planName = LoginCommonConstants.PLAN_NAME;
    	System.out.println(planName);
    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
    	for(int i=0; i<planWebElement.size();i++){
    		if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
    			System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
    			Assert.fail();
    		}
    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
    			System.out.println("----------Plan name displayed as expected="+planName);
    		} else{
	    			System.out.println("----------Failed because Plan NAme not present");
	    			Assert.fail();
	    		} 	  		 
    	}
 }
	@Override
	public void openAndValidate() {

		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : planMaterials.getExpectedData().keySet()) {
			WebElement element = findElement(planMaterials.getExpectedData()
					.get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		planMaterialsConfirmationJson = jsonObject;
		
		System.out.println("planMaterialsConfirmationJson----->"+planMaterialsConfirmationJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		// expected data for ORDER PLAN MATERIALS
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject planMaterialsExpectedJson = expectedDataMap
				.get(CommonConstants.ORDER_PLAN_MATERIALS);
		planMaterialsExpectedJson = CommonUtility.mergeJson(
				planMaterialsExpectedJson, globalExpectedJson);
		return planMaterialsExpectedJson;
	}

}
