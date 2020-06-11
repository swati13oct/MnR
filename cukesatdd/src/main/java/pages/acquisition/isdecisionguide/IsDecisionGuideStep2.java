/**
 * 
 */
package pages.acquisition.isdecisionguide;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
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
public class IsDecisionGuideStep2 extends UhcDriver{

	
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
	
	@FindBy(xpath = "//a[contains(@role, 'tab') and contains(@id, 'step-2')]")
	private WebElement Step2Tab;
	
	//Form Elements
	@FindBy(xpath = "//input[contains(@class, 'dob') and contains(@id, 'form-dob') and contains(@name, 'dob')]")
	private WebElement DateOfBirthTxt;
	
	@FindBy(xpath = "//a[contains(@class, 'dob-modal-trigger') and contains(@id, 'form-dob-modal-trigger') and contains(@name, 'dob-modal-trigger')]")
	private WebElement DoBHelpLink;
	
	@FindBy(xpath = "//div[ contains(@id, 'modal-dob-info')]//div[contains(@class,'modal-content')]")
	private WebElement DoBHelpModal;
	
	@FindBy(xpath = "//div[ contains(@id, 'modal-dob-info')]//div[contains(@class,'modal-content')]//button[contains(text(), 'Close')]")
	private WebElement DoBHelpModal_CloseBtn;
	
	@FindBy(xpath = "//*[contains ( @id ,'error-dob' )]")
	private WebElement DOBError;
	
	@FindBy(xpath = "//select[contains(@class, 'medicaredate_mm') and contains(@id, 'form-medicaredate_mm') and contains(@name, 'medicaredate_mm')]")
	private WebElement PartBStartMonth;
	
	
	@FindBy(xpath = "//select[contains(@class, 'medicaredate_yy') and contains(@id, 'form-medicaredate_yy') and contains(@name, 'medicaredate_yy')]")
	private WebElement PartBStartYear;
	
	@FindBy(xpath = "//*[contains ( @id ,'error-medicaredate' )]")
	private WebElement PartBError;

	@FindBy(xpath = "//select[contains(@class, 'startdate') and contains(@id, 'form-startdate') and contains(@name, 'startdate')]")
	private WebElement PlanStartDate;

	@FindBy(xpath = "//input[contains(@class, 'phone') and contains(@id, 'form-phone') and contains(@name, 'phone')]")
	private WebElement PhoneNumber;
	
	@FindBy(xpath = "//span[contains (@id ,'error-phone')]")
	private WebElement PhoneNumberError;

	@FindBy(xpath = "//input[contains(@class, 'mobilephone') and contains(@id, 'form-mobilephone') and contains(@name, 'mobilephone')]//following-sibling::label")
	private WebElement SelectisMobilecheckbox;

	@FindBy(xpath = "//input[contains(@class, 'aarpnumber') and contains(@id, 'form-aarpnumber') and contains(@name, 'aarpnumber')]")
	private WebElement AARP_MembershipNo;
	
	@FindBy(xpath = "//*[contains(@id, 'form-step-2')]//button[contains(@type, 'submit') and contains(text(), 'Submit')]")
	private WebElement SubmitBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'ebrcFooter')]")
	private WebElement DisclosureScrollBox;

	@FindBy(xpath = "//input[contains(@class, 'mobilephone') and contains(@id, 'form-mobilephone') and contains(@name, 'mobilephone')]")
	private WebElement MobilePhRadio;

	
	//Thank You Page
	
	@FindBy(xpath = "//*[contains(@id, 'thankyou')]")
	private WebElement ThankYouPageHeader;

	@FindBy(xpath = "//*[contains(@id, 'findplansbtn')]")
	private WebElement FindPlanBtn;


	
	public IsDecisionGuideStep2(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, PageHeader,30);
		
		validate(Step2Tab);
		validate(PageHeader);
		validate(HeaderNavigation);
		validate(SiteLogo);
		validate(DisclosureScrollBox);

		if(PageHeader.getText().contains(" Medicare Supplement Insurance Plans "))
			System.out.println("IS Decision Guide Page header is Displayed : "+PageHeader.getText());
	}
	
	public boolean blankFieldValidation() {
		boolean flag = true;
		
		if(validate(SubmitBtn)){
			SubmitBtn.click();
			if(validate(DOBError)){
				if(!DOBError.getText().contains("Please enter a date of birth.")){
					System.out.println("Date of Birth Error is Not  displayed : "+DOBError.getText());
					flag=false;
				}
				System.out.println("Date of Birth Error : "+DOBError.getText());

			}
			else{
				System.out.println("Date of Birth Error field is not displayed");

			}

			if(validate(PartBError)){
				if(!PartBError.getText().contains("Please enter a Medicare (Part B) date.")){
					System.out.println("Part B Error is Not  displayed : "+PartBError.getText());
					flag=false;
				}
				System.out.println("Part B Error : "+PartBError.getText());

			}
			else{
				System.out.println("Part B Error field is not displayed");

			}
	}
		return flag;
    }
	
	public boolean invalidFieldValidation() {
		boolean flag = true;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue("Phone Number Field is Not Displayed", validate(PhoneNumber));
		PhoneNumber.sendKeys("8765550987");
		SubmitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(PhoneNumberError)){
			if(!PhoneNumberError.getText().contains("You have entered an invalid number (555 prefix). Please enter a valid phone number")){
				System.out.println("Phone Number Invalid Error is Not  displayed : "+PhoneNumberError.getText());
				flag=false;
			}
			System.out.println("Phone Number Invalid Error : "+PhoneNumberError.getText());

		}
		else{
			System.out.println("Phone Number Invalid Error field is not displayed");

		}
		PhoneNumber.sendKeys("900-123-8765");
		SubmitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(PhoneNumberError)){
			if(!PhoneNumberError.getText().contains("You have entered a pay-per-call number (900 area code). Please enter a valid phone number.")){
				System.out.println("Phone Number Invalid Error is Not  displayed : "+PhoneNumberError.getText());
				flag=false;
			}
			System.out.println("Phone Number Invalid Error : "+PhoneNumberError.getText());

		}
		else{
			System.out.println("Phone Number Invalid Error field is not displayed");

		}
		PhoneNumber.sendKeys("800-123-8795");
		SubmitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(PhoneNumberError)){
			if(!PhoneNumberError.getText().contains("You have entered a toll-free number (800 area code). Please enter a valid phone number.")){
				System.out.println("Phone Number Invalid Error is Not  displayed : "+PhoneNumberError.getText());
				flag=false;
			}
			System.out.println("Phone Number Invalid Error : "+PhoneNumberError.getText());

		}
		else{
			System.out.println("Phone Number Invalid Error field is not displayed");

		}
		PhoneNumber.sendKeys("888-123-8795");
		SubmitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(PhoneNumberError)){
			if(!PhoneNumberError.getText().contains("You have entered a toll-free number (888 area code). Please enter a valid phone number.")){
				System.out.println("Phone Number Invalid Error is Not  displayed : "+PhoneNumberError.getText());
				flag=false;
			}
			System.out.println("Phone Number Invalid Error : "+PhoneNumberError.getText());

		}
		else{
			System.out.println("Phone Number Invalid Error field is not displayed");

		}
		PhoneNumber.sendKeys("877-176-4765");
		SubmitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(PhoneNumberError)){
			if(!PhoneNumberError.getText().contains("You have entered a toll-free number (877 area code). Please enter a valid phone number.")){
				System.out.println("Phone Number Invalid Error is Not  displayed : "+PhoneNumberError.getText());
				flag=false;
			}
			System.out.println("Phone Number Invalid Error : "+PhoneNumberError.getText());

		}
		else{
			System.out.println("Phone Number Invalid Error field is not displayed");

		}
		PhoneNumber.sendKeys("866-176-4765");
		SubmitBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(validate(PhoneNumberError)){
			if(!PhoneNumberError.getText().contains("You have entered a toll-free number (866 area code). Please enter a valid phone number.")){
				System.out.println("Phone Number Invalid Error is Not  displayed : "+PhoneNumberError.getText());
				flag=false;
			}
			System.out.println("Phone Number Invalid Error : "+PhoneNumberError.getText());

		}
		else{
			System.out.println("Phone Number Invalid Error field is not displayed");

		}
		return flag;
	}
	
	public void enterUserInfoStep2(Map<String, String> memberAttributesMap) {
		String DOB = memberAttributesMap.get("dob");
		String partBmonth = memberAttributesMap.get("partBmonth");
		String partByear = memberAttributesMap.get("partByear");
		String aarpNo = memberAttributesMap.get("aarpNo");
		String phNo = memberAttributesMap.get("phNo");
		String mobileFlag = memberAttributesMap.get("mobileFlag");

		DateOfBirthTxt.clear();
		DateOfBirthTxt.sendKeys(DOB);
		PartBStartMonth.findElement(By.xpath("//*[contains(text(), '"+partBmonth+"')]")).click();
		PartBStartYear.findElement(By.xpath("//*[contains(text(), '"+partByear+"')]")).click();
		AARP_MembershipNo.sendKeys(aarpNo);
	}

	public DGR_ThankYouPage NavigateNext_DGRthankYouPage() {
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
			return new DGR_ThankYouPage(driver);
		}
		return null;	}
}	