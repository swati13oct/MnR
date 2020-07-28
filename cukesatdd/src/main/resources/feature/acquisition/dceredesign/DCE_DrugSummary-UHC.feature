@dce_redesign_Drug_summary_UHC @F426576
Feature: 1.10.1 DCE-REDESIGN UHC - To test Drug summary page in New DCE flow

@DCE_DrugSummary_ValidatePage_UHC
  Scenario Outline: Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected
    Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to following UHC medicare solutions site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
    | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
    #Then user should be navigated to zipcode and plan year capture page for AEP on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
   # And user selects plan year on UHC
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    And user verify the drug summary page on UHC

    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  90210 |
      
  @drugSummary_SAM_Icon_UHC
  Scenario Outline: Test to verify SAM icon is visiblle on Drug summary page
   Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to following UHC medicare solutions site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
    | DrugName | <drugName> |
    And clicks on Review drug cost button on UHC
    #Then user should be navigated to zipcode and plan year capture page for AEP on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
    #And user selects plan year on UHC
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    Then the user validates whether call icon is visible on UHC
    Then the user validates whether chat icon is visible on UHC
    
    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  90210 |