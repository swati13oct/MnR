package pages.member.bluelayer;

/**
 * @author pagarwa5
 * 
 * 
 */

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ConfirmPlanDetailsPage extends UhcDriver {

	@FindBy(linkText = "add new plan(s)")
	private WebElement addNewPlanButton;

	@FindBy(linkText = "Go to my account home")
	private WebElement homePageLink;
	
	@FindBy(xpath = "//tr[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div/div/div")
	private WebElement myPlansSection;
	
	@FindBy(xpath = "//tr[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div[2]/div/div")
	private WebElement myResourcesSection;
	
	@FindBy(id = "my-account-home-page")
	private WebElement accountHomePage;
	
	private PageData addPlanConfirmation;

	public JSONObject addPlanConfirmationJson;

	public ConfirmPlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ADD_PLAN_CONFIRMATION_PAGE_DATA;
		addPlanConfirmation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public AccountHomePage confirm() {
		addNewPlanButton.click();
		homePageLink.click();

		/*CommonUtility.waitForPageLoad(driver, accountHomePage);*/
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")) {
			return new AccountHomePage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		validate(addNewPlanButton);

		JSONObject jsonObject = new JSONObject();
		for (String key : addPlanConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(addPlanConfirmation.getExpectedData()
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
		addPlanConfirmationJson = jsonObject;
		
		System.out.println("addPlanConfirmationJson----->"+addPlanConfirmationJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject planConfirmationExpectedJson = expectedDataMap
				.get(CommonConstants.ADD_PLAN_CONFIRMATION);

		return planConfirmationExpectedJson;
	}

	public AccountHomePage confirm(String category) {
		addNewPlanButton.click();
		homePageLink.click();
		CommonUtility.waitForPageLoad(driver, myPlansSection, CommonConstants.TIMEOUT_30);
		CommonUtility.waitForPageLoad(driver, myResourcesSection, CommonConstants.TIMEOUT_30);
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new AccountHomePage(driver,category);
		}
		else if(this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")){
			return new AccountHomePage(driver);
		}
		return null;

	}
}
