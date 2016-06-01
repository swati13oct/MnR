/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PlanPaymentOptions extends UhcDriver{
	
	
	
	@FindBy(id = "planpaymentLink")
	private WebElement planpaymentLink;
	
	@FindBy(id = "disclaimerAgreeBtn")
	private WebElement disclaimerAgreeBtn;
	
	@FindBy(id = "pcpprevious")
	private WebElement pcpprevious;
	
	@FindBy(id = "pcpsaveandcont")
	private WebElement pcpsaveandcont;
	
	@FindBy(id = "ppcpcancel")
	private WebElement pcpcancel;
	
	private PageData planpaymentInformation;

	public JSONObject planpaymentInformationJson;
	
	public PlanPaymentOptions(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_PAYMENT_OPTION_PAGE_DATA;
		planpaymentInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		
	}

	@Override
	public void openAndValidate() {
		
		JSONObject jsonObject = new JSONObject();
		for (String key : planpaymentInformation.getExpectedData().keySet()) {
			WebElement element = findElement(planpaymentInformation.getExpectedData()
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
		planpaymentInformationJson = jsonObject;	
	}

	public void clickplanproviderInformation() {
	
		planpaymentLink.click();		
		disclaimerAgreeBtn.click();
		}
		
	public OptionalRidersPage navigatesToNextStep() {
			pcpsaveandcont.click();
				return new OptionalRidersPage(driver);
	
		}
	
		
	
	}
