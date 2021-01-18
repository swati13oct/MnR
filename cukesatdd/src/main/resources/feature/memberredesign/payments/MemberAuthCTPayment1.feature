<<<<<<< HEAD
@regressionMember
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD @sanityMemberPROD1
  Scenario Outline: TID: <TID> -  Test Case 01- To validate One time Credit Card Payment Flow for Federal Plan member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user validates the information on Payment Review page

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | jkuma14  | Brock@04 | DSOADY17    | MAPD     | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |

  @regressionMemberPROD
  Scenario Outline: TID: <TID> -  Test Case 02-Verify One time EFT payment flow for federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
<<<<<<< HEAD
   And user navigates to Review Your One-Time Payment Information and selects agreements and click on Submit Button for Make One Time
   And the user is displayed with an error message that he is not authorized
=======
   And Updated user navigates to Review Your One-Time Payment Information and selects agreement
   #Removed 11/5/2020 - And the user is displayed with an error message that he is not authorized
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

    Examples: 
      | TID     | username | password | memUserName    | planType | claimPeriod    | dateRange      | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
<<<<<<< HEAD
      | TC002   | jkuma14  | Brock@03 | mleroy@mcn.org | MAPD     | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |
=======
      | TC002   | jkuma14  | Brock@04 | mleroy@mcn.org | MAPD     | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD

  @regressionMemberPROD
  Scenario Outline: TID: <TID> -  Test Case 04 -Verify cancel button on Update Recurring EFT flow for federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
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
    And the user clicks on cancel button in One time EFT or Recurring EFT

    Examples: 
      | TID     | username | password | memUserName    | planType |  routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
<<<<<<< HEAD
      | TC004   | jkuma14  | Brock@03 | mleroy@mcn.org | MAPD     | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
=======
      | TC004   | jkuma14  | Brock@04 | mleroy@mcn.org | MAPD     | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
=======
@regressionMember
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD @sanityMemberPROD1
  Scenario Outline: TID: <TID> -  Test Case 01- To validate One time Credit Card Payment Flow for Federal Plan member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user validates the information on Payment Review page

    Examples: 
      | UID     | username | password | memUserName    | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | jkuma14  | Brock@05 | LMHOCHSCHILD11 | MAPD     | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |

  @regressionMemberPROD
  Scenario Outline: TID: <TID> -  Test Case 02-Verify One time EFT payment flow for federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Amount to be paid          | <Amount>           |
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And Updated user navigates to Review Your One-Time Payment Information and selects agreement

    #Removed 11/5/2020 - And the user is displayed with an error message that he is not authorized
    Examples: 
      | TID   | username | password | memUserName    | planType | claimPeriod    | dateRange      | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | TC002 | jkuma14  | Brock@05 | mleroy@mcn.org | MAPD     | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

  @regressionMemberPROD
  Scenario Outline: TID: <TID> -  Test Case 04 -Verify cancel button on Update Recurring EFT flow for federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
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
    And the user clicks on cancel button in One time EFT or Recurring EFT

    Examples: 
      | TID   | username | password | memUserName    | planType | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | TC004 | jkuma14  | Brock@05 | mleroy@mcn.org | MAPD     | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
>>>>>>> branch 'develop' of https://github.optum.com/Consumer-Portals/MRATDD
