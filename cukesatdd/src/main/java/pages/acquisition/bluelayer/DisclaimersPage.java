/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author saduri
 *
 */
public class DisclaimersPage extends UhcDriver{
	
	@FindBy(id = "gf_lnk_8")
	private WebElement agentAndBrokersLink;
	
	//@FindBy(xpath = "//h1[@class='logo']/a/p/img")
	@FindBy(id = "logo")
	private WebElement unitedHealthCareLogo;

	public DisclaimersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		validate(unitedHealthCareLogo);
		
	}
	public AgentsAndBrokersPage agentsAndBrokersClick() {
		validate(agentAndBrokersLink);
		agentAndBrokersLink.click();
		validate(agentAndBrokersLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_HEALTH_INSURANCE_BROKER_AGENT_RESOURCES)){
			return new AgentsAndBrokersPage(driver);
		}
		return null;
			
		}
	
	public AcquisitionHomePage unitedHealthCareLogoClick() {
		validate(unitedHealthCareLogo);
		unitedHealthCareLogo.click();
		validate(unitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)) {
			return new AcquisitionHomePage(driver);
		}
		return null;

	}

}
