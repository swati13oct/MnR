
@Test @AARPvisitorprofile
Feature: 1.08. ACQ- Viitor Profile Authenticated NBA AARP
  
  @getStartedNBA
  Scenario Outline: Verify get started for  authenticated Visitor Profile page
   Given the user is on the AARP medicare site landing page
    And the user clicks on the shopping cart icon in AARP site
    Then the user signs in with optum Id credentials in AARP site
      | User Name | <userName> |
      | Password  | <password> |  
    Then user clicks on back to plan on VP authenticated AARP site
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      
    Examples: 
      | userName           | password   | zipcode|county|plantype|drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | jarvisstage23111 | Password@9 |90210| Jefferson County|MAPD|Lipitor|TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |
