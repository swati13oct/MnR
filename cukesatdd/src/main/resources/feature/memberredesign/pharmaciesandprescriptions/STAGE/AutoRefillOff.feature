Feature: Auto Refill Off
  To validate Auto Refill Off

  @STAGERegression
  Scenario Outline: To verify Auto Refill checkbox is unchecked
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    Then user will view Auto Refill off displaying unchecked box
    When user select the auto refill checkbox
    Then user will view auto refill enrollment page asking for enroll auto refill
    When user select Cancel
    Then user will see "Complete Your Refill" Page

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_AutoRefillOff |
