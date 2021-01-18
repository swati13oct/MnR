Feature: 1.19 Verify the premium payment flows on member portal - Part 3 - Test case 19 to 26

Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature           | UCPPayments |
      
###############################Regression Scenarios Begin Here ########################################

  #Test Case 19 - Test data needed - Any AARP MAPD Plan member - Error message for multiple payments in a day
  @regressionMember
  Scenario Outline: TID: <TID> - Test Case 19 - Verify More Than one Payment Per day error message
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
      | 15142 | MAPD     | IndividualAarpPayments | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME |   1.12 | 50025629105 | OneTime     |

  #Test Case 20 - Member Auth - FED - Error message on submitting payment - Edit Recurring EFT
  @regressionMember
  Scenario Outline: TID: <TID> -MemUserName: <member> - Test Case 20 - To validate the unauthorized error message in Edit EFT Payment flow for Member Auth User
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
      | TID   | username  | password  | member              | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
<<<<<<< HEAD
      | 15118 | qavgogine | qavgogine | q3_sep_UAT4_AARP069 | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
=======
      | 15118 | qavgogine | qavgogine | PerfCCM_01903       | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

  #Test Case 21 - Any member will work - Member Auth - FED - Error message on submitting payment - One time EFT
  @regressionMember
  Scenario Outline: TID: <TID> -MemUserName: <member> - Test Case 21 - To validate the error message when memberauth user tries to submit oneTime EFT Payment
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

  #Test Case 22 - COMBO member - Needs a SHIP/HIP member with Setup Recurring Payment button and a Fed MAPD/PDP Plan member
  @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Test Case 22 - Verify Payment Submission for Fed+SHIP Combo member - Recurrung EFT for SHIP and One Time EFT for Federal
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
    And the user moves to Go to Payment History Page button
    And user clicks on Make one time payment on payment overview page for plan 2
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
      | 15144 | COMBO    | COMBOAARPPayments2 | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME |   2.00 |     3760900 | OneTime     |

  #Test Case 23 -Fed Only Member with Recurring method already setup and with billing history (same as in test case #15)
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 23 - Verify Payment Hisory Section and Cancel Model Popup for Fed Recurring EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate Billing history Section and Payment History Section and scrolls up for Fed
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
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID       | planType | memberType                | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |

      | US1463204 | MAPD     | UpdateRecurrStop_Payments | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |


  #Test Case 24 - Fed Only Member with Recurring method already setup and with billing history
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 24 -Verify Payment Error Messages for Recurring EFT when user doesn't enter values in the form and clicks on continue button
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate Billing history Section and Payment History Section and scrolls up for Fed
    And user clicks on Update Automatic payments on payment overview page
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And the user clicks on Authorize button to validate error message

    Examples: 
      | UID       | planType | memberType                |
      | US1474255 | MAPD     | UpdateRecurrStop_Payments |

  #Test Case 25 - Fed - Any member will work
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 25 - Verify Payment Hisory Section and Cancel Model Popup for Fed One time EFT
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate Billing history Section and Payment History Section and scrolls up for Fed
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "2.00" and selects Checking Account and click on Next button
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID       | planType | memberType                |
      | US1449078 | MAPD     | UpdateRecurrStop_Payments |

  #Test Case 26 -Fed - member with single federal plan and Next payment Due amount and date
  @regressionMember
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Test Case 26 - Verify Payment Summary for OneTime payment Flow
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate Billing history Section and Payment History Section and scrolls up for Fed
    And user clicks on Make one time payment on payment overview page
    And the user validates the Payment Summary option on New page OTP

    Examples: 
  #Test Case 30 - This test case check the Make a Payment button on Coverage and Benefits page for federal plan member
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
  @regressionMember
  Scenario Outline: Test Case 30 - Verify that member of <Test Scenario> is able to click on Make Payment button Coverage and Benefits page and navigate to Premium Payments page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And user scrolls down to Monthly Premium section to click on Make Payment button
    Then user clicks on Make Payment button and lands on Premium Payments page

    Examples: 
      | TID   | planType | memberType       | copayCategory | Test Scenario                          |
      | XXXXX | MAPD     | ACTIVEIndPayment | NON LIS       | Federal member with Total Amount Due>0 |

  #Test Case 31 - Payment flow  for Fed+Fed - Active Group PDP + Active Group SSUP member - Submit One time EFT for both plans
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 31 -Verify payment submission for Fed+Fed - Active Group PDP + Active Group SSUP member - Submit One time EFT for both plans
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    And user clicks on Make one time payment on payment overview page for plan 1
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
    And the user moves to Go to Payment History Page button
    And user clicks on Make one time payment on payment overview page for plan 2
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
      | planType          | memberType                     | copayCategory | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | Amount | HouseholdID | paymentType |
      | GroupPDPGroupSSUP | ACTIVEGroupPDPGroupSSUPPayment | NON LIS       | 123123123 |        123123123 |     12345 |            12345 | FIRSTNAME | MIDDLENAME | LASTNAME |   1.12 | 50025629105 | OneTime     |
  
  #Test Case 32 - Active SHIP member with billing and payment history in last 90 days
  @regressionMember
  Scenario Outline: <planType> -memberType: <memberType> - Test Case 32 -Verify billing and payment history for Active SHIP member with billing and payment history in last 90 days
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
     | Plan Type      | <planType>      |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
    | Plan Type      | <planType>      |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
    | Plan Type      | <planType>      |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
    | Plan Type      | <planType>      |
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
    | Plan Type      | <planType>      |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    | Plan Type      | <planType>      |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    | Plan Type      | <planType>      |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    | Plan Type      | <planType>      |

    Examples: 

      | UID       | planType | memberType                    |
      | US1448800 | MAPD     | UpdateRecurrStop_Payments_new |
