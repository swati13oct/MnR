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
public class AgentsnBrokersAARPPage extends GlobalWebElementsMobile{
	
	@FindBy(xpath = "//*[contains(@class,'meded-article-header__title')]")
	public WebElement header;
	
	@FindBy(xpath = "//div[contains(@class,'mededoverviewcontainer')]//div[contains(@class,'meded-medicare-overview__title')]")
	public WebElement medicareOverviewTableTitle;
	
	
	public AgentsnBrokersAARPPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//CommonUtility.waitForPageLoadNew(driver, header, 30);
		validateNew(header);
		
	}


}
