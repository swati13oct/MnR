
       package acceptancetests.memberredesign.formsandresources;

       import gherkin.formatter.model.DataTableRow;

       import java.util.LinkedHashMap;
       import java.util.List;
       import java.util.Map;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pages.dashboard.acquisition.RegistrationInformationPage;
import pages.dashboard.formsandresources.FormsAndResourcesPage;
import pages.member.redesign.NewLoginPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.RallyDashboard;
import atdd.framework.*;
       import acceptancetests.data.CommonConstants;
       import acceptancetests.data.PageConstants;
       import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * @Functionality : Forms and resources page navigation from dashboard and sections validation
 */


       public class DashboardFormsnResourcesStepDefinition {

              
              @Autowired
              MRScenario loginScenario;

              public MRScenario getLoginScenario() {
                     return loginScenario;
              }
              /**
               * @toDo : user logs in
               */
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
                    
                     
                     newLoginPage.navigateToNewDashboardUrls();
                     getLoginScenario().saveBean(PageConstants.NEW_LOGIN_PAGE, newLoginPage);
                     RallyDashboard rallydashboardpage = (RallyDashboard) newLoginPage.loginWith(userId, password);
        			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        			getLoginScenario().saveBean(PageConstants.RALLY_DASHBOARDPAGE,rallydashboardpage);
                     

                   
              }
              
                              
              /**
               * @toDo : navigation to the forms and resources page from dashboard for terminated member
               */
                              @And("^click on the forms and resource link and navigate to forms and resource page for terminated member$")
                              public void clickOnFormAndResourcesLink() throws InterruptedException {
                                   RallyDashboard rallydashboardpage = (RallyDashboard) loginScenario.getBean(PageConstants.RALLY_DASHBOARDPAGE);
                                              Thread.sleep(5000);
                                                
                                  FormsAndResourcesPage formsAndResourcesPage = rallydashboardpage.navigatetoFormsnResources();     
                                  getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
                                              
                              }
                              
                              /**
                               * @toDo : navigation to the forms and resources page from dashboard for active member
                               */
                                              @And("^click on the forms and resource link and navigate to forms and resource page for active member$")
                                              public void clickOnFormAndResourcesLinkActive() throws InterruptedException {
                                                   RallyDashboard rallydashboardpage = (RallyDashboard) loginScenario.getBean(PageConstants.RALLY_DASHBOARDPAGE);
                                                              Thread.sleep(5000);
                                                                     
                                                  FormsAndResourcesPage formsAndResourcesPage = rallydashboardpage.navigatetoFormsnResourcesforactivemembers();     
                                                  getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
                                                              
                                              }
                                              
                         /**
                          * @toDo : show that order plan material is not visible for terminated member
                          */     
                                   
                                              
                         @And("^for terminated member order plan materials link is not displayed$")
                         public void linknotdisplayedforterminated()
                         {
                       	  
                       	  FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);        	  
                       	  formsAndResourcesPage.checkOrderPlanMaterialLinkforterminated();
                         }                    
                                              
                                                             
                                              
                         @And("^for active member both the links are displayed$")
                         public void linksdisplayedforactivemembers() throws InterruptedException
                         {
			                   FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);        	  
			                   Thread.sleep(2000); 
			                   formsAndResourcesPage.scroll();
			                   formsAndResourcesPage.getOrderPlanMaterialLink().isDisplayed();
			               
			                   Thread.sleep(2000);                    
			                   formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();
			                                      
                       
                         }                              
                                              
		               @And("^clicking on the order plan materials link the user is navigated back to the forms and resources page$")
		                   public void planmateriallink() throws InterruptedException
		                     {
		                 FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		                   Thread.sleep(2000);
		                 formsAndResourcesPage.validatenclickOrderPlanMaterial();
		                 
				                                             
		                        }
                              /**
                               * @toDo : verifies the EOB section
                               */
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
                                              formsAndResourcesPage.scroll();
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
                              /**
                               * @toDo : verifies my document section
                               */
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
                              /**
                               * @toDo : verifies renew magazine section
                               */
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
                                              formsAndResourcesPage.scroll();
                                              String renewMagazine = memberAttributesMap.get("RENEW_MAGAZINE_SECTION");
                                              String isRenewMagazineVisible = isButtonVisible(formsAndResourcesPage.getRenewMagazineSection()) ?"YES": "NO";
                                              Assert.assertEquals(renewMagazine, isRenewMagazineVisible);
                                              
                              }
                              /**
                               * @throws InterruptedException 
                             * @toDo : verifies the plan material section
                               */
                              @Then("^validate plan materials section$")
                              public void validatePlanMaterialSection() throws InterruptedException {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              Thread.sleep(30000);
                                            /*  formsAndResourcesPage.clickonperceptionpopup();*/
                                              System.out.println("fnr page");
                                              formsAndResourcesPage.getplanmaterialsection().isDisplayed();
                                              System.out.println("plan materials");
                                              
                                              
                              }
                              /**
                               * @toDo : clicks order plan materials and view temporary id card links
                               */
                              @And("^clicking on the view temporary id card link user is navigated to rallydashboard page$")
                              public void clicklinksonplanmaterials() throws InterruptedException  {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              Thread.sleep(10000);
                                             formsAndResourcesPage.scroll();
                                              formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();
                                              
                                              
                                              formsAndResourcesPage.validatenclickIDCard();
                                              
                                              
                              }
                              /**
                               * @toDo : verifies default language displayed in the drop down
                               */
                              @Then("^validate that english is default language in dropdown$")
                              public void validatelanguage() {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              
                                              formsAndResourcesPage.validateEngDefault();
                              }
                              /**
                               * @toDo : verifies the anoc section
                               */
                              @Then("^validate the anoc section$")
                              public void validateAnocSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              formsAndResourcesPage.scroll();
                                              String  anocsection = memberAttributesMap.get("ANOC_SECTION");
                                              String isANOCSECTIONVisible = isButtonVisible(formsAndResourcesPage.getANOCSection()) ?"YES": "NO";
                                              Assert.assertEquals(anocsection, isANOCSECTIONVisible);
                                              
                              }
                              /**
                               * @toDo : user switches to a different language than the default one
                               */
                             @And("^change the language in the language dropdown$")
                              public void changelanguage() throws InterruptedException {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              formsAndResourcesPage.changelanguage();
                                             
                              }
                             /**
                              * @toDo : verifies the annual directories section
                              */
                              @Then("^validate the annual directories section$")
                              public void validatePlanMaterialSection(DataTable givenAttributes) {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                              Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                              for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                              memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                                              .get(0), memberAttributesRow.get(i).getCells().get(1));
                                              }
                                              formsAndResourcesPage.scroll();
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
                              /**
                               * @throws InterruptedException 
                             * @toDo : verifies the forms and resources section
                               */
                              @And("^validate that the forms and resources section is displayed$")
                              public void validateFNRSection() throws InterruptedException {
                                              
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              Thread.sleep(5000);
                                              formsAndResourcesPage.scroll();
                                              
                                            /*  formsAndResourcesPage.clickonperceptionpopup();*/
                                              System.out.println("fnr section");
                                              if(formsAndResourcesPage.getFormsandResourcesSection().isDisplayed())
                                            	  {
                                            	    System.out.println("true");
                                            	  }
                                              else 
                                            	  System.out.println("false");
                                              
                                              
                                              
                                              
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


       
