@regressionMember
Feature: 1.16 Member Contact us Page

  @regressionMember @agentSigninforAARPCHAT @shipChat
  Scenario Outline: Verify AARP chat agent login in.
    Given agentlogin lands on page
    And agent enters credentials

    Examples: 
      | username   | password   |
      | AARPStage7 | AARPStage7 |

  @codeWarriors @US2483619 @shipChat
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Chat with us  is visible on contactUS page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    And the user validates the CHAT section

    Examples: 
      | TID       | plantype | memberType |
      | US2483619 | SHIP     | SHIPCHAT   |
