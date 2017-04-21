/**
 * 
 */
package pages.member.ulayer;


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
	
	private PageData contactUs;
	
	private PageData secureemailwidgetData;
	
	private JSONObject secureemailwidgetDataJson;
	
	public JSONObject contactUsJson;
	
	@FindBy(xpath="//*[@id='secureWidget']/div[2]/p[4]/a/span")
	private WebElement getstartedlink;
	
	@FindBy(xpath="//*[@id='modelContent']/div[1]")
	private WebElement emialUslink;
	
	@FindBy(xpath="//*[@id='contActButton']")
	private WebElement continuelink;
	
	@FindBy(css="#secureWidget")
	private WebElement securewidgetlink;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.CONTACT_US_PAGE_DATA;
		contactUs = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : contactUs.getExpectedData().keySet()) {
			WebElement element = findElement(contactUs.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				}
			}
		}
		contactUsJson = jsonObject;
		
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);*/
		JSONObject contactUsExpectedJson = expectedDataMap
				.get(CommonConstants.CONTACT_US);
		/*contactUsExpectedJson = CommonUtility.mergeJson(
				contactUsExpectedJson, globalExpectedJson);*/
		return contactUsExpectedJson;
	}
	
	public void validatesecureemail()
	{
		if (securewidget.isDisplayed())
		{
			System.out.println("Secure widget is displayed");
			Assert.assertTrue("Secure Email widget is displayed", securewidget.isDisplayed());
			
		}
		else
		{
			System.out.println("Secure widget is not  displayed");
		}
	}
	public void secureEmailWidgetDisplayed(){
		
			Assert.assertTrue("Secure Email widget is displayed", securewidget.isDisplayed());
			
		
	}
	
	public void secureEmailWidgetNonDisplayedCheck(){
			Assert.assertEquals("display: block;", securewidgetlink.getAttribute("style"));
		
			//Assert.assertTrue("Secure Email widget not displayed", !securewidgetlink.isDisplayed());
			
	}

	public JSONObject getsecurewidget() {
		String fileName = CommonConstants.AARPM_SECURE_EMAIL_DATA;
		secureemailwidgetData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

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
