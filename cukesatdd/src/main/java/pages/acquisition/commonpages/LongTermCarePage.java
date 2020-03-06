/**
 * 
 */
package pages.acquisition.commonpages;

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

public class LongTermCarePage extends UhcDriver{
	
	@FindBy(xpath = "//label[@for='ltc-no']")
	private WebElement longtermcareno;
	
	@FindBy(xpath = "//label[@for='ltc-yes']")
	private WebElement longtermcaredyes;
	
	@FindBy(id = "ltc-name")
	private WebElement longtermcarename;
	
	@FindBy(id = "ltc-address-1")
	private WebElement longtermcarestreet;
	
	@FindBy(id = "ltc-address-2")
	private WebElement longtermcareapt;
	
	@FindBy(id = "ltc-city")
	private WebElement longtermcarecity;
	
	@FindBy(id = "ltc-phone")
	private WebElement longtermcarephone;
	
	@FindBy(id = "ltc-date")
	private WebElement longtermcaredate;
	
	@FindBy(id = "longtermcaresaveandcont")
	private WebElement longtermcaredsaveandcontinue;
	
	@FindBy(id = "longtermcarecancel")
	private WebElement longtermcaredcancelregistration;	
	
	private PageData longtermcareInformation;

	public JSONObject longtermcareInformationJson;

	public LongTermCarePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.LONG_TERM_CARE_PAGE_DATA;
		longtermcareInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}


	@FindBy(id="ltcInfo")
	private WebElement ltcHeader;


	@Override
	public void openAndValidate() {
		validate(longtermcareno);
		validate(longtermcaredyes);
		validate(ltcHeader);
		validate(longtermcaredsaveandcontinue);
		validate(longtermcaredcancelregistration);
		JSONObject jsonObject = new JSONObject();
		for (String key : longtermcareInformation.getExpectedData().keySet()) {
			WebElement element = findElement(longtermcareInformation.getExpectedData()
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
		longtermcareInformationJson = jsonObject;

	

		
	
		
	}

	public void enterslongtermInformation(
			Map<String, String> personalAttributesMap) {
		String ltcradiooption = personalAttributesMap.get("ltcradiooption");
		String ltcname = personalAttributesMap.get("ltcname");
		String ltcstreetaddr = personalAttributesMap.get("ltcstreetaddr");
		String ltcapt = personalAttributesMap.get("ltcapt");
		String ltccity = personalAttributesMap.get("ltccity");
		String ltcphonenum = personalAttributesMap.get("ltcphonenum");
		String ltcdatemoved = personalAttributesMap.get("ltcdatemoved");
		if(ltcradiooption.equalsIgnoreCase("No")){
				longtermcareno.click();
		}else if(ltcradiooption.equalsIgnoreCase("Yes")){
			longtermcaredyes.click();
			sendkeys(longtermcarename,ltcname);
			sendkeys(longtermcarestreet,ltcstreetaddr);
			sendkeys(longtermcareapt,ltcapt);
			sendkeys(longtermcarecity,ltccity);
			sendkeys(longtermcarephone,ltcphonenum);
			sendkeys(longtermcaredate,ltcdatemoved);
		}		
	}

	public MedicaidPage navigatesToNextStepMAorMAPD() {
			longtermcaredsaveandcontinue.click();
				return new MedicaidPage(driver);
		}
	
	public PlanPaymentOptions navigatesToNextStepPDP() {
		longtermcaredsaveandcontinue.click();
			return new PlanPaymentOptions(driver);
		
	}
		
	/*@FindBy(id="ltcInfo")
	private WebElement ltcHeader;*/
	
	public boolean validateLTCPage(){
		boolean flag = false;
		if(validate(ltcHeader)&&validate(longtermcareno)&&validate(longtermcaredyes)&&validate(longtermcaredsaveandcontinue)&&validate(longtermcaredcancelregistration))
			flag = true;
		return flag;
	}

}