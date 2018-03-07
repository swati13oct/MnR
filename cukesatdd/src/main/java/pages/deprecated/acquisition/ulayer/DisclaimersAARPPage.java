/**
 * 
 */
package pages.deprecated.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import atdd.framework.UhcDriver;

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
		validateNew(footerAgentsnBrokersLink);
		
	}

	public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
		validateNew(footerAgentsnBrokersLink);
		footerAgentsnBrokersLink.click();
		validateNew(footerAgentsnBrokersLink);
		if(driver.getTitle().equalsIgnoreCase("Health Insurance Broker & Agent Tools | AARP® Medicare Plans from UnitedHealthcare®")){
			return new AgentsnBrokersAARPPage(driver);
		}
		return null;
	}
	
	public AcquisitionHomePage logoClick() {
		validateNew(logoLink);
		logoLink.click();
		validateNew(logoLink);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		
		return null;
	}

	public AcquisitionHomePage unitedHealthCareLogoClick() {
		validateNew(aarpunitedHealthCareLogo);
		aarpunitedHealthCareLogo.click();
		validateNew(aarpunitedHealthCareLogo);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	
	}
}
