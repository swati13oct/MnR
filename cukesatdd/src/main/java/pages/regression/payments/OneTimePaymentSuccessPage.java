package pages.regression.payments;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

/**
 * @author pperugu
 *
 */
public class OneTimePaymentSuccessPage extends UhcDriver{
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;
	                 
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[7]/div/div/div/div/div/div")
	private WebElement OneTimePaymentSuccess;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/div[1]/div/div/div[5]/div[2]/span")
	private WebElement AccountNumber;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/div[1]/div/div/div[6]/div[2]/span")
	private WebElement AccountHolderName;
	
	@FindBy(xpath = "//*[@class='container--base']/div[@class='container']//button[@ng-click='backToPaymentHistoryPage()']")
	private WebElement BackToPaymentHistoryPage;


	private PageData oneTimePaymentSuccess;
	
	public JSONObject oneTimePaymentSuccessJson;
	
	public OneTimePaymentSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ONE_PAYMENT_SUCCESS_PAGE_DATA;
		oneTimePaymentSuccess = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public String getContent() {
		return OneTimePaymentSuccess.getText();
	}
	
	public void logOut() {
		logOut.click();
		
	}

	@Override
	public void openAndValidate() {
		validate(logOut);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : oneTimePaymentSuccess.getExpectedData().keySet()) {
			WebElement element = findElement(oneTimePaymentSuccess.getExpectedData

().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		oneTimePaymentSuccessJson = jsonObject;
		
		System.out.println("oneTimePaymentSuccessJson----->"+oneTimePaymentSuccessJson);
		
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject oneTimePaymentExpectedJson = expectedDataMap.get

(CommonConstants.ONE_TIME_PAYMENT_SUCCESS);
		oneTimePaymentExpectedJson = CommonUtility.mergeJson(oneTimePaymentExpectedJson, 

globalExpectedJson);
		return oneTimePaymentExpectedJson;
	}


	// In progress
	public PaymentHistoryPage ScrollDownToBackButton()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		
		if(BackToPaymentHistoryPage.isDisplayed())
		{
			BackToPaymentHistoryPage.click();
			return new PaymentHistoryPage(driver);
		}
		else
			return null;
		
		
	}
	
}
