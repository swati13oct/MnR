@pharmacylocatorblayer

Feature: 2.11. ACQ-Pharmacy Locator - UMS


  #------------------------- BEGINNING OF ACQUISITION SMOKE TESTS----
  @pharmacyLocatorPerformanceBlayer @vbfGate
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
      | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                       | ny_planYear | ny_planName                                         | plantype |
      | Blayer   | 80002   | 25       | Adams County | 2019        | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | MA       |
     #| Blayer   | 80002   | 15       | Adams County | 2019        | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | MA       |

  
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

    @pharmacylocatorBlayerSmoke @pharmacyLocatorBlayerCurrentYrSmoke @pharmacyLocatorBlayerNextYrSmoke

    Examples: 
      | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                       | ny_planYear | ny_planName                                         | pharmacytype              | servicetype   |
      | Blayer   |   80002 |       25 | Adams County |        2019 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Standard Network Pharmacy | Open 24 hours |
   #  | Blayer   |   90210 |       25 | None         |        2019 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | Standard Network Pharmacy | Open 24 hours |

  #tbd @pharmacyLocatorBlayerNextYrSmoke
  #tbd Examples: 
  #tbd     | siteName | zipcode | distance | countyName   | planName                                          | planYear | pharmacytype              | servicetype   |
  #tbd     | Blayer   |   80002 |       25 | Adams County | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |     2020 | Standard Network Pharmacy | Open 24 hours |
  #tbd   #  | Blayer   |   90210 |       25 | None         | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |     2020 | Standard Network Pharmacy | Open 24 hours |

      
  #------------------------- END OF ACQUISITION SMOKE TESTS----
  #-------------------------
  # note: Acq ALM Pharmacy Locator Test cases located in OP regression
  # note: each of the language E2E cases are split into two scenarios to keep the run time shorter so sauce lab won't timeout
  # Blayer
  # TID	: 15586 - TC_001_Locate a pharmacy_header nav PDP
  # TID	: 15587 - TC_002_Locate a pharmacy_header nav MAPD
  # TID	: 15588 - TC_003_Locate a pharmacy_VPP_ MAPD
  # TID : 15589 - TC_004_Locate a pharmacy_VPP_ PDP
  #
  # BYPASS KNOWN ISSUES
  # ticket INC12081940 - Walgreen widget is not showing for Chinese and Spanish page
  #-------------------------
  @pharmacylocatorblayer01 @shopPlan @English @pharmacylocatorAcquisitionE2E @Pharmacy_regression
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

   # @pharmacylocatorblayer01a
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                                    | ny_planYear | ny_planName                                                    | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Blayer   |   10980 |       15 | None           |        2019 | AARP MedicareRx Preferred (PDP)                                |        2020 | AARP MedicareRx Preferred (PDP)                                | E-Prescribing               | True                  | False            | True                 |
      | 15582 | Blayer   |   85215 |       15 | None           |        2019 | AARP MedicareRx Walgreens (PDP)                                |        2020 | AARP MedicareRx Walgreens (PDP)                                | Open 24 hours               | True                  | True             | True                 |
      | 15582 | Blayer   |   78006 |       15 | Kendall County |        2019 | AARP MedicareRx Walgreens (PDP)                                |        2020 | AARP MedicareRx Walgreens (PDP)                                | Open 24 hours               | True                  | True             | True                 |


    @pharmacylocatorblayer01b
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                                    | ny_planYear | ny_planName                                                    | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | Blayer   |   78006 |       10 | Comal County   |        2019 | AARP MedicareComplete Choice Plan 1 (PPO)                      |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)      | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | Blayer   |   80002 |       10 | Adams County   |        2019 | AARP MedicareComplete SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)            | Long-term care              | False                 | False            | True                 |
      | 15583 | Blayer   |   14867 |       25 | None           |        2019 | UnitedHealthcare MedicareComplete Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | Blayer   |   33321 |       10 | None           |        2019 | Medica HealthCare Plans MedicareMax (HMO)                      |        2020 | Medica HealthCare Plans MedicareMax (HMO)                      | Home Infusion and Specialty | False                 | False            | True                 |



  @pharmacylocatorblayer02 @shopPlan @English @pharmacylocatorAcquisitionE2E @Pharmacy_regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name | <siteName> |
    #------ English -----------------------------------
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

   # @pharmacylocatorblayer02a
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                                    | ny_planYear | ny_planName                                                    |pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Blayer   |   10980 |       15 | None           |        2019 | AARP MedicareRx Preferred (PDP)                                |        2020 | AARP MedicareRx Preferred (PDP)                                | E-Prescribing               | True                  | False            | True                 |
      | 15582 | Blayer   |   85215 |       15 | None           |        2019 | AARP MedicareRx Walgreens (PDP)                                |        2020 | AARP MedicareRx Walgreens (PDP)                                | Open 24 hours               | True                  | True             | True                 |
      | 15582 | Blayer   |   78006 |       15 | Kendall County |        2019 | AARP MedicareRx Walgreens (PDP)                                |        2020 | AARP MedicareRx Walgreens (PDP)                                | Open 24 hours               | True                  | True             | True                 |


    @pharmacylocatorblayer02b
    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                                    | ny_planYear | ny_planName                                                    |pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | Blayer   |   78006 |       10 | Comal County   |        2019 | AARP MedicareComplete Choice Plan 1 (PPO)                      |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)      | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | Blayer   |   80002 |       10 | Adams County   |        2019 | AARP MedicareComplete SecureHorizons Plan 1 (HMO)              |        2020 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)            | Long-term care              | False                 | False            | True                 |
      | 15583 | Blayer   |   14867 |       25 | None           |        2019 | UnitedHealthcare MedicareComplete Choice Plan 3 (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | Blayer   |   33321 |       10 | None           |        2019 | Medica HealthCare Plans MedicareMax (HMO)                      |        2020 | Medica HealthCare Plans MedicareMax (HMO)                      | Home Infusion and Specialty | False                 | False            | True                 |



  @pharmacylocatorblayer03 @shopPlan @Chinese @pharmacylocatorAcquisitionE2E @Pharmacy_regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition site
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

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Blayer   |   10980 |       15 | None           |        2019 | AARP MedicareRx Preferred (PDP)           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Blayer   |   78006 |       15 | Kendall County |        2019 | AARP MedicareRx Walgreens (PDP)           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Blayer   |   78006 |       10 | Comal County   |        2019 | AARP MedicareComplete Choice Plan 1 (PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |


  @pharmacylocatorblayer04 @shopPlan @Chinese @pharmacylocatorAcquisitionE2E @Pharmacy_regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition site
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
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Blayer   |   10980 |       15 | None           |        2019 | AARP MedicareRx Preferred (PDP)           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Blayer   |   78006 |       15 | Kendall County |        2019 | AARP MedicareRx Walgreens (PDP)           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Blayer   |   78006 |       10 | Comal County   |        2019 | AARP MedicareComplete Choice Plan 1 (PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |


  @pharmacylocatorblayer05 @shopPlan @Spanish @pharmacylocatorAcquisitionE2E @Pharmacy_regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition site
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
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Blayer   |   10980 |       15 | None           |        2019 | AARP MedicareRx Preferred (PDP)           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Blayer   |   78006 |       15 | Kendall County |        2019 | AARP MedicareRx Walgreens (PDP)           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Blayer   |   78006 |       10 | Comal County   |        2019 | AARP MedicareComplete Choice Plan 1 (PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |


  @pharmacylocatorblayer06 @shopPlan @Spanish @pharmacylocatorAcquisitionE2E @Pharmacy_regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition site
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
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                               | ny_planYear | ny_planName                                                    |pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | Blayer   |   10980 |       15 | None           |        2019 | AARP MedicareRx Preferred (PDP)           |        2020 | AARP MedicareRx Preferred (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15582 | Blayer   |   78006 |       15 | Kendall County |        2019 | AARP MedicareRx Walgreens (PDP)           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15583 | Blayer   |   78006 |       10 | Comal County   |        2019 | AARP MedicareComplete Choice Plan 1 (PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |


  @pharmacylocatorblayer07 @onlinePharmacyDir @Pharmacy_regression
  Scenario Outline: TID: <TID> -plan: <planType> - To verify navigation to pharmacy search page from VPP page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <planType> |
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

  @pharmacylocatorblayer08 @geoTargeting @Pharmacy_regression
  Scenario Outline: TID: <TID> -state: <state> - To verify pharmacy locator page display for different state
    Given the user is on the Acquisition Site landing page with selected state and navigate to pharmacy search page
      | Site Name | <siteName> |
      | State     | <state>    |
    #------ English -----------------------------------
    And the user validates header section content

    Examples: 
      | TID   | state     | siteName |
      | xxxxx | Ohio      |   Blayer |
      | xxxxx | Minnesota |   Blayer |      