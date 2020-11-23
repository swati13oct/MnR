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

	@FindBy(css = "div[class*='savedProviderModal'] h1")
	private WebElement saveModelDoctorName;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>button")
	private WebElement saveModalCloseContinueSearchbutton;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn']>a")
	private WebElement viewSavedbutton;

	@FindBy(css = "#savedProviders>.export-saved-providers button")
	private WebElement checkProviderCoveragebutton;

	@FindBy(css = "span.location")
	private WebElement location;

	@FindBy(css = "div[class*='savedProviderModal'] div[class*='modal-btn'] button[type='submit']")
	private WebElement finishReturnButton;

	@FindBy(css = "label#label_unsaved_selectedLocation0")
	private WebElement firstLocation;

	@FindBy(css = "button[aria-describedby*='locationRequired']")
	private WebElement locationSave;

	@FindBy(css = "div.mobile-header img")
	private WebElement mobileLogo;

	@FindBy(css = "div.exportSavedProviders button[class^='action-btn'][type='submit']")
	private WebElement finishReturnButtonHome;

	public ArrayList<String> werallySearch(String type, String searchParameter, int count) {
		System.out.println("Werally " + type + " Search Operation");
		ArrayList<String> doctorsName = new ArrayList<String>();
		boolean newRally = false;
		if (driver.getClass().toString().toUpperCase().contains("ANDROID")) {
			try {
				validate(welcomeTilte, 30);
				getStarted.click();
			} catch (Exception e) {
				System.out.println("No Get Started button available in werally");
			}
			String[] searchParameterList = searchParameter.split(":");

			for (String s : searchParameterList) {
				searchParameter = s;
				validate(searchBox, 30);
				if (type.toUpperCase().contains("DOCTOR")) {
					mobileactionsendkeys(searchBox, searchParameter);
					hidekeypad();
					mobileswipe("50%", false);
					mobileactiontap(searchButton);
					pageloadcomplete();
					int actualResultscount = Integer.parseInt(serachResultsCount.getText().trim().split(" ")[0]);
					if (actualResultscount >= count) {
						for (int i = count - 1; i >= 0; i--) {
							threadsleep(5000);
							doctorsName
									.add(searchResults.get(i).findElement(By.cssSelector("h2")).getText().trim() + " "
											+ searchResults.get(i)
													.findElement(By.cssSelector("span[data-test-id='specialty']"))
													.getText().trim());
							WebElement saveButton = searchResults.get(i)
									.findElement(By.cssSelector(".acquisitionButtons.visible-phone>button"));
							threadsleep(1000);

							//jsClickNew(saveButton);
							System.out.println("Flow Iteration : "+i);
							System.out.println("Count : "+count);
							mobileUtils.mobileLocateElementClick(saveButton);
							//saveButton.click();
							threadsleep(3000);
							chooseFirstLocation();

							saveModalCloseContinueSearchbutton.click();
						}
					} else {
						System.out.println("Required search Results is not Returned");
						Assert.assertTrue(false);
					}
				}
				mobileLogo.click();
			}
			threadsleep(3000);
			finishReturnButtonHome.click();
		}
		// For IOS - Check with Updated Android when needed
		else {
			try {
				validate(welcomeTilte, 30);
				jsClickMobile(getStarted);
			} catch (Exception e) {
				System.out.println("No Get Started button available in werally");
			}
			validate(searchBox, 30);
			threadsleep(5000);
			if (type.toUpperCase().contains("DOCTOR")) {
				// driver.navigate().refresh();
				// pageloadcomplete();
				String zipinfo = location.getText().trim();
				String zip = zipinfo.split(" ")[zipinfo.split(" ").length - 1];
				jsSendkeys(searchBox, searchParameter);

				/*
				 * Clicking is not navigating to search results //mobileswipe("50%",2, false);
				 * searchBox.click(); clickTextIOSNative("return"); //searchButton.click();
				 * //jsClickMobile(searchButton); //pageloadcomplete(); //mobileswipe("50%",1,
				 * true); WebElement elem = null; try {
				 * //elem=driver.findElement(By.cssSelector(
				 * "button[name='primary-search-box-action']>span"));
				 * //elem=driver.findElement(By.
				 * cssSelector("button[name='primary-search-box-action']>span i"));
				 * //elem=driver.findElement(By.xpath(
				 * "//button[@name='primary-search-box-action']"));
				 * //elem=driver.findElement(By.xpath(
				 * "//button[@name='primary-search-box-action']//i")); }catch(Exception e){
				 * System.out.println("No"); } jsClickMobile(elem); elem.click();
				 * System.out.println(driver.getCurrentUrl()); //mobileswipe("50%",3, false);
				 */
				// Alternative :)
				String stgRally = "connect.int.werally.in";
				String prdRally = "connect.werally.com";
				if (driver.getCurrentUrl().contains(stgRally))
					driver.navigate()
							.to("https://" + stgRally + "/searchResults/" + zip + "/page-1?term=" + searchParameter);
				else
					driver.navigate()
							.to("https://" + prdRally + "/searchResults/" + zip + "/page-1?term=" + searchParameter);

				pageloadcomplete();
				System.out.println("We Rally Result URL : " + driver.getCurrentUrl());
				int actualResultscount = Integer.parseInt(serachResultsCount.getText().trim().split(" ")[0]);
				if (actualResultscount >= count) {
					for (int i = count - 1; i >= 0; i--) {
						threadsleep(1000);
						doctorsName.add(searchResults.get(i).findElement(By.cssSelector("h2")).getText().trim() + " "
								+ searchResults.get(i).findElement(By.cssSelector("span[data-test-id='specialty']"))
										.getText().trim());
						WebElement save = searchResults.get(i)
								.findElement(By.cssSelector(".acquisitionButtons.visible-phone>button"));
						jsClickMobile(save);
						threadsleep(1000);
						String text = saveModalCloseContinueSearchbutton.getText();
						if (text.toUpperCase().contains("CONTINUE"))
							newRally = true;
						if (i == 0) {
							if (newRally)
								jsClickMobile(finishReturnButton);
							else
								jsClickMobile(viewSavedbutton);
						} else {
							jsClickMobile(saveModalCloseContinueSearchbutton);
						}
					}
					threadsleep(1000);
					if (!newRally)
						jsClickMobile(checkProviderCoveragebutton);
				} else {
					System.out.println("Required search Results is not Returned");
					Assert.assertTrue(false);
				}
			}
		}
		Collections.sort(doctorsName);
		System.out.println("doctorsName : "+doctorsName);
		return doctorsName;
	}

	public void chooseFirstLocation() {
		if (validate(firstLocation, 5)) {
			firstLocation.click();
			threadsleep(1000);
			jsClickMobile(locationSave);
			threadsleep(2000);
		}
	}

}
