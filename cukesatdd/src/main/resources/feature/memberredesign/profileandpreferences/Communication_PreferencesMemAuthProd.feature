@CommunicationPreferences @thePredators @F402311
Feature: 1.03.1 Member Preferences page -Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPProfileAndPreferences |

  #----- beginning of non Regression preferences scenarios section ------------------------
  @prod_CommunicationPreferences01
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Communication Preferences section
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section
    Then the user validates Communication Preferences section
    Then the user validates the presence of Communication preferences header
    And the user clicks on edit preferences link
    Then the user validates headers on Preferences page
    Then the user validates the presence of Plan Name on Communication Preferences Page
    And the user validates the iframe on Communication Preferences Page
    Then the user validates the I have read checkbox and check it
   # Then the user validates the Save Preferences Button
    Then the user validates the Note Section on Preferences Page
#    Then the user validates the presence of Back links on Preferences page
    @prod_CommunicationPreferences1a
    Examples:
      | TID   | username | password | MemUserName  | userSelection | planType                      |
      | 15311 | ujethwa | 221Umang | DSOADY17     | xxxxx         | MAPD_AARP_GOGreen_Profilepref |
      | 15312 | ujethwa | 221Umang | TOMIKOARMER2 | xxxxx         | MA_AARP_GOGreen_Profilepref   |

    @prod_CommunicationPreferences1b
    Examples:
      | TID   | username | password | MemUserName       | userSelection | planType                       |
      | 15313 | ujethwa | 221Umang | LSLOMSKI777       | xxxxx         | PDP_AARP_GOGreen_Profilepref   |
      | 15314 | ujethwa | 221Umang | TEAKSAMPPALA1     | xxxxx         | MAPD_UHC_GOGreen_Profilepref   |
      | 15316 | ujethwa | 221Umang | WILLIAMGARRISON48 | xxxxx         | MAPD_GROUP_GOGreen_Profilepref |


  #-----------------------  SHIP Preferences tests ---------------------------------------------------
  @prod_CommunicationPreferences02
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Communication Preferences section for a SHIP member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section
    Then the user validates Communication Preferences section
    Then the user clicks on edit preferences link page for ship
    Then the user validate the presence of Plan Name on Communication Preferences Page for Ship
    Then the user validates the headers and labels of the communication preferences section for SHIP
    Then the user validates that the iframe is not present for a ship member
    #Then the user validates the update preferences functionality for ship
    Then the user validates the presence of Back links on ship Preferences page

    Examples:
      | TID   | username | password | MemUserName | userSelection | planType | memberType       |
      | 15309 | ujethwa | 221Umang | kataz2525 | xxxxx         | SHIP     | SHIP_ProfilePref |


  @prod_CommunicationPreferences03
  Scenario Outline: TID: <TID> - plan: <planType> - Verify use doesn't have Communication Preferences section
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    #-------------- navigate to the target test page for testing
    When the user navigates to Profile and Preferences page
    And the user validates that Communication Preferences section does not display
      | Plan Type | <planType> |

    Examples:
      | TID   | username | password | MemUserName           | planType           |
      #| 15310 | ujethwa | 221Umang | testusername    | SSUP_ProfilePref       |
#      | 15376 | ujethwa | 221Umang | erbenoit56    | Terminated_ProfilePref |
      | 15308 | ujethwa | 221Umang | marylamb823           | PCP_ProfilePref    |
      | 15308 | ujethwa | 221Umang | SUSICHAPMAN@GMAIL.COM | MEDICA_ProfilePref |
      
