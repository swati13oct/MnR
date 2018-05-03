/**
 * 
 */
package pages.member.redesign;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class TestHarnessPage extends UhcDriver {

	@FindBy(xpath="//a[text()='Go to Contact Us page']")
	private WebElement linkContactUs;
	
	@FindBy(xpath="//header//h1")
	private WebElement heading;
	
	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;
	
	@FindBy(xpath="//a[text()='Go to preferences page']")
	private WebElement linkPreferences;
	
	
	public TestHarnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public ContactUsPage navigateToContactUsPage() {
		if (validate(iPerceptionPopUp)) {
            iPerceptionPopUp.click();
            System.out.println("iPerception Pop Up displayed");
		}
		linkContactUs.click();
		CommonUtility.waitForPageLoad(driver, heading, 10);
		if(driver.getTitle().equalsIgnoreCase("Overview"))
		{
			return new ContactUsPage(driver);
		}
		return null;
	}
	
	public PreferencesPage navigateToPreferencesPage() {
		if (validate(iPerceptionPopUp)) {
            iPerceptionPopUp.click();
            System.out.println("iPerception Pop Up displayed");
		}
		linkPreferences.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(driver.getTitle().equalsIgnoreCase("Preferences"))
		{
			return new PreferencesPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(linkContactUs);
		validate(linkPreferences);
	}
}
