/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class WerallyMobilePage extends UhcDriver {

	public WerallyMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	String page = "Werally";

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// Werally page Elements

	// --- From here Common for all page starts ---
	@FindBy(css = ".providerCoverageWelcome div:nth-of-type(1) h2")
	private WebElement welcomeTilte;

	@FindBy(css = ".providerCoverageWelcome button")
	private WebElement getStarted;

	@FindBy(css = "input#search")
	private WebElement searchBox;

	@FindBy(css = "button[name='primary-search-box-action']")
	private WebElement searchButton;

	@FindBy(css = ".results>h4")
	private WebElement serachResultsCount;

	@FindBy(css = "div>div[data-test-id*='search-result-person']")
	private List<WebElement> searchResults;

	// div>div[data-test-id*='search-result-person']:nth-of-type(1) h2
	// Find doctor element and lookup name
	@FindBy(css = "h2")
	private WebElement doctorName;

	// div>div[data-test-id*='search-result-person']:nth-of-type(1)
	// div[class*='hidden'] button
	// Find doctor element and lookup save button
	@FindBy(css = "div[class*='hidden'] button")
	private WebElement doctorsSavebutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>button")
	private WebElement saveModalClosebutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>a")
	private WebElement viewSavedbutton;

	@FindBy(css = "#savedProviders>check-provider-coverage button")
	private WebElement checkProviderCoveragebutton;

	public ArrayList<String> werallySearch(String type, String searchParameter, int count) {
		System.out.println("Werally " + type + " Search Operation");
		ArrayList<String> doctorsName = new ArrayList<String>();
		validate(welcomeTilte, 30);
		getStarted.click();
		validate(searchBox, 30);
		if (type.toUpperCase().contains("DOCTOR")) {
			searchBox.sendKeys(searchParameter);
			searchButton.click();
			int actualResultscount = Integer.parseInt(serachResultsCount.getText().trim().split(" ")[0]);
			if (actualResultscount >= count) {
				for (int i = count; i > 0; i--) {
					doctorsName.add(searchResults.get(i).findElement(By.cssSelector("h2")).getText().trim());
					searchResults.get(i).findElement(By.cssSelector("div[class*='hidden'] button")).click();
					if (i == 1)
						viewSavedbutton.click();
					else
						saveModalClosebutton.click();
				}
				checkProviderCoveragebutton.click();
			} else {
				System.out.println("Required search Results is not Returned");
				Assert.assertTrue(false);
			}
			Collections.sort(doctorsName);
		}
		return doctorsName;
	}

}
