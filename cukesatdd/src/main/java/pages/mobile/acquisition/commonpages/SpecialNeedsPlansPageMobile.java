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
import pages.acquisition.commonpages.WhentoEnrollinMedicarePage;

import java.util.List;

public class SpecialNeedsPlansPageMobile extends GlobalWebElements {
    public SpecialNeedsPlansPageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Special Needs Plans (SNPs)");
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Special Needs Plans (SNPs)')]")
    public WebElement header;

    @FindBy(xpath = "//span//a[contains(@href,'/shop/dual-special-needs-plans.html')]")
    public WebElement lnkShopDSNP;

    @FindBy(xpath = "//span[contains(text(),'Next')]/ancestor::*//span//a[contains(@href,'/medicare-education/when-to-enroll.html')]")
    public WebElement lnkNextWhenToEnroll;


    /*public void checkInpageNavigation() {
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

    public void clickOnDSNPCoverage() {
        sleepBySec(2);
        jsClickNew(lnkShopDSNP);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/shop/dual-special-needs-plans.html")) {
            System.out.println("'Learn more about Dual Special Needs coverage' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about Dual Special Needs coverage' Link Clicked not Successful");
        }
    }

    public WhentoEnrollinMedicarePageMobile clickOnMedicareEnrollment() {
        sleepBySec(2);
        jsClickNew(lnkNextWhenToEnroll);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("medicare-education/when-to-enroll.html")) {
            return new WhentoEnrollinMedicarePageMobile(driver);
        } else {
            return null;
        }
    }
}
