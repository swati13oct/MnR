/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalFooterWebElements;

/**
 * @author rkodumur
 *
 */
public class PrepareForInitialEnrollmentuhcPage extends GlobalFooterWebElements{
	
	

	public PrepareForInitialEnrollmentuhcPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(exploreChangingPlansLink);
		
	}

	public ExploreChangingPlansuhcPage exploreChangingPlansFooterClick() {
		exploreChangingPlansLink.click();
		if(driver.getTitle().equalsIgnoreCase("Change Medicare Plans | UnitedHealthcare�")){
			return new ExploreChangingPlansuhcPage(driver); 
		}
		return null;
		
		
	}

}
