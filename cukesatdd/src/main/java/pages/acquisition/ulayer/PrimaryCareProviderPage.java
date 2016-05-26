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
public class PrimaryCareProviderPage extends UhcDriver{
	

	@FindBy(id = "pcpprevious")
	private WebElement pageHeadingPlanPaymentopt;
	
	@FindBy(id = "pcpprevious")
	private WebElement pcpprevious;
	
	@FindBy(id = "pcpsaveandcont")
	private WebElement pcpsaveandcont;
	
	@FindBy(id = "ppcpcancel")
	private WebElement pcpcancel;
	
	private PageData primarycareproviderInformation;

	public JSONObject primarycareproviderInformationJson;
	
	
 public PrimaryCareProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PRIMARY_CARE_PROVIDER_PAGE_DATA;
		primarycareproviderInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
	

		
	
		
	}

		
	public PlanPaymentOptions navigatesToNextStep() {
			pcpsaveandcont.click();
			if (pageHeadingPlanPaymentopt.getText().equalsIgnoreCase("Prescription Drug Coverage")) {
				return new PlanPaymentOptions(driver);
			}
			return null;
		}
	
		
	
	}
