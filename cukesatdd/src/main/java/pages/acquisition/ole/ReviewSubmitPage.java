/**
 * 
 */
package pages.acquisition.ole;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class ReviewSubmitPage extends UhcDriver{
	
	@FindBy(id="firstnametextbox")
	private WebElement firstNameField;
	
	@FindBy(id = "middlenametextbox")
	private WebElement middleInitialField;
	
	@FindBy(id = "lastnametextbox")
	private WebElement lastNameField;
	
	/*@FindBy(xpath = ".//*[@id='medicalclaimnum']/input[2]")
	private WebElement claimNumberField;*/
	
	@FindBy(xpath = "//*[@id='medicalclaimnumtext'][2]")
	private WebElement claimNumberField;
	
	@FindBy(id = "part-a")
	private WebElement partAStartDateField;
	
	@FindBy(id = "part-b")
	private WebElement partBStartDateField;
	
	@FindBy(id = "enrollmentdisclaimerstep1btn")
	private WebElement viewEnrollDisclaimer;
	
	@FindBy(id="disclaimerAgreeBtndisclaimer")
	private WebElement disclaimeragreebtn;
	
	@FindBy(id="beginOnlineEnrollmentbtn")
	private WebElement enrollmentNext;
	
	@FindBy(id = "beginOnlineEnrollmentBtn")
	private WebElement beginOnlineEnrBtn;
	
	@FindBy(xpath = "//div[@id='beginOnlineEnrollment']/span")
	private WebElement alreadyEnrolledErrorMsg;
	
	@FindBy(id = "medicalclaimnumerr")
	private WebElement MedicareIDErrorMsg;
	
	@FindBy(id = "step2Heading")
	private WebElement NextStepPage;
	
	
	private PageData ReviewSubmitPage;

	public ReviewSubmitPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.INTRODUCTION_INFORMATION_PAGE_DATA;
		ReviewSubmitPage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}



}