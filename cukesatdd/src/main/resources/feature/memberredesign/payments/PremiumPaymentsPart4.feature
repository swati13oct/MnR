<<<<<<< HEAD
Feature: 1.19 Verify the premium payment flows on member portal - Part 4 - Test case 27 to 32

Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature           | UCPPayments |
###############################Regression Scenarios Begin Here ########################################

  #Test Case 27 - Pre-effective federal member with no billing and no payment history
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 27 -Verify payments for Pre-effective Federal member with no billing and no payment history
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate Billing history Section and Payment History Section to ensure that sections are disabled

    Examples: 
      | planType | memberType             | copayCategory | technicalTFN   | segmentId |
      | IndMA    | preeffectiveIndPayment | NON LIS       | 1-888-980-8125 |       000 |

  #Test Case 28 - Active member Fed and  Active Group Member with billing and payment history in last 90 days
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 28 -Verify billing and payment history for Active Federal and Active Group member with billing and payment history in last 90 days
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |

    Examples: 
      | planType  | memberType         | copayCategory |
      | IndMA     | ACTIVEIndPayment   | NON LIS       |
      | GroupMAPD | ACTIVEGroupPayment | NON LIS       |

  #Test Case 29 - Billing and Payment history for Fed+Fed-Active Group PDP + Active Group SSUP, Active PDP+SHIP CPMBO member with billing and payment history in last 90 days
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 29 -Verify billing and payment history for Fed+Fed - Active Group PDP + Active Group SSUP member , Active PDP + Active SHIP with billing and payment history in last 90 days
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user clicks to expand the billing hisory section of first plan
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user clicks to expand the payment hisory section of first plan
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Previous Calendar Year in the Payment History dropdown and views Payment History
    Then User Scrolls down to the Billing history Section of Second Plan
    Then user clicks to expand the billing hisory section of Second plan
    Then user validates billing history section header exists of Second Plan
    Then Last 90 days is selected by default in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user clicks to expand the payment hisory section of Second Plan
    Then user validates Payment history section header exists of Second Plan
    Then Last 90 days is selected by default in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Previous Calendar Year in the Payment History dropdown of Second Plan and views Payment History
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |

    Examples: 
      | planType          | memberType                     | copayCategory |
      | GroupPDPGroupSSUP | ACTIVEGroupPDPGroupSSUPPayment | NON LIS       |
      | FedPDPSHIP        | ACTIVEPDPSHIPPayment           | NON LIS       |

  #Test Case 30 - This test case check the Make a Payment button on Coverage and Benefits page for federal plan member
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
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType         |
      | SHIP     | SHIPSetup_Payments |
=======
Feature: 1.19 Verify the premium payment flows on member portal - Part 4 - Test case 27 to 32

  Background: Feature security flag needs to be true before ATDD script execution
    Given First check if feature security flag is set to true
      | Feature | UCPPayments |

  ###############################Regression Scenarios Begin Here ########################################
  #Test Case 27 - Pre-effective federal member with no billing and no payment history
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 27 -Verify payments for Pre-effective Federal member with no billing and no payment history
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down and validate Billing history Section and Payment History Section to ensure that sections are disabled

    Examples: 
      | planType | memberType             | copayCategory | technicalTFN   | segmentId |
      | IndMA    | preeffectiveIndPayment | NON LIS       | 1-888-980-8125 |       000 |

  #Test Case 28 - Active member Fed and  Active Group Member with billing and payment history in last 90 days
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 28 -Verify billing and payment history for Active Federal and Active Group member with billing and payment history in last 90 days
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |

    Examples: 
      | planType  | memberType         | copayCategory |
      | IndMA     | ACTIVEIndPayment   | NON LIS       |
      | GroupMAPD | ACTIVEGroupPayment | NON LIS       |

  #Test Case 29 - Billing and Payment history for Fed+Fed-Active Group PDP + Active Group SSUP, Active PDP+SHIP CPMBO member with billing and payment history in last 90 days
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 29 -Verify billing and payment history for Fed+Fed - Active Group PDP + Active Group SSUP member , Active PDP + Active SHIP with billing and payment history in last 90 days
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user clicks to expand the billing hisory section of first plan
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user clicks to expand the payment hisory section of first plan
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Previous Calendar Year in the Payment History dropdown and views Payment History
    Then User Scrolls down to the Billing history Section of Second Plan
    Then user clicks to expand the billing hisory section of Second plan
    Then user validates billing history section header exists of Second Plan
    Then Last 90 days is selected by default in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown of Second Plan
    Then user validates data is present in billing history table of Second Plan
      | Plan Type | <planType> |
    Then user clicks to expand the payment hisory section of Second Plan
    Then user validates Payment history section header exists of Second Plan
    Then Last 90 days is selected by default in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown of Second Plan
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |
    Then user selects Previous Calendar Year in the Payment History dropdown of Second Plan and views Payment History
    Then user validates data is present in Payment history table of Second Plan
      | Plan Type | <planType> |

    Examples: 
      | planType          | memberType                     | copayCategory |
      | GroupPDPGroupSSUP | ACTIVEGroupPDPGroupSSUPPayment | NON LIS       |
      | FedPDPSHIP        | ACTIVEPDPSHIPPayment           | NON LIS       |

  #Test Case 30 - This test case check the Make a Payment button on Coverage and Benefits page for federal plan member
  @regressionMember
  Scenario Outline: Test Case 30 - Verify that member of <Test Scenario> is able to click on Make Payment button Coverage and Benefits page and navigate to Premium Payments page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
   # And user scrolls down to Monthly Premium section to click on Make Payment button
    Then user clicks on Make Payment button and lands on Premium Payments page

    Examples: 
      | TID   | planType | memberType              | copayCategory | Test Scenario                          |
      | XXXXX | MAPD     | ACTIVEIndPayment_BNC_MP | NON LIS       | Federal member with Total Amount Due>0 |

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
    And the user moves to Go to Payment History Page button for one time payment
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
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
      | Plan Type | <planType> |
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType         |
      | SHIP     | SHIPSetup_Payments |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
