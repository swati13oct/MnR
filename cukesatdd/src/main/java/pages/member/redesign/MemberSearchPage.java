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

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class MemberSearchPage extends UhcDriver {

	@FindBy(id="userName")
	private WebElement memberUsername;
	
	@FindBy(id="memberId")
	private WebElement memberIdField;
	
	@FindBy(css="button")
	private WebElement btnSearch;
	
	@FindBy(css="table.resultsTable tr:nth-child(2)>td>a")
	private WebElement lnkMemberUsername;
	
	public MemberSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(memberUsername);
		validate(memberIdField);
		validate(btnSearch);
	}
	
	public MemberInformationPage memberSearch(String strMemberUsername){
		WebDriverWait wait = new WebDriverWait(driver,30);
		sendkeys(memberUsername, strMemberUsername);
		btnSearch.click();
		CommonUtility.waitForPageLoad(driver, lnkMemberUsername, 60);
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(lnkMemberUsername));*/
		scrollToView(lnkMemberUsername);
		lnkMemberUsername.click();
		return new MemberInformationPage(driver);
		
	}
}
