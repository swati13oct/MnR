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
 *c */
public class PrescriptionDrugCoveragePage extends UhcDriver{	
	
	@FindBy(xpath = "//label[@for='drug-coverage-no']")
	private WebElement pdcno;
	
	@FindBy(xpath = "//label[@for='drug-coverage-yes']")
	private WebElement pdcyes;
	
	@FindBy(id = "insurance-name")
	private WebElement pdcnameofinsur;
	
	@FindBy(id = "group-id")
	private WebElement pdcgroupid;
	
	@FindBy(id = "member-id")
	private WebElement pdcmemberid;
	
	@FindBy(id = "pdcsaveandcont")
	private WebElement pdcsaveandcont;
	
	@FindBy(id = "pdccancel")
	private WebElement pdccancel;
	
	private PageData prescriptiondrugcoverageInformation;

	public JSONObject prescriptionDrugCoverageInformationJson;

	public PrescriptionDrugCoveragePage(WebDriver driver) {
			
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PRESCRIPTION_DRUG_COVERAGE_PAGE_DATA;
		prescriptiondrugcoverageInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(pdcno);
		validate(pdcyes);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : prescriptiondrugcoverageInformation.getExpectedData().keySet()) {
			WebElement element = findElement(prescriptiondrugcoverageInformation.getExpectedData()
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
		prescriptionDrugCoverageInformationJson = jsonObject;
	}

	public void enterspdcInformation(
			Map<String, String> personalAttributesMap) {
		String pdcradiooption = personalAttributesMap.get("pdcradiooption");
		String pdchealthinsurname = personalAttributesMap.get("pdchealthinsurname");
		String pdcgroupidnumber = personalAttributesMap.get("pdcgroupidnumber");
		String pdcmemberidnumber = personalAttributesMap.get("pdcmemberidnumber");
		if(pdcradiooption.equalsIgnoreCase("No")){
				pdcno.click();
		}else if(pdcradiooption.equalsIgnoreCase("Yes")){
			pdcyes.click();
			sendkeys(pdcnameofinsur,pdchealthinsurname);
			sendkeys(pdcgroupid,pdcgroupidnumber);
			sendkeys(pdcmemberid,pdcmemberidnumber);
			
		}
				
	}
		
		public LongTermCarePage navigatesToNextStep() {
			pdcsaveandcont.click();
				return new LongTermCarePage(driver);
		}
		
		
		@FindBy(xpath = ".//*[@id='pdcInfo']/p")
		private WebElement pdcHeader;
		
		public boolean validatePDCPage(){
			boolean flag = false;
			if(validate(pdcHeader)&&validate(pdcsaveandcont)&&validate(pdccancel)&&validate(pdcno)&&validate(pdcyes))
				flag = true;
			return flag;
		}
}
		
	

