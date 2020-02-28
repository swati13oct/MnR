@pharmacylocatorulayer
Feature: 1.11. ACQ-Pharmacy Locator AARP

  #------------------------- BEGINNING OF ACQUISITION SMOKE TESTS----
  @pharmacyLocatorPerformanceUlayer @vbfGate
  Scenario Outline: To verify available pharmacies
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies results
      | Language | English |

    Examples: 
      | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                         | ny_planYear | ny_planName                                         | plantype |
      | Ulayer   |   80002 |       25 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | MA       |

  #| Ulayer   | 80002   | 15       | Adams County | 2020        | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | MA       |
  Scenario Outline: To verify available pharmacies page
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies results
      | Language | English |
    Then the user chooses the Pharmacy Type
      | Filter Type | <pharmacytype> |
    Then the user chooses the Pharmacy Type
      | Filter Type | <servicetype> |
    Then the user validates the pharmacies results
      | Language | English |

    @pharmacyLocatorUlayerSmoke @pharmacyLocatorUlayerCurrentYrSmoke @pharmacyLocatorUlayerNextYrSmoke
    Examples: 
      | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                         | ny_planYear | ny_planName                                         | pharmacytype              | servicetype   |
      | Ulayer   |   80002 |       25 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Standard Network Pharmacy | Open 24 hours |

  #  | Ulayer   |   90210 |       25 | None         |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Standard Network Pharmacy | Open 24 hours |
  #tbd @pharmacyLocatorUlayerNextYrSmoke
  #tbd Examples:
  #tbd    | siteName | zipcode | distance | countyName   | planName                                          | planYear | pharmacytype              | servicetype   |
  #tbd    | Ulayer   |   80002 |       25 | Adams County | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |     2020 | Standard Network Pharmacy | Open 24 hours |
  #tbd  #  | Ulayer   |   90210 |       25 | None         | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |     2020 | Standard Network Pharmacy | Open 24 hours |
  #------------------------- END OF ACQUISITION SMOKE TESTS----
  #-------------------------
  # note: Acq ALM Pharmacy Locator Test cases located in OP regression
  # note: each of the language E2E cases are split into two scenarios to keep the run time shorter so sauce lab won't timeout
  # Ulayer
  # TID	: 15582 - TC_001_Locate a pharmacy_header nav PDP
  # TID	: 15583 - TC_002_Locate a pharmacy_header nav MAPD
  # TID	: 15584 - TC_003_Locate a pharmacy_VPP_ MAPD
  # TID : 15585 - TC_004_Locate a pharmacy_VPP_ PDP
  #
  # BYPASS KNOWN ISSUES
  # ticket INC12081940 - Walgreen widget is not showing for Chinese and Spanish page
  #-------------------------
  @pharmacylocatorulayer01 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ English -----------------------------------
    And the user validates header section content
    When the user enters following details for pharmacy search
      | Zip Code |            |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | English |
    When the user enters following details for pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | English |
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available
      | Language | English |
    And the user validates tooltips on filters
      | Language                                   | English                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section content
    And the user validates show on map link
    And the user validates get direction link
    And the user validates more information content based on plan type
    And the user validates view search PDF link

    @pharmacylocatorulayer01a
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | Ulayer   |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | Ulayer   |   00602 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | Ulayer   |   96950 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | False                 | True             | True                 |

    @prodRegression
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    @pharmacylocatorulayer01b
    Examples: 
      | TID   | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | Ulayer   |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | Ulayer   |   80002 |       10 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | Ulayer   |   14867 |       25 | None         |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | Ulayer   |   33321 |       10 | None         |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

  @pharmacylocatorulayer02 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ English -----------------------------------
    And the user validates header section content
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And the user validates pharmacy widgets
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | English        |
    Then the user validates the pharmacies available
      | Language | English |
    Then the user validates error message displayed when filter results in no match
    Then the user validates the question widget

    @pharmacylocatorulayer02a
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | Ulayer   |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    @prodRegression
    Examples: 
      | TID   | siteName | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None       |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @pharmacylocatorulayer02b
    Examples: 
      | TID   | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | Ulayer   |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | Ulayer   |   80002 |       10 | Adams County |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | Ulayer   |   14867 |       25 | None         |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | Ulayer   |   33321 |       10 | None         |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        |        2020 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

  @pharmacylocatorulayer03 @shopPlan @Chinese @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ Chinese -----------------------------------
    When the user selects Chinese Language
    And the user validates header section content
    When the user enters following details for pharmacy search
      | Zip Code |            |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | Chinese |
    When the user enters following details for pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | Chinese |
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available
      | Language | Chinese |
    And the user validates tooltips on filters
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
    Then the user validates the pharmacies available
      | Language | Chinese |
    Then the user validates error message displayed when filter results in no match
    Then the user validates the question widget

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Ulayer   |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @pharmacylocatorulayer04 @shopPlan @Chinese @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ Chinese -----------------------------------
    When the user selects Chinese Language
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And the user validates pharmacy widgets
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | Chinese        |
    Then the user validates the pharmacies available
      | Language | Chinese |
    Then the user validates error message displayed when filter results in no match
    Then the user validates the question widget

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Ulayer   |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @pharmacylocatorulayer05 @shopPlan @Spanish @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ Spanish -----------------------------------
    When the user selects Spanish Language
    And the user validates header section content
    When the user enters following details for pharmacy search
      | Zip Code |            |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | Spanish |
    When the user enters following details for pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page
      | Language | Spanish |
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available
      | Language | Spanish |
    And the user validates tooltips on filters
      | Language                                   | Spanish                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section content
    And the user validates show on map link
    And the user validates get direction link
    And the user validates more information content based on plan type
    And the user validates view search PDF link

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Ulayer   |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @pharmacylocatorulayer06 @shopPlan @Spanish @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ Spanish -----------------------------------
    When the user selects Spanish Language
    And the user enters following details for pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And the user validates pharmacy widgets
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | Spanish        |
    Then the user validates the pharmacies available
      | Language | Spanish |
    Then the user validates error message displayed when filter results in no match
    Then the user validates the question widget

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Ulayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP)                           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Ulayer   |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @pharmacylocatorulayer07 @onlinePharmacyDir @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -plan: <planType>  - To verify navigation to pharmacy search page from VPP page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <planType> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user selects the first plan to view plan detail
      | Plan Type | <planType> |
    And the user navigates to pharmacy locator page using Online pharmacy directory link
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |

    Examples: 
      | TID   | planType | zipcode | isMultutiCounty | county           |
      | 15584 | MA       |   80002 | Yes             | Adams County     |
      | 15585 | PDP      |   80001 | No              | Jefferson County |
      | xxxxx | SNP      |   78006 | Yes             | Comal County     |

  @pharmacylocatorulayer08 @geoTargeting @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -state: <state> - To verify pharmacy locator page display for different state
    Given the user is on the Acquisition Site landing page with selected state and navigate to pharmacy search page
      | Site Name | <siteName> |
      | State     | <state>    |
    #------ English -----------------------------------
    And the user validates header section content

    Examples: 
      | TID   | state     | siteName |
      | xxxxx | Ohio      | Ulayer   |
      | xxxxx | Minnesota | Ulayer   |
