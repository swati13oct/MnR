@regressionMember
Feature: 1.16 Member Contact us Page CHAT

 Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPContactus |
###############################Regression Scenarios Begin Here ########################################

  #Agent logins have been commented out as the agents id's expire frequently & the agent portal login does not work not MNR work
  #@regressionMember @agentSigninforAARPCHAT @shipChat
  # Scenario Outline: Verify AARP chat agent login in.
  #  Given agentlogin lands on page
  # And agent enters credentials
  #  | <username> | <password> |
  #  Examples:
  #    | username   | password   |
  #    | AARPStage1 | AARPStage1 |
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

  # @regressionMember @agentSigninforGroupCHAT @GroupFedChat
  #Scenario Outline: Verify AARP chat agent login in.
  #  Given agentlogin lands on page
  #  And agent enters credentials for federal
  #  | <username> | <password> |
  #   Examples:
  #    | username | password |
  #    | MRagent8 | MRagent8 |
  @regressionMember @CT @GroupFedChat @codeWarriors
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Chat with us  is visible on contactUS page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    And the user validates the CHAT section for group member

    Examples: 
      | TID       | plantype | memberType |
      | US2483619 | GroupFED | FedCHAT    |
    #To check how many agents are logged in
    #window.OgnGenesys.chatStatus() if it is false then chat is offine.
