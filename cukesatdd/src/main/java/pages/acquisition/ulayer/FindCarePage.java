package pages.acquisition.ulayer;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class FindCarePage extends UhcDriver {

	public FindCarePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	@FindBy(xpath = "//span[text()='Find Care']")
	public WebElement FindCareLink;

	@FindBy(xpath = "//button[@class='action-btn getStarted']")
	public WebElement GetstartedButton;

	@FindBy(xpath = "//span[@class='location']")
	public WebElement LocationLink;

	@FindBy(xpath = "//span[text()='Change Location']")
	public WebElement ChangeLocationButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Places')]")
	public WebElement PlacesButton;
	
	@FindBy(xpath = "//*[contains(@data-ui-element-name,'People')]")
	public WebElement PeopleButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Hospitals')]")
	public WebElement HospitalsButton;
	
	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Clinics')]")
	public WebElement ClinicsButton;
	
	@FindBy(xpath = "//*[text()='Primary Care Clinic']")
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
	
	@FindBy(xpath = "//h1//span[text()='Results for ']")
	public WebElement ResultsHeader;

	@FindBy(xpath = "(//*[contains(@data-test-id,'provider-name-link')])[1]")
	public WebElement FirstHospitalRecord;

	@FindBy(xpath = "//Img[@alt='Facility icon']")
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

	@FindBy(xpath = "//header[@class='txtCenter step-header']")
	public WebElement GreatHeaderText;

	@FindBy(xpath = "//button[@data-test-id='button-close']")
	public WebElement ViewSavedButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Saved')]")
	public WebElement SavedHeader;

	@FindBy(xpath = "//h2[@class='provider-name']//a")
	public WebElement SavedProviderName;

	@FindBy(xpath = "(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")
	public WebElement CheckProviderCoverageButton;

	@FindBy(xpath = "(//*[contains(text(),'Edit my Doctor')])[1]")
	public WebElement EditproviderlistLink;
	
	@FindBy(xpath="//a[text()='Edit Doctors']")
	private WebElement editDoctorsLink;
	
	@FindBy(xpath="//a[text()='Edit Hospitals']")
	private WebElement editHospitalsLink;
	
	@FindBy(xpath = "//*[contains(@class,'modal-btns')]//*[contains(text(),'Save')]")
	public WebElement addressSaveButton; 
	
	@FindBy(xpath = "//*[contains(@id,'label_unsaved_selectedLocation0')]")
	public WebElement addressCheckBox;
	
	@FindBy(xpath="//span[text()='Edit Saved']")
	private WebElement EditSavedButton;
	
	@FindBy(xpath="//span[text()='View Saved Providers']")
	private WebElement ViewSavedProvidersLink;
	
	@FindBy(xpath = "(//*[@data-test-id='saved-provider-button'])[1]")
	private WebElement selectProviderBtn;
	
	@FindBy(xpath = "//*[@data-test-id='button-view-saved-provider']")
	private WebElement ViewsaveOldbtn;
	
	@FindBy(xpath = "(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]")
	private WebElement FinishButton;

	public ComparePlansPage getstarted() throws Exception {
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
					driver.manage().window().maximize();
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
			return new ComparePlansPage(driver);
		return null;

	}

public ComparePlansPage providerfromMedicalGroup() throws Exception {
		
		String ParentWindow = null;
		System.out.println("In find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		PeopleButton.click();
		waitforElement(Whoareyoulookingfor);
		MedicalGroupsButton.click();
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("selected Provder Name is : " + HospName);
		validate(Medicalgroupicon);
		selectProviderBtn.click();		
		if(validate(addressCheckBox)){
			addressCheckBox.click();
			addressSaveButton.click();
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
			CheckProviderCoverageButton.click();
		}	
		else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]")).size() > 0){
			System.out.println("NEW Rally page displayed");
			//ParentWindow = driver.getTitle();
			FinishButton.click();
		}else
			System.out.println("Issue with Xpath");
	
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;

	}
	
	public ComparePlansPage providerfromPrimaryCareClinicButton() throws Exception {
		String ParentWindow = null;
		System.out.println("In find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		PlacesButton.click();
		waitforElement(Whichtypeofplace);
		ClinicsButton.click();
		waitforElement(Whichtypeofclinic);
		PrimaryCareClinicButton.click();
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		validate(Facilityicon);
		selectProviderBtn.click();		
		if(validate(addressCheckBox)){
			addressCheckBox.click();
			addressSaveButton.click();
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
			ParentWindow = driver.getTitle();
			CheckProviderCoverageButton.click();
		}	
		else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")).size() > 0){
			System.out.println("NEW Rally page displayed");
			ParentWindow = driver.getTitle();
			FinishButton.click();
		}else
			System.out.println("Issue with Xpath");

		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;

	}
	
	public ComparePlansPage providerfromPrimaryCare() throws Exception {
		String ParentWindow = null;
		validate(GetstartedButton);
		GetstartedButton.click();
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		PeopleButton.click();
		waitforElement(Whoareyoulookingfor);
		PrimaryCareButton.click();
		waitforElement(Whichtypeofprimarycareprovider);
		AllPrimaryCareProviders.click();
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		FirstHospitalRecord.click();
		validate(Providericon);
		selectProviderBtn.click();		
		if(validate(addressCheckBox)){
			addressCheckBox.click();
			addressSaveButton.click();
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
			ParentWindow = driver.getTitle();
			CheckProviderCoverageButton.click();
		}	
		else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]")).size() > 0){
			System.out.println("NEW Rally page displayed");
			ParentWindow = driver.getTitle();
			FinishButton.click();
		}else
			System.out.println("Issue with Xpath");
		checkIfPageReadySafari();
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;

	}
	
	public ComparePlansPage placesfromHospital() throws Exception {
		String ParentWindow = null;
		CommonUtility.waitForPageLoadNew(driver, GetstartedButton, 45);
		GetstartedButton.click();
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		PlacesButton.click();
		CommonUtility.waitForPageLoadNew(driver, HospitalsButton, 30);
		HospitalsButton.click();
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		System.out.println("Text is :: " + HospName);
		FirstHospitalRecord.click();
		validate(Facilityicon);
		selectProviderBtn.click();		
		if(validate(addressCheckBox)){
			addressCheckBox.click();
			addressSaveButton.click();
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
			ParentWindow = driver.getTitle();
			CheckProviderCoverageButton.click();
		}	
		else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")).size() > 0){
			System.out.println("NEW Rally page displayed");
			ParentWindow = driver.getTitle();
			FinishButton.click();
		}else
			System.out.println("Issue with Xpath");
	
		checkIfPageReadySafari();
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;

	}

	
	@Override
	public void openAndValidate() {

		CommonUtility.waitForPageLoadNew(driver, FindCareLink, 30);
		validate(FindCareLink);

	}

}
