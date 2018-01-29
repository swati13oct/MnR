package pages.dashboard.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ProviderSearchPage extends UhcDriver {

	private PageData providerSearchPage;
	
	@FindBy(xpath="//div[@id='find-care']//span[contains(text(),'Provider')]")
	private WebElement providerSearch;
	
	@FindBy(id="search")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@value='search']")
	private WebElement searchButton;
	
	@FindBy(className="zip")
	private WebElement zipCode;
	
	@FindBy(xpath="//h3[@class='option-title' and contains(text(),'People')]")
	private WebElement people;
	
	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, providerSearch, 40);
		//validate(providerSearch);

	}	
	
	public void validateZipCodePage() {
		providerSearch.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, searchField, 60);
		validate(searchButton);
		validate(zipCode);
		validate(people);
		

	}	
}
