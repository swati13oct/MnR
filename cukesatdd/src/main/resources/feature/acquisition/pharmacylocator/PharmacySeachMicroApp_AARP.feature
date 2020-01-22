@pharmacylocatorMicroAppUlayer
Feature: 1.11. ACQ-Pharmacy Locator AARP

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
  #
  #-------------------------
  @pharmacylocatorMicroAppUlayer01 @English
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
      | Zip Code        |            |
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

    @pharmacylocatorulayer01aaa
    Examples: 
      | TID   | THPage         | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | pharmacysearch | Ulayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

  @pharmacylocatorMicroAppUlayer03 @Chinese
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Chinese on acquisition site
    Given the user is on the Acquisition Site TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
      | Zip Code        |            |
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
      | TID   | THPage         | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | pharmacysearch | Ulayer   |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @pharmacylocatorMicroAppUlayer05 @Spanish
  Scenario Outline: TID: <TID> -zipcode: <zipcode> -countyName: <countyName> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in Spanish on acquisition site
    Given the user is on the Acquisition Site TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
      | Zip Code        |            |
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
      | TID   | THPage         | siteName | zipcode | distance | countyName   | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | pharmacysearch | Ulayer   |   78006 |       10 | Comal County |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |
