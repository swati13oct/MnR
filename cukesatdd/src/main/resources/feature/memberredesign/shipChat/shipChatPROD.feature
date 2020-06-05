@regressionMemberProd
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD @regressionMemberPRODsigninSignout
  Scenario Outline: Scenario: <Scenario> - Verify member auth functionality of member sign in & sign out
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And the user navigates to payments secondary page
    And the user clicks on Contact & help us link & navigate to contact us page    
    And the user validates the CHAT section

    Examples: 
      | username | password | member |
      | ashah120 | Mnrqa002 | Pramila1946 |
