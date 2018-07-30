@regression_06_06_18 @velocityDashers
Feature: V1.1To test Send us a question Widget and Click to call functionality in contact us redesign pages in UHCM site

  @secureEmailWidgetCancel
  Scenario Outline: Verify Secure Email Us Widget section in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates cancel click on secure email widget in redesign contact us page
      | New Email        | <newEmail>        |
      | NewConfirm Email | <newConfirmEmail> |

    Examples: 
      | plantype | memberType       | newEmail       | newConfirmEmail |
      | PDP      | IDCardmember     | test@optum.com | test@optum.com  |
      | MAPD     | IndividualMember | test@optum.com | test@optum.com  |

  @GroupEmailConfirmMessage
  Scenario Outline: Verify Group Email Widget Confirm Request in contact us redesign page
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
      | plantype | memberType    | enquiryType                 | alternativeEmailId | confirmAlternativeEmailId | alternativePhoneNumber | confirmAlternativePhoneNumber | expectedMessage                                                                                                                                                                 |
      | MAPD     | CALPERSGroup  | Payment Information         | test@optum.com     | test@optum.com            |             9999999999 |                    9999999999 | Thank you for your inquiry. We value your input, and would be happy to answer your questions. A Customer Service Advocate will review your question and respond to you shortly. |
      | MAPD     | GEORGIAGroup  | Finding a Pharmacy          | test@optum.com     | test@optum.com            |             9999999999 |                    9999999999 | Thank you for your inquiry. We value your input, and would be happy to answer your questions. A Customer Service Advocate will review your question and respond to you shortly. |
      | MAPD     | TEXASERSGroup | Updating Member information | test@optum.com     | test@optum.com            |             9999999999 |                    9999999999 | Thank you for your inquiry. We value your input, and would be happy to answer your questions. A Customer Service Advocate will review your question and respond to you shortly. |

  @GroupEmailAQuestionFiledValidations
  Scenario Outline: Verify Group Email Widget Confirm Request in contact us redesign page
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
      | plantype | memberType   | enquiryType         | alternativeEmailId | confirmAlternativeEmailId | alternativePhoneNumber | confirmAlternativePhoneNumber | inavlidPhoneErrorMessage                    | inavlidAConfirmPhoneErrorMessage                                                      | inavlidEmailErrorMessage                                        | inavlidAConfirmEmailErrorMessage                        |
      | MAPD     | CALPERSGroup | Payment Information | abc                | xyz                       |                    123 |                           789 | Enter phone number like this: 111-111-1111. | Your confirmation alternative phone number and alternative phone number do not match. | Enter your email address like this: yourname@emailprovider.com. | Your email confirmation and email address do not match. |
      | MAPD     | GEORGIAGroup | Payment Information |                    |                           |                        |                               | Enter phone number like this: 111-111-1111. | Your confirmation alternative phone number and alternative phone number do not match. | Enter your email address like this: yourname@emailprovider.com. | Your email confirmation and email address do not match. |

  @SHIPEmailUsFunctionality
  Scenario Outline: Verify SHIP Email Us Widget Confirm Request in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
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
      | plantype | memberType | enquiryType | message | aarpMemberShipNumber | firstName | lastName | emailAddress   | confirmEmailAddress | date | month | year | expectedMessage                                                                                                                          |
      | PHIP     | SHIPCLAIMS | Claims      | Testing |           1234567890 | test      | test     | test@optum.com | test@optum.com      |   01 |    01 | 1950 | We value your input and will be happy to answer your questions. A UnitedHealthcare Customer Service representative will respond shortly. |

  @goToInbox
  Scenario Outline: Verify go To Inbox button on contactUS redesign page for opted in member
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates go To Inbox button in redesign contact us page

    Examples: 
      | memberType      |
      | MA_AARP_GOGreen |

  @clickToCallCancel
  Scenario Outline: Verify clickToCall Widget Expansion (Drop-Down, Text Box and Button UI) and click on cancel on contactUS redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates clickToCallButton display on contactUS redesign page
    And user clicks on cancel button on Request a call widget
      | Phone Number | <phoneNumber> |

    Examples: 
      | plantype | memberType   | phoneNumber |
      | MAPD     | CALPERSGroup |  9999999999 |

  @clickToCallConfirmation
  Scenario Outline: Verify Click to Call Widget Drop-Down Request Routing and Confirmation message functionality on contactUS redesign page
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
      | plantype | memberType   | phoneNumber | formatPhoneNumber | expectedMessage                                                                                                                                                      |
      | MAPD     | CALPERSGroup |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |

  @sendUsQuestionPDP
  Scenario Outline: Verify sendUs A Question Widget page for PDP display section in contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates PDP page display in redesign contact us page

    Examples: 
      | plantype | memberType   |
      | PDP      | IDCardmember |

  @regressionContactUsForTerminatedMembers
  Scenario Outline: Verify terminated members view on contact us redesign page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user should only see the Technical Support and Plan Support components

    Examples: 
      | plantype | memberType                      |
      | MA       | Terminated_Group_MA_NICE        |
      | MAPD     | Terminated_Group_MAPD_COSMOS    |
      | SSP      | Terminated_Group_SSP            |
      | MA       | Terminated_Individual_MA_COSMOS |
      | MAPD     | Terminated_Individual_MAPD_NICE |
