package pages.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import junit.framework.Assert;

public class EnrollmentBasicsPage extends GlobalWebElements {

	public EnrollmentBasicsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		super.openAndValidate();
		validate(hdrEnrollmentBasics);
	}
	@FindBy(xpath = "//h1[contains(@class,'meded-article-header__title')]")
	private WebElement hdrEnrollmentBasics;

	@FindBy(className = "meded-back-link")
	private WebElement lnkBackMedicareEducationHome;

	@FindBy(id = "state-select")
	private WebElement dropDownState;

	@FindBy(xpath = "//a[@class='med-article-sidebar__link']")
	private List<WebElement> lstSideBarLinks;

	@FindBy(xpath = "//*[@class='med-article-sidebar__section-title']")
	private List<WebElement> lstSideBarheadings;

	@FindBy(id = "zipcodemeded")
	private WebElement txtZipcode;

	@FindBy(xpath = "//button[contains(@ng-click,'lookupZip')]")
	private WebElement btnZipcode;
	
	@FindBy(id="uhc-arrow")
	private WebElement btnNext;
	
	@FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;
	
	@FindBy(xpath = "//a[contains(@href,'pdp-enrollment')]")
	private WebElement pdpLeanHowToEnrollLink;
	
	@FindBy(xpath = "//div[@id='accordion2']//h3[text()='Enrollment']")
	private WebElement EnrollmentLink;
	
	@FindBy(id = "js-ole-zip-search")
	private WebElement StandaloneZipcode;
	
	@FindBy(xpath="//a[contains(@class, 'back-to-top')]")
    private WebElement backToTop;
	
	@FindBy(xpath="//a[contains(text(),'Social Security website')]")
	private WebElement lnkSocialSecurity;
	
	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getTxtZipcode() {
		return txtZipcode;
	}

	public WebElement getBtnZipcode() {
		return btnZipcode;
	}

	public WebElement getHdrEnrollmentBasics() {
		return hdrEnrollmentBasics;
	}

	public WebElement getLnkBackMedicareEducationHome() {
		return lnkBackMedicareEducationHome;
	}

	public WebElement getDropDownState() {
		return dropDownState;
	}

	public List<WebElement> getLstSideBarLinks() {
		return lstSideBarLinks;
	}

	public List<WebElement> getLstSideBarheadings() {
		return lstSideBarheadings;
	}

	public Object backMedicareEducationHome() {
		getLnkBackMedicareEducationHome().click();
		return null;
	}
	
	public void clickONEnrollLink(String plantype, String planName) throws Exception{
		if(plantype.equals("MAPD") || plantype.equals("MA") || plantype.equals("SNP")){
			waitforElement(maLeanHowToEnrollLink);
			maLeanHowToEnrollLink.click();
			Thread.sleep(5000);
			//EnrollmentLink.click();
		}
		else if(plantype.equals("PDP")){
			waitforElement(pdpLeanHowToEnrollLink);
			pdpLeanHowToEnrollLink.click();
			Thread.sleep(5000);
		//	EnrollmentLink.click();
		}		
	}
	
	public void selectStateForGeotargeting() {
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement stateGeotargeting = driver.findElement(By.xpath("(//select[@id='state-select']//option)[2]"));
		scrollToView(stateGeotargeting);
		stateGeotargeting.click();
		waitforElementNew(stateGeotargeting, 5);
		System.out.println("State selected for Geotagging: "+ stateGeotargeting.getText());
		waitforElementNew(stateGeotargeting, 5);
		jsClickNew(backToTop);
	}
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkInnerLinks() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkOriginalMedicare=driver.findElement(By.xpath("//a[contains(text(),'When can I enroll in Original Medicare or apply fo')]"));
		scrollToView(lnkOriginalMedicare);
		jsClickNew(lnkOriginalMedicare);
		sleepBySec(3);
		WebElement lnkBack=driver.findElement(By.xpath("(//a[contains(text(),'Back to top')])[1]"));
		scrollToView(lnkBack);
		jsClickNew(lnkBack);
		System.out.print("Link Clicked: When can I enroll in Original Medicare or apply for more coverage?");
		
		WebElement lnkChangPlans=driver.findElement(By.xpath("//a[contains(text(),'How do I know if I should change plans?')]"));
		scrollToView(lnkChangPlans);
		jsClickNew(lnkChangPlans);
		sleepBySec(3);
		lnkBack=driver.findElement(By.xpath("(//a[contains(text(),'Back to top')])[2]"));
		scrollToView(lnkBack);
		jsClickNew(lnkBack);
		System.out.print("Link Clicked: How do I know if I should change plans?");
		
		WebElement lnkAdditionCoverage=driver.findElement(By.xpath("//a[contains(text(),'When can I change my Medicare plan or apply for ad')]"));
		scrollToView(lnkAdditionCoverage);
		jsClickNew(lnkAdditionCoverage);
		sleepBySec(3);
		lnkBack=driver.findElement(By.xpath("(//a[contains(text(),'Back to top')])[3]"));
		scrollToView(lnkBack);
		jsClickNew(lnkBack);
		System.out.print("Link Clicked: When can I change my Medicare plan or apply for additional coverage?");	
	}

	public void clickSocialSecurity() {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(lnkSocialSecurity);
		scrollToView(lnkSocialSecurity);
		switchToNewTabNew(lnkSocialSecurity);
		
		if(driver.getCurrentUrl().contains("https://www.ssa.gov/benefits/medicare/")) {
			Assert.assertTrue(true);
			System.out.println("Social Security Link open Successfully\tURL: "+driver.getCurrentUrl());
			sleepBySec(5);
			driver.close();
			driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
			
		}else {
			Assert.fail("Social Security Link did not open Successfully");
		}	
	}
	@FindBy(xpath="//p[contains(text(),'See plans available in your area')]")
	private WebElement lnkSeePlans;
	
	public void clickSeePlans() {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(lnkSeePlans);
		scrollToView(lnkSeePlans);
		switchToNewTabNew(lnkSeePlans);
		CommonUtility.checkPageIsReadyNew(driver);
		sleepBySec(10);
		if(driver.getCurrentUrl().contains("/health-plans.html#/plan-summary")) {
			Assert.assertTrue(true);
			System.out.println("Plan Summary Page open Successfully");
			waitForPageLoadSafari();
			sleepBySec(5);
			driver.close();
			driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);			
		}else {
			Assert.fail("Plan Summary Page did not open Successfully");
		}
		
	}
	

	
}