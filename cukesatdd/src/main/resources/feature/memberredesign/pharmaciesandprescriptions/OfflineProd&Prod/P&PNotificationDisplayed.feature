Feature: P&P Notification is deactivated
  To validate P&P Notification is deactivated.

  @Sanity @Regression
  Scenario Outline: To verify P&P Notification is deactivated
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    When a PnP notification is deactivated

    Examples: 
      | username | password | memUserName | planType | memberType |
      | kjadha10 | Virus$$1 | Berniewb    | PDP      | Individual |
