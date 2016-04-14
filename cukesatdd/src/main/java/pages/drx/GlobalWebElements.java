package pages.drx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */

class GlobalWebElements extends UhcDriver {

	@FindBy(id = "enter-plan-info")
	public WebElement enterPlanInfoLink;

	@FindBy(id = "enter-drugs")
	public WebElement enterDrugsLink;

	@FindBy(id = "select-pharmacy")
	public WebElement selectPharmacyLink;

	@FindBy(id = "plan-summary")
	public WebElement planSummaryLink;

	public GlobalWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub

	}

}
