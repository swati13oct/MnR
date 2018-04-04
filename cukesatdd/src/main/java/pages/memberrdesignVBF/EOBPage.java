package pages.memberrdesignVBF;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EOBPage extends UhcDriver {

	@FindBy(id = "eob-type")
	private WebElement eobType;

	@FindBy(id = "date-range-1")
	private WebElement eobMonthDateRange;

	@FindBy(xpath = "//h2[@class='h4 margin-none']")
	private WebElement eobDetailsHeader;

	@FindBy(id = "adobesitelink")
	private WebElement adobeWebsiteLink;

	@FindBy(id = "proceedbtn")
	private WebElement siteLeavingProceedButton;

	@FindBy(id = "cancelbtn")
	private WebElement siteLeavingCancelButton;

	@FindBy(xpath = ".//*[@id='IPEinvL']/map/area[2]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//a[contains(text(),'EOB Search')]")
	private WebElement eobLink;

	@FindBy(xpath = "//*[@class='bold number-title ng-binding']")
	private WebElement eobCount;

	@FindBy(xpath = "//i[@class='rightarrow']")
	private WebElement nextPageArrow;

	@FindBy(xpath = ".//*[@id='eoblist0']/a")
	private List<WebElement> listOfEOBs;

	@FindBy(xpath = ".//*[@id='eoblist0']/a/img")
	private List<WebElement> pdfIcon;

	@FindBy(xpath = ".//*[@id='eoblist0']/a/span")
	private List<WebElement> fileType;

	@FindBy(xpath = ".//*[@id='eoblist0']/p")
	private List<WebElement> datesDisplayed;

	@FindBy(className = "loading-block")
	public List<WebElement> loadingImages;

	private static String EOB_DIRECT_URL = MRConstants.EOB_DIRECT_URL;

	/***
	 * 
	 * @param driver
	 */
	public EOBPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/***
	 * 
	 */
	@Override
	public void openAndValidate() {
		RallyDashboardPage.checkModelPopup(driver);
	}

	/***
	 * 
	 * @param dateRange
	 * @param planType
	 * @param eobTypeData
	 */
	public void selectDateRange(String dateRange, String planType, String eobTypeData) {
		validateNew(eobMonthDateRange);
		Select select = new Select(eobMonthDateRange);
		System.out.println(dateRange);
		select.selectByValue(dateRange);
		validateNew(eobType);
		if (planType.equalsIgnoreCase("MAPD")) {
			Select selectType = new Select(eobType);
			selectType.selectByValue(eobTypeData);
			System.out.println(eobTypeData);
		}
		validateDateRangeContentDisplayed(dateRange);
	}

	/***
	 * 
	 */
	public void validateEachEOBonUI() {
		// this method validates size/date/link displayed on UI for each EOB
		if (listOfEOBs.size() == pdfIcon.size() && listOfEOBs.size() == fileType.size()
				&& listOfEOBs.size() == datesDisplayed.size()) {
			// Code optimization required for same logic
			for (int i = 0; i <= pdfIcon.size() - 1; i++) {
				if (pdfIcon.get(i).isDisplayed()) {
					System.out.println(
							pdfIcon.get(i).getAttribute("alt") + " icon at " + (i + 1) + " displayed correctly");
				} else {
					System.out.println("Icon " + (i + 1) + " not displayed");
					Assert.fail();
				}
			}

		} else {
			System.out.println("Count of PDFs and EOB doesn't match");
			Assert.fail();
		}
	}

	/***
	 * 
	 * @param userName
	 * @return
	 */

	public EOBPage loginToDashboardPage(String userName) {
		startNew(EOB_DIRECT_URL);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(userName);
		validateNew(driver.findElement(By.id("username")));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("Password@1");
		driver.findElement(By.id("sign-in-btn")).click();
		return new EOBPage(driver);
	}

	/***
	 * 
	 * @param dateRangeValue
	 */
	public void validateDateRangeContentDisplayed(String dateRangeValue) {
		if (!(loadingImages.isEmpty())) {
			CommonUtility.waitForElementToDisappear(driver, loadingImages.get(0), 120);
		}
		String modifiedDateRange = dateRangeValue.replace('m', 'M');
		if (eobDetailsHeader.getText().contains(modifiedDateRange)) {
			System.out.println(dateRangeValue + " displayed correctly");
		} else {
			System.out.println("Desired value not displayed correctly for EOB statement header");
			Assert.fail();
		}
	}

	/***
	 * 
	 * @return
	 */
	public EOBPage navigateDirectToEOBPag() {
		try {
			if (iPerceptionPopUp.isDisplayed()) {
				iPerceptionPopUp.click();
			}
		} catch (Exception e) {
			System.out.println("iPerception Pop Up not displayed");
		}

		validateNew(eobLink);
		eobLink.click();
		return new EOBPage(driver);
	}

	/***
	 * 
	 */
	public void validateSiteLeaveingPopUP() {
		String eobPageTitle = driver.getTitle();
		System.out.println(eobPageTitle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", adobeWebsiteLink);
		validateNew(siteLeavingProceedButton);
		validateNew(siteLeavingCancelButton);

		// now click cancel and validate any element on page
		siteLeavingCancelButton.click();
		validateNew(adobeWebsiteLink);

		// now again validate site leaving popup
		js.executeScript("arguments[0].click();", adobeWebsiteLink);
		validateNew(siteLeavingProceedButton);
		validateNew(siteLeavingCancelButton);

		// now click on proceed and validate new tab opens
		switchToNewTabNew(siteLeavingProceedButton);

		// capture next page title
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		if (pageTitle != null && pageTitle != eobPageTitle) {
			System.out.println("Site leaving popup validated and working fine");
		} else {
			System.out.println("Site leaving popup is not working!!!");
			Assert.fail("Site leaving popup is not working!!!");
		}
	}

	/***
	 * 
	 */
	public void validateEOBStatements() {
		validateNew(eobCount);
		System.out.println(eobCount.getText());
		int eobCountInt = Integer.parseInt(eobCount.getText());
		System.out.println(eobCountInt);
		numberOfPageDisplayed(eobCountInt);
		for (int i = 0; i < eobCountInt; i++) {
			if (driver.findElement(By.id("eoblist" + i)).isDisplayed()) {
				System.out.println("EOB at" + i + " displayed correctly");
				System.out.println(i % 9);
				if (i % 9 == 0 && i != 0) {
					System.out.println("user clicks on next page arrow button");
					i = 0;
					nextPageArrow.click();
					break;
				}
			} else {
				System.out.println("EOB at " + i + "not displayed");
				Assert.fail("EOB at " + i + "not displayed");
			}
		}
	}

	/***
	 * 
	 * @param eobCount
	 * @return
	 */
	public int numberOfPageDisplayed(int eobCount) {
		float pageCount;
		int numberOfPageDisplayed;
		pageCount = eobCount / 9;
		System.out.println(pageCount);
		numberOfPageDisplayed = (int) pageCount;
		if (numberOfPageDisplayed < 1) {
			System.out.println(numberOfPageDisplayed + "Page displayed for EOBs");
		} else {
			numberOfPageDisplayed += 1;
			System.out.println(numberOfPageDisplayed + "Page displayed for EOBs");
		}
		return numberOfPageDisplayed;
	}

}
