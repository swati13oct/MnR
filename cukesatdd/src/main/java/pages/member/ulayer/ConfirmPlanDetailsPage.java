package pages.member.ulayer;

/**
 * @author pagarwa5
 * 
 * 
 */

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.SecondPlanWithDocumentsPopupPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;


public class ConfirmPlanDetailsPage extends UhcDriver{

	@FindBy(className = "btnaddplannew")
	private WebElement addNewPlanButton;
	
	private PageData addPlanConfirmation;

	public JSONObject addPlanConfirmationJson;

	public ConfirmPlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ADD_PLAN_CONFIRMATION_PAGE_DATA;
		addPlanConfirmation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public SecondPlanWithDocumentsPopupPage confirm() {
		addNewPlanButton.click();
		ElementData elementData = new ElementData("id", "progress");
		WebElement element = findElement(elementData);
		
		if(validate(element))
		{
			try
			{
			CommonUtility.waitForElementToDisappear(driver, element, 10);
			
		} catch (NoSuchElementException e) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (TimeoutException ex) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (Exception e) {
			System.out.println("closeAndApplyChangesLink not found");
		}
		}
			
			return new SecondPlanWithDocumentsPopupPage(driver);
	}

	@Override
	public void openAndValidate() {
		validate(addNewPlanButton);

		JSONObject jsonObject = new JSONObject();
		for (String key : addPlanConfirmation.getExpectedData().keySet()) {
			WebElement element = findElement(addPlanConfirmation.getExpectedData()
					.get(key));
			
				if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
		addPlanConfirmationJson = jsonObject;
		
		System.out.println("addPlanConfirmationJson----->"+addPlanConfirmationJson);
	}
	
	public JSONObject getExpectedJson(Map<String, JSONObject> expectedDataMap) {
		JSONObject planConfirmationExpectedJson = expectedDataMap
				.get(CommonConstants.ADD_PLAN);
		JSONObject globalExoectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		planConfirmationExpectedJson = CommonUtility.mergeJson(planConfirmationExpectedJson, globalExoectedJson);
		
		try {
			String memberName = (String) planConfirmationExpectedJson.get("memberName");
			memberName = memberName.replace("Welcome ", "");
			planConfirmationExpectedJson.put("memberName", memberName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return planConfirmationExpectedJson;
	}

}



