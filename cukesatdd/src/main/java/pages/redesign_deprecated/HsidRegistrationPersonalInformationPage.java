package pages.redesign;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;

public class HsidRegistrationPersonalInformationPage extends UhcDriver {
	
	@FindBy(id = "piFirstName")
	public WebElement firstName;
	
	@FindBy(id = "piLastName")
	public WebElement lastName;
	
	@FindBy(id = "piDoB")
	public WebElement dob;
	
	@FindBy(id = "piZipCode")
	public WebElement zipCode;
	
	@FindBy(id = "piMemberId4Mnr")
	public WebElement memberId;

	////button[contains(.,'Register now')]
    @FindBy(xpath = "//button[@class='button button--primary ng-scope' and contains(.,'Continue')]")
    public WebElement continuebutton;
    
    @FindBy(xpath = "//button[@class='button button--primary ng-scope']/span[1]")
    public WebElement tryagainbutton;
	
	@FindBy(xpath = "//label[@for='piFirstName']/span[@class='error']")
	private WebElement firstNameErrorMsg;

	@FindBy(xpath = "//label[@for='piLastName']/span[@class='error']")
	private WebElement lastNameErrorMsg;

	@FindBy(xpath = "//label[@for='piDoB']//span[contains(@class,'error') and not(contains(@class,'ng-hide'))]")
	private WebElement dateOfBirthErrorMsg;

	@FindBy(xpath = "//label[@for='password']//span[contains(@class,'error') and not(contains(@class,'ng-hide'))]")
	private WebElement passwordErrorMsg;

	@FindBy(xpath = "//label[@for='piZipCode']//span[starts-with(@class,'error')]")
	private WebElement zipcodeErrorMsg;
	
	@FindBy(xpath = "//label[starts-with(@for,'piMemberId')]//*[@ng-bind-html='piMemberIdError']|//label[@for='piMemberId']/span[@class='error']")
	private WebElement memberIdErrorMsg;
	
	@FindBy(xpath = "//div[contains(@class,'form__step1')]//p[contains(@class,'ng-scope')]|//div[@ng-show='pageError']/p")
	private WebElement mainErrorMsg;
	
	
	public HsidRegistrationPersonalInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate()  {

		
	}

	public void validateFields() {
		validate(firstName);
		validate(lastName);
		validate(dob);
		validate(zipCode);
		validate(memberId);
		validate(continuebutton);
	}
	
	public void populatefields(String firstName, String lastName, String dob,String zipcode, String memberId){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.dob.sendKeys(dob);
		this.zipCode.sendKeys(zipcode);
		this.memberId.sendKeys(memberId);
	}
	
	public HsidRegistrationPersonalCreateAccount clickContinue(){
		continuebutton.click();
		
		try
		{
          if(tryagainbutton.isDisplayed())
          {
        	  while(tryagainbutton.isDisplayed())
        	  {
        	  tryagainbutton.click();
        	  }
          }
		}
		catch (NoSuchElementException e)
		{
			System.out.println("test");
		}
          
		while(!currentUrl().contains("register/createAccount")){
			
			System.out.println("create account page is loading");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
          
		System.out.println("create account page is loaded"+currentUrl());
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		if(currentUrl().contains("register/createAccount")){
			
			return new HsidRegistrationPersonalCreateAccount(driver);
		}else{
			Assert.assertTrue("Errors in Registration Personal Info page and not navigated to Create Account page",false);
		}
		return null;
	}
	
	public void clickContinueAndValidate(){
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		WebElement continuebtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[1]/div/div[2]/flex[2]/flex-content[1]/div/form/div/div[2]/p/button")));
		continuebtn.click();
	}
	
	public void validateErrorMessages(){
		
		
		Assert.assertTrue("Error message for dob is not displayed",dateOfBirthErrorMsg.isDisplayed());
	}
	
	public void validateFirstNameErrorMessage(){
		Assert.assertTrue("Error message for first name is not displayed",firstNameErrorMsg.isDisplayed());
	}
	
	public void validateLastNameErrorMessage(){
		Assert.assertTrue("Error message for last name is not displayed",lastNameErrorMsg.isDisplayed());
	}
	
	public void validatedobErrorMessage(){
		Assert.assertTrue("Error message for dob is not displayed",dateOfBirthErrorMsg.isDisplayed());
	}
	
	public void validateZipCodeErrorMessage(){
		Assert.assertTrue("Error message for zipcode is not displayed",zipcodeErrorMsg.isDisplayed());
	}
	
	public void validateMemberIDErrorMessage(){
		Assert.assertTrue("Error message for member id is not displayed",memberIdErrorMsg.isDisplayed());
	}


	public void validateMainErrorMessage(){
		Assert.assertTrue("Main error message is not displayed",mainErrorMsg.isDisplayed());
	}
}
