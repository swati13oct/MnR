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
 * @author pperugu
 *
 */
public class OneTimePaymentSuccessPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/div/div")
	private WebElement OneTimePaymentSuccess;

	private PageData oneTimePaymentSuccess;

	public JSONObject oneTimePaymentSuccessJson;

	public OneTimePaymentSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ONE_PAYMENT_SUCCESS_PAGE_DATA;
		oneTimePaymentSuccess = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public String getContent() {
		return OneTimePaymentSuccess.getText();
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
		for (String key : oneTimePaymentSuccess.getExpectedData().keySet()) {
			WebElement element = findElement(oneTimePaymentSuccess
					.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		oneTimePaymentSuccessJson = jsonObject;
		
		System.out.println("oneTimePaymentSuccessJson----->"+oneTimePaymentSuccessJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject oneTimePaymentExpectedJson = expectedDataMap
				.get(CommonConstants.ONE_TIME_PAYMENT_SUCCESS);
		oneTimePaymentExpectedJson = CommonUtility.mergeJson(
				oneTimePaymentExpectedJson, globalExpectedJson);
		return oneTimePaymentExpectedJson;
	}

}
