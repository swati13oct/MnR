package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class ContactUsAARPPage extends GlobalWebElements{
	 
	public ContactUsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerSiteMapLink);
		
	}

	public SiteMapAARPPage siteMapFooterClick() {
		validate(footerSiteMapLink);
		footerSiteMapLink.click();
		validate(footerSiteMapLink);
		if (driver.getTitle().equalsIgnoreCase("Site Map | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new SiteMapAARPPage(driver);
		}
		return null;
	}

}
