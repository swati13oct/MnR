/**
 * 
 */
package pages.acquisition.ole;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PlanPremiumPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
	private WebElement PageHeader;
	
	@FindBy(xpath = "//h1[contains(text(),'Authorization')]")
	private WebElement authPageHeader;

	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;
	
	@FindBy(xpath=".//*[@id='ole-form-content']//*[contains(@for,'premiumAgree')]")
	private WebElement agreeBtn;
	
	@FindBy(id = "premiumPaymentQstnPBM")
	private WebElement payByMail;
	
	@FindBy(id = "premiumPaymentQstnCC")
	private WebElement creditCard;
	
	@FindBy(id = "premiumPaymentQstnSSRRB")
	private WebElement socialSecurity;
	
	@FindBy(xpath="//div[@id='premiumPaymentQstn']/div/p")
	private WebElement payByMailText;
	
	@FindBy(id = "div_cardInfo")
	private WebElement creditCardText;
	
	@FindBy(xpath="//div[@id='premiumPaymentQstn']/div/p")
	private WebElement socialSecurityText;
	
	public PlanPremiumPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, ZipCode_County, 30);
		validateNew(PageHeader);
		System.out.println("Page header is Displayed : "+PageHeader.getText());	
	}

	public SupplementalBenefitsPage navigate_to_Supplemental_Riders_Page() {
		agreeBtn.click();
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Supplemental')]")))){
			Assert.assertTrue(validateNew(driver.findElement(By.xpath("//label[contains(text(),'Yes, I want to add')]"))), "unable to find Yes option available for rider");
			System.out.println("Validated Yes option available");
			System.out.println("OLE Supplemental Benefits page is Displayed");
			return new SupplementalBenefitsPage(driver);
		}
		else{
			System.out.println("OLE Supplemental Benefits page is Displayed");
			return null;
		}
	}	

	public AuthorizationPage navigate_to_Authorization_Page() {
		agreeBtn.click();
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		if(validateNew(authPageHeader,45)){
			System.out.println("OLE Authorization page is Displayed : Navigation from Plan Premium Page Passed");
			return new AuthorizationPage(driver);
		}
		else{
			System.out.println("OLE Authorization page is Displayed : Navigation from Plan Premium Page Failed");
			return null;
		}
	}
	
	public boolean validatePayByMail(String paymentType) {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		try {
		if(payByMail.isDisplayed())	{
			actualText = payByMailText.getText().trim();
			expectedText = CommonConstants.PAY_BY_MAIL_TEXT;
			flag = actualText.equalsIgnoreCase(expectedText);
			
		}
			
			
		} catch (Exception e) {
			System.out.println("=====PayByMail FAILED=====");
		}

			
    return flag;
	
	}
	
	public boolean validateCreditCard(String paymentType) {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		
		try {
			if(creditCard.isDisplayed())	{
				actualText = creditCardText.getText().trim();
				expectedText = CommonConstants.CREDIT_CARD_TEXT;
				flag = actualText.equalsIgnoreCase(expectedText);
				
			}
				
				
			} catch (Exception e) {
				System.out.println("=====CreditCard FAILED=====");
			}

				
	    return flag;
		
		}
	
	public boolean validateSocialSecurity(String paymentType) {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		
		try {
			if(socialSecurity.isDisplayed())	{
				actualText = socialSecurityText.getText().trim();
				expectedText = CommonConstants.SOCIAL_SECURITY_TEXT;
				flag = actualText.equalsIgnoreCase(expectedText);
				
			}
				
				
			} catch (Exception e) {
				System.out.println("=====SocialSecurity FAILED=====");
			}

				
	    return flag;
		
		}

}


