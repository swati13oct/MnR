@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  #Test Case 12 - Active SHIP member with terminated and active plan in same year with billing and payment history in last 90 days
  @regressionMemberPROD
  Scenario Outline: <planType> -memberType: <memberType> - Test Case 12 -Verify billing and payment history for Active SHIP member with billing and payment history in last 90 days
    Given First check if feature security flag is set to true
      | Feature | UCPPayments |
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
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
      | UID     | username | password | memUserName | planType | memberType | copayCategory     |         |
      | F243897 | jkuma14  | Brock@04 | dmarmet     | SHIP     | SHIP       | ACTIVESHIPPayment | NON LIS |

  #Test Case 13 - Federal member - One time CC - User can select to Save Credit Card on File on Review Page
  @regressionMemberPROD
  Scenario Outline: TID: <memberType> - Test Case 13 - Verify MakeOne time Payment flow for Credit card Other amount , saving card option on review page
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
    Then for saving card user navigates to payment overview screen and selects agreements and save card checkbox on Prod

    Examples: 
      | UID     | username | password | memUserName    | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | jkuma14  | Brock@04 | LMHOCHSCHILD11 | MAPD     | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |

  #Test Case 14 - Federal member - One time CC - Validate existing Saved Card Details on one time payment page and navigate to one time payment review page with an existing Saved Card
  @regressionMemberPROD
  Scenario Outline: TID: <memberType> - Test Case 14 - Verify existing Saved Card Details on one time payment page and navigate to one time payment review page with an existing Saved Card
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects SAVED credit card and click on Next button
    Then user navigates to payment overview screen for SAVED Card and selects agreements for Prod

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      | Name         | CreditCardNumber | validMonth | validYear | paymentType |
      | F243897 | jkuma14  | Brock@04 | KarenBloch  | MAPD     | Last 24 months | Last 18 months | Pooja Minhas | 4121600170691201 |         01 |      2021 | OneTime     |
