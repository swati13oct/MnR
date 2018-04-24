package acceptancetests.memberredesign.formsandresources;

       import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.member.bluelayer.HSIDLoginPage;
import pages.member.redesign.NewLoginPage;

import pages.member.ulayer.LoginPage;
import pages.member.ulayer.RallyDashboard;
import atdd.framework.*;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
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
             
              @Given("^logging in with following details member logins in the member portal and validate elements$")
  				public void login_with_member(DataTable memberAttributes) throws InterruptedException {
                List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                for (int i = 0; i < memberAttributesRow.size(); i++) {

                 memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                }

                String category = memberAttributesMap.get("Member Type");
				Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
				List<String> desiredAttributes = new ArrayList<String>();
				for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
                {
                                String key = iterator.next();
                                desiredAttributes.add(memberAttributesMap.get(key));
                }

		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		
		Map<String, String> loginCreds = loginScenario.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
		                // no match found
		System.out.println("Member Type data could not be setup !!!");
		Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
		                userName = loginCreds.get("user");
		pwd = loginCreds.get("pwd");
		System.out.println("User is..." + userName);
		System.out.println("Password is..." + pwd);
		                                getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		                                getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		                }
   
                WebDriver wd = getLoginScenario().getWebDriver();
                getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
                HSIDLoginPage loginPage = new HSIDLoginPage(wd);
                loginPage.validateelements();
  AccountHomePage accountHomePage = (AccountHomePage) loginPage.doLoginWith(userName, pwd);
                
                if (accountHomePage!= null) {
                                 getLoginScenario().saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE,accountHomePage);
                                Assert.assertTrue(true);
                }
                else {
                                Assert.fail("***** Error in loading  Redesign Account Landing Page *****");
}
/*AssistiveRegistrationPage assistiveregistration = (AssistiveRegistrationPage) loginPage.doLoginWith(userName, pwd);
if (assistiveregistration != null) {
                 getLoginScenario().saveBean(PageConstantsMnR.ASSISTIVE_REGISTRATION_PAGE,assistiveregistration);
                Assert.assertTrue(true);
}
else {
                Assert.fail("***** Error in loading  Assistive Registration Page *****");
}*/

}
              
                              
  /**
   * @toDo : navigation to the forms and resources page from dashboard for terminated member
   */
  @And("^click on the forms and resource link and navigate to forms and resource page for terminated member$")
  public void clickOnFormAndResourcesLink() throws InterruptedException {
       AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.RALLY_DASHBOARDPAGE);
                  Thread.sleep(5000);
                    
      FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResources();     
      getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
                  
  }
  
  /**
   * @toDo : navigation to the forms and resources page from dashboard for active member
   */
  @And("^click on the forms and resource link and navigate to forms and resource page$")
  public void clickOnFormAndResourcesLinkActive() throws InterruptedException {
	  AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.RALLY_DASHBOARDPAGE);
                  Thread.sleep(5000);
                         
      FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResources();     
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
                              @And("^clicks on the view temporary id card link$")
                              public void clicklinksonplanmaterials() throws InterruptedException  {
                                              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                              Thread.sleep(10000);
                                            
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
                             * @toDo : verifies the eob statemnets for ship member
                               */
                              
                              @And("^validate that the EOB statemnets section is displayed$")
                             public void validateEOBship() throws  InterruptedException {
                                  FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                                  Thread.sleep(5000);
                                  System.out.println("eob section");
                                  formsAndResourcesPage.validateshipeob();
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


       
