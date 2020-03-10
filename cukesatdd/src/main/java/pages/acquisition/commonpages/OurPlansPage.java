package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.ZipcodeLookupPage;
import acceptancetests.data.MRConstants;
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


	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/span")
	private WebElement errormessage;

	@FindBy(id = "ghn_lnk_2")
	private WebElement OurPlansLink;

	@FindBy(id = "subnav_2")
	public static WebElement ourPlansDropdown;

	@FindBy(id = "nav-zipcode")
	private WebElement zipfield;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div[2]/form/span/button")
	public WebElement FindPlansButton;

	private static String PAGE_URL = MRConstants.AARP_OUR_PLANS_URL;

	public OurPlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
//		openAndValidate();
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
		PageFactory.initElements(driver, this);
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
		validate(FindPlansButton);
		FindPlansButton.click();
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

}
