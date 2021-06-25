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
import pages.acquisition.commonpages.OverviewofPlanTypesPage;

import java.util.List;

public class OriginalMedicarePageMobile extends GlobalWebElements {
    public OriginalMedicarePageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'What is Original Medicare?')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-part-d.html')]//span[@class='link-text']")
    public WebElement lnkpdp;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare.html')]")
    public WebElement lnkArticleCoverage;

    @FindBy(xpath = "//h4//a[contains(@href,'/medicare-education/medicare-plans-overview.html')]")
    public WebElement lnkNextPlanOverview;

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "What is Original Medicare?");
    }


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

    public void clickonPDPlink() {
        scrollToView(lnkpdp);
        sleepBySec(1);
        jsClickNew(lnkpdp);
        System.out.println("Learn more about getting prescription drug coverage link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-education/medicare-part-d.html")) {
            Assert.assertTrue(true);
            System.out.println("Learn more about getting prescription drug coverage Link opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Learn more about getting prescription drug coverage link not opened");
        }
    }

    public void clickonArticleCoveragelink() {
        scrollToView(lnkArticleCoverage);
        sleepBySec(1);
        jsClickNew(lnkArticleCoverage);
        System.out.println("Learn how to get coverage for dental, vision and other benefits with Medicare Article link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare.html")) {
            Assert.assertTrue(true);
            System.out.println("How to Get Medicare Dental & Vision Coverage Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("How to Get Medicare Dental & Vision Coverage Article Page not opened");
        }
    }

    public OverviewofPlanTypesPageMobile clickonNextPlanOverviewLink() {
        scrollToView(lnkNextPlanOverview);
        sleepBySec(1);
        jsClickNew(lnkNextPlanOverview);
        System.out.println("Types of Medicare and Medigap Insurance Plans link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-plans-overview")) {
            return new OverviewofPlanTypesPageMobile(driver);
        } else {
            return null;
        }
    }


}
