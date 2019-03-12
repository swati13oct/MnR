@payments
Feature: To test the payment flow on Member site

  @paymentsFInal @paymentsOneTimePayments @regressionMember @payment1
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify if the user is able to make one time payment.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to payment history
    And the user clicks on One Time Payment button
    And the user makes one time payment and navigate futher
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the payment in AARP site

    Examples: 
      | TID   | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15118 | MAPD     | IndividualUHCPayments   | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      | 15143 | SHIP     | IndividualAARPSPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsAutoPay @15301 @regressionMember @payment2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Recurring Payment for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History and Scrolls up
    And the user clicks on Edit Automatic Payment button
    And the user makes auto payment in AARP site
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Autopayment in UHC site

    Examples: 
      | TID   | planType | memberType            | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15118 | MAPD     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsMoreThanOnePay @15142 @regressionMember @payment3
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify More Than one Payment Per day error message
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History and Scrolls up
    And the user clicks on Make One Time Payment button
    And the user makes one time payment and navigate futher
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Autopayment in UHC site
    And the user moves to Go to Payment History Page button
    And the user clicks on Make One Time Payment button
    And the user makes one time payment and navigate futher
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Autopayment in UHC site

    Examples: 
      | TID   | planType | memberType             | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15142 | MAPD     | IndividualAarpPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.12 |

  #NOTE: Nov2018 - q2_jun_aarp0057 didn't work, swap to use other user
  @TestmemberAuth @15170 @regressionMember @payment4
  Scenario Outline: TID: <TID> -MemUserName: <MemUserName> - To validate the Edit Payment flow for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And User Clicks on the Pop up displayed
    Then User Scrolls down to validate Payment History and Scrolls up
    And the user clicks on MemAuth Edit Automatic Payment button

    Examples: 
      | TID   | username  | password  | MemUserName     |
      | 15118 | qavgogine | qavgogine | q2_jun_aarp0058 |

  #NOTE: Nov2018 - q2_jun_uhc0042 didn't work, swap to use other user
  @TestmemberAuthOTP @15163 @regressionMember @payment5
  Scenario Outline: TID: <TID> -MemUserName: <MemUserName> - To validate the oneTime Payment flow for Member Auth
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And User Clicks on the Pop up displayed
    Then User Scrolls down to validate Payment History and Scrolls up
    And the user clicks on Make One Time Payment button
    And the user makes one time payment and navigate futher
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Submit disabled in Member site

    Examples: 
      | TID   | username  | password  | MemUserName   | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15118 | qavgogine | qavgogine | q4_dec_uhc150 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.12 |

  @paymentsShip @15320 @regressionMember @payment6
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Recurring Payment for SHIP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Ship Recurring payment history
    Then User Scrolls down to validate Payment History and Scrolls up
    And the user clicks on Edit Automatic Payment button
    And the user makes auto payment in AARP site
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Autopayment in UHC site

    Examples: 
      | TID   | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15320 | SHIP     | IndividualAARPSPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsCombo @15144 @regressionMember @payment7
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Payment for Combo member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Combo payment history page
    When the user navigates to Ship tab and validates the amount
    Then User Scrolls down to validate Payment History and Scrolls up
    And the user clicks on Edit Automatic Payment button
    And the user makes auto payment in AARP site
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Autopayment in UHC site
    And the user moves to Go to Payment History Page button
    And the user clicks on Make One Time Payment button
    And the user makes one time payment and navigate futher
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the Autopayment in UHC site

    Examples: 
      | TID   | planType | memberType         | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | 15144 | COMBO    | COMBOAARPPayments2 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsAutoPayCancel @US1463204 @Feb_release_2019 @Spartans @payment8
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Verify Cancel Model PopUP for Recurring EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow Edit Automatic Payment button
    And the user selects the Checking account option on New page
    And the user clicks on cancel button in Recurring EFT flow

    Examples: 
      | UID       | planType | memberType                |
      | US1463204 | MAPD     | UpdateRecurrStop_Payments |

  @paymentsErrorMessage @US1474255 @Feb_release_2019 @Spartans @payment9
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Verify Payment Error Message for Recurring EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow Edit Automatic Payment button
    And the user selects the Checking account option on New page
    And the user clicks on Authorize button to validate error message

    Examples: 
      | UID       | planType | memberType                |
      | US1474255 | MAPD     | UpdateRecurrStop_Payments |

  @paymentsCancelButton @US1449078 @Feb_release_2019 @Spartans @payment10
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Verify Cancel Model PopUP for OneTime Payment
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow OneTime Payment button
    And the user selects the Checking account option on New page OTP
    And the user clicks on cancel button on Make one time flow

    Examples: 
      | UID       | planType | memberType                |
      | US1449078 | MAPD     | UpdateRecurrStop_Payments |

  @BalanceSummaryValidation @US1448800 @Feb_release_2019 @Spartans @payment11
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Verify Payment Summary for OneTime payment Flow
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow OneTime Payment button
    And the user validates the Payment Summary option on New page OTP

    Examples: 
      | UID       | planType | memberType                |
      | US1448800 | MAPD     | UpdateRecurrStop_Payments |

  @paymentsEndtoEnd @US1483885 @Feb_release_2019 @Spartans @payment12
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Verify oneTime Payment submission Checking Account
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow OneTime Payment button
    And the user selects the Checking account option on New page OTP
    And the user makes one time payment in new flow and navigate further
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the New flow OneTimePayment in UHC site

    Examples: 
      | UID       | planType | memberType            | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | US1483885 | MAPD     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  @paymentsAutoPayEndtoEnd @Feb_release_2019 @Spartans @payment13
  Scenario Outline: Verify AutoPay Payment submission for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow Edit Automatic Payment button
    And the user selects the Checking account option on New page
    And the user makes one time payment in new flow and navigate further
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user confirms the New flow OneTimePayment in UHC site

    Examples: 
      | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | MAPD     | IndividualAARPRPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  @paymentsAutoPayCC @Feb_release_2019 @Spartans @payment14
  Scenario Outline: Verify AutoPay CC Payment submission for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow Edit CC Automatic Payment button
    And the user selects the Setup AutoCreditCard option on New page
    And the user makes Auto payment in CC flow and navigate further
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |

    #And the user confirms the New flow OneTimePayment in UHC site
    Examples: 
      | planType | memberType              | Name | CreditCardNumber |
      | PDP      | IndividualAARPCPayments | Test | 4111111111111111 |

  @payment15 @paymentHistoryShip @Apr_release_2019 @thePredators @F247601
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Verify SHIP member can view payment history.
    """
    This scenario covers the following user-stories in F247601
    US1474717,US1474718,US1474731,US1474719,US1474720
    US1474722,US1474723,US1474725,US1474726,US1474727
    Open item: 
    -Custom Search option text not visible 
    -got server error when filter result in no row (e.g. Current Year filter option got server error)
    -paid and unpaid filters behavior unstable 
    """

    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to payment history
    Then user validates payment history section header exists
    Then user expands show payment history for supplement insurance plan section
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
