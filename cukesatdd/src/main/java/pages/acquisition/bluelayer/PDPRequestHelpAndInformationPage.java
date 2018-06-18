package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PDPRequestHelpAndInformationPage extends UhcDriver{
	
	
	@FindBy(xpath = ".//*[@id='subPageLeft']//*[contains(text(),'Information and Enrollment')]")
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
		CommonUtility.waitForPageLoad(driver, pdpEnquiryKitLink, 20);
		pdpEnquiryKitLink.click();
		 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(currentUrl().contains("/prescription-drug-plans/request-information/inquirykit.html")){
			return new  PDPEnrollementGuidePage(driver);
		}
		return null;
		
		
	}

}
