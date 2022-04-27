/**
 * 
 */
package pages.acquisition.commonpages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.DataTableParser;
import atdd.framework.UhcDriver;
import io.cucumber.datatable.DataTable;
import pages.acquisition.vpp.VPPTestHarnessPage;

/**
 * @author pperugu
 *
 */
public class ProviderSearchPage extends UhcDriver {

	private static final String planToBeSelected = null;
	

	@FindBy(className = "firstTierFilterItem")
	private WebElement physcianSearchTypes;

	@FindBys(value = { @FindBy(xpath = "//div[@id='providerResultsContainer']/div") })
	private List<WebElement> providerNameList;

	@FindBy(className = "cboxIframe")
	private WebElement cboxIframeElement;

	@FindBy(className = "providerName")
	private WebElement providerName;

	@FindBy(id = "ctl00_PopupContentPlaceHolder_CompleteListButton")
	private WebElement completeMyList;

	@FindBy(id = "pageHeader")
	private WebElement pageHeader;

	@FindBy(xpath = "(//*[@data-test-id='saved-provider-button'])[1]")
	private WebElement selectProviderBtn;

	// @FindBys(value = {
	// @FindBy(xpath = "//div[@class='acquisitionButtons
	// hidden-phone']//button[contains(@class,'saved-provider-button')]/span[text()='Save']")
	// })
	@FindBy(xpath = "(//button[contains(@class,'saved-provider-button')])[1]")
	private WebElement SaveBtn;

	@FindBys(value = {
			@FindBy(xpath = "//div[@class='acquisitionButtons hidden-phone']//button[contains(@class,'saved-provider-button')]/span[text()='Save']") })
	private List<WebElement> SaveBtns;

	@FindBys(value = {
		//	 @FindBy(xpath = "//div[@class='acquisitionButtons hidden-phone']//button[contains(@class,'saved-provider-button')]") })
			@FindBy(xpath = "//*[@data-test-id='saved-provider-button']") })
	private List<WebElement> MulitpleSaveBtns;

	@FindBy(xpath = "//button[@data-test-id='button-close']")
	private WebElement Viewsavebtn;

	@FindBy(xpath = "//*[@data-test-id='button-view-saved-provider']")
	private WebElement ViewsaveOldbtn;

	// @FindBy(xpath = "//*[contains(@class,'action-btn') and
	// contains(text(),'Finish')]")
	// @FindBy(xpath = "//*[contains(@class,'action-btn') and
	// contains(text(),'Finish')]")
	@FindBy(xpath = "(//*[contains(@class,'action-btn') and contains(text(),'Finish')])[2]")
	private WebElement finishReturnBtn;

	@FindBy(xpath = "//*[text()='View Saved']")
	private WebElement ViewsaveProviderbtn;

	@FindBy(xpath = "//*[contains(@text(),'View Saved')]")
	private WebElement EditSavedButton;

	@FindBy(xpath = "//span[contains(text(),'Saved')]")
	private WebElement ViewSavedProvidersLink;

	// @FindBy(xpath = "//*[contains(@id,'label_unsaved_selectedLocation0')]")
	@FindBy(xpath = "//label[contains(@id,'unsaved_selectedLocation0')]")
	private WebElement selectLocationOption;

	@FindBy(xpath = "(//button[contains(text(),'Check Provider Coverage')])[1]")
	private WebElement Checkcoverage;

	@FindBy(xpath = "(//button[contains(text(),'Finish & Return')])[1]")
	private WebElement FinishButton;

	@FindBy(id = "finishAndReturnButton")
	private WebElement FinishButtonFinish;

	@FindBy(xpath = "//button[@data-test-id='People']")
	private WebElement People;

	@FindBy(xpath = "//button[@data-test-id='GeneralDentists']")
	private WebElement GeneralDentist;

	@FindBy(xpath = "//*[contains(@data-test-id,'MedicalDirectory')]")
	private WebElement MedicalDirectory;

	@FindBy(xpath = "//*[contains(@data-test-id,'BehavioralHealthDirectory')]")
	private WebElement BehaviourDirectory;

	@FindBy(xpath = "//*[contains(@data-test-id,'DentalHealthDirectory')]")
	private WebElement DentalDirectory;

	@FindBy(xpath = "//button[@data-test-id='Places']")
	private WebElement Places;

	@FindBy(xpath = "//button[@data-test-id='Hospitals']")
	private WebElement Hospitals;

	@FindBy(xpath = "//button[@data-test-id='PrimaryCare']")
	private WebElement Primary;

	@FindBy(xpath = "//button[@data-test-id='MedicalVirtualCare']")
	private WebElement VirtualCare;

	@FindBy(xpath = "//*[contains(text(),'All Primary Care')]")
	private WebElement Physician;

	@FindBy(xpath = "//div[contains(@class,'first')]//div[@class='hidden-phone']//button")
	private WebElement Savebtn;

	@FindBy(xpath = "//*[contains(text(),'Get Started')]")
	private WebElement GetStarted;

	@FindBy(id = "location")
	private WebElement zipCodeTextfield;

	@FindBy(xpath = "//*[@id='mainContent']//button")
	private WebElement continueButton;

	@FindBy(xpath = "(//*[contains(@class,'searchData')]//*[contains(@data-test-id,'provider-name-link')])[2]")
	private WebElement PrimaryCarePhysician;

	@FindBy(xpath = "//*[contains(@class,'action-btn negative print')]")
	private WebElement PrintEmailBtn;

	@FindBy(xpath = "//span[contains(@ng-switch-when, 'false') and (text()='Save')]")
	private WebElement saveBtn2;

	@FindBy(xpath = "//button[text()='Cancel']//following-sibling::button")
	private WebElement NewsaveBtn2;

	@FindBy(xpath = "(//span[contains(@ng-bind-html, 'item.title') and contains(text(),'Saved')])")
	private WebElement Savedproviders;

	@FindBy(xpath = "//*[contains(text(),'Close')]")
	private WebElement BtnClose;

	@FindBy(xpath = "//*[contains(@class,'provider-name')]")
	private WebElement providerNameText;

	@FindBy(xpath = "//li[@class='provider-card']")
	private WebElement providerCard;

	@FindBy(xpath = "//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'next')]")
	private WebElement nextYrTile;

	@FindBy(xpath = "//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'current')]")
	private WebElement currentYrTile;

	@FindBy(xpath = "//button[text()='Continue Searching']")
	private WebElement continueSearching;

	@FindBy(xpath = "(//button[contains(text(),'Finish')])[2]")
	private WebElement Finish;

	@FindBy(xpath = "//*[text()='Finish & Return']")
	private WebElement FinishReturnButton;

	@FindBy(xpath = "//*[@track='Find Care']")
	private WebElement FindCare;

	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if(validate(continueButton)||validate(GetStarted)) {
			System.out.println("Elements validated on Rally landing page");
		}else
			Assert.fail("Continue button or Get Started button not present on Rally landing page");
	}

	public VPPPlanSummaryPage selectsProvider(String physicianSearchCriteria, String physicianName) {

		CommonUtility.waitForPageLoad(driver, physcianSearchTypes, 10);
		ElementData elementData = new ElementData("linkText", physicianSearchCriteria);
		findElement(elementData).click();
		CommonUtility.waitForPageLoad(driver, providerName, 10);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WebElement element : providerNameList) {
			ElementData providerElementData = new ElementData("className", "providerName");
			if (findChildElement(providerElementData, element).getText().equalsIgnoreCase(physicianName)) {
				ElementData addToListElementData = new ElementData("linkText", "Add to List");
				findChildElement(addToListElementData, element).click();
				break;
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToNewIframe(cboxIframeElement);
		completeMyList.click();

		if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage selectsProvider() {
		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, MedicalDirectory, 30);
		MedicalDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		Physician.click();
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption, 10)) {
			jsClickNew(selectLocationOption);
			validateNew(saveBtn2);
			jsClickNew(saveBtn2);
		}
		threadsleep(10);
		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Provider Name is : " + providerSaved);
		MRConstants.PROV_NAME = providerSaved;

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ Viewsavebtn.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		// note: setting the implicit wait to 0 as it fails because of TimeoutException
		// while finding List<WebElement>
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			jsClickNew(Checkcoverage);
		} else if (driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']"
				+ "//button[contains(@class,'action-btn')])[1]")).size() > 0) {
			System.out.println("NEW Rally page displayed");
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");

		threadsleep(3);
		waitForCountDecrement(2);
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new VPPPlanSummaryPage(driver);
	}

	public VPPPlanSummaryPage selectsBehaviour() {

		CommonUtility.waitForPageLoadNew(driver, FindCare, 45);
		FindCare.click();

		CommonUtility.waitForPageLoadNew(driver, BehaviourDirectory, 30);
		BehaviourDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		// CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		// Primary.click();

		CommonUtility.waitForPageLoadNew(driver, VirtualCare, 30);

		VirtualCare.click();
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption, 10)) {
			jsClickNew(selectLocationOption);
			validateNew(saveBtn2);
			jsClickNew(saveBtn2);
		}
		threadsleep(10);
		validateNew(providerNameText);
		String BehaviourSaved = providerNameText.getText().trim();
		System.out.println("Behaviour Provider Name is : " + BehaviourSaved);
		MRConstants.BEHAV_NAME = BehaviourSaved;

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ Viewsavebtn.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		// note: setting the implicit wait to 0 as it fails because of TimeoutException
		// while finding List<WebElement>
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			jsClickNew(Checkcoverage);
		} else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");

		threadsleep(3);
		waitForCountDecrement(2);
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new VPPPlanSummaryPage(driver);
	}

	public VPPPlanSummaryPage selectsDental() {

		CommonUtility.waitForPageLoadNew(driver, FindCare, 45);
		FindCare.click();

		CommonUtility.waitForPageLoadNew(driver, DentalDirectory, 30);
		DentalDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, GeneralDentist, 30);
		GeneralDentist.click();

		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption, 10)) {
			jsClickNew(selectLocationOption);
			validateNew(saveBtn2);
			jsClickNew(saveBtn2);
		}
		threadsleep(10);
		validateNew(providerNameText);
		String DentalSaved = providerNameText.getText().trim();
		System.out.println("Dental Provider Name is : " + DentalSaved);
		MRConstants.DENT_NAME = DentalSaved;

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ Viewsavebtn.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		// note: setting the implicit wait to 0 as it fails because of TimeoutException
		// while finding List<WebElement>
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			jsClickNew(Checkcoverage);
		} else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");

		threadsleep(3);
		waitForCountDecrement(2);
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new VPPPlanSummaryPage(driver);
	}

	public VPPPlanSummaryPage selectsHospitals() {
		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		jsClickNew(GetStarted);

		CommonUtility.waitForPageLoadNew(driver, MedicalDirectory, 10);
		MedicalDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, Places, 30);
		jsClickNew(Places);

		CommonUtility.waitForPageLoadNew(driver, Hospitals, 30);
		jsClickNew(Hospitals);

		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);

		jsClickNew(selectProviderBtn);
		if (validate(selectLocationOption)) {
			jsClickNew(selectLocationOption);
			validateNew(saveBtn2);
			jsClickNew(saveBtn2);
		}
		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME = providerSaved;

		if (driver.findElements(By.xpath("//*[@data-test-id='button-view-saved-provider']")).size() > 0)
			jsClickNew(ViewsaveOldbtn);
		else if (driver.findElements(By.xpath("//button[@data-test-id='button-close']")).size() > 0) {
			jsClickNew(Viewsavebtn);
			if (driver.findElements(By.xpath("//span[text()='Update This Provider']")).size() > 0) {
				jsClickNew(ViewSavedProvidersLink);
			} else
				System.out.println("New Rally page not displayed");

		}
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			jsClickNew(Checkcoverage);
		} else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");
		waitForCountDecrement(2);
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		return new VPPPlanSummaryPage(driver);
	}

	public void entersZipcodeAndSelectPlanName(String zipcode, String planName, String year) {

		validateNew(zipCodeTextfield);
		zipCodeTextfield.sendKeys(zipcode);
		validateNew(continueButton);
		continueButton.click();
		if (year.contains("current")) {
			if (validate(currentYrTile)) {
				// currentYrTile.click();
				jsClickNew(currentYrTile);
			} else {
				System.out.println("Current year tile is not present");
			}
		} else if (year.contains("next")) {
			if (validate(nextYrTile))
				// nextYrTile.click();
				jsClickNew(nextYrTile);
		}
		WebElement planNameToBeSelected = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]"));
		validateNew(planNameToBeSelected);
		planNameToBeSelected.click();
		// TODO Auto-generated method stub

	}

	public int entersZipcodeAndPlancount(String zipcode, String year) {

		validateNew(zipCodeTextfield);
		zipCodeTextfield.sendKeys(zipcode);
		validateNew(continueButton);
		jsClickNew(continueButton);
		selectYear(year);

		List<WebElement> topicDropDownValues = driver
				.findElements(By.xpath("//div[@data-ui-section='plan-listing']//ul//li"));

		return topicDropDownValues.size();
	}

	public void selectsProviderFromGlobaHeader() {

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);
		Physician.click();

		CommonUtility.waitForPageLoadNew(driver, PrimaryCarePhysician, 30);
		PrimaryCarePhysician.click();

		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);
		selectProviderBtn.click();

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		if (driver.findElements(By.xpath("//*[@data-test-id='button-view-saved-provider']")).size() > 0)
			ViewsaveOldbtn.click();
		else if (driver.findElements(By.xpath("//button[@data-test-id='button-close']")).size() > 0) {
			Viewsavebtn.click();
			if (driver.findElements(By.xpath("//span[text()='Update This Provider']")).size() > 0) {
				ViewSavedProvidersLink.click();
			} else
				System.out.println("New Rally page not displayed");

		}
		CommonUtility.waitForPageLoadNew(driver, PrintEmailBtn, 30);
		// validateNew(providerCard);
		validateNew(PrintEmailBtn);

	}

	public PlanDetailsPage selectsProviderFromVppPlanDetailsPage() {
		// TODO Auto-generated method stub

		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, MedicalDirectory, 10);
		MedicalDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		Physician.click();
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption)) {
			jsClickNew(selectLocationOption);
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME = providerSaved;

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ Viewsavebtn.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		// note: setting the implicit wait to 0 as it fails because of TimeoutException
		// while finding List<WebElement>
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(FinishButtonFinish));
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			Checkcoverage.click();
		} else if (driver.findElements(By.xpath(
				"//form[@data-ui-element-name='check-provider-coverage']//button[contains(@id,'finishAndReturnButton')]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			// FinishButton.click();
			jsClickNew(FinishButtonFinish);
		} else
			System.out.println("Issue with Xpath");

		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		return new PlanDetailsPage(driver);

	}

	public VPPTestHarnessPage selectsProviderNavigateBacktoTestharness() {
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, MedicalDirectory, 10);
		MedicalDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		jsClickNew(Physician);
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME = providerSaved;

		if (driver.findElements(By.xpath("//*[@data-test-id='button-view-saved-provider']")).size() > 0)
			ViewsaveOldbtn.click();
		else if (driver.findElements(By.xpath("//button[@data-test-id='button-close']")).size() > 0) {
			Viewsavebtn.click();
			if (driver.findElements(By.xpath("//span[text()='Update This Provider']")).size() > 0) {
				ViewSavedProvidersLink.click();
			} else
				System.out.println("New Rally page not displayed");

		}
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			Checkcoverage.click();
		} else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			FinishButton.click();
		} else
			System.out.println("Issue with Xpath");
		waitForCountDecrement(2);
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		return new VPPTestHarnessPage(driver);
	}

	/*
	 * /* public VPPPlanSummaryPage MultipleselectsProvider() { GetStarted.click();
	 * 
	 * //CommonUtility.waitForPageLoadNew(driver, People, 30);
	 * CommonUtility.waitForPageLoadNew(driver, People, 10); People.click();
	 * 
	 * //CommonUtility.waitForPageLoadNew(driver, Primary, 30);
	 * CommonUtility.waitForPageLoadNew(driver, Primary, 10); Primary.click();
	 * 
	 * //CommonUtility.waitForPageLoadNew(driver, Physician, 30);
	 * CommonUtility.waitForPageLoadNew(driver, Physician, 10);
	 * jsClickNew(Physician);
	 * 
	 * CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
	 * jsClickNew(selectProviderBtn);
	 * 
	 * int counter =0; for (WebElement element : MulitpleSaveBtns) {
	 * //CommonUtility.waitForPageLoadNew(driver, element, 45);
	 * CommonUtility.waitForPageLoadNew(driver, element, 10); jsClickNew(element);
	 * 
	 * if (validate(selectLocationOption,10)) { // selectLocationOption.click();
	 * jsClickNew(selectLocationOption); validateNew(saveBtn2);
	 * jsClickNew(saveBtn2); //saveBtn2.click(); } //New Changes
	 * 
	 * //CommonUtility.waitForPageLoadNew(driver, continueSearching, 45);
	 * CommonUtility.waitForPageLoadNew(driver, continueSearching, 10);
	 * //continueSearching.click(); jsClickNew(continueSearching);
	 * 
	 * 
	 * //CommonUtility.waitForPageLoadNew(driver, BtnClose, 45);
	 * //jsClickNew(BtnClose);
	 * 
	 * 
	 * counter++; if(counter==9) { break; }
	 * 
	 * } CommonUtility.waitForPageLoadNew(driver, Savedproviders, 10);
	 * jsClickNew(Savedproviders); waitForPageLoadSafari();
	 * 
	 * if(driver.findElements(By.
	 * xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() >
	 * 0){ System.out.println("OLD Rally page displayed"); // Checkcoverage.click();
	 * jsClickNew(Checkcoverage); } else if(driver.findElements(By.xpath(
	 * "(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"
	 * )).size() > 0){ System.out.println("NEW Rally page displayed");
	 * //FinishButton.click(); validateNew(FinishButton); jsClickNew(FinishButton);
	 * }else System.out.println("Issue with Xpath");
	 * 
	 * threadsleep(3); waitForCountDecrement(2);
	 * driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
	 * 
	 * return new VPPPlanSummaryPage(driver); }
	 */
	public VPPPlanSummaryPage MultipleselectsProvider() throws InterruptedException {
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, MedicalDirectory, 10);
		MedicalDirectory.click();

		// CommonUtility.waitForPageLoadNew(driver, People, 30);
		CommonUtility.waitForPageLoadNew(driver, People, 10);
		People.click();

		// CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		CommonUtility.waitForPageLoadNew(driver, Primary, 10);
		Primary.click();

		// CommonUtility.waitForPageLoadNew(driver, Physician, 30);
		CommonUtility.waitForPageLoadNew(driver, Physician, 10);
		jsClickNew(Physician);

		// CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
		// jsClickNew(selectProviderBtn);

		int counter = 0;
		Thread.sleep(10000);
		for (WebElement element : MulitpleSaveBtns) {
			// CommonUtility.waitForPageLoadNew(driver, element, 45);
		//	CommonUtility.waitForPageLoadNew(driver, element, 30);
			Thread.sleep(10000);
			scrollToView(element);
			jsClickNew(element);

			if (validate(selectLocationOption, 10)) {
				// selectLocationOption.click();
				jsClickNew(selectLocationOption);
				validateNew(saveBtn2);
				// saveBtn2.click();
				jsClickNew(saveBtn2);
			}
			/*
			 * New Changes
			 */
			// CommonUtility.waitForPageLoadNew(driver, continueSearching, 45);
			CommonUtility.waitForPageLoadNew(driver, continueSearching, 10);
			// continueSearching.click();
			jsClickNew(continueSearching);

			/*
			 * CommonUtility.waitForPageLoadNew(driver, BtnClose, 45); jsClickNew(BtnClose);
			 */

			counter++;
			if (counter == 9) {
				break;
			}

		}


		/*---------------------Commented the lines as per new changes in rally---------------
			CommonUtility.waitForPageLoadNew(driver, Savedproviders, 10);
		jsClickNew(Savedproviders); 	
		waitForPageLoadSafari();
		
		
		if(driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0){
		System.out.println("OLD Rally page displayed");
		Checkcoverage.click();
		}	
		else
		if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")).size() > 0){
		System.out.println("NEW Rally page displayed");
		//FinishButton.click();
		validateNew(FinishButton);
		jsClickNew(FinishButton);
		}else
		System.out.println("Issue with Xpath");
		---------------------Commented the lines as per new changes in rally---------------*/
		validateNew(FinishButton);
		jsClickNew(FinishButton);
		threadsleep(3);
		// waitForCountDecrement(2);
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		return new VPPPlanSummaryPage(driver);
	}

	public void verifyProviderSearchRallyPageDisplayed() {
		org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("werally"),
				"Provider Search Rally Page is not displayed");
	}

	public void selectYear(String year) {
		if (year.contains("current")) {
			if (validate(currentYrTile)) {
				// currentYrTile.click();
				jsClickNew(currentYrTile);
			} else {
				System.out.println("Current year tile is not present");
			}
		} else {
			if (validate(nextYrTile)) {
				// nextYrTile.click();
				jsClickNew(nextYrTile);
			} else {
				System.out.println("Next year tile is not present");
			}
		}
	}

	public AcquisitionHomePage returnToAcqHomePage() {
		// TODO Auto-generated method stub
		driver.close();
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		return new AcquisitionHomePage(driver);
	}

	@FindBy(xpath = "(//*[@class='remove-provider'])[1]")
	public WebElement removeExistingProvider;

	public void removeExistingProviderIfAny() {
		removeExistingProvider.click();
	}

	public PlanDetailsPage navigatebacktoPlanDetails() {
		// TODO Auto-generated method stub

		CommonUtility.waitForPageLoadNew(driver, FinishReturnButton, 45);
		validateNew(FinishReturnButton);
		jsClickNew(FinishReturnButton);

		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		return new PlanDetailsPage(driver);

	}

	public VisitorProfilePage selectsProviderAndBackToVP() {
		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, MedicalDirectory, 10);
		MedicalDirectory.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		Physician.click();
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption, 10)) {
			jsClickNew(selectLocationOption);
			validateNew(saveBtn2);
			jsClickNew(saveBtn2);
		}
		threadsleep(10);
		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Provider Name is : " + providerSaved);
		MRConstants.PROV_NAME = providerSaved;

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ Viewsavebtn.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		// note: setting the implicit wait to 0 as it fails because of TimeoutException
		// while finding List<WebElement>
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			jsClickNew(Checkcoverage);
		} else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");

		threadsleep(3);
		waitForCountDecrement(2);
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return new VisitorProfilePage(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Add Doctors')]/parent::button")
	private WebElement addDoctor;

	public ProviderSearchPage addDoctor() {
		switchToNewTabNew(addDoctor);
		sleepBySec(15);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}
}
