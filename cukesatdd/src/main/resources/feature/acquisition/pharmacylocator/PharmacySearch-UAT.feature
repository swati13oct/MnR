@pharmacyLocator
Feature: 1.11 UAT - Pharmacy Locator

  Scenario Outline: TID: <TID> -zipcode: <zipcode> - To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ English -----------------------------------
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code | [blank]    |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | English |
    When the user enters following details for the pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | English |
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    #Then the user validates the Pharmacies available
    #  | Language | English |
    And the user validates pharmacy widgets on page
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user validates map section contents
    And the user validate show on map link
    And the user validate more information content based on plan type
    And the user validate view search PDF link
    And click on DCE Link on Pharmacy Page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    And user should be able to see Medicare Advantage plan by default
    Then user verify breadcrumb "Return to Pharmacy Search" on drug summary page
    And user click on return to home on drug summary in AARP site

  @UATAARP01 @regressionAARP @HPA
    Examples:
      | TID                 | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | drug1  | drug2   |
      | E2E Scenario 1_AARP | AARP |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | Fanapt | Lipitor |

  @UATUHC01 @regressionUHC
    Examples:
      | TID                | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | drug1  | drug2   |
      | E2E Scenario 1_UHC | UHC  |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | Fanapt | Lipitor |

  @UATAARP01 @NextYear
    Examples:
      | TID                 | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | drug1  | drug2   |
      | E2E Scenario 1_AARP | AARP |   10980 |       15 | None       |        2022 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | Fanapt | Lipitor |

  @UATUHC01 @NextYear
    Examples:
      | TID                | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | drug1  | drug2   |
      | E2E Scenario 1_UHC | UHC  |   10980 |       15 | None       |        2022 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | Fanapt | Lipitor |

  Scenario Outline: TID: <TID> -zipcode: <zipcode> To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    #And the user navigate to pharmacy search page from the navigation bar
    #------ English -----------------------------------
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    And the user navigate to pharmacy search page from the navigation bar
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code | [blank]    |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | English |
    When the user enters following details for the pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | English |
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    # Then the user validates the Pharmacies available
    #   | Language | English |
    And the user validates pharmacy widgets on page
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user validates map section contents
    And the user validate show on map link
    And the user validate more information content based on plan type
    And the user validate view search PDF link

    @UATAARP02 @regressionAARP 
    Examples: 
       | TID                 | site | language | countyForPlanDetails | path                                                                                                                       | pageName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
       | E2E Scenario 2_AARP | AARP | English  | None                 | health-plans/prescription-drug-plans/available-plans.html?zipcode=90210&planyear=current&WT.mc_id=8001024&county=053&state=27#/plan-summary | PDP-52   |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @UATUHC02 @regressionUHC
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                       | pageName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 2_UHC | UHC  | English  | None                 | health-plans/prescription-drug-plans/available-plans.html?zipcode=90210&planyear=current&WT.mc_id=8001024&county=053&state=27#/plan-summary | PDP-52   |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

  @UATAARP02 @NextYear
    Examples:
      | TID                 | site | language | countyForPlanDetails | path                                                                                                                       | pageName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 2_AARP | AARP | English  | None                 | health-plans/prescription-drug-plans/available-plans.html?zipcode=90210&planyear=2022&WT.mc_id=8001024&county=053&state=27#/plan-summary | PDP-52   |   10980 |       15 | None       |        2022 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

  @UATUHC02 @NextYear
    Examples:
      | TID                | site | language | countyForPlanDetails | path                                                                                                                       | pageName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 2_UHC | UHC  | English  | None                 | health-plans/prescription-drug-plans/available-plans.html?zipcode=90210&planyear=2022&WT.mc_id=8001024&county=053&state=27#/plan-summary | PDP-52   |   10980 |       15 | None       |        2022 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

  Scenario Outline: TID: <TID> -zipcode: <zipcode> - To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from plan type pdp navigation bar
    #------ English -----------------------------------
    And the user validates header section content on site
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
     | Current Year Plan Year | <cy_planYear> |
    | Next Year Plan Name    | <ny_planName> |
    | Next Year Plan Year    | <ny_planYear> |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | English        |
    Then the user validate error message displayed when filter results in no match

    @UATAARP03 @regressionAARP
    Examples: 
      | TID                 | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType   | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 3_AARP | AARP |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | Long-term care | True                  | False            | True                 |

    @UATUHC03 @regressionUHC
    Examples: 
      | TID                | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType   | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 3_UHC | UHC  |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | Long-term care | True                  | False            | True                 |


  @UATAARP03 @regressionAARP @NextYear
    Examples:
      | TID                 | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType   | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 3_AARP | AARP |   10980 |       15 | None       |        2022 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | Long-term care | True                  | False            | True                 |

  @UATUHC03 @regressionUHC @NextYear
    Examples:
      | TID                | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType   | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | E2E Scenario 3_UHC | UHC  |   10980 |       15 | None       |        2022 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | Long-term care | True                  | False            | True                 |
