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
public class ESRDPage extends UhcDriver{	
	
	@FindBy(xpath = "//label[@for='esrd-no']")
	private WebElement esrdno;
	
	@FindBy(xpath = "//label[@for='esrd-yes']")
	private WebElement esrdyes;
	
	@FindBy(id = "esrdquestionyestext")
	private WebElement pageHeadingPrescriptionDrugCoverage;
	
	@FindBy(id = "esrdprevious")
	private WebElement esrdprevious;
	
	@FindBy(id = "esrdsaveandcont")
	private WebElement esrdsaveandcontinue;
	
	@FindBy(id = "esrdcancel")
	private WebElement esrdcancelregistration;
	
	private PageData esrdInformation;

	public JSONObject esrdInformationJson;

	public ESRDPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ESRD_PAGE_DATA;
		esrdInformation = CommonUtility.readPageData(fileName,CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public void openAndValidate() {
		validate(esrdno);
		validate(esrdyes);
		validate(esrdprevious);
		validate(esrdsaveandcontinue);
		validate(esrdcancelregistration);
		
		
		JSONObject jsonObject = new JSONObject();
		for (String key : esrdInformation.getExpectedData().keySet()) {
			WebElement element = findElement(esrdInformation.getExpectedData()
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
		esrdInformationJson = jsonObject;

		
	}

	public void entersESRDInformation(Map<String, String> personalAttributesMap) {
		String esrdradiooption = personalAttributesMap.get("esrdradiooption");
		if(esrdradiooption.equalsIgnoreCase("No"))
		{
			esrdno.click();
		}
		else
		{
			esrdyes.click();
		}
		
	}
	public PrescriptionDrugCoveragePage navigatesToNextStep() {
			esrdsaveandcontinue.click();
			if (pageHeadingPrescriptionDrugCoverage.getText().equalsIgnoreCase("Prescription Drug Coverage")) {
				return new PrescriptionDrugCoveragePage(driver);
			}
			return null;
		}
		
}