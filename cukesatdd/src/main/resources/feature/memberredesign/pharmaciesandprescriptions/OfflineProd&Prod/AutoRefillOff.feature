Feature: Auto Refill Off
  To validate Auto Refill Off

  @Regression
  Scenario Outline: To verify Auto Refill checkbox is unchecked
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
    Then user will view Auto Refill off displaying unchecked box
    When user select the auto refill checkbox
    Then user will view auto refill enrollment page asking for enroll auto refill
    When user select Cancel
    Then user will see "Complete Your Refill" Page
