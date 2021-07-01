package pages.mobile.acquisition.commonpages;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.commonpages.ChangingMedicarePlansPage;
import pages.acquisition.commonpages.GlobalWebElements;

import java.util.List;

public class HowtoEnrollinMedicarePageMobile extends GlobalWebElements {

    public HowtoEnrollinMedicarePageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'How to Enroll in Medicare')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'https://www.ssa.gov/benefits/medicare/')]")
    public List<WebElement> lnkSocialSecurity;

    //div[@class='desktopview']//a[contains(@href,'https://www.medicare.gov/')]
    @FindBy(xpath = "//a[contains(@href,'https://www.medicare.gov/')]")
    public List<WebElement> lnkMedicareGov;

    @FindBy(xpath = "//a[contains(@href,'/health-plans')]//span[contains(text(),'View')]")
    public List<WebElement> lnkViewPlans;

    @FindBy(xpath = "//h4//a[@href='/medicare-education/changing-plans.html']")
    public WebElement lnkChangingPlans;

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "How to Enroll in Medicare");
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
        WebElement lnkautoEnrollment = driver.findElement(By.xpath("//span[contains(text(),'How automatic enrollment in Medicare works')]"));
        WebElement lnkenrollYourself = driver.findElement(By.xpath("//span[contains(text(),'How to enroll in Medicare yourself')]"));
        WebElement lnkenrollPrivate = driver.findElement(By.xpath("//span[contains(text(),'How to enroll in a private Medicare insurance plan')]"));

        scrollToView(lnkautoEnrollment);
        jsClickNew(lnkautoEnrollment);
        sleepBySec(2);
        System.out.println("Link Clicked: How automatic enrollment in Medicare works");

        scrollToView(lnkenrollYourself);
        jsClickNew(lnkenrollYourself);
        sleepBySec(2);
        System.out.println("Link Clicked: How to enroll in Medicare yourself");

        scrollToView(lnkenrollPrivate);
        jsClickNew(lnkenrollPrivate);
        sleepBySec(2);
        System.out.println("Link Clicked: How to enroll in a private Medicare insurance plan");
    }

    public void clickOnSocialSecurityLinks() {

        for (int i = 0; i < lnkSocialSecurity.size(); i++) {
            if (lnkSocialSecurity.get(i).isDisplayed()) {
                switchToNewTabNew(lnkSocialSecurity.get(i));
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
        }
    }


    public void clickOnMedicareGovLinks() {

        for (int i = 0; i < lnkMedicareGov.size(); i++) {
            if (lnkMedicareGov.get(i).isDisplayed()) {
                switchToNewTabNew(lnkMedicareGov.get(i));
                CommonUtility.checkPageIsReadyNew(driver);
                sleepBySec(5);
                String urlCheck = "https://www.medicare.gov/";
                System.out.println("Expected URL: " + urlCheck);
                System.out.println("Actual   URL: " + driver.getCurrentUrl());
                if (driver.getCurrentUrl().contains(urlCheck)) {
                    System.out.println("Medicare Gov Link open successfully");
                    Assertion.assertTrue(true);
                } else {
                    Assertion.fail("Medicare Gov Link did not open successfully");
                }
                driver.close();
                driver.switchTo().window(CommonConstants.getMainWindowHandle());
            }
        }
    }

    public void clickOnViewPlansLinks() {

        for (int i = 0; i < lnkViewPlans.size(); i++) {
            sleepBySec(2);
            String linkText=lnkViewPlans.get(i).getText().trim();
            switchToNewTabNew(lnkViewPlans.get(i));
            CommonUtility.checkPageIsReadyNew(driver);
            sleepBySec(5);
            System.out.println("Actual   URL: " + driver.getCurrentUrl());
            System.out.println("Shop Page Title: " + driver.getTitle().trim());
            if (driver.getTitle().trim().equalsIgnoreCase("Shop for a Plan")) {
                System.out.println(linkText + " Link open successfully");
                Assertion.assertTrue(true);
            } else {
                Assertion.fail(lnkViewPlans.get(i).getText().trim() + " Link did not open successfully");
            }
            driver.close();
            driver.switchTo().window(CommonConstants.getMainWindowHandle());
        }
    }

    public ChangingMedicarePlansPageMobile clickOnChangingPlans() {
        jsClickNew(lnkChangingPlans);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-education/changing-plans.html")) {
            return new ChangingMedicarePlansPageMobile(driver);
        } else {
            return null;
        }
    }
}
