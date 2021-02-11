/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author rkodumur
 *
 */
public class AgentsnBrokersAARPPage extends GlobalWebElements{
	
	@FindBy(xpath = "//*[contains(@class,'heading-1')]")
	public static WebElement header;
	
	@FindBy(xpath = "(//*[contains(@class,'layout-container')]//ul)[1]")
	public static WebElement medicareOverviewTableTitle;
	
	
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
