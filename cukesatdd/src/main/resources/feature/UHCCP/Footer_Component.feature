#Author: chandrahasa_sambhangi@optum.com
@tag
Feature: Validation of Footer Component

  @tagCP @tagCP-F
  Scenario Outline: Validation of Footer Component - <link>
    Given User Launch Chrome browser and opens UHOne website to validate footer component
    And User clicks on button "<link>" to validate footer component
    Then User Verifies the Confirmation text for "<link>" to validate footer component
    And User close browser to validate footer component

    Examples: 
      | link               |
      | Accessibility      |
      | Medicare Complaint |
      | Terms of Use       |
      | Privacy            |
      | NL                 |
      | HCP                |
