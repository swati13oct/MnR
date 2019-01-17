package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ProviderSearchPage extends UhcDriver {

	//private PageData providerSearchPage;

	@FindBy(xpath = "//div[@id='find-care']//span[contains(text(),'Provider')]")
	private WebElement providerSearch;

	@FindBy(id = "search")
	private WebElement searchField;

	@FindBy(xpath = "//button[@value='search']")
	private WebElement searchButton;

	@FindBy(className = "location")
	private WebElement zipCode;

	@FindBy(xpath = "//h3[@class='option-title' and contains(text(),'People')]")
	private WebElement people;

	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, providerSearch, 40);
	}

	public void validateZipCodePage() {
		providerSearch.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, searchField, 60);
		validateNew(searchButton);
		validateNew(zipCode);
		validateNew(people);

	}
}
