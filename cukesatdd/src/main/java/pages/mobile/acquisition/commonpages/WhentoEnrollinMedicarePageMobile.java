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

public class WhentoEnrollinMedicarePageMobile extends GlobalWebElements {
    public WhentoEnrollinMedicarePageMobile(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "When to Enroll in Medicare");
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'When to Enroll in Medicare')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-initial-enrollment-period.html')]")
    public List<WebElement> lnkIEP;

    /*@FindBy(xpath = "(//a[contains(@href,'/medicare-education/medicare-initial-enrollment-period.html')])[2]")
    public WebElement lnkIEP2;*/

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/what-is-creditable-drug-coverage.html')]")
    public WebElement lnkArticleCreditable;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-while-working.html')]//span[@class='link-text']")
    public WebElement lnkWP65;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/what-is-the-medicare-special-enrollment-period.html')]")
    public WebElement lnkArticleSEP;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties.html')]")
    public WebElement lnkArticlePenalty;

    @FindBy(xpath = "//p//span//a[contains(@href,'/medicare-education/how-to-enroll-in-medicare.html')]")
    public WebElement lnkHowToEnroll;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare.html')]")
    public WebElement lnkArticleDisability;

    @FindBy(xpath = "//h4//a[contains(@href,'/medicare-education/how-to-enroll-in-medicare.html')]")
    public WebElement lnkNextHowToEnroll;


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
        WebElement lnkfirstTime = driver.findElement(By.xpath("//a//span[contains(text(),'should I enroll')]"));
        WebElement lnkNeedMedicare = driver.findElement(By.xpath("//a//span[contains(text(),'plan to work')]"));
        WebElement lnkcoverSpouse = driver.findElement(By.xpath("//a//span[contains(text(),'spouse')]"));
        WebElement lnkMissIEP = driver.findElement(By.xpath("//a//span[contains(text(),'miss my Initial')]"));
        WebElement lnkEnrollMedicare = driver.findElement(By.xpath("//a//span[contains(text(),'my next steps')]"));
        WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));


        jsClickNew(lnkfirstTime);
        sleepBySec(2);
        jsClickNew(backtotop);
        System.out.println("Link Clicked: When should I enroll in Medicare for the first time? ");

        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
        jsClickNew(lnkNeedMedicare);
        sleepBySec(2);
        jsClickNew(backtotop);
        System.out.println("Link Clicked: Do I need Medicare if I plan to work past age 65? ");

        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
        jsClickNew(lnkcoverSpouse);
        sleepBySec(2);
        jsClickNew(backtotop);
        System.out.println("Link Clicked: Do I need Medicare if I am covered my spouse's insurance? ");

        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[4]"));
        jsClickNew(lnkMissIEP);
        sleepBySec(2);
        jsClickNew(backtotop);
        System.out.println("Link Clicked: What if I miss my Initial Enrollment Period? ");

        jsClickNew(lnkEnrollMedicare);
        sleepBySec(2);
        System.out.println("Link Clicked: I want to enroll in Medicare. What are my next steps? ");
    }

    public void clickonIEPlink() {
        for (int i = 0; i < lnkIEP.size(); i++) {
            jsClickNew(lnkIEP.get(i));
            System.out.println("IEP link clicked");
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
    }

    public void clickonCreditablelink() {
        jsClickNew(lnkArticleCreditable);
        System.out.println("Creditable Article link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-articles/what-is-creditable-drug-coverage.html")) {
            Assert.assertTrue(true);
            System.out.println("What is Creditable Drug Coverage? Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("What is Creditable Drug Coverage? Article Page not opened");
        }
    }

    public void clickonWP65link() {
        jsClickNew(lnkWP65);
        System.out.println("Understand your options for Medicare enrollment when working past 65 link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-while-working.html")) {
            Assert.assertTrue(true);
            System.out.println("Working Past 65 Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Working Past 65 Page not opened");
        }
    }


    public void clickonSEPlink() {
        jsClickNew(lnkArticleSEP);
        System.out.println("Learn more about the Special Enrollment Period when working past 65 link clicked");
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

    public void clickonPenaltylink() {
        jsClickNew(lnkArticlePenalty);
        System.out.println("Learn more about Medicare penalties link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("/medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties.html")) {
            Assert.assertTrue(true);
            System.out.println("How to Avoid Paying Medicare Late Enrollment Penalties Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("How to Avoid Paying Medicare Late Enrollment Penalties Article Page not opened");
        }
    }

    public void clickonHowToEnrolllink() {
        jsClickNew(lnkHowToEnroll);
        System.out.println("Learn how to enroll in Medicare coverage link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-education/how-to-enroll-in-medicare.html")) {
            Assert.assertTrue(true);
            System.out.println("How to Enroll in Medicare Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("How to Enroll in Medicare Page not opened");
        }
    }

    public void clickonDisabilitylink() {
        jsClickNew(lnkArticleDisability);
        System.out.println("Learn how to enroll in Medicare with a qualifying disability, ALS or ESRD link clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        sleepBySec(2);
        if (driver.getCurrentUrl().contains("medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare.html")) {
            Assert.assertTrue(true);
            System.out.println("Disability & Medicare Eligibility and Enrollment Article Page opened ");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            Assert.fail("Disability & Medicare Eligibility and Enrollment Article Page not opened");
        }
    }

    public HowtoEnrollinMedicarePageMobile clickOnNextHowToEnrollLink() {
        jsClickNew(lnkNextHowToEnroll);
        sleepBySec(3);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/how-to-enroll-in-medicare.html")) {
            return new HowtoEnrollinMedicarePageMobile(driver);
        } else {
            return null;
        }
    }


}
