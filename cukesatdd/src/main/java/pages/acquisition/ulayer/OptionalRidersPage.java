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
public class OptionalRidersPage extends UhcDriver{
	
	
	
	@FindBy(id = "optionalridersquestionnotext")
	private WebElement esrdno;
	
	@FindBy(id = "optionalridersquestionyestext")
	private WebElement esrdyes;
	
	private PageData optionalridersInformation;

	public JSONObject optiionalridersInformationJson;

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
	

		
	
		
	}

	public void entersOptionalRiderInformation(
			Map<String, String> personalAttributesMap) {
		String answer = personalAttributesMap.get("Answer");
		
			
		}

	}

