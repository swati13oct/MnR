/**
 * 
 */
package pages.deprecated.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.gson.JsonObject;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoveragePage1 extends UhcDriver {

	
	public PageData benefitsCoverage;

	public JSONObject benefitsandcoverageJson;
		
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[1]/div/div/div/div/h1")
	private WebElement planName;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;
	
	@FindBy(className="start-search-atdd")  
	private WebElement startSerch;

	@FindBy(className="changepcp-atdd")  
	private WebElement changePcp;
	
	public BenefitsAndCoveragePage1(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*get PHR expected data*/
		JSONObject benefitsExpectedJson = expectedDataMap.get(CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, globalExpectedJson);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);

		return benefitsExpectedJson;

	}
		
	public void validateFieldsOnBenefitsAndCoveragePage(){
		
		try {
			validateNew(planName);
			
			validateNew(memberId);

			validateNew(memberName);

			validateNew(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	@Override
	public void openAndValidate() {
		
		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsCoverage.getExpectedData().get(key));
			if (elements.size() == 1) {
				validateNew(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validateNew(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(benefitsCoverage.getExpectedData()
								.get(key).getElementName(), element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		benefitsandcoverageJson = jsonObject;

		System.out.println("BenefitsCoverageJson----->"+benefitsandcoverageJson);
		
	}

	public void navigateToRallySearchWindow() {
		// TODO Auto-generated method stub
		validateNew(startSerch);
		startSerch.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void navigateToContactUsPage() {
		// TODO Auto-generated method stub
		validateNew(changePcp);
		changePcp.click();
		try { 
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
}
