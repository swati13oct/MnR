/**
 * 
 */
package pages.member.redesign;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.RallyDashboardPage;

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
	
	public RallyDashboardPage loginAsMember(){
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOf(btnLoginAsMember));
		scrollToView(btnLoginAsMember);
		//btnLoginAsMember.click();
		switchToNewTab(btnLoginAsMember);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RallyDashboardPage(driver);
	}
}
