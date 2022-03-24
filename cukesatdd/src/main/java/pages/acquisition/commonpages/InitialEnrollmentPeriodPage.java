package pages.acquisition.commonpages;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class InitialEnrollmentPeriodPage extends GlobalWebElements {
    public InitialEnrollmentPeriodPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {
        Assert.assertEquals(header.getText(),"Medicare Initial Enrollment Period (IEP)");
        checkInpageNavigation();
    }

    @FindBy(xpath = "//ul[@class='uhc-side-nav']//li")
    public List<WebElement> inPageNavigationLinks;

    @FindBy(xpath = "(//h1[contains(text(),'Medicare Initial Enrollment Period (IEP)')])[1]")
    public WebElement header;

    @FindBy(xpath = "//a[contains(@href,'/medicare-education/medicare-while-working.html')]//span[contains(text(),'Delay')]")
    public WebElement lnkDelay;

    @FindBy(xpath = "//a[contains(@href,'/medicare-articles/what-if-i-missed-my-initial-enrollment-period.html')]")
    public WebElement lnkMissingIEP;

    @FindBy(xpath ="//span[contains(text(),'How to Enroll')]")
    public WebElement lnkHowToEnroll;

    public void checkInpageNavigation(){
        String lnkText="";
        for(int i=0;i<inPageNavigationLinks.size();i++){
            if(i!=3)
                lnkText+=inPageNavigationLinks.get(i).getText()+";";
        }
        String linksPresent="Introduction to Medicare;Types of Plans;Medicare Enrollment;When to Enroll;How to Enroll;Changing Plans;Working Past 65;Initial Enrollment Period;More about Medicare;FAQ;";
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
    	 WebElement lnkMedIEP=driver.findElement(By.xpath("//a//span[contains(text(),'Medicare Initial Enrollment Period (IEP)')]"));
         WebElement backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[1]"));
         jsClickNew(lnkMedIEP);
         jsClickNew(backtotop);
         System.out.println(" Link Clicked: The Medicare Initial Enrollment Period (IEP) ");

         WebElement lnkAutoEnroll=driver.findElement(By.xpath("//a//span[contains(text(),'Am I automatically enrolled')]"));
         backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[2]"));
         jsClickNew(lnkAutoEnroll);
         jsClickNew(backtotop);
         System.out.println(" Link Clicked: Am I automatically enrolled in Medicare at 65? ");

         WebElement lnkNeedMedicare=driver.findElement(By.xpath("//a//span[contains(text(),'Do I need Medicare')]"));
         backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[3]"));
         jsClickNew(lnkNeedMedicare);
         jsClickNew(backtotop);
         System.out.println(" Link Clicked: Do I need Medicare if working past 65? ");

         WebElement lnkWhenEnroll=driver.findElement(By.xpath("//a//span[contains(text(),'when you can enroll')]"));
         //backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[4]"));
         jsClickNew(lnkWhenEnroll);
         //jsClickNew(backtotop);
         System.out.println(" Link Clicked: Find out when you can enroll in Medicare ");

         WebElement lnkMissIEP=driver.findElement(By.xpath("//a//span[contains(text(),'miss my Initial Enrollment Period')]"));
         backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[4]"));
         jsClickNew(lnkMissIEP);
         jsClickNew(backtotop);
         System.out.println(" Link Clicked: What happens if I miss my Initial Enrollment Period? ");

         WebElement lnkCvgChoices=driver.findElement(By.xpath("//a//span[contains(text(),'what Medicare coverage')]"));
         backtotop = driver.findElement(By.xpath("(//a//span[contains(text(),'Back to Top')])[5]"));
         jsClickNew(lnkCvgChoices);
         jsClickNew(backtotop);
         System.out.println(" Link Clicked: How do I know what Medicare coverage I need? ");

    }
    public void clickOnFindDelayLink(){
        jsClickNew(lnkDelay);
        System.out.println("Find Out If You Can Delay Enrolling in Medicare link on Initial Enrollment Period Page clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if(driver.getCurrentUrl().contains("/medicare-education/medicare-while-working.html")){
            Assert.assertTrue(true);
            System.out.println("Medicare When Working Past Age 65 Page opened from Initial Enrollment Period page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        }else{
            Assert.fail("Medicare When Working Past Age 65 opened from Initial Enrollment Period page not successful");
        }
    }
    public void clickOnMissingIEP(){
        jsClickNew(lnkMissingIEP);
        System.out.println("Learn more about missing your Initial Enrollment Period here link on Initial Enrollment Period Page clicked");
        CommonUtility.checkPageIsReadyNew(driver);
        if(driver.getCurrentUrl().contains("/medicare-articles/what-if-i-missed-my-initial-enrollment-period.html")){
            Assert.assertTrue(true);
            System.out.println("Medicare Article Page opened from Initial Enrollment Period page successful");
            driver.navigate().back();
            CommonUtility.checkPageIsReadyNew(driver);
        }else{
            Assert.fail("Medicare Article opened from Initial Enrollment Period page not successful");
        }
    }

    public HowtoEnrollinMedicarePage clickOnHowToEnrollLink(){
        sleepBySec(2);
        jsClickNew(lnkHowToEnroll);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("/medicare-education/how-to-enroll-in-medicare.html")){
            return new HowtoEnrollinMedicarePage(driver);
        }else {
            return null;
        }
    }
}
