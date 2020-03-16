package acceptancetests.acquisition.tfn;

/**
 * @author Tamzid
 *
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.GlobalWebElements;
import pages.acquisition.ulayer.UlayerTFNPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class tfnStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver wd;
	AcquisitionHomePage acqHomePage;
	UlayerTFNPage tfnPage;
	MRScenario mr;
	
	
	@Given("^the user is on AARP medicare acquisition site page$")
	public void the_user_on_aarp_medicaresolutions_Site(DataTable givenAttributes) throws Exception {
		
			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}
			String url = memberAttributesMap.get("URL");
			String amptfn = memberAttributesMap.get("TFN Number MA");
			mr = new MRScenario();
			wd = mr.getWebDriverNew();
			tfnPage = new UlayerTFNPage(wd);
			tfnPage.openUrl(url);
			System.out.println(url);
			//tfnPage.popupCheck();
		
			String tfn = tfnPage.validateDirectPageTFN();
			if(tfn.equalsIgnoreCase(amptfn)){
				System.out.println("MA Tab displaying proper number");
				getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, tfnPage);
			}
			else{
				Assert.fail("Error validating TFN in  VPP plan summary page");
			}


		}

	@Then("^click to view MA plans in VPP to varify the TFN$")
	public void click_to_view_MA_plans_in_VPP_to_varify_the_TFN(DataTable givenAttributes) throws Exception {

		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}	
		 tfnPage = new UlayerTFNPage(wd);
		String tfnNumber = memberAttributesMap.get("TFN Number MA");
		tfnPage.navigateToVPPpage();
		String tfn = tfnPage.validateMAtabTFN();
		tfnPage.checkModelPopup(wd,10);
		if( tfn.equalsIgnoreCase(tfnNumber)){
			System.out.println("MA Tab displaying correct TFN");
		}
		else{
			Assert.fail("TFN in  VPP plan summary page DID NOT Match");
		}	
	}
	

	@Then("^Navigate to Medicare Education to varify TFN for AMP version$")
	public void navigate_to_Medicare_Education_to_varify_TFN_for_AMP_version() throws Exception{
		 tfnPage = new UlayerTFNPage(wd);
		 tfnPage.learnAboutMedicareLink.click();
		if(tfnPage.learnAboutmedicareTFN()==true){
			System.out.println("TFN displaying properly on Learn abot medicare page");
		} else {
			Assert.fail("TFN not displaying proper number/ or didnt dislay at all");
		}
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

	}

	@Then("^Navigate back to VPP and select MEdSup tab to varify TFN in right rail Display$")
	public void navigate_back_to_VPP_and_select_MEdSup_tab_to_varify_TFN_in_right_rail_Display() throws Exception{
		tfnPage = new UlayerTFNPage(wd);
		if(tfnPage.MedSupTFN()==true){
			System.out.println("TFN displaying properly on Med Sup Right Rail ");
		} else {
			Assert.fail("TFN not displaying proper number/ or didnt dislay at all");
		}
	}

	@Then("^Navigate back to VPP and select PDP tab to varify TFN$")
	public void navigate_back_to_VPP_and_select_PDP_tab_to_varify_TFN() throws Throwable {
		tfnPage = new UlayerTFNPage(wd);
		if(tfnPage.PDPTFN()==true){
			System.out.println("TFN displaying properly on PDP Right Rail ");
		} else {
			Assert.fail("TFN not displaying proper number/ or didnt dislay at all");
		}
	}

	@Then("^click plan and drug coverage button for any PDP plan to varify TFN$")
	public void click_plan_and_drug_coverage_button_for_any_PDP_plan_to_varify_TFN() throws Exception {
		tfnPage = new UlayerTFNPage(wd);
		if(tfnPage.PDPplanDrugCvrg()==true){
			System.out.println("TFN displaying properly on PDP Plancand Drug coverafe Right Rail ");
		} else {
			Assert.fail("TFN not displaying proper number/ or didnt dislay at all");
		}
		
	}

	@Then("^varify the right rail Display of TFN on PDP OLE$")
	public void varify_the_right_rail_Display_of_TFN_on_PDP_OLE() throws Throwable {
		tfnPage = new UlayerTFNPage(wd);
		if(tfnPage.PdpOleTFN()==true){
			System.out.println("TFN displaying properly on PDP Plancand Drug coverafe Right Rail ");
		} else {
			Assert.fail("TFN not displaying proper number/ or didnt dislay at all");
		}
	}
	
	//***********************************************************************************************************************************************************************
	
	
	@Given("^the user navigating from Campaign Landing Page$")

	public void the_user_navigating_from_Campaign_Landing_Page(){


		wd = getLoginScenario().getWebDriverNew();
		wd.get("https://ma.aarpmedicareplans.com/?wt.mc_id=8001038");
		wd.findElement(By.xpath("//*[@id='button-530621114']")).click();
		// switchToNewTab();

		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE, aquisitionhomepage);

	}

	@When("^the user go to plan search in the AARP site$")
	public void the_user_go_to_plan_search(){
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);

		//for(String winHandle : wd.getWindowHandles()){
		//wd.switchTo().window(winHandle);
		wd.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("90210");
		wd.findElement(By.xpath("//*[@id='globalContentIdForSkipLink']/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div/div[2]/form/div/button")).click();

		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);	
		getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, plansummaryPage);

	}
	@Given("^user visits AMP using Direct URL and varify TFN$")
	public void user_visits_AMP_using_Direct_URL_and_varify_TFN(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String url = memberAttributesMap.get("URL");
		String amptfn = memberAttributesMap.get("AMPTFN");
		System.out.println("this is the Expected MA-TAB TFN from Feature file: " + amptfn);
		mr = new MRScenario();
		wd = mr.getWebDriverNew();
		wd.manage().deleteAllCookies();
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.openUrl(url);
		System.out.println(url);
		String tfn = tfnPage.validateDirectPageTFN();
		if(tfn.equalsIgnoreCase(amptfn)){
			System.out.println("MA-Tab displaying Correct TFN number");
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, tfnPage);
		}
		else{
			Assert.fail("MA-TAB Page TFN Did Not Match the Expected TFN");
		}


	}


	@Then("^navigate to MedSup to varify TFN$")
	public void navigate_to_MedSup_to_varify_TFN(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		tfnPage = (UlayerTFNPage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String medsuptfn = tfnPage.medicalSupTFN_direct_2();
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med sub Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("Med Sup Page TFN did not Match Expected TFN");
		}
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@Then("^navigate to MedSup to varify TFN from direct url$")
	public void navigate_to_MedSup_from_direct_to_varify_TFN(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		tfnPage = (UlayerTFNPage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String medsuptfn = tfnPage.medicalSupTFN();
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med sub Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("Med Sup Page TFN did not Match Expected TFN");
		}
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	
	@Then("^navigate from google search to MedSup to varify TFN$")
	public void navigate_to_google_MedSup_to_varify_TFN(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		tfnPage = (UlayerTFNPage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String medsuptfn = tfnPage.medicalSupTFN_direct_2();
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med sub Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("Med Sup Page TFN did not Match Expected TFN");
		}
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@Then("^close and reopen browser$")
	public void user_close_the_browser() {
		System.out.println("closed and reopened");
	}
	
	@Given("^user is on Google and search AARP Medicare Advantage Plan to navigate to AMP page and varify TFN$")
	public void user_is_on_Google_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AMP_page_and_varify_TFN(DataTable givenAttributes) throws Exception  {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String url = memberAttributesMap.get("URL");
		String tfn = memberAttributesMap.get("AMPTFN");
		System.out.println("this is the number from Feature file: " + tfn);
		mr = new MRScenario();
		wd = mr.getWebDriverNew();
		//wd.manage().deleteAllCookies();
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.openUrl(url);
		String hometfn = tfnPage.googleSearchAARP();
		System.out.println("I am here");
		//String hometfn = wd.findElement(By.xpath("//*[contains(@class,'tel')]")).getText().trim();
		System.out.println("this is from UI"+hometfn);
		
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("Home Page displaying proper number");
		}
		else{
			Assert.fail("Error validating plans in  Acqusition homepage TFN");
		}
		
	}
	@Then("^navigate to MedSup to varify TFN from Google$")
	public void navigate_to_MedSup_to_varify_TFN_from_Google(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");

		tfnPage = new UlayerTFNPage(wd);
		String medsuptfn = tfnPage.medicalSupTFNfromGoogle();
		
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med Sup Tab displaying correct number");
		}
		else{
			Assert.fail("Error validating plans in  VPP plan summary page");
		}
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

	}
	@Given("^user visits AMP using  specific URL and varify TFN$")
	public void user_visits_AMP_using_specific_URL_and_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String url = memberAttributesMap.get("URL");
		String tfn = memberAttributesMap.get("AMPTFN");
		System.out.println("this is the number from Feature file: " + tfn);
		mr = new MRScenario();
		wd = mr.getWebDriverNew();
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.openUrl(url);
		tfnPage.popupCheck();
		String hometfn = tfnPage.validateDeepLinkPageTFN();
		//String hometfn = tfnPage.validateDirectPageTFN();
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("Home Page displaying proper number");
		}
		else{
			Assert.fail("Error validating plans in  Acqusition homepage TFN");
		}
	}
	
	@Then("^navigate to MedSup to varify TFN from specific url$")
	public void navigate_to_MedSup_to_varify_TFN_from_specific_url(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		tfnPage = new UlayerTFNPage(wd);
		String medsuptfn = tfnPage.medicalSupTFN_FromDeepLink1();
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("MedSup Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("Med Sup Page TFN did not Match Expected TFN ");
		}
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@Then("^user is on Google and search AARP Medicare Advantage Plan to navigate to AMP page to view the same TFN  and varify$")
	public void user_is_on_Google_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AMP_page_to_view_the_same_TFN_as_step_and_varify_TFN(DataTable givenAttributes) throws Exception  {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String tfn = memberAttributesMap.get("AMPTFN");
		System.out.println("this is the Expected MA-TAB TFN from Feature file: " + tfn);
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.reopenGoogle();
		String hometfn = tfnPage.googleSearchAARP();
		System.out.println("I am here after google search completed and returning me TFN from UI on MA-TAB");
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("MA-Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("MA-TAB Page TFN did not Match Expected TFN");
		}

	}
	
	@Then("^user is on Google and navigate to  AMP page to view the same TFN  and varify$")
	public void user_is_on_Google_navigate_to_AMP_page_to_view_the_same_TFN_as_step_and_varify_TFN(DataTable givenAttributes) throws Exception  {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String tfn = memberAttributesMap.get("AMPTFN Google");
		System.out.println("this is the Expected MA-TAB TFN from Feature file: " + tfn);
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.reopenGoogle();
		String hometfn = tfnPage.googleSearchAARP();
		System.out.println("I am here after google search complted and returned TFN from MA Tab");
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("MA-Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("MA-TAB Page TFN did not Match Expected TFN");
		}
		
	}
	
	@Then("^user visits AMP using  amp url and varify TFN$")
	public void user_visits_AMP_using_amp_URL_and_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String url = memberAttributesMap.get("URL");
		String tfn = memberAttributesMap.get("AMPTFN");
		System.out.println("this is the number from Feature file: " + tfn);
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.reopenAMPPage(url);
		String hometfn = tfnPage.validateAMPPageTFN();
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("Home Page displaying proper number");
		}
		else{
			Assert.fail("Error validating plans in  Acqusition homepage TFN");
		}
	}
	
	@Then("^user visits AMP using  amp url and varify TFN without clearing cache$")
	public void user_visits_AMP_using_amp_URL_and_varify_TFN_without_clearing_cache(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String url = memberAttributesMap.get("URL");
		String tfn = memberAttributesMap.get("AMPTFN");
		System.out.println("this is the Expected MA-TAB TFN from Feature file: " + tfn);
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.reopenAMPPage(url);
		String hometfn = tfnPage.validateAMPPageTFN();
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("MA-Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("MA-TAB Page TFN did not Match Expected TFN");
		}
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	@Then("^without clear cache navigate to MedSup  to varify TFN$")
	public void navigate_to_MedSup_to_varify_TFN_no_clear_cache(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		tfnPage = new UlayerTFNPage(wd);
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		String medsuptfn = tfnPage.medicalSupTFN_direct_2();
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med sub Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("Med Sup Page TFN did not Match Expected TFN");
		}
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@Then("^without clear cache navigate from google to MedSup  to varify TFN$")
	public void navigate_to_MedSup_to_varify_TFN_no_clear_cache_from_google(DataTable givenAttributes) throws Exception {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		tfnPage = new UlayerTFNPage(wd);
		String medsuptfn = tfnPage.medicalSupTFN_direct_2();
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med sub Tab displaying Correct TFN number");
		}
		else{
			Assert.fail("Med Sup Page TFN did not Match Expected TFN");
		}
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}
	
	@Then("^user will go to MedSup page to varify TFN$")
	public void user_will_go_to_MedSup_page_to_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		System.out.println("this is the Expected MedSUp-TAB TFN from Feature file: " + medicalsuptfn);
		 tfnPage = new UlayerTFNPage(wd);
		 String medsuptfn = tfnPage.medicalSupTFN_2();
		 if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
				System.out.println("MedSup Page displaying proper number "+ medsuptfn );
			}
			else{
				Assert.fail("TFN did not match in  MedSup plan summary page");
			}
	}

	@Then("^visit amp using direct url$")
	public void visit_amp_using_direct_url(DataTable givenAttributes) throws Exception  {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String url = memberAttributesMap.get("URL");
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.reopenAMPPage(url);
		tfnPage.popupCheck();
		
	}

	@Given("^user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AMP page and varify TFN$")
	public void user_is_on_Yahoo_and_search_AARP_Medicare_Advantage_Plan_to_navigate_to_AMP_page_and_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String url = memberAttributesMap.get("URL");
		String tfn = memberAttributesMap.get("AMPTFN");
		System.out.println("This is the Expected number for Acquisition Home Page from Feature file: " + tfn);
		mr = new MRScenario();
		wd = mr.getWebDriverNew();
		//wd.manage().deleteAllCookies();
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.openUrl(url);
		String hometfn = tfnPage.YahooSearchAARP();
		System.out.println("I am here after yahoo search");
		System.out.println("This TFN number is from Acqusition Home Page UI:  "+ hometfn);
		if(tfn.equalsIgnoreCase(hometfn)){
			System.out.println("Home Page displaying proper number");
		}
		else{
			Assert.fail("Error validating plans in  Acqusition homepage TFN");
		}
		
	}

	@Then("^navigate to MedSup to varify TFN from Yahoo$")
	public void navigate_to_MedSup_to_varify_TFN_from_Yahoo(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");

		tfnPage = new UlayerTFNPage(wd);
		String medsuptfn = tfnPage.medicalSupTFN();
		
		if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
			System.out.println("Med Sup Page is displaying the correct number:  "+ medsuptfn);
		}
		else{
			Assert.fail("Error validating plans in  VPP plan summary page");
		}
	}
	
	@Given("^user is on campaign url and varify TFN$")
	public void user_is_on_campaign_url_and_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));		}
		String url = memberAttributesMap.get("URL");
		
		
		mr = new MRScenario();
		wd = mr.getWebDriverNew();
		tfnPage = new UlayerTFNPage(wd);
		tfnPage.openUrl(url);
		//tfnPage.popupCheck();
	}

	@Then("^click eligibility to check TFN on eligibility page$")
	public void click_eligibility_to_check_TFN_on_eligibility_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String medicaleligibilityTFN = memberAttributesMap.get("Eligiblity TFN");
		System.out.println("This is the TFN for Eligiblity page from feature file:  "+medicaleligibilityTFN);
		 tfnPage = new UlayerTFNPage(wd);
		 String eligibiltyTFN = tfnPage.medEligibilityTFN();
		 if(medicaleligibilityTFN.equalsIgnoreCase(eligibiltyTFN)){
				System.out.println("Medical Eligibility  Page displaying proper number "+ eligibiltyTFN );
			}
			else{
				Assert.fail("TFN did not match in Medical Eligibility page "+ eligibiltyTFN);
			}
	}

	@Then("^enter zipcode to check TFn on ma vpp page$")
	public void enter_zipcode_to_check_TFn_on_ma_vpp_page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		String maVPPTFN = memberAttributesMap.get("MA VPP TFN");
		tfnPage = new UlayerTFNPage(wd);
		String maTFN = tfnPage.maVPPPageTFN();
		if(maVPPTFN.equalsIgnoreCase(maTFN)){
			System.out.println("MA Tab displaying proper number:  "+maTFN);
		}
		else{
			Assert.fail("TFN did not match in  VPP plan summary page"+ maTFN);
		}
	}
	@Then("^navigate to MedSup via direct url towards med sup to varify TFN$")
	public void user_will_go_to_MedSup_page_via_directUrl_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		 tfnPage = new UlayerTFNPage(wd);
		 String medsuptfn = tfnPage.medicalSupTFN();
		 if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
				System.out.println("MedSup Page displaying proper number "+ medsuptfn );
				Thread.sleep(15000);
			}
			else{
				Assert.fail("TFN did not match in  MedSup plan summary page");
			}
	}
	
	@Then("^coming from dircet url and navigate to medsup to varify TFN$")
	public void coming_from_dircet_url_and_navigate_to_medsup_to_varify_TFN(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}
		String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
		 tfnPage = new UlayerTFNPage(wd);
		 String medsuptfn = tfnPage.medicalSupTFN();
		 if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
				System.out.println("MedSup Page displaying proper number "+ medsuptfn );
				Thread.sleep(15000);
			}
			else{
				Assert.fail("TFN did not match in  MedSup plan summary page");
			}
	}
}

	
	
	
	
	
	
	
	
	
	
	
