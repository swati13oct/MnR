package pages.acquisition.commonpages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;

@SuppressWarnings({ "deprecation" })
public class LearnAboutMedicareHomePage extends GlobalWebElements {

	public LearnAboutMedicareHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	private WebElement lnkLearnAboutMedicare;

	/* LearnAboutMedicare-Eligibility option */
	@FindBy(xpath = "//*[contains(text(),'Eligibility')]")
	private WebElement lnkEligibility;

	/* List of options under LearnAboutMedicare */
	@FindBy(xpath = "//*[@class='nav-col__title']")
	private List<WebElement> lstLearnAboutMedicare;

	/* LearnAboutMedicare headings */
	@FindBy(xpath = "//*[@class='nav-col__sub']")
	private List<WebElement> lstLearnAboutMedicareTitle;

	/* Medicare Advantage link */
	//@FindBy(xpath = "//a[contains(@class,'tile')]//span[contains(text(),'Advantage')]")
	@FindBy(xpath="//a[contains(@href,'/medicare-education/medicare-advantage')]//span[contains(text(),'Advantage')]")
	private WebElement lnkMedicareAdvantage;
	
	//Medicare Supplement link
	@FindBy(xpath="(//span[contains(text(),'Supplement')])[4]")
	private WebElement lnkMedicareSupplement;

	

	/* Prescription Drug Plans link */
	@FindBy(xpath = "(//span[contains(text(),'Prescription Drug Plans')])[2]")
	private WebElement lnkPrescriptionDrugPlan;
	
	@FindBy(xpath="//a[contains(@class, 'back-to-top')]")
    private WebElement backToTop;
	
	@FindBy(xpath="(//span[contains(text(),'Enrollment Basics')])")
	private WebElement lnkEnrollmentBasic;
	

	public WebElement getLnkMedicareAdvantage() {
		return lnkMedicareAdvantage;
	}
	public WebElement getLnkMedicareSupplement() {
			return lnkMedicareSupplement;
	}
	public WebElement getLnkPrescriptionDrugPlan() {
		return lnkPrescriptionDrugPlan;
	}

	public WebElement getLnkLearnAboutMedicare() {
		return lnkLearnAboutMedicare;
	}

	public WebElement getLnkEligibility() {
		return lnkEligibility;
	}

	public List<WebElement> getLstLearnAboutMedicare() {
		return lstLearnAboutMedicare;
	}

	public List<WebElement> getLstLearnAboutMedicareTitle() {
		return lstLearnAboutMedicareTitle;
	}

	@FindBy(xpath="//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement FindAnAgent; 
	
	@FindBy(xpath = "//input[contains(id,'updates-email') or contains(@id,'learnmore-email-address')]")
	private WebElement requestshoppageemailaddress;
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement requestplaninformationLearnMedicaresubmit;
	
	@FindBy(xpath = "//p[contains(text(),'Your guide will arrive in your inbox')]")
	private WebElement requestplaninformationLearnMedicaresubmitpopup;
	
	@FindBy(xpath = "//span[contains(@id,'learnmore-email-error')]")
	private WebElement RequestPlanInformationLearnMedicarepages_ErrorMessage;
	
	/* logic to navigate to Learn About medicare page from other pages */
	public void pagebackButton() {
		int i = 0;
		waitforElementVisibilityInTime(getLnkMedicareAdvantage(), 10000);
		//waitforElementNew(getLnkLearnAboutMedicare());

		backButtonClick(getLstLearnAboutMedicare().get(i));
		new MedicareEligibilityPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new CoverageChoicesPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new PrescriptionsProvidersBenefitsPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new CostBasicsPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new MedicareAdvantagePartCPlansPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new MedicarePrescriptionDrugPartDPlansPage(driver).backMedicareEducationHome();

		backButtonClick(getLstLearnAboutMedicare().get(++i));
		new EnrollmentBasicsPage(driver).backMedicareEducationHome();

	}

	public void backButtonClick(WebElement element) {
		//navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicareTitle().get(0));
		navigateToMenuLinks(getLnkLearnAboutMedicare(), element);
	}

	/* logic to access links of learn medicare using tab key */
	public void checktabKeyMedBacklink() {
		int i = 0, j = 0;
		waitforElementVisibilityInTime(getLnkMedicareAdvantage(), 10000);
		//waitforElementNew(getLnkLearnAboutMedicare());

		navigateToMedicareMenuLinks(getLstLearnAboutMedicare().get(0));

		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(i)),
				(new MedicareEligibilityPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new CoverageChoicesPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new PrescriptionsProvidersBenefitsPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new CostBasicsPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new MedicareAdvantagePartCPlansPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new MedicarePrescriptionDrugPartDPlansPage(driver)).backMedicareEducationHome());
		fnTabKey(getLstLearnAboutMedicare().get(++j));
		checkTab(fnEnterKey(getLstLearnAboutMedicare().get(++i)),
				(new EnrollmentBasicsPage(driver)).backMedicareEducationHome());

	}

	private void checkTab(Object fnTabKeyClick, Object backMedicareEducationHome) {
		navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicareTitle().get(0));
	}

	/* logic to simulate tabkey of keyboard here */
	public Object fnTabKey(WebElement element) {
		element.sendKeys(Keys.TAB);

		return null;
	}

	/* logic to simulate enterkey of keyboard here */
	public Object fnEnterKey(WebElement element) {
		element.sendKeys(Keys.ENTER);
		return null;
	}

	/* logic to check URL and Title of learn About Medicare */
	public void checkMedicareURLAndTitle() {
		String titleAARP = "AARP� Medicare Plans from UnitedHealthcare�";
		String titleUHC = "Medicare Coverage Options from UnitedHealthcare�";
		String baseUrlTitle = getTitle();
		for (int i = 0; i < getLstLearnAboutMedicare().size(); i++) {
			if (getLstLearnAboutMedicare().get(i).isEnabled()) {
				navigateToMedicareMenuLinks(getLstLearnAboutMedicare().get(i));
				if (driver.getCurrentUrl().contains("supplement"))
					compareValues(medicareUrlMapping()[i]);
				else if (medicareUrlMapping()[i].contains("supplement"))
					continue;
				else
					compareValues(medicareUrlMapping()[i]);

				if (baseUrlTitle.contains("AARP"))
					checkTitle(titleAARP);
				else
					checkTitle(titleUHC);

			}

		}

	}

	/* logic to access links of learn about medicare and click on it */
	public void navigateToMedicareMenuLinks(WebElement menuDropListItem) {

		navigateToMenuLinks(getLnkLearnAboutMedicare(), menuDropListItem);
	}

	public void navigateToMenuLinks(WebElement hdrMenuElement, WebElement menuDropListItem) {

		/*Actions actions = new Actions(driver);
		actions.moveToElement(hdrMenuElement);
		actions.moveToElement(menuDropListItem);
		actions.click().build().perform();*/
		jsMouseOver(hdrMenuElement);
		jsMouseOver(menuDropListItem);
		CommonUtility.checkPageIsReadyNew(driver);

	}

	/* logic to check header of learn about medicare */
	public void checkMedicareMenuHeaders() {
		waitforElementVisibilityInTime(getLnkMedicareAdvantage(), 10000);

		navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicareTitle().get(0));
		for (int i = 0; i < getLstLearnAboutMedicareTitle().size(); i++) {
			System.out.println(getLstLearnAboutMedicareTitle().get(i).getText());
			Assertion.assertTrue("Medicare-Menu-header-mismatch, incorrect header displayed",
					getLstLearnAboutMedicareTitle().get(i).getText().contains(medicareMenuHeaders()[i]));

		}

		for (int i = 0; i < getLstLearnAboutMedicare().size(); i++) {
			if (getLstLearnAboutMedicare().get(i).isEnabled()) {

				if (getLstLearnAboutMedicare().get(i).getText().contains("Supplement")) {
					Assertion.assertTrue("Medicare-Menu-links-Text-Mismatch, link's description is incorrect",
							getLstLearnAboutMedicare().get(i).getText().contains(medicareMenuText()[i]));
				}
				else
					if((medicareMenuText()[i]).contains("Supplement"))
						continue;
				else
					Assertion.assertTrue("Medicare-Menu-links-Text-Mismatch, link's description is incorrect",
							getLstLearnAboutMedicare().get(i).getText().contains(medicareMenuText()[i]));
				System.out.println(getLstLearnAboutMedicare().get(i).getText());
			}
		}

	}

	/* logic to check title of a page */
	public void checkTitle(String title) {

		Assertion.assertTrue("Title mismatch, incorrect page loaded", getTitle().contains(title));
		System.out.println(getTitle());
	}

	/* logic to compare URL */
	private void compareValues(String value) {
		checkURL(value);
		driver.navigate().back();
	}

	/* logic to compare URL */
	public void checkURL(String url) {

		Assertion.assertTrue("URL mismatch, incorrect page loaded", currentUrl().contains(url));
		System.out.println(currentUrl());

	}

	/* part of url to be compared */
	private String[] medicareUrlMapping() {
		String urlMapping[] = {

				"medicare-education/medicare-eligibility.html",
				"medicare-education/medicare-parts-and-medigap-plans.html", "medicare-education/medicare-benefits.html",
				"medicare-education/medicare-costs.html", "medicare-education/medicare-advantage-plans.html",
				"medicare-supplement-plans.html", "medicare-education/medicare-part-d.html",
				"medicare-education/enrollment-and-changing-plans.html" };
		return urlMapping;
	}

	/* Learn About medicare options */
	private String[] medicareMenuText() {
		String txtmedicareMenu[] = {

				"Eligibility", "Coverage Choices", "Prescriptions, Providers & Benefits", "Cost Basics",
				"Medicare Advantage Plans", "Medicare Supplement Insurance Plans","Medicare Prescription Drug Plans", "Enrollment Basics" };
		return txtmedicareMenu;
	}

	/* Learn About medicare headers */
	private String[] medicareMenuHeaders() {

		String txtmenuHeaders[] = {

				"Introduction to Medicare", "Types of UnitedHealthcare Plans", "Enrollment & Changing Plans" };
		return txtmenuHeaders;

	}

	/* Accessing Eligibility option from the learn About medicare menu */
	public MedicareEligibilityPage navigateToMedicareEligibility() {

		navigateToMenuLinks(getLnkLearnAboutMedicare(), getLstLearnAboutMedicare().get(0));
		return new MedicareEligibilityPage(driver);

	}

	/* Accessing MedicareAdvantage option from the learn About medicare homePage */
	public MedicareAdvantagePartCPlansPage planSelectionMA() {
//		getLnkMedicareAdvantage().click();
		WebElement lnkMA;
		if(driver.getCurrentUrl().contains("classic")){
		lnkMA = driver.findElement(By.xpath("//a[contains(@class,'tile')]//span[contains(text(),'Advantage')]"));
		}
		else{
		lnkMA=driver.findElement(By.xpath("//a[contains(@href,'/medicare-education/medicare-advantage')]//span[contains(text(),'Advantage')]"));
		}
		jsClickNew(lnkMA);
		waitForPageLoadSafari();
		return new MedicareAdvantagePartCPlansPage(driver);

	}
	public MedicareSupplementInsurancePlansPage planSelectionMS() {
//		getLnkMedicareSupplement().click();
		jsClickNew(getLnkMedicareSupplement());
		waitForPageLoadSafari();
		return new MedicareSupplementInsurancePlansPage(driver);

	}

	/*
	 * Accessing MedicarePrescriptionDrug option from the learn About medicare
	 * homePage
	 */
	public MedicarePrescriptionDrugPartDPlansPage planSelectionPDP() {
//		getLnkMedicareAdvantage().click();
		jsClickNew(getLnkMedicareAdvantage());
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		return new MedicarePrescriptionDrugPartDPlansPage(driver);

	}
	public PrescriptionsProvidersBenefitsPage selectBenifitsEducation() {
		
		WebElement medBenifits= driver.findElement(By.xpath("(//a[contains(@href,'medicare-benefits')])[3]"));
		validateNew(medBenifits);
		jsClickNew(medBenifits);
		waitForPageLoadSafari();
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains("medicare-education/medicare-benefits.html")||checkUrl.contains("/medicare-education-classic/medicare-benefits-classic.html")) {
			return new PrescriptionsProvidersBenefitsPage(driver);
		}else
		{
			return null;
		}
		
	}
	public CostBasicsPage navigatetoMedicareCostBasic() {
		
		WebElement lnkMedCostBasic= driver.findElement(By.xpath("(//a[contains(@href,'medicare-cost')])[3]"));
		validateNew(lnkMedCostBasic);
		jsClickNew(lnkMedCostBasic);
		waitForPageLoadSafari();
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains("medicare-education/medicare-costs.html")||checkUrl.contains("/medicare-education-classic/medicare-costs-classic.html")) {
			return new CostBasicsPage(driver);
		}else
		{
			return null;
		}
	}
	public MedicareEligibilityPage selectMedicareEligibility() {
		WebElement lnkMedEligibility= driver.findElement(By.xpath("//span[contains(text(),'Medicare Eligibility')]"));
		validateNew(lnkMedEligibility);
		jsClickNew(lnkMedEligibility);
		
		waitForPageLoadSafari();
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains("medicare-education/medicare-eligibility.html")||checkUrl.contains("/medicare-education-classic/medicare-eligibility-classic.html")) {
			return new MedicareEligibilityPage(driver);
		}else
		{
			return null;
		}
		
	}
	public CoverageChoicesPage clickonCoverageChoicesLink() {
		//WebElement lnkcvrgChoice=driver.findElement(By.xpath("//div[contains(@class,'tile')]//a[contains(@href,'medicare-parts')]//span[contains(text(),'Coverage')]"));
		WebElement lnkcvrgChoice=driver.findElement(By.xpath("//a[contains(@href,'medicare-parts')]//span[contains(text(),'Coverage')]"));
		validateNew(lnkcvrgChoice);
		jsClickNew(lnkcvrgChoice);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains("medicare-education/medicare-parts-and-medigap-plans.html")||checkUrl.contains("/medicare-education-classic/medicare-parts-and-medigap-plans-classic.html")) {
			return new CoverageChoicesPage(driver);
		}else
		{
			return null;
		}
		
	}
	
	public void clickonFindanAgentlinkfromMedEd(String ExpectedUHCAgentURL ) {
		
		validateNew(FindAnAgent);
		CommonUtility.waitForPageLoadNew(driver, FindAnAgent, 30);
		String parentWindow = driver.getWindowHandle();
//		FindAnAgent.click();
		jsClickNew(FindAnAgent);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while(itr.hasNext()) {
			String window = itr.next();
			if(!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}
		
		/*CommonUtility.checkPageIsReadyNew(driver);
		String CurrentUHCAgentURL = driver.getCurrentUrl();
		System.out.println("myuhcagent Page is displayed : "+CurrentUHCAgentURL);
		System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
		
		if(ExpectedUHCAgentURL.equalsIgnoreCase(CurrentUHCAgentURL)) {
			System.out.println("****************myuhcagent Page is displayed  ***************");

			Assertion.assertTrue(true);
		}
		else {
			Assertion.fail("****************myuhcagent Page is not loaded ***************");
		}*/
		CommonUtility.checkPageIsReadyNew(driver);
		if(siteLeavingPopupProceddButton.isDisplayed()){
			jsClickNew(siteLeavingPopupProceddButton);
		}
		sleepBySec(3);
		String CurrentUHCAgentURL = driver.getCurrentUrl();
		String ActualCurrentUHCAgentURL=CurrentUHCAgentURL.substring(0, 27).trim();
		System.out.println("myuhcagent Page is displayed : "+ActualCurrentUHCAgentURL);
		System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
		System.out.println("Actual myuhcagent URL: "+ActualCurrentUHCAgentURL);

		if(ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
			System.out.println("****************myuhcagent Page is displayed  ***************");

			Assertion.assertTrue(true);
		}
		else {
			Assertion.fail("****************myuhcagent Page is not loaded ***************");
		}
	
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnReadNextLink() {
		// TODO Auto-generated method stub

		//WebElement lnkNext=driver.findElement(By.xpath("//span[contains(text(),'Read Next')]/following-sibling::span//a"));
		WebElement lnkNext;
		if(driver.getCurrentUrl().contains("classic")){
			lnkNext=driver.findElement(By.xpath("//span[contains(text(),'Read Next')]/following-sibling::span//a"));
		}else{
			lnkNext=driver.findElement(By.xpath("//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a"));

		}

		validateNew(lnkNext);
		jsClickNew(lnkNext);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getTitle());
		
	}
	
	
	public void selectStateForGeotargeting() {
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		WebElement stateDropDown = driver.findElement(By.id("state-select"));
		scrollToView(stateDropDown);
		waitTllOptionsAvailableInDropdown(stateDropDown, 5);
		stateDropDown.click();
		WebElement stateGeotargeting = driver.findElement(By.xpath("(//select[@id='state-select']//option)[2]"));
//		scrollToView(stateGeotargeting);
		stateGeotargeting.click();
		//jsClickNew(stateGeotargeting);
		waitforElementNew(stateGeotargeting, 5);
		System.out.println("State selected for Geotagging: "+ stateGeotargeting.getText());
		waitforElementNew(stateGeotargeting, 5);
	}
	public void checkInnerPageLinks(String pageName) {
		
		if (pageName.contains("Prescription"))
		{
			WebElement drugcvrg = driver.findElement(By.xpath("//a//span[contains(text(),'prescription drug coverage?')]"));
			WebElement backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
			System.out.println(" Link Clicked: Will I have prescription drug coverage? ");
			jsClickNew(drugcvrg);
			jsClickNew(backtotop);		
			
			WebElement currentProvider = driver.findElement(By.xpath("//a//span[contains(text(),'current provider')]"));
			backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
			System.out.println(" Link Clicked: Will I still be able to see my current provider(s)? ");
			jsClickNew(currentProvider);
			jsClickNew(backtotop);
			
			WebElement additionBenefits= driver.findElement(By.xpath("//a//span[contains(text(),'additional benefits')]"));
			//backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
			System.out.println(" Link Clicked: Will I have coverage for additional benefits like vision, dental, or hearing aids? ");
			jsClickNew(additionBenefits);
			jsClickNew(backtotop);				
			
		}
		else if (pageName.contains("Eligibility")) {
			
			WebElement lnkEligibility=driver.findElement(By.xpath("//a//span[contains(text(),'Who is eligible for Medicare?')]"));
			WebElement backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
			jsClickNew(lnkEligibility);
			jsClickNew(backtotop);
			System.out.println(" Link Clicked: Who is eligible for Medicare? ");
			
			WebElement lnkPast65=driver.findElement(By.xpath("//a//span[contains(text(),'What if I continue to work past age 65?')]"));
			backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
			jsClickNew(lnkPast65);
			jsClickNew(backtotop);
			System.out.println(" Link Clicked: What if I continue to work past age 65? ");

			WebElement lnkNeedToEligible=driver.findElement(By.xpath("//a//span[contains(text(),\"What do I need to do when I'm eligible for Medicar\")]"));
			backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
			jsClickNew(lnkNeedToEligible);
			jsClickNew(backtotop);
			System.out.println(" Link Clicked: What do I need to do when I'm eligible for Medicare? ");

			WebElement lnkCvgChoice=driver.findElement(By.xpath("//a//span[contains(text(),'my coverage choices after')]"));
			backtotop=driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[4]"));
			jsClickNew(lnkCvgChoice);
			jsClickNew(backtotop);
			System.out.println(" Link Clicked: What are my coverage choices after I have Medicare? ");				
		}
		else if (pageName.contains("Coverage Choices")) {
			
			WebElement lnkcvrgChoice=driver.findElement(By.xpath("//a//span[contains(text(),'Get to know your coverage choices')]"));
			jsClickNew(lnkcvrgChoice);
			System.out.println(" Link Clicked: Get to know your coverage choices ");

			WebElement lnkogMedCvrg=driver.findElement(By.xpath("//a//span[contains(text(),'Original Medicare coverage from the U.S. governmen')]"));
			//WebElement lnkogMedCvrg=driver.findElement(By.xpath("//a//span[contains(text(),'Medicare coverage combinations')]"));
			scrollToView(lnkogMedCvrg);
			jsClickNew(lnkogMedCvrg);
			
			System.out.println(" Link Clicked: Medicare coverage combinations ");

			WebElement lnkPIC=driver.findElement(By.xpath("//a//span[contains(text(),'Coverage choices from private insurance companies')]"));
			scrollToView(lnkPIC);
			jsClickNew(lnkPIC);
			System.out.println(" Link Clicked: Coverage choices from private insurance companies ");

			WebElement lnkplanCombo=driver.findElement(By.xpath("//a//span[contains(text(),'Seven plan combo options')]"));
			//WebElement lnkplanCombo=driver.findElement(By.xpath("//a//span[contains(text(),'Key things to remember when choosing coverage')]"));
			scrollToView(lnkplanCombo);
			jsClickNew(lnkplanCombo);
			System.out.println(" Link Clicked: Seven plan combo options ");				
		}
		else if (pageName.contains("Cost Basics")) {
			
			/*WebElement lnkPremium=driver.findElement(By.xpath("(//a[contains(text(),'What is a premium?')])[2]"));
			jsClickNew(lnkPremium);
			System.out.println(" Link Clicked: What is a premium? ");
			
			WebElement lnkcostShare=driver.findElement(By.xpath("//a[contains(text(),'Which costs might I share with Original Medicare')]"));
			scrollToView(lnkcostShare);
			jsClickNew(lnkcostShare);
			
			System.out.println(" Link Clicked: Which costs might I share with Original Medicare or my plan? ");

			WebElement lnkSpending=driver.findElement(By.xpath("//a[contains(text(),'out-of-pocket spending?')]"));
			scrollToView(lnkSpending);
			jsClickNew(lnkSpending);
			System.out.println(" Link Clicked: Are there ways to limit my out-of-pocket spending? ");

			WebElement lnkPartAB=driver.findElement(By.xpath("//a[contains(text(),'(Parts A and B) costs?')]"));
			scrollToView(lnkPartAB);
			jsClickNew(lnkPartAB);
			System.out.println(" Link Clicked: What are Original Medicare (Parts A and B) costs? ");
			
			WebElement lnkMedCost=driver.findElement(By.xpath("(//a[contains(text(),'paying Medicare costs?')])[2]"));
			scrollToView(lnkMedCost);
			jsClickNew(lnkMedCost);
			System.out.println(" What if I need help paying Medicare costs? ");*/
		}
	}
	public void clickToYoutubeVideo() {
		WebElement btnPlay=driver.findElement(By.xpath("//div[contains(@class,'playBtn')]"));
		validateNew(btnPlay);
		scrollToView(btnPlay);
		jsClickNew(btnPlay);
		System.out.println("Video start playing");
		sleepBySec(10);
		jsClickNew(btnPlay);
		System.out.println("Video paused");
		
		
	}

	public void clickVideoTransciptLink() {
		WebElement lnkVideoTranscipt=driver.findElement(By.xpath("//*[contains(text(),'video transcript')]"));
		
		validateNew(lnkVideoTranscipt);
		jsClickNew(lnkVideoTranscipt);
		sleepBySec(1);
		if(driver.findElement(By.xpath("//h4[contains(text(),'Video transcript')]")).isDisplayed()) {
			System.out.println("Transcipt PDF link open successfully");
			jsClickNew(lnkVideoTranscipt);
			Assertion.assertTrue(true);
		}else {
			Assertion.fail("Transcipt PDF link did not open successfully");
		}
	}

	public void backToMedEdPage() {
		/*CommonUtility.checkPageIsReadyNew(driver);		
		waitForPageLoadSafari();
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		driver.switchTo().window(CommonConstants.getMainWindowHandle());*/
		if (driver.getWindowHandles().size() > 1) {
			String currentPage = driver.getWindowHandle();
			Set<String> newWindow = driver.getWindowHandles();
			for (String parentWindow : newWindow) {
				if (!parentWindow.equalsIgnoreCase(currentPage)) {
					driver.switchTo().window(currentPage).close();
					break;
				}
			}
		}
		else {
			driver.navigate().back();
		}
	} 

	public void navigateToSubMededPage(String pageName,String urlPath) {
		WebElement lnkNext=driver.findElement(By.xpath("//a[contains(@class,'card-link')]//span[contains(text(),'"+pageName+"')]"));
		validateNew(lnkNext);
		jsClickNew(lnkNext);
		WebElement breadcrumb=driver.findElement(By.xpath("//div[contains(@class,'breadcrumb')]//a[contains(@class,'inline') and contains(text(),'"+pageName+"')]"));
		waitforElementNew(breadcrumb, 8);
		waitForPageLoadSafari();
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains(urlPath)) {
			Assertion.assertTrue(true);
			System.out.println(pageName+" page loaded");
		}else
		{
			Assertion.fail(pageName+" page failed to load");
		}
				
	}
	public void clickOnSeePlanLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement lnkPlansAvailableInYourArea=driver.findElement(By.xpath("//span//a[contains(@href,'/health-plans')]"));
		scrollToView(lnkPlansAvailableInYourArea);
		Assertion.assertTrue("Plans Available link isn't present", lnkPlansAvailableInYourArea.isDisplayed());
		switchToNewTabNew(lnkPlansAvailableInYourArea);
		sleepBySec(10);
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("health-plans")) {
			Assertion.assertTrue(true);
			System.out.println("Plan Details page displayed Successfully");
			driver.close();
//			driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
			driver.switchTo().window(CommonConstants.getMainWindowHandle());
		}else {
			Assertion.fail("Plan Details page did not displayed Successfully");
		}
	}

	public EnrollmentBasicsPage clickonEnrollmentBasicLink() {
		validateNew(lnkEnrollmentBasic);
		jsClickNew(lnkEnrollmentBasic);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		
		String checkUrl=driver.getCurrentUrl();
		if(checkUrl.contains("/medicare-education-classic/enrollment-and-changing-plans-classic.html")) {
			return new EnrollmentBasicsPage(driver);
		}else
		{
			return null;
		}
		
	}
	public void hoverToPlanPage(String plantype) {
		WebElement learnAbtMedicare=driver.findElement(By.xpath("//a[@id='ghn_lnk_3']"));
		WebElement lnkPlan=null;
		if(plantype.equalsIgnoreCase("MA")) {
			lnkPlan=driver.findElement(By.xpath("(//a[contains(text(),'Advantage')])[3]"));
		}else if(plantype.equalsIgnoreCase("MS")) {
			lnkPlan=driver.findElement(By.xpath("(//a[contains(text(),'Supplement')])[1]"));
		}else if(plantype.equalsIgnoreCase("PDP")) {
			lnkPlan=driver.findElement(By.xpath("(//a[contains(text(),'Prescription Drug')])[3]"));
		}
		scrollToView(learnAbtMedicare);
		navigateToMedicareMenuLinks(learnAbtMedicare);
		jsClickNew(lnkPlan);
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("PlanType: "+ plantype);
		System.out.println(""+driver.getCurrentUrl());
		
	}
	public void chechStillHaveQues() {
		CommonUtility.checkPageIsReadyNew(driver);
		sleepBySec(4);
		WebElement stillQues=driver.findElement(By.xpath("//span[contains(text(),'Still have questions?')]"));
		validateNew(stillQues);
		if(stillQues.isDisplayed()) {
			Assertion.assertTrue(true);
		}
		else {
			Assertion.fail("Still have a question not displayed");
		}
		
	}
	
	
	
	public boolean RequestPlanIInformationshoppages(String EmailAddress)
			throws InterruptedException {

		boolean RequestPlanIInformation_Validation = true;

		boolean flag = true;
		
		requestshoppageemailaddress.clear();
		requestshoppageemailaddress.sendKeys("(*^*_asb@t.c");
		requestplaninformationLearnMedicaresubmit.click();
		if (validate(RequestPlanInformationLearnMedicarepages_ErrorMessage) && RequestPlanInformationLearnMedicarepages_ErrorMessage.isDisplayed()) {
			if (!RequestPlanInformationLearnMedicarepages_ErrorMessage.getText()
					.contains("Please enter a valid email address")) {
				System.out.println(
						"Email Invalid Error is Not  displayed : " + RequestPlanInformationLearnMedicarepages_ErrorMessage.getText());
				flag = false;
			}
			System.out.println("Email Invalid Error : " + RequestPlanInformationLearnMedicarepages_ErrorMessage.getText());

		} else {
			System.out.println("Email Invalid Error field is not displayed");

		}
		validateNew(requestshoppageemailaddress);
		requestshoppageemailaddress.clear();
		requestshoppageemailaddress.sendKeys(EmailAddress);
		System.out.println("Email Address is enetered : " + EmailAddress);
		validateNew(requestplaninformationLearnMedicaresubmit);
		jsClickNew(requestplaninformationLearnMedicaresubmit);
		if (requestplaninformationLearnMedicaresubmitpopup.getText().contains(
				"Your guide will arrive in your inbox shortly")) {
			System.out.println("****************Request  information is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			System.out.println("****************Request information is displayed  ***************");
		}
		return RequestPlanIInformation_Validation;

	}
}

