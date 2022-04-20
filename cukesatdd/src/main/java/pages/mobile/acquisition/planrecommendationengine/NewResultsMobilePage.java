/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumDriver;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;

public class NewResultsMobilePage extends UhcDriver {

	public NewResultsMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = CommonutilitiesMobile.resultsPageName;

	CommonutilitiesMobile mobileUtils = new CommonutilitiesMobile(driver);

	// Results loading page Elements

		@FindBy(css = "#loadingText")
		private WebElement resultsloadingTitle;

		@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(2)>img")
		private WebElement svgAnimation;

		@FindBy(css = "div>img[alt*='Loading Plan Recommendations']")
		private WebElement loadingImage;

		// Result Page Elements

		@FindBy(css = "body>div#overlay")
		private WebElement planLoaderscreen;
		
		@FindBy(css = "div[class*='bottomPaginationSec'] div[class*='pdf-section'] p")
		private List<WebElement> ImpResSectionPDFLinks;

		@FindBy(xpath = "//*[@class='mobileHeader']")
		private WebElement planZipInfo;
		
		@FindBy(css = ".planRemoveSort svg")
		private WebElement removeBreadCrumbs;

		@FindBy(css = ".editPref button")
		private WebElement editYourResponse;

		@FindBy(css = ".saveRes button")
		private WebElement saveYourResults;

		@FindBy(css = ".view-ms-plans a")
		private WebElement viewMSPlans;

		@FindBy(css = "label[for*='recommendSort']")
		private WebElement sortByLabel;

		@FindBy(css = "#recommendSort option")
		private List<WebElement> sortByOptions;

		// Pagination

		@FindBy(css = ".returnSection button.buttonLink")
		private WebElement returnToBeginning;

		@FindBy(css = ".returnSection span#viewMorePlans")
		private WebElement pagenoLabel;

		@FindBy(css = "button[class*='view-plans-next']")
		private WebElement pageNextButton;
		
		@FindBy(css = ".planRemoveSort span")
		private WebElement sortBreadCrumbs;
		
		@FindBy(css = "#msVppZipCode")
		private WebElement zipcodeMSForm;

		@FindBy(css = "button[class*='view-plans-next disabled']")
		private WebElement pageNextButtonDisabled;

		@FindBy(css = "button[class*='view-plans-prev']")
		private WebElement pagePreviousButton;

		@FindBy(css = "button[class*='view-plans-prev disabled']")
		private WebElement pagePreviousButtonDisabled;

		// Plan Tile Elements

		@FindBy(xpath = ".//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]")
		private List<WebElement> plantiles;
		
		@FindBy(css = "li.planTileGrid")
		private List<WebElement> plantiles1;
		
		@FindBy(css = "div.modal-inner button[class*='modal-close']")
		private WebElement modelCloseICon;
		
		@FindBy(css = "div.modal-inner .bodyContent p")
		private WebElement modelPara;

		@FindBy(css = "div.modal-inner div[class*='separatePlanImages']")
		private WebElement modelImage;
		
		@FindBy(css = "div.modal-inner h2#modal-label")
		private WebElement modelTiltle;

		@FindBy(css = "#modal")
		private WebElement drugModel;

		@FindBy(css = "#modal button")
		private WebElement drugModelClose;

		// Bottom Result page Elements

		@FindBy(css = "div[class*='resourcesSection'] h2")
		private WebElement resourcesTitle;

		@FindBy(css = ".moreAboutPlansSection h2")
		private WebElement moreAboutPlanTypesTitle;

		@FindBy(css = ".moreAboutPlansSection p")
		private WebElement moreAboutPlanTypesPara;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] .accordion-title h3")
		private WebElement mapdPlanTypesTitle;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='MAPD']")
		private WebElement MAPDCheckOption;
		
		@FindBy(css = "#PlanDetails .back-to-plans")
		private WebElement MSplanDetailsPage;

		@FindBy(css = "#PlanDetails h1.heading-1")
		private WebElement MSplanNameInDetailsPage;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='Medicare']")
		private WebElement MedigapCheckOption;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='PDP']")
		private WebElement PDPCheckOption;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='SNP']")
		private WebElement SNPCheckOption;

		@FindBy(xpath = ".//uhc-accordion[contains(@ng-reflect-title,'Medicare Advantage Plans')]//span[contains(@class,'accordion-arrow')]")
		private WebElement mapdPlanTypesFlipArrow;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] p")
		private WebElement mapdPlanTypesPara;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Advantage Plans'] a")
		private WebElement mapdPlanTypesLearnmoreLink;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] .accordion-title h3")
		private WebElement madsupPlanTypesTitle;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] span[class*='accordion-arrow'] svg")
		private WebElement madsupPlanTypesFlipArrow;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] p")
		private WebElement madsupPlanTypesPara;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='MAPD'] span.checkbox-square")
		private WebElement MAPDCheck;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='Medicare'] span.checkbox-square")
		private WebElement MedigapCheck;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='PDP'] span.checkbox-square")
		private WebElement PDPCheck;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='SNP'] span.checkbox-square")
		private WebElement SNPCheck;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Supplement Insurance'] a")
		private WebElement madsupPlanTypesLearnmoreLink;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] .accordion-title h3")
		private WebElement pdpPlanTypesTitle;

		@FindBy(xpath = ".//uhc-accordion[contains(@ng-reflect-title,'Medicare Prescription Drug')]//span[contains(@class,'accordion-arrow')]")
		private WebElement pdpPlanTypesFlipArrow;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] p")
		private WebElement pdpPlanTypesPara;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Medicare Prescription Drug'] a")
		private WebElement pdpPlanTypesLearnmoreLink;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] .accordion-title h3")
		private WebElement dsnpPlanTypesTitle;

		@FindBy(xpath = ".//uhc-accordion[contains(@ng-reflect-title,'Dual Special Needs')]//span[contains(@class,'accordion-arrow')]")
		private WebElement dsnpPlanTypesFlipArrow;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] p")
		private WebElement dsnpPlanTypesPara;

		@FindBy(css = "uhc-accordion[ng-reflect-title*='Dual Special Needs'] a")
		private WebElement dsnpPlanTypesLearnmoreLink;

		// Plan details page

		@FindBy(css = "div.content h2")
		private WebElement planNameDetailsPage;
		
		@FindBy(css = "div[class*='bottomPaginationSec'] div[class*='pdf-section']")
		private WebElement ImpResSection;
		
		@FindBy(css="div.sortBySection #plansSorting")
		private WebElement sortByDropdown;
		
		@FindBy(css = "div.sortBySection div.applySec>button")
		private WebElement applyBtn;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='SNP']>label")
		private WebElement SNPCheckLabel;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='PDP']>label")
		private WebElement PDPCheckLabel;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='Medicare']>label")
		private WebElement MedigapCheckLabel;
		
		@FindBy(css = "div.sortBySection uhc-checkbox[ng-reflect-name*='MAPD']>label")
		private WebElement MAPDCheckLabel;
		
		@FindBy(css = "a#ghn_lnk_1")
		private WebElement Home;
		
		public void applySort(String planType) {
			Assert.assertTrue(validate(sortByDropdown), "SortBy Dropdown is missing");
			sortByDropdown.click();
			threadsleep(2000);

			if (planType.equalsIgnoreCase("mapd")) {
				validate(MAPDCheck, 20);
				MAPDCheck.click();
			}
			if (planType.equalsIgnoreCase("medigap")) {
				validate(MedigapCheck, 20);
				MedigapCheck.click();
			}
			if (planType.equalsIgnoreCase("pdp")) {
				validate(PDPCheck, 20);
				PDPCheck.click();
			}
			if (planType.equalsIgnoreCase("snp")) {
				validate(SNPCheck, 20);
				SNPCheck.click();
			}
			Assert.assertTrue(validate(applyBtn), "apply Button is missing");
			jsClickNew(applyBtn);
			threadsleep(2000);
		}
		
		public void VerifyPlanTile(String plan) {
			System.out.println("Verify the PlanType after applied Filter");
			String PlanType = null;
			String text = null;
			if (plan.equalsIgnoreCase("mapd"))
				text = "Part C";
			else if (plan.equalsIgnoreCase("medigap"))
				text = "Supplement";
			else if (plan.equalsIgnoreCase("pdp"))
				text = "Part D";
			else if (plan.equalsIgnoreCase("snp"))
				text = "Special";

			int plancount = plantiles.size();
		//	Assert.assertTrue(sortBreadCrumbs.getText().trim().contains(text),
		//			"BreadCrumbs not showing for " + plan + " PlanType");
			for (int i = 0; i < plancount; i++) {
				// System.out.println("I count is: "+i);
				PlanType = plantiles.get(i).findElement(By.xpath(".//div[contains(@class,'planNameType')]")).getText().trim();
				System.out.println("\n\n===============->"+PlanType+"===================->"+text+"==============\n\n");
				Assert.assertTrue(PlanType.contains(text), "Sort By Functionality is not working");
				try {
					pageNextButton.click();
					threadsleep(2000);
				}
				catch(Exception e) {
				//	mobileswipeHorizantal("40%", true);
				}
			}

		}
		
		public void sortByFunc(String plan) {
			System.out.println("Sorting  Options: " + plan);
			String options[] = plan.split(",");
			for (int i = 0; i < options.length; i++) {
				applySort(options[i]);
				VerifyPlanTile(options[i]);
			}
		}
		
		public void removeBreadcrumb() {
			System.out.println("Removing Filtered BreadCrumb");
			Assert.assertTrue(sortBreadCrumbs.isDisplayed(), "BreadCrumbs is not displaying");
			removeBreadCrumbs.click();
			threadsleep(5000);
			Assert.assertFalse(validate(sortBreadCrumbs, 20), "BreadCrumbs is displaying after remove breadcrumb");
		}
		
		public void sortByBreadcrumb() {
			System.out.println("Sorting Breadcrumb validation after PlanYear Toggle");
			threadsleep(5000);
			Assert.assertFalse(validate(sortBreadCrumbs, 20), "BreadCrumbs is displaying after PlanYear Toggle");
		}
		
		public void verifyDrugWhySeparateMdel(String planName) {
			int planIndex = findPlan(planName);
			jsClickNew(plantiles1.get(planIndex-1).findElement(By.cssSelector("button[id*='seperatePlanLink']")));
			threadsleep(2000);
			Assert.assertTrue(modelTiltle.getText().trim().contains("required"),
					"Why is a separate model not found in plan - " + planName);
			Assert.assertTrue(modelPara.getText().trim().contains("Part D"),
					"Why is a separate model not found in plan - " + planName);
			Assert.assertTrue(modelImage.getText().trim().contains("Supplement"),
					"Why is a separate model not found in plan - " + planName);
			validate(modelCloseICon);
			modelCloseICon.click();
			threadsleep(2000);
		}

	public void validateDrugInfo(String drugsInfo, String location) {
		System.out.println("Validating Drug Info...");
		String planName = "", drugName = "", drugStatus = "";
		String[] drugslist = drugsInfo.split(":");
		for (int i = 0; i < drugslist.length; i++) {
			String drugInfo = drugslist[i];
			if (drugInfo.trim().length() > 0) {
				String[] drugDetails = drugInfo.split(",");
				planName = drugDetails[0];
				drugName = drugDetails[1];
				drugStatus = drugDetails[2];
				if (location.toLowerCase().contains("tile"))
					verifyDrugdata(planName, drugName, drugStatus);
				if (location.toLowerCase().contains("model"))
					verifyDrugdataModel(planName, drugName, drugStatus);
				if (location.toLowerCase().contains("show"))
					verifyDrugShowMore(planName, drugName);
				if (location.toLowerCase().contains("whyseparatemodel"))
					verifyDrugWhySeparateMdel(planName);
			}
		}
	}
	
	public void verifyDrugdata(String planName, String drugName, String drugStatus) {
		int planIndex = findPlan(planName);
		String drugText = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//div[contains(@class,'displayDrugsUI')])["+planIndex+"]")).getText()
				.trim();
		// String drugText =
		// plantiles.get(planIndex).findElement(drugInfo).getText().trim();
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in plan - " + planName);
		// Either all True or all False drugs for a plan
		int covered = 0, nonCovered = 0;
		covered = plantiles1.get(planIndex-1)
				.findElements(By.cssSelector("div[class*='displayDrugsUI'] span[class^='covered']")).size();
		nonCovered = plantiles1.get(planIndex-1)
				.findElements(By.cssSelector("div[class*='displayDrugsUI'] span[class^='non-covered']")).size();
		System.out.println("Validating Drug Coverage...");
		if (drugStatus.toLowerCase().contains("true")) {
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else if (drugStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(covered < 1, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else {
			if (!planName.toUpperCase().contains("PATRIOT"))
				Assert.assertTrue(
						validate(plantiles1.get(planIndex-1)
								.findElement(By.cssSelector("div[class*='displayDrugsUI'] a.buttonLink"))),
						"Add Drug link is not available");
			threadsleep(3000);
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be Zero drugs");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be Zero drugs");
		}

	}
	
	public void csnRanking(String snpOption) {
		String FirstplanName;
		String SecondplanName;
		FirstplanName = plantiles.get(0).findElement(By.cssSelector("h2>a")).getText().trim();
		SecondplanName = plantiles.get(1).findElement(By.cssSelector("h2>a")).getText().trim();
		if (snpOption.contains("nursing") || snpOption.contains("Medicaid")) {
			Assert.assertTrue(FirstplanName.contains("Silver"), "FirstplanName is not CSNP Silver Plan");
			Assert.assertTrue(SecondplanName.contains("D-SNP"), "SecondplanName is not D-SNP Plan");
		} else {
			Assert.assertTrue(FirstplanName.contains("Gold"), "FirstplanName is not CSNP Gold Plan");
			Assert.assertTrue(SecondplanName.contains("Silver"), "SecondplanName is not CSNP Silver Plan");
		}
	}
	
	public void sortByFuncWithoutVerify(String plan) {
		System.out.println("Sorting  Options: " + plan);
		String options[] = plan.split(",");
		for (int i = 0; i < options.length; i++) {
			applySort(options[i]);
		}
	}
	
	public void validateNoSortByElements() {
		System.out.println("Validate No Sort By UI ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		scrollToView(Home);
		threadsleep(2000);
		Assert.assertFalse(validate(sortByDropdown), "SortBy Dropdown is displaying");
	}
	
	public void validateSortByElements() {
		System.out.println("Validate Sort By UI Elements : ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		scrollToView(Home);
		threadsleep(2000);
		Assert.assertTrue(validate(sortByDropdown), "SortBy Dropdown is missing");
		jsClickNew(sortByDropdown);
		Assert.assertTrue(validate(MAPDCheckLabel), "MAPD Checkbox is missing");
		Assert.assertTrue(validate(MedigapCheckLabel), "Medigap Checkbox is missing");
		Assert.assertTrue(validate(PDPCheckLabel), "PDP Checkbox is missing");
		Assert.assertTrue(validate(SNPCheckLabel), "SNP Checkbox is missing");
		Assert.assertTrue(validate(applyBtn), "Apply button is missing");

		Assert.assertFalse(MAPDCheck.isSelected(), "MAPD is selected by default");
		Assert.assertFalse(MedigapCheck.isSelected(), "Medigap is selected by default");
		Assert.assertFalse(PDPCheck.isSelected(), "PDP is selected by default");
		Assert.assertFalse(SNPCheck.isSelected(), "SNP is selected by default");

		// Deselect All
		validate(applyBtn);
		optionSelection("MAPD,Medigap,PDP,SNP", false);
		applyBtn.click();
		threadsleep(3000);
		boolean dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);

	}
	
	public void optionSelection(String option, boolean select) {
		String options[] = option.split(",");
		for (int i = 0; i < options.length; i++) {
			checkUncheck(options[i], select);
			threadsleep(1000);
		}
	}
	
	public void addDoctorsLink() {
		threadsleep(5000);
		System.out.println("Adding doctors from PRE Result page");
		String pageCount1 = pagenoLabel.getText().trim();
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,-800)");
		js.executeScript("window.scrollBy(0,-800)");
		
		int currentPage = Integer
				.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("plan", ""));
		if (currentPage != 1) {
			for (int c = 1; c < currentPage; c++) {
				pagePreviousButton.click();
				threadsleep(2000);
			}
		}
		jsClickNew(plantiles.get(0).findElement(By.cssSelector("div[class*='provider'] a.buttonLink")));
		threadsleep(3000);
	}
	
	public void editDoctorsLink() {
		threadsleep(5000);
		System.out.println("Editing doctors from PRE Result page");
		String pageCount1 = pagenoLabel.getText().trim();
		int currentPage = Integer
				.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("plan", ""));
		if (currentPage != 1) {
			for (int c = 1; c < currentPage; c++) {
				jsClickNew(pagePreviousButton);
				threadsleep(2000);
			}
		}
		jsClickNew(plantiles.get(0).findElement(By.cssSelector("div[class*='provider'] button[dlassetid*='editDoc']")));
		threadsleep(3000);
	}
	
	public void checkUncheck(String checkOption, boolean select) {
		System.out.println("Selecting Option " + checkOption + " : " + select);
		WebElement elemCheck = null, elemClick = null;
		if (checkOption.equalsIgnoreCase("mapd")) {
			elemCheck = MAPDCheck;
			elemClick = MAPDCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("medigap")) {
			elemCheck = MedigapCheck;
			elemClick = MedigapCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("pdp")) {
			elemCheck = PDPCheck;
			elemClick = PDPCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("snp")) {
			elemCheck = SNPCheck;
			elemClick = SNPCheckLabel;
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
	
	public void optionVisibility(String option) {
		Assert.assertTrue(validate(sortByDropdown), "SortBy Dropdown is missing");
		sortByDropdown.click();
		String options[] = option.split(":");
		for (int i = 0; i < options.length; i++) {
			String optionInfo = options[i];
			if (optionInfo.trim().length() > 0) {
				String[] optionDetails = optionInfo.split(",");
				String planType = optionDetails[0];
				String visibility = optionDetails[1];
				disableCheck(planType, visibility);
			}
			threadsleep(2000);
			sortByDropdown.click();
		}
	}
	
	public void disableCheck(String planType, String visibility) {
		System.out.println("Validating " + planType + " Option: " + visibility);
		if (planType.equalsIgnoreCase("mapd"))
			Assert.assertEquals(MAPDCheckOption.getAttribute("ng-reflect-disabled"), visibility,
					"MAPD is not Disabled");
		if (planType.equalsIgnoreCase("medigap"))
			Assert.assertEquals(MedigapCheckOption.getAttribute("ng-reflect-disabled"), visibility,
					"Medigap is not Disabled");
		if (planType.equalsIgnoreCase("pdp"))
			Assert.assertEquals(PDPCheckOption.getAttribute("ng-reflect-disabled"), visibility, "PDP is not Disabled");
		if (planType.equalsIgnoreCase("snp"))
			Assert.assertEquals(SNPCheckOption.getAttribute("ng-reflect-disabled"), visibility, "SNP is not Disabled");
	}
	
	public void verifyDrugdataModel(String planName, String drugName, String drugStatus) {
		int planIndex = findPlan(planName);
		String PlanName = plantiles1.get(planIndex-1).findElement(By.cssSelector("h2>a")).getText().trim().toLowerCase();
		threadsleep(2000);
		System.out.println("PlanName is: " + PlanName);

		if (PlanName.contains("supplement")) {
			WebElement DocTitle = plantiles1.get(planIndex-1)
					.findElement(By.cssSelector("div[class*='providerSection'] h3"));
			WebElement MSPlanName = plantiles1.get(planIndex-1).findElement(By.cssSelector("h4[class*='pdpPlanName'] a"));
			scrollToView(DocTitle);
			planName = MSPlanName.getText().trim();
			WebElement viewModel = plantiles1.get(planIndex-1)
					.findElement(By.cssSelector("button[dlassetid*='pre_res_drug_modal']"));
			jsClickNew(viewModel);
			threadsleep(2000);

		} else {
			System.out.println("PlanIndex is: " + planIndex);
			WebElement viewind = plantiles1.get(planIndex-1)
					.findElement(By.cssSelector("button[dlassetid*='drug_modal']"));
			scrollToView(viewind);
			threadsleep(2000);
			jsClickNew(viewind);
			threadsleep(2000);
		}	
		
		String drugText = drugModel.getText().trim();
		Assert.assertTrue(drugText.contains(planName), "Plan Name not found in drug model - " + planName);
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in drug model - " + planName);
		// Either all True or all False drugs for a plan
		int covered = 0, nonCovered = 0;
		covered = drugModel.findElements(By.cssSelector("span[class^='covered']")).size();
		nonCovered = drugModel.findElements(By.cssSelector("span[class^='non-covered']")).size();
		System.out.println("Validating Drug Coverage in Model...");
		if (drugStatus.toLowerCase().contains("true")) {
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else if (drugStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(covered < 1, "Mismatch in Covered. Make all drugs covered for a plan");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered. Make all drugs not covered for a plan");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be Zero drugs");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be Zero drugs");
		}
		jsClickNew(drugModelClose);
		threadsleep(2000);
	}
	
	public void verifyDrugShowMore(String planName, String drugName) {
		int planIndex = findPlan(planName);
		System.out.println("\nPlan Index :"+planIndex);
		WebElement showMore = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//button[contains(@id,'showAllDrugsId')])["+planIndex+"]"));
		scrollToView(showMore);
		jsClickNew(showMore);
		String drugText = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//div[contains(@class,'displayDrugsUI')])["+planIndex+"]")).getText()
				.trim();
		Assert.assertTrue(drugText.contains(drugName), "Drug details not found in plan - " + planName);
		jsClickNew(driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//button[@id='showLessDrugsId'])["+planIndex+"]")));
	}
	
	public void verifyDoctorShowMore(String planName, String doctorName) {
		int planIndex = findPlan(planName);
		jsClickNew(plantiles1.get(planIndex-1).findElement(By.cssSelector("a[id*='showAllDoctorsId']")));
		String doctorText = plantiles1.get(planIndex-1).findElement(By.cssSelector("div[class*='providerSection']"))
				.getText().trim();
		Assert.assertTrue(doctorText.contains(doctorName), "Doctor details not found in plan - " + planName);
		jsClickNew(plantiles1.get(planIndex-1).findElement(By.cssSelector("a[id*='showLessDoctorsId']")));
	}
	
	public int findPlan(String uniqueName) {
		System.out.println("Finding a Plan...");
//		waitforResultsPage();
		scrollToView(pagePreviousButton);
		
		if(!driver.toString().contains("IOS")) {
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("window.scrollBy(0,-800)");
			js.executeScript("window.scrollBy(0,-800)");
		}
		scrollToView(pagenoLabel);
		String pageCount1;
		int currentPage;
		try {
			pageCount1 = pagenoLabel.getText().trim();
			currentPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("plan", ""));
		}catch (Exception e) {
			pageCount1 = driver.findElement(By.xpath("//span[contains(@class,'mobilePaginationText')]")).getText().trim();
			currentPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[0].replace("plan", ""));
		}
		if(currentPage != 1) {
			for(int c = 1; c < currentPage; c++) {
				pagePreviousButton.click();
				threadsleep(2000);
			}
		}
		boolean planAvailable = false;
		// String uniqueName = "Plan 1 (Regional PPO)";
		// int totalPlans = plantiles.size();
//		String pageCount1 = pagenoLabel.getText().trim();
		int totalPage;
		try {
			totalPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[1]);
		}catch (Exception e) {
			totalPage = Integer.parseInt(((pageCount1.toLowerCase().replace(" ", "").split("of")[1]).replace("ranked"," ")).split(" ")[0]);
		}
		int i = 1, planIndex = 1;
		do {
			// 3 plans per page

				String planName = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//h2//a)["+(planIndex)+"]")).getText().trim();
				scrollToView(driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//h2//a)["+(planIndex)+"]")));
				if (planName.contains(uniqueName.trim())) {
					planAvailable = true;
					break;
				}
				planIndex++;
				
			if (i == totalPage || planAvailable) {
				break;
			}
			jsClickNew(pageNextButton);
			threadsleep(2000);
			i++;
		} while (i <= totalPage);
		System.out.println("planAvailable - " + planAvailable);
		if (!planAvailable)
			planIndex = -1;
		return planIndex;
	}
	
	public void waitforResultsPage() {
		pageloadcomplete();
		waitForPageLoadSafari();
		validate(planZipInfo, 60);
		threadsleep(1000);
	}
	
	public void preResultsUI(String zip, String county) {
		System.out.println("Validating PRE Results UI Page: ");
		waitforResultsPage();
		Assert.assertTrue(planZipInfo.getText().contains(zip), "Invalid Zip");
	//	Assert.assertTrue(planZipInfo.getText().toUpperCase().contains(county.toUpperCase()), "Invalid County");
		Assert.assertTrue(Integer.parseInt(planZipInfo.getText().split(" ")[0]) > 0, "Total Plan count is less than 1");
		Assert.assertTrue(validate(editYourResponse, 60), " Issue in Edit Your Response button");
		// Assert.assertTrue(validate(saveYourResults, 60), " Issue in Save Your Results
		// button");
		// Assert.assertTrue(validate(viewMSPlans, 60), " Issue in View MS Plans
		// button");
		// Assert.assertTrue(sortByLabel.getText().contains("Sort By :"), "Invalid Sort
		// Text");
		// Assert.assertTrue(resourcesTitle.getText().contains("Resources"), "Invalid
		// Resources Text");
		Assert.assertTrue(moreAboutPlanTypesTitle.getText().contains("More About Plan Types"),
				"Invalid More About Plan Types Text");
		// scrollToView(moreAboutPlanTypesTitle);
		validate(moreAboutPlanTypesPara, 60);
		Assert.assertTrue(mapdPlanTypesTitle.getText().contains("Medicare Advantage Plans (Part C)"),
				"Invalid MAPD Text. Returned value " + mapdPlanTypesTitle.getText());
		validate(mapdPlanTypesPara, 60);
		Assert.assertTrue(mapdPlanTypesLearnmoreLink.getText().contains("Learn More About"),
				"Learn More About link not displayed");
		// Assert.assertTrue(madsupPlanTypesTitle.getText().contains("Medicare
		// Supplement Insurance Plans (Medigap)"),
		// "Invalid MADSUP Text");
		// validate(madsupPlanTypesPara, 60);
		Assert.assertTrue(validate(madsupPlanTypesPara, 10),
				"Medsub section should not display for PDP flow/Non-approved states");
		// Assert.assertTrue(madsupPlanTypesLearnmoreLink.getText().contains("Learn More
		// About"),
		// "Learn More About link not displayed");
		Assert.assertTrue(pdpPlanTypesTitle.getText().contains("Medicare Prescription Drug Plans (Part D)"),
				"Invalid PDP Text");
		validate(pdpPlanTypesPara, 60);
		Assert.assertTrue(pdpPlanTypesLearnmoreLink.getText().contains("Learn More About"),
				"Learn More About link not displayed");
		Assert.assertTrue(validate(dsnpPlanTypesTitle, 60), " Issue in DSNP Title");
		Assert.assertTrue(validate(dsnpPlanTypesPara, 60), " Issue in DSNP Text Area");
		Assert.assertTrue(validate(dsnpPlanTypesLearnmoreLink, 60), " Issue in DSNP Learnmore linke");
		threadsleep(3000);
		jsClickNew(mapdPlanTypesFlipArrow);
		validateNonPresenceOfElement(mapdPlanTypesLearnmoreLink);
		threadsleep(3000);
		// madsupPlanTypesFlipArrow.click();
		// validateNonPresenceOfElement(madsupPlanTypesLearnmoreLink);
		// threadsleep(3000);
		jsClickNew(pdpPlanTypesFlipArrow);
		validateNonPresenceOfElement(pdpPlanTypesLearnmoreLink);
		threadsleep(3000);
		jsClickNew(dsnpPlanTypesFlipArrow);
		validateNonPresenceOfElement(dsnpPlanTypesFlipArrow);
	}

	public void validatePagination() {
		System.out.println("Validating Pagination Functionality");
		waitforResultsPage();
		Assert.assertTrue(validate(pagenoLabel, 20), " Page count is not available");
		String pageCount1 = pagenoLabel.getText().trim();
		Assert.assertTrue(validate(pagePreviousButtonDisabled, 60), " Previous button Enabled in pagination");
//		Assert.assertFalse(validate(returnToBeginning, 3), " Return to Beginning is displayed");
		Assert.assertTrue(validate(pageNextButton, 60), "Next button is not available in pagination");
		pageNextButton.click();
		threadsleep(2000);
		Assert.assertFalse(validate(pagePreviousButtonDisabled, 60), " Previous button Disabled in pagination");
//		Assert.assertTrue(returnToBeginning.getText().contains("Return to beginning"), "Invalid Return to beginning Text");
		pagePreviousButton.click();
		threadsleep(2000);
		Assert.assertTrue(validate(pagePreviousButtonDisabled, 60), " Previous button Enabled in pagination");
//		Assert.assertFalse(validate(returnToBeginning, 3), " Return to Beginning is displayed");
		String pageCount2 = pagenoLabel.getText().trim();
		Assert.assertEquals(pageCount1, pageCount2, "Page count in not matching");
		int totalPage = Integer.parseInt(pageCount1.toLowerCase().replace(" ", "").split("of")[1]);
		driver.navigate().refresh();
		threadsleep(2000);
		for (int i = 1; i <= totalPage; i++) {
			scrollToView(pagenoLabel);
			pageCount1 = pagenoLabel.getText().trim();
			int currentPage = Integer
					.parseInt(pageCount1.split(" ")[1]);
			Assert.assertEquals(i, currentPage, "Page count is mismatch after pagenation");
			if (i == totalPage) {
				Assert.assertTrue(validate(pageNextButtonDisabled, 60), " Next button Enabled in pagination");
//				Assert.assertTrue(returnToBeginning.getText().contains("Return to beginning"),"Invalid Return to beginning Text");
			} else {
				jsClickNew(pageNextButton);
				threadsleep(2000);
			}
		}
	}
	
	public void validateDoctorInfo(String doctorsInfo, String location) {
		System.out.println("Validating Doctor Info...");
		String planName = "", doctorName = "", doctorStatus = "";
		String[] doctorslist = doctorsInfo.split(":");
		for (int i = 0; i < doctorslist.length; i++) {
			String doctorInfo = doctorslist[i];
			if (doctorInfo.trim().length() > 0) {
				String[] doctorDetails = doctorInfo.split(",");
				planName = doctorDetails[0];
				doctorName = doctorDetails[1];
				doctorStatus = doctorDetails[2];
				if(location.toLowerCase().contains("tile"))
					verifyDoctordata(planName, doctorName, doctorStatus);
				else
					verifyDoctorShowMore(planName, doctorName);
			}
		}
	}
	
	public void verifyDoctordata(String planName, String doctorName, String doctorStatus) {
		int planIndex = findPlan(planName);
		String doctorText = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//div[contains(@class,'providerSection')])["+planIndex+"]"))
				.getText().trim();
		Assert.assertTrue(doctorText.toLowerCase().contains(doctorName.toLowerCase()),
				"Doctor details not found in plan - " + planName);
		// Either all True or all False Doctors for a plan
		int covered = 0, nonCovered = 0;
		covered = plantiles1.get(planIndex-1)
				.findElements(By.cssSelector("div[class*='providerSection'] span[class^='covered']")).size();
		nonCovered = plantiles1.get(planIndex-1)
				.findElements(By.cssSelector("div[class*='providerSection'] span[class^='non-covered']")).size();
		System.out.println("Validating Doctor Coverage...");
		if (doctorStatus.toLowerCase().contains("true")) {
			// Below is the Text to be validated
			if (doctorName.toLowerCase().contains("Access to doctors".toLowerCase())
					|| doctorName.toLowerCase().contains("Access to in-network".toLowerCase())
					|| doctorName.toLowerCase().contains("local or National".toLowerCase())
					|| doctorName.toLowerCase().contains("any provider".toLowerCase())
					|| doctorName.toLowerCase().contains("provider nation".toLowerCase())
					|| doctorName.toLowerCase().contains("unitedhealthcare network".toLowerCase())) {
				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").contains(doctorName.toLowerCase().replace(" ", "")),
						"Doctor Description is Invalid in plan - " + planName);
			} else {
				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").replace("\n", "")
								.contains(doctorName.toLowerCase().replace(" ", "") + "In-Network".toLowerCase()),
						"Doctor details Invalid in plan - " + planName);
			}
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all Doctors covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all Doctors not covered for a plan");
		} else if (doctorStatus.toLowerCase().contains("false")) {

			if (doctorName.toLowerCase().contains("Access to doctors".toLowerCase())
					|| doctorName.toLowerCase().contains("Access to in-network".toLowerCase())
					|| doctorName.toLowerCase().contains("local or National".toLowerCase())
					|| doctorName.toLowerCase().contains("any provider".toLowerCase())
					|| doctorName.toLowerCase().contains("do not include".toLowerCase())
					|| doctorName.toLowerCase().contains("provider nation".toLowerCase())
					|| doctorName.toLowerCase().contains("unitedhealthcare network".toLowerCase())) {
				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").contains(doctorName.toLowerCase().replace(" ", "")),
						"Doctor Description is Invalid in plan - " + planName);
			} else {

				Assert.assertTrue(
						doctorText.toLowerCase().replace(" ", "").replace("\n", "")
								.contains(doctorName.toLowerCase().replace(" ", "") + "Out-Of-Network".toLowerCase()),
						"Doctor details Invalid in plan - " + planName);
			}
			Assert.assertTrue(covered < 1, "Mismatch in Covered. Make all Doctors covered for a plan");
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered. Make all Doctors not covered for a plan");
		} else if (doctorStatus.toLowerCase().contains("mscoverage")) {
			Assert.assertTrue(
					doctorText.toLowerCase().replace("\n", "")
							.contains(doctorName.toLowerCase() + "Accept Medicare Patient".toLowerCase()),
					"Doctor details Invalid in plan - " + planName);
			Assert.assertTrue(covered > 0, "Mismatch in Covered. Make all Doctors covered for a plan");
			Assert.assertTrue(nonCovered < 1, "Mismatch in Not Covered. Make all Doctors not covered for a plan");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be Zero Doctors");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be Zero Doctors");
		}
	}
	
	public void validateSNPInfo(String snpsInfo) {
		System.out.println("Validating SNP Info...");
		String planName = "", snpName = "", snpStatus = "";
		String[] snpslist = snpsInfo.split(":");
		for (int i = 0; i < snpslist.length; i++) {
			String drugInfo = snpslist[i];
			if (drugInfo.trim().length() > 0) {
				String[] drugDetails = drugInfo.split(",");
				planName = drugDetails[0];
				snpName = drugDetails[1];
				snpStatus = drugDetails[2];
				verifySNPdata(planName, snpName, snpStatus);
			}
		}
	}

	public void verifySNPdata(String planName, String snpName, String snpStatus) {
		int planIndex = findPlan(planName);
		String snpText = plantiles1.get(planIndex-1).findElement(By.cssSelector("*[class*='special-needs-ul']")).getText()
				.trim();
		Assert.assertTrue(snpText.contains(snpName), "SNP details not found in plan - " + planName);
		// Either all True or all False drugs for a plan
		int covered = 0, nonCovered = 0;
		covered = plantiles1.get(planIndex-1)
				.findElements(By.cssSelector("*[class*='special-needs-ul'] span[class^='covered']")).size();
		nonCovered = plantiles1.get(planIndex-1)
				.findElements(By.cssSelector("*[class*='special-needs-ul'] span[class^='non-covered']")).size();
		System.out.println("Validating SNP Coverage...");
		if (snpStatus.toLowerCase().contains("true")) {
			Assert.assertTrue(covered > 0, "Mismatch in Covered.");
		} else if (snpStatus.toLowerCase().contains("false")) {
			Assert.assertTrue(nonCovered > 0, "Mismatch in Not Covered.");
		} else if (snpStatus.toLowerCase().contains("noicon")) {
			System.out.println("No Coverage Icon for Non-SNP plans");
		} else {
			Assert.assertTrue(covered == 0, "Mismatch in Covered. Should be No coverage icon");
			Assert.assertTrue(nonCovered == 0, "Mismatch in Not Covered. Should be No coverage icon");
		}
	}
	
	public void viewPlanInfo(String planInfo) {
		threadsleep(5000);
		System.out.println("Navigating Plans Info...");
		String planName = "", planAction = "";
		String[] planDetails = planInfo.split(",");
		planName = planDetails[0];
		planAction = planDetails[1];
		int planIndex = findPlan(planName);

		if (planAction.toLowerCase().contains("link")) {
			String planFullName = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//*[contains(concat(' ',normalize-space(@class),' '),' planName ')]//a)["+planIndex+"]")).getText().trim();
			jsClickNew(driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//*[contains(concat(' ',normalize-space(@class),' '),' planName ')]//a)["+planIndex+"]")));
			threadsleep(5000);
			if (planName.contains("Plan A") || planName.contains("Plan B") || planName.contains("Plan F")
					|| planName.contains("Plan G") || planName.contains("Plan K") || planName.contains("Plan L")
					|| planName.contains("Plan N")) {
				threadsleep(10000);
				PlanRecommendationEngineResultsPage planSelectorResultspage = new PlanRecommendationEngineResultsPage(
						driver);
				if (validate(MSplanDetailsPage, 20)) {
					validate(MSplanNameInDetailsPage, 60);
					Assert.assertTrue(
							planFullName.toLowerCase().contains(MSplanNameInDetailsPage.getText().toLowerCase()),
							"Not navigated to Plan details page");
				} else {
					validate(zipcodeMSForm, 60);
					planSelectorResultspage.submitMSform();
					Assert.assertTrue(driver.getCurrentUrl().contains("/plan-summary"),
							"MS Plan Summary page is not loaded");
				}
			} else {
				validate(planNameDetailsPage, 60);
				Assert.assertTrue(planNameDetailsPage.getText().toLowerCase().contains(planFullName.toLowerCase()),
						"Not navigated to Plan details page");
			}
		}
		if (planAction.toLowerCase().contains("viewbutton")) {
			String planFullName = driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//*[contains(concat(' ',normalize-space(@class),' '),' planName ')]//a)["+planIndex+"]")).getText().trim();
			jsClickNew(driver.findElement(By.xpath("(.//li[contains(concat(' ',normalize-space(@class),' '),' planTileGrid ')]//div[@class='enrollSection']//button[text()='View Plan '])["+planIndex+"]")));
			if (planName.contains("Plan A") || planName.contains("Plan B") || planName.contains("Plan F")
					|| planName.contains("Plan G") || planName.contains("Plan K") || planName.contains("Plan L")
					|| planName.contains("Plan N")) {
				threadsleep(10000);
				PlanRecommendationEngineResultsPage planSelectorResultspage = new PlanRecommendationEngineResultsPage(
						driver);
				if (validate(MSplanDetailsPage, 20)) {
					validate(MSplanNameInDetailsPage, 60);
					Assert.assertTrue(
							planFullName.toLowerCase().contains(MSplanNameInDetailsPage.getText().toLowerCase()),
							"Not navigated to Plan details page");
				} else {
					validate(zipcodeMSForm, 60);
					planSelectorResultspage.submitMSform();
					Assert.assertTrue(driver.getCurrentUrl().contains("/plan-summary"),
							"MS Plan Summary page is not loaded");
				}
			} else {
				validate(planNameDetailsPage, 60);
				Assert.assertTrue(planNameDetailsPage.getText().toLowerCase().contains(planFullName.toLowerCase()),
						"Not navigated to Plan details page");
			}
		}
	}
	
	public void ImportantResource() {
		System.out.println("Validate ImportantResource Not Present");
		Assert.assertTrue(isElementPresent(ImpResSection), "ImportantResource is not displaying in Result Page");
		scrollToView(ImpResSection);
		threadsleep(3000);
		Assert.assertTrue(ImpResSectionPDFLinks.size()>0, "ImportantResource is not having PDF Links in Result Page");
	}
	
	public void pdfLink(String pdfname, String pdflink) {
		int pdfindex = 0;
		String curWindow = driver.getWindowHandle();
		System.out.println(curWindow);
		for(int p=0; p<ImpResSectionPDFLinks.size(); p++) {
			try {
				ImpResSectionPDFLinks.get(p).getText().contains(pdfname);
				pdfindex = p;
				break;
			}
			catch (Exception e) {
				System.out.println("Unable to find PDF with : " + p);
			}
		}
		windowSwape(pdfindex,curWindow,pdflink);
		
	}
	
	public void windowSwape(int p, String curWindow, String pdf ) {
		threadsleep(2000);
		ImpResSectionPDFLinks.get(p).click();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(windows);
		for (String window : windows) {
			System.out.println(window.replace("page-", ""));
			if (!window.equals(curWindow)) {
				driver.switchTo().window(window);
				Assert.assertTrue(driver.getCurrentUrl().contains(pdf), "PDF doc is not correct one");
				driver.close();
			}else
				System.out.println("It is Primary Window");
			threadsleep(5000);
			driver.switchTo().window(curWindow);
		}
	}
	
	public void findPDF(String uniqueName) {
		System.out.println("Finding a PDF... " + uniqueName);
		if(uniqueName.contains("wrap")) 
			pdfLink("AARP Medicare","WR1000");
		if(uniqueName.contains("cms guide")) 
			pdfLink("Health Insurance","GU25125ST");
		if(uniqueName.contains("pov")) 
			pdfLink("plan overview","POV");
		if(uniqueName.contains("rate pages")) 
			pdfLink("Rate Pages","RP");
		if(uniqueName.contains("rd")) 
			pdfLink("Rules and Disclosures","RD");
		if(uniqueName.contains("bt")) 
			pdfLink("Benefit Tables","RD");
		if(uniqueName.contains("ooc")) 
			pdfLink("Outline of Coverage","OOC");
		if(uniqueName.contains("creeed enroll")) 
			pdfLink("Enrollment Discount","WB");
		if(uniqueName.contains("selecthd")) 
			pdfLink("Select Provider","HD1000");
	}
	
	public void importantResourceSection(String ImpRes) {
		System.out.println("Validate ImportantResource Present and Links");
		ImportantResource();
		threadsleep(3000);
		System.out.println("Validating PDF document Info...");
		String resName = "";
		if(ImpRes.isEmpty())
			System.out.println("Resources is Empty ");
		else
		{
			String[] resDetails = ImpRes.split(",");
			for (int i = 0; i < resDetails.length; i++) {
				resName = resDetails[i].toLowerCase();
				findPDF(resName);
			}
		}
	}

	public void learnMore(String learnMore) {
		waitforResultsPage();
		String curURL = driver.getCurrentUrl();

		if (learnMore.contains("Advantage"))
			jsClickNew(mapdPlanTypesLearnmoreLink);
		if (learnMore.contains("Supplement"))
			jsClickNew(madsupPlanTypesLearnmoreLink);
		if (learnMore.contains("Drug"))
			jsClickNew(pdpPlanTypesLearnmoreLink);
		if (learnMore.contains("Special"))
			jsClickNew(dsnpPlanTypesLearnmoreLink);

		threadsleep(5000);
		String newURL = driver.getCurrentUrl();
		Assert.assertFalse(curURL.contains(newURL), "Invalid Navigation");

	}
}