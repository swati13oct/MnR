#Author: chandrahasa_sambhangi@optum.com
@tag
Feature: Validation of Search Component

  @tagCP @tagCP-Search
  Scenario Outline: Validation of Search Component - <Search details>
    Given User Launch Chrome browser and opens Community Portal Website for validation of search component
    And User enters "<Search details>" for validation of search component
    And User clicks on search button for validation of search component
    Then User Verifies the Confirmation text for validation of search component
    And close browser for validation of search component

    Examples: 
      | Search details  | 
      | children health | 
      | medicaid        |
      | caregiving      |
      | telehealth      |
      | optum           |
  
      
      