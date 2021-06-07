#Author: Naveen BK
#created Date:2/12/2019
@visitorProfileLegacyUIAuthenticated @visitorProfile
Feature: 1.09. UAT - Legacy Visitor profile UI Authenticated

  @addDrugAuthenticatedLeagcy
  Scenario Outline: Verify user is able to add drug information to the authenticated visitor profile
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user clicks on the add drugs button in the profile
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And the user clicks on the shopping cart icon on DCE page
    Then the user should be able to see the Drug information in the guest profile page
      | Drugname | <drug1> |
    Then user delets all the added drugs on visitor profile page

    @visitorProfile_AARP
    Examples: 
      | site | state    | userName | password   | drug1   | zipCode |
      | AARP | Virginia | mnrqevd5 | Password@1 | Lipitor |   20120 |

    @visitorProfile_UHC
    Examples: 
      | site | state    | userName | password   | drug1   | zipCode |
      | UHC  | Virginia | mnrqevd5 | Password@1 | Lipitor |   20120 |

  @providerFlowAuthenticatedLeagcy
  Scenario Outline: Verify Provider Search functional flow for authenticated Visitor Profile page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page
    Then Verify X out of Y provider covered information is displayed on legacy visitor profile page
      | PlanName | <planname> |
    And user delets all the added providers on visitor profile page
      | PlanName | <planname> |

    @visitorProfile_AARP
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county        | userName | password   | plantype | planname                             |
      | AARP | Virginia |   20120 | NO              | Beaver County | mnrqevd5 | Password@1 | MAPD     | AARP Medicare Advantage Plan 1 (HMO) |

    @visitorProfile_UHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county        | userName | password   | plantype | planname                             |
      | UHC  | Virginia |   20120 | NO              | Beaver County | mnrqevd5 | Password@1 | MAPD     | AARP Medicare Advantage Plan 1 (HMO) |
