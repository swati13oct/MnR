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
	
	@FindBy(xpath = "//*[contains(@class, 'last_name') and contains(@id, 'last_name') and contains(@name, 'last_name')]")
	private WebElement LastNameTxt;
	
	
	@FindBy(xpath = "//*[@class = 'footer']")
	private WebElement ReceiveMail_RadioOptions;
	
	@FindBy(xpath = "//label[contains(@for, 'fulfillment-email')]")
	private WebElement EmailOptionSelection;
	
	
	@FindBy(xpath = "//label[contains(@for, 'fulfillment-mail')]")
	private WebElement MailOptionSelection;
	
	@FindBy(xpath = "//input[contains(@class, 'email') and contains(@id, 'form-email') and contains(@name, 'email')]")
	private WebElement EmailTxt;

	@FindBy(xpath = "//input[contains(@class, 'address') and contains(@id, 'form-address') and contains(@name, 'address')]")
	private WebElement HomeAddressTxt;
	
	@FindBy(xpath = "//input[contains(@class, 'city') and contains(@id, 'form-city') and contains(@name, 'city')]")
	private WebElement CityTxt;
	
	@FindBy(xpath = "//select[contains(@class, 'state') and contains(@id, 'form-state') and contains(@name, 'state')]")
	private WebElement StateDropDown;
	
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

		if(PageHeader.getText().contains(" Medicare Supplement Insurance Plans "))
			System.out.println("IS Decision Guide Page header is Displayed : "+PageHeader.getText());
	}

}