package pages.regression.guestPayments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import pages.memberrdesignVBF.ConfirmOneTimePaymentPage;
import pages.regression.guestPayments.OneTimeGuestPaymentsPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Strings;
import com.itextpdf.text.log.SysoCounter;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author akapoo18
 *
 */
public class ReviewOneTimeGuestPaymentsPage extends UhcDriver {

	public static boolean isBusinessValidation = false;
	
	@FindBy(xpath = "//h1[contains(text(),'Review and Submit')]")
	public WebElement reviewAndSubmitHeader ;
	
	@FindBy(xpath = "//button[@class='back-btn']")
	public WebElement reviewAndSubmitBackButton;
	
	@FindBy(xpath = "//h3[@class='uhc-tempo-header__h3 token-color-gray-dark-base uhc-tempo-header__medium uhc-pay-txt']")
	public WebElement reviewPaymentDetailsStaticText;

	@FindBy(xpath = "//h2[@class='uhc-tempo-header__h2 uhc-tempo-card__header uhc-tempo-header__medium token-color-gray-dark-base'][contains(text(),'Payment Details')]")
	public WebElement paymentDetailsHeader;
	
	@FindBy(xpath = "//*[@class='change-details-icon-span']")
	public WebElement changePaymentsDetailsLink;

	@FindBy(xpath = "//label[@for='memberID'][contains(text(),'Plan:')]")
	public WebElement planName;

	@FindBy(xpath = "//label[@for='memberID'][contains(text(),'Member Name:')]")
	public WebElement memberName;

	@FindBy(xpath = "//label[@for='memberID'][contains(text(),'ID:')]")
	public WebElement memberID;
	
	@FindBy(xpath = "//label[@for='memberID'][contains(text(),'Payment Details:')]")
	public WebElement paymentDetails;
	
	@FindBy(xpath = "//h3[contains(text(),' Total You Pay ')]")
	public WebElement totalYouPay;
	
	
	@FindBy(xpath = "//p/a")
	public WebElement termsOfServiceLink;

	
	@FindBy(xpath = "//button[contains(text(),'Confirm and Pay')]")
	public WebElement confirmAndPayButton;
	
	@FindBy(id = "//h1[contains(text(),'Payment Submitted')]")
	private WebElement confirmationPageHeader;
	
	@FindBy(xpath = "")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//h1[contains(text(),'Make a One-Time Payment')]")
	public WebElement guestPaymentsHeader;

	
	public ReviewOneTimeGuestPaymentsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	@Override
	public void openAndValidate() {
	

	}
	public boolean guestPaymentsValidate(WebElement element) {
		long timeoutInSec=0;
		return guestPaymentsValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean guestPaymentsValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 



		public void validateHeaderAndPageElementsOnReviewAndSubmitPage() {
			Assert.assertTrue("PROBLEM - unable to locate Review And Submit Header",guestPaymentsValidate(reviewAndSubmitHeader));
			Assert.assertTrue("PROBLEM - unable to locate Review Payment Details Static Text",guestPaymentsValidate(reviewPaymentDetailsStaticText));
			Assert.assertTrue("PROBLEM - unable to locate payment Details Header",guestPaymentsValidate(paymentDetailsHeader));
			Assert.assertTrue("PROBLEM - unable to locate change Payments Details Link",guestPaymentsValidate(changePaymentsDetailsLink));
			Assert.assertTrue("PROBLEM - unable to locate plan Name",guestPaymentsValidate(planName));
			Assert.assertTrue("PROBLEM - unable to locate member Name",guestPaymentsValidate(memberName));
			Assert.assertTrue("PROBLEM - unable to locate member ID",guestPaymentsValidate(memberID));
			Assert.assertTrue("PROBLEM - unable to locate payment Details",guestPaymentsValidate(paymentDetails));
			Assert.assertTrue("PROBLEM - unable to locate total You Pay",guestPaymentsValidate(totalYouPay));
			Assert.assertTrue("PROBLEM - unable to locate Terms Of Service Link",guestPaymentsValidate(termsOfServiceLink));
			Assert.assertTrue("PROBLEM - unable to locate confirm And Pay Button",guestPaymentsValidate(confirmAndPayButton));
			
		}


		public confirmOneTimeGuestPaymentsPage clickOnConfirmPayOnReviewPage() {
			
			confirmAndPayButton.click();
			System.out.println(">>>>>>>Confirm and Pay button is clicked<<<<<<<");
			
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, confirmationPageHeader, 45);
			
			if (driver.getTitle().contains("Payment Submitted")) {
				System.out.println(">>>>>>>>>>>>>>>User is on Confirmation Page<<<<<<<<<<<<<<<<<<");
				return new confirmOneTimeGuestPaymentsPage(driver);
				
			} else if(errorMessage.getText().contains("Only one payment request can be submitted per business day")) {
				System.out.println(">>>>>>>>>>>>Business Validation message appears -- "+errorMessage.getText());
				isBusinessValidation = true;

				return null;
			}
			else {
				System.out.println(">>>>>>>>>>>>>>>>>User is not on Confirmation Page<<<<<<<<<<<<<<<<<<<<<<<<");
				return null;
			}
		}


		public OneTimeGuestPaymentsPage clickOnChangePaymentDetailsLink() {
			
			changePaymentsDetailsLink.click();
			
			System.out.println(">>>>>>>Change Payment details link is clicked<<<<<<<");
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoadNew(driver, guestPaymentsHeader, 45);
			
			
			if (driver.getCurrentUrl().contains("payment-details")) {
				return new OneTimeGuestPaymentsPage(driver);
			}
			else {
			System.out.println(">>>>>>>>>>>>>>>>>User is not on One Time Payments Page<<<<<<<<<<<<<<<<<<<<<<<<");
			
			return null;
			}
		}
			
			
		
			
		
		

}
