@dce_redesign_Drug_summary_AARP @F426576
Feature: 1.10.1 DCE-REDESIGN AARP - To test Drug summary page in New DCE flow

@DCE_DrugSummary_ValidatePage_AARP
  Scenario Outline: Test to verify the Drug summary page in AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user verify the drug summary page

    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  90210 |
      
      
      @drugSummary_SAM_Icon_AARP
  Scenario Outline: Test to verify SAM icon is visiblle on Drug summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    Then the user validates whether call icon is visible on AARP
    Then the user validates whether chat icon is visible on AARP
    
    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|  90210 |
      
      
      @drugSummary_PlanToggle @F477157
  Scenario Outline: Test to verify plan toggle functionality on Drug summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    And user should be able to toggle between plan types
    
    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|  90210 |
      
      
        @dCERedesign_PlanSave_AARP @F476042
  Scenario Outline: Test to verify unauthenticated user save the plan on drug summary page and see the saved plan on guest profile 
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    Then user saves plan as favorite on drug summary page AARP site
       | Test Plans | <testPlans> |
    Then user save PDP plan as favorite on drug summary page AARP site
     | PDP Plans | <pdptestPlans> |
     Then user save SNP plan as favorite on drug summary page AARP site
     | SNP Plans | <snptestPlans> |
    Then the user clicks on the shopping cart icon in AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
       |PDP Plans | <pdptestPlans> |
       | SNP Plans | <snptestPlans> |
        
        Examples: 
      | path                     | pageName                   |drugName|zipCode |testPlans|pdptestPlans|snptestPlans|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  10001 |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP Medicare Advantage Mosaic (HMO)|AARP MedicareRx Preferred (PDP)|UnitedHealthcare Dual Complete (HMO D-SNP)|

      
      @dCERedesign_ChangePharmacy_AARP @F426569
  Scenario Outline: Test to verify change pharmacy functionality 
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    When user clicks on change pharmacy link from summary page in AARP
    Then change pharmacy modal should be displayed in AARP
    And user verify change pharmacy modal in AARP
        
        Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |emsam|  10001 |
     
     @dceRedesignSwitchtoGenericDrug @F484185
   Scenario Outline: Test to Verify that user can switch to generic drug when no drug covered 
      Given the user is on AARP medicare acquisition site landing page
     When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
     Then the user validates Get Started Page
     When the user clicks on Add drugs button
     And adds drugs in drug list page
      | DrugName | <drugName> |
      #And adds drugs in drug list page
      #| DrugName | <drugName1> |
      And clicks on Review drug cost button
     Then user should be navigated to zipcode and plan year capture page for AEP in AARP
     When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
     #And user selects plan year in AARP
     And user clicks on continue button in Zip Entry Page in AARP
     #Then load screen should be displayed in AARP
     And user should be navigated to Review drug cost estimate page in AARP
     And user should be able to see Medicare Advantage plan by default
     And user click on View Drug Pricing Modal in AARP
     And user click on Switch To Generic in AARP
     And clicks on Review drug cost button
     Then user should be navigated to zipcode and plan year capture page for AEP in AARP
     When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
      And user clicks on continue button in Zip Entry Page in AARP
      And user should be navigated to Review drug cost estimate page in AARP
     And user should be able to see Medicare Advantage plan by default
      And user click on View Drug Pricing Modal in AARP
      And user verify drug can switch to generic drug in AARP
     
       
        Examples: 
      | path                     | pageName                   |drugName|drugName1|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor| Emsam|10001 |
     
      @dCERedesign_ChangePharmacy_DetailsPage_AARP @F472598
  Scenario Outline: Test to verify change pharmacy functionality from Drug details page
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button in AARP
    And user clicks on change pharmacy link from details page in AARP
    Then details page change pharmacy modal should be displayed in AARP
    And user verify details page change pharmacy modal in AARP
        
        Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |Lipitor|  10001 |
      
      @dceRedesignExtraHelpAlert @F477268
   Scenario Outline: Test to Verify that Extra help Warning messgae on view drug pricing modal up
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
     And user should verify the Extra help in AARP
     And user click on View Drug Pricing Modal in AARP
     And user should verify the drug extra qualification in drug pricing popup in AARP
     
     
      Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |Lipitor|  10001 |
      