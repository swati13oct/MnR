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

/**
 * @author pperugu
 *
 */
public class OtherHealthInsurancePage extends UhcDriver{
	
	@FindBy(id = "esrdquestionnotext")
	private WebElement otherhealthinsuranceno;
	
	@FindBy(id = "otherhealthinsurancequestionyestext")
	private WebElement otherhealthinsuranceyes;
	
	@FindBy(id = "other-insurance-name")
	private WebElement otherhealthinsurancename;	
	
	@FindBy(id = "other-insurance-group")
	private WebElement otherhealthinsurancegroup;
	
	@FindBy(id = "other-insurance-member")
	private WebElement otherhealthinsurancememberid;	
	
	@FindBy(id = "othprevious")
	private WebElement otherhealthinsuranceprevious;
	
	@FindBy(id = "othsaveandcont")
	private WebElement otherhelathinsurancesaveandcontinue;
	
	@FindBy(id = "othcancel")
	private WebElement otherhelathinsurancecancelregristration;
	
	@FindBy(id = "pageHeadingPrimaryCareProvider")
	private WebElement pageHeadingPrimaryCareProvider;	
	
	private PageData otherheslthinsuranceInformation;

	public JSONObject otherhealthinsuranceInformationJson;

	public OtherHealthInsurancePage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.OTHER_HEALTH_INSURANCE_PAGE_DATA;
		PageData otherhealthinsuranceInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
	 validate(otherhealthinsuranceno);
	  validate(otherhealthinsuranceyes);

		
	
		
	}

	public void entersotherhealthinsurInformation(
			Map<String, String> personalAttributesMap) {
			String othradiooption = personalAttributesMap.get("othradiooption");
		String othnameofhealthinsur = personalAttributesMap.get("othnameofhealthinsur");
		String othgroupid = personalAttributesMap.get("othgroupid");
		String othmemberid = personalAttributesMap.get("othmemberid");
		if(othradiooption.equalsIgnoreCase("No")){
				otherhealthinsuranceno.click();
		}else{
			otherhealthinsuranceyes.click();
			sendkeys(otherhealthinsurancename,othnameofhealthinsur);
			sendkeys(otherhealthinsurancegroup,othgroupid);
			sendkeys(otherhealthinsurancememberid,othmemberid);
		}			
		
			
		}
		
			public PrimaryCareProviderPage navigatesToNextStep() {
			otherhelathinsurancesaveandcontinue.click();
			if (pageHeadingPrimaryCareProvider.getText().equalsIgnoreCase("Prescription Drug Coverage")) {
				return new PrimaryCareProviderPage(driver);
			}
			return null;
		}
	}

