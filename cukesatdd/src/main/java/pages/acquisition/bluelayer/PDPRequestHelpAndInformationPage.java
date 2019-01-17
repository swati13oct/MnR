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
	
	
	@FindBy(xpath = ".//*[@id='article_mededaccordion1']//*[contains(text(),'Information')]")
	private WebElement pdpEnquiryKitLink;
	
	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion1']")
	private WebElement pdpInquiryKitDropdown;
	
	@FindBy(id = "firstName")
	private WebElement firstNameField;

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
		CommonUtility.waitForPageLoad(driver, pdpInquiryKitDropdown, 50);
		pdpInquiryKitDropdown.click();
		CommonUtility.waitForPageLoad(driver, pdpEnquiryKitLink, 50);
		pdpEnquiryKitLink.click();
		
		//applying hard timeout here to give it couple of seconds to launch the second tab
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		String mainwindow=driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		CommonUtility.waitForPageLoad(driver, firstNameField, 30);
		if(validateNew(firstNameField) && currentUrl().contains("prescription-drug-plans/request-information/inquirykit")){
			return new  PDPEnrollementGuidePage(driver);
		}
		return null;
		
		
	}

}
