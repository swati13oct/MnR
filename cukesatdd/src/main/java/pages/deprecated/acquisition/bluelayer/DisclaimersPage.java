/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

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
	
	@FindBy(xpath = "//h1[@class='logo']/a/p/img")
	private WebElement unitedHealthCareLogo;

	public DisclaimersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		validateNew(unitedHealthCareLogo);
		
	}
	public AgentsAndBrokersPage agentsAndBrokersClick() {
		validateNew(agentAndBrokersLink);
		agentAndBrokersLink.click();
		validateNew(agentAndBrokersLink);
		if(driver.getTitle().equalsIgnoreCase("Health Insurance Broker & Agent Resources | UnitedHealthcare®")){
			return new AgentsAndBrokersPage(driver);
		}
		return null;
			
		}
	
	public AcquisitionHomePage unitedHealthCareLogoClick() {
		validateNew(unitedHealthCareLogo);
		unitedHealthCareLogo.click();
		validateNew(unitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans for Different Needs | UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;

	}

}
