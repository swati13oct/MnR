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

/**
 * @author pperugu
 *
 */
public class MedicaidPage extends UhcDriver{	
	
	@FindBy(xpath = "//label[@for='medicaid-no']")
	private WebElement medicaiddno;
	
	@FindBy(xpath = "//label[@for='medicaid-yes']")
	private WebElement medicaiddyes;
		
	@FindBy(id = "medicaid-number")
	private WebElement medicaidnum;
	
	@FindBy(id = "medicaidprevious")
	private WebElement medicaidprevious;
	
	@FindBy(id = "medicaidsaveandcont")
	private WebElement medicaidsaveandcontinue;
	
	@FindBy(id = "medicaidcancel")
	private WebElement medicaidcancleregistration;
			
	
	private PageData medicaidInformation;

	public JSONObject medicaidInformationJson;

	public MedicaidPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MEDICAID_PAGE_DATA;
		medicaidInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
		public void openAndValidate() {
		validate(medicaiddno);
		validate(medicaiddyes);		
		JSONObject jsonObject = new JSONObject();
		for (String key : medicaidInformation.getExpectedData().keySet()) {
			WebElement element = findElement(medicaidInformation.getExpectedData()
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
		medicaidInformationJson = jsonObject;

	

	}

	public void entersmedicaidInformation(
			Map<String, String> personalAttributesMap) {
			String medicaidradiooption = personalAttributesMap.get("medicaidradiooption");
		String medicaidnumber = personalAttributesMap.get("medicaidnum");
		if(medicaidradiooption.equalsIgnoreCase("No")){
				medicaiddno.click();
		}else if(medicaidradiooption.equalsIgnoreCase("Yes")){
			medicaiddyes.click();
			sendkeys(medicaidnum,medicaidnumber);
		}				
	}
		
	public OtherHealthInsurancePage navigatesToNextStepMAorMAPD() {
			medicaidsaveandcontinue.click();
				return new OtherHealthInsurancePage(driver);
			
		}
	
	public PlanPaymentOptions navigatesToNextStepPDP() {
		medicaidsaveandcontinue.click();
			return new PlanPaymentOptions(driver);
		
	}
	
	@FindBy(xpath = ".//*[@id='medicaidInfo']/p")
	private WebElement medicaidHeader;
	
	public boolean validateMedicadePage(){
		boolean flag = false;
		if(validate(medicaidHeader)&&validate(medicaidprevious)&&validate(medicaidsaveandcontinue)&&validate(medicaiddno)&&
		validate(medicaiddyes)&&validate(medicaidcancleregistration))
			flag = true;
		return flag;
	}
   }
