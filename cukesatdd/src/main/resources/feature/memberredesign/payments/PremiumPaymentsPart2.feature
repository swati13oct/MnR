Feature: 1.19 Verify the premium payment flows on member portal - Part 2 - Test cases 7 to 13

  #Test Case 07
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 07 -Verify Update Recurring for Checking Account for Ship Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
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

    Examples: 
      | TID     | planType | memberType         | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | F242866 | SHIP     | SHIPSetup_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  #Test Case 08
  @regressionMember
  Scenario Outline: TID: <TID> -  Test Case 08 -Verify Update Recurring for Checking Account for Ship Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
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
    And user navigates to Review Payment Method Update screen and selects agreements and click on Contuine Button for EFT Ship
    Then User navigates to payment confirmation page and verifies sucessful EFT for Update Recurring for Ship

    Examples: 
      | TID     | planType | memberType          | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | F242866 | SHIP     | SHIPUpdate_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  #Test Case 09
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 09 -Verify Stop Recurring for Ship Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Update Automatic payments on payment overview page for Ship
    And user selects Stop Automatic Recurring Payments and Click on Next
    And user navigates to Review Payment Method Update screen and selects agreements and click on Contuine Button for Stop recurring Ship
    Then User navigates to payment confirmation page and verifies sucessful Stop Recurring for Ship

    Examples: 
      | TID     | planType | memberType          |
      | F242866 | SHIP     | SHIPUpdate_Payments |

  #Test Case 10
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 10 -Verify download PDF for payment History
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then user validates download PDF for monthly bill PDF

    Examples: 
      | FID    | planType | memberType   |
      | 247601 | PDP      | IDCardmember |

  #Test Case 11 - UHC MAPD Plan member with direct pay
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 11 - Verify if the user is able to make one time payment for EFT
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
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID   | planType | memberType                | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | HouseholdID | paymentType |
      | 15118 | MAPD     | IndividualUHCPayments_BnC | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME | 80012942508 | OneTime     |

  #Test Case 12
  @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Test Case 12 - Verify if the user is able to make one time Total Amount payment for Ship
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to payment history
    And user clicks on Make one time payment on payment overview page
    And user SHIP selects other amount and enters "1.00" and selects Checking Account and click on Next button
    And user SHIP Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time
    Then SHIP User navigates to payment confirmation page and verifies ConfirmationNo for One time

    Examples: 
      | TID   | planType | memberType          | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | 15143 | SHIP     | SHIPUpdate_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
