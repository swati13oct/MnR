package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.Rallytool_Page;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PlanDetailsPage extends UhcDriver{
	
	@FindBy(id = "planDetailsPage")
	private WebElement planDetailsContent;
	
	@FindBy(id = "learnmorebtnDetails")
	private WebElement learnMoreButton;
	
	@FindBy(id = "yourDceInitial")
	private WebElement enterDrugInfoLink;
	
	@FindBy(xpath ="/html/body/div[4]/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[4]/td[2]/a")
	private WebElement plandetailsProviderlink;
	
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
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
		vppPlanDetailsJson = jsonObject;
		
	}

	public GetStartedPage clicksOnEnterDrugInformationLink() {
		
		enterDrugInfoLink.click();
		
		if (currentUrl().contains("/estimate-drug-costs")) {
			return new GetStartedPage(driver);
		}
		return null;
	}

	public Rallytool_Page lookupproviderclick() {
		validate(plandetailsProviderlink);
		plandetailsProviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
						"Find Care")) {
			return new Rallytool_Page(driver);
		}
		
		// TODO Auto-generated method stub
		return null;
	} 
	
}
