@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows for SHIP member Micro App.

         
        @regressionMemberPROD @memAuthProdOneTimeEFTSHIP @CodeTransformers
  Scenario Outline: TID: <TID> -  Test Case 03 -Verify EFT payment SHIP member
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

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | F243897 | ashah120 | Mnrqa003 | Pramila1946 | SHIP     | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

    @regressionMemberPROD @memAuthProdSetUpRecurringEFT @CodeTransformers
  Scenario Outline: UID: <UID> -plan: <planType> - Test Case 07 - Verify Payment Hisory Section and Cancel for Fed Recurring EFT
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    Then User Scrolls down and validate that Payment History Section and scrolls up
    And user clicks on Update Automatic payments on payment overview page for Ship
    And user selects checking Account on Update Automatic recurring payments page and Click on Next
    And the user clicks on cancel button in One time EFT or Recurring EFT flow

    Examples: 
      | UID     | username | password | memUserName       | planType |
      | F243897 | ashah120 | Mnrqa003 | vernajohnson19651 | SHIP     |

  