@regressionMember
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD @memAuthProdSetUpRecurringChecking @CodeTransformers
  Scenario Outline: TID: <TID> -  Test Case 05 -Verify Setup Recurring for Checking Account Federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
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
    And user navigates to review your Automatic screen and selects agreements for EFT

    Examples: 
      | UID     | username | password | memUserName         | planType | claimPeriod    | dateRange      | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | F243897 | ashah120 | Mnrqa003 | TELGUY1@HOTMAIL.COM | MA       | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

  @regressionMemberPROD @memAuthProdSetUpRecurringCC @CodeTransformers
  Scenario Outline: TID: <TID> -  Test Case 06- Verify Setup Recurring for CC federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Set up Automatic payments on payment overview page
    And user selects CreditDebit Card on Setup Automatic recurring payments page and Click on Next
    Then user Navigates to UPG payment page and Enter Mandatory fields and click on Proceed for Recurring
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    And user navigates to review your Automatic screen and selects agreements for CC

    Examples: 
      | UID     | username | password | memUserName         | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | ashah120 | Mnrqa003 | TELGUY1@HOTMAIL.COM | MA       | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |
