/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PlanSummaryPage extends UhcDriver {

	@FindBy(id = "addAnotherPlanLink")
	private WebElement addAnotherPlanLink;
	
	
	@FindBy(linkText = "addaplan")
	private WebElement addaplanlink;
	
	//@FindBy(xpath = ".//*[@id='plan_box']/div[1]/div[2]/div/p[2]/a")
	//private WebElement searchMedClaimsBtn;
	
	
	
	@FindBy(id = "btn_viewclaims")
	private WebElement searchMedClaimsBtn;
	
	//@FindBy(xpath = ".//*[@id='plan_box']/div[2]/div[2]/div/p[2]/a")
	//private WebElement searchDrugClaimsBtn;
	
	
	@FindBy(id = "btn_searchallclaims1")
	private WebElement searchAllClaimsBtn;

	@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div/div[2]/div/div[2]/div/h3")
	private WebElement planInformationHeading;

	//@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div/div[3]/div/div[2]/div/h3")
	//private WebElement claimSectionHeading;
	
	@FindBy(xpath="//div[@id='main_content']//h3[contains(.,'Claim Activity')]")
	private WebElement claimSectionHeading;
	

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	//@FindBy(xpath = ".//*[@id='plan_box']")
	//private WebElement claimsPlanBox;
	
	@FindBy(id = "plan_box")
	private WebElement claimsPlanBox;
	
	

	public JSONObject planSummaryJson;

	public PlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		//CommonUtility.waitForPageLoad(driver, planInformationHeading,CommonConstants.TIMEOUT_30);
		//CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
		openAndValidate();
	}

	public PlanSummaryPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		
		CommonUtility.waitForPageLoad(driver, planInformationHeading,10);
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,10);
		
		openAndValidate();
	}


	public AddPlanPopUpPage clickAddPlan() {
		addAnotherPlanLink.click();
		CommonUtility.checkPageIsReady(driver);
		return new AddPlanPopUpPage(driver);
	}



	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {
		/*

		JSONObject jsonObject = new JSONObject();
		for (String key : planSummary.getExpectedData().keySet()) {
			

			WebElement element = findElement(planSummary.getExpectedData().get(
					key));
			System.out.println(element.getText());
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
		planSummaryJson = jsonObject;

		System.out.println("planSummaryJson----->"+planSummaryJson); */
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		/* get PLAN_SUMMARY expected data */
		JSONObject planSummaryExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_SUMMARY);
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		planSummaryExpectedJson = CommonUtility.mergeJson(
				planSummaryExpectedJson, globalExpectedJson);

		return planSummaryExpectedJson;
	}


	public void validatePlanName(){
    	String planName = LoginCommonConstants.PLAN_NAME;
    	System.out.println(planName);
	    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
    	for(int i=0; i<planWebElement.size();i++){
    		if(planWebElement.get(i).getText().contains("UnitedHealthcare Medicare Rx")){
    			System.out.println("----------Failed due to presence of UnitedHealthcare Medicare Rx  ------------");
    			Assert.fail();
    		}
    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
    			System.out.println("----------Plan name displayed as expected="+planName);
    		} else{
	    			System.out.println("----------Failed because Plan NAme not present");
	    			Assert.fail();
	    		} 	  		 
    	  }
       }

	public void validatePharmacySaver() {
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean present;
		try {
			driver.findElement(By.id("Atdd_Pharmacy_Saver_Widget"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");

	}


	public boolean validateViewDetailsButton() {
		boolean presentLink =false;
		
		try {
		//	if(viewDetailsButtons.isDisplayed()){
				
				presentLink = true;
		//	}			  
			 
		} catch (NoSuchElementException e) {
			presentLink = false;
		}
		return presentLink;
		
		
		// TODO Auto-generated method stub
		
	}
	

	public boolean validateaddaplanlink() {
		
	boolean presentLink =false;
		
		try {
			if(addaplanlink.isDisplayed()){
				
				presentLink = true;
				return presentLink;
			}			  
			 
		} catch (NoSuchElementException e) {
			presentLink = false;
		}
		return presentLink;
		// TODO Auto-generated method stub
		
	}

	

	public boolean validateClaims() {
		boolean flag = false;
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
		if(validate(claimSectionHeading)&&validate(claimsPlanBox)){
				flag = true;
		}
		return flag;
	}
	
	public ClaimSummaryPage navigateToMedicalClaimsSummary() {
		
		searchMedClaimsBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}
	public ClaimSummaryPage navigateToDrugClaimsSummary() {
		CommonUtility.waitForPageLoad(driver, searchAllClaimsBtn, 25);
		searchAllClaimsBtn.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
				return new ClaimSummaryPage(driver);
		}
		return null;
	}
	

}


