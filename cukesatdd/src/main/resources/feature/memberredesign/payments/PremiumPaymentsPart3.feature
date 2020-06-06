Feature: 1.19 Verify the premium payment flows on member portal - Part 3 - Test case 14 to 21

   #Test Case 14 - AARP MAPD Plan member
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 14 - Verify More Than one Payment Per day error message
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "2.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time
    Then User navigates to payment confirmation page and verifies ConfirmationNo for One time
    And the user moves to Go to Payment History Page button
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "2.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time
    And the error is displayed on review payment page for second payment
    And Exception the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID   | planType | memberType             | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount | HouseholdID | paymentType |
      | 15142 | MAPD     | IndividualAarpPayments | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME |   1.12 | 90019633509 | OneTime     |

  #Test Case 15
  @regressionMember
  Scenario Outline: TID: <TID> -MemUserName: <member> - Test Case 15 - To validate the unauthorized error message in Edit EFT Payment flow for Member Auth User
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And memberauth user navigates to Payment Overview Page
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
    And CSR navigates to Review Payment Method Update screen and selects agreements and click on Authorize Monthly payments Button for EFT
    And the user is displayed with an error message on Edit Recurring EFT Review that he is not authorized

    Examples: 
      | TID   | username  | password  | member          | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | 15118 | qavgogine | qavgogine | q2_june_rto0002 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  #Test Case 16 - Any member will work
  @regressionMember
  Scenario Outline: TID: <TID> -MemUserName: <member> - Test Case 16 - To validate the error message when memberauth user tries to submit oneTime EFT Payment
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And memberauth user navigates to Payment Overview Page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "2.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time
    And the user is displayed with an error message that he is not authorized

    Examples: 
      | TID   | username  | password  | member    | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15118 | qavgogine | qavgogine | canrec001 | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME |   1.12 |

  #Test Case 17 - COMBO member - Needs a SHIP/HIP member with Setup Recurring Payment button and a Fed MAPD/PDP Plan member
  @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Test Case 17 - Verify Payment Submission for Combo member - Recurrung EFT for SHIP and One Time EFT for Federal
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    When the user navigates to Ship tab and validates the amount
    And user clicks on Setup Automatic payments on payment overview page for Ship
    And user Enters all Mandatory fields on form page and click on Electronic Signature and click on Contuine for Setup Recurring for Ship
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your Payment screen and selects agreements and click on Contuine Button for EFT Ship
    Then User navigates to payment confirmation page and verifies sucessful EFT for setup Recurring for Ship
    And the user moves to Go to Payment History Page button
    And user clicks on Federal Plan Tab
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "2.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time
    Then User navigates to payment confirmation page and verifies ConfirmationNo for One time
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID   | planType | memberType         | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount | HouseholdID | paymentType |
      | 15144 | COMBO    | COMBOAARPPayments2 | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME |   2.00 | 60023626906 | OneTime     |

  #Test Case 18 -Member with Recurring method already setup and with billing history
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 18 - Verify Payment Hisory Section and Cancel Model Popup for Fed Recurring EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate that Payment History Section and scrolls up
    And user clicks on Update Automatic payments on payment overview page
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID       | planType | memberType                |
      | US1463204 | MAPD     | UpdateRecurrStop_Payments |

  #Test Case 19 - Member with Recurring method already setup and with billing history
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 19 -Verify Payment Error Message for Recurring EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate that Payment History Section and scrolls up
    And user clicks on Update Automatic payments on payment overview page
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And the user clicks on Authorize button to validate error message

    Examples: 
      | UID       | planType | memberType                |
      | US1474255 | MAPD     | UpdateRecurrStop_Payments |

  #Test Case 20 - Any member will work
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 20 - Verify Payment Hisory Section and Cancel Model Popup for Fed One time EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate that Payment History Section and scrolls up
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "2.00" and selects Checking Account and click on Next button
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID       | planType | memberType                |
      | US1449078 | MAPD     | UpdateRecurrStop_Payments |

  #Test Case 21 -Any member will work
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 21 - Verify Payment Summary for OneTime payment Flow
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate that Payment History Section and scrolls up
    And user clicks on Make one time payment on payment overview page
    And the user validates the Payment Summary option on New page OTP

    Examples: 
      | UID       | planType | memberType                |
      | US1448800 | MAPD     | UpdateRecurrStop_Payments |

  #Test Case 22
  @DONOTRUN
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 22 -Verify SHIP member can view payment history.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to payment history
    Then user validates payment history section header exists
    Then user validates date range default is Last 90 days
    Then user validates default payment status selected option
    Then user validates payment table includes the most recent Payment Date information
    Then user validates LEARN MORE ABOUT YOUR PAYMENT HISTORY link
    Then user validates total date range options available
    Then user validates nonCustomSearch date range options
    Then user validates only paid rows display when paid selected
    Then user validates only unpaid rows display when unpaid selected
    Then user validates custom search with valid input
    Then user validates error message for custom search with to date earlier than from date
    Then user validates error message for custom search with no dates selected
    Then user validates error message for custom search with From and To date more than 24 months apart

    Examples: 
      | FID    | planType | memberType     |
      | 247601 | Ship     | PaymentHistory |
