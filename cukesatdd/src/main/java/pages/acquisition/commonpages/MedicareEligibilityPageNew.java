package pages.acquisition.commonpages;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MedicareEligibilityPageNew extends GlobalWebElements {
    public MedicareEligibilityPageNew(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Medicare Eligibility");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//span[contains(text(),'Medicare Eligibility')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-initial-enrollment-period.html')]")
    public WebElement lnkIEP;

    @FindBy(xpath = "(//a[contains(@href,'/medicare-education/medicare-while-working.html')])[3]")
    public WebElement lnkWP65;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare.html')]")
    public WebElement lnkDisabilityArticle;

    @FindBy(xpath = "//a[contains(@href,'https://www.ssa.gov/benefits/medicare/')]")
    public WebElement lnkSocialSecurity;

    @FindBy(xpath = "//a[contains(@href,'/plan-recommendation-engine.html') and @role='button']")
    public WebElement lnkPRE;

    @FindBy(xpath = "//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a")
    public WebElement lnkCoverageChoice;


    public void checkInpageNavigation() {
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
    }


    public void checkInnerLinks() {
        WebElement lnkEligibility = driver.findElement(By.xpath("//a//span[contains(text(),'Who is eligible for Medicare?')]"));
        WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
        jsClickNew(lnkEligibility);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: Who is eligible for Medicare? ");

        WebElement lnkIEP = driver.findElement(By.xpath("//a//span[contains(text(),'Medicare Initial Enrollment Period')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
        jsClickNew(lnkIEP);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: Medicare Initial Enrollment Period  ");

        WebElement lnkPast65 = driver.findElement(By.xpath("//a//span[contains(text(),'What if I continue to work past age 65?')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
        jsClickNew(lnkPast65);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What if I continue to work past age 65? ");

        WebElement onDisability = driver.findElement(By.xpath("//a//span[contains(text(),' on disability. When will I be eligible')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
        jsClickNew(onDisability);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: I'm on disability. When will I be eligible for Medicare?");

        WebElement lnkNeedToEligible = driver.findElement(By.xpath("//a//span[contains(text(),\"What do I need to do when I'm eligible for Medicar\")]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[5]"));
        jsClickNew(lnkNeedToEligible);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What do I need to do when I'm eligible for Medicare? ");

        WebElement lnkCvgChoice = driver.findElement(By.xpath("//a//span[contains(text(),'my coverage choices after')]"));
        jsClickNew(lnkCvgChoice);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What are my coverage choices after I have Medicare? ");
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
        System.out.println("Learn more about enrolling in Medicare for the first time at age 65 link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("medicare-education/medicare-initial-enrollment-period.html")) {
            Assert.assertTrue(true);
            System.out.println("Initial Enrollment Period Page opened from Eligibility page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Initial Enrollment Period Page opened from Eligibility page not successful");
        }
    }

    public void clickonWP65link() {
        jsClickNew(lnkWP65);
        System.out.println("Understand your options for Medicare enrollment when working past 65 link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-while-working.html")) {
            Assert.assertTrue(true);
            System.out.println("Working Past 65 Page opened from Eligibility page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Working Past 65 Page opened from Eligibility page not successful");
        }
    }

    public void clickonDisabilityArticlelink() {
        jsClickNew(lnkDisabilityArticle);
        System.out.println("Learn more about Medicare eligibility due to disability link on Eligibility Page link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare.html")) {
            Assert.assertTrue(true);
            System.out.println("Disability & Medicare Eligibility and Enrollment Article opened from Eligibility page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Disability & Medicare Eligibility and Enrollment Article opened from Eligibility page not successful");
        }
    }

    public void clickOnSocialSecurityLink() {

        switchToNewTabNew(lnkSocialSecurity);
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(5);
        String urlCheck = "https://www.ssa.gov/benefits/medicare/";
        System.out.println("Expected URL: " + urlCheck);
        System.out.println("Actual   URL: " + driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains(urlCheck)) {
            System.out.println("Socaial Security Link open successfully");
            Assertion.assertTrue(true);
        } else {
            Assertion.fail("Social Security Link did not open successfully");
        }
        driver.close();
        driver.switchTo().window(CommonConstants.getMainWindowHandle());

    }

    public CoverageChoicesPageNew clickOnCoverageChoiceLink() {
        jsClickNew(lnkCoverageChoice);
        sleepBySec(3);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-parts-and-medigap-plans.html")) {
            return new CoverageChoicesPageNew(driver);
        } else {
            return null;
        }
    }
}
