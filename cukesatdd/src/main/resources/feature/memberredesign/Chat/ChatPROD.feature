@regressionMemberPROD
Feature: S1.1 To test Member Auth CHAT functionality on PROD

  @regressionMemberPROD @regressionMemberPRODChatSHIP @sanityMemberPROD1
  Scenario Outline: <Scenario> - Verify member auth functionality for SHIP member CHAT
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And the user navigates to payments secondary page
    And the user clicks on Contact & help us link & navigate to contact us page
    And the user validates the CHAT section for SHIP member on PROD

    Examples: 
      | username | password | member      |
      | pminhas  | Mnrqa002 | Pramila1946 |

  @regressionMemberPROD @regressionMemberPRODGroupChat @sanityMemberPROD2
  Scenario Outline: <Scenario> - Verify member auth functionality For Group member CHAT
    Given First check if feature security flag is set to true
      | Feature | UCPContactus |
    And the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And the group user navigates to claims secondary page in Prod & clicks on the EOB LINK
    And the group user clicks on Contact & help us link & navigate to contact us page on PROD
    And the user validates the CHAT section for group member on PROD

    Examples: 
      | username | password | member       |
      | pminhas  | Mnrqa002 | 2nancyreeves |
