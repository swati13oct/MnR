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
 * @author pperugu
 *
 */
public class PDPRequestHelpAndInformationPage extends UhcDriver{
	
	
	@FindBy(linkText = "Request Plan Information and Enrollment Materials")
	private WebElement pdpEnquiryKitLink;

	public PDPRequestHelpAndInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

	public PDPEnrollementGuidePage navigatesToPdpEnquiryKit() {
		pdpEnquiryKitLink.click();
		
		if(currentUrl().contains("/prescription-drug-plans/request-information/inquirykit.html")){
			return new  PDPEnrollementGuidePage(driver);
		}
		return null;
		
		
	}

}
