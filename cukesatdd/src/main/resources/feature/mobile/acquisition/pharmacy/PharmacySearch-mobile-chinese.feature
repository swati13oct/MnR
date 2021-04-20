@pharmacylocatorblayermobile
Feature: 2.11. ACQ-Pharmacy Locator - UMS

  #------------------------- BEGINNING OF ACQUISITION SMOKE TESTS----
 
  @pharmacylocatorblayer01 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page mobile
      | Site Name | <siteName> |
       When the user enters following details for pharmacy search mobile
      | Zip Code |            |
      | Distance | <distance> |
      Then the user verify error messages in pharmacy locator page mobile
      | Language | Chinese |
    When the user enters following details for pharmacy search mobile
      | Zip Code |       9999 |
      | Distance | <distance> |
     Then the user verify error messages in pharmacy locator page mobile
      | Language | Chinese |
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
 	  | 15586 | Blayer   |   10980 |       15 | None           |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | E-Prescribing   | True                  | False            | True                 |
      | 15586 | Blayer   |   78006 |       15 | Kendall County |        2020 | AARP MedicareRx Walgreens (PDP)                           |        2020 | AARP MedicareRx Walgreens (PDP)                           | Open 24 hours   | True                  | True             | True                 |
      | 15587 | Blayer   |   78006 |       10 | Comal County   |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) |        2020 | UnitedHealthcare Medicare Advantage Choice (Regional PPO) | Retail Pharmacy | False                 | False            | True                 |
 	 