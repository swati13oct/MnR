package pages.memberrdesignVBF;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

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

	private static ThreadLocal<String> UserName = new ThreadLocal<String>();
	
	public DeregisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		String environment = MRScenario.environment;
		if (environment.equalsIgnoreCase("team-ci1"))
			PAGE_URL = MRConstants.TEANCI_DEREGISTER_URL;
		else if (environment.equalsIgnoreCase("team-ci2"))
			PAGE_URL = MRConstants.TEANCI_DEREGISTER_URL;
		else if (environment.equalsIgnoreCase("Test-a"))
			PAGE_URL = MRConstants.TEST_A_DEREGISTER_URL;
		else if (environment.equalsIgnoreCase("stage"))
			PAGE_URL = MRConstants.STAGE_DEREGISTER_URL;
		else {
			Assert.fail("Please check environment");
			System.out.println("Please check environment");
		}
		startNew(PAGE_URL);
	}

	public void deregisterUser(String userId) {
		enterUserName.sendKeys(userId);
		deregisterButton.click();
		driver.switchTo().alert().accept();
	}
	   public static String getUserName() {

			
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();

			// For multithreaded execution, timestamp with seconds is not granular
			// enough. Include random suffix
			String rndSuffix = Integer.toString(new Random().nextInt(10)); //1000 is too long and is leading to issues in LAWW.
			String appndTxt = dateFormat.format(date) + "_" + rndSuffix;

			UserName.set("Auto" + appndTxt);
			return UserName.get();

		}
}
