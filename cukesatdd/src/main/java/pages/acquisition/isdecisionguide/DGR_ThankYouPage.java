/**
 * 
 */
package pages.acquisition.isdecisionguide;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.VPPPlanSummaryPage;

/**
 *@author sdwaraka
 *
 */
public class DGR_ThankYouPage extends UhcDriver{


	//Global Elements
//	@FindBy(xpath = "//*[@class = 'logo']")
	@FindBy(id = "aarpSVGLogo")
	private WebElement SiteLogo;

	@FindBy(xpath = "//*[@id = 'nav' and @role = 'navigation']")
	private WebElement HeaderNavigation;


	@FindBy(xpath = "//*[@class = 'footer']")
	private WebElement Footer;


	//Right Rail Elements
	@FindBy(xpath = "//*[contains(@class, 'needHelpContainer')]")
	private WebElement NeedHelpContainer;


	//Header

	@FindBy(xpath = "//*[contains(@id, 'ebrcheader')]")
	private WebElement PageHeader;

	@FindBy(xpath = "//a[contains(@role, 'tab') and contains(text(), 'Step 1')]")
	private WebElement Step1Tab;

	//Form Elements

	@FindBy(xpath = "//div[contains(@class, 'ebrcFooter')]")
	private WebElement DisclosureScrollBox;
	
	//Thank You Page
	
	@FindBy(xpath = "//*[contains(@id, 'thankyou')]")
	private WebElement ThankYouPageHeader;

	@FindBy(xpath = "//*[contains(@id, 'findplansbtn')]")
	private WebElement FindPlanBtn;


	public DGR_ThankYouPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, PageHeader,30);

//		validate(Step1Tab);
		validate(PageHeader);
		validate(HeaderNavigation);
		validate(SiteLogo);
		validate(DisclosureScrollBox);
		validate(FindPlanBtn);

		if(PageHeader.getText().contains("Medicare Supplement Insurance Plans"))
			System.out.println("IS Decision Guide Page header is Displayed : "+PageHeader.getText());
	}

	@FindBy(xpath = "//button[contains(text(), 'Find Plans in Your Area')]")
	private WebElement FindPlansAreaButton;
	
	@FindBy(xpath = "(//input[contains(@id,'zipcode')])[2]")
	private WebElement Zipcode;
	public  VPPPlanSummaryPage NavigateNext_vppMedsuppPage() {
		//	if( validate(FindPlansAreaButton)){
			validateNew(FindPlansAreaButton);
			//FindPlansAreaButton.click();
			jsClickNew(FindPlansAreaButton);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonUtility.checkPageIsReadyNew(driver);	
			String checkUrl=driver.getCurrentUrl();
			if(checkUrl.contains("health-plans.html?product=medsup#/plan-summary")) {
				System.out.println("Submit Button Clicked : Plan summary Page is Displayed with zipcode to enter in the page");
				Zipcode.isDisplayed();
				return new VPPPlanSummaryPage(driver);
			}
			return null;	
			}
	}