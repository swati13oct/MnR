package pages.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.Assertion;

public class MedicareAdvantagePartCPlansPage extends GlobalWebElements {

	public MedicareAdvantagePartCPlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//span[@class='meded-article-header__title']")
	private WebElement hdrMedicareAdvantagePartCPlans;

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
	
	@FindBy(xpath = "//p[@class='icon-link-box__text']")
	private WebElement lnkPlansAvailableInYourArea;
	
	@FindBy(id="uhc-arrow")
	private WebElement btnNext;
	
	public WebElement getLnkPlansAvailableInYourArea() {
		return lnkPlansAvailableInYourArea;
	}
	
	public WebElement getBtnNext() {
		return btnNext;
	}
		

	public WebElement getTxtZipcode() {
		return txtZipcode;
	}

	public WebElement getBtnZipcode() {
		return btnZipcode;
	}

	public WebElement getHdrMedicareAdvantagePartCPlans() {
		return hdrMedicareAdvantagePartCPlans;
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

	/*back button click on MedicareEducationHome button*/
	public Object backMedicareEducationHome() {
		getLnkBackMedicareEducationHome().click();
		return null;
	}
	
	/*See Plans available in your area*/
	@SuppressWarnings("deprecation")
	public void plansAvailableInYourArea() {

		scrollToView(getLnkPlansAvailableInYourArea());
		Assertion.assertTrue("Plans Available link isn't present", getLnkPlansAvailableInYourArea().isDisplayed());
		switchToNewTabNew(getLnkPlansAvailableInYourArea());

	}

	/* logic:search for a plan with valid zipcode */
	@SuppressWarnings("deprecation")
	public WebDriver planSearch(String zipCode) {
		validateNew(getTxtZipcode());
		getTxtZipcode().sendKeys(zipCode);
		switchToNewTabNew(btnZipcode);
		System.out.println(getTitle());
		Assertion.assertTrue("Incorrect page is loaded",
				getTitle().contains("Find Medicare Plans") || getTitle().contains("Available Plans"));
		validateNonPresenceOfElement(btnZipcode);
		return driver;

	}
	
}