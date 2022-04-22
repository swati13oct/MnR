#Author: chandrahasa_sambhangi@optum.com
@tag
Feature: Navigating to external portals

  @tagCP @tagCP-Navigate
  Scenario Outline: Navigating to External Portals - <link>
    Given User Launch Chrome browser and opens UHOne website to validate navigation for external portals
    And User clicks on button "<link>" to validate navigation for external portals
    Then User Verifies the Confirmation text for "<link>" to validate navigation for external portals
    And User close browser for external portals

    Examples: 
      | link     |
      | myuhc    |
      | medicaid |