@theSpartans @profilepreferencesPage
Feature:S1.2 Save profile preferences

  @profilepreferences
  Scenario Outline: To verify My Preferences and edit preferences
    Given PreferencesSpartans Login to the application
      | memberNumber | <memberNumber> |
    When PreferencesSpartans the user navigates to Prefrences page
    Then PreferencesSpartans the user changes delivery preferences

    Examples: 
      | memberNumber        |
      | q1_aarp_feb159      |
