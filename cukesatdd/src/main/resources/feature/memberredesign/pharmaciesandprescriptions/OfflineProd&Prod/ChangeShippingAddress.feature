Feature: Change Shipping Address
  To validate Change Shipping Address
  @Regression
  Scenario Outline: To verify Change Shipping Address
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member |
      | 9ac57f09-f46f-4989-99af-53f86c089e07 |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page