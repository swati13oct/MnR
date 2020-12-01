@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  #Test Case 12 - Active SHIP member with terminated and active plan in same year with billing and payment history in last 90 days
  @regressionMemberPROD
  Scenario Outline: <planType> -memberType: <memberType> - Test Case 11 -Verify billing and payment history for Active SHIP member with billing and payment history in last 90 days
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
