package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class RallyDashboard extends UhcDriver{
	
	@FindBy(id="hello-person")
	private WebElement WelcomeMessage;
	
	@FindBy(linkText="VIEW DOCUMENTS & RESOURCES")
	private WebElement DOCUMENTSRESOURCES;
	

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
	
	public void navigatetoFormsnResources()
	{
		DOCUMENTSRESOURCES.click();
		
	}
 
 
}
