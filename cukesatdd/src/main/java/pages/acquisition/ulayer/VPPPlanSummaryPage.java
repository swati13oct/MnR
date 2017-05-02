/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.ArrayList;
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

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
	private WebElement showMaPlans;
	
	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hideMaPlans;

	@FindBy(xpath = "//div[@class='plan-overview-wrapper']")
	private WebElement vppplansummarypage;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/span[3]")
	private WebElement showMsPlans;
	

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[3]")
	private WebElement showPdpPlans;
	
	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div[2]")
	private WebElement hidePdpPlans;

	@FindBy(xpath = "//div[@class='enabled ng-scope']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
	List<WebElement> pdpPlanElement;
	
	@FindBy(id = "medicalinsursectionheading")
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
	
	
	@FindBy(id = "allplanssise")
	private WebElement allPlansSize;

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/span[1]/span")
	private WebElement maPlansCount;
	
	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[1]/p")
	private WebElement msPlansCount;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/span[1]/span")
	private WebElement pdpPlansCount;
	
	@FindBy(id = "pageHeader")
	private WebElement pageHeader;
	
	@FindBy(id = "providerSearchFrame")
	private WebElement providerSearchIframe;
	

	@FindBy(className = "switchPlanYear")
	private WebElement toggleplanYear;
	
	//@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	@FindBy(xpath=".//*[@id='doctorCoverMA']")
	private WebElement MaProviderLink;
	
	@FindBy(xpath="//div[@id='mainWrapper']/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div/div[3]/div/div[3]/div[3]/div/div[1]/a")
	private WebElement previousYearLink;


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


		
	@FindBy(xpath=".//div[@id='pdpplans_container']/div[3]/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement PDPEnrolllink;

	
	@FindBy (xpath=".//div[@id='maplans_container']/div[3]/div[1]/div/div[1]/div[1]/div/div[1]/div[3]/div/div/span[2]/a")
	private WebElement MAEnrolllink;
	
	@FindBy (xpath=".//*[@id='next']")
	private WebElement stayOnthisPopup;
	
	@FindBy(name = "emailWidgetForm")
	private WebElement emailWidgetForm;

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, vppplansummarypage, CommonConstants.TIMEOUT_30);
		
	/*	String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ); */
		openAndValidate();
	}

	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	/*	String fileName = null;
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
		*/

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
	
	private WebElement getSpecificPlanSummary(
			List<WebElement> planElement,
			String planName) {
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {

				return plan;

			}
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		/*validate(showMaPlans);
		validate(showMsPlans);
		validate(showPdpPlans);*/
		// vppPlanSummaryJson = formJsonObject(vppPlanSummary);
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
			//validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			showMaPlans.click();
			//validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			showMsPlans.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
	}
	
	
	public boolean selectPlanType(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
			return validate(hidePdpPlans);
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			showMaPlans.click();
			return  validate(hideMaPlans);
		} else if (planType.equalsIgnoreCase("MS")) {
			showMsPlans.click();
		}
		return false;
		//return new VPPPlanSummaryPage(driver, planType);
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
	
	

	public boolean validatepassportData() {
		try {
			Thread.sleep(15000);

			String expectedpassportdata = PassportFlyerPDF.getText();
			System.out.println("expectedpassportdata"+expectedpassportdata);
			String actualpassportdata = "Passport Flyer (PDF)";
			if (expectedpassportdata.equalsIgnoreCase(actualpassportdata)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;

	}

	public boolean getSpecificPlanInfo(String planName) {
		WebElement element = null;
		if (planName.contains("HMO")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			 element = getSpecificPlanSummary(maPlanElement, planName);

		} else if (planName.contains("PDP")) {
			//ElementData elementData = new ElementData("id", "viewDetailsPDP");
			 element = getSpecificPlanSummary(pdpPlanElement, planName);
		} 
		else if (planName.contains("Regional PPO")) {
			//ElementData elementData = new ElementData("id", "viewDetailsMA");
			 element = getSpecificPlanSummary(maPlanElement, planName);
		}
		
		return validate(element);
	}

	public boolean validatePlansNumber() {
		
		int allPlans = Integer.valueOf(allPlansSize.getText().replace(" ", ""));
		int maPlans = Integer.valueOf(maPlansCount.getText().replace(" Plans", ""));
		int msPlans = Integer.valueOf(msPlansCount.getText().replace(" Plans", ""));
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText().replace(" Plans", ""));

			
		if(allPlans == maPlans + msPlans + pdpPlans)
		{
			return true;
		}
		return false;
	}

	public boolean validatePlanNames(String planType) {

		if (planType.equalsIgnoreCase("PDP")) {
			int pdpPlans = Integer.valueOf(pdpPlansCount.getText().replace(
					" Plans", ""));
			return pdpPlans == pdpPlanElement.size();

		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			int maPlans = Integer.valueOf(maPlansCount.getText().replace(
					" Plans", ""));
			return maPlans == maPlanElement.size();
		}
		return false;
	}
	
	@FindBy(linkText = "Change location")
	private WebElement changeLocationBtn;
	
	public boolean validateVPPPlanSummaryPage(){
		List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='zipLookup']/p/a"));
		System.out.println("Change loc elements size: "+ elements.size());
		
		System.out.println("Change loc elements text: "+ elements.get(0).getText());
		boolean flag = false;
		if(validate(showMaPlans)&&validate(showMsPlans)&&validate(showPdpPlans)&&validate(changeLocationBtn))
			flag = true;
		return flag;
	}
	public IntroductionInformationPage clicksOnEnrollInplanLink(String planName) {
		 
		int pdpValue = Integer.parseInt(pdpPlansCount.getText());
		int maValue = Integer.parseInt(maPlansCount.getText());
		
		if (planName.contains("HMO")) {
			System.out.println("Entered the plan");
			for(int i=1; i<=maValue; i++){
				WebElement maPlanElement= driver.findElement(By.xpath(".//*[@id='plan-list-1']/div/div[2]/div/div["+i+"]"));
				if (maPlanElement.getText().contains(planName)) {
					ElementData elementData = new ElementData("linkText", "Enroll in plan");//("id", "enrollMA");
					System.out.println("***Element Data is: "+elementData);
					findChildElement(elementData, maPlanElement).click();
					System.out.println("Clicked on the Enroll Link");
					break;
				}
				
			}
		} else if (planName.contains("PDP")) {
			for(int i=1; i<=pdpValue; i++){
				WebElement pdpPlanElement= driver.findElement(By.xpath(".//*[@id='plan-list-3']/div/div[2]/div/div["+i+"]"));
				if (pdpPlanElement.getText().contains(planName)) {
					ElementData elementData = new ElementData("linkText", "Enroll in plan");//("id", "enrollPDP"); // TODO:
					System.out.println("***Element Data is: "+elementData);													// Re-check
					findChildElement(elementData, pdpPlanElement).click();
					System.out.println("Clicked on the Enroll Link");
					break;
				}
				
			}
			
		}
		return new IntroductionInformationPage(driver);
	}

}

	
