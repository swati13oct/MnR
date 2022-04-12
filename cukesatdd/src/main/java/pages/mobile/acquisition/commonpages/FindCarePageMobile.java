package pages.mobile.acquisition.commonpages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.ComparePlansPage;

public class FindCarePageMobile extends UhcDriver {

	public FindCarePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();

	}

	@FindBy(xpath = "//span[text()='Find Care']")
	public WebElement FindCareLink;
	
	@FindBy(xpath = "//div[@id='urgentCareNode']")
	public WebElement FindUrgentCareLink;

	@FindBy(xpath = "//button[@class='action-btn getStarted']")
	public WebElement GetstartedButton;

	@FindBy(xpath = "//*[@class='location']")
	public WebElement LocationLink;

	@FindBy(xpath = "//span[text()='Change Location']")
	public WebElement ChangeLocationButton;

	@FindBy(xpath="//*[contains(@data-test-id,'MedicalDirectory')]")
	private WebElement MedicalDirectory;

	@FindBy(css = "button[data-test-id='BehavioralHealthDirectory']")
	private WebElement BehavioralHealthDirectory;

	@FindBy(css = "button[data-test-id='DentalHealthDirectory']")
	private WebElement DentalDirectory;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Places')]")
	public WebElement PlacesButton;
	
	@FindBy(xpath = "//*[contains(@data-ui-element-name,'People')]")
	public WebElement PeopleButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Hospitals')]")
	public WebElement HospitalsButton;
	
	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Clinics')]")
	public WebElement ClinicsButton;
	
//	@FindBy(xpath = "//*[text()='Primary Care Clinic']")
	@FindBy(css = "button[data-test-id='PrimaryCareClinic']")
	public WebElement PrimaryCareClinicButton;
	
	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Medical Groups')]")
	public WebElement MedicalGroupsButton;
	
	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Primary Care')]")
	public WebElement PrimaryCareButton;

	@FindBy(xpath = "//h1[text()='Which type of place?']")
	public WebElement Whichtypeofplace;
	
	@FindBy(xpath = "//h1[text()='Who are you looking for?']")
	public WebElement Whoareyoulookingfor;
	
	@FindBy(xpath = "//h1[text()='Which type of clinic?']")
	public WebElement Whichtypeofclinic;
	
	
	@FindBy(xpath = "//h1[text()='Which type of primary care provider (PCP)?']")
	public WebElement Whichtypeofprimarycareprovider;
	
	@FindBy(xpath = "//button[text()='All Primary Care Providers']")
	public WebElement AllPrimaryCareProviders;
	
	@FindBy(xpath = "//h1//span[text()='Results for']")
	public WebElement ResultsHeader;

	@FindBy(xpath = "(//*[contains(@data-test-id,'provider-name-link')])[1]")
	public WebElement FirstHospitalRecord;

	@FindBy(css = "[id$='bioTab']")
	private WebElement providerDetailOverviewTab;

	@FindBy(xpath = "(//Img[@alt='Facility icon'])[2]")
	public WebElement Facilityicon;
	
	@FindBy(xpath = "//Img[@alt='Medical group icon']")
	public WebElement Medicalgroupicon;
	
	@FindBy(xpath = "//Img[@alt='Provider icon']")
	public WebElement Providericon;
	
	@FindBy(xpath = "//h1[@class='heading']")
	public WebElement PlanHeading;

	@FindBy(xpath = "//button[contains(@class,'cta-header-button')]//span[text()='Save']")
	public WebElement SaveButton;

	@FindBy(xpath = "//h1[@class='provider-name']")
	public WebElement ProviderNameHeader;

	@FindBy(xpath = "//header[contains(@class,'txtCenter step-header')]")
	public WebElement GreatHeaderText;

	@FindBy(xpath = "//button[@data-test-id='button-close']")
	public WebElement ViewSavedButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Saved')]")
	public WebElement SavedHeader;

	@FindBy(xpath = "//h2[@class='provider-name']//a")
	public WebElement SavedProviderName;

	@FindBy(xpath="(//*[contains(text(),'Check Provider Coverage')])[1]")
	public WebElement CheckProviderCoverageButton;

	@FindBy(xpath = "(//*[contains(text(),'Edit my Doctor')])[1]")
	public WebElement EditproviderlistLink;
	
	@FindBy(xpath="//a[text()='Edit Doctors']")
	private WebElement editDoctorsLink;
	
	@FindBy(xpath="//a[text()='Edit Hospitals']")
	private WebElement editHospitalsLink;
	
	@FindBy(xpath="//*[contains(@class,'modal-btns')]//*[contains(text(),'Save')]")
	public WebElement addressSaveButton; 
	
	@FindBy(xpath = "//*[contains(@id,'label_unsaved_selectedLocation0')]")
	public WebElement addressCheckBox;
	
	@FindBy(xpath="//span[text()='Edit Saved']")
	private WebElement EditSavedButton;
	
	@FindBy(xpath="//span[text()='View Saved Providers']")
	private WebElement ViewSavedProvidersLink;
	
	@FindBy(xpath = "(//*[@data-test-id='saved-provider-button'])[2]")
	private WebElement selectProviderBtn;

	@FindBy(css = "div[class$='mobile-profile-header-buttons'] .saved-provider-button")
	private WebElement selectProviderButtonOverviewTab;

	@FindBy(xpath = "//*[@data-test-id='button-view-saved-provider']")
	private WebElement ViewsaveOldbtn;
	
//	@FindBy(xpath = "(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]")
	@FindBy(xpath = "//button[@id='finishAndReturnButton']")
	private WebElement FinishButton;
	
	@FindBy(xpath = "//button[contains(@class,'action-btn ally-focus')]")
	private WebElement saveBtn;

	public ComparePlansPageMobile getstarted() throws Exception {
		validate(GetstartedButton);
		GetstartedButton.click();
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		PlacesButton.click();
		waitforElement(Whichtypeofplace);
		HospitalsButton.click();
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		FirstHospitalRecord.click();
		validate(Facilityicon);
		if (HospName.equals(PlanHeading.getText())) {
			System.out.println("Provder Name is verified :: " + HospName);
		}
		SaveButton.click();
		waitforElement(ProviderNameHeader);
		String ProvName = ProviderNameHeader.getText();
		if (HospName.equals(ProvName)) {
			System.out.println("Provder Name is verified");
		} else {
			System.out.println("selected Provder Name is not matching");
		}
		
		if(validate(addressCheckBox)){
			addressCheckBox.click();
			addressSaveButton.click();
		}
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);
		ViewSavedButton.click();
		if(validate(EditSavedButton)){
			ViewSavedProvidersLink.click();
		}
		waitforElement(SavedHeader);
		if (HospName.equals(SavedProviderName.getText())) {
			System.out.println("Provder Name is verified :: " + HospName);
		}
		String ParentWindow = driver.getTitle();
		CheckProviderCoverageButton.click();
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Compare Medicare Plans")) {
					System.out.println("We are on Compare Medicare Plans winodow opened");
					//driver.manage().window().maximize();
					Thread.sleep(3000);
					waitforElement(EditproviderlistLink);
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}

public ComparePlansPageMobile providerfromMedicalGroup() throws Exception {
		
		String ParentWindow = null;
		System.out.println("In find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);

		jsClickNew(MedicalDirectory);
		waitforElement(PeopleButton);

		jsClickNew(PeopleButton);
		waitforElement(Whoareyoulookingfor);

		jsClickNew(MedicalGroupsButton);
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("selected Provder Name is : " + HospName);
		validate(Medicalgroupicon);
			
		jsClickNew(selectProviderBtn);
		if(validate(addressCheckBox)){
			jsClickNew(addressCheckBox);
			jsClickNew(addressSaveButton);
		}
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);
		
		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ ViewSavedButton.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		
		if(driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0){
			System.out.println("OLD Rally page displayed");
			//ParentWindow = driver.getTitle();
			jsClickNew(CheckProviderCoverageButton);
		}	
		/*else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]"))
				.size() > 0) {*/
		else if (driver.findElements(By.cssSelector("#finishAndReturnButton")).size() > 0) {
			System.out.println("NEW Rally page displayed");
			//ParentWindow = driver.getTitle();
			jsClickNew(FinishButton);
		}else
			System.out.println("Issue with Xpath");
	
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}
	
	public ComparePlansPageMobile providerfromPrimaryCareClinicButton() throws Exception {
		String ParentWindow = null;
		System.out.println("In find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		jsClickNew(MedicalDirectory);
		waitforElement(PlacesButton);
		jsClickNew(PlacesButton);
		waitforElement(Whichtypeofplace);
		jsClickNew(ClinicsButton);
		waitforElement(Whichtypeofclinic);
		jsClickNew(PrimaryCareClinicButton);
		waitforElementNew(ResultsHeader, 20);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		validate(Facilityicon);
		jsClickNew(selectProviderBtn);
		if (validate(addressCheckBox)) {
			jsClickNew(addressCheckBox);
			jsClickNew(addressSaveButton);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement GreatHeaderText = driver.findElement(By.xpath("//header[contains(@class,'txtCenter step-header')]"));
		CommonUtility.waitForPageLoadNew(driver, GreatHeaderText, 15);
		scrollToView(GreatHeaderText);
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ ViewSavedButton.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // Added because below findelements throws
																		// timeout exception if element not found
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(CheckProviderCoverageButton);
		}
		/*else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {*/
		else if (driver.findElements(By.cssSelector("#finishAndReturnButton")).size() > 0) {
			System.out.println("NEW Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");
		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}
	
	public ComparePlansPageMobile providerfromPrimaryCare() throws Exception {
		String ParentWindow = null;
		validate(GetstartedButton);
		jsClickNew(GetstartedButton);
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		jsClickNew(MedicalDirectory);
		CommonUtility.waitForPageLoadNew(driver, PeopleButton, 30);
		jsClickNew(PeopleButton);
		waitforElement(Whoareyoulookingfor);
		jsClickNew(PrimaryCareButton);
		waitforElement(Whichtypeofprimarycareprovider);
		jsClickNew(AllPrimaryCareProviders);
		waitforElementNew(ResultsHeader, 20);
		
		scrollToView(FirstHospitalRecord);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		jsClickNew(FirstHospitalRecord);
		CommonUtility.checkPageIsReadyNew(driver);

		validate(Providericon);
		jsClickNew(providerDetailOverviewTab);

		waitforElementNew(selectProviderButtonOverviewTab, 20);
		jsClickNew(selectProviderButtonOverviewTab);
		CommonUtility.checkPageIsReadyNew(driver);
		
		if (validate(addressCheckBox)) {
			jsClickNew(addressCheckBox);
			jsClickNew(addressSaveButton);
		}



		CommonUtility.checkPageIsReadyNew(driver);
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // Added because below findelements throws
																		// timeout exception if element not found
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(CheckProviderCoverageButton);
		}
		/*else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]"))
				.size() > 0) {*/
		else if (driver.findElements(By.cssSelector("#finishAndReturnButton")).size() > 0) {
			System.out.println("NEW Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");
		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}
	
	@FindBy(css = "[class$='mobile-profile-header-buttons'] button[data-test-id='saved-provider-button']")
	private WebElement selectThisProviderHospitalButton;
	public ComparePlansPageMobile placesfromHospital() throws Exception {
		String ParentWindow = null;
		try {
			if(GetstartedButton.isDisplayed())
				jsClickNew(GetstartedButton);
		}
		catch(Exception e) {
			
		}
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		jsClickNew(MedicalDirectory);
		CommonUtility.waitForPageLoadNew(driver, PlacesButton, 30);
		jsClickNew(PlacesButton);
		CommonUtility.waitForPageLoadNew(driver, HospitalsButton, 30);
		jsClickNew(HospitalsButton);
		waitforElementNew(ResultsHeader, 20);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		jsClickNew(FirstHospitalRecord);
		CommonUtility.checkPageIsReadyNew(driver);
		jsClickNew(selectThisProviderHospitalButton);
		if (validate(addressCheckBox)) {
			jsClickNew(addressCheckBox);
			jsClickNew(addressSaveButton);
		}


		CommonUtility.checkPageIsReadyNew(driver);
		WebElement GreatHeaderText = driver.findElement(By.xpath("//header[contains(@class,'txtCenter step-header')]"));
		CommonUtility.waitForPageLoadNew(driver, GreatHeaderText, 15);
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);

		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ ViewSavedButton.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // Added because below findelements throws
																		// timeout exception if element not found
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(CheckProviderCoverageButton);
		}
		/*else if (driver.findElements(By.xpath(
				"(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]"))
				.size() > 0) {*/
		else if (driver.findElements(By.cssSelector("#finishAndReturnButton")).size() > 0) {
			ParentWindow = driver.getTitle();
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");
		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}

	
	@Override
	public void openAndValidate() {

		CommonUtility.waitForPageLoadNew(driver, LocationLink, 30);
		validateNew(LocationLink);

	}
	
	public ComparePlansPageMobile HospitalPlaces() throws Exception {
		String ParentWindow = null;
		CommonUtility.waitForPageLoadNew(driver, LocationLink, 45);
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		jsClickNew(MedicalDirectory);
		jsClickNew(PlacesButton);
		CommonUtility.waitForPageLoadNew(driver, HospitalsButton, 30);
		jsClickNew(HospitalsButton);
		waitforElementNew(ResultsHeader, 20);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		jsClickNew(FirstHospitalRecord);
		validate(Facilityicon);
		jsClickNew(selectProviderBtn);
		if (validate(addressCheckBox)) {
			jsClickNew(addressCheckBox);
			jsClickNew(addressSaveButton);
		}
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		
		if (driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0) {
			System.out.println("OLD Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(CheckProviderCoverageButton);
		} else if (driver
				.findElements(By
						.xpath("//form[@data-ui-element-name='check-provider-coverage']//button[contains(@id,'finishAndReturnButton')]"))
				.size() > 0) {
			System.out.println("NEW Rally page displayed");
			ParentWindow = driver.getTitle();
			jsClickNew(FinishButton);
		} else
			System.out.println("Issue with Xpath");
		// note: setting the implicit wait back to default value - 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPageMobile(driver);
		return null;

	}

}
