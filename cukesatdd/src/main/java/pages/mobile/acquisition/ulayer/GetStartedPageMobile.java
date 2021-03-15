package pages.mobile.acquisition.ulayer;

import org.junit.Assert;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;


public class GetStartedPageMobile extends UhcDriver {
	
	@FindBy(linkText = "Get started")
	private WebElement getStartedLink;
	
	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[4]/div/div[2]/div/div/div/div/div/div/div[2]/table/tbody/tr/td[3]/div/div[2]/div/div/p/a")
	WebElement enterDrugLink;
	
	@FindBy(xpath="//iframe[@src='/health-plans/dce.html#/estimate-drug-costs']")
	WebElement dceToolFrame;
	
	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	@FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement BuildDrugPage_EnterDrugNameTxt;

	@FindBy(xpath = "//h3[contains(text(), 'Almost there')]")
	public WebElement BuildDrugPage_verificationTxt;
	
	@FindBy(xpath = "//a[contains(@class, 'uhc-link-button')]//*[contains(text(), 'Return to')]")
	public WebElement LinktoExitScenario;
	
	@FindBy(xpath = "//*[contains(@id,'get-started')]")
	public WebElement getStartedTab;


	public GetStartedPageMobile(WebDriver driver) {
		 super(driver);
	       PageFactory.initElements(driver, this);
	       openAndValidate();
	}

	public LocationSearchPageMobile getStarted() {
		getStartedLink.click();
		if(currentUrl().contains("enterZipCode"))
		{
			return new LocationSearchPageMobile(driver);
		}
		else
			return null;
		
	}

	@Override
	public void openAndValidate() {
		validate(getStartedLink);
		
	}
	
	public AddDrugPageMobile navigateToDCE(){
		enterDrugLink.click();
		getStartedLink.click();
		return new AddDrugPageMobile(driver);
		
	}
	
	public BuildYourDrugListMobile clickAddsDrugs() {
		if(validate(AddMyDrugsBtn))
			AddMyDrugsBtn.click();
		CommonUtility.waitForPageLoad(driver, BuildDrugPage_EnterDrugNameTxt, 30);
		if (validateNew(BuildDrugPage_EnterDrugNameTxt)) {
			Assert.assertTrue("Naviagted to Build Drug List Page", true);
			return new BuildYourDrugListMobile(driver);
		}
		Assert.fail("Did not Navigate to Build Drug List Page");
		return null;
	}
		  
	public AddDrugPageMobile clicksOnGetStarted() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(dceToolFrame);
		try{
			getStartedLink.click();
		}catch(Exception e){
			System.out.println("phantomjs doesn't support the element on switched iframe");
		}
		return new AddDrugPageMobile(driver);
	}	 

}
