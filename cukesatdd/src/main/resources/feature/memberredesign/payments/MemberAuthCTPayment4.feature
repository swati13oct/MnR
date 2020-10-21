@regressionMemberPROD
Feature: S1.1 To test Member Auth premium payment flows Micro App.

  @regressionMemberPROD
  Scenario Outline: TID: <TID> -  Test Case 10 -Verify billing and payment history for Active Federal and Active Group member with billing and payment history in last 90 days
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
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table

    Examples: 
      | UID     | username | password | memUserName         | planType | memberType | copayCategory      |         |
      | F243897 | jkuma14  | Brock@03 | TELGUY1@HOTMAIL.COM | IndMA    | GroupMAPD  | ACTIVEGroupPayment | NON LIS |

  #Test Case 24 - Active member Fed and  Active Group Member with billing and payment history in last 90 days
  @regressionMember
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Test Case 24 -Verify billing and payment history for Active Federal and Active Group member with billing and payment history in last 90 days
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user clicks on Premium Payments on Header
    Then User Scrolls down to the Billing history Section
    Then user validates billing history section header exists
    Then Last 90 days is selected by default in the Billing History dropdown
    Then user validates data is present in billing history table
    Then user selects Last 6 months in the Billing History dropdown
    Then user validates data is present in billing history table
    Then user selects Last 12 months in the Billing History dropdown
    Then user validates data is present in billing history table
    Then user selects Last 24 months in the Billing History dropdown
    Then user validates data is present in billing history table
    Then User Scrolls down to the Payment history Section
    Then user validates Payment history section header exists
    Then Last 90 days is selected by default in the Payment History dropdown
    Then user validates data is present in Payment history table
    Then user selects Last 6 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    Then user selects Last 12 months in the Payment History dropdown
    Then user validates data is present in Payment history table
    Then user selects Last 24 months in the Payment History dropdown
    Then user validates data is present in Payment history table

    Examples: 
      | planType  | memberType         | copayCategory |
      | IndMA     | ACTIVEIndPayment   | NON LIS       |
      | GroupMAPD | ACTIVEGroupPayment | NON LIS       |