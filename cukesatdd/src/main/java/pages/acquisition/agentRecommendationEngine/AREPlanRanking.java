/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(css = ".uhc-container div.content h2:nth-child(2)")
	private WebElement planNameVPPDetailsPage;
	
	@FindBy(css = "a.compare-link")
	private List<WebElement> backtoComparePlans;

	public void validateUIElements() {
		System.out.println("Validate ARE UI Elements : ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		Assert.assertTrue(validate(planRankingTxt),"Ranking text is missing");
		Assert.assertTrue(validate(planRankingDropdown),"Ranking Dropdown is missing");
		planRankingDropdown.click();
		Assert.assertTrue(validate(dentalCheckLabel),"Dental Checkbox is missing");
		Assert.assertTrue(validate(visionCheckLabel),"Vision Checkbox is missing");
		Assert.assertTrue(validate(hearingCheckLabel),"Hearing Checkbox is missing");
		Assert.assertTrue(validate(fitnessCheckLabel),"Fitness Checkbox is missing");
		Assert.assertTrue(validate(lowPremiumCheckLabel),"Low Premium Checkbox is missing");
		Assert.assertTrue(validate(travelCheckLabel),"Travel Checkbox is missing");
		Assert.assertTrue(validate(drugCheckLabel),"Drug Checkbox is missing");
		Assert.assertTrue(validate(doctorCheckLabel),"Doctor Checkbox is missing");
		Assert.assertTrue(validate(applyBtn),"Apply button is missing");
		
		Assert.assertTrue(drugCheck.isSelected(), "Drug is not selected by default");
		Assert.assertTrue(doctorCheck.isSelected(), "Doctor is not selected by default");
		
		//Deselect All
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", false);
		applyBtn.click();
		threadsleep(3000);
		boolean dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);
		
		//Select All
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
			Assert.assertTrue(elemCheck.isSelected(), "Unable to Select "+elemCheck);
		else
			Assert.assertFalse(elemCheck.isSelected(), "Unable to Deselect "+elemCheck);
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
    	rallyobj.validateLinksanotherWindow(curWindow,"Adding Doctors",search);
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
    	rallyobj.validateLinksanotherWindow(curWindow,"Delete Doctors",docDetails);
    	threadsleep(5000);		
	}
	
	public void validateViewPlanDetails() {
		System.out.println("Validate ARE View Plan Details : ");
		int totalnumberofplans = Integer.parseInt(NumberofPlans.getText().trim().split(" ")[0]);
		verifyPlanNames(plancards, totalnumberofplans, viewplandetailslink);		
	}
	
	public void verifyPlanNames(List<WebElement> plansName, int PlanCount, List<WebElement> viewplandetails) {
		List<String> vppPlans = new ArrayList<String>();
		System.out.println(plansName.size());
		System.out.println(viewplandetails.size());
		int plan = 0;
		if(plansName.size()!=viewplandetails.size()) {
			for(plan=1;plan <= PlanCount; plan++) {
				for(int i = 0; i<viewplandetails.size(); i++)
					vppPlans.add(verifygetplanName(plansName.get(plan),viewplandetails.get(i)));
				}
		}
		else {
			for(plan=0;plan < PlanCount; plan++) {
				for(int i = 0; i<viewplandetails.size(); i++)
					vppPlans.add(verifygetplanName(plansName.get(plan),viewplandetails.get(i)));
				}
		}
			
		System.out.println("Plan Name compared Successful Clicks on Plan Name");
	}
	
	public String verifygetplanName(WebElement plan, WebElement planInPDP) {
		String actualplanName = "";
		String exceptedplanName = plan.getText().trim();
		String VIew = planInPDP.getText().trim();
		System.out.println("Plan Name in VPP Summary Page: "+exceptedplanName);
		System.out.println("View "+VIew);
		planInPDP.click();
		pageloadcomplete();
		actualplanName = planNameVPPDetailsPage.getText().split("\n")[0];
		System.out.println("Plan Name in VPP Details Page: "+actualplanName);
		Assert.assertTrue(exceptedplanName.contains(actualplanName), "--- Plan name are not matches---");
		WebElement comparePlanlink = backtoComparePlans.get(0);
		comparePlanlink.click();
		pageloadcomplete();
		return actualplanName;
	}
	
	public void validateSavePlan() {
		System.out.println("Validate ARE Save Plans functionality : ");
		int totalnumberofplans = Integer.parseInt(NumberofPlans.getText().trim().split(" ")[0]);
//		verifySavePlans(plancards, totalnumberofplans);		
	}
	
}