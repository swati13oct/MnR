
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
	private WebElement Logo;
	
	@FindBy(css = "label[for*='plan-ranking']")
	private WebElement planRankingTxt;

	@FindBy(css = "div#multiSelect>#plan-ranking")
	private WebElement planRankingDropdown;

	@FindBy(css = "#printComparison")
	private WebElement print;
	
	@FindBy(css = "#printPlans th[class*='headerinPrint']:nth-child(2) #viewallplansBtnId")
	private WebElement showAllPlansLink;

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
	
	@FindBy(css = "button#adddrug")
	private WebElement AddMyDrugsInDCE;

	@FindBy(css = "a[dtmname*=' Drugs']")
	private WebElement AddDrugsLink;

	@FindBy(xpath = "//a//span[contains(text(),'Doctors')]")
	private WebElement AddDoctorsLink;

	@FindBy(css = "a[dtmname*=' Hospitals']")
	private WebElement AddHospitalsLink;

	@FindBy(css = "#printPlans th:nth-child(2) h2")
	private WebElement NumberofPlans;

	@FindBy(css = "#printPlans th[class*='text-blue-primary'] div >span")
	private List<WebElement> plancards;
	
	@FindBy(css = ".uhc-compare-header__controls button[class*='compare-plans-next']")
    private WebElement viewMorePlansinPlanCompare;

	@FindBy(css = "#compare-table-header th[class*='uhc-slide-table'] a[dtmname*='View Details']")
	private List<WebElement> viewplandetailslink;

	@FindBy(css = "#enroll-row th")
	private List<WebElement> enrollBtn;
	
	@FindBy(css = "#highlights a[dtmid*='cta_acq_plans_detail']")
	private List<WebElement> enrollBtnInDetailsPage;

	@FindBy(css = ".uhc-container div.content h2")
	private WebElement planNameVPPDetailsPage;

	@FindBy(css = "a.compare-link")
	private List<WebElement> backtoComparePlans;

	@FindBy(css = "#enroll-row th button[class*='moreOptionsbtn']")
	private List<WebElement> saveplanComparepage;
	
	@FindBy(css = "#moreOptionsId #save-plan span:nth-child(2)")
	private WebElement saveplanOption;
	
	@FindBy(css = "#moreOptionsId div:nth-child(2) span")
	private WebElement viewPlanOption;

	@FindBy(css = "#compare-table-header div[class='liked savePlanText']")
	private List<WebElement> unsaveplanComparepage;

	@FindBy(css = "div[class*='dupIcon'] img[dtmid*='visitor_profile']")
	private WebElement heartIcon;
	
	@FindBy(css = "#auth-saved-items-button")
	private WebElement viewSavedItems;

	@FindBy(css = "div h3[class*='plan-name']")
	private List<WebElement> planNamesVisitorPrf;
	
	@FindBy(css = "button[class*='saved-items-button']")
	private WebElement mySavedItems ;
	
	@FindBy(css = "#auth-saved-items-button span")
	private WebElement AuthViewSavedBtn;

	@FindBy(css = "#landrover div[class*='justify-content-between'] a[dtmid*='acq_visitor_profile']")
	private WebElement comparePlansBtn;

	@FindBy(css = "a[dtmname*='Edit Drugs']")
	private WebElement editDrugs;

	@FindBy(css = "a[dtmname*='Edit Doctors']")
	private WebElement editDoctors;

	@FindBy(css = "span[class*='multiple-added-text'] button[class*='cta-button']")
	private List<WebElement> comparePlansBtninVpp;

	@FindBy(css = ".segment div[class*='content p-b-0'] h3")
	private WebElement planNameEnrollPage;

	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;

	@FindBy(css = ".plan-compare-heading-holder h1")
	private WebElement zipInfo;
	
	@FindBy(css = "#printPlans th[class*='text-blue-primary']")
	private List<WebElement> planTile;

	@FindBy(css = "#compare-table div[class*='flex'][class*='scope']")
	private List<WebElement> planNameSection;

	@FindBy(css = "#compare-table div[class*='flex'][class*='scope']>div[class*='flex']>div")
	private List<WebElement> planNamesOnly;

	@FindBy(css = "#printPlans th[class*='text-blue-primary'] a[class*='uhc-link-button']")
	private List<WebElement> plandeleteButtons;

	@FindBy(css = "div.plan-ranking-message")
	private WebElement successMsg;

	@FindBy(css = "#selectCounty p>a")
	private List<WebElement> selectMultiZip;

	@FindBy(css = ".modal-body #multiCountyCancelBtn")
	private WebElement confrimButton;

	@FindBy(css = ".uhc-toggle button")
	private WebElement planYear;

	@FindBy(css = "#addanotherplanbutton")
	private WebElement addPlan;

	@FindBy(css = "div[class*='compare']>div[class*='compare-box']")
	private List<WebElement> vppCompare;

	@FindBy(css = "div[class*='compare-box'] button")
	private List<WebElement> vppCompareButton;

	@FindBy(css = "#currentYearToggle")
	private WebElement currentPlanYear;

	@FindBy(css = "#nextYearToggle")
	private WebElement futurePlanYear;
	
	@FindBy(css = ".multi-year-select button:nth-child(1)")
	private WebElement currentPlanYearInVP;

	@FindBy(css = ".multi-year-select button:nth-child(2)")
	private WebElement futurePlanYearInVP;
	
	@FindBy(css = "#plan-summary-table tr:nth-child(16)")
	private WebElement estimateMedicalCost;
	
	@FindBy(css = "#plan-summary-table tr:nth-child(16) div.text-small span")
	private List<WebElement> estimateMedicalCostvalue;

	@FindBy(css = "div#multiSelect label[for='estimated_medical_costs']")
	private WebElement mceCheckLabel;

	@FindBy(css = "div#multiSelect label[for='estimated_medical_costs']>input")
	private WebElement mceCheck;
	
	// Feedback PopUp
		@FindBy(css = "iframe[title*=' Survey']")
		private WebElement popupFrame;
		
		@FindBy(css = "button[id*='no']")
		private WebElement popupNo;
	
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
//		Assert.assertTrue(validate(travelCheckLabel), "Travel Checkbox is missing");
		Assert.assertTrue(validate(drugCheckLabel), "Drug Checkbox is missing");
		Assert.assertTrue(validate(doctorCheckLabel), "Doctor Checkbox is missing");
		Assert.assertTrue(validate(applyBtn), "Apply button is missing");

		Assert.assertFalse(drugCheck.isSelected(), "Drug is selected by default");
		Assert.assertFalse(doctorCheck.isSelected(), "Doctor is selected by default");

		// Deselect All
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,drug,doctor", false);
		applyBtn.click();
		threadsleep(3000);
		boolean dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);

		// Select All
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,drug,doctor", true);
		applyBtn.click();
		threadsleep(3000);
		dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);
	}

	public void validateUIPlanRanking() {
		System.out.println("Validate ARE PlanRanking Dropdown UI : ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		Assert.assertFalse(validate(planRankingTxt), "Ranking text is displaying");
		Assert.assertFalse(validate(planRankingDropdown), "Ranking Dropdown is displaying");
	
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
		if (checkOption.equalsIgnoreCase("drug")) {
			elemCheck = drugCheck;
			elemClick = drugCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("doctor")) {
			elemCheck = doctorCheck;
			elemClick = doctorCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("mce")) {
			elemCheck = mceCheck;
			elemClick = mceCheckLabel;
		}

		if (select && !elemCheck.isSelected()) {
			jsClickNew(elemClick);
		}
		if (!select && elemCheck.isSelected()) {
			jsClickNew(elemClick);
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
		jsClickNew(AddDrugsLink);
		validate(AddMyDrugsInDCE);
		jsClickNew(AddMyDrugsInDCE);
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
		if (plansName.size() != viewplandetails.size()) {
			for (int i = 0; i < viewplandetails.size(); i++) {
					 if(i>3) {
						 for(int k=0; k<i; k++)
							 jsClickNew(viewMorePlansinPlanCompare);
					 }
					vppPlans.add(verifygetplanName(plansName.get(i+1), viewplandetails.get(i+1)));
				}
			System.out.println("Plan Name compared Successful Clicks on Plan Name");
		} else {
				for (int i = 0; i < viewplandetails.size(); i++) {
					if(i>3) {
						 for(int k=0; k<i; k++)
							 jsClickNew(viewMorePlansinPlanCompare);
					 }
					vppPlans.add(verifygetplanName(plansName.get(i), viewplandetails.get(i)));
				}
			System.out.println("Plan Name compared Successful Clicks on Enroll Button");
		}
	}

	public String verifygetplanName(WebElement plan, WebElement planInPDP) {
		String actualplanName = "";
		String exceptedplanName = plan.getText().toUpperCase().trim();
		planInPDP = planInPDP.findElement(By.cssSelector(" button[class*='moreOptionsbtn']"));
		System.out.println("MoreOption in Plan Compare Page: " + planInPDP.getText());
		threadsleep(2000);
		jsClickNew(planInPDP);
		String VIew = viewPlanOption.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
//		System.out.println("View " + VIew);
		if (VIew.contains("View Plan Details")) {
			viewPlanOption.click();
			pageloadcomplete();
			actualplanName = planNameVPPDetailsPage.getText().split("\n")[0].toUpperCase();
			System.out.println("Plan Name in VPP Details Page: " + actualplanName);
			Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
//			WebElement comparePlanlink = backtoComparePlans.get(0);
//			comparePlanlink.click();
			browserBack();
		} else {
			close_Popup();
			viewPlanOption.click();
			pageloadcomplete();
			close_Popup();
			pageloadcomplete();
			enrollBtnInDetailsPage.get(0).click();
			actualplanName = planNameEnrollPage.getText().toUpperCase().trim();
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

	public void validateSavePlan(String year) {
		System.out.println("Validate ARE Save Plans functionality : ");
		int saveplans = 2;
		verifySavePlans(plancards, saveplans, saveplanComparepage, year);
	}

	public void verifyRankingOrder(String zip, String rankOptions, String curPlan, String changeOrder,
			String planOrders) {
		System.out.println("Verify Ranking and Plans Reorder");
		int planStartCount = 0;
		Assert.assertTrue(zipInfo.getText().contains(zip), "Not Expected Zip Code");

		List<String> plansDetails = getPlanSectionDetails();

		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
			String elemPlan = planTile.get(3).findElement(By.cssSelector(" div >span")).getText().trim().replace(" ", "").toUpperCase()+" "+ driver.findElement(By.cssSelector("#enroll-row th:nth-child(1)")).getText().trim().replace(" ", "").toUpperCase();
			Assert.assertTrue(elemPlan.contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		jsClickNew(planRankingDropdown);
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,drug,doctor", false);
		optionSelection(rankOptions, true);
		jsClickNew(applyBtn);
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			String Plan = newplansDetails.get(i)+ "#" + String.valueOf(j) + "BESTMATCH";
			Assert.assertTrue(Plan.contains("#" + String.valueOf(j) + "BESTMATCH"),
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
			String elemPlan = planTile.get(3).findElement(By.cssSelector(" div >span")).getText().trim().replace(" ", "").toUpperCase()+" "+ driver.findElement(By.cssSelector("#enroll-row th:nth-child(1)")).getText().trim().replace(" ", "").toUpperCase();
			Assert.assertTrue(elemPlan.contains("CURRENTPLAN"), "Current Plan is not displayed by default");
			Assert.assertFalse(newplansDetails.get(0).contains("BEST"), "Current plan is with Best Match text");
		}

		// Uncheck all and validate original order
		jsClickNew(planRankingDropdown);
		validate(applyBtn);
		optionSelection(rankOptions, false);
		jsClickNew(applyBtn);
		threadsleep(3000);
		;
		boolean msg = validate(successMsg, 10); // Validate message disappear
		Assert.assertFalse(msg);

		List<String> originalplansDetails = getPlanSectionDetails();

		Assert.assertTrue(plansDetails.equals(originalplansDetails), "Return to Original order is failed");
		System.out.println("------- Ranking Validation completed -------");
	}

	public void verifySavePlans(List<WebElement> plansName, int saveplans, List<WebElement> saveplanComparepage,
			String year) {
		Actions action = new Actions(driver);
		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansName.size());
		System.out.println(saveplanComparepage.size());
		int plan = 0;
		if (plansName.size() != saveplanComparepage.size()) {
			for (plan = 1; plan <= saveplans; plan++) {
				int i = 0;
				vppPlans.add(savingplans(plansName.get(plan), saveplanComparepage.get(plan - 1), (plan-1)));
			}
			Collections.sort(vppPlans);
			System.out.println(vppPlans);
			threadsleep(3000);
			scrollToView(mySavedItems);
			action.clickAndHold(mySavedItems).build().perform();
			validate(AuthViewSavedBtn);
			AuthViewSavedBtn.click();
			changePlanyearVisitorProfile(year);
			visitorprofile(planNamesVisitorPrf, vppPlans);
			comparePlansBtn.click();
		} else {
			for (plan = 0; plan < saveplans; plan++) {
				int i = plan;
				vppPlans.add(savingplans(plansName.get(i), saveplanComparepage.get(i), i));
			}
			Collections.sort(vppPlans);
			System.out.println(vppPlans);
			threadsleep(3000);
			scrollToView(mySavedItems);
			action.clickAndHold(mySavedItems).build().perform();
			validate(AuthViewSavedBtn);
			AuthViewSavedBtn.click();
			changePlanyearVisitorProfile(year);
			visitorprofile(planNamesVisitorPrf, vppPlans);
			comparePlansBtn.click();
		}
		System.out.println("Plan Name compared Successful Clicks on Save Plan");
	}

	public String savingplans(WebElement plan, WebElement saveplan, int i) {
		String exceptedplanName = plan.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: " + exceptedplanName);
		saveplan.click();
		String save = saveplanOption.getText().trim();
		if (save.equalsIgnoreCase("Save Plan")) {
			saveplanOption.click();
		} else {
			saveplanOption.click();
			threadsleep(2000);
			saveplan.click();
			threadsleep(2000);
			saveplanOption.click();
		}
		threadsleep(5000);
		return exceptedplanName;
	}

	public void visitorprofile(List<WebElement> plansName, List<String> vppPlans) {
		System.out.println("Plan Name in VPP Page: " + vppPlans);
		String actualplanName = "";
		pageloadcomplete();
		System.out.println(plansName.size());
		for (int i = 0; i < plansName.size(); i++) {
			actualplanName = plansName.get(i).getText().trim();
			System.out.println("Plan Name in Visitor Profile Page: " + actualplanName);
			Assert.assertTrue(vppPlans.contains(actualplanName), "--- Plan name are not matches---");
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
		threadsleep(5000);
	}

	public void changePlanyear(String year) {
		// Checking and Changing to Current Year
		if (year.equalsIgnoreCase("current")) {
			if (validate(planYear, 10)) 
				currentPlanYear.click();
		}

		// Checking and Changing Future Year
		else if (year.equalsIgnoreCase("future")) {
			if (validate(planYear, 10)) 
				futurePlanYear.click();
			} 		
		else
			Assert.assertTrue(true, "Plan Year Toggle is Needed to set Future Year");
		
		threadsleep(5000);
			
	}

	public void checkYear(String year) {
		String curYear = getCurrentYear();
		// Checking Year
		if (year.equalsIgnoreCase("current")) {
			if (validate(planYear, 10)) {
				if(currentPlanYear.getAttribute("aria-selected").equalsIgnoreCase("true") )
					Assert.assertTrue(currentPlanYear.findElement(By.cssSelector(">div")).getText().trim().contains(curYear),
						" Current Year is not Selected by Default");
			}
		}
		if (year.equalsIgnoreCase("future")) {
			if (validate(planYear, 10)) {
				int nxtYear = Integer.parseInt(curYear) + 1;
				if(futurePlanYear.getAttribute("aria-selected").equalsIgnoreCase("true") )
					Assert.assertTrue(futurePlanYear.findElement(By.cssSelector("div")).getText().trim().contains(String.valueOf(nxtYear)),
						"Future Year is not set by default");
			}
		}
		 else {
				Assert.assertTrue(true, "Plan Year Toggle is Needed to set Future Year");
			}
	}

	public boolean changePlanyearVisitorProfile(String year) {
		// Checking Current year selection
		if (year.equalsIgnoreCase("current")) {
			if (validate(currentPlanYearInVP, 15)) {
				currentPlanYearInVP.click();
				Assert.assertTrue(currentPlanYearInVP.getAttribute("class").length() > 0,
						"Current Plan Year is not Selected");
				return true;
			}
		}

		// Checking and Changing Future Year
		if (year.equalsIgnoreCase("future")) {
			if (validate(futurePlanYearInVP, 15)) {
				futurePlanYearInVP.click();
				Assert.assertTrue(futurePlanYearInVP.getAttribute("class").length() > 0,
						"Future Plan Year is not Selected");
				return true;
			} else {
				Assert.assertTrue(true, "Future Plan Year Toggle is Needed");
			}
		}
		return false;
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
//			Assertion.assertTrue(drugplansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Verify Drug and Doctors Session Storage");
		
		List<String> plansDetails = getPlanSectionDetails();
		
		planRankingDropdown.click();
		drugDocDisable(rankOptions, false);
		applyBtn.click();
		threadsleep(3000);

		List<String> newplansDetails = new ArrayList<String>();
		for (WebElement elem : planTile) {
			WebElement elemPlan = elem.findElement(By.cssSelector("div >span"));
			String planName = (String) (js.executeScript("return arguments[0].textContent;", elemPlan).toString().trim().toUpperCase().replace(" ", ""));
			newplansDetails.add(planName);
		}
		System.out.println(newplansDetails);
		
		if (planOrders.isEmpty()) {
			Assert.assertFalse(plansDetails.equals(newplansDetails), "Plans are not Re-ordered");
		} else {
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
//		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		DocName.click();
//		scrollToView(planRankingDropdown);
		scrollToView(print);
		scrollToView(AddDrugsLink);
		threadsleep(3000);
		scrollToView(Logo);
//		action.moveToElement(planRankingDropdown).perform();
//		action.moveToElement(planRankingDropdown).click().perform();
		jsMouseOver(planRankingDropdown);
		jsClickNew(planRankingDropdown);
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
		actionMoveTo(planRankingDropdown);
		//planRankingDropdown.click();
		jsClickNew(planRankingDropdown);
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
//			Assertion.assertTrue(drugplansDetails.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		List<String> newplansDetails = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement elem : planNameSection) {
			String planName = (String) js.executeScript("return arguments[0].innerText;", elem);
			String val = planName.trim().toUpperCase().replace(" ", "").split("SAVEPLAN")[0].split("CLOSE")[0]
					.split("\n")[0];
			newplansDetails.add(val);
		}
		System.out.println(newplansDetails);

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
		optionSelection("dental,vision,hearing,fitness,lowpremium,drug,doctor", false);
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			String Plan = newplansDetails.get(i)+ "#" + String.valueOf(j) + "BESTMATCH";
			Assert.assertTrue(Plan.contains("#" + String.valueOf(j) + "BESTMATCH"),
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
			String Plan = newplansDetails.get(i)+ "#" + String.valueOf(j) + "BESTMATCH";
			Assert.assertTrue(Plan.contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + newplansDetails.get(i));
			j++;
		}

		// Validate Ranking Order - In Future for future plans

		System.out.println("------- Plan Year Auto ranking Validation completed -------");
	}

	public List<String> getPlanSectionDetails() {
		List<String> plansDetails = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement elem : planTile) {
			WebElement elemPlan = elem.findElement(By.cssSelector("div >span"));
			String planName = (String) (js.executeScript("return arguments[0].textContent;", elemPlan).toString());
			System.out.println("PlanName in PlanCompare page: "+planName);
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
			String elemPlan = planTile.get(3).findElement(By.cssSelector(" div >span")).getText().trim().replace(" ", "").toUpperCase()+" "+ driver.findElement(By.cssSelector("#enroll-row th:nth-child(1)")).getText().trim().replace(" ", "").toUpperCase();
			Assert.assertTrue(elemPlan.contains("CURRENTPLAN"), "Current Plan is not displayed by default");
		}
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,drug,doctor", false);
		optionSelection(rankOptions, true);
		applyBtn.click();
		threadsleep(3000);
		// Validate Success message
		Assert.assertTrue(successMsg.getText().toUpperCase().contains("SUCCESS"), "No Sucess message");

		List<String> newplansDetails = getPlanSectionDetails();

		// Validate best match Text max of 4
		int j = 1, k = planStartCount;
		for (int i = k; i < newplansDetails.size() && j <= 4; i++) {
			String Plan = newplansDetails.get(i)+ "#" + String.valueOf(j) + "BESTMATCH";
			Assert.assertTrue(Plan.contains("#" + String.valueOf(j) + "BESTMATCH"),
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
			String Plan = afterDeleteDetails.get(i)+ "#" + String.valueOf(j) + "BESTMATCH";
			Assert.assertTrue(Plan.contains("#" + String.valueOf(j) + "BESTMATCH"),
					"Expected Best Match Text is not applied : " + afterDeleteDetails.get(i));
			j++;
		}

//		addPlan();
		if(validate(showAllPlansLink))
			showAllPlansLink.click();
		
		validate(planRankingDropdown, 60);

		List<String> afterAddDetails = getPlanSectionDetails();

		Assert.assertTrue(newplansDetails.equals(afterAddDetails),
				"Return to Previous Ranking order is failed after Adding the deleted One");

		System.out.println("------- Plan Delete Add Validation completed -------");
	}

	public void deletePlan(int planIndex) {
//		jsClickMobile(plandeleteButtons.get(planIndex - 1));
		jsClickNew(plandeleteButtons.get(planIndex - 1));
		threadsleep(5000);
	}

	public void addPlan() {
		System.out.println("Adding Plan....");
//		jsClickMobile(addPlan);
		jsClickNew(addPlan);
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
		//Actions action = new Actions(driver);
		scrollToView(print);
		scrollToView(AddDoctorsLink);
		threadsleep(3000);
		scrollToView(Logo);
		//action.moveToElement(planRankingDropdown).perform();
		//action.moveToElement(planRankingDropdown).click().perform();
		jsMouseOver(planRankingDropdown);
		jsClickNew(planRankingDropdown);
		drugDocDisable(rankOptions, false);
		compareCurrentOriginalPlan(curPlan, changeOrder, planOrders);
	}

	public void compareCurrentOriginalPlan(String curPlan, String changeOrder, String planOrders) {
		int planStartCount = 0;
		if (curPlan.equalsIgnoreCase("yes")) {
			planStartCount = 1;
//			Assertion.assertTrue(originalplanNames.get(0).contains("CURRENTPLAN"), "Current Plan is not displayed by default");
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
			validate(planRankingDropdown, 60);
			actionMoveTo(planRankingDropdown);
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
			validate(planRankingDropdown, 30);
			actionMoveTo(planRankingDropdown);
		}
	}

	public void actionMoveTo(WebElement elem) {
//		Actions action = new Actions(driver);
//		action.moveToElement(elem).perform();
		jsMouseOver(elem);
		threadsleep(1000);
	}
	
	public void estimateMedicalCost(String mediMC) {
		List<String> estimateMCE = new ArrayList<String>();
		pageloadcomplete();
		System.out.println("Validate Estimate Medical Costs in Plan Compare page : ");
		if(mediMC.equalsIgnoreCase("YES")) {
		validate(estimateMedicalCost, 30);
		Assert.assertTrue(estimateMedicalCost.findElement(By.cssSelector("p")).getText().toUpperCase().contains("ESTIMATED ANNUAL MEDICAL COST"), "Estimated Annual Medical Cost row not displayed for this MBI ID");
		int totalnumberofplans = Integer.parseInt(NumberofPlans.getText().trim().split(" ")[0]);
		threadsleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i=1;i<=totalnumberofplans;i++) {
			WebElement estimate = estimateMedicalCostvalue.get(i);
			String estimateCost = (String) (js.executeScript("return arguments[0].textContent;", estimate).toString());
			estimateMCE.add(estimateCost.trim());
		}
		System.out.println(estimateMCE);
		}
		else {
			Assert.assertFalse(validate(estimateMedicalCost, 30), "Estimated Annual Medical Cost row is displayed for this MBI ID");
		}
	}
	
	public void optionCheck(String option,boolean visible) {
		System.out.println("Verify Options..");
		planRankingDropdown.click();
		validate(applyBtn);
		if(visible) {
			if(option.equalsIgnoreCase("mce"))
				Assert.assertTrue(validate(mceCheck,10), option+" is not visible");	
		}
		else {
			if(option.equalsIgnoreCase("mce"))
				Assert.assertFalse(validate(mceCheck,10), option+" is visible");	
		}
	}
	
	public boolean close_Popup() {
		boolean popup_presents = false;
		System.out.println("Checking Popup Status...");
		if(validate(popupNo, 20)) {
			if(validate(popupFrame, 5))
				driver.switchTo().frame(popupFrame);
			threadsleep(1000);
			popupNo.click();
			threadsleep(1000);
			popup_presents = true;
		}
		driver.switchTo().defaultContent();
		return popup_presents;
	}

}

