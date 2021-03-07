@memauth @theSpartans
Feature: S1.1 To test Member Auth Dashboard page.

  @memauth1 @memb
  Scenario Outline: To validate the error message for invalid user name and correct password or viseversa.
    Given the user is on member auth login page
    Then the member tries to login with invalid username and correct password and verify the error message
      | Username      | <username>     |
      | Password      | <password>     |
      | Error Message | <errormessage> |

    Examples: 
      | username  | password  | errormessage                                    |
      | qavgogine |           | Either your UserName or Password was incorrect. |
      |           | qavgogine | Either your UserName or Password was incorrect. |

  @memauth2
  Scenario Outline: To validate the contact us page through Member auth.
    Given the user is on member auth login page
      | Username | <username> |
      | Password | <password> |
    When I search for a member
      | Member | <member> |
    Then click on the member displayed in the search list
    And I will see the disclaimer text at top of the page
      | Disclaimer | <disclaimer> |
    And all SUBMIT buttons display message when clicked on contact us page
      | Message | <message> |

    Examples: 
      | username  | password  | member                               | disclaimer                                                                                                      | Message                          |
      | qavgogine | qavgogine | 4B152296-7C31-49C7-B49F-8739EB9A84A2 | You are viewing this site with member authorized read only access. Remember to LOGOUT at the end of the session | You are not authorized to submit |

  @memauth3 @regressionMemberAuth @regressionMember
  Scenario Outline: TC09_Save_Prefrences WRT member auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    Then the user navigates to profile and preference page
    And the user validates the save preference functionality WRT member auth
      | Error Mesage | <errorMessage> |

    Examples: 
      | username  | password  | member         | errorMessage                                                          |
      | qavgogine | qavgogine | q2_jun_uhc0008 | You are not authorized to change preferences on behalf of the member. |

  @memauth4 @regressionMemberAuth @regressionMember
  Scenario Outline: TC08_Edit_Temporary_Address WRT member auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    Then the user navigates to profile and preference page
    And the user validates edit temproray address functionality WRT member auth
      | Error Mesage | <errorMessage> |

    Examples: 
      | username  | password  | member         | errorMessage                                                            |
      | qavgogine | qavgogine | q2_jun_uhc0008 | you are not authorized to update the address number on behalf of member |

  @memauth5 @regressionMemberAuth @regressionMember
  Scenario Outline: TC07_Edit_alternative_Address WRT member auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    Then the user navigates to profile and preference page
    And the user validates edit alternative address functionality WRT member auth
      | Error Mesage | <errorMessage> |

    Examples: 
      | username  | password  | member         | errorMessage                                                            |
      | qavgogine | qavgogine | q2_jun_uhc0008 | you are not authorized to update the address number on behalf of member |

  @memauth6 @regressionMemberAuth @regressionMember
  Scenario Outline: TC06_Edit_Email WRT member auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    Then the user navigates to profile and preference page
    And the user validates edit email functionality WRT member auth
      | Error Mesage | <errorMessage> |

    Examples: 
      | username  | password  | member         | errorMessage                                                            |
      | qavgogine | qavgogine | q2_jun_uhc0008 | you are not authorized to update the email address on behalf of member. |

  @memauth6 @regressionMemberAuth @regressionMember
  Scenario Outline: TC05_Edit_Phone WRT member auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    Then the user navigates to profile and preference page
    And the user validates edit phone functionality WRT member auth
      | Error Mesage | <errorMessage> |

    Examples: 
      | username  | password  | member         | errorMessage                                                          |
      | qavgogine | qavgogine | q2_jun_uhc0008 | you are not authorized to update the phone number on behalf of member |

  @memauth7 @regressionMemberAuth @regressionMember
  Scenario Outline: TC18_Check EOB page is accessible using Member Auth Tool WRT member auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    Then the user click on EOB link and navigates to EOB page
    And the user slects the desired date range
      | Plan Type  | <planType>  |
      | Date Range | <dateRange> |
      | EOB Type   | <eobType>   |

    Examples: 
      | username  | password  | member          | planType | dateRange | eobType      |
      | qavgogine | qavgogine | q2_jun_aarp0101 | PDP      | 18 Months | Prescription |

  @memauth8 @MemberAuth_PharmacyLocatorDefaultZip @regressionMember
  Scenario Outline: To validate Pharmacy Locator view for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    When the user navigates to pharmacy search page on member site
    And the user enters distance details in Redesign site
      | Distance | <distance> |
    And the user selects Pharmacy Types to Filter in Redesign Site
      | Pharmacy Type | <pharmacyType> |
    Then the user validates the pharmacies available in Redesign site
    And the user Validates show on map link in Redesign Site
    And the user validate more information content based on plan type in Redesign Site

    #    And the user Validates view search PDF link in Redesign Site
    Examples: 
      | username  | password  | MemUserName     | distance | pharmacyType  |
      | qavgogine | qavgogine | q2_jun_aarp0017 |       25 | Open 24 hours |

  @memauth9 @MemberAuth_PharmacyLocatorValidateLanguage @regressionMember
  Scenario Outline: To validate Pharmacy Locator Multiple Language and Zipcode entry for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    When the user navigates to pharmacy search page on member site
    Then the user validates the pharmacies available in Redesign site
    When the user Selects Chinese Language in Redesign Site
    Then the user searches multi lang for pharmacy search results available in Redesign site
    When the user Selects Spanish Language in Redesign site
    Then the user searches multi lang for pharmacy search results available in Redesign site

    Examples: 
      | username  | password  | MemUserName     |
      | qavgogine | qavgogine | q2_jun_aarp0017 |

  @memauth10 @MemberAuth_OrderMaterialsErrorMessage @regressionMember
  Scenario Outline: To validate Order Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    When the user views order materials in Member Redesign Order Materials page
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    Then the user validates CSR error message for Order Submission
      | CSR Error | <csrError> |

    Examples: 
      | username  | password  | MemUserName     | planType | option              | csrError                             |
      | qavgogine | qavgogine | q2_jun_aarp0101 | MAPD     | Replacement ID card | are not authorized to order material |

  @memauth11 @MemberAuthFederalOneTimeCC @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To validate One Time CC Payment Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Make one time payment on payment overview page
    And user selects Amount due today and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to Member Auth One Time payment overview and validates error message for Make one time payemnt
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                        | Name | CreditCardNumber | validMonth | validYear | csrError              |
      | F243897 | qavgogine | qavgogine | MAPD     | MAPD_MakePaymentsCCTotal_Payments | Test | 4111111111111111 |         04 |      2019 | are not authorized to |

  @memauth12 @MemberAuthFederalSetupRecurrEFT @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To validate Set up Recurring EFT Payment Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Set up Automatic payments on payment overview page
    And user selects checking Account on Setup Automatic recurring payments page and Click on Next
    And user Enters all Mandatory fields on form page and click on Authorize button
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Member Auth Recurring payment overview and validates error message for Make one time payemnt
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | csrError              |
      | F243897 | qavgogine | qavgogine | MAPD     | MAPD_SetupRecEFT_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | are not authorized to |

  @memauth13 @MemberAuthFederalSetupRecurrCC @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To validate Setup Recurring CC Payment Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Set up Automatic payments on payment overview page
    And user selects CreditDebit Card on Setup Automatic recurring payments page and Click on Next
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Recurring
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to Member Auth Recurring payment overview and validates error message for Make one time payemnt
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType               | Name | CreditCardNumber | validMonth | validYear | csrError              |
      | F243897 | qavgogine | qavgogine | MAPD     | MAPD_SetupRecCC_Payments | Test | 4111111111111111 |         04 |      2019 | are not authorized to |

  @memauth14 @MemberAuthFederalUpdateRecurrEFT @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - Verify Update Recurring for Checking Account Payment Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Update Automatic payments on payment overview page
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And user Enters all Mandatory fields on form page and click on Authorize button for Update Recurring
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Member Auth Update Review Page and validates error message for Submit or Continue
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                    | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | csrError              |
      | F243897 | qavgogine | qavgogine | MAPD     | MAPD_UpdateRecurrEFT_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | are not authorized to |

  @memauth15 @MemberAuthFederalUpdateRecurrCC @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To Verify Update Recurring for CC Payment Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Update Automatic payments on payment overview page
    And user selects CreditDebit Card on Update Automatic recurring payments page and Click on Next
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Update Recurring
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to Member Auth Update Review Page and validates error message for Submit or Continue
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                   | Name | CreditCardNumber | validMonth | validYear | csrError              |
      | F243897 | qavgogine | qavgogine | MAPD     | MAPD_UpdateRecurrCC_Payments | Test | 4111111111111111 |         04 |      2019 | are not authorized to |

  @memauth16 @MemberAuthUpdateRecurrStopFed @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To validate STOP Recurring Update Payement Submission Error for Member Auth for Fed Member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Update Automatic payments on payment overview page
    And user clicks on Stop Automatic payments and clicks on next for Federal
    And user navigates to Member Auth Update Review Page and validates error message for Submit or Continue
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                     | csrError              |
      | F243897 | qavgogine | qavgogine | MAPD     | MAPD_UpdateRecurrStop_Payments | are not authorized to |

  @memauth17 @MemberAuthUpdateRecurrStopSHIP @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To validate SHIP STOP Recurring Update Payement Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Update Automatic payments on payment overview page for Ship
    And user selects Stop Automatic Recurring Payments and Click on Next
    And user navigates to Member Auth Update Review Page and validates error message for Submit or Continue
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                                 | csrError              |
      | F243897 | qavgogine | qavgogine | SHIP     | SHIP_IndividualSHIPPaymentsUpdate_Payments | are not authorized to |

  @memauth18 @MemberAuthUpdateRecurrEFTSHIP @MemberAuth_Payments @fastandfurious @Feb_release_2019
  Scenario Outline: UserStory: <UID>, Plan Type: <planType>, Member Type: <memberType> - To validate SHIP Update Recurring Paymnet EFT Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Searches for the Username as per the membertype provided
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on member to select
    Then the user navigates to payment history
    And user clicks on Update Automatic payments on payment overview page for Ship
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And user Enters all Mandatory fields on form page and click on Electronic Signature and click on Contuine for Update Recurring for Ship
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Member Auth Update Review Page and validates error message for Submit or Continue
      | CSR Error | <csrError> |

    Examples: 
      | UID     | username  | password  | planType | memberType                                 | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | csrError              |
      | F243897 | qavgogine | qavgogine | SHIP     | SHIP_IndividualSHIPPaymentsUpdate_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | are not authorized to |

  @memAuthProd
  Scenario Outline: Plan Type: <planType>, Member Type: <memberType> - To validate SHIP Update Recurring Paymnet EFT Submission Error for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to profile and preference page
    And the user validates the profile page and the preference page and navigates to claims page in prod
      | Plan Type | <planType> |
    And the user validates the claims page and navigates to eob page in prod
      | Plan Type    | <planType>    |
      | Claim Period | <claimPeriod> |
    And the user validates the EOB page and navigates to benefits and coverage page in prod
      | Date Range | <dateRange> |
      | Plan Type  | <planType>  |
    And the user validates the benefits and coverage page in prod
      | Plan Type | <planType> |
    And the user navigates to the documents and resources page and validates PDFs in prod
      | Plan Type | <planType> |
    And the user navigates to the order plan materials page and validates in prod
      | Plan Type | <planType> |
    And the user navigates to payments page and validates in prod
      | Plan Type | <planType> |

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange         |
      | F243897 | ashah120 | Mnrqa002 | DSOADY17    | MAPD     | Last 24 months | Last 18 months    |
      | F243897 | ashah120 | Mnrqa002 | TARA9       | PDP      | Last 24 months | Last 18 months    |
      | F243897 | ashah120 | Mnrqa002 | TARA9       | SHIP     | Last 24 months | Last 12-18 months |