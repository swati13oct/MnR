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
public class MedicaidPage extends UhcDriver{
	
	
	
	@FindBy(id = "medicaidquestionnotext")
	private WebElement medicaiddno;
	
	@FindBy(id = "medicaiddquestionyestext")
	private WebElement medicaiddyes;
		
	@FindBy(id = "medicaid-number")
	private WebElement medicaidnum;
	
	@FindBy(id = "medicaidprevious")
	private WebElement medicaidprevious;
	
	@FindBy(id = "medicaiddquestionyestext")
	private WebElement medicaidsaveandcontinue;
	
	@FindBy(id = "medicaiddquestionyestext")
	private WebElement medicaidcancleregistration;
	
	@FindBy(id = "pageHeadingOtherHealthInsur")
	private WebElement pageHeadingOtherHealthInsur;
	
	
	
	private PageData medicaiddInformation;

	public JSONObject medicaidInformationJson;

	public MedicaidPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MEDICAID_PAGE_DATA;
		PageData medicaidinformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
		public void openAndValidate() {
		validate(medicaiddno);
		validate(medicaiddyes);		
	}

	public void entersmedicaidInformation(
			Map<String, String> personalAttributesMap) {
			String medicaidradiooption = personalAttributesMap.get("medicaidradiooption");
		String medicaidnumber = personalAttributesMap.get("medicaidnum");
		if(medicaidradiooption.equalsIgnoreCase("No")){
				medicaiddno.click();
		}else{
			medicaiddyes.click();
			sendkeys(medicaidnum,medicaidnumber);
		}				
	}
		
	public OtherHealthInsurancePage navigatesToNextStep() {
			medicaidsaveandcontinue.click();
			if (pageHeadingOtherHealthInsur.getText().equalsIgnoreCase("Prescription Drug Coverage")) {
				return new OtherHealthInsurancePage(driver);
			}
			return null;
		}
   }
