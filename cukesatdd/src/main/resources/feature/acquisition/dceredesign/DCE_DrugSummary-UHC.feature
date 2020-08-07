@dce_redesign_Drug_summary_UHC @F426576
Feature: 1.10.1 DCE-REDESIGN UHC - To test Drug summary page in New DCE flow

@DCE_DrugSummary_ValidatePage_UHC
  Scenario Outline: Test to verify the Drug summary page in UHC
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
      
       @drugSummary_PlanToggle_UHC @F477157
  Scenario Outline: Test to verify plan toggle is visible on Drug summary page
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
    And user should be able to see Medicare Advantage plan by default on UHC
    And user should be able to toggle between plan types on UHC
    
    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  10001 |
  
       @dCERedesign_PlanSaveUHC @F476042   
     Scenario Outline: Test to verify unauthenticated user save the plan on drug summary page and see the saved plan on guest profile 
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
    And user should be able to see Medicare Advantage plan by default on UHC
    Then user saves plan as favorite on drug summary UHC site
      | Test Plans | <testPlans> |
     Then user save PDP plan as favorite on drug summary page UHC site
     | PDP Plans | <pdptestPlans> |
     Then user save SNP plan as favorite on drug summary page UHC site
     | SNP Plans | <snptestPlans> |
    Then the user clicks on the shopping cart icon in UHC site
    And user validates the added plans on visitor profile page of UHC site
      | Test Plans | <testPlans> |
       |PDP Plans | <pdptestPlans> |
       | SNP Plans | <snptestPlans> |
    
       Examples: 
      | path                     | pageName                   |drugName|zipCode |testPlans|pdptestPlans|snptestPlans|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  10001 |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP Medicare Advantage Mosaic (HMO)|AARP MedicareRx Preferred (PDP)|UnitedHealthcare Dual Complete (HMO D-SNP)|

	
	@dCERedesign_ChangePharmacy_UHC @F426569   
     Scenario Outline: Test to verify unauthenticated user save the plan on drug summary page and see the saved plan on guest profile 
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
    And user should be able to see Medicare Advantage plan by default on UHC
		When user clicks on change pharmacy link from summary page in UHC
    Then change pharmacy modal should be displayed in UHC
    And user verify change pharmacy modal in UHC
    
       Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  10001 |
      
      
       
     @dceRedesignSwitchtoGenericDrugUHC @F484185
    Scenario Outline: Test to Verify that user can switch to generic drug when no drug covered 
     Given the user is on the uhcmedicaresolutions site landing page
     When the user navigates to following UHC medicare solutions site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page for UHC
    When the user clicks on Add drugs button on UHC
    And adds drugs in drug list page on UHC
    | DrugName | <drugName> |
    And adds drugs in drug list page on UHC
    | DrugName | <drugName1> |
    And clicks on Review drug cost button on UHC
    #Then user should be navigated to zipcode and plan year capture page for AEP on UHC
    Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
   # And user selects plan year on UHC
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    And user should be able to see Medicare Advantage plan by default on UHC
    And user click on View Drug Pricing Modal in UHC
     And user click on Switch To Generic in UHC
     And clicks on Review drug cost button
     Then user should be navigated to UHC, zipcode and plan year capture page for Non AEP
      When user enters valid zipcode and county on UHC
      | ZipCode | <zipCode> |
   # And user selects plan year on UHC
    And user clicks on continue button on UHC
    Then load screen should be displayed on UHC
    And user should be navigated to Review drug cost estimate page on UHC
    And user should be able to see Medicare Advantage plan by default on UHC
    And user click on View Drug Pricing Modal in UHC
     And user verify drug can switch to generic drug in UHC
     
      Examples: 
      | path                     | pageName                   |drugName|drugName1|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | lipitor| Emsam|10001 |
