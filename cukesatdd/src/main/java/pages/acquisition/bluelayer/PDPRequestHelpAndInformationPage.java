package pages.acquisition.bluelayer;

import java.util.Set;

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
	
	
	@FindBy(xpath = ".//*[@id='article_mededaccordion2']//*[contains(text(),'Information and Enrollment')]")
	private WebElement pdpEnquiryKitLink;
	
	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion2']")
	private WebElement pdpInquiryKitDropdown;

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
		CommonUtility.waitForPageLoad(driver, pdpInquiryKitDropdown, 20);
		pdpInquiryKitDropdown.click();
		pdpEnquiryKitLink.click();
		String mainwindow=driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(currentUrl().contains("prescription-drug-plans/request-information/inquirykit")){
			return new  PDPEnrollementGuidePage(driver);
		}
		return null;
		
		
	}

}
