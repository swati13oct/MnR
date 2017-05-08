/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = ".//*[@id='main_content']/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/h3")
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
		//CommonUtility.waitForPageLoad(driver, planInformationHeading,CommonConstants.TIMEOUT_30);
		//CommonUtility.waitForPageLoad(driver, claimSectionHeading,CommonConstants.TIMEOUT_30);
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
	
	@FindBy(xpath = ".//*[@id='plan_box']")
	private WebElement claimsPlanBox;
	
	
	@FindBy(xpath = ".//*[@id='plan_box']/div[1]/div[2]/div/p[1]")
	private WebElement claimsStatement;
	
	@FindBy(xpath = ".//*[@id='btn_searchallclaims']")
	private WebElement searchClaimsBtn;
	
	@FindBy(xpath = ".//*[@id='btn_searchallclaims1']")
	private WebElement searchClaimsBtn1;
	
	@FindBy(xpath = ".//*[@id='btn_viewclaims']")
	private WebElement viewClaimsBtn;
	
	@FindBy(xpath = ".//*[@id='btn_viewclaims1']")
	private WebElement viewClaimsBtn1;
	
	@FindBy(xpath = ".//*[@id='plan_box']/div[2]/div[2]/div/p[1]")
	private WebElement rxClaimsStatement;
	
	private WebElement medClaimsbtn = null, rxClaimsbtn = null;
	public boolean validateClaims() {
		boolean flag = false;
		CommonUtility.waitForPageLoad(driver, claimSectionHeading,20);
		if(validate(claimSectionHeading)&&validate(claimsPlanBox)){
			
			if(claimsStatement.getText().equals("No medical claims were processed.")){
				System.out.println("There were no medical claims found in the last 90 days");
				medClaimsbtn = searchClaimsBtn;
			}else{
				System.out.println("There were some medical claims found in the last 90 days");
				medClaimsbtn = viewClaimsBtn;
			}
			if(rxClaimsStatement.getText().equals("No prescription drug claims were processed.")){
				System.out.println("There were no rx claims found in the last 90 days");
				rxClaimsbtn = searchClaimsBtn1;
			}else{
				System.out.println("There were some rx claims found in the last 90 days");
				rxClaimsbtn = searchClaimsBtn;
			}
			if(validate(medClaimsbtn)&&validate(rxClaimsbtn))
				flag = true;
		}
		return flag;
	}
	
	public ClaimSummaryPage navigateToMedicalClaimsSummary() {
		
		
		viewClaimsBtn.click();
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

		viewClaimsBtn1.click();
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Claims")) {
			/*if (planCategory.equalsIgnoreCase("Individual")) {
				return new ClaimSummaryPage(driver, planCategory);
			} else { */
				return new ClaimSummaryPage(driver);
			/*}*/
		}

		return null;
	}
	
}


