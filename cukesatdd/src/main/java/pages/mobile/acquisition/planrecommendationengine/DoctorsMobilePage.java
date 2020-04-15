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

	String page = "Step 5: Doctors";

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	WerallyMobilePage werally = new WerallyMobilePage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();

	// Doctors Page Elements

	// --- From here Common for all page starts ---
	@FindBy(css = ".progress-bar-title>h1")
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
		Assert.assertTrue(doctorPagePrimaryQuestion.getText().contains("doctors"));
		validate(doctorPagePrimaryQuestionMark);
		validate(doctorPagePrimaryQuestionDecsription);
		validate(doctorUHCNetworkOption, 30);
		Assert.assertTrue(doctorUHCNetworkOption.getText().contains("network"));
		validate(doctorWantOption, 30);
		Assert.assertTrue(doctorWantOption.getText().contains("want"));
		validate(doctorLookupOption, 30);
		Assert.assertTrue(doctorLookupOption.getText().contains("lookup"));
		mobileUtils.mobileLocateElementClick(doctorWantOption);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previousPageValidation(page.toUpperCase());
	}

	public void doctorspage(String doctorsSelection, String doctorsName, String multiDoctor, String status) {
		if (status.equals("Positive")) {
			if (doctorsSelection.equalsIgnoreCase("willing to use")) {
				mobileUtils.mobileLocateElementClick(doctorUHCNetworkOption);
				System.out.println("Plan Type " + doctorsSelection + " Clicked");
				mobileUtils.mobileLocateElementClick(continueBtn);
			} else if (doctorsSelection.equalsIgnoreCase("want to use")) {
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
			mobileUtils.nextPageValidation(page.toUpperCase());
		} else {
			if (doctorsSelection.isEmpty()) {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}

	public void doctorlookup(String search, int count) {
		String curdriverhandle = driver.getWindowHandle();
		mobileUtils.mobileLocateElementClick(modalFinddoctors);
		validateWerallySearchanotherWindowmobile(curdriverhandle, "Doctors", search, count);
		getConfimationPopupResults(count);
		verifyConfirmationmodalResults(count, werallyResults, confirmationResults);
		if (count > 2)
			removeDoctors();
		mobileUtils.mobileLocateElementClick(modalContinuedoctors);
	}

	public void doctorModellookupElements() {
		validate(modalDescription);
		Assert.assertTrue(modalDescription.getText().contains("Save"));
		validate(modalTitle);
		Assert.assertTrue(modalTitle.getText().contains("browser"));
		validate(modalCancel);
		Assert.assertTrue(modalCancel.getText().contains("Cancel"));
		validate(modalFinddoctors);
		Assert.assertTrue(modalFinddoctors.getText().contains("Find Doctors"));
	}

	public void doctorConfirmationModellookupElements() {
		validate(modalTitle);
		Assert.assertTrue(modalTitle.getText().contains("Your Doctors"));
		validate(modalDoctorsCount);
		Assert.assertTrue(modalDoctorsCount.getText().contains("doctor(s)"));
		validate(modalCancel);
		Assert.assertTrue(modalCancel.getText().contains("Cancel"));
		validate(modalContinuedoctors);
		Assert.assertTrue(modalContinuedoctors.getText().contains("Continue"));
	}

	public void removeDoctors() {
		// By default removing 2nd doctor
		int beforeRemove = modalDoctorsList.size();
		WebElement remove = modalDoctorsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
		mobileUtils.mobileLocateElementClick(remove);
		int afterRemove = modalDoctorsList.size();
		if (beforeRemove == afterRemove) {
			System.out.println("Remove Results Count mismatch");
			Assert.assertTrue(false);
		}
	}

	public void getConfimationPopupResults(int count) {
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
	}

	public void validateWerallySearchanotherWindowmobile(String primaryWindow, String type, String search, int count) {
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
	}

	public void verifyConfirmationmodalResults(int count, ArrayList<String> werally, ArrayList<String> confirm) {

		if (werally.size() == confirm.size() && count == werally.size()) {
			if (equalsname(werally, confirm)) {
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
			String wname[] = werally.get(i).replace(",", "").replace(".", "").split(" ");
			Arrays.sort(wname);
			for (int j = 0; j < doctorsmodal.size(); j++) {
				String dname[] = doctorsmodal.get(j).replace(",", "").replace(".", "").split(" ");
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

	public void doctorspageCancel(String doctorsName, String multiDoctor) {
		mobileUtils.mobileLocateElementClick(doctorLookupOption);
		System.out.println("Plan Type Lookup Clicked");
		mobileUtils.mobileLocateElementClick(continueBtn);
		if (multiDoctor.equalsIgnoreCase("YES")) {
			String curdriverhandle = driver.getWindowHandle();
			mobileUtils.mobileLocateElementClick(modalFinddoctors);
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

}
