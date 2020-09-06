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
public class ESRDPageMobile extends UhcDriver{	
	
	@FindBy(xpath = ".//*[@id='esrd-no_label']")
	private WebElement esrdno;
	
	@FindBy(xpath = ".//*[@id='esrd-yes_label']")
	private WebElement esrdyes;
	
	@FindBy(id = "esrdprevious")
	private WebElement esrdprevious;
	
	@FindBy(id = "esrdsaveandcont")
	private WebElement esrdsaveandcontinue;
	
	@FindBy(id = "esrdcancel")
	private WebElement esrdcancelregistration;
	
	private PageData esrdInformation;

	public JSONObject esrdInformationJson;

	public ESRDPageMobile(WebDriver driver) {
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
		else if(esrdradiooption.equalsIgnoreCase("Yes"))
		{
			esrdyes.click();
		}
		
	}
	public PrescriptionDrugCoveragePageMobile navigatesToNextStep() {
			esrdsaveandcontinue.click();
				return new PrescriptionDrugCoveragePageMobile(driver);
		}
		
	@FindBy(xpath = ".//*[@id='esrdInfo']/p")
	private WebElement esrdHeader;
	
	public boolean validateESRDPage(){
		boolean flag = false;
		if(validate(esrdHeader)&&validate(esrdno)&&validate(esrdyes)&&validate(esrdprevious)
		&&validate(esrdsaveandcontinue)&&validate(esrdcancelregistration))
			flag = true;
		return flag;
	}
}