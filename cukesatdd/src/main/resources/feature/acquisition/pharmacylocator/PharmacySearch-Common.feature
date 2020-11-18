#@pharmacylocatorAARP
Feature: 1.11. ACQ-Pharmacy Locator AARP

  # @pharmacylocatorAARP01 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ English -----------------------------------
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code |            |
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
    Then the user validates the Pharmacies available
      | Language | English |
    And the user validate tooltips on filters
      | Language                                   | English                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section contents
    And the user validate show on map link
    And the user validate get direction link
    And the user validate more information content based on plan type
    And the user validate view search PDF link

    #  @pharmacylocatorAARP01a
    @PharmacyLocatorCommonAARP01a
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | AARP |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | AARP |   00602 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | AARP |   96950 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | Open 24 hours | False                 | True             | True                 |

    # @PharmacyLocatorCommonProd_AARP
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    @PharmacyLocatorCommonAARP01b
    Examples: 
      | TID   | site | zipcode | distance | countyName   | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | AARP |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | AARP |   80002 |       10 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   14867 |       25 | None         |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   33321 |       10 | None         |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

    @PharmacyLocatorCommonUHC01a
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | UHC  |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   00602 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   96950 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | Open 24 hours | False                 | True             | True                 |

    # @PharmacyLocatorCommonProd_UHC
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    @PharmacyLocatorCommonUHC01b
    Examples: 
      | TID   | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | UHC      |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | UHC      |   80002 |       10 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC      |   14867 |       25 | None         |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC      |   33321 |       10 | None         |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

  # @pharmacylocatorAARP02 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ English -----------------------------------
    And the user validates header section content
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
      | Language      | English        |
    Then the user validates the Pharmacies available
      | Language | English |
    Then the user validate error message displayed when filter results in no match
    Then the user validate the question widget

    #@pharmacylocatorAARP02a\
    @PharmacyLocatorCommonAARP02a
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | AARP |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    #@prodRegression
    @PharmacyLocatorCommonProd_AARP
    Examples: 
      | TID   | siteName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP     |   10980 |       15 | None       |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    #@pharmacylocatorAARP02b
    @PharmacyLocatorCommonAARP02b
    Examples: 
      | TID   | site | zipcode | distance | countyName   | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | AARP |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | AARP |   80002 |       10 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   14867 |       25 | None         |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   33321 |       10 | None         |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

    #@pharmacylocatorAARP02a\
    @PharmacyLocatorCommonUHC02a
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | UHC  |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    #@prodRegression
    @PharmacyLocatorCommonProd_UHC
    Examples: 
      | TID   | siteName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC      |   10980 |       15 | None       |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    #@pharmacylocatorAARP02b
    @PharmacyLocatorCommonUHC02b
    Examples: 
      | TID   | site | zipcode | distance | countyName   | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | UHC  |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | UHC  |   80002 |       10 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC  |   14867 |       25 | None         |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC  |   33321 |       10 | None         |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

  # @pharmacylocatorAARP03 @shopPlan @Chinese @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ Chinese -----------------------------------
    When the user selects Chinese Language to translate
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code |            |
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

    @PharmacyLocatorCommonAARP03
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

    @PharmacyLocatorCommonUHC03
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  #  @pharmacylocatorAARP04 @shopPlan @Chinese @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
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

    @PharmacyLocatorCommonAARP04
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

    @PharmacyLocatorCommonUHC04
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  #@pharmacylocatorAARP05 @shopPlan @Spanish @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ Spanish -----------------------------------
    When the user selects Spanish Language to translate
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code |            |
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

    @PharmacyLocatorCommonAARP05
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

    @PharmacyLocatorCommonUHC05
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  #     @pharmacylocatorulayer06 @shopPlan @Spanish @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
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

    @PharmacyLocatorCommonAARP06
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | AARP |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

    @PharmacyLocatorCommonUHC06
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | UHC  |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  # @pharmacylocatorulayer07 @onlinePharmacyDir @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -plan: <planType>  - To verify navigation to pharmacy search page from VPP page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user validates plan count for all plan types on plan summary page
    And the user select the first plan to view plan detail
      | Plan Type | <planType> |
    And the user navigates to pharmacy locator page using online pharmacy directory link
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |

    @PharmacyLocatorCommonAARP07
    Examples: 
      | TID   | site | plantype | zipcode | isMultutiCounty | county           |
      | 15584 | AARP | MA       |   80002 | Yes             | Adams County     |
      | 15585 | AARP | PDP      |   80001 | No              | Jefferson County |
      | xxxxx | AARP | SNP      |   78006 | Yes             | Comal County     |

    @PharmacyLocatorCommonUHC07
    Examples: 
      | TID   | site | plantype | zipcode | isMultutiCounty | county           |
      | 15584 | UHC  | MA       |   80002 | Yes             | Adams County     |
      | 15585 | UHC  | PDP      |   80001 | No              | Jefferson County |
      | xxxxx | UHC  | SNP      |   78006 | Yes             | Comal County     |

  # @pharmacylocatorulayer08 @geoTargeting @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -state: <state> - To verify pharmacy locator page display for different state
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page with selected state
      | State | <state> |
    #------ English -----------------------------------
    And the user validates header section content on site

    @PharmacyLocatorCommonAARP07
    Examples: 
      | TID   | site | state     |
      | xxxxx | AARP | Ohio      |
      | xxxxx | AARP | Minnesota |

    @PharmacyLocatorCommonUHC07
    Examples: 
      | TID   | site | state     |
      | xxxxx | UHC  | Ohio      |
      | xxxxx | UHC  | Minnesota |