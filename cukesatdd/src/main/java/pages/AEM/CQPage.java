/**
 * 
 */
package pages.AEM;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;


/**
 * @author saduri
 *
 */
public class CQPage extends UhcDriver{
	
	
	@FindBy(id="globalnav-start-home-collection")
	private WebElement globalNavHome;
	
	@FindBy(xpath=".//*[contains(@id,'ole-common-form')]")
	private WebElement oleForm;
	
	@FindBy(xpath=".//*[contains(@id,'ole-cancel-confirm')]")
	private WebElement cancelForm;
	
	@FindBy(xpath = ".//*[contains(@class,'tooltipParsys parsys cq-element-tooltipParsys')]")
	private WebElement oleToolTips;
	
	@FindBy(xpath = "//*[contains(text(),'Please Provide Your Medicare Insurance Info')]")
	private WebElement masterListPage;
	
	@FindBy(xpath = "//*[contains(@class,'vpp base_common_tools')]")
	private WebElement vppContent;
	
	@FindBy(xpath = "//*[contains(@ng-app,'commontoolsAngularApp')]")
	private WebElement cnsPlansContent;
	
	@FindBy(xpath = "//*[contains(@class,'tooltipConfiguration')]")
	private WebElement vppToolTip;
	
	@FindBy(xpath = "//header[contains(@class,'header fixed')]")
	private WebElement acqHeader;

	@FindBy(xpath = "//*[contains(@class,'globalFooter')]//footer")
	private WebElement acqFooter;
	
	@FindBy(xpath = "//*[contains(@id,'globalContentIdForSkipLink')]")
	private WebElement acqPageBodyContent;
	
	@FindBy(xpath = "//*[contains(@class,'header preauth')]")
	private WebElement memberHeaderPreSignIn;

	@FindBy(xpath = "//*[contains(@class,'footer')]//footer")
	private WebElement memberFooterPreSignIn;
	
	@FindBy(xpath = "//*[contains(@data-ng-controller,'uhcMnRCustomSegmentationCtl')]")
	private WebElement memberBodyContentPreSignIn;
	
	@FindBy(xpath = "//header[contains(@class,'navbar')]")
	private WebElement memberHeader;

	@FindBy(xpath = "//*[contains(@class,'footerParsys iparsys parsys')]//*[contains(@class,'iparys_inherited')]")
	private WebElement memberFooter;
	
	@FindBy(xpath = "//*[contains(@id,'globalContentIdForSkipLink')]")
	private WebElement memberBodyContent;
	
	
	
	public CQPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validateNew(globalNavHome);
	}

	public void validatePage() {
		
		
	}

	public void validateOLEPages() {
		
			//AARP pages
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/welcome.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/oleReviewSubmission.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/oleSubmitConfirmation.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/modalpopup.html");
			validateNew(cancelForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/ole-tooltip-library.html");
			validateNew(oleToolTips);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/masterlistquestions.html");
			validateNew(masterListPage);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/questionlayout.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/ole-righrail.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/aarp/medicareInsuranceInformation.html");
			validateNew(oleForm);
			
			//UHC pages
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/welcome.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/oleReviewSubmission.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/oleSubmitConfirmation.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/modalpopup.html");
			validateNew(cancelForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/ole-tooltip-library.html");
			validateNew(oleToolTips);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/masterlistquestions.html");
			validateNew(masterListPage);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/questionlayout.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/ole-righrail.html");
			validateNew(oleForm);
			driver.get("http://apvrt73396:8080/content/commontools/ole/uhc/medicareInsuranceInformation.html");
			validateNew(oleForm);
			
		
	}
	public void validateVPPPages() {
		
		//AARP pages
		driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=summary");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=detail#/zipcode");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=portfolio");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/plan.html?page=compare");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/mapdmarketing.html");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/aarp/planmarketing.html");
		validateNew(vppContent);
		
		driver.get("http://apvrt73396:8080/content/commontools/vpp/tool-tip-configuration.html");
		validateNew(vppToolTip);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/CnSPlans.html");
		validateNew(cnsPlansContent);
		
		//UHC pages
		driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=summary");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=detail#/zipcode");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=portfolio");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/plan.html?page=compare");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/mapdmarketing.html");
		validateNew(vppContent);
		driver.get("http://apvrt73396:8080/content/commontools/vpp/uhc/planmarketing.html");
		validateNew(vppContent);

	}
	
	public void validateAcqPages(){
		
		//home page
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en.html");
		validateAcqContent();
		
		//shop for a plan pages
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/health-plans/shop/medicare-advantage-plans.html");
		validateAcqContent();
	
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/health-plans/shop/prescription-drug-plans.html");
		validateAcqContent();
		
		//Understanding medicare pages
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/medicare-education/medicare-eligibility.html");
		validateAcqContent();
		
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/medicare-education/medicare-costs.html");
		validateAcqContent();
	
		//footer links pages
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/contact-us.html");
		validateAcqContent();
		
		driver.get("http://apvrt73396:8080/content/aarpmedicareplans/en/terms-of-use.html");
		validateAcqContent();

	}
	
	public void validateAcqContent(){
		if(!validate(acqHeader))
			Assert.fail("header not found on this page: "+driver.getCurrentUrl());
		if(!validate(acqFooter))
			Assert.fail("footer not found on this page: "+driver.getCurrentUrl());
		if(!validate(acqPageBodyContent))
			Assert.fail("page content not found on this page: "+driver.getCurrentUrl());
	}
	
	public void validateMemberPages(){
		
		//login page
		driver.get("http://apvrt73396:8080/content/medicare/login.html");
		validateMemberPreSingInContent();
		
		//secondary pages
		driver.get("http://apvrt73396:8080/content/medicare/member/order-materials.html");
		validateMemberContent();
		driver.get("http://apvrt73396:8080/content/medicare/member/benefits.html");
		validateMemberContent();
		driver.get("http://apvrt73396:8080/content/medicare/member/payments.html");
		validateMemberContent();
		driver.get("http://apvrt73396:8080/content/medicare/member/claims.html");
		validateMemberContent();
		driver.get("http://apvrt73396:8080/content/medicare/member/health-and-wellness.html");
		validateMemberContent();
		driver.get("http://apvrt73396:8080/content/medicare/member/eob.html");
		validateMemberContent();

	}

	private void validateMemberContent() {
		if(!validate(memberHeader))
			Assert.fail("header not found on this page: "+driver.getCurrentUrl());
		if(!validate(memberFooter))
			Assert.fail("footer not found on this page: "+driver.getCurrentUrl());
		if(!validate(memberBodyContent))
			Assert.fail("page content not found on this page: "+driver.getCurrentUrl());
		
	}

	private void validateMemberPreSingInContent() {
		// TODO Auto-generated method stub
		if(!validate(memberHeaderPreSignIn))
			Assert.fail("header not found on this page: "+driver.getCurrentUrl());
		if(!validate(memberFooterPreSignIn))
			Assert.fail("footer not found on this page: "+driver.getCurrentUrl());
		if(!validate(memberBodyContentPreSignIn))
			Assert.fail("page content not found on this page: "+driver.getCurrentUrl());
	}
}
