/**
 * 
 */
package pages.regression.memberauth;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * 
 * @author bnaveen4
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
	
	/**
	 * This method navigates the member to AccountHome Page\Rally Dashboard page
	 * @return
	 */
	public AccountHomePage loginAsMember(){
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
		return new AccountHomePage(driver);
	}
}
