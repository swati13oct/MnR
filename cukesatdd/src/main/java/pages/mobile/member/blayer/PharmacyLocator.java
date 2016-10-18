package pages.mobile.member.blayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.mobile.member.blayer.BenefitsSummaryPage;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class PharmacyLocator extends UhcDriver {
	@FindBy(xpath="//div[1]/div[3]/div/div/div[2]/div[1]")
	public static  WebElement filterButton;
	
	@FindBy(xpath="//div[2]/div/div[9]/div/label/span")
	public static WebElement mailServiceRadioText;
	
	@FindBy(xpath="//div[2]/div/div[9]/div/label/input")
	public static WebElement mailServiceRadioCheckbox;
	
	@FindBy(xpath="//div[9]/div[2]/div/div[1]")
	public static WebElement toolTip;
	
	@FindBy(xpath="//div/div/div[10]/div[2]/div[2]/div/p[9]")
	public static WebElement toolTipMailServiceContent;
	
	/*public WebElement filterButton(){
		System.out.println("inside filter");
		return filterButton;
	}*/
	
	//private PageData pharmacyLocator;
	
	//public JSONObject pharmacyLocatorJson;

	//private PageData browserCheckData;

	//private JSONObject browserCheckJson;
	
	public PharmacyLocator(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//String fileName = CommonConstants.PHARMACY_LOCATOR_PAGE_DATA;
	//	pharmacyLocator = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_MOBILE_BLUELAYER_MEMBER);
		//openAndValidate();
	}

	@Override
	public void openAndValidate() {
	}
	
	/*public void clickFilterAndValidateScenario(){
		filterButton.click();
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
	}*/
}
