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
	
	@FindBy(id = "primarycareproviderquestionnotext")
	private WebElement ppono;
	
	@FindBy(id = "primarycareproviderquestionyestext")
	private WebElement ppoyes;
	
	@FindBy(id = "pageHeadingOptRider")
	private WebElement pageHeadingOptRider;
	
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
		PageData otherhealthinsuranceInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		
	}

	@Override
	public void openAndValidate() {
	

		
	
		
	}

	public void entersplanproviderInformation(
			Map<String, String> personalAttributesMap) {
		String pporadiooption = personalAttributesMap.get("pporadiooption");
			
		if(pporadiooption.equalsIgnoreCase("No")){
				ppono.click();
		}else{
			ppoyes.click();
			
		}	
		planpaymentLink.click();		
		disclaimerAgreeBtn.click();
		}
		
	public OptionalRidersPage navigatesToNextStep() {
			pcpsaveandcont.click();
			if (pageHeadingOptRider.getText().equalsIgnoreCase("Prescription Drug Coverage")) {
				return new OptionalRidersPage(driver);
			}
			return null;
		}
	
		
	
	}
