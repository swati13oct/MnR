/**
 * 
 */
package pages.mobile.acquisition.commonpages;

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
public class OtherHealthInsurancePageMobile extends UhcDriver {

	@FindBy(xpath = "//label[@for='other-insurance-no']")
	private WebElement otherhealthinsuranceno;

	@FindBy(xpath = "//label[@for='other-insurance-yes']")
	private WebElement otherhealthinsuranceyes;

	@FindBy(css = "#other-insurance-name")
	private WebElement otherhealthinsurancename;

	@FindBy(css = "#other-insurance-group")
	private WebElement otherhealthinsurancegroup;

	@FindBy(css = "#other-insurance-member")
	private WebElement otherhealthinsurancememberid;

	@FindBy(css = "#othprevious")
	private WebElement otherhealthinsuranceprevious;

	@FindBy(css = "#othsaveandcont")
	private WebElement otherhelathinsurancesaveandcontinue;

	@FindBy(css = "#othcancel")
	private WebElement otherhelathinsurancecancelregristration;

	
	private PageData otherhealthinsuranceInformation;

	public JSONObject otherhealthinsuranceInformationJson;

	public OtherHealthInsurancePageMobile(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.OTHER_HEALTH_INSURANCE_PAGE_DATA;
		otherhealthinsuranceInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(otherhealthinsuranceno);
		validate(otherhealthinsuranceyes);

		JSONObject jsonObject = new JSONObject();
		for (String key : otherhealthinsuranceInformation.getExpectedData().keySet()) {
			WebElement element = findElement(otherhealthinsuranceInformation.getExpectedData().get(key));
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
		otherhealthinsuranceInformationJson = jsonObject;

	}

	public void entersotherhealthinsurInformation(Map<String, String> personalAttributesMap) {
		String othradiooption = personalAttributesMap.get("othradiooption");
		String othnameofhealthinsur = personalAttributesMap.get("othnameofhealthinsur");
		String othgroupid = personalAttributesMap.get("othgroupid");
		String othmemberid = personalAttributesMap.get("othmemberid");
		if (othradiooption.equalsIgnoreCase("No")) {
			otherhealthinsuranceno.click();
		} else if (othradiooption.equalsIgnoreCase("Yes")) {
			otherhealthinsuranceyes.click();
			sendkeys(otherhealthinsurancename, othnameofhealthinsur);
			sendkeys(otherhealthinsurancegroup, othgroupid);
			sendkeys(otherhealthinsurancememberid, othmemberid);
		}
	}
			
		
			
		
	public PrimaryCareProviderPageMobile navigatesToNextStep() {
		otherhelathinsurancesaveandcontinue.click();

		return new PrimaryCareProviderPageMobile(driver);
	}

	@FindBy(xpath = ".//*[@id='othInfo']/p")
	private WebElement othHeader;

	public boolean validateOTHPage() {
		boolean flag = false;
		if (validate(otherhealthinsuranceno) && validate(otherhealthinsuranceyes)
				&& validate(otherhelathinsurancesaveandcontinue) && validate(otherhealthinsuranceprevious)
				&& validate(otherhelathinsurancecancelregristration) && validate(othHeader))
			flag = true;
		return flag;
	}
}
