package pages.dashboard.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.dashboard.acquisition.RegistrationInformationPage;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MemberNewSignInPage extends UhcDriver{
	//private PageData newSign;

	@FindBy (css ="#siginaccheader")
	private WebElement signInCard;

	@FindBy (css = ".page-header--left")
	private WebElement signInHeader;

	@FindBy (css = "#username")
	private WebElement username;

	@FindBy (css = "#password")
	private WebElement password;

	@FindBy (css = "#sign-in-btn")
	private WebElement signInButton;

	@FindBy (css = "#username-error>p")
	private WebElement usernameErrormessage;

	@FindBy (css ="#password-error>p")
	private WebElement passwordErrorMessage;
	
	@FindBy (id ="regbutton")
	private WebElement registerbutton;

	private WebDriver driver;

	private static String PAGE_URL = MRConstants.SIGN_IN_URL;
	
	public MemberNewSignInPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		openAndValidate();
		
		//CommonUtility.waitForPageLoad(driver, ClaimDetailsPage, 60);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
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

	public RegistrationInformationPage clickRegisterbutton() {
		
		validate(registerbutton);
		registerbutton.click();
		
		if (getTitle().equalsIgnoreCase("")) {
			return new RegistrationInformationPage(driver);
		}
		return null;
		
		
	
	}

	

}
