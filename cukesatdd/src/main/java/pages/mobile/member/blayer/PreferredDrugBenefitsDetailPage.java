/**
 * 
 */
package pages.mobile.member.blayer;

import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstantsMobile;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class PreferredDrugBenefitsDetailPage extends UhcDriver{
	
	@FindBy(xpath="//div[@class='site-header']/a")
	private WebElement menuButton;
	
	@FindBy(xpath = "//div[@id='preferred']//div[@class='carousel-next clickable']")
	private WebElement nextarrow;
	
	@FindBy(xpath="//div[@id='preferred']//div[@class='drug__benefits__mobile constrain-mobile mobile-only']//div[2]//th")
	private WebElement txtInitialCoverage;
	
	@FindBy(xpath="//div[@id='preferred']//div[@class='drug__benefits__mobile constrain-mobile mobile-only']//div[3]//th")
	private WebElement txtCoverageGapStage;

	@FindBy(xpath="//div[@id='preferred']//div[@class='drug__benefits__mobile constrain-mobile mobile-only']//div[4]//th")
	private WebElement txtCatastrophicCoverageStage;
	
	private PageData benefitsDetail;

	public JSONObject benefitsDetailJson;
	
	private PageData browserCheckData;

	private JSONObject browserCheckJson;
	
	public static final String INTIAL_COVERAGE_STAGE ="INITIAL COVERAGE STAGE";
	
	public static final String COVERAGE_GAP_STAGE ="COVERAGE GAP STAGE";
	
	public static final String CATASTROPHIC_COVERAGE_STAGE ="CATASTROPHIC COVERAGE STAGE";
	
	public PreferredDrugBenefitsDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstantsMobile.BENEFITS_DETAIL_PAGE_DATA;
		benefitsDetail = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_ULAYER_MEMBER);
		openAndValidate();
	}

	
	@Override
	public void openAndValidate() {
		validate(menuButton);
		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsDetail.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsDetail
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(key, element.getText());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
		benefitsDetailJson = jsonObject;
		
		System.out.println("benefitsdetailJson----->"+benefitsDetailJson);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject benefitsDetailExpectedJson = expectedDataMap
				.get(acceptancetests.data.CommonConstants.BENEFITS_DETAIL);
		
		return benefitsDetailExpectedJson;
	}



	public JSONObject getBrowserCheck() {
		String fileName = CommonConstantsMobile.MOBILE_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}
	
	public void click2ndstagearrow() {

		validate (nextarrow);
		nextarrow.click();
		try {
		Thread.sleep(5000L);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}


		// TODO Auto-generated method stub

		}
	
	@SuppressWarnings("deprecation")
	public void validateInitialCoverageStage(){
		
		validate (txtInitialCoverage);
		Assert.assertEquals(INTIAL_COVERAGE_STAGE, txtInitialCoverage.getText());
		System.out.println("Validated "+txtInitialCoverage.getText());
		
	}
	@SuppressWarnings("deprecation")
	public void validateCoverageStageGap(){
		
		validate (txtCoverageGapStage);
		Assert.assertEquals(COVERAGE_GAP_STAGE, txtCoverageGapStage.getText());
		System.out.println("Validated "+txtCoverageGapStage.getText());
	}
	@SuppressWarnings("deprecation")
	public void validateCatastrophicCoverageStage(){
		
		validate (txtCatastrophicCoverageStage);
		Assert.assertEquals(CATASTROPHIC_COVERAGE_STAGE, txtCatastrophicCoverageStage.getText());
		System.out.println("Validated "+txtCatastrophicCoverageStage.getText());
	}
}