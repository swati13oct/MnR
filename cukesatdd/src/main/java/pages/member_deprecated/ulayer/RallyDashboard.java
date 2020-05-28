package pages.member_deprecated.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.dashboard_deprecated.formsandresources.FormsAndResourcesPage;

public class RallyDashboard extends UhcDriver{
	
	@FindBy(id="hello-person")
	private WebElement WelcomeMessage;
	
	@FindBy(linkText="VIEW DOCUMENTS & RESOURCES")
	private WebElement DOCUMENTSRESOURCES;
	
	@FindBy(xpath="//*[@class='fluid-nav ng-scope']/div/div/a[5]")
    private WebElement PremiumPaymentsLink;	

	public RallyDashboard(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(WelcomeMessage);
		System.out.println("Welcome Message Displayed");		
	}
	
	   public FormsAndResourcesPage navigatetoFormsnResources()
       {
                       DOCUMENTSRESOURCES.click();
                       return new FormsAndResourcesPage(super.driver);
                       
       }
 
	
	public PaymentsOverview navigateToPaymentOverview() throws InterruptedException
	{
		Thread.sleep(15000);
		if(PremiumPaymentsLink.isEnabled()){
			PremiumPaymentsLink.click();
			return new PaymentsOverview(driver);
		}
		return null;
	}


}
