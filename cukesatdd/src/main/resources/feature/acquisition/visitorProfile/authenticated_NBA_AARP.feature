
@Test @AARPAuthenticatedvisitorprofile
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
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then user validate Saved items and Get started      
    Examples: 
      | userName           | password   | isMultutiCounty | zipcode|county|plantype|drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | chargersqa@23 | Password@23 | NO              |90210| Jefferson County|MAPD|Lipitor|TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |

@drugAlreadyAdded
     Scenario Outline: Verify get Find a provider for authenticated Visitor Profile VPP summary page when drug is already added 
   Given the user is on the AARP medicare site landing page
    And the user clicks on the shopping cart icon in AARP site
    Then the user signs in with optum Id credentials in AARP site
      | User Name | <userName> |
      | Password  | <password> |  
    Then user clicks on back to plan on VP authenticated AARP site
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then user validate Saved items and Get started
    Then user click on get started on AARP site
    Then the user validates Get Started Page 
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    And the user click on return to plan summary from Get Started Page to return to VPP Plan Summary
    Then user validate Find a Provider
   
    Examples: 
      | userName           | password   | isMultutiCounty | zipcode|county|plantype|drugName    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | chargersqa@23 | Password@23 | NO              |90210| Jefferson County|MAPD|Lipitor|TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |
     
      