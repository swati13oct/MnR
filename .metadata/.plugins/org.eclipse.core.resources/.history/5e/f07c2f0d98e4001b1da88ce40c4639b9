/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.acquisition.commonpages.GlobalWebElements;

public class PlanRecommendationEngineEditResponsePage extends GlobalWebElements {

	public PlanRecommendationEngineEditResponsePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}

	String flow;
	ArrayList<String> DrugsInPRE;
	ArrayList<String> DrugsInDCE;
	ArrayList<String> DrugsList = new ArrayList<String>();
	ArrayList<String> ModelDrugsList = new ArrayList<String>();
	static ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> vppResults = new ArrayList<String>();
	static ArrayList<String> vppProviderResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults1 = new ArrayList<String>();
	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	public WebElement drugCoveredeVPP;
	PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	@FindBy(css = "div.progress-bar-info")
	private WebElement progressInfo;

	@FindBy(css = "button[class*='button-secondary']")
	private WebElement cancelButton;

	@FindBy(css = "button[class*='button-primary']")
	private WebElement saveButton;
	
	@FindBy(css = ".editPref button")
	private WebElement editYourResponse;
	
	@FindBy(css = "div[data-rel='#plan-list-1'] a")
	private WebElement MAViewPlansLink;
	
	@FindBy(css = "div[data-rel='#plan-list-3'] a")
	private WebElement PDPViewPlansLink;
	
	@FindBy(css = "div[data-rel='#plan-list-4'] a")
	private WebElement SNPViewPlansLink;
	
	@FindBy(css = "div[data-rel='#plan-list-1'] span.ng-binding")
	private WebElement MAPlanCount;
	
	@FindBy(css = "div[data-rel='#plan-list-4'] span.ng-binding")
	private WebElement SNPPlanCount;

	//Save Results elements
	
	@FindBy(css = ".saveRes button")
	private WebElement saveYourResults;
	
	@FindBy(css = "#saveResultConfirmationTitle")
	private WebElement saveResultsTitle;
	
	@FindBy(css = "#saveResultPopupClose")
	private WebElement saveResultsPopupClose;
	
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement SignInButton;
	
	@FindBy(css = "#cancelButton")
	private WebElement cancelLink;
	
	@FindBy(css = "button#keepShoppingBtn")
	private WebElement KeepShoppingPlansButton;
	
	@FindBy(css = "button#viewPlanBtn")
	private WebElement ViewProfileButton;
	
	@FindBy(css = "li.planTileGrid")
	private List<WebElement> plantiles;
	
	@FindBy(xpath = "//button[contains(text(),'Create Profile')]")
	private WebElement CreateProfileButton;
	
	//Shopping Cart elements
	
	@FindBy(css = "button[class*='saved-items-button']")
	private WebElement mySavedItems ;
	
	@FindBy(css = "img[alt*='Shopping Cart']")
	private WebElement ShoppingCartImg;
		
	@FindBy(css = "h3#guest-profile")
	private WebElement guestProfileLink;
		
	@FindBy(css = "h3#auth-profile")
	private WebElement AuthProfileLink;
		
	@FindBy(xpath = "(//a[contains(text(),'Sign Out')])[2]")
	private WebElement signOut;
		
	@FindBy(xpath = "div[class*='log-in'] a")
	private WebElement signInLink;

	// Edit Responses page Elements

	@FindBy(css = "#prefrencesTitle")
	private WebElement editResponseTitle;

	@FindBy(css = "#backToPlanRecommendation")
	private WebElement returnToPlanLink;

	@FindBy(css = "uhc-list-item.list-item")
	private List<WebElement> allQuestionSection;

	@FindBy(css = "div.viewUpdateSection:nth-of-type(1)>button")
	private WebElement viewUpdateButton;

	@FindBy(css = "div.viewUpdateSection:nth-of-type(1)>button")
	private WebElement viewUpdateButtonBottom;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;

	@FindBy(css = "a#changeMyProviders")
	private WebElement changeDocLink;
	
	@FindBy(css = "#doctors-warning")
	private WebElement WarningDocMsg;

	@FindBy(css = "#modal button[class*='primary']")
	private WebElement locationModalConfirm;

	// Variables

	public HashMap<String, String> inputValues;

	public HashMap<Integer, String> flowNumValue, mapd, ma, pdp, idk;

	public int previousVal = -1;

	public boolean drugEdit = false, docEdit = false;

	public final int coverageNum = 1;

	public void editResponsepage(HashMap<String, String> userInput) {
		System.out.println("Validating Edit Response Page: ");
		inputValues = userInput;
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		pageloadcomplete();
		navigateEditResponsePage(inputValues.get("Plan Type"));
		checkContent("location");
		checkContent("coverage");
		checkContent("special");
		checkContent("travel");
		checkContent("doctor");
		checkContent("drugs");
		checkContent("additional");
		checkContent("cost");
		checkContent("priorities");
		verifyClickEditButton("location", false);
		verifyClickEditButton("coverage", false);
		verifyClickEditButton("special", false);
		verifyClickEditButton("travel", false);
		verifyClickEditButton("doctor", false);
		verifyClickEditButton("drugs", false);
		verifyClickEditButton("additional", false);
		verifyClickEditButton("cost", false);
		verifyClickEditButton("priorities", false);
		checkDrugDocInfo("drugs", false);
		checkDrugDocInfo("doctor", false);
		editCancel(inputValues.get("Plan Type").toLowerCase());
		System.out.println("******  Edit Response Validation Completed ******");
	}

	public void navigateEditResponsePage(String flow) {
		waitForPageLoadSafari();
		validate(editYourResponse, 10);
		editYourResponse.click();
		validate(editResponseTitle);
		validate(returnToPlanLink, 30);
	}
	
	
	String firstRecomPlanName = "";
	String planType = "";
	public String navigateSaveResultsPage() {
		firstRecomPlanName = plantiles.get(0).findElement(By.cssSelector("h2>a")).getText().trim();
		planType = plantiles.get(0).findElement(By.cssSelector("p[class*='planNameType']")).getText().trim();
		validate(saveYourResults, 10);
		saveYourResults.click();
		validate(saveResultsTitle);
		validate(saveResultsPopupClose, 30);
		return firstRecomPlanName;
	}
	
	public void ValidatePREWidget(String userType,String plantype, String username, String password) {
		if(userType.equalsIgnoreCase("Guest")){
			cancelLink.click();
			shoppingcartNavigation(userType,plantype, username, password);
		}else {
			if(validate(SignInButton)) {
				SignInButton.click();
				signIn(username, password);
			}else
				System.out.println("Authenciated profile already Signed In");
		}
		
		
	}
	
	Actions actions = new Actions(driver);
	public void shoppingcartNavigation(String userType, String plantype, String username, String password) {
		if(userType.equalsIgnoreCase("Guest")){
			scrollToView(ShoppingCartImg);
			actions.clickAndHold(ShoppingCartImg).build().perform();
//			desktopCommonUtils.MouseOver(ShoppingCartImg, Browsername);
			guestProfileLink.click();
			threadsleep(3000);
		}else {
			navigatePlanTypeFromMS(plantype);
			navigateSaveResultsPage();
			validateSaveResultModel(userType);
			SignInButton.click();
			signIn(username, password);
			threadsleep(3000);
		}
	}
	
	public void SignIn(String username, String password) {
		System.out.println("Signin the profile:");
		actions.clickAndHold(mySavedItems).build().perform();
		validate(signInLink,10);
		signInLink.click();
		signIn(username, password);
		threadsleep(3000);
	}
	
	public void navigatePlanTypeFromMS(String flow) {
		if(flow.equalsIgnoreCase("pdp")) 
			PDPViewPlansLink.click();
		else if(flow.equalsIgnoreCase("pdp"))
				MAViewPlansLink.click();
		else
				SNPViewPlansLink.click();
		threadsleep(3000);
	}
	

	
	public void validateSaveResultModel(String usertype) {
		if(usertype.equalsIgnoreCase("Authenticated")) {
			validate(saveResultsTitle, 30);
			validate(saveResultsPopupClose, 30);
			validate(KeepShoppingPlansButton, 30);
			if (validate(ViewProfileButton, 30))
				ViewProfileButton.click();
		}else {
			validate(saveResultsTitle, 30);
			validate(saveResultsPopupClose, 30);
			validate(SignInButton, 30);
			validate(CreateProfileButton, 30);
			validate(cancelLink, 30);
		}
	}
	
	public void PRESaveResultModelBtn() {
		SignInButton.click();
		threadsleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "***Sign In With Your One Healthcare ID Page Not Opened***");
		browserBack();
		waitForPageLoadSafari();
		navigateSaveResultsPage();
		CreateProfileButton.click();
		threadsleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/registration"),"***Create One Healthcare ID Page Not Opened***");
		browserBack();
		waitForPageLoadSafari();
		navigateSaveResultsPage();
	}
	
	public void browserBack() {
		driver.navigate().back();
		threadsleep(2000);
	}

	public void checkContent(String section) {
		// boolean sectionStaus = false;
		section = section.toLowerCase();
		String formatedUIText = changetoUIdata(section);
		// System.out.println("Formated UI Text : "+formatedUIText);
		String actualExtractedUIText = getUISectionValue(section);
		// System.out.println("actualExtractedUIText : "+actualExtractedUIText);
		for (String val : formatedUIText.split(",")) {
			Assert.assertTrue(actualExtractedUIText.contains(val),
					val + " is not available in " + actualExtractedUIText);
		}
	}

	public String changetoUIdata(String section) {

		// flow = PlanRecommendationEngineStepDefinition.PREflow;
		String UIValue = null;

		if (section.equalsIgnoreCase("location")) {
			UIValue = inputValues.get("Zip Code") + "," + inputValues.get("CountyDropDown");
		} else if (section.equalsIgnoreCase("coverage")) {
			UIValue = inputValues.get("Plan Type");
			if (UIValue.equalsIgnoreCase("mapd"))
				UIValue = "Medical and prescription drug".toLowerCase();
			if (UIValue.equalsIgnoreCase("MA"))
				UIValue = "Medical only".toLowerCase();
			if (UIValue.equalsIgnoreCase("pdp"))
				UIValue = "Prescription drug only".toLowerCase();
			if (UIValue.equalsIgnoreCase("none"))
				UIValue = "not sure".toLowerCase();
		} else if (section.equalsIgnoreCase("special")) {
			UIValue = inputValues.get("SNP Options");
		} else if (section.equalsIgnoreCase("travel")) {

			UIValue = inputValues.get("Travel Options");
			UIValue = UIValue.replace("withinUS", "within").replace("OutsideUS", "another part").replace("regular",
					"routine");
		} else if (section.equalsIgnoreCase("doctor")) {
			UIValue = inputValues.get("Doctors");
			UIValue = UIValue.replace("UHGNetwork", "UnitedHealthcare").replace("AcceptsMedicare", "any doctor")
					.replace("Lookup", "Look up");

		} else if (section.equalsIgnoreCase("drugs")) {
			UIValue = inputValues.get("Drug Selection");
		} else if (section.equalsIgnoreCase("additional")) {
			UIValue = inputValues.get("Additional Option");
			// Works for all Yes or all No
		} else if (section.equalsIgnoreCase("cost")) {
			UIValue = inputValues.get("Preference Option");
		} else if (section.equalsIgnoreCase("priorities")) {
			UIValue = inputValues.get("Priorities");
		}
		return UIValue.toLowerCase();
	}

	public String getUISectionValue(String section) {
		String actualExtractedUIText = null;
		for (WebElement elm : allQuestionSection) {
			actualExtractedUIText = elm.getText().toLowerCase();
			if (actualExtractedUIText.contains(section)) {
				break;
			}
		}
		return actualExtractedUIText;
	}

	public void verifyClickEditButton(String section, boolean click) {
		boolean editButton = false;
		for (WebElement elem : allQuestionSection) {
			String tempTxt = elem.findElement(By.cssSelector("button")).getText().toLowerCase();
			System.out.println("tempTxt : " + tempTxt);
			if (tempTxt.contains(section)) {
				editButton = true;
				if (click) {// Edit button Click
					if (section.equalsIgnoreCase("location")) {
						boolean lookup = validate(changeDocLink, 5);
						elem.findElement(By.cssSelector("button")).click();
						if (lookup)
							locationModalConfirm.click();
					} else {
						elem.findElement(By.cssSelector("button")).click();
					}
				}
				break;
			}
		}
		Assert.assertTrue(editButton, "Edit button is not available for " + section);
	}

	public void returnVPP(String button) {
		if (button.toLowerCase().contains("update"))
			viewUpdateButton.click();
		else
			returnToPlanLink.click();
	}

	public void checkDrugDocInfo(String section, boolean modifiedValue) {
		String UIInfo = getUISectionValue(section);
		String givenInfo = null;
		if (section.contains("drugs")) {
			if (modifiedValue)
				givenInfo = inputValues.get("Drug Details").split(",")[2].toLowerCase();
			else
				givenInfo = inputValues.get("Drug Details").split(",")[2].toLowerCase();
		} else {
			if (modifiedValue)
				givenInfo = inputValues.get("Doctors Search Text").toLowerCase();
			else
				givenInfo = inputValues.get("Doctors Search Text").toLowerCase();
		}
		Assert.assertTrue(UIInfo.contains(givenInfo), givenInfo + " is not available in " + UIInfo);
	}

	public void setKeyQuestions() {

		mapd = new HashMap<Integer, String>();
		mapd.put(0, "location");
		mapd.put(1, "coverage");
		mapd.put(2, "special");
		mapd.put(3, "travel");
		mapd.put(4, "doctor");
		mapd.put(5, "drugs");
		mapd.put(6, "additional");
		mapd.put(7, "cost");
		mapd.put(8, "priorities");

		ma = new HashMap<Integer, String>();
		ma.put(0, "location");
		ma.put(1, "coverage");
		ma.put(2, "special");
		ma.put(3, "travel");
		ma.put(4, "doctor");
		ma.put(5, "additional");
		ma.put(6, "cost");
		ma.put(7, "priorities");

		pdp = new HashMap<Integer, String>();
		pdp.put(0, "location");
		pdp.put(1, "coverage");
		pdp.put(2, "drugs");

		idk = new HashMap<Integer, String>(mapd);

	}

	public Integer chooseRandomQuesNum(String flow) {
		setKeyQuestions();
		Random rand = new Random();
		int rval; // Exclude Coverage
		do {
			if (flow.equalsIgnoreCase("pdp"))
				rval = rand.nextInt(pdp.size());
			else if (flow.equalsIgnoreCase("ma"))
				rval = rand.nextInt(ma.size());
			else
				rval = rand.nextInt(mapd.size());
		} while (rval == previousVal || rval == coverageNum);
		System.out.println("rval " + rval);
		previousVal = rval;
		return rval;
	}

	public String getSection(String flow, Integer num) {
		String section = null;
		if (flow.equalsIgnoreCase("pdp"))
			section = pdp.get(num);
		else if (flow.equalsIgnoreCase("ma"))
			section = ma.get(num);
		else
			section = mapd.get(num);

		return section;

	}

	public void editCancel(String flow) {
		System.out.println("Flow : " + flow);
		int randomEdit = chooseRandomQuesNum(flow);
		System.out.println("Random Number : " + randomEdit);
		String randomSection = getSection(flow, randomEdit);
		System.out.println("Performing Random Cancel action for : " + randomSection);
		verifyClickEditButton(randomSection, true);
		validate(progressInfo, 10);
		String progressText = progressInfo.getText().toLowerCase();
		Assert.assertTrue(progressText.contains(randomSection) && progressText.contains("100%"),
				"Progres Bar does not have required Info");
		cancelButton.click();
		Assert.assertTrue(validate(returnToPlanLink, 10), "Invalid cancel action");
	}

	public void editUserResponse(HashMap<String, String> userInput) {
		System.out.println("Edit User Response: ");
		inputValues = userInput;
		pageloadcomplete();
		navigateEditResponsePage(inputValues.get("Plan Type"));
		editUpdate(inputValues.get("Plan Type").toLowerCase());
		Assert.assertTrue(validate(viewUpdateButton, 10), "View Updated Button should be displayed");
		editUpdate(inputValues.get("Plan Type").toLowerCase());
		System.out.println("******  Edit Response Completed ******");
	}

	public void editUpdate(String flow) {
		System.out.println("Flow : " + flow);
		int randomEdit = chooseRandomQuesNum(flow);
		System.out.println("Random Number : " + randomEdit);
		String randomSection = getSection(flow, randomEdit);
		System.out.println("Performing Random Edit action for : " + randomSection);
		verifyClickEditButton(randomSection, true);
		validate(progressInfo, 10);
		String progressText = progressInfo.getText().toLowerCase();
		Assert.assertTrue(progressText.contains(randomSection) && progressText.contains("100%"),
				"Progres Bar does not have required Info");
		editValue(randomSection);
		// cancelButton.click();
		// Assertion.assertTrue(validate(returnToPlanLink,10),"Invalid cancel action");
	}

	public void editValue(String section) {

		if (section.equalsIgnoreCase("location")) {
			String zipcode = inputValues.get("Zip Code");
			String multi = inputValues.get("Is Multi County");
			String county = inputValues.get("CountyDropDown");
			PlanRecommendationEngineLandingAndZipcodePages loc = new PlanRecommendationEngineLandingAndZipcodePages(
					driver);
			loc.edit_location(zipcode, multi, county);
			jsClickNew(saveBtn);
			checkContent("location");
		} else if (section.equalsIgnoreCase("drugs")) {
			String drugSelect = inputValues.get("Drug Selection");
			PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);
			drug.drugpageOptions(drugSelect);
			if (drugSelect.equalsIgnoreCase("Yes")) {
				String drugsDetails = inputValues.get("Drug Details");
				jsClickNew(continueBtn);
				drug.drugsHandlerWithdetails(drugsDetails);
				jsClickNew(saveBtn);
				checkDrugDocInfo("drugs", false);
				drugEdit = true;
			} else {
				jsClickNew(saveBtn);
			}
			checkContent("drugs");
		} else if (section.equalsIgnoreCase("special")) {
			PlanRecommendationEngineSpecialNeedsPage snp = new PlanRecommendationEngineSpecialNeedsPage(driver);
			snp.edit_specialneeds(inputValues.get("SNP Options"));
			jsClickNew(saveBtn);
			checkContent("special");
		} else if (section.equalsIgnoreCase("travel")) {
			PlanRecommendationEngineTravelPage travel = new PlanRecommendationEngineTravelPage(driver);
			travel.edit_travel(inputValues.get("Travel Options"));
			jsClickNew(saveBtn);
			checkContent("travel");
		} else if (section.equalsIgnoreCase("additional")) {
			PlanRecommendationEngineAdditionalServicesPage add = new PlanRecommendationEngineAdditionalServicesPage(
					driver);
			add.edit_additional(inputValues.get("Additional Option"));
			jsClickNew(saveBtn);
			checkContent("additional");
		} else if (section.equalsIgnoreCase("cost")) {
			PlanRecommendationEngineCostPreferencesPage cost = new PlanRecommendationEngineCostPreferencesPage(driver);
			cost.edit_cost(inputValues.get("Preference Option"));
			jsClickNew(saveBtn);
			checkContent("cost");
		} else if (section.equalsIgnoreCase("doctor")) {
			PlanRecommendationEngineDoctorsPage doc = new PlanRecommendationEngineDoctorsPage(driver);
			doc.edit_doctor(inputValues.get("Doctors"), inputValues.get("Doctors Search Text"),
					inputValues.get("Multi Doctor"));
//			jsClickNew(saveBtn);
			checkContent("doctor");
			if (inputValues.get("Doctors").contains(("look"))) {
				checkDrugDocInfo("doctor", false);
				docEdit = true;
			}
		} else if (section.equalsIgnoreCase("priorities")) {
			PlanRecommendationEnginePrioritiesPage priority = new PlanRecommendationEnginePrioritiesPage(driver);
			priority.prioritiesFunctional(inputValues.get("Priority Option"), inputValues.get("Priorities"));
			jsClickNew(saveBtn);
			checkContent("priorities");
		}
	}

	public void addDoctorEditResponse(HashMap<String, String> userInput) {
		System.out.println("Add Provider: ");
		inputValues = userInput;
		pageloadcomplete();
		navigateEditResponsePage(inputValues.get("Plan Type"));
		changeDocLink.click();
		PlanRecommendationEngineDoctorsPage doc = new PlanRecommendationEngineDoctorsPage(driver);
		doc.addProviderEdit(inputValues.get("Doctors Search Text"));
		checkContent("doctor");
		checkDrugDocInfo("doctor", false);
		System.out.println("******  Add Provider Completed ******");
	}

	public void changeCoverage(HashMap<String, String> userInput) {
		System.out.println("Change Coverage Options: ");
		inputValues = userInput;
		verifyClickEditButton("coverage", true);
		validate(progressInfo, 10);
		PlanRecommendationEngineCoverageOptionPage coverage = new PlanRecommendationEngineCoverageOptionPage(driver);
		coverage.chooseCoverageOption(inputValues.get("Plan Type").toUpperCase().replace("PDPTOMAPD", "MAPD"));
		jsClickNew(saveBtn);
	}
	
	public void addSNPEditResponse(HashMap<String, String> userInput) {
		System.out.println("Change SpecialNeeds Options:");
		inputValues = userInput;
		pageloadcomplete();
		navigateEditResponsePage(inputValues.get("Plan Type"));
		verifyClickEditButton("special", true);
		validate(progressInfo, 10);
		String progressText = progressInfo.getText().toLowerCase();
		Assert.assertTrue(progressText.contains("special") && progressText.contains("100%"),
				"Progres Bar does not have required Info");
		editValue("special");
		System.out.println("******  Add SpecialNeeds Completed ******");
	}
	
	public void addLocationEditResponse(HashMap<String, String> userInput) {
		System.out.println("Change SpecialNeeds Options:");
		inputValues = userInput;
		pageloadcomplete();
//		navigateEditResponsePage(inputValues.get("Plan Type"));
		verifyClickEditButton("location", true);
		validate(progressInfo, 10);
		String progressText = progressInfo.getText().toLowerCase();
		Assert.assertTrue(progressText.contains("location") && progressText.contains("100%"),
				"Progres Bar does not have required Info");
		editValue("location");
		validate(WarningDocMsg, 10);
		Assert.assertTrue(WarningDocMsg.getText().contains("Warning:"), "Doctors Warning message is not displayed");
		System.out.println("******  Add Location Completed ******");
	}

	public void checkCoveragevalue(HashMap<String, String> userInput) {
		inputValues = userInput;
		checkContent("coverage");
	}

	public void addDrugs(HashMap<String, String> userInput) {
		inputValues = userInput;
		editValue("drugs");
	}
	
	public void validateSaveResults() {
		System.out.println("Validating Save Results : ");
		pageloadcomplete();
		waitForPageLoadSafari();
		navigateSaveResultsPage();
		threadsleep(5000);
	}
	
	public void signIn(String username, String password) {
		try {
			Thread.sleep(3000);
			waitForPageLoadSafari();
			driver.findElement(By.xpath("//input[contains(@id,'userNameId_input')]")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
			waitForPageLoadSafari();
			Thread.sleep(3000);
			String Question = driver.findElement(By.cssSelector("span#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("input#UnrecognizedSecAns_input"));
			waitforElement(securityAnswer);
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				securityAnswer.sendKeys("name1");
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
			waitForPageLoadSafari();
//			CommonUtility.waitForPageLoadNew(driver, signOut, 15);

		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
		}

	}

}