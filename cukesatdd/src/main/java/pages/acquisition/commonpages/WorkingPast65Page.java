package pages.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WorkingPast65Page extends GlobalWebElements {
    public WorkingPast65Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Medicare When Working Past Age 65");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Medicare When Working Past Age 65')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-initial-enrollment-period.html')]")
    public WebElement lnkIEP;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/what-is-the-medicare-special-enrollment-period.html')]")
    public WebElement lnkArticleSEP;

/*
    @FindBy(xpath = "")
    public WebElement lnk;

    @FindBy(xpath = "")
    public WebElement lnk;
*/


    public void checkInpageNavigation() {
        String lnkText = "";
        for (int i = 0; i < inPageNavigationLinks.size(); i++) {
            if (i != 3)
                lnkText += inPageNavigationLinks.get(i).getText() + ";";
        }
        String linksPresent = "Introduction to Medicare;Types of Plans;Medicare Enrollment;When to Enroll;How to Enroll;Changing Plans;Working Past 65;More about Medicare;FAQ;";
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

    public void clickonIEPlink() {
        jsClickNew(lnkIEP);
        System.out.println("Learn about my Initial Enrollment Period & Medicare choices link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-education/medicare-initial-enrollment-period.html")) {
            Assert.assertTrue(true);
            System.out.println("Initial Enrollment Period Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Initial Enrollment Period Page not opened");
        }

    }

    public void clickonSEPlink() {
        jsClickNew(lnkArticleSEP);
        System.out.println("Find your Special Enrollment Period dates link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-articles/what-is-the-medicare-special-enrollment-period.html")) {
            Assert.assertTrue(true);
            System.out.println("What is the Medicare Special Enrollment Period? Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("What is the Medicare Special Enrollment Period? Article Page not opened");
        }
    }

}
