@contactUs @velocityDashers
Feature: 1.16 Member Contact us Page

  @smokeTest @ContactUs
  Scenario Outline: VBF - Verify Click to Call and email Widget section on contact us page for Federal member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click
      | Phone Number | <phoneNumber> |
    Then user validates cancel click on secure email widget in redesign contact us page
    	
      | New Email        | <newEmail>        |
      | NewConfirm Email | <newConfirmEmail> |

    Examples: 
      | plantype | memberType    | newEmail       | newConfirmEmail | phoneNumber |
      | MAPD     | Ind_ContactUs | test@optum.com | test@optum.com  |  9999999999 |
      | MAPD     | Grp_ContactUs | test@optum.com | test@optum.com  |  9999999999 |

#SecureMessage-GetStarted1
@contactUs1 @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Widget section in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user should see Help With This Website and Help With Your Plan sections
    Then user validates cancel click on secure email widget in redesign contact us page
      | New Email        | <newEmail>        |
      | NewConfirm Email | <newConfirmEmail> |
      
    Examples: 
      | TID   | plantype | memberType                 | newEmail       | newConfirmEmail |
      | 15220 | PDP      | IndAARPPDP_Pharmacylocator | test@optum.com | test@optum.com  |
      | 15221 | MAPD     | Ind_ContactUs              | test@optum.com | test@optum.com  |
      
#SM-Grp+Indi-GoToInbox
 @contactUs2 @regressionMember
  Scenario Outline: UID: <UID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Message Page from contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user click on send a message in the secure email widget in redesign contact us page
    Then the user validates that the SSO secure message Page opens in a new window

    Examples: 
      | UID       | plantype | memberType                          | newEmail       | newConfirmEmail |
     | US1742688 | MAPD     | CALPERSGroup_ContactUs_SendMessage  | test@optum.com | test@optum.com  |
      | US1742688 | MAPD     | GEORGIAGroup_ContactUs_SendMessage  | test@optum.com | test@optum.com  |
      | US1742688 | MAPD     | TEXASERSGroup_ContactUs_SendMessage | test@optum.com | test@optum.com  |
      |	 152201   | MAPD     | Ind_ContactUs                       | test@optum.com | test@optum.com  |

#secureEmailMessageViaMessagesLink
 @contactUs3  @regressionMember
  Scenario Outline: UID: <UID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Message Page secondry pages via messengers link
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
	When the user navigates to contact us page in UHC site
    Then user click on account Profile dropdown and click the messages link
    Then the user validates SSO secure message Page via messages link from secondry pages opens in a new window
    Examples: 
      | UID       | plantype | memberType                          | newEmail       | newConfirmEmail |
      |	 152202   | MAPD     | Ind_ContactUs                       | test@optum.com | test@optum.com  |
