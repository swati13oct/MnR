/**
 * 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class DoctorsMobilePage extends UhcDriver {

	public DoctorsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.doctorsPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	WerallyMobilePage werally = new WerallyMobilePage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();

	// Doctors Page Elements

	// --- From here Common for all page starts ---
	@FindBy(css = "#progress-bar-title")
	private WebElement planSelectorPageTilte;

	@FindBy(css = ".progress-bar-info>h2")
	private WebElement pageStepsNumberName;

	@FindBy(css = "div.progress-bar-value-background")
	private WebElement progressbar;

	@FindBy(css = "div.progress-bar-info>p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div>.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = ".all-fields-marked-wi>sup")
	private WebElement pageRequiredInfoAsteriskMark;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	// --- Common elements Ends above ---

	@FindBy(css = "div legend.primary-question-tex")
	private WebElement doctorPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement doctorPagePrimaryQuestionMark;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement doctorPagePrimaryQuestionDecsription;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label")
	private WebElement doctorUHCNetworkOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement doctorWantOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(4)>label")
	private WebElement doctorLookupOption;

	// Doctors Page Modal popup
	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalFinddoctors;

	@FindBy(css = "#modal div[class*='modal-footer'] button[class*='secondary']")
	private WebElement modalCancel;

	@FindBy(css = "#modal #modal-label")
	private WebElement modalTitle;

	@FindBy(css = "#modal .modal-content")
	private WebElement modalDescription;

	// Doctors Page Confirmation Modal popup
	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalContinuedoctors;

	@FindBy(css = "#modal div[class*='edit']>button")
	private WebElement modalEditdoctors;
	
	@FindBy(css = "#modal .modal-content .row:nth-of-type(1) p")
	private WebElement modalDoctorsCount;

	@FindBy(css = "#modal .modal-content .row:nth-of-type(2) uhc-list-item")
	private List<WebElement> modalDoctorsList;

	// Find doctor element and lookup for name
	@FindBy(css = ".list-item-content")
	private WebElement doctorName;

	// Doctors Page Element Verification Method
	public void doctorspageElements() {
		System.out.println("Doctors Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		validate(pageProgressPercentage, 30);
		mobileUtils.currentPageValidation(page.toUpperCase());
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);
		validate(doctorPagePrimaryQuestion);
		//Assert.assertTrue(doctorPagePrimaryQuestion.getText().contains("doctors"));
		validate(doctorPagePrimaryQuestionMark);
		validate(doctorPagePrimaryQuestionDecsription);
		validate(doctorUHCNetworkOption, 30);
		//Assert.assertTrue(doctorUHCNetworkOption.getText().contains("network"));
		validate(doctorWantOption, 30);
		//Assert.assertTrue(doctorWantOption.getText().contains("want"));
		validate(doctorLookupOption, 30);
		//Assert.assertTrue(doctorLookupOption.getText().contains("lookup"));
		mobileUtils.mobileLocateElementClick(doctorWantOption);
		mobileUtils.mobileLocateElement(previousBtn);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	public void doctorspage(String doctorsSelection, String doctorsName, String multiDoctor, String status) {
		if (status.toUpperCase().contains("POSITIVE")) {
			if (doctorsSelection.equalsIgnoreCase("UHCNetwork")) {
				mobileUtils.mobileLocateElementClick(doctorUHCNetworkOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("AcceptsMedicare")) {
				mobileUtils.mobileLocateElementClick(doctorWantOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("lookup")) {
				mobileUtils.mobileLocateElementClick(doctorLookupOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
				if (multiDoctor.equalsIgnoreCase("YES"))
					doctorlookup(doctorsName, 3);
				else
					doctorlookup(doctorsName, 1);
			}
			System.out.println("Validating " + page + " page Continue button functionality");
			if(!status.toUpperCase().contains("NEXTPAGENAME"))
				mobileUtils.nextPageValidation(page.toUpperCase());
			else
				mobileUtils.nextPageNameValidation(page.toUpperCase());
		} else {
			if (doctorsSelection.isEmpty()) {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}

	public void doctorlookup(String search, int count) {
		String curdriverhandle = driver.getWindowHandle();
		modalFinddoctors.click();
		validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", search, count);
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
		modalContinuedoctors.click();
	}

	public void doctorModellookupElements() {
		validate(modalDescription);
		//Assert.assertTrue(modalDescription.getText().contains("Save"));
		validate(modalTitle);
		Assert.assertTrue(modalTitle.getText().contains("browser"));
		validate(modalCancel);
		Assert.assertTrue(modalCancel.getText().contains("Cancel"));
		validate(modalFinddoctors);
		//Assert.assertTrue(modalFinddoctors.getText().contains("Find Doctors"));
	}

	public void doctorConfirmationModellookupElements() {
		validate(modalTitle);
		//Assert.assertTrue(modalTitle.getText().contains("Your Doctors"));
		validate(modalDoctorsCount);
		//Assert.assertTrue(modalDoctorsCount.getText().contains("doctor(s)"));
		validate(modalCancel);
		Assert.assertTrue(modalCancel.getText().contains("Cancel"));
		validate(modalContinuedoctors);
		Assert.assertTrue(modalContinuedoctors.getText().contains("Continue"));
	}

	public void removeDoctors() {
		// By default removing 2nd doctor
		int beforeRemove = modalDoctorsList.size();
		WebElement remove = modalDoctorsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
		mobileactiontap(remove);
		threadsleep(2000);
		int afterRemove = modalDoctorsList.size();
		if (beforeRemove == afterRemove) {
			System.out.println("Remove Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public ArrayList<String> getConfimationPopupResults(int count) {
		int confirmationSize = Integer.parseInt(modalDoctorsCount.getText().trim().split(" ")[2]);
		if (count == modalDoctorsList.size() && count == confirmationSize) {
			confirmationResults = new ArrayList<String>();
			for (int i = 0; i < count; i++)
				confirmationResults.add(
						modalDoctorsList.get(i).findElement(By.cssSelector(".list-item-content")).getText().replace("\n", " ").trim());
			Collections.sort(confirmationResults);
			System.out.println(confirmationResults);
		} else {
			System.out.println("Modal Results Count mismatch");
			Assert.assertTrue(false);
		}
		return confirmationResults;
	}

	public ArrayList<String> validateWerallySearchanotherWindowmobile(String primaryWindow, String type, String search, int count) {
		threadsleep(2000);
		werallyResults = null;
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		if (windows.size() == 2) {
				for (String window : windows) {
					if (!window.equals(primaryWindow)) {
						driver.switchTo().window(window);
						System.out.println(driver.getCurrentUrl());
						mobileUtils.fixLeavingProceedMobile();
						mobileUtils.fixPrivateConnectionMobile();
						mobileUtils.fixFormResubmission(true);
						pageloadcomplete();
						System.out.println(driver.getCurrentUrl());
						werallyResults = werally.werallySearch(type, search, count);
					}
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

	public void verifyConfirmationmodalResults(int count, ArrayList<String> werally, ArrayList<String> confirm) {
		//Additional specialty will be displayed in saved page of Werally and the same will display in  modal popup
		if (werally.size() == confirm.size() && count == werally.size()) {
			if (equalsname(werally, confirm)) {
				System.out.println("Werally and Modal Result's Content matched");
			}else if (containsname(confirm, werally)) {
				System.out.println("Werally and Modal Result's Content matched");
			}else {
				System.out.println("Werally and Modal Result's Content mismatch");
				System.out.println("Actual Confirm "+confirm);
				System.out.println("Expected Werally "+werally);
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
			String wname[] = werally.get(i).toUpperCase().replace(",", " ").replace(".", " ").replace("  ", " ").split(" ");
			Arrays.sort(wname);
			for (int j = 0; j < doctorsmodal.size(); j++) {
				String dname[] = doctorsmodal.get(j).toUpperCase().replace(",", " ").replace(".", " ").replace("  ", " ").split(" ");
				Arrays.sort(dname);
				System.out.println(Arrays.equals(wname, dname));
				if (Arrays.equals(wname, dname)) {
					result = true;
					break;
				} else {
					result = false;
					System.out.println("Expected : "+werally.get(i));
					System.out.println("Actual : "+doctorsmodal.get(j));
				}
			}
		}
		System.out.println("Doctors Name validation Result " + result);
		return result;
	}

	public void doctorspageCancel(String doctorsName, String multiDoctor) {
		mobileUtils.mobileLocateElementClick(doctorLookupOption);
		System.out.println("Plan Type Lookup Clicked");
		mobileUtils.mobileLocateElementClick(continueBtn);
		if (multiDoctor.equalsIgnoreCase("YES")) {
			String curdriverhandle = driver.getWindowHandle();
			modalFinddoctors.click();
			validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", doctorsName, 2);
			doctorConfirmationModellookupElements();
			modalCancel.click();
			if(validate(modalCancel,10)==true) {
				System.out.println("Modal Popup is not closed");
				Assert.assertTrue(false);
			}
		}
		else {
			doctorModellookupElements();
			modalCancel.click();
			if(validate(modalCancel,10)==true) {
				System.out.println("Confirmation Modal Popup is not closed");
				Assert.assertTrue(false);
			}
		}
		System.out.println("Validating " + page + " page modal cancel button functionality");
		pageStepsNumberName.getText().toUpperCase().contains(page.toUpperCase());
	}

	public void navigateDoctorsmodalsession() {
		mobileUtils.mobileLocateElementClick(doctorLookupOption);
		System.out.println("Dooctor Lookup Type Clicked");
		mobileUtils.mobileLocateElementClick(continueBtn);
	}
	
	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	
	public void addProvidersPRE(String doctorsName, String multiDoctor) {
				mobileUtils.mobileLocateElementClick(doctorLookupOption);
				System.out.println("Lookup Type Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
				if (multiDoctor.equalsIgnoreCase("YES"))
					providerlookup(doctorsName, 3);
				else
					providerlookup(doctorsName, 1);
				nextPageValidationDoctor();
	}

	public void providerlookup(String search, int count) {
		String curdriverhandle = driver.getWindowHandle();
		modalFinddoctors.click();
		validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", search, count);
		confirmationProviderResults=getConfimationPopupResults(count);
		verifyConfirmationmodalResults(count, werallyResults, confirmationProviderResults);
	}
	
	public void nextPageValidationDoctor() {
		modalContinuedoctors.click();
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}
	
	public void editProvider(String doctorName1, String multiDoctor1, String doctorName2,String muliDoctor2) {
		mobileUtils.mobileLocateElementClick(doctorLookupOption);
		System.out.println("Lookup Type Clicked");
		mobileUtils.mobileLocateElementClick(continueBtn);
		if (multiDoctor1.equalsIgnoreCase("YES"))	
			providerlookup(doctorName1, 3);
		else
			providerlookup(doctorName1, 1);
		int confirmationSize = Integer.parseInt(modalDoctorsCount.getText().trim().split(" ")[2]);
		String curdriverhandle = driver.getWindowHandle();
		modalEditdoctors.click();
		threadsleep(1000);
		modalFinddoctors.click();
		if (muliDoctor2.equalsIgnoreCase("YES"))	
			validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", doctorName2, 3);
		else
			validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", doctorName2, 1);
		Assert.assertTrue(modalDoctorsList.size()>confirmationSize,"Error in adding another Provider through Edit");
		nextPageValidationDoctor();
	}

	public void verifyExisitngPREDoclist(String multi) {
		int count =1;
		if(multi.equalsIgnoreCase("Yes"))
			count = 3-1;//-1 Because one provider should have been removed in first run
		//confirmationProviderResults - Static variable which already has the value of doc at 1st run
		verifyConfirmationmodalResults(count, getConfimationPopupResults(count), confirmationProviderResults);
	}
	
	public void nextPageNameValidationDoctor() {
		modalContinuedoctors.click();
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageNameValidation(page.toUpperCase());
	}

	public boolean containsname(ArrayList<String> primaryContent, ArrayList<String> subContent) {
		boolean result = true;
		for (int i = 0; i < primaryContent.size(); i++) {
			String wname[] = primaryContent.get(i).toUpperCase().replace(",", "").replace(".", "").split(" ");
			List<String> wnam = Arrays.asList(wname);
			for (int j = 0; j < subContent.size(); j++) {
				String dname[] = subContent.get(j).toUpperCase().replace(",", "").replace(".", "").split(" ");
				List<String> dnam = Arrays.asList(dname);
				if (wnam.containsAll(dnam)) {
					result = true;
					break;
				} else {
					result = false;
				}
			}
		}
		System.out.println("Content validation Result : " + result);
		Assert.assertTrue(result, "Content mismatch");
		return result;
	}
	
	public void doctorspageOptions(String doctorsSelection) {
			if (doctorsSelection.equalsIgnoreCase("UHCNetwork")) {
				mobileUtils.mobileLocateElementClick(doctorUHCNetworkOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("AcceptsMedicare")) {
				mobileUtils.mobileLocateElementClick(doctorWantOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("lookup")) {
				mobileUtils.mobileLocateElementClick(doctorLookupOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
			}
	}
	
	public void edit_doctor(String doctor, String doctorsName, String multiDoctor) {
		doctorspageOptions(doctor);
		mobileUtils.mobileLocateElementClick(continueBtn);
		if (doctor.equalsIgnoreCase("Lookup")) {
			if (multiDoctor.equalsIgnoreCase("YES"))
				doctorlookup(doctorsName, 3);
			else
				doctorlookup(doctorsName, 1);
		}
	}
	
	public void addProviderEdit(String search) {
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		validateWerallySearchanotherWindowmobile(curWindow, "Doctors", search, 1);
		threadsleep(5000);
	}
}