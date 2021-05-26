package pages.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;

public class CostBasicsPage extends GlobalWebElements {

	public CostBasicsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//span[@class='meded-article-header__title']")
	private WebElement hdrCostBasics;

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

	public WebElement getHdrCostBasics() {
		return hdrCostBasics;
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
	
	public void navigatesExtraLinks() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkDrugCost=driver.findElement(By.xpath("//a[contains(@href,'extra-help-program')]"));
		validateNew(lnkDrugCost);
		jsClickNew(lnkDrugCost);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("medicare-education/extra-help-program.html")) {
			System.out.println("Extra Help with Medicare Prescription Drug Costs Page Displayed");
		}else{
			System.out.println("Extra Help with Medicare Prescription Drug Costs Page Not Displayed");
		}
		driver.navigate().back();
		
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkMedicaid=driver.findElement(By.xpath("//a[contains(@href,'medicaid-dual')]"));
		validateNew(lnkMedicaid);
		jsClickNew(lnkMedicaid);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("medicare-education/medicare-medicaid-dual-eligibility.html")) {
			System.out.println("Medicare, Medicaid and Dual Eligibility Page Displayed");
		}else{
			System.out.println("Medicare, Medicaid and Dual Eligibility Page Not Displayed");
		}
		driver.navigate().back();
		
	}

	public void navigatesToMedicareSaving() {
		
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkSavings=driver.findElement(By.xpath("//span[contains(text(),'Find out if you qualify for Medicare Savings Pro')]"));
		validateNew(lnkSavings);
		switchToNewTabNew(lnkSavings);		
		CommonUtility.checkPageIsReadyNew(driver);
		sleepBySec(5);
		String urlCheck="https://www.medicare.gov/your-medicare-costs/get-help-paying-costs/medicare-savings-programs";
		System.out.println("Expected URL: "+urlCheck);
		System.out.println("Actual   URL: "+driver.getCurrentUrl());
		if(driver.getCurrentUrl().contains(urlCheck)) {
			System.out.println("Medicare Saving Link open successfully");
			Assertion.assertTrue(true);
		}else{
			Assertion.fail("Medicare Saving Link did not open successfully");
		}
		driver.close();
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

	}		
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}