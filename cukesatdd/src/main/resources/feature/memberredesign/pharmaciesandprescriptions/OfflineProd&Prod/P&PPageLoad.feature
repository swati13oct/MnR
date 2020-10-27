Feature: P&P Page is Loaded
  To validate P&P Page Loaded Successfully.

  @Sanity @Regression
  Scenario Outline: To verify Pharmacy and Prescription Page load successfully
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member   |
      | Berniewb |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
