/**
 * 
 */
package pages.mobile.acquisition.ulayer;

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

public class PlanPaymentOptions extends UhcDriver{
	
	
	@FindBy(xpath = "//label[@for='payment-no']")
	private WebElement planpaymentno;
	
	@FindBy(xpath = "//label[@for='payment-yes']")
	private WebElement planpaymentyes;
	
	
	@FindBy(id = "planpaymentLink")
	private WebElement planpaymentLink;
	
	@FindBy(id="disclaimerAgreeBtnplanpayment")
	private WebElement ppodisclaimerAgreeBtn;
	
	@FindBy(id = "planPaymentOptionSaveBtnId")
	private WebElement pposaveandcont;
	
	@FindBy(xpath = ".//*[@id='disclaimerAgreeBtnplanpayment']")
	private WebElement disclaimerppoagreebutton;
	
	@FindBy(xpath = ".//*[@id='planPaymentOptionSaveBtnId']")
	private WebElement saveandcontinuebutton;
	
	@FindBy(xpath = ".//*[@id='planpaymentLink']")
	private WebElement disclaimerppo;
	
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
		validate(ppodisclaimerAgreeBtn);
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

	public void clickplanproviderInformation(Map<String, String> personalAttributesMap) {
		
		planpaymentLink.click();	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

			ppodisclaimerAgreeBtn.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	public OptionalRidersPage navigatesToNextStepMAPDorMA() {
		pposaveandcont.click();
				return new OptionalRidersPage(driver);
	
		}
	
	public ProposedEffectiveDatePage navigatesToNextStepPDP() {
		pposaveandcont.click();
			return new ProposedEffectiveDatePage(driver);

	}

	public OptionalRidersPage clickdisclaimerbutton() {
		
		validate(disclaimerppo);
		disclaimerppo.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		validate(disclaimerppoagreebutton);
		disclaimerppoagreebutton.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		validate(saveandcontinuebutton);
		saveandcontinuebutton.click();
		
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_ENROLLMENT)) {
			return new OptionalRidersPage(driver);
		}
		return null;
		
		
	}
	
	@FindBy(xpath = ".//*[@id='ppoInfo']/p")
	private WebElement ppoHeader ;	
	
	@FindBy(xpath = ".//*[@id='planPaymentOptionprevious']")
	private WebElement ppoPrevBtn;
	
	@FindBy(xpath = ".//*[@id='planPaymentOptioncancel']")
	private WebElement ppoCancelBtn;
	
	public boolean validatePPOPage(){
		boolean flag = false;
		if(validate(ppoHeader)&&validate(ppoPrevBtn)&&validate(saveandcontinuebutton)&&validate(ppoCancelBtn)&&
		validate(disclaimerppo)&&validate(planpaymentyes)&&validate(planpaymentno))
			flag = true;
		return flag;
	}
	}
