package pages.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MedicarePrescriptionDrugPartDPlansPageNew extends GlobalWebElements {
    public MedicarePrescriptionDrugPartDPlansPageNew(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Medicare Prescription Drug (Part D) Plans");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Medicare Prescription Drug (Part D) Plans')]")
    public WebElement header;

    @FindBy(xpath = "//p//span//a[contains(@href,'/medicare-education/medicare-advantage-plans.html')]")
    public WebElement lnkMAPlans;

    @FindBy(xpath = "(//a[contains(@href,'/medicare-education/extra-help-program.html')])[1]")
    public WebElement lnkExtaHelp;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-coverage-examples.html')]")
    public WebElement lnkMedCvgExample;

    @FindBy(xpath = "//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a")
    public WebElement lnkNextHowToEnroll;

    public void checkInpageNavigation() {
        String lnkText = "";
        for (int i = 0; i < inPageNavigationLinks.size(); i++) {
            if (i != 2)
                lnkText += inPageNavigationLinks.get(i).getText() + ";";
        }

        String linksPresent = "Introduction to Medicare;Types of Plans;Medicare Advantage Plans;Medicare Supplement Insurance Plans;Medicare Prescription Drug Plans;Special Needs Plans;Medicare Enrollment;More about Medicare;FAQ;";
        if (lnkText.equalsIgnoreCase(linksPresent)) {
            Assert.assertTrue(true);
            System.out.println("Links Present in Page Navigation: " + lnkText);
        } else {
            Assert.fail("All links not present: " + lnkText);
        }
    }

    public LearnAboutMedicareHomePageNew backtoMedicareEducationPage() {
        inPageNavigationLinks.get(0).click();
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education.html")) {
            return new LearnAboutMedicareHomePageNew(driver);
        } else {
            return null;
        }
    }

    public void clickOnMAPlansLink() {
        sleepBySec(2);
        jsClickNew(lnkMAPlans);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-advantage-plans.html")) {
            System.out.println("'Medicare Advantage Plans' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Medicare Advantage Plans' Link Clicked not Successful");
        }
    }

    public void clickOnExtraHelpLink() {
        sleepBySec(2);
        jsClickNew(lnkExtaHelp);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("medicare-education/extra-help-program.html")) {
            System.out.println("'qualify for the Extra Help program' Link Clicked Successfully"
                    + "\nExtra Help with Medicare Prescription Drug Costs Page Opened Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'qualify for the Extra Help program' Link Clicked not Successful"
                    + "\nExtra Help with Medicare Prescription Drug Costs Page did not Opened Successfully");
        }
    }

    public void clickOnCoverageExampleLink() {
        sleepBySec(2);
        jsClickNew(lnkMedCvgExample);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-coverage-examples.html")) {
            System.out.println("'See how Medicare costs may work with these Medicare coverage examples' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'See how Medicare costs may work with these Medicare coverage examples' Link Clicked not Successful");
        }
    }

    public HowtoEnrollinMedicarePage clickOnHowToEnroll() {
        sleepBySec(2);
        jsClickNew(lnkNextHowToEnroll);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/how-to-enroll-in-medicare.html")) {
            return new HowtoEnrollinMedicarePage(driver);
        } else {
            return null;
        }
    }
}
