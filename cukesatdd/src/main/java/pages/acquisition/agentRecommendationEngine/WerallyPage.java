/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

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

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class WerallyPage extends UhcDriver {

	public WerallyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	ArrayList<String> werallyResults = new ArrayList<String>();

	String page = "Werally";

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Werally page Elements

//--- From here Common for all page starts ---
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

	@FindBy(css = "h2")
	private WebElement doctorName;

// Find doctor element and lookup save button
	@FindBy(css = "div[class*='hidden'] button")
	private WebElement doctorsSavebutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>button")
	private WebElement saveModalCloseContinueSearchbutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>a")
	private WebElement viewSavedbutton;

	@FindBy(css = "div[class*='exportSavedProviders'] button[class*='action-btn'] span")
	private WebElement checkProviderCoveragebutton;
	
	@FindBy(css = ".modal-body button[type*='submit']")
	private WebElement returnToEnrollment;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn'] button[type='submit']")
	private WebElement finishReturnButton;
	
	@FindBy(css = "#savedProviders button[title^='Delete']")
	private List<WebElement> deleteLinks;

//Rally Home Page

	@FindBy(css = ".feature a[href*='/saved-providers']")
	private WebElement viewSavedProviderbutton;
	
	@FindBy(css = ".feature a[track='Find Care']")
	private WebElement findCarebutton;

//Switch to Werally Window Page

	public ArrayList<String> validateLinksanotherWindow(String primaryWindow, String type, String search) {
		String browser = MRScenario.browsername;
		String env = MRScenario.environment;
		threadsleep(2000);
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows);
		if (windows.size() == 3) {
			for (String window : windows) {
				System.out.println(window.replace("page-", ""));
				if (!window.equals(primaryWindow)) {
					driver.switchTo().window(window);
					if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("edge")
							|| browser.equalsIgnoreCase("IE"))
						driver.manage().window().maximize();
					System.out.println(driver.getCurrentUrl());
					if (driver.getCurrentUrl().contains("werally.in")
							|| driver.getCurrentUrl().contains("werally.com")) {
						if (env.equalsIgnoreCase("prod") || env.equalsIgnoreCase("offline"))
							Assert.assertTrue(driver.getCurrentUrl().contains("werally.com"),
									"Prod Connected to Incorrect Rally");
						else
							Assert.assertTrue(driver.getCurrentUrl().contains("werally.in"),
									"Non Prod Connected to Incorrect Rally");
						if (type.toUpperCase().contains("ADDING"))
							werallyResults = werallySearch(type, search);
						else if (type.toUpperCase().equals("DELETE"))
							werallyResults = werallySearchfordelete(type, search);
						else if (type.toUpperCase().contains("ALL"))
							werallyDeleteAll();
					} else {
						threadsleep(5000);
					}
				}
				threadsleep(5000);
				driver.switchTo().window(primaryWindow);
			}
			System.out.println(driver.getCurrentUrl());
			threadsleep(1000);
		} else {
			System.out.println("Unexpected windows opened");
			driver.switchTo().window(primaryWindow);
			threadsleep(1000);
			Assert.assertTrue(false);
		}
		return werallyResults;
	}

	public ArrayList<String> werallySearch(String type, String searchParameter) {
		System.out.println("Werally " + type + " Search Operation");
		ArrayList<String> doctorsName = new ArrayList<String>();
		boolean newRally = false;
		try {
			validate(welcomeTilte, 30);
			getStarted.click();
		} catch (Exception e) {
			System.out.println("No Get Started button available in werally");
		}
		if (type.toUpperCase().contains("DOCTORS") || type.toUpperCase().contains("HOSPITALS")) {
			String[] doclist = searchParameter.split(":");
			for (int j = 0; j < doclist.length; j++) {
				String docInfo = doclist[j];
				if (docInfo.trim().length() > 0) {
					validate(searchBox, 30);
					searchBox.sendKeys(docInfo);
					threadsleep(2000);
					searchButton.click();
					int actualResultscount = Integer.parseInt(serachResultsCount.getText().trim().split(" ")[0]);
					int count = 1;
					if (actualResultscount >= count) {
						for (int i = count - 1; i >= 0; i--) {
							threadsleep(5000);
							WebElement saveButton = searchResults.get(i)
									.findElement(By.cssSelector("div[class*='hidden'] button"));
							saveButton.click();
							threadsleep(3000);
							String text = saveModalCloseContinueSearchbutton.getText();
							if (text.toUpperCase().contains("SEARCHING"))
								newRally = true;
							if (j == (doclist.length) - 1) {
								if (newRally)
									finishReturnButton.click();
								else
									viewSavedbutton.click();
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
					}
				} else {
					System.out.println("Required search Results is not Returned");
					Assert.assertTrue(false);
				}
			}
			Collections.sort(doctorsName);
		}
		return doctorsName;
	}

	public ArrayList<String> werallySearchfordelete(String type, String searchParameter) {
		System.out.println("Werally " + type + " Search Operation");
		ArrayList<String> doctorsName = new ArrayList<String>();
		// boolean newRally=false;
		try {
			validate(welcomeTilte, 30);
			getStarted.click();
		} catch (Exception e) {
			System.out.println("No Get Started button available in werally");
		}
		validate(viewSavedProviderbutton, 30);
		viewSavedProviderbutton.click();
		String[] doclist = searchParameter.split(":");
		for (int j = 0; j < doclist.length; j++) {
			String docInfo = doclist[j];
			if (docInfo.trim().length() > 0) {
				delete(docInfo);
			}
		}
		validate(viewSavedProviderbutton, 30);
		viewSavedProviderbutton.click();
		threadsleep(5000); 
		validate(checkProviderCoveragebutton, 30);
		checkProviderCoveragebutton.click();
		validate(returnToEnrollment, 30);
		returnToEnrollment.click();
		return doctorsName;
	}

	public void delete(String docInfo) {
		WebElement deleteLink = driver.findElement(By.xpath("//*[contains(@class,'provider-name')]/a[contains(text(),'"
				+ docInfo + "')]/../../../../div[contains(@class,'provider-header')]/p[2]/span/button[@class='link']"));
		jsClickNew(deleteLink);
		threadsleep(2000);
		pageloadcomplete();
	}
	
	public void werallyDeleteAll() {
		System.out.println("Deleting all Providers");
		if (validate(getStarted, 5))
			getStarted.click();
		validate(viewSavedProviderbutton, 30);
		viewSavedProviderbutton.click();
		threadsleep(3000);
		int docLimit = deleteLinks.size(); 
		for(int i=0;i<docLimit;i++) {
			deleteLinks.get(0).click();
			threadsleep(2000);
		}
		validate(findCarebutton, 10);
		findCarebutton.click();
		threadsleep(2000);
		validate(viewSavedProviderbutton, 30);
		viewSavedProviderbutton.click();
		threadsleep(2000);
		validate(checkProviderCoveragebutton, 30);
		checkProviderCoveragebutton.click();
		validate(returnToEnrollment, 30);
		returnToEnrollment.click();
	}

}