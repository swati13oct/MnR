
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;

public class PlanRecommendationEngineDoctorsPage extends UhcDriver {

	public PlanRecommendationEngineDoctorsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Doctor";

	PlanRecommendationEngineWerallyPage werally = new PlanRecommendationEngineWerallyPage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	ArrayList<String> confirmationSpecialtyResults = new ArrayList<String>();

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

// Doctors page Elements

	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(xpath = "//*[@class='progress-bar-info']/h2")
	private WebElement pageStepsNumberName;

	@FindBy(xpath = "//*[@class='progress-bar-info']/p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div.row.pb-1>div>uhc-radio-group>fieldset>legend.primary-question-tex")
	private WebElement doctorsTitle;

	@FindBy(xpath = "//label[@class='radio-label']/input[contains(text(),'network')]")
	private WebElement SelectDoctors;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "p.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label>span.radio-label-content")
	private WebElement innetwork;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement outnetwork;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
	private WebElement mydoctors;

	@FindBy(css = "#errorMessage>div:nth-child(2)")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[contains(@class,'radio-checked')]")
	private WebElement radioselect;

// Doctors Page Modal popup

	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalFinddoctors;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement modalCancel;

	@FindBy(css = "#modal #modal-label")
	private WebElement modalTitle;

	@FindBy(css = "#modal .modal-content")
	private WebElement modalDescription;

//Doctors Page Confirmation Modal popup

	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalContinuedoctors;

	@FindBy(css = "#modal .modal-content .row:nth-of-type(1) p")
	private WebElement modalDoctorsCount;

	@FindBy(css = "#modal .modal-content .row:nth-of-type(2) uhc-list-item")
	private List<WebElement> modalDoctorsList;

	// #modal .modal-content .row:nth-of-type(2) uhc-list-item
	// button[class*='secondary']
	// Find doctor element and lookup remove button
	@FindBy(css = "button[class*='secondary']")
	private List<WebElement> modalDoctorsRemovebutton;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
	private WebElement doctorLookupOption;

	@FindBy(css = "#modal div[class*='edit']>button")
	private WebElement modalEditdoctors;

//Doctors Page Element Verification Method 

	public void doctorspageElements() {
		System.out.println("Validating Doctors Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
//                                                Assert.assertTrue(planSelectorPageTilte.getText().contains("Get help finding a plan"));
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		desktopCommonUtils.currentPageValidation(page.toUpperCase());
		validate(pageRequiredInfo);
//                                                Assert.assertTrue(pageRequiredInfo.getText().contains("All fields marked with "), " are required");
		validate(doctorsTitle);
//                                                Assert.assertTrue(doctorsTitle.getText().contains("doctors"));
		validate(innetwork, 30);
//                                                Assert.assertTrue(innetwork.getText().contains("network"));
		validate(outnetwork, 30);
//                                              Assert.assertTrue(outnetwork.getText().contains("patients"));
		validate(mydoctors, 30);
//                                                Assert.assertTrue(mydoctors.getText().contains("current doctors"));
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

// Selecting doctor options in Doctor Page

	public void doctorspageOptions(String doctor) {
		System.out.println("Doctor Page Functional Operations");
		if (doctor.equalsIgnoreCase("UHGNetwork")) {
			validate(innetwork);
			jsClickNew(innetwork);
			System.out.println("Doctors Type " + doctor + " Clicked");
		} else if (doctor.equalsIgnoreCase("AcceptsMedicare")) {
			validate(outnetwork);
			jsClickNew(outnetwork);
			System.out.println("Doctors Type " + doctor + " Clicked");
		} else if (doctor.equalsIgnoreCase("Lookup")) {
			validate(mydoctors);
			jsClickNew(mydoctors);
			System.out.println("Doctors Type " + doctor + " Clicked");
		}
	}

//Doctors Page Function Verification                      

	public void doctorspageFunctional(String doctor, String doctorsName, String multiDoctor, String status) {
		System.out.println("Doctor Page Functional Operations");
		if (status.toUpperCase().contains("POSITIVE")) {
			doctorspageOptions(doctor);
			jsClickNew(continueBtn);
			if (doctor.equalsIgnoreCase("Lookup")) {
				if (multiDoctor.equalsIgnoreCase("YES"))
					doctorModellookup(doctorsName, 3);
				else
					doctorModellookup(doctorsName, 1);
			}
			System.out.println("Validating " + page + " page Continue button functionality");
			if (!status.toUpperCase().contains("NEXTPAGENAME"))
				desktopCommonUtils.nextPageValidation(page.toUpperCase());
			else
				desktopCommonUtils.nextPageNameValidation(page.toUpperCase());
		} else {
			if (doctor.isEmpty()) {
				jsClickNew(continueBtn);
				desktopCommonUtils.desktopErrorValidation(page);
			}
		}
	}

//Doctors page - Select Doctor Type and click on Previous Button              

	public void doctorspagePreviousButton(String doctor) {
		System.out.println("Doctor Page Functional Operations");
		doctorspageOptions(doctor);
		if (radioselect.isDisplayed()) {
			validate(pageProgressPercentage, 30);
			Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
		} else {
			System.out.println("Doctor Type not selected in Doctors Page");
		}
		previousBtn.click();
		System.out.println("Validating " + page + " page Previous button functionality");
		desktopCommonUtils.previousPageValidation(page.toUpperCase());
	}

//Doctors Page Function Verification                                      
	public void doctorspageerror() {
		System.out.println("Doctor type not selected - Error Scenario in Doctors Page");
		continueBtn.click();
		desktopCommonUtils.desktopErrorValidation(page);
	}

//Doctors Model Popup Window Verification        
	int locationCount = 1;

	public void doctorModellookup(String search, int count) {
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
//		modalFinddoctors.click();
		jsClickNew(modalFinddoctors);
		validateLinksanotherWindow(curWindow, "Doctors", search, count, locationCount);
		threadsleep(5000);
		// Changing the count for multiple doc with : separated
		if (search.contains(":")) {
			count = search.split(":").length;
		}
		confirmationProviderResults = getConfimationPopupResults(count);
		verifyConfirmationmodalResults(count, werallyResults, confirmationResults);
		if (count > 2 && !search.contains(":")) {
			removeDoctors();
			count = count - 1;
			confirmationProviderResults = getConfimationPopupResults(count);
		}
//		modalContinuedoctors.click();
		jsClickNew(modalContinuedoctors);
	}

	public void doctorModellookupElements() {
		validate(modalDescription);
//                        			Assert.assertTrue(modalDescription.getText().contains("Save"));
		validate(modalTitle);
		Assert.assertTrue(modalTitle.getText().contains("browser"));
		validate(modalCancel);
		Assert.assertTrue(modalCancel.getText().contains("Cancel"));
		validate(modalFinddoctors);
//                        			Assert.assertTrue(modalFinddoctors.getText().contains("Find Doctors"));
	}

//Doctors Confirmation Model Popup Window Verification                                

	public void doctorConfirmationModellookup() {
		validate(modalTitle);
//                        			Assert.assertTrue(modalTitle.getText().contains("Your Doctors"));
		validate(modalDoctorsCount);
//                        			Assert.assertTrue(modalDoctorsCount.getText().contains("doctor(s)"));
		validate(modalCancel);
		Assert.assertTrue(modalCancel.getText().contains("Cancel"));
		validate(modalContinuedoctors);
		Assert.assertTrue(modalContinuedoctors.getText().contains("Continue"));
	}

//Switch to Werally Window Page


	public ArrayList<String> validateLinksanotherWindow(String primaryWindow, String type, String search, int count, int locationCount) {
		String browser = MRScenario.browserName;				//E2E: the browser name is stored in browserName variable in getWebDriverNew method of MRScenario 

		String env = MRScenario.environment;
		threadsleep(2000);
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows);
		if (windows.size() == 2) {
			for (String window : windows) {
				System.out.println(window.replace("page-", ""));
				/*
				 * String a =
				 * "window.open('https://connect.int.werally.in/welcome-to-check-provider-coverage');";
				 * ((JavascriptExecutor)driver).executeScript(a);
				 */
				if (!window.equals(primaryWindow)) {
					/*
					 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
					 * Auto-generated catch block e.printStackTrace(); }
					 */
					driver.switchTo().window(window);
					if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("edge")
							|| browser.equalsIgnoreCase("IE"))
						driver.manage().window().maximize();
					System.out.println(driver.getCurrentUrl());
					if (env.equalsIgnoreCase("prod") || env.equalsIgnoreCase("offline"))
						Assert.assertTrue(driver.getCurrentUrl().contains("werally.com"),
								"Prod Connected to Incorrect Rally");
					else
						Assert.assertTrue(driver.getCurrentUrl().contains("werally.in"),
								"Non Prod Connected to Incorrect Rally");
					werallyResults = werally.werallySearch(type, search, count, locationCount);
					System.out.println("werallyResults Size is : " + werallyResults.size());
					System.out.println("werallyResults Content is : " + werallyResults);
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

	public ArrayList<String> getConfimationPopupResults(int count) {
		int confirmationSize = Integer.parseInt(modalDoctorsCount.getText().trim().split(" ")[2]);
		if (count == modalDoctorsList.size() && count == confirmationSize) {
			confirmationResults = new ArrayList<String>();
			confirmationSpecialtyResults = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				confirmationResults
						.add(modalDoctorsList.get(i).findElement(By.cssSelector(".list-item-content p:nth-child(1)"))
								.getText().replace("\n", " ").trim());
				confirmationSpecialtyResults
						.add(modalDoctorsList.get(i).findElement(By.cssSelector(".list-item-content p:nth-child(2)"))
								.getText().replace("\n", " ").trim());
			}
			Collections.sort(confirmationResults);
			Collections.sort(confirmationSpecialtyResults);
			System.out.println("confirmationResults Size is : " + confirmationResults.size());
			System.out.println("confirmationResults Content is : " + confirmationResults);
			System.out.println("confirmationSpecialtyResults Size is : " + confirmationSpecialtyResults.size());
			System.out.println("confirmationSpecialtyResults Content is : " + confirmationSpecialtyResults);

		} else {
			System.out.println("Modal Results Count mismatch");
			Assert.assertTrue(false);
		}
		return confirmationResults;
	}
	
	public void getcontinue(String multi) {
		int count = 0;
		threadsleep(3000);
		int confirmationSize = Integer.parseInt(modalDoctorsCount.getText().trim().split(" ")[2]);
		System.out.println("confirmationResults Size is : " + confirmationSize);
		if(multi.equalsIgnoreCase("Multi"))
			count = 5;
		if(confirmationSize==count)
			System.out.println("Doctors Size is : " + count);
			jsClickNew(continueBtn);
			threadsleep(3000);
		}

	public void verifyConfirmationmodalResults(int count, ArrayList<String> werally, ArrayList<String> confirm) {

		if (werally.size() == confirm.size() && count == werally.size()) {
			if (containsname(werally, confirm)) {
				System.out.println("Werally and Modal Result's Content matched");
			} else {
				System.out.println("Werally and Modal Result's Content mismatch");
				Assert.assertTrue(false);
			}
		} else {
			System.out.println("Werally and Modal Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public boolean equalsname(ArrayList<String> werally, ArrayList<String> doctorsmodal) {
		boolean result = true;
		for (int i = 0; i < werally.size(); i++) {
			String wname[] = werally.get(i).toUpperCase().replace(",", "").replace(".", "").split(" ");
			Arrays.sort(wname);
			for (int j = 0; j < doctorsmodal.size(); j++) {
				String dname[] = doctorsmodal.get(j).toUpperCase().replace(",", "").replace(".", "").split(" ");
				Arrays.sort(dname);
				System.out.println(Arrays.equals(wname, dname));
				if (Arrays.equals(wname, dname)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		System.out.println("Doctors Name validation Result " + result);
		return result;
	}

	public boolean containsname(ArrayList<String> werallypreproviders, ArrayList<String> vppprovider) {
		boolean result = true;
		for (int i = 0; i < werallypreproviders.size(); i++) {
			String wname[] = werallypreproviders.get(i).replace(",", "").replace(".", "").split(" ");
			List<String> wnam = Arrays.asList(wname);
			for (int j = 0; j < vppprovider.size(); j++) {
				String dname[] = vppprovider.get(j).replace(",", "").replace(".", "").replace("\n", " ").split(" ");
				List<String> dnam = Arrays.asList(dname);
				if (wnam.containsAll(dnam) || dnam.containsAll(wnam)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		System.out.println("Doctors Name validation Result " + result);
		Assert.assertTrue(result, "Providers name mismatch");
		return result;
	}

	public void removeDoctors() {
		// By default removing 2nd doctor
		int beforeRemove = modalDoctorsList.size();
//		modalDoctorsList.get(1).findElement(By.cssSelector("button[class*='secondary']")).click();
		jsClickNew(modalDoctorsList.get(1).findElement(By.cssSelector("button[class*='secondary']")));
		int afterRemove = modalDoctorsList.size();
		if (beforeRemove != afterRemove) {
			System.out.println("Remove Results Count mismatch");
			getConfimationPopupResults(afterRemove);
		} else {
			System.out.println("Remove Results Count matching and Remove is not removed");
			Assert.assertTrue(false);
		}
	}

	public void browserBack() {

		driver.navigate().back();
	}

	public void nextPageValidationDoctor() {
		jsClickNew(modalContinuedoctors);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageValidation(page.toUpperCase());
	}

	public void doctorspageCancel(String doctorsName, String multiDoctor) {
//		doctorLookupOption.click();
		jsClickNew(doctorLookupOption);
		System.out.println("Plan Type Lookup Clicked");
//		continueBtn.click();
		jsClickNew(continueBtn);
		if (multiDoctor.equalsIgnoreCase("YES")) {
			String curdriverhandle = driver.getWindowHandle();
//			modalFinddoctors.click();
			jsClickNew(modalFinddoctors);
			validateLinksanotherWindow(curdriverhandle, "Doctors", doctorsName, 2, locationCount);
			doctorConfirmationModellookup();
//			modalCancel.click();
			jsClickNew(modalCancel);
			if (validate(modalCancel, 10) == true) {
				System.out.println("Modal Popup is not closed");
				Assert.assertTrue(false);
			}
		} else {
			doctorModellookupElements();
//			modalCancel.click();
			jsClickNew(modalCancel);
			if (validate(modalCancel, 10) == true) {
				System.out.println("Confirmation Modal Popup is not closed");
				Assert.assertTrue(false);
			}
		}
		System.out.println("Validating " + page + " page modal cancel button functionality");
		pageStepsNumberName.getText().toUpperCase().contains(page.toUpperCase());
	}

	public void navigateDoctorsmodalsession() {
//		doctorLookupOption.click();
		jsClickNew(doctorLookupOption);
		System.out.println("Doctor Lookup Type Clicked");
//		continueBtn.click();
		jsClickNew(continueBtn);
	}

	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();

	public void addProvidersPRE(String doctorsName, String multiDoctor) {
		jsClickNew(doctorLookupOption);
		System.out.println("Lookup Type Clicked");
		jsClickNew(continueBtn);
		if (multiDoctor.equalsIgnoreCase("YES"))
			providerlookup(doctorsName, 3);
		else
			providerlookup(doctorsName, 1);
		System.out.println("Validating " + page + " page Continue button functionality");
		jsClickNew(modalContinuedoctors);
		desktopCommonUtils.nextPageValidation(page.toUpperCase());

	}

	public void providerlookup(String search, int count) {
		String curdriverhandle = driver.getWindowHandle();
		jsClickNew(modalFinddoctors);
		validateLinksanotherWindow(curdriverhandle, "Doctors", search, count, locationCount);
		confirmationProviderResults = getConfimationPopupResults(count);
		verifyConfirmationmodalResults(count, werallyResults, confirmationProviderResults);
	}

	public void editProvider(String doctorName1, String multiDoctor1, String doctorName2, String muliDoctor2) {
		jsClickNew(doctorLookupOption);
		System.out.println("Lookup Type Clicked");
		jsClickNew(continueBtn);
		if (multiDoctor1.equalsIgnoreCase("YES"))
			providerlookup(doctorName1, 3);
		else
			providerlookup(doctorName1, 1);
		int confirmationSize = Integer.parseInt(modalDoctorsCount.getText().trim().split(" ")[2]);
		String curdriverhandle = driver.getWindowHandle();
		threadsleep(5000);
		jsClickNew(modalEditdoctors);
		jsClickNew(modalFinddoctors);
		if (muliDoctor2.equalsIgnoreCase("YES"))
			validateLinksanotherWindow(curdriverhandle, "Doctors", doctorName2, 3, locationCount);
		else
			validateLinksanotherWindow(curdriverhandle, "Doctors", doctorName2, 1, locationCount);
		Assert.assertTrue(modalDoctorsList.size() > confirmationSize, "Error in adding another Provider through Edit");
		nextPageValidationDoctor();
	}

	public void verifyExisitngPREDoclist(String multi) {
		int count = 1;
		if (multi.equalsIgnoreCase("Yes"))
			count = 3 - 1;// -1 Because one provider should have been removed in first run
		// confirmationProviderResults - Static variable which already has the value of
		// doc at 1st run
		verifyConfirmationmodalResults(count, getConfimationPopupResults(count), confirmationProviderResults);
	}

	public void nextPageNameValidationDoctor() {
		jsClickNew(modalContinuedoctors);
		System.out.println("Validating " + page + " page Continue button functionality");
		desktopCommonUtils.nextPageNameValidation(page.toUpperCase());
	}

	public void edit_doctor(String doctor, String doctorsName, String multiDoctor) {
		doctorspageOptions(doctor);
		jsClickNew(continueBtn);
		if(validate(modalEditdoctors)) {
			jsClickNew(modalEditdoctors);
		}
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		jsClickNew(modalFinddoctors);
		threadsleep(5000);
		if (doctor.equalsIgnoreCase("Lookup")) {
			if (multiDoctor.equalsIgnoreCase("YES"))
				validateLinksanotherWindow(curWindow, "Doctors", doctorsName, 3, locationCount);
			else
				validateLinksanotherWindow(curWindow, "Doctors", doctorsName, 1, locationCount);
		}
		jsClickNew(modalContinuedoctors);
	}
	
	public void addProviderEdit(String search) {
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		validateLinksanotherWindow(curWindow, "Doctors", search, 1, locationCount);
		threadsleep(5000);
	}

}

