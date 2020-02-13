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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.AcquisitionHomePage;

public class DrugMobilePage extends UhcDriver {

	public DrugMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String page = "Drug";

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);
	WerallyMobilePage werally = new WerallyMobilePage(driver);
	ArrayList<String> werallyResults = new ArrayList<String>();
	ArrayList<String> confirmationResults = new ArrayList<String>();

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	// drugs Page Elements

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
	private WebElement drugPagePrimaryQuestion;

	@FindBy(css = "div legend.primary-question-tex span>sup")
	private WebElement drugPagePrimaryQuestionMark;

	@FindBy(css = "div legend.primary-question-tex .description-text")
	private WebElement drugPagePrimaryQuestionDecsription;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(2)>label")
	private WebElement drugAddOption;

	@FindBy(css = "#custom-radio-group>fieldset>uhc-radio:nth-child(3)>label")
	private WebElement drugSkipOption;

	//Search Page elements
	@FindBy(css = "uhc-temp-display>div.container div>div>h2")
	private WebElement drugsearchbuildpres;
	
	@FindBy(css = "uhc-temp-display>div.container div>div>p")
	private WebElement drugsearchdescription;
	
	@FindBy(css = "input#drug")
	private WebElement drugsearchBox;

	@FindBy(css = "uhc-autocomplete button")
	private WebElement drugsearchButton;
	
	// drugs Page Modal popup
	
	@FindBy(css = "#modal uhc-radio[class*='checked']")
	private WebElement modalSelcetedDrug;

	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalcontinue;

	@FindBy(css = "#modal div[class*='modal-footer'] button[class*='secondary']")
	private WebElement modalBackCancel;

	@FindBy(css = "#modal #modal-label")
	private WebElement modalTitle;

	@FindBy(css = "#modal #dosage-select")
	private WebElement modalDosageSelect;

	@FindBy(css = "#modal #package-select")
	private WebElement modalPackageSelect;
	
	@FindBy(css = "#modal #Quantity")
	private WebElement modalQuantity;
	
	@FindBy(css = "#modal #frequency-select")
	private WebElement modalFrequencySelect;
	
	//Generic modal
	
	@FindBy(css = "#modal uhc-alert")
	private WebElement modalGenericDescription;
	
	@FindBy(css = "#modal legend")
	private WebElement modalGenericDrug;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(1) label .radio-label-content")
	private WebElement modalGenericKeep;
	
	@FindBy(css = "#modal uhc-radio:nth-of-type(2) label .radio-label-content")
	private WebElement modalGenericSwitch;
	
	// drugs Page Confirmation Modal popup

	@FindBy(css = "#modal div>button[class*='primary button']")
	private WebElement modalContinuedrugs;

	@FindBy(css = "#modal .modal-content .row:nth-of-type(1) p")
	private WebElement modaldrugsCount;

	@FindBy(css = "uhc-list uhc-list-item")
	private List<WebElement> drugsList;

	// Find drug element and lookup for name
	@FindBy(css = ".list-item-content")
	private WebElement drugName;

	// Drugs Page Element Verification Method
	public void drugspageElements() {
		System.out.println("Drugs Validating Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(planSelectorPageTilte);
		validate(pageStepsNumberName, 30);
		Assert.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug"));
		validate(pageProgressPercentage, 30);
		Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
		validate(progressbar);
		validate(pageRequiredInfo);
		validate(pageRequiredInfoAsteriskMark);
		validate(drugPagePrimaryQuestion);
		Assert.assertTrue(drugPagePrimaryQuestion.getText().contains("drug"));
		validate(drugPagePrimaryQuestionMark);
		validate(drugPagePrimaryQuestionDecsription);
		validate(drugAddOption, 30);
		Assert.assertTrue(drugAddOption.getText().contains("add"));
		validate(drugSkipOption, 30);
		Assert.assertTrue(drugSkipOption.getText().contains("skip"));
		mobileUtils.mobileLocateElementClick(drugAddOption);
		mobileUtils.mobileLocateElementClick(previousBtn);
		System.out.println("Validating " + page + " page Previous button functionality");
		mobileUtils.previouspageValidation(page.toUpperCase());
	}

	public void chooseOption(String drugsSelection) {
			if (drugsSelection.equalsIgnoreCase("add")) {
				mobileUtils.mobileLocateElementClick(drugAddOption);
				System.out.println("Plan Type " + drugsSelection + " Clicked");
			} else if (drugsSelection.equalsIgnoreCase("skip")) {
				mobileUtils.mobileLocateElementClick(drugSkipOption);
				System.out.println("Plan Type " + drugsSelection + " Clicked");
		} else {
			if (drugsSelection.isEmpty()) {
				mobileUtils.mobileLocateElementClick(continueBtn);
				mobileUtils.mobleErrorValidation(page);
			}
		}
	}
	
	public void skipDrugs(String drugsSelection) {
		chooseOption(drugsSelection);
		mobileUtils.mobileLocateElementClick(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		mobileUtils.nextPageValidation(page.toUpperCase());
	}
	
	public void addDrugs(String drugsSelection,String drugsName) {
		chooseOption(drugsSelection);
		mobileUtils.mobileLocateElementClick(continueBtn);
		
	}
	
	// Drugs Search Page Element Verification Method
	public void drugsSearchpageElements() {
			System.out.println("Drugs Search Validating Page: ");
			String currentPageUrl = driver.getCurrentUrl();
			currentPageUrl.contains("/plan-recommendation-engine.html/");
			validate(planSelectorPageTilte);
			validate(pageStepsNumberName, 30);
			Assert.assertTrue(pageStepsNumberName.getText().contains("Step 6: Drug"));
			validate(pageProgressPercentage, 30);
			Assert.assertTrue(pageProgressPercentage.getText().contains("40% Complete"));
			validate(progressbar);
			validate(drugsearchbuildpres);
			validate(drugsearchdescription);
			Assert.assertTrue(drugsearchdescription.getText().contains("drug"));
			validate(drugsearchBox);
			validate(drugsearchButton);
			validate(continueBtn);
			mobileUtils.mobileLocateElementClick(previousBtn);
			Assert.assertTrue(drugAddOption.getText().contains("add"));
		}

	public void genericElements() {
		validate(modalGenericDescription, 30);
		Assert.assertTrue(modalGenericDescription.getText().contains("switching to a generic drug"));
		validate(modalGenericDrug, 30);
		Assert.assertTrue(modalGenericDrug.getText().contains("TAB"));
		validate(modalGenericKeep, 30);
		Assert.assertTrue(modalGenericKeep.getText().contains("Keep"));
		validate(modalGenericSwitch, 30);
		Assert.assertTrue(modalGenericSwitch.getText().contains("Switch"));
	}
	
	public void addDrugbySearchbutton(String drugName,boolean switchGeneric) {
		drugsSearchpageElements();
		drugsearchBox.sendKeys(drugName);
		drugsearchButton.click();
		Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),"Drug name is not Matched :"+drugName);
		modalcontinue.click();
		threadsleep(2000);
		if (switchGeneric) {
			genericElements();
			modalcontinue.click();
			threadsleep(2000);
		}
		modalcontinue.click();
	}
	
	public void addDrugbySearchbutton(String drugName, String dosage, String packageName, String count,
			String threeeMonthfrequency, boolean switchGeneric) {
		try {
			drugsearchBox.sendKeys(drugName);
			drugsearchButton.click();
			Assert.assertTrue(modalSelcetedDrug.getText().toUpperCase().contains(drugName.toUpperCase()),"Drug name is not Matched :"+drugName);
			modalcontinue.click();
			threadsleep(2000);
			Select dos = new Select(modalDosageSelect);
			Select freq = new Select(modalFrequencySelect);

			if (dosage != null)
				dos.selectByVisibleText(dosage);
			if (packageName != null) {
				Select pack = new Select(modalPackageSelect);
				pack.selectByVisibleText(packageName);
			}
			if (count != null)
				modalQuantity.sendKeys(count);
			if (threeeMonthfrequency.toUpperCase().contains("YES"))
				freq.selectByVisibleText("Every 3 Months");
			if (switchGeneric)
				modalcontinue.click();
			modalcontinue.click();
		} catch (Exception e) {
			System.out.println("Unable to add drug");
		}
	}
	
	public void checkRemove(int count){
		if (count > 2)
			removedrugs();
	}


	public void removedrugs() {
		// By default removing 2nd drug
		int beforeRemove = drugsList.size();
		WebElement remove = drugsList.get(1).findElement(By.cssSelector("button[class*='secondary']"));
		mobileUtils.mobileLocateElementClick(remove);
		int afterRemove = drugsList.size();
		if (beforeRemove == afterRemove) {
			System.out.println("Remove Results Count mismatch");
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

	
	public boolean equalsname(ArrayList<String> werally, ArrayList<String> drugsmodal) {
		boolean result = true;
		for (int i = 0; i < werally.size(); i++) {
			String wname[] = werally.get(i).replace(",", "").replace(".", "").split(" ");
			Arrays.sort(wname);
			for (int j = 0; j < drugsmodal.size(); j++) {
				String dname[] = drugsmodal.get(j).replace(",", "").replace(".", "").split(" ");
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
		System.out.println("drugs Name validation Result " + result);
		return result;
	}

	
	public void drugspageCancel(String drugsName, String multidrug) {
		mobileUtils.mobileLocateElementClick(drugAddOption);
		System.out.println("Plan Type Lookup Clicked");
		mobileUtils.mobileLocateElementClick(continueBtn);
		if (multidrug.equalsIgnoreCase("YES")) {
			String curdriverhandle = driver.getWindowHandle();
			//mobileUtils.mobileLocateElementClick(modalFinddrugs);
			//validateWerallySearchanotherWindowmobile(curdriverhandle, "drugs", drugsName, 2);
			//drugConfirmationModellookupElements();
			//modalCancel.click();
			if(validate(modalBackCancel,10)==true) {
				System.out.println("Modal Popup is not closed");
				Assert.assertTrue(false);
			}
		}
		else {
			modalBackCancel.click();
			if(validate(modalBackCancel,10)==true) {
				System.out.println("Confirmation Modal Popup is not closed");
				Assert.assertTrue(false);
			}
		}
		System.out.println("Validating " + page + " page modal cancel button functionality");
		pageStepsNumberName.getText().toUpperCase().contains(page.toUpperCase());
	}

}
