package pages.vbfacquisition_deprecated.bluelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.vbfacquisition_deprecated.ole.WelcomePage;

public class PlanComparePage extends UhcDriver{
	
	//header elements
	@FindBy(id="ghn_lnk_1")
	private WebElement homeLink;
	
	@FindBy(id="ghn_lnk_2")
	private WebElement ourPlansLink;
	
	@FindBy(id="ghn_lnk_3")
	private WebElement medicareEducationLink;
	
	@FindBy(id="search-field")
	private WebElement searchTextBox;
	
	//footer elements
	@FindBy(id="gf_lnk_1")
	private WebElement homeFooterLink;
	
	@FindBy(xpath="//a[@class='back-to-top' and contains(text(),'Back to Top')]")
	private WebElement backToTopLink;
	
	

	public PlanComparePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
 	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	public PlanComparePage validateHaderAndFooter(){
		validate(homeLink);
		validate(ourPlansLink);
		validate(medicareEducationLink);
		validate(searchTextBox);
		validate(backToTopLink);
		validate(homeFooterLink);
		return new PlanComparePage(driver);
	}
	
	/**
	 * @author sdwaraka
	 * Method Added for OLE Flow - Navigate to OLE from Plan Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {
		
		System.out.println("Enroll in Plan for Plan : "+planName);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@id='innerdiv']//*[contains(text(), 'Enroll in plan')]"));
		try {
		validate(EnrollForPlan);
		
		System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}catch(Exception e){
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}
		EnrollForPlan.click();
		
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("enrollment")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}


}
