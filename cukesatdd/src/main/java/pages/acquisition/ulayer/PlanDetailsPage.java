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
	
	@FindBy(id = "backToplans")
	private WebElement backToAllPlans;
	
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
	

	public VPPPlanSummaryPage backtoPlanSummary(String planType) {
		validate(backToAllPlans);
		if(backToAllPlans != null){
		backToAllPlans.click();		
		return new VPPPlanSummaryPage(driver, planType);
		}
		
	return null;
		
	}
	
}