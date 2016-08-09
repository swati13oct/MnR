/**
 * 
 */
package pages.acquisition.ulayer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skyscreamer.jsonassert.JSONAssert;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.annotation.en.And;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;

/**
 * @author gumeshna
 *
 */
public class PlanDetailsPage extends UhcDriver {

	@FindBy(id = "planDetailsPage")
	private WebElement plandetails;

	@FindBy(id = "learnmorebtnDetails")
	private WebElement waysToSaveLink;

	@FindBy(xpath="//*[@id='enrollDetails']/span")
	private WebElement enrollinaPlan;

	@FindBy(xpath = "//*[@id='detailplanNameBox']/div/div/div/span/h3")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[1]/p[4]")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[3]/span[1]")
	private WebElement planCost1;
	
	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[4]/span[1]")
	private WebElement planCost2;
	
	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[3]/td[4]/div/div/span[1]")
	private WebElement planCost3;
	
	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]")
      
	
	//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]
	private WebElement planCost4;

       @FindBy(id = "yourDceInitial")
	private WebElement enterDrugInfoLink;
	
	
	private PageData vppPlanDetails;

	public JSONObject vppPlanDetailsJson;

	public PlanDetailsPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, plandetails, CommonConstants.TIMEOUT_30);
		String fileName = null;
		if(planType.equalsIgnoreCase("MA")||planType.equalsIgnoreCase("MAPD"))
		{
			fileName = "maplandetails.json";
		}
		else
		{
			fileName = planType.toLowerCase()+"plandetails.json";
		}

		vppPlanDetails = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public ManageDrugPage showWaysToSave(){
		waysToSaveLink.click();
		try{
			if(waysToSaveLink.isDisplayed()){
				CommonUtility.waitForElementToDisappear(driver, waysToSaveLink,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("waysToSaveLink not found");
		} catch (TimeoutException ex) {
			System.out.println("waysToSaveLink not found");
		} catch (Exception e) {
			System.out.println("waysToSaveLink not found");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}


	}

	public String getContent() {
		return plandetails.getText();
	}

	public String getPlanDetails() {
		// TODO write implementation of the method
		return null;
	}

	public AddDrugPage navigateToWTSPage() {
		// TODO write implementation of the method
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(plandetails);
		validate(waysToSaveLink);
		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanDetails.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(vppPlanDetails.getExpectedData()
					.get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(key, element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		vppPlanDetailsJson = jsonObject;
		System.out.println("vppPlanDetailsJson------>" + vppPlanDetailsJson);



	}

	public PlanInformationPage navigatetoenrollinplanlink(String planName)
	{
		enrollinaPlan.click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("AARP Medicare Complete Online Application") || driver.getTitle().equalsIgnoreCase("AARP Medicarerx Online Application")|| driver.getTitle().equalsIgnoreCase("Enrollment Information"))
		{
			System.out.println("in if");
			return new PlanInformationPage(driver, planName);
		}

		return null;
	}

	public void validateDrugList(String planName,String expectedErrorMessage) {
		driver.navigate().refresh();
		String pName = planName.toString();
		if(pName.contains(planName)){
			//String expectedErrorMessage = "The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.";
			String actualErrorMessage = errorMessage.getText();
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

	public void validatePlanCost(String planName) {
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

          public GetStartedPage clicksOnEnterDrugInformationLink() 
	{
		enterDrugInfoLink.click();
		
		if (currentUrl().contains("/estimate-drug-costs")) {
			return new GetStartedPage(driver);
		}
		return null;
		// TODO Auto-generated method stub
		
	}
	
}