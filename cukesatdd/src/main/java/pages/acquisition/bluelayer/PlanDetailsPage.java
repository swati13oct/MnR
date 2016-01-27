package pages.acquisition.bluelayer;

/*@author pagarwa5*/

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

public class PlanDetailsPage extends UhcDriver{
	
	@FindBy(id = "planDetailsPage")
	WebElement planDetailsContent;
	
	@FindBy(id = "learnmorebtnDetails")
	WebElement learnMoreButton;
	
	private PageData vppPlanDetails;

	public JSONObject vppPlanDetailsJson;

	public PlanDetailsPage(WebDriver driver,String planName) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = null;
		if(planName.contains("HMO"))
		{
			fileName = "maplandetails.json";
		}
		if(planName.contains("PDP"))
		{
			fileName = "pdpplandetails.json";
		}
		if(planName.contains("SNP"))
		{
			fileName = "snpplandetails.json";
		}
		
		vppPlanDetails = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		openAndValidate();
	}

	public String getPlanDetails() {
		return planDetailsContent.getText();

	}

	public AddDrugPage navigateToWTSPage() {
		learnMoreButton.click();
		if(driver.getTitle().equalsIgnoreCase("Plan Details"))
		{
			return new AddDrugPage(driver);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanDetails.getExpectedData().keySet()) {
			WebElement element = findElement(vppPlanDetails.getExpectedData()
					.get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		vppPlanDetailsJson = jsonObject;
		
	}

}
