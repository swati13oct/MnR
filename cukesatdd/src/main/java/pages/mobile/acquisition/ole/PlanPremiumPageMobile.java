/**
 * 
 */
package pages.mobile.acquisition.ole;

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
public class PlanPremiumPageMobile extends UhcDriver{
	
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
	
	@FindBy(xpath = "(//label[contains(@for, 'premiumPaymentQstnPBM')])[1]")
	private WebElement payByMail;
	
	@FindBy(xpath = "//li[@id='ole-premium']")
	private WebElement premium;
	
	
	//@FindBy(id = "premiumPaymentQstnCC")
	@FindBy(xpath = "(//label[contains(@for, 'premiumPaymentQstnCC')])[1]")
	private WebElement creditCard;
	
	//@FindBy(id = "premiumPaymentQstnSSRRB")
	
	@FindBy(xpath = "(//label[contains(@for, 'premiumPaymentQstnSSRRB')])[1]")
	private WebElement socialSecurity;
	
	@FindBy(xpath="//div[@id='premiumPaymentQstn']/div/p")
	private WebElement payByMailText;
	
	@FindBy(id = "div_cardInfo")
	private WebElement creditCardText;
	
	@FindBy(xpath="//div[@id='premiumPaymentQstn']/div/p")
	private WebElement socialSecurityText;
	
	@FindBy(xpath="//span[@id='acceptedCardsSpan']")
	private WebElement acceptedCards;
	
	@FindBy(xpath="//div[@id='sessionTimeoutNotice']")
	private WebElement sessionTimeoutNotice;
	
//	@FindBy(id="cardholderName")
	@FindBy(xpath="(//input[contains(@id,'holderName')])[1]")
	private WebElement cardholderName;
	
	//@FindBy(id="accountNumber")
	@FindBy(xpath="(//input[contains(@id,'accountNumber')])[1]")
	private WebElement accountNumber;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement cardExpirationMonth;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement cardExpirationYear;
	
	//@FindBy(id="storeCardBtn")
	@FindBy(xpath="(//button[contains(@id,'btnSubmit')])[1]")
	private WebElement btnSubmit;
	
	@FindBy(xpath="(//div[@id='upgResultsHtml'])[1]")
	private WebElement upgResultsMessage;
	
	@FindBy(xpath="//*[contains(text(),'The plan')]")
	private WebElement noMonthlyPremium;
	
	@FindBy(xpath="//p[contains(text(),'enrollment penality')]")
	private WebElement lastEnrollmentPenalty;
	
	@FindBy(xpath="//p[contains(text(),'Part D-Income Related Monthly Adjustment Amount (Part D-IRMAA)')]")
	private WebElement partdincome;
	
	@FindBy(xpath="//ul[@class='zeroPremium']/li[1]")
	private WebElement ss;
	
	@FindBy(xpath="//ul[@class='zeroPremium']/li[2]")
	private WebElement medicare;
	
	@FindBy(xpath="//ul[@class='zeroPremium']/li[3]")
	private WebElement raildroad;
	
	@FindBy(xpath="//ul[@class='zeroPremium']/parent::div/p[4]")
	private WebElement partdirmaa;
	
	public PlanPremiumPageMobile(WebDriver driver) {
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

	public SupplementalBenefitsPageMobile navigate_to_Supplemental_Riders_Page() {
	//	agreeBtn.click();
		//jsClickNew(agreeBtn);
		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Supplemental')]")))){
			Assert.assertTrue(validateNew(driver.findElement(By.xpath("//label[contains(text(),'Yes, I want to add')]"))), "unable to find Yes option available for rider");
			System.out.println("Validated Yes option available");
			System.out.println("OLE Supplemental Benefits page is Displayed");
			return new SupplementalBenefitsPageMobile(driver);
		}
		else{
			System.out.println("OLE Supplemental Benefits page is Displayed");
			return null;
		}
	}	

	public AuthorizationPageMobile navigate_to_Authorization_Page() {
		//agreeBtn.click();
//		jsClickNew(agreeBtn);
		validateNew(NextBtn);
		jsClickNew(NextBtn);
//		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		if(validateNew(authPageHeader,45)){
			System.out.println("OLE Authorization page is Displayed : Navigation from Plan Premium Page Passed");
			return new AuthorizationPageMobile(driver);
		}
		else{
			System.out.println("OLE Authorization page is Displayed : Navigation from Plan Premium Page Failed");
			return null;
		}
	}	

	public boolean validatePayByMail() {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		try {
		if(payByMail.isDisplayed())	{
			scrollToView(payByMail);
			jsClickNew(payByMail);
			Thread.sleep(1000);
			actualText = payByMailText.getText().trim();
			expectedText = CommonConstants.PAY_BY_MAIL_TEXT;
			flag = actualText.equalsIgnoreCase(expectedText);
			
		}
			
			
		} catch (Exception e) {
			System.out.println("=====PayByMail FAILED=====");
		}

			
    return flag;
	
	}
	
	public boolean validateCreditCard(String cardNumber, String year, String month , String name ) throws InterruptedException {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		
		validateNew(creditCard);
		try {
			if(creditCard.isDisplayed())	{
				scrollToView(creditCard);
				jsClickNew(creditCard);
				Thread.sleep(10000);
				driver.switchTo().frame("ole_credit_payment");
				actualText = creditCardText.getText();
				expectedText = CommonConstants.CREDIT_CARD_TEXT;
				flag = actualText.equalsIgnoreCase(expectedText);
					if(flag) {
						flag = enterCreditCardInformation(cardNumber, year, month, name);
					}
			}
			
		} catch (Exception e) {
				System.out.println("=====CreditCard FAILED=====");
			}

				
	    return flag;
		
		}
	
	public boolean enterCreditCardInformation(String cardNo, String month, String year , String cardHolderName) {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		
		try {
			System.out.println("Validate accepted cards");
			actualText = acceptedCards.getText();
			expectedText = CommonConstants.ACCEPTED_CARDS_TEXT;
			flag = actualText.equalsIgnoreCase(expectedText);
				if(flag) {
					System.out.println("Validate session timeout notice");
					actualText = sessionTimeoutNotice.getText();
					expectedText = CommonConstants.SESSION_TIMEOUT_TEXT;
					flag = actualText.contains(expectedText);
					if(flag) {
						System.out.println("Validate Holder Name");
						actualText = cardholderName.getAttribute("value");
						expectedText = cardHolderName;
						flag = actualText.equalsIgnoreCase(expectedText);
							if(flag) {
							System.out.println("Enter Account Information");
							sendKeysByCharacter(accountNumber, cardNo);
							sendKeysByCharacter(cardExpirationMonth, month);
							sendKeysByCharacter(cardExpirationYear, year);
							scrollToView(btnSubmit);
							jsClickNew(btnSubmit);
							Thread.sleep(5000);
							System.out.println("Validate card details stored successfully message");
							driver.switchTo().defaultContent();
							actualText = upgResultsMessage.getText();
							expectedText = CommonConstants.CARD_STORED_SUCCESSFULLY_TEXT;
							flag = actualText.equalsIgnoreCase(expectedText);
					}
				}
		}
			
				
				
			} catch (Exception e) {
				System.out.println("=====CreditCard FAILED=====");
			}

				
	    return flag;
		
		}

	
	public boolean validateSocialSecurity() {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		
		try {
			if(socialSecurity.isDisplayed())	{
				scrollToView(socialSecurity);
				jsClickNew(socialSecurity);
				Thread.sleep(1000);
				actualText = socialSecurityText.getText().trim();
				expectedText = CommonConstants.SOCIAL_SECURITY_TEXT;
				flag = actualText.equalsIgnoreCase(expectedText);
				
			}
				
				
			} catch (Exception e) {
				System.out.println("=====SocialSecurity FAILED=====");
			}

				
	    return flag;
		
		}
	
	public boolean validatePremiumValue() {
		boolean flag = false;
		String actualText = null;
		String expectedText = "0.00";
		try {
			actualText = premium.getText();
			flag = actualText.contains(expectedText);
			if(!flag) {
			System.out.println("=====Premium is greater than 0=====");
			}
		} catch (Exception e) {
			
		}

			
    return flag;
	
	}
	
	public boolean validateNoMonthlyPremium() {
		boolean flag = false;
		String actualText = null;
		String expectedText = null;
		try {
			System.out.println("Validate no monthly premium text");
			actualText = noMonthlyPremium.getText();
			expectedText = CommonConstants.NO_MONTHLY_PREMIUM_TEXT;
			flag = actualText.contains(expectedText);
				if(flag) {
					System.out.println("Validate last enrollment penalty text");
					actualText = lastEnrollmentPenalty.getText();
					expectedText = CommonConstants.LAST_ENROLLMENT_PENALITY_TEXT;
					flag = actualText.contains(expectedText);
					if(flag) {
						System.out.println("Validate part d income text");
						actualText = partdincome.getText();
						expectedText = CommonConstants.PART_D_INCOME_TEXT;
						flag = actualText.contains(expectedText);
						if(flag) {
							System.out.println("Validate ss text");
							actualText = ss.getText();
							expectedText = CommonConstants.SS_TEXT;
							flag = actualText.contains(expectedText);
							if(flag) {
								System.out.println("Validate medicare text");
								actualText = medicare.getText();
								expectedText = CommonConstants.MEDICARE_TEXT;
								flag = actualText.contains(expectedText);
								if(flag) {
									System.out.println("Validate railroad text");
									actualText = raildroad.getText().replaceAll("\u00A00", " ").trim();
									expectedText = CommonConstants.RAILROAD_TEXT;
									flag = actualText.contains(expectedText);
									if(flag) {
										System.out.println("Validate partdirmaa tex");
										actualText = partdirmaa.getText();
										expectedText = CommonConstants.PARTDIRMAA_TEXT;
										flag = actualText.contains(expectedText);
							
									}
						
						
								}
								
					
						}
		}
					}	
			
		}
		}catch (Exception e) {
			System.out.println("=====No monthly premium text validation failed=====");
		}

			
    return flag;
	
	}
	




}