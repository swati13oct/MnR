/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
//import pages.mobile.acquisition.ulayer.PageTitleConstants;


/**
 * @author saduri
 *
 */
public class AgentsAndBrokersPageMobile extends GlobalWebElementsMobile{

	@FindBy(className = "med_cont")
	private WebElement agentsAndBrokersTable;

	@FindBy(id = "medicareTitle")
	private WebElement agentsAndBrokersTitle;

	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public static WebElement header;
	
	@FindBy(xpath = "//h1//*[contains(@class,'meded-article-header__title')]")
	public static WebElement brokerAgentHeader;


	public AgentsAndBrokersPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(brokerAgentHeader);
		}

	public AcquisitionHomePageMobile homeFooterClick() {
		validate(footerHomeLink);
		footerHomeLink.click();
		validate(footerHomeLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstantsMobile.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

}
