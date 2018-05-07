package pages.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

public class NewEmailAddressPage extends UhcDriver{	

	
  //private static String PAGE_URL = MRConstants.TeamC_NewEmail_address_URL;
	
	
		
		@FindBy(id = "new-email")
		private WebElement newEmail;
		
		@FindBy(id = "new-email-confirm")
		private WebElement ConfirmNewEmail;
		
		@FindBy(xpath = ".//*[@id='email-modal-form']/div/button/span")
		private WebElement ContinueButton1;


		public NewEmailAddressPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}	


		@Override
		public void openAndValidate() {
			//start(PAGE_URL);
		}
		
		public AccountHomePage EnterNewMail() throws InterruptedException
		{
			Thread.sleep(5000);
			newEmail.sendKeys("test@optum.com");
			ConfirmNewEmail.sendKeys("test@optum.com");
			ContinueButton1.click();
			Thread.sleep(5000);
			if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | My Account Home")){
		        return new AccountHomePage(driver);
				}
			return null;
		}
}
