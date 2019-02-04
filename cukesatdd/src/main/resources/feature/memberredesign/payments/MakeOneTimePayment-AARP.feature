@payments
Feature: To test the payment flow on Member site

  @paymentsFInal @paymentsOneTimePayments @regressionMember @payment1
  Scenario Outline: Verify if the user is able to make one time payment.
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
      | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | MAPD     | IndividualUHCPayments   | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      #   | SHIP     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      | SHIP     | IndividualAARPSPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsAutoPay @15301 @regressionMember @payment2
  Scenario Outline: Verify Recurring Payment for Different Types of Member
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
      | planType | memberType            | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | MAPD     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsMoreThanOnePay @15142 @regressionMember @payment3
  Scenario Outline: Verify More Than one Payment Per day error message
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
      | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | MAPD     | IndividualAARPRPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.12 |

  #NOTE: Nov2018 - q2_jun_aarp0057 didn't work, swap to use other user
  @TestmemberAuth @15170 @regressionMember @payment4
  Scenario Outline: To validate the Edit Payment flow for Member Auth
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
      | username  | password  | MemUserName     |
      #| qavgogine | qavgogine | q2_jun_aarp0057 |
      | qavgogine | qavgogine | q2_jun_aarp0058 |

  #NOTE: Nov2018 - q2_jun_uhc0042 didn't work, swap to use other user
  @TestmemberAuthOTP @15163 @regressionMember @payment5
  Scenario Outline: To validate the oneTime Payment flow for Member Auth
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
      | username  | password  | MemUserName    | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      # | qavgogine | qavgogine | q2_jun_uhc0042 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.12 |
      | qavgogine | qavgogine | q2_jun_uhc0043 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.12 |

  @paymentsShip @15320 @regressionMember @payment6
  Scenario Outline: Verify Recurring Payment for SHIP member
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
      | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | SHIP     | IndividualAARPSPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  #NOTE: Nov2018 - q2_june_combo0012 didn't work, swap to use other user
  @paymentsCombo @15144 @regressionMember @payment7
  Scenario Outline: Verify Payment for Combo member
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
      | planType | memberType         | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      # | COMBO    | COMBOAARPPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      | COMBO    | COMBOAARPPayments2 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsAutoPayCancel @US1463204 @Feb_release_2019 @Spartans @payment8
  Scenario Outline: Verify Recurring Payment cancellation for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow Edit Automatic Payment button
    And the user selects the Checking account option on New page
    And the user clicks on cancel button in new flow

    Examples: 
      | planType | memberType            |
      | MAPD     | IndividualUHCPayments |

  @paymentsErrorMessage @US1474255 @Feb_release_2019 @Spartans @payment9
  Scenario Outline: Verify Recurring Payment Error Message for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow Edit Automatic Payment button
    And the user selects the Checking account option on New page
    And the user clicks on Authorize button to validate error message

    Examples: 
      | planType | memberType            |
      | MAPD     | IndividualUHCPayments |

  @paymentsCancelButton @US1449078 @Feb_release_2019 @Spartans @payment10
  Scenario Outline: Verify oneTime Payment cancellation for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow OneTime Payment button
    And the user selects the Checking account option on New page OTP
    And the user clicks on cancel button in new flow for OneTimePay

    Examples: 
      | planType | memberType              |
      | MAPD     | IndividualAARPRPayments |

  @BalanceSummaryValidation @US1448800 @Feb_release_2019 @Spartans @payment11
  Scenario Outline: Verify Balance Summary for different types of members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow OneTime Payment button
    And the user validates the Balance Summary option on New page OTP

    Examples: 
      | planType | memberType              |
      | MAPD     | IndividualAARPRPayments |

  @paymentsEndtoEnd @US1483885 @Feb_release_2019 @Spartans @payment12
  Scenario Outline: Verify oneTime Payment submission for Different Types of Member
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
      | planType | memberType            | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | MAPD     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

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

  @MakOneTimeCCTotal @Feb_release_2019 @Spartans
  Scenario Outline: Verify MakeOne time Payment submission for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Make one time payment on payment overview page
    And user selects Amount due today and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to payment overview screen and selects agreements and click on Make one time payemnt
    Then User navigates to payment confirmation page for CC flow

    Examples: 
      | planType | memberType              | Name | CreditCardNumber | validMonth | validYear |
      | PDP      | IndividualAARPCPayments | Test | 4111111111111111 |         04 |      2019 |

  @MakOneTimeCCOther @Feb_release_2019 @Spartans
  Scenario Outline: Verify MakeOne time Payment submission for Different Types of Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to payment overview screen and selects agreements and click on Make one time payemnt
    Then User navigates to payment confirmation page for CC flow

    Examples: 
      | planType | memberType              | Name | CreditCardNumber | validMonth | validYear |
      | PDP      | IndividualAARPCPayments | Test | 4111111111111111 |         04 |      2019 |

  @SetupRecurrEFT @Feb_release_2019 @Spartans
  Scenario Outline: Verify Setup Recurring for Checking Account
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
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
    And user navigates to review your Automatic screen and selects agreements and click on Authorize Monthly payments Button for EFT
    Then User navigates to payment confirmation page and verifies ConfirmationNo for EFT

    Examples: 
      | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | PDP      | IndividualAARPCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @SetupRecurrCC @Feb_release_2019 @Spartans
  Scenario Outline: Verify Setup Recurring for CC
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Set up Automatic payments on payment overview page
    And user selects CreditDebit Card on Setup Automatic recurring payments page and Click on Next
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Recurring
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to review your Automatic screen and selects agreements and click on Authorize Monthly payments Button for CC
    Then User navigates to payment confirmation page and verifies ConfirmationNo for CC

    Examples: 
      | planType | memberType              | Name | CreditCardNumber | validMonth | validYear |
      | PDP      | IndividualAARPCPayments | Test | 4111111111111111 |         04 |      2019 |
