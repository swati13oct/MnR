/**
 * 
 */
package pages.acquisition.ulayer;

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
public class DisclaimersAARPPage extends GlobalFooterWebElements{
	 
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
		if(driver.getTitle().equalsIgnoreCase("Health Insurance Broker & Agent Tools | AARP® Medicare Plans from UnitedHealthcare®")){
			return new AgentsnBrokersAARPPage(driver);
		}
		return null;
	}

}
