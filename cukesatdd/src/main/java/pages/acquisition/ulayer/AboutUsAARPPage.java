/**
 * 
 */
package pages.acquisition.ulayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class AboutUsAARPPage extends UhcDriver{
	
	@FindBy(id = "gf_lnk_3")
	private WebElement footerContactUsLink;

	public AboutUsAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(footerContactUsLink);
		
	}

	public ContactUsAARPPage contactUsFooterClick() {
		footerContactUsLink.click();
		if (driver.getTitle().equalsIgnoreCase("Contact UnitedHealthcare® | AARP® Medicare Plans from UnitedHealthcare")) {
			return new ContactUsAARPPage(driver);
		}
		return null;
	}

}
