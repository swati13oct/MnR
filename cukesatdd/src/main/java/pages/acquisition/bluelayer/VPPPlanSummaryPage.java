/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;









import pages.acquisition.bluelayer.EnrollPlanInfoPage;
import pages.acquisition.uhcretiree.Rallytool_Page;


import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class VPPPlanSummaryPage extends UhcDriver {

	@FindBy(xpath = "//a[text()='Passport Flyer (PDF)']")
	private WebElement PassportFlyerPDF;

	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[2]/div[2]/div")
	private WebElement showMaPlans;

	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[2]/div[2]/div")
	private WebElement showPdpPlans;

	@FindBy(xpath = "//div[@class='snpplans_planbutton']/div[2]/div[2]/div")
	private WebElement showSnpPlans;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[2]/div[1]/a")
	private WebElement showMsPlans;

	@FindBy(xpath = "//div[@id='chooseplan']/div/div/h3")
	private WebElement pageHeading;

	@FindBy(xpath = "//div[@id='maplans_container']")
	WebElement maPlanConatiner;

	@FindBy(xpath = "//div[@id='pdpplans_container']")
	WebElement pdpPlanConatiner;

	@FindBy(xpath = "//div[@id='snpplans_container']")
	WebElement snpPlanConatiner;


	//@FindBy(xpath ="//div[@id='maplans_container']/div[3]/div/div/div/div[@class='ng-scope']")
	@FindBy(xpath ="//div[@id='maplans_container']")
	List<WebElement> maPlanElement;

	@FindBy(xpath = "//div[@id='maplans_container']/h1/span[2]")
	WebElement maPlanHeadingText;

	@FindBy(xpath = "//div[@id='maplans_container']/h1/span")
	WebElement maPlanHeadingYear;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans']")
	List<WebElement> maPlans;


	@FindBy(xpath = "//div[@id='pdpplans_container']/h1/span[2]")
	WebElement pdpPlanHeadingText;

	@FindBy(xpath = "//div[@id='pdpplans_container']/h1/span")
	WebElement pdpPlanHeadingYear;

	@FindBy(xpath="//div[@data-ng-repeat='plan in pdpplans']")
	List<WebElement> pdpPlans;



	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span[2]")
	WebElement msnPlanHeadingText;

	@FindBy(xpath = "//div[@id='snpplans_container']/h1/span")
	WebElement msnPlanHeadingYear;

	@FindBy(xpath="//div[@data-ng-repeat='plan in snpplans']")
	List<WebElement> msnPlans;

	@FindBy(xpath =".//*[@id='pdpplans_container']")
	List<WebElement> pdpPlanElement;

	//@FindBy(xpath ="//div[@id='snpplans_container']/div[2]/div/div/div/div[@class='ng-scope']")	

	@FindBy(xpath="//div[@id='snpplans_container']")
	List<WebElement> snpPlanElement;

	@FindBy(className = "planinf")
	private WebElement vppplansummarypage;

	@FindBy(id = "editDrugMA")
	private WebElement editDrugListLink;


	@FindBy(linkText ="Make an appointment with an agent")
	private WebElement make_an_appointment_agent;

	@FindBy(css="#pdpplans_container .planCompareBtn")
	private WebElement comparePDPPlanChkBox;

	@FindBy(css="#maplans_container .compareHeading>p")
	private WebElement compareUpto3PlansPopup;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//span[@class='cpcheckbox']")
	private WebElement compareChkBox;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[1]/b")
	private WebElement comparePopUpTxt1;

	@FindBy(xpath="//div[@data-ng-repeat='plan in maplans'][1]//div[contains(@id,'showcompare')][1]/div[@class='compareHeading']/p[2]")
	private WebElement comparePopUpTxt2;

	@FindBy(className = "toggleYear")
	private WebElement toggleplanYear;

	@FindBy(xpath = "//div[@id='maplans_container']/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/div/div[1]/div[2]/table/tbody/tr/td[3]/div/div[2]/div[3]/div[1]/p/a")
	private WebElement MaProviderLink;

	@FindBy(id = "allplanssise")
	private WebElement allPlansSize;

	@FindBy(xpath = "//div[@class='maplans_planbutton']/div[1]/p")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[@class='medsupplans_planbutton']/div[1]/p")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[@class='pdpplans_planbutton']/div[1]/p")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[@class='snpplans_planbutton']/div[1]/p")
	private WebElement msnPlansCount;

	@FindBy(className = "planYear")
	WebElement planYear;

	@FindBy(className = "planType_info")
	WebElement planHeadingText;

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;

	public VPPPlanSummaryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		CommonUtility.waitForPageLoad(driver, vppplansummarypage,CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		openAndValidate();
	}



	public VPPPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageFactory.initElements(driver, this);

		String fileName = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			fileName = "maplans.json";
		} else if (planType.equalsIgnoreCase("PDP")) {
			fileName = "pdpplans.json";
		} else if (planType.equalsIgnoreCase("SNP")) {
			fileName = "snpplans.json";
		} else {
			fileName = "msplans.json";
		}

		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		vppPlanSummaryJson = formJsonObject(vppPlanSummary);

	}

	public boolean validatePlanSummary(){
		boolean flag = true;
		int allPlans = Integer.valueOf(allPlansSize.getText().replace(" ", ""));
		int maPlans = Integer.valueOf(maPlansCount.getText().replace(" Plans", ""));
		int msPlans = Integer.valueOf(msPlansCount.getText().replace(" Plans", ""));
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText().replace(" Plans", ""));
		int msnPlans = Integer.valueOf(msnPlansCount.getText().replace(" Plans", ""));

		if(!(allPlans == maPlans + msPlans + pdpPlans + msnPlans))
		{
			flag = false;
		}

		return flag;
	}

	public boolean validateAvailablePlans(String planType){
		boolean flag = true;
		int planCount = 0;
		Calendar calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		if(planType.equals("MAPD") || planType.equals("MA") ){
			String planHeading = maPlanHeadingYear.getText()+" "+maPlanHeadingText.getText();
			System.out.println(planHeading);
			if(!planHeading.equals(year+" Medicare Advantage Plans")){
				flag = false;
			}
			planCount = Integer.valueOf(maPlansCount.getText().replace(" Plans", ""));
			for(int i=0;i<planCount;i++){
				if(maPlans.get(i).getText().length()==0){
					flag=false;
				}
			}

		}else if(planType.equals("PDP")){
			String planHeading = pdpPlanHeadingYear.getText()+" "+pdpPlanHeadingText.getText();
			System.out.println(planHeading);
			if(!planHeading.equals(year+" Medicare Prescription Drug Plans")){
				flag = false;
			}
			planCount = Integer.valueOf(pdpPlansCount.getText().replace(" Plans", ""));
			for(int i=0;i<planCount;i++){
				if(pdpPlans.get(i).getText().length()==0){
					flag=false;
				}
			}
		}else if(planType.equals("SNP")){
			String planHeading = msnPlanHeadingYear.getText()+" "+msnPlanHeadingText.getText();
			System.out.println(planHeading);
			if(!planHeading.equals(year+" Medicare Special Needs Plans")){
				flag = false;
			}
			planCount = Integer.valueOf(msnPlansCount.getText().replace(" Plans", ""));
			for(int i=0;i<planCount;i++){
				if(msnPlans.get(i).getText().length()==0){
					flag=false;
				}
			}
		}else{
			flag = false;
		}

		return flag;
	}

	public boolean validatePlanSummarydetails(String planName){
		boolean flag = true;
		String fileName = null;
		WebElement planContainer = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			planContainer = snpPlanConatiner;
		}
		else if (planName.contains("HMO")) {
			fileName = "maplansummary.json";
			planContainer = maPlanConatiner;
		}
		else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			planContainer = pdpPlanConatiner;
		}else if(planName.contains("Regional PPO"))
		{
			fileName = "mamultistateplansummary.json";
			planContainer = maPlanConatiner;
		}

		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className","ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(
							vppPlanSummary.getExpectedData().get(key), plan);
					System.out.println("Checking for the element : "+key );
					flag = validate(element);
					if(!flag){
						break;
					}
				}
			}
		}
		return flag;
	}
	public PlanDetailsPage navigateToPlanDetails(String planName) {
		System.out.println("******");
		System.out.println(planName);
		if (planName.contains("HMO")) {
			ElementData elementData = new ElementData("id", "viewDetailsMA");
			WebElement element = getViewPlanDetailsElement(maPlanElement,
					elementData, planName);
			System.out.println(element.getText());

			if (element != null) {
				element.click();
			}
			System.out.println(driver.getCurrentUrl());
		} else if (planName.contains("PDP")) {
			ElementData elementData = new ElementData("id", "viewDetailsPDP");
			WebElement element = getViewPlanDetailsElement(pdpPlanElement,
					elementData, planName);
			System.out.println(element.getText());
			if (element != null) {
				element.click();
			}
			System.out.println(driver.getCurrentUrl());
		}
		else if (planName.contains("SNP")) {
			ElementData elementData = new ElementData("id", "viewDetailsSNP");
			WebElement element = getViewPlanDetailsElement(snpPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();
			}
		}else if (planName.contains("Regional PPO")) {
			ElementData elementData = new ElementData("id", "viewDetailsMA");
			WebElement element = getViewPlanDetailsElement(maPlanElement,
					elementData, planName);
			if (element != null) {
				element.click();
			}

		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("Title is :"+driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		if (driver.getTitle().equalsIgnoreCase("Medicare Advantage Plan Details | | UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plan Details | UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase("Medicare Prescription Drug Plan Details | UnitedHealthcare®")
				|| driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®")) {
			return new PlanDetailsPage(driver,planName);
		}
		return null;
	}

	private WebElement getViewPlanDetailsElement(
			List<WebElement> maPlanElement2, ElementData elementData,
			String planName) {
		for (WebElement plan : maPlanElement2) {
			if (plan.getText().contains(planName)) {

				WebElement element = findChildElement(elementData,
						plan);

				return element;

			}
		}
		return null;
	}

	public VPPPlanSummaryPage viewPlanSummary(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		} else if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")) {
			showMaPlans.click();
		} else if (planType.equalsIgnoreCase("SNP")) {
			showSnpPlans.click();
		} else {
			showMsPlans.click();
		}
		return new VPPPlanSummaryPage(driver, planType);
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

	@Override
	public void openAndValidate() {
		validate(showMaPlans);
		validate(showMsPlans);
		validate(showPdpPlans);
		validate(showSnpPlans);
		vppPlanSummaryJson = formJsonObject(vppPlanSummary);
	}

	public JSONObject getPlanSummaryActualData(String planName) {
		String fileName = null;
		if (planName.contains("SNP")) {
			fileName = "snpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,snpPlanConatiner);
			return jsonObject;
		}
		else if (planName.contains("HMO") || planName.contains("Regional PPO")) {
			fileName = "maplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,maPlanConatiner);
			return jsonObject;
		}
		else if (planName.contains("PDP")) {
			fileName = "pdpplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,pdpPlanConatiner);
			return jsonObject;
		}else if(planName.contains("Regional PPO"))
		{
			fileName = "mamultistateplansummary.json";
			JSONObject jsonObject = getActualJsonObject(fileName, planName,maPlanConatiner);
			return jsonObject;

		}


		return null;
	}

	private JSONObject getActualJsonObject(String fileName, String planName,
			WebElement planContainer) {

		vppPlanSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		ElementData elementData = new ElementData("className","ng-scope");
		List<WebElement> planElement = findChildElements(elementData, planContainer);
		for (WebElement plan : planElement) {
			if (plan.getText().contains(planName)) {
				JSONObject jsonObject = new JSONObject();
				for (String key : vppPlanSummary.getExpectedData().keySet()) {
					WebElement element = findChildElement(
							vppPlanSummary.getExpectedData().get(key), plan);
					validate(element);
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				return jsonObject;

			}
		}
		return null;

	}

	public String viewplans(String planName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EstimateDrugCostPage navigateToSummaryPage(String planType) {
		if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		} 
		return new EstimateDrugCostPage(driver);
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
			ElementData elementData = new ElementData("id", "editDrugMA");
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
		}else{
			return null;
		}
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
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new GetStartedPage(driver);
		}
		return null;

	}

	public Rallytool_Page clicksOnIsProviderCovered(String planName) {
		if (planName.contains("HMO")) {
			for (WebElement plan : maPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"doctorCoverMA");
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (planName.contains("SNP")) {
			for (WebElement plan : snpPlanElement) {
				if (plan.getText().contains(planName)) {
					ElementData elementData = new ElementData("id",
							"doctorCoverMA"); // TODO Re-check
					findChildElement(elementData, plan).click();
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Welcome")) { 
			return new Rallytool_Page(driver);
		}
		// TODO Auto-generated method stub
		return null;
	}


	public RequestAgentAppointmentPage nagiateToRequetAnAppointmentPage()
	{
		make_an_appointment_agent.click();

		try {
			if (make_an_appointment_agent.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, make_an_appointment_agent,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("make_an_appointment_agent not found");
		} catch (TimeoutException ex) {
			System.out.println("make_an_appointment_agent not found");
		} catch (Exception e) {
			System.out.println("make_an_appointment_agent not found");
		}
		if(currentUrl().contains("medicare-advantage-plans/request-information/agentebrc.html"))
		{
			return new RequestAgentAppointmentPage(driver);
		}

		return null;

	}

	public String togglePlan() {
		String currentYearFlag = "false";
		validate(toggleplanYear);
		if (toggleplanYear != null) {
			toggleplanYear.click();
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

	public  void clicksOnMAProviderCoveredLink()
	{
		MaProviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	/**
	 * This method verifies whether the Compare 3 Plans button is Inactive or NOt
	 */
	public void verifyInactiveCompare3PlansButton(){
		waitforElement(comparePDPPlanChkBox);
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
	public boolean validatepassportData() {
		try {
			Thread.sleep(20000);

			String expectedpassportdata=PassportFlyerPDF.getText();
			String actualpassportdata="Passport Flyer (PDF)";
			if(expectedpassportdata.equalsIgnoreCase(actualpassportdata))
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;

	}
}





