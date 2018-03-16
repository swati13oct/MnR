/**
 * 
 */
package pages.memberrdesignVBF;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PharmacyResultPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//*[@class='pharmacy-info']")
	private List<WebElement> PharmacyResultList;

	@FindBy(xpath = "//span[@ng-show = 'showPharmacyCount']")
	private WebElement PharmacyFoundCount;

	public PharmacyResultPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validateNew(PharmacyResultList.get(0));
		validateNew(PharmacyFoundCount);
	}

}
