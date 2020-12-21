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
      | username | password | member              | Scenario                                                        |
      | pminhas  | Mnrqa001 | KEVINC1234          | Scenario 1:  Search with member username : Federal Member- NICE |
      | pminhas  | Mnrqa001 | Pramila1946         | Scenario 2a: Search using username � SHIP Member                |
      | pminhas  | Mnrqa001 | marylamb823         | Scenario 3: Search using username � PCP Plan Member             |
      | pminhas  | Mnrqa001 | SWHITE33436         | Scenario 4: Search using username � Medica Plan Member          |
