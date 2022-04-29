package pages.UHCCP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.WelcomePage;

public class PlanDetailsPage extends UhcDriver {
	
	@FindBy(xpath = "//div[contains(@class,'providerSearch')]")
	private WebElement providerCoverageSection;
	
	@FindBy(xpath = "//div[contains(@class,'benefitsList')]")
	private WebElement benefitsListSection;
	
	@FindBy(xpath = "//div[contains(@data-sb-container-name,'Enroll today')]")
	private WebElement enrollSection;
	
	@FindBy(xpath = "//div[contains(@class,'email-capture__form')]")
	private WebElement emailGuideSection;
	
	@FindBy(xpath = "(//a[contains(@id,'oleButton')])[1]")
	private WebElement EnrollinPlan;
	
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class, 'only-intro')]")
	private WebElement WelcomePageHeader;

	public PlanDetailsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		checkModelPopup(driver, 10);
		validateNew(providerCoverageSection);
		validateNew(benefitsListSection);
		validateNew(enrollSection);
		//validateNew(emailGuideSection);
	}

	public OLE_Enroll_Plan_Page enrollInPlan(String planName, String zipcode) {
		System.out.println("Enroll in Plan for Plan : " + planName);
		try {
			if (validate(EnrollinPlan)) {
				jsClickNew(EnrollinPlan);
				System.out.println("Found Enroll IN Plan Button for the Plan : " + planName);
			}
			else
				System.out.println("Enroll in Plan Button is Not Displayed ");

		} catch (Exception e) {
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}
		CommonUtility.waitForPageLoadNew(driver, WelcomePageHeader, 5);
		
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new OLE_Enroll_Plan_Page(driver,zipcode);
		}
		return null;
	}

}
