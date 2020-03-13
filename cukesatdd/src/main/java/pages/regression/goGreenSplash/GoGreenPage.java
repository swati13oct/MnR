package pages.regression.goGreenSplash;

/*@sunya*/

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class GoGreenPage extends UhcDriver {

	@FindBy(xpath = "//a[contains(text(),'UnitedHealthcare MedicareComplete Choice (PPO)')]")
	private WebElement uhcMedicareCompleteChoicePPO;

	@FindBy(className = "greencontleft")
	private WebElement goGreenLeaf;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData goGreen;

	public JSONObject myProfilesJson;
	public JSONObject accountHomeJson;

	public GoGreenPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}
//below is validating only for newly registered member 
	@Override
	public void openAndValidate() {
		//validateNew(goGreenLeaf);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		if (currentUrl().contains("gogreen-splash") || currentUrl().contains("testharness.html")) {
		System.out.println("Login success full with URL- " +currentUrl());
		}
	}

	public boolean validateNew(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible");

		}
		return false;
	}

	public void logOut() {
		logOut.click();
	}

	/**
	 * Below method will validate plan name: 'uhcMedicareCompleteChoicePPO'
	 * Added as part of commandos team
	 * 
	 * @return
	 */
	public boolean isUHCMedicareCompleteChoicePPOPresent() {
		try {
			if (uhcMedicareCompleteChoicePPO.getText() == "UnitedHealthcare MedicareComplete Choice (PPO)") {
				System.out.println("uhcMedicareCompleteChoicePPO is displayed ");
			} else {
				System.out.println(
						"uhcMedicareCompleteChoicePPO.getText() >>>>>>   " + uhcMedicareCompleteChoicePPO.getText());
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
