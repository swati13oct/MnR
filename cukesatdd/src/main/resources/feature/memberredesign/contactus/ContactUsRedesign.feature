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

  @contactUs1 @secureEmailWidgetCancel @regressionMember
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
     # | 15220 | PDP      | IndAARPPDP_Pharmacylocator | test@optum.com | test@optum.com  |
      | 15221 | MAPD     | Ind_ContactUs              | test@optum.com | test@optum.com  |

  #Below scenario @contactUs2  and @contactUs3 for CalPERs, Texas ERS and GA DCH are obsolete. Replaced with @contactUs10 and @contactUs11
  @contactUs2 @GroupEmailConfirmMessage
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Group Email Widget Confirm Request in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user fill all the details of Email a question widget and submit
      | Enquiry Type                   | <enquiryType>                   |
      | Alternative Email              | <alternativeEmailId>            |
      | ConfirmAlternative Email       | <confirmAlternativeEmailId>     |
      | AlternativePhone Number        | <alternativePhoneNumber>        |
      | ConfirmAlternativePhone Number | <confirmAlternativePhoneNumber> |
    And UI should be replaced by a confirmation display
      | Expected Message | <expectedMessage> |

    Examples: 
      | TID   | plantype | memberType              | enquiryType                 | alternativeEmailId | confirmAlternativeEmailId | alternativePhoneNumber | confirmAlternativePhoneNumber | expectedMessage                                                                                                                                                                 |
      | 15323 | MAPD     | CALPERSGroup_ContactUs  | Payment Information         | test@optum.com     | test@optum.com            |             9999999999 |                    9999999999 | Thank you for your inquiry. We value your input, and would be happy to answer your questions. A Customer Service Advocate will review your question and respond to you shortly. |
      | 15324 | MAPD     | GEORGIAGroup_ContactUs  | Finding a Pharmacy          | test@optum.com     | test@optum.com            |             9999999999 |                    9999999999 | Thank you for your inquiry. We value your input, and would be happy to answer your questions. A Customer Service Advocate will review your question and respond to you shortly. |
      | 15218 | MAPD     | TEXASERSGroup_ContactUs | Updating Member information | test@optum.com     | test@optum.com            |             9999999999 |                    9999999999 | Thank you for your inquiry. We value your input, and would be happy to answer your questions. A Customer Service Advocate will review your question and respond to you shortly. |

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

 
  # This test case will be executed once email id is updated to Kana test email address(aarpmemberadvantages.kanatest@optum.com)
  @contactUs4 @SHIPEmailUsFunctionality 
   Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify SHIP Email Us Widget Confirm Request in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then validates labels on the contactUS page for SHIP member
    Then user fill all the email Form details and submit
      | Enquiry Type          | <enquiryType>          |
      | Message               | <message>              |
      | AARPMembership Number | <aarpMemberShipNumber> |
      | First Name            | <firstName>            |
      | Last Name             | <lastName>             |
      | First Name            | <firstName>            |
      | Email Address         | <emailAddress>         |
      | ConfirmEmail Address  | <confirmEmailAddress>  |
      | Date                  | <date>                 |
      | Month                 | <month>                |
      | Year                  | <year>                 |
    And UI should be replaced by success request received
      | Expected Message | <expectedMessage> |

    Examples: 
      | TID   | plantype | memberType           | enquiryType | message | aarpMemberShipNumber | firstName | lastName | emailAddress   | confirmEmailAddress | date | month | year | expectedMessage                                                                                                                          |
      | 15380 | PHIP     | SHIPCLAIMS_ContactUs | Claims      | Testing |           1234567890 | test      | test     | test@optum.com | test@optum.com      |   01 |    01 | 1950 | We value your input and will be happy to answer your questions. A UnitedHealthcare Customer Service representative will respond shortly. |

  @contactUs5 @goToInbox @regressionMember
  Scenario Outline: TID: <TID>  -Member Type: <memberType> - Verify go To Inbox button on contactUS redesign page for opted in member
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates go To Inbox button in redesign contact us page

    Examples: 
      | TID   | memberType   |
      | 15379 | MA_ContactUs |

  @contactUs6 @clickToCallCancel @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> -  Verify clickToCall Widget Expansion -Drop-Down, Text Box and Button UI- and click on cancel on contactUS redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on cancel button on Request a call widget
      | Phone Number | <phoneNumber> |

    Examples: 
      | TID   | plantype | memberType             | phoneNumber |
      | 15224 | MAPD     | CALPERSGroup_ContactUs |  9999999999 |

  @contactUs7 @clickToCallConfirmation @rgressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click
      | Phone Number | <phoneNumber> |
    And UI should be replaced by a success confirmation display
      | Format Phone Number | <formatPhoneNumber> |
      | Expected Message    | <expectedMessage>   |

    Examples: 
      | TID   | plantype | memberType             | phoneNumber | formatPhoneNumber | expectedMessage                                                                                                                                                      |
      | 15224 | MAPD     | CALPERSGroup_ContactUs |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |

  @contactUs8 @sendUsQuestionPDP @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> -  Verify send Us A Question Widget page for PDP display section in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates PDP page display in redesign contact us page

    Examples: 
      | TID   | plantype | memberType                 |
      | 15219 | PDP      | IndAARPPDP_Pharmacylocator |

  @contactUs9 @regressionContactUsForTerminatedMembers @regressionMember
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

  @contactUs10 @secureEmailMessageSSOpage @GroupMember @F282564 @regressionMember
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
      
        @contactUs10 @secureEmailMessageViaMessagesLink @regressionMember
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
       @contactUs10 @secureMessageFromRally @regressionMember12
      Scenario Outline: UID: <UID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Message Page from Rally dashboard page via messengers link
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
	When the user navigates to contact us page in UHC site
    Then user navigate to rally dashboard page and click on account Profile dropdown 
    Then the user validates SSO secure message Page via messages link from secondry pages opens in a new window

    Examples: 
      | UID       | plantype | memberType                          | newEmail       | newConfirmEmail |
      |	 152203   | MAPD     | Ind_ContactUs                       | test@optum.com | test@optum.com  |
      
  @contactUs11 @secureEmailWidgetCancel @GroupMember @F282564
  Scenario Outline: UID: <UID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Secure Email Us Widget section in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates cancel click on secure email widget in redesign contact us page
      | New Email        | <newEmail>        |
      | NewConfirm Email | <newConfirmEmail> |

    Examples: 
      | UID       | plantype | memberType                         | newEmail       | newConfirmEmail |
      | US1742771 | MAPD     | CALPERSGroup_ContactUs_GetStarted  | test@optum.com | test@optum.com  |
      | US1742771 | MAPD     | GEORGIAGroup_ContactUs_GetStarted  | test@optum.com | test@optum.com  |
      | US1742771 | MAPD     | TEXASERSGroup_ContactUs_GetStarted | test@optum.com | test@optum.com  |
      
      
       @contactUs7  @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then the user validates the labels and contact numebers on the page
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on Request Confirmation Click
      | Phone Number | <phoneNumber> |
    And UI should be replaced by a success confirmation display
      | Format Phone Number | <formatPhoneNumber> |
      | Expected Message    | <expectedMessage>   |

    Examples: 
      | TID   | plantype | memberType  | phoneNumber | formatPhoneNumber | expectedMessage                                                                                                                                                      |
      | 152243 | PCP    | ContactUsPCP |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |
      | 15224 | Medica  | Individual_needHelp |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |

        @contactUs8 @validateLabelsonContactUsPage @regressionMember
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
      
      
     
     