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

public class LongTermCarePage extends UhcDriver{
	
	@FindBy(id = "longtermcarequestionnotext")
	private WebElement longtermcareno;
	
	@FindBy(id = "longterncarequestionyestext")
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
	
	
	@FindBy(id = "pageHeadingmedicaid")
	private WebElement pageHeadingmedicaid;
	
	@FindBy(id = "longtermcareprevious")
	private WebElement longtermcareprevious;
	
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



	@Override
	public void openAndValidate() {
	

		
	
		
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
		}else{
			longtermcaredyes.click();
			sendkeys(longtermcarename,ltcname);
			sendkeys(longtermcarestreet,ltcstreetaddr);
			sendkeys(longtermcareapt,ltcapt);
			sendkeys(longtermcarecity,ltccity);
			sendkeys(longtermcarephone,ltcphonenum);
			sendkeys(longtermcaredate,ltcdatemoved);
		}		
	}

	public MedicaidPage navigatesToNextStep() {
			longtermcaredsaveandcontinue.click();
			if (pageHeadingmedicaid.getText().equalsIgnoreCase("Prescription Drug Coverage")) {
				return new MedicaidPage(driver);
			}
			return null;
		}
		
	}

