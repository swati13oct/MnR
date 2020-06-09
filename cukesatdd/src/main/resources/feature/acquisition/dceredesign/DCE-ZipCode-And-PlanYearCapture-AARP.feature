@dce_redesign_zipcode_planyear_capture
Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow

  @DCE_ZipCodePlanYear_AEP @test
  Scenario Outline:  Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for AEP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Step 2
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
      | path                     | pageName                   |drugName|
      | drug-cost-estimator.html | DCE Redesign - Get Started |Lipitor|
      
      @DCE_ZipCodePlanYear_NonAEP
  Scenario Outline:  Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for Non AEP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Step 2
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
      | path                     | pageName                   |drugName|
      | drug-cost-estimator.html | DCE Redesign - Get Started |Lipitor|
      
      @DCE_ZipCodePlanYear_NonAEP
  Scenario Outline:  Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Step 2
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
      | path                     | pageName                   |drugName|
      | drug-cost-estimator.html | DCE Redesign - Get Started |Lipitor|
      
      @DCE_ZipCodePlanYear_ErrorMessage_NoZipcode
  Scenario Outline:  Test to verify the error message when user does not enter zipcode and clicks on continue button
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Step 2
    Then user should be navigated to Build Drug list page
    #Then the user clicks on Build Drug List to navigate to Step 2
    When user search and add a drug in Step 2
    |DrugName|<drugName>|
    And user clicks on Next: Review Drug Costs button
   # Then load screen should be displayed
    And user should be navigated to zipcode and plan year capture page
    When user enter invalid zipcode
    |inValidzipCode|<invalidzipcode>|
    When user enters valid zipcode and county
    |ZipCode|<zipCode>|
    And user selects plan year
    And user clicks on continue button
    Then load screen should be displayed
    And user should be navigated to Review drug cost estimate page

    Examples: 
      | path                     | pageName                   |drugName|invalidzipcode| zipCode|
      | drug-cost-estimator.html | DCE Redesign - Get Started |Lipitor |12345         |90210   |
      
    
       Scenario Outline:  Test to verify the appropriate county when users have more than one counties 
       
        @DCE_ZipCodePlanYear_MultipleCounty_SelectAppropriate
    
    #Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Step 2
    Then user should be navigated to Build Drug list page
    #Then the user clicks on Build Drug List to navigate to Step 2
    When user search and add a drug in Step 2
    |DrugName|<drugName>|
    And user clicks on Next: Review Drug Costs button
   # Then load screen should be displayed
    And user should be navigated to zipcode and plan year capture page
    When user enters valid zipcode
    And user selects county
    And user selects plan year
    And user clicks on continue button
    #Then load screen should be displayed
    And user should be navigated to Review drug cost estimate page

    Examples: 
      | path                     | pageName                   |drugName| zipCode|countyName|
      | drug-cost-estimator.html | DCE Redesign - Get Started |Lipitor | 80002  |Adam County|
      
      