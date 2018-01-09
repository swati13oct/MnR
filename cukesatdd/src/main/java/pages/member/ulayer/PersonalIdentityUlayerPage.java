package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class PersonalIdentityUlayerPage extends UhcDriver {	
	
	@FindBy(xpath = ".//*[@id='sign-in-form']/fieldset/div[1]/div[1]/div/div/label")
	private WebElement Username;
	
	@FindBy(xpath = ".//*[@id='sign-in-form']/fieldset/div[1]/div[2]/div/div/label")
	private WebElement Password;
	
	@FindBy(id = "missing-btn")
	private WebElement Continue;
	
	@FindBy(xpath = ".//*[@id='sign-in-form']/fieldset/div[2]/a")
	private WebElement Cancel;
	
	@FindBy(xpath = ".//*[@id='sign-in-form']/fieldset/div[1]/label[1]")
	private WebElement MemberId;	
	
	@FindBy(id = "missingerror")
	private WebElement ErrorMessage;
			
	
	public PersonalIdentityUlayerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);		
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {
		driver.get("https://member."+MRScenario.TeamCEnvironment+"-aarpmedicareplans.uhc.com/content/dashboard/guest/username-and-password-assistance.html#/identityassistance");
		}
	
	
	public PersonalIdentificationPageNew navigateToPersonalIdentificationPage() throws InterruptedException {
		System.out.println("In PI method");
		Thread.sleep(2000);
		Username.click();
		System.out.println("Username clicked");
		Password.click();
		System.out.println("Password clicked");
		Continue.click();
		System.out.println("Continue Clicked");
		Thread.sleep(7000);
		if(MemberId.getText().contains("Member ID Number"))
		{
			return new PersonalIdentificationPageNew(driver);
		}
		return null;
	}


	
	public LoginPage SignInPageMovement() throws InterruptedException {
		System.out.println("In Sign In Movement method");
		Thread.sleep(2000);		
		Cancel.click();
		System.out.println("Cancel Clicked");
		Thread.sleep(2000);
		if(driver.getTitle().equalsIgnoreCase("signin"))
		{
			return new LoginPage(driver);
		}
		return null;
	}
	
	
	public PersonalIdentificationPageNew ErrorMessageValidation() throws InterruptedException {
		System.out.println("In ErrorMessage method");
		Thread.sleep(2000);		
		Continue.click();
		System.out.println("Continue Clicked");
		Thread.sleep(2000);
		if(ErrorMessage.getText().contains("This field is required"))
		{
			return new PersonalIdentificationPageNew(driver);
		}
		return null;
	}

	
	
}
