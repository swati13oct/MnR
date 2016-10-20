package pages.mobile.member.blayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author Bhaji Shaik
 *
 */
public class ProviderSearchPage extends UhcDriver {
	
	@FindBy(id = "menuopen")
	private WebElement menuButton;

	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/a[5]")
	private WebElement logout;
	
	@FindBy(xpath = "//*[@id='wrapper']/div[1]/div[3]/div/div/div[1]/h1")
	private WebElement pharmacyLocatorText;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// start(PAGE_URL);
		validate(pharmacyLocatorText);

	}
	
	public void logout()
	{
		menuButton.click();
		if(validate(logout))
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
