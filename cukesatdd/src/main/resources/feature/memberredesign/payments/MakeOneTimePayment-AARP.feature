  @paymentsFInal @paymentsOneTimePayments @regression_06_06_18 
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

  @paymentsAutoPay @15301 @regression_06_06_18
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

#NOTE: This scenario may fail if run more than one time per day
# because the first run will satisfied making first payment of the day
# during re-running testcase will fail because that "first payment" is no longer the first payment test user in the test environment
  @paymentsMoreThanOnePay @15142 @regression_06_06_18
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

#NOTE: Nov2018 - q2_jun_aarp0057 didn't work, swap w/ q2_jun_aarp0058
  @TestmemberAuth @15170 @regression_06_06_18
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

#NOTE: Nov2018 - q2_jun_uhc0042 didn't work, swap w/ q2_jun_uhc0043
  @TestmemberAuthOTP @15163 @regression_06_06_18
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

  @paymentsShip @15320 @regression_06_06_18
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

#NOTE: Nov2018 - q2_june_combo0012 didn't work, swap to use use q2_june_combo0017
  @paymentsCombo @15144 @regression_06_06_18
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
