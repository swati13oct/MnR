@accountProfile @codeMonkeys1 @thePredators
Feature: C1.2To test Profile and Preferences page .

  @accountProfile1 @CMNeedhelp
  Scenario Outline: To verify the NeedHelp Section On Account Profile page
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validates the need help section
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |

  @accountProfile2 @CMNeedhelpShip
  Scenario Outline: To verify the NeedHelp Section On Account Profile page for ship members
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validate the need help section for ship member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples: 
      | planType |
      | SHIP     |

  @accountProfile3 @CMValidatePlanNamemembernameIDAccountSectionUMS
  Scenario Outline: To verify Plan Name, Member name, Member ID and account section in UMS site
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile4 @CMPasswordEdit
  Scenario Outline: To verify the edit functionality in Account Profile section in UMS site
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    #Then the user validates the functionality of save Button
    Then the user validates the functionality of Cancel Button

    Examples: 
      | planType |
      | MAPD     |                    
      | PDP      |
      | SHIP     |

  @accountProfile5 @CMPasswordEdit1
  Scenario Outline: To verify the edit functionality in Account Profile section in UMS site without entering the mandatory fields
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    Then the user clicks on save button without filling current and new password and the red mandatory message should come

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile6 @CMPasswordEdit3
  Scenario Outline: To verify the edit functionality in Account Profile section in UMS site when user enters different password in confirm new password field
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    Then the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile7 @CMValidateEmail
  Scenario Outline: To verify Email section in member Redesign site
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Email section in UMS site

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile8 @CMEmailEdit1
  Scenario Outline: To verify Email edit functionality in Redesign site
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user clicks on edit button
    Then the user clicks on save without filling both fields then the user should see red mandatory message
    Then the user fill new email address and click save then user should see new updated email on page

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile9 @CMEmailEdit2
  Scenario Outline: To verify validations on email secton in member redesign site
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user clicks on edit button
    Then the user fill invalid email and clicks on save button then the user should see error message for invalid email
    Then the user fill different email id in confirm email box from new email address then error message should come

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile10 @CMPermanentAddress
  Scenario Outline: To verify the Permanent Address section
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates permanent address section
    And the user validates contact us statement

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |

  @accountProfile11 @CMCommunicationPreferences
  Scenario Outline: To verify Communication Preferences section
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
    And the user validates Go paperless button and on clicking button go green page should come

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile12 @CMPhone
  Scenario Outline: To verify Phone in Aarp site
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Phone section
    Then the user Clicks on the the Edit Link and validates the elements
    Then the user checks the Edit Button changes to Cancel Button
    Then the user checks the functionality of save Button in Phoneeditsection
    Then the user validate the functionality of Cancel Button In phoneeditSection

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |
      | SHIP     |

  @accountProfile13 @CMGoGreen
  Scenario Outline: To verify Go Green page
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates Go paperless button and on clicking button go green page should come
    Then the user validates the presence of Communication preferences header
    Then the user validates headers on green page
    Then the user validates the presence of Plan Name
    #Then the user validates the Note section
    Then the user validates the I have read checkbox and check it
    Then the user validates the Save Preferences Button
    Then the user validates the presence of Back to Profile and Preferences links

    Examples: 
      | planType |
      | MAPD     |
      | PDP      |

  #|SHIP      |
  @accountProfile14 @CMTemporaryaddress
  Scenario Outline: To verify Temporary address section
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the temporary address section
    Then the user validates the fields and Buttons of temp address section
    Then the user checks the Edit Button on the top changes to Cancel Button

    #Then the user validates the functionality of save Button in Temporary adrress section
    Examples: 
      | planType |
      | MAPD     |
      | PDP      |

  @accountProfile15 @CMTemporaryaddressShip
  Scenario Outline: To verify Temporary address section for a ship member
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validate the temporary address section for ship member

    Examples: 
      | planType |
      | SHIP     |

  @accountProfile16 @US957739
  Scenario Outline: To verify  the sections on Profile and Preferences page for a NOKIA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Presence of edit button in email section
    Then the user validates the Presence of edit button in Phone section
    Then the user validates the Presence of edit button in Temporary Address section
    Then the user validates the Presence of edit button in Mailing Address section

    Examples: 
      | planType | memberType |
      | MA       | NOKIA      |
      | MAPD     | NOKIA      |

  @accountProfile17 @thePredators @AprilRelease2018 @ProfilePageHSIDLinks
  Scenario Outline: To test the Profile Page after HSID login
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And I click the HEALTHSAFE ID PASSWORD link and validate username and password
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    And I click the HEALTHSAFE ID ACCOUNT RECOVERY AND SECURITY link

    Examples: 
      | planType |
      | MAPD     |

  @accountProfile18 @accountProfAndPref @regressionAccountProf&Pref 
  Scenario Outline: To test end to end regression scenario for account profile page aarp member
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    And the user validates the Email section in UMS site
      | Member Type | <memberType> |
    And the user validates the Phone section
      | Member Type | <memberType> |
    And the user Clicks on the the Edit phone Link and validates the elements
      | Member Type | <memberType> |
    Then the user validates Communication Preferences section
    And the user clicks on edit preferences link and validates the page
    And the user clicks on profile & preferences link to go back to Account settings page
    And the user validates the address section
      | Member Type | <memberType> |

    Examples: 
      | userType            | memberType |
      | MAPD_AARPIndividual | AARP       |

  @accountProfile19 @goGreen @regressionMember
  Scenario Outline: To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link and validates the page
    Then the user changes the online preference and saves the change

    Examples: 
      | userType           |
    #  | MAPD_AARP_GOGreen_Profilepref  |
     # | MA_AARP_GOGreen_Profilepref    |
      #| PDP_AARP_GOGreen_Profilepref   |
      #| MA_UHC_GOGreen_Profilepref     |
      #| MAPD_UHC_GOGreen_Profilepref   |
      #| MAPD_GROUP_GOGreen_Profilepref |

  @accountProfile20 @EPMPProfilePage
  Scenario Outline: To test end to end regression scenario for EPMP profile page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should see the communicationpreferncessection

    Examples: 
      | planType | memberType  |
      | MAPD     | EPMPEnabled |

  @accountProfile21 @EPMPProfilePageContactusInformation 
  Scenario Outline: To test end to end regression scenario for EPMP profile page
  #Removed from Regression as EPMP is still in the pipeline for development
 	Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #|data type    | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page   
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers

    Examples: 
      | planType | memberType  | dataType   |
      #| MAPD     | EPMPEnabled | Individual |

  @accountProfile22 @EMPMprofilePageForShip 
  Scenario Outline: To test end to end regression scenario for EPMP profile page for ship
   #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validate the email section on profile page for ship member
    And the user validate the Phone section on profile page for ship member
    And the user validate the Permanent Address section on profile page for ship member
    And the user validate the temporary section on profile page for ship member
	
    Examples: 
      | planType |
      #| SHIP    |

  @accountProfile23 @EPMPProfilePageContactusGroup
  Scenario Outline: To test end to end regression scenario for EPMP profile page for group members
   #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | data type   | <dataType>   |
    #|data type    | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should not be able to edit the Phone numbers section for specific group members
      | Group Plan Name | <GroupPlanName> |

    Examples: 
      | planType | memberType  | dataType | GroupPlanName  |
      #| MAPD     | EPMPEnabled | group    | HealthSelectRx |

  @accountProfile24 @regressionPCPMedica 
  Scenario Outline: To test end to end regression scenario for account profile page for PCP medica members
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I click the HEALTHSAFE ID PASSWORD link and validate username and password and verify edit password link
    Then I should see the breadcrumb  in the upper left side of the page
    And clicking the link should lead me back to the Account Settings page of the member site
    And the user validate the Email section in UMS site
    And the user fill new email address and click save then user should see new updated email on page
    And the user validates the Phone section
      | Member Type | <memberType> |
    And the user Clicks on the the Edit phone Link and validates the elements
      | Member Type | <memberType> |
    Then the user checks the functionality of save Button in Phoneeditsection
    Then the user validate the functionality of Cancel Button In phoneeditSection
    Then the user validates that  Communication Preferences section doesn't come for PCP medica member
    And the user validates the address section
      | Member Type | <memberType> |

    Examples: 
      | userType | memberType |
     # | PCP      | PCP_SouthFlorida_ProfilePref     |
      | Medica   | Medica_SouthFlorida_ProfilePref  |

  @accountProfile25 @regressionPreferencesForShip 
  Scenario Outline: To test end to end regression scenario for preferences of a SHIP member
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    Then the user validates that  Communication Preferences section comes up for Ship Member
    Then the user validates the Go Green page for a ship member

    Examples: 
      | userType |
     # | SHIP_ProfilePref     |

  @accountProfile26 @profilePageForTerminated
  Scenario Outline: To test end to end regression scenario for account profile  page for a terminated member
 #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | data type   | <dataType>   |
    When the user navigates to Profile and Preferences page
    And I should see the EPMP i frame on profile page
    And I should be able to see edit email address and to view read only HSID email
    And I should be able to view and edit phone numbers
    Then the user validates that  Communication Preferences section doesn't come for terminated members

    Examples: 
      | planType | memberType  | dataType   |
    #  | MAPD     | EPMPEnabled | Terminated |

  @accountProfile27 @EPMPpreferencesForComboOnProfile 
  Scenario Outline: To test end to end regression scenario for account profile and preferences for a combo member
  #Removed from Regression as EPMP is still in the pipeline for development
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Account Profile page and user validates the elements on individual tabs
    And I should see the combo tabs on Preferences page and user validates the elements on individual tabs

    Examples: 
      | planType | memberType  |
     # | Combo    | EPMPEnabled |
