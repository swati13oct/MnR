/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author sdatt11
 *
 */
public class AARPOrgPage extends GlobalFooterWebElements{
		
	
	public AARPOrgPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		System.out.println(getTitle());
		
	}

	 

	
	
}
