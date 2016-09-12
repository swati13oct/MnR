/**
 * 
 */
package pages.mobile.member.blayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pnampall
 *
 */
public class BenefitsSummaryPage extends UhcDriver {
	
	@FindBy(xpath="//div[@class='site-header']/a")
	private WebElement menuButton;
	
	@FindBy(xpath = "//div[@class='menu-container']/a")
	private WebElement logout;
	
	@FindBy(className = "menu-container")
	private WebElement menuContainer;
	
	private PageData benefitsSummary;

	public JSONObject benefitsSummaryJson;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public BenefitsSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_SUMMARY_PAGE_DATA;
		benefitsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_MOBILE_BLUELAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(menuButton);
		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsSummary
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(key, element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		benefitsSummaryJson = jsonObject;
		
		System.out.println("benefitsSummaryJson----->"+benefitsSummaryJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject benefitsSummaryExpectedJson = expectedDataMap
				.get(acceptancetests.atdd.data.CommonConstants.BENEFITS_SUMMARY_BLAYER);
		
		return benefitsSummaryExpectedJson;
	}

	public void logout()
	{
		menuButton.click();
		if(validate(menuContainer))
		{
			logout.click();
		}
		else
		{
			System.out.println("logout button not found on page");
		}
	}

	public JSONObject getBrowserCheck() {
	
		String fileName = CommonConstants.MOBILE_BROWSER_CHECK_DATA_BLUELAYER;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_MOBILE_BLUELAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
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
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}


	
}
