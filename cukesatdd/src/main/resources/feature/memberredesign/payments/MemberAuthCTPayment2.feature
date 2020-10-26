@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD
  Scenario Outline: TID: <TID> -  Test Case 03 -Verify One time EFT payment for SHIP member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
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
    And user navigates to Review Your One-Time Payment Information
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | F243897 | jkuma14  | Brock@03 | Pramila1946 | SHIP     | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

  @regressionMemberPROD
  Scenario Outline: UID: <UID> -plan: <planType> - Test Case 07 - Verify SHIP Update Recurring EFT flow
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Update Automatic payments on payment overview page for Ship
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID     | username | password | memUserName       | planType |
      | F243897 | jkuma14  | Brock@03 | vernajohnson19651 | SHIP     |

  @regressionMemberPROD @sanityMemberPROD2
  Scenario Outline: UID: <UID> -plan: <planType> - Test Case 09 - Verify SHIP Setup Recurring EFT flow
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Setup Automatic payments on payment overview page for Ship
    And user Enters all Mandatory fields on form page and click on Electronic Signature and click on Contuine for Setup Recurring for Ship
      | Routing number             | <routingNo>        |
      | Confirm routing number     | <confirmRoutingNo> |
      | Account number             | <accountNo>        |
      | Confirm account number     | <confirmAccountNo> |
      | Account holder first name  | <firstName>        |
      | Account holder middle name | <middleName>       |
      | Account holder last name   | <lastName>         |
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID     | username | password | memUserName | planType | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName |
      | F243897 | jkuma14  | Brock@03 | Pramila1946 | SHIP     | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    |
