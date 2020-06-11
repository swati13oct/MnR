/**
 * 
 */
package pages.member_deprecated.bluelayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * @author pjaising
 *
 */
public class SecondPlanInfoPage extends UhcDriver{

	@FindBy(className = "gotomyaccounthome_btn")
	private WebElement goToAccountHome;
	
	private PageData secondPlanInfo;

	public JSONObject secondPlanInfoJson;
	
	public SecondPlanInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SECOND_PLAN_INFO_BLUELAYER_PAGE_DATA;
		secondPlanInfo = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	
	}

	@Override
	public void openAndValidate() {
		validate(goToAccountHome);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : secondPlanInfo.getExpectedData().keySet()) {
			WebElement element = findElement(secondPlanInfo.getExpectedData()
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
		secondPlanInfoJson = jsonObject;
		
		System.out.println("secondPlanInfoJson----->"+secondPlanInfoJson);
		
	}
	
	public AccountHomePage navigateToAccountHome(String category)
	{
		goToAccountHome.click();
		ElementData elementData = new ElementData("id", "progress");
		WebElement element = findElement(elementData);
		
		if(validate(element))
		{
			try
			{
			CommonUtility.waitForElementToDisappear(driver, element, 10);
			
		} catch (NoSuchElementException e) {
			System.out.println("progress not found");
		} catch (TimeoutException ex) {
			System.out.println("progress not found");
		} catch (Exception e) {
			System.out.println("progress not found");
		}
		}
		if (currentUrl().contains("home/my-account-home.html")) {
			return new AccountHomePage(driver);
		}
		
		return null;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject secondPlanInfoJson = expectedDataMap.get(CommonConstants.ADD_PLAN);
		secondPlanInfoJson.remove("dateOfBirth");
		try {
			String memberName  = "Welcome "+(String) secondPlanInfoJson.get("memberName");
			secondPlanInfoJson.put("memberName", memberName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return secondPlanInfoJson;
	}
	

}
