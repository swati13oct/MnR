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
	
	@FindBy(xpath = "//select[contains(@class, 'medicaredate_mm') and contains(@id, 'form-medicaredate_mm') and contains(@name, 'medicaredate_mm')]")
	private WebElement PartBStartMonth;
	
	
	@FindBy(xpath = "//select[contains(@class, 'medicaredate_yy') and contains(@id, 'form-medicaredate_yy') and contains(@name, 'medicaredate_yy')]")
	private WebElement PartBStartYear;

	@FindBy(xpath = "//select[contains(@class, 'startdate') and contains(@id, 'form-startdate') and contains(@name, 'startdate')]")
	private WebElement PlanStartDate;

	@FindBy(xpath = "//input[contains(@class, 'phone') and contains(@id, 'form-phone') and contains(@name, 'phone')]")
	private WebElement PhoneNumber;

	@FindBy(xpath = "//input[contains(@class, 'mobilephone') and contains(@id, 'form-mobilephone') and contains(@name, 'mobilephone')]//following-sibling::label")
	private WebElement SelectisMobilecheckbox;

	@FindBy(xpath = "//input[contains(@class, 'aarpnumber') and contains(@id, 'form-aarpnumber') and contains(@name, 'aarpnumber')]")
	private WebElement AARP_MembershipNo;
	
	@FindBy(xpath = "//*[contains(@id, 'form-step-2')]//button[contains(@type, 'submit') and contains(text(), 'Submit')]")
	private WebElement SubmitBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'ebrcFooter')]")
	private WebElement DisclosureScrollBox;
	
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

}