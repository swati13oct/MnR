Feature: 1.19 Verify the premium payment flows on member portal - Part 1 - Test cases 1 to 6

  @DONOTRUNTOTALAMOUNTDUE
  Scenario Outline: TID: <TID> - Verify MakeOne time Payment submission for Credit card total amount
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
      | TID       | planType | memberType                       | Name | CreditCardNumber | validMonth | validYear |
      | F243897   | MAPD     | MakeOneTimeCCTotal_Payments      | Test | 4111111111111111 |         04 |      2024 |
      | US1588469 | PDP      | ComboMakeOneTimeCCTotal_Payments | Test | 4111111111111111 |         04 |      2024 |

  #Test Case 01
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 01 - Verify MakeOne time Payment submission for Credit card Other amount
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
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType                       | Name | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897   | PDP      | MakeOneTimeCCOther_Payments      | Test | 4111111111111111 |         04 |      2028 | OneTime     |
     | US1588469 | PDP      | ComboMakeOneTimeCCOther_Payments | Test | 4111111111111111 |         04 |      2028 | OneTime     |

  #Test Case 02
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 02 - Verify Setup Recurring for Checking Account
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
    And delete confirmation number GPS for recurring payment
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType                | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | F238525   | MAPD     | SetupRecEFT_Payments      | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |
      | US1588469 | PDP      | ComboSetupRecEFT_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

  #Test Case 03
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 03 - Verify Setup Recurring for CC
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
    And delete confirmation number GPS for recurring payment
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType               | Name | CreditCardNumber | validMonth | validYear | paymentType |
      | F2385256   | PDP      | SetupRecCC_Payments      | Test | 4111111111111111 |         04 |      2028 | Recurring   |
      | US1588469 | PDP      | ComboStepuRecCC_Payments | Test | 4111111111111111 |         04 |      2028 | Recurring   |

  #Test Case 04
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 04 - Verify Update Recurring for Checking Account
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
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType                    | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | F242866   | MAPD     | UpdateRecurrEFT_Payments      | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |
      | US1588469 | PDP      | ComboUpdateRecurrEFT_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

  #Test Case 05
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 05 - Verify Update Recurring for CC
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
    And the user delete recurring payment record from GPS so that he can run recurring payment again
      | Payment Type | <paymentType> |

    Examples: 
      | TID       | planType | memberType                   | Name | CreditCardNumber | validMonth | validYear | paymentType |
      | F242866   | PDP      | UpdateRecurrCC_Payments      | Test | 4111111111111111 |         04 |      2028 | Recurring   |
      | US1588469 | PDP      | ComboUpdateRecurrCC_Payments | Test | 4111111111111111 |         04 |      2028 | Recurring   |

  #Test Case 06
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 06 -Verify Stop Recurring payment flow for Federal memeber
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    And user clicks on Update Automatic payments on payment overview page
    And user clicks on Stop Automatic payments and clicks on next for Federal
    Then user navigates to Review Payment Method Update screen for Stop Recurring Payments for Federal
    Then User navigates to payment confirmation page and verifies sucessful Stop Recurring for Federal

    Examples: 
      | TID       | planType | memberType                  |
     | F242866   | MAPD     | UpdateRecurrStop_Payments   |
     | US1588469 | PDP      | ComboUpdateStopRec_Payments |  