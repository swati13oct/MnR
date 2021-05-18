@dce_redesign_Drug_summary_AARP @dce
Feature: 1.10.1 DCE-REDESIGN AARP - To test Drug summary page in New DCE flow

  ############# DCE Summary Regression Scenario #################
  ############# Validate - Summary Page validation, Switch to generic, Change Pharmacy, Covered Drugs view for Not Covered Pharmacy
  @dce_DrugSummary_Page
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
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
    And user should verify the Extra help on SNP plan type
    And user click on View Drug Pricing Modal
    #  And user should verify the drug extra qualification in drug pricing popup
    And user verifies Drug List on DCE Summary Page - Drug Pricing Modal
    And user clicks on change pharmacy link from summary page
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    Then the user validates Covered Drug display for NC Pharmacy selection
    And user clicks on change pharmacy link on alert message from plan card on drug summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    Then the user selects Mail Pharmacy and returns to DCE Summary page
    #And verify DCE NBA is displayed on drug summary page
    Then user saves MAPD plan as favorite on drug summary page AARP site
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

    @dce_DrugSummary_Page_AARP @regressionAARP @prodRegression
    Examples: 
      | site | zipCode | drug1   | drug2     | drug3 | genericDrug1         | genericDrug2        | SelectPharmacy | testPlans                            | pdptestPlans                    | snptestPlans                               |
      | AARP |   78006 | Lipitor | Lopressor | Emsam | atorvastatin calcium | metoprolol tartrate | ROCK PHARMACY  | AARP Medicare Advantage Choice (PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

    @dce_DrugSummary_Page_UHC @regressionUHC @sanity
    Examples: 
      | site | zipCode | drug1   | drug2     | drug3 | genericDrug1         | genericDrug2        | SelectPharmacy | testPlans                            | pdptestPlans                    | snptestPlans                               |
      | UHC  |   78006 | Lipitor | Lopressor | Emsam | atorvastatin calcium | metoprolol tartrate | ROCK PHARMACY  | AARP Medicare Advantage Choice (PPO) | AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  ############# END - DCE Summary Regression Scenario #################
  @dceRedesign_ChangePharmacyModal @F426569 @F535368 @decRelease
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

    @dceRedesign_ChangePharmacyModal_AARP @regressionAARP
    Examples: 
      | site | drug1   | zipCode | message                                                                                                                                            | zipCode1 | zipCode2 |
      | AARP | Lipitor |   90001 | Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result. |    96799 |    78456 |

    @dceRedesign_ChangePharmacyModal_UHC @regressionUHC @vbfGate
    Examples: 
      | site | drug1   | zipCode | message                                                                                                                                            | zipCode1 | zipCode2 |
      | UHC  | Lipitor |   90001 | Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result. |    96799 |    78456 |
