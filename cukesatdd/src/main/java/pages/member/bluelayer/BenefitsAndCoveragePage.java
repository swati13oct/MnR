/**
 * 
 */
package pages.member.bluelayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoveragePage extends UhcDriver {

	
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
	
	@FindBy(xpath="//*[@id='_content_uhcm_home_my-plans_benefits-and-coverage-page_jcr_content_overview_needhelp_tfnParplansource_teaser']/div/section/div/div[1]/div/h2")
	private WebElement NeedHelpHeader;
	
	@FindBy(xpath="//*[@id='_content_uhcm_home_my-plans_benefits-and-coverage-page_jcr_content_overview_needhelp_tfnParplansource_teaser']/div/section/div/div[3]/div/p")
	private WebElement Contactussection;
	

        public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*get PHR expected data*/
		JSONObject benefitsExpectedJson = expectedDataMap.get(CommonConstants.BENEFITS_AND_COVERAGE);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		//JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);
		//benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);

		return benefitsExpectedJson;

	}
	
	public void validateFieldsOnBenefitsAndCoveragePage(){
		
		try {
			validate(planName);
			
			validate(memberId);

			validate(memberName);

			validate(effectiveDate);

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
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
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
	
	
public void validateNeedhelpheader(){
		
		try {
			validate(NeedHelpHeader);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

public boolean validatecontactussection()
{
	try{
	if(Contactussection.getText().contains("See more ways to contact us")){
	System.out.println("contactus section is coming ");
	}
	else
	{
	System.out.println("Contactussection.getText() >>>>>>   "+Contactussection.getText());
	}
	}
	catch(Exception e){
	return false;
	}
	return true;
	}
}
	

