@dce_redesign_zipcode_planyear_capture_NonAEP
Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow during NonAEP

  @DCE_ZipCodePlanYear_NonAEP
  Scenario Outline: Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for AEP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for Non AEP
    And plan year dropdown should not be displayed during Non AEP

    Examples: 
      | path                     | pageName                   |drugName|
      | /health-plans/estimate-drug-costs.html | DCE Redesign - Get Started |lipitor|

  @DCE_ZipCodePlanYear_ValidateContinueBtn_NonAEP
  Scenario Outline: Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
     And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page in AARP
    Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP

    Examples: 
      | path                     | pageName                   | zipCode |drugName|
      | /health-plans/estimate-drug-costs.html | DCE Redesign - Get Started |   80001 |lipitor|

  @DCE_ZipCodePlanYear_ErrorMessage_NoZipcode_NonAEP
  Scenario Outline: Test to verify the error message when user does not enter or enter invalid zipcode and clicks on continue button
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for Non AEP
    #When user clicks on continue button
    #Then error message should be displayed
    When user enter invalid zipcode in AARP
      | inValidzipCode | <invalidzipcode> |
    Then error message should be displayed in AARP
    When user enter invalid zipcode in AARP
      | inValidzipCode | <invalidzipcode1> |
    Then error message should be displayed in AARP
    When user enter invalid zipcode in AARP
      | inValidzipCode | <invalidzipcode2> |
    Then error message should be displayed in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page in AARP
    Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP

    Examples: 
      | path                     | pageName                   | invalidzipcode | zipCode | invalidzipcode1 | invalidzipcode2 |drugName|
      | /health-plans/estimate-drug-costs.html | DCE Redesign - Get Started |          78452 |   90210 |            1234 |           00000 |lipitor|
 
 
  @DCE_ZipCodePlanYear_SamChatCall_NonAEP
  Scenario Outline: To verify the SAM icons on DCE Zip code and plan year capture page on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    And the user validates whether call icon is visible on AARP
    And the user validates whether chat icon is visible on AARP
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for Non AEP
    Then the user validates whether call icon is visible on AARP
    Then the user validates whether chat icon is visible on AARP

    Examples: 
      | path                     | pageName                   |drugName|
      | /health-plans/estimate-drug-costs.html | DCE Redesign - Get Started |lipitor|
