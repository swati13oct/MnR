@regressionMemberPROD @OfflinePRODVanityURLdeeplinkSignin
Feature: To test URL formation on offline PROD Signin from various Deeplinks on offlinePROD 

  @regressionMemberPROD @codeWarriors @F477221
  Scenario Outline: Verify members lands on the offline PROD virtual visit page after signing in from virtual visit Vanity URL.
    Given member lands on the offline PROD virtual visit deeplink page
      | <brand> |
    And the offline PROD virtual visit deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
      | Medica |
      | AARP   |
      | UHC    |
