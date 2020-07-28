@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD @regressionMemberPRODsigninSignout
  Scenario Outline: <Scenario> - Verify member auth functionality of member sign in & sign out
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And the user navigates to payments secondary page
    And the user clicks on signout and validates the signout is successfull

    Examples: 
      | username | password | member                | Scenario                                                        |
      | ashah120 | Mnrqa003 | skho@roadrunner.com   | Scenario 1:  Search with member username : Federal Member- NICE |
      | ashah120 | Mnrqa003 | Pramila1946           | Scenario 2a: Search using username – SHIP Member                |
      | ashah120 | Mnrqa003 | marylamb823           | Scenario 3: Search using username – PCP Plan Member             |
      | ashah120 | Mnrqa003 | SUSICHAPMAN@GMAIL.COM | Scenario 4: Search using username – Medica Plan Member          |
  