/**
 * 
 */
package pages.acquisition.isdecisionguide;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class IsDecisionGuideStep1 extends UhcDriver{


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

	@FindBy(xpath = "//*[contains(@id, 'ebrcheader')]")
	private WebElement PageHeader;

	@FindBy(xpath = "//a[contains(@role, 'tab') and contains(text(), 'Step 1')]")
	private WebElement Step1Tab;

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

	@FindBy(xpath = "//*[contains(@id, '-form-error-fulfillment')]")
	private WebElement DistributionMethodError;

	@FindBy(xpath = "//*[contains(@id, '-form-error-email')]")
	private WebElement EmailError;

	@FindBy(xpath = "//label[contains(@for, 'fulfillment-email')]")
	private WebElement EmailOptionSelection;


	@FindBy(xpath = "//label[contains(@for, 'fulfillment-mail')]")
	private WebElement MailOptionSelection;

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

	public IsDecisionGuideStep1(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, PageHeader,30);

		validate(Step1Tab);
		validate(PageHeader);
		validate(HeaderNavigation);
		validate(SiteLogo);
		validate(DisclosureScrollBox);

		if(PageHeader.getText().contains("Medicare Supplement Insurance Plans"))
			System.out.println("IS Decision Guide Page header is Displayed : "+PageHeader.getText());
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
			if(validate(DistributionMethodError) && DistributionMethodError.isDisplayed()){
				if(!DistributionMethodError.getText().contains("Please select how would you like to receive your information.")){
					System.out.println("Distribution Method Error is Not  displayed : "+DistributionMethodError.getText());
					flag=false;
				}
				System.out.println("Distribution Method Error : "+DistributionMethodError.getText());

			}
			else{
				System.out.println("Distribution Method Error field is not displayed");

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
		}
		else{
			System.out.println("Next Button is not displayed");
			flag=false;
		}
		return flag;
	}

	public boolean invalidFieldValidation() {

		boolean flag = true;
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

		return flag;
	}

}