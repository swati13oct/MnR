@dce_redesign_Drug_summary_AARP @F426576
Feature: 1.10.1 DCE-REDESIGN AARP - To test Drug summary page in New DCE flow

@DCE_DrugSummary_ValidatePage_AARP 
  Scenario Outline: Test to verify the Drug summary page in AARP
    Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
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
      | zipCode | plantype | county | isMultutiCounty | drugName | planname                                           |
      |   10001 | MAPD     | none   | no              | Emsam | AARP Medicare Advantage SecureHorizons Focus (HMO)    |

      
      
      @drugSummary_SAM_Icon_AARP
  Scenario Outline: Test to verify SAM icon is visible on Drug summary page
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
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |Lipitor|  90210 |
      
      
      @drugSummary_PlanToggle @F477157 @F472327
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
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |Lipitor|  90210 |
      
      
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
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |Emsam|  10001 |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP Medicare Advantage Mosaic (HMO)|AARP MedicareRx Preferred (PDP)|UnitedHealthcare Dual Complete (HMO D-SNP)|

      
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
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    When user clicks on change pharmacy link from summary page in AARP
    Then change pharmacy modal should be displayed in AARP
    And user verify change pharmacy modal in AARP
        
        Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|  90001 |
     
     @dceRedesignSwitchtoGenericDrug @F484185 @F495366
   Scenario Outline: Test to Verify that user can switch to generic drug when no drug covered 
   Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
   And adds drugs in drug list page
      | DrugName | <drug1> |
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
      And user should be navigated to Review drug cost estimate page in AARP
     And user should be able to see Medicare Advantage plan by default
      And user click on View Drug Pricing Modal in AARP
      And user verify drug can switch to generic drug in AARP
     	| DrugName | <drugName2> |
       
        Examples: 
      |zipCode|drug1|drugName2|
      | 10001 | Lipitor|atorvastatin calcium TAB 10MG|
     
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
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |Lipitor|  90001 |
      
      @dceRedesignExtraHelpAlert @F477268 @F470669
   Scenario Outline: Test to Verify that Extra help Warning messgae on view drug pricing modal up
   Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
   And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
     And user should verify the Extra help in AARP
     And user click on View Drug Pricing Modal in AARP
     And user should verify the drug extra qualification in drug pricing popup in AARP  
     
     Examples: 
      | zipCode | plantype | county | isMultutiCounty | drugName | planname                                           |
      |   10001 | MAPD     | none   | no              | Emsam | AARP Medicare Advantage SecureHorizons Focus (HMO)    |
      
      @dceNoDefaultMAPDplan @F492296
     
         Scenario Outline: Test to Verify that user can Handle Zip Codes with No Pharmacies Returned
   Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
   And adds drugs in drug list page
    | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipcode> |
   # And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    And user should be able to toggle between plan types
   
      
      Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      |   96799 | PDP      | Western District | no             | Orkambi | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |
      
      @dceSaveplanandBacktoplans   
   Scenario Outline: Test to verify that user Save plan on DCE summary page and navigating back to homepage to retain the cart value
    Given the user is on the AARP medicare site landing page
     When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drug1> |
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
       
      And user click on back to all plans on vpp summary
      Then user validate cart value on plan card in AARP.
        
        Examples: 
     |drug1|zipCode |testPlans|pdptestPlans|snptestPlans|
     |Orkambi|  10001 |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP Medicare Advantage Mosaic (HMO)|AARP MedicareRx Preferred (PDP)|UnitedHealthcare Dual Complete (HMO D-SNP)|

      
       
      
     
      
      