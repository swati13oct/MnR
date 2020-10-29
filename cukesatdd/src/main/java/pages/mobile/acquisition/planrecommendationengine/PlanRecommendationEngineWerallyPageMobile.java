/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class PlanRecommendationEngineWerallyPageMobile extends UhcDriver {

	public PlanRecommendationEngineWerallyPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	PlanRecommendationEngineCommonutilityMobile desktopCommonUtils = new PlanRecommendationEngineCommonutilityMobile(
			driver);

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
	private WebElement saveModalCloseContinueSearchbutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>a")
	private WebElement viewSavedbutton;

	@FindBy(css = "#savedProviders>.export-saved-providers button")
	private WebElement checkProviderCoveragebutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn'] button[type='submit']")
	private WebElement finishReturnButton;

	public ArrayList<String> werallySearch(String type, String searchParameter, int count) {
		System.out.println("Werally " + type + " Search Operation");
		ArrayList<String> doctorsName = new ArrayList<String>();
		ArrayList<String> doctorsSPecialtyName = new ArrayList<String>();
		boolean newRally = false;
		try {
			validate(welcomeTilte, 30);
			getStarted.click();
		} catch (Exception e) {
			System.out.println("No Get Started button available in werally");
		}
		validate(searchBox, 30);
		if (type.toUpperCase().contains("DOCTORS")) {
			searchBox.sendKeys(searchParameter);
			threadsleep(2000);
			// searchButton.click();
			jsClickNew(searchButton);
			waitforElement(serachResultsCount);
			int actualResultscount = Integer.parseInt(serachResultsCount.getText().trim().split(" ")[0]);
			if (actualResultscount >= count) {
				for (int i = count - 1; i >= 0; i--) {
					threadsleep(5000);
					doctorsName.add(searchResults.get(i).findElement(By.cssSelector("h2")).getText().trim());
					doctorsSPecialtyName.add(searchResults.get(i)
							.findElement(By.cssSelector("div[class='small specialties']")).getText().trim());
					WebElement saveButton = searchResults.get(i)
							.findElement(By.cssSelector("div[class*='hidden'] button"));
					if (count > 1) {
						if (i != 0) {
							WebElement doc = searchResults.get(i - 1).findElement(By.cssSelector("h2"));
							scrollToView(doc);
						} else
							scrollToView(serachResultsCount);
					}
					jsClickNew(saveButton);
					threadsleep(4000);
					String text = saveModalCloseContinueSearchbutton.getText();
					if (text.toUpperCase().contains("CONTINUE"))
						newRally = true;
					if (i == 0) {
						if (newRally)
							// finishReturnButton.click();
							jsClickNew(finishReturnButton);
						else
							// viewSavedbutton.click();
							jsClickNew(viewSavedbutton);
					} else {
						saveModalCloseContinueSearchbutton.click();
					}
				}
				if (!newRally)
					checkProviderCoveragebutton.click();
				try {
					WebDriverWait wait = new WebDriverWait(driver, 2);
					if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
						System.out.println("alert was not present");
					} else {
						Alert alert = driver.switchTo().alert();
						alert.accept();
						System.out.println("alert was present and accepted");
					}

				} catch (Exception e) {
					// exception handling
				}
			} else {
				System.out.println("Required search Results is not Returned");
				Assert.assertTrue(false);
			}
			Collections.sort(doctorsName);
			Collections.sort(doctorsSPecialtyName);
			System.out.println("Specialty Name Size is : " + doctorsSPecialtyName.size());
			System.out.println("Specialty Name in werally Content is : " + doctorsSPecialtyName);
		}
		return doctorsName;
	}

}
