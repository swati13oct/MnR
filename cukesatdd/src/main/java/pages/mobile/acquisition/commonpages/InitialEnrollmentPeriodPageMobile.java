package pages.mobile.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.commonpages.GlobalWebElements;
import pages.acquisition.commonpages.HowtoEnrollinMedicarePage;
import pages.acquisition.commonpages.LearnAboutMedicareHomePageNew;

import java.util.List;

public class InitialEnrollmentPeriodPageMobile extends GlobalWebElements {
    public InitialEnrollmentPeriodPageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Initial Enrollment Period (IEP)");
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1[contains(text(),'Initial Enrollment Period (IEP)')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-while-working.html')]//span[contains(text(),'Delay')]")
    public WebElement lnkDelay;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-parts-and-medigap-plans.html')]//span[contains(text(),'Medicare')]")
    public WebElement lnkPartsCombined;

    @FindBy(xpath = "//span[contains(text(),'How to Enroll')]")
    public WebElement lnkHowToEnroll;

    /*public void checkInpageNavigation() {
        String lnkText = "";
        for (int i = 0; i < inPageNavigationLinks.size(); i++) {
            if (i != 3)
                lnkText += inPageNavigationLinks.get(i).getText() + ";";
        }
        String linksPresent = "Introduction to Medicare;Types of Plans;Medicare Enrollment;When to Enroll;How to Enroll;Changing Plans;Working Past 65;Initial Enrollment Period;More about Medicare;FAQ;";
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
        WebElement lnkAutoEnroll = driver.findElement(By.xpath("//a//span[contains(text(),'Am I automatically enrolled')]"));
        WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
        jsClickNew(lnkAutoEnroll);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: Am I automatically enrolled in Medicare at 65? ");

        WebElement lnkWhenEnroll = driver.findElement(By.xpath("//a//span[contains(text(),'When can I enroll')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
        jsClickNew(lnkWhenEnroll);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: When can I enroll in Medicare? ");

        WebElement lnkMissIEP = driver.findElement(By.xpath("//a//span[contains(text(),'miss my Initial Enrollment Period')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
        jsClickNew(lnkMissIEP);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: What happens if I miss my Initial Enrollment Period? ");

        WebElement lnkNeedMedicare = driver.findElement(By.xpath("//a//span[contains(text(),'Do I need Medicare')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[4]"));
        jsClickNew(lnkNeedMedicare);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: Do I need Medicare if working past 65? ");

        WebElement lnkWhichPart = driver.findElement(By.xpath("//a//span[contains(text(),'which parts of Medicare')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[5]"));
        jsClickNew(lnkNeedMedicare);
        jsClickNew(backtotop);
        System.out.println(" Link Clicked: How do I know which parts of Medicare I need? ");

        WebElement lnkCvgChoices = driver.findElement(By.xpath("//a//span[contains(text(),'Medicare coverage choices?')]"));
        jsClickNew(lnkCvgChoices);
        System.out.println(" Link Clicked: What are my Medicare coverage choices?? ");

    }

    public void clickOnFindDelayLink() {
        jsClickNew(lnkDelay);
        System.out.println("Find Out If You Can Delay Enrolling in Medicare link on Initial Enrollment Period Page clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-while-working.html")) {
            Assert.assertTrue(true);
            System.out.println("Medicare When Working Past Age 65 Page opened from Initial Enrollment Period page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Medicare When Working Past Age 65 opened from Initial Enrollment Period page not successful");
        }
    }

    public void clickOnPartsCombinedLink() {
        jsClickNew(lnkPartsCombined);
        System.out.println("See How All the Parts of Medicare Can be Combined link on Initial Enrollment Period Page clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-parts-and-medigap-plans.html")) {
            Assert.assertTrue(true);
            System.out.println("Coverage Options Page opened from Initial Enrollment Period page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Coverage Options opened from Initial Enrollment Period page not successful");
        }
    }

    public HowtoEnrollinMedicarePageMobile clickOnHowToEnrollLink() {
        sleepBySec(2);
        jsClickNew(lnkHowToEnroll);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/how-to-enroll-in-medicare.html")) {
            return new HowtoEnrollinMedicarePageMobile(driver);
        } else {
            return null;
        }
    }
}
