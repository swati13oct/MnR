package pages.dashboard.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MemberNewSignInPage extends UhcDriver{
	//private PageData newSign;

	/*@FindBy (css ="#siginaccheader")
	private WebElement signInCard;*/
	
	@FindBy (id="siginaccheader")
	private WebElement signInCard;

	@FindBy (css = ".page-header--left")
	private WebElement signInHeader;
	
	/*@FindBy (className = ".page-header--left")
	private WebElement signInHeader;*/

	/*@FindBy (css = "#username")
	private WebElement username;*/
	
	@FindBy (id = "username")
	private WebElement username;

	@FindBy (id = "password")
	private WebElement password;

/*	@FindBy (css = "#sign-in-btn")
	private WebElement signInButton;*/
	
	@FindBy (id= "sign-in-btn")
	private WebElement signInButton;
	
	@FindBy (id ="uname_pwd_empty_error")
	private WebElement emptyUsernamePswd;

	/*@FindBy (css = "#username-error>p")
	private WebElement usernameErrormessage;*/

	@FindBy (id = "username-error")
	private WebElement usernameErrormessage;
	
/*	@FindBy (css ="#password-error>p")
	private WebElement passwordErrorMessage;*/
	
	@FindBy (id ="password-error")
	private WebElement passwordErrorMessage;
	
	@FindBy (id ="regbutton")
	private WebElement registerbutton;
	
	@FindBy (linkText ="Forgot your username and password?")
	private WebElement forgotusernamepasswordlink;
	
	@FindBy (id ="member-id")
	private WebElement MemberId;
	
	@FindBy (css = "#regbutton")
	private WebElement regbutton;
	

	private WebDriver driver;

	
	
	public MemberNewSignInPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		//CommonUtility.waitForPageLoad(driver, ClaimDetailsPage, 60);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		
		// TODO Auto-generated method stub

	}

	public  void validateNewSignPage(){

		CommonUtility.waitForPageLoad(this.driver, signInCard, 30);
		
		if (signInHeader.isDisplayed()){

			System.out.println("i am in new sign page ------------> "+ driver.getCurrentUrl());
		}else
		{
			System.out.println("Page not loaded correctly ==========> "+ signInHeader.isDisplayed());
		}
	}	

	public  void clearUnAndPwfields() {
		username.clear();
		password.clear();
		signInButton.click();
	}

	public void onlyUsernameEntred(){
		username.sendKeys("dummyuser");
		password.clear();
		signInButton.click();
	}

	public void  onlypasswerdEntred() {
		username.clear();
		password.sendKeys("Password");
		signInButton.click();
	}
	public boolean validateUsernameError(){

		return usernameErrormessage.isDisplayed();		

	}	
	public boolean validatepassworderror() {

		return passwordErrorMessage.isDisplayed();

	}
	
	public boolean validateUsernamePswdError() {

		return emptyUsernamePswd.isDisplayed();

	}

	public NewMemebrRegistrationPage  clickRegisterbutton() {
		
		validate(registerbutton);
		
		registerbutton.click();
		CommonUtility.waitForPageLoad(driver, MemberId, 45);
		
		if (getTitle().equalsIgnoreCase("Member Registration")) {
			System.out.println("i am in member regestration mage -------->"+ driver.getTitle());
		}
		return new NewMemebrRegistrationPage(driver);
	}
		
		public UsernamePasswordAssistancePage clickForgotUsernamePasswordLink() 
		{
			
		forgotusernamepasswordlink.click();
			
			return new UsernamePasswordAssistancePage(driver);
		}	
		
		
		
		
}
