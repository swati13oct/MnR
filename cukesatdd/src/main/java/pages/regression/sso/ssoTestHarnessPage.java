/**
 * 
 */
package pages.regression.sso;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import pages.memberredesign_deprecated.bluelayer.AccountHomePage;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

/**
 * @author jkuma14
 *
 */
public class ssoTestHarnessPage extends UhcDriver {

	@FindBy(name="ssosource")
	private WebElement ssoPartnerdropdown;
	
	@FindBy(name="FIRSTNAME")
	private WebElement firstName;
	
	@FindBy(name="LASTNAME")
	private WebElement lastName;
	
	@FindBy(name="DOB")
	private WebElement dateofBirth;
	
	@FindBy(name="UHC_ID")
	private WebElement uhcID;
	
	@FindBy(name="EAID")
	private WebElement eaID;
	
	@FindBy(name="EMPNUMBER")
	private WebElement empNumber;
	
	@FindBy(name="Submit")
	private WebElement submitButton;
	
	@FindBy(linkText="stage-medicare.uhc.com/sso/inbound")
	private WebElement ssoLink;
	
	@FindBy(xpath = "//*[contains(@class,'btn btn-outline-primary')]")
	private WebElement homePageNotice;
	
	public ssoTestHarnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/*This method will select the value of SSO Partner from the dropdown , the expected value is obtained from feature file */
	public void selectBenefitFocusFromSSOPartnerDropdown(String ssopartner) {
		//driver.switchTo().frame("cq-cf-frame");
		
		 Select dropdown= new Select(ssoPartnerdropdown);
	    dropdown.selectByVisibleText(ssopartner);
	}
	
	/*This method will enter first name on SSO Test Harness page */
   public void enterFirstName(String fname) {
	    	sendkeys(firstName, fname);
	        }
   /*This method will enter last name on SSO Test Harness page */
   public void enterLastName(String lname) {
   	sendkeys(lastName, lname);
       }	
   /*This method will enter dob on SSO Test Harness page */
   public void enterDOB(String dob) {
	   	sendkeys(dateofBirth, dob);
	       }
   /*This method will enter uhcid on SSO Test Harness page */
   public void enterUHCID(String uhcid) {
	   	sendkeys(uhcID, uhcid);
	       }	
   /*This method will enter EAID on SSO Test Harness page */
   public void enterEAID(String eaid) {
	   	sendkeys(eaID, eaid);
	       }	
   
   /*This method will enter employer number on SSO Test Harness page */
   public void enterEmpNumber(String empnumber) {
	   	sendkeys(empNumber, empnumber);
	       }	
   
   /*This method will click submit button on SSO test harness page */
   public void clickSubmit() throws InterruptedException {
	   submitButton.click();
	   Thread.sleep(2000);
	       }	

  
	/*This method will click on SSO Link on test harness page , and then switch to Home Page window */
   public AccountHomePage clickSSOLink() throws InterruptedException {
		ssoLink.click();
	    Thread.sleep(10000);
	   switchToNewTab();
	   String oldURLwithttp = driver.getCurrentUrl();
	   System.out.println("SSO link generated is  "+oldURLwithttp);
	   if(oldURLwithttp.contains("https://"))
	   {
		   System.out.println("Now clicking on the SSO link");
		   driver.navigate().to(oldURLwithttp);  
	   }
	   else
	   {
	  System.out.println("SSO Link doesn't contain https:// , therefore replacing http:// with https://");
	   String newURLwithttps = oldURLwithttp.replace("http://", "https://");
	   System.out.println("Updated SSO link with https is  "+newURLwithttps);
	   System.out.println("Now clicking on the SSO link");
	   driver.navigate().to(newURLwithttps);
	   }
	   Thread.sleep(5000);
	   System.out.println("Now Checking if user landed on covid-19 banner page");
	  
	   if(validate(homePageNotice)) {
		   System.out.println("User landed on covid-19 banner page, clicking continue/home button"); 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", homePageNotice);
			homePageNotice.click();
			 System.out.println("Continue/home button was clicked"); 
		}
	   else
	   {
	   System.out.println("Either Covid-19 banner page was not displayed or the Continue/Home button was not displayed, returing AccountHomePage"); 
	    }
	   return new AccountHomePage(driver);

}

   
	@Override
	public void openAndValidate() {
				
	}

	

	
}
