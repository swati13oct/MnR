/**
 * 
 */
package pages.memberrdesignVBF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class MemberSearchPage extends UhcDriver {

	@FindBy(id = "userName")
	private WebElement memberUsername;

	@FindBy(id = "memberId")
	private WebElement memberIdField;

	@FindBy(css = "button")
	private WebElement btnSearch;

	@FindBy(css = "table.resultsTable tr:nth-child(2)>td>a")
	private WebElement lnkMemberUsername;
	
	@FindBy(id = "date-mm")
	private WebElement monthDropdown;
	
	@FindBy(id = "date-dd")
	private WebElement dateDropdown;
	
	@FindBy(id = "date-yyyy")
	private WebElement yearDropdown;

	
	public MemberSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(memberUsername);
		validateNew(memberIdField);
		validateNew(btnSearch);
	}

	public MemberInformationPage memberSearch() {
		btnSearch.click();
		CommonUtility.waitForPageLoadNew(driver, lnkMemberUsername, 60);
		scrollToView(lnkMemberUsername);
		lnkMemberUsername.click();
		return new MemberInformationPage(driver);

	}
	public void enterMemberUserName(String text){
		sendkeysNew(memberUsername, text);
	}
	
	public void enterMemberID(String text){
		sendkeysNew(memberIdField, text);
	}
	
	public void enterDOB(String month, String date, String year){
		sendkeysNew(monthDropdown, month);
		sendkeysNew(dateDropdown, date);
		sendkeysNew(yearDropdown, year);	
	}
	
	
	
}
