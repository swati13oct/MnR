package pages.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static atdd.framework.Assertion.assertTrue;

public class MedicareSupplementInsurancePlansPageNew extends GlobalWebElements {
    public MedicareSupplementInsurancePlansPageNew(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(),"Medicare Supplement Insurance Plans");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Medicare Supplement Insurance Plans')]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/shop/estimate/ms-costs.html')]")
    public WebElement lnkEstimateMS;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-coverage-examples.html')]")
    public WebElement lnkMedCvgExample;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/when-to-enroll.html')]//span[@class='link-text']")
    public WebElement lnkSEP;

    @FindBy(xpath = "//a[contains(@href,'/health-plans.html?product=medsupp') and @role='button']")
    public WebElement btnShopNow;

    public void checkInpageNavigation(){
        String lnkText="";
        for(int i=0;i<inPageNavigationLinks.size();i++){
            if(i!=2)
                lnkText+=inPageNavigationLinks.get(i).getText()+";";
        }

        String linksPresent="Introduction to Medicare;Types of Plans;Medicare Advantage Plans;Medicare Supplement Insurance Plans;Medicare Prescription Drug Plans;Special Needs Plans;Medicare Enrollment;More about Medicare;FAQ;";
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

    public void clickShopNowButton(){
        sleepBySec(2);
        jsClickNew(btnShopNow);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        String vppPageTitle = driver.getTitle();
        System.out.println("Actual : " + vppPageTitle);
        if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
            if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains((PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")))
                System.out.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
            else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains((PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")))
                System.out
                        .println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
            else
                assertTrue("Not redirected to VPP page",
                        vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains((PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")));
        } else {
            if (driver.getCurrentUrl().contains("uhcmedicaresolutions")) {
                if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")))
                    System.out.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
                else if (vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")))
                    System.out
                            .println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
                else
                    assertTrue("Not redirected to VPP page",
                            vppPageTitle.replaceAll("[^A-Za-z0-9:.]", "").contains((PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE).replaceAll("[^A-Za-z0-9:.]", "")));
            }
        }
        sleepBySec(2);
        driver.navigate().back();
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);

    }
    public void clickOnMSCostLink() {
        sleepBySec(2);
        jsClickNew(lnkEstimateMS);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/shop/estimate/ms-costs.html")) {
            System.out.println("'Learn more about costs associated with Medicare supplement plans' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about costs associated with Medicare supplement plans' Link Clicked not Successful");
        }
    }

    public void clickOnCoverageExampleLink() {
        sleepBySec(2);
        jsClickNew(lnkMedCvgExample);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/medicare-coverage-examples.html")) {
            System.out.println("'See how Medicare costs may work with these Medicare coverage examples' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'See how Medicare costs may work with these Medicare coverage examples' Link Clicked not Successful");
        }
    }
    public void clickOnMedicareSEPLink() {
        sleepBySec(2);
        jsClickNew(lnkSEP);
        sleepBySec(2);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("medicare-education/when-to-enroll.html")) {
            System.out.println("'Learn more about the Medicare Supplement Enrollment Period' Link Clicked Successfully");
            driver.navigate().back();
            sleepBySec(2);
        } else {
            Assert.fail("'Learn more about the Medicare Supplement Enrollment Period' Link Clicked not Successful");
        }
    }

}
