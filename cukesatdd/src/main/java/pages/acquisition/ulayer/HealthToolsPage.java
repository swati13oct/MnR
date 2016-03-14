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
public class HealthToolsPage extends GlobalWebElements{

	public HealthToolsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;
	
	
	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[1]/div[1]/div[2]/p[3]/a/span")
	private WebElement prescriptiondruglink ;
	
	
public void hoverhealthandwellnesslink() {
	
		
		validate(hoverhealthandwellnesslink);
			//Hover over text
			Actions action = new Actions(driver);
			action.moveToElement(hoverhealthandwellnesslink).build().perform();
			
			//validate(hoverhealthandwellnesslink);
			
			// TODO Auto-generated method stub
		
		}


	public PrescriptionDrugPage PrescriptionDrugToolsClick() {
		
		driver.navigate().back();
		hoverhealthandwellnesslink();
		validate(prescriptiondruglink);
		Actions actions = new Actions(driver);
		 actions.moveToElement(prescriptiondruglink);
	      actions.click().build().perform();
		
	      if(driver.getTitle().equalsIgnoreCase("General Drug Tools")){
		    	return new PrescriptionDrugPage(driver);
	}
	     
		
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}