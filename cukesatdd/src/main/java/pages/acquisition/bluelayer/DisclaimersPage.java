/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class DisclaimersPage extends UhcDriver{
	
	@FindBy(id = "gf_lnk_8")
	private WebElement agentAndBrokersLink;

	public DisclaimersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}
	public AgentsAndBrokersPage agentsAndBrokersClick() {
		agentAndBrokersLink.click();
		if(driver.getTitle().equalsIgnoreCase("Health Insurance Broker & Agent Resources | UnitedHealthcare®")){
			return new AgentsAndBrokersPage(driver);
		}
		return null;
			
		}

}
