#Author        : Obul Reddy
#Created Date  : 2019-02-11(YYYY-MM-DD)
@payments
Feature: To Test Credit card functional Flows

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
      | planType | memberType              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | PDP      | IndividualAARPCPayments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

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

  @UpdateRecurrEFT @Feb_release_2019 @Spartans
  Scenario Outline: Verify Update Recurring for Checking Account
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
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
    And user navigates to Review Payment Method Update screen and selects agreements and click on Authorize Monthly payments Button for EFT
    Then User navigates to payment confirmation page and verifies ConfirmationNo for EFT for Update Recurring

    Examples: 
      | planType | memberType                       | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | MAPD     | IndividualAARPMAPDPaymentsUpdate | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  @UpdateRecurrCC @Feb_release_2019 @Spartans
  Scenario Outline: Verify Update Recurring for CC
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Update Automatic payments on payment overview page
    And user selects CreditDebit Card on Update Automatic recurring payments page and Click on Next
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Update Recurring
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to Review Payment Method Update screen and selects agreements and click on Authorize Monthly payments Button for CC
    Then User navigates to payment confirmation page and verifies ConfirmationNo for CC for Update Recurring

    Examples: 
      | planType | memberType                       | Name | CreditCardNumber | validMonth | validYear |
      | MAPD     | IndividualAARPMAPDPaymentsUpdate | Test | 4111111111111111 |         04 |      2019 |

  @UpdateRecurrEFTSHIP @Feb_release_2019 @Spartans
  Scenario Outline: Verify Update Recurring for Checking Account for Ship Member
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
      | planType | memberType                   | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | SHIP     | IndividualSHIPPaymentsUpdate | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |

  @UpdateRecurrStopSHIP @Feb_release_2019 @Spartans
  Scenario Outline: Verify Stop Recurring for Ship Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Update Automatic payments on payment overview page for Ship
    And user selects Stop Automatic Recurring Payments and Click on Next
    And user navigates to Review Payment Method Update screen and selects agreements and click on Contuine Button for Stop recurring Ship
    Then User navigates to payment confirmation page and verifies sucessful Stop Recurring for Ship

    Examples: 
      | planType | memberType                   |
      | SHIP     | IndividualSHIPPaymentsUpdate |