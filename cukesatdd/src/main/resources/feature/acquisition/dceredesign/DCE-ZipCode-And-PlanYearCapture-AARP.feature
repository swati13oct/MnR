@dce_redesign_zipcode_planyear_capture
Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow

  @DCE_ZipCodePlanYear_AEP
  Scenario Outline:  Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for AEP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When user clicks on the Add my drugs button
    Then user should be navigated to Build Drug list page
    #Then the user clicks on Build Drug List to navigate to Step 2
    When user search and add a drug in Step 2
    |DrugName|<drugName>|
    And user clicks on Next: Review Drug Costs button
    Then load screen should be displayed
    And user should be navigated to zipcode and plan year capture page
    And zipcode field should be visible
    And County dropdown should be visible
    And user verify plan year dropdown
    And Continue button should be displayed

    Examples: 
      | path                     | pageName                   |
      | drug-cost-estimator.html | DCE Redesign - Get Started |
      
      @DCE_ZipCodePlanYear_AEP
  Scenario Outline:  Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for Non AEP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When user clicks on the Add my drugs button
    Then user should be navigated to Build Drug list page
    #Then the user clicks on Build Drug List to navigate to Step 2
    When user search and add a drug in Step 2
    |DrugName|<drugName>|
    And user clicks on Next: Review Drug Costs button
    Then load screen should be displayed
    And user should be navigated to zipcode and plan year capture page
    And zipcode field should be visible
    And County dropdown should be visible
    And user verify plan year dropdown
    And Continue button should be displayed

    Examples: 
      | path                     | pageName                   |
      | drug-cost-estimator.html | DCE Redesign - Get Started |
      
      @DCE_ZipCodePlanYear_AEP
  Scenario Outline:  Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When user clicks on the Add my drugs button
    Then user should be navigated to Build Drug list page
    #Then the user clicks on Build Drug List to navigate to Step 2
    When user search and add a drug in Step 2
    |DrugName|<drugName>|
    And user clicks on Next: Review Drug Costs button
    Then load screen should be displayed
    And user should be navigated to zipcode and plan year capture page
    When user enters valid zipcode
    And user selects county
    And user selects plan year
    And user clicks on continue button
    Then load screen should be displayed
    And user should be navigated to Review drug cost estimate page

    Examples: 
      | path                     | pageName                   |
      | drug-cost-estimator.html | DCE Redesign - Get Started |