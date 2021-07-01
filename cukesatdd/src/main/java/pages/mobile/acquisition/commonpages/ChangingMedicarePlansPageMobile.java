package pages.mobile.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.acquisition.commonpages.WorkingPast65Page;

import java.util.List;

public class ChangingMedicarePlansPageMobile extends GlobalWebElements {
    public ChangingMedicarePlansPageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Changing Medicare Plans')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/decide-change-plan.html')]")
    public WebElement lnkArticleDecideChangePlan;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period.html')]")
    public WebElement lnkArticlAEP;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period.html')]")
    public WebElement lnkWP65;

    @FindBy(xpath = "//h4//a[@href='/medicare-education/medicare-while-working.html']")
    public WebElement lnkLearnMoreMedicareWP65;

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Changing Medicare Plans");
    }

    /*public void checkInpageNavigation() {
        String lnkText = "";
        for (int i = 0; i < inPageNavigationLinks.size(); i++) {
            if (i != 3)
                lnkText += inPageNavigationLinks.get(i).getText().trim() + ";";
        }
        String linksPresent = "Introduction to Medicare;Types of Plans;Medicare Enrollment;When to Enroll;How to Enroll;Changing Plans;Working Past 65;More about Medicare;FAQ;";
        if (lnkText.equalsIgnoreCase(linksPresent)) {
            Assert.assertTrue(true);
            System.out.println("Links Present in Page Navigation: " + lnkText);
        } else {
            Assert.fail("All links not present: " + lnkText);
        }
    }*/

    public void checkInnerLinks() {
        WebElement lnkWhenChange = driver.findElement(By.xpath("//span[contains(text(),'When can I change Medicare plans?')]"));
        WebElement lnkHowChange = driver.findElement(By.xpath("//span[contains(text(),'How do I change Medicare plans?')]"));
        WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));

        scrollToView(lnkWhenChange);

        jsClickNew(lnkWhenChange);
        sleepBySec(2);
        jsClickNew(backtotop);
        System.out.println("Link Clicked: When can I change Medicare plans?");

        jsClickNew(lnkHowChange);
        sleepBySec(2);
        System.out.println("How do I change Medicare plans?");
    }

    public void clickonArticleDecideChangePlanlink() {
        jsClickNew(lnkArticleDecideChangePlan);
        System.out.println("Learn more here link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-articles/decide-change-plan.html")) {
            Assert.assertTrue(true);
            System.out.println("How to Decide Whether to Switch Medicare Plans Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("How to Decide Whether to Switch Medicare Plans Article Page not opened");
        }
    }

    public void clickonArticleAEPlink() {
        jsClickNew(lnkArticlAEP);
        System.out.println("Tips for the Medicare Annual Enrollment Period (AEP) link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period.html")) {
            Assert.assertTrue(true);
            System.out.println("How to Get Ready for the Medicare Annual Enrollment Period Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("How to Get Ready for the Medicare Annual Enrollment Period Article Page not opened");
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

}
