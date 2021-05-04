/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.acquisition.commonpages.PageTitleConstants;
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
	public WebElement header;
	
	@FindBy(xpath = "//h1//*[contains(@class,'meded-article-header__title')]")
	public WebElement brokerAgentHeader;


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
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)) {
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

}
