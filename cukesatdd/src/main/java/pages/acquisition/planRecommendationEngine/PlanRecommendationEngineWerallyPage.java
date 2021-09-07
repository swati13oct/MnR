/**
 * 
 */
package pages.acquisition.planRecommendationEngine;

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

public class PlanRecommendationEngineWerallyPage extends UhcDriver {

	public PlanRecommendationEngineWerallyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

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
	
	@FindBy(css = "button[class*='action-btn']")
	private WebElement warningMsg;

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
	
	@FindBy(css = "h1.provider-name")
	private WebElement doctorNameinWerally;

	// div>div[data-test-id*='search-result-person']:nth-of-type(1)
	// div[class*='hidden'] button
	// Find doctor element and lookup save button
	@FindBy(css = "div[class*='hidden'] button")
	private WebElement doctorsSavebutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>button")
	private WebElement saveModalCloseContinueSearchbutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>a")
	private WebElement viewSavedbuttonModel;

	@FindBy(css = "#savedProviders>.export-saved-providers button")
	private WebElement checkProviderCoveragebutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn'] button[type='submit']")
	private WebElement finishReturnButton;

	@FindBy(css = "label#label_unsaved_selectedLocation0")
	private WebElement firstLocation;
	
	@FindBy(css = "label#label_unsaved_selectedLocation1")
	private WebElement secondLocation;
	
	@FindBy(css = "label#label_unsaved_selectedLocation2")
	private WebElement thirdLocation;
	
	@FindBy(css = "label#label_unsaved_selectedLocation3")
	private WebElement fourthLocation;
	
	@FindBy(css = "label#label_unsaved_selectedLocation4")
	private WebElement fivthLocation;

	@FindBy(css = "button[aria-describedby*='locationRequired']")
	private WebElement locationSave;

	@FindBy(css = "h1[class*='hidden-phone'] img[alt='UnitedHealthcare']")
	private WebElement desktopLogo;

	@FindBy(css = "div.exportSavedProviders button[type='submit']")
	private WebElement savedFinishReturnButton;

	@FindBy(css = "a[track='Saved']")
	private WebElement viewSavedbutton;
	
	@FindBy(css = "a[track='Find Care']")
	private WebElement findCarebutton;
	
	public ArrayList<String> werallySearch(String type, String searchParameter, int count, int locationCount) {
		System.out.println("Werally " + type + " Search Operation");
		ArrayList<String> doctorsName = new ArrayList<String>();
		ArrayList<String> doctorsSPecialtyName = new ArrayList<String>();
		try {
			validate(welcomeTilte, 30);
//			getStarted.click();
			jsClickNew(getStarted);
		} catch (Exception e) {
			System.out.println("No Get Started button available in werally");
		}
		String[] searchParameterList = searchParameter.split(":");

		for (String s : searchParameterList) {
			searchParameter = s;
			if(validate(warningMsg, 20)) {
				jsClickNew(warningMsg);
				driver.navigate().refresh();
				threadsleep(5000);
				jsClickNew(findCarebutton);
				threadsleep(2000);
			}
			validate(searchBox, 30);
			if (type.toUpperCase().contains("DOCTORS")) {
				if(!validate(searchBox, 30)) {
					validate(findCarebutton, 20);
					jsClickNew(findCarebutton);
					threadsleep(2000);
				}
				searchBox.sendKeys(searchParameter);
				threadsleep(2000);

//				searchButton.click();
				jsClickNew(searchButton);
				validate(serachResultsCount, 30);

				int actualResultscount = Integer.parseInt(serachResultsCount.getText().trim().split(" ")[0]);
				if (actualResultscount >= count) {
					for (int i = count - 1; i >= 0; i--) {
						threadsleep(5000);
						doctorsName.add(searchResults.get(i).findElement(By.cssSelector("h3")).getText().trim());
						doctorsSPecialtyName.add(searchResults.get(i)
								.findElement(By.cssSelector("div[class='small specialties']")).getText().trim());
						WebElement saveButton = searchResults.get(i)
								.findElement(By.cssSelector("div[class*='ctaButtonContainer'] button"));
						if (count > 1) {
							if (i != 0) {
								WebElement doc = searchResults.get(i - 1).findElement(By.cssSelector("h3"));
								scrollToView(doc);
							} else
								scrollToView(serachResultsCount);
						}
						jsClickNew(saveButton);
						threadsleep(3000);
//						doctorsName.add(doctorNameinWerally.getText().trim());
						if(locationCount >= 5 )
							chooseFiveLocation();
						chooseFirstLocation();

//						saveModalCloseContinueSearchbutton.click();
						jsClickNew(saveModalCloseContinueSearchbutton);

					}
				} else {
					System.out.println("Required search Results is not Returned");
					Assert.assertTrue(false);
				}

			}

//			desktopLogo.click();
			jsClickNew(desktopLogo);

		}

//		viewSavedbutton.click();
		jsClickNew(viewSavedbutton);
		threadsleep(3000);
//		savedFinishReturnButton.click();
		jsClickNew(savedFinishReturnButton);
		waitForPageLoadSafari();

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
		Collections.sort(doctorsName);
		Collections.sort(doctorsSPecialtyName);
		System.out.println("Specialty Name Size is : " + doctorsSPecialtyName.size());
		System.out.println("Specialty Name in werally Content is : " + doctorsSPecialtyName);
		return doctorsName;
	}

	public void chooseFirstLocation() {
		if (validate(firstLocation, 5)) {

//			firstLocation.click();
			jsClickNew(firstLocation);

			threadsleep(1000);
			jsClickNew(locationSave);
			threadsleep(2000);
		}
	}
	
	public void chooseFiveLocation() {
		if (validate(firstLocation, 5)) {
//			firstLocation.click();
			jsClickNew(firstLocation);
			threadsleep(1000);
			jsClickNew(secondLocation);
			threadsleep(1000);
			jsClickNew(thirdLocation);
			threadsleep(1000);
			jsClickNew(fourthLocation);
			threadsleep(1000);
			jsClickNew(fivthLocation);
			threadsleep(1000);
			jsClickNew(locationSave);
			threadsleep(2000);
		}
	}

}
