@smokeTest
Feature: 1.13-VBF-MemRedesign-To test My Profile & Preferences and Go Green flows
@smokeTest_ProfileAndPreference @rallyDashboard @testharness
  Scenario Outline: Verify Plan Name, Member name, Member ID and account section
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    And the user navigates to Rally Dashboard Page for profile and preference
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site

    Examples: 
         | planType|
#         | GroupRetireeMapd|
       	 | UhcMapdInd     |
#         | AARPMapdInd       |

 @smokeTest_GoGreen @rallyDashboard @testharness
    Scenario Outline: To verify Go Green page
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    And the user navigates to Rally Dashboard Page for profile and preference
    And the user clicks on Edit Preferences
    Then the user validates the presence of Plan Name
    Then the user validates the presence of Communication preferences header
    Then the user validates the presence of Back to Profile and Preferences links
    Then the user validates the Note section
    Then the user validates the Save Preferences Button
    Then the user validates the Go Green Header
    
     Examples: 
      | planType |
#   	  | GroupRetireeMapd|
      | UhcMapdInd     |
#      | AARPMapdInd       |
