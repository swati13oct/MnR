/**
 * 
 */
package pages.redesign;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import pages.redesign.OrderplanmaterialsPage;

/**
 * @author sdwaraka
 *
 */
public class PlanMaterialConfirmationPage extends UhcDriver {
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;

	private PageData planMaterials;
	
	public JSONObject planMaterialsConfirmationJson;
	
	@FindBy(xpath = "//section[1]/div/div/div/a")
	private WebElement addordermaterialLink;

	
	public PlanMaterialConfirmationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ORDER_PLAN_MATERIALS_PAGE_DATA;
		planMaterials = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	   }
	
	public void logOut() {
		logOut.click();
		
	}

	public OrderplanmaterialsPage navigateToValidateOrderConfirmationInRedesignPage() {
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		addordermaterialLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(driver.getTitle().equalsIgnoreCase("Order Plan Materials")){
			return new OrderplanmaterialsPage(driver);
		}
	
		return null;
	}


	@Override
	public void openAndValidate() {
		
		validate(logOut);
		
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
