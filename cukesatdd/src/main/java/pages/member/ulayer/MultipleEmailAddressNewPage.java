package pages.member.ulayer;

import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.dashboard.eob.EOBPage;
import pages.member.bluelayer.AccountHomePage;

public class MultipleEmailAddressNewPage extends UhcDriver{	

	
	private static String PAGE_URL = MRConstants.TeamC_MultipleEmail_address_URL;
	
		@FindBy(xpath = ".//*[@id='email-modal-form']/div/button")
		private WebElement ContinueButton;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/fieldset/span")
		private WebElement Error1;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/fieldset/div[1]/div[3]/div/div/label")
		private WebElement UseDifferentEmailAddressButton;
		
		@FindBy(xpath = ".//*[@id='new-email']")
		private WebElement New_Mail;
		
		@FindBy(xpath = ".//*[@id='new-email-confirm']")
		private WebElement Confirm_New_Mail;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/fieldset/div[2]/div[1]/span[1]")
		private WebElement Valid_email_error;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/fieldset/div[2]/div[2]/span[3]")
		private WebElement Email_confirm_error;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/fieldset/div[1]/div[3]/div/div/label")
		private WebElement UseDifferentMailAddressLink;		
       
		@FindBy(id = "email-2")
		private WebElement SecondOption;	
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/fieldset/div[1]/div[1]/div/div/label")
		private WebElement FirstOption;
		
		@FindBy(id = "new-email")
		private WebElement newEmail;
		
		@FindBy(id = "new-email-confirm")
		private WebElement ConfirmNewEmail;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/div/button/span")
		private WebElement ContinueButton1;


		public MultipleEmailAddressNewPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}	


		@Override
		public void openAndValidate() {
			start(PAGE_URL);
		}

		
		public AccountHomePage ClickOnContinue()
		{
			ContinueButton.click();
			if(Error1.getText().contains("required")){				
				return new AccountHomePage(driver);
			}
			return null;
		}
		
		public AccountHomePage EnterInvalidMail() throws InterruptedException
		{
			UseDifferentEmailAddressButton.click();
			Thread.sleep(1000);
			New_Mail.sendKeys("asdf");
			ContinueButton.click();
			if(Valid_email_error.getText().contains("Valid Email Address")){				
				return new AccountHomePage(driver);
			}
			return null;
		}
		
		public AccountHomePage ConfirmMailIssue() throws InterruptedException
		{
			UseDifferentEmailAddressButton.click();
			Thread.sleep(1000);
			New_Mail.sendKeys("asdf@asd.com");
			Confirm_New_Mail.sendKeys("asdf");
			ContinueButton.click();
			if(Email_confirm_error.getText().contains("exact value again")){				
				return new AccountHomePage(driver);
			}
			return null;
		}
		
		public AccountHomePage SelectDifferentEmailAddress() throws InterruptedException
		{
			Thread.sleep(7000);
			UseDifferentMailAddressLink.click();
			New_Mail.sendKeys("abc@tst.com");
			Confirm_New_Mail.sendKeys("abc@tst.com");
			ContinueButton.click();
			Thread.sleep(10000);
			if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | My Account Home")){
		        return new AccountHomePage(driver);
				}
			return null;
		}
		
		public AccountHomePage SelectEmailfromOption() throws InterruptedException
		{
			Thread.sleep(5000);
			SecondOption.click();
			ContinueButton.click();
			Thread.sleep(5000);
			if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | My Account Home")){
		        return new AccountHomePage(driver);
				}
			return null;
		}
		
		
		
}