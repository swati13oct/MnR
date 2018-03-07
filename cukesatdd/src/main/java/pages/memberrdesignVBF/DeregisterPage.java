package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author akuma103
 */
public class DeregisterPage extends UhcDriver {

	/** The Deregister page url for team - g. */
	private static String PAGE_URL;

	/** The user Id to be deregistered. */
	@FindBy(id = "tobederegisteruser")
	private WebElement enterUserName;

	/** The deregister button. */
	@FindBy(xpath = "//*[@id='deregisterform']/input[2]")
	private WebElement deregisterButton;

	public DeregisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		String environment = MRScenario.environment;
		switch (environment.toUpperCase()) {
		case "TEAMCI-1":
			PAGE_URL = MRConstants.TEANCI_1_DEREGISTER_URL;
			break;
		case "TEST-A":
			PAGE_URL = MRConstants.TEST_A_DEREGISTER_URL;
			break;
		case "STAGE":
			PAGE_URL = MRConstants.STAGE_DEREGISTER_URL;
			break;
		default:
			System.out.println("Please check environment");
		}
		System.out.println("URL:" + PAGE_URL);
		startNew(PAGE_URL);
	}

	public void deregisterUser(String userId) {
		enterUserName.sendKeys(userId);
		deregisterButton.click();
		driver.switchTo().alert().accept();
	}

}
