package pages.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import org.testng.Assert;
import pages.acquisition.dceredesign.GetStartedPage;

public class PrescriptionsProvidersBenefitsPage extends GlobalWebElements {

	public PrescriptionsProvidersBenefitsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//span[@class='meded-article-header__title']")
	private WebElement hdrPrescriptionsProvidersBenefits;

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
	
	public WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getTxtZipcode() {
		return txtZipcode;
	}

	public WebElement getBtnZipcode() {
		return btnZipcode;
	}

	public WebElement getHdrPrescriptionsProvidersBenefits() {
		return hdrPrescriptionsProvidersBenefits;
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
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickMedicareAnnualEnrollment() {
		
		sleepBySec(3);
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement annualEnrll=driver.findElement(By.xpath("//a[contains(text(),'Medicare Annual Enrollment Period')]"));
		jsClickNew(annualEnrll);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		
		if(driver.getCurrentUrl().contains("/medicare-education/enrollment-and-changing-plans")||driver.getCurrentUrl().contains("/medicare-education-classic/enrollment-and-changing-plans-classic"))
		{
			//WebElement pageHeader=driver.findElement(By.xpath("//span[contains(text(),'Enrollment Basics') and contains(@class,'heading-1')]"));
			//waitforElementNew(pageHeader);
			System.out.println("Annual Enrollment Period Page open correctly");
			
		}else {
			Assert.fail("Annual Enrollment Period Page did not open correctly");
		}
		driver.navigate().back();
	}
	public ProviderSearchPage clicksOnRallyToolFromMedEdPage() {
		//WebElement providerSearchFromMedEd= driver.findElement(By.xpath("//span[contains(text(),'Look up providers in the Provider Search tool')]"));
		WebElement providerSearchFromMedEd= driver.findElement(By.xpath("//a//span[contains(text(),'Look up your providers')]"));
		validateNew(providerSearchFromMedEd);
	
		switchToNewTabNew(providerSearchFromMedEd);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {
	
			return new ProviderSearchPage(driver);
		}
		return null;
	}

	public GetStartedPage clickDCERedesignLinkonMedEdPage() {
		//WebElement DCELink = driver.findElement(By.xpath("//a[contains(@href,'drug-cost-estimator')]//span[contains(text(),'drug cost')]"));
		//WebElement DCELink=driver.findElement(By.xpath("//a[contains(@href,'drug-cost-estimator') and @role='button']"));
		WebElement DCELink=driver.findElement(By.xpath("(//a[contains(@href,'drug-cost-estimator')])[3]"));
		validateNew(DCELink);
		switchToNewTabNew(DCELink);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement DCEHeader=driver.findElement(By.xpath("//h1[contains(text(),'Drug Cost Estimator')]"));
		if (validateNew(DCEHeader))
			return new GetStartedPage(driver);
		return null;
	}

}