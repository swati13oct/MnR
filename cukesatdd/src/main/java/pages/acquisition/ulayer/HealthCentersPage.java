package pages.acquisition.ulayer;


import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.GlobalWebElements;
import acceptancetests.login.data.LoginCommonConstants;

/**
 * @author naggarw2
 *
 */
public class HealthCentersPage extends GlobalWebElements{
	
	
	

	public HealthCentersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	
	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;
	
	@FindBy(xpath ="//*[@id='subnav_4']/div/div/div[1]/div[2]/div[1]/h3/a/span")
	private WebElement healthmanagementprogramlink;
	
	
public void hoverhealthandwellnesslink() {
	
		
		validate(hoverhealthandwellnesslink);
			//Hover over text
			Actions action = new Actions(driver);
			action.moveToElement(hoverhealthandwellnesslink).build().perform();
			
			//validate(hoverhealthandwellnesslink);
			
			// TODO Auto-generated method stub
		
		}


	public HealthManagementProgramPage HealthManagementProgramClick() {
		
		
			  driver.navigate().back();
			hoverhealthandwellnesslink();
			validate(healthmanagementprogramlink);
			Actions actions = new Actions(driver);
			 actions.moveToElement(healthmanagementprogramlink);
		      actions.click().build().perform();
			
		      if(driver.getTitle().equalsIgnoreCase("Health Management Programs")){
			    	return new HealthManagementProgramPage(driver);
		  }
			
		// TODO Auto-generated method stub
		return null;
	}
	
	
}