/**
 * 
 */
package pages.mobile.acquisition.ulayer;

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
public class PDPRequestHelpAndInformationPageMobile extends UhcDriver{
	
	
	@FindBy(xpath = ".//*[@id='subPageLeft']/div/div/div/div[2]/div/div[1]/p[2]/a")
	private WebElement pdpEnquiryKitLink;

	public PDPRequestHelpAndInformationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}

	public PDPEnrollementGuidePageMobile navigatesToPdpEnquiryKit() {
		CommonUtility.waitForPageLoad(driver, pdpEnquiryKitLink, 20);
		pdpEnquiryKitLink.click();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(currentUrl().contains("/prescription-drug-plans/request-information/inquirykit.html")){
			return new  PDPEnrollementGuidePageMobile(driver);
		}
		return null;
		
		
	}

}
