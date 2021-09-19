/**
 * 
 */
package pages.acquisition.ole;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;

/**
 * @author sdwaraka
 *
 */
public class WelcomePage extends UhcDriver{

	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']//img")
	private WebElement SiteLogo;

	@FindBy(xpath = "//button[@id='enrollment-next-button']")
	private WebElement NextBtn;

	//@FindBy(xpath = "//*[@class = 'cancel-button modal-link']")
	@FindBy(xpath = "//*[contains(@id,'cancel-enrollment') or contains(@id,'ole-form-cancel-button')]")
	private WebElement CancelEnrollmentLink;

	// WebElements for Welcome Page
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class, 'only-intro')]")
	private WebElement WelcomePageHeader;

	@FindBy(id = "view-learn-enrollment")
	private WebElement LearnMore_Modal;

	@FindBy(xpath = "//*[(contains(@id,'ole-cancel-confirm') or contains(@id,'enroll-cancel-profile')) and contains(@class,'active')]")
	private WebElement CancellationModal;

	@FindBy(id = "leavingSite-linkrouter")
	private WebElement LeavingOLEmodal;

	@FindBy(xpath = "//*[contains(@class,'h3-welcome-class')]")
	private WebElement PlanYear_PlanName;

	@FindBy(xpath = "//strong[contains(text(),'ZIP Code:')]/..")
	private WebElement ZipCode_County;

	@FindBy(xpath = "//strong[contains(text(),'Monthly Premium:')]/..")
	private WebElement PremiumDisplay;

	@FindBy(xpath = "//*[@id = 'learn-more' or @id = 'learnmorebtn']")
	private WebElement LearnMoreButton;

	@FindBy(xpath = "//h1[contains(text(),'Medicare Insurance Information')]")
	private WebElement welcomepageHeader;

	/*	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']")
	private WebElement DisclaimerAgreeCheckBx;
	 */
	//@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']/following-sibling::label")
	@FindBy(xpath = "//*[@id='enrollment-disclaimer-accept-yes']")
	private WebElement DisclaimerAgreeSelect;

	//Right Rail Elements

	//	@FindBy(id = "//*[contains(text(),'Need Help? Call')]/u")
	@FindBy(xpath = "//*[contains(@class,'tel tfn')]")
	private WebElement TFNNoWidget;
	
	@FindBy(xpath = "//u[contains(@class,'tel')]")
	private WebElement TFNNoNeedHelp;
	
	@FindBy(xpath = "(//u[contains(@class,'tel')])[2]")
	private WebElement TFNNoSaveWelcomeOLE;	

	@FindBy(xpath = "//*[text()='Coverage Details']")
	private WebElement CoverageDetailswdt;

	@FindBy(xpath = "//li[contains(text(), normalize-space('Dental'))]//img")
	private WebElement DentalImg;

	@FindBy(xpath = "//li[contains(text(), normalize-space('Vision'))]//img")
	private WebElement VisionImg;

	@FindBy(xpath = "//li[contains(text(), normalize-space('Fitness'))]//img")
	private WebElement FitnessImg;

	@FindBy(xpath = "//li[contains(text(), normalize-space('Hearing'))]//img")
	private WebElement HearingImg;

	@FindBy(xpath = "//*[@id='ole-form-content']//a[contains(@href,'pharmacy.html')]")
	private WebElement pharmacyLink;

	@FindBy(xpath = "//a[contains(text(),'Enrollment Checklist - English (PDF)')]")
	private WebElement EnrollmentChecklistLink;

	@FindBy(xpath = "//a[contains(text(),'Lista de Verificación de Inscripción (PDF)')]")
	private WebElement ListaVerificationLink;
	
	@FindBy(xpath = "//*[contains(@title,'Privacy Policy')]")
	private WebElement PrivacyPolicy;
	
	@FindBy(xpath="//button[contains(@class,'button-primary proactive-offer__button main-background-color second-color proactive-offer__close')]")
	public WebElement proactiveChatExitBtn;
	
	@FindBy(xpath="//button[contains(@id,'ip-no')]")
	public WebElement AccessibilityButton;
	
	//@FindBy(xpath="//*[contains(text(),'View Plan Details')]")
	@FindBy(xpath="//*[contains(@class,'view-plan-link')]")
	public WebElement ViewPlanDetails;
	
	
	@FindBy(xpath = "(//a[contains(@id,'save-return-button')])[1]")
	private WebElement SaveEnrollmentLinkOLE;		
	@FindBy(xpath = "(//div[contains(@id,'enroll-save-popup')])[1]")
	private WebElement SaveModalOLE;

	@FindBy(xpath = "(//a[contains(text(),'Create a Profile')])[1]")
	private WebElement CreateProfilesave;

	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
	private WebElement SaveSignIn;

	@FindBy(xpath = "(//a[contains(@class,'oleClose')])[1]")
	private WebElement Saveclosepopup;
	
	@FindBy(xpath = "(//input[contains(@id,'DentalPlatinum_selectedRiders')]/../label)[1]")
	private WebElement Ridersoption_Yes;
	
	@FindBy(xpath = "(//input[contains(@id,'N_selectedRiders')]/../label)[1]")
	private WebElement Ridersoption_No;
	
	@FindBy(xpath = "(//a[contains(@class,'sitelogo')])[1]")
	private WebElement LogoImage;
	
	@FindBy(xpath = "//button[contains(@id,'proceed')]")
	private WebElement LeaveOnlineApplication;
	
	@FindBy(xpath = "//button[contains(@id,'leaveOleAlertBack')]")
	private WebElement OLEImageBackButton;
	
	@FindBy(xpath = "(//div[contains(@id,'leavingSite')])[1]")
	private WebElement LogoModalOLE;
	
	@FindBy(xpath = "//*[contains(@id,'olesections')]")
	private WebElement WidgetsImage;
	
	@FindBy(xpath = "//*[contains(@id,'oleStickyHeader')]")
	private WebElement OLEStickyHeader;
	
	@FindBy(xpath = "//*[contains(@class,'sticky-planname')]")
	private WebElement OLEStickyPlanName;
	
	@FindBy(xpath = "//*[contains(@class,'ole-progress-bar')]")
	private WebElement OLEProgressBar;
	
	@FindBy(xpath = "//*[contains(@class,'invoca_swap tel ng-binding')]")
	private WebElement VPPTFNNo;
	
	public WelcomePage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public WelcomePage(WebDriver driver, String OLE_URL) {
		super(driver);
		PageFactory.initElements(driver, this);
		start(OLE_URL);

		openAndValidate();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {

		System.out.println("Validating Welcome Page for OLE");
		if (MRScenario.environment.equals("offline") || MRScenario.environment.equals("prod"))
			checkModelPopup(driver, 30);
		/*else 
			checkModelPopup(driver,10);*/
		validateNew(WelcomePageHeader);
		validateNew(PlanYear_PlanName);
	}

	
	
	public boolean validate_plan_details(Map<String, String> planDetailsMap) throws InterruptedException {
		boolean flag = false;
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		String StickyPlanName = OLEStickyPlanName.getText();
		
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code is Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		System.out.println("OLEStickyPlanName Displayed on welcome OLE : "+StickyPlanName);
		
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_Premium = planDetailsMap.get("Plan Premium");
		String Expected_PlanType = planDetailsMap.get("Plan Type");
		
		
		if(validateNew(ViewPlanDetails)){
			ViewPlanDetails.click();
			Thread.sleep(500);
			flag = driver.getCurrentUrl().contains("details");
			if(flag){
				
				validateNew(VPPTFNNo);
				System.out.println("TFN in VPP Right Rail : "+VPPTFNNo);
				String VPPTFNNoActual = VPPTFNNo.getText();
				System.out.println("TFN in VPP Right Rail TEXT : "+VPPTFNNoActual);
				CheckiPerseptions();
				String elementPath = "//*[not(contains(@class,'ng-hide')) and contains(text(), 'Enroll in plan')]";
				WebElement enrollInPlan = driver.findElement(By.xpath(elementPath));
				enrollInPlan.click();
				Thread.sleep(500);
				flag = driver.getCurrentUrl().contains("welcome");
				CheckiPerseptions();
				if (flag){
					flag = PlanYear_PlanName_Text.contains(Expected_PlanName)
							&& Zip_County_Text.contains(Expected_ZipCode) && Premium.contains(Expected_Premium) && StickyPlanName.contains(Expected_PlanName);
				}

			}
		}
		
		System.out.println("Plan Details are Validated : "+flag);
		return flag;
			
	}

	
	public boolean ValidateTFNonWelcomeOLE(String TFN) {
		//TFN no  above the continue button
		
		boolean flag = false;
		
		String TFNWidget_OLE = TFNNoWidget.getText();
		String TFNNeedHelp_OLE = TFNNoNeedHelp.getText();
			
		
		System.out.println("TFN in OLE Right Rail : "+TFNNeedHelp_OLE);
		System.out.println("TFN in OLE Right Rail : "+TFNWidget_OLE);
		
		//String Expected_TFN = planDetailsMap.get("TFN");
		
		System.out.println("TFN in VPP page : "+TFN);
				flag = driver.getCurrentUrl().contains("welcome");
				CheckPageLoad();
				CheckiPerseptions();
				if (flag){
					flag = TFNWidget_OLE.contains(TFN) && TFNNeedHelp_OLE.contains(TFN);
				}			
		
		System.out.println("TFN not displayed in OLE right rail"+flag);
		return flag;
		
		
	}
	
	public boolean ValidateTFNOLEPages(Map<String, String> planDetailsMap) {
		//TFN no  above the continue button
		
		boolean flag = false;
		
		String TFNWidget_OLE = TFNNoWidget.getText();
		System.out.println("TFN in OLE Right Rail : "+TFNWidget_OLE);
		
		String Expected_TFN = planDetailsMap.get("TFN");
		
		System.out.println("TFN in VPP page : "+Expected_TFN);
			//	flag = driver.getCurrentUrl().contains("welcome");
				if (flag){
				//	flag = TFNWidget_OLE.contains(Expected_TFN);
				}			
		
		System.out.println("TFN not displayed in OLE right rail"+flag);
		return flag;		
		
	}

	public PersonalInformationPage navigate_to_Personal_Information_page() {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		//if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Personal')]")))){		
		if(validateNew(driver.findElement(By.xpath("//*[contains(text(),'Personal')]")))){
			System.out.println("OLE Personal Information Page is Displayed");
			validate(OLEProgressBar);
			OLEProgressBar.isDisplayed();
			return new PersonalInformationPage(driver);
		}
		return null;
	}

	public MedicareInformationPage navigate_to_medicare_info_page_PDP() {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(welcomepageHeader)){ 
			System.out.println("OLE Medicare Information Page is Displayed");
			return new MedicareInformationPage(driver);
		}
		return null;
	}

	public LearnMoreModal OpenLearnMore() {
		if(MRScenario.environment.equalsIgnoreCase("offline")||MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver);
		validate(LearnMoreButton);
		jsClickNew(LearnMoreButton);
		//		LearnMoreButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(LearnMore_Modal)){
			System.out.println("OLE Learn More Modal is Displayed");
			return new LearnMoreModal(driver);
		}
		return null;
	}

	public void CheckiPerseptions() {
		CommonUtility.waitForPageLoad(driver, AccessibilityButton, 20); // do not change this to waitForPageLoadNew as
																			// we're not trying to fail the test if it
																			// isn't found
		try {
			if (AccessibilityButton.isDisplayed())
				jsClickNew(AccessibilityButton);
		} catch (Exception e) {
			System.out.println("Accessibility Button popup not displayed");
		}
	}	
	private void CheckPageLoad() {
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		if(MRScenario.environment.equalsIgnoreCase("offline")||MRScenario.environment.equalsIgnoreCase("prod"))
			checkModelPopup(driver, 10);
	
	}
	public CancelOLEModal OpenCancelOLE() {
		CheckPageLoad();
		CheckiPerseptions();
		validate(CancelEnrollmentLink);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelEnrollmentLink);

		//((JavascriptExecutor) driver).executeScript("arguments[0].click;", CancelEnrollmentLink);

		//CancelEnrollmentLink.click();
		/*try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		//CheckPageLoad();
		CheckiPerseptions();
		if(validate(CancellationModal,20)){
		
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			return new CancelOLEModal(driver);
		}
		return null;
	}

	public LeavingOLEmodal OpenLeaveOLEmodal() {
		CheckiPerseptions();
		validate(SiteLogo);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SiteLogo);
		//SiteLogo.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(validate(LeavingOLEmodal)){
			System.out.println("Leaving OLE modal is Displayed");
			return new LeavingOLEmodal(driver);
		}
		return null;
	}

	public void validateBenefits(boolean riderFlag, WebElement riderBenefit) throws Exception {

		if (riderFlag) {
			for (int i = 0; i <= 5; i++) {
				try {
					waitforElement(riderBenefit);
					validate(riderBenefit);
					Assertion.assertTrue("Rider Benefit is not available for this plan",
							riderBenefit.getAttribute("class").contains("benefitAvailable"));
					System.out.println("Benfit is Available");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("TestWarning: Unable to find element : Retry Count - " + i);
			}

		} else {
			for (int i = 0; i <= 5; i++) {
				try {
					waitforElement(riderBenefit);
					validate(riderBenefit);
					Assertion.assertTrue("Rider Benefit is available for this plan",
							riderBenefit.getAttribute("class").contains("benefitUnavailable"));
					System.out.println("Benfit is UnAvailable");
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("TestWarning: Unable to find element : Retry Count - " + i);
			}
		}
	}


	public void validate_Ancillary_Benefits(String DentalFlag, String VisionFlag,String FitnessFlag,String HearingFlag) throws Exception {
		boolean di = Boolean.parseBoolean(DentalFlag);
		boolean vi = Boolean.parseBoolean(VisionFlag);
		boolean fi = Boolean.parseBoolean(FitnessFlag);
		boolean hi = Boolean.parseBoolean(HearingFlag);

		waitforElement(CoverageDetailswdt);
		validate(CoverageDetailswdt);
		validateBenefits(di, DentalImg);		
		validateBenefits(vi, VisionImg);
		validateBenefits(fi, FitnessImg);
		validateBenefits(hi, HearingImg);	
	}

	public boolean validateNextButtonIsClickable() {

		boolean enrollInNotPossible = false;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(NextBtn));
			enrollInNotPossible = true;
			return enrollInNotPossible;
		}
		catch (Exception e)
		{
			return enrollInNotPossible;
		}		
	}

	public ArrayList<String> validate_marketing_details(String planName) {

		ArrayList<String> marketingBulletDetails = new ArrayList<String>();
		List<WebElement> marketingBullets = driver.findElements(By.xpath("//*[@id='ole-form-content']//*[@class='bullet-div']//*[@id='bullets-sub-header']//following-sibling::div//ul[@class='marketing-bullets']//li"));

		for(WebElement element:marketingBullets)
		{
			String marketingDetails = element.getText().trim();
			marketingBulletDetails.add(marketingDetails);
		}

		return marketingBulletDetails;

	}

	public MedicareInformationPage navigate_to_medicare_info_page() {

		validateNew(NextBtn);
		NextBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Medicare')]")))){			
			System.out.println("OLE Medicare Information Page is Displayed");
			validate(OLEProgressBar);
			OLEProgressBar.isDisplayed();
			return new MedicareInformationPage(driver);
		}
		return null;
	}

	public PharmacySearchPage clickPharamcyLinkAndSwitchTab() {
		/*pharmacyLink.click();
		switchToNewTab();*/
		switchToNewTabNew(pharmacyLink);
		if (driver.getCurrentUrl().contains("health-plans/aarp-pharmacy.html#/Pharmacy-Search-English")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void ValidateFooterEnrollmentChecklistLink()  throws InterruptedException, IOException{

		validateNew(EnrollmentChecklistLink);
		CommonUtility.waitForPageLoadNew(driver, EnrollmentChecklistLink, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(EnrollmentChecklistLink);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		URL TestURL = new URL(driver.getCurrentUrl());
		BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
		PDDocument document = PDDocument.load(TestFile);
		/*PDFParser TestPDF = new PDFParser(document);
			TestPDF.parse();*/
		String PDFText = new PDFTextStripper().getText(document);
		String ExpectedPDFText = "Enrollment Checklist";
		String ExpectedPDFText1 = "Understanding the Benefits";
		String ExpectedPDFText2 = "Understanding Important Rules";
		if(PDFText.contains(ExpectedPDFText) && PDFText.contains(ExpectedPDFText1) && PDFText.contains(ExpectedPDFText2)){
			System.out.println("PASSED - PDF : text contains expected Document code : "+ExpectedPDFText);
		}
		else{
			System.out.println("FAILED - PDF: text DOES NOT contains expected Document code : "+ExpectedPDFText);
			if(PDFText.contains("PDF coming soon")) {

			}
		}

		driver.close();
		driver.switchTo().window(parentWindow);

	}

	public void ValidateFooterListaVerificationLink() throws InterruptedException, IOException {

		validateNew(ListaVerificationLink);
		CommonUtility.waitForPageLoadNew(driver, ListaVerificationLink, 30);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(ListaVerificationLink);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				break;
			}
		}

		//	try {
		URL TestURL = new URL(driver.getCurrentUrl());
		BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
		PDDocument document = PDDocument.load(TestFile);
		/*PDFParser TestPDF = new PDFParser(document);
			TestPDF.parse();*/
		String PDFText = new PDFTextStripper().getText(document);
		String ExpectedPDFText = "Lista de Verificaci6n de lnscripci6n";
		String ExpectedPDFText1 = "Explicaci6n de los beneficios";
		String ExpectedPDFText2 = "Explicaci6n de las reglas importantes";
		if(PDFText.contains(ExpectedPDFText) && PDFText.contains(ExpectedPDFText1) && PDFText.contains(ExpectedPDFText2)){
			System.out.println("PASSED - PDF : text contains expected Document code : "+ExpectedPDFText);
			Assertion.assertTrue(true);
		}
		else{
			System.out.println("FAILED - PDF: text DOES NOT contains expected Document code : "+ExpectedPDFText);
			if(PDFText.contains("PDF coming soon")) {

				Assertion.fail("****************Lista Verification page is not loaded ***************");

			}
		}
		/*	} catch (MalformedURLException e) {
			 System.out.println("FAILURE, Exception in Reading PDF");
		} catch (IOException e) {
			 System.out.println("FAILURE, Exception in Reading PDF");
		}*/
		driver.close();
		driver.switchTo().window(parentWindow);

	}
		
	public SaveandReturnOLEModal OpensavereturnOLEPages() {
		validate(SaveEnrollmentLinkOLE);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SaveEnrollmentLinkOLE);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click;", CancelEnrollmentLink);
		
		//CancelEnrollmentLink.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(validate(SaveModalOLE)){
			System.out.println("OLE Cancel Enrollment Modal is Displayed");
			validate(CreateProfilesave);
			CreateProfilesave.isDisplayed();
			validate(SaveSignIn);
			SaveSignIn.isDisplayed();
			Saveclosepopup.isDisplayed();
		String TFNNoSaveWelcome_OLE = TFNNoSaveWelcomeOLE.getText();
			System.out.println("TFN in OLE ExitModels : "+TFNNoSaveWelcome_OLE);
			jsClickNew(Saveclosepopup);
			validate(OLEStickyHeader);
			OLEStickyHeader.isDisplayed();
			validate(OLEStickyPlanName);
			validate(OLEProgressBar);
			OLEProgressBar.isDisplayed();
			
			return new SaveandReturnOLEModal(driver);
		}
		return null;
	}
	
	public Map<Boolean, String> validate_Supplemental_Riders(String riderflag) {
		boolean flag=false;
		String riderText = null;
		HashMap map = new HashMap<Boolean,String>();
		String elementPath = "//*[contains(text(),'Optional Supplemental Benefits')]";
		WebElement benefit = driver.findElement(By.xpath(elementPath));
		flag = validateNew(benefit);
		if(flag){
			flag = validateNew(Ridersoption_Yes) && validateNew(Ridersoption_No);
			if(flag && riderflag.equalsIgnoreCase("true_yes")){
				jsClickNew(Ridersoption_Yes);
				riderText = Ridersoption_Yes.getText().trim();
			}else{
				jsClickNew(Ridersoption_No);
				riderText = Ridersoption_No.getText().trim();
			}
		}
		map.put(flag,riderText);
		return map;
	}
	
	public String GetMonthlyPremiumValue() {
		
		if (validateNew(PremiumDisplay, 45)) {
		//	System.out.println("Monthly Premium is displayed on Welcome OLE Page");
			String Monthly_Premium = PremiumDisplay.getText();
			System.out.println("Monthly Premium is displayed on Welcome OLE Page" +Monthly_Premium );
			return Monthly_Premium;
		}
		System.out.println("Monthly Premium is not displayed on Welcome OLE Page");

		return null;
	}
	public boolean validate_plan_details_CSNP(Map<String, String> planDetailsMap) throws InterruptedException {
		boolean flag = false;
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		String StickyPlanName = OLEStickyPlanName.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code is Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		System.out.println("OLE Sticky PlanName on Welcome OLE Page : "+StickyPlanName);
		
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_Premium = planDetailsMap.get("Plan Premium");
		String Expected_PlanType = planDetailsMap.get("Plan Type");
		
	
		
				flag = driver.getCurrentUrl().contains("welcome");
				if (flag){
					flag = PlanYear_PlanName_Text.contains(Expected_PlanName)
							&& Zip_County_Text.contains(Expected_ZipCode) && Premium.contains(Expected_Premium) && StickyPlanName.contains(Expected_PlanName);
				}			
		
		System.out.println("WELCOME OLE Page are Validated : "+flag);
		return flag;
			
	}
	public WelcomePage ValidateLogoonWelcomeOLE() {
		validate(LogoImage);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", LogoImage);
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(validate(LogoModalOLE)){
			System.out.println("OLE logo modalis Displayed");
			validate(LeaveOnlineApplication);
			LeaveOnlineApplication.isDisplayed();
			validate(OLEImageBackButton);
			OLEImageBackButton.isDisplayed();			
			jsClickNew(OLEImageBackButton);
			
			return new WelcomePage(driver);
		}
		return null;
	}
	
	public boolean ValidateTFNExitModels(String ExpectedTFNNo) {
	
		boolean flag = false;
		
		String TFNNoNeedHelp_OLE = TFNNoNeedHelp.getText();
		System.out.println("TFN in OLE ExitModels : "+TFNNoNeedHelp_OLE);
		
	//	String Expected_TFN = planDetailsMap.get("TFN");
		
		System.out.println("TFN in VPP page : "+ExpectedTFNNo);
				if (flag){
					flag = TFNNoNeedHelp_OLE.contains(ExpectedTFNNo);
				}			
		return flag;		
		
	}
	
	public WelcomePage ValidateWidgetsonWelcomeOLE(String ExpectedTFNNo) {
		validate(WidgetsImage);
		if(validate(WidgetsImage)){
			System.out.println("OLE Widgets Image is Displayed");
			String TFNNoWidget_OLE = TFNNoWidget.getText();
			System.out.println("TFN in OLE ExitModels : "+TFNNoWidget_OLE);
		
			System.out.println("TFN in VPP page : "+ExpectedTFNNo);
			System.out.println("TFN No is validated"+TFNNoWidget_OLE.contains(ExpectedTFNNo));			
			validateNew(PrivacyPolicy);
			CommonUtility.waitForPageLoadNew(driver, PrivacyPolicy, 30);
			String parentWindow = driver.getWindowHandle();
			jsClickNew(PrivacyPolicy);
			sleepBySec(3);
			Set<String> tabs_windows = driver.getWindowHandles();
			Iterator<String> itr = tabs_windows.iterator();
			while (itr.hasNext()) {
				String window = itr.next();
				if (!parentWindow.equals(window)) {
					driver.switchTo().window(window);
					break;
				}
			}

			CommonUtility.checkPageIsReadyNew(driver);
			String CurrentPageURL = driver.getCurrentUrl();
			System.out.println(" Page is displayed : " + CurrentPageURL);
			
			if (CurrentPageURL.contains("privacy-policy.html")) {
				System.out.println("****************privacy policy is displayed  ***************");

				Assertion.assertTrue(true);
			} else {
				Assertion.fail("****************privacy policy is not loaded ***************");
			}
			driver.close();
			driver.switchTo().window(parentWindow);
			
			return new WelcomePage(driver);
		}
		return null;
	}
}