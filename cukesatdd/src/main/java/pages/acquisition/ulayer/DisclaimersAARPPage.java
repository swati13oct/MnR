/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class DisclaimersAARPPage extends GlobalWebElements{
	
	@FindBy(xpath = "//*[@id='site-wrapper']/div[3]/div[1]/header/div[2]/h1/a/p/img")
	private WebElement aarpunitedHealthCareLogo;
	 
	public DisclaimersAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerAgentsnBrokersLink);
		
	}

	public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
		validate(footerAgentsnBrokersLink);
		footerAgentsnBrokersLink.click();
		validate(footerAgentsnBrokersLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_HEALTH_INSURANCE_BROKER_AGENT_TOOLS)){
			return new AgentsnBrokersAARPPage(driver);
		}
		return null;
	}
	
	public AcquisitionHomePage logoClick() {
		validate(logoLink);
		logoLink.click();
		validate(logoLink);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		
		return null;
	}

	public AcquisitionHomePage unitedHealthCareLogoClick() {
		validate(aarpunitedHealthCareLogo);
		aarpunitedHealthCareLogo.click();
		validate(aarpunitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	
	}
}
