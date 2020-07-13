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
 
 #TC-Terminated
  @contactUs7 @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify terminated members view on contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user should only see the Technical Support and Plan Support components

    Examples: 
      | TID   | plantype | memberType                                |
      | 15207 | MA       | Terminated_Group_MA_NICE_ContactUs        |
      | 15208 | MAPD     | Terminated_Group_MAPD_COSMOS_ContactUs    |
      | 15210 | SSP      | Terminated_Group_SSP_ContactUs            |
      | 15214 | MA       | Terminated_Individual_MA_COSMOS_ContactUs |
      | 15217 | MAPD     | Terminated_Individual_MAPD_NICE_ContactUs |

#viewQuestions
   @contactUs10  @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify View qquestion button and common questions on the contactUS redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    And the user click on view questions button and validate the questions links
   | Plan Type   | <plantype>   |
    
    Examples: 
     | TID     | plantype | memberType  | 
     | 152244 | PCP      | ContactUsPCP |  
     | 152255  | MEDICA   | Individual_needHelp | 
     | 152201  | MAPD     | Ind_ContactUs |
     | US2438941 | MAPD     | TEXASERSGroup_ContactUs_SendMessage |
     | US2438941 | PHIP     | SHIPCLAIMS_ContactUs |
 

     @contactUs3 @GroupEmailAQuestionFiledValidations
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Group Email Widget Confirm Request in contact us redesign page with error messages
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user fill all the invalid details of Email a question widget and submit
      | Enquiry Type                   | <enquiryType>                   |
      | Alternative Email              | <alternativeEmailId>            |
      | ConfirmAlternative Email       | <confirmAlternativeEmailId>     |
      | AlternativePhone Number        | <alternativePhoneNumber>        |
      | ConfirmAlternativePhone Number | <confirmAlternativePhoneNumber> |
    And UI should be replaced by error messages
      | InavlidPhone ErrorMessage        | <inavlidPhoneErrorMessage>         |
      | InavlidConfirmPhone ErrorMessage | <inavlidAConfirmPhoneErrorMessage> |
      | InavlidEmail ErrorMessage        | <inavlidEmailErrorMessage>         |
      | InavlidConfirmEmail ErrorMessage | <inavlidAConfirmEmailErrorMessage> |

    Examples: 
      | TID   | plantype | memberType             | enquiryType         | alternativeEmailId | confirmAlternativeEmailId | alternativePhoneNumber | confirmAlternativePhoneNumber | inavlidPhoneErrorMessage                    | inavlidAConfirmPhoneErrorMessage                                                      | inavlidEmailErrorMessage                                        | inavlidAConfirmEmailErrorMessage                        |
      | 15380 | MAPD     | CALPERSGroup_ContactUs | Payment Information | abc                | xyz                       |                    123 |                           789 | Enter phone number like this: 111-111-1111. | Your confirmation alternative phone number and alternative phone number do not match. | Enter your email address like this: yourname@emailprovider.com. | Your email confirmation and email address do not match. |
      | 15380 | MAPD     | GEORGIAGroup_ContactUs | Payment Information |                    |                           |                        |                               | Enter phone number like this: 111-111-1111. | Your confirmation alternative phone number and alternative phone number do not match. | Enter your email address like this: yourname@emailprovider.com. | Your email confirmation and email address do not match. |
      
     
     