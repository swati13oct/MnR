/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	@FindBy(css = "div#multiSelect>label")
	private WebElement planRankingTxt;

	@FindBy(css = "div#multiSelect>#plan-ranking")
	private WebElement planRankingDropdown;

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

	@FindBy(css = "#compare-table-header span.unliked")
	private List<WebElement> saveplanComparepage;

	@FindBy(css = "div[class*='dupIcon'] img[dtmid*='visitor_profile']")
	private WebElement viewSavedItems;

	@FindBy(css = "#dashPlansContainer div[class*='item advantagePlan'] h4")
	private List<WebElement> planNamesVisitorPrf;

	@FindBy(css = "div[class*='title-compare'] button[class*='btn']")
	private WebElement comparePlansBtn;

	@FindBy(css = ".segment h2")
	private WebElement planNameEnrollPage;

	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;

	@FindBy(css = "#header .container")
	private WebElement zipInfo;

	@FindBy(css = "#compare-table div[class*='flex'][class*='scope']")
	private List<WebElement> planNameSection;

	@FindBy(css = "div.plan-ranking-message")
	private WebElement successMsg;

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

		Assert.assertTrue(drugCheck.isSelected(), "Drug is not selected by default");
		Assert.assertTrue(doctorCheck.isSelected(), "Doctor is not selected by default");

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
		dceobj.choosePharmacyandBacktoPlans();
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
		int totalnumberofplans = Integer.parseInt(NumberofPlans.getText().trim().split(" ")[0]);
		int saveplans = 2;
		verifySavePlans(plancards, saveplans, saveplanComparepage);
	}

	public void verifyRankingOrder(String zip, String rankOptions, String curPlan, String changeOrder,
			String planOrders) {
		System.out.println("Verify Ranking and Plans Reorder");
		int planStartCount = 0;
		Assert.assertTrue(zipInfo.getText().contains(zip), "Not Expected Zip Code");
		List<String> plansDetails = new ArrayList<String>();
		for (WebElement elem : planNameSection) {
			String val = elem.getText().trim().toUpperCase().replace(" ", "");
			plansDetails.add(val);
		}
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

		List<String> newplansDetails = new ArrayList<String>();
		for (WebElement elem : planNameSection) {
			String val = elem.getText().trim().toUpperCase().replace(" ", "");
			newplansDetails.add(val);
		}

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		if (planStartCount == 0)
			k = planStartCount + 1;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			Assert.assertTrue(newplansDetails.get(i).contains("#" + String.valueOf(i) + "BESTMATCH"),
					"Expected Best Match Text is not applied");
			j++;
		}

		// Validate Ranking Order
		j = 0;
		ArrayList<String> givenplansDetails = new ArrayList<String>(Arrays.asList(planOrders.split(",")));
		for (int i = planStartCount; i < givenplansDetails.size(); i++) {
			Assert.assertTrue(newplansDetails.get(i).contains(givenplansDetails.get(j).toUpperCase()),
					"Expected Ranking is Not applied Expected: " + givenplansDetails.get(j) + " Actual: "
							+ newplansDetails.get(i));
			j++;
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

		List<String> originalplansDetails = new ArrayList<String>();
		for (WebElement elem : planNameSection) {
			String val = elem.getText().trim().toUpperCase().replace(" ", "");
			originalplansDetails.add(val);
		}

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
					vppPlans.add(savingplans(plansName.get(plan + i), saveplanComparepage.get(i)));
			}
			Collections.sort(vppPlans);
			System.out.println(vppPlans);
			visitorprofile(planNamesVisitorPrf, vppPlans);
			comparePlansBtn.click();
		} else {
			for (plan = 0; plan < saveplans; plan++) {
				for (int i = 0; i < saveplans; i++)
					vppPlans.add(savingplans(plansName.get(i), saveplanComparepage.get(i)));
			}
			Collections.sort(vppPlans);
			System.out.println(vppPlans);
			visitorprofile(planNamesVisitorPrf, vppPlans);
			comparePlansBtn.click();
		}
		System.out.println("Plan Name compared Successful Clicks on Save Plan");
	}

	public String savingplans(WebElement plan, WebElement saveplan) {
		String exceptedplanName = plan.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
		saveplan.click();
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
			System.out.println("Plan Name in VPP Details Page: " + actualplanName);
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

}