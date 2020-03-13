/**
 * 
 */
package pages.mobile.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class GlobalWebElementsMobile extends UhcDriver {
	
	public GlobalWebElementsMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {	
	}
	
	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

}
