@accountPreferences @thePredators @regressionMember
Feature: C1.2To test Preferences page

  @accountPreferences1 @CommunicationPreferences
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
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
      | TID   | planType                      |
      | 15311 | MAPD_AARP_GOGreen_Profilepref |
      | 15312 | MA_AARP_GOGreen_Profilepref   |
      | 15313 | PDP_AARP_GOGreen_Profilepref  |

  @accountPreferences2 @goGreen @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link
    Then the user changes the online preference and saves the change
    Then the user validates the functionality of updating the email on the iframe

    Examples: 
      | TID   | planType                       |
      | 15311 | MAPD_AARP_GOGreen_Profilepref  |
      | 15312 | MA_AARP_GOGreen_Profilepref    |
      | 15313 | PDP_AARP_GOGreen_Profilepref   |
      | 15314 | MAPD_UHC_GOGreen_Profilepref   |
      | 15315 | MA_UHC_GOGreen_Profilepref     |
      | 15316 | MAPD_GROUP_GOGreen_Profilepref |

  #-----------------------  SHIP Preferences tests ---------------------------------------------------
  @accountPreferences3 @F220921 @CommunicationPreferences
  Scenario Outline: FID: <FID> -Plan Type: <planType> - To verify Communication Preferences section for a SHIP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
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
      | FID    | planType         |
      | 220921 | SHIP_ProfilePref |

  @accountPreferences4 @EPMPpreferencesForComboOnProfile @regressionMember
  Scenario Outline: plan: <planType> - memberType: <EPMPEnabled_ProfilePref> - To test end to end regression scenario for account profile and preferences for a combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Preferences page and user validates the elements on individual tabs

    Examples: 
      | planType | memberType              |
      | Combo    | EPMPEnabled_ProfilePref |
      
  @accountPreferences5 @EPMPpreferencesForSSUPOnProfile @regressionMember
  Scenario Outline: plan: <planType> - To test end to end regression scenario for account profile and preferences for a combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
    When the user navigates to Profile and Preferences page
    And the user validates that  Communication Preferences section doesn't come for SSUP member

    Examples: 
      | planType               |
      | SSUP_ProfilePref       |
      | Terminated_ProfilePref |
      | PCP_ProfilePref        |
      | MEDICA_ProfilePref     |
      
  @accountPreferences6  @regressionMember @F276629
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Verify Plan documents and Welcome kit for SHIP
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
    When the user navigates to Profile and Preferences page
    Then the user navigates to Communication Preferences page
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
    And the user validate the success message
    Examples: 
      | FID    | planType |  planName                  |
      | 276629 | SHIP_MedSel_ProfilePref  | AARP MEDICARE SELECT PLAN |
