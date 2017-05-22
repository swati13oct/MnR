/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.AddPlanPopUpPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
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
	
	
	@FindBy(xpath = "//a[@id='btn_viewdetails']")
   private WebElement viewDetailsButtons;

	@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div/div[2]/div/div[2]/div/h3")
	private WebElement planInformationHeading;

	@FindBy(xpath = "//div[@id='main_content']/div[2]/div/div[2]/div/div[3]/div/div[2]/div/h3")
	private WebElement claimSectionHeading;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div[160]/div[2]/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div/p/a")
	private WebElement viewdetailbutton;
	
	@FindBy(xpath=".//*[contains(text(),'search providers')]")
	private WebElement searchProvider;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(id="btn_viewdetails")
	private WebElement viewDetailsButton;

	private PageData planSummary;

	public JSONObject planSummaryJson;

	public PlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_SUMMARY_PAGE_DATA;
		CommonUtility.waitForPageLoad(driver, planInformationHeading,CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
		planSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public PlanSummaryPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_SUMMARY_PAGE_DATA;
		CommonUtility.waitForPageLoad(driver, planInformationHeading,CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
		planSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
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
			if(viewDetailsButtons.isDisplayed()){
				
				presentLink = true;
			}			  
			 
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
}


