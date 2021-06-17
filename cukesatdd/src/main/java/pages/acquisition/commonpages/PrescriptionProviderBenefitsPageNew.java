package pages.acquisition.commonpages;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.acquisition.dceredesign.GetStartedPage;

import java.util.List;

public class PrescriptionProviderBenefitsPageNew extends GlobalWebElements {
    public PrescriptionProviderBenefitsPageNew(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(), "Prescriptions, Providers & Benefits");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "//h1//span[contains(text(),'Prescriptions, Providers & Benefits')]")
    public WebElement header;

    @FindBy(xpath ="//span[contains(text(),'Next')]/ancestor::*/following-sibling::p//a")
    public WebElement lnkCostBasics;


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

    public LearnAboutMedicareHomePageNew backtoMedicareEducationPage() {
        WebElement intro = driver.findElement(By.xpath("(//ul[@class='uhc-side-nav']//li)[1]"));
        inPageNavigationLinks.get(0).click();
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education.html")) {
            return new LearnAboutMedicareHomePageNew(driver);
        } else {
            return null;
        }
    }

    public void checkInnerLinks() {
        WebElement drugcvrg = driver.findElement(By.xpath("//a//span[contains(text(),'prescription drug coverage?')]"));
        WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
        System.out.println(" Link Clicked: Will I have prescription drug coverage? ");
        jsClickNew(drugcvrg);
        jsClickNew(backtotop);

        WebElement currentProvider = driver.findElement(By.xpath("//a//span[contains(text(),'current provider')]"));
        backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
        System.out.println(" Link Clicked: Will I still be able to see my current provider(s)? ");
        jsClickNew(currentProvider);
        jsClickNew(backtotop);

        WebElement additionBenefits = driver.findElement(By.xpath("//a//span[contains(text(),'additional benefits')]"));
        System.out.println(" Link Clicked: Will I have coverage for additional benefits like vision, dental, or hearing aids? ");
        jsClickNew(additionBenefits);
    }

    public void clickOnLookUpProvider() {
        WebElement providerSearchFromMedEd = driver.findElement(By.xpath("//a//span[contains(text(),'Look up your providers')]"));
        validateNew(providerSearchFromMedEd);

        switchToNewTabNew(providerSearchFromMedEd);

        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("werally")) {
            CommonUtility.checkPageIsReadyNew(driver);
            System.out.println("Rally Opened Successfully");
            sleepBySec(3);
            driver.close();
            driver.switchTo().window(CommonConstants.getMainWindowHandle());
        } else {
            Assert.fail("Rally Did Not Opened Successfully");
        }
    }

    public void clickOnEstimateYourDrugCosts() {
        WebElement DCELink = driver.findElement(By.xpath("(//a[contains(@href,'drug-cost-estimator')])[3]"));
        validateNew(DCELink);
        jsClickNew(DCELink);
        waitForPageLoadSafari();
        CommonUtility.checkPageIsReadyNew(driver);
        WebElement DCEHeader = driver.findElement(By.xpath("//h1[contains(text(),'Drug Cost Estimator')]"));
        WebElement lnkReturn = driver.findElement(By.xpath("//a[contains(@class, 'uhc-link-button')]//*[contains(text(),'Return')]"));
        if (validateNew(DCEHeader) && driver.getCurrentUrl().contains("/drug-cost-estimator")) {
            System.out.println("Drug Cost Estimator Tool opened successfully.");
            sleepBySec(2);
            jsClickNew(lnkReturn);
            sleepBySec(2);
            CommonUtility.checkPageIsReadyNew(driver);
        } else {
            System.out.println("Drug Cost Estimator Tool did not opened successfully.");
        }
    }

    public void clickMedicareAnnualEnrollment() {

        sleepBySec(1);
        CommonUtility.checkPageIsReadyNew(driver);
        WebElement annualEnrll = driver.findElement(By.xpath("//a[contains(text(),'Medicare Annual Enrollment Period')]"));
        jsClickNew(annualEnrll);
        waitForPageLoadSafari();
        CommonUtility.checkPageIsReadyNew(driver);

        if (driver.getCurrentUrl().contains("/medicare-education/enrollment-and-changing-plans.html")) {
            System.out.println("Annual Enrollment Period Page open correctly");

        } else {
            System.out.println("Annual Enrollment Period Page did not open correctly");
        }
        driver.navigate().back();
    }

    public void clickonMAPlansLinks() {
        sleepBySec(1);
        CommonUtility.checkPageIsReadyNew(driver);
        WebElement lnkMAPlans = driver.findElement(By.xpath("//a[contains(text(),'Medicare Advantage (Part C) plans')]"));
        jsClickNew(lnkMAPlans);
        waitForPageLoadSafari();
        CommonUtility.checkPageIsReadyNew(driver);

        if (driver.getCurrentUrl().contains("medicare-education/medicare-advantage-plans.html")) {
            System.out.println("Medicare Advantage (Part C) Plans Page open correctly");

        } else {
            System.out.println("Medicare Advantage (Part C) Plans Page did not open correctly");
        }
        driver.navigate().back();
    }

    public CostBasicsPageNew clickOnCostBasicsLink() {
        jsClickNew(lnkCostBasics);
        sleepBySec(3);
        CommonUtility.checkPageIsReadyNew(driver);
        if(driver.getCurrentUrl().contains("medicare-education/medicare-costs.html")){
            return new CostBasicsPageNew(driver);
        }
        else{
            return null;
        }
    }
}
