package pages.member.bluelayer;

/**
 * @author pagarwa5
 * 
 * 
 */

import java.util.Map;
import java.util.NoSuchElementException;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ConfirmPlanDetailsPage extends UhcDriver {

	@FindBy(linkText = "add new plan(s)")
	private WebElement addNewPlanButton;

	@FindBy(xpath = "//tr[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div/div/div")
	private WebElement myPlansSection;
	
	@FindBy(xpath = "//tr[@id='contentRow']/td/table/tbody/tr/td/div/div[2]/div[3]/div[3]/div[2]/div/div")
	private WebElement myResourcesSection;
	
	@FindBy(id = "my-account-home-page")
	private WebElement accountHomePage;
	
	@FindBy(linkText = "Go to my account home")
	private WebElement homePageLink;
	
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

	public SecondPlanInfoPage confirm() {
		addNewPlanButton.click();
		ElementData elementData = new ElementData("id","progress");
		WebElement element = findElement(elementData);
		if(validate(element))
		{
			try
			{
			CommonUtility.waitForElementToDisappear(driver, element, 10);
			}
			catch (NoSuchElementException e) {
				System.out.println("progress not found");
			} catch (TimeoutException ex) {
				System.out.println("progress not found");
			} catch (Exception e) {
				System.out.println("progress not found");
			}
		}
		ElementData accountHomeElementData = new ElementData("className", "gotomyaccounthome_btn");
		WebElement accountHomeElement = findElement(accountHomeElementData);
		if(validate(accountHomeElement))
		{
			return new SecondPlanInfoPage(driver);
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

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		Map<String, JSONObject> expectedDataMap1 = expectedDataMap;
		JSONObject planConfirmationExpectedJson = expectedDataMap1
				.get(CommonConstants.ADD_PLAN);
		JSONObject globalExpectedJson = expectedDataMap1
				.get(CommonConstants.GLOBAL);
		planConfirmationExpectedJson = CommonUtility.mergeJson(planConfirmationExpectedJson, globalExpectedJson);
		
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
	
	public SecondPlanInfoPage confirm(String category) {
		addNewPlanButton.click();
		ElementData elementData = new ElementData("id", "progress");
		WebElement element = findElement(elementData);
		
		if(validate(element))
		{
			try
			{
			CommonUtility.waitForElementToDisappear(driver, element, 10);
			
		} catch (NoSuchElementException e) {
			System.out.println("progress not found");
		} catch (TimeoutException ex) {
			System.out.println("progress not found");
		} catch (Exception e) {
			System.out.println("progress not found");
		}
		}
		
		return new SecondPlanInfoPage(driver);
		

	}
}
