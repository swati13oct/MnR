package pages.mobile.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.acquisition.commonpages.LearnAboutMedicareHomePageNew;
import pages.acquisition.commonpages.MedicareSupplementInsurancePlansPageNew;

import java.util.List;

public class MedicareAdvantagePartCPlansPageNewMobile extends GlobalWebElements {
    public MedicareAdvantagePartCPlansPageNewMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Medicare Advantage (Part C) Plans");
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Medicare Advantage (Part C) Plans')]")
    public WebElement header;

    @FindBy(xpath = "//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a")
    public WebElement lnkNextMedSupPlans;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/special-needs-plans.html')]//span[@class='link-text']")
    public WebElement lnkSNP;

    @FindBy(xpath = "//a[contains(@href,'/shop/medicare-advantage-veteran-plan.html')]")
    public WebElement lnkVeteran;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-coverage-examples.html')]")
    public WebElement lnkMedCvgExample;


   /* public void checkInpageNavigation() {
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

    public void clickOnSNPLink() {
        sleepBySec(2);
        jsClickNew(lnkSNP);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/special-needs-plans.html")) {
            System.out.println("'Get more information about Special Needs Plans' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Get more information about Special Needs Plans' Link Clicked not Successful");
        }
    }

    public void clickOnVeteranLink() {
        sleepBySec(2);
        jsClickNew(lnkVeteran);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/shop/medicare-advantage-veteran-plan.html")) {
            System.out.println("'Learn more about these Medicare Advantage plans here ' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about these Medicare Advantage plans here ' Link Clicked not Successful");
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

    public MedicareSupplementInsurancePlansPageNewMobile clickOnReadNextMedSuppPlanLink() {
        jsClickNew(lnkNextMedSupPlans);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-supplement-plans.html")) {
            return new MedicareSupplementInsurancePlansPageNewMobile(driver);
        } else {
            return null;
        }
    }

}
