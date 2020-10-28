Feature: P&P Notification is Displayed
  To validate P&P Notification is displayed Successfully.

  @Sanity @Regression
  Scenario Outline: To verify P&P Notification is displayed successfully
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated
    Then user must see that message at the top of the PnP page

    Examples: 
      | username | password | memUserName |
      | kjadha10 | Free@123 | Berniewb    |
