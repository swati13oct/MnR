@smokeTest @MemberVBF
Feature: 1.11-VBF-MemRedesign-To test the payment history (GATED)

  @smokeMakOneTimeCCOther @rallyDashboard @testharness
  Scenario Outline: Verify MakeOne time Payment submission for Credit card Other amount
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates Premium Payment from Rally Dashboard Page
    And User validates Premium Payment table
    And the user navigates to One Time Payments page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to payment overview screen and selects agreements and click on Make one time payemnt
    Then User navigates to payment confirmation page for CC flow

    Examples: 
      | TID     | memberType                  | Name | CreditCardNumber | validMonth | validYear | friendname | favcolor | phonenumber |
      | F243897 | MakeOneTimeCCOther_Payments | Test | 4111111111111111 |         04 |      2020 | name1      | color1   | number1     |

    @oneTimeCCPaymentPerf
    Examples: 
      | memberType           | Name | CreditCardNumber | validMonth | validYear | friendname | favcolor | phonenumber |
      | oneTimeCCPaymentPerf | Test | 4111111111111111 |         04 |      2020 | name1      | color1   | number1     |

  @smokeMakOneTimeEFTOther @rallyDashboard @testharness
  Scenario Outline: Verify Make One time Payment submission for Checking Account Other amount
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates Premium Payment from Rally Dashboard Page
    And User validates Premium Payment table
    And the user navigates to One Time Payments page
    And user selects other amount and enters "10.00" and selects Checking Account and click on Next buttons
    And user Enter all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make OneTime
    Then User navigates to payment confirmation page and verifies ConfirmationNo for Onetime

    Examples: 
      | memberType            | routingNo | confirmRoutingNo | accountNo  | confirmAccountNo | firstName | middleName | lastName | friendname | favcolor | phonenumber |
      | IndividualUHCPayments | 123123123 |        123123123 | 0123456789 |       0123456789 | first     | second     | third    | name1      | color1   | number1     |

  @smokeMakOneTimeEFTOtherSHIP @rallyDashboard @testharness
  Scenario Outline: Verify Make One time Payment submission for Checking Account Other amount for SHIP
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates Premium Payment from Rally Dashboard Page
    And User validates Premium Payment table
    And the user navigates to One Time Payments page
    And user selects other amount and enters "10.00" and selects Checking Account and click on Next buttons for SHIP
    And user Enter all Mandatory fields on form page and click on Authorize button for Make one Time CA For SHIP
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make OneTime for SHIP
    Then User navigates to payment confirmation page and verifies ConfirmationNo for Onetime for SHIP

    Examples: 
      | memberType          | routingNo | confirmRoutingNo | accountNo  | confirmAccountNo | firstName  | middleName  | lastName   | friendname | favcolor | phonenumber |
      | SHIPUpdate_Payments | 123123123 |        123123123 | 0123456789 |       0123456789 | TEST-First | TEST-second | TEST-third | name1      | color1   | number1     |
