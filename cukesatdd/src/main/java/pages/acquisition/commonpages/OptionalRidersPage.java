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

/**
 * @author pperugu
 *
 */
public class OptionalRidersPage extends UhcDriver{
	

	@FindBy(xpath = "//label[@for='dental-no']")
	private WebElement optno;
	
	@FindBy(id = "dental-rider-yes-label1")
	private WebElement optyes;
	
	@FindBy(id = "optRiderprevious")
	private WebElement optionalridersprevious;
	
	@FindBy(id = "optRidersaveandcont")
	private WebElement optionalriderssaveandcontinue;
	
	@FindBy(id = "optRidercancel")
	private WebElement optionalriderscancelregristration;
	
	private PageData optionalridersInformation;

	public JSONObject optionalridersInformationJson;

	public OptionalRidersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.OPTIONAL_RIDERS_PAGE_DATA;
		optionalridersInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
	
		JSONObject jsonObject = new JSONObject();
		for (String key : optionalridersInformation.getExpectedData().keySet()) {
			WebElement element = findElement(optionalridersInformation.getExpectedData()
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
		optionalridersInformationJson = jsonObject;

		
	
		
	}

	public void entersOptionalRiderInformation(
			Map<String, String> personalAttributesMap) {
		String optradiooption = personalAttributesMap.get("optradiooption");
		if(optradiooption.equalsIgnoreCase("No")){
			optno.click();
		}else
			optyes.click();
			
		}
	

		public ProposedEffectiveDatePage navigatesToNextStep() {
			optionalriderssaveandcontinue.click();
				return new ProposedEffectiveDatePage(driver);
			
		}
		
		
		@FindBy(xpath = ".//*[@id='optriderInfo']/p")
		private WebElement optHeader;
		
		public boolean validateOptionalRidersPage(){
			boolean flag = false;
			if(validate(optHeader)&&validate(optionalridersprevious)&&validate(optionalriderssaveandcontinue)&&
			validate(optionalriderscancelregristration))//&&validate(optno))
				flag = true;
			return flag;
		}
}
