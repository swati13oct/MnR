@profilepreferences
Feature: Save profile preferences

  Scenario Outline: To verify My Preferences and edit preferences
    Given Login to the application
      | memberNumber | <memberNumber> |
    When the user navigates to Prefrences page 
    Then the user changes delivery preferences

    Examples: 
      | memberNumber   |
      | q4_dec_aarp004 |