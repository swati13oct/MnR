package pages.dashboard_deprecated.member.blayer;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

//DEPRICATED CLASS
public class SavingsOppurtunity extends UhcDriver{
	
	private PageData switchgeneric;

	public JSONObject switchgenericJson;
	

	@FindBy(id="drug-alt-search-button")
	public WebElement continueButton;
	
	@FindBy(id="save-drug-button")
	public WebElement savedrugbutton;
	
	
	@FindBy(xpath="//header[@class='add-drug-slide-header']/span[contains(text(),' SAVINGS OPPORTUNITY')]")
	public WebElement SwitchGenericPage;
	
	public SavingsOppurtunity(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, SwitchGenericPage, 10);
		String fileName = CommonConstants.SWITCH_GENERIC_PAGE_DATA;
		switchgeneric = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		openAndValidate();
	}
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : switchgeneric.getExpectedData().keySet()) {
			WebElement element = findElement(switchgeneric.getExpectedData()
					.get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		switchgenericJson = jsonObject;

		System.out.println("addnewdrugJson----->" + switchgenericJson);
	}
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject newPaymentHistoryExpectedJson = expectedDataMap
				.get(CommonConstants.SWITCH_GENERIC);

		return newPaymentHistoryExpectedJson;
	}
	public void savedrugbutton() throws InterruptedException {
		Thread.sleep(10000);
		waitforElement(savedrugbutton);
		savedrugbutton.click();
		// TODO Auto-generated method stub
		
	}
}
