Feature: MedCab Load On P&P Page
  To validate MedCab Load On P&P Page

  @Sanity @Regression
  Scenario Outline: To verify MedCab Load On P&P Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member   |
      | Berniewb |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user view MedCab load successfully on PnP page
    Then user validates the disclaimer Medication appearance subject to change
    And user validates first six of his active prescriptions
