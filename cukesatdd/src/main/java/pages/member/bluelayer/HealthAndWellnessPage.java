package pages.member.bluelayer;

/*@sunya*/

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class HealthAndWellnessPage extends UhcDriver {


	@FindBy(xpath = "//a[contains(text(),'UnitedHealthcare MedicareComplete Choice (PPO)')]")
	private WebElement uhcMedicareCompleteChoicePPO;


	@FindBy(xpath = ".//*[@id='hl-hw-banner']/a")
	private WebElement healthAndWellnessBanner;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData healthAndWellness;

	public JSONObject myProfilesJson;
	public JSONObject accountHomeJson;


	public HealthAndWellnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PROFILES_PAGE_DATA;
		healthAndWellness = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(healthAndWellnessBanner);
		
		JSONObject jsonObject = new JSONObject();
		for (String key : healthAndWellness.getExpectedData().keySet()) {
			WebElement element = findElement(healthAndWellness.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
		accountHomeJson = jsonObject;
		
		System.out.println("accountHomeJson----->"+accountHomeJson);

	}
	public boolean validate(WebElement element) {
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
	 * @return
	 */
	
}
