



package pages.acquisition.ulayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.ZipcodeLookupPage;

/**
 * @author pperugu
 *
 */
public class PortfolioPage extends UhcDriver {

	@FindBy(linkText = "Look up a ZIP code")
	private WebElement lookupZipcodeLink;

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;

	@FindBy(id = "nav-zipcode")
	private WebElement zipfield;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/span")
	private WebElement errormessage;

	@FindBy(id = "ghn_lnk_2")
	private WebElement OurPlansLink;

	@FindBy(id = "subnav_2")
	public static WebElement ourPlansDropdown;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/button")
	public WebElement findPlansButton;
	
	@FindBy(xpath="//*[@class='zipcode_text ng-pristine ng-valid ng-valid-maxlength']")
	public WebElement zipCodeInput;
	
	@FindBy(linkText="Search by Address")
    private WebElement searchbyaddresslink;
    
    @FindBy(id="address")
    private WebElement address;
    
    @FindBy(id="city")
    private WebElement city;
    
    @FindBy(id="compare-plan-1")
    private WebElement chkBoxAddtoCompare1;
    
        
    @FindBy(id="compare-plan-2")
    private WebElement chkBoxAddtoCompare2;
    
    @FindBy(id="compare-plan-3")
    private WebElement chkBoxAddtoCompare3;
    
    @FindBy(id="compare-plan-4")
    private WebElement chkBoxAddtoCompare4;
    
   
    
    @FindBy(className="single-added-text show")
    private WebElement onePlanAdded;

	//private static String PAGE_URL = MRConstants.AARP_OUR_PLANS_URL;
	private static String PAGE_URL = MRConstants.PORTFOLIO_PAGE_URL;

	public PortfolioPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ZipcodeLookupPage looksupforZipcodes() {
		 if (driver instanceof JavascriptExecutor) {
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].click();", lookupZipcodeLink);
	        } 
	        else {
	        	lookupZipcodeLink.click();
	        }

		//lookupZipcodeLink.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new ZipcodeLookupPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
	}

	public void hoverourplanslink() {

		validate(OurPlansLink);
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(OurPlansLink).build().perform();
		validate(OurPlansLink);
	}
	
	public void selectAddToCompareCheckboxes() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waitforElement(selectAddToCompareCheckbox);
		//System.out.println(chkBoxAddtoCompare1.isEnabled());
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(10000);
		js.executeScript("arguments[0].click();", chkBoxAddtoCompare1);
		js.executeScript("arguments[0].click();", chkBoxAddtoCompare2);
		js.executeScript("arguments[0].click();", chkBoxAddtoCompare3);
		js.executeScript("arguments[0].click();", chkBoxAddtoCompare4);
		
		//selectAddToCompareCheckbox.click();
		validate(onePlanAdded);
		/*selectAddToCompareCheckbox2.click();
		validate(twoPlanAdded);*/		
		
	}
	
	
	
	
	
	

	public Boolean findplansbuttonclick2() {

		hoverourplanslink();
		validate(findPlansButton);
		findPlansButton.click();
		validate(findPlansButton);

		return validate(errormessage);

	}

	public AcquisitionHomePage ErrorMessage() {
		validate(errormessage);
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(errormessage);

		validate(errormessage);
		return null;
	}

	public Boolean clicktextfield() {

		hoverourplanslink();

		validate(zipfield);
		zipfield.click();
		zipfield.sendKeys("9001");
		validate(findPlansButton);
		findPlansButton.click();
		return validate(errormessage);
	}

	public AcquisitionHomePage errormessage() {
		validate(errormessage);
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(errormessage);

		validate(errormessage);
		return null;
	}

	public Boolean correctzipcode() {

		hoverourplanslink();

		validate(zipfield);
		zipfield.click();
		zipfield.sendKeys("90010");
		return null;
	}
	
	public void searchbyaddressclick() {
        
        validate(searchbyaddresslink);
        searchbyaddresslink.click();
  
 }
 
 public void validate()
 {
        address.sendKeys("abcd");
        city.sendKeys("california");
       // selectFromDropDown(selectDropDown, "AL");
        /*Select sel = new Select(selectDropDown);
        sel.selectByValue("AL");*/
        try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            
 }
 
 public WebElement findNoSuchElement(By locator) {
		WebElement element = null;
		FluentWait<WebDriver> wait = new WebDriverWait(driver,60).ignoring(NoSuchElementException.class)
				.withTimeout(60, TimeUnit.SECONDS);
		try {
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(locator));
			return element;
			
		} catch (NoSuchElementException e) {
			e.getStackTrace();
			System.out.println("******************************** "+e.getCause().getMessage());
		}			
		return null;
 }

public ResponsivePlanSummary searchPlans(String zipcode, String CountyName) throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    WebDriverWait wait = new WebDriverWait(driver, 40);
//    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("zipcode")));
    
    
    
//    WebElement element =findNoSuchElement(By.id("zipcode"));
    
//    sendkeys(element, zipcode);
//    element.sendKeys(Keys.ENTER);
	  Thread.sleep(10000);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,300)", "");
	  Thread.sleep(2000);
    sendkeys(zipCodeField, zipcode);
    zipCodeField.sendKeys(Keys.ENTER);
    //remove thread once page is stable
    try {
                Thread.sleep(10000);
        } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
    
    List<WebElement> countyActuals = driver.findElements(By.xpath("//a[@class='ng-binding ng-pristine ng-valid']"));
    System.out.println(countyActuals.size());
    
    for(int i=0; i<=countyActuals.size()-1;i++){
            System.out.println(CountyName);
            if(countyActuals.get(i).getText().equals(CountyName)){
                    System.out.println(CountyName);
                    System.out.println(countyActuals.get(i).getText());
                    countyActuals.get(i).click();
                    break;
            }
    }
        if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PLAN_SUMMARY_PAGE_TITLE)) {
                 return new ResponsivePlanSummary(driver);
        } 
        return null;
	}
}















































