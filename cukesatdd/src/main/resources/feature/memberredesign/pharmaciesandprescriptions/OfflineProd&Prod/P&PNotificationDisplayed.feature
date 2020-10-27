Feature: P&P Notification is Displayed
  To validate P&P Notification is displayed Successfully.

  @Sanity @Regression
  Scenario Outline: To verify P&P Notification is displayed successfully
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member   |
      | Berniewb |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated
    Then user must see that message at the top of the PnP page
