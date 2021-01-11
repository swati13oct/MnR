package pages.mobile.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.acquisition.ulayer.GlobalWebElements;

public class PrivacyPolicyAARPPageMobile extends GlobalWebElements{
	 
		@FindBy(xpath = "//span[@class='heading-1']")
		public static WebElement header;
		
		@FindBy(xpath = "//h2//span[contains(@class,'paragraph')]")
		public static WebElement pageContent_Para1;
		
		public PrivacyPolicyAARPPageMobile(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}

		@Override
		public void openAndValidate() {
			CommonUtility.waitForPageLoadNew(driver, header, 30);
			
			validateNew(pageContent_Para1,5);
		}

		

	}