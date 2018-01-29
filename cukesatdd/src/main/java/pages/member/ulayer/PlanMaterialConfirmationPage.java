/**
 * 
 */
package pages.member.ulayer;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PlanMaterialConfirmationPage extends UhcDriver {
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;

	private PageData planMaterials;
	
	public JSONObject planMaterialsConfirmationJson;
	
	@FindBy(id="additionalMaterialsText")
	private WebElement addordermaterialLink;

	
	public PlanMaterialConfirmationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		/*String fileName = CommonConstants.ORDER_PLAN_MATERIALS_PAGE_DATA;
		planMaterials = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);*/
		openAndValidate();
	   }
	
	public void logOut() {
		logOut.click();
		
	}

	public boolean navigateToValidateOrderConfirmationInRedesignPage() {
		CommonUtility.waitForPageLoad(driver, addordermaterialLink, 60);
		addordermaterialLink.click();
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().contains("Order Plan Material")){
			return true;
		}
	
		return false;
	}


	@Override
	public void openAndValidate() {
		
		validate(addordermaterialLink);
		
/*		JSONObject jsonObject = new JSONObject();
		for (String key : planMaterials.getExpectedData().keySet()) {
			WebElement element = findElement(planMaterials.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		planMaterialsConfirmationJson = jsonObject;
		
		System.out.println("planMaterialsConfirmationJson----->"+planMaterialsConfirmationJson);
		*/
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		JSONObject planMaterialsExpectedJson = expectedDataMap.get(CommonConstants.ORDER_PLAN_MATERIALS);
		planMaterialsExpectedJson = CommonUtility.mergeJson(planMaterialsExpectedJson, globalExpectedJson);
		return planMaterialsExpectedJson;
	}
}
