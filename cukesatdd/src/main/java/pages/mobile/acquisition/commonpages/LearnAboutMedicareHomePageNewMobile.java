package pages.mobile.acquisition.commonpages;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.acquisition.commonpages.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LearnAboutMedicareHomePageNewMobile extends GlobalWebElements {
    public LearnAboutMedicareHomePageNewMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        validateNew(pageHeader);
        if (driver.getCurrentUrl().contains("medicare-education.html")) {
            Assert.assertEquals(pageHeader.getText(), "Medicare Made Clear");
            Assert.assertTrue(true);
            System.out.println("New Learn about Medicare Homepage opened Successfully");
        } else {
            Assert.fail("New Learn about Medicare Homepage not opened Successfully");
        }
    }

    @FindBy(xpath = "//h1[contains(text(),'Medicare Made Clear')]")
    private WebElement pageHeader;

    @FindBy(xpath = "//h1[contains(text(),'Medicare Made Clear')]")
    private WebElement breadCrumb;

    @FindBy(xpath = "//span[contains(text(),'Medicare Eligibility')]")
    private WebElement lnkMedicareEligibility;

    @FindBy(xpath = "//span[contains(text(),'Coverage Choices')]")
    private WebElement lnkCoverageChoices;

    @FindBy(xpath = "//span[contains(text(),'Prescriptions, Providers & Benefits')]")
    private WebElement lnkBenefits;

    @FindBy(xpath = "//span[contains(text(),'Medicare Cost Basics')]")
    private WebElement lnkCostBasics;

    @FindBy(xpath = "//a[contains(@href,'when-to-enroll')]//span[contains(text(),'Enrollment')]")
    private WebElement lnkEnrollment;

    @FindBy(xpath = "//a[contains(text(),'Original Medicare')]")
    private WebElement lnkOriginalMedicare;

    @FindBy(xpath = "//a[contains(@href,'medicare-education/medicare-advantage')]//span[contains(text(),'Advantage')]")
    private WebElement lnkMAPlans;

    @FindBy(xpath = "//a[contains(@href,'medicare-education/medicare-supp')]//span[contains(text(),'Supplement')]")
    private WebElement lnkMedSuppPlans;

    @FindBy(xpath = "//a[contains(@href,'medicare-education/medicare-part-d')]//span[contains(text(),'Prescription')]")
    private WebElement lnkPDPPlans;

    @FindBy(xpath = "//a[contains(@href,'medicare-education/special')]//span[contains(text(),'Special')]")
    private WebElement lnkSNPPlans;

    @FindBy(xpath = "//a[contains(text(),'Overview of Plan Types')]")
    private WebElement lnkOverviewOfPlans;

    @FindBy(xpath = "//span[contains(text(),'Learn More about Medicare Initial Enrollment Perio')]")
    private WebElement lnkLearnMoreMedicareIEP;

    @FindBy(xpath = "//span[contains(text(),'Learn More about Working Past 65')]")
    private WebElement lnkLearnMoreMedicareWP65;


    @FindBy(xpath = "//a[contains(@href,'https://www.myuhcagent.com/')]")
    private WebElement FindAnAgent;


    //Note: Links under 'Let's Get to Know Medicare' Section

    public MedicareEligibilityPageNewMobile clickOnMedicareEligibility() {
        scrollToView(lnkMedicareEligibility);
        jsClickNew(lnkMedicareEligibility);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-eligibility.html")) {
            return new MedicareEligibilityPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public CoverageChoicesPageNewMobile clickOnCoverageChoices() {
        scrollToView(lnkCoverageChoices);
        jsClickNew(lnkCoverageChoices);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-parts-and-medigap-plans.html")) {
            return new CoverageChoicesPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public PrescriptionProviderBenefitsPageNewMobile clickOnBenefitsLink() {
        scrollToView(lnkBenefits);
        jsClickNew(lnkBenefits);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-benefits.html")) {
            return new PrescriptionProviderBenefitsPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public CostBasicsPageNewMobile clickOnCostBasics() {
        scrollToView(lnkCostBasics);
        jsClickNew(lnkCostBasics);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-costs.html")) {
            return new CostBasicsPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public WhentoEnrollinMedicarePageMobile clickOnEnrollment() {
        scrollToView(lnkEnrollment);
        jsClickNew(lnkEnrollment);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/when-to-enroll.html")) {
            return new WhentoEnrollinMedicarePageMobile(driver);
        } else {
            return null;
        }
    }

    //Note: Links under 'Types of Medicare and Medigap Plans' Section

    public OriginalMedicarePageMobile clickOnOriginalMedicare() {
        jsClickNew(lnkOriginalMedicare);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/original-medicare.html")) {
            return new OriginalMedicarePageMobile(driver);
        } else {
            return null;
        }
    }

    public MedicareAdvantagePartCPlansPageNewMobile clickOnMAPlans() {
        jsClickNew(lnkMAPlans);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-advantage-plans.html")) {
            return new MedicareAdvantagePartCPlansPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public MedicareSupplementInsurancePlansPageNewMobile clickOnMedSupp() {
        jsClickNew(lnkMedSuppPlans);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-supplement-plans.html")) {
            return new MedicareSupplementInsurancePlansPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public MedicarePrescriptionDrugPartDPlansPageNewMobile clickOnPDPPlans() {
        jsClickNew(lnkPDPPlans);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-part-d.html")) {
            return new MedicarePrescriptionDrugPartDPlansPageNewMobile(driver);
        } else {
            return null;
        }
    }

    public SpecialNeedsPlansPageMobile clickOnSNPPlans() {
        jsClickNew(lnkSNPPlans);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/special-needs-plans.html")) {
            return new SpecialNeedsPlansPageMobile(driver);
        } else {
            return null;
        }
    }

    public OverviewofPlanTypesPageMobile clickOnOverviewOfPlanTypes() {
        jsClickNew(lnkOverviewOfPlans);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-plans-overview")) {
            return new OverviewofPlanTypesPageMobile(driver);
        } else {
            return null;
        }
    }

    //Note: Links under 'Getting Medicare the First Time' Section

    public InitialEnrollmentPeriodPageMobile clickOnLearnMoreAboutIEP() {
        jsClickNew(lnkLearnMoreMedicareIEP);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-initial-enrollment-period.html")) {
            return new InitialEnrollmentPeriodPageMobile(driver);
        } else {
            return null;
        }
    }

    public WorkingPast65PageMobile clickOnLearnMoreAboutWP65() {
        jsClickNew(lnkLearnMoreMedicareWP65);
        CommonUtility.checkPageIsReadyNew(driver);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-while-working.html")) {
            return new WorkingPast65PageMobile(driver);
        } else {
            return null;
        }
    }

    public boolean checkAllLinks() {
        if (validateNew(breadCrumb) || validateNew(lnkBenefits) || validateNew(lnkCostBasics) || validateNew(lnkCoverageChoices) || validateNew(lnkEnrollment) ||
                validateNew(lnkLearnMoreMedicareIEP) || validateNew(lnkLearnMoreMedicareWP65) || validateNew(lnkMAPlans) || validateNew(lnkMedicareEligibility) ||
                validateNew(lnkMedSuppPlans) || validateNew(lnkOriginalMedicare) || validateNew(lnkOverviewOfPlans) || validateNew(lnkPDPPlans) || validateNew(lnkSNPPlans)) {
            return true;
        } else {
            return false;
        }
    }

    public void clickonFindanAgentlinkfromMedEd(String ExpectedUHCAgentURL) {
        validateNew(FindAnAgent);
        CommonUtility.waitForPageLoadNew(driver, FindAnAgent, 30);
        String parentWindow = driver.getWindowHandle();
        jsClickNew(FindAnAgent);
        sleepBySec(3);
        Set<String> tabs_windows = driver.getWindowHandles();
        Iterator<String> itr = tabs_windows.iterator();
        while (itr.hasNext()) {
            String window = itr.next();
            if (!parentWindow.equals(window)) {
                driver.switchTo().window(window);
            }
        }

        CommonUtility.checkPageIsReadyNew(driver);
        String CurrentUHCAgentURL = driver.getCurrentUrl();
        String ActualCurrentUHCAgentURL = CurrentUHCAgentURL.substring(0, 27).trim();
        System.out.println("myuhcagent Page is displayed : " + ActualCurrentUHCAgentURL);
        System.out.println("Expected myuhcagent URL: " + ExpectedUHCAgentURL);
        System.out.println("Actual myuhcagent URL: " + ActualCurrentUHCAgentURL);

        if (ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
            System.out.println("****************myuhcagent Page is displayed  ***************");

            Assertion.assertTrue(true);
        } else {
            Assertion.fail("****************myuhcagent Page is not loaded ***************");
        }
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void clickToYoutubeVideo() {
        WebElement btnPlay = driver.findElement(By.xpath("//div[contains(@class,'playBtn')]"));
        validateNew(btnPlay);
        scrollToView(btnPlay);
        jsClickNew(btnPlay);
        System.out.println("Video start playing");
        sleepBySec(10);
        jsClickNew(btnPlay);
        System.out.println("Video paused");


    }

    public void clickVideoTransciptLink() {
        WebElement lnkVideoTranscipt = driver.findElement(By.xpath("//*[contains(text(),'video transcript')]"));
        validateNew(lnkVideoTranscipt);
        jsClickNew(lnkVideoTranscipt);
        sleepBySec(1);
        if (driver.findElement(By.xpath("//h4[contains(text(),'Video transcript')]")).isDisplayed()) {
            System.out.println("Transcipt PDF link open successfully");
            jsClickNew(lnkVideoTranscipt);
            Assertion.assertTrue(true);
        } else {
            Assertion.fail("Transcipt PDF link did not open successfully");
        }
    }
    /*WebElement tabRetirement=driver.findElement(By.xpath("//button[contains(@class,'tab2')]"));
    WebElement tabDisability=driver.findElement(By.xpath("//button[contains(@class,'tab3')]"));*/

    public void checkEDCTab1() {
        WebElement EDC = driver.findElement(By.xpath("//div[contains(@class,'enrollmentcalc')]"));
        scrollToView(EDC);
        sleepBySec(2);
        WebElement selectToolDropDown = driver.findElement(By.xpath("//button[contains(@class,'edcMobileMenu__button')]"));
        jsClickNew(selectToolDropDown);
        WebElement tabTurning65 = driver.findElement(By.xpath("//div[contains(@class,'uhc-menu__list-item mobileTab1')]"));
        jsClickNew(tabTurning65);
        System.out.println("Turning 65 tab opened");
        WebElement tab1Heading = driver.findElement(By.xpath("//h3[contains(text(),'Enter your date of birth')]"));
        validateNew(tab1Heading);
        Assert.assertTrue(tab1Heading.getText().contains("Enter your date of birth"), "EDC Tab 1 Header not Verified");
        WebElement lblDate = driver.findElement(By.xpath("//label[contains(text(),'Enter date of birth (MM/DD/YYYY)')]"));
        Assert.assertTrue(lblDate.getText().contains("Enter date of birth (MM/DD/YYYY)"), "EDC Tab 1 Date Field Label Not Verified");
        WebElement txtDate = driver.findElement(By.xpath("//input[@id='tab1-inputfield']"));
        validateNew(txtDate);
        txtDate.sendKeys("11111111");
        WebElement lblError = driver.findElement(By.xpath("//input[contains(@id,'tab1')]/following-sibling::p[@class='errorMsg']"));
        Assert.assertTrue(lblError.isDisplayed(), "Error Message Not Displayed");
        sleepBySec(2);
        txtDate.clear();
        txtDate.sendKeys("02111955");
        WebElement btnGetResult = driver.findElement(By.xpath("(//button//span[@class='EDCButtonSpan'])[1]"));
        jsClickNew(btnGetResult);
        System.out.println("Get Result Button Clicked");
        sleepBySec(2);
        WebElement IEPDate = driver.findElement(By.xpath("//h3[contains(text(),'February 11, 2020')]"));
        if (validateNew(IEPDate)) {
            System.out.println("Date Calculated in Turning 65 is correct");
        } else {
            System.out.println("Date Calculated in Turning 65 is not correct");
        }//div[contains(@class,'dob')]
        List<WebElement> calendars = driver.findElements(By.xpath("//div[contains(@class,'content1')]//div[contains(@class,'datecalender')]"));
        if (calendars.size() == 2 && calendars.get(0).isDisplayed() && calendars.get(1).isDisplayed()) {
            System.out.println("Both Calendars are displayed");
        } else {
            Assert.fail("Both Calendars are not displayed");
        }

        List<WebElement> markedMonths = driver.findElements(By.xpath("//div[contains(@class,'dob')]"));
        String months = "";

        for (WebElement m : markedMonths) {
            months += m.getText().replace("\n", " ").trim() + ";";
        }
        String checkMonths = "NOV 2019;DEC 2019;JAN 2020;FEB 2020;MAR 2020;APR 2020;MAY 2020;";
        if (months.equalsIgnoreCase(checkMonths)) {
            System.out.println("Correct Enrollment Months Displayed\nMonth List: " + months);
        } else {
            Assert.fail("Correct Enrollment Months Not Displayed\nMonth List: " + months);
        }
        WebElement btnstartOver = driver.findElement(By.xpath("//a[@class='startAgain' and contains(@onclick,'1')]"));
        jsClickNew(btnstartOver);
        System.out.println("Start Over button Clicked");
        sleepBySec(2);
        if (lblDate.isDisplayed() && txtDate.isDisplayed()) {
            System.out.println("Turning 65 Tab reset Successfully");
        } else {
            Assert.fail("Turning 65 Tab did not reset Successfully");
        }
    }

    public void checkEDCTab2() {
        WebElement EDC = driver.findElement(By.xpath("//div[contains(@class,'enrollmentcalc')]"));
        scrollToView(EDC);
        sleepBySec(2);
        WebElement selectToolDropDown = driver.findElement(By.xpath("//button[contains(@class,'edcMobileMenu__button')]"));
        jsClickNew(selectToolDropDown);
        WebElement tabRetirement = driver.findElement(By.xpath("//div[contains(@class,'uhc-menu__list-item mobileTab2')]"));
        jsClickNew(tabRetirement);
        System.out.println("Retirement tab opened");
        WebElement tab2Heading = driver.findElement(By.xpath("//h3[contains(text(),'Enter your retirement')]"));
        validateNew(tab2Heading);
        Assert.assertTrue(tab2Heading.getText().contains("Enter your retirement date or the date you're losing your employer coverage (whichever happens first)"), "EDC Tab 1 Header not Verified");
        WebElement lblDate = driver.findElement(By.xpath("//label[contains(@for,'tab2')]"));
        Assert.assertTrue(lblDate.getText().contains("Date you're losing coverage (MM/YYYY)"), "EDC Tab 2 Date Field Label Not Verified");
        WebElement txtDate = driver.findElement(By.xpath("//input[@id='tab2-inputfield']"));
        validateNew(txtDate);
        txtDate.sendKeys("111111");
        WebElement lblError = driver.findElement(By.xpath("//input[contains(@id,'tab2')]/following-sibling::p[@class='errorMsg']"));
        Assert.assertTrue(lblError.isDisplayed(), "Error Message Not Displayed");
        sleepBySec(2);
        txtDate.clear();
        txtDate.sendKeys("112020");
        WebElement btnGetResult = driver.findElement(By.xpath("(//button//span[@class='EDCButtonSpan'])[2]"));
        jsClickNew(btnGetResult);
        System.out.println("Get Result Button Clicked");
        sleepBySec(2);
        List<WebElement> IEPDate = driver.findElements(By.xpath("//h2[contains(text(),'February 2020')]"));
        if (IEPDate.size() == 2 && IEPDate.get(0).isDisplayed() && IEPDate.get(0).isDisplayed()) {
            System.out.println("Date Calculated in Retirement Tab is correct");
        } else {
            System.out.println("Date Calculated in Retirement Tab is not correct");
        }//div[contains(@class,'dob')]
        List<WebElement> calendars = driver.findElements(By.xpath("//div[contains(@class,'content2')]//div[contains(@class,'calenderContainer')]"));
        if (calendars.size() == 2 && calendars.get(0).isDisplayed() && calendars.get(1).isDisplayed()) {
            System.out.println("Both Calendars are displayed");
        } else {
            Assert.fail("Both Calendars are not displayed");
        }
        List<WebElement> retireMonth = driver.findElements(By.xpath("//div[contains(@class,'retirement')]"));
        String rmonths = "";
        for (WebElement m : retireMonth) {
            rmonths += m.getText().replace("\n", " ").trim() + ";";
        }
        String checkRMonths = "NOV 2020;NOV 2020;";
        if (retireMonth.size() == 2 && rmonths.equalsIgnoreCase(checkRMonths)) {
            System.out.println("Start Month Displayed Correct: " + rmonths);
        } else {
            Assert.fail("Start Month Not Displayed Correct: " + rmonths);
        }
        List<WebElement> markedMonths = driver.findElements(By.xpath("//div[contains(@class,'content2')]//div[contains(@class,'dob')]"));
        String months = "";

        for (WebElement m : markedMonths) {
            months += m.getText().replace("\n", " ").trim() + ";";
        }
        String checkMonths = "DEC 2020;JAN 2021;FEB 2021;MAR 2021;APR 2021;MAY 2021;JUNE 2021;JULY 2021;DEC 2020;JAN 2021;";
        if (months.equalsIgnoreCase(checkMonths)) {
            System.out.println("Correct Enrollment Months Displayed\nMonth List: " + months);
        } else {
            Assert.fail("Correct Enrollment Months Not Displayed\nMonth List: " + months);
        }
        WebElement btnstartOver = driver.findElement(By.xpath("//a[@class='startAgain' and contains(@onclick,'2')]"));
        jsClickNew(btnstartOver);
        System.out.println("Start Over button Clicked");
        sleepBySec(2);
        if (lblDate.isDisplayed() && txtDate.isDisplayed()) {
            System.out.println("Retirement Tab reset Successfully");
        } else {
            Assert.fail("Retirement Tab did not reset Successfully");
        }
    }

    public void checkEDCTab3() {
        WebElement EDC = driver.findElement(By.xpath("//div[contains(@class,'enrollmentcalc')]"));
        scrollToView(EDC);
        sleepBySec(2);
        WebElement selectToolDropDown = driver.findElement(By.xpath("//button[contains(@class,'edcMobileMenu__button')]"));
        jsClickNew(selectToolDropDown);
        WebElement tabDisability = driver.findElement(By.xpath("//div[contains(@class,'uhc-menu__list-item mobileTab3')]"));
        jsClickNew(tabDisability);
        System.out.println("Disability tab opened");
        WebElement tab3Heading = driver.findElement(By.xpath("//h3[contains(text(),'radio button')]"));
        validateNew(tab3Heading);
        Assert.assertTrue(tab3Heading.getText().contains("Choose a radio button if you have the following:"), "EDC Tab 1 Header not Verified");
        WebElement rdbALS = driver.findElement(By.xpath("//label//preceding::input[@value='radio1']"));
        WebElement rdbESRD = driver.findElement(By.xpath("//label//preceding::input[@value='radio2']"));
        WebElement rdbDisability = driver.findElement(By.xpath("//label//preceding::input[@value='radio3']"));
        WebElement btnGetResult = driver.findElement(By.xpath("//button[contains(@onclick,'EDC')]//span[@class='uhc-button__text']"));
        WebElement btnstartOver = driver.findElement(By.xpath("//div[contains(@class,'ESRD')]//following-sibling::div[@class='EDCResetRadio']//a[@class='startAgainRadio']"));

        //Validating ALS Content on EDC
        jsClickNew(rdbALS);
        jsClickNew(btnGetResult);
        sleepBySec(2);
        WebElement ALSContent = driver.findElement(By.xpath("//div[@class='EDCALSContent']"));
       /* String checkALSContent="Medicare Coverage and Lou Gehrig's Disease (ALS)\n" +
                "You are automatically enrolled in Original Medicare (Part A and Part B) the month your Social Security disability benefits begin when you have ALS. It's a good idea to apply for these benefits as soon as you are diagnosed, since there may be a waiting period before they kick in.\n" +
                "Even though you are enrolled in Original Medicare automatically, you may still make other Medicare coverage choices, such as adding Medicare Part D prescription drug coverage or choosing a Medicare Advantage plan.\n" +
                "\n";*/
        if (ALSContent.isDisplayed() /*&& ALSContent.getText().contentEquals(checkALSContent)*/) {
            System.out.println("ALS Content Displayed Successfully");
            System.out.println("ALS Content: " + ALSContent.getText());
        } else {
            Assert.fail("ALS Content Did Not Displayed Successfully: " + ALSContent.getText());
        }
        jsClickNew(btnstartOver);
        System.out.println("Start Over button Clicked");
        sleepBySec(2);
        if (rdbALS.isDisplayed() && rdbESRD.isDisplayed() && rdbDisability.isDisplayed()) {
            System.out.println("Retirement Tab reset Successfully");
        } else {
            Assert.fail("Retirement Tab did not reset Successfully");
        }

        //Validating ESRD Content on EDC
        jsClickNew(rdbESRD);
        jsClickNew(btnGetResult);
        sleepBySec(2);
        WebElement ESRDContent = driver.findElement(By.xpath("//div[@class='EDCESRDContent']"));
        String checkESRDContent = "Medicare Coverage and End Stage Renal Disease (ESRD)\n" +
                "You may get Medicare benefits at any age if you have ESRD and one of the following applies:\n" +
                "You are eligible for Medicare based on your work record.\n" +
                "You are already getting Social Security or Railroad Retirement Board benefits, or you are eligible for benefits.\n" +
                "Your spouse or parent meets one of the above requirements.\n" +
                "Medicare coverage starts the fourth month you receive dialysis treatments. For example, your Medicare coverage would start on October 1 if you start getting your dialysis treatments in July.\n" +
                "Medicare coverage could start the first month you receive treatments if all of these apply:\n" +
                "You attend a home dialysis training program provided by a Medicare-certified training facility.\n" +
                "Your doctor expects you to complete the training and be able to do your own dialysis treatments.\n" +
                "You maintain regular dialysis treatments throughout the usual required waiting period.\n" +
                "You must enroll in Original Medicare (Parts A and B) yourself. Once you have both Part A and Part B, you may make other Medicare coverage choices, such as adding Medicare Part D prescription drug coverage or choosing a Medicare Advantage plan.\n" +
                "If you are 65 or older, or disabled, and are already enrolled in Part A, you may enroll in Part B without penalty if you are approved for Medicare based on ESRD. You may also have an existing Part B late enrollment penalty removed.";
        if (ESRDContent.isDisplayed() && ESRDContent.getText().contentEquals(checkESRDContent)) {
            System.out.println("ESRD Content Displayed Successfully");
            System.out.println("ESRD Content: " + ESRDContent.getText());
        } else {
            Assert.fail("ESRD Content Did Not Displayed Successfully");
        }
        jsClickNew(btnstartOver);
        System.out.println("Start Over button Clicked");
        sleepBySec(2);
        sleepBySec(1);
        if (rdbALS.isDisplayed() && rdbESRD.isDisplayed() && rdbDisability.isDisplayed()) {
            System.out.println("Retirement Tab reset Successfully");
        } else {
            Assert.fail("Retirement Tab did not reset Successfully");
        }

        //Validating Disability Calendar on EDC
        jsClickNew(rdbDisability);
        sleepBySec(2);
        WebElement lblDate = driver.findElement(By.xpath("//p[@class='radioInputLabel']"));
        Assert.assertTrue(lblDate.getText().contains("Enter date you began receiving disability benefits (MM/YYYY)"), "EDC Tab 3 Date Field Label Not Verified");
        WebElement txtDate = driver.findElement(By.xpath("//p[@class='radioInputLabel']//following-sibling::input"));
        validateNew(txtDate);
        txtDate.sendKeys("111111");
        WebElement lblError = driver.findElement(By.xpath("//p[@class='radioInputLabel']/following-sibling::p[@class='errorMsg']"));
        Assert.assertTrue(lblError.isDisplayed(), "Error Message Not Displayed");
        sleepBySec(2);
        txtDate.clear();
        txtDate.sendKeys("112020");

        jsClickNew(btnGetResult);
        System.out.println("Get Result Button Clicked");
        sleepBySec(2);
        WebElement IEPDate = driver.findElement(By.xpath("//h3[contains(text(),'November 2020')]"));
        if (IEPDate.isDisplayed() && IEPDate.getText().contains("Initial Enrollment Period: Began receiving disability benefits in")) {
            System.out.println("Date Calculated in Disability Tab is correct");
        } else {
            System.out.println("Date Calculated in Disability Tab is not correct");
        }//div[contains(@class,'dob')]
        List<WebElement> calendars = driver.findElements(By.xpath("//div[contains(@class,'content3')]//div[contains(@class,'calenderContainer')]"));
        if (calendars.size() == 2) {
            System.out.println("Both Calendars are displayed");
        } else {
            Assert.fail("Both Calendars are not displayed");
        }
        List<WebElement> retireMonth = driver.findElements(By.xpath("//div[contains(@class,'retirement')]"));
        String rmonths = "";
        for (WebElement m : retireMonth) {
            rmonths += m.getText().replace("\n", " ").trim() + ";";
        }
        List<WebElement> markedMonths = driver.findElements(By.xpath("//div[contains(@class,'content3')]//div[contains(@class,'dob')]"));
        String months = "";

        for (WebElement m : markedMonths) {
            months += m.getText().replace("\n", " ").trim() + ";";
        }
        String checkMonths = "AUG 2022;SEP 2022;OCT 2022;NOV 2022;DEC 2022;JAN 2023;FEB 2023;";
        if (months.equalsIgnoreCase(checkMonths)) {
            System.out.println("Correct Enrollment Months Displayed\nMonth List: " + months);
        } else {
            Assert.fail("Correct Enrollment Months Not Displayed\nMonth List: " + months);
        }
        sleepBySec(2);
        jsClickNew(btnstartOver);
        System.out.println("Start Over button Clicked");
        sleepBySec(2);
        if (rdbALS.isDisplayed() && rdbESRD.isDisplayed() && rdbDisability.isDisplayed()) {
            System.out.println("Retirement Tab reset Successfully");
        } else {
            Assert.fail("Retirement Tab did not reset Successfully");
        }
    }

    public void validateEmailComponent() {
        WebElement txtFirstName = driver.findElement(By.xpath("//input[@id='emailCaptureInputId-0']"));
        WebElement txtLastName = driver.findElement(By.xpath("//input[@id='emailCaptureInputId-1']"));
        WebElement txtEmail = driver.findElement(By.xpath("//input[@id='emailCaptureInputId-2']"));
        WebElement txtDOB = driver.findElement(By.xpath("//input[@id='emailCaptureInputId-3']"));
        WebElement btnSubmit = driver.findElement(By.xpath("//fieldset//button[contains(@class,'email-button')]"));

        jsClickNew(btnSubmit);
        sleepBySec(2);

        WebElement ErrFirstName = driver.findElement(By.xpath("//p[@id='emailCaptureErrorMsg-0']"));
        WebElement ErrLastName = driver.findElement(By.xpath("//p[@id='emailCaptureErrorMsg-1']"));
        WebElement ErrEmail = driver.findElement(By.xpath("//p[@id='emailCaptureErrorMsg-2']"));
        WebElement ErrDOB = driver.findElement(By.xpath("//p[@id='emailCaptureErrorMsg-3']"));

        if (ErrFirstName.isDisplayed() && ErrLastName.isDisplayed() && ErrEmail.isDisplayed() && ErrDOB.isDisplayed()) {
            System.out.println("All Error Messages displayed in Email Form");
        } else {
            Assert.fail("All Error Messages not displayed in Email Form");
        }
        sleepBySec(1);

        txtFirstName.sendKeys("John");
        txtLastName.sendKeys("Wick");
        txtEmail.sendKeys("test@test.com");
        txtDOB.sendKeys("02241955");
        sleepBySec(1);
        jsClickNew(btnSubmit);
        sleepBySec(2);
        WebElement confirmaitonBox = driver.findElement(By.xpath("//div[@class='confirmationtext']"));
        if (confirmaitonBox.isDisplayed() && !confirmaitonBox.getText().isEmpty()) {
            System.out.println("Details submission Successful");
            System.out.println("Confirmation Message: " + confirmaitonBox.getText());
        } else {
            Assert.fail("Details submission not Successful");
        }
    }

    public void clickOnPlanRecommendationButton() {
        CommonUtility.checkPageIsReadyNew(driver);
        WebElement lnkPRE = driver.findElement(By.xpath("//a[contains(@href,'/plan-recommendation-engine.html') and @role='button']"));
        jsClickNew(lnkPRE);
        sleepBySec(5);
        if (driver.getCurrentUrl().contains("/plan-recommendation-engine.html")) {
            System.out.println("Plan Recommendation Engine open successfully");
            Assertion.assertTrue(true);
        } else {
            Assertion.fail("Plan Recommendation Engine did not open successfully");
        }
        driver.navigate().back();
    }

    public void validateWizardComponent() {
        WebElement btnWizard = driver.findElement(By.xpath("//div[contains(@class,'wizard')]//a[@role='button']"));
        scrollToView(btnWizard);
        sleepBySec(2);
        jsClickNew(btnWizard);
        WebElement WizardDialog = driver.findElement(By.xpath("//div[contains(@class,'wizard') and @role='dialog']"));
        WebElement wizardHeader = driver.findElement(By.xpath("//div[@class='header-container']//h2"));
        WebElement btnwizardClose = driver.findElement(By.xpath("//div[@class='header-container']//button"));
        if (WizardDialog.isDisplayed() && wizardHeader.isDisplayed()) {
            System.out.println("Working Past 65 Wizard Opened");
        } else {
            Assert.fail("Working Past 65 Wizard not Opened");
        }

        WebElement wizardQues = driver.findElement(By.xpath("//h3[@class='wizard-uhc-QuestionPara']"));
        WebElement ansYes = driver.findElement(By.xpath("//button//span[text()='Yes']"));
        WebElement ansNo = driver.findElement(By.xpath("//button//span[text()='No']"));
        WebElement startOver = driver.findElement(By.xpath("//a[@class='wizardStartAgain']"));

        String ques1 = "Do you currently receive Social Security or Railroad Retirement Board Benefits?";
        String ques2 = "Is your health insurance through your spouse" + String.valueOf(Character.toChars(8217)) + "s employer?";
        String ques3 = "Does the employer you get your health insurance from have 20 or more employees?";

        if (wizardQues.getText().trim().contentEquals(ques1)) {
            System.out.println("Question 1 Displayed: " + ques1);
            jsClickNew(ansYes);
            sleepBySec(1);
        } else {
            Assert.fail("Question 1 Not Displayed: " + wizardQues.getText());
        }

        if (wizardQues.getText().trim().contentEquals(ques2)) {
            System.out.println("Question 2 Displayed: " + ques2);
            jsClickNew(ansNo);
            sleepBySec(1);
        } else {
            Assert.fail("Question 2 Not Displayed: " + wizardQues.getText() + "\nCHeck Check" + ques2);
        }

        if (wizardQues.getText().trim().contentEquals(ques3)) {
            System.out.println("Question 3 Displayed: " + ques3);
            jsClickNew(ansYes);
            sleepBySec(1);
        } else {
            Assert.fail("Question 3 Not Displayed: " + wizardQues.getText());
        }

        WebElement wizardAnswer = driver.findElement(By.xpath("//p[@class='wizard-uhc-AnswerPara']"));
        WebElement wizardAnswerLink = driver.findElement(By.xpath("//a[@class='answerLink']"));
        if (wizardAnswer.isDisplayed() && wizardAnswerLink.isDisplayed()) {
            System.out.println("Your result on Wizard is Displayed");
        } else {
            Assert.fail("Your result on Wizard is Displayed");
        }
        String answer = "Because you" + String.valueOf(Character.toChars(8217)) + "re receiving Social Security / Railroad Retirement Board benefits, you will be automatically enrolled in Medicare Parts A & B when you turn 65. However, since your employer has 20 or more employees, you may be able to delay enrollment if you have creditable drug coverage!";
        if (wizardAnswer.getText().trim().contentEquals(answer)) {
            System.out.println("Correct Answer displayed on Wizard");
        } else {
            Assert.fail("Correct Answer not displayed on Wizard");

        }
        sleepBySec(2);

        switchToNewTabNew(wizardAnswerLink);
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-education/wp65-guide.html")) {
            System.out.println("Get Your Medicare When Working Guide & Resources Page open correctly");
        } else {
            Assert.fail("Get Your Medicare When Working Guide & Resources Page did not open correctly");
        }
        driver.close();
        driver.switchTo().window(CommonConstants.getMainWindowHandle());

        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(1);
        jsClickNew(startOver);
        System.out.println("Start Over Clicked");
        if (wizardQues.getText().trim().contentEquals(ques1)) {
            System.out.println("Wizard Reset Successfully");
            sleepBySec(1);
        } else {
            Assert.fail("Wizard Reset Successfully");
        }

        jsClickNew(btnwizardClose);
        if (!WizardDialog.isDisplayed()) {
            System.out.println("Wizard Close is successful");
        } else {
            Assert.fail("Wizard Close is not successful");
        }
    }


    public void navigateToPath(String path) {

        String CurrentURL = driver.getCurrentUrl();
        System.out.println("Current URL : " + CurrentURL);
        String NavigateToURL = CurrentURL.replace(".html", "/") + path;
        System.out.println("Navigating to URL : " + NavigateToURL);

        driver.navigate().to(NavigateToURL);
        waitForPageLoadSafari();
        CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
        System.out.println("Page Title : " + (driver.findElement(By.xpath("//title")).getText()));

    }


    public void validateDownloadLink(String headerText, String pdfName) {
        sleepBySec(2);
        WebElement header = driver.findElement(By.xpath("//h2//span[contains(@class,'2')]"));
        if (header.getText().trim().contentEquals(headerText)) {
            System.out.println(headerText + " PDF Page page opened successfully ");
        } else {
            Assert.fail(headerText + " PDF Page page opened successfully ");
        }

        WebElement lnkDownload = driver.findElement(By.xpath("//a[contains(text(),'Download PDF')]"));
        if (validateNew(lnkDownload) && lnkDownload.isDisplayed()) {
            System.out.println("Download PDF link present on Page");
        } else {
            Assert.fail("Download PDF link present on Page");
        }/*switchToNewTabNew(lnkDownload);
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains(pdfName)) {
            System.out.println(pdfName + " opened Correctly");
        } else {
            Assert.fail(pdfName + " not opened Correctly");
        }
        driver.close();
        driver.switchTo().window(CommonConstants.getMainWindowHandle());*/


    }

    public void validatePDFViewer() {
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(1);
        WebElement pdfViewer = driver.findElement(By.xpath("//iframe[contains(@id,'pdfviewer')]"));
        if (pdfViewer.isDisplayed()) {
            System.out.println("PDF Viewer is present on the page");
        } else {
            Assert.fail("PDF Viewer is not present on the page");
        }
        switchToNewIframe(pdfViewer);

        WebElement btnSearch = driver.findElement(By.xpath("//button[contains(@id,'documentSearch')]"));

        if (btnSearch.isDisplayed()) {
            System.out.println("Search Button is displayed");
        } else {
            Assert.fail("Search Button is not displayed");
        }
        driver.switchTo().defaultContent();
    }

    public void validatePdfMenuDownloadLink(String pdfName) {

        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(1);
        WebElement pdfViewer = driver.findElement(By.xpath("//iframe[contains(@id,'pdfviewer')]"));
        if (pdfViewer.isDisplayed()) {
            System.out.println("PDF Viewer is present on the page");
        } else {
            Assert.fail("PDF Viewer is not present on the page");
        }
        switchToNewIframe(pdfViewer);

        WebElement btnpdfSideMenu = driver.findElement(By.xpath("//button[contains(@class,'sideMenuButton')]"));
        jsClickNew(btnpdfSideMenu);
        WebElement pdfSideMenu = driver.findElement(By.xpath("//div[contains(@class,'spectrum-Dialog-content')]"));
        if (pdfSideMenu.isDisplayed()) {
            System.out.println("PDF menu clicked");
        } else {
            Assert.fail("PDF menu not clicked");
        }
        WebElement btnDownload = driver.findElement(By.xpath("//button[contains(@class,'Button')]//span[contains(text(),'Download PDF')]"));
        if (btnDownload.isDisplayed()) {
            System.out.println("Download option present in PDF Viewer");
        } else {
            Assert.fail("Download option is not present in PDF Viewer");
        }
        /*jsClickNew(btnDownload);
        System.out.println("Download Button Clicked");
        sleepBySec(2);
        driver.switchTo().defaultContent();
        driver.navigate().to("chrome://downloads/");
        sleepBySec(2);
        driver.switchTo().defaultContent();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement pdfDownload = (WebElement) executor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#mainContainer').querySelector('downloads-item').shadowRoot.querySelector('#content.is-active').querySelector('#details')");
        if (pdfDownload != null) {
            String downloadedPDFName = (pdfDownload.getText().split("\n"))[0].trim();
            if (downloadedPDFName.equalsIgnoreCase(pdfName))
                System.out.println("PDF Downloaded:\n" + downloadedPDFName);
        } else {
            Assert.fail("Correct PDF not downloaded");
        }

        driver.navigate().back();
        driver.switchTo().defaultContent();*/
    }

    /*public void validatePdfMenuPrintLink() {
        if (MRScenario.browserName.equalsIgnoreCase("chrome")) {
            CommonUtility.checkPageIsReadyNew(driver);
            driver.switchTo().defaultContent();
            sleepBySec(5);

            WebElement pdfViewer = driver.findElement(By.xpath("//iframe[contains(@id,'pdfviewer')]"));
            if (pdfViewer.isDisplayed()) {
                System.out.println("PDF Viewer is present on the page");
            } else {
                Assert.fail("PDF Viewer is not present on the page");
            }
            switchToNewIframe(pdfViewer);

            sleepBySec(3);
            WebElement btnpdfSideMenu = driver.findElement(By.xpath("//button[contains(@class,'sideMenuButton')]"));
            jsClickNew(btnpdfSideMenu);
            WebElement pdfSideMenu = driver.findElement(By.xpath("//div[contains(@class,'spectrum-Dialog-content')]"));
            if (pdfSideMenu.isDisplayed()) {
                System.out.println("PDF menu clicked");
            } else {
                Assert.fail("PDF menu not clicked");
            }
            WebElement btnPrint = driver.findElement(By.xpath("//button[contains(@class,'Button')]//span[contains(text(),'Print PDF')]"));
            jsClickNew(btnPrint);
            sleepBySec(2);

            //Switch to Print dialog
            Set<String> windowHandles = driver.getWindowHandles();
            if (!windowHandles.isEmpty()) {
                System.out.println("Size : " + windowHandles.size());
                driver.switchTo().window((String) windowHandles.toArray()[1]);
                System.out.println(driver.getCurrentUrl());
            }
            WebElement printPreview = driver.findElement(By.tagName("print-preview-app"));
            if (printPreview.isDisplayed()) {
                System.out.println("Print Functionality working successfully");
            } else {
                Assert.fail("Print Functionality not working successfully");
            }
            driver.switchTo().window((String) windowHandles.toArray()[1]);
            driver.getCurrentUrl();
            sleepBySec(2);
            driver.switchTo().defaultContent();

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            WebElement btnPrintCancel = (WebElement) executor.executeScript("return document.querySelector('print-preview-app').shadowRoot.querySelector('#sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('.cancel-button')");

            if (btnPrintCancel != null) {
                btnPrintCancel.click();
                System.out.println("Print Dialog Closed");
            } else {
                Assert.fail("Print Dialog not Closed");
            }
            driver.switchTo().window((String) windowHandles.toArray()[0]);
            ;
        } else {
            System.out.println("Print Validation not available on browser other than Chrome");
        }
    }*/
}
