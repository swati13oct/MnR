Feature: To test the payment flow on Member site

  @paymentsFInal @paymentsOneTimePayments @regressionMember 
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
      | planType | memberType            | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
      | MAPD     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
   #   | SHIP     | IndividualUHCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      | SHIP     | IndividualAARPSPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |

  @paymentsAutoPay @15301 @regressionMember
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

  @paymentsMoreThanOnePay @15142 @regressionMember
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
  @TestmemberAuth @15170 @regressionMember
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
  @TestmemberAuthOTP @15163 @regressionMember
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

  @paymentsShip @15320 @regressionMember
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
  @paymentsCombo @15144 @regressionMember
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
      | planType | memberType        | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount |
     # | COMBO    | COMBOAARPPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      | COMBO    | COMBOAARPPayments2 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |   1.00 |
      

   @paymentsAutoPayCancel @US1463204 @Feb_release_2019 @Spartans
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
 
  @paymentsErrorMessage @US1474255 @Feb_release_2019 @Spartans
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
      

 @paymentsCancelButton @US1449078 @Feb_release_2019 @Spartans
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
      | planType | memberType            | 
      | MAPD     | IndividualAARPRPayments | 
      
  @BalanceSummaryValidation @US1448800 @Feb_release_2019 @Spartans
  Scenario Outline: Verify Balance Summary for different types of members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user navigates to Recurring payment history
    Then User Scrolls down to validate Payment History Section
    And the user clicks on New flow OneTime Payment button
    And the user validates the Balance Summary option on New page OTP    
    
    Examples: 
      | planType | memberType            | 
      | MAPD     | IndividualAARPRPayments | 
      
@paymentsEndtoEnd @US1483885 @Feb_release_2019 @Spartans
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
    