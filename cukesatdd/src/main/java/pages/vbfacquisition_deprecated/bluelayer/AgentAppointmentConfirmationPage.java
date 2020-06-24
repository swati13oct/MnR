/**
 * 
 */
package pages.vbfacquisition_deprecated.bluelayer;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import acceptancetests.vbfacquisition_deprecated.agentflow.RequestAgentAppointmentConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class AgentAppointmentConfirmationPage extends UhcDriver {

	public JSONObject agentConfirmationJson;

	private PageData agentConfirmation;

	public AgentAppointmentConfirmationPage(WebDriver driver) {
		super(driver);
		String agentConfirmationFile = CommonConstants.AGENT_CONFIRMATION_PAGE_DATA;
		agentConfirmation = CommonUtility.readPageData(agentConfirmationFile,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : agentConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(agentConfirmation
					.getExpectedData().get(key));
			if (validate(element)) {
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		agentConfirmationJson = jsonObject;
		
		System.out.println("agentConfirmationJson------->"+agentConfirmationJson);
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
}
