@pharmacylocatorblayermobile
Feature: 2.11. ACQ-Pharmacy Locator - UMS

  #------------------------- BEGINNING OF ACQUISITION SMOKE TESTS----
  @pharmacylocatorblayer01 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression @prodSanity
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page mobile
      | Site Name | <siteName> |
    When the user enters following details for pharmacy search mobile
      | Zip Code |            |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page mobile
      | Language | English |
    When the user enters following details for pharmacy search mobile
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in pharmacy locator page mobile
      | Language | English |
    And the user enters following detail for pharmacy search mobile
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown mobile
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available mobile
      | Language | English |
    And the user validates map section content mobile
    And the user validates show on map link mobile
    And the user validates get direction link mobile
    And the user validates more information content based on plan type mobile
    And the user validates view search PDF link mobile

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                                               | ny_planYear | ny_planName                                               | pharmacyType    | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15586 | Blayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | E-Prescribing   | True                  | True             | True                 |
      | 15586 | Blayer   |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15586 | Blayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      #| 15586 | Ulayer   |   00602 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      # | 15586 | Ulayer   |   96950 |       15 | None           |        2020 | AARP MedicareRx Preferred (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | False                  | False             | False                 |
      | 15587 | Blayer   |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |

  @pharmacylocatorblayer02 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression @prodSanity
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page mobile
      | Site Name | <siteName> |
    And the user enters following detail for pharmacy search mobile
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown mobile
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    Then the user validates the pharmacies available mobile
      | Language | English |
    And the user validates map section content mobile
    And the user validates show on map link mobile
    And the user validates get direction link mobile
    And the user validates more information content based on plan type mobile
    And the user validates view search PDF link mobile

    Examples: 
      | TID   | siteName | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15586 | Blayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15586 | Blayer   |   85215 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15586 | Blayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP) |        2020 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

  @pharmacylocatorulayer07 @onlinePharmacyDir @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -plan: <planType>  - To verify navigation to pharmacy search page from VPP page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <planType> |
    # Then user validates plan count for all plan types on plan summary page in the AARP site
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
