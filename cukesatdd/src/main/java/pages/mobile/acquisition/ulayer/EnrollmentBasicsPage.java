package pages.mobile.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnrollmentBasicsPage extends GlobalWebElements {

	public EnrollmentBasicsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//span[@class='meded-article-header__title']")
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
	
	@FindBy(xpath = "//span[text()='Enrollment']")
	private WebElement EnrollmentLink;
	
	@FindBy(id = "js-ole-zip-search")
	private WebElement StandaloneZipcode;
	
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
			EnrollmentLink.click();
		}
		else if(plantype.equals("PDP")){
			waitforElement(pdpLeanHowToEnrollLink);
			pdpLeanHowToEnrollLink.click();
			Thread.sleep(5000);
			EnrollmentLink.click();
		}		
	}

}