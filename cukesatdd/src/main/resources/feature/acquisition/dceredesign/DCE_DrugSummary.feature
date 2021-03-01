@dce_redesign_Drug_summary_AARP
Feature: 1.10.1 DCE-REDESIGN AARP - To test Drug summary page in New DCE flow

  ############# DCE Summary Regression Scenario #################
  ############# Validate - Summary Page validation, Switch to generic, Change Pharmacy, Covered Drugs view for Not Covered Pharmacy

  @DCE_DrugSummary_Page
  Scenario Outline: Test to verify the Drug summary page on <site> site - Switch to generic, Change Pharmacy and Not Covered Pharmacy Covered Drug validation
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    And user should be able to see Medicare Advantage plan by default
    And user click on View Drug Pricing Modal
    Then the user validates Switch to generic for following Brand Drug to Generic from Drug Summary - Drug Pricing Modal
      | Brand Drug   | <drug1>        |
      | Generic Drug | <genericDrug1> |
    And user click on PDP plan to view drug pricing
    Then the user validates Switch to generic for following Brand Drug to Generic from Drug Summary - Drug Pricing Modal
      | Brand Drug   | <drug2>        |
      | Generic Drug | <genericDrug2> |
    And user click on View Drug Pricing Modal
    And user verifies Drug List on DCE Summary Page - Drug Pricing Modal
    And user clicks on change pharmacy link from summary page
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    Then the user validates Covered Drug display for NC Pharmacy selection

    @dce_DrugSummary_Page_AARP
    Examples: 
      | site | zipCode | drug1   | drug2     | genericDrug1         | genericDrug2        | SelectPharmacy |
      | AARP |   78006 | Lipitor | Lopressor | atorvastatin calcium | metoprolol tartrate | ROCK PHARMACY  |

    @dce_DrugSummary_Page_UHC
    Examples: 
      | site | zipCode | drug1   | drug2     | genericDrug1         | genericDrug2        | SelectPharmacy |
      | UHC  |   78006 | Lipitor | Lopressor | atorvastatin calcium | metoprolol tartrate | ROCK PHARMACY  |

  ############# END - DCE Summary Regression Scenario #################
  
  
  @DCE_DrugSummary_ValidatePage
  Scenario Outline: Test to verify the Drug summary page in AARP
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user verify the drug summary page

		@DCE_DrugSummary_ValidatePage_AARP
    Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |AARP|   10001 | MAPD     | none   | no              | Emsam | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
      @DCE_DrugSummary_ValidatePage_UHC
      Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |UHC|   10001 | MAPD     | none   | no              | Emsam | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @drugSummary_SAM_Icon_AARP
  Scenario Outline: Test to verify SAM icon is visible on Drug summary page
   Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible

    Examples: 
      |site| drug1 | zipCode |
      |AARP| Lipitor  |   90210 |
      
      Examples: 
      |site| drug1 | zipCode |
      |UHC| Lipitor  |   90210 |

  @drugSummary_PlanToggle @F477157 @F472327 @F493728 @F504721
  Scenario Outline: Test to verify plan toggle functionality on Drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user should be able to toggle between plan types

		@drugSummary_PlanToggle_AARP
    Examples: 
      |site| drug1 | zipCode |
      |AARP| Lipitor  |   90210 |
      
      @drugSummary_PlanToggle_UHC
      Examples: 
      |site| drug1 | zipCode |
      |UHC| Lipitor  |   90210 |

  @dCERedesign_PlanSave @F476042
  Scenario Outline: Test to verify unauthenticated user save the plan on drug summary page and see the saved plan on guest profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
    Then the user navigates to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <testPlans>    |
      | PDP Plans  | <pdptestPlans> |
      | SNP Plans  | <snptestPlans> |

    Examples: 
      |site| drug1 | zipCode | testPlans                                                                                       | pdptestPlans                    | snptestPlans                               |
      |AARP| Emsam    |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

		Examples: 
      |site| drug1 | zipCode | testPlans                                                                                       | pdptestPlans                    | snptestPlans                               |
      |UHC| Emsam    |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  @dCERedesign_SummaryPage_ChangePharmacy @F426569
  Scenario Outline: Test to verify change pharmacy functionality
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page

		@dCERedesign_SummaryPage_ChangePharmacy_AARP
    Examples: 
      |site| drug1 | zipCode |
      |AARP| Lipitor  |   90001 |
      
      @dCERedesign_SummaryPage_ChangePharmacy_UHC
      Examples: 
      |site| drug1 | zipCode |
      |UHC| Lipitor  |   90001 |

  @drugSummaryPageSwitchToGenericDrug @F484185 @F495366 
  Scenario Outline: Test to Verify that user can switch to generic drug when no drug covered
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
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
    And user click on lipitor Switch To Generic
    And user should be able to see "Medicare Advantage Plans" by default
    And user click on View Drug Pricing Modal
    And user verify drug can switch to generic drug
      | DrugName | <drugName1> |
    And user click on PDP plan to view drug pricing
    And user click on Switch To Generic on drug summary
    And user should be able to see "Medicare Prescription Drug Plans" by default
    And user click on View Drug Pricing Modal
    And user verify drug can switch to generic drug
      | DrugName | <drugName2> |

		@drugSummaryPageSwitchToGenericDrug_AARP @switchtoGenericAARP
    Examples: 
      |site| zipCode | drug1   | drug2     | drugName1                     | drugName2                    |
      |AARP|   10001 | Lipitor | Lopressor | atorvastatin calcium TAB 10MG | metoprolol tartrate TAB 50MG |
     
     @drugSummaryPageSwitchToGenericDrug_UHC @switchtoGenericUHC
      Examples: 
      |site| zipCode | drug1   | drug2     | drugName1                     | drugName2                    |
      |UHC|   10001 | Lipitor | Lopressor | atorvastatin calcium TAB 10MG | metoprolol tartrate TAB 50MG |

  @dCERedesign_ChangePharmacy_DetailsPage @F472598
  Scenario Outline: Test to verify change pharmacy functionality from Drug details page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button  
    Then the user searches and adds the following Drug to Drug List
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
    When user clicks view drug cost button
    And user clicks on change pharmacy link from details page
    Then details page change pharmacy modal should be displayed
    And user verify details page change pharmacy modal
    When user saves and updates pharmacy from list on details page
    Then the pharmacy name should be updated on details page

		@dCERedesign_ChangePharmacy_DetailsPage_AARP
    Examples: 
      |site| drug1 | zipCode |
      |AARP| Lipitor  |   90001 |
      
      @dCERedesign_ChangePharmacy_DetailsPage_UHC
       Examples: 
      |site| drug1 | zipCode |
      |UHC| Lipitor  |   90001 |

  @dceRedesignExtraHelpAlert @F477268 @F470669
  Scenario Outline: Test to Verify that Extra help Warning messgae on view drug pricing modal up
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
    And user should verify the Extra help on SNP plan type
    And user click on View Drug Pricing Modal
    And user should verify the drug extra qualification in drug pricing popup

		@dceRedesignExtraHelpAlert_AARP @extraHelpSNPAARP
    Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |AARP|   10001 | MAPD     | none   | no              | Lipitor    | AARP Medicare Advantage SecureHorizons Focus (HMO) |
     
     @dceRedesignExtraHelpAlert_UHC @extraHelpSNPUHC
      Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | planname                                           |
      |UHC|   10001 | MAPD     | none   | no              | Lipitor    | AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @dceNoPharmaciesZipCode @F492296 @F493728
  Scenario Outline: Test to Verify that user can Handle Zip Codes with No Pharmacies Returned
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
     And user clicks on continue button in Zip Entry Page
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user should be able to toggle between plan types
    
    @dceNoPharmaciesZipCode_AARP
    Examples: 
      |site| zipcode |drug1   |
      |AARP|   96799 |Orkambi |
      
      @dceNoPharmaciesZipCode_UHC
      Examples: 
      |site| zipcode |drug1   |
      |UHC|   96799 |Orkambi |

  @dceSaveplanandBacktoplans @F492270
  Scenario Outline: Test to verify that user can Save plan on DCE summary page and navigating back to homepage to retain the cart value
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
      |site| drug1   | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               |testPlansName|
      |AARP| Orkambi |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP MedicareRx Preferred (PDP),UnitedHealthcare Dual Complete (HMO D-SNP)|

		Examples: 
      |site| drug1   | zipCode | testPlans                                                        | pdptestPlans                    | snptestPlans                               |testPlansName|
      |UHC| Orkambi |   10001 | UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |UnitedHealthcare Medicare Advantage Choice Plan 4 (Regional PPO),AARP MedicareRx Preferred (PDP),UnitedHealthcare Dual Complete (HMO D-SNP)|
      
  @dceNBADrugSummaryPage @F465679 @decRelease
  Scenario Outline: Test to Verify that DCE NBA on Drug summary page 
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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

		@dceNBADrugSummaryPage_AARP
    Examples: 
      |site| zipcode | county | isMultutiCounty | drug1   |
      |AARP|   10001 | none   | no              | Orkambi |
      
      @dceNBADrugSummaryPage_UHC
      Examples: 
      |site| zipcode | county | isMultutiCounty | drug1   |
      |UHC|   10001 | none   | no              | Orkambi |
      
     @dcecovereduncoveredDrugSummayPage @F531892 @decRelease
     Scenario Outline: To verify drug pricing modal popup for covered/noncovered drug for DSNP on drug summary page  
     Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
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
    And user should verify the Extra help on SNP plan type
    And user click on View Drug Pricing Modal
    And user should verify the drug extra qualification in drug pricing popup
    And user should verify drug coverage and you pay value for not covered drug in drug pricing popup
   And user should verify drug coverage and you pay value for covered drug in drug pricing popup

		@dcecovereduncoveredDrugSummayPage_AARP
    Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | drug2| planname                                           |
      |AARP|   10001 | MAPD     | none   | no              | Emsam   | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
     
     @dcecovereduncoveredDrugSummayPage_UHC
   Examples: 
      |site| zipCode | plantype | county | isMultutiCounty | drug1 | drug2| planname                                           |
      |UHC|   10001 | MAPD     | none   | no              | Emsam   | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      
  @dceRedesignSwitchToGenericDrug @F484185 @F495366 @decRelease
  Scenario Outline: Test to Verify that user can update drug dosage, quantity and supply length in switch to generic drug modal
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user click on View Drug Pricing Modal
   And user click on Switch To Generic link for "<drug1>" on drug pricing modal
    And user updates dosage quantity and supply length in switch to generic modal
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user click on View Drug Pricing Modal
    And user verify drug can switch to generic drug
      | DrugName | <drugName1> |
      
      @dceRedesignSwitchToGenericDrug_Summary_AARP
    Examples: 
      |site| zipCode | drug1   | drugName1                     | 
      |AARP|   10001 | Lipitor | atorvastatin calcium TAB 20MG |
      
      @dceRedesignSwitchToGenericDrug_Summary_UHC
		Examples: 
      |site| zipCode | drug1   | drugName1                     | 
      |UHC|   10001 | Lipitor | atorvastatin calcium TAB 20MG |
      
      
      @dceRedesignNoPrescriptionChangePharmacy @decRelease
       Scenario Outline: Test to verify change pharmacy functionality from plan card when no drug prescription
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Advantage Plans" by default
    And user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    And user clicks on change pharmacy link on alert message from plan card on drug summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal

		@dceRedesignNoPrescriptionChangePharmacy_AARP
    Examples: 
      |site| drug1    |drug2      | zipCode |SelectPharmacy|
      |AARP| Emsam  |   Lipitor   |78006 |ROCK PHARMACY  |
      
      @dceRedesignNoPrescriptionChangePharmacy_UHC
      Examples: 
      |site| drug1    |drug2      | zipCode |SelectPharmacy|
      |UHC| Emsam  |   Lipitor   |78006 |ROCK PHARMACY  |
      
      @dCERedesign_ChangePharmacyModal @F426569 @F535368 @decRelease
  Scenario Outline: Test to verify sort, pagination, invalid zipcode error functionality for change pharmacy on drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user selects Preferred mail order pharmacy
    Then the message "OptumRx Home Delivery only provides 90-day refill for your drugs." should be displayed on change pharmacy modal
    And user verify the default distance on change pharmacy modal
    When user sort the pharmacy list by "A to Z"
    Then pharmacy list should be displayed in ascending order
    When user sort the pharmacy list by "Z to A"
    Then pharmacy list should be displayed in descending order
    When user clicks on next button on change pharmacy modal
    Then user should be navigated to second page of pharmacy list
    When user clicks on back button on change pharmacy modal
    Then user should be navigated to first page of pharmacy list
    When user search with zipcode with no pharamacies
    | ZipCode | <zipCode1> |
    Then no results message should be displayed
    | NoResultsMessage | <message> |
    When user search with incorrect zipcode
    | ZipCode | <zipCode2> |
    Then error message "Please enter a valid ZIP code." should be displayed on change pharmacy modal
    
    @dCERedesign_ChangePharmacyModal_AARP
    Examples: 
      |site| drug1 | zipCode |message|zipCode1|zipCode2|
      |AARP| Lipitor  |   90001 |Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result.|96799|78456|

		@dCERedesign_ChangePharmacyModal_UHC
 		Examples: 
      |site| drug1 | zipCode |message|zipCode1|zipCode2|
      |UHC| Lipitor  |   90001 |Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result.|96799|78456|

      
      @dCERedesign_ChangePharmacyNoResults @F426569 @F489207 @decRelease
  Scenario Outline: Test to verify no results message displayed for change pharmacy modal on drug summary page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
     When user search with zipcode with no pharamacies
    | ZipCode | <zipCode1> |
    When user updates the distance to "2 Miles"
    Then no results message should be displayed
    | NoResultsMessage | <message> |
    
    @dCERedesign_ChangePharmacyNoResults_AARP
    Examples: 
      |site| drug1 | zipCode |message|zipCode1|
      |AARP| Lipitor  |   90001 |Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result.|78006|
      
      @dCERedesign_ChangePharmacyNoResults_UHC
       Examples: 
      |site| drug1 | zipCode |message|zipCode1|
      |UHC| Lipitor  |   90001 |Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result.|78006|
      
      
      @DCERedesign_DCE-VPPDetails_DrugSummary
      Scenario Outline: Test to verify the Drug cost estimator and view plan summary button on VPP detail page from Drug summary page
     Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
   	When user clicks on view plan details button on drug summary page
   	| Plan Name | <planName> |
   	Then the user validates planName matches plan Name in VPP details page
    And verify the default tab displayed on VPP details page
    | TabName | <tabName> |
    Then the user verify the drug cost estimator and view plan summary buttons on VPP detail page
    When the user click on drug cost estimator button on vpp plan detail page
    Then user verify the drug summary page

    Examples: 
      |site| drug1 | zipCode |planName|tabName|
      |AARP| Lipitor  |   10001|AARP Medicare Advantage Prime (HMO)|Medical Benefits and Programs|
      
      Examples: 
      |site| drug1 | zipCode |planName|tabName|
      |UHC| Lipitor  |   10001|AARP Medicare Advantage Prime (HMO)|Medical Benefits and Programs|
      
      @dceRedesignDefaultPharmacyDrugSummary @F497405 @decRelease
  Scenario Outline: Test to Verify default Retail chain pharmacy on drug summary page
     Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
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
    Then the user verify the default Retail chain pharmacy on drug summary page
    	|DefaultPharmacy| <defaultPharmacy>|
    And user clicks on change pharmacy link from summary page
    Then user clicks on Keep Using This Pharmacy link on change pharmacy modal
    Then user validate "WALGREENS" pharmacy on drug summary page

    @dceRedesignDefaultPharmacyDrugSummary_AARP
    Examples: 
      |site| zipCode | plantype | county       | isMultutiCounty | drug1     |defaultPharmacy|
      |AARP|   10001 | MAPD     | Bexar County | yes             | Lipitor |Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)|

      @dceRedesignDefaultPharmacyDrugSummary_UHC
      Examples: 
      |site| zipCode | plantype | county       | isMultutiCounty | drug1     |defaultPharmacy|
      |UHC|   10001 | MAPD     | Bexar County | yes             | Lipitor |Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)|
      
      
      @drugSummary_DefaultPlanType @F504721
  Scenario Outline: Test to verify plan toggle functionality on Drug summary page when no MAPD plans available
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
     And user clicks on continue button in Zip Entry Page
    And user should be navigated to Review drug cost estimate page
    And user should be able to see "Medicare Prescription Drug Plans" by default

		@drugSummary_DefaultPlanType_AARP
    Examples: 
      |site| drug1 | zipCode |
      |AARP| Lipitor  |   41311 |
      
      @drugSummary_DefaultPlanType_UHC
      Examples: 
      |site| drug1 | zipCode |
      |UHC| Lipitor  |   41311 |
      