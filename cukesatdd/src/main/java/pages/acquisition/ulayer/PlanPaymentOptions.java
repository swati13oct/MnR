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
	
	
	
	@FindBy(xpath = "//label[@for='payment-no']")
	private WebElement planpaymentLicnkno;
	
	@FindBy(xpath = "//label[@for='payment-yes']")
	private WebElement planpaymentLinkyes;
	
	@FindBy(id = "planpaymentLink")
	private WebElement planpaymentLink;

	@FindBy(xpath = "//a[@id='disclaimerAgreeBtn']")
	private WebElement ppodisclaimerAgreeBtn;
	
	@FindBy(id = "planPaymentOptionprevious")
	private WebElement pcpprevious;
	
	@FindBy(id = "planPaymentOptionSaveBtnId")
	private WebElement pcpsaveandcont;
	
	@FindBy(id = "planPaymentOptioncancel")
	private WebElement pcpcancel;
	
	private PageData planpaymentInformation;

	public JSONObject planpaymentInformationJson;
	
	public PlanPaymentOptions(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_PAYMENT_OPTION_PAGE_DATA;
		planpaymentInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
		
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

	public void clickplanproviderInformation(	Map<String, String> personalAttributesMap) {
		String planpaymentoption = personalAttributesMap.get("planpaymentoption");
		if(planpaymentoption.equalsIgnoreCase("No")) {
			planpaymentLicnkno.click();
		
		}else if(planpaymentoption.equalsIgnoreCase("Yes")){
			planpaymentLinkyes.click();
		}
	
		planpaymentLink.click();	
	/*	try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		if(getTitle().equalsIgnoreCase("AARP Medicare Complete Online Application")||getTitle().equalsIgnoreCase("AARP Medicarerx Online Application")){
			ppodisclaimerAgreeBtn.click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		}
		
	public OptionalRidersPage navigatesToNextStepMAPDMA() {
			pcpsaveandcont.click();
				return new OptionalRidersPage(driver);
	
		}
	
	public ProposedEffectiveDatePage navigatesToNextStepPDP() {
		pcpsaveandcont.click();
			return new ProposedEffectiveDatePage(driver);

	}
	
		
	
	}
