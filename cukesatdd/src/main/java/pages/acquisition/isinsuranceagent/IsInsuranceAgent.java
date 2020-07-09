/**
 * 
 */
package pages.acquisition.isinsuranceagent;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;


/**
 *@author sdwaraka
 *
 */
public class IsInsuranceAgent extends UhcDriver{


	//Global Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;

	@FindBy(xpath = "//*[@id = 'nav' and @role = 'navigation']")
	private WebElement HeaderNavigation;


	@FindBy(xpath = "//*[@class = 'footer']")
	private WebElement Footer;


	//Right Rail Elements
	@FindBy(xpath = "//*[contains(@class, 'needHelpContainer')]")
	private WebElement NeedHelpContainer;


	//Header

	@FindBy(xpath = "//*[contains(@id, 'agentheader')]")
	private WebElement PageHeader;

	//Form Elements
	@FindBy(xpath = "//*[contains(@class, 'first_name') and contains(@id, 'first_name') and contains(@name, 'first_name')]")
	private WebElement FirstNameTxt;

	@FindBy(xpath = "//*[contains(@id, '-form-error-first_name')]")
	private WebElement FirstNameError;


	@FindBy(xpath = "//*[contains(@class, 'last_name') and contains(@id, 'last_name') and contains(@name, 'last_name')]")
	private WebElement LastNameTxt;

	@FindBy(xpath = "//*[contains(@id, '-form-error-last_name')]")
	private WebElement LastNameError;

	@FindBy(xpath = "//*[@class = 'footer']")
	private WebElement ReceiveMail_RadioOptions;

	//@FindBy(xpath = "//*[contains(@id, '-form-error-fulfillment')]")
	//private WebElement DistributionMethodError;

	@FindBy(xpath = "//*[contains(@id, '-form-error-email')]")
	private WebElement EmailError;

	@FindBy(xpath = "//label[contains(@for, 'fulfillment-email')]")
	private WebElement EmailOptionSelection;


	//@FindBy(xpath = "//label[contains(@for, 'fulfillment-mail')]")
	//private WebElement MailOptionSelection;

	@FindBy(xpath = "//input[contains(@class, 'email') and contains(@id, 'form-email') and contains(@name, 'email')]")
	private WebElement EmailTxt;

	@FindBy(xpath = "//input[contains(@class, 'address') and contains(@id, 'form-address') and contains(@name, 'address')]")
	private WebElement HomeAddressTxt;

	@FindBy(xpath = "//*[contains(@id, '-form-error-address')]")
	private WebElement HomeAddressError;

	@FindBy(xpath = "//input[contains(@class, 'city') and contains(@id, 'form-city') and contains(@name, 'city')]")
	private WebElement CityTxt;

	@FindBy(xpath = "//*[contains(@id, '-form-error-city')]")
	private WebElement CityError;

	@FindBy(xpath = "//select[contains(@class, 'state') and contains(@id, 'form-state') and contains(@name, 'state')]")
	private WebElement StateDropDown;

	@FindBy(xpath = "//*[contains(@id, '-form-error-state')]")
	private WebElement StateDropDownError;

	@FindBy(xpath = "//input[contains(@class, 'zip') and contains(@id, 'form-zip') and contains(@name, 'zip')]")
	private WebElement ZipTxt;

	@FindBy(xpath = "//*[contains(@id, '-form-error-zip')]")
	private WebElement ZipError;


	@FindBy(xpath = "//button[contains(@data-target, 'form-step-2')]")
	private WebElement NextBtn;

	@FindBy(xpath = "//div[contains(@class, 'ebrcFooter')]")
	private WebElement DisclosureScrollBox;
	
	@FindBy(xpath= "//div[contains(@class, 'error errorheader is-invalid')]")
	private WebElement topErrorMsg;
	
	@FindBy(xpath="//*[contains(@id, 'need-help-modal-tfn')]")
	private WebElement tfnpopup;
	
	@FindBy(xpath="//button[contains(@class, 'close') and contains(@data-dismiss, 'modal')]")
	private WebElement closebuttontfn;

	
	
	public IsInsuranceAgent(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, PageHeader,30);


		validate(PageHeader);
		validate(HeaderNavigation);
		validate(SiteLogo);
		validate(DisclosureScrollBox);
		validate(tfnpopup);

		if(PageHeader.getText().contains("Medicare Supplement Insurance Plans"))
			System.out.println("IS Licensed Insurance Agent Page header is Displayed : "+PageHeader.getText());
	}

	public boolean blankFieldValidation() {
		// TODO Auto-generated method stub
		boolean flag = true;
		if(validate(NextBtn)){
			NextBtn.click();
			if(validate(FirstNameError) && FirstNameError.isDisplayed()){
				if(!FirstNameError.getText().contains("Please enter a first name.")){
					System.out.println("First Name Error is Not  displayed : "+FirstNameError.getText());
					flag=false;
				}
				System.out.println("First Name Error : "+FirstNameError.getText());

			}
			else{
				System.out.println("First Name Error field is not displayed");

			}

			if(validate(LastNameError) && LastNameError.isDisplayed()){
				if(!LastNameError.getText().contains("Please enter a last name.")){
					System.out.println("Last Name Error is Not  displayed : "+LastNameError.getText());
					flag=false;
				}
				System.out.println("Last Name Error : "+LastNameError.getText());

			}
			else{
				System.out.println("Last Name Error field is not displayed");

			}
			
			if(validate(HomeAddressError) && HomeAddressError.isDisplayed()){
				if(!HomeAddressError.getText().contains("Please enter an address.")){
					System.out.println("Address Error is Not  displayed : "+HomeAddressError.getText());
					flag=false;
				}
				System.out.println("Address Error : "+HomeAddressError.getText());

			}
			else{
				System.out.println("Address Error field is not displayed");

			}
			if(validate(CityError) && CityError.isDisplayed()){
				if(!CityError.getText().contains("Please enter a city.")){
					System.out.println("City Error is Not  displayed : "+CityError.getText());
					flag=false;
				}
				System.out.println("City Error  : "+CityError.getText());
			}
			else{
				System.out.println("City Error field is not displayed");

			}
			if(validate(ZipError) && ZipError.isDisplayed()){
				if(!ZipError.getText().contains("Please enter a zip code.")){
					System.out.println("Zip code Error is Not  displayed : "+ZipError.getText());
					flag=false;
				}
				System.out.println("Zip code Error : "+ZipError.getText());
			}
			else{
				System.out.println("ZipCode Error field is not displayed");
			}
			if(validate(topErrorMsg)){
			    if(!topErrorMsg.getText().contains("Hmm... The information below doesn’t seem correct. Please take a look at the fields indicated below. If you need help, call 1-888-378-0254.")){
			    	System.out.println("Error message on top of the step 1 is not displayed : "+topErrorMsg.getText());
			    	flag=false;
			    }
			    System.out.println("Step 1 error message : "+topErrorMsg.getText());
			}
		    else{
			System.out.println("Error Message on top of the Step 1 is not displayed");	
			
		    }
			EmailOptionSelection.click();
			NextBtn.click();
			if(validate(EmailError) && EmailError.isDisplayed()){
				if(!EmailError.getText().contains("Please enter a email.")){
					System.out.println("Email Error is Not  displayed : "+EmailError.getText());
					flag=false;
				}
				System.out.println("Email Error : "+EmailError.getText());

			}
			else{
				System.out.println("Email Error field is not displayed");

			}

	      }
		  else{
			System.out.println("Next Button is not displayed");
			flag=false;
		}
		return flag;
	}

	public boolean invalidFieldValidation() {

		boolean flag = true;
		FirstNameTxt.clear();
		FirstNameTxt.sendKeys("-abc351351*&^*^&");
		NextBtn.click();
		if(validate(FirstNameError) && FirstNameError.isDisplayed()){
			if(!FirstNameError.getText().contains("Please enter a first name that only contains non-numeric characters, apostrophe, hyphen or space.")){
				System.out.println("First Name Invalid Error is Not  displayed : "+FirstNameError.getText());
				flag=false;
			}
			System.out.println("First Name Invalid Error : "+FirstNameError.getText());

		}
		else{
			System.out.println("First Name Invalid Error field is not displayed");

		}
		FirstNameTxt.clear();
		FirstNameTxt.sendKeys("- ' abc");
		NextBtn.click();
		if(validate(FirstNameError) && FirstNameError.isDisplayed()){
			if(!FirstNameError.getText().contains("Please enter a first name with characters immediately before and after the hyphen or apostrophe.")){
				System.out.println("First Name Invalid Error is Not  displayed : "+FirstNameError.getText());
				flag=false;
			}
			System.out.println("First Name Invalid Error : "+FirstNameError.getText());

		}
		else{
			System.out.println("First Name InvalidError field is not displayed");

		}
		LastNameTxt.clear();
		LastNameTxt.sendKeys("-abc351351*&^*^&");
		NextBtn.click();
		if(validate(LastNameError) && LastNameError.isDisplayed()){
			if(!LastNameError.getText().contains("Please enter a last name that only contains non-numeric characters, apostrophe, hyphen or space.")){
				System.out.println("Last Name Error is Not  displayed : "+LastNameError.getText());
				flag=false;
			}
			System.out.println("Last Name Invalid Error : "+LastNameError.getText());

		}
		else{
			System.out.println("Last Name Error field is not displayed");

		}
		LastNameTxt.clear();
		LastNameTxt.sendKeys("- ' abc");
		NextBtn.click();
		if(validate(LastNameError) && LastNameError.isDisplayed()){
			if(!LastNameError.getText().contains("Please enter a last name with characters immediately before and after the hyphen or apostrophe.")){
				System.out.println("Last Name Invalid Error is Not  displayed : "+LastNameError.getText());
				flag=false;
			}
			System.out.println("Last Name Invalid Error : "+LastNameError.getText());

		}
		else{
			System.out.println("Last Name Error field is not displayed");

		}
		EmailTxt.clear();
		EmailTxt.sendKeys("(*^*_asb@t.c");
		NextBtn.click();
		if(validate(EmailError) && EmailError.isDisplayed()){
			if(!EmailError.getText().contains("Please enter a valid email address in the format 'user@company.com'")){
				System.out.println("Email Invalid Error is Not  displayed : "+EmailError.getText());
				flag=false;
			}
			System.out.println("Email Invalid Error : "+EmailError.getText());

		}
		else{
			System.out.println("Email Invalid Error field is not displayed");

		}
		HomeAddressTxt.clear();
		HomeAddressTxt.sendKeys("[*(abc");
		NextBtn.click();
		if(validate(HomeAddressError) && HomeAddressError.isDisplayed()){
			if(!HomeAddressError.getText().contains("Please enter an address that contains only numbers, letters, apostrophe, comma, hyphen, #, & or space.")){
				System.out.println("Address Invalid Error is Not  displayed : "+HomeAddressError.getText());
				flag=false;
			}
			System.out.println("Address Invalid Error : "+HomeAddressError.getText());

		}
		else{
			System.out.println("Address Invalid Error field is not displayed");

		}
		CityTxt.clear();
		CityTxt.sendKeys("[*(abc%&&*(&^ 123");
		NextBtn.click();
		if(validate(CityError) && CityError.isDisplayed()){
			if(!CityError.getText().contains("Please enter a city that only contains non-numeric characters, apostrophe, hyphen or space.")){
				System.out.println("City Invalid Error is Not  displayed : "+CityError.getText());
				flag=false;
			}
			System.out.println("City Invalid Error  : "+CityError.getText());
		}
		else{
			System.out.println("City Error field is not displayed");

		}
		ZipTxt.clear();
		ZipTxt.sendKeys("12");
		NextBtn.click();
		if(validate(ZipError)) {
		  if(!ZipError.getText().contains("Please enter a valid 5-digit ZIP code in the format 12345.")){
			  System.out.println("Zip Invalid Error is not displayed : "+ZipError.getText());
			  flag=false;
		  }
		  System.out.println("Zip Code Invalid Error : "+ZipError.getText());
		}
		else{
			System.out.println("Zip code invalid error field is not displayed");
		}
		//WebElement StateSelect = driver.findElement(By.xpath("//*[@id='agent-appointment-form-state']//option[text()='Select a state']"));


		return flag;
	}

	public boolean NextBtn_invalidAddressValidation() {
		boolean flag = true;

		HomeAddressTxt.clear();
		HomeAddressTxt.sendKeys("12 test street");
		CityTxt.clear();
		CityTxt.sendKeys("Test City");
		ZipTxt.clear();
		ZipTxt.sendKeys("80210");
		WebElement StateSelect = driver.findElement(By.xpath("//*[@id='agent-appointment-form-state']//option[@value='CA']"));
		StateSelect.click();
		NextBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(HomeAddressError)) {
		  if(!HomeAddressError.getText().contains("Home Address (Apt/Suite/Unit number if applicable. Please note: P.O. Box/PMB cannot be accepted as a home address.") && 
				  !HomeAddressError.getText().contains("Address not found. If you believe this address is valid, call 1-888-378-0254, TTY 711, for help in requesting information.")){
			  System.out.println("Address Not Found Error is not displayed : "+HomeAddressError.getText());
			  flag=false;
		  }
		  System.out.println("Address Not Found Error : "+HomeAddressError.getText());
		}
		else{
			System.out.println("Address Not Found error field is not displayed");
		}

		return flag;
	
	}

	public void enterUserInfoStep1(Map<String, String> memberAttributesMap) {
		String FirstName = memberAttributesMap.get("FirstName");
		String LastName = memberAttributesMap.get("LastName");
		String DistributionMethod = memberAttributesMap.get("DistributionMethod");
		String Email = memberAttributesMap.get("Email");
		FirstNameTxt.clear();
		LastNameTxt.clear();
		EmailTxt.clear();
		FirstNameTxt.sendKeys(FirstName);
		LastNameTxt.sendKeys(LastName);
		if(DistributionMethod.equalsIgnoreCase("email")){
			EmailOptionSelection.click();
			EmailTxt.sendKeys(Email);
		
		}
	}

	public boolean Validate_addressAutoComplete() {
		HomeAddressTxt.clear();
		CityTxt.clear();
		ZipTxt.clear();
		HomeAddressTxt.clear();
		HomeAddressTxt.sendKeys("12");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Actions action = new Actions(driver);
		action.sendKeys(Keys.DOWN).perform(); 
		String AutoCompleteAddress = HomeAddressTxt.getAttribute("value");
		action.sendKeys(Keys.TAB).perform(); 
		action.sendKeys(Keys.TAB).perform(); 
		action.sendKeys(Keys.TAB).perform(); 
		action.sendKeys(Keys.TAB).perform(); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String CityEntered = CityTxt.getAttribute("value");
		System.out.println("CityEntereed : "+CityEntered);


		String State = StateDropDown.getAttribute("value");
		
		String AddressEntered = HomeAddressTxt.getAttribute("value");
		System.out.println("AddressEntered : "+AddressEntered);
		String ZipEntered = ZipTxt.getAttribute("value");
		System.out.println("ZipEntered : "+ZipEntered);

		if(!CityEntered.isEmpty() && !AddressEntered.isEmpty() && !ZipEntered.isEmpty()){
			System.out.println("Auto Complete Address : "+AddressEntered+" - "+CityEntered+" - "+ZipEntered);
			return true;
		}
		System.out.println(" Address : "+AddressEntered+" - "+CityEntered+" - "+ZipEntered);

		return false;
		

		
	}
	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
				.executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}
	
	public WebElement locateElementWithinShadowRoot(WebElement shadowRootElement, String inputSelector) {
		if (validate(shadowRootElement)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1=expandRootElement(shadowRootElement);
			try {
				WebElement element=root1.findElement(By.cssSelector(inputSelector));
				return element;
			} catch (Exception e) {
				System.out.println("can't locate element. Exception e="+e);
			}
		} else {
			System.out.println("no shadow-root element either, not sure what's going on!!!");
		}
		return null;
	}
	
	@FindBy(xpath = "//a[contains(@role, 'tab') and contains(@id, 'step-2')]")
	private WebElement Step2Tab;

	public IsInsuranceAgent NavigateNext_DGRStep1() {
		if(!validate(topErrorMsg) && validate(NextBtn)){
			NextBtn.click();
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Step2Tab.isEnabled()){
			System.out.println("Next Button Clicked : Step 2 Displayed");
			return new IsInsuranceAgent(driver);
		}
		return null;
	}
	
	@FindBy(xpath = "//input[contains(@class, 'dob')]")
	private WebElement DateOfBirthTxt;
	@FindBy(xpath ="//*[@name='phone']")
	private WebElement PhNo;
	
	public void enterUserInfoStep2(Map<String, String> memberAttributesMap) throws InterruptedException {
		String DOB = memberAttributesMap.get("DOB");
		String partBmonth = memberAttributesMap.get("partBmonth");
		String partByear = memberAttributesMap.get("partByear");
		String aarpNo = memberAttributesMap.get("aarpNo");
		String phNo = memberAttributesMap.get("PhNo");
		String mobileFlag = memberAttributesMap.get("mobileFlag");

		//DateOfBirthTxt.clear();
		Thread.sleep(2000);
       validateNew(DateOfBirthTxt);
		
		if(validateNew(DateOfBirthTxt)&& DateOfBirthTxt.isDisplayed())
			DateOfBirthTxt.sendKeys(DOB);
		
		if(validateNew(PhNo)){
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		PhNo.sendKeys(selectAll);
		PhNo.sendKeys(Keys.BACK_SPACE);
		PhNo.sendKeys(phNo);
		}
	}

	@FindBy(id = "agent-submit-button")
	private WebElement SubmitBtn;
	
	@FindBy(xpath = "//*[contains(@id, 'thankyou')]")
	private WebElement ThankYouPageHeader;

	@FindBy(xpath = "//*[contains(@id, 'findplansbtn')]")
	private WebElement FindPlanBtn;
	
	public License_ThankYouPage NavigateNext_LIAthankYouPage() {
		if( validate(SubmitBtn)){
			SubmitBtn.click();
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(FindPlanBtn) && validate(ThankYouPageHeader)){
			System.out.println("Submit Button Clicked : DGR Thank You Page is Displayed");
			return new License_ThankYouPage(driver);
		}
		return null;
	}
}