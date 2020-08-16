@regressionMember
Feature: S1.1 To test Member Auth premium payment flows Micro App.
  
  @regressionMemberPROD @memAuthProdOnetimeCreditCardPayment @CodeTransformers
  Scenario Outline: TID: <TID> -  Test Case 01- To validate Credit Card Payments Flow
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
    And user navigates to payment overview screen

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | ashah120 | Mnrqa003 | DSOADY17    | MAPD     | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |

  @regressionMemberPROD @memAuthProdOneTimeEFT @CodeTransformers
  Scenario Outline: TID: <TID> -  Test Case 02-Verify EFT payment flow for federal member
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

    Examples: 
      | UID     | username | password | memUserName    | planType | claimPeriod    | dateRange      | routingNo | confirmRoutingNo | accountNo | confirmAccountNo | firstName | middleName | lastName | paymentType |
      | F243897 | ashah120 | Mnrqa003 | mleroy@mcn.org | MAPD     | Last 24 months | Last 18 months | 123123123 |        123123123 |     12345 |            12345 | first     | second     | third    | Recurring   |

 
   
  @regressionMemberPROD @memAuthProdOneTimeEFTCancel @CodeTransformers
  Scenario Outline: TID: <TID> -  Test Case 04 -Verify cancel EFT federal member
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
    And the user clicks on cancel button in One time EFT or Recurring EFT

    Examples: 
      | UID     | username | password | memUserName    | planType | claimPeriod    | dateRange      |
      | F243897 | ashah120 | Mnrqa003 | mleroy@mcn.org | MAPD     | Last 24 months | Last 18 months |

  
