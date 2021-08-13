@pharmacylocatorChineseSpanish
Feature: 1.11.b ACQ-Pharmacy Locator Test Scripts for Spanish and Chinese Language Selection

  @PharmacyLocatorChinese1
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ Chinese -----------------------------------
    When the user selects Chinese Language to translate
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code | [blank]    |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | Chinese |
    When the user enters following details for the pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | Chinese |
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available
      | Language | Chinese |
    And the user validate tooltips on filters
      | Language                                   | Chinese                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section content
    And the user validates show on map link
    And the user validates get direction link
    And the user validates more information content based on plan type
    And the user validates view search PDF link
    And the user validates pharmacy widgets
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | Chinese        |
    Then the user validates the Pharmacies available
      | Language | Chinese |
    Then the user validate error message displayed when filter results in no match
    Then the user validate the question widget

  @PharmacyLocatorChinese1_AARP @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorChinese1_UHC @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorChinese2
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ Chinese -----------------------------------
    When the user selects Chinese Language to translate
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And the user validates pharmacy widgets on page
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter pharmacies
      | Pharmacy Type | <pharmacyType> |
      | Language      | Chinese        |
    Then the user validates the Pharmacies available
      | Language | Chinese |
    Then the user validate error message displayed when filter results in no match
    Then the user validate the question widget

  @PharmacyLocatorChinese2_AARP @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorChinese2_UHC @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorSpanish1
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ Spanish -----------------------------------
    When the user selects Spanish Language to translate
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code | [blank]    |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | Spanish |
    When the user enters following details for pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | Spanish |
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the Pharmacies available
      | Language | Spanish |
    And the user validate tooltips on filters
      | Language                                   | Spanish                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section contents
    And the user validate show on map link
    And the user validate get direction link
    And the user validate more information content based on plan type
    And the user validate view search PDF link

  @PharmacyLocatorSpanish1_AARP @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorSpanish1_UHC @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorSpanish2
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ Spanish -----------------------------------
    When the user selects Spanish Language to translate
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And the user validates pharmacy widgets on page
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter pharmacies
      | Pharmacy Type | <pharmacyType> |
      | Language      | Spanish        |
    Then the user validates the Pharmacies available
      | Language | Spanish |
    Then the user validate error message displayed when filter results in no match
    Then the user validate the question widget

  @PharmacyLocatorSpanish2_AARP @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @PharmacyLocatorSpanish2_UHC @regressionAARP
    Examples:
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP)                           |        2021 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP)                           |        2021 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |
