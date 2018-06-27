@codeMonkeys1
Feature: C1.2To test Profile and Preferences page .

  @CMNeedhelp
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

  @CMNeedhelpShip
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

  @CMValidatePlanNamemembernameIDAccountSectionUMS
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

  @CMPasswordEdit
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

  @CMPasswordEdit1
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

  @CMPasswordEdit3
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

  @CMValidateEmail
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

  @CMEmailEdit1
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

  @CMEmailEdit2
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

  @CMPermanentAddress
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

  @CMCommunicationPreferences
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

  @CMPhone
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

  @CMGoGreen
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
  @CMTemporaryaddress
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

  @CMTemporaryaddressShip
  Scenario Outline: To verify Temporary address section for a ship member
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validate the temporary address section for ship member

    Examples: 
      | planType |
      | SHIP     |

  @US957739
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

  @thePredators @AprilRelease2018 @ProfilePageHSIDLinks
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

  @accountProfAndPref @regressionAccountProf&Pref @regression_06_06_18
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

  @goGreen @regression_06_06_18
  Scenario Outline: To verify Edit preferences section for Go Green
    Given login with following details logins in the member portal and validate elements
      | User Type | <userType> |
    When the user navigates to Profile and Preferences page
    And the user clicks on edit preferences link and validates the page
    Then the user changes the online preference and saves the change

    Examples: 
      | userType           |
      | MAPD_AARP_GOGreen  |
      | MA_AARP_GOGreen    |
      | PDP_AARP_GOGreen   |
      | MA_UHC_GOGreen     |
      | MAPD_UHC_GOGreen   |
      | MAPD_GROUP_GOGreen |

  @EPMPProfilePage
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

  @EPMPProfilePageContactusInformation @regression_06_06_18
  Scenario Outline: To test end to end regression scenario for EPMP profile page
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
      | MAPD     | EPMPEnabled | Individual |

  @profilePageForShip @regression_06_06_18
  Scenario Outline: To test end to end regression scenario for EPMP profile page
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validate the email section on profile page for ship member
    And the user validate the Phone section on profile page for ship member
    And the user validate the Permanent Address section on profile page for ship member
    And the user validate the temporary section on profile page for ship member

    Examples: 
      | planType |
      | SHIP     |
