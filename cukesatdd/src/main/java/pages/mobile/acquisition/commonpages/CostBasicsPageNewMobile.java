package pages.mobile.acquisition.commonpages;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.acquisition.commonpages.LearnAboutMedicareHomePageNew;
import pages.acquisition.commonpages.MedicareAdvantagePartCPlansPageNew;

import java.util.List;

public class CostBasicsPageNewMobile extends GlobalWebElements {
    public CostBasicsPageNewMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Medicare Cost Basics");
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Medicare Cost Basics')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/original-medicare.html')]//span[ contains(text(),'Learn')]")
    public WebElement lnkOriginalMedicare;

    @FindBy(xpath = "//a[contains(@href,'/shop/estimate/pdp-costs.html')]//span[ contains(text(),'Learn')]")
    public WebElement lnkEstimatePDP;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/extra-help-program.html')]//span[ contains(text(),'Learn')]")
    public WebElement lnkExtraHelpProgram;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-medicaid-dual-eligibility.html')]//span[ contains(text(),'Learn')]")
    public WebElement lnkDualEligibility;

    @FindBy(xpath = "//a[contains(@href,'/medicare-savings-programs')]")
    public WebElement lnkSavingsProgram;

    @FindBy(xpath = "//a[contains(@href,'get-help-paying-costs/pace')]")
    public WebElement lnkPACE;

    @FindBy(xpath = "//span//a[contains(@href,'/medicare-education/medicare-while-working.html')]")
    public WebElement lnkWP65;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/special-enrollment-for-medicare-when-working-past-65.html')]")
    public WebElement lnkArticleSEP;

    @FindBy(xpath = "//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a")
    public WebElement lnkNextMAPlans;


    /*public void checkInpageNavigation() {
        String lnkText = "";
        for (int i = 0; i < inPageNavigationLinks.size(); i++) {
            if (i != 1)
                lnkText += inPageNavigationLinks.get(i).getText() + ";";
        }
        String linksPresent = "Introduction to Medicare;Introduction;Eligibility;Coverage Options;Prescriptions, Providers & Benefits;Medicare Cost Basics;Original Medicare;Types of Plans;Medicare Enrollment;More about Medicare;FAQ;";
        if (lnkText.equalsIgnoreCase(linksPresent)) {
            Assert.assertTrue(true);
            System.out.println("Links Present in Page Navigation: " + lnkText);
        } else {
            Assert.fail("All links not present: " + lnkText);
        }
    }*/

    public LearnAboutMedicareHomePageNewMobile backtoMedicareEducationPage() {
        WebElement lnkMedEdHomepage = driver.findElement(By.xpath("//div[contains(@class,'bread')]//a[contains(@href,'/medicare-education.html')]"));
        jsClickNew(lnkMedEdHomepage);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education.html")) {
            return new LearnAboutMedicareHomePageNewMobile(driver);
        } else {
            return null;
        }
    }

    public void checkInnerLinks() {

        sleepBySec(2);
        WebElement lnkPartAB = driver.findElement(By.xpath("//a//span[contains(text(),'Parts A and B')]"));
        WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
        scrollToView(lnkPartAB);
        jsClickNew(lnkPartAB);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What are my costs for Original Medicare Parts A and B)?");

        sleepBySec(2);
        WebElement lnkMyCost = driver.findElement(By.xpath("//a//span[contains(text(),'paying Medicare costs?')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
        scrollToView(lnkMyCost);
        jsClickNew(lnkMyCost);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What are my costs with Medicare Advantage, Part D or Medigap plans? ");

        sleepBySec(2);
        WebElement lnkMedCost = driver.findElement(By.xpath("//a//span[contains(text(),'paying Medicare costs?')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
        scrollToView(lnkMedCost);
        jsClickNew(lnkMedCost);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What if I need help paying Medicare costs? ");
    }

    public void clickOnOriginalMedicareLink() {
        sleepBySec(2);
        jsClickNew(lnkOriginalMedicare);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("medicare-education/original-medicare.html")) {
            System.out.println("'Learn more about the specific costs " +
                    "for Medicare Part A and Part B' Link Clicked Successfully" + "\nOriginal Medicare Page Opened Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about the specific costs " +
                    "for Medicare Part A and Part B' Link Clicked not Successful" + "\nOriginal Medicare Page did not" +
                    " Opened Successfully");
        }
    }

    public void clickOnEstimatePDPLink() {
        sleepBySec(2);
        jsClickNew(lnkEstimatePDP);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("shop/estimate/pdp-costs.html")) {
            System.out.println("'Learn more about Medicare Prescription Drug plan costs' Link Clicked Successfully"
                    + "\nEstimate PDP Page Opened Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about Medicare Prescription Drug plan costs' Link Clicked not Successful"
                    + "\nEstimate PDP Page did not Opened Successfully");
        }
    }

    public void clickOnExtraHelpLink() {
        sleepBySec(2);
        jsClickNew(lnkExtraHelpProgram);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("medicare-education/extra-help-program.html")) {
            System.out.println("'Learn how to get help with prescription drug costs' Link Clicked Successfully"
                    + "\nExtra Help with Medicare Prescription Drug Costs Page Opened Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn how to get help with prescription drug costs' Link Clicked not Successful"
                    + "\nExtra Help with Medicare Prescription Drug Costs Page did not Opened Successfully");
        }

    }

    public void clickOnDualEligibilityLink() {
        sleepBySec(2);
        jsClickNew(lnkDualEligibility);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-medicaid-dual-eligibility.html")) {
            System.out.println("'Learn more about Medicaid and Dual Eligibility' Link Clicked Successfully"
                    + "\nMedicare vs Medicaid and Dual Eligibility Page Opened Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about Medicaid and Dual Eligibility' Link Clicked not Successful"
                    + "\nMedicare vs Medicaid and Dual Eligibility Page did not Opened Successfully");
        }
    }

    public void clickOnSavingProgramLink() {
        sleepBySec(2);
        switchToNewTabNew(lnkSavingsProgram);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/your-medicare-costs/get-help-paying-costs/medicare-savings-programs")) {
            System.out.println("'Find out if you qualify for Medicare Savings Programs' Link Clicked Successfully");
            driver.close();
            driver.switchTo().window(CommonConstants.getMainWindowHandle());
            sleepBySec(2);
        } else {
            Assert.fail("'Find out if you qualify for Medicare Savings Programs' Link Clicked not Successful");
        }
    }

    public void clickOnPACELink() {
        sleepBySec(2);
        switchToNewTabNew(lnkPACE);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/your-medicare-costs/get-help-paying-costs/pace")) {
            System.out.println("'Get more information about PACE' Link Clicked Successfully");
            driver.close();
            driver.switchTo().window(CommonConstants.getMainWindowHandle());
            sleepBySec(2);
        } else {
            Assert.fail("'Get more information about PACE' Link Clicked not Successful");
        }
    }

    public void clickOnMedicareSEPLink() {
        sleepBySec(2);
        jsClickNew(lnkArticleSEP);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-articles/special-enrollment-for-medicare-when-working-past-65.html")) {
            System.out.println("'Medicare Special Enrollment Period' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Medicare Special Enrollment Period' Link Clicked not Successful");
        }
    }

    public void clickOnWP65Link() {
        sleepBySec(2);
        jsClickNew(lnkWP65);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-while-working.html")) {
            System.out.println("Medicare When Working Past Age 65 Learn More' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Medicare When Working Past Age 65 Learn More' Link Clicked not Successful");
        }
    }

    public MedicareAdvantagePartCPlansPageNewMobile clickOnReadNextMAPlanLink() {
        jsClickNew(lnkNextMAPlans);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-advantage-plans.html")) {
            return new MedicareAdvantagePartCPlansPageNewMobile(driver);
        } else {
            return null;
        }
    }

}

