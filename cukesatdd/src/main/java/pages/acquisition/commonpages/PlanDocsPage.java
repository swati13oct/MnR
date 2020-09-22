/**
 * 
 */
package pages.acquisition.commonpages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author saduri driver.findElement(By.xpath(".//label[@for='currentYear']")).click();
 *
 */
public class PlanDocsPage extends GlobalWebElements{	

	@FindBy(xpath = "//h1")
	public static WebElement header;
	
	@FindBy(xpath = "//h2")
	public static WebElement subtitle;
	
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
	
	@FindBy(xpath = ".//*[@id='county']/option[2]")
	private  WebElement selectMultiCounty;
	
	@FindBy(xpath = ".//*[@id='plan-year']/option[2]")
	private WebElement planYear;
	
	@FindBy(xpath = ".//*[@id='plan']/option[2]")
	private WebElement planName;
	
	@FindBy(xpath = "//*[@id='planDocForm']/div[4]/div/button/span")
	private WebElement continueButton;
	
	@FindBy(xpath = "//*[@id='planDocuments']/h3")
	private WebElement planTitle;	
	
	@FindBy(xpath = "//*[@id='planDocuments']/div/div[1]")
	private WebElement PDF;

	public PlanDocsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//startNew(urlvalue);		
	}
	
	public void validateContent() {		
		if(header.getText().contains("Plan Documents Search")){
			Assert.assertTrue("Heading is::"+header, true); 	
		}else
			Assert.fail("Heading is not matching");
		
		if(subtitle.getText().contains("To find your plan-specific documents enter your ZIP code, then choose your plan.")){
			Assert.assertTrue("Sub Heading is is::"+subtitle, true); 	
		}else
			Assert.fail("subheading is not matching");
	}
	
	public void validateLabels() {
		System.out.println("labelZipCode=="+labelZipCode.getText());
		if(labelZipCode.getText().contains("Enter ZIP code")){
			Assert.assertTrue("Zipcode is::"+labelZipCode.getText(), true); 	
		}else 
			Assert.fail("Zipcode is not matching");		
		
		System.out.println("labelSelectCounty=="+labelSelectCounty.getText());
		if(labelSelectCounty.getText().contains("Select a county")){
			Assert.assertTrue("County is::"+labelSelectCounty.getText(), true); 	
		}else
			Assert.fail("County is not matching");
		
		//System.out.println("labelPlan=="+labelPlan.getText());
		/*if(labelPlan.getText().contains("Choose a plan")){
			Assert.assertTrue("Plan is::"+labelPlan.getText(), true); 	
		}else
			Assert.fail("Plan is not matching");	*/	
	}
	
	public void enterValue(String zipcodeval,String selcounty, String plan, String plandropdown ) throws InterruptedException {
		System.out.println("zipCode=="+zipcodeval+"==county=="+selcounty);
		sendkeys(zipCode, zipcodeval);
		
		selectMultiCounty.click();
		
		if(plandropdown.equalsIgnoreCase("yes")){
			planYear.click();
			System.out.println("plan=="+plan);
		}
		planName.click();
		
		
		
	}
	
	public void verifyPDF(String plan) {
		continueButton.click();	
		System.out.println("Plan Documents for "+plan);
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		System.out.println(planTitle.getText());

			if(PDF.isDisplayed()){
				System.out.println("PDF is visible");
				Assert.assertTrue("PDF section is not there", true); 	
			}else
				Assert.fail("PDF section is there");		
			
		
			if(driver.findElement(By.xpath("//*[@id='planDocuments']/div/div[1]/h4")).getText().equalsIgnoreCase("English"))
				System.out.println("good");
			
			if(driver.findElement(By.xpath("//*[@id='planDocuments']/div/div[2]/h4")).getText().equalsIgnoreCase("Other Languages"))
				System.out.println("good 135");
			
		
	}	
}