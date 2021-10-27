package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import acceptancetests.util.CommonUtility;


public class PrescriptionsProvidersBenefitsPageMobile extends GlobalWebElements {

	public PrescriptionsProvidersBenefitsPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//span[@class='meded-article-header__title']")
	private WebElement hdrPrescriptionsProvidersBenefits;

	@FindBy(className = "meded-back-link")
	private WebElement lnkBackMedicareEducationHome;

	@FindBy(css = "#state-select")
	private WebElement dropDownState;

	@FindBy(xpath = "//a[@class='med-article-sidebar__link']")
	private List<WebElement> lstSideBarLinks;

	@FindBy(xpath = "//*[@class='med-article-sidebar__section-title']")
	private List<WebElement> lstSideBarheadings;

	@FindBy(css = "#zipcodemeded")
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
public void clickMedicareAnnualEnrollment() {
		
		WebElement annualEnrll=driver.findElement(By.xpath("//a[contains(text(),'Medicare Annual Enrollment Period')]"));
		jsClickNew(annualEnrll);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		
		if(driver.getCurrentUrl().contains("/medicare-education/enrollment-and-changing-plans")||driver.getCurrentUrl().contains("/medicare-education-classic/enrollment-and-changing-plans-classic"))
		{
			/*WebElement pageHeader=driver.findElement(By.xpath("//h1[contains(text(),'Enrollment Basics')]"));
			waitforElementNew(pageHeader);*/
			System.out.println("Annual Enrollment Period Page open correctly");
			
		}else {
			Assert.fail("Annual Enrollment Period Page did not open correctly");
		}
		driver.navigate().back();
		
	}
	public ProviderSearchPageMobile clicksOnRallyToolFromMedEdPage() {
		WebElement providerSearchFromMedEd= driver.findElement(By.xpath("//a//span[contains(text(),'Look up your providers')]"));
		validateNew(providerSearchFromMedEd);
		switchToNewTabNew(providerSearchFromMedEd);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPageMobile(driver);
		}
		return null;
	}

	public GetStartedPageMobile clickDCERedesignLinkonMedEdPage() {
		WebElement DCELink=driver.findElement(By.cssSelector("a[data-asset-name='Estimate Your Drug Costs'][href$='drug-cost-estimator']"));
		validateNew(DCELink);
		jsClickNew(DCELink);
//		switchToNewTabNew(DCELink);
		waitForPageLoadSafari();
		sleepBySec(2);
		CommonUtility.checkPageIsReadyNew(driver);
		//WebElement DCEHeader=driver.findElement(By.xpath("//h1[contains(text(),'Drug Cost Estimator')]"));
		if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
			return new GetStartedPageMobile(driver);
		return null;
	}

}