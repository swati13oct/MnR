/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div")
	private WebElement showMaPlans;

	@FindBy(className = "planinf")
	private WebElement vppplansummarypage;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div/a")
	private WebElement showMsPlans;

	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div")
	private WebElement showPdpPlans;

	@FindBy(xpath = "//div[@class='enabled ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
	List<WebElement> pdpPlanElement;
	
	@FindBy(xpath = "//div[@id='chooseplan']/div/div/h3")
	private WebElement pageHeading;

	@FindBy(id = "editDrugMA")
	private WebElement editDrugListLink;
	
	@FindBy(linkText = "All Primary Care Physicians")
	private WebElement allPrimaryCarePhysicians;
	
	@FindBy(linkText = "Complete my list")
	private WebElement completeMyList;
	
	@FindBys(value = { @FindBy(className = "firstTierFilterItem") })
	private List<WebElement> physcianSearchTypes;
	
	
	@FindBys(value = { @FindBy(xpath = "//div[@id='providerResultsContainer']/div") })
	private List<WebElement> providerNameList;
	
	
	@FindBy(id = "pageHeader")
	private WebElement pageHeader;
	
	@FindBy(id = "providerSearchFrame")
	private WebElement providerSearchIframe;
	
	@FindBy(css="#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;
	
	@FindBy(id="pdpplans")
	private WebElement pdpShowPlansLnk;
	
	@FindBy(css="#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//span[@class='cpcheckbox']/input")
	private WebElement compareChkBox;
	
	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;
	
	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, vppplansummarypage, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);

		String fileName = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			fileName = "maplans.json";
		}
		else
		{
			fileName = planType.toLowerCase()+"plans.json";
		}
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		vppPlanSummaryJson = formJsonObject(vppPlanSummary);

	}

	public PlanDetailsPage navigateToPlanDetails(String planName,
			String planType) {
		
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			ElementData elementData = new ElementData("id", "viewDetailsMA");
			WebElement element = getViewPlanDetailsElement(maPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();

			}

		} else if (planType.equalsIgnoreCase("PDP")) {
			ElementData elementData = new ElementData("id", "viewDetails"
					+ planType);
			WebElement element = getViewPlanDetailsElement(pdpPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();

			}

		}
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Plan Details | AARP® Medicare Plans from UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase("Plan Detail")) {
			return new PlanDetailsPage(driver,planType);
		}

		return null;
	}

	private WebElement getViewPlanDetailsElement(
			List<WebElement> planElement, ElementData elementData,
			String planName) {
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {

				WebElement element = findChildElement(elementData,
						plan);

				return element;

			}
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(showMaPlans);
		validate(showMsPlans);
		validate(showPdpPlans);
		vppPlanSummaryJson = formJsonObject(vppPlanSummary);
	}

	private JSONObject formJsonObject(PageData vppPlanSummary) {
		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(vppPlanSummary
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
							jsonObjectForArray.put(vppPlanSummary
									.getExpectedData().get(key)
									.getElementName(), element.getText());
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
		return jsonObject;

	}

	public VPPPlanSummaryPage viewPlanSummary(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			showMaPlans.click();
		} else if (planType.equalsIgnoreCase("MS")) {
			showMsPlans.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public JSONObject getPlanSummaryActualData(String planName) {
		String fileName = null;
		if (planName.contains("HMO")) {
			fileName = "maplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,maPlanElement);
			return jsonObject;
			
		}
		if(planName.contains("PDP"))
		{
			fileName = "pdpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,pdpPlanElement);
			return jsonObject;
		}
		
		
		return null;
	}

	private JSONObject getActualJsonObject(String fileName, String planName,
			List<WebElement> planElement) {
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {

				JSONObject jsonObject = new JSONObject();
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(
							vppPlanSummary.getExpectedData().get(key), plan);
					if(validate(element))
					{
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					
				}
				return jsonObject;

			}
		}
		return null;
	}


	public EnrollPlanInfoPage clicksOnEnrollInplanLink(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollPDP"); // TODO:
																					// Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (pageHeading.getText().equalsIgnoreCase(
				"You Have Chosen to Enroll in the Following Plan")) {
			return new EnrollPlanInfoPage(driver);
		}
		return null;
	}	

	
	public GetStartedPage navigateToSummaryPage(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		} 
		return new GetStartedPage(driver);
	}

    public ManageDrugPage navigateToEditDrugList(String planName) {
		
		if (planName.contains("HMO")) {
			ElementData elementData = new ElementData("id", "editDrugMA");
			WebElement element = getViewPlanDetailsElement(maPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();

			}

		} else if (planName.contains("PDP")) {
			ElementData elementData = new ElementData("id", "editDrugPDP");
			WebElement element = getViewPlanDetailsElement(pdpPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();

			}

		}
		CommonUtility.checkPageIsReady(driver);
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		}

		return null;
	}

	public ProviderSearchPage clicksOnIsProviderCovered(String planName) {
		
		ElementData elementData = new ElementData("id", "doctorCoverMA");
		for (WebElement plan : maPlanElement) {
			if (plan.getText().contains(planName)) {
				findChildElement(elementData,plan).click();
				break;
			}
		}

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToNewIframe("providerSearchFrame");
		if (pageHeader.getText().equalsIgnoreCase("Find a Physician, Medical Group, Clinic or Facility"))
		{
			return new ProviderSearchPage(driver);
		}
		return null;
		/*for (WebElement physcianSearchType : physcianSearchTypes) {
			if (physcianSearchType.getText().contains(physicianSearchCriteria)) {
				ElementData physcianElementdata = new ElementData("tagName", "a");
				findChildElement(physcianElementdata,physcianSearchType).click();
			}
		}

		
		for(WebElement element : providerNameList){
			ElementData providerElementData = new ElementData("className", "providerName");
			if(findChildElement(providerElementData,element).getText().equalsIgnoreCase(physicianName))
			{ 
				ElementData addToListElementData = new ElementData("linkText", "Add to List");
				findChildElement(addToListElementData,element).click();
			}
		}
		
		completeMyList.click();

		if (getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		*/
	}
	
	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton(){
		
		Assert.assertTrue("FAIL - Compare 3 plans button is not displayed", elementFound(comparePDPPlanChkBox));
		Assert.assertEquals("true", comparePDPPlanChkBox.getAttribute("readonly"));
	}
	
	public void clickAndVerifyCompareUpto3PlansPopup(){
		comparePDPPlanChkBox.click();
		Assert.assertEquals("Compare up to 3 plans Select 2-3 plans that you'd like to compare.",compareUpto3PlansPopup.getText().trim());
	}
	
	public void verifyCompareCheckBoxesAreUnchecked(){
		
		Assert.assertEquals("compare_checkbox ng-scope ng-pristine ng-valid", compareChkBox.getAttribute("class"));
		
	}
	
	public void UncheckAndVerifyCompareChkBox(){
		compareChkBox.click();
		Assert.assertEquals("compare_checkbox ng-scope ng-valid ng-dirty", compareChkBox.getAttribute("class"));
	}
	
	public void VerifyComparePopUpText(){
		
		Assert.assertEquals("Select 1 more plan to compare",comparePopUpTxt1.getText().trim());
		Assert.assertEquals("Select 2-3 plans that you'd like to compare",comparePopUpTxt2.getText().trim());
	}
	
	public void clickCompareChkBox(){
		waitforElement(compareChkBox);
		compareChkBox.click();
	}
	
	
}
