package pages.acquisition.ulayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PortfolioPage extends UhcDriver {

	@FindBy(linkText = "Look up a ZIP code")
	private WebElement lookupZipcodeLink;

	@FindBy(className = "zipcode_text")
	private WebElement zipCodeField;

	@FindBy(id = "goBtn")
	private WebElement goButton;

	@FindBy(id = "nav-zipcode")
	private WebElement zipfield;

	@FindBy(xpath = "//*[@id='zipLookup']/p/a")
	private WebElement LookUpZipCode;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/span")
	private WebElement errormessage;

	@FindBy(id = "ghn_lnk_2")
	private WebElement OurPlansLink;

	@FindBy(id = "subnav_2")
	public static WebElement ourPlansDropdown;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/button")
	public WebElement FindPlansButton;
	
	@FindBy(xpath="//*[@class='zipcode_text ng-pristine ng-valid ng-valid-maxlength']")
	public WebElement zipCodeInput;
	
	@FindBy(linkText="Search By Address")
    private WebElement searchbyaddresslink;
    
    @FindBy(id="address")
    private WebElement address;
    
    @FindBy(id="city")
    private WebElement city;
    
    @FindBy(xpath="//select")
    private WebElement selectDropDown;


	//private static String PAGE_URL = MRConstants.AARP_OUR_PLANS_URL;
	private static String PAGE_URL = MRConstants.AARP_OUR_PLANS_URL;

	public PortfolioPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ZipcodeLookupPage looksupforZipcodes() {

		lookupZipcodeLink.click();
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
		validate(zipCodeField);
		validate(goButton);
		validate(lookupZipcodeLink);

	}

	public void hoverourplanslink() {

		validate(OurPlansLink);
		Actions action = new Actions(driver);
		action.moveToElement(OurPlansLink).build().perform();
		validate(OurPlansLink);
	}

	public Boolean findplansbuttonclick2() {

		hoverourplanslink();
		validate(FindPlansButton);
		FindPlansButton.click();
		validate(FindPlansButton);

		return validate(errormessage);

	}

	public AcquisitionHomePage ErrorMessage() {
		validate(errormessage);
		Actions action = new Actions(driver);
		action.moveToElement(errormessage);

		validate(errormessage);
		return null;
	}

	public Boolean clicktextfield() {

		hoverourplanslink();

		validate(zipfield);
		zipfield.click();
		zipfield.sendKeys("9001");
		validate(FindPlansButton);
		FindPlansButton.click();
		return validate(errormessage);
	}

	public AcquisitionHomePage errormessage() {
		validate(errormessage);
		Actions action = new Actions(driver);
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
	
	public VPPPlanSummaryPage enterZipCodeNavigateVPP(String zipcode){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(zipCodeInput));
		
		validate(zipCodeInput);
		zipCodeInput.sendKeys(zipcode);
		validate(goButton);
		goButton.click();
		Select sel = new Select(goButton);
		sel.selectByValue("AL");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")){
			System.out.println("PAss");
			return new VPPPlanSummaryPage(driver);
 		}
		System.out.println("Fail");
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


}
