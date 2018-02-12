package pages.member.redesign;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * This class represents Jarvis' Deregister page. It is a simple page containing
 * a form that requires a userId and password to deregister a user from Jarvis.
 */

public class DeregisterPage extends UhcDriver {

    /** The signin page url. */
    private static String PAGE_URL = MRConstants.DEREGISTER_STAGE_URL;

    /** The agent party unix id. */
    @FindBy(id = "tobederegisteruser")
    private WebElement userNameField;

    /** The password field. */
    @FindBy(id = "password")
    private WebElement passwordField;

    /** The password field. */
    @FindBy(xpath = "//input[@value='DeRegister']")
    private WebElement deregisterButton;

    /**
     * Instantiates a new sign in page.
     *
     * @param driver
     *            the driver
     */
    public DeregisterPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	openAndValidate();
    }

    /**
     * Open and validate screen is shown.
     *
     * @return true, if successful
     * @see atdd.framework.UHCDriver#openAndValidate()
     */
    @Override
    public void openAndValidate() {
	start(MRConstants.DEREGISTER_STAGE_URL);
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.visibilityOf(userNameField));
    }

    /**
     * Deregister the user. This takes @params and populates form and submits to 
     * delete user.
     *
     * @param username
     *            the username
     */
    public void deregisterUser(String username) {
	userNameField.sendKeys(username);
	deregisterButton.click();
	Alert alert2 = driver.switchTo().alert();
	alert2.accept();
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }

}
