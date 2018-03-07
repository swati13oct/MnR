/**
 * 
 */
package pages.deprecated.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class AgentsnBrokersAARPPage extends GlobalWebElements{
	 
	public AgentsnBrokersAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(footerHomeLink);
		
	}

	public AcquisitionHomePage homeFooterClick() {
		validateNew(footerHomeLink);
		footerHomeLink.click();
		validateNew(footerHomeLink);
		if (driver.getTitle().equalsIgnoreCase("AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}
	
	public boolean validatHomeLink(){
		boolean flag = true;
		
		if(!footerHomeLink.isDisplayed())
			flag = false;
		
		return flag;
	}

}
