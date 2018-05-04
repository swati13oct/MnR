
       package acceptancetests.memberredesign.formsandresources;

       import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import junit.framework.Assert;
import pages.dashboard.formsandresources.FormsAndResourcesPage;
import pages.member.redesign.NewLoginPage;
import pages.member.ulayer.RallyDashboard;

       /**
       * @author 
        *
       */

       public class DashboardFormsnResourcesStepDefinition {

              
              @Autowired
              MRScenario loginScenario;

              public MRScenario getLoginScenario() {
                     return loginScenario;
              }
              
              @Given("^details of user to sign in on member redesign site to see forms and resources page$")
                  public void details_of_user_for_member_redesign_site(DataTable givenAttributes) throws InterruptedException {
                     // get test variables
                     List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                     Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                     for (int i = 0; i < memberAttributesRow.size(); i++) {
                         memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                     }

                     // extract relevant field data from test variable parameters
                     String userId = memberAttributesMap.get("userId");
                     String password = memberAttributesMap.get("password");

                     // init Web Driver
                     WebDriver wd = loginScenario.getWebDriver();
                     loginScenario.saveBean(CommonConstants.WEBDRIVER, wd);

                       
                     // create Sign In context
                     NewLoginPage newLoginPage = new NewLoginPage(wd);
                     getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
                     

                     // authenticate
                     RallyDashboard rallydashboardpage = (RallyDashboard) newLoginPage.loginWith(userId, password);
                     loginScenario.saveBean(PageConstants.RALLY_DASHBOARDPAGE, rallydashboardpage);
                  }
              
                              
                             
                              @And("^click on the forms and resource link and navigate to forms and resource page$")
                              public void clickOnFormAndResourcesLink() throws InterruptedException {
                                   RallyDashboard rallydashboardpage = (RallyDashboard) loginScenario.getBean(PageConstants.RALLY_DASHBOARDPAGE);
                                              Thread.sleep(5000);
                                  FormsAndResourcesPage formsAndResourcesPage = rallydashboardpage.navigatetoFormsnResources();     
                                  getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
                                              
                              }
                              
                              @SuppressWarnings("deprecation")
                              @And("^validate EOB section$")
                              public void validateEOBSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              String eobMedicalLink = memberAttributesMap.get("EOB_MEDICAL_LINK");
                                              String eobDrugLink = memberAttributesMap.get("EOB_DRUG_LINK");
                                              try {
                                                              Thread.sleep(50000);
                                              } catch (InterruptedException e) {
                                                              e.printStackTrace();
                                              }
                                              
                                              String isEOBMedicalButtonVisible = isButtonVisible(formsAndResourcesPage.getEOBMedicaButton()) ?"YES": "NO";
                                              String isEOBDrugButtonVisible =  isButtonVisible(formsAndResourcesPage.getEOBDrugButton()) ?"YES": "NO";
                                              Assert.assertEquals(eobMedicalLink, isEOBMedicalButtonVisible);
                                              Assert.assertEquals(eobDrugLink, isEOBDrugButtonVisible);
                                              
                              }
                              
                              @SuppressWarnings("deprecation")
                              @And("^validate my document section$")
                              public void validateMyDocumentSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              
                                              String myDocumentSection = memberAttributesMap.get("MY_DOCUMENT_SECTION");
                                              String isMyDocumentVisible = isButtonVisible(formsAndResourcesPage.getMyDocumentSection()) ?"YES": "NO";
                                              Assert.assertEquals(myDocumentSection, isMyDocumentVisible);
                              }

                              @SuppressWarnings("deprecation")
                              @And("^validate renew magazine section$")
                              public void validateRenewMagazineSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              String renewMagazine = memberAttributesMap.get("RENEW_MAGAZINE_SECTION");
                                              String isRenewMagazineVisible = isButtonVisible(formsAndResourcesPage.getRenewMagazineSection()) ?"YES": "NO";
                                              Assert.assertEquals(renewMagazine, isRenewMagazineVisible);
                                              
                              }
                              
                              @Then("^validate plan materials section$")
                              public void validatePlanMaterialSection() {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              formsAndResourcesPage.getplanmaterialsection().isDisplayed();
                                              
                                              
                              }
                              
                              @And("^click on the order plan materials and view temporary id card link$")
                              public void clicklinksonplanmaterials() throws InterruptedException  {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              formsAndResourcesPage.getOrderPlanMaterialLink().isDisplayed();
                                              Thread.sleep(2000);
                                              formsAndResourcesPage.validatenclickOrderPlanMaterial();
                                         
                                              formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();
                                              Thread.sleep(1000);
                                              formsAndResourcesPage.validatenclickIDCard();
                                              
                              }
                              
                              @Then("^validate that english is default language in dropdown$")
                              public void validatelanguage() {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              
                                              formsAndResourcesPage.validateEngDefault();
                              }
                              
                              @Then("^validate the anoc section$")
                              public void validateAnocSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              String  anocsection = memberAttributesMap.get("ANOC_SECTION");
                                              String isANOCSECTIONVisible = isButtonVisible(formsAndResourcesPage.getANOCSection()) ?"YES": "NO";
                                              Assert.assertEquals(anocsection, isANOCSECTIONVisible);
                                              
                              }
                              
                             @And("^change the language in the language dropdown$")
                              public void changelanguage() throws InterruptedException {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              formsAndResourcesPage.changelanguage();
                                             
                              }
                
                              @Then("^validate the annual directories section$")
                              public void validatePlanMaterialSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              String AnnualDirectoriesSection = memberAttributesMap.get("ANNUAL_DIRECTORIES_SECTION");
                                              String providersearchLink = memberAttributesMap.get("PROVIDER_SEARCHLINK");
                                              String pharmacylocatorLink = memberAttributesMap.get("PHARMACY_SEARCHLINK");
                                              try {
                                                              Thread.sleep(50000);
                                              } catch (InterruptedException e) {
                                                              e.printStackTrace();
                                              }
                                              
                                              String isPharmacyLocatorLinkVisible = isButtonVisible(formsAndResourcesPage.getpharmacysearchlink()) ?"YES": "NO";
                                              String isproviderSearchVisible =  isButtonVisible(formsAndResourcesPage.getprovisesearchlink()) ?"YES": "NO";
                                              Assert.assertEquals(providersearchLink, isproviderSearchVisible);
                                              Assert.assertEquals(pharmacylocatorLink, isPharmacyLocatorLinkVisible);
                                             
                                              String isannualdirectoryVisible = isButtonVisible(formsAndResourcesPage.getAnnualDirectorySection()) ?"YES": "NO";
                                              Assert.assertEquals(AnnualDirectoriesSection, isannualdirectoryVisible);
                                              
                              }
                              
                              @And("^validate that the forms and resources section is displayed$")
                              public void validateFNRSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              String formsandresourcesection = memberAttributesMap.get("FORMS_N_RESOURCES");
                                              String isfnrsectionVisible = isButtonVisible(formsAndResourcesPage.getFormsandResourcesSection()) ?"YES": "NO";
                                              Assert.assertEquals(formsandresourcesection, isfnrsectionVisible);
                                              
                              }
                              
                              private boolean isButtonVisible(WebElement button){
                                              try{
                                                              if(button.isDisplayed()){
                                                                              return true;
                                                              }
                                              }catch(NoSuchElementException noSuchElementException){
                                                              return false;
                                              }
                                              return false;
                                              
                              }

                              
                              

              }


       
