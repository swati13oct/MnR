package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverageChoicesPageMobile extends GlobalWebElements {

	public CoverageChoicesPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(css = "#meded-article-header__title")
	private WebElement hdrCoverageChoices;

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

	public WebElement getHdrCoverageChoices() {
		return hdrCoverageChoices;
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
	

	public void checkCoverageDropdownAB() {
		WebElement dropDownA=driver.findElement(By.xpath("//span[contains(text(),'Original Medicare Part A: Hospital coverage')]"));
		scrollToView(dropDownA);
		validateNew(dropDownA);
		jsClickNew(dropDownA);
		System.out.println("Original Medicare Part A: Hospital coverage DropDown Clicked" );
		sleepBySec(2);
		jsClickNew(dropDownA);
		WebElement dropDownB=driver.findElement(By.xpath("//span[contains(text(),'Original Medicare Part B: Medical coverage')]"));
		scrollToView(dropDownB);
		validateNew(dropDownB);
		jsClickNew(dropDownB);
		System.out.println("Original Medicare Part B: Medical coverage DropDown Clicked");
		sleepBySec(2);
		jsClickNew(dropDownB);
	}

	public void checkPlanDropDowns() {
		WebElement dropDownMA=driver.findElement(By.xpath("//span[contains(text(),'Medicare Advantage (Part C) plans:')]"));
		scrollToView(dropDownMA);
		validateNew(dropDownMA);
		jsClickNew(dropDownMA);
		System.out.println("Medicare Advantage Plan DropDown Clicked" );
		sleepBySec(2);
		jsClickNew(dropDownMA);
		WebElement dropDownSNP=driver.findElement(By.xpath("//span[contains(text(),'Special Needs Plans (SNPs):')]"));
		scrollToView(dropDownSNP);
		validateNew(dropDownSNP);
		jsClickNew(dropDownSNP);
		System.out.println("SNP DropDown Clicked");
		sleepBySec(2);
		jsClickNew(dropDownSNP);
		WebElement dropDownPDP=driver.findElement(By.xpath("//span[contains(text(),'Prescription Drug (Part D) plans:')]"));
		scrollToView(dropDownPDP);
		validateNew(dropDownPDP);
		jsClickNew(dropDownPDP);
		System.out.println("PDP DropDown Clicked");
		sleepBySec(2);
		jsClickNew(dropDownPDP);
		WebElement dropDownMedSup=driver.findElement(By.xpath("//span[contains(text(),'Medicare Supplement insurance plans:')]"));
		scrollToView(dropDownMedSup);
		validateNew(dropDownMedSup);
		jsClickNew(dropDownMedSup);
		System.out.println("MedSup DropDown Clicked");
		sleepBySec(2);
		jsClickNew(dropDownMedSup);
	}


}
