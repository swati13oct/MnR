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

#goToInboxButtonValidation
@contactUs4 @goToInbox @regressionMember
  Scenario Outline: TID: <TID>  -Member Type: <memberType> - Verify go To Inbox button on contactUS redesign page for opted in member
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then user validates go To Inbox button in redesign contact us page
    Examples: 
      | TID   | memberType   |
      | 15379 | MA_ContactUs |
      
 #Labels-TFN
  @contactUs4 @regressionMember
   Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify SHIP Member contactUs labels and telephone numbers
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then for Ship member validates labels and TFNs on the contactUS page
      | callUsSHIPTFN          | <callUsSHIPTFN>    |
      | generalQueTFN          | <generalQueTFN>    |
      | claimQueTFN            | <claimQueTFN>      |
  Examples: 
      | TID   | plantype | memberType           | callUsSHIPTFN     | generalQueTFN    | claimQueTFN |
      | 153845 | PHIP     | SHIPCLAIMS_ContactUs | 1-866-254-3132    | 1-800-523-5800   | 1-800-523-5880 |

#EmailUs
  @contactUs5 @regressionMember
   Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify SHIP Email Us Widget Confirm Request in contact us redesign page
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
      | TID   | plantype | memberType           | enquiryType | message | aarpMemberShipNumber | firstName | lastName | emailAddress   | confirmEmailAddress | date | month | year | expectedMessage                                                                                                                          |
      | 15380 | PHIP     | SHIPCLAIMS_ContactUs | Claims      | Testing |           1234567890 | test      | test     | test@optum.com | test@optum.com      |   01 |    01 | 1950 | We value your input and will be happy to answer your questions. A UnitedHealthcare Customer Service representative will respond shortly. |

#ClickToCallCancel
  @contactUs6 @regressionMember
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

 #LabelsAndTFN
 @contactUs8 @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <plantype> -Member Type: <memberType> - Verify labels and telephone number displaying on contact US page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <plantype>   |
      | Member Type | <memberType> |
    When the user navigates to contact us page in UHC site
    Then the user validates the labels and contact numebers on the page
     Then the pcp and Medica user validates the labels and contact numebers on the page
    | PlanType       | <plantype>       |
    | techSupportTFN | <techSupportTFN> |
    | planSupportTFN | <planSupportTFN> |

    Examples: 
      | TID   | plantype | memberType  | techSupportTFN     | planSupportTFN    |
      | 1522436 | PCP    | ContactUsPCP | 1-800-721-0627  |	1-866-231-7201  |
      | 152246 | MEDICA  | Individual_needHelp | 1-800-721-0627  |	1-800-407-9069  |


 #ClickToCall
 @contactUs9 @regressionMember
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
      | 15224 | MEDICA  | Individual_needHelp |  9999999999 | 999-999-9999      | We value your input and will be happy to answer your questions. A UnitedHealthcare® Customer Service representative will call you shortly at the number you provided |
 