@guestPayment
Feature: 1.06.7 Member Guest Payments Page - Member Auth - PROD


  @prod_guestPayment01 @prod_validateUrlForDifferentBrands
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    When I click on link Help me find my id link
    Then I click on the sign in link and navigate to Member Portal sign in page
    #Then I will see the Logo specific to my plan and the Sign in button
          #  | Site Name | <siteName> |

    Examples:
      | TID   | planType | siteName    |
      | 10000 | MAPD     |   AARP      |
      | 10001 | MAPD     |   UHC       |
      | 10002 | MAPD     |   RETIREE   |
      | 10003 | MAPD     |   PCP       |
      | 10004 | MAPD     |   MEDICA    |



  @prod_guestPayment02 @prod_ErrorsAndContent
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different error scenarios
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    And  I click on Next button leaving Member ID and Date of birth blank
    Then I will get an error message
       #incorrect member id
    Then I will enter my Member ID and Date of birth
      | Member ID         | aa           |
      | Date of Birth     | 01/01/1944   |
    Then I will click the Next Button on the login page
    Then I will get an error message
    #incorrect combination
    And  I will enter my Member ID and Date of birth
      | Member ID         |  915516555-1      |
      | Date of Birth     |   01/01/1944      |
    Then I will click the Next Button on the login page
    Then I will get an Error that match cannot be found in GPS

    Examples:
      | TID   | planType |  siteName   |
      | 10005 | MAPD     |   AARP      |
      | 10006 | MAPD     |   UHC       |


  @prod_guestPayment03 @prod_Blockeduser  @prod_Terminated @100%Subsidy @PremiumtoaBank
  Scenario Outline: TID: <TID> - To validate the Guest Payment page for blocked Members
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And  I will click on the Next Button and navigate to an Error page
    And  I will be instructed to call the number on the back of my ID
    And I will see the sign in link to the authenticated M&R member site
    #Then I click on the sign in link and navigate to Member Portal sign in page
    #Then I will see the Logo specific to my plan and the Sign in button

    Examples:
      | TID   | planType              | memberID      | dob           | siteName    |
    #  | 10007 | SHIP                  | 312137089-12  | 09/08/1946  |   AARP      |
      | 10008 | TERMINATEDWithNODUE   | 000087616-01  | 11/12/1937    |   UHC       |
      | 10009 | GroupWithSubsidy      | 925610646-1   | 04/18/1946    |   RETIREE   |
      | 10011 | PreffectiveWithNoDue  | 977757984-1  | 12/14/1955   |   RETIREE   |

### to review
  @prod_guestPayment04 @prod_C&SplanBLOCKED @M&RBlocked
  Scenario Outline: TID: <TID> - To validate the Guest Payment page for Blocked Members with No sign in Link
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click on the Next Button and navigate to an Error page
    And I will be instructed to call the number on the back of my ID
    And I will not see the sign in link to the authenticated M&R member site

    Examples:
      | TID   | planType              | memberID      | dob           | siteName    |
     # | 10010 | PremiumPayedToBank    | 952802197-1   | 07/22/1943    |   RETIREE   |
     # | 10011 | C&SBlocked            |112532945      | 02/17/1941    |   RETIREE   |
     # | 10012 | M&RBlocked            |936841418-1    | 08/31/1930   |   RETIREE    |no such member available

  @prod_guestPayment05 @prod_selectPaymentAmountValidations
  Scenario Outline: TID: <TID> - To validate the One time payments page with different member types
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate payment Amount fields for different member types
      | pastDue         | <hasPD> |
      | currentCharges  |  <hasCC>   |

    Examples:
      | TID   | memberType       | memberID    | dob        | hasPD  | hasCC  |siteName   |
    # | 10000 | memberWithPD     |              |            | true   | false   | AARP      |
      | 10000 | memberWithoutPD   | 920736343-1 |  12/27/1953| false  | true   | UHC       |
      | 10000 | memberWithNoDues  | 904498840-1 | 06/03/1933 | false  | false  | RETIREE   |
    #  | 10000 | memberWithBOTHDues| 966369983-1  | 09/20/1940 | true | true  | RETIREE   |

  @prod_guestPayment06 @prod_ErrorsAndContentOneTimePayment @prod_otherAmountErrorAndContent
  Scenario Outline: TID: <TID> - To validate the One time payment page with different error scenarios
  
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    Then I will entered other amount Due
      | Other Amount | 0.50 |
    And I will get an error message Amount must exceed 1.00
    Then I will entered other amount Due
      | Other Amount | 1.00 |
    And I will get an error message Cannot exceed annual remaining amount
    #Then I select and entered other amount Due and choose a EFT Checking acc payment Method
     # | Other Amount | <otherAmountDue> |
    #Then I will click on Review and Submit button leaving EFT Account information blank
    #And I will get an error to enter valid Account EFT information
  
    Examples:
      | TID   | planType | memberID    | dob        | siteName | otherAmountDue |
      | 10000 | MAPD     | 920736343-1 | 12/27/1953 | AARP     | 1.50         |
    

  @prod_guestPayment07 @prod_makeOneTimePayment @prod_pastAmount @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then  I select current charges Due and choose a Credit Debit payment Method
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    #When I click on Confirm and Pay
    #And I navigate to Payment confirmation page and validate all the page elements
    #Then I will click on Print on Confirm Payment page to print my Payment Receipt
    #Then I entered my Email address and click send button to send receipt on my Email
     # | Email             | <Email>             |
    #And I validate success Email receipt message and click send to another Email
    #Then I will click on Sign in and Register Now link to navigate to Member Portal

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name                 | CreditCardNumber | validMonth | validYear | Email          |
      | 10000 | MAPD     |  007311322-1  | 08/11/1949 | AARP     | GuestPayCC        | 4121600170691201 |         01 |      2021    | test@optum.com |


  @prod_guestPayment08 @prod_makeOneTimePayment @prod_pastAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then  I select current charges Due and choose a EFT Checking acc payment Method
    Then I will enter EFT Checking Account Details
      | AccountHoldersFirstName  | <FirstName>  |
      | AccountHoldersMiddleName | <MiddleName> |
      | AccountHoldersLastName   | <LastName>   |
      | AccountNumber            | <accountNo>  |
      | RoutingNumber            | <routingNo>  |
    Then I validate header and and page elements on Review & Submit page
    #When I click on Confirm and Pay
    #And I navigate to Payment confirmation page and validate all the page elements
    #Then I entered my Email address and click send button to send receipt on my Email
     # | Email             | <Email>             |
    #And I validate success Email receipt message and click send to another Email
   # Then I will click on Sign in and Register Now link to navigate to Member Portal

    Examples:
      | TID   | planType | memberID      | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo | Email          |
      | 10000 | MAPD     |  007311322-1  | 08/11/1949 | AARP     | Guest     | A          | Payments1 | 1234512345 | 123123123 | test@optum.com |



  @prod_guestPayment09 @prod_makeOneTimePayment @prod_otherAmount @prod_ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    Then I select and enter other amount Due and choose a Credit Debit payment Method
      | Other Amount | <otherAmountDue> |
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    #When I click on Confirm and Pay
    #And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |Name                 | CreditCardNumber | validMonth | validYear |otherAmountDue    |
      | 10000 | MAPD     | 007311322-1   | 08/11/1949   |   AARP      |CreditCardAutomation | 4121600170691201 |         01 |      2021 |  10.05           |


  @prod_guestPayment10 @prod_makeOneTimePayment @prod_otherAmount @prod_eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    Then I select and entered other amount Due and choose a EFT Checking acc payment Method
      | Other Amount | <otherAmountDue> |
    Then I will enter EFT Checking Account Details
      | AccountHoldersFirstName  | <FirstName>  |
      | AccountHoldersMiddleName | <MiddleName> |
      | AccountHoldersLastName   | <LastName>   |
      | AccountNumber            | <accountNo>  |
      | RoutingNumber            | <routingNo>  |
    Then I validate header and and page elements on Review & Submit page
    #When I click on Confirm and Pay
    #And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo | otherAmountDue |
      | 10002    | PDP      |972288002-1 | 07/07/1954 | RETIREE  | Guest     | C          | Payments3 | 1234512345 | 123123123 | 20.30         |

  @prod_guestPayment11 @prod_makeOneTimePayment @prod_changePaymentDetails
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    Then I select and entered other amount Due and choose a EFT Checking acc payment Method
      | Other Amount | <otherAmountDue> |
    Then I will enter EFT Checking Account Details
      | AccountHoldersFirstName  | <FirstName>  |
      | AccountHoldersMiddleName | <MiddleName> |
      | AccountHoldersLastName   | <LastName>   |
      | AccountNumber            | <accountNo>  |
      | RoutingNumber            | <routingNo>  |
    Then I validate header and and page elements on Review & Submit page
    Then I click on Change Payment Details link
    Then I select Credit Debit payment Method
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    #When I click on Confirm and Pay
    #And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo | otherAmountDue | Name                 | CreditCardNumber | validMonth | validYear |
      | 10000 | MAPD     | 944419140-1 | 07/13/1941 | AARP     | Guest     | A          | Payments1 | 1234512345 | 123123123 | 10.05          | CreditCardAutomation | 4121600170691201 | 01        | 2021     |