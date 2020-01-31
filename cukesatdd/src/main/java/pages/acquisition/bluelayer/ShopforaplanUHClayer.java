package pages.acquisition.bluelayer;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.aop.target.SimpleBeanTargetSource;

import org.junit.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ShopforaplanUHClayer extends UhcDriver {
	
	
	@FindBy(xpath="//*[@id='ghn_lnk_2']")
	private WebElement ShopForaplan;
	
    @FindBy(xpath=".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;
    
    @FindBy(id="updates-email")
	private WebElement updatesemail;
    
    @FindBy(xpath="//*[@id='subnav_2']/div[2]/div/p")
	private WebElement successMessage;
    
    @FindBy(xpath="//a[text()='Plan Selector']")
	private WebElement PlanSelector;
 
    @FindBy(xpath="//div[contains(@id,'aside-second')]//h1")
   	private WebElement heading;
    
    @FindBy(xpath="//div[@id='widget_POmb5hgvb0afo9HIaTIbiQ']/div/a")
   	private WebElement GetStarted;
    
    @FindBy(xpath="//input[contains(@title,'ZIP Code')]")
   	private WebElement ZIPcode;
    
    @FindBy(xpath="//a[text()='Drug Cost Estimator']")
   	private WebElement Drugcostestimator;
    
    @FindBy(xpath="//a[text()='Pharmacy Search']")
   	private WebElement Pharmacysearch;
    
    @FindBy(xpath="//a[text()='Provider Search']")
   	private WebElement Providersearch;
    
    @FindBy(xpath="//a[@class='cta-button secondary']")
   	private WebElement canceldrugsearch;
    
    @FindBy(xpath="//input[@id='zipcodeTxt']")
   	private WebElement zipcodetxt;
    
    @FindBy(xpath="//select[@id='plan-type']")
   	private WebElement chooseaplan;
    
    @FindBy(xpath="//button[@type='submit']")
   	private WebElement pcontinue;
    
    @FindBy(xpath="//div[@id='planTypesColumn']//a[text()='Enroll']")
	private WebElement enrollLink;
  
    @FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;
  
    
  
    
 	
	public ShopforaplanUHClayer(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, ShopForaplan, 60);
		validateNew(ShopForaplan);	
	}

	
	public boolean hovershopaplan()
	{
		try {
	         waitforElement(ShopForaplan);
	            if (ShopForaplan.isDisplayed()) {
	                   Actions actions = new Actions(driver);
	                   actions.moveToElement(ShopForaplan);
	                   waitforElementNew(submit);
	                   System.out.println("Submit is displayed");
	            }
	     } catch (Exception e) {
	            Assert.fail("The element is not  found");
	         return false;
	     }
		return true;
	}
	
	public ShopforaplanUHClayer Hoveronaplan() throws InterruptedException
	{		
		waitforElement(ShopForaplan);
        if (ShopForaplan.isDisplayed()) {
               Actions actions = new Actions(driver);
               actions.moveToElement(ShopForaplan);
               waitforElementNew(submit);
               System.out.println("Submit is displayed");
               return new ShopforaplanUHClayer(driver);
        }
		else {
			return null;}
	}
	
	public ShopforaplanUHClayer EnterEmailAddress(String email) throws InterruptedException
	{		
		Actions actions = new Actions(driver);
        actions.moveToElement(updatesemail);
		sendkeys(updatesemail, email);
		submit.click();
		Thread.sleep(6000);
		//waitforElementDisapper(By.xpath("//*[@id='updates-mobile-form']/div/div[2]/button"),0);
		String text =successMessage.getText();
		if(!(text==null))
		return new ShopforaplanUHClayer(driver);
		else 
			return null;
	}
	
	public ShopforaplanUHClayer Validatesuccessfull(String Message) throws InterruptedException
	{		
		String text = successMessage.getText();
		if(text.equals(Message)) {
			System.out.println("Successfull message is displayed");
			return new ShopforaplanUHClayer(driver);
		}
		else 
			{
			return null;}
	}
	
	public ShopforaplanUHClayer clickonplanselector() throws InterruptedException
	{		
		Actions actions = new Actions(driver);
        actions.moveToElement(PlanSelector);
        PlanSelector.click();
	
		if(!(heading==null))
		return new ShopforaplanUHClayer(driver);
		else 
			return null;
	}
	
	public ShopforaplanUHClayer clickongetstartedbutton() throws InterruptedException
	{		
//		Actions actions = new Actions(driver);
//      actions.moveToElement(GetStarted);
//        waitforElement(GetStarted);
		driver.switchTo().frame("planSelectorTool");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(GetStarted));
		GetStarted.click();
		Thread.sleep(6000);
		if(ZIPcode.isDisplayed()) {
			driver.switchTo().defaultContent();
		return new ShopforaplanUHClayer(driver);}
		else {
			return null;}
	}
	
	public ShopforaplanUHClayer clickondrugcostestimator() throws InterruptedException
	{		
		waitforElement(ShopForaplan);
        if (ShopForaplan.isDisplayed()) {
               Actions actions = new Actions(driver);
               actions.moveToElement(ShopForaplan).build().perform();
               waitforElementNew(submit);
               System.out.println("Submit is displayed");
               Drugcostestimator.click();
               waitforElement(canceldrugsearch);
               return new ShopforaplanUHClayer(driver);  
        }else
        {
        	return null;
        }
	}
	
	public ShopforaplanUHClayer Validatecanceldrug() throws InterruptedException
	{		
        if (canceldrugsearch.isDisplayed()) {
               return new ShopforaplanUHClayer(driver);  
        }else
        {
        	return null;
        }
	}
	
	public ShopforaplanUHClayer clickonphramacysearch() throws InterruptedException
	{		
		waitforElement(ShopForaplan);
        if (ShopForaplan.isDisplayed()) {
               Actions actions = new Actions(driver);
               actions.moveToElement(ShopForaplan).build().perform();
               waitforElementNew(submit);
               System.out.println("Submit is displayed");
               Pharmacysearch.click();
               waitforElement(zipcodetxt);
               return new ShopforaplanUHClayer(driver);  
        }else
        {
        	return null;
        }
	}
	
	public ShopforaplanUHClayer Validatechooseplan() throws InterruptedException
	{		
        if (chooseaplan.isDisplayed()) {
               return new ShopforaplanUHClayer(driver);  
        }else
        {
        	return null;
        }
	}
	
	public ProviderSearchPage clickonprovidersearch() throws InterruptedException
	{		
		waitforElement(ShopForaplan);
        if (ShopForaplan.isDisplayed()) {
               Actions actions = new Actions(driver);
               actions.moveToElement(ShopForaplan).build().perform();
               waitforElementNew(submit);
               System.out.println("Submit is displayed");
               switchToNewTabNew(Providersearch);
               Thread.sleep(4000);
               return new ProviderSearchPage(driver);
        }else
        {
        	return null;
        }
	}
	
	public ProviderSearchPage validateprovidersearch() throws InterruptedException
	
	{	
        if (pcontinue.isDisplayed()) {
               return new ProviderSearchPage(driver);  
        }else
        {
        	return null;
        }
	}
	
	public EnrollmentBasicsPage enrollLinkOnShopPlan() throws Exception{
		waitforElement(enrollLink);
		enrollLink.click();
		 Thread.sleep(4000);
		 if(validate(maLeanHowToEnrollLink)){
			 waitforElement(maLeanHowToEnrollLink);
				System.out.println("OLE Learn More Modal is Displayed");
				return new EnrollmentBasicsPage(driver);
			}
			return null;
	}
}
