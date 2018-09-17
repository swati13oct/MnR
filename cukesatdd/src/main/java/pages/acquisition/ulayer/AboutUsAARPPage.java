/**
 * 
 */
package pages.acquisition.ulayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class AboutUsAARPPage extends GlobalWebElements{
	
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
		validate(footerContactUsLink);
		footerContactUsLink.click();
		validate(footerContactUsLink);
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsAARPPage(driver);
		}
		return null;
	}

}
