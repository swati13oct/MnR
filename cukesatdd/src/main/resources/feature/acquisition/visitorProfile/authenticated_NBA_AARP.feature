
@Test @AARPvisitorprofile
Feature: 1.08. ACQ- Viitor Profile Authenticated NBA AARP
  
  @getStartedNBA
  Scenario Outline: Verify get started for  authenticated Visitor Profile page
   Given the user is on the AARP medicare site landing page
    And the user clicks on the shopping cart icon in AARP site
    Then the user signs in with optum Id credentials in AARP site
      | User Name | <userName> |
      | Password  | <password> |

    Examples: 
      | userName           | password   | drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | mnrqavd2@gmail.com| | Password@1 | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |
