/**
 * 
 */
package pages.memberrdesignVBF;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PlanMaterialConfirmationPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;


	public JSONObject planMaterialsConfirmationJson;

	@FindBy(id = "additionalMaterialsText")
	private WebElement addordermaterialLink;

	public PlanMaterialConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}
/***
 * 
 * @return
 */
	public boolean navigateToValidateOrderConfirmationInRedesignPage() {
		CommonUtility.waitForPageLoadNew(driver, addordermaterialLink, 60);
		addordermaterialLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Order Plan Material")) {
			return true;
		}

		return false;
	}

	@Override
	public void openAndValidate() {

		validateNew(addordermaterialLink);
	}

}
