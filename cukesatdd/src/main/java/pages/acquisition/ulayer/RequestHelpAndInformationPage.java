/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;


/**
 * @author pjaising
 *
 */
public class RequestHelpAndInformationPage extends UhcDriver {
	
	
	//@FindBy(xpath =".//*[contains(@class, 'meded-article-content__section')]//*[contains(text(), 'Request an Appointment')]")
	@FindBy(xpath="//a[contains(text(),'Find an Agent')]")
	private WebElement ma_requestAgentAppointmentLink;
	                 
	@FindBy(xpath =".//*[@id='article_mededaccordion2']//*[contains(text(),'Find UnitedHealthcare')]")
	private WebElement communityMeetingLink;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion0']/a")
	private WebElement requestAgentApptDropdown;
	
	@FindBy(xpath = ".//*[@id='article_mededaccordion1']//*[contains(text(),'Information')]")
	private WebElement pdpEnquiryKitLink;
	
	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion1']/a")
	private WebElement pdpInquityDropdown;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion2']/a")
	private WebElement communityMeetingDropdown;
	
	@FindBy(xpath =".//*[@id='ghn_lnk_1']")
	private WebElement homeTab;
	
	@FindBy(id = "firstName")
	private WebElement firstNameField; //PDP enrollment guide page
	
	@FindBy(id = "ym-first_name")
	private WebElement firstNameAgentAppt; //agent appointment page
	
	
	@FindBy(id = "zipcodemeded-0")
	private WebElement zipCodeMedEd;
	
	@FindBy(id = "lookzip")
	private WebElement lookUpZipLink;
	
	
	@FindBy(xpath = "//input[@id='zipcodemeded']/following-sibling::button[contains(@class,'zip-button')]")
	private WebElement findPlansBtnMedEd;
	
	@FindBy(xpath =".//*[@id='collapse2heading_article_mededaccordion1']/a")
	private WebElement requestMailinfoDropdown;
	
	@FindBy(xpath =".//*[@id='article_mededaccordion1']//*[contains(text(),'Request Mailed Information')]")
	private WebElement ma_requestmailedinformationLink;
	
	@FindBy(id ="iframeForConnextions")
	private WebElement frame;
	
	@FindBy(xpath=" //input[@id='zip']")
	private WebElement zipfield;

	//@FindBy(xpath="//div[contains(@class,'uhc-container')]//div[contains(@class,'segment-title')]//*[contains(text(),'Need')]")
	@FindBy(xpath="//span[@class='heading-1']")
	private WebElement needHelpHeader;
	
	@FindBy(xpath="//a[contains(@class,'tel')][contains(@class, 'tfn')]")
	private WebElement needHelpTFN;
	
	@FindBy(id = "proceed")
	private WebElement proceed;
	
	public RequestHelpAndInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(needHelpHeader);
		validateNew(needHelpTFN);
		validateNew(zipCodeMedEd);
		//validateNew(lookUpZipLink);
		

	}
	
	public RequestAgentAppointmentPage navigateToAgentAppointmentRequest() {
			switchToNewTabNew(ma_requestAgentAppointmentLink);
		CommonUtility.checkPageIsReadyNew(driver);

		if (currentUrl().contains("myuhcagent")) {
			/*if (currentUrl().contains("aarpmedicareplans")) {
				proceed.click();
				CommonUtility.checkPageIsReadyNew(driver);
			}*/
			return new RequestAgentAppointmentPage(driver);
		}

		return null;
	}
	
	public boolean validateHelpandInfoPage(){
		CommonUtility.waitForPageLoad(driver, requestAgentApptDropdown, 50);
		if(!validate(requestAgentApptDropdown)&&!validate(communityMeetingDropdown))
			return false;
		return true;
	}
	
	public boolean validateUhcLink(){
		CommonUtility.waitForPageLoad(driver, communityMeetingDropdown, 50);
		if(validate(communityMeetingDropdown)&&communityMeetingDropdown.getText().contains("Community"))
			return true;
		return false;
	}
	
	public PDPEnrollementGuidePage navigatesToPdpEnquiryKit() {
		validateNew(pdpInquityDropdown);
		if (pdpInquityDropdown.getAttribute("class").contains("collapsed")) {
			pdpInquityDropdown.click();
		}
		validateNew(pdpEnquiryKitLink);
		pdpEnquiryKitLink.click();

		// applying hard timeout here to give it couple of seconds to launch the second
		// tab
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String mainwindow = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstNameField, 60);
		if (firstNameField.isDisplayed()) {
			return new PDPEnrollementGuidePage(driver);
		}
		return null;

	}

	public boolean landingOnCommunityPage() {
		CommonUtility.waitForPageLoad(driver, communityMeetingDropdown, 50);
		communityMeetingDropdown.click();
		CommonUtility.waitForPageLoad(driver, communityMeetingLink, 10);
		communityMeetingLink.click();
		CommonUtility.waitForPageLoad(driver, homeTab, 30);
		if(driver.getCurrentUrl().contains("attend"))
			return true;
		return false;
	}
	
	public RequestMailedInformation navigateToRequestMailedinformation() throws InterruptedException {
		if (requestMailinfoDropdown.getAttribute("class").contains("collapsed")) {
			requestMailinfoDropdown.click();
		}
		validateNew(ma_requestmailedinformationLink);
		ma_requestmailedinformationLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("inquirykit")) {
			return new RequestMailedInformation(driver);
		}
		return null;
	}
	public boolean validatelementsonCommunitymeeting(){
				try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (validate(frame)) {
				switchToNewIframe(frame);
				zipfield.click();
				zipfield.sendKeys("07747");
				driver.switchTo().defaultContent();
				// iPerceptionAutoPopUp.click();
			} else {
				System.out.println("iPerception Pop Up not displayed");
			}
			return false;
			
	}
}
