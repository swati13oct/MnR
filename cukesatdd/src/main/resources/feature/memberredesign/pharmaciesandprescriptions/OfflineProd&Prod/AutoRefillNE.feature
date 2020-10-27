Feature: Auto Refill NE
  To validate Auto Refill NE

  @Regression
  Scenario Outline: To verify Auto refill filled not displayed
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member |
      |        |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will not view the Auto Refill display
