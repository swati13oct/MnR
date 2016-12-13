package pages.mobile.acquisition.ulayer;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class VPPRequestSendEmailConfirmationPage extends UhcDriver {
	
	public JSONObject sendEmailConfirmationJson;

	private PageData sendEmailConfirmation;

	public VPPRequestSendEmailConfirmationPage(WebDriver driver) {
		super(driver);
		String sendEmailConfirmationFile = CommonConstants.AGENT_CONFIRMATION_PAGE_DATA;
		sendEmailConfirmation = CommonUtility.readPageData(sendEmailConfirmationFile,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

	}

}
