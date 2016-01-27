/**
 * 
 */
package pages.member.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class OrderplanmaterialsPage extends UhcDriver {

	@FindBy(id = "documentIdName1")
	private WebElement memberMaterialsfield;

	@FindBy(id = "documentIdName2")
	private WebElement replacementIdField;

	@FindBy(linkText = "submit")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@class='orderplanconttext']/h3")
	private WebElement planMaterialHeading;

	@FindBy(id = "shipDocumentStateCodeId")
	private WebElement shipDocumentStateCodeId;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	public OrderplanmaterialsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, planMaterialHeading, CommonConstants.TIMEOUT_30);
		openAndValidate();
	}

	public PlanMaterialConfirmationPage selectsOption(String option) {

		if (option.contains("Member Materials")) {
			memberMaterialsfield.click();
		}

		if (option.contains("Replacement ID card")) {
			replacementIdField.click();
		}

		submitButton.click();

		if (planMaterialHeading.getText().contains(
				"Plan Materials Order Confirmation")) {
			return new PlanMaterialConfirmationPage(driver);
		} else
			return null;

	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validate(planMaterialHeading);
		validate(logOut);
	}

}
