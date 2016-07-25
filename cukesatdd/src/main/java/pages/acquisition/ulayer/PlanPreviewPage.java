package pages.acquisition.ulayer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.AssertThrows;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pgrover1
 *
 */
public class PlanPreviewPage extends GlobalWebElements {

	@FindBy(xpath="//*[@id='pipAcq']/div/p[2]/input")
	private WebElement zipcodetxtbox;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[2]/a/span")
	private WebElement continuebtn;
	
	@FindBy(linkText="Look up a ZIP code")
	private WebElement lookuplink;
	
	@FindBy(id="selectcounty_box")
	private WebElement countyModal;

	@FindBy(linkText="Look up a ZIP code")
	private WebElement lookzip;
	
	@FindBy(id="findazip_box")
	private WebElement zipCodeSearchPopup;
	
	@FindBy(xpath = "//div[@id='findazip_box']/div[2]/div/h4/b")
	private WebElement zipCodeSearchPopupHeading;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[3]/select")
	private WebElement selectplandropdwn;
	
	@FindBy(xpath="//*[@id='pipAcq']/div/div[3]/a/span")
	private WebElement searchBtn;
	
	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;
	
	private static String AARP_PLANPREVIEW_PAGE_URL = MRConstants.AARP_PLANPREVIEW_URL;
	
	

	public PlanPreviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	

	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("aarpmedicareplans"))) {
			start(AARP_PLANPREVIEW_PAGE_URL);
			validate(zipcodetxtbox);
			validate(lookuplink);
			validate(continuebtn);
		}
		

	}
	
	public void searchPlans(String zipcode, String countyName) throws InterruptedException
{
		sendkeys(zipcodetxtbox, zipcode);
		continuebtn.click();
		Thread.sleep(5000L);
		try {
			if (countyModal.isDisplayed()) {
				for (WebElement county : countyRows) {
					if (county.getText().contains(countyName)) {
						county.click();
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		if (getTitle().equalsIgnoreCase("Plan Preview information")) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		

	
	}

	
	public ZipcodeLookupHomePage looksupforZipcodes() {
		lookzip.click();
		CommonUtility.waitForPageLoad(driver, zipCodeSearchPopup, CommonConstants.TIMEOUT_30);
		System.out.println(zipCodeSearchPopupHeading.getText());
		if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase("Find a ZIP code")) {
			System.out.println("zipCodeSearchPopupHeading");
			return new ZipcodeLookupHomePage(driver);
		}
		return null;
	}
	
	public void validatesplandropdown(String planname)
	{
		Select dropdown= new Select(selectplandropdwn);
		dropdown.selectByVisibleText(planname);
		searchBtn.click();
		if (currentUrl().contains("/plan-documents.html"))
		{
			System.out.println("Plan documents page loaded");
			Assert.assertTrue(true);
		}
		
		
	}
	
	
}