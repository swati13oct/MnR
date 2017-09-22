@pharmacylocator
Feature: To test pharmacy search page functionality in AARP ULayer

	@sanity
  Scenario Outline: To verify pharmacy search functionality for 2017 in AARP ULayer
    Given user is on the AARP Medicare Site landing page
    Then the user navigates to pharmacy search page in AARP Site
    And enter zipcode
      | Zipcode | <zipcode> |
    And Select a year from the available list displayed
      | Year | <year> |
    And Select a Plan from the available plans list displayed
      | PlanName | <planName> |
    And validate pharmacy search results
    And validate pharmacy saver

    Examples: 
      | year | zipcode | planName                                          |
      | 2017 |   90210 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	
	#@sanity
  Scenario Outline: To verify pharmacy search functionality for 2018 in AARP ULayer
     Given user is on the AARP Medicare Site landing page
    Then the user navigates to pharmacy search page in AARP Site
    And Select a year from the available list displayed
      | Year | <year> |
    And enter zipcode
      | Zipcode | <zipcode> |
    And Select a Plan from the available plans list displayed
      | PlanName | <planName> |
    And validate pharmacy search results
    And validate Standard Network pharmacy

    Examples: 
      | year | zipcode | planName                                          |
      | 2018 |   90210 | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
