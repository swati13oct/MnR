package pages.mobile.member.blayer;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
public class PharmacyLocatorPage extends UhcDriver {
	
	@FindBy(id = "menuopen")
	private WebElement menuButton;

	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/a[5]")
	private WebElement logout;
	
	@FindBy(xpath = "//*[@id='wrapper']/div[1]/div[3]/div/div/div[1]/h1")
	private WebElement pharmacyLocatorText;
	
	@FindBy(xpath="//div[@class='button button-primary pharmacy_filter_button']")
	private WebElement filterButton;
	
	@FindBy(xpath="//div[9]/div[2]/div/div[1]")
	private WebElement toolTip;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public PharmacyLocatorPage(WebDriver driver) {
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
	
	public void narrowSearchValidation(){
		filterButton.click();
		List<WebElement> elements = driver.findElements(By.xpath("//span"));
		for(int i=0; i<elements.size();i++){
			System.out.println(elements.get(i).getText());
			if(elements.get(i).getText().contains("Mail Service")){
				System.out.println("--------------Failed due to Presence of Mail Service CheckBox--------------");
				Assert.fail();
			}
		}
		System.out.println("narrow search radio button verified");
		toolTip.click();
		List<WebElement> toolTipElement = driver.findElements(By.xpath("//b"));
		for(int i=0; i<toolTipElement.size();i++){
			System.out.println(toolTipElement.get(i).getText());
			if(toolTipElement.get(i).getText().contains("Mail Service")){
				System.out.println("---------------Failed due to presence of Mail Service in Tool Tip------------");
				Assert.fail();
			}
		}
		System.out.println("tool tip verified");
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
