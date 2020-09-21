@guestPayment
Feature: 1.06.7 Member Guest Payments Page

#Footer steps are being commented right now, need to enable them later
 @guestPayment01 @validateUrlForDifferentBrands
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands
    Given I am on the login screen of Guest Payments Portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    When I click on link Help me find my id link
    Then I click on the sign in link and navigate to Member Portal sign in page
    Then I will see the Logo specific to my plan and the Sign in button
            | Site Name | <siteName> |

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |
      | 10000 | MAPD     | 915516555-1   | 10/29/1947    |   AARP      |
      #| 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |
      #| 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |
     # | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |
     # | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |



  @guestPayment02 @ErrorsAndContent
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


  @guestPayment03 @Blockeduser  @Terminated @100%Subsidy @PremiumtoaBank
  Scenario Outline: TID: <TID> - To validate the Guest Payment page for blocked Members
    Given I am on the login screen of Guest Payments Portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
       | Member ID         | <memberID> |
       | Date of Birth     |  <dob>     |
    And  I will click on the Next Button and navigate to an Error page
    And  I will be instructed to call the number on the back of my ID
    #Then I click on the sign in link and navigate to Member Portal sign in page
    #Then I will see the Logo specific to my plan and the Sign in button

    Examples:
      | TID   | planType              | memberID      | dob           | siteName    |
     #| 10007 | SHIP                  | 361857096-11  | 05/01/1954    |   AARP      |
      | 10008 | TERMINATEDWithNODUE   | 958542476-1   | 03/28/1941    |   UHC       |
      | 10009 | GroupWithSubsidy      | 925610646-1   | 04/27/1946    |   RETIREE   |
      | 10010 | PremiumPayedToBank    | 952802197-1   | 07/22/1943    |   RETIREE   |
      | 10011 | PreffectiveWithNoDue  | 020713181-1   | 09/06/1946    |   RETIREE   |


  @guestPayment04 @C&SplanBLOCKED @M&RBlocked 
  Scenario Outline: TID: <TID> - To validate the Guest Payment page for Blocked Members with No sign in Link
      Given I am on the login screen of Guest Payments Portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
       | Member ID         | <memberID> |
       | Date of Birth     |  <dob>     |
    And I will click on the Next Button and navigate to an Error page
    And I will be instructed to call the number on the back of my ID
   # And I will not see the sign in link to the authenticated M&R member site

    Examples:
      | TID   | planType              | memberID      | dob           | siteName    |
      | 10011 | C&SBlocked            |112532945      | 02/17/1941    |   RETIREE   |
      | 10012 | M&RBlocked            |936841418-1    | 08/31/1930   |   RETIREE    |

 @guestPayment05 @selectPaymentAmountValidations
  Scenario Outline: TID: <TID> - To validate the One time payments page with different member types
    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
   # Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate payment Amount fields for different member types
       | pastDue         | <hasPD> |
       | currentCharges  |  <hasCC>   |
       
    Examples:
      | TID   | memberType       | memberID    | dob        | hasPD  | hasCC  |siteName   |
      | 10000 | memberWithPD     | 978196889-1 | 10/19/1941 | true   | false   | AARP      |
   #  | 10000 | memberWithoutPD  | 915516555-1 | 10/29/1947 | false  | true   | UHC       |
      | 10000 | memberWithNoDues | 904498840-1 | 06/19/1933 | false  | false  | RETIREE   |
    # | 10000 | memberWithBOTHDues | 904498840-1 | 06/19/1933 | true | true  | RETIREE   |

  @guestPayment06 @ErrorsAndContentOneTimePayment @otherAmountErrorAndContent
  Scenario Outline: TID: <TID> - To validate the One time payment page with different error scenarios

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
   # And I validate all the header and page elements on One-time payment page
    Then I will entered other amount Due
    #incorrect Amount
      | Other Amount | 2500 |
    And I will get an error message Cannot exceed annual remaining amount
    Then I will entered other amount Due
    #incorrect Amount
      | Other Amount | 0.50 |
    And I will get an error message Amount must exceed 1.00

    Examples:
      | TID   | planType | memberID    | dob        | siteName |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     |

  @guestPayment07 @makeOneTimePayment @pastAmount @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
   # And I validate all the header and page elements on One-time payment page
    Then I select Past Amount Due and choose a Credit Debit payment Method
    Then I will enter Credit card Details
      | Name             | <Name>             |
      | CreditCardNumber | <CreditCardNumber> |
      | Month            | <validMonth>       |
      | Year             | <validYear>        |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements
    #Then I will click on Print on Confirm Payment page to print my Payment Receipt
    Then I entered my Email address and click send button to send receipt on my Email
      | Email             | <Email>             |
    And I validate success Email receipt message and click send to another Email
    Then I will click on Sign in and Register Now link to navigate to Member Portal

    Examples:
      | TID   | planType | memberID    | dob        | siteName | Name                 | CreditCardNumber | validMonth | validYear | Email          |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | GuestPayCC           | 4111111111111111 | 04         | 2024      | test@optum.com |
     # | 10001 | PDP      | 915516555-1 | 10/29/1947 | UHC      | GuestPayCC           | 4111111111111111 | 04         | 2024      | test@optum.com |
      #| 10002 | MA       | 915516555-1 | 10/29/1947 | RETIREE  | GuestPayCC           | 4111111111111111 | 04         | 2024      | test@optum.com |
     # | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | GuestPayCC           | 4111111111111111 | 04         | 2024      | test@optum.com |
      #| 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | GuestPayCC           | 4111111111111111 | 04         | 2024      | test@optum.com |

  @guestPayment08 @makeOneTimePayment @pastAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    #And I validate all the header and page elements on One-time payment page
    Then I select Past Amount Due and choose a EFT Checking acc payment Method
    Then I will enter EFT Checking Account Details
      | AccountHoldersFirstName  | <FirstName>  |
      | AccountHoldersMiddleName | <MiddleName> |
      | AccountHoldersLastName   | <LastName>   |
      | AccountNumber            | <accountNo>  |
      | RoutingNumber            | <routingNo>  |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements
    Then I entered my Email address and click send button to send receipt on my Email
      | Email             | <Email>             |
    And I validate success Email receipt message and click send to another Email
    Then I will click on Sign in and Register Now link to navigate to Member Portal

    Examples:
      | TID   | planType | memberID    | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo | Email          |
      | 10000 | MAPD     | 979160486-1 | 03/16/1989 | AARP     | Guest     | A          | Payments1 | 1234512345 | 123123123 | test@optum.com |
      | 10001 | PDP      | 016647204-1 | 06/12/1950 | AARP     | Guest     | B          | Payments2 | 1234512345 | 123123123 | test@optum.com |
      | 10002 | PDP      | 980958988-1 | 04/08/1933 | RETIREE  | Guest     | C          | Payments3 | 1234512345 | 123123123 | test@optum.com |
      | 10003 | MAPD     | 978196889   | 10/19/1941 | PCP      | Guest     | D          | Payments4 | 1234512345 | 123123123 | test@optum.com |
      | 10004 | MAPD     | 911808274   | 09/06/1945 | MEDICA   | Guest     | E          | Payments5 | 1234512345 | 123123123 | test@optum.com |


  @guestPayment09 @makeOneTimePayment @pastAmount&currentCharges @ccFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
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
       | 10000 | MAPD     | 954458415-1   | 09/26/1941    |   AARP      |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
     # | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
     # | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
     # | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |
     # | 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |CreditCardAutomation | 4111111111111111 |         04 |      2024 |


  @guestPayment10 @makeOneTimePayment @pastAmount&currentCharges @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select Past Amount & current charges Due and choose a EFT Checking acc payment Method
    Then I will enter EFT Checking Account Details
      | AccountHoldersFirstName  | <FirstName>  |
      | AccountHoldersMiddleName | <MiddleName> |
      | AccountHoldersLastName   | <LastName>   |
      | AccountNumber            | <accountNo>  |
      | RoutingNumber            | <routingNo>  |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo |
      | 10000 | MAPD     | 979160486-1 | 03/16/1989 | AARP     | Guest     | A          | Payments1 | 1234512345 | 123123123 |
      | 10001 | PDP      | 016647204-1 | 06/12/1950 | AARP     | Guest     | B          | Payments2 | 1234512345 | 123123123 |
      | 10002 | PDP      | 980958988-1 | 04/08/1933 | RETIREE  | Guest     | C          | Payments3 | 1234512345 | 123123123 |
      | 10003 | MAPD     | 978196889   | 10/19/1941 | PCP      | Guest     | D          | Payments4 | 1234512345 | 123123123 |
      | 10004 | MAPD     | 911808274   | 09/06/1945 | MEDICA   | Guest     | E          | Payments5 | 1234512345 | 123123123 |

  @guestPayment11 @makeOneTimePayment @otherAmount @ccFLow
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
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID      | dob           | siteName    |Name                 | CreditCardNumber | validMonth | validYear |otherAmountDue    |
      | 10000 | MAPD     | 978196889-1   | 10/19/1941    |   AARP      |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  10.05           |
     # | 10001 | MAPD     | 915516555-1   | 10/29/1947    |   UHC       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  15.20           |
     # | 10002 | MAPD     | 915516555-1   | 10/29/1947    |   RETIREE   |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  20.30           |
    #  | 10003 | MAPD     | 915516555-1   | 10/29/1947    |   PCP       |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  11.000          |
      #| 10004 | MAPD     | 915516555-1   | 10/29/1947    |   MEDICA    |CreditCardAutomation | 4111111111111111 |         04 |      2024 |  333.00          |


  @guestPayment12 @makeOneTimePayment @otherAmount @eftCheckingFLow
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
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
      | AccountHoldersFirstName  | <FirstName>  |
      | AccountHoldersMiddleName | <MiddleName> |
      | AccountHoldersLastName   | <LastName>   |
      | AccountNumber            | <accountNo>  |
      | RoutingNumber            | <routingNo>  |
    Then I validate header and and page elements on Review & Submit page
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo | otherAmountDue |
      | 10000 | MAPD     | 979160486-1 | 03/16/1989 | AARP     | Guest     | A          | Payments1 | 1234512345 | 123123123 | 10.05          |
      | 10001 | PDP      | 016647204-1 | 06/12/1950 | AARP     | Guest     | B          | Payments2 | 1234512345 | 123123123 | 15.20          |
      | 10002 | PDP      | 980958988-1 | 04/08/1933 | RETIREE  | Guest     | C          | Payments3 | 1234512345 | 123123123 | 20.30          |
      | 10003 | MAPD     | 978196889   | 10/19/1941 | PCP      | Guest     | D          | Payments4 | 1234512345 | 123123123 | 11.000         |
      | 10004 | MAPD     | 911808274   | 09/06/1945 | MEDICA   | Guest     | E          | Payments5 | 1234512345 | 123123123 | 333.00         |
      
      
  @guestPayment13 @makeOneTimePayment @changePaymentDetails
  Scenario Outline: TID: <TID> - To validate the Guest Payment home page with different brands

    Given I am on the login screen of Guest Payments Portal
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
    When I click on Confirm and Pay
    And I navigate to Payment confirmation page and validate all the page elements

    Examples:
      | TID   | planType | memberID    | dob        | siteName | FirstName | MiddleName | LastName  | accountNo  | routingNo | otherAmountDue | Name                 | CreditCardNumber | validMonth | validYear |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | Guest     | A          | Payments1 | 1234512345 | 123123123 | 10.05          | CreditCardAutomation | 4111111111111111 | 04         | 2024      |
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | Guest     | B          | Payments2 | 1234512345 | 123123123 | 15.20          | CreditCardAutomation | 4111111111111111 | 04         | 2024      |
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | Guest     | C          | Payments3 | 1234512345 | 123123123 | 20.30          | CreditCardAutomation | 4111111111111111 | 04         | 2024      |
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | Guest     | D          | Payments4 | 1234512345 | 123123123 | 11.000         | CreditCardAutomation | 4111111111111111 | 04         | 2024      |
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | Guest     | E          | Payments5 | 1234512345 | 123123123 | 333.00         | CreditCardAutomation | 4111111111111111 | 04         | 2024      |



  @guestPayment14 @ErrorsAndContentOneTimePayment @eftErrorAndContent
  Scenario Outline: TID: <TID> - To validate the One time payment page with different error scenarios

    Given I am on the login screen of Guest Payments Portal
      | Site Name | <siteName> |
    Then I validate all the header and page elements
    Then I will enter my Member ID and Date of birth
      | Member ID         | <memberID> |
      | Date of Birth     |  <dob>     |
    And I will click Next to proceed to the Make a One-time payment page
    And I validate all the header and page elements on One-time payment page
    Then I select and entered other amount Due and choose a EFT Checking acc payment Method
      | Other Amount | <otherAmountDue> |
    Then I will click on Review and Submit button leaving EFT Account information blank
    And I will get an error valid Account EFT information
    Then I will enter EFT Checking Account Details
      | AccountHoldersName | <Name>      |
      | AccountNumber      | <accountNo> |
      | RoutingNumber      | <routingNo> |
    And I will get an error valid Account EFT information

    Examples:
      | TID   | planType | memberID    | dob        | siteName | otherAmountDue |
      | 10000 | MAPD     | 915516555-1 | 10/29/1947 | AARP     | 10.05          |
      | 10001 | MAPD     | 915516555-1 | 10/29/1947 | UHC      | 15.20          |
      | 10002 | MAPD     | 915516555-1 | 10/29/1947 | RETIREE  | 20.30          |
      | 10003 | MAPD     | 915516555-1 | 10/29/1947 | PCP      | 11.00        |
      | 10004 | MAPD     | 915516555-1 | 10/29/1947 | MEDICA   | 333.00         |