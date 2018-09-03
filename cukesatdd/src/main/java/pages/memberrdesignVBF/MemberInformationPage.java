/**
 * 
 */
package pages.memberrdesignVBF;

/*import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;*/
import atdd.framework.UhcDriver;

public class MemberInformationPage extends UhcDriver {

	@FindBy(xpath = "//div[contains(@class,'loginbutton')]/a[contains(text(),'Login as member')]")
	private WebElement btnLoginAsMember;

	@FindBy(css = ".modal-title>p")
	private WebElement memerInformationHeader;

	public MemberInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(memerInformationHeader);
	}

	public Object loginAsMember() throws InterruptedException {

		scrollToView(btnLoginAsMember);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnLoginAsMember));
		Thread.sleep(30000);
		switchToNewTabNew(btnLoginAsMember);
		int counter = 0;
		do {
			if (counter <= 20) {
				Thread.sleep(5000);
				System.out.println("Time elapsed post sign In clicked --" + counter + "*5 sec.");
			} else {
				System.out.println("TimeOut!!!");
				return null;
			}
			counter++;
			if (driver.getTitle().contains("Internal Error") || driver.getTitle().contains("Sign In")) {
				System.out.println("Error !!!");
				return null;
			}
		} while (!((driver.getTitle().contains("Home")) || (driver.getTitle().contains("Test Harness"))));

		System.out.println("Current URL: " + currentUrl());
		if (currentUrl().contains("member/testharness.html")) {
			return new TestHarness(driver);
		} else if (currentUrl().contains("terminated-plan.html")) {
			return new TerminatedHomePage(driver);
		} else if (currentUrl().contains("/dashboard")) {
			return new RallyDashboardPage(driver);
		}
		return null;
	}

}
