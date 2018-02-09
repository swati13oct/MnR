package pages.member.ulayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.dashboard.formsandresources.FormsAndResourcesPage;
import pages.dashboard.member.ulayer.ClaimSummarypage;

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
	/**
     * @throws InterruptedException 
	 * @toDo : clicking forms and resources link on dashboard
     */
	   public pages.dashboard.formsandresources.FormsAndResourcesPage navigatetoFormsnResources() throws InterruptedException
       {
                     //  DOCUMENTSRESOURCES.click();
                      if (MRScenario.environment.equalsIgnoreCase("team-ci1") || MRScenario.environment.equalsIgnoreCase("team-g") ||MRScenario.environment.equalsIgnoreCase("test-a") ) {
                    	  Thread.sleep(40000);
               			System.out.println("Go to forms and resources link is present "+driver.findElement(By.xpath("//*[contains(text(),'Go to Forms and Resource page')]")).isDisplayed());
               			driver.findElement(By.xpath("//*[contains(text(),'Go to Forms and Resource page')]")).click();
               			
               		}

               		else if (MRScenario.environment.equalsIgnoreCase("stage")) {
               			System.out.println("user is on Stage login page");			
               						
               			if(driver.getCurrentUrl().contains("/dashboard"));
               			{
               				System.out.println("User is on dashboard page and URL is ====>"+driver.getCurrentUrl());
               				Thread.sleep(20000);
               				DOCUMENTSRESOURCES.click();
               				
               			}
               				
               		}
               		else 
               		{
               			System.out.println("This script is only intended to be run using test harness on team-b or team-h. Update condition for your own environment");	
               		}
               		
                      System.out.println(driver.getTitle());

               		
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
