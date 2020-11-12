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
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user verify the drug summary page

    Examples: 
      | zipCode | plantype | county | isMultutiCounty | drugName | planname                                           |
      |   10001 | MAPD     | none   | no              | Emsam    | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @DCE_DrugSummary_Page
  Scenario Outline: Test to verify the Drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user verify the drug summary page

    @dce_DrugSummary_Page_AARP
    Examples: 
      | site | path                                             | pageName                   | drugName | zipCode |
      | AARP | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor  |   90210 |

    #@dce_DrugSummary_Page_UHC
    #Examples: 
     # | site | path                                             | pageName                   | drugName | zipCode |
      #| UHC  | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor  |   90210 |

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
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    Then the user validates whether call icon is visible on AARP
    #Then the user validates whether chat Agent is Available on AARP

    Examples: 
      | path                                             | pageName                   | drugName | zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor  |   90210 |

  @drugSummary_PlanToggle @F477157 @F472327 @F493728
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
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And user should be able to toggle between plan types

    Examples: 
      | path                                             | pageName                   | drugName | zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor  |   90210 |

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
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    Then user saves plan as favorite on drug summary page AARP site
      | Test Plans | <testPlans> |
    Then user save PDP plan as favorite on drug summary page AARP site
      | PDP Plans | <pdptestPlans> |
    Then user save SNP plan as favorite on drug summary page AARP site
      | SNP Plans | <snptestPlans> |
    Then the user navigates to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <testPlans>    |
      | PDP Plans  | <pdptestPlans> |
      | SNP Plans  | <snptestPlans> |

    Examples: 
      | path                                             | pageName                   | drugName | zipCode | testPlans                                                                                       | pdptestPlans                    | snptestPlans                               |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Emsam    |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

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
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page

    Examples: 
      | path                                             | pageName                   | drugName | zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor  |   90001 |

  @dceRedesignSwitchToGenericDrug @F484185 @F495366
  Scenario Outline: Test to Verify that user can switch to generic drug when no drug covered
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drug1> |
    And adds drugs in drug list page
      | DrugName | <drug2> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And user click on View Drug Pricing Modal
    And user click on lipitor Switch To Generic in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And user click on View Drug Pricing Modal
    And user verify drug can switch to generic drug
      | DrugName | <drugName2> |
    And user click on PDP plan to view drug pricing in AARP
    And user click on Switch To Generic
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And user click on View Drug Pricing Modal
    And user verify drug can switch to generic drug
      | DrugName | <drugName3> |

    Examples: 
      | zipCode | drug1   | drug2     | drugName2                     | drugName3                    |
      |   10001 | Lipitor | Lopressor | atorvastatin calcium TAB 10MG | metoprolol tartrate TAB 50MG |

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
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button
    And user clicks on change pharmacy link from details page
    Then details page change pharmacy modal should be displayed
    And user verify details page change pharmacy modal
    When user saves and updates pharmacy from list on details page
    Then the pharmacy name should be updated on details page

    Examples: 
      | path                                             | pageName                   | drugName | zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started | Lipitor  |   90001 |

  @dceRedesignExtraHelpAlert @F477268 @F470669
  Scenario Outline: Test to Verify that Extra help Warning messgae on view drug pricing modal up
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And user should verify the Extra help
    And user click on View Drug Pricing Modal
    And user should verify the drug extra qualification in drug pricing popup

    Examples: 
      | zipCode | plantype | county | isMultutiCounty | drugName | planname                                           |
      |   10001 | MAPD     | none   | no              | Emsam    | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @dceNoDefaultMAPDplan @F492296 @F493728
  Scenario Outline: Test to Verify that user can Handle Zip Codes with No Pharmacies Returned
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
     And adds drugs in drug list page
      | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    # And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    #And user should be able to see Medicare Advantage plan by default
    And user should be able to toggle between plan types
    
    Examples: 
      | zipcode | plantype | county           | isMultutiCounty | drugName   |planname                        |
      |   96799 | PDP      | Western District | no              | Orkambi |AARP MedicareRx Walgreens (PDP) |

  @dceSaveplanandBacktoplans @F492270
  Scenario Outline: Test to verify that user can Save plan on DCE summary page and navigating back to homepage to retain the cart value
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    Then user saves plan as favorite on drug summary page AARP site
      | Test Plans | <testPlans> |
    Then user save PDP plan as favorite on drug summary page AARP site
      | PDP Plans | <pdptestPlans> |
    Then user save SNP plan as favorite on drug summary page AARP site
      | SNP Plans | <snptestPlans> |
    And user click on return to home on drug summary in AARP site
    Then the user navigates to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <testPlansName>    |

    Examples: 
      | drug1   | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               |testPlansName|
      | Orkambi |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP MedicareRx Preferred (PDP),UnitedHealthcare Dual Complete (HMO D-SNP)|

  @dceNBADrugSummaryPage @F465679
  Scenario Outline: Test to Verify that DCE NBA on Drug summary page
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    # And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see Medicare Advantage plan by default
    And verify DCE NBA is displayed on drug summary page

    Examples: 
      | zipcode | county | isMultutiCounty | drug1   |
      |   10001 | none   | no              | Orkambi |
      
  
