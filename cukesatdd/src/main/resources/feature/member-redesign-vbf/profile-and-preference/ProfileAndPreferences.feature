@smokeTest
Feature: 1.13-VBF-MemRedesign-To test My Profile & Preferences and Go Green flows


     @smokeTest_ProfileAndPreferenceEPMP 
  Scenario Outline: To test end to end regression scenario for EPMP profile page
   Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Rally Dashboard Page for profile and preference
    When I click the HEALTHSAFE ID PASSWORD link
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    And I should see the communicationpreferncessection
    And I should see the EPMP i frame on profile page 
    And I should be able to see view email address
    And I should be able to view phone numbers

    Examples: 
      | memberType  | friendname | favcolor | phonenumber | 
     | AARPMapdIndEPMP | name1      | color1   | number1     |
      
  @smokeTest_GoGreenEPMP 
  Scenario Outline: To verify Edit preferences section for Go Green
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Rally Dashboard Page for profile and preference
    And the user clicks on Edit Preferences
    Then the user changes the online preference and saves the change
    And the user validates navigates back to Profile page
    And the user clicks on Edit Preferences
    Then the user validates that changes have been saved

    Examples: 
      | memberType  | friendname | favcolor | phonenumber | 
     | AARPMapdIndEPMP | name1      | color1   | number1     |
     
     
  @smokeTest_ProfileAndPreference @rallyDashboard @testharness
  Scenario Outline: Verify Plan Name, Member name, Member ID and account section
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Rally Dashboard Page for profile and preference
    When I click the HEALTHSAFE ID PASSWORD link
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site

    Examples: 
      | memberType  | friendname | favcolor | phonenumber |
    #  | GroupRetireeMapd|name1      | color1   | number1     |
      # | UhcMapdInd     |name1      | color1   | number1     |
      | AARPMapdInd | name1      | color1   | number1     |

  @smokeTest_GoGreen @rallyDashboard @testharness
  Scenario Outline: To verify Go Green page
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Rally Dashboard Page for profile and preference
    And the user clicks on Edit Preferences
    Then the user validates the presence of Plan Name
    Then the user validates the presence of Communication preferences header
    Then the user validates the presence of Back to Profile and Preferences links
    Then the user validates the Note section
    Then the user validates the Save Preferences Button
    Then the user validates the Go Green Header

    Examples: 
      | memberType  | friendname | favcolor | phonenumber |
      # | GroupRetireeMapd|name1      | color1   | number1     |
      # | UhcMapdInd     |name1      | color1   | number1     |
      | AARPMapdInd | name1      | color1   | number1     |
