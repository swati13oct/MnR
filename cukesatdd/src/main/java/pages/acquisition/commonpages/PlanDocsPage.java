/**
 * 
 */
package pages.acquisition.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;

/**
 * @author saduri driver.findElement(By.xpath(".//label[@for='currentYear']")).click();
 *
 */
public class PlanDocsPage extends GlobalWebElements{	

	@FindBy(xpath = "//*[@id='uhcheader']/div/div/div/h1")
	public WebElement header;
	
	@FindBy(xpath = "//*[@id='uhc-plandocumentsApp']/div[2]/div[1]/div/div/div/div/div/h2")
	public WebElement subtitle;
	
	@FindBy( xpath= ".//label[@for='zip-code']")
	private WebElement labelZipCode;
	
	@FindBy(xpath = "//*[@id='planDocForm']/div[1]/div[2]/label")
	private WebElement labelSelectCounty;
	
	@FindBy(xpath = "//*[@id='planDocForm']/div[2]/div/label")
	private WebElement labelPlanYear;
	
	@FindBy(xpath = "//*[@id='planDocForm']/div[3]/div/label")
	private WebElement labelPlan;
	
	@FindBy(xpath = "//*[@id='zip-code']")
	private WebElement zipCode;
	
	@FindBy(id = "county")
	private  WebElement selectMultiCounty;
	
	@FindBy(id = "plan")
	private WebElement planYear;
	
	@FindBy(xpath = ".//*[@id='plan']/option[2]")
	private WebElement planName;
	
	@FindBy(xpath = "//*[@id='planDocForm']/div[3]/div/button")
	private WebElement continueButton;
	
	@FindBy(xpath = "//*[@id='planDocuments']/h3")
	private WebElement planTitle;
	
	@FindBy(id = "zip-code-error")
	private WebElement zipcodeerror;
	
	@FindBy(id = "county-error")
	private WebElement countyerror;
	
	@FindBy(id = "plan-error")
	private WebElement planerror;
	
	@FindBy(xpath = "//*[@id='planDocuments']/div/div[1]")
	private WebElement PDF;

	public PlanDocsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//startNew(urlvalue);		
	}
	
	public void validateContent() {		
		if(header.getText().contains("Plan Documents Search")){
			Assertion.assertTrue("Heading is::"+header, true); 	
		}else
			Assertion.fail("Heading is not matching");
		
		if(subtitle.getText().contains("To find your plan-specific documents enter your ZIP code, then choose your plan.")){
			Assertion.assertTrue("Sub Heading is is::"+subtitle, true); 	
		}else
			Assertion.fail("subheading is not matching");
	}
	
	public void validateLabels() {
		System.out.println("labelZipCode=="+labelZipCode.getText());
		if(labelZipCode.getText().contains("Enter ZIP code")){
			Assertion.assertTrue("Zipcode is::"+labelZipCode.getText(), true); 	
		}else 
			Assertion.fail("Zipcode is not matching");		
		
		System.out.println("labelSelectCounty=="+labelSelectCounty.getText());
		if(labelSelectCounty.getText().contains("Select a county")){
			Assertion.assertTrue("County is::"+labelSelectCounty.getText(), true); 	
		}else
			Assertion.fail("County is not matching");
		
	
	}
	
	public void enterYearValue(String plandropdown ) throws InterruptedException {
		if(plandropdown.equalsIgnoreCase("yes")){
			planYear.click();
		}
	}	

	public void enterZipCodeValue(String zipcodeval) {
		sendkeys(zipCode, zipcodeval);	
	}
	

	public void enterCountyValue(String county) {
		jsClickNew(selectMultiCounty);
		WebElement countySelection = driver.findElement(By.xpath("//option[contains(text(), '" + county + "')]"));
		countySelection.click();
	}
	

	public void enterPlanValue(String plan) {
		jsClickNew(planName);
		WebElement planSelection = driver.findElement(By.xpath("//option[contains(text(), '" + plan + "')]"));
		planSelection.click();
	}
	
	public void continuebuttonOnClick() {
		continueButton.click();	
	}
	
	public boolean verifyErrorZipCodeMessage() {
		if(zipcodeerror.isDisplayed()){
			zipcodeerror.getText().contains("Please enter a valid ZIP code");
			Assertion.assertTrue("zipcodeerror section is visible", true); 
			return true;
		}else{
			Assertion.fail("zipcodeerror is not visible");
			return false;
		}
	}
	
	public boolean verifyErrorCountyMessage() {
		if(countyerror.isDisplayed()){
			countyerror.getText().contains("Please select a county");
			Assertion.assertTrue("countyerror section is visible", true); 	
			return true;
		}else{
			Assertion.fail("countyerror is not visible");
			return false;
		}
	}
	
	public boolean verifyErrorPlanMessage() {
		if(planerror.isDisplayed()){
			planerror.getText().contains("Please select a plan");
			Assertion.assertTrue("planerror section is visible", true); 	
			return true;
		}else{
			Assertion.fail("planerror is not visible");
			return false;
		}		
	}
	
	public void verifyPDF(String plan) {
		continuebuttonOnClick();
		System.out.println("Plan Documents for "+plan);
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		System.out.println(planTitle.getText());

			if(PDF.isDisplayed()){
				System.out.println("PDF is visible");
				Assertion.assertTrue("PDF section is visible", true); 	
			}else
				Assertion.fail("PDF section is not visible");		
			
		
			if(driver.findElement(By.xpath("//*[@id='planDocuments']/div/div[1]/h4")).getText().equalsIgnoreCase("English"))
				System.out.println("good");
			
			if(driver.findElement(By.xpath("//*[@id='planDocuments']/div/div[2]/h4")).getText().equalsIgnoreCase("Other Languages"))
				System.out.println("good 135");
			
		
	}	
}
