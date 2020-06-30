@dce_redesign_zipcode_planyear_capture_AEP @F426582
Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow during AEP

  @DCE_ZipCodePlanYear_AEP 
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
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    And plan year dropdown should be displayed during AEP in AARP

    Examples: 
      | path                     | pageName                   |drugName|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|

  @DCE_ZipCodePlanYear_ValidateContinueBtn_AEP @F443609
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
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user selects plan year in AARP
    And user clicks on continue button in AARP
    Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP

    Examples: 
      | path                     | pageName                   |drugName|zipCode |
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|  90210 |

  @DCE_ZipCodePlanYear_ErrorMessage_NoZipcode_AEP 
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
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enter invalid zipcode in AARP
      | inValidzipCode | <invalidzipcode2> |
    Then error message should be displayed in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user selects plan year in AARP
    And user clicks on continue button in AARP
    Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP

    Examples: 
      | path                     | pageName                   | invalidzipcode | zipCode | invalidzipcode1 | invalidzipcode2 |drugName|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |          78452 |   90210 |            1234 |00000 |lipitor|

  @DCE_ZipCodePlanYear_SamChatCall_AEP
  Scenario Outline: To verify the SAM icons on DCE Zip code and plan year capture page on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    Then the user validates whether call icon is visible on AARP
    Then the user validates whether chat icon is visible on AARP

    Examples: 
      | path                     | pageName                   |drugName|
      | health-plans/estimate-drug-costs.html/getstarted | DCE Redesign - Get Started |lipitor|
