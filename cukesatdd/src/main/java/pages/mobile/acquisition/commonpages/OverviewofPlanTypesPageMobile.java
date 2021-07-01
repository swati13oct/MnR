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

import java.util.List;

public class OverviewofPlanTypesPageMobile extends GlobalWebElements {
    public OverviewofPlanTypesPageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Types of Medicare and Medigap Insurance Plans");
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Types of Medicare and Medigap Insurance Plans')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-advantage-plans.html')]//span[@class='link-text']")
    public WebElement lnkMA;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-supplement-plans.html')]//span[@class='link-text']")
    public WebElement lnkMedSupp;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-part-d.html')]//span[@class='link-text']")
    public WebElement lnkPDP;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/special-needs-plans.html')]//span[@class='link-text']")
    public WebElement lnkSNP;


    /*public void checkInpageNavigation() {
        String lnkText = "";
        for (int i = 0; i < inPageNavigationLinks.size(); i++) {
            if (i != 2)
                lnkText += inPageNavigationLinks.get(i).getText() + ";";
        }

        String linksPresent = "Introduction to Medicare;Types of Plans;Types of Plans;Medicare Advantage Plans;Medicare Supplement Insurance Plans;Medicare Prescription Drug Plans;Special Needs Plans;Medicare Enrollment;More about Medicare;FAQ;";
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

    public void clickonMAlink() {
        scrollToView(lnkMA);
        sleepBySec(1);
        jsClickNew(lnkMA);
        System.out.println("Learn more about Medicare Advantage plans link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-advantage-plans.html")) {
            Assert.assertTrue(true);
            System.out.println("Learn more about Medicare Advantage plans Link opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Learn more about Medicare Advantage plans link not opened");
        }
    }

    public void clickonMedSupplink() {
        scrollToView(lnkMedSupp);
        sleepBySec(1);
        jsClickNew(lnkMedSupp);
        System.out.println("Learn more about Medigap plans link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-education/medicare-supplement-plans.html")) {
            Assert.assertTrue(true);
            System.out.println("Learn more about Medigap plans Link opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Learn more about Medigap plans link not opened");
        }
    }


    public void clickonPDPlink() {
        scrollToView(lnkPDP);
        sleepBySec(1);
        jsClickNew(lnkPDP);
        System.out.println("Learn more about Medicare prescription drug plans clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-education/medicare-part-d.html")) {
            Assert.assertTrue(true);
            System.out.println("Learn more about Medicare prescription drug plans Link opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Learn more about Medicare prescription drug plans link not opened");
        }
    }

    public void clickonSNPlink() {
        scrollToView(lnkSNP);
        sleepBySec(1);
        jsClickNew(lnkSNP);
        System.out.println("Learn more about Special Needs Plans link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-education/special-needs-plans.html")) {
            Assert.assertTrue(true);
            System.out.println("Learn more about Special Needs Plans Link opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Learn more about Special Needs Plans link not opened");
        }
    }

}
