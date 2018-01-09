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
public class HealthManagementProgramPage extends GlobalWebElements{

	public HealthManagementProgramPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;
	
	@FindBy(xpath="//*[@id='subnav_4']/div/div/div[1]/div[1]/div[2]/p[1]/a/span")
	public static WebElement healthlivinglink;
	
	
	
public void hoverhealthandwellnesslink() {
	
		
		validate(hoverhealthandwellnesslink);
			//Hover over text
			Actions action = new Actions(driver);
			action.moveToElement(hoverhealthandwellnesslink).build().perform();
			
			//validate(hoverhealthandwellnesslink);
			
			// TODO Auto-generated method stub
		
		}

	public HealthLivingPage healthylivingclick() {
		
	
			driver.navigate().back();
			hoverhealthandwellnesslink();
			validate(healthlivinglink);
			Actions actions = new Actions(driver);
			 actions.moveToElement(healthlivinglink);
		      actions.click().build().perform();
			
		      if(driver.getTitle().equalsIgnoreCase("Healthy Living Tools")){
			    	return new HealthLivingPage(driver);
		}
		     

		// TODO Auto-generated method stub
		return null;
	}
	
}