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

	@FindBy(xpath ="//*[@id='myDoctorDetails']")
	private WebElement plandetailProviderlink;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[1]/p[4]")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[3]/span[1]")
	private WebElement planCost1;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[4]/span[1]")
	private WebElement planCost2;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[3]/td[4]/div/div/span[1]")
	private WebElement planCost3;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]")
	private WebElement planCost4;
	
	@FindBy(xpath = "//*[@id='detailplanNameBox']/div/div/div/span/h3")
	private WebElement planName;

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

	public Rallytool_Page lookupaproviderclick() {
		validate(plandetailProviderlink);
		plandetailProviderlink.click();
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

	public void validateDrugList(String nameOfPlan, String expectedErrorMessage) {
		driver.navigate().refresh();
		String pName = planName.getText().toString();
		if(pName.contains(nameOfPlan)){
			//String expectedErrorMessage = "The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.";
			String actualErrorMessage = errorMessage.getText().toString();
			if(actualErrorMessage.equals(expectedErrorMessage))
			{
				System.out.println("Validated the error message");
			}
			else{
				System.out.println("Expected Error Message is --------"+expectedErrorMessage);
				System.out.println("But got ---------"+actualErrorMessage);
			}

		}
		else{
			System.out.println("The user is not on the correct page");
		}

	} 

	public void validatePlanCost(String planName){
		String pName = planName.toString();
		String pCost1 = planCost1.getText();
		String pCost2 = planCost2.getText();
		String pCost3 = planCost3.getText();
		String pCost4 = planCost4.getText();
		if(pName.contains(planName)){
			if(pCost1.equals("--")&&pCost2.equals("--")&&pCost3.equals("--")&&pCost4.equals("--")){
				System.out.println("Verified Plan Costs");
			}
			else{
				System.out.println("Plan costs contains data");
			}


		}
		else{
			System.out.println("The user is not on the correct page");
		}

	}

}


