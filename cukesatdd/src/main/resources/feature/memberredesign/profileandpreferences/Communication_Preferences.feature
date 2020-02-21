@CommunicationPreferences @thePredators 
Feature: 1.03 Member Preferences page

  #----- beginning of VBF preferences scenarios section ------------------
  @vbfGate
  Scenario Outline:Plan Type: <planType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And the user validates preferences page for non epmp

    Examples: 
      | memberType      |
      | AARPMapdNonEPMP | 
     
  @vbfGate
  Scenario Outline:Plan Type: <planType> -To verify Plan Name, Member name, Member ID and account section
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And the user validates the Plan Name, Member name, Member ID and account section
    And I validate the healthsafe ID links
    And I should see the communication prefernces section
    
    Examples: 
     | memberType      |
     | AARPMapdNonEPMP |
        
   #----- end of VBF preferences scenarios section ------------------
 
  #----- beginning of Regression preferences scenarios section ------------------------
  #-------------------------
  # note: preferences ALM cases
  # TID: 15311 - TC01_AARP _MAPD_Go_Green
  # TID: 15312 - TC02_AARP_MA_Go_Green
  # TID: 15313 - TC03_AARP_PDP_Go_Green
  # TID: 15314 - TC04_UHC_MAPD_Go_Green
  # TID: 15315 - TC05_UHC_MA_Go_Green
  # TID: 15316 - TC06_UHC_Group_MA_GoGreen
  # TID: 15308 - TC7_PCP_Medica_SSUP_GoGreen should not come
  # TID: 15310 - TC8_PDP_PDP+SSUP_GoGreen should come
  # TID: 15309 - TC9_Ship_GoGreen should come
  # TID: 15376 - TC10_Terminated view member
  #-------------------------  
  @CommunicationPreferences01 @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Segment ID: <segmentId> - To verify Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
      | User Selection | <userSelection> |
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section
    Then the user validates Communication Preferences section
    Then the user validates the presence of Communication preferences header
    And the user clicks on edit preferences link
    Then the user validates headers on Preferences page
    #Then I can validate the segment ID value in localStorage on preference page
    #  | Plan Type  | <planType>  |
    #  | Segment ID | <segmentId> |
    Then the user validates the presence of Plan Name on Communication Preferences Page
    And the user validates the iframe on Communication Preferences Page
    Then the user validates the I have read checkbox and check it
    Then the user validates the Save Preferences Button
    Then the user validates the Note Section on Preferences Page
    Then the user validates the presence of Back links on Preferences page

     Examples: 
      | TID   | userSelection | planType                         | segmentId |  
      | 15311 | xxxxx         | MAPD_AARP_GOGreen_Profilepref    | 000       |
      | 15312 | xxxxx         | MA_AARP_GOGreen_Profilepref      | 000       |
      | 15313 | xxxxx         | PDP_AARP_GOGreen_Profilepref     | 000       |
     #note: need user data with segment id non-000 AND EPMP enabled for below case
     #| xxxxx | xxxxx         | MA_001_AARP_GOGreen_Profilepref  | 001       |
      
  @CommunicationPreferences02 @goGreen @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
      | User Selection | <userSelection> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link
    Then the user changes the online preference and saves the change
    Then the user validates the functionality of updating the email on the iframe

    @smokeTest @MemberVBF @smokeTest_GoGreenEPMP @rallyDashboard @testharness
    Examples: 
      | TID   | userSelection | planType                        | 
      | 15311 | xxxxx         | MAPD_AARP_GOGreen_Profilepref   |

    Examples: 
      | TID   | userSelection | planType                        |
      | 15312 | xxxxx         | MA_AARP_GOGreen_Profilepref     | 
      | 15313 | xxxxx         | PDP_AARP_GOGreen_Profilepref    |
      | 15314 | xxxxx         | MAPD_UHC_GOGreen_Profilepref    |
      | 15315 | xxxxx         | MA_UHC_GOGreen_Profilepref      |
      | 15316 | xxxxx         | MAPD_GROUP_GOGreen_Profilepref  |

  #-----------------------  SHIP Preferences tests ---------------------------------------------------
  @CommunicationPreferences03 @CommunicationPreferencesMicroApp03 @F220921 @regressionMember
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

	@devRegression @mocked
    Examples: 
      | TID    | userSelection           | planType | memberType       |
      | 15309  | SHIP-q1_feb_ship_20_001 | SHIP     | SHIP_ProfilePref |

  @CommunicationPreferences04 @EPMPpreferencesForComboOnProfile @regressionMember
  Scenario Outline: TID: <TID> - plan: <planType> - memberType: <memberType> - To test end to end regression preferences scenario for combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Preferences page and user validates the elements on individual tabs

    Examples: 
      | TID   | planType       | memberType              |
   #  | 15310 | Combo_FED_SHIP | EPMPEnabled_ProfilePref |
      | 15310 | Combo_PDP_SSUP | EPMPEnabled_ProfilePref |
      
  @CommunicationPreferences05 @NoEPMPpreferences @regressionMember
  Scenario Outline: TID: <TID> - plan: <planType> - Verify use doesn't have Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
    When the user navigates to Profile and Preferences page
    And the user validates that Communication Preferences section does not display
      | Plan Type   | <planType>   |

    Examples: 
      | TID   | planType               |
      | 15310 | SSUP_ProfilePref       |
      | 15376 | Terminated_ProfilePref |
      | 15308 | PCP_ProfilePref        |
      | 15308 | MEDICA_ProfilePref     |
      
  @CommunicationPreferences06 @CommunicationPreferencesMicroApp06 @regressionMember @F276629
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
      | FID    | planType                 | memberType             | planName                      |
      | 276629 | SHIP                     | SHIP_ProfilePref       | AARP MEDICARE SUPPLEMENT PLAN |
      | 276629 | SHIP                     | COMBO_SHIP_ProfilePref | AARP GROUP HOSPITAL PLAN      |
      