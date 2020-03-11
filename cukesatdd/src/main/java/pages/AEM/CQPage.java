/**
 * 
 */
package pages.AEM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author saduri
 *
 */
public class CQPage extends UhcDriver{
	
	
	@FindBy(id="apps")
	private WebElement apps;
	
	@FindBy(xpath=".//*[contains(@id,'ole-common-form')]")
	private WebElement oleForm;
	
	@FindBy(xpath=".//*[contains(@id,'ole-cancel-confirm')]")
	private WebElement cancelForm;
	
	@FindBy(xpath = ".//*[contains(@class,'tooltipParsys parsys cq-element-tooltipParsys')]")
	private WebElement oleToolTips;
	
	@FindBy(xpath = "//*[contains(text(),'Please Provide Your Medicare Insurance Info')]")
	private WebElement masterListPage;

	public CQPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validateNew(apps);
	}

	public void validatePage() {
		
		
	}

	public void validateOLEPages() {
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/welcome.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/oleReviewSubmission.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/oleSubmitConfirmation.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/modalpopup.html");
			validateNew(cancelForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/ole-tooltip-library.html");
			validateNew(oleToolTips);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/masterlistquestions.html");
			validateNew(masterListPage);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/questionlayout.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/ole-righrail.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/aarp/medicareInsuranceInformation.html");
			validateNew(oleForm);
			
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/welcome.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/oleReviewSubmission.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/oleSubmitConfirmation.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/modalpopup.html");
			validateNew(cancelForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/ole-tooltip-library.html");
			validateNew(oleToolTips);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/masterlistquestions.html");
			validateNew(masterListPage);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/questionlayout.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/ole-righrail.html");
			validateNew(oleForm);
			driver.get("http://author-team-ucpcontent.ocp-ctc-dmz-nonprod.optum.com/content/commontools/ole/uhc/medicareInsuranceInformation.html");
			validateNew(oleForm);
			
		
	}
	
	

}
