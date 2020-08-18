package pages.regression.guestPayments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;


/**
 * @author akapoo18
 *
 */
public class guestPaymentsLoginWebElements extends UhcDriver{
	
	/**
	 * Lists all the elements of Guest Payments Portal
	 */

	
	public guestPaymentsLoginWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public void openAndValidate() { 
		
	}

	@FindBy(className= "uhc-tempo-header__h1")
     public static WebElement guestPaymentsHeader;
		
	


}

