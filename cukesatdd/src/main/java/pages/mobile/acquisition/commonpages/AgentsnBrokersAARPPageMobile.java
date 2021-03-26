/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class AgentsnBrokersAARPPageMobile extends GlobalWebElements {

	// @FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	@FindBy(xpath = "//h1//*[contains(text(),'Health Insurance Broker & Agent Tools')]")
	public static WebElement header;

	// @FindBy(xpath =
	// "//div[contains(@class,'mededoverviewcontainer')]//div[contains(@class,'meded-medicare-overview__title')]")
	@FindBy(xpath = "(//div[contains(@class,'CustomRTE')]//ul)[1]")
	public static WebElement medicareOverviewTableTitle;

	public AgentsnBrokersAARPPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(header);

	}

}
