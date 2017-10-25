/**
 * 
 */
package pages.member.redesign;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class TestHarnessPage extends UhcDriver {

	@FindBy(xpath="//a[text()='Go to Contact Us page']")
	private WebElement linkContactUs;
	
	@FindBy(xpath="//h2/p[text()='Website Technical Support']")
	private WebElement heading;
	
	public TestHarnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ContactUsPage navigateToContactUsPage() {
		linkContactUs.click();
		CommonUtility.waitForPageLoad(driver, heading, 10);
		if(driver.getTitle().equalsIgnoreCase("Overview"))
		{
			return new ContactUsPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(linkContactUs);
	}
}
