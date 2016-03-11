package pages.acquisition.ulayer;


import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.login.data.LoginCommonConstants;

/**
 * @author naggarw2
 *
 */
public class PrescriptionDrugPage extends GlobalFooterWebElements{

	public PrescriptionDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}
	
}	