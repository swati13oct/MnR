/**
 * 
 */
package pages.memberrdesignVBF;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipcodeTxt")
	private WebElement zipcodeField;

	@FindBy(id = "distance")
	private WebElement distanceDropDownField;

	@FindBy(id = "zipcode-button")
	private WebElement continueField;

	@FindBy(xpath = "//*[@class='pharmacy-info']")
	private List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	private WebElement PharmacyFoundCount;

	@FindBy(xpath = "//*[contains(text(),'SHOW ON MAP')]")
	private List<WebElement> showonmap;

	@FindBy(xpath = ".//a[@class='display-block collapse-expand collapsed']")
	private WebElement moreInfoLink;

	@FindBy(id = "collapseInfo")
	private WebElement moreInfoText;

	@FindBy(className = "loading-block")
	private WebElement loadingImage;

	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		RallyDashboardPage.checkModelPopup(driver);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 60);
		openAndValidate();
	}

	/***
	 * 
	 * @param distance
	 * @return
	 */
	public boolean enterDistanceDetails(String distance) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReadyNew(driver);

		Select select = new Select(distanceDropDownField);
		String DistanceSelection = distance + " miles";
		select.selectByVisibleText(DistanceSelection);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CommonUtility.waitForElementToDisappear(driver, loadingImage, 120);
		if (distanceDropDownField.getText().contains(distance)) {
			return true;
		}
		return false;

	}

	/***
	 * 
	 * @return
	 */
	public PharmacyResultPage searchesPharmacy() {

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReadyNew(driver);

		int PharmacyCount = PharmacyResultList.size();

		if (PharmacyCount > 0) {
			System.out.println("No of Pharmacies Displayed in Pharmacy Result Page 1 : " + PharmacyCount);
			System.out.println("Total Pharmacy Count : " + PharmacyFoundCount.getText());

			return new PharmacyResultPage(driver);

		}
		System.out.println("Pharmacy Result Not displayed  - Pharmacy Count =  " + PharmacyCount);

		return null;

	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, distanceDropDownField, 60);
		validateNew(zipcodeField);
		validateNew(distanceDropDownField);
		validateNew(continueField);
	}

	/***
	 * 
	 * @return
	 */
	public PharmacyResultPage ValidateShowOnMapLinks() {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, showonmap.get(0), 100);
		int showonmapCount = showonmap.size();
		int PharmacyCount = PharmacyResultList.size();

		System.out.println(" No of SHOW ON MAP Links displayed : " + showonmapCount);
		System.out.println(" No of Pharmacy Results displayed : " + PharmacyCount);

		if (showonmapCount == PharmacyCount) {
			System.out.println("Show on Map Links are Displayed for all Displayed Pharmacy Results");

			return new PharmacyResultPage(driver);
		}
		return null;
	}

	/***
	 * 
	 * @return
	 */
	public PharmacyResultPage validateMoreInfoContent() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(moreInfoLink);
		moreInfoLink.click();
		if (moreInfoText.isDisplayed()) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}

}
