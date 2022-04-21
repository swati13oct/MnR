#Author: chandrahasa_sambhangi@optum.com
@tag
Feature: Email capture form validation

  @tagUHCCP-Email @tagCP
  Scenario Outline: Email capture form validation
    Given User loads the driver and User opens Community Portal Website for email capture form
    When User clicks on Resource Center button for email capture form
    And User visits the benefits page for email capture form
    And Click on Request Guide button for email capture form
    And User enters First Name as "<first name>" for email capture form
    And User enters Last Name as "<last name>" for email capture form
    And User selects State as "<state>" for email capture form
    And User enters Email as "<email>" for email capture form
    And Click on Submit button for email capture form
    Then User clicks on button the confirmation message should be validated for email capture form
    And close browser for email capture form
    
    Examples: 
      | first name      | last name       | state   | email                           |          
      | Test_Portals_FN | Test_Portals_LN | Arizona | chandrahasa_sambhangi@optum.com |