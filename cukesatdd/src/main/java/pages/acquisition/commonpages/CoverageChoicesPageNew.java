package pages.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CoverageChoicesPageNew extends GlobalWebElements {
    public CoverageChoicesPageNew(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }



    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(),"Coverage Options");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Coverage Options')]")
    public WebElement header;

    @FindBy(xpath = "//strong//a[@href='/medicare-education/original-medicare.html']")
    public WebElement lnkOriginalMedicare;

    @FindBy(xpath = "//h2//a[@href='/medicare-education/medicare-part-d.html']")
    public WebElement lnkMedicarePartD;

    @FindBy(xpath = "//span//a[@href='/medicare-education/medicare-advantage-plans.html']")
    public WebElement lnkMedicareAdvantage;

    @FindBy(xpath = "//span//a[@href='/medicare-education/medicare-supplement-plans.html']")
    public WebElement lnkMedSupsPlan;

    @FindBy(xpath ="//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a")
    public WebElement lnkBenefitsPage;




    public void checkInpageNavigation(){
        String lnkText="";
        for(int i=0;i<inPageNavigationLinks.size();i++){
            if(i!=1)
                lnkText+=inPageNavigationLinks.get(i).getText()+";";
        }
        String linksPresent="Introduction to Medicare;Introduction;Eligibility;Coverage Options;Prescriptions, Providers & Benefits;Medicare Cost Basics;Original Medicare;Types of Plans;Medicare Enrollment;More about Medicare;FAQ;";
        if (lnkText.equalsIgnoreCase(linksPresent)){
            Assert.assertTrue(true);
            System.out.println("Links Present in Page Navigation: "+lnkText);
        }else {
            Assert.fail("All links not present: "+lnkText);
        }
    }
    public LearnAboutMedicareHomePageNew backtoMedicareEducationPage() {
        inPageNavigationLinks.get(0).click();
        CommonUtility.checkPageIsReadyNew(driver);
        if(driver.getCurrentUrl().contains("/medicare-education.html")){
            return new LearnAboutMedicareHomePageNew(driver);
        }
        else {
            return null;
        }
    }
    public void checkInnerLinks(){
        WebElement lnkcvrgChoice=driver.findElement(By.xpath("//a//span[contains(text(),'Get to know your coverage choices')]"));
        jsClickNew(lnkcvrgChoice);
        System.out.println(" Link Clicked: Get to know your coverage choices ");

        WebElement lnkogMedCvrg=driver.findElement(By.xpath("//a//span[contains(text(),'Medicare coverage combinations')]"));
        scrollToView(lnkogMedCvrg);
        jsClickNew(lnkogMedCvrg);

        System.out.println(" Link Clicked: Medicare coverage combinations ");

        WebElement lnkrememberwhenchooisingcoverage=driver.findElement(By.xpath("//a//span[contains(text(),'Key things to remember when choosing coverage')]"));
        scrollToView(lnkrememberwhenchooisingcoverage);
        jsClickNew(lnkrememberwhenchooisingcoverage);
        System.out.println(" Link Clicked: Key things to remember when choosing coverage");
    }

    public void checkPlansLinks(){
        validateNew(lnkOriginalMedicare);
        validateNew(lnkMedicareAdvantage);
        validateNew(lnkMedicarePartD);
        validateNew(lnkMedSupsPlan);
        sleepBySec(2);

        jsClickNew(lnkOriginalMedicare);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/original-medicare.html")) {
            System.out.println("Original Medicare link opened Successfully");
            driver.navigate().back();
        } else {
            Assert.fail("Original Medicare link not opened Successfully");
        }
        sleepBySec(2);

        jsClickNew(lnkMedicareAdvantage);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-advantage-plans.html")) {
            System.out.println("Medicare Advantage or Part C link opened Successfully");
            driver.navigate().back();
        } else {
            Assert.fail("Medicare Advantage or Part C link not opened Successfully");
        }
        sleepBySec(2);
        jsClickNew(lnkMedicarePartD);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-part-d.html")) {
            System.out.println("Medicare Part D link opened Successfully");
            driver.navigate().back();
        } else {
            Assert.fail("Medicare Part D link not opened Successfully");
        }
        sleepBySec(2);
        jsClickNew(lnkMedSupsPlan);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("medicare-education/medicare-supplement-plans.html")) {
            System.out.println("Medicare Supplement Insurance link opened Successfully");
            driver.navigate().back();
        } else {
            Assert.fail("Medicare  Supplement Insurance link not opened Successfully");
        }
        sleepBySec(2);
    }

    public PrescriptionProviderBenefitsPageNew clickOnBenifitsLink() {
        jsClickNew(lnkBenefitsPage);
        sleepBySec(3);
        CommonUtility.checkPageIsReadyNew(driver);
        if(driver.getCurrentUrl().contains("medicare-education/medicare-benefits.html")){
            return new PrescriptionProviderBenefitsPageNew(driver);
        }
        else{
            return null;
        }
    }
}
