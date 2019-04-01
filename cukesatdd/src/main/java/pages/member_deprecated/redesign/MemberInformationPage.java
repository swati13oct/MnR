/**
 * 
 */
package pages.member.redesign;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class MemberInformationPage extends UhcDriver {

	@FindBy(css="div.modal-dialog.modal-lg a.btn.btn--primary")
	private WebElement btnLoginAsMember;
	
	public MemberInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
	}
	
	public TestHarnessPage loginAsMember(){
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOf(btnLoginAsMember));
		btnLoginAsMember.click();
		switchToNewTab();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new TestHarnessPage(driver);
	}
}
