

package acceptancetests.memberredesign.formsandresources;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.HSIDLoginPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import atdd.framework.*;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;

/**
* @Functionality : Forms and resources page navigation from dashboard and sections validation
*/


       @SuppressWarnings("deprecation")
       public class DashboardFormsnResourcesStepDefinition {

              
              @Autowired
              MRScenario loginScenario;
              
              public MRScenario getLoginScenario() {
                     return loginScenario;
              }  
              
              @Given("^login with following details logins in the member redesign portal$")
              public void login_with_member(DataTable memberAttributes) throws InterruptedException {
                     List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
                     Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                     for (int i = 0; i < memberAttributesRow.size(); i++) {

                           memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
                                         memberAttributesRow.get(i).getCells().get(1));
                     }

                     memberAttributesMap.get("Member Type");
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
                   
                     WebDriver wd = getLoginScenario().getWebDriverNew();
                     
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
       AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.ACCOUNT_HOME_PAGE);
                  Thread.sleep(5000);
                    
      FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResources();     
      getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
                  
  }
  
  /**
   * @toDo : navigation to the forms and resources page from dashboard for active member
   */
  @And("^user clicks on the view document and resources link and navigate to forms and resource page$")
  public void clickOnFormAndResourcesLinkActive() throws InterruptedException {
         AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.ACCOUNT_HOME_PAGE);
                  Thread.sleep(20000);
            
      FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResources();
      System.out.println("navigation worked");
      Thread.sleep(5000);
      formsAndResourcesPage.waitforFNRpage();
      getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
      System.out.println("forms and resources page");
                  
  }   
   
  
  /**
  * @toDo : correct pdfs are coming
   */
  @And("^the user verifies that the correct pdfs are coming in the plan material section$")
   public void verifypdfscoming(DataTable givenAttributes) throws InterruptedException   {
         
 FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
      List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
      System.out.println(memberAttributesRow);
      Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
      for (int i = 0; i < memberAttributesRow.size(); i++) {
                      memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                      .get(0), memberAttributesRow.get(i).getCells().get(1));}
                      Collection<String> values = memberAttributesMap.values();
                      String[] targetArray = values.toArray(new String[values.size()]);
                      System.out.println(values.size());
                      
                      boolean arraycheck = formsAndResourcesPage.verifypdfname(targetArray);
                      if (arraycheck == true)
                      {
                      Assert.assertTrue(true);
                      System.out.println("all pdfs are coming correctly");
                      }
                      else 
                      {
                      Assert.fail("pdfs not coming correctly");
                      }
                      Thread.sleep(2000);
                      formsAndResourcesPage.scroll();
      }
      
       
   
  
  @And("^the user changes the laguage in the language dropdown$")
  public void changelanguageforpdfs() throws InterruptedException  {
         
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
         formsAndResourcesPage.scrollUp();
         Thread.sleep(5000);
         formsAndResourcesPage.changelanguage();
  }
  
  
  
  
                                              
                         /**
                          * @toDo : show that order plan material is not visible for terminated member
                          */     
                                   
                          
     @And("^for terminated member order plan materials link is not displayed$")
     public void linknotdisplayedforterminated()
     {
              
              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
              //formsAndResourcesPage.checkOrderPlanMaterialLinkforterminated();
              Assert.assertTrue(formsAndResourcesPage.checkPOrderPlanMaterialLinkNotAvailable());
              
     }                    
                          
   
    @Then("^validate that the renew magazine section is not displayed$")
    public void renewsectionfortermed()
    {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
         formsAndResourcesPage.scroll();
         formsAndResourcesPage.scroll();
         formsAndResourcesPage.checkRenewsection();
    }
    
    @Then("^validate that the annual directories section is not displayed$")
    public void annualdirectoriesnotdispalyed()
    {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
         formsAndResourcesPage.scroll();
         Assert.assertTrue(formsAndResourcesPage.checkAnnualDirectoriesforgroup());
    }
    
    @And("^both the Pharmacy locator and provider search links are not displayed$")
    public void providerpharacygroupnotdisplayed() throws InterruptedException
    {
       
 FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
         
 formsAndResourcesPage.scroll();
Thread.sleep(6000);
        Assert.assertTrue(formsAndResourcesPage.checkProviderforgroup());
        Assert.assertTrue(formsAndResourcesPage.checkPharmacyforgroup());
    }
    
    @And ("^the Pharmacy locator link is displayed for PDP$")
    public void phamacypdp()
    {
       FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
       formsAndResourcesPage.scroll();
       formsAndResourcesPage.scroll();
        if(formsAndResourcesPage.getPharmacyforPDP().isDisplayed())
        {
              Assert.assertTrue(true);
              System.out.println("pharmacy locator link for PDP is present");
        }
        else 
        {
              Assert.fail("pharmacy locator link for PDP is not present");
        }
    }
    
    
      @And("^the provider search link is not displayed for PDP")
      public void providerpdp()
      {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
       
         Assert.assertTrue(formsAndResourcesPage.checkProviderforPDP());
          
      }
      
      @And("^the Drug EOB link is displayed for PDP$")
      public void eoblinkforpdp()
      {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
         formsAndResourcesPage.scroll();
          if(formsAndResourcesPage.getDrugEOBforPDP().isDisplayed())
          {
              Assert.assertTrue(true);
              System.out.println("drug eob link for PDP is present");
          }
          else 
          {
              Assert.fail("drug eob link for PDP is not present");
          }
      }
    
      @And("^Medical EOB link is not displayed for PDP")
      public void medeoblinkpdp()
      {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
              
         Assert.assertTrue(formsAndResourcesPage.checkMedicalEobforPDP());
      }
    @Then("^validate that the anoc section is displayed for group$")
    public void anocforgroup() throws InterruptedException
    {
       FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
        Thread.sleep(2000); 
        if(formsAndResourcesPage.getAnocforgroup().isDisplayed())
        {
              Assert.assertTrue(true);
              System.out.println("anoc for grp is present");
        }
        else
        {
              Assert.fail("anoc for grp is not present");
        }
        
    }
                              
 @And("^for active member Temporary Id Card and Plan Order Material links are displayed$")
     public void linksdisplayedforactivemembers() throws InterruptedException
    {
       FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);                     
       Thread.sleep(2000); 
       
       formsAndResourcesPage.getOrderPlanMaterialLink().isDisplayed();
       
   
       Thread.sleep(2000);                    
       formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();
                                          
   
     }                              
                          
   @And("^clicking on the order plan materials link the user is navigated to the Order Plan Material Page$")
   public void planmateriallink() throws InterruptedException
            {
              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
              Thread.sleep(2000);
              formsAndResourcesPage.validateOrderPlanMaterial();
       
                                                                    
            }
   
     @And("^validates the pdp texas logo")
     public void validatepdptexaslogo() throws InterruptedException 
     {
        FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         Thread.sleep(2000);
         Assert.assertTrue(formsAndResourcesPage.getpdptexaslogo().isDisplayed());
     }
   
   
   @Then("^validate that the EOB section is displayed$")
   public void eobsec() throws InterruptedException
   {
          FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);  
       formsAndResourcesPage.scroll();
       Thread.sleep(2000); 
       if(formsAndResourcesPage.geteobsectionall().isDisplayed())
       {
         Assert.assertTrue(true); 
         System.out.println("eob present");
       }
       else 
       {
          Assert.fail("eob not present");
       }
   }
   
   /**@throws InterruptedException
    * @toDo :for PCP/Medica anoc section should not come
    */
   @Then("^validate that the anoc section is not displayed$")
   public void anocsecforPCP() throws InterruptedException
   {
          FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);  
       formsAndResourcesPage.scroll();
       Thread.sleep(2000); 
      Assert.assertTrue( formsAndResourcesPage.checkanocforPCP());
   }
   
   
   /** @throws InterruptedException 
      @toDo :for MAPD member both types of EOB are present */
   
@And("^both the Drug and Medical EOB links are displayed$")
   public void bothEOBSpresent() throws InterruptedException
   {
          FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
       Thread.sleep(2000); 
       formsAndResourcesPage.scroll();
             if(formsAndResourcesPage.getEOBMedicaButton().isDisplayed())
             {
              Assert.assertTrue(true);
              System.out.println("medical eob present");
              }
             else{
                Assert.fail("medical eob is not present");
             }
             
             
             if(formsAndResourcesPage.getEOBDrugButton().isDisplayed())
             {
              Assert.assertTrue(true);
              System.out.println("drug eob present");
              }
             else{
                Assert.fail("drug eob is not present");
             }
      
   }
   
         /* to verify the my doc section*/
@Then("^validate that My document section is displayed$")
   public void mydocumentsectionisdispayed() throws InterruptedException
   {
          
   FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
   formsAndResourcesPage.scroll();
       if(formsAndResourcesPage.getMyDocumentSection().isDisplayed())
       {
              Assert.assertTrue(true);
              System.out.println("my doc sec is present");
              
       }
       else 
       {
              Assert.fail("my doc section is not present");
       }
      
   }
      

@Then("^validate that the anoc section is displayed$")
   public void anocsec() throws InterruptedException
   {  
       FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
       formsAndResourcesPage.scroll();
       Thread.sleep(2000);
       if(formsAndResourcesPage.getANOCSection().isDisplayed())
       {
              Assert.assertTrue(true);
              System.out.println("anoc section is present");
              
       }
       else 
       {
              Assert.fail("anoc section is not present");
       }
                     
   }
   
   @Then("^validate that the annual directories section is displayed$")
   public void annualdirectory()
   {
          FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
          formsAndResourcesPage.scroll();
          if(formsAndResourcesPage.getAnnualDirectorySection().isDisplayed())
              {
                     Assert.assertTrue(true);
                     System.out.println("annual directory section is present");
                     
              }
              else 
              {
                     Assert.fail("annual directory section is not present");
              }    
   }
   
   
   
   @And("^both the Pharmacy locator and provider search links are displayed$")
   public void pharmacyprovider()
   {
          FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
          if(formsAndResourcesPage.getpharmacysearchlink().isDisplayed())
             {
                    Assert.assertTrue(true);
                    System.out.println("pharmacy locator is present");
                    
              }
             else 
              {
                     Assert.fail("pharmacy locator is not present");
             }        
          
          
          if(formsAndResourcesPage.getprovisesearchlink().isDisplayed())
             {
                    Assert.assertTrue(true);
                    System.out.println("provider search link is present");
                    
              }
             else 
              {
                     Assert.fail("provider search link is not present");
             }   
   }
    
   
   @And("^the user verifies that the correct pdfs are coming in the anoc and annual directories section$")
    public void verifyanocpdfscoming(DataTable givenAttributes) throws InterruptedException   {
       
    FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
    List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
    System.out.println(memberAttributesRow);
    Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
    for (int i = 0; i < memberAttributesRow.size(); i++) {
                    memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                    .get(0), memberAttributesRow.get(i).getCells().get(1));}
    Collection<String> values = memberAttributesMap.values();
    String[] targetArray = values.toArray(new String[values.size()]);
    System.out.println(values.size());
    
    boolean arraycheck = formsAndResourcesPage.verifypdfnamesforanocdocuments(targetArray);
    if (arraycheck == true)
    {
         Assert.assertTrue(true);
         System.out.println("all anoc and annual directory pdfs are coming correctly");
    }
    else 
    {
         Assert.fail("anoc and annual directory pdfs not coming correctly");
    }
    }
    
  
  /**
   * @throws InterruptedException 
 * @toDo : verifies the plan material section
   */
  @Then("^validate that the plan materials section is displayed$")
  public void validatePlanMaterialSection() throws InterruptedException {
                  FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                  System.out.println("fnr page");
         if(formsAndResourcesPage.getplanmaterialsection().isDisplayed())
         { System.out.println("plan materials");
         Assert.assertTrue(true);
         }
         else 
         {
                Assert.fail("plan material section is not present");
          }
                  
                  
  }
  /**
   * @toDo : clicks order plan materials and view temporary id card links
   */
  @And("^validates the view temporary id card link$")
  public void clicklinksonplanmaterials() throws InterruptedException  {
                  FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                  Thread.sleep(10000);
                
               formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed(); 
               formsAndResourcesPage.validateIDCard();
                  
                  
  }
  /**
   * @toDo : verifies default language displayed in the drop down
   */
  @And("^validate that english is default language in dropdown$")
  public void validatelanguage() {
                  FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                  
                  formsAndResourcesPage.validateEngDefault();
  }
  
  /**
   * @toDo : user switches to a different language than the default one
   */
@And("^the user validates the language dropdown and selects new value in dropdown successfully$")
  public void validate_langdropdown_select(DataTable givenAttributes) throws InterruptedException {
                  FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
                  Thread.sleep(2000);
                  List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                  System.out.println(memberAttributesRow);
                  Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                  for (int i = 0; i < memberAttributesRow.size(); i++) {
                                  memberAttributesMap.put(memberAttributesRow.get(i).getCells()
                                                                  .get(0), memberAttributesRow.get(i).getCells().get(1));}
                  String language = memberAttributesMap.get("Language");
                  formsAndResourcesPage.selectlanguagedropdown(language);
                           
                 
  }

@Then("^validate that the PDPTexas document is present")
public void validatePDPtexasdocument() throws InterruptedException {
     FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
     formsAndResourcesPage.getmedicationforms().click();
        if(formsAndResourcesPage.getpdptexaslogo().isDisplayed())
             {   System.out.println(formsAndResourcesPage.getpdptexasdocument().getText());  
                    
              
             Assert.assertTrue(true);
             }
             else 
             {
             Assert.fail("pdp texas doc is not present");
                   }
                  

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
   * @toDO  : to show ALPeehip Doc
   */
  @And("^validates that the Alpeehip doc is present$")
  public void validateALPeehipDoc() throws InterruptedException {
      FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
      formsAndResourcesPage.getdisenrollment().click();
         if(formsAndResourcesPage.getMAPDALpeehipDoc().isDisplayed())
              {   System.out.println(formsAndResourcesPage.getMAPDALpeehipDoc().getText());  
                     
               
              Assert.assertTrue(true);
              }
              else 
              {
              Assert.fail("plan material section is not present");
                    }
                   

       }
  
@Then("^the user verifies the error message for ship if particular pdf is not present")
       public void errormessagepresentforship() throws InterruptedException
       {  
              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
       Thread.sleep(10000);
       System.out.println("passed");
       int arraylen=formsAndResourcesPage.checkshipdocuments();
       if((arraylen==0) || (arraylen==1))
       {
          Assert.assertTrue(formsAndResourcesPage.geterrormessgaeforship().isDisplayed());
       }
       else if(arraylen==2)
       {   
          
                 Assert.assertTrue(formsAndResourcesPage.checkerrormessageforship());
       }
       }

       

       @Then("^verifies that Electronic Funds pdf for ship is displayed")
       public void verifyshipfnrdocument() throws InterruptedException
       {  
              FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
              Thread.sleep(2000);
              
              if(formsAndResourcesPage.geteftpdfforship().isDisplayed())
                {     
                      System.out.println("the eft pdf is present for ship");
                      Assert.assertTrue(true);
                }
                   else 
                       Assert.fail("the document for ship is not coming");  
       }
              
  /**
   * @throws InterruptedException 
 * @toDo : verifies the forms and resources section
   */
  @Then("^validate that the forms and resources section is displayed$")
  public void validateFNRSection() throws InterruptedException {
                          
      FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
      
      formsAndResourcesPage.scroll();
      Thread.sleep(5000);
    /*  formsAndResourcesPage.clickonperceptionpopup();*/
  System.out.println("fnr section");
  if(formsAndResourcesPage.getFormsandResourcesSection().isDisplayed())
      {
        System.out.println("true forms and resources sec is present");
      }
  else 
         Assert.fail("false fnr not coming");
                    
  }
  
  @Then("^validate that the renew magazine section is displayed$")
  public void validateRenewSection() throws InterruptedException {
                          
      FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
      
      formsAndResourcesPage.scroll();
      Thread.sleep(5000);
    /*  formsAndResourcesPage.clickonperceptionpopup();*/
  System.out.println("fnr section");
         if(formsAndResourcesPage.getRenewMagazineSection().isDisplayed())
             {
               System.out.println("renew sec is present");
             }
          else 
                Assert.fail("renw sec not coming");
                           
         }
  
  @And("^the Pharmacy locator link is not displayed for MA$")
  public void pharmacynotforMA() {
FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
      
      formsAndResourcesPage.scroll();
       Assert.assertTrue(formsAndResourcesPage.checkpharmacyforMA());
         
      
  }
  
  @And("^the Provider Search link is displayed for MA$")
  public void providerlinkMA()
  {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         if(formsAndResourcesPage.getProviderSerachLinkMA().isDisplayed())
      {
        System.out.println("provider search for MA is present");
      }
     else 
         Assert.fail("provider search for MA is not coming");
     
  }
  
  
  
  @And("^the Drug EOB link is not displayed for MA$")
  public void drugeobforMAnotpresent()
  {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         formsAndResourcesPage.scroll();
         Assert.assertTrue(formsAndResourcesPage.checkdrugeobforMA());
         
  }
  
  @And("^Medical EOB link is displayed for MA$")
  public void medicaleobforMA()
  {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         if(formsAndResourcesPage.getEOBMedicaButton().isDisplayed())
      {
        System.out.println("medical eob for MA is present");
      }
     else 
         Assert.fail("medical eob for MA is not coming");
  }
       
  @And("^user is on the forms and resources page for first plan tab")
  public void firstplantab() throws InterruptedException
  {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         Thread.sleep(10000);
         if(formsAndResourcesPage.getfirstplantab().isDisplayed())
         {     
               System.out.println("user is present on fnr page for the first plan");
               Assert.assertTrue(true);
         }
            else 
                Assert.fail("plan tab is missing");  
   }
      
  @And("^the user scrolls till the end of the page to check the My Document and forms and resources section")
  public void checkmydocumentandformsresourcessection()
  {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         formsAndResourcesPage.scroll();
         formsAndResourcesPage.scroll();
         Assert.assertTrue(formsAndResourcesPage.getMyDocumentSection().isDisplayed());
         Assert.assertTrue(formsAndResourcesPage.getFormsandResourcesSection().isDisplayed());
  }
  
  @And("^the user changes the plan tab to view the forms and resources page for second plan")
  public void secondtab() throws InterruptedException
  {
         FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         formsAndResourcesPage.scroll();
         Thread.sleep(10000);
         if(formsAndResourcesPage.getsecondplantab().isDisplayed())
         {     
                formsAndResourcesPage.getsecondplantab().click();
                Thread.sleep(20000);
                System.out.println("user is present on fnr page for the second plan");
               Assert.assertTrue(true);
         }
            else 
                Assert.fail("plan tab is missing");  
   }
  
  @Then("^validate that the EOB section and both the type of Eobs are not displayed")
      public void eobpresentornot()
       {
         
            FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
         Assert.assertTrue(formsAndResourcesPage.checkeobsection());
         Assert.assertTrue(formsAndResourcesPage.checkdrugeobforMA());
         Assert.assertTrue(formsAndResourcesPage.checkmedicaleob());
         
        }
  
  @And("^user clicks on the view document and resources link and navigate to forms and resource page from member auth page")
  public void navigatofnrpage() throws InterruptedException
  { 
         AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstants.ACCOUNT_HOME_PAGE);
      Thread.sleep(20000);

FormsAndResourcesPage formsAndResourcesPage = accounthomepage.navigatetoFormsnResourcesfrommemauth();
System.out.println("navigation worked fine from member auth");
Thread.sleep(5000);
formsAndResourcesPage.waitforFNRpage();
getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
System.out.println("forms and resources page");
      
         
  }
  

  }
       
       
                  
       


