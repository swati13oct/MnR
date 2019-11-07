package acceptancetests.acquisition.tfn;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ulayer.UlayerTFNPage;


public class tfnStepDefinitionUHC {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver wd;
	UlayerTFNPage tfnPage;
	MRScenario mr;


@Given("^user is on UMS Prod and varify TFN$")
public void user_is_on_UMS_Prod_and_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String url = memberAttributesMap.get("URL");
	String amptfn = memberAttributesMap.get("AMPTFN");
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	//wd.manage().deleteAllCookies();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	System.out.println("This is the URL to begin Testing:  "+ url);
	tfnPage.popupCheck();
	String tfn = tfnPage.validateDirectPageTFN();
	if(tfn.equalsIgnoreCase(amptfn)){
		System.out.println("Acqusition Home Page displaying proper number:  "+ tfn );
	}
	else{
		Assert.fail("Error validating plans in  VPP plan summary page");
	}
}

@Then("^user navigate to Medicare Edu and varify TFN on Righ Rail$")
public void user_navigate_to_Medicare_Edu_and_varify_TFN_on_Righ_Rail(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String MedEdTfn = memberAttributesMap.get("Med Ed TFN");
	System.out.println("This is the TFN for Learn About Medicare page from Feature File:  "+MedEdTfn);
	String MedEducationTFN = tfnPage.LrnAbtMedicare_TFN_UHC();
	if(MedEdTfn.equalsIgnoreCase(MedEducationTFN)){
		System.out.println("Learn About Medicare Education Page displaying proper number:  "+ MedEducationTFN );
	}
	else{
		Assert.fail("Error validating TFN in Medicare Education page" + MedEducationTFN );
	}
}

@Then("^user enter zip on bottom of MEd Ed page and click to view MA Plans and varify TFN on Right Rail$")
public void user_enter_zip_on_bottom_of_MEd_Ed_page_and_click_to_view_MA_Plans_and_varify_TFN_on_Right_Rail(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String VPPPageTFN = memberAttributesMap.get("MA Plan TFN");
	System.out.println("This is the TFN for VPP page from Feature File:  "+VPPPageTFN);
	String maVppTfn = tfnPage.VppPageTFN_UHC();
	if(VPPPageTFN.equalsIgnoreCase(maVppTfn)){
		System.out.println(" VPP Page displaying proper number:  "+ maVppTfn );
	}
	else{
		Assert.fail("Error validating TFN in  VPP plan summary page" + maVppTfn );
	}
}

@Then("^user varifies Med Sup tab TFN$")
public void user_varifies_Med_Sup_tab_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String MedSupTFN = memberAttributesMap.get("Med Sup TFN");
	System.out.println("This is the TFN for Med Sup page from Feature File:  "+MedSupTFN);
	String medSupTfn_UI = tfnPage.MedSupTFN_UHC();
	if(MedSupTFN.equalsIgnoreCase(medSupTfn_UI)){
		System.out.println(" Med Sup Page displaying proper number:  "+ medSupTfn_UI );
	}
	else{
		Assert.fail("Error validating TFN in  Med Sup page" + medSupTfn_UI );
	}
}

@Then("^user varifies PDP Tab TFN$")
public void user_varifies_PDP_Tab_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String PDPtabTFN = memberAttributesMap.get("PDP TFN");
	System.out.println("This is the TFN for PDP page from Feature File:  "+PDPtabTFN);
	String pdpTFN_UI = tfnPage.PDPTFN_UHC();
	if(PDPtabTFN.equalsIgnoreCase(pdpTFN_UI)){
		System.out.println(" PDP Page displaying proper number:  "+ pdpTFN_UI );
	}
	else{
		Assert.fail("Error validating TFN in  PDP page" + pdpTFN_UI );
	}
}

@Then("^user click the View plan and drug coverage details button for any PDP Plan and Click the Enroll in plan button to varify TFN$")
public void user_click_the_View_plan_and_drug_coverage_details_button_for_any_PDP_Plan_and_Click_the_Enroll_in_plan_button_to_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String PDPtabTFN = memberAttributesMap.get("PDP TFN");
	System.out.println("This is the TFN for PDP Plan and Drug Covrg from Feature File:  "+PDPtabTFN);
	String pdpTFN_UI = tfnPage.PDPDrugCvrgTFN_UHC();
	if(PDPtabTFN.equalsIgnoreCase(pdpTFN_UI)){
		System.out.println(" PDP Plan and Drug cvrg displaying proper number:  "+ pdpTFN_UI );
	}
	else{
		Assert.fail("Error validating TFN in PDP Plan and Drug cvrg page" + pdpTFN_UI );
	}
}

@Then("^user Verify the Right Rail TFN on PDP OLE$")
public void user_Verify_the_Right_Rail_TFN_on_PDP_OLE(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String PDPtabTFN = memberAttributesMap.get("PDP TFN");
	System.out.println("This is the TFN for PDP OLE Page from Feature File:  "+PDPtabTFN);
	String pdpTFN_UI = tfnPage.PDPOleTFN_UHC();
	if(PDPtabTFN.equalsIgnoreCase(pdpTFN_UI)){
		System.out.println(" PDP OLE Page displaying proper number:  "+ pdpTFN_UI );
	}
	else{
		Assert.fail("Error validating TFN in PDP OLE page" + pdpTFN_UI );
	}
}
	
@Given("^user is on Google and search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN$")
public void user_is_on_Google_and_search_UHC_Medicare_Advantage_Plan_to_navigate_to_AMP_page_and_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String url = memberAttributesMap.get("URL");
	String tfn = memberAttributesMap.get("AMPTFN");
	System.out.println("this is the Acquisition Home page TFN from Feature file: " + tfn);
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	String hometfn = tfnPage.googleSearchUHC_2();
	System.out.println("I am here checking pop up for 30 sec .......");
	//tfnPage.popupCheck();
	System.out.println("this is the TFN for Acqusition Home page from UI  "+hometfn);
	if(tfn.equalsIgnoreCase(hometfn)){
		System.out.println("Acqusition Home Page displaying correct number  "+hometfn);
	}
	else{
		Assert.fail("TFN Displayed did not Match expected TFN in Acqusition homepage " + hometfn);
	}	
}
@Then("^user navigate to MedSup from Google to varify TFN$")
public void user_navigate_to_MedSup_from_Google_to_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	String medsuptfn = tfnPage.medicalSupTFN_UHC_3();
	System.out.println("This is the TFN on Med Sup Page displayed on UI:  "+medsuptfn);
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}

@Given("^user is on Bing and search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN$")
public void user_is_on_Bing_and_search_UHC_Medicare_Advantage_Plan_to_navigate_to_AMP_page_and_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String url = memberAttributesMap.get("URL");
	String tfn = memberAttributesMap.get("AMPTFN");
	System.out.println("this is the Acquisition Home page TFN from Feature file: " + tfn);
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	String hometfn = tfnPage.bingSearchUHC();
	System.out.println("this is the TFN for Acqusition Home page from UI  "+hometfn);
	if(tfn.equalsIgnoreCase(hometfn)){
		System.out.println("Acqusition Home Page displaying correct number  "+hometfn);
	}
	else{
		Assert.fail("Error validating TFN in  Acqusition homepage TFN  " + hometfn);
	}	
}

@Then("^user navigate to MedSup from Bing to varify TFN$")
public void user_navigate_to_MedSup_from_Bing_to_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.popupCheck();
	String medsuptfn = tfnPage.medicalSupTFN_UHC_3();
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}

@Then("^user navigate to PDP to varify  TFN via Bing$")
public void user_navigate_to_PDP_to_varify_TFN_via_Bing(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String PDPtfn = memberAttributesMap.get("PDP TFN");
	System.out.println("This is the TFN for PDP page from Feature file:  "+PDPtfn);
	tfnPage = new UlayerTFNPage(wd);
	String pdptfn_UI = tfnPage.PDPTFN_UHC_via_bing();
	if(pdptfn_UI.equalsIgnoreCase(PDPtfn)){
		System.out.println("PDP TAB displaying correct TFN on UI  "+pdptfn_UI);
	}
	else{
		Assert.fail("PDP TAB TFN is not displaying the right number  "+ pdptfn_UI);
	}
}

@Given("^user visits UMS site using Direct URL and varify TFN$")
public void user_visits_UMS_site_using_Direct_URL_and_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String url = memberAttributesMap.get("URL");
	String tfn = memberAttributesMap.get("AMPTFN");
	System.out.println("this is the Acqusition home page TFN from Feature file: " + tfn);
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	tfnPage.popupCheck();
	String hometfn = tfnPage.validateAMPPageTFN_UHC();
	if(tfn.equalsIgnoreCase(hometfn)){
		System.out.println("Home Page displaying proper number");
	}
	else{
		Assert.fail("Error validating plans in  Acqusition homepage TFN");
	}
}
	
@Then("^user navigate to MedSup from Direct url to varify TFN$")
public void user_navigate_to_MedSup_from_direct_to_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	String medsuptfn = tfnPage.medicalSupTFN_UHC_2();
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}	
	

@Given("^user visits UMS using  specific URL and varify TFN$")
public void user_visits_UMS_using_specific_URL_and_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String url = memberAttributesMap.get("URL");
	String tfn = memberAttributesMap.get("AMPTFN");
	System.out.println("this is TFn for Acquisition home Page from Feature file: " + tfn);
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	//tfnPage.popupCheck();
	String hometfn = tfnPage.validateAMPPageTFN_UHC_campaignLink();
	if(tfn.equalsIgnoreCase(hometfn)){
		System.out.println("TFN on MA Tab is displaying correct number:  "+ hometfn);
	}
	else{
		Assert.fail("MA tab not displaying correct number"+ hometfn);
	}
}

@Then("^navigate to MedSup to varify TFN from specific UMS url$")
public void navigate_to_MedSup_to_varify_TFN_from_specific_UMS_url(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	String medsuptfn = tfnPage.medicalSupTFN_UHC_3();
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}	

@Given("^user is landing on UHC via campaign url$")
public void user_is_landing_on_UHC_via_campaign_url(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String url = memberAttributesMap.get("URL");
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	//tfnPage.popupCheck();	
}

@Then("^user navigates to MA VPP tab to vaify TFN$")
public void user_navigates_to_MA_VPP_tab_to_vaify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String maVPPTabTFN = memberAttributesMap.get("MA TFN");
	System.out.println("This is the TFN for MA Tab Right Rail TFN from Feature file:  "+maVPPTabTFN);
	tfnPage = new UlayerTFNPage(wd);
	String maVPPTabTFN_UI = tfnPage.ma_VPP_TFN_UHC();
	if(maVPPTabTFN_UI.equalsIgnoreCase(maVPPTabTFN)){
		System.out.println("MA TAB displaying correct TFN on UI  "+maVPPTabTFN_UI);
	}
	else{
		Assert.fail("MA Tab TFN is not displaying the right number  "+ maVPPTabTFN_UI);
	}
}
@Then("^user navigates to MA VPP tab to vaify TFN from this specific url$")
public void user_navigates_to_MA_VPP_tab_to_vaify_TFN_from_this_specific_url(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String maVPPTabTFN = memberAttributesMap.get("MA TFN");
	System.out.println("This is the TFN for MA Tab Right Rail TFN from Feature file:  "+maVPPTabTFN);
	tfnPage = new UlayerTFNPage(wd);
	String maVPPTabTFN_UI = tfnPage.ma_VPP_TFN_UHC_2();
	if(maVPPTabTFN_UI.equalsIgnoreCase(maVPPTabTFN)){
		System.out.println("MA TAB displaying correct TFN on UI  "+maVPPTabTFN_UI);
	}
	else{
		Assert.fail("MA Tab TFN is not displaying the right number  "+ maVPPTabTFN_UI);
	}
}

@Then("^user varifies Med Sup tab TFN from this specific url$")
public void user_varifies_Med_Sup_tab_TFN_from_this_specific_url(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("Med Sup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	String medsuptfn = tfnPage.medicalSupTFN_UHC_4();
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}
@Given("^user is on Google  search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN$")
public void user_is_on_Google_search_UHC_Medicare_Advantage_Plan_to_navigate_to_AMP_page_and_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String tfn = memberAttributesMap.get("AMPTFN");
	String url = memberAttributesMap.get("URL");
	mr = new MRScenario();
	wd = mr.getWebDriverNew();
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	String hometfn = tfnPage.googleSearchUHC_1();
	System.out.println("this is from Acq Home Page UI  "+hometfn);
	
	if(tfn.equalsIgnoreCase(hometfn)){
		System.out.println("Home Page displaying proper number");
	}
	else{
		Assert.fail("Error validating plans in  Acqusition homepage TFN");
	}
	
}


@Then("^navigate from Google via uhc site to MedSup to varify TFN$")
public void navigate_from_Google_via_uhc_site_to_MedSup_to_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	String medsuptfn = tfnPage.medicalSupTFN_UHC_5();
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}

@Given("^user is on Yahoo search UHC Medicare Advantage Plan to navigate to AMP page and varify TFN$")
public void user_is_on_Yahoo_search_UHC_Medicare_Advantage_Plan_to_navigate_to_AMP_page_and_varify_TFN(DataTable givenAttributes) throws Throwable {
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
	tfnPage = new UlayerTFNPage(wd);
	tfnPage.openUrl(url);
	String hometfn = tfnPage.YahooSearchUHC();
	System.out.println("I am here after yahoo search");
	System.out.println("This TFN number is from Acqusition Home Page UI:  "+ hometfn);
	if(tfn.equalsIgnoreCase(hometfn)){
		System.out.println("Home Page displaying proper number");
	}
	else{
		Assert.fail("Error validating plans in  Acqusition homepage TFN");
	}
	
}

@Then("^navigate from yahoo via uhc site to MedSup to varify TFN$")
public void navigate_from_yahoo_via_uhc_site_to_MedSup_to_varify_TFN(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
				memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalsuptfn = memberAttributesMap.get("MedSup TFN");
	System.out.println("This is the TFN for MedSup page from Feature file:  "+medicalsuptfn);
	tfnPage = new UlayerTFNPage(wd);
	String medsuptfn = tfnPage.medicalSupTFN_UHC_3();
	if(medsuptfn.equalsIgnoreCase(medicalsuptfn)){
		System.out.println("Med Sup TAB displaying correct TFN on UI  "+medsuptfn);
	}
	else{
		Assert.fail("Med Sup TFN is not displaying the right number  "+ medsuptfn);
	}
}





}
