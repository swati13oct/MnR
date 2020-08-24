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
    Then I select Past Amount Due and choose a Credit/Debit payment Method
    Then I will enter card details
    And I click on Review and Submit to review payment details
    Then I validated header and and page elemens on Review & Submit page
    When I click on Confirm and Pay
    And I navigated to Payment submitted page and validate all page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |

  @guestPayment06 @makeOneTimePayment @pastAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

  
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount Due and choose a EFT Checking acc payment Method
    And user selects other amount and enters "1.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Routing number             | <routingNo>        |
      | Account number             | <accountNo>        |
      | Account holder  name  | <firstName>        |
    And I click on Review and Submit to review payment details
    Then I validated header and and page elemetns on Review & Submit page
    When I click on Confirm and Pay
    And I navigated to Payment submitted page and validate all page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |


  @guestPayment07 @makeOneTimePayment @pastAmount&currentChanrges @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    When I click on link Help me find my id link
    Then I click on the sign in link and navigate to Member Portal sign in page
    Then I will see the Logo specific to my plan and the Sign in button
    ## Next two steps will be removed soon
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    Then I am on the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount & current charges Due and choose a Credit/Debit payment Method
    Then I will enter card details
    And I click on Review and Submit to review payment details
    Then I validated header and and page elemetns on Review & Submit page
    When I click on Confirm and Pay
    And I navigated to Payment submitted page and validate all page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |


  @guestPayment08 @makeOneTimePayment @pastAmount&currentChanrges @eftCheckingFLow
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
    And user selects other amount and enters "1.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Routing number             | <routingNo>        |
      | Account number             | <accountNo>        |
      | Account holder  name  | <firstName>        |
    And I click on Review and Submit to review payment details
    Then I validated header and and page elemetns on Review & Submit page
    When I click on Confirm and Pay
    And I navigated to Payment submitted page and validate all page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |


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
    Then I select other amount Due and choose a Credit/Debit payment Method
    Then I will enter card details
    And I click on Review and Submit to review payment details
    Then I validated header and and page elemetns on Review & Submit page
    When I click on Confirm and Pay
    And I navigated to Payment submitted page and validate all page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |


  @guestPayment10 @makeOneTimePayment @otherAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the Welcome Page of M&R Guest Premium Payment portal
   
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select other amount Due and choose a EFT Checking acc payment Method
    And user selects other amount and enters "1.00" and selects Checking Account and click on Next button
    And user Enters all Mandatory fields on form page and click on Authorize button for Make one Time CA
      | Routing number             | <routingNo>        |
      | Account number             | <accountNo>        |
      | Account holder  name  | <firstName>        |
    And I click on Review and Submit to review payment details
    Then I validated header and and page elemetns on Review & Submit page
    When I click on Confirm and Pay
    And I navigated to Payment submitted page and validate all page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
      | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
      | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |

