/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
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
public class ContactUsPage extends UhcDriver{

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="//*[@id='secureWidget']/div[1]")
	private WebElement securewidget;
	
	@FindBy(xpath="//*[@id='addAnotherPlanLink']")	
	private WebElement addPlan;
	
	
	
	private PageData contactUs;

	public JSONObject contactUsJson;
	
	private JSONObject secureemailwidgetDataJson;
	
	private PageData secureemailwidgetData;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, addPlan, CommonConstants.TIMEOUT_30);
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {

		validate(addPlan);
		validate(logOut);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject contactUsExpectedJson = expectedDataMap
				.get(CommonConstants.CONTACT_US);
		contactUsExpectedJson = CommonUtility.mergeJson(
				contactUsExpectedJson, globalExpectedJson);
		return contactUsExpectedJson;
	}

	
	public void validatesecureemail()
	{
		if (securewidget.isDisplayed())
		{
			System.out.println("Secure widget is displayed");
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
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
	public JSONObject getsecurewidget() {
		String fileName = CommonConstants.AARPM_SECURE_EMAIL_DATA;
		secureemailwidgetData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : secureemailwidgetData.getExpectedData().keySet()) {
			WebElement element = findElement(secureemailwidgetData.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		secureemailwidgetDataJson = jsonObject;

		return secureemailwidgetDataJson;
	}

	
	

	public void logOut() {
		logOut.click();

	}

}
