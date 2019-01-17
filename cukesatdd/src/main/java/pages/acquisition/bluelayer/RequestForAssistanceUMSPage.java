/**
 * 
 */
package pages.acquisition.bluelayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pgupta15
 *
 */
public class RequestForAssistanceUMSPage extends UhcDriver{
	
	@FindBy(id = "cobrowse-disclaimer")
	private WebElement cobrowsemodelwindow;
	
	@FindBy(xpath = "//*[@id='cobrowse-disclaimer']/div/div[3]/button")
	private WebElement agreeButton;
	
	@FindBy(xpath = "//*[@id='cobrowse-disclaimer']/div/div[1]/div[2]/a") 
	private WebElement closeButton;
	
	
	private PageData requestforassist;

	public JSONObject RequestforassistanceJson;
	
	
	
	public RequestForAssistanceUMSPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	

	@Override
	public void openAndValidate() {
		
		validate(cobrowsemodelwindow);
		validate(agreeButton);
		validate(closeButton);
		
		
		
	}
	
public JSONObject Requestforassistance() {
		
		String fileName = CommonConstants.Request_For_Assistance_PAGE_DATA;
		requestforassist = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : requestforassist.getExpectedData().keySet()) {
		WebElement element = findElement(requestforassist.getExpectedData()
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
		RequestforassistanceJson = jsonObject;
		
		
		return RequestforassistanceJson;
		
	}

public void validatecobrosemodelwindow()
{
	validate(cobrowsemodelwindow);
	Assert.assertTrue(cobrowsemodelwindow.isDisplayed());
	Assert.assertTrue(agreeButton.isDisplayed());
	Assert.assertTrue(closeButton.isDisplayed());
}



}
