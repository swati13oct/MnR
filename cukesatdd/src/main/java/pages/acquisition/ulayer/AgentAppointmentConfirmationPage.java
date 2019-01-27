/**
 * 
 */
package pages.acquisition.ulayer;

import java.io.File;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.vbfacquisition.agentflow.RequestAgentAppointmentConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class AgentAppointmentConfirmationPage extends UhcDriver {

	@FindBy(xpath=".//*[@id='subPageLeft']")
	private WebElement confirmationHeader;
	
	@FindBy(xpath=".//*[@id='subPageRight']/div/div/div/div/div")
	private WebElement rightRail;
	
	@FindBy(xpath=".//*[@id='ym-custom-container']//button[contains(text(),'Find plans')]")
	private WebElement findPlansBtn;
	
	public JSONObject agentConfirmationJson;


	public AgentAppointmentConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		validateNew(findPlansBtn);
	}

	public JSONObject getExpectedData() {
		String fileName = "agentappointmentconfirmation";
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_ULAYER
				+ File.separator + RequestAgentAppointmentConstants.REQUEST_AGENT_APPOINTMENT_FLOW_NAME
				+ File.separator;
		JSONObject agentappointmentconfirmation = MRScenario.readExpectedJson(
				fileName, directory);
		return agentappointmentconfirmation;
	}
	
	public boolean validateConfirmationPage(){
		CommonUtility.waitForPageLoad(driver, confirmationHeader,CommonConstants.TIMEOUT_30);
		if(validate(rightRail))//.getText().contains("Thank You for Your Appointment Request"))
			return true;
		return false;
	}
}
