@dce_redesign_zipcode_planyear_capture_NonAEP_UHC @F426582
Feature: 1.10.1 DCE-REDESIGN UHC - To test ZipCode and Plan Year capture page in New DCE flow during NonAEP

  @DCE_ZipCodePlan_Non_AEP
  Scenario Outline: Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for Non AEP on UHC
      Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to following UHC medicare solutions site page
      | PageName | <pageName> |
      | PagePath | <path>     |
     Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
    | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
   Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP 
   Then plan year dropdown should not be displayed during Non AEP in UHC
   
    Examples: 
      | path                     | pageName                   |drugName|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|
      
        @DCERedesign_ZipCodePlanYear_ValidateContBtn_NonAEPUHC @F443609
  Scenario Outline: Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected on UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to following UHC medicare solutions site page
          | PageName | <pageName> |
          | PagePath | <path>     |
     Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
          | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP 
     When user enters valid zipcode and county on UHC
            | ZipCode | <zipCode> |
     And user clicks on continue button on UHC
      Then load screen should be displayed on UHC
     And user should be navigated to Review drug cost estimate page on UHC
   
    Examples: 
      | path                     | pageName                   |drugName|zipCode|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|90210|
      
        @DCE_ZipCodePlanYear_ErrorMessage_NoZipcode_NonAEPUHC @F443609
  Scenario Outline: Test to verify the error message when user does not enter or enter invalid zipcode and clicks on continue button on UHC
        Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to following UHC medicare solutions site page
          | PageName | <pageName> |
          | PagePath | <path>     |
     Then the user validates Get Started Page for UHC
     When the user clicks on Add drugs button on UHC
     And adds drugs in drug list page on UHC
          | DrugName | <drugName> |
     And clicks on Review drug cost button on UHC
     Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP 
     When user enter invalid zipcode on UHC
          | inValidzipCode | <invalidzipcode2> |
    Then error message should be displayed on UHC
    When user enters valid zipcode and county on UHC
           | ZipCode | <zipCode> |
     And user clicks on continue button on UHC
     Then load screen should be displayed on UHC
     And user should be navigated to Review drug cost estimate page on UHC
    
     Examples: 
      | path                     | pageName                   | invalidzipcode | zipCode | invalidzipcode1 | invalidzipcode2 |drugName|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |          78452 |   90210 |            1234 |00000 |lipitor|
    
  
  @DCE_ZipCodePlanYear_SamChatCall_NonAEP_UHC
        Scenario Outline: To verify the SAM icons on DCE Zip code and plan year capture page on UHC site
     Given the user is on the uhcmedicaresolutions site landing page
     When the user navigates to following UHC medicare solutions site page
         | PageName | <pageName> |
         | PagePath | <path>     |
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
   And adds drugs in drug list page on UHC
        | DrugName | <drugName> |
     And clicks on Review drug cost button on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP 
    And the user validates whether call icon is visible on UHC
    And the user validates whether chat icon is visible on UHC
    
  Examples: 
      | path                                             | pageName                   | drugName |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | lipitor  |
  