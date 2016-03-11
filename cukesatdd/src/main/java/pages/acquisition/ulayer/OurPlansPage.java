package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class OurPlansPage extends UhcDriver {

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
	
	@FindBy(id= "ghn_lnk_2")
	private WebElement OurPlansLink;
	
	@FindBy(id="subnav_2")
	public static WebElement ourPlansDropdown;
	
	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/button")
	public WebElement FindPlansButton;

	private static String PAGE_URL = MRConstants.AARP_OUR_PLANS_URL;

	public OurPlansPage(WebDriver driver) {
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
		//Hover over text
		Actions action = new Actions(driver);
		action.moveToElement(OurPlansLink).build().perform();
		
	// to click
	//	action.click().build().perform();
		
		validate(OurPlansLink);
		
		// TODO Auto-generated method stub
	
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
	
	// TODO Auto-generated method stub
	return null;
}

public Boolean clicktextfield() {
	
	hoverourplanslink();
	
	validate(zipfield);
	zipfield.click();
	zipfield.sendKeys("9001");
	validate(FindPlansButton);
//	String zip= zipfield.getAttribute("value");
	FindPlansButton.click();
	return validate(errormessage);
	
//	if(zip.equalsIgnoreCase("1234")){
//		return true;
//	}
//	return false;
	// TODO Auto-generated method stub
	
}

public AcquisitionHomePage errormessage() {
	validate(errormessage);
	Actions action = new Actions(driver);
	action.moveToElement(errormessage);
	
	validate(errormessage);
	
	// TODO Auto-generated method stub
	return null;
}

public Boolean correctzipcode() {
	
	hoverourplanslink();
	
	validate(zipfield);
	zipfield.click();
	zipfield.sendKeys("90010");
//	String zip= zipfield.getAttribute("value");
//	if(zip.equalsIgnoreCase("90010")){
//		return true;
	return null;
	}
//	return false;
	
	// TODO Auto-generated method stub
	



}
