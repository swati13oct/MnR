@guestPayment
Feature: 1.06.7 Member Guest Payments Page

 @guestPayment01 @validateUrlForDifferentBrands
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    When I click on link Help me find my id link
    Then I click on the sign in link and navigate to Member Portal sign in page
    Then I will see the Logo specific to my plan and the Sign in button
            | Site Name | <siteName> |
    ## Next two steps will be removed soon
    Then I will enter my Member ID and Date of birth
       | Member ID         | <memberID> |
       | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |



  @guestPayment02 @ErrorsAndContent
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different error scenarios

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    And  I click on Next button leaving Member ID and Date of birth blank
    Then I will get an error message
    Then I will enter my Member ID and Date of birth
    #incorrect member id
       | Member ID         | 01           |
       | Date of Birth     | 01/01/1944   |
    Then I will get an error message
    And  I will enter my Member ID and Date of birth
     #incorrect dob
       | Member ID         | 915516555-1     |
       | Date of Birth     |  01/01/2050     |
    Then I will get an error message
    #incorrect combination
   And  I will enter my Member ID and Date of birth
       | Member ID         |  915516555-1      |
       | Date of Birth     |   01/01/1944      |
    Then I will get an Error that match cannot be found in GPS

   Examples:
      | TID   | planType |  siteName   |
      | 10005 | MAPD     |   AARP      |
      | 10006 | MAPD     |   UHC       |


  @guestPayment03 @Blockeduser  @Terminated @100%Subsidy @PremiumtoaBank
  Scenario Outline: TID: <TID> - To validate the Guest Payment page for blocked Members
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
       | Member ID         | <memberID> |
       | Date of Birth     |  <dob>     |
    And  I will click on the Next Button and navigate to an Error page
    And  I will be instructed to call the number on the back of my ID
    Then I click on the sign in link and navigate to Member Portal sign in page
    Then I will see the Logo specific to my plan and the Sign in button

    Examples:
      | TID   | planType              | memberID      | dob           | siteName    |
      | 10007 | SHIP                  | 915516555-1   | 10/29/1947    |   AARP      |
      | 10008 | TERMINATED            | 915516555-1   | 10/29/1947    |   UHC       |
      | 10009 | GroupWithSubsidy      | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10010 | PremiumPayedToBank    | 915516555-1   | 10/29/1947    |   RETIREE   |



  @guestPayment04 @C&SplanBLOCKED
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
      Given I am on the Welcome Page of M&R Guest Premium Payment portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
       | Member ID         | <memberID> |
       | Date of Birth     |  <dob>     |
    And I will click on the Next Button and navigate to an Error page
    And I will be instructed to call the number on the back of my ID
    And I will not see the sign in link to the authenticated M&R member site

    Examples:
      | TID   | planType              | memberID      | dob           | siteName       |
      | 10011 | C&SBlocked            | 915516555-1   | 10/29/1947   |   RETIREE     |


  @guestPayment05 @makeOneTimePayment @pastAmount @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount Due and choose a Credit Debit payment Method
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements
    Then I entered my Email address and click send button to send receipt on my Email
      | Email             | <Email>             |
    And I validate success Email receipt message and click send to another Email
    Then I will click on Sign in link to navigate to Member Portal

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name                 | CreditCardNumber | validMonth | validYear | Email          |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | CreditCardAutomation | 4111111111111111 | 04         | 2024      | test@optum.com |
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | CreditCardAutomation | 4111111111111111 | 04         | 2024      | test@optum.com |
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | CreditCardAutomation | 4111111111111111 | 04         | 2024      | test@optum.com |
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | CreditCardAutomation | 4111111111111111 | 04         | 2024      | test@optum.com |
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | CreditCardAutomation | 4111111111111111 | 04         | 2024      | test@optum.com |

  @guestPayment06 @makeOneTimePayment @pastAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount Due and choose a EFT Checking acc payment Method
    Then I will enter EFT Checking Account Details
      | AccountHoldersName | <Name>      |
      | AccountNumber      | <accountNo> |
      | RoutingNumber      | <routingNo> |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements
    Then I entered my Email address and click send button to send receipt on my Email
      | Email             | <Email>             |
    And I validate success Email receipt message and click send to another Email
    Then I will click on Sign in link to navigate to Member Portal

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name            | accountNo  | routingNo | Email          |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | Guest Payments1 | 1234512345 | 123123123 | test@optum.com |
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | Guest Payments2 | 1234512345 | 123123123 | test@optum.com |
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | Guest Payments3 | 1234512345 | 123123123 | test@optum.com |
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | Guest Payments4 | 1234512345 | 123123123 | test@optum.com |
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | Guest Payments5 | 1234512345 | 123123123 | test@optum.com |


  @guestPayment07 @makeOneTimePayment @pastAmount&currentCharges @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount & current charges Due and choose a Credit Debit payment Method
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |Name                 | CreditCardNumber | validMonth | validYear |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |CreditCardAutomation | 4111111111111111 |         04 |      2024 |


  @guestPayment08 @makeOneTimePayment @pastAmount&currentCharges @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount & current charges Due and choose a EFT Checking acc payment Method
    Then I will enter EFT Checking Account Details
      | AccountHoldersName | <Name>      |
      | AccountNumber      | <accountNo> |
      | RoutingNumber      | <routingNo> |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name            | accountNo      | routingNo   |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | Guest Payments1 |  1234512345    |   123123123 |       
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | Guest Payments2 |  1234512345    |   123123123 |  
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | Guest Payments3 |  1234512345    |   123123123 |  
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | Guest Payments4 |  1234512345    |   123123123 | 
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | Guest Payments5 |  1234512345    |   123123123 |  

  @guestPayment09 @makeOneTimePayment @otherAmount @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands


    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select and enter other amount Due and choose a Credit Debit payment Method
     | Other Amount | <otherAmountDue> |
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |Name                 | CreditCardNumber | validMonth | validYear |otherAmountDue    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  10.05           |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  15.20           |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  20.30           |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  11.000          |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  333.00          |


  @guestPayment10 @makeOneTimePayment @otherAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select and entered other amount Due and choose a EFT Checking acc payment Method
      | Other Amount | <otherAmountDue> |
    Then I will enter EFT Checking Account Details
      | AccountHoldersName | <Name>      |
      | AccountNumber      | <accountNo> |
      | RoutingNumber      | <routingNo> |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name            | accountNo      | routingNo   |otherAmountDue    |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | Guest Payments1 |  1234512345    |   123123123 |  10.05           |
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | Guest Payments2 |  1234512345    |   123123123 |  15.20           |
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | Guest Payments3 |  1234512345    |   123123123 |  20.30           |
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | Guest Payments4 |  1234512345    |   123123123 |  11.000          |
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | Guest Payments5 |  1234512345    |   123123123 |  333.00          |
      
      
  @guestPayment11 @makeOneTimePayment @EditPayments
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

#workInProgress
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select and entered other amount Due and choose a EFT Checking acc payment Method
      | Other Amount | <otherAmountDue> |
    Then I will enter EFT Checking Account Details
      | AccountHoldersName | <Name>      |
      | AccountNumber      | <accountNo> |
      | RoutingNumber      | <routingNo> |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name            | accountNo      | routingNo   |otherAmountDue    |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | Guest Payments1 |  1234512345    |   123123123 |  10.05           |
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | Guest Payments2 |  1234512345    |   123123123 |  15.20           |
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | Guest Payments3 |  1234512345    |   123123123 |  20.30           |
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | Guest Payments4 |  1234512345    |   123123123 |  11.000          |
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | Guest Payments5 |  1234512345    |   123123123 |  333.00          |

