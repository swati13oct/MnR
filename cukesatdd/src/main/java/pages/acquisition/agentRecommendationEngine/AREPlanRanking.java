/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class AREPlanRanking extends UhcDriver {

	public AREPlanRanking(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	ARECommonutility commonUtils = new ARECommonutility(driver);
	List<String> drugplansDetails = new ArrayList<String>();
	List<String> originalplanNames = new ArrayList<String>();

	@FindBy(css = "a#aarpSVGLogo")
	private WebElement planRankingTxt;

	@FindBy(css = "div#multiSelect>#plan-ranking")
	private WebElement planRankingDropdown;

	@FindBy(css = "#printComparison")
	private WebElement print;

	@FindBy(css = "div#multiSelect label[for='as_dental']")
	private WebElement dentalCheckLabel;

	@FindBy(css = "div#multiSelect label[for='as_dental']>input")
	private WebElement dentalCheck;

	@FindBy(css = "div#multiSelect label[for='as_vision']")
	private WebElement visionCheckLabel;

	@FindBy(css = "div#multiSelect label[for='as_vision']>input")
	private WebElement visionCheck;

	@FindBy(css = "div#multiSelect label[for='as_hearing']")
	private WebElement hearingCheckLabel;

	@FindBy(css = "div#multiSelect label[for='as_hearing']>input")
	private WebElement hearingCheck;

	@FindBy(css = "div#multiSelect label[for='as_fitness']")
	private WebElement fitnessCheckLabel;

	@FindBy(css = "div#multiSelect label[for='as_fitness']>input")
	private WebElement fitnessCheck;

	@FindBy(css = "div#multiSelect label[for='cs_low']")
	private WebElement lowPremiumCheckLabel;

	@FindBy(css = "div#multiSelect label[for='cs_low']>input")
	private WebElement lowPremiumCheck;

	@FindBy(css = "div#multiSelect label[for='travel_regular']")
	private WebElement travelCheckLabel;

	@FindBy(css = "div#multiSelect label[for='travel_regular']>input")
	private WebElement travelCheck;

	@FindBy(css = "div#multiSelect label[for='drug']")
	private WebElement drugCheckLabel;

	@FindBy(css = "div#multiSelect label[for='drug']>input")
	private WebElement drugCheck;

	@FindBy(css = "div#multiSelect label[for='doctor_lookup']")
	private WebElement doctorCheckLabel;

	@FindBy(css = "div#multiSelect label[for='doctor_lookup']>input")
	private WebElement doctorCheck;

	@FindBy(css = "div#multiSelect button[class*='uhc-button']")
	private WebElement applyBtn;

	@FindBy(css = "#yourdoctorsheading")
	private WebElement DocName;

	@FindBy(css = "a[dtmname*=' Drugs']")
	private WebElement AddDrugsLink;

	@FindBy(css = "a[dtmname*=' Doctors']")
	private WebElement AddDoctorsLink;

	@FindBy(css = "a[dtmname*=' Hospitals']")
	private WebElement AddHospitalsLink;

	@FindBy(css = "#compare-table-header th[class*='uhc-slide-table'] div[class*='text-semibold']")
	private WebElement NumberofPlans;

	@FindBy(css = "#compare-table-header th[class*='uhc-slide-table'] div[class*='text-dark']")
	private List<WebElement> plancards;

	@FindBy(css = "#compare-table-header th[class*='uhc-slide-table'] a[dtmname*='View Details']")
	private List<WebElement> viewplandetailslink;

	@FindBy(css = "#enroll-table div[id*='enrollbtnplancompare'] span[class*='uhc-button']")
	private List<WebElement> enrollBtn;

	@FindBy(css = ".uhc-container div.content h2:nth-child(2)")
	private WebElement planNameVPPDetailsPage;

	@FindBy(css = "a.compare-link")
	private List<WebElement> backtoComparePlans;

	@FindBy(css = "#compare-table-header div[class*='unliked savePlanText']")
	private List<WebElement> saveplanComparepage;

	@FindBy(css = "#compare-table-header div[class='liked savePlanText']")
	private List<WebElement> unsaveplanComparepage;

	@FindBy(css = "div[class*='dupIcon'] img[dtmid*='visitor_profile']")
	private WebElement viewSavedItems;

	@FindBy(css = "#dashPlansContainer div[class*='item advantagePlan'] h4")
	private List<WebElement> planNamesVisitorPrf;

	@FindBy(css = "div[class*='title-compare'] button[class*='btn']")
	private WebElement comparePlansBtn;

	@FindBy(css = "a[dtmname*='Edit Drugs']")
	private WebElement editDrugs;

	@FindBy(css = "a[dtmname*='Edit Doctors']")
	private WebElement editDoctors;

	@FindBy(css = "span[class*='multiple-added-text'] button[class*='cta-button']")
	private List<WebElement> comparePlansBtninVpp;

	@FindBy(css = ".segment h2")
	private WebElement planNameEnrollPage;

	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;

	@FindBy(css = "#header .container")
	private WebElement zipInfo;

	@FindBy(css = "#compare-table div[class*='flex'][class*='scope']")
	private List<WebElement> planNameSection;

	@FindBy(css = "#compare-table div[class*='flex'][class*='scope']>div[class*='flex']>div")
	private List<WebElement> planNamesOnly;

	@FindBy(css = "#compare-table div[class*='flex'][class*='scope'] button[class*='delete']")
	private List<WebElement> plandeleteButtons;

	@FindBy(css = "div.plan-ranking-message")
	private WebElement successMsg;

	@FindBy(css = "#selectCounty p>a")
	private List<WebElement> selectMultiZip;

	@FindBy(css = ".modal-body #multiCountyCancelBtn")
	private WebElement confrimButton;

	@FindBy(css = "select#plan-year")
	private WebElement planYear;

	@FindBy(css = "#addanotherplanbutton")
	private WebElement addPlan;

	@FindBy(css = "div[class*='compare']>div[class*='compare-box']")
	private List<WebElement> vppCompare;

	@FindBy(css = "div[class*='compare-box'] button")
	private List<WebElement> vppCompareButton;

	public void validateUIElements() {
		System.out.println("Validate ARE UI Elements : ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		Assert.assertTrue(validate(planRankingTxt), "Ranking text is missing");
		Assert.assertTrue(validate(planRankingDropdown), "Ranking Dropdown is missing");
		planRankingDropdown.click();
		Assert.assertTrue(validate(dentalCheckLabel), "Dental Checkbox is missing");
		Assert.assertTrue(validate(visionCheckLabel), "Vision Checkbox is missing");
		Assert.assertTrue(validate(hearingCheckLabel), "Hearing Checkbox is missing");
		Assert.assertTrue(validate(fitnessCheckLabel), "Fitness Checkbox is missing");
		Assert.assertTrue(validate(lowPremiumCheckLabel), "Low Premium Checkbox is missing");
		Assert.assertTrue(validate(travelCheckLabel), "Travel Checkbox is missing");
		Assert.assertTrue(validate(drugCheckLabel), "Drug Checkbox is missing");
		Assert.assertTrue(validate(doctorCheckLabel), "Doctor Checkbox is missing");
		Assert.assertTrue(validate(applyBtn), "Apply button is missing");

		Assert.assertFalse(drugCheck.isSelected(), "Drug is selected by default");
		Assert.assertFalse(doctorCheck.isSelected(), "Doctor is selected by default");

		// Deselect All
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", false);
		applyBtn.click();
		threadsleep(3000);
		boolean dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);

		// Select All
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", true);
		applyBtn.click();
		threadsleep(3000);
		dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
		threadsleep(3000);
	}

	public void optionSelection(String option, boolean select) {
		String options[] = option.split(",");
		for (int i = 0; i < options.length; i++) {
			checkUncheck(options[i], select);
			threadsleep(1000);
		}
	}

	public void checkUncheck(String checkOption, boolean select) {
		System.out.println("Selecting Option " + checkOption + " : " + select);
		WebElement elemCheck = null, elemClick = null;
		if (checkOption.equalsIgnoreCase("dental")) {
			elemCheck = dentalCheck;
			elemClick = dentalCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("vision")) {
			elemCheck = visionCheck;
			elemClick = visionCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("hearing")) {
			elemCheck = hearingCheck;
			elemClick = hearingCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("fitness")) {
			elemCheck = fitnessCheck;
			elemClick = fitnessCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("lowpremium")) {
			elemCheck = lowPremiumCheck;
			elemClick = lowPremiumCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("travel")) {
			elemCheck = travelCheck;
			elemClick = travelCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("drug")) {
			elemCheck = drugCheck;
			elemClick = drugCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("doctor")) {
			elemCheck = doctorCheck;
			elemClick = doctorCheckLabel;
		}

		if (select && !elemCheck.isSelected()) {
			elemClick.click();
		}
		if (!select && elemCheck.isSelected()) {
			elemClick.click();
		}

		if (select)
			Assert.assertTrue(elemCheck.isSelected(), "Unable to Select " + elemCheck);
		else
			Assert.assertFalse(elemCheck.isSelected(), "Unable to Deselect " + elemCheck);
	}

	public void agentaddDrugsPlanCompare(String drugDetails) {
		pageloadcomplete();
		System.out.println("Validate Adding Drugs from Plan Compare page : ");
		validate(AddDrugsLink);
		AddDrugsLink.click();
		DCEPage dceobj = new DCEPage(driver);
		dceobj.drugsHandlerWithdetails(drugDetails);
		returnToPlanCompare();
	}

	public void returnToPlanCompare() {
		DCEPage dceobj = new DCEPage(driver);
		dceobj.returnToCompare();
		validate(planRankingDropdown, 60);
	}

	public void DrugsInPlanCompare(String drugDetails) {
		pageloadcomplete();
		System.out.println("Validate Added Drugs in Plan Compare page : ");
	}

	public void DeleteinDCE(String drugDetails) {
		pageloadcomplete();
		System.out.println("Delete Added Drugs in DCE page : ");
		validate(AddDrugsLink);
		AddDrugsLink.click();
		DCEPage dceobj = new DCEPage(driver);
		dceobj.deletedrugsHandlerWithdetails(drugDetails);
	}

	public void agentaddProvidersPlanCompare(String doctors) {
		pageloadcomplete();
		System.out.println("Validate Adding Doctors from Plan Compare page : ");
		validate(AddDoctorsLink);
		AddDoctorsLink.click();
		doctorModellookup(doctors);
	}

	public void doctorModellookup(String search) {
		WerallyPage rallyobj = new WerallyPage(driver);
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		rallyobj.validateLinksanotherWindow(curWindow, "Adding Doctors", search);
		threadsleep(5000);
	}

	public void DoctorsInPlanCompare(String docDetails) {
		pageloadcomplete();
		System.out.println("Validate Added Doctors in Plan Compare page : ");
	}

	public void DeleteinWerally(String docDetails) {
		pageloadcomplete();
		System.out.println("Delete Added Doctors in Werally page : ");
		validate(AddDoctorsLink);
		AddDoctorsLink.click();
		WerallyPage rallyobj = new WerallyPage(driver);
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		rallyobj.validateLinksanotherWindow(curWindow, "Delete Doctors", docDetails);
		threadsleep(5000);
	}

	public void validateViewPlanDetails() {
		System.out.println("Validate ARE View Plan Details : ");
		int totalnumberofplans = Integer.parseInt(NumberofPlans.getText().trim().split(" ")[0]);
		verifyPlanNames(plancards, totalnumberofplans, viewplandetailslink);
	}

	public void validateEnrollPlan() {
		System.out.println("Validate ARE Enroll Plan : ");
		int totalnumberofplans = Integer.parseInt(NumberofPlans.getText().trim().split(" ")[0]);
		verifyPlanNames(plancards, totalnumberofplans, enrollBtn);
	}

	public void verifyPlanNames(List<WebElement> plansName, int PlanCount, List<WebElement> viewplandetails) {
		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansName.size());
		System.out.println(viewplandetails.size());
		int plan = 0;
		if (plansName.size() != viewplandetails.size()) {
			for (plan = 1; plan < PlanCount; plan++) {
				for (int i = 0; i < viewplandetails.size(); i++)
					vppPlans.add(verifygetplanName(plansName.get(plan + i), viewplandetails.get(i)));
			}
			System.out.println("Plan Name compared Successful Clicks on Plan Name");
		} else {
			for (plan = 0; plan < PlanCount; plan++) {
				for (int i = 0; i < viewplandetails.size(); i++)
					vppPlans.add(verifygetplanName(plansName.get(i), viewplandetails.get(i)));
			}
			System.out.println("Plan Name compared Successful Clicks on Enroll Button");
		}
	}

	public String verifygetplanName(WebElement plan, WebElement planInPDP) {
		String actualplanName = "";
		String exceptedplanName = plan.getText().trim();
		String VIew = planInPDP.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
		System.out.println("View " + VIew);
		if (VIew.contains("View Plan Details")) {
			planInPDP.click();
			pageloadcomplete();
			actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
			System.out.println("Plan Name in VPP Details Page: " + actualplanName);
			Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
			WebElement comparePlanlink = backtoComparePlans.get(0);
			comparePlanlink.click();
		} else {
			scrollToView(planInPDP);
			planInPDP.click();
			pageloadcomplete();
			actualplanName = planNameEnrollPage.getText().trim();
			System.out.println("Plan Name in Plan Enroll Page: " + actualplanName);
			Assert.assertTrue(actualplanName.contains(exceptedplanName), "--- Plan name are not matches---");
			browserBack();
			try {
				WebDriverWait wait = new WebDriverWait(driver, 2);
				if (wait.until(ExpectedConditions.alertIsPresent()) == null)
					System.out.println("alert was not present");
				else {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					System.out.println("alert was present and accepted");
				}

			} catch (Exception e) {
				// exception handling
			}
		}
		pageloadcomplete();
		return actualplanName;
	}

	public void validateSavePlan() {
		System.out.println("Validate ARE Save Plans functionality : ");
		int saveplans = 2;
		verifySavePlans(plancards, saveplans, saveplanComparepage);
	}

	public void verifyRankingOrder(String zip, String rankOptions, String curPlan, String changeOrder,
			String planOrders) {
		System.out.println("Verify Ranking and Plans Reorder");
		int planStartCount = 0;
		Assert.assertTrue(zipInfo.getText().contains(zip), "Not Expected Zip Code");

		List<String> plansDetails = getPlanSectionDetails();

		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
			Assert.assertTrue(plansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", false);
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertTrue(newplansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + newplansDetails.get(i));
			j++;
		}

		// Validate Ranking Order

		if (planOrders.isEmpty() && changeOrder.equalsIgnoreCase("yes")) {
			Assert.assertFalse(plansDetails.equals(newplansDetails), "Plans are not Re-ordered");
		} else if (planOrders.isEmpty() && !changeOrder.equalsIgnoreCase("yes")) {
			Assert.assertTrue(plansDetails.equals(newplansDetails), "Plans are Re-ordered");
		} else {
			j = 0;
			ArrayList<String> givenplansDetails = new ArrayList<String>(Arrays.asList(planOrders.split(",")));
			for (int i = planStartCount; i < givenplansDetails.size(); i++) {
				Assert.assertTrue(newplansDetails.get(i).contains(givenplansDetails.get(j).toUpperCase()),
						"Expected Ranking is Not applied Expected: " + givenplansDetails.get(j) + " Actual: "
								+ newplansDetails.get(i));
				j++;
			}
		}

		// Check current Plan is not changed and no BestMatch text
		if (planStartCount == 1) {
			Assert.assertTrue(newplansDetails.get(0).contains("CURRENTPLAN"), "Change is Current plan position");
			Assert.assertFalse(newplansDetails.get(0).contains("BEST"), "Current plan is with Best Match text");
		}

		// Uncheck all and validate original order
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection(rankOptions, false);
		applyBtn.click();
		threadsleep(3000);
		boolean msg = validate(successMsg, 10); // Validate message disappear
		Assert.assertFalse(msg);

		List<String> originalplansDetails = getPlanSectionDetails();

		Assert.assertTrue(plansDetails.equals(originalplansDetails), "Return to Original order is failed");
		System.out.println("------- Ranking Validation completed -------");
	}

	public void verifySavePlans(List<WebElement> plansName, int saveplans, List<WebElement> saveplanComparepage) {
		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansName.size());
		System.out.println(saveplanComparepage.size());
		int plan = 0;
		if (plansName.size() != saveplanComparepage.size()) {
			for (plan = 1; plan < saveplans; plan++) {
				for (int i = 0; i < saveplans; i++)
					vppPlans.add(savingplans(plansName.get(plan + i), saveplanComparepage.get(i), i));
			}
			Collections.sort(vppPlans);
			System.out.println(vppPlans);
			visitorprofile(planNamesVisitorPrf, vppPlans);
			comparePlansBtn.click();
		} else {
			for (plan = 0; plan < saveplans; plan++) {
				for (int i = 0; i < saveplans; i++)
					vppPlans.add(savingplans(plansName.get(i), saveplanComparepage.get(i), i));
			}
			Collections.sort(vppPlans);
			System.out.println(vppPlans);
			visitorprofile(planNamesVisitorPrf, vppPlans);
			comparePlansBtn.click();
		}
		System.out.println("Plan Name compared Successful Clicks on Save Plan");
	}

	public String savingplans(WebElement plan, WebElement saveplan, int i) {
		String exceptedplanName = plan.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
		if (saveplan.getText().trim().equals("Save Plan")) {
			saveplan.click();
		} else {
			unsaveplanComparepage.get(i).click();
			threadsleep(3000);
			saveplan.click();
		}
		threadsleep(5000);
		return exceptedplanName;
	}

	public void visitorprofile(List<WebElement> plansName, List<String> vppPlans) {
		validate(viewSavedItems);
		viewSavedItems.click();
		String actualplanName = "";
		String exceptedplanName = "";
		pageloadcomplete();
		for (int i = 0; i < plansName.size(); i++) {
			actualplanName = plansName.get(i).getText().trim();
			System.out.println("Plan Name in Visitor Profile Page: " + actualplanName);
			exceptedplanName = vppPlans.get(i);
			Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
		}
	}

	public void browserBack() {
		driver.navigate().back();
		plansLoader();
	}

	public void plansLoader() {
		pageloadcomplete();
		validate(planLoaderscreen, 60);
		waitforElementInvisibilityInTime(planLoaderscreen, 60);
		threadsleep(5000);// Plan loader
	}

	public void checkCountyPlanYear(String multiCounty, String year) {
		threadsleep(1000);
		if (!multiCounty.isEmpty() && !multiCounty.toUpperCase().contains("NONE")) {
			if (selectMultiZip.get(0).getText().toUpperCase().contains(multiCounty.toUpperCase()))
				selectMultiZip.get(0).click();
			else if (selectMultiZip.get(1).getText().toUpperCase().contains(multiCounty.toUpperCase()))
				selectMultiZip.get(1).click();
			else if (selectMultiZip.get(2).getText().toUpperCase().contains(multiCounty.toUpperCase()))
				selectMultiZip.get(2).click();
			waitforElementInvisibilityInTime(planLoaderscreen, 60);
			threadsleep(5000);// Plan loader
		}
		confirmAlert(60);
		changePlanyear(year);
	}

	public void changePlanyear(String year) {
		String curYear = getCurrentYear();
		// Checking and Changing to Current Year
		if (year.equalsIgnoreCase("current")) {
			if (validate(planYear, 10)) {
				Select planYearSelect = new Select(planYear);
				if (!planYearSelect.getFirstSelectedOption().toString().trim().equalsIgnoreCase(curYear)) {
					planYearSelect.selectByVisibleText(curYear);
					confirmAlert();
				}
			}
		}

		// Checking and Changing Future Year
		if (year.equalsIgnoreCase("future")) {
			if (validate(planYear, 10)) {
				Select planYearSelect = new Select(planYear);
				if (planYearSelect.getFirstSelectedOption().toString().trim().equalsIgnoreCase(curYear)) {
					planYearSelect.selectByVisibleText(String.valueOf(Integer.valueOf(curYear) + 1));
					confirmAlert();
				}
			} else {
				Assert.assertTrue(false, "Plan Year Toggle is Needed to set Future Year");
			}
		}
	}

	public String getCurrentYear() {
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date date = new Date();
		String curDate = dateFormat.format(date);
		return curDate.split("/")[2];
	}

	public void confirmAlert() {
		if (validate(confrimButton, 20))
			confrimButton.click();
	}

	public void confirmAlert(int time) {
		if (validate(confrimButton, time))
			confrimButton.click();
	}

//Session Cookie Methods

	public void verifyClearSession(String zip) {
		System.out.println("Verify cleared in session storage");
		int planStartCount = 0;
		Assert.assertTrue(zipInfo.getText().contains(zip), "Not Expected Zip Code");
		List<String> plansDetails = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement elem : planNameSection) {
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "");
			plansDetails.add(val);
		}

		// Validate best match Text not displaying in UI
		int j = 1, k = planStartCount;
		for (int i = k; i < plansDetails.size() && j <= 4; i++) {
			Assert.assertFalse(plansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Plans are having Best Match Text : " + plansDetails.get(i));
			j++;
		}
	}

	public void verifySavedSession(String zip, String rankOptions, String rankOptions1) {
		System.out.println("Verify saved in session storage");
		planRankingDropdown.click();
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");
		planRankingDropdown.click();
		optionSelection(rankOptions, true);
		optionSelection(rankOptions1, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");
		planRankingDropdown.click();
		optionSelection(rankOptions1, true);
	}

	public void verifyDrugDoc(String rankOptions, String planOrders, String curPlan) {
		int planstart = 0;
		if (curPlan.equalsIgnoreCase("yes")) {
			planstart = 1;
//			Assert.assertTrue(drugplansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Verify Drug and Doctors Session Storage");
		planRankingDropdown.click();
		drugDocDisable(rankOptions, false);
		applyBtn.click();
		threadsleep(3000);

		List<String> newplansDetails = new ArrayList<String>();
		for (WebElement elem : planNameSection) {
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "").split("SAVEPLAN")[0].split("CLOSE")[0]
					.split("\n")[0];
			newplansDetails.add(val);
		}
		System.out.println(newplansDetails);

		ArrayList<String> givenplansDetails = new ArrayList<String>(Arrays.asList(planOrders.split(",")));
		int j = 0;
		for (int i = planstart; i < givenplansDetails.size(); i++) {
			Assert.assertTrue(
					newplansDetails.get(i).toUpperCase().contains(givenplansDetails.get(j).trim().toUpperCase()),
					"Expected Ranking is Not applied Expected: " + givenplansDetails.get(j).trim().toUpperCase()
							+ " Actual: " + newplansDetails.get(i).toUpperCase());
			j++;
		}
	}

	public void drugDocDisable(String option, boolean select) {
		String options[] = option.split(",");
		for (int i = 0; i < options.length; i++) {
			disable(options[i], select);
			threadsleep(1000);
		}
	}

	public void disable(String checkOption, boolean select) {
		System.out.println("Selecting Option " + checkOption + " : " + select);
		WebElement elemCheck = null, elemClick = null;
		if (checkOption.equalsIgnoreCase("drug")) {
			elemCheck = drugCheck;
			elemClick = drugCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("doctor")) {
			elemCheck = doctorCheck;
			elemClick = doctorCheckLabel;
		}
		if (select)
			Assert.assertFalse(elemCheck.isEnabled(), "Unable to Select " + elemCheck);
	}

	public void applyRankingGetplanNames(String rankOptions) {
		System.out.println("Appling Ranking after adding Drugs");
		threadsleep(3000);
		pageloadcomplete();
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		DocName.click();
//		scrollToView(planRankingDropdown);
		scrollToView(print);
		scrollToView(AddDoctorsLink);
		threadsleep(3000);
		scrollToView(planRankingTxt);
		action.moveToElement(planRankingDropdown).perform();
		action.moveToElement(planRankingDropdown).click().perform();
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		for (WebElement elem : planNamesOnly) {
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "");
			drugplansDetails.add(val);
		}
	}

	public void OriginalPlanOrder(String rankOptions) {
		System.out.println("Fetching Original PlanOrder in plancompare page");
		planRankingDropdown.click();
		drugDocDisable(rankOptions, false);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement elem : planNamesOnly) {
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "");
			originalplanNames.add(val);
		}
		System.out.println("Original Plan Orders" + originalplanNames);
	}

	public void rankingplancomparion(String curPlan, String changeOrder, String planOrders) {
		int planStartCount = 0;
		threadsleep(3000);
		pageloadcomplete();
		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
//			Assert.assertTrue(drugplansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertTrue(newplansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + newplansDetails.get(i));
			j++;
		}

		// Validate Ranking Order

		if (planOrders.isEmpty() && changeOrder.equalsIgnoreCase("yes")) {
			Assert.assertFalse(drugplansDetails.equals(newplansDetails), "Plans are not Re-ordered");
		} else if (planOrders.isEmpty() && !changeOrder.equalsIgnoreCase("yes")) {
			Assert.assertTrue(drugplansDetails.equals(newplansDetails), "Plans are Re-ordered");
		}
	}

	public void verifyAutoRankingPlanYear(String year, String zip, String rankOptions, String curPlan,
			String changeOrder, String planOrders) {
		System.out.println("Verify Auto Ranking for Plan year change..");
		int planStartCount = 0;
		Assert.assertTrue(zipInfo.getText().contains(zip), "Not Expected Zip Code");
		List<String> plansDetails = getPlanSectionDetails();

		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
			Assert.assertTrue(plansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", false);
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertTrue(newplansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + newplansDetails.get(i));
			j++;
		}

		if (year.equalsIgnoreCase("current"))
			changePlanyear("future");
		else
			changePlanyear("current");

		newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		j = 1;
		k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertTrue(newplansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + newplansDetails.get(i));
			j++;
		}

		// Validate Ranking Order - In Future for future plans

		System.out.println("------- Plan Year Auto ranking Validation completed -------");
	}

	public List<String> getPlanSectionDetails() {
		List<String> plansDetails = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement elem : planNameSection) {
			// String val = elem.getText().trim().toUpperCase().replace(" ", "");
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "");
			plansDetails.add(val);
		}
		return plansDetails;
	}

	public void verifyDeleteAddPlan(String zip, String rankOptions, String curPlan, String changeOrder,
			String planOrders) {
		System.out.println("Verify Auto Ranking for Plan year change..");
		int planStartCount = 0;
		Assert.assertTrue(zipInfo.getText().contains(zip), "Not Expected Zip Code");
		List<String> plansDetails = getPlanSectionDetails();

		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
			Assert.assertTrue(plansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", false);
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertTrue(newplansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + newplansDetails.get(i));
			j++;
		}

		newplansDetails = getPlanSectionDetails();

		deletePlan(planStartCount + 1);

		List<String> afterDeleteDetails = getPlanSectionDetails();

		Assert.assertTrue(newplansDetails.size() == afterDeleteDetails.size() + 1, "Delete plan is not Compelted");

		// Validate best match Text max of 4
		j = 1;
		k = planStartCount;
		for (int i = k; i < afterDeleteDetails.size() && j <= 4; i++) {
			Assert.assertTrue(afterDeleteDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + afterDeleteDetails.get(i));
			j++;
		}

		addPlan();
		validate(planRankingDropdown, 60);

		List<String> afterAddDetails = getPlanSectionDetails();

		Assert.assertTrue(newplansDetails.equals(afterAddDetails),
				"Return to Previous Ranking order is failed after Adding the deleted One");

		System.out.println("------- Plan Delete Add Validation completed -------");
	}

	public void deletePlan(int planIndex) {
		jsClickMobile(plandeleteButtons.get(planIndex - 1));
		threadsleep(5000);
	}

	public void addPlan() {
		System.out.println("Adding Plan....");
		jsClickMobile(addPlan);
		threadsleep(5000);
		plansLoader();
		for (WebElement elem : vppCompare)
			if (!elem.findElement(By.cssSelector("input")).isSelected()) {
				elem.findElement(By.cssSelector("label")).click();
				break;
			}
		threadsleep(3000);
		vppCompareButton.get(0).click();
	}

	public void disableDrugOriginalPlans(String curPlan, String changeOrder, String rankOptions, String planOrders) {
		System.out.println("Verify Drug option disabled after deleting drugs in DCE");
		Actions action = new Actions(driver);
		scrollToView(print);
		scrollToView(AddDoctorsLink);
		threadsleep(3000);
		scrollToView(planRankingTxt);
		action.moveToElement(planRankingDropdown).perform();
		action.moveToElement(planRankingDropdown).click().perform();
		drugDocDisable(rankOptions, false);
		compareCurrentOriginalPlan(curPlan, changeOrder, planOrders);
	}

	public void compareCurrentOriginalPlan(String curPlan, String changeOrder, String planOrders) {
		int planStartCount = 0;
		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
//			Assert.assertTrue(originalplanNames.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		List<String> newplansDetails = new ArrayList<String>();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement elem : planNamesOnly) {
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "");
			newplansDetails.add(val);
		}
		System.out.println("Plan Orders after deleting doctors: " + newplansDetails);

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertFalse(newplansDetails.get(i).contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Plans are having Best Match Text : " + newplansDetails.get(i));
			j++;
		}

		// Validate Ranking Order

		if (planOrders.isEmpty() && changeOrder.equalsIgnoreCase("yes")) {
			Assert.assertFalse(originalplanNames.equals(newplansDetails), "Plans are Re-ordered");
		} else if (planOrders.isEmpty() && !changeOrder.equalsIgnoreCase("yes")) {
			Assert.assertFalse(originalplanNames.equals(newplansDetails), "Plans are Re-ordered");
		}
	}

	public void checkDeleteAllDrugs() {
		if (validate(editDrugs, 10)) {
			editDrugs.click();
			System.out.println("Deleting Existing Drugs");
			DCEPage areDce = new DCEPage(driver);
			areDce.deleteAllDrugs();
			areDce.returnToCompare();
			validate(planRankingDropdown,30);
		}
	}

	public void checkDeleteAllDoctors() {
		if (validate(editDoctors, 10)) {
			editDoctors.click();
			System.out.println("Deleting Existing All Providers");
			WerallyPage werally = new WerallyPage(driver);
			String curWindow = driver.getWindowHandle();
			System.out.println(curWindow);
			werally.validateLinksanotherWindow(curWindow, "Delete All", "");
			validate(planRankingDropdown,30);
		}
	}

}