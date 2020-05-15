@CommunicationPreferences @thePredators @F402311
Feature: 1.03.1 Member Preferences page - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPProfileAndPreferences |

  #----- beginning of non Regression preferences scenarios section ------------------------
  @memAuth_CommunicationPreferences01
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Communication Preferences section
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    Then the user validates the Save Preferences Button
    Then the user validates the Note Section on Preferences Page
    Then the user validates the presence of Back links on Preferences page

     Examples: 
      | TID   | username  | password  | MemUserName     | userSelection | planType                         |
      | 15311 | qavgogine | qavgogine | testusername    | xxxxx         | MAPD_AARP_GOGreen_Profilepref    |
      | 15312 | qavgogine | qavgogine | testusername    | xxxxx         | MA_AARP_GOGreen_Profilepref      |
      | 15313 | qavgogine | qavgogine | testusername    | xxxxx         | PDP_AARP_GOGreen_Profilepref     |
     #note: need user data with segment id non-000 AND EPMP enabled for below case
     #| xxxxx | qavgogine | qavgogine | testusername    | xxxxx         | MA_001_AARP_GOGreen_Profilepref  |
      
  @memAuth_CommunicationPreferences02 @goGreen
  Scenario Outline: TID: <TID> -Plan Type: <planType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
      | User Selection | <userSelection> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link
    Then the user changes the online preference and saves the change
    Then the user validates the functionality of updating the email on the iframe

    Examples: 
      | TID   | username  | password  | MemUserName     | userSelection | planType                        | 
      | 15311 | qavgogine | qavgogine | testusername    | xxxxx         | MAPD_AARP_GOGreen_Profilepref   |
      | 15312 | qavgogine | qavgogine | testusername    | xxxxx         | MA_AARP_GOGreen_Profilepref     | 
      | 15313 | qavgogine | qavgogine | testusername    | xxxxx         | PDP_AARP_GOGreen_Profilepref    |
      | 15314 | qavgogine | qavgogine | testusername    | xxxxx         | MAPD_UHC_GOGreen_Profilepref    |
      | 15315 | qavgogine | qavgogine | testusername    | xxxxx         | MA_UHC_GOGreen_Profilepref      |
      | 15316 | qavgogine | qavgogine | testusername    | xxxxx         | MAPD_GROUP_GOGreen_Profilepref  |

  #-----------------------  SHIP Preferences tests ---------------------------------------------------
  @memAuth_CommunicationPreferences03 @CommunicationPreferencesMicroApp03 @F220921
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Communication Preferences section for a SHIP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>         |
      | Member Type | <memberType>       |
      | User Selection | <userSelection> |
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section
    Then the user validates Communication Preferences section
    Then the user clicks on edit preferences link page for ship
    Then the user validate the presence of Plan Name on Communication Preferences Page for Ship
    Then the user validates the headers and labels of the communication preferences section for SHIP
    Then the user validates that the iframe is not present for a ship member
    Then the user validates the update preferences functionality for ship
    Then the user validates the presence of Back links on ship Preferences page 

    Examples: 
      | TID    | username  | password  | MemUserName     | userSelection           | planType | memberType       |
      | 15309  | qavgogine | qavgogine | testusername    | SHIP-q1_feb_ship_20_001 | SHIP     | SHIP_ProfilePref |

  @memAuth_CommunicationPreferences04 @EPMPpreferencesForComboOnProfile
  Scenario Outline: TID: <TID> - plan: <planType> - memberType: <memberType> - To test end to end regression preferences scenario for combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Preferences page and user validates the elements on individual tabs

    Examples: 
      | TID   | username  | password  | MemUserName     | planType       | memberType              |
   #  | 15310 | qavgogine | qavgogine | testusername    | Combo_FED_SHIP | EPMPEnabled_ProfilePref |
      | 15310 | qavgogine | qavgogine | testusername    | Combo_PDP_SSUP | EPMPEnabled_ProfilePref |
      
  @memAuth_CommunicationPreferences05 @NoEPMPpreferences
  Scenario Outline: TID: <TID> - plan: <planType> - Verify use doesn't have Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
    When the user navigates to Profile and Preferences page
    And the user validates that Communication Preferences section does not display
      | Plan Type   | <planType>   |

    Examples: 
      | TID   | username  | password  | MemUserName     | planType               |
      | 15310 | qavgogine | qavgogine | testusername    | SSUP_ProfilePref       |
      | 15376 | qavgogine | qavgogine | testusername    | Terminated_ProfilePref |
      | 15308 || qavgogine | qavgogine | testusername     PCP_ProfilePref        |
      | 15308 | qavgogine | qavgogine | testusername    | MEDICA_ProfilePref     |
      
  @memAuth_CommunicationPreferences06 @CommunicationPreferencesMicroApp06 @F276629
  Scenario Outline: FID: <FID> -plan: <planType> - Verify Plan documents for SHIP with plan <planName>
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    Then the user navigates to Communication Preferences page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user validates that Communication Preferences section for Ship
      | Plan Name | <planName> |
    And the user select "US MAIL" for "Plan Documents"
    And the user click Terms and Conditions check box
    And the user click on the Save Preferences button
    And the user validate the success message
    And the user edit preference again
    And the user select "electronic delivery" for "Plan Documents"
    And the user click Terms and Conditions check box
    And the user click on the Save Preferences button
    Then a popup is displayed and validate the popup select Yes and submit
      | Plan Name | <planName> |
    And the user validate the success message

    Examples: 
      | FID    | username  | password  | MemUserName     | planType                 | memberType             | planName                      |
      | 276629 | qavgogine | qavgogine | testusername    | SHIP                     | SHIP_ProfilePref       | AARP MEDICARE SUPPLEMENT PLAN |
      | 276629 | qavgogine | qavgogine | testusername    | SHIP                     | COMBO_SHIP_ProfilePref | AARP GROUP HOSPITAL PLAN      |
      