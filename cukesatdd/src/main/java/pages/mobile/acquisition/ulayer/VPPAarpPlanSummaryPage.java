package pages.mobile.acquisition.ulayer;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.GetStartedPage;
import pages.acquisition.ulayer.IntroductionInformationPage;
import pages.acquisition.ulayer.ManageDrugPage;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.ulayer.PlanDetailsPage;
import pages.acquisition.ulayer.PlanInformationPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class VPPAarpPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div")
	private WebElement showMaPlans;

	@FindBy(xpath = "//div[@class='planValues']")
	private WebElement vppplansummarypage;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div/a")
	private WebElement showMsPlans;

	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div")
	private WebElement showPdpPlans;

	@FindBy(xpath = "//div[@class='enabled ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
	List<WebElement> pdpPlanElement;
	

	
	
	@FindBy(id = "pageHeader")
	private WebElement pageHeader;

	

	@FindBy(className = "switchPlanYear")
	private WebElement toggleplanYear;
	
	//@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	@FindBy(xpath=".//*[@id='doctorCoverMA']")
	private WebElement MaProviderLink;
	
	@FindBy(xpath="//div[@id='mainWrapper']/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[3]/div/div[1]/a")
	private WebElement previousYearLink;


	@FindBy(css="#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;
	

	
	@FindBy(css="#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//span[@class='cpcheckbox']/input")
	private WebElement compareChkBox;
	
	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;
	
	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;


		
	@FindBy(xpath=".//div[@id='pdpplans_container']/div[3]/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement PDPEnrolllink;

	
	@FindBy (xpath=".//div[@id='maplans_container']/div[3]/div[1]/div/div[1]/div[1]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement MAEnrolllink;
	
	@FindBy (xpath=".//*[@id='next']")
	private WebElement stayOnthisPopup;

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPAarpPlanSummaryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		
		CommonUtility.waitForPageLoad(driver, vppplansummarypage, CommonConstants.TIMEOUT_30);
		
		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public VPPAarpPlanSummaryPage(WebDriver driver, String planType) {
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
		/*if (driver.getTitle().equalsIgnoreCase("Plan Details | AARP® Medicare Plans from UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PLAN_DETAIL)) {
			return new PlanDetailsPage(driver,planType);
		}*/

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
						jsonObject.put(key, elements.get(0).getText().trim());
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
									.getElementName(), element.getText().trim());
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
	
	public boolean validateTimeoutPopup()
	{
		boolean validatePopup=false;
		try{
			
			Thread.sleep(600000);
			validatePopup=validate(stayOnthisPopup);
			stayOnthisPopup.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return validatePopup;
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
		if(planName.contains("Regional PPO"))
		{
		fileName = "mamultistateplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName,maPlanElement);
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


	public IntroductionInformationPage clicksOnEnrollInplanLink(String planName) { 
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollMA");
					findChildElement(elementData, plan).click();

				}
				break;
			}
		}
		else if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id", "enrollPDP"); // TODO:
																					// Re-check
					findChildElement(elementData, plan).click();

				}
				break;
			}
		}
			return new IntroductionInformationPage(driver);
	}	
	
	public PlanInformationPage navigatetoEnrollInplanLink(String planName)
	{
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
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Complete Online Application") || driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_AARP_MEDICARERX_ONLINE_APPLICATION)) {
			return new PlanInformationPage(driver,planName);
		}
		
		return null;
	}
	public IntroductionInformationPage navigatetoEnrollInplanLinkpage(String planName)
	{
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
		if (driver.getTitle().equalsIgnoreCase(
				"AARP Medicare Complete Online Application") || driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_AARP_MEDICARERX_ONLINE_APPLICATION)) {
			return new IntroductionInformationPage(driver);
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
	
	public String togglePlan() {
		String currentYearFlag = "false";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currentYearFlag = "true";
		}
		return currentYearFlag;

	}

	
	public VPPPlanSummaryPage togglePlanYear(String planType) {

		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}

	public boolean clicksOnMAProviderCoveredLink() {
		previousYearLink.click();
		validate(MaProviderLink);
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Welcome")) {
			return true;
		}
		return false;
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
		
	public boolean plantitlematch(String planname, String plantype) {
		if ((plantype.equalsIgnoreCase("MA") && planname.contains("HMO"))||(plantype.equalsIgnoreCase("PDP") && planname.contains("PDP"))) {
			return true;
		} else 
		return false;
	}
	
	public boolean verifyandclickenrolllink(String plantype)
	{
		if(plantype.equals("PDP"))
		{
			if(validate(PDPEnrolllink))
			{
			PDPEnrolllink.click();
			driver.navigate().back();
			togglePlan();
			PDPEnrolllink.click();
			driver.navigate().back();
			return true;
			}
		}
		else if(plantype.equals("MA"))
		{
			if(validate(MAEnrolllink))
			{
			MAEnrolllink.click();
			driver.navigate().back();
			togglePlan();
			MAEnrolllink.click();
			driver.navigate().back();
			return true;
			}
		}
		return false;
	}
	
	public GetStartedPage clicksOnEnterDrugInformationLink(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
			if (plan.getText().contains(planName)) {
			ElementData elementData = new ElementData("id",
			"enterDrugMA");
			findChildElement(elementData, plan).click();
			}
			}
			}
			if (planName.contains("PDP")) {
			for (WebElement plan : pdpPlanElement) {
			if (plan.getText().contains(planName)) {
			ElementData elementData = new ElementData("id",
			"enterDrugPDP"); // TODO Re-check
			findChildElement(elementData, plan).click();
			}
			}
			}
			
			if (driver.getTitle().equalsIgnoreCase(
			"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new GetStartedPage(driver);
			}
		
	
		return null;
	}

}
