@dce_redesign_zipcode_planyear_capture_NonAEP
Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow during NonAEP

  @DCE_ZipCodePlanYear_NonAEP @test1
  Scenario Outline:  Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for AEP
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    Then user should be navigated to zipcode and plan year capture page for Non AEP
		And plan year dropdown should not be displayed during Non AEP
    Examples: 
      | path                     | pageName                   |
      | drug-cost-estimator.html | DCE Redesign - Get Started |
      
      @DCE_ZipCodePlanYear_NonAEP @test
  Scenario Outline:  Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected
   Given the user is on AARP medicare acquisition site landing page
    When the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    When the user clicks on Add drugs button 
    Then user should be navigated to zipcode and plan year capture page for Non AEP
    When user enters valid zipcode and county
    |ZipCode|<zipCode>|
    And user clicks on continue button
    Then load screen should be displayed
    And user should be navigated to Review drug cost estimate page

    Examples: 
      | path                     | pageName                   |zipCode|
      | drug-cost-estimator.html | DCE Redesign - Get Started |90210|