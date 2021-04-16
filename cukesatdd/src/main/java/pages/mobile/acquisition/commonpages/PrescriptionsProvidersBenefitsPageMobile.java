package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
public void clickMedicareAnnualEnrollment() {
		
		WebElement annualEnrll=driver.findElement(By.xpath("//a[contains(text(),'Medicare Annual Enrollment Period')]"));
		jsClickNew(annualEnrll);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		
		if(driver.getCurrentUrl().contains("/medicare-education/enrollment-and-changing-plans.html"))
		{
			WebElement pageHeader=driver.findElement(By.xpath("//h1[contains(text(),'Enrollment Basics')]"));
			waitforElementNew(pageHeader);
			System.out.println("Annual Enrollment Period Page open correctly");
			
		}else {
			System.out.println("Annual Enrollment Period Page did not open correctly");
		}
		
		driver.navigate().back();
		
	}
	public ProviderSearchPageMobile clicksOnRallyToolFromMedEdPage() {
		WebElement providerSearchFromMedEd= driver.findElement(By.xpath("//p[contains(text(),'Look up your providers')]"));
		validateNew(providerSearchFromMedEd);
	
		switchToNewTabNew(providerSearchFromMedEd);
	
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {
	
			return new ProviderSearchPageMobile(driver);
		}
		return null;
	}

	public GetStartedPageMobile clickDCERedesignLinkonMedEdPage() {
		WebElement DCELink = driver.findElement(By.xpath("//a[contains(@href,'drug-cost-estimator') and contains(@class,'contentRow__mededcontainer')]"));
		validateNew(DCELink);
		jsClickNew(DCELink);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement AddMyDrugsBtn=driver.findElement(By.xpath("//button[contains(@id,'addDrug')]"));
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

}